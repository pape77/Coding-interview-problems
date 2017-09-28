package bfs;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import bfs.Node;

public class BreadthFirstSearch {

	public static void bfs(List<List<Integer>> graph) {
		List<Integer> queue = new ArrayList<Integer>();
		queue.add(0);
		while (queue.size() != 0) {
			int node = queue.get(0);
			System.out.println(node);
			queue.remove(0);
			List<Integer> neighbours = graph.get(node);
			for (Integer neighbour : neighbours) {
				// if the graph has cycles we must check for visited nodes before adding them
				queue.add(neighbour);
			}
		}
	}
	
     
	public static void rightSidedfs(List<List<Integer>> graph){
		
		Stack<Integer> stack = new Stack<Integer>();
		stack.push(0);
		while(stack.size() != 0){
			int node = stack.pop();
			System.out.println(node);
			List<Integer> neighbours= new ArrayList<Integer>();
			neighbours = graph.get(node);
			for(Integer neighbour : neighbours){
				stack.push(neighbour);
			}
		}
	}
		
		public static void leftSidedfs(List<List<Integer>> graph){
			
			Stack<Integer> stack = new Stack<Integer>();
			stack.push(0);
			while(stack.size() != 0){
				int node = stack.pop();
				System.out.println(node);
				List<Integer> neighbours = graph.get(node);
				while(neighbours.size() != 0){
					stack.push(neighbours.get(neighbours.size()-1));
					neighbours.remove(neighbours.size()-1);
				}
				
			}
		}
		
		public static void DFSWithNode(Node node) {
			
			System.out.println(node.name);
			node.visited = true;
			
			Stack<Node> stack = new Stack<Node>();
			for(Node neighbour : node.neighbours)
			{
				stack.push(neighbour);
			}
				
			while(stack.size() != 0) {
				Node currentNode = stack.pop();
				
				if(!currentNode.visited) {
					System.out.println(currentNode.name);
					currentNode.visited = true;

					for(Node neighbour : currentNode.neighbours)
					{
						stack.push(neighbour);
					}
				}
			}		
		}
		
		
	
	public static void main(String[] args) {
		
		List<List<Integer>> graph = new ArrayList<List<Integer>>();
		List<Integer> node1neighbours = new ArrayList<Integer>();
		node1neighbours.add(1); node1neighbours.add(2);
		List<Integer> node2neighbours = new ArrayList<>();
		node2neighbours.add(3);
		List<Integer> node3neighbours = new ArrayList<>();
		node3neighbours.add(4);
		List<Integer> node4neighbours = new ArrayList<>();
		node4neighbours.add(5); node4neighbours.add(6);
		List<Integer> node5neighbours = new ArrayList<>();
		List<Integer> node6neighbours = new ArrayList<>();
		List<Integer> node7neighbours = new ArrayList<>();
		graph.add(node1neighbours); graph.add(node2neighbours);
		graph.add(node3neighbours); graph.add(node4neighbours);
		graph.add(node5neighbours); graph.add(node6neighbours);
		graph.add(node7neighbours);
		
		System.out.println(graph);
		System.out.println("Run bfs");
		bfs(graph);
		System.out.println("Run right-side dfs");
		rightSidedfs(graph);
		System.out.println("Run left-side dfs");
		leftSidedfs(graph);
		
		

		System.out.println("Run left-side dfs with Node class");
		Node a = new Node("a");
		Node b = new Node("b");
		Node c = new Node("c");
		Node d = new Node("d");
		Node e = new Node("e");
		Node f = new Node("f");
		
		a.neighbours.add(b);
		a.neighbours.add(c);
		
		b.neighbours.add(d);
		b.neighbours.add(f);
		b.neighbours.add(a);
		
		c.neighbours.add(e);
		c.neighbours.add(a);
		
		d.neighbours.add(b);
		
		e.neighbours.add(c);
		
		f.neighbours.add(b);
		
		DFSWithNode(a);
	}
}

