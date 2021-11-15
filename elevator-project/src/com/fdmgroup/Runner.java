package com.fdmgroup;

import java.util.regex.*;
import java.util.Arrays;
import java.util.Scanner;

public class Runner {
	
	public static void main (String args[]) {
		
		boolean running = true;
		Scanner scanner = new Scanner(System.in);

		System.out.println("Please input the number of lifts");
		String input1 = scanner.nextLine();
		int numOfLifts = Integer.parseInt(input1);


		System.out.println("Please input the number of floors");
		String input2 = scanner.nextLine();
		int numOfFloors = Integer.parseInt(input2);


		ElevatorManager.createElevators(numOfLifts, 0, numOfFloors);
		ElevatorFrameView efv= new ElevatorFrameView(numOfFloors, numOfLifts);
		
		

		System.out.println("Please input your current floor and the floor you would like to go in this format (currentfloor),(destinationfloor)");
		while(running) {	
			String input = scanner.nextLine();
			input = input.trim();
			String[] request = input.split(",");
			int startFloor = Integer.parseInt(request[0]);
			int destinationFloor = Integer.parseInt(request[1]);
			ElevatorManager.assigningElevator(startFloor, destinationFloor);
		}
	}
	

}
