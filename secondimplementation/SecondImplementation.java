/**
 * SecondImplementation is a class that takes care of sorting
 * two sorted arrays of integers
 * into one sorted array of integers
 *
 * Time complexity: O(N)
 * Space complexity: O(N)
 */

public class SecondImplementation {
	public static void main (String[] args){

		int[] first = new int[]{3, 4, 6, 10, 11, 15};
		int[] second = new int[]{1, 5, 8, 12, 14, 19};

		String output = mergeArrays(first, second);
		System.out.println(output);

	}

	private static String mergeArrays(int[] first, int[] second){

		int[] merged = new int[first.length + second.length];

		int firstIndex = 0;
		int secondIndex = 0;

		for (int resultIndex = 0; resultIndex < merged.length; resultIndex++){

			if (firstIndex < first.length && first[firstIndex] <= second[secondIndex]){

				merged[resultIndex] = first[firstIndex];
				firstIndex++;

			} else {

				merged[resultIndex] = second[secondIndex];
				secondIndex++;

			}

		}
		
		return mergedArrayAsString(merged);

	}

	private static String mergedArrayAsString(int[] merged){

		String result = "";
		int lastEntryIndex = merged.length - 1;

		for (int i = 0; i < merged.length; i++){

			result += Integer.toString(merged[i]);

			if (i != lastEntryIndex) {
				result += ", ";
			}

		}

		result = "[" + result + "]";

		return  result;

	}
}
