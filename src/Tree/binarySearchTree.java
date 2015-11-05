package Tree;

public class binarySearchTree {
    Node root;

    public void addNode(int key, String name) {
        Node newNode = new Node(key, name);
        Node focusNode;

        if (root == null) {
            root = newNode;
        } else {

            focusNode = root;

            while (true) {
                Node parentNode = focusNode;

                if (key < focusNode.key) {
                    focusNode = focusNode.leftChild;
                    if (focusNode == null) {
                        parentNode.leftChild = newNode;
                        newNode.parentNode = parentNode;
                        newNode.pToN = 1;
                        break;
                    }
                } else {
                    focusNode = focusNode.rightChild;
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

    public void addNode(int key) {
        Node newNode = new Node(key);
        Node focusNode;

        if (root == null) {
            root = newNode;
        } else {

            focusNode = root;

            while (true) {
                Node parentNode = focusNode;

                if (key < focusNode.key) {
                    focusNode = focusNode.leftChild;
                    if (focusNode == null) {
                        parentNode.leftChild = newNode;
                        newNode.parentNode = parentNode;
                        newNode.pToN = 1;
                        break;
                    }
                } else {
                    focusNode = focusNode.rightChild;
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

    public Node findNode(int key) {
        Node focusNode = root;
        if (key == focusNode.key) {
            return focusNode;
        } else {
            while (key != focusNode.key) {
                if (key < focusNode.key) {
                    focusNode = focusNode.leftChild;
                    if (focusNode == null) {
                        return null;
                    } else if (key == focusNode.key) {
                        return focusNode;
                    }
                } else {
                    focusNode = focusNode.rightChild;
                    if (focusNode == null) {
                        return null;
                    } else if (key == focusNode.key) {
                        return focusNode;
                    }
                }
            }
            return null;
        }
    }

    public Node findNodeRec(Node root, int key) {
        if (root == null) {
            return null;
        }

        if (root.key == key) {
            return root;
        } else if (root.key > key) {
            return findNodeRec(root.leftChild, key);
        } else {
            return findNodeRec(root.rightChild, key);
        }


    }

    public void preOrderTrav(Node focusNode) {

        if (focusNode != null) {
            System.out.print(focusNode.key + " ");
            preOrderTrav(focusNode.leftChild);
            preOrderTrav(focusNode.rightChild);
        }

    }

    public void inOrderTrav(Node focusNode) {

        if (focusNode == null) {
            return;
        }
        inOrderTrav(focusNode.leftChild);
        System.out.print(focusNode.key + " ");
        inOrderTrav(focusNode.rightChild);
    }

    public void postOrderTrav(Node focusNode) {

        if (focusNode != null) {
            postOrderTrav(focusNode.leftChild);
            postOrderTrav(focusNode.rightChild);
            System.out.print(focusNode.key + " ");

        }

    }

    public void delNode(int key) {

        if (findNode(key) != null) {
            Node a = findNode(key);
            boolean asd = checkLeaf(key);
            if (asd == true) {
                System.out.println("leaf found");
                emptyNode(key);
            } else {
                if (a.leftChild != null) {
                    System.out.println("\"max of left subtree\" approach");
                    Node b = a.leftChild;
                    Node c = maxNodeLeft(b);
                    findNode(key).name = c.name;
                    findNode(key).key = c.key;
                    emptyNode(c.key);
                } else {
                    System.out.println("\"min of right subtree\" approach");
                    Node b = a.rightChild;
                    Node c = minNodeRight(b);
                    findNode(key).name = c.name;
                    findNode(key).key = c.key;
                    emptyNode(c.key);
                }

            }
        } else {
            System.out.println("invalid input");
        }

    }

    public int SumBetween(Node root, int L, int H) {
        if (root == null) {
            return 0;
        }
        if (root.key < L) {
            return SumBetween(root.rightChild, L, H);
        }
        if (root.key > H) {
            return SumBetween(root.leftChild, L, H);
        }
        return root.key + SumBetween(root.leftChild, L, H)
                + SumBetween(root.rightChild, L, H);
    }

    public boolean checkLeaf(int key) {
        boolean boolval = false;
        Node a = findNode(key);
        if (a.leftChild == null && a.rightChild == null) {
            boolval = true;
        }
        return boolval;
    }

    public Node maxNodeLeft(Node x) {
        // because we are looking for max we head to the right branch here
        while (x.rightChild != null) {
            x = x.rightChild;
        }
        Node z = x;
        return z;

    }

    public Node minNodeRight(Node x) {
        // because we are looking for min we head to the left branch here
        while (x.leftChild != null) {
            x = x.leftChild;
        }
        Node z = x;
        return z;

    }

    public void ConvertToDLL(Node root) {
        if (root != null) {

            ConvertToDLL(root.leftChild);

            Node L = root.leftChild;
            Node R = root.rightChild;
            Node RL = RightMost(L);
            Node LR = LeftMost(R);
            root.leftChild = RL;
            RL.rightChild = root;
            root.rightChild = LR;
            LR.leftChild = root;

            ConvertToDLL(root.rightChild);

        }

    }

    public Node RightMost(Node root) {
        while (root.rightChild != null) {
            root = root.rightChild;
        }
        return root;
    }

    public Node LeftMost(Node root) {
        while (root.leftChild != null) {
            root = root.leftChild;
        }
        return root;
    }

    public void emptyNode(int key) {
        if (findNode(key).pToN == 1) {
            findNode(key).parentNode.leftChild = null;
        } else {
            findNode(key).parentNode.rightChild = null;
        }
    }

    public static void main(String[] args) {
        binarySearchTree myTree = new binarySearchTree();

        myTree.addNode(12, "agdsybsada");
        myTree.addNode(34, "sdsdybsada");
        myTree.addNode(56, "jkldfybsada");
        myTree.addNode(11, "ncmvnybsada");
        myTree.addNode(10, "ieowybsada");
        myTree.addNode(23, "asdsdsybsada");
        myTree.addNode(26, "glastrfraba");
        System.out.println("addNode done");

//        myTree.ConvertToDLL(myTree.root);
  //      System.out.println(myTree.SumBetween(myTree.root, 10, 26));

	/*
     * Node asd = myTree.findNode(10); Node asdg = myTree.findNode(101);
	 * System.out.println(asd); System.out.println(asdg);
	 * System.out.println("findNode done");
	 * 
	 * myTree.preOrderTrav(myTree.root); System.out.println();
	 * System.out.println("pre order traversal done");
	 */
        myTree.inOrderTrav(myTree.root);
        System.out.println();
        System.out.println("in order traversal done");

        myTree.postOrderTrav(myTree.root);
        System.out.println();
        System.out.println("post order traversal done");

        myTree.delNode(56);

        System.out.println(myTree.findNode(34).parentNode);
        System.out.println(myTree.findNodeRec(myTree.root, 34).parentNode);

    }

    class Node {
        int key;
        String name;

        Node parentNode;
        int pToN;
        Node leftChild;
        Node rightChild;

        Node(int key, String name) {
            this.key = key;
            this.name = name;
        }

        Node(int key) {
            this.key = key;
        }

        Node(String name) {
            this.name = name;
        }

        public Node() {

        }

        public String toString() {
            return name + " has the key " + key;
        }
    }

}
