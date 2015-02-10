package SeparatePackage;
import java.util.*;

public class test {
	
	static Queue<Node> bfsQ = new LinkedList<Node>(); 
	static HashSet<Integer> bfsHS = new HashSet<Integer>();
	public enum State{
		Unvisited, Visiting, Visited;
	}

	public static void main(String[] args) {
		dirGraph dg1 = new dirGraph();
		dg1.addNode(1);
		dg1.addNode(2);
		dg1.addNode(3);
		dg1.addNode(4);
		dg1.addNode(5);
		
		dg1.nodeList[0].adjacent.add(dg1.nodeList[1]);
		dg1.nodeList[1].adjacent.add(dg1.nodeList[2]);
		dg1.nodeList[1].adjacent.add(dg1.nodeList[3]);
		dg1.nodeList[2].adjacent.add(dg1.nodeList[4]);
		dg1.nodeList[4].adjacent.add(dg1.nodeList[3]);
		System.out.println(bfs(dg1.nodeList[2], dg1.nodeList[0]));
		System.out.println(dg1.checkPath(dg1.nodeList[1],dg1.nodeList[4]));
	}
	
	public static boolean bfs(Node a, Node b){
		Node cNode = a;
		System.out.println(cNode.value);
		bfsHS.add(cNode.value);
		bfsQ.add(cNode);
		
		while(!bfsQ.isEmpty()){
			Node x = bfsQ.poll();
			for(Node z:x.adjacent){
				if(!bfsHS.contains(z.value)){
					if(z.value == b.value){
						return true;
					}else{
						System.out.println(z.value);
						bfsHS.add(z.value);
						bfsQ.add(z);
					}
				}
			}
		}
		
		return false;
	}

}
