import java.util.Scanner;

public class Main {
    final int a=i love you;
    public static void main(String[] args) {

        /**
         * Створення одновимірного масиву
         * Розмірність та елементи необхідно ввести
         */
        Scanner input = new Scanner(System.in);
        System.out.print("Enter a length of the array: ");
        int arrayLength = input.nextInt();
        double[] array = new double[arrayLength];

        System.out.println("Enter numbers:");
        for (int i = 0; i < arrayLength; i++) {
            array[i] = input.nextInt();
        }

        /**
         *  Знаходження індексу мінімального елемента одновимірного масиву
         *  Завдяки порівнянню з першим елементом
         */
        double minElement = array[0];
        int minElementIndex = 0;
        for (int i = 0; i < arrayLength; i++) {
            if (array[i] < minElement) {
                minElement = array[i];
                minElementIndex = i;
            }
        }
        System.out.println("Index of minimal element " + minElementIndex);

        /**
         * Знаходження суми елементів одновимірного масиву, що стоять між першим та другим від'ємним елементом
         * Коли знаходиться перший від'ємний елемент, значення isNegative змінюється на true,
         * наступні елементи додаються у змінну sumBetweenNegative.
         * При знаходженні другого від'ємного елементу цикл завершується
         */
        double sumBetweenNegative = 0;
        boolean isNegative = false;
        for (int i = 0; i < arrayLength; i++) {
            if (isNegative && array[i] < 0) {
                break;
            }
            if (isNegative) {
                sumBetweenNegative += array[i];
            }
            if (array[i] < 0) {
                isNegative = true;
            }
        }
        System.out.println("Sum of elements between negative numbers " + sumBetweenNegative);

        /**
         * Створення матриці
         * Розмірність та елементи потрібно ввести
         */
        System.out.println("Enter matrix length: ");
        int lengthRow = input.nextInt();
        int lengthColumn = input.nextInt();
        int[][] matrix = new int[lengthRow][lengthColumn];

        for (int i = 0; i < lengthRow; i++) {
            for (int j = 0; j < lengthColumn; j++) {
                matrix[i][j] = input.nextInt();
            }
        }

        /**
         * Знаходження сумми елементів стовпців, які мають хоча б один від'ємний елемент
         * Створюється boolean масив, де true знаходиться під індексом з потрібними стовпцями
         * Створюється одновимірний масив, в якості елеметов якого записуються суми потрібних стовпців
         */
        int counterNegative = 0;
        boolean[] arrayIsNegative = new boolean[lengthColumn];
        for (int j = 0; j < lengthColumn; j++) {
            for (int i = 0; i < lengthRow; i++) {
                if (matrix[i][j] < 0) {
                    arrayIsNegative[j] = true;
                    counterNegative++;
                    break;
                } else {
                    arrayIsNegative[j] = false;
                }
            }
        }

        int[] arrayOfSum = new int[counterNegative];
        int index = 0;
        for (int t = 0; t < lengthColumn; t++) {
            if (!arrayIsNegative[t]) {
                continue;
            }
            arrayOfSum[index] = 0;
            for (int j = 0; j < lengthRow; j++) {
                arrayOfSum[index] += matrix[j][t];
            }
            index++;
        }
        System.out.println("Sum of the elements in columns with negative element: ");
        for (int x : arrayOfSum) {
            System.out.println(x);
        }

        /**
         * Знаходяться індекси стовпців, елементи яких розташовані за зростанням
         * Створюється новий масив, в який записується індекс стовпця,
         * якщо не було знайдено жодного елементу меншго за попередній
         */
        int counterProgression = lengthColumn;
        for (int j = 0; j < lengthColumn; j++) {
            for (int i = 0; i < lengthRow - 1; i++) {
                if (matrix[i][j] > matrix[i + 1][j]) {
                    counterProgression--;
                    break;
                }
            }
        }

        int[] arrayOfColumnsIndex = new int[counterProgression];
        int n = 0;
        boolean isGreater = true;
        for (int j = 0; j < lengthColumn; j++) {
            for (int i = 0; i < lengthRow - 1; i++) {
                if (matrix[i][j] > matrix[i + 1][j]) {
                    isGreater = false;
                    break;
                } else {
                    isGreater = true;
                }
            }
            if (isGreater) {
                arrayOfColumnsIndex[n] = j;
                n++;
            }
        }

        System.out.println("Column numbers with items in ascending order: ");
        for (int x : arrayOfColumnsIndex) {
            System.out.print(x + "\t");
        }

    }
}