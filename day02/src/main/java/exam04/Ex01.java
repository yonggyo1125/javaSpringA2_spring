package exam04;

public class Ex01 {
    public static void main(String[] args) {
        Calculator calculator1 = new ProxyCalculator(new SimpleCalculator());
        Calculator calculator2 = new ProxyCalculator(new RecCalculator());

        long result1 = calculator1.factorial(20);
        System.out.printf("calculator1=%d%n", result1);


        long result2 = calculator2.factorial(20);
        System.out.printf("calculator2=%d%n", result2);

    }
}
