package urgeToMerge;


/**
 * This class represents an instance of a single card in the game.
 * 
 * @author Andy Rock
**/
public class Card
{
	// Suit and Rank of this Card cannot change
	private final Suit suit;
	private final Rank rank;


	enum Suit // the four suits: spades, diamonds, clubs, hearts
	{
		SPADES, DIAMONDS, CLUBS, HEARTS;
	}

	enum Rank // the thirteen ranks: Ace - King
	{
		ACE(1), TWO(2), THREE(3), FOUR(4), FIVE(5),
		SIX(6), SEVEN(7), EIGHT(8), NINE(9), TEN(10),
		JACK(11), QUEEN(12), KING(13);

		private final int val;
		Rank(int v)
		{
			val = v;
		}

		public int getValue()
		{
			return val;
		}
	}


	/**
	 * Produces a Card with the specified Suit and Rank.
	 * 
	 * @param s the Suit this Card will take on.
	 * @param r the Rank this Card will take on.
	**/
	Card(Suit s, Rank r)
	{
		suit = s;
		rank = r;
	}


	/**
	 * Produces the value of this card, defined as follows:
	 * Ace   - 1
	 * Two   - 2
	 * Three - 3
	 * Four  - 4
	 * Five  - 5
	 * Six   - 6
	 * Seven - 7
	 * Eight - 8
	 * Nine  - 9
	 * Ten   - 10
	 * Jack  - 11
	 * Queen - 12
	 * King  - 13
	 * 
	 * @return the value of this Card.
	**/
	public int getValue()
	{
		return rank.getValue();
	}


	/**
	 * Returns a String representation of this Card.
	 * The format of the returned String is "RANK of SUIT",
	 * for example, "ACE of SPADES".
	 * 
	 * @return a String representation of this Card.
	 * <dt><strong>Overrides:</strong></dt> toString in class Object
	**/
	@Override
	public String toString()
	{
		return rank + " of " + suit;
	}
}