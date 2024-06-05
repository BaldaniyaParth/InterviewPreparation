public class TransposeMatrix {

    public static void main(String[] args) {
        int [][]arr = {{1,2,3},{4,5,6}};

        int [][]transpose = new int[arr[0].length][arr.length];

        for(int i=0; i< transpose.length; i++){
            for(int j=0; j< transpose[0].length; j++){
                System.out.print(arr[j][i]);
            }
            System.out.println();
        }
    }
}
