package tictactoe;

import java.util.HashMap;

public interface GameConfig {

	final int BOARD_SIZE = 3; // Spielfeld-Größe
	// Zuordnung von Spielernamen zu Symbolen
	HashMap<String, Symbol> PLAYER_SYMBOLS = new HashMap<>();
}
