import java.util.Scanner;

import java.io.FileWriter;
import java.io.IOException;

public class UserDataApp {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите данные в порядке указанном ниже:\n" + "Фамилия Имя Отчество дата_рождения номер_телефон пол\n" + "Пример:\n" + "Иванов Иван Иванович 01.01.1963 89999999999 f");
        String next = scanner.next();
        String[] split = next.split("\\s");
    
        if (next.isEmpty()) {
            throw new EmptyStringException("Строка является пустой");
        }
        
        try {
            String name = split[0];
            String firstName = split[1];
            String middleName = split[2];
            String Date = split[3];
            String phoneNumber = split[4];
            String your_gender = split[5];
            if (your_gender.length() == 1){
                your_gender = your_gender.toLowerCase();
                if (your_gender.equals("m") || your_gender.equals("f")) {
                    char[] charArray = your_gender.toCharArray();
                    char convertedGender = charArray[0];
                } else {
                    throw new IncorrectValueException("Вы непрвльно указали пол !\n" +
                            "Правильный формат ввода данных: m или f.");
                }
            } else {
                throw new IncorrectValueException("Вы неправильно указали пол!\n");
            }
            
            if (split.length == 6){
                throw new ArrayCountElementException("Вы ввели не все данные или\n" +
                "Вы пропустили пробел");  
        }
  
            String output = name + firstName + middleName + Date + " " + phoneNumber + your_gender;
            FileWriter fileWriter = new FileWriter(split + ".txt");
            fileWriter.write(output);
            fileWriter.close();
        } catch (IOException e) {
            System.out.println("Ошибка! Не удалось создать файл.");
            return;
        } catch (ArrayIndexOutOfBoundsException e) {
            throw new ArrayCountElementException("Ошибка! Введены неполные данные.");
    
        }
        
        System.out.println("Данные успешно сохранены в файле " + split[0] + ".txt");
    
        }
}