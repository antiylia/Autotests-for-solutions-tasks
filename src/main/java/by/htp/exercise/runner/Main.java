package by.htp.exercise.runner;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;

import by.htp.exercise.FirstTask;

public class Main {

	public static void main(String[] args) {
		/*
		 1- Write code to filter duplicate elements from an array and print as a list?  
		*/
		List<Integer> listElements = new ArrayList<Integer>();
		listElements.add(20);
		listElements.add(23);
		listElements.add(25);
		listElements.add(23);
		listElements.add(25);
		listElements.add(28);
		listElements.add(28);
		listElements.add(29);
		
		FirstTask ob = new FirstTask();
		
		Set<Integer> filtered = ob.filterList(listElements);
		System.out.println(filtered);
		
		/*	
		2- Write code to sort the list of strings using Java collection?  
		*/		
		String[] inputList = { "Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul",
				"aug", "Sep", "Oct", "nov", "Dec" };
		List<String> unsortedlist = Arrays.asList(inputList);
		List<String> sortedlist = ob.sortString(unsortedlist);
		System.out.println(sortedlist);
		/*		
		  3- Write a function to reverse a number in Java?	 
		*/
		long result = ob.doInvert (356647887L);
		System.out.println(result);
		/*
		 * 5- Write a Java program to find out the first two max values from an array?
		 */
	//	Integer [] arrayInt = listElements.toArray(new Integer [listElements.size()]);
		int array [] = {20, 32, 44, 65, 800, 99, -800};		
		array = ob.getTwoMaxValues(array);
		for (int a: array) {
		System.out.print(a + " ");
		}
		
		System.out.println("\n" + ob.getSubStringWithoutDublicates("giuiuuhh") );
		
		System.out.println(ob.editStringFromMultipleSpaces("      jnmn  nkj   kjkjkj  l mm ") );
		
		System.out.println(ob.checkPalidromOrNot (20200202));
		
		ob.swapWithoutTemp (2, 6);
	}

}
