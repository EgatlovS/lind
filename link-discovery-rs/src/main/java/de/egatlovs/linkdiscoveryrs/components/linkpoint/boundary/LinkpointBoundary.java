package de.egatlovs.linkdiscoveryrs.components.linkpoint.boundary;

import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;

import de.egatlovs.linkdiscoveryrs.components.linkpoint.entity.Field;
import de.egatlovs.linkdiscoveryrs.components.linkpoint.entity.Linkpoint;

@Stateless
@TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
public class LinkpointBoundary {

	public Linkpoint getLinkpointById(long id) {
		// TODO get endpoint from db
		// TODO map endpoint to dto
		// TODO return endpoint
		return null;
	}

	public Linkpoint createLinkpoint(Linkpoint linkpoint) {
		// TODO get structure of endpoint
		// TODO validate against structure constraints
		// TODO map linkpoint to entity
		// TODO write linkpoint in db
		// TODO return created linkpoint
		return null;
	}

	public Linkpoint updateLinkpointById(long id, Linkpoint linkpoint) {
		// TODO get linkpoint from db
		// TODO map updated linkpoint to entity
		// TODO get structure from db
		// TODO validate updated linkpoint against structure
		// TODO write updated linkpoint in db
		// TODO return updated linkpoint
		return null;
	}

	public void removeLinkpointById(long id) {
		// TODO try to remove linkpoint from db
	}

	public Field getLinkpointField(long id, String fieldname) {
		// TODO try to get field of linkpoint from db
		// TODO return field
		return null;
	}

}
