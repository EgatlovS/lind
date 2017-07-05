package de.egatlovs.lind.components.structure.entity.dbaccess;

import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import de.egatlovs.lind.components.linkpoint.entity.Linkpoint;
import de.egatlovs.lind.components.structure.entity.Structure;

@RequestScoped
public class StructureDao {

	@PersistenceContext
	private EntityManager em;

	public List<Structure> readAll() {
		TypedQuery<Structure> q = em.createNamedQuery("Structure.GET_ALL", Structure.class);
		return q.getResultList();
	}

	public Structure read(long id) {
		TypedQuery<Structure> q = em.createNamedQuery("Structure.GET_BY_ID", Structure.class) //
				.setParameter("id", id);
		return q.getSingleResult();
	}

	public void save(Structure structure) {
		em.persist(structure);
	}

	public void remove(long id) {
		em.remove(read(id));
	}

	public List<Linkpoint> matchingLinkpoints(long id) {
		TypedQuery<Linkpoint> q = em.createNamedQuery("Structure.GET_MATCHING_LINKPOINTS", Linkpoint.class)//
				.setParameter("id", id);
		return q.getResultList();
	}

}
