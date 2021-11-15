package com.fdmgroup;

public class Elevator {
	
	private int currentFloor;
	private int elevatorId;
	private static int minFloor;
	private static int maxFloor;
	private int stack;
	private int destinationFloor;
	

	public Elevator(Integer i) {
		this.currentFloor = 0;
		this.elevatorId = i;
		this.destinationFloor=0;
		this.stack=0;
	}
	
	
	public int getDistance(int startFloor) {
		return Math.abs(destinationFloor - startFloor);
	}
	
	
	public synchronized void elevatorUpDown(int startFloor, int destination) throws InterruptedException {
		//elevator move to the client's floor
		destinationFloor = destination;
		if(startFloor < currentFloor)
			for(int i = currentFloor; i>=startFloor;i-- ) {
				currentFloor = i;
				Thread.sleep(500);
				}
		else if(startFloor > currentFloor)
			for(int i = currentFloor; i<=startFloor;i++ ) {
				currentFloor = i;
				Thread.sleep(500);
			}
		//elevator transporting the client
		if(destination < currentFloor)
			for(int i = currentFloor; i>=destination;i-- ) {
				currentFloor = i;
				Thread.sleep(500);
				}
		else if(destination > currentFloor)
			for(int i = currentFloor; i<=destination;i++ ) {
				currentFloor = i;
				Thread.sleep(500);
			}
		this.stackDecrement();
	}
	

	public int getCurrentFloor() {
		return currentFloor;
	}


	public int getElevatorId() {
		return elevatorId;
	}
	

	public static int getMinFloor() {
		return minFloor;
	}

	
	public static int getMaxFloor() {
		return maxFloor;
	}

	
	public static void setMinFloor(int minFloor) {
		Elevator.minFloor = minFloor;
	}

	
	public static void setMaxFloor(int maxFloor) {
		Elevator.maxFloor = maxFloor;
	}

	
	public int getStack() {
		return stack;
	}

	
	public void stackIncrement() {
		stack++;
	}

	public void stackDecrement() {
		stack--;
	}

	
}
