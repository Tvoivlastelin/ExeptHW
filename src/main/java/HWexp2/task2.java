package HWexp2;

public class task2 {
    public static void main(String[] args) {
        try {
            int d = 0;
            double[] intArray = new double[10];
            double catchedRes1 = intArray[8] / d;
            System.out.println("catchedRes1 = " + catchedRes1);
        } catch (ArithmeticException | ArrayIndexOutOfBoundsException e) {
            System.out.println("Catching exception: " + e);
        }
    }
}
