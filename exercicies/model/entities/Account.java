package model.entities;

import model.entities.exceptions.DomainExceptions;

public class Account {
    private Integer numeroDaConta;
    private String portadorDaConta;
    private Double saldo;
    private Double limiteDeSaque;
    private Double amount;

    public Account(){
    }

    public Account(Integer numeroDaConta, String portadorDaConta, Double saldo, Double limiteDeSaque) {
        this.numeroDaConta = numeroDaConta;
        this.portadorDaConta = portadorDaConta;
        this.saldo = saldo;
        this.limiteDeSaque = limiteDeSaque;
    }

    public Integer getNumeroDaConta() {
        return numeroDaConta;
    }

    public void setNumeroDaConta(Integer numeroDaConta) {
        this.numeroDaConta = numeroDaConta;
    }

    public String getPortadorDaConta() {
        return portadorDaConta;
    }

    public void setPortadorDaConta(String portadorDaConta) {
        this.portadorDaConta = portadorDaConta;
    }

    public Double getSaldo() {
        return saldo;
    }

    public Double getLimiteDeSaque() {
        return limiteDeSaque;
    }

    public void setLimiteDeSaque(Double limiteDeSaque) {
        this.limiteDeSaque = limiteDeSaque;
    }

    public void deposit (Double amount){
         saldo += amount;
    }

    public void withdraw (Double amount) throws DomainExceptions {
        double novoSaldo = saldo -= amount;

        if(limiteDeSaque<=0){
            throw new DomainExceptions("Voce nao possui valor para saque");
        } if(amount > limiteDeSaque){
            amount -= limiteDeSaque;
            throw new DomainExceptions("O valor solicitado excede o limite de saque disponivel");
        }if (amount > saldo){
            amount -= saldo;
            throw new DomainExceptions("O valor solicitado excede o saldo disponivel");
        }
        else {
            throw new DomainExceptions("Saque concluido com sucesso!! "
                    + " novo saldo $"
                    + novoSaldo);
        }
    }
}
