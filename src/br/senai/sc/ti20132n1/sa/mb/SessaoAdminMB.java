package br.senai.sc.ti20132n1.sa.mb;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import br.senai.sc.ti20132n1.sa.Dao.AdministradorDao;
import br.senai.sc.ti20132n1.sa.model.Administrador;

@ManagedBean
@SessionScoped
public class SessaoAdminMB {
	
	private Administrador administradorForm;
	private Administrador administradorLogado;
	
	@PostConstruct
	public void init(){
		administradorForm = new Administrador();
	}
	
	public boolean isLogadoAdmin(){
		return administradorLogado != null;
	}
	
	public String login(){
		AdministradorDao dao = new AdministradorDao();
		Administrador administrador = dao.buscaPorEmail(administradorForm.getEmail());
			if(checkLogin(administrador)){
				administradorLogado = administrador;
				return "/index?faces-redirect=true";
			}
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Usuário ou senha inválido."));
		return "/login";
	}
	
	private boolean checkLogin(Administrador administradorEncontrado) {
		return administradorEncontrado != null 
				&& administradorForm.getEmail().equals(administradorEncontrado.getEmail()) 
				&& administradorForm.getSenha().equals(administradorEncontrado.getSenha());
	}
	
	public String logout(){
		administradorLogado = null;
		return "/login?face-redirect=true";
	}

	public Administrador getAdministradorForm() {
		return administradorForm;
	}

	public void setAdministradorForm(Administrador administradorLogar) {
		this.administradorForm = administradorLogar;
	}

	public Administrador getAdministradorLogado() {
		return administradorLogado;
	}

	public void setAdministradorLogado(Administrador administradorLogado) {
		this.administradorLogado = administradorLogado;
	}

	
}