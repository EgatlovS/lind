package de.egatlovs.linkdiscoveryrs.components.linkpoint.rest;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.core.Response;

import de.egatlovs.linkdiscoveryrs.components.linkpoint.boundary.LinkpointBoundary;
import de.egatlovs.linkdiscoveryrs.components.linkpoint.entity.Field;
import de.egatlovs.linkdiscoveryrs.components.linkpoint.entity.Linkpoint;

@RequestScoped
public class LinkpointResource implements LinkpointResourceDefinition {

	@Inject
	private LinkpointBoundary bdry;

	@Override
	public Response getLinkpointById(long id) {
		Linkpoint linkpoint = bdry.getLinkpointById(id);
		return Response.ok(linkpoint).build();
	}

	@Override
	public Response createLinkpoint(Linkpoint linkpoint) {
		Linkpoint created = bdry.createLinkpoint(linkpoint);
		return Response.status(201).entity(created).build();
	}

	@Override
	public Response updateLinkpointById(long id, Linkpoint linkpoint) {
		Linkpoint updated = bdry.updateLinkpointById(id, linkpoint);
		return Response.ok(updated).build();
	}

	@Override
	public Response removeLinkpointById(long id) {
		bdry.removeLinkpointById(id);
		return Response.ok().build();
	}

	@Override
	public Response getLinkpointField(long id, String fieldname) {
		Field field = bdry.getLinkpointField(id, fieldname);
		return Response.ok(field).build();
	}

}
