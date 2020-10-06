import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

//    1. Создать сущности:
//    Passport с полями:
//    - серия;
//    - номер;
//    - имя владельца;
//    - год рождения;
//    - страна.
//
//    Client с полями:
//    - имя;
//    - номер договора;
//    - баланс на счету.
//
//    Реализовать паттерн DAO (интерфейс должен быть параметризованным) с реализациями: хранение данных в списке List и в базе данных. Для работы с базой данных использовать JPA.
//    В паттерне реализовать методы:
//    - List<T> getAll();
//    - T getById(int id);
//    - void save(T t);
//    - void remove(T t).
//
//    Для сущности Client сделать ListClientDao - реализация с хранением в списке, для сущности Passport - JpaPassportDao - реализация с хранение в базе данных.
//
//    В Main проверить работу методов.

        Scanner scn = new Scanner (System.in);
        String input = "";

        while(!input.equals("3")){
            System.out.println("1. Passport.");
            System.out.println("2. Client.");
            System.out.println("3. Exit.");
            input = scn.nextLine();
            if(input.equals("1")){
                System.out.println("1. Work With Passport.");
                InputPassport ip = new InputPassport();
                ip.inputPassport();

            }
            else if(input.equals("2")){
                System.out.println("2. Work With Client.");
                InputClient ic = new InputClient();
                ic.inputClient();

            }
            else if(input.equals("3")){
                System.out.println("3. Exit.");

            }
            else{
                System.out.println("Uncorrect input.");
            }
        }



    }
}
