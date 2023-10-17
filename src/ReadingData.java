
// required imports
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

// ReadingData class redas the data from the file
public class ReadingData {

   /**
    * arrayData method reads the file entered by the user and returns an array of
    * the integer data. First while loop counts the number of integer in the file
    * to use for declaring array size. Second while loop stores the values in the
    * array.
    * 
    * @param file - file passed in by the user
    * @return array of the file integer data
    */
   public int[] arrayData(File file) {
      int count = 0;
      int[] numbers = new int[count];
      try {
         Scanner scanCount = new Scanner(file);
         while (scanCount.hasNextInt()) {
            scanCount.nextInt();
            count++;
         }
         Scanner scanStore = new Scanner(file);
         numbers = new int[count];
         for (int i = 0; i < numbers.length; i++) {
            numbers[i] = scanStore.nextInt();
         }
         scanCount.close();
         scanStore.close();
         return numbers;
      } catch (FileNotFoundException e) {
         e.printStackTrace();
      }
      return numbers;
   }

   /**
    * linkedData method reads the file passed in by the user and returns a linked
    * list representation of the integer data.
    * 
    * @param file - file passed in by the user
    * @return linked list of the file data
    */
   public MyLinkedMerge linkedData(File file) {
      MyLinkedMerge myLinkedList = new MyLinkedMerge();
      try {
         Scanner scanStore = new Scanner(file);
         while (scanStore.hasNextInt()) {
            myLinkedList.add(scanStore.nextInt());
         }
         scanStore.close();
         return myLinkedList;
      } catch (FileNotFoundException e) {
         e.printStackTrace();
      }
      return myLinkedList;
   }
}
