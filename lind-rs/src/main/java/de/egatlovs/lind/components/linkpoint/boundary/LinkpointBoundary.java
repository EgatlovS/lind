package de.egatlovs.lind.components.linkpoint.boundary;

import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.inject.Inject;

import de.egatlovs.lind.components.linkpoint.control.LTransformer;
import de.egatlovs.lind.components.linkpoint.control.FieldValidation;
import de.egatlovs.lind.components.linkpoint.entity.Field;
import de.egatlovs.lind.components.linkpoint.entity.Linkpoint;
import de.egatlovs.lind.components.linkpoint.entity.LinkpointDao;
import de.egatlovs.lind.components.linkpoint.entity.dto.FieldDTO;
import de.egatlovs.lind.components.linkpoint.entity.dto.LinkpointDTO;
import de.egatlovs.lind.components.structure.entity.Structure;
import de.egatlovs.lind.components.structure.entity.StructureDao;

@Stateless
@TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
public class LinkpointBoundary {

	@Inject
	private LTransformer optimus;

	@Inject
	private LinkpointDao linkpointManager;

	@Inject
	private StructureDao structureManager;

	@Inject
	private FieldValidation linkpointValidation;

	public LinkpointDTO getLinkpointById(long id) {
		Linkpoint linkpoint = linkpointManager.getLinkpoint(id);
		return optimus.linkpointDTO(linkpoint);
	}

	public void createLinkpoint(LinkpointDTO linkpointDTO) {
		Structure structure = structureManager.getStructure(linkpointDTO.getStructureId());
		if (linkpointValidation.isValid(structure, linkpointDTO)) {
			Linkpoint linkpoint = optimus.linkpoint(linkpointDTO);
			linkpoint.setParent(structure);
			linkpointManager.persist(linkpoint);
		} else {
			// TODO throw exception instead!
		}
	}

	public void updateLinkpointById(long id, LinkpointDTO linkpointDTO) {
		Linkpoint linkpoint = linkpointManager.getLinkpoint(id);
		Structure structure = linkpoint.getParent();
		if (linkpointValidation.isValid(structure, linkpointDTO)) {
			linkpoint = optimus.linkpoint(linkpointDTO);
			linkpoint.setParent(structure);
			linkpoint.setId(id); // Need to set the id otherwise someone could
									// update a diffrent linkpoint which he did
									// not describe in the dto (The Validation
									// of the structure could then be incorrect
									// and the db would become inconsistent!!!)
			linkpointManager.merge(linkpoint);
		} else {
			// TODO throw exception instead!
		}
	}

	public void removeLinkpointById(long id) {
		linkpointManager.removeLinkpoint(id);
	}

	public FieldDTO getLinkpointField(long id, String fieldname) {
		Field field = linkpointManager.getField(id, fieldname);
		return optimus.fieldDTO(field);
	}

}
