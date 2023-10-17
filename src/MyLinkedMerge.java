
// required imports
import java.io.FileWriter;
import java.io.IOException;

// MyLinkedMerge class which combines the ability to create a linked list with Merge Sort algorithm
public class MyLinkedMerge {

   // Node class to create new node in linked list
   public class Node {
      int data;
      Node next;

      private Node(int data) {
         this.data = data;
         this.next = null;
      }
   }

   // initialize the head, tail, and size values
   public Node head = null;
   private Node tail = null;
   private int size;

   /**
    * add method to allow the user to add node to linked list
    * 
    * @param data - integer value to add
    */
   public void add(int data) {
      Node node = new Node(data);
      if (head == null) {
         head = node;
         tail = node;
      } else {
         tail.next = node;
         tail = node;
      }
      size++;
   }

   /**
    * get method to allow the user to access a value in the linked list based on
    * position
    * 
    * @param position - integer value to identify location of desired value
    * @return
    */
   public int get(int position) {
      if (head == null) {
         throw new IndexOutOfBoundsException();
      }
      Node curr = head;
      for (int i = 0; i < position; i++) {
         curr = curr.next;
      }
      return curr.data;
   }

   /**
    * isEmpty method to determine whether the linked list contains values
    * 
    * @return - true/false based on size of linked list
    */
   public boolean isEmpty() {
      if (size == 0) {
         return true;
      } else {
         return false;
      }
   }

   /**
    * size method to return size of linked list
    * 
    * @return - size of linked list
    */
   public int size() {
      return size;
   }

   /**
    * display method to iterate through linked list.
    */
   public void display() {
      Node curr = head;
      while (curr != null) {
         System.out.println(curr.data);
         curr = curr.next;
      }
   }

   /**
    * printNodes method to traverse through linked list and display each node.
    * 
    * @param head - start at first node in linked list
    */
   public void printNodes(Node head) {
      while (head != null) {
         System.out.print(head.data + " ");
         head = head.next;
      }
   }

   /**
    * writeNodes method to traverse through linked list and write each node to
    * output file.
    * 
    * @param head   - start at first node in linked list
    * @param writer - location to write output file
    */
   public void writeNodes(Node head, FileWriter writer) {
      try {
         Long start = System.nanoTime();
         while (head != null) {
            writer.write(head.data + "\t");
            head = head.next;
            if (head == null) {
               Long end = System.nanoTime();
               writer.write("\n" + "The nano time required according to the MergeSort algorithm: " + (end - start));
            }
         }
         writer.close();
      } catch (IOException e) {
         e.printStackTrace();
      }
   }

   /**
    * middleNode method to determine the middle node in the linked list.
    * 
    * @param head - start at the first node in linked list
    * @return - middle node
    */
   public MyLinkedMerge.Node middleNode(Node head) {
      if (head == null) {
         return head;
      }
      Node regSpeed = head;
      Node doubleSpeed = head;
      while (doubleSpeed.next != null && doubleSpeed.next.next != null) {
         regSpeed = regSpeed.next;
         doubleSpeed = doubleSpeed.next.next;
      }
      return regSpeed;
   }

   /**
    * mergeSort method recursively sorts the linked list with the help of the
    * getMiddle and merge helper methods.
    * 
    * @param head - start at the first node in linked list
    * @return - sorted linked list
    */
   public MyLinkedMerge.Node mergeSort(Node head) {
      if (head == null || head.next == null) {
         return head;
      }
      Node mid = middleNode(head);
      Node midNext = mid.next;
      mid.next = null;
      Node leftHalf = mergeSort(head);
      Node rightHalf = mergeSort(midNext);
      Node sorted = merge(leftHalf, rightHalf);
      return sorted;
   }

   /**
    * merge method compared the values in the split halfed linked list with one
    * another, then returns a sorted merged linked list.
    * 
    * @param left  - current node in the leftHalf linked list
    * @param right - current node in the rightHalf linked list
    * @return - sorted merged linked list
    */
   private MyLinkedMerge.Node merge(Node left, Node right) {
      Node merged = null;
      if (left == null) {
         return right;
      }
      if (right == null) {
         return left;
      }
      if (left.data <= right.data) {
         merged = left;
         merged.next = merge(left.next, right);
      } else {
         merged = right;
         merged.next = merge(left, right.next);
      }
      return merged;
   }

}
