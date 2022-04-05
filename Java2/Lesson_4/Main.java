package Lesson4;

public class Main {
    public static void main(String[] args){

        PhoneBook phonebook = new PhoneBook();

        System.out.println("Добовляем записи:");
        phonebook.add("Иванов", "+79991234567");
        phonebook.add("Петров", "+79991231223");
        phonebook.add("Сидоров", "+79991112233");
        phonebook.add("Иванов", "+79992223344");
        phonebook.add("Петров", "+79991115566");

        System.out.println("Поиск номера по фамилии:");
        System.out.println("Иванов");
        System.out.println(phonebook.get("Иванов"));
        System.out.println("Петров");
        System.out.println(phonebook.get("Петров"));
        System.out.println("Сидоров");
        System.out.println(phonebook.get("Сидоров"));
    }
}
