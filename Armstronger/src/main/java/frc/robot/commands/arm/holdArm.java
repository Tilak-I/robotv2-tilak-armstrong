// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands.arm;

import edu.wpi.first.math.controller.ArmFeedforward;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.ArmSystem;

public class holdArm extends CommandBase {
  private ArmFeedforward ArmFF;
  private ArmSystem ArmyLarmy;
  private double kS;
  private double kG;
  private double kV;
  private double kA;


  /** Creates a new holdArm. */
  public holdArm() {

    addRequirements(ArmyLarmy);
    // Use addRequirements() here to declare subsystem dependencies.
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() 
  {
    kS = 0;
    kG = 0;
    kV = 0;
    kA = 0;
    
    ArmFF = new ArmFeedforward(kS, kG, kV, kA);
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() 
  
  {
  if(true){
      double calc = ArmFF.calculate(
        Math.toRadians(ArmyLarmy.getBicepEncoderPosition() - 33.43),
        Math.toRadians(ArmyLarmy.neoVelocity()) / 12
      );} 
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
