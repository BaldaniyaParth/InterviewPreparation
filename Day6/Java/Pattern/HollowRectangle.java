public class HollowRectangle{
    public static void Hollow_Rectangle(int n){
        for(int i=1; i<=n; i++){
            for(int j=1; j<=n+1; j++){
                if(i==1 || i==n || j==1 || j==n+1){
                    System.out.print("*");
                }
                else{
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
    }
    public static void main(String[] args) {
        Hollow_Rectangle(4);
    }
}

output :-
    *****
    *   *
    *   *
    *****
