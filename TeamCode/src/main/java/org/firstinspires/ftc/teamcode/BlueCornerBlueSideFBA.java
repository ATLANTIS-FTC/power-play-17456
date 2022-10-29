package org.firstinspires.ftc.teamcode;
import com.acmerobotics.roadrunner.geometry.Pose2d;
import com.acmerobotics.roadrunner.trajectory.Trajectory;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import org.firstinspires.ftc.teamcode.drive.SampleMecanumDrive;

public class BlueCornerBlueSideFBA extends LinearOpMode{
    @Override
    public void runOpMode() throws InterruptedException {
        SampleMecanumDrive drivetrain = null;
        Trajectory depotPath = drivetrain.trajectoryBuilder(new Pose2d(-36,63,-90),-90)
                .splineToLinearHeading(new Pose2d(-36,23,-90),-90)
                .splineToLinearHeading(new Pose2d(-58,12,-180),-180)
                .build();
        drivetrain.followTrajectory(depotPath);

    }
}
