import java.util.Scanner;

public class Palindrame {

    public static void isPalindrame(int number){
        int num = number;
        int sum = 0;
        while(num != 0 ){
            int rem = num % 10;
            sum = (sum * 10) + rem;
            num = num / 10;
        }
        if(number == sum){
            System.out.println("Palindrame");
        }else{
            System.out.println("Not Palindrame");
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        isPalindrame(n);
    }
}
