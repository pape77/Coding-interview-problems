package stack.problems;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class SetOfStacks{
	
	private List<Stack<Integer>> stacks;
	private int threshold;
	
	public SetOfStacks(Integer t){
		this.threshold = t;
		this.stacks = new ArrayList<Stack<Integer>>();
		stacks.add(new Stack<Integer>());
	}
	public void push(Integer e){
		if(stacks.get(stacks.size()-1).size() == threshold){
			stacks.add(new Stack<Integer>());	
		}
		stacks.get(stacks.size()-1).push(e);
	}

	public Integer pop(){
		Integer top;
		top = stacks.get(stacks.size()-1).pop();
		if(stacks.get(stacks.size()-1).isEmpty()){	
			stacks.remove(stacks.size()-1);
		}
		return top;
	}

	public Integer popAt(int stackIndex){
		if(stacks.size() < stackIndex){return -1;} 
		Stack<Integer> stackFromWhichToPop =stacks.get(stackIndex);
		return	stackFromWhichToPop.pop();
	}
	
	public static void main(String args[]){
		SetOfStacks sos = new SetOfStacks(3);
		sos.push(1);
		sos.push(2);
		sos.push(3);
		sos.push(4);
		sos.push(5);
		System.out.println(sos.popAt(0)); //3
		System.out.println(sos.pop()); //5
		System.out.println(sos.pop());//4
		System.out.println(sos.pop());//2
		System.out.println(sos.pop());//1
	}
}