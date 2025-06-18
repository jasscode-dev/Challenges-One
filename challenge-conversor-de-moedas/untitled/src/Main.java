import models.ConvertCurrency;
import service.ExchangeService;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        var convert = new ExchangeService();
        Scanner scanner = new Scanner(System.in);
        int opcao = 0;
        double amountBase;

        do {
            System.out.println("***************************************");
            System.out.println("Seja bem-vindo/a ao Conversor de Moeda =]");
            System.out.println("***************************************");
            System.out.println("1) Dólar >>> Peso argentino");
            System.out.println("2) Peso argentino >>> Dólar");
            System.out.println("3) Dólar >>> Real brasileiro");
            System.out.println("4) Real brasileiro >>> Dólar");
            System.out.println("5) Dólar >>> Peso colombiano");
            System.out.println("6) Peso colombiano >>> Dólar");
            System.out.println("7) Sair");

            System.out.print("Escolha uma opção válida: ");

            try {
                opcao = scanner.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Entrada inválida! Digite um número inteiro.");
                scanner.nextLine();
                continue;
            }

            if (opcao >= 1 && opcao <= 6) {
                System.out.print("Digite o valor que deseja converter: ");
                try {
                    amountBase = scanner.nextDouble();
                } catch (InputMismatchException e) {
                    System.out.println("Entrada inválida! Digite um número decimal válido.");
                    scanner.nextLine();
                    continue;
                }
            } else {
                amountBase = 0.0;
            }

            ConvertCurrency convertCurrency;


            try {
                switch (opcao) {
                    case 1:
                        convertCurrency = new ConvertCurrency(convert.exchangeCurrency("USD", "ARS", amountBase), amountBase);
                        break;
                    case 2:
                        convertCurrency = new ConvertCurrency(convert.exchangeCurrency("ARS", "USD", amountBase), amountBase);
                        break;
                    case 3:
                        convertCurrency = new ConvertCurrency(convert.exchangeCurrency("USD", "BRL", amountBase), amountBase);
                        break;
                    case 4:
                        convertCurrency = new ConvertCurrency(convert.exchangeCurrency("BRL", "USD", amountBase), amountBase);
                        break;
                    case 5:
                        convertCurrency = new ConvertCurrency(convert.exchangeCurrency("USD", "COP", amountBase), amountBase);
                        break;
                    case 6:
                        convertCurrency = new ConvertCurrency(convert.exchangeCurrency("COP", "USD", amountBase), amountBase);
                        break;
                    case 7:
                        System.out.println("Saindo...");
                        continue;
                    default:
                        System.out.println("Opção inválida. Tente novamente.");
                        continue;
                }

                System.out.println(convertCurrency);
                System.out.println();

            } catch (RuntimeException e) {
                System.out.println("Erro ao converter moeda: " + e.getMessage());
            }

        } while (opcao != 7);

        scanner.close();
    }
}
