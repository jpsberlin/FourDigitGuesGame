
package fourdigitgame_jp;

import java.awt.*;
import javax.swing.*;


public class GuessFourDigitsGUI extends JFrame{
    
    
    private JTextArea taMessage;
    private JLabel lblTipp;
    private JTextField tfInsert;
    private JButton btnEnd;
    private JButton btnGuess;
    private JButton btnReset;
    int counterTry = 0;

    GuessFourDigits guess;

    public GuessFourDigitsGUI() {
        guess = new GuessFourDigits();
        initializeComponents();
    }

    public void showGui() {
        this.setVisible(true);
    }

    private void initializeComponents() {
        // configuring Frames 
        this.setTitle("Guess Digits");
        this.setSize(420, 350);
        this.setLocation(500, 200);
        this.setResizable(true);

        // creating Components
        taMessage = new JTextArea();
        JScrollPane spMitteilung = new JScrollPane();
        spMitteilung.setViewportView(taMessage);
        lblTipp = new JLabel();
        tfInsert = new JTextField();
        btnEnd = new JButton();
        btnGuess = new JButton();
        btnReset = new JButton();

        // Texts input
        final String willkommen = "Welcome to Guess a  Four Digit Number.\n-------------------------------------------------\nGuess a Number between 0123 and 9876.\nNo repeatation of a Digit. Good Luck!\n-------------------------------------------------\n";
        taMessage.append(willkommen);
        taMessage.setEditable(false);

        lblTipp.setText("your number:");
        btnEnd.setText("end");
        btnGuess.setText("guess");
        btnReset.setText("reset");

        // activating Listener 
        btnEnd.addActionListener((ae) -> System.exit(0));
        btnReset.addActionListener((ae) -> {
            btnGuess.setEnabled(true);
            taMessage.setText(willkommen);
            tfInsert.setText("");
            guess.reset();
            counterTry = 0;
                    
        });
        
        btnGuess.addActionListener((ae) -> {
            
               String usersNumber = tfInsert.getText();
               int[] comparingNumber;
               boolean tipp = false;
               
               counterTry++;
               // 2. asking User to guess
               taMessage.append("your number: " + usersNumber +"\n");
               
               // 2a. check validity of inserted number
               if (guess.validityCheckOfNumber(usersNumber)){
                
                   // 3. comparing numbers
                   comparingNumber = guess.compareTheNumbers(usersNumber);
                   int rightGuess = comparingNumber[0]+comparingNumber[1];
                   // 4.  giving tipps and congratulating user
                   if(comparingNumber[0] == guess.NUMBER_LENGTH){
                       taMessage.append("congratulations!, your guess " 
                               +usersNumber+ " right, total "
                                       +counterTry +" steps.");
                       tipp = true;
                   }else{
                       taMessage.append("right number at right position: "
                        +comparingNumber[0]+ " right number at wrong position: "
                        +comparingNumber[1]+ "\n"+ "total right numbers: " 
                        +rightGuess+ "\n");
                        
                   }
               }else{
                   JOptionPane.showMessageDialog(this, "your input is invalid, insert a 4 digit number.", "Input Error", JOptionPane.ERROR_MESSAGE);
               }
               
            tfInsert.setText("");
            tfInsert.requestFocusInWindow();
        });

        // Buttons Panel 
        JPanel buttons = new JPanel();
        buttons.setLayout(new GridLayout(1,3));
        buttons.add(btnReset);
        buttons.add(btnGuess);
        buttons.add(btnEnd);

        // Components configuring with Grouplayout Panel
        JPanel panel = new JPanel();
        GroupLayout layout = new GroupLayout(panel);
        panel.setLayout(layout);

        layout.setHorizontalGroup(layout.createParallelGroup()
                        .addGap(10)
                        .addComponent(spMitteilung)
                        .addGroup(layout.createSequentialGroup()
                                .addComponent(lblTipp)
                                .addGap(5)
                                .addComponent(tfInsert)
                        )
                        .addComponent(buttons)
        );

        layout.setVerticalGroup(layout.createSequentialGroup()
                        .addComponent(spMitteilung)
                        .addGap(5)
                        .addGroup(layout.createParallelGroup()
                                .addComponent(lblTipp, GroupLayout.Alignment.CENTER)
                                .addComponent(tfInsert, GroupLayout.Alignment.CENTER, tfInsert.getPreferredSize().height, tfInsert.getPreferredSize().height, tfInsert.getPreferredSize().height)
                        )
                        .addGap(5)
                        .addComponent(buttons, btnEnd.getPreferredSize().height, btnEnd.getPreferredSize().height, btnEnd.getPreferredSize().height)
        );

        // Panel placing to Frame and padding and margin
        GroupLayout layout2 = new GroupLayout(this.getContentPane());
            layout2.setHorizontalGroup(layout2.createSequentialGroup()
                .addGap(10)
                    .addGroup(layout2.createParallelGroup()
                            .addGap(10)
                            .addComponent(panel)
                            .addGap(10)
                    )
                .addGap(10)
            );

        layout2.setVerticalGroup(layout2.createParallelGroup()
                .addGap(10)
                .addGroup(layout2.createSequentialGroup()
                        .addGap(10)
                        .addComponent(panel)
                        .addGap(10)
                )
                .addGap(10)
        );
        this.setLayout(layout2);
    
    
}

}