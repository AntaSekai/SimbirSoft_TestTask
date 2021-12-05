import java.lang.Integer;
public class testKata {
    public static void main(String[] args) {
        System.out.println(BitsOfInteger.reverse_bits(22));
    }
    public class BitsOfInteger{
        public static int reverse_bits(int n) {
            return Integer.parseInt(new StringBuilder(Integer.toBinaryString(n)).reverse() + "", 2);
        }
    }
}
