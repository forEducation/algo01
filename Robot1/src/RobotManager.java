
import edu.robot.Robot;
import edu.robot.RobotTotal;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Flow
 */
public class RobotManager 
{
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Robot robot = new RobotTotal(0, 0);
 
        robot.forward(20);
        robot.setCourse(90);
        robot.forward(20);
        robot.setCourse(90);
        robot.forward(50);
        System.out.println(robot.getClass().getName());
        // Напечатать координаты
        robot.printCoordinates();
        // Напечатать общую дистанцию уже не получится
        // компилятор выдает ошибку
        //System.out.println(robot.getTotalDistance());
    }
    
}
