package de.egatlovs.lind.components.linkpoint.entity.dbaccess;

import javax.enterprise.context.RequestScoped;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import de.egatlovs.lind.components.linkpoint.entity.Linkpoint;

@RequestScoped
public class LinkpointDao {

	@PersistenceContext
	private EntityManager em;

	public Linkpoint read(long id) {
		TypedQuery<Linkpoint> q = em.createNamedQuery("Linkpoint.GET_BY_ID", Linkpoint.class) //
				.setParameter("id", id);
		return q.getSingleResult();
	}

	public void remove(long id) {
		em.remove(read(id));
	}

	public void save(Linkpoint linkpoint) {
		em.persist(linkpoint);
	}

	public void update(Linkpoint linkpoint) {
		em.merge(linkpoint);
	}

}
