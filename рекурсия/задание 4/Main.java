public class Main {
   public static void main(String[] args) {
       Tree tree = new Tree();

       tree.insertNode(6);
       tree.insertNode(8);
       tree.insertNode(5);
       tree.insertNode(8);
       tree.insertNode(2);
       tree.insertNode(9);
       tree.insertNode(7);
       tree.insertNode(4);
       tree.insertNode(10);
       tree.insertNode(3);
       tree.insertNode(1);

       tree.printTree();

       tree.deleteNode(4);
       tree.printTree();


       Node foundNode = tree.findNodeByValue(9);
       foundNode.printNode();
   }
}

class Node {
   private int value;
   private Node leftChild;
   private Node rightChild;

   public void printNode() {
       System.out.println(" Выбранный узел имеет значение :" + value);
   }

   public int getValue() {
       return this.value;
   }

   public void setValue(final int value) {
       this.value = value;
   }

   public Node getLeftChild() {
       return this.leftChild;
   }

   public void setLeftChild(final Node leftChild) {
       this.leftChild = leftChild;
   }

   public Node getRightChild() {
       return this.rightChild;
   }

   public void setRightChild(final Node rightChild) {
       this.rightChild = rightChild;
   }

   @Override
   public String toString() {
       return "Node{" +
               "value=" + value +
               ", leftChild=" + leftChild +
               ", rightChild=" + rightChild +
               '}';
   }
}

class Tree {
   private Node rootNode;

   public Tree() {
       rootNode = null;
   }

   public Node findNodeByValue(int value) {
       Node currentNode = rootNode;
       while (currentNode.getValue() != value) {
           if (value < currentNode.getValue()) {
               currentNode = currentNode.getLeftChild();
           } else {
               currentNode = currentNode.getRightChild();
           }
           if (currentNode == null) {
               return null; 
           }
       }
       return currentNode;
   }

   public void insertNode(int value) {
       Node newNode = new Node();
       newNode.setValue(value);
       if (rootNode == null) {
           rootNode = newNode;
       }
       else {
           Node currentNode = rootNode;
           Node parentNode;
           while (true)
           {
               parentNode = currentNode;
               if(value == currentNode.getValue()) {
                    return;
                }
                else  if (value < currentNode.getValue()) {
                   currentNode = currentNode.getLeftChild();
                   if (currentNode == null){
                       parentNode.setLeftChild(newNode);
                       return;
                   }
               }
               else { // Или направо?
                   currentNode = currentNode.getRightChild();
                   if (currentNode == null) {
                       parentNode.setRightChild(newNode);
                       return; // и выйти
                   }
               }
           }
       }
   }

   public boolean deleteNode(int value)
   {
       Node currentNode = rootNode;
       Node parentNode = rootNode;
       boolean isLeftChild = true;
       while (currentNode.getValue() != value) {
           parentNode = currentNode;
           if (value < currentNode.getValue()) {
               isLeftChild = true;
               currentNode = currentNode.getLeftChild();
           }
           else { // или движение вправо?
               isLeftChild = false;
               currentNode = currentNode.getRightChild();
           }
           if (currentNode == null)
               return false;
       }

       if (currentNode.getLeftChild() == null && currentNode.getRightChild() == null) {
           if (currentNode == rootNode)
               rootNode = null;
           else if (isLeftChild)
               parentNode.setLeftChild(null);
           else
               parentNode.setRightChild(null);
       }
       else if (currentNode.getRightChild() == null) {
           if (currentNode == rootNode)
               rootNode = currentNode.getLeftChild();
           else if (isLeftChild)
               parentNode.setLeftChild(currentNode.getLeftChild());
           else
               parentNode.setRightChild(currentNode.getLeftChild());
       }
       else if (currentNode.getLeftChild() == null) {
           if (currentNode == rootNode)
               rootNode = currentNode.getRightChild();
           else if (isLeftChild)
               parentNode.setLeftChild(currentNode.getRightChild());
           else
               parentNode.setRightChild(currentNode.getRightChild());
       }
       else {
           Node heir = receiveHeir(currentNode);
           if (currentNode == rootNode)
               rootNode = heir;
           else if (isLeftChild)
               parentNode.setLeftChild(heir);
           else
               parentNode.setRightChild(heir);
       }
       return true;
   }

  
   private Node receiveHeir(Node node) {
       Node parentNode = node;
       Node heirNode = node;
       Node currentNode = node.getRightChild();
       while (currentNode != null)
       {
           parentNode = heirNode;
           heirNode = currentNode;
           currentNode = currentNode.getLeftChild();
       }
       // Если преемник не является
       if (heirNode != node.getRightChild())
       { // создать связи между узлами
           parentNode.setLeftChild(heirNode.getRightChild());
           heirNode.setRightChild(node.getRightChild());
       }
       return heirNode;
   }

   public void printTree() {
       Stack globalStack = new Stack();
       globalStack.push(rootNode);
       int gaps = 32;
       boolean isRowEmpty = false;
       String separator = "-----------------------------------------------------------------";
       System.out.println(separator);
       while (isRowEmpty == false) {
           Stack localStack = new Stack();
           isRowEmpty = true;

           for (int j = 0; j < gaps; j++)
               System.out.print(' ');
           while (globalStack.isEmpty() == false) {
               Node temp = (Node) globalStack.pop();
               if (temp != null) {
                   System.out.print(temp.getValue());
                   localStack.push(temp.getLeftChild());
                   localStack.push(temp.getRightChild());
                   if (temp.getLeftChild() != null ||
                           temp.getRightChild() != null)
                       isRowEmpty = false;
               }
               else {
                   System.out.print("__");
                   localStack.push(null);
                   localStack.push(null);
               }
               for (int j = 0; j < gaps * 2 - 2; j++)
                   System.out.print(' ');
           }
           System.out.println();
           gaps /= 2;
           while (localStack.isEmpty() == false)
               globalStack.push(localStack.pop());
       }
       System.out.println(separator);
   }
}