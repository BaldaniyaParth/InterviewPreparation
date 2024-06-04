public class NumberPyramid {
    public static void Number_Pyramid(int n){
        for(int i=1; i<=n; i++){
            for(int j=1; j<=n-i; j++){
                System.out.print(" ");
            }
            for(int j=1; j<=i; j++){
                System.out.print(i+" ");
            }
            System.out.println();
        }
    }
    public static void main(String[] args) {
        Number_Pyramid(5);
    }
}

output :-
    1 
   2 2
  3 3 3
 4 4 4 4
5 5 5 5 5
