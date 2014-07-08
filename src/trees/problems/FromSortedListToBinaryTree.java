package trees.problems;


import java.util.ArrayList;
import java.util.List;

public class FromSortedListToBinaryTree {
	
	public static Node toBinTree(List<Integer> inputElements) {
		if(inputElements.isEmpty()){
			return null;
		}else if(inputElements.size()==1){ 
			Node root = new Node(); 
			root.setValue(inputElements.get(0));
			return root;
		}
		else{
		Node root = new Node();
		Integer rootElementIndex = inputElements.size()/2;
		root.setValue(inputElements.get(rootElementIndex));
		
		List<Integer> firstHalf = inputElements.subList(0, rootElementIndex);
		List<Integer> secondHalf = inputElements.subList(rootElementIndex + 1, inputElements.size());
		
		root.setLeftNode(toBinTree(firstHalf));
		root.setRightNode(toBinTree(secondHalf));
		
		return root;
		}
	}
	
	public static void main(String[] args) {

		List<Integer> inputList = new ArrayList<Integer>();
		inputList.add(9);
		inputList.add(12);
		inputList.add(14);
		inputList.add(17);
		inputList.add(19);
		inputList.add(23);
		inputList.add(50);
		inputList.add(54);
		inputList.add(67);
		inputList.add(72);
		inputList.add(76);
		//[9,12,14,17,19,23,50,54,67,72,76]
		@SuppressWarnings("unused")
		Node rootOfMyTree = toBinTree(inputList);
	}
}


