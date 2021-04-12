package fourdigitgame_jp;

import java.util.Scanner;

public class UserInput {

    /**
     *The Methode request the User to insert an Integer number.
     * If the input is NaN or error, output is null.
     * 
     * @param consoloeInput Scanner Object to read the input.
     * @return int value as String or null in error.
     */
    public static String askUserToInsert(Scanner consoloeInput) {
        // testing the Scanner Object input
        if(consoloeInput == null){
            return null;
        }
        //declaring return value
        String result;
        
        try{
            if(consoloeInput.hasNextInt()){
                //if User input is valid
                result = consoloeInput.next();
            }else{
                // return null;
                result = null;
            }
        }catch(IllegalStateException e){
            System.err.println("\n the input has: " + e.getLocalizedMessage());
            System.err.println("Game Over.");
            System.exit(0);
            
            // still to write
            result = null;
        }
        //throw the input
        consoloeInput.nextLine();
        //User's input as output
        return result;
    }

}
