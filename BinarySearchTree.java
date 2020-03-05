import java.lang.reflect.Array;
import java.util.ArrayList;

public class BinarySearchTree {
    Node root;

    public BinarySearchTree() {

        this.root = null;

    }
    public void insert(String name, double gdpPerCapita){

        Node node = new Node(name, gdpPerCapita);

        if(root == null){
            this.root = node;
            return;
        } else{
            Node presentNode = root;
            Node parentNode;
            while(true){
                parentNode = presentNode;

                //Check left
                if(name.compareTo(presentNode.name) < 0){
                    presentNode = presentNode.leftChild;
                    if(presentNode == null){
                        parentNode.leftChild = node;
                        return;
                    }
                }else{
                    presentNode = presentNode.rightChild;
                    if(presentNode == null){
                        parentNode.rightChild = node;
                        return;
                    }
                }
            }
        }
    }
    public double find(String name){
        int traversed = 0;
        Node current = root; // start at root
        while (current != null && !current.name.equals(name)) // if no match
             {
            if (name.compareTo(current.name) < 0) {
                traversed ++;
                current = current.leftChild; // follow left link
            }else {
                traversed ++;
                current = current.rightChild;
            }// follow right link
            if (current == null) {
                traversed ++;
                return -1;
            }
        } // end while
        System.out.println(traversed + " Nodes Traversed");
            return current.gdpPerCapita;
    }

    public void inserLeftChild(Node n){
        if(root == null){
            root = n;
            return;
        }

        Node current = root;
        while(current.leftChild != null){
            current = current.leftChild;
        }
        current.leftChild = n;
    }
    public void delete(String name) {
        Node sucessor = null;
        Node current = root; // start at root
        Node parent = root;
        while (current != null && !current.name.equals(name)) // if no match
        {
            if (name.compareTo(current.name) < 0) {
                parent = current;
                current = current.leftChild; // follow left link
            }else {
                parent = current;
                current = current.rightChild;
            }// follow right link
            if (current == null) {
                return;
            }
        } // end while



        Node leftChild = current.leftChild;
        Node rightChild = current.rightChild;
        boolean isLeftChild;

        if(current.name.compareTo(parent.name) < 0){
            isLeftChild = true;
        }else{
            isLeftChild = false;
        }

        if(current == root) {
            if(rightChild == null){
                root = leftChild;
            }else{
                root = rightChild;
                inserLeftChild(leftChild);
            }
        }else if(isLeftChild){
            if(rightChild == null){
                parent.leftChild = leftChild;
            }else{
                parent.leftChild = rightChild;
                inserLeftChild(leftChild);
            }
        }else{
            if(rightChild == null){
                parent.rightChild = leftChild;
            }else{
                parent.rightChild = rightChild;
                inserLeftChild(leftChild);
            }
        }

        /*
        // if no children, delete it
        if (current.leftChild == null && current.rightChild == null) {
            if (current == root) {
                root = null;
            }else if (isLeftChild) {
                parent.leftChild = null; // disconnect from parent
            }else{
                parent.rightChild = null;
            }
        }
        // if no right child, replace with left subtree
        else if (current.rightChild == null){
            if (current == root) {
                root = current.leftChild;
            }else if (isLeftChild) { // left child of parent
                parent.leftChild = current.leftChild;
            }else { // right child of parent
                parent.rightChild = current.leftChild;
            }
        }
        // if no left child, replace with right subtree
        else if(current.leftChild==null) {
            if (current == root) {
                root = current.rightChild;
            } else if (isLeftChild) { // left child of parent
                parent.leftChild = current.rightChild;
            } else { // right child of parent
                parent.rightChild = current.rightChild;
            }
        }
        //if the right not does not have a left child, it is successor
        else if((parent.rightChild).leftChild == null){
            sucessor = parent.rightChild;
            sucessor.leftChild = current.leftChild;
        }else{
            sucessor = current.rightChild;
            Node sucessorLeft = sucessor.leftChild;
            sucessorLeft.leftChild = current.leftChild;

        }*/
    }

    public void printInOrder(){
        printInOrder(this.root);
    }

    private void printInOrder(Node root){

        if(root != null){
            printInOrder(root.leftChild);
            root.printNode();
            printInOrder(root.rightChild);
        }
    }

    public void printPreOrder(){
        printPreOrder(this.root);
    }
    private void printPreOrder(Node root){

        if(root != null){
            root.printNode();
            printPreOrder(root.leftChild);
            printPreOrder(root.rightChild);
        }

    }
    public void printPostOrder(){
            printPostOrder(this.root);
    }
    private void printPostOrder(Node root){

        if(root != null){
            printPostOrder(root.leftChild);
            printPostOrder(root.rightChild);
            root.printNode();
        }
    }
    public void printBottomTen(){

        ArrayList<Node> arrayOfTreeBottom = new ArrayList<Node>();
        inOrderTraversal(this.root, arrayOfTreeBottom);
        insertionSort(arrayOfTreeBottom);
        for (int i = 0; i < 10; i++) {
            arrayOfTreeBottom.get(i).printNode();
        }

    }
    private void inOrderTraversal(Node root, ArrayList<Node> arrayOfTree){

        if(root != null){
            inOrderTraversal(root.leftChild, arrayOfTree);
            arrayOfTree.add(root);
            inOrderTraversal(root.rightChild, arrayOfTree);
        }
    }
    public void printTopTen(){

        ArrayList<Node> arrayOfTreeTop = new ArrayList<Node>();
        inOrderTraversal(this.root, arrayOfTreeTop);
        insertionSort(arrayOfTreeTop);
        for (int i = arrayOfTreeTop.size() - 11; i < arrayOfTreeTop.size(); i++) {
            arrayOfTreeTop.get(i).printNode();
        }
    }
    public void insertionSort(ArrayList<Node> list) {
        int inner, outer;
        for(outer = 1; outer < list.size(); outer++) { // out is dividing line
            Node temp = list.get(outer); // remove marked item
            inner = outer-1; // start shifts at “outer”

            while(inner >= 0 && list.get(inner).gdpPerCapita > temp.gdpPerCapita) { // until one is smaller
                list.set(inner+1, list.get(inner));
                inner--;
            } // end while
         list.set(inner + 1, temp);
        }
    }

    private class Node {
        String name;
        double gdpPerCapita;
        Node leftChild;
        Node rightChild;

        public Node(String name, double gdpPerCapita) {
            this.name = name;
            this.gdpPerCapita = gdpPerCapita;
        }
        public void printNode() {
            System.out.printf("%-25s%,-20.2f\n", name, gdpPerCapita); }
    }
}
