package banco_poliform;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

public class Program {
	
	static Teclado Teclado;
	static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	static contaGold[] gold = new contaGold[10];
	static contaSilver[] silver = new contaSilver[10];
	static contaSimples[] simple = new contaSimples[10];
	static Cliente[] cliente = new Cliente[10];
	static Conta[] acc = new Conta[10];
	static Random random = new Random();
	
	public static void main(String[] args) throws ParseException {
			menu();
		}
	
	
	public static void menu() throws ParseException {
		while(true) {	
			int opcao = banco_poliform.Teclado.LerInt(" (1)Cadastrar Cliente \n"
					+ "(2) Deposito \n"
					+ "(3) Acessa Conta \n"
					+ "(4) Sair");
		
			switch (opcao) {
			case 1: 
					cadastrar();
				break; 
			case 2:
					depositoSaque();
				break;
			case 3:
					acesso();
				break;
			case 4:
				System.exit(0);
				break;
				
			default:
				System.out.println("\n ESCOLHA OUTRA OPÇÃO \n");
				break;
			}
			
		}
	}
	
	public static void cadastrar() throws ParseException {
		
		String name = banco_poliform.Teclado.LerString("Nome: ");
		String lastName = banco_poliform.Teclado.LerString("Sobre nome: ");
		String cpf = banco_poliform.Teclado.LerString("Cpf: ");
		String dat =  banco_poliform.Teclado.lerData("Digite sua data de nascimento: ");
		
		//INSERÇÃO DE DATEFORMAT
		DateFormat data = DateFormat.getInstance();
		
		// TRATAMENTO DO DATEERROR
		try { @SuppressWarnings("unused")
		Date da=data.parse(dat); } 
		catch (ParseException ex) { 
			String alterar = banco_poliform.Teclado.LerString("\n DATA INVALIDA, ALTERAR DATA? (y/) \n");
			if(alterar == "Y") {
				acc[0].infoDate();
				String continuar = banco_poliform.Teclado.LerString(" ");
				if(continuar == "Y" || continuar == "y") {
					cadastrar();
				}
			}
			};
			
		int idade = banco_poliform.Teclado.LerInt("Idade: ");
		int escolaridade = banco_poliform.Teclado.LerInt("(1) Nivel Superior Completo \n"
				+ "(2)Nivel Superior Incompleto \n"
				+ "(3) Sem nível superior");
		
		Cliente cadastrados = new Cliente(name, lastName, cpf, data, idade, escolaridade);
		
		for (int i = 0; i < cliente.length; i++) {
			if(cliente[i] == null) {
				cliente[i] = cadastrados;
				break;
			}
		}
		 
		int numero = random.nextInt(100000);
		int agencia = random.nextInt(1000);
		int senhaTest = banco_poliform.Teclado.LerInt("INSIRA UMA SENHA: ");
		boolean repetir = false;
		
		while(repetir == false) {
			int senha = banco_poliform.Teclado.LerInt("INSIRA SENHA NOVAMENTE: ");
			
			if(senha == senhaTest) {
				int i = 0;
				if(cliente[i].getEscolaridade() == 1) {
					Conta cadastroConta = new contaGold(numero, agencia, senha);
					repetir = true;
					for (i = 0; i < acc.length; i++) {
						if(acc[i] == null) {
							acc[i] = cadastroConta;
							break;			
						}
					}
				} 
						
				else if(cliente[i].getEscolaridade() == 2) {
					Conta cadastroConta1 = new contaSilver(numero, agencia, senha);
					repetir = true;
					for (i = 0; i < acc.length; i++) {
						if(acc[i] == null) {
							acc[i] = cadastroConta1;
							break;
						}
					} 
				}
					
				else if(cliente[i].getEscolaridade() == 3) {
					Conta cadastroConta2 = new contaSilver(numero, agencia, senha);
					repetir = true;
					for (i = 0; i < acc.length; i++) {
						if(acc[i] == null) {
							acc[i] = cadastroConta2;
							break;
						}
					}
				}
			 else {
				System.out.println("\n SENHAS NÃO COINCIDEM");
			}
		}
		System.out.println("CADASTRO REALIZADO COM SUCESSO!!!");
		}
	}
	
	//DEPOSITO
	
	@SuppressWarnings("unused")
	public static void depositoSaque() {
		System.out.println("\n DEPOSITO \n");
		int numeroConta = banco_poliform.Teclado.LerInt("INSIRA O NUMERO DA CONTA: ");
		int agencia = banco_poliform.Teclado.LerInt("INSIRA O NUMERO DA AGENCIA: ");
		try {
			for (int i=0;i<acc.length;i++) {
				if(acc[i] != null && acc[i].getNumero() == numeroConta && acc[i].getAgencia() == agencia) {
					
					double valor = banco_poliform.Teclado.LerDouble("DIGITE O VALOR: ");
					acc[i].deposito(valor);
					
				} else if(acc[i].getNumero() == numeroConta || acc[i].getAgencia() == agencia) {
					if(acc[i].getNumero() != numeroConta) {
						System.out.println("NUMERO DA CONTA INVALIDO");
					}
					if(acc[i].getAgencia() != agencia) {
						System.out.println("NUMERO DA AGENCIA INVALIDO");
					}
				} else {
					System.out.println("CONTA NÃO CADASTRADA");
				}
				break;
			 }
		} catch(NullPointerException ex){
			System.out.println("\n ** NENHUMA CONTA CADASTRADA NO SISTEMA ** \n");
		}
	}
	
