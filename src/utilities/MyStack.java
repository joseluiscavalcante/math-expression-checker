package utilities;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

import exception.EmptyException;

public class MyStack <T> {
	private List<T> stack;
	
	public MyStack() {
		stack = new ArrayList<T>();
	}
	
	public int size() {
		return stack.size();
	}
	
	public void push(T element) {
		stack.add(element);
	}
	
	public T getTop(){
		if(isEmpty()) {
			throw new EmptyException();
		}
		return stack.get(size() - 1);
	}
	
	public T pop() {
		if(isEmpty()) {
			throw new EmptyException();
		}
		return stack.remove(size() - 1);
	}
	
	public boolean isEmpty() {
		return stack.isEmpty();
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		ListIterator<T> reverseList = stack.listIterator(stack.size());
		
		int i = 0;
		while (reverseList.hasPrevious()) {
			i++;
		    T element = reverseList.previous();
		    sb.append(String.format("[%dº] %s%n", i, element.toString()));
		}
		
		String finalStr = sb.toString();
		return finalStr;
	}
}
