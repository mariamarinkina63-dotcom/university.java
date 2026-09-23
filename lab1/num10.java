/*Найти все пятизначные натуральные числа из заданной последовательности чисел,
в которых наименьшее число, кратное n такое, что первая его цифра равна пяти и все
цифры различны. Подсчитать количество таких чисел.*/

import java.util.Scanner;

public class num10 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Введите количество чисел в последовательности: ");
        int count = sc.nextInt();

        System.out.println("Введите " + count + " чисел последовательности:");
        int found = 0;

        for (int i = 0; i < count; i++) {
            int n = sc.nextInt();
            Integer result = findSmallestMultiple(n);
            if (result != null) {
                System.out.println(n + " -> " + result);
                found++;
            } else {
                System.out.println(n + " -> нет");
            }
        }

        System.out.println("Количество: " + found);
    }

    static Integer findSmallestMultiple(int n) {
        if (n <= 0) return null;
        int start = ((50000 + n - 1) / n) * n;
        for (int m = start; m <= 59999; m += n) {
            if (hasDistinctDigits(m)) {
                return m;
            }
        }
        return null;
    }

    static boolean hasDistinctDigits(int m) {
        boolean[] seen = new boolean[10];
        while (m > 0) {
            int d = m % 10;
            if (seen[d]) return false;
            seen[d] = true;
            m /= 10;
        }
        return true;
    }
}