package lab2;
/*Дана квадратная матрица. Построить матрицу, вычитая из максимальных(минимальных, нулевых)
элементов каждой строки матрицы среднее арифметическое элементов строки.
Затем отсортировать строки матрицы повозрастанию(убыванию) элементов стоящихнадиагонали.*/

import java.util.Scanner;
import java.util.Random;

public class num10 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random rnd = new Random();

        System.out.print("Введите размер квадратной матрицы n: ");
        int n = sc.nextInt();

        System.out.print("Заполнить случайно (1) или вручную (2)? ");
        int mode = sc.nextInt();

        double[][] a = new double[n][n];

        if (mode == 1) {
            for (int i = 0; i < n; i++)
                for (int j = 0; j < n; j++)
                    a[i][j] = rnd.nextInt(21) - 10;
        } else {
            System.out.println("Введите " + (n * n) + " элементов матрицы:");
            for (int i = 0; i < n; i++)
                for (int j = 0; j < n; j++)
                    a[i][j] = sc.nextDouble();
        }

        System.out.println("\nИсходная матрица:");
        printMatrix(a);

        double[][] b = new double[n][n];
        for (int i = 0; i < n; i++) {
            double sum = 0;
            int maxIdx = 0;
            for (int j = 0; j < n; j++) {
                sum += a[i][j];
                if (a[i][j] > a[i][maxIdx]) maxIdx = j;
            }
            double avg = sum / n;
            for (int j = 0; j < n; j++) b[i][j] = a[i][j];
            b[i][maxIdx] = a[i][maxIdx] - avg;
        }

        System.out.println("\nМатрица после замены максимума на (максимум - среднее):");
        printMatrix(b);

        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - 1 - i; j++) {
                if (b[j][j] > b[j + 1][j + 1]) {
                    double[] tmp = b[j];
                    b[j] = b[j + 1];
                    b[j + 1] = tmp;
                }
            }
        }

        System.out.println("\nСтроки отсортированы по возрастанию диагонального элемента:");
        printMatrix(b);
    }

    static void printMatrix(double[][] m) {
        for (double[] row : m) {
            for (double x : row) System.out.printf("%9.2f", x);
            System.out.println();
        }
    }

}
