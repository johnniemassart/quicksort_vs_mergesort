
// required imports
import java.io.FileWriter;
import java.io.IOException;

// QuickSorting class which contains the methods to perform the QuickSort algorithm
public class QuickSorting {

   /**
    * quickSortPartition method to partition the data into two parts: low partition
    * - values less than, equal to the pivot; high partition - values greater than,
    * equal to the pivot.
    * 
    * @param numbers   - array of the file integer data
    * @param lowIndex  - starts at first element in the sub-array (required for
    *                  recursion)
    * @param highIndex - starts at last element in the sub-array (required for
    *                  recursion)
    * @return - highIndex value representing the greatest index value of the low
    *         partition of the array.
    */
   public int quickSortPartition(int[] numbers, int lowIndex, int highIndex) {

      int pivot = numbers[lowIndex];
      boolean partition = false;

      while (!partition) {
         while (numbers[lowIndex] < pivot) {
            lowIndex++;
         }
         while (pivot < numbers[highIndex]) {
            highIndex--;
         }
         if (lowIndex >= highIndex) {
            partition = true;
         } else {
            int temp = numbers[lowIndex];
            numbers[lowIndex] = numbers[highIndex];
            numbers[highIndex] = temp;
            lowIndex++;
            highIndex--;
         }
      }
      return highIndex;

   }

   /**
    * insertionSortSorting method implements the insertion sort algorithm as seen
    * in the textbook. Nested loops to compare sorted, unsorted parts within the
    * array.
    * 
    * @param numbers - array of the file integer data
    */
   public void insertionSortSorting(int[] numbers) {
      for (int i = 1; i < numbers.length; i++) {
         int j = 1;
         while (j < 0 && numbers[j] < numbers[j - 1]) {
            int temp = numbers[j];
            numbers[j] = numbers[j - 1];
            numbers[j - 1] = temp;
            --j;
         }
      }
   }

   /**
    * quickSortSortingRecursion method partitions and sorts the array recursively.
    * 
    * @param numbers   - array of the file integer data
    * @param lowIndex  - starts at the first element in the array
    * @param highIndex - starts at the last index in the array
    */
   public void quickSortSortingRecursion(int[] numbers, int lowIndex, int highIndex) {
      if (lowIndex >= highIndex) {
         return;
      }
      int lowEndIndex = quickSortPartition(numbers, lowIndex, highIndex);
      quickSortSortingRecursion(numbers, lowIndex, lowEndIndex);
      quickSortSortingRecursion(numbers, lowEndIndex + 1, highIndex);
   }

   /**
    * quickSortSortingCombination method combines the insertion sort algorithm with
    * the recursive sorting algorithm.
    * 
    * @param numbers   - array of the file integer data
    * @param lowIndex  - starts at the first element in the array
    * @param highIndex - starts at the last index in the array
    */
   public void quickSortSortingCombination(int[] numbers, int lowIndex, int highIndex) {
      if (highIndex - lowIndex < 5) {
         insertionSortSorting(numbers);
      } else {
         int lowEndIndex = quickSortPartition(numbers, lowIndex, highIndex);
         quickSortSortingRecursion(numbers, lowIndex, lowEndIndex);
         quickSortSortingRecursion(numbers, lowEndIndex + 1, highIndex);
      }
   }

   /**
    * printNumbers method to iterate through integer array data and output the
    * result.
    * 
    * @param numbers - array of the file integer data
    */
   public void printNumbers(int[] numbers) {
      for (int i = 0; i < numbers.length; i++) {
         System.out.print(numbers[i] + " ");
         if (i == numbers.length - 1) {
            System.out.println();
         }

      }
   }

   /**
    * writeNumbers method iterates through the numbers array and writes the results
    * to the output file.
    * 
    * @param numbers - array of the file integer data
    * @param writer  = FileWriter to write to output file
    */
   public void writeNumbers(int[] numbers, FileWriter writer) {
      try {
         Long start = System.nanoTime();
         for (int i = 0; i < numbers.length; i++) {
            writer.write(numbers[i] + "\t");
            if (i == numbers.length - 1) {
               Long end = System.nanoTime();
               writer.write("\n" + "The nano time required according to the QuickSort algorithm: " + (end - start));
            }
         }
         writer.close();
      } catch (IOException e) {
         e.printStackTrace();
      }

   }

}
