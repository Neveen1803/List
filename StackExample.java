package StackExample;

import java.util.Arrays;
//10, 12, 5, 6, 7, 9, 11, 13

public class StackExample {
	public static void main(String[] args) {
		Stack <String>myFirstStack = new Stack<String>();
		myFirstStack.push("Neveen");
		myFirstStack.push("Dhnau");
		myFirstStack.push("Obadiah");
		myFirstStack.push("Bala");
		System.out.println(myFirstStack);
		myFirstStack.pop();
		System.out.println(myFirstStack);
		System.out.println(myFirstStack.get(0));
	}
	
}
class Stack<T>{
	private T[] myElements;
	private int lengthOfTheStack;
	
	public Stack() {
		myElements = (T[])new Object[0];
		lengthOfTheStack = 0;
	}
	
	public void push(T elem) {
		myElements = Arrays.copyOf(myElements, lengthOfTheStack+1);
		myElements[myElements.length-1] = elem;
		this.lengthOfTheStack = myElements.length;
	}
	
	public T pop() {
		myElements=Arrays.copyOfRange(myElements, 0, lengthOfTheStack-1);
		lengthOfTheStack-=1;
		return myElements[myElements.length-1];
	}
	
	public T get(int index) {
		return myElements[index];
	}
	
	public int getLengthOfTheStack() {
		return lengthOfTheStack;
	}
	public String toString() {
		StringBuffer elements = new StringBuffer();
		for(int i=0;i<myElements.length; i++) {
			elements = elements.append(myElements[i]).append(", ");
		}
		return elements.toString();
	}
}
