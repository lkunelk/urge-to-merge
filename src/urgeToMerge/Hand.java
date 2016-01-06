package urgeToMerge;


import java.util.ArrayList;


/**
 * This class represents an instance of a Hand in the game.
 * 
 * @author Andy Rock
**/
public class Hand extends ArrayList<Card>
{
	private static final long serialVersionUID = 1151418111673482558L;


	/**
	 * Produces an array of integers representing the values of the
	 * Cards in this Hand.
	 * 
	 * @return an int[] containing the values of the Cards in this Hand
	**/
	public int[] intValues()
	{
		int[] vals = new int[size()];
		for(int i=0;i<vals.length;i++)
			vals[i] = get(i).getValue();

		return vals;
	}
}