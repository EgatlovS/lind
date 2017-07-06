package de.egatlovs.lind.components.linkpoint.boundary;

import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.inject.Inject;

import de.egatlovs.lind.components.linkpoint.control.FieldMatcher;
import de.egatlovs.lind.components.linkpoint.control.manager.FieldManager;
import de.egatlovs.lind.components.linkpoint.control.manager.LinkpointManager;
import de.egatlovs.lind.components.linkpoint.entity.dto.FieldDTO;
import de.egatlovs.lind.components.linkpoint.entity.dto.LinkpointDTO;
import de.egatlovs.lind.components.structure.control.manager.StructureManager;
import de.egatlovs.lind.components.structure.entity.dto.StructureDTO;

@Stateless
@TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
public class LinkpointBoundary {

	@Inject
	private StructureManager structureManager;

	@Inject
	private LinkpointManager linkpointManager;

	@Inject
	private FieldManager fieldManager;

	@Inject
	private FieldMatcher fieldMatcher;

	public LinkpointDTO getLinkpointById(long id) {
		return linkpointManager.dto(id);
	}

	public void createLinkpoint(LinkpointDTO linkpointDTO) throws Exception {
		StructureDTO structureDto = structureManager.dto(linkpointDTO.getStructureId());
		fieldMatcher.tryToMatch(structureDto, linkpointDTO);
		linkpointManager.save(linkpointDTO, structureDto);
	}

	public void updateLinkpointById(LinkpointDTO linkpointDTO) throws Exception {
		StructureDTO structureDto = structureManager.dto(linkpointDTO.getStructureId());
		fieldMatcher.tryToMatch(structureDto, linkpointDTO);
		linkpointManager.update(linkpointDTO, structureDto);
	}

	public void removeLinkpointById(long id) {
		linkpointManager.remove(id);
	}

	public FieldDTO getLinkpointField(long id, String fieldname) throws Exception {
		return fieldManager.dto(id, fieldname);
	}

}
