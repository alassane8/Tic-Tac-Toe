import java.util.Random;
import javax.swing.JOptionPane;

public class tictactoe {
    public int number;
    public char[][] Array;

    public tictactoe(int num, char[][] array) {
        number = num;
        Array = array;
    }

    public String display(String display) {

        for (char row = 0; row < 3; row++) {
            for (int col = 0; col < 3; col++) {

                if (row == 0 && col == 2) {
                    display = display + Array[row][col] + "\n";
                } else if (row == 1 && col == 2) {
                    display = display + Array[row][col] + "\n";
                } else {
                    display = display + Array[row][col] + " ";
                }
            }
        }
        return display;
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // Variables
        int num = 0;
        int input = 1;
        int value;
        char c = 'X';
        String str;
        String display = "";
        char[][] array = { { 49, 50, 51 }, { 52, 53, 54 }, { 55, 56, 57 } };

        // Welcoming the player
        JOptionPane.showMessageDialog(null, "Welcome to Tic-Tac-Toe.\n"
                + "You will have X and the computer will have O.");

        // Display of the array that will be the grid for players
        tictactoe tableau = new tictactoe(num, array);

        for (int a = 0; a < 3; a++) {
            for (int b = 0; b < 3; b++) {
                do {
                    // Input of the shoot the player hase to make
                    str = JOptionPane.showInputDialog(null,
                            "Enter number where you want to play.\n" + tableau.display(display));
                    num = Integer.parseInt(str);
                    num = num + 48;
                    // Going accross the grid to find num
                    for (int i = 0; i < 3; i++) {
                        for (int j = 0; j < 3; j++) {
                            if (array[i][j] == num) {
                                array[i][j] = c;
                                JOptionPane.showMessageDialog(null,
                                        "Your move is recorded.\nNow the computer will play.\n"
                                                + tableau.display(display));
                            }
                        }
                    }
                    // Computer shoot
                    Random random = new Random();
                    value = random.nextInt(10) + 1;
                    value = value + 48;
                    // Going accross the grid to found num
                    for (int i = 0; i < 3; i++) {
                        for (int j = 0; j < 3; j++) {
                            while (array[i][j] == value && array[i][j] == c) {
                                value = random.nextInt(10) + 1;
                            }
                            if (array[i][j] == value) {
                                array[i][j] = 'O';
                                JOptionPane.showMessageDialog(null,
                                        "The computer has played.\n" + tableau.display(display));
                            }
                        }
                    }
                } while (input != 0);
            }
        }
    }
}