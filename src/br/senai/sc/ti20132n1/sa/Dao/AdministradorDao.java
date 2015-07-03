package br.senai.sc.ti20132n1.sa.Dao;

import java.util.List;

import javax.persistence.Query;


import br.senai.sc.ti20132n1.sa.model.Administrador;
import br.senai.sc.ti20132n1.sa.model.Cliente;


public class AdministradorDao extends Dao{


	
	public void salvar(Administrador administrador) {
		getEntityManager().merge(administrador);
	}
	
	public void excluir(Long id) {
		Administrador administrador = getEntityManager().getReference(Administrador.class, id);
		getEntityManager().remove(administrador);
	}
	
	public Administrador buscarPorId(Long id) {
		return getEntityManager().find(Administrador.class, id);
	}
	
	public Administrador buscaPorEmail(String email) {
		Query query = getEntityManager().createQuery("From Administrador u Where u.email = :email", Administrador.class);
		query.setParameter("email", email);
		return (Administrador) query.getSingleResult();
	}
	
	
	@SuppressWarnings("unchecked")
	public List<Administrador> listarTodos() {
		Query query = getEntityManager().createQuery("From Administrador",Administrador.class);
		return query.getResultList();
	}
	
	
}
