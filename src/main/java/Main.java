import java.util.Scanner;
import java.util.ArrayList;

/**
 * Клас представляє число Фібоначі з його порядковим номером та значенням.
 * Цей клас дозволяє створювати об'єкти для кожного числа Фібоначі.
 *
 * @author Vitalii Rudenko
 * @version 1.0
 */
class numberFibonacci {
    /**
     * Номер числа Фібоначі у послідовності.
     */
    private int index;

    /**
     * Значення числа Фібоначі.
     */
    private int value;

    /**
     * Конструктор для ініціалізації об'єкта числа Фібоначі.
     *
     * @param index порядковий номер числа Фібоначі
     * @param value значення числа Фібоначі
     */
    numberFibonacci(int index, int value) {
        this.index = index;
        this.value = value;
    }

    /**
     * Повертає порядковий номер числа Фібоначі.
     *
     * @return порядковий номер числа
     */
    public int getIndex() {
        return index;
    }

    /**
     * Повертає значення числа Фібоначі.
     *
     * @return значення числа
     */
    public int getValue() {
        return value;
    }
}

/**
 * Клас для генерації послідовності чисел Фібоначі.
 * Він дозволяє створювати та зберігати числа Фібоначі у вигляді об'єктів.
 */
class createFibonacciNumber {
    /**
     * Список для зберігання об'єктів чисел Фібоначі.
     */
    ArrayList<numberFibonacci> fibonaccis = new ArrayList<>();

    /**
     * Перше число Фібоначі у послідовності (0).
     */
    int FirstNumber = 0;

    /**
     * Друге число Фібоначі у послідовності (1).
     */
    int SecondNumber = 1;

    /**
     * Поточне число Фібоначі, яке обчислюється в циклі.
     */
    int ThirdNumber;

    /**
     * Генерує послідовність чисел Фібоначі певної довжини.
     *
     * @param number кількість чисел у послідовності, яку потрібно згенерувати
     */
    public void createFibonacciNumber(int number) {
        // Додаємо перше число Фібоначі
        fibonaccis.add(new numberFibonacci(0, FirstNumber));

        // Додаємо друге число Фібоначі
        fibonaccis.add(new numberFibonacci(1, SecondNumber));

        // Генеруємо решту чисел послідовності
        for (int i = 2; i < number; i++) {
            ThirdNumber = FirstNumber + SecondNumber;
            fibonaccis.add(new numberFibonacci(i + 1, ThirdNumber));
            FirstNumber = SecondNumber;
            SecondNumber = ThirdNumber;
        }
    }

    /**
     * Повертає список згенерованих чисел Фібоначі.
     *
     * @return список об'єктів чисел Фібоначі
     */
    public ArrayList<numberFibonacci> getFibonaccis() {
        return fibonaccis;
    }
}

/**
 * Головний клас програми, який дозволяє користувачеві ввести кількість чисел Фібоначі,
 * а також знайти числа, що закінчуються на певну цифру.
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        createFibonacciNumber fibonacciCreator = new createFibonacciNumber();

        // Введення кількості чисел Фібоначі
        System.out.println("Введіть кількість чисел Фібоначі: ");
        int number = scanner.nextInt();

        // Введення цифри, на яку має закінчуватись число
        System.out.println("Введіть цифру, на яку повинно закінчуватись число: ");
        int digit = scanner.nextInt();

        // Генерація послідовності чисел Фібоначі
        fibonacciCreator.createFibonacciNumber(number);

        // Отримання списку згенерованих чисел
        ArrayList<numberFibonacci> list = fibonacciCreator.getFibonaccis();

        // Виведення чисел, що закінчуються на вказану цифру
        for (numberFibonacci num : list) {
            if (num.getValue() > 10) {
                if(num.getValue() % 10 == digit){
                    System.out.println("Індекс: " + num.getIndex() + " Значення: " + num.getValue());
                }
            }
        }
    }
}
