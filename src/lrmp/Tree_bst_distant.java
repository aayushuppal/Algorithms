package lrmp;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class Tree_bst_distant {

    public static void main(String[] args) {
	int[] inp = { 9, 3, 2, 9, 2, 1, 7, 3, 7, 4 };

	int root = findHead(inp);

	if (root < 0) {
	    System.out.println("incorrect input");
	    System.exit(-1);
	}

	Node head = constructGraph(inp, root);

	int[] xxc = findDistArr(head, inp.length);
	System.out.println();

    }

    public static Node constructGraph(int[] inp, int rootVal) {
	Map<Integer, Node> createdNodes = new HashMap<Integer, Node>();
	for (int i = 0; i < inp.length; i++) {
	    if (!createdNodes.containsKey(i)) {
		createdNodes.put(i, new Node(i));
	    }
	    if (!createdNodes.containsKey(inp[i])) {
		createdNodes.put(inp[i], new Node(inp[i]));
	    }
	    Node nodeI = createdNodes.get(i);
	    Node nodeinpI = createdNodes.get(inp[i]);
	    if (!nodeI.equals(nodeinpI)) {
		System.out.println(nodeI.val + "<---->" + nodeinpI.val);
		nodeI.connectedNodes.add(nodeinpI);
		nodeinpI.connectedNodes.add(nodeI);
	    }
	}

	return createdNodes.get(rootVal);
    }

    public static int findHead(int[] x) {
	for (int i = 0; i < x.length; i++) {
	    if (x[i] == i) {
		return i;
	    }
	}
	return -1;
    }

    public static int[] findDistArr(Node head, int processCount) {

	int[] distArr = new int[processCount];
	Set<Node> processedNode = new HashSet<Node>();

	Queue<Node> tempQ = new LinkedList<Node>();
	head.distFromRoot = 0;
	distArr[0] = distArr[0] + 1;
	tempQ.add(head);
	processedNode.add(head);

	while (!tempQ.isEmpty()) {
	    Node temp = tempQ.poll();
	    int dist = temp.distFromRoot + 1;

	    for (Node x : temp.connectedNodes) {
		if (!processedNode.contains(x)) {
		    x.distFromRoot = dist;
		    distArr[dist] = distArr[dist] + 1;
		    tempQ.add(x);
		    processedNode.add(x);
		}
	    }

	}
	return distArr;
    }

}

class Node {
    int val;
    int distFromRoot;
    List<Node> connectedNodes;

    public Node(int a) {
	this.val = a;
	connectedNodes = new ArrayList<Node>();
    }
}
