package org.firstinspires.ftc.teamcode;

import com.acmerobotics.roadrunner.geometry.Pose2d;
import com.acmerobotics.roadrunner.trajectory.Trajectory;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

import org.firstinspires.ftc.teamcode.drive.SampleMecanumDrive;

public class RedCornerRedSideFBA extends LinearOpMode {
    @Override
    public void runOpMode() throws InterruptedException {
        SampleMecanumDrive drivetrain = null;
        Trajectory depotPath = drivetrain.trajectoryBuilder(new Pose2d(-36, -63, -90), -90)
                .splineToLinearHeading(new Pose2d(-36, -26, -90), -90)
                .splineToLinearHeading(new Pose2d(-60, -12, -180), -180)
                .build();
        drivetrain.followTrajectory(depotPath);
    }
}
