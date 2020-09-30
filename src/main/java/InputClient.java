import model.Client;
import service.ClientService;

import java.util.Scanner;

public class InputClient {

    public void inpurClient(){
        String input = "";
        Scanner scn = new Scanner(System.in);

        ClientService clientService = new ClientService();

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
                Client client1 = new Client("Ivan", "A-123", 100);
                Client client2 = new Client("Olga", "B-234", 500);
                Client client3 = new Client("Sergey", "C-345", 200);
                Client client4 = new Client("Anna", "D-456", 400);
                Client client5 = new Client("Pavel", "E-567", 300);

                clientService.save(client1);
                clientService.save(client2);
                clientService.save(client3);
                clientService.save(client4);
                clientService.save(client5);

            }
            else if(input.equals("2")){
                System.out.println("2. Read All.");

                clientService.getAll();

            }
            else if(input.equals("3")){
                System.out.println("3. Read By ID.");
                System.out.println("Введите id клиента:");
                String inputTemp = scn.nextLine();
                int id = Integer.parseInt(inputTemp);

                clientService.getById(id);


            }
            else if(input.equals("4")){
                System.out.println("4. Update.");
                System.out.println("Введите id клиента, который будет изменён:");
                String inputTemp = scn.nextLine();
                int id = Integer.parseInt(inputTemp);

                System.out.println("Введите новое имя клиента:");
                String changedName = scn.nextLine();

                System.out.println("Введите новый контракт:");
                String changedContract = scn.nextLine();

                System.out.println("Введите новый баланс на счёте:");
                inputTemp = scn.nextLine();
                int changedBalance = Integer.parseInt(inputTemp);

                Client oldClient = clientService.getById(id);
                Client newClient = new Client(changedName, changedContract, changedBalance);

                clientService.update(oldClient, newClient);


            }
            else if(input.equals("5")){
                System.out.println("5. Delete.");
                System.out.println("Введите id клиента, который будет удален");
                String inputTemp = scn.nextLine();
                int id = Integer.parseInt(inputTemp);

                Client deletedClient = clientService.getById(id);

                clientService.remove(deletedClient);

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
