	package br.fatec.financas2021.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="tb_conta")
public class Conta implements Serializable{

    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "pk_id")
    private Long id;
    @Column(name = "nr_agencia", length = 10)
    private Integer agencia;
    @Column(name = "nr_num_conta", length = 10, unique = true)
    private String numero;
    @Column(name = "nm_titular", length = 50, unique = true)
    private String titular;
    @Column(name = "vl_saldo")
    private Float saldo;

    public Conta() { }
    public Conta(Long id) { 
        this.id = id;
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
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Conta other = (Conta) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
}
