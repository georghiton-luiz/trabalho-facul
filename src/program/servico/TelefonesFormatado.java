package program.servico;

import java.text.ParseException;

import javax.swing.text.DefaultFormatterFactory;
import javax.swing.text.MaskFormatter;

public class TelefonesFormatado {

	private String celular;
	private String fone;
	private static String FormatoC = "(##) #####.####";
	private static String FormatoF = "(##) ####.####";	

			
	public TelefonesFormatado(String celular, String fone) {
		super();
		this.celular = celular;
		this.fone = fone;
	}

	public TelefonesFormatado(String celular) {		
		this.celular = this.Format(celular, false);
	}
	
	public TelefonesFormatado() {
		super();		
	}

	public void FoneFixoFormatado(String data) {		
		this.fone = this.Format(data, false);;
	}

	public String getCelular(boolean Mascara) {
		return Format(this.celular, Mascara);
	}
	
	public String getFone(boolean Mascara) {
		return Format(this.celular, Mascara);
	}
	
	private String Format(String C, boolean Mascara) {
		if (Mascara) {
			return (C.substring(0, 7) + "." + C.substring(7, 11));
		}
		else if(Mascara) {
			return (C.substring(0, 6) + "." + C.substring(6, 10));
		}
		else {
			C = C.replace(".", "");
			C = C.replace(" ", "");
			C = C.replace("(", "");
			C = C.replace(")", "");
			return C;
		}
	}

	public static DefaultFormatterFactory getFormatC() {
		try {
			return new DefaultFormatterFactory(new MaskFormatter(FormatoC));
		} catch (Exception e) {
			return null;
		}
	}
	
	public static DefaultFormatterFactory getFormatF() {
		try {
			return new DefaultFormatterFactory(new MaskFormatter(FormatoF));
		} catch (Exception e) {
			return null;
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

	public String getCelularFormatada() {
		return formatar(FormatoC, celular);
	}
	
	public String getFoneFixoFormatada() {
		return formatar(FormatoF, fone);
	}
	
	public String toStringFones() {
		return "\nFone: " + getFoneFixoFormatada() + "\nCelular: " + getCelularFormatada();
	}

}
