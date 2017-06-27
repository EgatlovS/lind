package de.egatlovs.lind.components.structure.entity;

import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import de.egatlovs.lind.components.linkpoint.entity.Linkpoint;

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
		TypedQuery<Structure> q = em.createNamedQuery("Structure.GET_BY_NAME", Structure.class) //
				.setParameter("name", name);
		return q.getSingleResult();
	}

	public void persist(Structure structure) {
		em.persist(structure);
	}

	public void removeStructure(long id) {
		em.remove(getStructure(id));
	}

	public void removeStructure(String name) {
		em.remove(getStructure(name));
	}

	public List<Linkpoint> getMatchingLinkpoints(long id) {
		TypedQuery<Linkpoint> q = em.createNamedQuery("Structure.GET_MATCHING_LINKPOINTS", Linkpoint.class)//
				.setParameter("id", id);
		return q.getResultList();
	}

}
