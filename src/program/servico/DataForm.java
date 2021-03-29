package program.servico;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.swing.text.DefaultFormatterFactory;
import javax.swing.text.MaskFormatter;

public class DataForm extends TelefonesFormatado{

	private String dataNasc;
	private String dataVacina1;
	private Integer resp;
	private static String Formato = "##/##/####";	
	
	public DataForm(String celular, String fone, String dataNasc, String dataVacina1, Integer resp) {
		super(celular, fone);
		this.dataNasc = dataNasc;
		this.dataVacina1 = dataVacina1;
		this.resp = resp;		
	}	

	public DataForm() {
		super();
	}
	
	public Integer getResp1() {
		return resp;
	}

	public void setResp1(Integer resp) {
		this.resp = resp;
	}

	public String getDataNasc(boolean Mascara) {
		return Format(this.dataNasc, Mascara);
	}

	public void DataNasc(String data) {
		this.dataNasc = this.Format(data, false);
	}

	public String getDataVacina1(boolean Mascara) {
		return Format(this.dataVacina1, Mascara);
	}

	public void DataVacina1(String data) {
		this.dataVacina1 = this.Format(data, false);
	}

	private String Format(String C, boolean Mascara) {
		if (Mascara) {
			return (C.substring(0, 2) + "/" + C.substring(2, 4) + "/" + C.substring(4, 8));
		} else {
			C = C.replace("/", "");
			C = C.replace("-", "");
			C = C.replace(".", "");
			return C;
		}
	}

	public static DefaultFormatterFactory getFormat() {
		try {
			return new DefaultFormatterFactory(new MaskFormatter(Formato));
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

	public String getDataNascFormatada() {
		return formatar(Formato, dataNasc);
	}

	public String getDataVacina1Formatada() {
		return formatar(Formato, dataVacina1);
	}

	public String TipoVacina() {
		if (resp == 0) {
			return "CoronaVac";
			
		}else if(resp == 1) {
			return "Covishield";
		}else {			
			return null;			
		}		
	}

	public String getDataVacina2() throws ParseException {

		Date d1 = new Date();

		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		d1 = sdf.parse(getDataVacina1Formatada());

		if (resp == 0) {
			Calendar cal = Calendar.getInstance();
			cal.setTime(d1);
			cal.add(Calendar.DAY_OF_MONTH, 30);
			d1 = cal.getTime();
			String data = sdf.format(d1);
			return data;

		} else if (resp == 1) {
			Calendar cal = Calendar.getInstance();
			cal.setTime(d1);
			cal.add(Calendar.DAY_OF_MONTH, 90);
			d1 = cal.getTime();
			String data = sdf.format(d1);
			return data;
		}
		return null;

	}

	public String dataNascParaBD() throws ParseException {

		String dataBD;
		Date d1 = new Date();

		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		d1 = sdf.parse(getDataNascFormatada());

		SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd");
		dataBD = sdf2.format(d1);

		return dataBD;
	}

	public String dataVacina1ParaBD() throws ParseException {
		String dataBD;
		Date d1 = new Date();

		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		d1 = sdf.parse(getDataVacina1Formatada());

		SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd");
		dataBD = sdf2.format(d1);

		return dataBD;
	}

	public String dataVacina2ParaBD() throws ParseException {
		String dataBD;
		Date d1 = new Date();

		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		d1 = sdf.parse(getDataVacina2());

		SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd");
		dataBD = sdf2.format(d1);

		return dataBD;
	}

	public String toStringData() {
		try {
			return "\nData de Nascimento: " + getDataNascFormatada() + "\nVacia aplicada: " + TipoVacina() + "\nData 1ª dose: "
		+ getDataVacina1Formatada() + "\nData 2ª dose: " + getDataVacina2();
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
}
