class Employee {
    private String fullname;
    private String position;
    private String email;
    private String phone;
    private int salary;
    private int age;

    Employee(String fullname, String position, String email, String phone, int salary, int age) {
        this.fullname = fullname;
        this.position = position;
        this.email = email;
        this.phone = phone;
        this.salary = salary;
        this.age = age;
    }

    public int getAge() {
        return age;
    }

    @Override
    public String toString() {
        return fullname + ", " +
                position + ", " +
                email + ", " +
                phone + ", " +
                salary + ", " +
                age;
    }
}

