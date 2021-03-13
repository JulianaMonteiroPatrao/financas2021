package br.fatec.financas2021.model;

import java.io.Serializable;
import java.util.Objects;

public class Conta implements Serializable{

    private static final long serialVersionUID = 1L;
    
    private static Long nextId = 1L;
    private Long id;
    private Integer agencia;
    private String numero;
    private String titular;
    private Float saldo;

    public Conta() { }
    public Conta(Long id) { 
        this.id = id;
    }
    public Long generateId() {
        return nextId++;
    }

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public Integer getAgencia() {
        return agencia;
    }
    public void setAgencia(Integer agencia) {
        this.agencia = agencia;
    }
    public String getNumero() {
        return numero;
    }
    public void setNumero(String numero) {
        this.numero = numero;
    }
    public String getTitular() {
        return titular;
    }
    public void setTitular(String titular) {
        this.titular = titular;
    }
    public Float getSaldo() {
        return saldo;
    }
    public void setSaldo(Float saldo) {
        this.saldo = saldo;
    }


    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Conta)) {
            return false;
        }
        Conta conta = (Conta) o;
        return Objects.equals(id, conta.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, agencia, numero, titular, saldo);
    }
    

    
}
