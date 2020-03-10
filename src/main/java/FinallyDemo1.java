/**
 * @ Author: Mr.Li
 * @ Date: 2020-02-20 16:36
 * @ Description: Java面试题， 在try-catch-finally 如果在catch 中代码中有return返回的时候，finally 会不会执行
 **/
public class FinallyDemo1 {
    public static void main(String[] args) {
        System.out.println(getInt());
    }

    public static int getInt() {
        int a = 20;

        try {
            System.out.println(a/0);
        } catch (Exception e) {
            a = 30;
            return a;
        } finally {
            a = 40;
//            return a; 写道这里面也是可以的。
        }
        return a;
    }


}
