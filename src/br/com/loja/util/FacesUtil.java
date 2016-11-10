package br.com.loja.util;

import javax.faces.application.FacesMessage;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import java.util.Map;


public class FacesUtil {
	public static void adicionarMsgInfo(String mensagem){
		FacesMessage facesmessage = new FacesMessage(FacesMessage.SEVERITY_INFO, mensagem, mensagem);
		
		FacesContext facesContext = FacesContext.getCurrentInstance();
		facesContext.addMessage(null, facesmessage);
	}
	public static void adicionarMsgError(String mensagem){
		FacesMessage facesmessage = new FacesMessage(FacesMessage.SEVERITY_ERROR, mensagem, mensagem);
		FacesContext facesContext = FacesContext.getCurrentInstance();
		facesContext.addMessage(null, facesmessage);
	}
	public static String getParam(String nome){
		FacesContext facesContext = FacesContext.getCurrentInstance();
		ExternalContext externalContext = facesContext.getExternalContext();
		
		Map<String, String> parametros = externalContext.getRequestParameterMap();
		
		String valor = parametros.get(nome);
		return valor;
	}
}
