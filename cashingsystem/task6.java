
/**
 * 1) Program Start
 * 2) Show Menu
 * 3) Get Input for Menu Choice
 * 4) If input invalid, move to step 2, else continue
 * 5) If "submit articles" chosen
 *      a) If articles array half full, expand it, else move to step b
 *      b) Get input for amount of articles
 *      c) If input invalid move to step b, else continue
 *      d) Create random value for price and quantity
 *      e) Add the created article to the articles array
 *      f) If all articles added continue, else move to step d
 * 6) If "delete article" chosen
 *      a) Get input for article number
 *      b) If input invalid move to step a, else continue
 *      c) Traverse the array and find the article number
 *      d) If article number found, put zero for all article attributes, else continue
 * 7) If "view articles" chosen
 *      a) Tranverse articles array
 *      b) If current article number non zero display it, else continue
 *      c) If array exceeded array size, continue, else move to step a
 * 8) If "Sales" chosen
 *  *   a) Get input for article number
 *      b) If input invalid move to step a, else continue
 *      c) Traverse the array and find the article number
 *      d) if article number non found, move to step g
 *      e) Traverse sales array and find empty spot
 *      f) If empty spot found, add the sales values to it, else move to step g
 *      g) exit the method
 * 9) If "Order history" chosen
 *      a) Tranverse sales array
 *      b) If current sales number non zero display it and the date, else continue
 *      c) If array exceeded array size, continue, else move to step a
 * 10) If "Finish" chosen move to step 12
 * 11) Move to step 2
 * 12) Exit Program
*/


import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Scanner;
import java.util.Date;
import java.util.Random;

public class Task6 {

    private static Scanner userInput = new Scanner(System.in);

    /**
     * The menu method shows the menu on console, gets user input and validates
     * it before returning
     *
     * @return the menu option chosen by the user
     */
    public static int menu() {

        System.out.println("1. Submit articles");
        System.out.println("2. Delete article");
        System.out.println("3. View articles");
        System.out.println("4. Sales");
        System.out.println("5. Order history");
        System.out.println("6. Finish");
        System.out.println("Your choice: ");

        int num = input();

        //If the input is not a valid option from menu user is asked again
        while (num < 1 || num > 6) {

            System.out.println("Invalid Input. Please choose an option from menu. Try again.");
            num = input();

        }

        return num;
    }

    /**
     * The input method gets input for an integer from user (it makes sure that
     * invalid input is not allowed)
     *
     * @return the integer inputted by the user
     */
    public static int input() {

        //Getting input in string to avoid exception on int input
        String choice = userInput.nextLine();

        //Checking if choice is a valid integer, asking for input again otherwise
        boolean isValid = false;
        while (!isValid) {
            try {
                Integer.parseInt(choice);
                isValid = true;

            } catch (Exception e) {
                //The number was not valid so asking for input again
                System.out.println("The input is not a valid integer. Please try again.");
                System.out.println("Your Choice: ");
                choice = userInput.nextLine();
            }
        }

        return Integer.parseInt(choice);

    }

    /**
     * If the array of articles is more than half full, this method doubles the
     * size of array and returns it
     *
     * @param articles the array of articles
     * @return the new array if size is increased, otherwise the original array
     */
    public static int[][] checkFull(int[][] articles) {

        //Counting total number of non empty spots in the array
        int counter = 0;
        for (int i = 0; i < articles.length; i++) {

            //The spot is not empty if the article number is non zero
            if (articles[i][0] != 0) {
                counter++;
            }
        }

        //doubling array size if its more than half filled
        if (counter > articles.length / 2) {

            int temp[][] = new int[articles.length * 2][articles.length * 2];

            for (int i = 0; i < articles.length; i++) {
                for (int j = 0; j < 3; j++) {
                    //The inner loop copies the item number, quantity and price for this article
                    temp[i][j] = articles[i][j];
                }
            }
            articles = temp;

        }
        return articles;
    }

    /**
     * The insertArticle method adds new articles to the array
     *
     * @param articles array of articles
     * @param articleNumber the article number for the article to be added
     * @return
     */
    public static int insertArticle(int[][] articles, int articleNumber) {

        Random rand = new Random();

        System.out.println("Input the number of articles to insert: ");
        int amount = input();

        while (amount <= 0) {
            System.out.println("Invalid amount of articles. Please try again.");
            amount = input();
        }

        for (int i = 0; i < amount; i++) {

            int quantity = rand.nextInt(10) + 1; //The quantity is 1 to 10 inclusive
            int price = rand.nextInt(901) + 100; //The price is 100 to 1000 inclusive

            //Finding an empty spot in the array and adding to it
            boolean isAdded = false;
            for (int j = 0; j < articles.length && !isAdded; j++) {
                if (articles[j][0] == 0) {
                    articles[j][0] = ++articleNumber;
                    articles[j][1] = quantity;
                    articles[j][2] = price;
                    isAdded = true;
                }
            }

        }
        return articleNumber;
    }

