import java.util.Scanner;

public class PyramidPattern {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int row = sc.nextInt();

        for(int i = 1; i <= row; i++){
            for(int j = 1; j <= row-i; j++){
                System.out.print(" ");
            }
            for(int j = 1; j <= i ; j++){
                System.out.print(j + "");
            }
            for(int j=i-1; j >= 1; j--){
                System.out.print(j);
            }
            System.out.println();
        }

    }
}
