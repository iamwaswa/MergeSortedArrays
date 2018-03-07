package testfortheweek.weekone.firstimplementation;

/**
 * FirstImplementation is a class that takes care of sorting
 * two sorted arrays of integers
 * into one sorted array of integers
 * Time complexity: O(N)
 * Space complexity: O(N)
 */
public class FirstImplementation {
	public static void main (String[] args){
		int[] myArray     = new int[]{3, 4, 6, 10, 11, 15};
		int[] otherArray = new int[]{1, 5, 8, 12, 14, 19};

		System.out.println(mergeArrays(myArray, otherArray));
	}

	private static String mergeArrays(int[] myArray, int[] otherArray){
		int[] resultArray = new int[myArray.length + otherArray.length];
		for (int i = 0, j = 0, k = 0; i < resultArray.length; i++){
			if (j < myArray.length && myArray[j] <= otherArray[k]){
				resultArray[i] = myArray[j];
				j++;
			} else {
				resultArray[i] = otherArray[k];
				k++;
			}
		}
		return resultArrayAsString(resultArray);
	}

	private static String resultArrayAsString(int[] resultArray){
		String result = "[";
		int lastEntryIndex = resultArray.length - 1;
		for (int i = 0; i < resultArray.length; i++){
			result += Integer.toString(resultArray[i]);
			if (i != lastEntryIndex) {
				result += ", ";
			}
		}
		result += "]";
		return  result;
	}
}
