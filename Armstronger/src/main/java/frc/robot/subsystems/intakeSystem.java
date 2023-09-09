// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class intakeSystem extends SubsystemBase {
  private final CANSparkMax intakeMotor; 
  private boolean isCube;
  /** Creates a new intakeSystem. */
  public intakeSystem() 
  {
    intakeMotor = new CANSparkMax(25, MotorType.kBrushless);
    isCube = true;
  }



  public void spintake() //spin + intake im so good at naming stuff 
  {
    if (isCube)
    {
      intakeMotor.set(0.5);
    }
    else {intakeMotor.set(1);}
  }

  public void spout() //spin + out im so good at naming stuff 
  {
    if (isCube)
    {
      intakeMotor.set(-0.5);
    }
    else {intakeMotor.set(-1);}
  }

  public void stopAll() 
  {
    intakeMotor.set(0);
  }
  
  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
