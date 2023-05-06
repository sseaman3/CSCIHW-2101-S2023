package Project3;

import java.util.ArrayList;
import java.util.Scanner;

public class squidgame {
 


//WriteUp:
//There are 2 ladders R and L 
//There are 2 types of Glass, Regular and Tempered 
//Tempered Glass can hold your body weight
//Regular Glass can not hold your body weight
 
//TO RUN THE JAVA JAR IN YOUR TERMINAL WITHIN THIS FOLDER type:

//java -jar SquidGame.jar

//NOTE: YOU MUST MAKE SURE YOU ARE IN THE PROJECT3 FOLDER


//The Requirements of this project is to create the ladder game in an asci art 
//EX.
//|||||| ---- Start
//| || |
//| || |
//| || |
//| || |
//| || |
//| || |
//| || |
//| || |
//|||||| ---- Finish

//This ladder should be dynamic in that as the player continues to play the game the ladder updates
//EX.
//|||||| ---- Start
//|1||0|
//|1||0|
//|?||?|

//You can follow this legend to help with the glass vs tempered glass
//---------LEGEND-----------
//0: Glass
//1: Tempered Glass
//--------------------------

//The game will continue until the player runs out of lives or makes it to the end:


//WIN EX.
//Congrats You Won!!
//|||||| ---- Start
//|1||0|
//|1||0|
//|1||0|
//|1||0|
//|0||1|
//|1||0|
//|0||1|
//|0||1|
//|||||| ---- Finish


//LOSE EX.
//-------------------------------------
//|||||| ---- Start
//|1||0|
//|1||0|
//|?||?|
//You Lost 1 life
//Total Lives: 0
//YOU DIED

//Components:
//The hardest part of the game will be making the ladder dynamic
//The best approach is to break up each of your objectives:

//1. Create a player life counter with the following methods:
//    a) getLives - Get total lives
//    b) death - Subtract 1 from total lives

    public class player{
        private int lives;
        public player(int lives){
            this.lives = lives;
        }
        public int getLives(){
            return this.lives;
        }
        public void death(){
            this.lives--;
        }
    }

//2. Create a ladder with n panels
//    Hint1: This can be done with a 2D array with the rows as the panels & 2 cols R/L
//   Hint2: The Cols are going to be hard coded 2 so int[panels][2] would work
//    Hint3: To create the ladders Glass and Tempered Glass placements use a double for loop 
//    Hint3: If you are really stuck here (I was for a few hours) Email me
//    Hint4: in the double for loop make a random number generator 0-1 

    public class ladder{
        private int[][] ladder;
        public ladder(int panels){
            this.ladder = new int[panels][2];
            for(int i = 0; i < panels; i++){
                for(int j = 0; j < 2; j++){
                    this.ladder[i][j] = (int)(Math.random() * 2);
                }
            }
        }
        public int[][] getLadder(){
            return this.ladder;
        }

    }
//3. Create a printer for a answer ladder and blank ladder and current ladder
//    a) Have a hard coded Start and End 
 //   b) the ladder should be the length that was decided by the objects initialization
//    Hint: Current Ladder -This is helpful- "|"+ladder[i][j] + "|" 

public static void printLadder(int[][] ladder){
    System.out.println("|||||| ---- Start");
    for(int i = 0; i < ladder.length; i++){
        System.out.print("|");
        for(int j = 0; j < 2; j++){
            System.out.print(ladder[i][j] + "|");
        }
        System.out.println();
    }
    System.out.println("|||||| ---- Finish");
}

//4. Create a method to get the current user selection
//    a) answer should only be R,r or L,l anything else should reprompt the user
 //   b) convert R to 1 and L to 0 
 //   c) add that value to an ArrayList

 public static ArrayList<Integer> getUserSelection(int[][] ladder) {
    Scanner input = new Scanner(System.in);
    ArrayList<Integer> userSelection = new ArrayList<Integer>();
    System.out.println("Please enter your selection for each panel");
    System.out.println("R = 1, L = 0");
    for(int i = 0; i < ladder.length; i++){
        System.out.println("Panel " + (i+1) + ": ");
        String answer = input.nextLine();
        while(!answer.equals("R") && !answer.equals("r") && !answer.equals("L") && !answer.equals("l")){
            System.out.println("Please enter a valid selection");
            answer = input.nextLine();
        }
        if(answer.equals("R") || answer.equals("r")){
            userSelection.add(1);
        }
        else{
            userSelection.add(0);
        }
    }
    return userSelection;
}
//5. Now you have a 2D array of the answers of panels and an running arrayList of the user
//selections... compare the current index of the users selection with the answer array 
//if correct continue to next ladder row and print the current ladder incermented by 1 
//if wrong -1 from lives
//if the lives hit 0 then end the game
//if the lives are not 0 and the end of the ladder is reached then print the final 
//ladder as well as a congrats 

public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    System.out.println("Welcome to Squid Game");
    System.out.println("How many panels would you like to play with?");
    int panels = input.nextInt();
    player player1 = new player(3);
    ladder ladder1 = new ladder(panels);
    int[][] ladder = ladder1.getLadder();
    printLadder(ladder);
    ArrayList<Integer> userSelection = getUserSelection(ladder);
    int[][] currentLadder = new int[panels][2];
    for(int i = 0; i < panels; i++){
        for(int j = 0; j < 2; j++){
            currentLadder[i][j] = 0;
        }
    }
    for(int i = 0; i < panels; i++){
        for(int j = 0; j < 2; j++){
            if(userSelection.get(i) == ladder[i][j]){
                currentLadder[i][j] = 1;
            }
            else{
                player1.death();
                System.out.println("You Lost 1 life");
                System.out.println("Total Lives: " + player1.getLives());
                if(player1.getLives() == 0){
                    System.out.println("YOU DIED");
                    System.exit(0);
                }
            }
        }
    }
    printLadder(currentLadder);
    System.out.println("Congrats You Won!!");
    printLadder(ladder);
}
}