package HWexp3;
//Напишите приложение, которое будет запрашивать у пользователя следующие данные, разделенные пробелом:
//        Фамилия Имя Отчество датарождения номертелефона пол
//        Форматы данных:
//        фамилия, имя, отчество - строки
//        датарождения - строка формата dd.mm.yyyy
//        номертелефона - целое беззнаковое число без форматирования
//        пол - символ латиницей f или m.
//        МОЖНО ВСЕ ПОЛЯ СДЕЛАТЬ СТРОКОВЫМИ
//        Приложение должно проверить введенные данные по количеству. Если количество не совпадает с
//        требуемым, вернуть код ошибки, обработать его и показать пользователю сообщение, что он ввел
//        меньше и больше данных, чем требуется.
//
//        Приложение должно попытаться распарсить полученные значения и выделить из них требуемые
//        параметры. Если форматы данных не совпадают, нужно бросить исключение, соответствующее
//        типу проблемы. Можно использовать встроенные типы java и создать свои. Исключение должно
//        быть корректно обработано, пользователю выведено сообщение с информацией, что именно неверно.
//
//        Если всё введено и обработано верно, должен создаться файл с названием, равным фамилии,
//        в него в одну строку должны записаться полученные данные, вида
//
//<Фамилия><Имя><Отчество><датарождения> <номертелефона><пол>
//
//Однофамильцы должны записаться в один и тот же файл, в отдельные строки.
//
//        Не забудьте закрыть соединение с файлом.
//
//        При возникновении проблемы с чтением-записью в файл, исключение должно быть корректно
//        обработано, пользователь должен увидеть стектрейс ошибки.

import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Task {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Введите данные в формате: Фамилия Имя Отчество Дата рождения Номер телефона Пол");
            try {
                String input = scanner.nextLine().trim();
                String[] inputData = input.split(" ");
                if (inputData.length != 6) {
                    throw new IllegalArgumentException("Неверное кол-во данных. Подалуйста введите все данные разделенные пробелом");
                }
                String surname = inputData[0];
                String firstName = inputData[1];
                String middleName = inputData[2];
                String birthDate = inputData[3];
                int phoneNumber = Integer.parseInt(inputData[4]);
                char gender = inputData[5].charAt(0);

                if (!birthDate.matches("\\d{2}\\.\\d{2}\\.\\d{4}")) {
                    throw new IllegalArgumentException("Неверный формат даты рождения. Введите в формате dd.mm.yyyy");
                }
                if (phoneNumber <= 0) {
                    throw new IllegalArgumentException("Неверный формат номера телефона. Введите целое беззнаковое число без форматирования");
                }
                if (gender != 'f' && gender != 'm'){
                    throw new IllegalArgumentException("Неверный формат пола. Пожалуйста введите символ \"f\" или \"m\".");
                }

                try (FileWriter file = new FileWriter(surname + ".txt", true)) {
                    file.write("<"+surname + "><" + firstName + "><" + middleName + "><" + birthDate + "><" + phoneNumber + "><" + gender +">" +"\n");
                    System.out.println("Данные записаны в файл: " + surname + ".txt");
                } catch (IOException e) {
                    e.printStackTrace();
                }
                break;
            }catch (IllegalArgumentException e){
                System.out.println("Ошибка: "+ e.getMessage());
            }
        }
    }
}
