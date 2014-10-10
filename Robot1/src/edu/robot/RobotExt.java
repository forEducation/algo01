package edu.robot;


import edu.robot.Robot;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Flow
 */
public class RobotExt extends Robot
{

    public RobotExt(double x, double y, double course) {
        super(x, y);
        this.course = course;
    }
 
    public void back(int distance) {
        forward(-distance);
    }
}
