
public class Boat {

	/*
	 *        Myo Thet Tun_2918551
	 *        Carlos Leite - 2931368
	 * 
	 * 
	 * 
	 */	
			
			
				
		private String name;
		private String type;
		private int size;
		private int strength;
		private boolean isAlive;
		private static int boatTotal = 5;
		public static int boatPosition[][] = new int[10][10];
		public static int boatPosition2[][] = new int[10][10];
		public static int shoots[][] = new int[10][10];
		// @ Myo
		// class method override with name, type, size, strength and isAlive 
		
		public Boat(String n,String t,int s,int h, boolean a){
			name = n;
			type = t;
			size = s;
			strength = h;
			isAlive = a;
		}
		// @ Myo	
		// check whether the boat is hit
		
		public void checkHit(int myStrength){
			int myStrengthArray[] = new int[5]; 
			// if the boatPosition and shoot are the same and there's a boat, it's been hit
			// check the hit boat according to the size 
			if(myStrength == 5){
				
				this.strength = this.strength - 1; // as it has been hit, minus one to the strength
				checkSank();						//check it has strength 0 or not
				myStrengthArray[0] = this.strength; // assign to temporary array and print out
				System.out.println("The ship has been hit!");
				//System.out.println("Strength Left = " + myStrengthArray[0]);
				System.out.println();
				System.out.println("*************************************************************");
			}
			else if(myStrength == 4){
				
				this.strength = this.strength - 1;
				checkSank();
				myStrengthArray[1] = this.strength;
				System.out.println("The ship has been hit!");
				//System.out.println("Strength Left = " + myStrengthArray[1]);
				System.out.println();
				System.out.println("*************************************************************");
			}
			else if(myStrength == 3){
				
				this.strength = this.strength - 1;
				checkSank();
				myStrengthArray[2] = this.strength;
				System.out.println("The ship has been hit!");
				//System.out.println("Strength Left = " + myStrengthArray[2]);
				System.out.println();
				System.out.println("*************************************************************");
			}
			else if(myStrength == 2){
				
				this.strength = this.strength - 1;
				checkSank();
				myStrengthArray[3] = this.strength;
				System.out.println("The ship has been hit!");
				//System.out.println("Strength Left = " + myStrengthArray[3]);
				System.out.println();
				System.out.println("*************************************************************");
			}
			else{
				System.out.println("You have missed the target!"); // if the strength is not matched with the boat size, then you miss the target!
			}
		}
		
		
		// @Carlos
		public void checkHit2(int myStrength){
			int myStrengthArray[] = new int[5]; 
			// if the boatPosition and shoot are the same and there's a boat, it's been hit
			// check the hit boat according to the size 
			if(myStrength == 5){
				
				this.strength = this.strength - 1; // as it has been hit, minus one to the strength
				checkSank();						//check it has strength 0 or not
				myStrengthArray[0] = this.strength; // assign to temporary array and print out
				System.out.println("The ship has been hit!");
				//System.out.println("Strength Left = " + myStrengthArray[0]);
				System.out.println();
				System.out.println("*************************************************************");
			}
			else if(myStrength == 4){
				
				this.strength = this.strength - 1;
				checkSank();
				myStrengthArray[1] = this.strength;
				System.out.println("The ship has been hit!");
				//System.out.println("Strength Left = " + myStrengthArray[1]);
				System.out.println();
				System.out.println("*************************************************************");
			}
			else if(myStrength == 3){
				
				this.strength = this.strength - 1;
				checkSank();
				myStrengthArray[2] = this.strength;
				System.out.println("The ship has been hit!");
				//System.out.println("Strength Left = " + myStrengthArray[2]);
				System.out.println();
				System.out.println("*************************************************************");
			}
			else if(myStrength == 2){
				
				this.strength = this.strength - 1;
				checkSank();
				myStrengthArray[3] = this.strength;
				System.out.println("The ship has been hit!");  
				//System.out.println("Strength Left = " + myStrengthArray[3]);
				System.out.println();
				System.out.println("*************************************************************");
			}
			else{
				System.out.println("Your enemy has missed the target!"); // if the strength is not matched with the boat size, then you miss the target!
				System.out.println();
				System.out.println("*************************************************************");
				System.out.println();
			}
		}		
		// @ Myo
		// check whether the boat is sank
		
		public void checkSank(){
			
			// if strength is 0, it's dead, so minus 1 boat from fleet
			
			if(this.strength < 1){
				isAlive = false;
				displaySank();
				boatTotal = boatTotal - 1;
				System.out.println("\nYou have " + boatTotal + " ships left!");
				
				// if there is no boat left, it's game over
				if(boatTotal < 1){
					displayGameOver();
				}
			}
			
			// if strength > 0, it's still alive
			
			else{
				isAlive = true;
			}
		}
		// @ Myo
		// display game over
		
		public void displayGameOver(){
			System.out.print("You sank the whole fleet! Game Over!");
		}
		// @ Myo
		// display sank
		
		public void displaySank(){
			System.out.print("The ship " + type + " has been sunk!");
		}

	}

