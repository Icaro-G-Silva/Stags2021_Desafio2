import java.util.InputMismatchException;
import java.util.Scanner;

import classes.PF;
import classes.PJ;

public class StartApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        final PF pf = new PF();
        final PJ pj = new PJ();

        boolean resolved = false;
        do {
            int choose = getChoose(scanner);
            switch(choose) {
                case 1: register(pf, scanner);
                    break;
                case 2: register(pj, scanner);
                    break;
                case 3: pf.list();
                    break;
                case 4: pj.list();
                    break;
                case 9: resolved = true;
                    break;
            }
        }while(!resolved);
    }

    private static int getChoose(Scanner scanner) {
        int choose = 0;
        boolean resolved = false;
        do {
            try {
                System.out.println();
                makeLine(10);
                System.out.print("MENU");
                makeLine(10);
                System.out.print("\n1 - Cadastrar Cliente PF\n2 - Cadastrar Cliente PJ\n3 - Listar Cliente PF\n4 - Listar Cliente PJ\n9 - Sair\n\n-> ");
                choose = scanner.nextInt();
                if ((choose > 4 && choose != 9) || choose < 1) System.out.println("Entrada de dados fora dos parâmetros, por favor tente novamente.\n\n");
                else resolved = true;
            } catch (InputMismatchException e) {
                System.err.println("Entrada de dados do tipo errada, por favor tente novamente.\n\n");
            } finally {
                clearBuffer(scanner);
            }
        }while(!resolved);
        return choose;
    }

    private static void register(PF client, Scanner scanner) {
        String[] clientData = getUserData(scanner, "cpf");
        client.register(clientData[0], clientData[1], clientData[2], clientData[3]);
        clientRegisteredSuccessfully();
    }

    private static void register(PJ client, Scanner scanner) {
        String[] clientData = getUserData(scanner, "cnpj");
        client.register(clientData[0], clientData[1], clientData[2], clientData[3]);
        clientRegisteredSuccessfully();
    }

    private static String[] getUserData(Scanner scanner, String identifierMessage) {
        String name = getInput("Digite o nome do cliente", scanner);
        String phone = getInput("Digite o telefone do cliente", scanner);
        String email = getInput("Digite o Email do cliente", scanner);
        String identifier = getInput("Digite o " + identifierMessage + " do cliente", scanner);
        String[] clientData = {name, phone, email, identifier};
        return clientData;
    }

    private static void clientRegisteredSuccessfully() {
        System.out.println("Cliente registrado com sucesso!");
    }

    private static String getInput(String message, Scanner scanner) {
        String input = null;
        boolean resolved = false;
        do {
            try {
                System.out.print(message + "\n-> ");
                input = scanner.nextLine();
                if(input.isEmpty() || input.isBlank() || input.equals(null)) System.out.println("Por favor, digite algo. Tente novamente.\n\n");
                else resolved = true;
            } catch (Exception e) {
                System.err.println("Algo deu errado, por favor tente novamente.\n\n");
            }
        }while(!resolved);
        return input;
    }

    private static void makeLine(int width) {
        for(int i = 0; i < width; i++) System.out.print("-");
    }

    private static void clearBuffer(Scanner scanner) {
        if (scanner.hasNextLine()) scanner.nextLine();
    }
}