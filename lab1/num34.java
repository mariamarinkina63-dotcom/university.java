/*Найти число n из заданной последовательности чисел с максимальной суммой
своих простых делителей, включая их в сумму по одному разу.*/
import java.util.Scanner;

public class num34 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Сколько чисел в последовательности? ");
        int count = sc.nextInt();

        int bestNumber = 0;
        int bestSum = -1;

        System.out.println("Введите " + count + " натуральных чисел:");
        for (int i = 0; i < count; i++) {
            int n = sc.nextInt();
            int sum = sumOfPrimeDivisors(n);
            if (sum > bestSum) {
                bestSum = sum;
                bestNumber = n;
            }
        }

        System.out.println("Число с максимальной суммой простых делителей: "
                + bestNumber + " (сумма = " + bestSum + ")");
    }

    static int sumOfPrimeDivisors(int n) {
        if (n < 2) return 0;

        int sum = 0;

        if (n % 2 == 0) {
            sum += 2;
            while (n % 2 == 0) n /= 2;
        }

        for (int d = 3; (long) d * d <= n; d += 2) {
            if (n % d == 0) {
                sum += d;
                while (n % d == 0) n /= d; 
            }
        }

        if (n > 1) sum += n;

        return sum;
    }
}