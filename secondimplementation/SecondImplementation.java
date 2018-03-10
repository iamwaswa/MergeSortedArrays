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

		boolean isMerged = mergeWhenEitherArrayIsEmpty(first, second, merged);

		if (!isMerged) {

			for (int resultIndex = 0; resultIndex < merged.length; resultIndex++) {

				if (firstIndex >= first.length){
					merged[resultIndex] = second[secondIndex];
					secondIndex++;
					continue;
				}

				if (secondIndex >= second.length){
					merged[resultIndex] = first[firstIndex];
					firstIndex++;
					continue;
				}

				if (first[firstIndex] <= second[secondIndex]) {
					merged[resultIndex] = first[firstIndex];
					firstIndex++;
				} else {
					merged[resultIndex] = second[secondIndex];
					secondIndex++;
				}

			}

		}

		return mergedArrayAsString(merged);

	}

	private static boolean mergeWhenEitherArrayIsEmpty(int[] first, int[] second, int[] merged) {

		boolean arrayIsMerged = false;

		if (first.length == 0 || second.length == 0){

			if (first.length == 0) {
				caseWhereOneListIsEmpty(merged, second);
			} else {
				caseWhereOneListIsEmpty(merged, first);
			}
			arrayIsMerged = true;

		}

		return arrayIsMerged;

	}

	private static void caseWhereOneListIsEmpty(int[] arrayToFill, int[] nonEmptyArray){

		for (int i = 0; i < nonEmptyArray.length; i++){
			arrayToFill[i] = nonEmptyArray[i];
		}

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
