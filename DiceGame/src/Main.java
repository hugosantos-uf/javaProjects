import java.util.Objects;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Bem vindo ao jogo");
        System.out.println("Insira o nome do Jogador 1");
        String nome1 = scanner.nextLine();
        System.out.println("Insira o nome do Jogador 2");
        String nome2 = scanner.nextLine();

        Game game = new Game(nome1,nome2);
        boolean run = true;

        while(run) {
            System.out.println("A meta a ser atingida é = " + game.getTarget() + "\n");
            System.out.println("pressione r para rolar os dados");
            System.out.println("pressione x para sair do jogo");
            String choice = scanner.nextLine();
            if (Objects.equals(choice, "r")){
                System.out.println("Rolando os dados\n");
                game.playeroneDices();
                game.playertwoDices();
            } else {
                run = false;
                System.out.println("Jogo finalizou");
            }
            if ((game.scorePlayerOne() >= game.getTarget())&&(game.scorePlayerTwo() >= game.getTarget())) {
                run = false;
                game.msgBothVictory();
            }
             else if (game.scorePlayerOne() >= game.getTarget()) {
                run = false;
                game.msgPlayerOneVictory();
            }
             else if (game.scorePlayerTwo() >= game.getTarget()) {
                run = false;
                game.msgPlayerTwoVictory();
            }
        }
        scanner.close();
    }
}