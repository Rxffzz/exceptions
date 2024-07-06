package application;

import model.entities.Account;
import model.entities.exceptions.DomainExceptions;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        try {
            System.out.println("Insira os dados da conta");
            System.out.print("Numero da conta: ");
            int numero = sc.nextInt();
            System.out.print("Portador da conta: ");
            sc.nextLine();
            String portador = sc.nextLine();
            System.out.print("Saldo inicial: ");
            double saldo = sc.nextDouble();
            System.out.print("Limite de Saque: ");
            double limiteDeSaque = sc.nextDouble();

            Account account = new Account(numero, portador, saldo, limiteDeSaque);

            System.out.print("Insira o valor para saque: ");
            account.withdraw(sc.nextDouble());
            saldo = account.getSaldo();
            System.out.print("Novo Saldo: ");
        }catch (InputMismatchException e) {
            System.out.println("Dados inseridos nao sao aceitos");
        } catch (RuntimeException e) {
            System.out.println("Erro inesperado");
        } catch (DomainExceptions e){
            System.out.println(e.getMessage());
        }

        sc.close();
    }
}
