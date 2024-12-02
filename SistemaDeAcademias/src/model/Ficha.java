package model;

import java.util.ArrayList;

public class Ficha {
    private Aluno aluno;
    private Personal personal;
    private ArrayList<Exercicio> exercicios;
    private String dtInicial;
    private String dtFinal;
    
    public Ficha(Aluno aluno, Personal personal, ArrayList<Exercicio> exercicios, String dtInicial, String dtFinal) {
        this.aluno = aluno;
        this.personal = personal;
        this.exercicios = exercicios;
        this.dtInicial = dtInicial;
        this.dtFinal = dtFinal;
    }

    public Aluno getAluno() {
        return aluno;
    }

    public void setAluno(Aluno aluno) {
        this.aluno = aluno;
    }

    public Personal getPersonal() {
        return personal;
    }

    public void setPersonal(Personal personal) {
        this.personal = personal;
    }

    public ArrayList<Exercicio> getExercicios() {
        return exercicios;
    }

    public void setExercicios(ArrayList<Exercicio> exercicios) {
        this.exercicios = exercicios;
    }

    public String getDtInicial() {
        return dtInicial;
    }

    public void setDtInicial(String dtInicial) {
        this.dtInicial = dtInicial;
    }

    public String getDtFinal() {
        return dtFinal;
    }

    public void setDtFinal(String dtFinal) {
        this.dtFinal = dtFinal;
    }

    public void adicionarExercicio(Exercicio exercicio) {
        exercicios.add(exercicio);
    }

    public void removerExercicio(Exercicio exercicio) {
        exercicios.remove(exercicio);
    }
}
