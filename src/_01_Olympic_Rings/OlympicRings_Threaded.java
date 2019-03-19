package _01_Olympic_Rings;

import java.awt.Color;

import org.jointheleague.graphical.robot.Robot;

public class OlympicRings_Threaded {
	// Make A Program that uses Threads and robots to draw the Olympic rings. One robot should draw one ring simultaneously with the other 4 robots.
	public static void main(String[] args) {
		Robot[] robots = new Robot[5];
		for(int i = 0; i < robots.length; i++) {
			robots[i] = new Robot();
			robots[i].setSpeed(5);
		}
		
		Thread r1 = new Thread (()->drawCircle(Color.BLUE, robots[0], 100,100));
		Thread r2 = new Thread (()->drawCircle(Color.YELLOW, robots[1], 200,300));
		Thread r3 = new Thread (()->drawCircle(Color.BLACK, robots[2], 300,100));
		Thread r4 = new Thread (()->drawCircle(Color.GREEN, robots[3], 400,300));
		Thread r5 = new Thread (()->drawCircle(Color.RED, robots[4], 500,100));
		
		r1.start();
		r2.start();
		r3.start();
		r4.start();
		r5.start();
		
	}
	
	static void drawCircle(Color c, Robot rob, int x, int y) {
		rob.setX(x);
		rob.setY(y);
		rob.penDown();
		rob.setPenColor(c);
		for(int i=0; i < 360; i ++) {
			rob.move(2);
			rob.turn(1);
		}
		rob.penUp();
		rob.setX(500);
		rob.setY(500);
	}
}

