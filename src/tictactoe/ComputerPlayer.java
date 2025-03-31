package tictactoe;

import java.util.Random;

public class ComputerPlayer extends AbstractPlayer {
    public ComputerPlayer(String name, Symbol symbol) {
        super(symbol, name);
    }

    @Override
    public boolean isHuman() {
        return false;
    }

    @Override
    public void makeMove(Board board) { // besser: decideMove (board) Entscheidung
        // Zufälliger Zug
        Random random = new Random();
        int row, col; // Reihe, Spalte
        do {
            row = random.nextInt(GameConfig.BOARD_SIZE); // Werte zw. 0..2
            col = random.nextInt(GameConfig.BOARD_SIZE); // Werte zw. 0..2         
        } while (!board.makeMove(row, col, symbol)); // solange das Feld nicht frei (false)
        
        System.out.println("Computer hat seinen Zug gemacht.");
    }
}
