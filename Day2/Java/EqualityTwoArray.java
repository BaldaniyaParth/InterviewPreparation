import java.util.Arrays;
public class EqualityTwoArray {


    public static void main(String[] args) {
        String[] s1 = {"java", "j2ee", "struts", "hibernate"};

        String[] s2 = {"jsp", "spring", "jdbc", "hibernate"};

        String[] s3 = {"java", "j2ee", "struts", "hibernate"};

        System.out.println(Arrays.equals(s1, s2));

        System.out.println(Arrays.equals(s1, s3));
    }
}
