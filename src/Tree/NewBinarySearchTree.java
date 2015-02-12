package Tree;


public class NewBinarySearchTree {
	Node root;
	
	public class Node{
		int val;
		Node parent;
		Node leftChild;
		Node rightChild;
		Node(int a){
			this.val = a;
		}
	}
	
	public void addNode(int a){
		Node incoming = new Node(a);
		if (root == null){
			root = incoming;
			root.parent = null;
		} else {
			Node current = root;
			while(true){
				Node parentNode = current;
				if(a < current.val){	current = current.leftChild;
					if (current == null){
					parentNode.leftChild = incoming;
					incoming.parent = parentNode;
					break;
					}
				} else { current = current.rightChild;
					if (current == null){
						parentNode.rightChild = incoming;
						incoming.parent = parentNode;
						break;
					}
				}
			}
			
		}
		
	}

}
