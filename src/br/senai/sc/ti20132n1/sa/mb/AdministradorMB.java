package br.senai.sc.ti20132n1.sa.mb;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

import br.senai.sc.ti20132n1.sa.Dao.AdministradorDao;
import br.senai.sc.ti20132n1.sa.model.Administrador;

@ManagedBean
public class AdministradorMB {

	private Administrador administrador;
	private List<Administrador> administradores;
	private AdministradorDao administradorDao;

	@PostConstruct
	public void initMB() {
		this.administrador = new Administrador();
		administradorDao = new AdministradorDao();
	}

	
	
	public List<Administrador> getAdministradores() {
		return administradores;
	}
	
	public List<Administrador> getCarros() {
		if (administradores == null) {
			administradores = administradorDao.listarTodos();
		}
		return administradores;
	}



	public void setAdministradores(List<Administrador> administradores) {
		this.administradores = administradores;
	}



	public AdministradorDao getAdministradorDao() {
		return administradorDao;
	}



	public void setAdministradorDao(AdministradorDao administradorDao) {
		this.administradorDao = administradorDao;
	}



	public void setAdministrador(Administrador administrador) {
		this.administrador = administrador;
	}



	public Administrador getAdministrador() {
		return administrador;
	}

	public Administrador setAdministrador() {
		return administrador;
	}

	

	public void setAdministrador(List<Administrador> administradores) {
		this.administradores = administradores;
	}

	public String salvar() {
		administradorDao.salvar(administrador);
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Administrador salvo com sucesso!"));
		return "/listaradmin?faces-redirect=true";
	}

	public String excluir(String idParam) {
		Long id = Long.valueOf(idParam);
		administradorDao.excluir(id);
		return "formadministrador";
	}

	public String editar(String idParam) {
		Long id = Long.valueOf(idParam);
		administradorDao.buscarPorId(id);
		return "formadministrador";
	}

}