	//ACESSO CONTA
	@SuppressWarnings("unused")
	public static void acesso() {
		try {
			int numeroConta = banco_poliform.Teclado.LerInt("NUMERO A CONTA: ");
			int senha = banco_poliform.Teclado.LerInt("SENHA: ");
			
			for (int i=0; i<acc.length; i++) {
				if(acc[i] != null && acc[i].getNumero() == numeroConta && acc[i].getSenha() == senha) {
					int opcao = banco_poliform.Teclado.LerInt("\n ** BEM VINDO CLIENTE " + acc[i].getName() 
							+ "\n (1)VER CONTA INFO"
							+ "\n (2)SAQUE"
							+ "\n (3)ALTERAR INFORMAÇÕES");
						
					switch (opcao) {
						case 1:
							System.out.println(cliente[i].infoCliente() + acc[i].infoConta());
							break;
						case 2:
							double saque = banco_poliform.Teclado.LerDouble(" VALOR DO SAQUE: ");
								for (i = 0; i < acc.length; i++) {
									if(saque > acc[i].getSaldo()) {
										
										if(cliente[i].getEscolaridade() == 1) {
											double emprestimo = 0.0;
											int opcao1 = banco_poliform.Teclado.LerInt(" **SALDO INSUFICIENTE** \n"
																		+ "(1) REALIZAR EMPRESTIMO \n"
																		+ "(2) VERIFICAR LIMITE \n"
																		+ "(2) SAIR");
												switch (opcao1) {
												case 1:
													emprestimo = banco_poliform.Teclado.LerDouble("VALOR DO EMPRESTIMO");
													if(emprestimo <= 1000.0) {  
															acc[i].sacar(emprestimo);
															if(acc[i].getSaldo() < 0) {
																System.out.println("\n EMPRESTIMO REALIZADO! "
																		+ "\n NO VALOR DE:" + emprestimo);
															}
													} else {
														System.out.println("\n VALOR ULTRAPASSA O TETO PERMITIDO \n");
													}
													break;
												case 2:
													if(emprestimo <= 1000.0) {
														gold[i].InfoGold();
													}
													else if(emprestimo <= 500.0) {
														silver[i].InfoSilver();
													} else if(emprestimo <= 50.0) {
														simple[i].InfoSimple();
													} else {
														System.out.println("\n VALOR ULTRAPASSA O TETO PERMITIDO \n");
													}
													break;
												case 3:
													System.out.println("\n SAIR \n");	
													break;
												default:
													System.out.println("ENTRADA INVALIDA");
													break;
												}
										}
									}
									
									else if(saque <= acc[i].getSaldo()) {
										acc[i].sacar(saque);
										if(acc[i].getSaldo() >= 0) {
											System.out.println("SAQUE REALIZADO :" + saque);
										}
									}
								}
							break;
						case 3:
							int opcao3 = banco_poliform.Teclado.LerInt("(1) altear nome. \n"
									+ "(2) alterar sobrenome: \n"
									+ "(3) alterar senha: \n"
									+ "(4) alterar escolaridade: \n"
									+ "(5) alterar idade: \n"
									+ "(6) alterar data: "); 
							switch (opcao3) {
							case 1:
								String newName = banco_poliform.Teclado.LerString("NOVO NOME: ");
								cliente[i].setName(newName);
								break;
							case 2:
								String newLast = banco_poliform.Teclado.LerString("NOVO SOBRE NOME: ");
								cliente[i].setName(newLast);
								break;
							case 3:
								int newSenha = banco_poliform.Teclado.LerInt("NOVA SENHA: ");
								acc[i].setSenha(newSenha);
								break;
							case 4:
								int newEscul = banco_poliform.Teclado.LerInt("ALTERAR ESCOLARIDADE: \n"
										+ "(1)Graduação Completa \n"
										+ "(2)Graduação Incompleta \n"
										+ "(3)Sem Graduação \n");
								if(newEscul == 1) {
									cliente[i].setEscolaridade(newEscul);
								} else if(newEscul == 2) {
									cliente[i].setEscolaridade(newEscul);
								} else if(newEscul == 3) {
									cliente[i].setEscolaridade(newEscul);
								} else {
									System.out.println("ENTRADA INVALIDA");
								}
								break;
							case 5:
								int newIdade = banco_poliform.Teclado.LerInt("INSIRA IDADE: ");
								cliente[i].setIdade(newIdade);
								break;
							case 6:
								String newDate = banco_poliform.Teclado.lerData("INSIRA DATA: ");
								acc[i].setDataReserv(newDate);
							default:
								break;
							}
							break;
						default:
							System.out.println("ENTRADA INVALIDA");
							break;
						}
				} else {
					System.out.println("\n **SENHA OU NUMERO DA CONTA INVALIDO** \n");
				}
			break;
			}
			
		}catch(NullPointerException ex) {
			System.out.println("\n ** CONTA INEXISTENTE ** \n");
		}
	}
	
}
	
