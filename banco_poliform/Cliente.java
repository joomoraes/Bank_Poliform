package banco_poliform;

import java.text.DateFormat;

public class Cliente {
	
	protected String name;
	protected String lastName;
	protected String cpf;
	protected DateFormat dataNascimento;
	protected Integer idade;
	protected int escolaridade;
	
	public Cliente(String name, String lastName, String cpf, DateFormat dataNascimento2, Integer idade, int escolaridade) {
		this.name = name;
		this.lastName = lastName;
		this.cpf = cpf;
		this.dataNascimento = dataNascimento2;
		this.idade = idade;
	}
	// Construtor utilitário que referência a classe Conta
	public Cliente(int numero, int agencia, int senha) {
		
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public DateFormat getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(DateFormat dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public Integer getIdade() {
		return idade;
	}

	public void setIdade(Integer idade) {
		this.idade = idade;
	}

	public int getEscolaridade() {
		return escolaridade;
	}

	public void setEscolaridade(int escolaridade) {
		this.escolaridade = escolaridade;
	}
	
	public String infoCliente() {
		return "\n Nome: " +  name  + " " + lastName +
			   "\n CPF: " + cpf + 
			   "\n Nascimento: " + getDataNascimento();
	}
}
