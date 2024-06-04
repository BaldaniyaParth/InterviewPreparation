public class SumOfDigits {

    public static int sumOfDigit(int num){
        int sum = 0;
        while(num > 0){
            int lastDigit = num % 10;
            sum += lastDigit;
            num = num / 10;
        }
        return sum;
    }

    public static void main(String[] args) {
        System.out.println(sumOfDigit(123456));
    }
}
