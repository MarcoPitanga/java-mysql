package br.com.unisuam.model;

public class Usuario {
	//Atributos
	private int matricula;
	private String senha;
	private String nome;
	
	//Construtores
	public Usuario() {
		
	}
	public Usuario(int matricula, String senha, String nome) {
		this.matricula = matricula;
		this.senha = senha;
		this.nome = nome;
	}
	
	//Metodos Get e Set
	public int getMatricula() {
		return matricula;
	}
	public void setMatricula(int matricula) {
		this.matricula = matricula;
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
}
