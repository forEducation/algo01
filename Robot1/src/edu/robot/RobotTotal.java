/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.robot;

/**
 *
 * @author Flow
 */
public class RobotTotal extends Robot
{
    // Вводим поле дляхранения пройденной дистанции
    private double totalDistance = 0;
 
    // Конструктор тоже надо переопределить
    public RobotTotal(double x, double y) {
        super(x, y);
    }
 
    @Override
    public void forward(int distance) {
        // Вызов нашего метода у класса предка.
        // Нужно указать зарезервированное слово super
        super.forward(distance);
        totalDistance += distance;
    }
 
    public double getTotalDistance() {
        return totalDistance;
    }
}
