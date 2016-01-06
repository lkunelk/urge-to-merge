package urgeToMerge;


import java.util.ArrayList;
import java.util.List;


/**
 * This class contains a number of static methods for generating,
 * analyzing, and solving instances of the game.
 * 
 * @author Andy Rock
**/
public class Brain
{
	//suppress constructor to ensure non-instantiability
	private Brain(){}


	/**
	 * Searches for a solution for the given Hand and target value.
	 * 
	 * <p>Implementation note: this problem is NP. This algorithm runs
	 * 2^n dynamic programming to efficiently find a solution. We consider
	 * the problem of finding all possible achievable values from a subset
	 * of the Cards in the given Hand. The base case is trivial, for example
	 * for the subset containing only a Jack, the only achievable value is 11.
	 * We can solve larger subsets by combining solutions to smaller subsets,
	 * for example we can combine (with +, *, -, /) every element attainable
	 * with a Jack with every element attainable with a 7 to find all elements
	 * attainable with a Jack and a 7. By building up these subproblems, we 
	 * eventually find all possible values attainable by using all the cards.
	 * If the target value is present in these values, we return the solution.
	 * To do this efficiently, we denote a subset of n elements as a binary
	 * string of length n, where a 1 at position i indicates the ith element is
	 * contained in the subset, and a 0 indicates it is not. We can interpret
	 * this binary string as an integer so that it may be used as an index.
	 * 
	 * @param hand the Hand to be solved
	 * @param target the goal value to achieve from the hand
	 * @return a String containing the solution, or 
	 *         "NO SOLUTION FOUND!", if a solution
	 *         does not exist.
	**/
	public static String solve(Hand hand, Integer target)
	{
		int[] values = hand.intValues();
		int n = values.length, len = 1 << n;

		List<List<Integer>> sols = new ArrayList<List<Integer>>();
		List<List< String>> txts = new ArrayList<List< String>>();
		for(int i=0;i<len;i++)
		{
			sols.add(new ArrayList<Integer>());
			txts.add(new ArrayList< String>());
		}

		for(int i=0;i<n;i++) // add base cases
		{
			sols.get(1 << i).add(values[i]);
			txts.get(1 << i).add(Integer.toString(values[i]));
		}

		for(int i=0;i<len;i++)
		{
			// we ignore multiple ways to get to the same value
			// for the sake of efficiency, we assume that no solution
			// ever has to exceed 1000
			boolean[] used = new boolean[1000];

			for(int j=i-1;j>0;j--)
				if((j^(i-j)) == i) // if (j) and (i-j) are subproblems of (i)
					for(int a=0;a<sols.get(j).size();a++)
						for(int b=0;b<sols.get(i-j).size();b++)
						{
							int     A = sols.get(  j).get(a);
							int     B = sols.get(i-j).get(b);
							String sA = txts.get(  j).get(a);
							String sB = txts.get(i-j).get(b);

							if(A+B < 1000 && !used[A+B]) // try addition
							{
								used[A+B] = true;
								sols.get(i).add(A+B);
								txts.get(i).add("("+sA+"+"+sB+")");
							}

							if(A*B < 1000 && !used[A*B]) // try multiplication
							{
								used[A*B] = true;
								sols.get(i).add(A*B);
								txts.get(i).add("("+sA+"*"+sB+")");
							}

							if(A-B >=0 && !used[A-B]) // try subtraction
							{
								used[A-B] = true;
								sols.get(i).add(A-B);
								txts.get(i).add("("+sA+"-"+sB+")");
							}

							if(B != 0 && A%B == 0 && !used[A/B]) // try division
							{
								used[A/B] = true;
								sols.get(i).add(A/B);
								txts.get(i).add("("+sA+"/"+sB+")");
							}
						}
		}

		for(int i=0;i<sols.get(len-1).size();i++)
			if(target.equals(sols.get(len-1).get(i)))
				return txts.get(len-1).get(i); // solution found

		return "NO SOLUTION FOUND!";           // solution not found
	}
}