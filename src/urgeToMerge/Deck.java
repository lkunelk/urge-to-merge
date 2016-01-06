package urgeToMerge;


import java.util.Collections;
import java.util.Stack;


/**
 * This class represents an instance of a deck of 52 Card
 * objects in the game. Deck is represented as a Stack of
 * Card objects, and contains methods to manipulate the deck.
 * 
 * @author Andy Rock
**/
public class Deck extends Stack<Card>
{
	public final static int ORDERED = 0, SHUFFLED = 1; // possible initial states

	private static final long serialVersionUID = -2337981998826896346L;
 

	/**
	 * Constructs a Deck with the 52 cards in default order. The default
	 * order is Spades A-K, Diamonds A-K, Clubs A-K, Hearts A-K. 
	**/
	Deck()
	{
		this(ORDERED);
	}

	/**
	 * Constructs a Deck with the 52 cards in the order specified by the
	 * state parameter.
	 * 
	 * @param state one of Deck.ORDERED, Deck.SHUFFLED, representing what
	 *        initial state of the Cards in the Deck should be.
	 * @throws IllegalArgumentException - if the given parameter is not
	 *         one of Deck.ORDERED, Deck.SHUFFLED.
	**/
	Deck(int state)
	{
		switch(state)
		{
			case ORDERED:
				reset();
				break;

			case SHUFFLED:
				reset();
				shuffle();
				break;

			default:
				throw new IllegalArgumentException("state must be one of: Deck.ORDERED, Deck.SHUFFLED");
		}
	}


	/**
	 * Clears all Cards from the Deck, and restores it to
	 * the default ordering.
	**/
	private void reset()
	{
		clear();

		for(Card.Suit ss : Card.Suit.values())     // loop through suits
			for(Card.Rank rs : Card.Rank.values()) // loop through Ace - King
				push(new Card(ss, rs));
	}


	/**
	 * Puts the Cards in the Deck in random order.
	**/
	public void shuffle()
	{
		Collections.shuffle(this);
	}


	/**
	 * Constructs a new Hand and from the top of the Deck,
	 * deals to it the specified number of Cards.
	 * 
	 * @param handSize the number of Cards to be dealt to the Hand.
	 * @return a Hand containing the Cards that were dealt to it.
	**/
	public Hand dealHand(int handSize)
	{
		Hand hand = new Hand();
		while(handSize --> 0)
			dealCard(hand);

		return hand;
	}


	/**
	 * Deals the Card from the top of the Deck to the specified Hand.
	 * 
	 * @param hand the Hand the Card should be dealt to.
	**/
	public void dealCard(Hand hand)
	{
		hand.add(pop());
	}


	/**
	 * Returns a String representation of this Deck.
	 * Returned String is of the form [c_1, c_2, ... c_n]
	 * where each Card c_i is represented as defined by
	 * the toString() method in the Card class.
	 * 
	 * @return a String representation of this Deck.
	 * <dt><strong>Overrides:</strong></dt> toString in class Vector
	**/
	@Override
	public String toString()
	{
		String ans = "[";
		for(Card c : this)
			ans += (c + ", ");
		ans += "]";

		return ans;
	}
}