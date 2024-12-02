package Task02;

import java.util.Scanner;

public class SistemaClinicaPets {
    public static void main(String[] args) {
        final int totalPets = 100;
        String[] nomesPets = new String[totalPets];
        String[] tiposPets = new String[totalPets];
        int petCount = 0;

        Scanner sc = new Scanner(System.in);
        int opcao;

        do {
            System.out.println("""
                    --- Bem-vindo a Clínica de Pets! ---
                    1. Inserir novo pet
                    2. Exibir todos os pets
                    3. Buscar pet pelo nome
                    4. Sair
                    Escolha uma opção:""");
            opcao = sc.nextInt();
            sc.nextLine();

            switch (opcao) {
                case 1 -> {
                    if (petCount < totalPets) {
                        System.out.print("Digite o nome do pet: ");
                        String nome = sc.nextLine().trim(); 
                        System.out.print("Digite o tipo do pet (ex: cachorro, gato, pássaro): ");
                        String tipo = sc.nextLine().trim();

                        if (!nome.isEmpty() && !tipo.isEmpty()) {
                            nomesPets[petCount] = nome;
                            tiposPets[petCount] = tipo;
                            petCount++;
                            System.out.println("Pet registrado com sucesso!");
                        } else {
                            System.out.println("Erro: Nome e tipo do pet não podem ser vazios.");
                        }
                    } else {
                        System.out.println("Capacidade máxima atingida. Não é possível registrar mais pets.");
                    }
                }
                case 2 -> {
                    if (petCount == 0) {
                        System.out.println("Nenhum pet registrado.");
                    } else {
                        System.out.println("--- Todos os Pets ---");
                        for (int i = 0; i < petCount; i++) {
                            System.out.println("Nome: " + nomesPets[i]);
                            System.out.println("Tipo: " + tiposPets[i]);
                            System.out.println("--------------------");
                        }
                    }
                }
                case 3 -> {
                    System.out.print("Digite o nome do pet para busca: ");

                    String nomeParaBusca = sc.nextLine().trim();
                    boolean nomeEncontrado = false;

                    for (int i = 0; i < petCount; i++) {

                        if (nomesPets[i].equalsIgnoreCase(nomeParaBusca)) {

                            System.out.println("Pet encontrado!");
                            System.out.println("Nome: " + nomesPets[i]);
                            System.out.println("Tipo: " + tiposPets[i]);
                            nomeEncontrado = true;

                            break;

                        }
                    }

                    if (!nomeEncontrado) {

                        System.out.println("Pet não encontrado.");

                    }
                }
                case 4 -> System.out.println("Saindo...");
                default -> System.out.println("Opção inválida! Tente novamente.");
            }
        } while (opcao != 4);

        sc.close();
    }
}
