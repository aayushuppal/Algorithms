package Tree;

import java.util.*;

import Tree.binarySearchTree.*;

public class SumPathFinder {
	
	ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
	ArrayList<Integer> curList = new ArrayList<Integer>();
	
	public static void main(String[] args) {
		binarySearchTree bst1 = new binarySearchTree();
		bst1.addNode(12, "name");
		bst1.addNode(7, "name");
		bst1.addNode(15, "name");
		bst1.addNode(4, "name");
		bst1.addNode(3, "name");
		bst1.addNode(1, "name");
	
		//ArrayList<ArrayList<Integer>> list = new ArrayList<ArrayList<Integer>>();
		//list = new SumPathFinder().pathSum(bst1.root, 27);	
		
		IterativeDFS(bst1.root);
		System.out.println("asas");
	}

	public ArrayList<ArrayList<Integer>> pathSum(Node root, int sum) {
	    if(root==null){
	        return res;
	    }
	    
	    curList.add(root.key);
	    
	    if(root.leftChild==null && root.rightChild==null){
	        if(sum - root.key==0){
	            res.add(new ArrayList<Integer>(curList));
	        }
	    }
	    
	    if(root.leftChild!=null){
	        pathSum(root.leftChild, sum-root.key);
	    }
	    
	    if(root.rightChild!=null){
	        pathSum(root.rightChild, sum-root.key);
	    }
	    
	    curList.remove(new Integer(root.key));
	    return res;
	}

	public static void IterativeDFS(Node root){
		HashMap<Node,Integer> travNodes = new HashMap<Node, Integer>(); 
		Stack<Node> st = new Stack<Node>();
		
		System.out.println(root.key);
		travNodes.put(root,root.key);
		
		
		if (root.rightChild != null){ 
			st.push(root.rightChild);
			st.push(root);
			}
		if (root.leftChild != null){ 
			st.push(root.leftChild);
			st.push(root);
			}
		
		while(!st.isEmpty()){
			int prev = travNodes.get(st.pop());
			Node c = st.pop();
			if(!travNodes.containsKey(c)){
				System.out.println(c.key);
				travNodes.put(c,c.key+prev);
			}		
			if (c.rightChild != null && !travNodes.containsKey(c.rightChild)){ 
				st.push(c.rightChild);
				st.push(c);
				}
			if (c.leftChild != null && !travNodes.containsKey(c.leftChild)){ 
				st.push(c.leftChild);
				st.push(c);
				}
		}
	}

}

