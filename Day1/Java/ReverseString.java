public class ReverseString {
    public static void main(String[] args) {
        String str = "PARTH";
        System.out.println(reverseString(str));
    }

    public static String reverseString(String str){
        if(str == null || str.length() <= 1){
            return str;
        }
        return reverseString(str.substring(1))+str.charAt(0);
    }
}
