import model.Passport;
import service.PassportService;

import java.util.Scanner;

public class InputPassport {

    public void inputPassport(){
        String input = "";
        Scanner scn = new Scanner(System.in);

        PassportService passportService = new PassportService();

        while(!input.equals("6")){
            System.out.println("1. Create.");
            System.out.println("2. Read All.");
            System.out.println("3. Read By ID.");
            System.out.println("4. Update.");
            System.out.println("5. Delete.");
            System.out.println("6. Exit.");
            input = scn.nextLine();

            if(input.equals("1")){
                System.out.println("1. Create.");
                Passport passport1 = new Passport("AA", 123, "Ivan", 1990, "Russia");
                Passport passport2 = new Passport("BB", 456, "Olga", 1990, "Russia");
                Passport passport3 = new Passport("CC", 789, "Petr", 1990, "Russia");
                Passport passport4 = new Passport("DD", 147, "Mary", 1990, "Russia");
                Passport passport5 = new Passport("EE", 258, "Inna", 1990, "Russia");

                passportService.save(passport1);
                passportService.save(passport2);
                passportService.save(passport3);
                passportService.save(passport4);
                passportService.save(passport5);

            }
            else if(input.equals("2")){
                System.out.println("2. Read All.");

                passportService.getAll();

            }
            else if(input.equals("3")){
                System.out.println("3. Read By ID.");
                System.out.println("Введите id клиента:");
                String inputTemp = scn.nextLine();
                int id = Integer.parseInt(inputTemp);

                passportService.getById(id);


            }
            else if(input.equals("4")){
                System.out.println("4. Update.");
                System.out.println("Введите id клиента, который будет изменён:");
                String inputTemp = scn.nextLine();
                int id = Integer.parseInt(inputTemp);

                System.out.println("Введите новую серию паспорта:");
                String newSeries = scn.nextLine();

                System.out.println("Введите новый номер паспорта:");
                inputTemp = scn.nextLine();
                int newNumber = Integer.parseInt(inputTemp);

                System.out.println("Введите новое имя клиента:");
                String newName = scn.nextLine();

                System.out.println("Введите новую дату выдачи паспорта:");
                inputTemp = scn.nextLine();
                int newYear = Integer.parseInt(inputTemp);

                System.out.println("Введите новую страну:");
                String newCountry = scn.nextLine();

                Passport oldPassport = passportService.getById(id);
                Passport newPassport = new Passport(newSeries, newNumber, newName, newYear, newCountry);

                passportService.update(oldPassport, newPassport);


            }
            else if(input.equals("5")){
                System.out.println("5. Delete.");
                System.out.println("Введите id клиента, который будет удален");
                String inputTemp = scn.nextLine();
                int id = Integer.parseInt(inputTemp);

                Passport deletedClient = passportService.getById(id);

                passportService.remove(deletedClient);

            }
            else if(input.equals("6")){
                System.out.println("6. Exit.");

            }
            else{
                System.out.println("Uncorrect input.");
            }
        }
    }
}
