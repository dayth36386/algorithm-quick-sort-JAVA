import java.util.*;
public class Quicksort {
    public static void main(String[] args) {
       Scanner sc = new Scanner(System.in);
       Random rd = new Random();
       
       System.out.print("Array Size ? ");
       int in = sc.nextInt();
       int[] number = new int[in];

       for (int i = 0; i < number.length; i++) {
        number[i] = rd.nextInt(1000);
      }
      System.out.println("Before :");
      printArray(number);
      final long startTime = System.currentTimeMillis();
      quicksort(number, 0, number.length - 1);
      final long endTime = System.currentTimeMillis();


      System.out.println("After :");
      printArray(number);
      System.out.println("Total execution time: " + (endTime - startTime));
      
    }

    private static void quicksort(int array[], int lowIndex,int highIndex){

        if(lowIndex >= highIndex){
          return;  
        }
        int pivot = array[highIndex];
        
        int leftPointer = lowIndex;
        int rightPointer = highIndex;
        
        while(leftPointer < rightPointer){
            while(array[leftPointer] <= pivot && leftPointer < rightPointer){
                leftPointer++;
            }
            while(array[rightPointer] >= pivot && leftPointer < rightPointer){
                rightPointer--;
            }

            swap(array, leftPointer, rightPointer);
        }
        
        swap(array, leftPointer, highIndex);

        quicksort(array, lowIndex, leftPointer-1);
        quicksort(array, leftPointer +1,highIndex);
    }
    private static void swap(int[] array, int index1, int index2) {
        int temp = array[index1];
        array[index1] = array[index2];
        array[index2] = temp;
      }
    private static void printArray(int[] number) {
        for (int i = 0; i < number.length; i++) {
          System.out.println(number[i]);

        }
    }
}
