package com.fdmgroup;

import java.util.ArrayList;
import java.util.List;

public class ElevatorManager {
	static List <Elevator> elevators;
	public static void createElevators(int number, int minFloor, int maxFloor) {
		Elevator.setMinFloor(minFloor);
		Elevator.setMaxFloor(maxFloor);
		elevators = new ArrayList<>();
		for(int i=1; i<=number;i++) {
			Elevator elevator = new Elevator(i);
			elevators.add(elevator);
		}	
	}
	
	
	public static void assigningElevator(int startFloor, int endFloor) {
		int tempLift=0;
		int closestDistance=Elevator.getMaxFloor()-Elevator.getMinFloor()+1;
		int leastStack=100;
		int largestStack=0;
		//check if the queue of the lifts are the same or not
		for(int i=0; i<elevators.size();i++) {
			if(elevators.get(i).getStack()>largestStack)
				largestStack=elevators.get(i).getStack();
		}
		//The Lift with least users queuing will be assigned but in case if there is the same length in queues
		//with short queues, the closest lift will be assigned.
		if(largestStack<=1){
			for(int i=0; i<elevators.size();i++) {
				if(elevators.get(i).getStack()<=leastStack) {
					leastStack=elevators.get(i).getStack();
					tempLift = i;
					//play safe
				}
			}
			for(int i=0; i<elevators.size();i++) {
				if(elevators.get(i).getStack()==leastStack && elevators.get(i).getDistance(startFloor)<closestDistance) {
					closestDistance = elevators.get(i).getDistance(startFloor);
					tempLift = i;
				}
			}
		}
		else {
			for(int i=0; i<elevators.size();i++) {
				if(elevators.get(i).getStack()<leastStack) {
					leastStack=elevators.get(i).getStack();
					tempLift = i;
				}
			}
		}
		elevators.get(tempLift).stackIncrement();
		
		RequestThread requestThread = new RequestThread(elevators.get(tempLift),startFloor, endFloor);
		Thread thread = new Thread(requestThread);
		//stack of waiting or using of the elevator+1
		thread.start();
	}

	
	public static List <Elevator> getElevators() {
		return elevators;
	}
	
}
