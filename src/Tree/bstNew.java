package Tree;

public class bstNew {
static Node root;

public void addNode(int key, String name){
	Node newNode = new Node(key, name);
	Node focusNode;
	
	if (root == null){
		root = newNode;	
	}
	
	else {
		
		focusNode = root;
		
		while (true){
			Node parentNode = focusNode;
			
			if (key < focusNode.key) { focusNode = focusNode.leftChild;
				if (focusNode == null) {
				parentNode.leftChild = newNode;
				newNode.parentNode = parentNode;
				newNode.pToN = 1;
				break;
				}
			}
			else { focusNode = focusNode.rightChild;
				if (focusNode == null) {
				parentNode.rightChild = newNode;
				newNode.parentNode = parentNode;
				newNode.pToN = 2;
				break;
				}
			}
		}
	}

}


public static void main(String[] args){
bstNew myTree = new bstNew();

myTree.addNode(12,"agdsybsada");
myTree.addNode(34,"sdsdybsada");
myTree.addNode(56,"jkldfybsada");
myTree.addNode(11,"ncmvnybsada");
myTree.addNode(10,"ieowybsada");
myTree.addNode(23,"asdsdsybsada");
myTree.addNode(26,"glastrfraba");
System.out.println("addNode done");

System.out.println(LeftTreeSize(root));

}

public static int treesize(Node nd){
	if (nd == null)
		return 0;
	else
		return treesize(nd.leftChild)+1+treesize(nd.rightChild);
			
}

public static int LeftTreeSize(Node nd){
	return treesize(nd.leftChild);
			
}

class Node {
	int key;
	String name;
	
	Node parentNode;
	int pToN;
	Node leftChild;
	Node rightChild;
	
	Node(int key, String name){
	this.key = key;
	this.name = name;
	}
	
	public String toString(){
	return name+" has the key "+key;
	}
}


}
