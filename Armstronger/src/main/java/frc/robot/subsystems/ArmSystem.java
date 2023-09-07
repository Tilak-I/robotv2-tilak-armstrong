// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj2.command.SubsystemBase
;
public class ArmSystem extends SubsystemBase {
  private final CANSparkMax mBicep;
  private final Encoder armEncoder;
  private boolean sniperMode;
  /** Creates a new ArmSystem. */
  public ArmSystem() 
  {
    mBicep = new CANSparkMax(4, MotorType.kBrushless);
    armEncoder = new Encoder(0, 1);
  }

  public void setSniperArm(double speed)
  {
    speed = 0.18; //(1*0.3) * 0.6, Basically just did it without constants will add constants later
    mBicep.set(speed);
  }
  public void setManualArm(double speed)
  {
    mBicep.set(speed);
  }
  
  public void speedToggle(boolean isSniper)
  {
    sniperMode = isSniper;
  }
  
  public void setMode(double speed)
  {
    if (sniperMode == true)
    {
      setSniperArm(1);
    }
    else if (sniperMode == false)
    {
      setManualArm(0.6);
    }
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
