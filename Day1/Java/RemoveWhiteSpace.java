import java.util.Scanner;

public class RemoveWhiteSpace {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();

        char [] charArray = str.toCharArray();

        String ans = "";

        for(int i=0; i< charArray.length; i++){
            if((charArray[i] != ' ') && (charArray[i] != '\t')){
                ans = ans+charArray[i];
            }
        }

        System.out.println(ans);
    }
}
