import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;
/*

 Take input number from the user. This is the number of integers that program will randomize
 create array whose size is equal to the number entered by the user
 Randomize as many integers as the number entered by the user
 Separate the even numbers from the odd number. After this step all the even numbers will be on one side of array and all the odd numbers on the other
 Sort the part of the array with even numbers
 Sort the part of array with odd number*/


public class Task4 {
    // This function sorts the even numbers starting from index = 0 to index = end.
    public static void EvenSort(int arr[], int start, int end)
    {
        int n = end;
        for (int i = 0; i < n-1; i++)
            for (int j = 0; j < n-i-1; j++)
                if (arr[j] > arr[j+1])
                {
                    // swap arr[j+1] and arr[j]
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
    }
    // This function sorts the odd numbers part of the array
    public static void OddSort(int arr[], int start, int end)
    {
        for (int i = start; i < end - 1; i++)
        {
            int index = i;
            for (int j = i + 1; j < end; j++){
                if (arr[j] >= arr[index]){
                    index = j;
                }
            }
            int smallerNumber = arr[index];
            arr[index] = arr[i];
            arr[i] = smallerNumber;
        }
    }


    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in); // taking input from the user
        System.out.println("How many random numbers in the range 0 - 999 are desired");
        int totalNumbers = in.nextInt(); // totalNumbers contains the values entered by the user. This carries the number of integers that will be randomized
        int arr[] = new int[totalNumbers];
        int l = 0;

        Random rand = new Random(); // This is used for generating the random numbers
        int number = 0;
        System.out.println("Here are the random numbers");
        for(int i = 0; i < totalNumbers ; i++)
        {
            number = rand.nextInt(1000); //defining the range for the random numbers
            arr[l] = number;
            System.out.print(arr[i] + " ");
            l++;
        }
        System.out.println();
        int leftIndex = 0, rightIndex = totalNumbers - 1;


        int TotalEvenNumbers = 0;
        // in the following loop, even numbers are separated from the odd numbers in the array
        // even numbers are placed on the left side of array and odd numbers are placed on the right side of array
        while (leftIndex < rightIndex) {

            while (arr[leftIndex] % 2 == 0) {
                leftIndex++;
                TotalEvenNumbers++;
            }

            while (arr[rightIndex] % 2 != 0 && leftIndex < rightIndex)
                rightIndex--;

            if (leftIndex < rightIndex) {
                int temp = arr[leftIndex];
                arr[leftIndex] = arr[rightIndex];
                arr[rightIndex] = temp;
            }
        }

        EvenSort(arr, 0, TotalEvenNumbers); // sorting even numbers
        OddSort(arr, TotalEvenNumbers, totalNumbers); // sorting odd numbers
        System.out.println("Here are the random numbers arranged");
        for(int i = 0; i < totalNumbers ; i++)
        {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
}
