public class Task2 {

    public static class RowMaxThread extends Thread {
        private final int[] row;
        private int maxInRow;

        public RowMaxThread(int[] row) {
            this.row = row;
        }

        @Override
        public void run() {
            if (row.length == 0) return;
            maxInRow = row[0];
            for (int i = 1; i < row.length; i++) {
                if (row[i] > maxInRow) {
                    maxInRow = row[i];
                }
            }
        }

        public int getMaxInRow() {
            return maxInRow;
        }
    }

    public static void main(String[] args) {
        int[][] matrix = {
            {3, 5, 1, 9},
            {12, 4, 7, 2},
            {6, 0, 18, 5}
        };

        RowMaxThread[] threads = new RowMaxThread[matrix.length];

        for (int i = 0; i < matrix.length; i++) {
            threads[i] = new RowMaxThread(matrix[i]);
            threads[i].start();
        }

        try {
            for (RowMaxThread thread : threads) {
                thread.join();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        int globalMax = threads[0].getMaxInRow();
        for (int i = 1; i < threads.length; i++) {
            if (threads[i].getMaxInRow() > globalMax) {
                globalMax = threads[i].getMaxInRow();
            }
        }

        System.out.println("Наибольший элемент в матрице: " + globalMax);
    }
}