package de.egatlovs.linkdiscoveryrs.components.linkpoint.entity;

import javax.enterprise.context.RequestScoped;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

@RequestScoped
public class LinkpointDao {

	@PersistenceContext
	private EntityManager em;

	public Linkpoint getLinkpoint(long id) {
		TypedQuery<Linkpoint> q = em.createNamedQuery("Linkpoint.GET_BY_ID", Linkpoint.class) //
				.setParameter("id", id);
		return q.getSingleResult();
	}

	public Field getField(long id, String fieldname) {
		TypedQuery<Field> q = em.createNamedQuery("Linkpoint.GET_FIELD_OF_LINKPOINT", Field.class)//
				.setParameter("id", id)//
				.setParameter("name", fieldname);
		return q.getSingleResult();
	}

	public void removeLinkpoint(long id) {
		em.remove(getLinkpoint(id));
	}

	public void persist(Linkpoint linkpoint) {
		em.persist(linkpoint);
	}

	public void merge(Linkpoint linkpoint) {
		em.merge(linkpoint);
	}

}
