/*Найти первое простое число n в заданной последовательности натуральных чисел
с максимальной суммой цифр*/

import java.util.Scanner;

public class num14 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Сколько чисел в последовательности? ");
        if (!scanner.hasNextInt()) {
            System.out.println("Нужно ввести целое число.");
            return;
        }

        int count = scanner.nextInt();

        System.out.println("Введите " + count + " натуральных чисел:");
        Integer bestPrime = null;
        int bestDigitSum = -1;

        for (int i = 0; i < count; i++) {
            int number = scanner.nextInt();

            if (isPrime(number)) {
                int sum = digitSum(number);

                if (sum > bestDigitSum) {
                    bestDigitSum = sum;
                    bestPrime = number;
                }
            }
        }

        if (bestPrime == null) {
            System.out.println("В последовательности нет простых чисел.");
        } else {
            System.out.println("Первое простое число с максимальной суммой цифр: "
                    + bestPrime + " (сумма цифр = " + bestDigitSum + ")");
        }
    }

    static boolean isPrime(int x) {
        if (x < 2) return false;
        if (x == 2) return true;
        if (x % 2 == 0) return false;

        for (int i = 3; (long) i * i <= x; i += 2) {
            if (x % i == 0) {
                return false;
            }
        }
        return true;
    }

    static int digitSum(int x) {
        int sum = 0;
        while (x > 0) {
            sum += x % 10;
            x /= 10;
        }
        return sum;
    }
}