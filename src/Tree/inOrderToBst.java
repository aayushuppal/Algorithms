package Tree;
import java.util.Scanner;



public class inOrderToBst {
	
	public void genTree(int[] treeNum, int root){
	}
	
	
	public static void main(String[] args) {
	inOrderToBst obj = new inOrderToBst();
	
	Scanner userInput = new Scanner(System.in);
	System.out.println("input number of nodes in tree");
	int num = userInput.nextInt();
	int[] treeNum = new int[num];
	
	for (int i=0; i<num; i++){
		treeNum[i] = userInput.nextInt();
		}
	System.out.println("input root node");
	int root = userInput.nextInt();
	
	userInput.close();
	
	obj.genTree(treeNum, root);
	
	}
	
	class Node{
		int key;
		String name;
		
		Node leftChild;
		Node rightChild;
		Node parentChild;
		
		Node(int key, String name){
		this.key = key;
		this.name = name;
		}
		
		
	}

}
