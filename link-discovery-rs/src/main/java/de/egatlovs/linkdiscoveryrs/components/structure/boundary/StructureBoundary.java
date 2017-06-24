package de.egatlovs.linkdiscoveryrs.components.structure.boundary;

import java.util.List;

import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.inject.Inject;

import de.egatlovs.linkdiscoveryrs.components.linkpoint.entity.LinkpointDTO;
import de.egatlovs.linkdiscoveryrs.components.structure.control.Transformer;
import de.egatlovs.linkdiscoveryrs.components.structure.entity.Structure;
import de.egatlovs.linkdiscoveryrs.components.structure.entity.StructureDTO;
import de.egatlovs.linkdiscoveryrs.components.structure.entity.StructureDao;

@Stateless
@TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
public class StructureBoundary {

	@Inject
	private StructureDao dao;

	@Inject
	private Transformer bumblebee;

	public List<StructureDTO> getStructures() {
		List<Structure> structures = dao.getStructures();
		List<StructureDTO> dtos = bumblebee.structureDTOs(structures);
		return dtos;
	}

	public StructureDTO getStructureById(long id) {
		Structure structure = dao.getStructure(id);
		StructureDTO dto = bumblebee.structureDTO(structure);
		return dto;
	}

	public StructureDTO getStructureByName(String name) {
		Structure structure = dao.getStructure(name);
		StructureDTO dto = bumblebee.structureDTO(structure);
		return dto;
	}

	public StructureDTO createStructure(StructureDTO structure) {
		// TODO map structure to entity
		// TODO write structure in db
		// TODO return created structure
		return null;
	}

	public void removeStructureById(long id) {
		// TODO try to remove structure and attached linkpoints from db
	}

	public void removeStructureByName(String name) {
		// TODO try to remove structure and attached linkpoints from db
	}

	public List<LinkpointDTO> getLinkpointsByStructureId(long id) {
		// TODO get linkpoints from db
		// TODO map linkpoints to dto
		// TODO return linkpoints
		return null;
	}

	public void removeLinkpointsByStructureId(long id) {
		// TODO try to remove all linkpoints from that sturcture from db
	}

}
