package bfs;

import java.util.ArrayList;
import java.util.List;

public class Node {
		public String name;
		public boolean visited = false;
		public List<Node> neighbours = new ArrayList<Node>();
		
		public Node(String name){
			
			this.name = name;
		}
	}

