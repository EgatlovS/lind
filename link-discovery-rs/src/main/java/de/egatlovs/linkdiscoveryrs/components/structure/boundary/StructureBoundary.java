package de.egatlovs.linkdiscoveryrs.components.structure.boundary;

import java.util.List;

import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.inject.Inject;

import de.egatlovs.linkdiscoveryrs.components.linkpoint.control.LinkpointTransformer;
import de.egatlovs.linkdiscoveryrs.components.linkpoint.entity.LinkpointDTO;
import de.egatlovs.linkdiscoveryrs.components.structure.control.StructureTransformer;
import de.egatlovs.linkdiscoveryrs.components.structure.entity.Structure;
import de.egatlovs.linkdiscoveryrs.components.structure.entity.StructureDTO;
import de.egatlovs.linkdiscoveryrs.components.structure.entity.StructureDao;

@Stateless
@TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
public class StructureBoundary {

	@Inject
	private StructureDao structureManager;

	@Inject
	private StructureTransformer bumblebee;

	@Inject
	private LinkpointTransformer optimus;

	public List<StructureDTO> getStructures() {
		List<Structure> structures = structureManager.getStructures();
		return bumblebee.structureDTOs(structures);
	}

	public StructureDTO getStructureById(long id) {
		Structure structure = structureManager.getStructure(id);
		return bumblebee.structureDTO(structure);
	}

	public StructureDTO getStructureByName(String name) {
		Structure structure = structureManager.getStructure(name);
		return bumblebee.structureDTO(structure);
	}

	public StructureDTO createStructure(StructureDTO structureDTO) {
		Structure structure = bumblebee.structure(structureDTO);
		structureManager.persist(structure);
		return bumblebee.structureDTO(structure);
	}

	public void removeStructureById(long id) {
		structureManager.removeStructure(id);
	}

	public void removeStructureByName(String name) {
		structureManager.removeStructure(name);
	}

	public List<LinkpointDTO> getLinkpointsByStructureId(long id) {
		Structure structure = structureManager.getStructure(id);
		return optimus.linkpointDTOs(structure.getLinkpoints());
	}

	public void removeLinkpointsByStructureId(long id) {
		Structure structure = structureManager.getStructure(id);
		structure.setLinkpoints(null);
		structureManager.merge(structure);
	}

}
