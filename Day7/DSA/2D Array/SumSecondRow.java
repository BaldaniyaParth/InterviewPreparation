public class SumSecondRow {

    public static int sumOfRow(int [][]arr, int row){
        int i = row;
        int sum = 0;
        for(int j=0; j<arr[0].length; j++){
            sum += arr[i][j];
        }
        return sum;
    }

    public static void main(String[] args) {
        int [][]arr = {{1,4,9}, {11,4,3}, {2,2,3}};
        int row = 1;
        System.out.println(sumOfRow(arr, row));
    }
}
