package program;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import program.entidades.Pessoa;
import program.servico.Conexao;

public class Programa {
	
	public static void main(String[] args) throws ParseException {
				
		Scanner tc = new Scanner(System.in);

		Integer resp = null;
		
		System.out.println("-----------------------------------------------------");		
		System.out.println("|Bem-vindo ao cadstro de vacinação contra o COVID-19|");
		System.out.println("-----------------------------------------------------\n");
		
		System.out.println("----------");
		System.out.println("|Cadastro|");
		System.out.println("----------");
		
		System.out.print("\nDigite seu completo: ");
		String nome = tc.nextLine();
		System.out.println("");
		
		System.out.print("Digite seu data de nascimento: ");
		String dataNasc = tc.next();
		System.out.println("");
		
		System.out.print("Digite seu CPF: ");
		String cpf = tc.next();
		System.out.println("");
		
		Pessoa cpfPaciente = new Pessoa();
		cpfPaciente.CPFPaciente(cpf);
		
		while(cpfPaciente.isCPF() == false) {
			System.out.println("CFP invalido!\n\nDigitar um CPF valido!");
			cpf = tc.next();
			System.out.println("");
			
			cpfPaciente.CPFPaciente(cpf);			
		}		
		
		System.out.print("Digite seu R.G.: ");
		String rg = tc.next();
		System.out.println("");
		
		System.out.print("Digite orgão emissor do R.G.: ");
		String orgEmissor = tc.next().toUpperCase();
		System.out.println("");
		
		System.out.print("Digite seu número do SUS: ");
		String numSus = tc.next();
		System.out.println("");
		
		System.out.print("Digite seu número de telefone fixo com DDD: ");
		String fone = tc.next();
		System.out.println("");
		
		System.out.print("Digite seu número celular com DDD: ");
		String celular = tc.next();
		System.out.println("");
		
		System.out.print("Digite seu E-mail: ");
		String email = tc.next();
		System.out.println("");
		
		System.out.println("--------------------");
		System.out.println("|Digite seu enderço|");
		System.out.println("--------------------\n");
		
		System.out.print("Digite o lagradouro: ");
		tc.nextLine();
		String rua = tc.nextLine();
		System.out.println("");
		
		System.out.print("Digite o numero: ");
		String num = tc.next();
		System.out.println("");		

		System.out.print("Digite o bairro: ");
		tc.nextLine();
		String bairro = tc.nextLine();
		System.out.println("");
		
		System.out.print("Digite o cidade: ");
		String cidade = tc.nextLine();
		System.out.println("");
		
		System.out.print("Digite o UF: ");
		String uf = tc.nextLine().toUpperCase();
		System.out.println("");
		
		System.out.print("Digite o complemento: ");
		String complemento = tc.nextLine();
		System.out.println("");
		
		System.out.print("Digite o CEP: ");
		String cep = tc.nextLine();
		System.out.println("");
		String dataVacina1 = null;
		
		int respVacina;		
		
		System.out.print("Paciente irá receber a 1ª dose da vacina? [0] = SIM ou [1] NÃO: ");
		respVacina = tc.nextInt();		
		
		while(respVacina > 0 && respVacina > 1) {
			System.out.print("\nOpção invalida!\n\nPaciente irá receber a 1ª dose da vacina? [0] = SIM ou [1] NÃO: ");
			respVacina = tc.nextInt();
		}

		if (respVacina == 0) {

			System.out.print("\nQual vacina será aplicada? [0] = CoronaVac ou  [1] = Covishield: ");
			resp = tc.nextInt();			

			while (resp > 0 && resp > 1) {
				System.out.print("\nOpção invalida!\nDigita [0] = CoronaVac ou  [1] = Covishield: ");
				resp = tc.nextInt();
			}
			
			if (resp == 0) {
				System.out.print("\nata da primeira vacina: ");
				dataVacina1 = tc.next();

			} else if (resp == 1) {
				System.out.print("\nData da primeira vacina: ");
				dataVacina1 = tc.next();
			}

		} else {
			System.out.print("\nData da primeira vacina: ");
			dataVacina1 = tc.next();
		}		
		
		Conexao con = new Conexao();
		Pessoa p1 = new Pessoa(celular, fone, dataNasc, dataVacina1, resp, rua, bairro, cidade, uf, complemento, cep, num, cpf, nome, rg, orgEmissor, numSus, email);
		
		Date dBD1,dBD2,dBD3;
		
		SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd");
		dBD1 = sdf1.parse(p1.dataNascParaBD());
		dBD2 = sdf1.parse(p1.dataVacina1ParaBD());
		dBD3 = sdf1.parse(p1.dataVacina2ParaBD());
		
		String sqlDadosPaciente, sqlEnderecoPaciente, sqlContatoPaciente, sqlVacinaPaciente;
			
		sqlDadosPaciente = "INSERT INTO dados_paciente (id_paciente,nome_paciente,data_nasc_paciente,"
				+ "rg_paciente,org_emissor_paciente,cpf_paciente,num_sus_paciente)values" + "(default,'" + p1.getNome()
				+ "','" + dBD1 + "','" + p1.getRg() + "','" + p1.getOrgEmissor() + "','"
				+ p1.getCpfPaciente() + "','" + p1.getNumSus() + "')";
		int confConect = con.executaSQL(sqlDadosPaciente);
		if(confConect > 0) {
			System.out.println("Dados do paciente cadastrado com sucesso");			
		}else {
			System.out.println("Dados não cadastrado");
		}
	
		sqlEnderecoPaciente = "INSERT INTO endereco_paciente (id_endereco,id_paciente,rua_paciente,num_paciente,"
				+ "bairro_paciente,cidade_paciente,uf_paciente,complemento_paciente,cep_paciente)values" + "(default,default,'"
				+ p1.getRua() + "','" + p1.getNum() + "','" + p1.getBairro() + "','" + p1.getCidade() + "','"
				+ p1.getUf() + "','" + p1.getComplemento() + "','" + p1.getCEPFormatada() + "')";
		confConect = con.executaSQL(sqlEnderecoPaciente);
		if(confConect > 0) {
			System.out.println("Dados do paciente cadastrado com sucesso");			
		}else {
			System.out.println("Dados não cadastrado");
		}
		
		sqlContatoPaciente = "INSERT INTO contato_paciente (id_contato,id_paciente,fone_paciente,celular_paciente,"
				+ "email_paciente)values" + "(default, default,'" + p1.getFoneFixoFormatada() + "','" + p1.getCelularFormatada()
				+ "','" + p1.getEmail() + "')";
		confConect = con.executaSQL(sqlContatoPaciente);
		if(confConect > 0) {
			System.out.println("Dados do paciente cadastrado com sucesso");			
		}else {
			System.out.println("Dados não cadastrado");
		}
		
		sqlVacinaPaciente = "INSERT INTO vacina_paciente (id_vacina,id_paciente,tipo_vac_paciente,data1_vac_paciente,"
				+ "data2_vac_paciente)values" + "(default,default,'" + p1.TipoVacina() + "','" + dBD2 + "','"
				+ dBD3 + "')";
		confConect = con.executaSQL(sqlVacinaPaciente);
		if(confConect > 0) {
			System.out.println("Dados do paciente cadastrado com sucesso");			
		}else {
			System.out.println("Dados não cadastrado");
		}
		con.closeCon();
		tc.close();
	}
}
