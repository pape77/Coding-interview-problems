package stack.problems;

import java.util.Stack;

public class SortStack {
	
	public static Stack<Integer> sort(Stack<Integer> s) {
		Stack<Integer> s2 = new Stack<Integer>();
		while (!s.isEmpty()) {
			Integer last = s.pop();
			s2.push(last);
			while (!s.isEmpty() && s.peek() < last) {
				s2.push(s.pop());
				last = s2.peek();
			}
			if (s.isEmpty()) {
				return s2;
			} else {
				last = s.pop();
				while (!s2.isEmpty()) {
					s.push(s2.pop());
				}
				s.push(last);
			}
		}
		return s2;
	}

	
	public static void main(String[] args) {
		Stack<Integer> s = new Stack<Integer>();
		s.push(5);
		s.push(7);
		s.push(8);
		s.push(3);
		s.push(6);
		s.push(2);
		
		System.out.println("pre S:[");
		for (Integer i : s) {
			System.out.println(i);
		}
		System.out.println("]");
		
		Stack<Integer> s2 = SortStack.sort(s);
		
		System.out.println("pos S:[");
		for (Integer i : s2) {
			System.out.println(i);
		}
		System.out.println("]");
	}
}
