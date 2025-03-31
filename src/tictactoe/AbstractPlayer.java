package tictactoe;

public abstract class AbstractPlayer implements Player {
	protected String name;   // Name des Spielers: Player 1 oder Player 2
	protected Symbol symbol; // Symbol des Spielers: X oder O

	// Konstruktor
	public AbstractPlayer(Symbol symbol, String name) {
		this.name = name;
		this.symbol = symbol;
	}
	
	@Override
	public Symbol getSymbol() {
		return symbol;  // An der Stelle symbol = this.symbol
	}
	
	public abstract boolean isHuman();
}
