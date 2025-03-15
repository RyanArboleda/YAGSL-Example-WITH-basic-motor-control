// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems.swervedrive;

import com.revrobotics.spark.SparkMax;
import com.revrobotics.spark.SparkBase.PersistMode;
import com.revrobotics.spark.SparkBase.ResetMode;
import com.revrobotics.spark.SparkLowLevel.MotorType;
import com.revrobotics.spark.config.SparkMaxConfig;
import com.revrobotics.spark.config.SparkBaseConfig.IdleMode;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class armSubsystem extends SubsystemBase {
  /** Creates a new armSubsystem. */
  SparkMax armMotor;
  public armSubsystem() {

    SparkMaxConfig armMotorConfig = new SparkMaxConfig();

    armMotorConfig.idleMode(IdleMode.kBrake).smartCurrentLimit(40).voltageCompensation(12);
    armMotorConfig.inverted(false);


    armMotor = new SparkMax(0, MotorType.kBrushed);
    
    armMotor.configure(armMotorConfig, ResetMode.kResetSafeParameters, PersistMode.kPersistParameters);

  }

  public void armSetPower(double power){
    armMotor.set(power);
  }

  public void armStop(){
    armMotor.set(0);
  }

  //These are optional but they can help make it more clear how what you write goes from the subsystem to the command
  //With these, you can set them to more than 0.5, it is just a placeholder value to see if positive moves the arm up
  //(If positive values don't move the arm up and you want them to then you can setInverted to true in the config)
  public void armUp(){
    armMotor.set(Constants.armMotorPower);
  }

  public void armDown(){
    armMotor.set(-Constants.armMotorPower);
  }


  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
