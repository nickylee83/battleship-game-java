
/*
 *        Myo Thet Tun_2918551
 *        Carlos Leite - 2931368
 * 
 * 
 * 
 */


import java.util.Scanner;

	public class BattleShip{
		// @ Carlos + Myo
		public static void main(String[] args) {
				
			//initialising boats
				
			int ship1Size = 5, ship2Size = 4, ship3Size = 3, ship4Size = 3, ship5Size = 2;
			Boat b1 = new Boat("Aircraft Carrier","Aircraft Carrier",5,5,true);
			Boat b2 = new Boat("Battleship","Battleship",4,4,true);
			Boat b3 = new Boat("Destroyer","Destroyer",3,3,true);
			Boat b4 = new Boat("Submarine","Submarine",3,3,true);
			Boat b5 = new Boat("Petrol Boat","Petrol Boat",2,2,true);
									
			/*Creating an array board Player 1 and 2, the method initBoard will populate 
			 *the entire array with the number -1  
			*/
			int[][] boardPlayer1 = initBoard();
			int[][] boardPlayer2 = initBoard();

			//Placing the ships in showBoard(boardPlayer1);
			placeShips(boardPlayer1,ship1Size);
			placeShips(boardPlayer1,ship2Size);
			placeShips(boardPlayer1,ship3Size);
			placeShips(boardPlayer1,ship4Size);
			placeShips(boardPlayer1,ship5Size);
					
			//Placing the ships in showBoard(boardPlayer1);
			placeShips(boardPlayer2,ship1Size);
			placeShips(boardPlayer2,ship2Size);
			placeShips(boardPlayer2,ship3Size);
			placeShips(boardPlayer2,ship4Size);
			placeShips(boardPlayer2,ship5Size);
					
			//Printing the board for the user
			showBoard1(boardPlayer1);
			showBoard2(boardPlayer2);
									
			//Scanner for the player choose row and column to shoot
			Scanner scan = new Scanner(System.in);
			int shootRow, shootCol;
			int myHit;
			int hitShip;
					
			// do this as long as the game is running
									
			boolean gameIsNotOver = true;
			do {	
						
				do{ // asking user input for row
					System.out.println("Player 1, attack enemy board");
					System.out.println("Enter a number from 0 to 9 for: ");
					System.out.print("ROW : ");
					
					// validation check for 0 to 9
					while (!scan.hasNextInt()) {
						System.out.println("That's not a number!");
						System.out.println();
						System.out.println("Please enter a number from 0 to 9 !!!");
						System.out.print("ROW : ");
						scan.next(); 
					}
					shootRow = scan.nextInt(); // assign to shoot Row
				} while (shootRow >= 10 || shootRow < 0);
				
										        
				do { // asking user input for column
					System.out.print("COLUMN : ");
					
					// validation check for 0 to 9
					while (!scan.hasNextInt()) {
						System.out.println("That's not a number!");
						System.out.println();
						System.out.println("Please enter a number from 0 to 9 !!!");
						System.out.print("COLUMN : ");
						scan.next(); 
						
					}
				
					shootCol = scan.nextInt(); // assign to shoot Col
				} while (shootCol >= 10 || shootCol < 0);								
						
				// check which boat has been shot according to size, and assign to hitShip
				if(boardPlayer1[shootRow][shootCol] == 5){
					hitShip = 5;
				}
				else if(boardPlayer1[shootRow][shootCol] == 4){
					hitShip = 4;
				}
				else if(boardPlayer1[shootRow][shootCol] == 3){
					hitShip = 3;
				}
				else if(boardPlayer1[shootRow][shootCol] == 2){
					hitShip = 2;
				}
				// missed the target!
				else{
					hitShip = 0;
				}
						
				// assign to myHit
				myHit = shoot(shootRow,shootCol,boardPlayer1,hitShip);
						
				// call checkHit procedure according to myHit number
				if(myHit == 5){
					b1.checkHit(5); // checking boat size of 5
				}
				else if(myHit == 4){
					b2.checkHit(4); // checking boat size of 4
				}
				else if(myHit == 3){
					b3.checkHit(3); // checking boat size of 3
				}
				else if(myHit == 2){
					b5.checkHit(2); // checking boat size of 2
				}
				else{
					b1.checkHit(0); // missed the target!
				}
				
							
				//Random numbers for the computer choose the grid to shoot for player 2
				int rowRandom = (int)Math.floor(Math.random()*10);
				int columnRandom = (int)Math.floor(Math.random()*10);
				//Checking where is the location of the shoot according to size, and assign to hitShip
												
				if(boardPlayer2[rowRandom][columnRandom] == 5){
					hitShip = 5;
				}
				else if(boardPlayer2[rowRandom][columnRandom] == 4){
					hitShip = 4;
				}
				else if(boardPlayer2[rowRandom][columnRandom] == 3){
					hitShip = 3;
				}
				else if(boardPlayer2[rowRandom][columnRandom] == 2){
					hitShip = 2;
				}
				// missed the target!
				else{
					hitShip = 0;
				}
						
				// assign to myHit
				int myHit2 = shoot2(rowRandom,columnRandom,boardPlayer2,hitShip);
						
				// call checkHit procedure according to myHit number
				if(myHit2 == 5){
					b1.checkHit2(5); // checking boat size of 5
				}
				else if(myHit2 == 4){
					b2.checkHit2(4);
				}
				else if(myHit2 == 3){
					b3.checkHit2(3);
				}
				else if(myHit2 == 2){
					b5.checkHit2(2);
				}
				else{
					b1.checkHit2(0); // missed the target!
				}
														
			}while(gameIsNotOver);
					
			scan.close();
		}
			// @ Carlos
			//Initiating the board, it will print -1 in both Boards
			public static int[][] initBoard(){
				int board[][] = new int[10][10];
				for(int row=0 ; row < 10 ; row++ ){
					for(int column=0 ; column < 10 ; column++){
						board[row][column] = -1;/*It is populating our array with -1 */
					}
				}
				return board;
			}
			// @ Carlos
			//To print the elements inside the board
			public static void showBoard1(int[][] board){
				System.out.println();
				System.out.println();
				System.out.println("*************************  ENEMY   *************************");
	
				for(int row=0 ; row < 10 ; row++ ){
					System.out.print(" ");            
					for(int column=0 ; column < 10 ; column++ ){         	
						if(board[row][column] == 5 ){
							System.out.print("__" + "_" + "__" + "|");// 5 = B 
						}else if(board[row][column] == 4 ){
							System.out.print("__" + "_" + "__" + "|");// 4 = B 
						}else if(board[row][column] == 3 ){
							System.out.print("__" + "_" + "__" + "|");// 3 = B 
						}else if(board[row][column] == 2 ){
							System.out.print("__" + "_" + "__" + "|");// 2 = B 
						}else if(board[row][column] == 1){
							System.out.print("__" + "H" + "__" + "|");// 1 = H                                 
						}else if(board[row][column] == -2){
							System.out.print("__" + "X" + "__" + "|");// -2 = X                                 
						}
						else{
							System.out.print("_____" + "|"); // expand grid size
						}
					}System.out.println(""); // expand grid size
					System.out.println("");}}
			// @ Carlos		
			//To print the elements inside the board
			public static void showBoard2(int[][] board){
				System.out.println();
				System.out.println();
                System.out.println("***********************   PLAYER 1  *************************");
				for(int row=0 ; row < 10 ; row++ ){
					System.out.print(" ");            
					for(int column=0 ; column < 10 ; column++ ){         	
						if(board[row][column] == 5 ){
							System.out.print("__" + "B" + "__" + "|");
						}else if(board[row][column] == 4 ){
							System.out.print("__" + "B" + "__" + "|");
						}else if(board[row][column] == 3 ){
							System.out.print("__" + "B" + "__" + "|");
						}else if(board[row][column] == 2 ){
							System.out.print("__" + "B" + "__" + "|");
						}else if(board[row][column] == 1){
							System.out.print("__" + "H" + "__" + "|");// 1 = H                                 
						}else if(board[row][column] == -2){
							System.out.print("__" + "X" + "__" + "|");// -2 = X                                 
						}
						else{
							System.out.print("_____" + "|"); // expand grid size
						}
					}System.out.println(""); // expand grid size
					System.out.println("");}
			}
			// @ Myo
			//To shoot in the board 1
			public static int shoot(int row, int column, int board[][], int shipSize){
				int hit;
				  
				Boat.boatPosition[row][column] = shipSize;
				
				if(board[row][column] == Boat.boatPosition[row][column]){
					hit = shipSize; // assign ship size to hit
					//System.out.println("Position value " + board[row][column] + "  Shoot value " + Boat.boatPosition[row][column]);
					board[row][column] = 1;// 1 =  will print H in the Board
					showBoard1(board);		// show player 1 grid again		
				}
				else{
					hit = 0;
					//System.out.println("Position " + board[row][column] + "  Shoot " + Boat.boatPosition[row][column]);
					board[row][column] = -2;// -2 =  will print X in the Board
					showBoard1(board);		// show player 1 grid again			
				}		
				
				return hit;
			}
			// @ Carlos				
			//To shoot in the board 2
			  public static int shoot2(int row, int column, int board[][], int shipSize){
				  int hit;		
				  
				Boat.boatPosition2[row][column] = shipSize;
				
				if(board[row][column] == Boat.boatPosition2[row][column]){
					hit = shipSize; // assign ship size to hit
					System.out.println("Position value " + board[row][column] + "  Shoot value " + Boat.boatPosition2[row][column]);
					board[row][column] = 1;// 1 =  will print H in the Board
					showBoard2(board); // show player 2 grid again	
				}
				else{
					hit = 0;
					System.out.println("Position " + board[row][column] + "  Shoot " + Boat.boatPosition[row][column]);
					board[row][column] = -2;// -2 =  will print X in the Board
					showBoard2(board); // show player 2 grid again	
				}		
				
				return hit;

			}
			// @ Carlos
			  // locating ships on the grid
				public static void placeShips(int board[][], int shipSize){
					//System.out.println("Trying ship of size " + shipSize);
					
					int provisoryBoard[][] = new int[10][10];//A new Board to hold the boats for tests				
					boolean shipPossible = false; // variable to check whether the ship is possible to be located on the board
					do{
						
						for (int i = 0; i < 10; i++){
							for (int j = 0; j < 10; j++){
								provisoryBoard[i][j] = -1;
							}
						}
						// random values for row and column
						int rowRandom = (int)Math.floor(Math.random()*10);
						int columnRandom = (int)Math.floor(Math.random()*10);
						//System.out.println("row:" + rowRandom + "Column " + columnRandom );
						
						/*
						 * RandomNumber will choose randomly the direction of the boat
						 * 0 = right, 1 = down, 2 = left , 3 = up
						 */					
						int RandomNumber = (int)(Math.random()*4);

						for(int row=0 ; row < 10 ; row++ ){
							for(int column=0 ; column < 10 ; column++){
								for(int i=0; i < shipSize; i++){ 
									
									// ship goes to right
									if( RandomNumber == 0){
										//col + ship size is bigger than grid
										if(columnRandom + shipSize > 10){
											RandomNumber++;
											shipPossible = false;
											break;
										}
										else{                                    //
											if(board[rowRandom][columnRandom + i] == shipSize){
												RandomNumber++;
												for (int j = i; j >= 0; j--){
													board[rowRandom][columnRandom + j] = -1;
												}
												shipPossible = false;
												break;
											}
											else{
												// locate the ship on provisory borad
												provisoryBoard [rowRandom][columnRandom+i] = shipSize;//Ship direction going to the right >
												shipPossible = true;
											}
											
										}
									}
									// ship goes to down
									if(RandomNumber == 1){
										//row + ship size is bigger than grid
										if(rowRandom + shipSize > 10){
											RandomNumber++;
											shipPossible = false;
											break;

										}
										else{
											if(board[rowRandom + i][columnRandom] == shipSize){
												RandomNumber++;
												//for (int j = i; j >= 0; j--){
													//board[rowRandom+j][columnRandom] = -1;
												//}
												shipPossible = false;
												break;
											}
											else{ // locate the ship on provisory borad                                           
												provisoryBoard [rowRandom+i]  [columnRandom]  = shipSize;//Ship direction going down V
												shipPossible = true;
											}
										}

									}
									// ship goes to left
									if(RandomNumber == 2){
										if(columnRandom - shipSize < 0){
											RandomNumber++;
										}
										else{
											if(board[rowRandom][columnRandom- i] == shipSize){
												RandomNumber++;

												shipPossible = false;
												break;
											}
											else{                                     //     = 0
												provisoryBoard [rowRandom]  [columnRandom-i] = shipSize;//Ship direction going backwards <
												shipPossible = true;
											}
										}
									}
									
									else{
										//ship goes to up
										if(RandomNumber == 3){
											if(rowRandom - shipSize < 0){
												shipPossible = false;
												break;
											}
											else{
												if(board[rowRandom - i][columnRandom] == shipSize){
													RandomNumber++;

													shipPossible = false;
													break;
												}
												else{
													// locate the ship on provisory borad
													provisoryBoard[rowRandom-i]  [columnRandom]  = shipSize;//Ship direction going upwards ^
													
												}
											}
										}
									}
									// if the ship can be located on provisory board, shipPossibe is true
									shipPossible = true;
								}	            			
							}	
						}		            	
					}while(shipPossible == false);
					
					for (int i = 0; i < 10; i++){
						for (int j = 0; j < 10; j++){
							// provisoryboard idea inspired by Henrique
							//THIS IS TO COPY THE POSSIBLE SHIP FROM THE PROVISORY BOARD TO THE ACTUAL ONE
							if (provisoryBoard[i][j] == shipSize){ 
								board[i][j] = shipSize;// =0
							}
						}
					}
				}
			}
