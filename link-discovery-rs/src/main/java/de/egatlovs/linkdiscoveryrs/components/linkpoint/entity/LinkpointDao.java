package de.egatlovs.linkdiscoveryrs.components.linkpoint.entity;

import javax.enterprise.context.RequestScoped;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@RequestScoped
public class LinkpointDao {

	@PersistenceContext
	private EntityManager em;

}
