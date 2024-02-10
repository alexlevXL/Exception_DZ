import java.util.Scanner;

import java.io.FileWriter;
import java.io.IOException;

public class UserDataApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Введите данные в порядке указанном ниже латиницейД:\n" + "<Фамилия> <Имя> <Отчество> <Дата рождения> <Телефон> <Пол>\n");
        String input;
        input = scanner.nextLine();
        String[] data = input.split(" ");
        
        if (input.isEmpty()) {
            throw new EmptyStringException("Строка является пустой");
        }
        
        try {
            String name = data[0];
            String firstName = data[1];
            String middleName = data[2];
            String Date = data[3];
            String phoneNumber = data[4];
            String your_gender = data[5];
            
            String output = name + firstName + middleName + Date + " " + phoneNumber + your_gender;
            
            FileWriter fileWriter = new FileWriter(name + ".txt");
            fileWriter.write(output);
            fileWriter.close();
        } catch (IOException e) {
            System.out.println("Ошибка! Не удалось создать файл.");
            return;
        } catch (ArrayIndexOutOfBoundsException e) {
            throw new ArrayCountElementException("Ошибка! Введены неполные данные.");
    
        }
        
        System.out.println("Данные успешно сохранены в файле " + data[0] + ".txt");
    }
}