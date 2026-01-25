package Flames;

import java.util.Scanner;

public class Flames {
    static void findFlames(String name1, String name2) {

        // Converting the string to characterArray
        char arr[] = name1.toCharArray();
        char brr[] = name2.toCharArray();

        // Initialising the variable count to count the number of letters getting
        // cancelled
        int count = 0;

        // Removing the same letters in both the names
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < brr.length; j++) {
                if (arr[i] == brr[j]) {
                    arr[i] = ' ';
                    brr[j] = '*';
                    count++;
                    break;
                }
            }
        }

        /*
         * Multiplying the count with 2 since we have cancelled in both the names and
         * Subtracting from the total length
         */
        count = count * 2;
        int total = name1.length() + name2.length() - count;
        // System.out.println("Remaining letters = " + total);

        // Creating a string with value FLAMES
        String flames = "FLAMES";
        int index = 0;

        // Important part of the code 
        while (flames.length() != 1) {
            index = (total % flames.length()) - 1;
            if (index >= 0)
                flames = flames.substring(index + 1) + flames.substring(0, index);
            else
                flames = flames.substring(0, flames.length() - 1);
        }

        // Finaly we would get a letter and passing it to switch case and print the results
        char output = flames.charAt(0);
        switch (output) {
            case 'F':
                System.out.println("FRIENDS");
                break;
            case 'L':
                System.out.println("LOVE");
                break;
            case 'A':
                System.out.println("AFFECTION");
                break;
            case 'M':
                System.out.println("MARRAIGE");
                break;
            case 'E':
                System.out.println("ENEMY");
                break;
            case 'S':
                System.out.println("SIBLINGS");
                break;
            default:
                break;
        }
    }

    public static void main(String[] args) {

        // Getting input from the user's name and their crush name
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter your name = ");
        String your_name = sc.nextLine().toLowerCase().replaceAll(" ", "");
        System.out.print("Enter your crush's name = ");
        String crush_name = sc.nextLine().toLowerCase().replaceAll(" ", "");

        // Calling the function findFlames();
        findFlames(your_name, crush_name);
        sc.close();
    }
}