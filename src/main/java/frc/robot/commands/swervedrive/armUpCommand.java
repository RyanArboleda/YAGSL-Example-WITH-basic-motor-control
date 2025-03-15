// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands.swervedrive;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.RobotContainer;

/* You should consider using the more terse Command factories API instead https://docs.wpilib.org/en/stable/docs/software/commandbased/organizing-command-based.html#defining-commands */
public class armUpCommand extends Command {
  /** Creates a new armUpCommand. */
  public armUpCommand() {
    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(RobotContainer.mArmSubsystem);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {}

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {

    //This is going to make the arm Move Up (here you could subsitute with the setPower method if you want to change the power here)
    RobotContainer.mArmSubsystem.armUp();

  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {

    //You have to have this armStop method call here so that teh arm doesn't continue to move after you end the command
    //Essentially, you have to stop it after you tell it to move otherwise it will keep going indefintely (and break stuff fr)
    RobotContainer.mArmSubsystem.armStop();
    
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
