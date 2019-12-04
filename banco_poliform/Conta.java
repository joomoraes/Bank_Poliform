package banco_poliform;

import java.text.DateFormat;

public class Conta extends Cliente{
	
	protected int numero;
	protected int agencia;
	protected Double saldo;
	protected int senha;
	private String dateReserv;
	
	
	//heritage
	/**
	 * @param name
	 * @param lastName
	 * @param cpf
	 * @param dataNascimento
	 * @param idade
	 * @param escolaridade
	 * @param numero
	 * @param agencia
	 * @param saldo
	 * @param senha
	 */
	public Conta(String name, String lastName, String cpf, DateFormat dataNascimento, Integer idade, int escolaridade,
			int numero, int agencia, Double saldo, int senha) {
		super(name, lastName, cpf, dataNascimento, idade, escolaridade);
		this.numero = numero;
		this.agencia = agencia;
		this.saldo = saldo;
		this.senha = senha;
	}
	
	public Conta(int numero, int agencia, int senha) {
		super(numero, agencia, senha);
		this.numero = numero;
		this.agencia = agencia;
		this.senha = senha;
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public int getAgencia() {
		return agencia;
	}

	public void setAgencia(int agencia) {
		this.agencia = agencia;
	}
	
	public void setSenha(int senha) {
		this.senha = senha;
	}
	public int getSenha() {
		return senha;
	}

	public Double getSaldo() {
		return saldo;
	}
	
	public void deposito(double valor) {
		this.saldo += valor;
	}
	
	public void sacar(double valor) {
			this.saldo += valor;
	}
	
	public String infoConta() {
		return infoConta() + "\n INFO CONTA " +
				"\n Numero Conta: " + numero +
				"\n Agencia: " + agencia + 
				"\n Saldo: " +  saldo;
	}
	
	//RESERVA
	
	public void setDataReserv(String dataReserv) {
		this.dateReserv =  dataReserv;
	}
	
	public String getDataReserv() {
		return dateReserv;
	}
	
	public String infoDate() {
		return "A data que vcoê inseriu invalidou \n"
				+ "o cadastro, mas você poderá proseguir \n"
				+ "normalmente com o cadastro, e depois realizar\n"
				+ "a alteração no seu perfil de conta, se assim desejar \n"
				+ "caso deseje refazer o cadastro digite a tecla 'y' ";
	}
}
