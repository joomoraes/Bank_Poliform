package banco_poliform;

import java.text.DateFormat;

public class contaGold extends Conta{
	
	private double limit = 1000;

	
	public contaGold(String name, String lastName, String cpf, DateFormat dataNascimento, Integer idade, int numero,
			int agencia, Double saldo, int senha, double limit, int escolaridade) {
		super(name, lastName, cpf, dataNascimento, idade, numero, agencia, senha, saldo, escolaridade);
		this.limit = limit;
	}
	
	//CONSTRUTOR UTILITÁRIO
	public contaGold(int numero, int agencia, int senha) {
		super(numero, agencia, senha);
		this.numero = numero;
		this.agencia = agencia;
		this.senha = senha;
	}
	
	public void sacar(double valor) {
		if(saldo+limit>=valor) {
			saldo = saldo - valor;
		} else {
			System.out.println("\n CRÉDITO INSUFICIENTE \n");
		}
	}
	
	public String InfoGold() {
		return "Seu limite atual é de: " + limit;
	}
}
