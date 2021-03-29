package program.entidades;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import program.servico.CPF;

public class Pessoa extends CPF {	

	private String nome, rg, orgEmissor, numSus, email;	

	public Pessoa() {
		super();
	}

	public Pessoa(String celular, String fone, String dataNasc, String dataVacina1, Integer resp, String rua,
			String bairro, String cidade, String uf, String complemento, String cep, String num, String cpf,
			String nome, String rg, String orgEmissor, String numSus, String email) {
		super(celular, fone, dataNasc, dataVacina1, resp, rua, bairro, cidade, uf, complemento, cep, num, cpf);
		this.nome = nome;
		this.rg = rg;
		this.orgEmissor = orgEmissor;
		this.numSus = numSus;
		this.email = email;
	}

	public String getNome() {
		return this.nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getRg() {
		return rg;
	}

	public void setRg(String rg) {
		this.rg = rg;
	}

	public String getOrgEmissor() {
		return orgEmissor;
	}

	public void setOrgEmissor(String orgEmissor) {
		this.orgEmissor = orgEmissor;
	}

	public String getNumSus() {
		return numSus;
	}

	public void setNumSus(String numSus) {
		this.numSus = numSus;
	}	
	
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	public static boolean isValidEmailAddressRegex(String email) {
	    boolean isEmailIdValid = false;
	    if (email != null && email.length() > 0) {
	        String expression = "^[\\w\\.-]+@([\\w\\-]+\\.)+[A-Z]{2,4}$";
	        Pattern pattern = Pattern.compile(expression, Pattern.CASE_INSENSITIVE);
	        Matcher matcher = pattern.matcher(email);
	        if (matcher.matches()) {
	            isEmailIdValid = true;
	        }
	    }
	    return isEmailIdValid;
	}

	public String toStringPessoa() {
		return "Nome: " + this.nome + "\nR.G.:" + this.rg + "\nOrgão Emissor: "
	+ this.orgEmissor + "\nNúmero SUS: " + this.numSus;
	}
	
}
