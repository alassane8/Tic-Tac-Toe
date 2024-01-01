import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Tictactoe implements ActionListener {
    private JFrame frame;
    private JPanel panel;
    private JButton[] buttons = new JButton[9];

    public Tictactoe() {
        frame = new JFrame("TicTacToe game");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        panel = new JPanel();
        panel.setLayout(new GridLayout(3, 3));
        panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        for (int i = 0; i < 9; i++) {
            buttons[i] = new JButton();
            buttons[i].setFont(new Font("Arial", Font.PLAIN, 40));
            buttons[i].addActionListener(this);
            panel.add(buttons[i]);
        }

        frame.add(panel, BorderLayout.CENTER);
        frame.setSize(400, 400);
        frame.setVisible(true);
    }

    public void actionPerformed(ActionEvent event) {
        JButton Button = (JButton) event.getSource();
        if (X) {
            Button.setText("X");
        }
        if (O) {
            Button.setText("O");
        }
        Button.setEnabled(false);
        X = !X;

        checkForWinner();
    }

    public void checkForWinner() {

    }

    public void resetGame() {
        for (int i = 0; i < 9; i++) {
            buttons[i].setText("");
            buttons[i].setEnabled(true);
        }
        X = true;
    }

    public static void main(String[] args) {
        new Tictactoe();
    }
}