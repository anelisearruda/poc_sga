package br.com.oi.sga.poc.validator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.component.UIInput;
import javax.faces.context.FacesContext;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

public class CPFValidator implements Validator {

	@Override
	public void validate(FacesContext context, UIComponent component,
			Object viewValue) throws ValidatorException {

		String value = (String) viewValue;
		Pattern pattern = Pattern
				.compile("[0-9]{3}[.][0-9]{3}[.][0-9]{3}[-][0-9]{2}");
		Matcher search = pattern.matcher(value);
		if (value.length()!=14) {
			throw new ValidatorException(new FacesMessage(FacesMessage.SEVERITY_ERROR, null, 
					"CPF: (" + value + ") é inválido"));
		} else {
			if (!search.matches() || !validaCPF(value)) {
				((UIInput) component).setValid(false);
				throw new ValidatorException(new FacesMessage(FacesMessage.SEVERITY_ERROR, null,
	                    "CPF: (" + value + ") é inválido"));				
			} 
		}
	}

	public boolean validaCPF(String strCpf) {
		if (!strCpf.substring(0, 1).equals("")) {
			try {
				int d1, d2;
				int digito1, digito2, resto;
				int digitoCPF;
				String nDigResult;
				strCpf = strCpf.replace('.', ' ');
				strCpf = strCpf.replace('-', ' ');
				strCpf = strCpf.replaceAll(" ", "");
				d1 = d2 = 0;
				digito1 = digito2 = resto = 0;

				for (int nCount = 1; nCount < strCpf.length() - 1; nCount++) {
					digitoCPF = Integer.valueOf(
							strCpf.substring(nCount - 1, nCount)).intValue();
					d1 = d1 + (11 - nCount) * digitoCPF;
					d2 = d2 + (12 - nCount) * digitoCPF;
				}
				resto = (d1 % 11);
				if (resto < 2) {
					digito1 = 0;
				} else {
					digito1 = 11 - resto;
				}
				d2 += 2 * digito1;
				resto = (d2 % 11);
				if (resto < 2) {
					digito2 = 0;
				} else {
					digito2 = 11 - resto;
				}
				String nDigVerific = strCpf.substring(strCpf.length() - 2,
						strCpf.length());
				nDigResult = String.valueOf(digito1) + String.valueOf(digito2);
				return nDigVerific.equals(nDigResult);
			} catch (Exception e) {
				System.err.println("Erro !" + e);
				return false;
			}
		} else {
			return false;
		}
	}

}
