package HWexp2;

import java.util.Scanner;

//Реализуйте метод, который запрашивает у пользователя ввод дробного числа (типа float),
//        и возвращает введенное значение. Ввод текста вместо числа не должно приводить
//        к падению приложения, вместо этого, необходимо повторно запросить у пользователя
//        ввод данных.
public class task1 {
    public static void main(String[] args) {
        System.out.println(inputFloatNumber());
    }

    public static float inputFloatNumber() {
        Scanner in = new Scanner(System.in);
        float input;
        while (true) {
            try {
                System.out.println("Введите дробное число: ");
                input = Float.parseFloat(in.nextLine());
                break;
            } catch (NumberFormatException e) {
                System.out.println("Вы ввели не дробное число");
            }
        }
        return input;
    }
}
