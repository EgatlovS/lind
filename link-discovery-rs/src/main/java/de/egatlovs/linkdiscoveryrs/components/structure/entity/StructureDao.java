package de.egatlovs.linkdiscoveryrs.components.structure.entity;

import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

@RequestScoped
public class StructureDao {

	@PersistenceContext
	private EntityManager em;

	public List<Structure> getStructures() {
		TypedQuery<Structure> q = em.createNamedQuery("Structure.GET_ALL", Structure.class);
		return q.getResultList();
	}

	public Structure getStructure(long id) {
		TypedQuery<Structure> q = em.createNamedQuery("Structure.GET_BY_ID", Structure.class) //
				.setParameter("id", id);
		return q.getSingleResult();
	}

	public Structure getStructure(String name) {
		TypedQuery<Structure> q = em.createNamedQuery("Structure.GET_BY_ID", Structure.class) //
				.setParameter("name", name);
		return q.getSingleResult();
	}

}
