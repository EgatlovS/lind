package de.egatlovs.lind.components.structure.boundary;

import java.util.List;

import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.inject.Inject;

import de.egatlovs.lind.components.linkpoint.entity.dto.MinimalLinkpointDTO;
import de.egatlovs.lind.components.structure.control.manager.StructureManager;
import de.egatlovs.lind.components.structure.entity.dto.MinimalStructureDTO;
import de.egatlovs.lind.components.structure.entity.dto.StructureDTO;

@Stateless
@TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
public class StructureBoundary {

	@Inject
	private StructureManager structureManager;

	public List<MinimalStructureDTO> getStructures() {
		return structureManager.minimals();
	}

	public StructureDTO getStructureById(long id) {
		return structureManager.dto(id);
	}

	public void createStructure(StructureDTO structureDTO) {
		structureManager.save(structureDTO);
	}

	public void removeStructureById(long id) {
		structureManager.remove(id);
	}

	public List<MinimalLinkpointDTO> getLinkpointsByStructureId(long id) {
		return structureManager.matchingLinkpoints(id);
	}

}
