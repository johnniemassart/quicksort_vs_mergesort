
// required imports
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

// SortingMain class reads in the file from the user and outputs the results
public class SortingMain {

   // number of arguments passed in by the user
   public static int ARGS_LENGTH = 3;

   // main method to execute code
   public static void main(String[] args) throws IOException {
      // Create instance of classes
      ReadingData readingData = new ReadingData();
      QuickSorting quickSorting = new QuickSorting();
      MyLinkedMerge main = new MyLinkedMerge();

      // require correct amount of user input
      if (args.length != ARGS_LENGTH) {
         System.out.println("You have entered an incorrect number of command line arguments. The program requires "
               + ARGS_LENGTH + " command lines arguments.");
         System.exit(1);
      }

      // read file names from folder
      File[] fileNames = new File[15];
      File[] files = new File(args[0]).listFiles();
      // File[] files = new File("./input").listFiles();
      int i = 0;
      for (File file : files) {
         if (file.isFile()) {
            fileNames[i] = file;
            i++;
         }
      }

      // files read, stored into variables
      // output quickSort, mergeSort results inside desired folder
      for (int j = 0; j < fileNames.length; j++) {
         File file = fileNames[j];
         // QuickSort
         int[] arrMain = readingData.arrayData(file);
         quickSorting.quickSortSortingCombination(arrMain, 0, arrMain.length - 1);
         FileWriter quickWriter = new FileWriter(args[1] + "/oQS_" + file.getName());
         // FileWriter quickWriter = new FileWriter("./outputQuickSort/oQS_" +
         // file.getName());
         quickSorting.writeNumbers(arrMain, quickWriter);
         // MergeSort
         main = readingData.linkedData(file);
         FileWriter mergeWriter = new FileWriter(args[2] + "/oMS_" + file.getName());
         // FileWriter mergeWriter = new FileWriter("./outputMergeSort/oMS_" +
         // file.getName());
         main.writeNodes(main.mergeSort(main.head), mergeWriter);
      }

   }
}