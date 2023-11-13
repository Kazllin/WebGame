package com.itb.tcc.webgame.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import java.time.LocalDate;

@Entity
@Table(name = "usuarios")
public class Usuario {


@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private long id;


private String senha;
private String nome;
private String telefone;
private String cep;
private String endereco;
private String uf;
private String email;


public Long getId() {
	return id;
}
public void setId(long id) {
	this.id = id;
}


public String getEmail() {
	return email;
}
public void setEmail(String email) {
	this.email = email;
}
public String getSenha() {
	return senha;
}
public void setSenha(String senha) {
	this.senha = senha;
}
public String getNome() {
	return nome;
}
public void setNome(String nome) {
	this.nome = nome;
}
public String getTelefone() {
	return telefone;
}
public void setTelefone(String telefone) {
	this.telefone = telefone;
}
public String getCep() {
	return cep;
}
public void setCep(String cep) {
	this.cep = cep;
}
public String getEndereco() {
	return endereco;
}
public void setEndereco(String endereco) {
	this.endereco = endereco;
}
public String getUf() {
	return uf;
}
public void setUf(String uf) {
	this.uf = uf;
}


}
