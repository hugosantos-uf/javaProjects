import java.util.Random;

public class Game {
    private Jogador jogador1;
    private Jogador jogador2;
    private int target;

    public Game (String nome1, String nome2) {
        Random random = new Random();
        this.jogador1 = new Jogador(nome1);
        this.jogador2 = new Jogador(nome2);
        this.target = random.nextInt(50)+50;
    }

    public void playeroneDices() {
        jogador1.rollDices();
    }

    public void playertwoDices() {
        jogador2.rollDices();
    }

    public int scorePlayerOne() {
        return jogador1.getScore();
    }

    public int scorePlayerTwo() {
        return jogador2.getScore();
    }

    public void msgBothVictory() {
        System.out.println("Ambos jogadores atingiram a marca na mesma rodada, jogo finalizou");
    }

    public void msgPlayerOneVictory() {
        System.out.println(jogador1.getNome() + " ganhou, jogo finalizou");
    }
    public void msgPlayerTwoVictory() {
        System.out.println(jogador2.getNome() + " ganhou, jogo finalizou");
    }

    public int getTarget() {
        return target;
    }
}
