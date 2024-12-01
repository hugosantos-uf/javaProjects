package Programa;

import Utilitarios.Utils;

public class Conta {

    private static int ContadorDeContas = 1;

    private int numeroConta;
    private Double saldo = 0.0;
    private Pessoa pessoa;

    public Conta(Pessoa pessoa) {
        this.numeroConta = ContadorDeContas;
        this.pessoa = pessoa;
        ContadorDeContas++;
    }

    public int getNumeroConta() {
        return numeroConta;
    }

    public void setNumeroConta(int numeroConta) {
        this.numeroConta = numeroConta;
    }

    public Double getSaldo() {
        return saldo;
    }

    public void setSaldo(Double saldo) {
        this.saldo = saldo;
    }

    public Pessoa getPessoa() {
        return pessoa;
    }

    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }

    public String toString() {
        return "\nNome: " + this.pessoa.getNome() +
                "\nCPF: " + this.pessoa.getCpf() +
                "\nNúmero da Conta: " + this.getNumeroConta() +
                "\nSaldo: " + Utils.doubleToString(this.getSaldo());
    }

    public void depositar(Double valor) {
        if (valor > 0) {
            setSaldo(getSaldo() + valor);
            System.out.println("Seu depósito foi realizado com sucesso");
        } else {
            System.out.println("Não foi possível realizar o déposito");
        }
    }

    public void sacar(Double valor) {
        if (valor > 0 && valor <= this.getSaldo()) {
            setSaldo(getSaldo() - valor);
            System.out.println("Saque concluído");
        } else {
            System.out.println("Não foi possível realizar o saque");
        }
    }

    public void transferir(Conta contaParaDeposito, Double valor) {
        if (valor > 0 && valor <= this.getSaldo()) {
            setSaldo(getSaldo() - valor);
            contaParaDeposito.setSaldo(contaParaDeposito.getSaldo() + valor);
            System.out.println("Transferência concluída");
        } else {
            System.out.println("Não foi possível realizar a transferência");
        }
    }
}
