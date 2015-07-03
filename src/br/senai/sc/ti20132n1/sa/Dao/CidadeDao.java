package br.senai.sc.ti20132n1.sa.Dao;

import java.util.List;

import javax.persistence.Query;

import br.senai.sc.ti20132n1.sa.model.Cidade;

public class CidadeDao extends Dao{
	
	@SuppressWarnings("unchecked")
	public List<Cidade> listarTodos() {
		Query query = getEntityManager().createQuery("From Cidade",
				Cidade.class);
		return query.getResultList();
	}

}
