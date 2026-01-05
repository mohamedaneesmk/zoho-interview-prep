import java.util.Scanner;

public class Pseudobinary {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        System.out.println(findPseudobinary(num));
        sc.close();
    } 

    private static int findPseudobinary(int num){
        int maxNum = 0;
        while (num>0) {
            int digit = num%10;
            maxNum = Math.max(maxNum, digit);
            num = num/10;
        }
        return maxNum;
    }
}
