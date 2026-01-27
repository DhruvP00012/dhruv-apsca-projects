package warmup;

public class Main {

    public static void main(String[] args) {
           int sum1 = 0;
           int sum2 = 0;
           int sum3 = 0;
           int sum4 = 0;
           for(int i = 0; i < 1000; i++) {
               if (i % 3 == 0 && i % 5 == 0) {
                   sum1 += i;
               }else if (i % 3 == 0 && i % 5 != 0) {
                   sum2 += i;
               }else if (i %3 != 0 && i % 5 == 0) {
                   sum3 += i;
               }else {
                   sum4 = sum4 + 0;
               }
           }
        System.out.print(sum1 + sum2 + sum3 +sum4);

        public static int[] genRanArray (int size) {
            
        }
    }
}
