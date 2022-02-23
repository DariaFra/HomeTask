import java.util.Arrays;

class HomeWork5 {
    public static void main(String[] args) {
        Employee[] empArray = new Employee[5];
        empArray[0] = new Employee("Ivanov Ivan", "manager", "iviv@mail.ru", "89992323344", 30000, 42);
        empArray[1] = new Employee("Petrov Petr", "manager", "pepe@mail.ru", "89991112233", 28000, 47);
        empArray[2] = new Employee("Sidorov Sergei", "seller", "sise@mail.ru", "89992223344", 20000, 25);
        empArray[3] = new Employee("Vasiliev Vasya", "seller", "vava@mail.ru", "89993334455", 23000, 34);
        empArray[4] = new Employee("Kuznicov Kuzya", "chief", "kuku@mail.ru", "89990001122", 44000, 40);
        System.out.println("Все сотрудники:");

        for (int i = 0; i < empArray.length; i++) {
            System.out.println(empArray[i]);
        }
        System.out.println("Сотрудники старше 40:");
        for (int i = 0; i < empArray.length; i++) {
            if (empArray[i].getAge() > 40) {
                System.out.println(empArray[i]);
            }
        }
    }
}
