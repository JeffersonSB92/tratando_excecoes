package exercicio.model.entities;

import exemplo.model.exceptions.DomainException;

public class Conta {

    private Integer numero;
    private String titular;
    private Double saldo;
    private Double limiteSaque;

    public Conta(Integer numero, String titular, Double saldo, Double limiteSaque) {
        this.numero = numero;
        this.titular = titular;
        this.saldo = saldo;
        this.limiteSaque = limiteSaque;
    }

    public Integer getNumero() {
        return numero;
    }

    public void setNumero(Integer numero) {
        this.numero = numero;
    }

    public String getTitular() {
        return titular;
    }

    public void setTitular(String titular) {
        this.titular = titular;
    }

    public Double getSaldo() {
        return saldo;
    }

    public Double getLimiteSaque() {
        return limiteSaque;
    }

    public void setLimiteSaque(Double limiteSaque) {
        this.limiteSaque = limiteSaque;
    }

    public void deposito(Double valor){
        saldo = saldo + valor;
    }

    public void saque(Double valor){
        if (saldo < valor){
            throw new DomainException("Erro no Saque: o valor de saque excede o valor em conta!");
        }
        if (valor > limiteSaque){
            throw new DomainException("Erro no Saque: o valor solicitado excede o limite de saque!");
        }

        saldo = saldo - valor;
    }
}
