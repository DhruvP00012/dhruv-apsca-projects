package robot;

import kareltherobot.*;

public class Roomba implements Directions {

	// Main method to make this self-contained
	public static void main(String[] args) {
		// LEAVE THIS ALONE!!!!!!
		String worldName = "robot/finalTestWorld2024.wld";

		Roomba cleaner = new Roomba();
		int totalBeepers = cleaner.cleanRoom(worldName, 26, 101);
		//System.out.println("Roomba cleaned up a total of " + totalBeepers + " beepers.");

	}

	// declared here so it is visible in all the methods!
	private Robot roomba;

	// You will need to add many variables!!


	public int cleanRoom(String worldName, int startX, int startY) {

		// A new Robot should be constructed and assigned to the global (instance) variable named roomba that is declared above.
        // Make sure it starts at startX and startY location.

		World.readWorld(worldName);
		World.setVisible(true);
       	//World.setSize(20, 20);
       	World.setDelay(0);

		roomba = new Robot(startX, startY, East, 0);
		int count = 0;
		int numPiles = 0; 
		int numSteps = 0;
		boolean end = true; 
		while(end){
			while(roomba.nextToABeeper()){
					roomba.pickBeeper();
					count++; 

				}
			while(roomba.frontIsClear()){
				roomba.move(); 
				numSteps++;
				if(roomba.nextToABeeper() == true){
					numPiles++; 
				}
				while(roomba.nextToABeeper()){
					roomba.pickBeeper();
					count++; 

				}
	
			}
			if(roomba.facingEast() && !roomba.frontIsClear()){
				while(roomba.nextToABeeper()){
					roomba.pickBeeper();
					count++; 

				}
				roomba.turnLeft();
				roomba.move(); 
				numSteps++;
				while(roomba.nextToABeeper()){
					roomba.pickBeeper();
					count++; 

				}
				roomba.turnLeft(); 
			}
			if(roomba.facingWest() && !roomba.frontIsClear()){
				while(roomba.nextToABeeper()){
					roomba.pickBeeper();
					count++; 

				}
				turnRight(roomba);
				roomba.move(); 
				numSteps++;
				while(roomba.nextToABeeper()){
					roomba.pickBeeper();
					count++; 

				}
				turnRight(roomba); 
			}
			if(roomba.facingNorth() && !roomba.frontIsClear()){
				end = false; 
			}
		} 
		System.out.println("Total number of beepers: "+ count); 
		System.out.println("Total number of steps: "+numSteps);
		System.out.println("Total number of piles = "+ numPiles); 
		return count;
		/*
		while(roomba.nextToABeeper())
		{
			roomba.pickBeeper();
			totalBeepers ++;
		}

		roomba.move();
		while(roomba.nextToABeeper())
		{
			roomba.pickBeeper();
			totalBeepers ++;
		}

		roomba.move();
		roomba.move();
		roomba.turnLeft();
		roomba.move();
		while(roomba.nextToABeeper())
		{
			roomba.pickBeeper();
			totalBeepers ++;
		}

		roomba.move();
		while(roomba.nextToABeeper())
		{
			roomba.pickBeeper();
			totalBeepers ++;
		}

		roomba.turnLeft();
		roomba.move();
		roomba.move();
		roomba.move();
		roomba.move();
		while(roomba.nextToABeeper())
		{
			roomba.pickBeeper();
			totalBeepers ++;
		}
		
		roomba.turnLeft();
		roomba.turnLeft();
		roomba.turnLeft();
		roomba.move();
		roomba.turnLeft();
		roomba.turnLeft();
		roomba.turnLeft();
		roomba.move();
		roomba.move();
		while(roomba.nextToABeeper())
		{
			roomba.pickBeeper();
			totalBeepers ++;
		}

		roomba.turnLeft();
		roomba.move();
		roomba.turnLeft();
		roomba.move();
		while(roomba.nextToABeeper())
		{
			roomba.pickBeeper();
			totalBeepers ++;
		}
		
		roomba.turnLeft();
		roomba.turnLeft();
		roomba.move();
		roomba.move();
		while(roomba.nextToABeeper())
		{
			roomba.pickBeeper();
			totalBeepers ++;
		}
		
		roomba.move();
		roomba.move();
		roomba.move();
		while(roomba.nextToABeeper())
		{
			roomba.pickBeeper();
			totalBeepers ++;
		}


		return totalBeepers;
	*/
	}

	public static void turnRight(Robot roomba){
		roomba.turnLeft();
		roomba.turnLeft();
		roomba.turnLeft();
	}
}
   