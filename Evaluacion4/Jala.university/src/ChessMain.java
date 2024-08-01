public class ChessMain {
    public static void main(String[] args) {
        System.out.println("Número de argumentos: " + args.length);
        for (int i = 0; i < args.length; i++) {
            System.out.println("Argumento " + i + ": " + args[i]);
        }

        if (args.length < 4) {
            System.out.println("Parametros insuficientes");
            return;
        }

        SortingAlgorithm sortingAlgorithm = parseSortingAlgorithm(args[0]);
        ValueType valueType = parseValueType(args[1]);
        PieceColor pieceColor = parsePieceColor(args[2]);
        int pieceCount = parsePieceCount(args[3]);

        // Verifica si pieceCount es positivo
        if (pieceCount <= 0) {
            System.out.println("Número de piezas inválido");
            return;
        }

        int[] numericValues = null;
        char[] characterValues = null;

        if (valueType == ValueType.NUMERIC) {
            numericValues = new int[pieceCount];
            int[] exampleNumericValues = {5, 8, 15, 16, 1, 2, 9, 10, 11, 6, 7, 13, 14, 3, 4, 12};
            pieceCount = Math.min(pieceCount, exampleNumericValues.length); // Asegúrate de que pieceCount no exceda el tamaño del arreglo
            System.arraycopy(exampleNumericValues, 0, numericValues, 0, pieceCount);
        } else if (valueType == ValueType.CHARACTER) {
            characterValues = new char[pieceCount];
            char[] exampleCharacterValues = {'m', 'j', 'k', 'l', 'e', 'n', 'c', 'd', 'b', 'g', 'h', 'i', 'f', 'o', 'p', 'a'};
            pieceCount = Math.min(pieceCount, exampleCharacterValues.length); // Asegúrate de que pieceCount no exceda el tamaño del arreglo
            System.arraycopy(exampleCharacterValues, 0, characterValues, 0, pieceCount);
        }

        Chess chess = new Chess(sortingAlgorithm, valueType, pieceColor, pieceCount, numericValues, characterValues);
        chess.sortAndPrint();
    }

    private static SortingAlgorithm parseSortingAlgorithm(String arg) {
        switch (arg) {
            case "i":
                return SortingAlgorithm.INSERTION_SORT;
            case "q":
                return SortingAlgorithm.QUICK_SORT;
            default:
                return SortingAlgorithm.INVALID;
        }
    }

    private static ValueType parseValueType(String arg) {
        switch (arg) {
            case "c":
                return ValueType.CHARACTER;
            case "n":
                return ValueType.NUMERIC;
            default:
                return ValueType.INVALID;
        }
    }

    private static PieceColor parsePieceColor(String arg) {
        switch (arg) {
            case "b":
                return PieceColor.BLACK;
            case "w":
                return PieceColor.WHITE;
            default:
                return PieceColor.INVALID;
        }
    }

    private static int parsePieceCount(String arg) {
        try {
            return Integer.parseInt(arg);
        } catch (NumberFormatException e) {
            return 0;
        }
    }
}
