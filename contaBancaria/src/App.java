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
        sc.nextLine();

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
        operacoes();
    }

    public static Conta encontrarConta(int numeroConta) {
        Conta conta = null;
        if(contasBancarias.size() > 0) {
            for(Conta c: contasBancarias) {
                if(c.getNumeroConta() == numeroConta);
                conta = c;
            }
        }
        return conta;
    }

    public static void depositar() {
        System.out.println("Digite o número da conta");
        int numeroConta = sc.nextInt();

        Conta conta = encontrarConta(numeroConta);
        
        if(conta != null) {
            System.out.println("Qual valor deseja depositar? ");
            Double valorDeposito = sc.nextDouble();
            conta.depositar(valorDeposito);
        } else {
            System.out.println("Conta não encontrada!");
        }
        operacoes();
    }

    public static void sacar() {
        System.out.println("Digite o número da conta");
        int numeroConta = sc.nextInt();

        Conta conta = encontrarConta(numeroConta);
        
        if(conta != null) {
            System.out.println("Qual valor deseja sacar? ");
            Double valorSaque = sc.nextDouble();
            conta.sacar(valorSaque);
        } else {
            System.out.println("Conta não encontrada!");
        }
        operacoes();
    }

    public static void transferir() {
        System.out.println("Digite o número da sua conta");
        int numeroConta = sc.nextInt();

        System.out.println("Digite o número da conta a transferir");
        int numeroContaDois = sc.nextInt();

        Conta conta = encontrarConta(numeroConta);
        Conta conta2 = encontrarConta(numeroContaDois);

        if(conta != null && conta2 != null){
            System.out.println("Qual valor deseja transferir? ");
            Double valorTransferencia = sc.nextDouble();
            conta.transferir(conta2, valorTransferencia);
            System.out.println("Valor transferido com sucesso! ");
        } else {
            System.out.println("Conta(s) não encontrada(s)!");
        }
        operacoes();
    }

    public static void listar() {
        if(contasBancarias.size() > 0) {
            for(Conta conta: contasBancarias) {
                System.out.println(conta);
            } 
            } else {
                System.out.println("Não há contas cadastradas");
            }
        operacoes();
    }
}
