public class Task1 {
    public static void main(String[] args) {
        Person mom = new PersonBuilder()
                .name("Анна")
                .surname("Вольф")
                .age(31)
                .address("Сидней")
                .build();
        Person son = mom.newChildBuilder()
                .name("Антошка")
                .build();

        System.out.println("C возрастом и адресом: " + mom);
        mom.happyBirthday();
        System.out.println("С днем рождения: " + mom);
        System.out.println("У " + mom + " есть сын, " + son);

        Person ivanov = new PersonBuilder()
                .name("Иван")
                .surname("Иванов")
                .build();

        System.out.println("Без возраста и адреса: " + ivanov);

        try {
            new PersonBuilder().build();
        } catch (IllegalStateException e) {
            e.printStackTrace();
        }

        try {
            new PersonBuilder().age(-100).build();
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        }
    }
}