package fourdigitgame_jp;

import java.util.Random;

public class GuessFourDigits {

    public final int NUMBER_LENGTH;

    private String randomNumber;
    private int guesses;

    // Constructor
    /**
     * creating a Game and generating the random number.
     */
    public GuessFourDigits() {
        NUMBER_LENGTH = 4;

        // generating random number
        generateRandomNumber();
        System.out.println(randomNumber);
    }

    /**
     * creating another GuessDigits game and generate the random number
     *
     * @param numberLength length of the game from 1 to 10.
     */
    public GuessFourDigits(int numberLength) {
        if (numberLength < 1 || numberLength > 10) {
            throw new IllegalArgumentException("input not valid.");
        }
        NUMBER_LENGTH = numberLength;
        
        // generating random number
        generateRandomNumber();
        System.out.println(randomNumber);
    }

    /**
     * The Method generates a random number between 0123 and 9876(length 4). The
     * random number has the following validities: positive number 4 digit no
     * repeatation of a digit possible to start with 0
     *
     * the number is checked and generated, assigned to String
     */
    private void generateRandomNumber() {
        String result = "";

        // creating an Object of Class Random with Variable random01
        Random random01 = new Random();

        // while loop to create a 4 digit number
        while (result.length() < NUMBER_LENGTH) {

            // random number between 0 and 9 to be generated
            int randomNumber = random01.nextInt(10);

            //changing randomNumber in String
            String stringRandomNumber = Integer.toString(randomNumber);

            /*
           * check the generated random number as digit in result
           * if not, to be inserted as a new digitat the end of result
             */
            if (!result.contains(stringRandomNumber)) {
                result += stringRandomNumber;
            }
        }
        randomNumber = result;
    }

     public void reset() {
        generateRandomNumber();
        guesses = 0;
    }
    
    /**
     * The Method checks a String the following validities. : Positive number 4
     * digit No repeatation of a digit Possible to start with 0
     *
     * Caution! the number is to be 4 digit, no long or short !!
     *
     * @param number to be checked in the String Format
     * @return true, if applicable, otherwise false
     */
    public boolean validityCheckOfNumber(String insertedNum) {
        // in case Object is "null" or not a 4 digit number, return false
        if (insertedNum == null || insertedNum.length() != NUMBER_LENGTH) {
            return false;
        }

        // its confirmed input is a number and a String with 4 char
        // looping through the chars
        for (char insertedCharacter : insertedNum.toCharArray()) {

            // checking the character for a number
            if (insertedCharacter >= '0' && insertedCharacter <= '9') {

                /*
                 * check repeatation of digit
                 * compare Indexes of 1st digit and the last digit, if so
                 * the repeatation is there
                 */
                if (insertedNum.indexOf(insertedCharacter) 
                        != insertedNum.lastIndexOf(insertedCharacter)) {
                    // digit is repeating
                    return false;
                }
            } else {
                //its not a number, Methode break, return false.
                return false;
            }
        }
        // as the check reach this point, the inserted number is valid
        return true;
    }

    /**
     * The Method compare the random number and the inserted number. It returns
     * an int-Array, index[0] is the total number of similar digit with the
     * exact position and index[1] is the total number of similar digit on the
     * other position.
     *
     * If the inserted value is not valid. [0,0] is the return.
     *
     * @param comparingNumber is the User's input.
     * @return int-Array
     */
    public int[] compareTheNumbers(String comparingNumber) {
        // declaring and initialization the return value
        int[] result = new int[2];

        // validity check of inserted value
        if (validityCheckOfNumber(comparingNumber)) {
            /*
             * to check all the inserted values every Index is to be 
             * compared with the random number, if so then to check the
             * similarity of Index 
             */
            for (int i = 0; i < randomNumber.length(); i++) {

                for (int j = 0; j < comparingNumber.length(); j++) {

                    if (randomNumber.charAt(i) == comparingNumber.charAt(j)) {
                   
                     // the valid number is there, not the similar Index                   
                        if (i == j) {
                            // similar Index
                            result[0]++;
                        } else {
                            // different Index
                            result[1]++;
                        }
                        // optional to stop the inner for loop
                        break;
                    }
                }
            }
        }
        return result;
    }
    
    public boolean gameOver(String guessNum) {
        return randomNumber == guessNum; //|| guesses >= MAX_GUESSES;
    }

}
