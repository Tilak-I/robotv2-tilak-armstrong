// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands.arm;
import frc.robot.subsystems.ArmSystem;
import edu.wpi.first.math.controller.ProfiledPIDController;
import edu.wpi.first.wpilibj2.command.CommandBase;
import edu.wpi.first.math.trajectory.TrapezoidProfile;

public class operatedArm extends CommandBase {
  private ArmSystem armSys;
  private ProfiledPIDController pid;

  private double kP;
  private double kI; 
  private double kD;
  /** Creates a new operatedArm. */
  public operatedArm() {
    addRequirements(armSys);

  }

  @Override
  public void initialize() 
  {
    kP = 0;
    kI = 0;
    kD = 0;

    pid = new ProfiledPIDController(kP, kI, kD, new TrapezoidProfile.Constraints(250,100));
    pid.setTolerance(2);
    }

  @Override
  public void execute() {}

  @Override
  public void end(boolean interrupted) {}

  @Override
  public boolean isFinished() {
    return false;
  }
}
