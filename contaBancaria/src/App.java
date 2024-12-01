import java.util.ArrayList;
import java.util.Scanner;
import Programa.Conta;
import Programa.Pessoa;

public class App {
    static Scanner sc = new Scanner(System.in);
    static ArrayList<Conta> contasBancarias;

    public static void main(String[] args) {
        contasBancarias = new ArrayList<Conta>();
        operacoes();
    }

    public static void operacoes() {
        System.out.println("\n--- Menu ---");
        System.out.println("1. Criar conta");
        System.out.println("2. Sacar");
        System.out.println("3. Depositar");
        System.out.println("4. Transferir");
        System.out.println("5. Listar contas");
        System.out.println("6. Sair");
        System.out.print("Escolha uma opção: ");

        int operacao = sc.nextInt();

        switch (operacao) {
            case 1:
                criarConta();
                break;
            case 2:
                sacar();
                break;
            case 3:
                depositar();
                break;
            case 4:
                transferir();
                break;
            case 5:
                listar();
                break;
            case 6:
                System.out.println("Saindo...");
                System.exit(0);
                break;

            default:
                System.out.println("Opção inválida");
                operacoes();
                break;
        }
    }

    public static void criarConta() {
        System.out.println("Digite seu nome");
        String nome = sc.nextLine();

        System.out.println("Digite seu CPF");
        String cpf = sc.nextLine();

        System.out.println("Digite seu email");
        String email = sc.nextLine();

        Pessoa pessoa = new Pessoa(nome, cpf, email);
        Conta conta = new Conta(pessoa);
        contasBancarias.add(conta);

        System.out.println("Conta criada com sucesso");
        
    }
}
