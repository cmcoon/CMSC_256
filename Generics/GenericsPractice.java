import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Scanner;

/**
 * Practice using java Generics.
 * 
 * @author ccoon
 *
 */

public class Generics {

	public static void main(String[] args){
		// TODO Auto-generated method stub
		
		Integer number1 = new Integer(12);
		
		//System.out.println(number1.compareTo(new Double(12.0)));
		
		if(number1 instanceof Integer) {
			System.out.println("These are same type of object");
		}
		
		// Can check if a class is an instance of itself or super class, not other subclasses though
		// Weird because it seems like you can't determine if its a different class
		if(number1 instanceof Number) {
			System.out.println("These are same type of object");
		}
		
		
		// Can cast an object to superclass type if needed
		Number number2 = (Number) number1;
		System.out.println(number2.toString());
		
		
		try {
			// Cannot compare wrapped object of different type however can use intValue() for specific primitive type
			// Also interesting is that issues with these are compile errors not runtime errors
			System.out.println(number1.compareTo(new Double(12.0).intValue()));
		}catch(Exception o) {
			System.out.println("Invalid argument");
		}
		
		System.out.println(number1);
		
		ArrayList<Object> arr = new ArrayList<>();
		arr.add(new String("Hello"));
		arr.add(new Integer("12"));
		arr.add(new BigDecimal(123456789.123456789902304234));
		
		for(Object x: arr) {
			System.out.println(x.toString());
		}
		
		ArrayList<String> arr2 = new ArrayList<>();
		arr2.add(new String("Hello"));
		arr2.add(new Integer("12").toString());
		arr2.add(new BigDecimal(123456789.123456789902304234).toString());
		
		for(Object x: arr) {
			System.out.println(x.toString());
		}
		
		// .remove takes index
		arr.remove(2);
		System.out.println("Removed a very long number");
		for(Object x: arr) {
			System.out.println(x.toString());
		}
		
		Collection<String> arr3 = new ArrayList<>();
		arr3.add("Maryland");
		arr3.add("Virginia");
		arr3.add("Colorado");
		
		// Collection class implements iterator class, create iterator object using iterator method
		// Then can use iterator methods for that specific iterator class belonging to specific collection class
		Iterator<String> iterator = arr3.iterator();
		while(iterator.hasNext()) {
			System.out.println(iterator.next());
		}
		
		System.out.println();
		
		// Linked list allows another list in constructor argument
		LinkedList<String> llist = new LinkedList<>(arr3);
		
		// but can only access front and end of linked list
		System.out.println(llist);
		
		llist.addAll(arr3);
		llist.add("Carolina");
		
		System.out.println(llist);
		
		llist.addFirst("California");
		llist.removeLast();
		
		System.out.println(llist);
		
		// USe a listIterator object to mess with linked list, remeber linked list is implemented by list but object creation required
		ListIterator<String> iterator2 = llist.listIterator();
		
		System.out.println();
		while(iterator2.hasNext()) {
			System.out.println(iterator2.next());
		}
		
		// Basically using generic arrayList to stroe different object types resulting in 2D array type thing
		// Can mess around with an iterator if desired
		ArrayList<Object> diverseList = new ArrayList<>();
		ArrayList<String> stringList = new ArrayList<>();
		ArrayList<Integer> intList = new ArrayList<>();
		ArrayList<Character> characterList = new ArrayList<>();
		
		stringList.addAll(llist);
		System.out.println(stringList);
		
		for(int i = 0; i < 10; i++) {
			intList.add(i);
		}
		
		characterList.add('a');
		characterList.add('b');
		characterList.add('c');
		characterList.add('d');
		characterList.add('e');
		
		diverseList.add(stringList);
		diverseList.add(intList);
		diverseList.add(characterList);
		
		System.out.println(diverseList);
	}
}
