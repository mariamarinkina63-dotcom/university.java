package lab2;

/*Перестроить матрицу, переставляя в нейстроки так, чтобы сумма элементов в строках полученной матрицы возрастала.*/

import java.util.Scanner;
import java.util.Random;

public class num20 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random rnd = new Random();

        System.out.print("Введите количество строк n: ");
        int n = sc.nextInt();
        System.out.print("Введите количество столбцов m: ");
        int m = sc.nextInt();

        System.out.print("Заполнить случайно (1) или вручную (2)? ");
        int mode = sc.nextInt();

        int[][] a = new int[n][m];

        if (mode == 1) {
            for (int i = 0; i < n; i++)
                for (int j = 0; j < m; j++)
                    a[i][j] = rnd.nextInt(21) - 10;
        } else {
            System.out.println("Введите " + (n * m) + " элементов матрицы:");
            for (int i = 0; i < n; i++)
                for (int j = 0; j < m; j++)
                    a[i][j] = sc.nextInt();
        }

        System.out.println("\nИсходная матрица:");
        printMatrix(a);

        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - 1 - i; j++) {
                if (rowSum(a[j]) > rowSum(a[j + 1])) {
                    int[] tmp = a[j];
                    a[j] = a[j + 1];
                    a[j + 1] = tmp;
                }
            }
        }

        System.out.println("\nМатрица после сортировки строк по возрастанию суммы:");
        printMatrix(a);

        System.out.println("\nСуммы строк:");
        for (int i = 0; i < n; i++)
            System.out.println("Строка " + (i + 1) + ": " + rowSum(a[i]));
    }

    static int rowSum(int[] row) {
        int s = 0;
        for (int x : row) s += x;
        return s;
    }

    static void printMatrix(int[][] m) {
        for (int[] row : m) {
            for (int x : row) System.out.printf("%5d", x);
            System.out.println();
        }
    }
}
