package Task02;

import java.util.Scanner;

public class SistemaCampeonatoBasquete {
    public static void main(String[] args) {
        final int totalJogos = 100;
        String[] timesCasa = new String[totalJogos];
        String[] timesVisitantes = new String[totalJogos];
        int[] pontosCasa = new int[totalJogos];
        int[] pontosVisitantes = new int[totalJogos];
        String[] datasJogos = new String[totalJogos];
        int jogoCount = 0;

        Scanner sc = new Scanner(System.in);
        int opcao;

        do {
            System.out.println("""
                    --- Bem-vindo ao Campeonato de Basquete ---
                    1. Inserir novo jogo
                    2. Exibir todos os jogos
                    3. Buscar jogos por time
                    4. Exibir classificação dos times
                    5. Sair
                    Escolha uma opção:""");
            opcao = sc.nextInt();
            sc.nextLine();

            switch (opcao) {
                case 1 -> {
                    if (jogoCount < totalJogos) {
                        System.out.println("--- Inserir Novo Jogo ---");

                        System.out.print("Digite o nome do time da casa: ");
                        String timeCasa = sc.nextLine().trim();
                        if (timeCasa.isEmpty()) {
                            System.out.println("O nome do time da casa não pode ser vazio. Tente novamente.");
                            break;
                        }

                        System.out.print("Digite o nome do time visitante: ");
                        String timeVisitante = sc.nextLine().trim();
                        if (timeVisitante.isEmpty()) {
                            System.out.println("O nome do time visitante não pode ser vazio. Tente novamente.");
                            break;
                        }

                        System.out.print("Digite a pontuação do time da casa: ");
                        int pontosCasaInput;
                        try {
                            pontosCasaInput = sc.nextInt();
                        } catch (Exception e) {
                            System.out.println("Pontuação inválida. Tente novamente.");
                            sc.nextLine();
                            break;
                        }

                        System.out.print("Digite a pontuação do time visitante: ");
                        int pontosVisitantesInput;
                        try {
                            pontosVisitantesInput = sc.nextInt();
                        } catch (Exception e) {
                            System.out.println("Pontuação inválida. Tente novamente.");
                            sc.nextLine();
                            break;
                        }

                        sc.nextLine();

                        System.out.print("Digite a data do jogo (formato DD/MM/AAAA): ");
                        String dataJogo = sc.nextLine().trim();
                        if (dataJogo.isEmpty()) {
                            System.out.println("A data do jogo não pode ser vazia. Tente novamente.");
                            break;
                        }

                        timesCasa[jogoCount] = timeCasa;
                        timesVisitantes[jogoCount] = timeVisitante;
                        pontosCasa[jogoCount] = pontosCasaInput;
                        pontosVisitantes[jogoCount] = pontosVisitantesInput;
                        datasJogos[jogoCount] = dataJogo;
                        jogoCount++;

                        System.out.println("Jogo adicionado com sucesso!");
                    } else {
                        System.out.println("Capacidade máxima atingida. Não é possível adicionar mais jogos.");
                    }
                }

                case 2 -> {
                    if (jogoCount == 0) {
                        System.out.println("Nenhum jogo cadastrado.");
                    } else {
                        System.out.println("--- Lista dos Jogos ---");
                        for (int i = 0; i < jogoCount; i++) {
                            System.out.println("Data: " + datasJogos[i] + ", Casa: " + timesCasa[i] + " ("
                                    + pontosCasa[i]
                                    + ") x Visitante: " + timesVisitantes[i] + " (" + pontosVisitantes[i] + ")");
                        }
                    }
                }

                case 3 -> {
                    System.out.print("Nome do time a buscar: ");
                    String nomeTime = sc.nextLine();
                    boolean encontrado = false;

                    for (int i = 0; i < jogoCount; i++) {
                        if (timesCasa[i].equalsIgnoreCase(nomeTime) || timesVisitantes[i].equalsIgnoreCase(nomeTime)) {
                            System.out.println("Data: " + datasJogos[i] + ", Casa: " + timesCasa[i] + " ("
                                    + pontosCasa[i] + ") x Visitante: " + timesVisitantes[i] + " ("
                                    + pontosVisitantes[i] + ")");
                            encontrado = true;
                        }
                    }

                    if (!encontrado) {
                        System.out.println("Nenhum jogo encontrado para o time especificado.");
                    }
                }

                case 4 -> {
                    if (jogoCount == 0) {
                        System.out.println("Nenhum jogo cadastrado.");
                    } else {
                        String[] nomesTimes = new String[2 * jogoCount];
                        int[] pontuacoes = new int[2 * jogoCount];
                        int timeCount = 0;

                        for (int i = 0; i < jogoCount; i++) {
                            if (timesCasa[i] == null || timesVisitantes[i] == null) continue;

                            int indexCasa = -1;
                            for (int j = 0; j < timeCount; j++) {
                                if (nomesTimes[j].equals(timesCasa[i])) {
                                    indexCasa = j;
                                    break;
                                }
                            }

                            if (indexCasa == -1) {
                                nomesTimes[timeCount] = timesCasa[i];
                                pontuacoes[timeCount] = pontosCasa[i];
                                timeCount++;
                            } else {
                                pontuacoes[indexCasa] += pontosCasa[i];
                            }

                            int indexVisitante = -1;
                            for (int j = 0; j < timeCount; j++) {
                                if (nomesTimes[j].equals(timesVisitantes[i])) {
                                    indexVisitante = j;
                                    break;
                                }
                            }

                            if (indexVisitante == -1) {
                                nomesTimes[timeCount] = timesVisitantes[i];
                                pontuacoes[timeCount] = pontosVisitantes[i];
                                timeCount++;
                            } else {
                                pontuacoes[indexVisitante] += pontosVisitantes[i];
                            }
                        }

                        for (int i = 0; i < timeCount - 1; i++) {
                            for (int j = i + 1; j < timeCount; j++) {
                                if (pontuacoes[i] < pontuacoes[j]) {
                                    int tempPontuacao = pontuacoes[i];
                                    pontuacoes[i] = pontuacoes[j];
                                    pontuacoes[j] = tempPontuacao;

                                    String tempNome = nomesTimes[i];
                                    nomesTimes[i] = nomesTimes[j];
                                    nomesTimes[j] = tempNome;
                                }
                            }
                        }

                        System.out.println("--- Classificação dos Times ---");
                        for (int i = 0; i < timeCount; i++) {
                            System.out.println(nomesTimes[i] + " - " + pontuacoes[i] + " pontos.");
                        }
                    }
                }

                case 5 -> System.out.println("Saindo...");
                default -> System.out.println("Opção inválida!");
            }
        } while (opcao != 5);

        sc.close();
    }
}
