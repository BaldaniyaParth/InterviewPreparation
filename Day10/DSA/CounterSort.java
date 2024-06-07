public class CounterSort {

    public static void counterSort(int []arr){
        int largest = Integer.MIN_VALUE;
        for(int i=0; i< arr.length; i++){
            largest = Math.max(largest, arr[i]);
        }

        int []count = new int [largest+1];

        for(int j = 0; j < arr.length ; j++){
            count[arr[j]]++;
        }

        int a = 0;
        for (int k=0; k < count.length; k++){
            while(count[k] > 0){
                arr[a] = k;
                a++;
                count[k]--;
            }
        }
    }

    public static void main(String[] args) {
        int []arr = {3,6,2,1,8,7,4,5,3,1};
        counterSort(arr);
        for(int i=0; i<arr.length; i++){
            System.out.print(arr[i] + " , ");
        }
    }
}