    /**
     * The removeArticle method gets input for the article number and removes it
     * from the array if found
     *
     * @param articles the array of articles
     */
    public static void removeArticle(int[][] articles) {

        System.out.println("Input the article number: ");
        int articleNumber = input();

        boolean didRemove = false;
        //searching for the article and removing if possible
        for (int i = 0; i < articles.length && !didRemove; i++) {
            if (articles[i][0] == articleNumber) {

                articles[i][0] = 0;
                articles[i][1] = 0;
                articles[i][2] = 0;
                didRemove = true;
            }
        }

        if (!didRemove) {
            System.out.println("Error, article with this number not found");
        }

    }

    /**
     * Displays all articles on console
     *
     * @param articles the array of articles
     */
    public static void printArticles(int[][] articles) {

        for (int i = 0; i < articles.length; i++) {

            if (articles[i][0] != 0) {
                String str = "Article Number: " + articles[i][0];
                str += ", ";
                str += "Quantity: " + articles[i][1];
                str += ", ";
                str += "Price: " + articles[i][2];

                System.out.println(str);
            }
        }

    }

    /**
     * This method gets article number and quantity and sells it if possible
     *
     * @param sales the array of sales
     * @param salesDate the array of dates for sale
     * @param articles the array for articles
     */
    public static void sellArticle(int[][] sales, Date[] salesDate, int[][] articles) {
        System.out.println("Input the article number: ");
        int articleNumber = input();

        System.out.println("Input quantity: ");
        int quantity = input();

        while (quantity <= 0) {
            System.out.println("Invalid Quantity. Please try again.");
            quantity = input();
        }

        boolean didSell = false;

        //searching for the article and selling if possible
        for (int i = 0; i < articles.length && !didSell; i++) {
            if (articles[i][0] == articleNumber) {

                if (articles[i][1] >= quantity) {

                    //Reducing quantity in stock
                    articles[i][1] -= quantity;

                    int index = -1;

                    //finding a free space in sales array
                    for (int j = 0; j < sales.length && index == -1; j++) {
                        if (sales[j][0] == 0) {
                            index = j;
                        }
                    }

                    if (index != -1) {
                        //Adding to the sales
                        sales[index][0] = articles[index][0];
                        sales[index][1] = quantity;
                        sales[index][2] = quantity * articles[0][2];   //The total sum is equal to qunatity * price
                        salesDate[index] = new Date();
                        didSell = true;
                    }
                } else {
                    System.out.println("Error, could not sell. The quantity in stock is not enough");
                }

            }
        }
    }

    /**
     * This method displays all sales on console
     *
     * @param sales the array of sales
     * @param salesDate the array of dates
     */
    public static void printSales(int[][] sales, Date[] salesDate) {
        for (int i = 0; i < sales.length; i++) {
            if (sales[i][0] != 0) {

                DateFormat df = new SimpleDateFormat("dd/MM/yy HH:mm:ss");
                String str = "Article Number: " + sales[i][0];
                str += ", ";
                str += "Quantity: " + sales[i][1];
                str += ", ";
                str += "Total Sum: " + sales[i][2];
                str += ", ";
                str += "Date: " + df.format(salesDate[i]);
                System.out.println(str);

            }
        }

    }

    public static void main(String args[]) {

        boolean keepRunning = true;

        int articles[][] = new int[10][3];

        int sales[][] = new int[100][3];
        Date saleDates[] = new Date[100];
        int articleNumber = 999;

        while (keepRunning) {

            int choice = menu();

            if (choice == 1) {
                articles = checkFull(articles);
                articleNumber = insertArticle(articles, articleNumber);
            } else if (choice == 2) {
                removeArticle(articles);
            } else if (choice == 3) {
                printArticles(articles);
            } else if (choice == 4) {
                sellArticle(sales, saleDates, articles);
            } else if (choice == 5) {
                printSales(sales, saleDates);
            } else if (choice == 6) {
                keepRunning = false;
            }

        }

    }

}
