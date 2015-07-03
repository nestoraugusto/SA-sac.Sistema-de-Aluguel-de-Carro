package br.senai.sc.ti20132n1.sa.Dao;

import java.util.List;

import javax.persistence.Query;

import br.senai.sc.ti20132n1.sa.model.Estado;

public class EstadoDao extends Dao{
	
	@SuppressWarnings("unchecked")
	public List<Estado> listarTodos() {
		Query query = getEntityManager().createQuery("From Estado",Estado.class);
		return query.getResultList();
	}
	
	public Estado buscaPorId(Long id){
		return getEntityManager().find(Estado.class, id);
	}

}
