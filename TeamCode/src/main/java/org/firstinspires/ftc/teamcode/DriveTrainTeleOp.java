//package org.firstinspires.ftc.teamcode;
//
//import com.acmerobotics.roadrunner.geometry.Pose2d;
//import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
//import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
//import com.qualcomm.robotcore.hardware.DcMotor;
//import com.qualcomm.robotcore.hardware.HardwareMap;
//import com.qualcomm.robotcore.hardware.Servo;
//
//import org.firstinspires.ftc.teamcode.drive.SampleMecanumDrive;
//import org.firstinspires.ftc.teamcode.subsystems.Drivetrain;
//
//@TeleOp(group = "drive")
//public class DriveTrainTeleOp extends LinearOpMode {
//    @Override
//    public void runOpMode() throws InterruptedException {
//        DcMotor motorfrontleft = hardwareMap.get(DcMotor.class, "motorfrontleft");
//        DcMotor motorbackleft = hardwareMap.get(DcMotor.class, "motorbackleft");
//        DcMotor motorfrontright = hardwareMap.get(DcMotor.class, "motorfrontright");
//        DcMotor motorbackright = hardwareMap.get(DcMotor.class, "motorbackright");
//        Drivetrain drivetrain = new Drivetrain(motorfrontleft, motorbackleft, motorfrontright, motorbackright);
//        waitForStart();
//        while (!isStopRequested()) {
//            if (gamepad1.a) {
//                intake.intake();
//            }
//            if (gamepad1.b) {
//                intake.outtake();
//            }
//            if (gamepad1.x) {
//                intake.deploy();
//            }
//            if (gamepad1.y) {
//
//                intake.retract();
//            }
//        }
//
//
//    }
