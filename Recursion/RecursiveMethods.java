/*
*	Collection of recursive methods, partially from class lab activity, mostly from CodingBat
*	Colin Coon
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
	
	// Recursively display an array
	public static void displayArray(int[] array, int first, int last) {
		System.out.print(array[first] + " ");
		if (first < last)
			displayArray(array, first + 1, last);
		}

	// Method is similar to previous one just does reverse stack like recursion
	public static void displayArrayFromEnd(int[] array, int first, int last) {
		if (first <= last){
			displayArray(array, first, last - 1);
		System.out.print(array[last] + " ");
		}
	}

	// Display array recursively from the middle
	public static void displayArrayBaseCase(int array[], int first, int last) {
		if (first == last)
			System.out.print(array[first] + " ");
		else {
			int mid = (first + last)/2;
			System.out.println("Mid is" + mid);
			displayArray(array, first, mid);
			displayArray(array, mid + 1, last);
		}
	}

	// Standard linear search
	public static int linearSearch(int[] arr, int key) {
		for(int i = 0; i < arr.length; i++) {
			if(arr[i] == key) {
				return i;
			}
		}
		return -1;
	}

	//We have a number of bunnies and each bunny has two big floppy ears.
	//We want to compute the total number of ears across all the bunnies recursively (without loops or multiplication).
	public static int bunnyEars(int bunnies) {
		if(bunnies == 0){
			return 0;
		}else{
			return 2 + bunnyEars(bunnies - 1);
		}
		}

	// Recursive Fibbonocci sequence is the sum of each to preceding numbers
	public static int fib(int n) { 
		if (n <= 1) 
			return n; 
    
		return fib(n-1) + fib(n-2); 
	} 

	// We have bunnies standing in a line, numbered 1, 2, ... The odd bunnies (1, 3, ..) have the normal 2 ears. 
	// The even bunnies (2, 4, ..) we'll say have 3 ears, because they each have a raised foot. 
	// Recursively return the number of "ears" in the bunny line 1, 2, ... n (without loops or multiplication).
	public static int bunnyEars2(int bunnies) {
		if(bunnies == 0){
			return bunnies;
		}else if(bunnies % 2 == 0){
			return 3 + bunnyEars2(bunnies - 1);
		}else{
			return 2 + bunnyEars2(bunnies - 1);
		}
	}
 
	// We have triangle made of blocks. The topmost row has 1 block, the next row down has 2 blocks, the next row has 3 blocks, and so on. 
	// Compute recursively (no loops or multiplication) the total number of blocks in such a triangle with the given number of rows.
	public static int triangle(int rows) {
		if(rows <= 1){
			return rows;
		}else{
			return rows + triangle(rows - 1);
		}
	}

	 // Given a non-negative int n, compute recursively (no loops) the count of the occurrences of 8 as a digit, 
	 // except that an 8 with another 8 immediately to its left counts double, so 8818 yields 4. Note that mod (%)
	 // by 10 yields the rightmost digit (126 % 10 is 6), while divide (/) by 10 removes the rightmost digit (126 / 10 is 12).
	public int count8(int n) {
		if(n == 0){
			return 0;
		}
	  
		if(n % 10 == 8){
			if((n/10) % 10 == 8){
				return 2 + count8(n / 10);
			}
	    return 1 + count8(n / 10);
		}
		
		return count8(n / 10); 
	}

	// Given a string, compute recursively (no loops) the number of lowercase 'x' chars in the string.
	public int countX(String str) {
		if(str.length() == 0){
			return 0;
		}
	  
		if(str.charAt(0) == 'x'){
			return 1 + countX(str.substring(1,str.length()));
		}else{
			return 0 + countX(str.substring(1, str.length()));
		}
	}

	// Same thing as countX but with the word hi
	public int countHi(String str) {
		if(str.length() <= 1){
			return 0;
		}
	  
		if(str.charAt(0) == 'h' && str.charAt(1) == 'i'){
			return 1 + countHi(str.substring(1,str.length()));
		}else{
			return 0 + countHi(str.substring(1, str.length()));
		}
	}

	// Returns true if there is a six in the array and false otherwise recursively
	public boolean array6(int[] nums, int index) {
		if(index == nums.length){
			return false;
		}
	  
		if(nums[index] == 6){
			return true;
		}else{
			return array6(nums, index + 1);
		} 
	}

	// Recursively count how many time 11 appears in array
	public int array11(int[] nums, int index) {
		if(index == nums.length){
			return 0;
		}
	  
		if(nums[index] == 11){
			return 1 + array11(nums, index + 1);
		}else{
			return 0 + array11(nums, index + 1);
		}
	}

	
	 // returns an int array that has the elements in reverse order
	 //			of the parameter array, nums. 
	 // Process this recursively beginning with the last element.
	public static int[] reverseNumArray(int[] nums, int backIndex) {
		if(nums.length/2 == backIndex) {
			return nums;
		}
		
		int temp = nums[backIndex];
		nums[backIndex] = nums[nums.length - backIndex -1];
		nums[nums.length - backIndex -1] = temp;		
		
		return reverseNumArray(nums, backIndex - 1);
	}
	
	
	 // returns true if the int array parameter is sorted from smallest
	 // 			to largest, false otherwise.
	 // Process this recursively beginning with the first element.
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
	
	// Recursive exponent
	public int powerN(int base, int n) {
		  if(n == 1){
		    return base;
		  }else{
		    return base * powerN(base, n-1);
		  }
	}
	
	// Given an array of ints, compute recursively if the array contains somewhere a value followed in the array 
	// by that value times 10. We'll use the convention of considering only the part of the array that begins at 
	// the given index. In this way, a recursive call can pass index+1 to move down the array. The initial call 
	// will pass in index as 0.
	public boolean array220(int[] nums, int index) {
		if(nums.length == 0){
			return false;
		}
		  
		if(index == nums.length - 1){
			return false;
		}else if(nums[index]*10 == nums[index+1]){
		    return true;
		}else{
		    return array220(nums, index+1);
		}
	}
	
	// Given a string, compute recursively a new string where all the adjacent chars are now separated by a "*".
	public String allStar(String str) {
		if(str.length() <= 1){
			return str;
		}else{
		    return "" + str.charAt(0) + "*" + allStar(str.substring(1, str.length()));
		}
	}
}