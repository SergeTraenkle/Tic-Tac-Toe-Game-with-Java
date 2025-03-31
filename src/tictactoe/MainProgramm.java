package tictactoe;

public class MainProgramm {
    public static void main(String[] args) {
        // Erstellung der Spielerkonfiguration per interface GameConfig
        GameConfig.PLAYER_SYMBOLS.put("Player 1", Symbol.X); // Füllung von HashMap
        GameConfig.PLAYER_SYMBOLS.put("Player 2", Symbol.O); // Füllung von HashMap

        // Erstellung der Spieler per interface Player
        Player player1 = new HumanPlayer("Player 1", Symbol.X); // Spielobjekt 1 ertsellt
        Player player2 = new ComputerPlayer("Player 2", Symbol.O); // Spielobjekt 2 ertsellt

        // Erstelle das Spielfeld
        Board board = new Board(); // 3x3-Array erst mit LEER gefüllt

        // Spiellogik
        Player currentPlayer = player1; // der Mensch fängt an zu spielen
        while (!board.isFull()) { // solange das Feld (Board) nicht gefüllt ist ( NOT(false) )... 
            board.printBoard(); // das Feld anzeigen/printen
            System.out.println("Aktueller Spieler: " + currentPlayer.getSymbol()); // Symbol (X oder O) anzeigen
         // Der aktuelle Spieler, führe einen Zug aus! 
            currentPlayer.makeMove(board); // besser: decideMove (board) Entscheidung

            // Prüfen ob 3 Symbole (X oder O) in der Reihe sind (Ob gewonnen)
            if (board.checkWin(currentPlayer.getSymbol())) { // checkWin(Symbol symbol) = true?
                board.printBoard(); // das Feld erneut anzeigen
                System.out.println("Spieler " + currentPlayer.getSymbol() + " hat gewonnen!"); // wer gewonnen
                return;
            }

            // Wechsle den aktuellen Spieler
            if (currentPlayer == player1) {
                currentPlayer = player2;
            } else {
                currentPlayer = player1;
            }
        }

        board.printBoard(); // das Feld anzeigen, wenn niemand gewonnen hat
        System.out.println("Unentschieden!");
    }
}
