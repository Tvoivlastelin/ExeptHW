package HWexp2;

import java.util.Scanner;

//Разработайте программу, которая выбросит Exception, когда пользователь вводит пустую строку.
//        Пользователю должно показаться сообщение, что пустые строки вводить нельзя.
public class task4 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (true) {
            System.out.println("Введите что-то: ");
            try {
                String input = in.nextLine();
                if (input.isEmpty()) {
                    throw new Exception("Нельзя вводить пустую строку");
                }
                System.out.println("Вы ввели: " + input);
                break;
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
