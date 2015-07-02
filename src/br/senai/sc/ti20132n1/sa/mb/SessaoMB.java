package br.senai.sc.ti20132n1.sa.mb;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import br.senai.sc.ti20132n1.sa.Dao.ClienteDao;
import br.senai.sc.ti20132n1.sa.model.Cliente;

@ManagedBean
@SessionScoped
public class SessaoMB {
	
	private Cliente clienteForm;
	private Cliente clienteLogado;
	
	@PostConstruct
	public void init(){
		clienteForm = new Cliente();
	}
	
	public boolean isLogado(){
		return clienteLogado != null;
	}
	
	private boolean checkLogin(Cliente clienteEncontrado) {
		return clienteEncontrado != null 
				&& clienteForm.getEmail().equalsIgnoreCase(clienteEncontrado.getEmail()) 
				&& clienteForm.getSenha().equals(clienteEncontrado.getSenha());
	}
	
	public String login(){
		ClienteDao dao = new ClienteDao();
		Cliente cliente = dao.buscarPorEmail(clienteForm.getEmail());
		
		if(checkLogin(cliente)){
			clienteLogado = cliente;
			return "/index?face-redirect=true";
		}
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Email ou senha invalidos"));
		return "/login";
	}
	
	public Cliente getClienteForm(){
		return clienteForm;
	}
	
	public void setClienteForm(Cliente clienteForm){
		this.clienteForm = clienteForm;
	}
	
	
	

}
