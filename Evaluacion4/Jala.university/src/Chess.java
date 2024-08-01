class Chess {
    private SortingAlgorithm sortingAlgorithm;
    private ValueType valueType;
    private PieceColor pieceColor;
    private int pieceCount;
    private int[] numericValues;
    private char[] characterValues;
    private SortStrategy sortStrategy;

    public Chess(SortingAlgorithm sortingAlgorithm, ValueType valueType, PieceColor pieceColor, int pieceCount, int[] numericValues, char[] characterValues) {
        this.sortingAlgorithm = sortingAlgorithm;
        this.valueType = valueType;
        this.pieceColor = pieceColor;
        this.pieceCount = pieceCount;
        this.numericValues = numericValues;
        this.characterValues = characterValues;
        setSortStrategy();
    }

    private void setSortStrategy() {
        switch (sortingAlgorithm) {
            case INSERTION_SORT:
                this.sortStrategy = new InsertionSort();
                break;
            case QUICK_SORT:
                this.sortStrategy = new QuickSort();
                break;
            default:
                throw new IllegalArgumentException("Invalid sorting algorithm");
        }
    }

    public void sortAndPrint() {
        if (valueType == ValueType.INVALID || pieceColor == PieceColor.INVALID || pieceCount <= 0) {
            System.out.println("Ordenamiento: Invalido");
            System.out.println("Tipo: Invalido");
            System.out.println("Color: Invalido");
            System.out.println("Valores: []");
            System.out.println("Valores Invalidos");
            return;
        }

        System.out.println("Ordenamiento: " + (sortingAlgorithm == SortingAlgorithm.INSERTION_SORT ? "Insertion sort" : "Quick sort"));
        System.out.println("Tipo: " + (valueType == ValueType.CHARACTER ? "Caracter" : "Numerico"));
        System.out.println("Color: " + (pieceColor == PieceColor.BLACK ? "Negras" : "Blancas"));

        if (valueType == ValueType.NUMERIC && numericValues != null) {
            System.out.print("Valores: ");
            for (int value : numericValues) {
                System.out.print(value + " ");
            }
            System.out.println();
            sortStrategy.sort(numericValues);
            System.out.print("Ordenado: ");
            for (int value : numericValues) {
                System.out.print(value + " ");
            }
            System.out.println();
        } else if (valueType == ValueType.CHARACTER && characterValues != null) {
            System.out.print("Valores: ");
            for (char value : characterValues) {
                System.out.print(value + " ");
            }
            System.out.println();
            sortStrategy.sort(characterValues);
            System.out.print("Ordenado: ");
            for (char value : characterValues) {
                System.out.print(value + " ");
            }
            System.out.println();
        }
    }
}
