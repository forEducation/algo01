package edu.robot;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Flow
 */
public class Robot 
{
    private String name;
 
    public Robot(String name) {
        this.name = name;
    }
 
    @Override
    public String toString() {
        return "name=" + name;
    }
    
 // Текущая координата X
    private double x = 0;
    // Текущая координата Y
    private double y = 0;
    // Текущий курс (в градусах)
    protected double course = 0;
 
    // Вот наш конструктор, который пока не очень полезен
     public Robot(double x, double y) {
        this.x = x;
        this.y = y;
    }
 
    // Передвижение на дистанцию distance
    public void forward(int distance) {
        // Обращение к полю объекта X
        x = x + distance * Math.cos(course / 180 * Math.PI);
        // Обращение к полю объекта Y
        y = y + distance * Math.sin(course / 180 * Math.PI);
    }
 
    // Печать координат робота
    public void printCoordinates() {
        System.out.println(x + "," + y);
    }
 
    public double getX() {
        return x;
    }
 
    public double getY() {
        return y;
    }
 
    public double getCourse() {
        return course;
    }
 
    public void setCourse(double course) {
        this.course = course;
    }
}
