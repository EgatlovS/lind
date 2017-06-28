package de.egatlovs.lind.components.structure.boundary;

import java.util.List;

import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.inject.Inject;

import de.egatlovs.lind.components.linkpoint.control.LTransformer;
import de.egatlovs.lind.components.linkpoint.entity.Linkpoint;
import de.egatlovs.lind.components.linkpoint.entity.dto.MinimalLinkpointDTO;
import de.egatlovs.lind.components.structure.control.STransformer;
import de.egatlovs.lind.components.structure.entity.Structure;
import de.egatlovs.lind.components.structure.entity.StructureDao;
import de.egatlovs.lind.components.structure.entity.dto.MinimalStructureDTO;
import de.egatlovs.lind.components.structure.entity.dto.StructureDTO;
import de.egatlovs.lind.shared.LinkBuilder;

@Stateless
@TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
public class StructureBoundary {

	@Inject
	private StructureDao structureManager;

	@Inject
	private STransformer bumblebee;

	@Inject
	private LTransformer optimus;

	@Inject
	private LinkBuilder builder;

	public List<MinimalStructureDTO> getStructures() {
		List<Structure> structures = structureManager.getStructures();
		List<MinimalStructureDTO> dtos = bumblebee.minimalStructureDTOs(structures);
		for (int i = 0; i < structures.size(); i++) {
			builder.build(dtos.get(i), structures.get(i));
		}
		return dtos;
	}

	public StructureDTO getStructureById(long id) {
		Structure structure = structureManager.getStructure(id);
		StructureDTO dto = bumblebee.structureDTO(structure);
		return builder.build(dto, structure);
	}

	public void createStructure(StructureDTO structureDTO) {
		Structure structure = bumblebee.structure(structureDTO);
		structureManager.persist(structure);
	}

	public void removeStructureById(long id) {
		structureManager.removeStructure(id);
	}

	public List<MinimalLinkpointDTO> getLinkpointsByStructureId(long id) {
		List<Linkpoint> linkpoints = structureManager.getMatchingLinkpoints(id);
		List<MinimalLinkpointDTO> dtos = optimus.minimalLinkpointDTOs(linkpoints);
		for (int i = 0; i < linkpoints.size(); i++) {
			builder.build(dtos.get(i), linkpoints.get(i));
		}
		return dtos;
	}

}