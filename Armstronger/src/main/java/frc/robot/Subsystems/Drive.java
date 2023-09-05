// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.Subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.motorcontrol.MotorControllerGroup;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Drive extends SubsystemBase {
  private final CANSparkMax frontLeft;
  private final CANSparkMax frontRight;
  private final CANSparkMax backLeft;
  private final CANSparkMax backRight;
  private final MotorControllerGroup rightDrive;
  private final MotorControllerGroup leftDrive;
  private final DifferentialDrive mDrive;
  /** Creates a new Drive. */
  public Drive() 
  {
    frontLeft = new CANSparkMax(0, MotorType.kBrushless);
    frontRight = new CANSparkMax(0, MotorType.kBrushless);
    backLeft = new CANSparkMax(0, MotorType.kBrushless);
    backRight = new CANSparkMax(0, MotorType.kBrushless);

    rightDrive = new MotorControllerGroup(frontRight, backRight);
    leftDrive = new MotorControllerGroup(frontLeft, backLeft);

    leftDrive.setInverted(true);
    mDrive = new DifferentialDrive(rightDrive, leftDrive);
  }

  public void defaultDrive(double speed, double rotation) 
  {
    mDrive.arcadeDrive(speed, rotation);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}