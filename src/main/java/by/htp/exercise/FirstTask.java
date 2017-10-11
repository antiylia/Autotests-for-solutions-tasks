package by.htp.exercise;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class FirstTask {

	/*
	 * 1- Write code to filter duplicate elements from an array and print as a list?
	 */
	public Set<Integer> filterList(List<Integer> listElements) {
		if (listElements == null) {
			throw new IllegalArgumentException("Uncorrect argument");
		}
		final Set<Integer> filtered = new HashSet<Integer>();

		Iterator<Integer> it = listElements.iterator();
		while (it.hasNext()) {
			Integer element = (Integer) it.next();
			filtered.add(element);
		}
		return filtered;
	}

	/*
	 * 2- Write code to sort the list of strings using Java collection?
	 */

	public List<String> sortString(List<String> list) {
		if (list == null) {
			throw new IllegalArgumentException("Uncorrect argument");
		}
		Set<String> sorted = new TreeSet<String>(new Comparator<String>() {
			public int compare(String a, String b) {
				return a.compareToIgnoreCase(b);
			}
		});
		Iterator<String> it = list.iterator();
		while (it.hasNext()) {
			String element = (String) it.next();
			sorted.add(element);
		}
		return new ArrayList<String>(sorted);
	}

	/*
	 * 3- Write a function to reverse a number in Java?
	 */
	public long doInvert(long number) {

		long invert = 0;
		while (number != 0) {
			invert = (invert * 10) + (number % 10);
			number = number / 10;
		}
		return invert;
	}	
	
	/*
	 * 4- Write a method to check prime no. in Java?
	 */

	/*
	 * 5- Write a Java program to find out the first two max values from an array?
	 */
	public int[] getTwoMaxValues(int[] nums) {
		int firstMax = nums[0];
		int secondMax = 0;
		for (int i = 0; i < nums.length; i++) {
			if (firstMax < nums[i]) {
				secondMax = firstMax;
				firstMax = nums[i];
			} else if (secondMax < nums[i]) {
				secondMax = nums[i];
			}
		}
		int resultarr[] = { firstMax, secondMax };
		return resultarr;
	}	
	 /*
	 * 6- Write a Java program to find the longest substring from a given string  which doesn't contain any duplicate characters? 
	 */

	public String getSubStringWithoutDublicates (String str) {
		if (str == null || str.isEmpty()) {
			throw new IllegalArgumentException("Uncorrect argument");
		}
		    int longestStart = 0;
	        int longestEnd = 0;

	        for (int mid = 0; mid <  str.length(); mid++) {           
	            int left = mid-1;
	            int right = mid+1;
	           
	            while (left >= 0 && right < str.length() ) {
	                if (checkDublicates (str.substring(left, right+1))) {
	                    if (right - left > longestEnd - longestStart) {
	                        longestStart = left;
	                        longestEnd = right;
	                    }
	                } else { break; }
	                left--;
	                right++;
	            }
	        }
	  return str.substring(longestStart, longestEnd+1);     
	}
	
	
		private boolean checkDublicates (String str) {
			boolean check = true;			
			for (int i=0; i<str.length(); i++) {
				String letter = new Character(str.charAt(i)).toString();
				if (str.substring(i+1).contains(letter) ) {
					check = false;
					return check;
			  }	
			}
				return check;
		}
		
		/*
		  7- Write Java code to get rid of multiple spaces from a string?	
		*/
		
     public String editStringFromMultipleSpaces (String str) {
	   String tempArray [] = str.split(" ");
	   StringBuilder newString = new StringBuilder();
	   for (String a: tempArray) {
		   if (!a.isEmpty()) {
		   newString.append(a.trim() + " ");
		   }
	   }
	   return new String (newString);
     }
	
	 /* 8- Write Java code to identify a number as Palindrome? */

     public boolean checkPalidromOrNot (int number) {
    	 String strInt = new Integer(number).toString();
		 StringBuilder builder = new StringBuilder(strInt);
		 StringBuilder builderReversed = builder.reverse();
		 
		 if (builder.equals(builderReversed)) {
			return true;
		 } else {
			 return false;
		 }		 
	}
     /*9- Write Java code to swap two numbers without using a temporary variable? */ 
     
     public void swapWithoutTemp (int a, int b) {
    	 System.out.println("before swaping - a " + a);
    	 System.out.println("before swaping - b " + b);
    	 a = a + b;
    	 b = a - b;
    	 a = a - b;
    	 System.out.println("after swaping - a " + a);
    	 System.out.println("after swaping - b " + b);
     }     
     
	 /* 10- Write a Java program to demonstrate string reverse with and without StringBuffer class? */

}
