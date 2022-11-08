package org.firstinspires.ftc.teamcode;

import org.firstinspires.ftc.robotcore.external.Telemetry;
import org.opencv.core.Core;
import org.opencv.core.Mat;
import org.opencv.core.Point;
import org.opencv.core.Rect;
import org.opencv.imgproc.Imgproc;
import org.openftc.easyopencv.OpenCvPipeline;
import org.opencv.core.Scalar;




public class ConeDetector extends OpenCvPipeline {
    private static final double PERCENT_COLOR_THRESHOLD = 0.4;
    Telemetry telemetry;
    Mat mat = new Mat();


    public ConeDetector(Telemetry t) {
        telemetry = t;
    }

    @Override
    public Mat processFrame(Mat inputMatrix) {
        final int rows = inputMatrix.rows();
        final int cols = inputMatrix.cols();

        final Rect HALF_RECT = new Rect(
                new Point(0, rows / 2d),
                new Point(cols, rows)
        );

        final Mat lowerHalfMatrix = inputMatrix.submat(HALF_RECT);

        return null;
    }

//@Override

    public Mat processFrameOld(final Mat inputMatrix) {
        Imgproc.cvtColor(inputMatrix, mat, Imgproc.COLOR_RGB2HSV);
        //pink signal sleeve
        final Scalar lowpinkHSV = new Scalar(23, 50, 70);
        final Scalar highpinkHSV = new Scalar(32, 255, 255);
j

        final double Val = Core.sumElems.val[0] / HALF_RECT.area() / 255;

        left.release();
        right.release();

        telemetry.addData("Left raw value", (int)Core.sumElems(left).val[0]);
        telemetry.addData("Right raw value", (int)Core.sumElems(right).val[0]);
        telemetry.addData("Left percentage", Math.round(leftVal * 100) + "%");
        telemetry.addData("Right percentage", Math.round(rightVal * 100) + "%");

        final boolean stoneLeft = leftVal > PERCENT_COLOR_THRESHOLD;
        final boolean stoneRight = rightVal > PERCENT_COLOR_THRESHOLD;

        Point location;
        Point Location;
        if (coneLeft && coneRight) {
            location = Location.NOT_FOUND;
            telemetry.addData("Game Element Location", "not found");
        }
        else if (coneLeft) {
            location = Location.x;
            telemetry.addData("Game Element Location", "right");
        }
        else {
        }

        location = Location.RIGHT;
            telemetry.addData("Game Element Location", "left");
        }
        telemetry.update();
        Imgproc.cvtColor(mat, mat, Imgproc.COLOR_GRAY2RGB);
        //Blue Team Cone
        final Scalar BlueCone = new Scalar(255, 0, 0);
        //Red Team Cone
        final Scalar RedCone = new Scalar(0, 255, 0);

}
