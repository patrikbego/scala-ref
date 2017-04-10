/**
 * Created by patrik007 on 07/04/2017.
 */
public class FunctionsJ {

    public static void main(String[] args) {
        System.out.println(addInteger(removeInteger(2, 1), 2));
        delayed(time());

    }

    public static Integer removeInteger(int a, int b) {
        return a - b;
    }


    public static Integer addInteger(Integer a, Integer b) {
        return a + b;
    }

    public static Long time() {
        System.out.println("Getting time in nano seconds");
        return System.nanoTime();
    }
    public static void delayed(Long t)  {
        System.out.println("In delayed method");
        System.out.println("Param: " + t);
    }


}
