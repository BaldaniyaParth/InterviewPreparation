public class PalindromicNumber {
    public static void Palindromic_Number(int n){
        for(int i=1; i<=n; i++){
            for(int j=1; j<=n-i; j++){
                System.out.print(" ");
            }
            for(int j=i; j>=1; j--){
                System.out.print(j);
            }
            for(int j=2; j<=i; j++){
                System.out.print(j);
            }
            System.out.println();
        }
    }
    public static void main(String[] args) {
        Palindromic_Number(10);
    }
}

output :-
         1
        212
       32123
      4321234
     543212345
    65432123456
   7654321234567
  876543212345678
 98765432123456789
109876543212345678910
