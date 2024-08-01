class InsertionSort extends SortStrategy {
    @Override
    void sort(int[] values) {
        for (int i = 1; i < values.length; i++) {
            int key = values[i];
            int j = i - 1;
            while (j >= 0 && values[j] > key) {
                values[j + 1] = values[j];
                j = j - 1;
            }
            values[j + 1] = key;
        }
    }

    @Override
    void sort(char[] values) {
        for (int i = 1; i < values.length; i++) {
            char key = values[i];
            int j = i - 1;
            while (j >= 0 && values[j] > key) {
                values[j + 1] = values[j];
                j = j - 1;
            }
            values[j + 1] = key;
        }
    }
}
