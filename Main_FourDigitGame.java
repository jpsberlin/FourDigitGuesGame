public class Main_FourDigitGame_JP {

    
    public static void main(String[] args) {
        
        /*
        Scanner scanner = new Scanner(System.in);
        GuessDigitsToConsole.startGame(scanner);
        scanner.close();
        */
        guiVersion();
    }

    private static void guiVersion() {
        new GuessFourDigitsGUI().showGui();  
        
    }
    
    /**
     * private static void consoleVersion() {
        Scanner scanner = new Scanner(System.in);
        GuessTwoDigitsConsole.startGame(scanner);
        scanner.close();
    }
     * 
     */
}
