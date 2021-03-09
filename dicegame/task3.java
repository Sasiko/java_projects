import java.util.Random;
import java.util.Scanner;
/*

Initialization of variables such as dice 1, dice 2, dice 3, sum ,win and loss
take char input from the user at a time
if char is 'q'
    exit program
if char is '1'
    roll the dice 1 and add its value to sum
if char is '2'
    roll the dice 2 and add its value to sum
    if value of sum is 12
        increment win by 1 and set all dice variables to zero
if char is '3'
    roll dice 3 and add its value to the sum
    if value of sum is 12
        increment win by 1 and set all dice variables to zero
    if value of sum is greater than 12
        increment loss by 1 and set all dice variables to zero

*/
public class Task3 {
    public static void main(String[] args)
    {
        System.out.println("Welcome to game 12. You must roll 1-3 dice and try to get the sum 12");
        char input; // this stores the char that the user entered
        boolean endgame = false;
        Random rand = new Random();
        //6 0 0 sum: 6 #win: 0 #loss: 0
        int dice1= 0, dice2 = 0, dice3 = 0, win = 0, loss = 0;
        // endgame is only set to true when the user enters 'q'
        while(endgame == false)
        {
            System.out.println("Enter the dice you want to roll [1,2,3] (finish with q):");
            Scanner reader = new Scanner(System.in); // reading the input
            input = reader.next().charAt(0); // storing the first char in the input variable
            if(input == 'q')
            {
                endgame = true; // if q is entered then endgame is set to true
            }
            else if(input == '1')
            {
                dice1 = rand.nextInt(6) + 1; // dice 1 is rolled

                System.out.println(dice1 + " " + dice2 + " " + dice3 + " sum: " + (dice1+ dice2+dice3) + " #win: "+ win+ " #loss: "+ loss);
            }
            else if(input == '2')
            {
                dice2 = rand.nextInt(6) + 1; // dice 2 is rolled
                if((dice1+ dice2+dice3) ==  12) // if the total sum of dice 1 and dice2 is 12 then user won this round otherwise continue
                {
                    win++;
                }
                System.out.println(dice1 + " " + dice2 + " " + dice3 + " sum: " + (dice1+ dice2+dice3) + " #win: "+ win+ " #loss: "+ loss);
                if((dice1+ dice2+dice3) ==  12)
                {
                    // resetting the values of all dices
                    dice1 = 0;
                    dice2 = 0;
                    dice3 = 0;
                    System.out.println("Next Round!");
                }

            }
            else if(input == '3')
            {
                dice3 = rand.nextInt(6) + 1;
                if((dice1+ dice2+dice3) ==  12) // if sum all of dices is 12. Then the user won
                    win++;
                else if((dice1+ dice2+dice3) >  12) // if the sum of dices is greater than 12 then the user lost
                    loss++;
                System.out.println(dice1 + " " + dice2 + " " + dice3 + " sum: " + (dice1+ dice2+dice3) + " #win: "+ win+ " #loss: "+ loss);
                dice1 = 0;
                dice2 = 0;
                dice3 = 0;
                System.out.println("Next Round!");

            }
        }
    }
}
