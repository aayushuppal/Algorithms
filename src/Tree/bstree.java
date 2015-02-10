
package Tree;

import java.util.*;

public class bstree {
	Node root;	

	
	public int DistanceBtw(int a, int b){
	ArrayList<Integer> l1 = pathFromRoot(a);
	ArrayList<Integer> l2 = pathFromRoot(b);
	ArrayList<Integer> lc = pathFromRoot(Lca(a,b));
	
	int s1 = l1.size();
	int s2 = l2.size();
	int sc = lc.size();
	
	return s1+s2-(2*sc);
	
	}
	
	public static void main(String[] args) {
		bstree tree1 = new bstree();
		tree1.addNode(12);
		tree1.addNode(10);
		tree1.addNode(8);
		tree1.addNode(11);
		tree1.addNode(14);
		tree1.addNode(7);
		
		ArrayList<LinkedList<Node>> aL =GenLinkLists(tree1);
		System.out.println("asasa");
		//System.out.println(tree1.DistanceBtw(11,7));
	}
	
	public static ArrayList<LinkedList<Node>> GenLinkLists(bstree Tree){
		ArrayList<LinkedList<Node>> aList = new ArrayList<LinkedList<Node>>();
		Node rt = Tree.root;
		aList = GenLinkLists(rt,aList,0);
		return aList;
	}
	
	public static ArrayList<LinkedList<Node>> GenLinkLists(Node rt, ArrayList<LinkedList<Node>> aList, int level ){
		if (rt == null){
			return null;
		} else {
			LinkedList<Node> lst;
			if(aList.size() == level){
				lst = new LinkedList<Node>();
				aList.add(lst);
			} else {
				lst = aList.get(level);
			}
			lst.add(rt);
			GenLinkLists(rt.leftChild,aList,level+1);
			GenLinkLists(rt.rightChild,aList,level+1);
		}
		return aList;
	}
	
	public class Node{
		int val;
		Node leftChild;
		Node rightChild;
		Node(int a){
			this.val = a;
		}
	}
	
	public void addNode(int a){
		Node n = new Node(a);
		if(root == null){
			root = n;
		} else {
			Node currNode = root;
			
			while(true){
				Node pNode = currNode;
				if(a < currNode.val){
					currNode = currNode.leftChild;
					if(currNode == null){
						pNode.leftChild = n;
						break;
					}
				} else if(a>currNode.val){
					currNode = currNode.rightChild;
					if(currNode == null){
						pNode.rightChild = n;
						break;
					}
				}
			}
		}
	}
	
	public ArrayList<Integer> pathFromRoot(int a){
		ArrayList<Integer> al = new ArrayList<Integer>(); 
		Node currNode = root;
		if (a == currNode.val){
			al.add(currNode.val);
			return al;
		}
		else {
			while(true){
				if(a<currNode.val){
					al.add(currNode.val);
					currNode = currNode.leftChild;
					if(a == currNode.val){
						al.add(currNode.val);
						return al;
					}
				} else if(a>currNode.val){
					al.add(currNode.val);
					currNode = currNode.rightChild;
					if(a == currNode.val){
						al.add(currNode.val);
						return al;
					}
				}
			}
			
		}
	}
	
	public int Lca(int a, int b){
		ArrayList<Integer> l1 = pathFromRoot(a);
		ArrayList<Integer> l2 = pathFromRoot(b);
		
		int offset = Math.abs(l1.size()-l2.size());
		if(l1.size() > l2.size()){
		while(offset>0){
			l1.remove(l1.size()-1);
			offset--;
		}
			
		} else {
			while(offset>0){
				l2.remove(l2.size()-1);
				offset--;
			}
		}
		
		int ls = l1.size()-1;
		int x = l1.get(ls);
		int y = l2.get(ls);
		
		while (x!=y){
			ls--;
			x = l1.get(ls);
			y = l2.get(ls);
		}
		
		return x;
	}

	public Node findNode(int key) {
		Node focusNode = root;
		if (key == focusNode.val){
			return focusNode;	
		}
		else {
			while(key != focusNode.val) {
				if (key < focusNode.val) {
				focusNode = focusNode.leftChild;
				if (focusNode == null){
					return null;
				}
				else if (key == focusNode.val){
					return focusNode;	
					}
				}
				else {
				focusNode = focusNode.rightChild;
				if (focusNode == null){
					return null;
				}
				else if (key == focusNode.val){
					return focusNode;	
					}
				}
			}
			return null;
		}
	}
	
}
