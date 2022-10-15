package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.hardware.DcMotor;

public class turret {
    private DcMotor turretMotor;
    private final double TURRET_CLOCK = 1;
    private final double TURRET_COUNTER = -1;
    private final double TURRET_ALIGN = 0;


    public turret(DcMotor turretMotor) {
        this.turretMotor = turretMotor;

        turretMotor.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE); // Stops turret motors fully


    }

    public void clockwise() {
        turretMotor.setPower(TURRET_CLOCK);       // Turret right position
    }

    public void aline() {
        turretMotor.setPower(TURRET_ALIGN);          // Turret left position
    }

    public void counterClockwise() {
        turretMotor.setPower(TURRET_COUNTER);        // Middle position/to re-aline

    }
    public void setTurretSpeed() {
        turretMotor.setPower(1); //Change speed later bases on drivetrain speed
    }

}



