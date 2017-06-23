package de.egatlovs.linkdiscoveryrs.components.structure.rest;

import java.util.List;

import javax.ws.rs.core.Response;

import de.egatlovs.linkdiscoveryrs.components.structure.entity.Structure;

public class StructureResource implements StructureResourceDefinition {

	@Override
	public Response getStructures() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Response createStructures(List<Structure> structures) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Response getStructureById(long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Response getStructureByName(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Response createStructure(Structure structure) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Response removeStructureById(long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Response removeStructureByName(String name) {
		// TODO Auto-generated method stub
		return null;
	}

}
