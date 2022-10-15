package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;

import org.firstinspires.ftc.teamcode.turret;

import com.qualcomm.robotcore.eventloop.opmode.TeleOp;


public class turretTeleOp {





    @TeleOp(group = "turret")
    public class ExampleTeleOp extends LinearOpMode {
        @Override
        public void runOpMode() throws InterruptedException {
            DcMotor turretMotor = hardwareMap.get(DcMotor.class, "turretMotor");
            turret turret = new turret(turretMotor);
            waitForStart();
            while (!isStopRequested()) {


                if (gamepad1.b) {
                    turret.clockwise();
                }
                if (gamepad1.x) {
                    turret.counterClockwise();
                }
                if (gamepad1.y) {
                    turret.aline();
                }
            }
        }
    }

}
