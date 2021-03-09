import java.util.Scanner;

/*

 
 Initialize variables to store radius, volume, numerator and denominator
 Take input from the user
 if input is 'q'
     take input from the user for fractions
     if input is 'q'
         exit the program
     else
         pick the first two number from input. Take First number as numerator and the second number as denominator
         compute and shorten the compound fraction using the fraction and sgd function
         print the fraction
         pick the next input
         if input is 'q'
         take input from user again for fractions
         else
             take two number from the input
             repeat above steps until 'q' is found
 else
     pick the first two number. Take First number as radius and the second number as volume
     compute and print base surface area
     compute and print lateral surface area
     compute and print volume of cone
     pick the next input
     if input is 'q'
         take input from user again for fractions
     else
         take two number from the input
         repeat above steps until 'q' is found
*/


public class Task5 {
    private static Scanner userInput = new Scanner(System.in);
    //This function takes radius as parameter and returns the base area of cone
    public double area(int radius)
    {
        return Math.PI * Math.pow(radius,2);
    }
    //this function takes radius and height as input and return the lateral surface area
    public double area(int radius, int height)
    {
        return Math.PI * radius * pythagoras(radius,height);
    }
    // this function calculates the hypotenuse of the triangle. It takes the measurement of other two sides as input
    public double pythagoras(int sideA, int sideB)
    {
        return Math.sqrt(Math.pow(sideA,2) + Math.pow(sideB,2));
    }
    //This function takes radius and height as parameter and returns the volume of the cone
    public double volume(int radius, int height)
    {
        return (Math.PI * Math.pow(radius,2)* height)/3;
    }
    //this function takes in the numerator and the denomenator of the fraction and return a number that can be used to shorten the fraction
    public int sgd (int a, int b)
    {
        while(b != 0)
        {
            int c = a % b;
            a = b;
            b = c;

        }
        return a;
    }
    // This function takes in numerator and denominator of the fraciton and returns the compound form of fraction in an array
    public int [] fraction (int numerator, int denominator)
    {
        int arr[] = new int[3];
        if(numerator == 0)
        {
            arr[0] = 0;
            arr[1] = 0;
            arr[2] = 0;
        }
        else if(denominator == 0)
        {
            return null;
        }
        else
        {
            arr[0] = numerator/denominator;
            arr[1] = numerator%denominator;
            arr[2] = denominator;

            int a = sgd(arr[2], arr[1]);
            arr[1] = arr[1]/a;
            arr[2] = arr[2]/a;
        }
        return arr;
    }
    // this function prints the fraction
    public void printFraction(int arr[])
    {
        if(arr == null)
        {
            System.out.println("Error!");
        }
        else if(arr[0] != 0)
        {
            if(arr[1] != 0) {
                System.out.print(arr[0]+" ");
                System.out.println(arr[1]+"/"+arr[2]);
            }
            else
            {
                System.out.println(arr[0]+" ");
            }
        }
        else{
            if(arr[1] != 0) {
                System.out.println(arr[1]+"/"+arr[2]);
            }
            else if(arr[2] == 0)
            {
                System.out.println("0");

            }
        }
    }
    public static void main(String[] args)
    {
        Task5 t = new Task5();
        System.out.println("----------------------------------\n" +
                "# Test of area and volume methods\n" +
                "----------------------------------\n");
        boolean end = false;

        String str = userInput.nextLine(); // read the line entered by the user
        String data[] = str.split(" "); // split the line whenever " " is found
        int i = 0;
        int r;
        int h;
        while(!data[i].equals("q"))
        {
            r = Integer.parseInt(data[i]); // converting string to int
            h = Integer.parseInt(data[i+1]); // converting string to int
            System.out.println("r = " + r + " h = " + h);
            System.out.printf("Base surface area: %.2f\n", t.area(r));
            System.out.printf("Lateral surface area: %.2f\n", t.area(r,h));
            System.out.printf("Volume: %.2f\n\n", t.volume(r,h));
            i = i + 2;
        }
        System.out.println("----------------------------------\n" +
                "# Test of the fractional methods\n" +
                "----------------------------------\n");
        str = userInput.nextLine();
        data = str.split(" ");
        i = 0;
        int n;
        int d;
        while(!data[i].equals("q"))
        {
            n = Integer.parseInt(data[i]);
            d = Integer.parseInt(data[i+1]);
            System.out.print(n+"/"+d+ " = ");
            t.printFraction(t.fraction(n,d));
            i = i + 2;
        }



    }
}
