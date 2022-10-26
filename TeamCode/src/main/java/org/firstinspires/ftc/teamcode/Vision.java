package org.firstinspires.ftc.teamcode;

import org.firstinspires.ftc.robotcore.external.Telemetry;
import org.opencv.core.Core;
import org.opencv.core.Point;
import org.opencv.core.Rect;
import org.opencv.core.Scalar;
import org.opencv.imgproc.Imgproc;
import org.openftc.easyopencv.OpenCvPipeline;
import org.opencv.core.Mat;

public class Vision extends OpenCvPipeline {
    private final Telemetry telemetry;
    private final Mat mat = new Mat();

    private Location location;
    public enum Location {
        LEFT,
        RIGHT,
        NOT_FOUND
    }

    public static final double PERCENT_COLOR_THRESHOLD = 0.4;

    private static final Rect LEFT_ROI = new Rect(
            new Point(60, 35),
            new Point(120, 75)
    );
    private static final Rect RIGHT_ROI = new Rect(
            new Point(140, 25),
            new Point(200, 75)
    );
    public Vision(final Telemetry telemetry) {
        this.telemetry = telemetry;
    }

    //@Override
    public Mat processFrame(final Mat inputMatrix) {
        final int rows = inputMatrix.rows();
        final int cols = inputMatrix.cols();

        final Rect HALF_RECT = new Rect(
                new Point(0, rows / 2d),
                new Point(cols, rows)
        );

        final Mat lowerHalfMatrix = inputMatrix.submat(HALF_RECT);
        final Mat lowerHalfHSV = new Mat();

        return null;
    }

    //@Override
    public Mat processFrameOld(final Mat inputMatrix) {
        Imgproc.cvtColor(inputMatrix, mat, Imgproc.COLOR_RGB2HSV);
        final Scalar lowHSV = new Scalar(23, 50, 70);
        final Scalar highHSV = new Scalar(32, 255, 255);

        Core.inRange(mat, lowHSV, highHSV, mat);

        final Mat left = mat.submat(LEFT_ROI);
        final Mat right = mat.submat(RIGHT_ROI);

        final double leftVal = Core.sumElems(left).val[0] / LEFT_ROI.area() / 255;
        final double rightVal = Core.sumElems(right).val[0] / RIGHT_ROI.area() / 255;

        left.release();
        right.release();

        telemetry.addData("Left raw value", (int)Core.sumElems(left).val[0]);
        telemetry.addData("Right raw value", (int)Core.sumElems(right).val[0]);
        telemetry.addData("Left percentage", Math.round(leftVal * 100) + "%");
        telemetry.addData("Right percentage", Math.round(rightVal * 100) + "%");

        final boolean stoneLeft = leftVal > PERCENT_COLOR_THRESHOLD;
        final boolean stoneRight = rightVal > PERCENT_COLOR_THRESHOLD;

        if (stoneLeft && stoneRight) {
            location = Location.NOT_FOUND;
            telemetry.addData("Game Element Location", "not found");
        }
        else if (stoneLeft) {
            location = Location.RIGHT;
            telemetry.addData("Game Element Location", "right");
        }
        else {
            location = Location.LEFT;
            telemetry.addData("Game Element Location", "left");
        }
        telemetry.update();

        Imgproc.cvtColor(mat, mat, Imgproc.COLOR_GRAY2RGB);

        final Scalar colorStone = new Scalar(255, 0, 0);
        final Scalar colorSkystone = new Scalar(0, 255, 0);

        Imgproc.rectangle(mat, LEFT_ROI, location == Location.LEFT ? colorSkystone : colorStone);
        Imgproc.rectangle(mat, RIGHT_ROI, location == Location.RIGHT ? colorSkystone : colorStone);

        return mat;
    }

    public Location getLocation() { return location; }
}
