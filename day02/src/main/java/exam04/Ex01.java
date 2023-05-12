package exam04;

public class Ex01 {
    public static void main(String[] args) {
        SimpleCalculator calculator1 = new SimpleCalculator();
        RecCalculator calculator2 = new RecCalculator();

        long stime = System.nanoTime();
        long result1 = calculator1.factorial(20);
        long etime = System.nanoTime();
        System.out.printf("calculator1=%d%n", result1);
        System.out.printf("걸린시간 : %d%n", etime - stime);

        stime = System.nanoTime();
        long result2 = calculator2.factorial(20);
        etime = System.nanoTime();
        System.out.printf("calculator2=%d%n", result2);
        System.out.printf("걸린시간 : %d%n", etime - stime);



    }
}
