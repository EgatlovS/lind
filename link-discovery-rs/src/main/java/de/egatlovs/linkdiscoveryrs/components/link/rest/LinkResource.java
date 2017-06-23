package de.egatlovs.linkdiscoveryrs.components.link.rest;

import java.util.List;

import javax.ws.rs.core.Response;

import de.egatlovs.linkdiscoveryrs.components.link.entity.Link;

public class LinkResource implements LinkResourceDefinition {

	@Override
	public Response getLinks(long structureId, String structureName) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Response createLinks(List<Link> structures) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Response getLinkById(long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Response updateLinkById(long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Response createLink(Link structure) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Response removeLinkById(long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Response removeLinksByStructureId(long structureId, String structureName) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Response getLinkField(long id, String fieldname) {
		// TODO Auto-generated method stub
		return null;
	}

}
