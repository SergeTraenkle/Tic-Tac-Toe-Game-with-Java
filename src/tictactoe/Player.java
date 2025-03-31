package tictactoe;

public interface Player {
	Symbol getSymbol(); // Gibt das Symbol des Spielers zurück
	void makeMove(Board board); // Führt einen Spielzug aus. // besser: decideMove
	boolean isHuman(); // Gibt an, ob der Spieler menschlich ist
}
