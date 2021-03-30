package program.entidades;

import java.text.ParseException;

import javax.swing.text.MaskFormatter;

import program.servico.DataForm;

public class Endereco extends DataForm{
	
	private String rua;
	private String bairro;
	private String cidade;
	private String uf;
	private String complemento;
	private String cep;
	private String num;
	private static String FormatoCep = "##.###-###";

	public Endereco(String celular, String fone, String dataNasc, String dataVacina1, Integer resp, String rua,
			String bairro, String cidade, String uf, String complemento, String cep, String num) {
		super(celular, fone, dataNasc, dataVacina1, resp);
		this.rua = rua;
		this.bairro = bairro;
		this.cidade = cidade;
		this.uf = uf;
		this.complemento = complemento;
		this.cep = cep;
		this.num = num;
	}	

	public Endereco() {
		super();
	}

	public String getRua() {
		return rua;
	}

	public void setRua(String rua) {
		this.rua = rua;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getUf() {
		return uf;
	}

	public void setUf(String uf) {
		this.uf = uf;
	}

	public String getComplemento() {
		return complemento;
	}

	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}

	public String getCep(boolean Mascara) {
		return FormatCep(this.cep, Mascara);
	}

	public void setCep(String cep) {
		this.cep = this.FormatCep(cep, false);
	}

	public String getNum() {
		return num;
	}

	public void setNum(String num) {
		this.num = num;
	}
	
	//Simplifica o número do CEP para receber a marcara
	private String FormatCep(String C, boolean Mascara) {
		if (Mascara) {
			return (C.substring(0, 2) + "." + C.substring(2, 5) + "-" + C.substring(5, 7));
		} else {
			C = C.replace("/", "");
			C = C.replace("-", "");
			C = C.replace(".", "");
			return C;
		}		
	}

	private String formatar(String pattern, Object value) {
		MaskFormatter mask;
		try {
			mask = new MaskFormatter(pattern);
			mask.setValueContainsLiteralCharacters(false);
			return mask.valueToString(value);
		} catch (ParseException e) {
			throw new RuntimeException(e);
		}
	}
	
    public String getCEPFormatada() {
    	if(cep != null) {
            return formatar(FormatoCep, cep);
        	}
        	else {
        		return null;
        	}
    }

	public String toStringEnd() {
		return "Endereco: " + this.rua + ", N°: " + this.num + "\nBairro: " + this.bairro 
		+ "\nCidade: " + this.cidade + "\nUF: " + this.uf.toUpperCase()
		+ "\nComplemento: " + this.complemento + "\nCEP: " + getCEPFormatada();
	}
    
}
