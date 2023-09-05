// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.Commands;
import frc.robot.Subsystems.Drive;

import java.util.function.DoubleSupplier;

import edu.wpi.first.wpilibj2.command.CommandBase;

public class arcadeDriveCmd extends CommandBase {
  private DoubleSupplier speed;
  private DoubleSupplier rotation;
  private final Drive kDrive;
  /** Creates a new arcadeDriveCmd. */
  public arcadeDriveCmd(DoubleSupplier speed, DoubleSupplier rotation, Drive kDrive) 
  {
    this.speed = speed;
    this.rotation = rotation;
    this.kDrive = kDrive;
    addRequirements(kDrive);
    // Use addRequirements() here to declare subsystem dependencies.
  }


  // Called when the command is initially scheduled.
  @Override
  public void initialize() {}

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() 
  {
    double deadX = speed.getAsDouble();
    double deadY = rotation.getAsDouble();
    
    if(Math.abs(deadX) <= 0.1) deadX = 0;
    if(Math.abs(deadY) <= 0.1) deadY = 0.0;

    kDrive.defaultDrive(deadX, deadY);
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {}

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}