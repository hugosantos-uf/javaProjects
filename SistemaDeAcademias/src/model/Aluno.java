package model;

public class Aluno {

    private static int numero = 0;

    private String nome;
    private Double peso;
    private int altura; //em centímetros
    private boolean treina;

    public Aluno(String nome, Double peso, int altura, boolean treina) {
        this.nome = nome;
        this.peso = peso;
        this.altura = altura;
        this.treina = treina;
        numero ++;
    }

    public static int getNumero() {
        return numero;
    }

    public static void setNumero(int numero) {
        Aluno.numero = numero;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Double getPeso() {
        return peso;
    }

    public void setPeso(Double peso) {
        this.peso = peso;
    }

    public int getAltura() {
        return altura;
    }

    public void setAltura(int altura) {
        this.altura = altura;
    }

    public boolean isTreina() {
        return treina;
    }

    public void setTreina(boolean treina) {
        this.treina = treina;
    }

    @Override
    public String toString() {
        return "Aluno [nome=" + nome + ", peso=" + peso + ", altura=" + altura + ", treina=" + treina + "]";
    }
    
}
