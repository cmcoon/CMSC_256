package cmsc256;

/*
*	Programmer #1: Caitlyn Dela Cruz 
*	Programmer #2: Colin Coon
*/

public class RecursiveMethods {
	public static void main(String[] args) {
		System.out.println(buildStringOfCharacters('x', 5));
		
		int[] nums = {30, 55, 12, 34, 16, 29, 1, 2, 54, 23};
		nums = reverseNumArray(nums, 9);
		
		for(int i = 0; i < nums.length; i++) {
			System.out.print(" " + nums[i]);
		}
		
		int[] nums2 = {1, 2, 3, 4, 5, 6, 7};
		int[] nums3 = {1, 2, 3, 10, 5, 6, 7};
		
		System.out.println(isSmallestToLargest(nums2, 0));
		System.out.println(isSmallestToLargest(nums3, 0));
		
		String name = "tacocat";
		System.out.println(isPalindrome(name, 0, 6));
		
		String name2 = "colin";
		System.out.println(isPalindrome(name2, 0, 4));
		
		String name3 = "naan";
		System.out.println(isPalindrome(name3, 0, 3));
		
	}
	
	/* 
	 * @returns a String of character, ch. The length is determined
	 * 			by the second parameter, length.
	 */
	public static String buildStringOfCharacters(char ch, int length) {
		if(length == 0) {
			return "";
		}
		
		if(length == 1) {
			return Character.toString(ch);
		}
		
		return ch + buildStringOfCharacters(ch, length - 1);
	}
	
	/*
	 * returns an int array that has the elements in reverse order
	 * 			of the parameter array, nums. 
	 * Process this recursively beginning with the last element.
	 */
	public static int[] reverseNumArray(int[] nums, int backIndex) {
		if(nums.length/2 == backIndex) {
			return nums;
		}
		
		int temp = nums[backIndex];
		nums[backIndex] = nums[nums.length - backIndex -1];
		nums[nums.length - backIndex -1] = temp;		
		
		return reverseNumArray(nums, backIndex - 1);
	}
	
	/*
	 * returns true if the int array parameter is sorted from smallest
	 * 			to largest, false otherwise.
	 * Process this recursively beginning with the first element.
	 */
	public static boolean isSmallestToLargest(int[] values, int firstIndex) {
		if(firstIndex == values.length - 2) {
			return true;
		}
		
		if(values[firstIndex] < values[firstIndex + 1] || values[firstIndex] == values[firstIndex + 1]) {
			return isSmallestToLargest(values, firstIndex + 1);
		}
		
		return false;
	}
	
	/* 
	 * @returns true if the parameter String, str is a palindrome
	 * 			false otherwise
	 */
	public static boolean isPalindrome(String str, int begin, int end) {
		if(begin >= end) {
			return true;
		}
		
		if(str.charAt(begin) == str.charAt(end)) {
			return isPalindrome(str, begin + 1, end -1);
		}
		
		return false;
	}
}