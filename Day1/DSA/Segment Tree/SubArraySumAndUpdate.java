public class SubArraySumAndUpdate {

    static int tree[];

    public static void init(int n){
        tree = new int[4*n];
    }

    public static int buildST(int arr[], int i, int start, int end){
        if(start == end){
            tree[i] = arr[start];
            return arr[start];
        }

        int mid = (start + end) / 2;
        buildST(arr, 2*i+1, start, mid);
        buildST(arr, 2*i+2, mid+1, end);
        tree[i] = tree[2*i+1] + tree[2*i+2];
        return tree[i];
    }

    public static int getSum(int i, int si, int sj, int qi, int qj){
        if(qj <= si || qi >= sj){
            return 0;
        }else if(si >= qi && sj <= qj){
            return tree[i];
        }else{
            int mid = (si + sj)/2;
            return getSum(2*i+1, si, mid, qi, qj) + getSum(2*i+2, mid+1, sj, qi, qj);
        }
    }

    public static void updateUtil(int i, int si, int sj, int idx, int diff){
        if(idx > sj || idx <si){
            return;
        }

        tree[i] += diff;

        if(si != sj){
            int mid = (si + sj) / 2;
            updateUtil(2*i+1, si, mid, idx, diff);
            updateUtil(2*i+2, mid+1, sj, idx, diff);
        }
    }
    public static void update(int arr[], int idx, int newValue){
        int n = arr.length;
        int diff = newValue - arr[idx];
        arr[idx] = newValue;

        updateUtil(0,0, n-1, idx, diff);
    }

    public static void main(String[] args) {
        int [] arr = {1,2,3,4,5,6,7,8};
        int n = arr.length;
        init(n);
        buildST(arr,0, 0, n-1);

        System.out.println(getSum(0, 0, n-1, 2, 5));

       update(arr, 2, 2);

        System.out.println(getSum(0, 0, n-1, 2, 5));


    }

}
