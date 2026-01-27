package sorting;

public class SelectionSort implements Sorter {

    public void sort(int[] input) {
        System.out.println("Selection Sort!!!");
        int n = input.length;

        for (int i = 0; i < n - 1; i++) {
            int minimum = i;
            for (int j = i + 1; j < n; j++) {
                if (input[j] < input[minimum]) {
                    minimum = j;
                }
            }
            int temp = input[minimum];
            input[minimum] = input[i];
            input[i] = temp;
        }
    }
}
