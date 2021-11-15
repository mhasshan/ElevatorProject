package com.fdmgroup;

public class RequestThread implements Runnable {
	private int startFloor;
	private int endFloor;
	Elevator elevator;
	

	public RequestThread(Elevator elevator, int startFloor, int endFloor) {
		this.startFloor = startFloor;
		this.endFloor = endFloor;
		this.elevator = elevator;
	}


	@Override
	public void run() {
		try {
			elevator.elevatorUpDown(startFloor,endFloor);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
