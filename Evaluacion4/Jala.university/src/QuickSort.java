class QuickSort extends SortStrategy {
    @Override
    void sort(int[] values) {
        quickSort(values, 0, values.length - 1);
    }

    private void quickSort(int[] values, int low, int high) {
        if (low < high) {
            int pi = partition(values, low, high);
            quickSort(values, low, pi - 1);
            quickSort(values, pi + 1, high);
        }
    }

    private int partition(int[] values, int low, int high) {
        int pivot = values[high];
        int i = (low - 1);
        for (int j = low; j < high; j++) {
            if (values[j] <= pivot) {
                i++;
                int temp = values[i];
                values[i] = values[j];
                values[j] = temp;
            }
        }
        int temp = values[i + 1];
        values[i + 1] = values[high];
        values[high] = temp;
        return i + 1;
    }

    @Override
    void sort(char[] values) {
        quickSort(values, 0, values.length - 1);
    }

    private void quickSort(char[] values, int low, int high) {
        if (low < high) {
            int pi = partition(values, low, high);
            quickSort(values, low, pi - 1);
            quickSort(values, pi + 1, high);
        }
    }

    private int partition(char[] values, int low, int high) {
        char pivot = values[high];
        int i = (low - 1);
        for (int j = low; j < high; j++) {
            if (values[j] <= pivot) {
                i++;
                char temp = values[i];
                values[i] = values[j];
                values[j] = temp;
            }
        }
        char temp = values[i + 1];
        values[i + 1] = values[high];
        values[high] = temp;
        return i + 1;
    }
}
