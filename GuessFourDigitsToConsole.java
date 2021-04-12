package fourdigitgame_jp;

import java.util.Scanner;


public class GuessFourDigitsToConsole {
   
/**
 *The Methode starts a new Game. A number will be generated and the User has
 * to gues the number with the helps of tipps.
 * 
 * @param console console Scanner of console.
 */
    public static void startGame(Scanner console){
        // 1. generate new game ans the random number
        GuessFourDigits guess = new GuessFourDigits(4);
        
        System.out.println("Welcome to GuessDigits");        
        System.out.println("-----------------------------------------");
        System.out.println("guess the right sequence of digits in "+guess.NUMBER_LENGTH+ "digits number.");
        System.out.println("with each try there will be tipp about result");
        System.out.println("-----------------------------------------");
        
        // declaring and initialization of loop flag
        boolean tipp = false;
        
        //counter of tries
        int counterTry = 0;
        
        do{
            // 2. asking User to guess
            System.out.println("Your guess: ");
            String usersNumber = UserInput.askUserToInsert(console);
            
            // 2a. check validity of inserted number
            if(!guess.validityCheckOfNumber(usersNumber)){
                System.out.println(" inserted number is not valid+\n"
                    + " a 4 digit positive number, no digit repeated.");
                continue;
            }
            
            // if inserted nummer valid, tipp counter goes up
            counterTry++;
            
            // 3. comparing numbers
            int[] comparingNum = guess.compareTheNumbers(usersNumber);
            
            // 4.  giving tipps and congratulating user
            if(comparingNum[0] == guess.NUMBER_LENGTH){
                //user wins
                System.out.println("Congrats, you reach "+usersNumber+" in "
                        + counterTry+ " tries.\n");
                tipp = true;
            }else{
                // tipp to user
                System.out.println("right number at right position: "
                        +comparingNum[0]+ " right number at wrong position: "
                        + comparingNum[1]+ "\n");
            }
            
            
            
        }while(!tipp);
        
    }
    
}
