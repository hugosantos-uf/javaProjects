public class Jogador {
    private String nome;
    private int score;
    private Dice dice1;
    private Dice dice2;

    public Jogador(String nome) {
        this.nome = nome;
        this.score = 0;
        this.dice1 = new Dice();
        this.dice2 = new Dice();
    }

    public void rollDices() {
        dice1.rollDice();
        dice2.rollDice();
        System.out.println("Resultado do dado 1 foi " + dice1.getValue());
        System.out.println("Resultado do dado 2 foi " + dice2.getValue());
        this.score += dice1.getValue() + dice2.getValue();
        System.out.println("Score atual = " + this.score + "\n");
    }

    public int getScore() {
        return score;
    }

    public String getNome() {
        return nome;
    }
}
