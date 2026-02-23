package sorting;

public class Main {
    public static void main(String[] args) {

        int[] testInput = randomArray(20);

        TestSuite.run(testInput, 1);
    }

    public static int[] randomArray(int length) {

        int[] a = new int[length];

        for (int i = 0; i < length; i++) {
            int g = (int) Math.random() * 101;
            a[i] = g;
        }
        return a;
    }

}
