
/**
 *
 * @author ly-jiangxh
 * @date 2021/07/05 18:10
 **/
public class Test {

    public static void main(String[] args) {
        int n = 17 - 1;
        n |= n >>> 1;
        n |= n >>> 2;
        n |= n >>> 4;
        n |= n >>> 8;
        n |= n >>> 16;
        System.out.println((n < 0) ? 1 : (n >= 5000) ? 5000 : n + 1);
    }
}
