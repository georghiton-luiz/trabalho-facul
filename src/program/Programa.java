package program;

import java.util.Scanner;

//import program.entidades.Pessoa;
//import program.servico.Conexao;

public class Programa {

	public static void main(String[] args) {

		Scanner tc = new Scanner(System.in);

//		Conexao con = new Conexao();
//
//		Integer resp = null;
//
//		System.out.println("-----------------------------------------------------");
//		System.out.println("|Bem-vindo ao cadstro de vacinação contra o COVID-19|");
//		System.out.println("-----------------------------------------------------\n");
//
//		System.out.println("----------");
//		System.out.println("|Cadastro|");
//		System.out.println("----------");
//
//		System.out.print("\nDigite seu completo: ");
//		String nome = tc.nextLine();
//		System.out.println("");
//
//		System.out.print("Digite seu data de nascimento: ");
//		String dataNasc = tc.next();
//		System.out.println("");
//
//		System.out.print("Digite seu CPF: ");
//		String cpf = tc.next();
//		System.out.println("");
//
//		Pessoa cpfPaciente = new Pessoa();
//		cpfPaciente.CpfPessoa(cpf);
//
//		while (cpfPaciente.isCPF() == false) {
//			System.out.println("CFP invalido!\n\nDigitar um CPF valido!");
//			cpf = tc.next();
//			System.out.println("");
//
//			cpfPaciente.CpfPessoa(cpf);
//		}
//
//		System.out.print("Digite seu R.G.: ");
//		String rg = tc.next();
//		System.out.println("");
//
//		System.out.print("Digite orgão emissor do R.G.: ");
//		String orgEmissor = tc.next().toUpperCase();
//		System.out.println("");
//
//		System.out.print("Digite seu número do SUS: ");
//		String numSus = tc.next();
//		System.out.println("");
//		
//		System.out.println("--------------------");
//		System.out.println("|Digite seu enderço|");
//		System.out.println("--------------------\n");
//		
//		System.out.print("Digite o lagradouro: ");
//		tc.nextLine();
//		String rua = tc.nextLine();
//		System.out.println("");
//		
//		System.out.print("Digite o numero: ");
//		String num = tc.next();
//		System.out.println("");		
//
//		System.out.print("Digite o bairro: ");
//		tc.nextLine();
//		String bairro = tc.nextLine();
//		System.out.println("");
//		
//		System.out.print("Digite o cidade: ");
//		String cidade = tc.nextLine();
//		System.out.println("");
//		
//		System.out.print("Digite o UF: ");
//		String uf = tc.nextLine().toUpperCase();
//		System.out.println("");
//		
//		System.out.print("Digite o complemento: ");
//		String complemento = tc.nextLine();
//		System.out.println("");
//		
//		System.out.print("Digite o CEP: ");
//		String cep = tc.nextLine();
//		System.out.println("");
//		
//		Pessoa p1 = new Pessoa(rua, bairro, cidade, uf, complemento, cep, num, dataNasc, cpf, nome, rg, orgEmissor, numSus, email);
//		
//		String sql;
//		sql = "INSERT INTO dados_paciente (id_paciente,nome_paciente,data_nasc_paciente,"
//				+ "rg_paciente,org_emissor_paciente,cpf_paciente,num_sus_paciente)values"
//				+ "(default,'" + p1.getNome() + "','" + p1.getDataNascFormatada()
//				+ "','" + p1.getRg() + "','" + p1.getOrgEmissor() + "','" + p1.getCpfPaciente()
//				+ "','" + p1.getNumSus() + "')";
//		int res = con.exeSql(sql);
//		if (res >= 1) {
//			System.out.println("Cadastrado com sucesso!");
//		} else {
//			System.out.println("Erro durante cadastro!");
//		}

		tc.close();

	}

}
