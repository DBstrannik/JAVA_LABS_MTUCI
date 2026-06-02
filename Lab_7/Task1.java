public class Task1 {

    public static class SumThread extends Thread {
        private final int[] array;
        private final int start;
        private final int end;
        private int partialSum;

        public SumThread(int[] array, int start, int end) {
            this.array = array;
            this.start = start;
            this.end = end;
            this.partialSum = 0;
        }

        @Override
        public void run() {
            for (int i = start; i < end; i++) {
                partialSum += array[i];
            }
        }

        public int getPartialSum() {
            return partialSum;
        }
    }

    public static void main(String[] args) {
        int[] array = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int mid = array.length / 2;

        SumThread thread1 = new SumThread(array, 0, mid);
        SumThread thread2 = new SumThread(array, mid, array.length);

        thread1.start();
        thread2.start();

        try {
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        int totalSum = thread1.getPartialSum() + thread2.getPartialSum();
        System.out.println("Сумма элементов массива: " + totalSum);
    }
}