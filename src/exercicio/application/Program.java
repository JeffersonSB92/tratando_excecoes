package exercicio.application;

import exemplo.model.exceptions.DomainException;
import exercicio.model.entities.Conta;

import java.util.Locale;
import java.util.Scanner;

public class Program {

    public static void main(String[] args){

        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        System.out.println("Entre com os dados da conta");
        System.out.print("Número: ");
        int numero = sc.nextInt();
        sc.nextLine();
        System.out.print("Titular: ");
        String titular = sc.nextLine();
        System.out.print("Saldo inicial: ");
        double saldo = sc.nextDouble();
        System.out.print("Limite de saque: ");
        double limiteSaque = sc.nextDouble();
        Conta conta = new Conta(numero, titular, saldo, limiteSaque);

        try {
            System.out.println();
            System.out.print("Entre o valor de saque: ");
            double valor = sc.nextDouble();
            conta.saque(valor);
            System.out.printf("Novo saldo: %.2f%n", conta.getSaldo());
        } catch (DomainException e){
            System.out.println(e.getMessage());
        }
        sc.close();
    }
}
