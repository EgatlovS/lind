package de.egatlovs.linkdiscoveryrs.components.linkpoint.rest;

import javax.ws.rs.core.Response;

import de.egatlovs.linkdiscoveryrs.components.linkpoint.entity.Linkpoint;

public class LinkpointResource implements LinkpointResourceDefinition {

	@Override
	public Response getLinkpoints(long structureId, String structureName) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Response removeLinkpointsByStructureId(long structureId, String structureName) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Response getLinkpointById(long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Response createLinkpoint(Linkpoint linkpoint) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Response updateLinkpointById(long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Response removeLinkpointById(long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Response getLinkpointField(long id, String fieldname) {
		// TODO Auto-generated method stub
		return null;
	}

}
