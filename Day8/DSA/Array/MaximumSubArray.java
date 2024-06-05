public class MaximumSubArray {

    public static int maximumSubArraySum(int []arr){
        int cs = 0;
        int ms = Integer.MIN_VALUE;
        for(int i=0; i< arr.length; i++){
            cs = cs + arr[i];
            if(cs < 0){
                cs = 0;
            }
            ms = Math.max(cs,ms);
        }
        return ms;
    }

    public static void main(String[] args) {
        int []arr ={-2,1,-3,4,-1,2,1,-5,4};
        System.out.println(maximumSubArraySum(arr));
    }

}
