package br.com.oi.sga.poc.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;
import javax.faces.convert.FacesConverter;

@FacesConverter("cepConverter")
public class CEPConverter implements Converter {
    
	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String value) throws ConverterException {

         String cep = value;
         if (value!= null && !value.equals(""))
              cep = value.replaceAll("\\.", "").replaceAll("\\-", "");

         return cep;
    }

	@Override
    public String getAsString(FacesContext context, UIComponent component, Object value) throws ConverterException {

         String cep= (String) value;
         if (cep != null && cep.length() == 8)
              cep = cep.substring(0, 5) + "-" + cep.substring(5, 7);

         return cep;
    }

}
