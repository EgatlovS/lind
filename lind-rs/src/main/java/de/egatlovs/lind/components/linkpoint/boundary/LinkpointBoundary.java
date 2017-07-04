package de.egatlovs.lind.components.linkpoint.boundary;

import java.util.List;

import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.inject.Inject;

import de.egatlovs.lind.components.linkpoint.control.FieldLinker;
import de.egatlovs.lind.components.linkpoint.control.FieldValidation;
import de.egatlovs.lind.components.linkpoint.control.LTransformer;
import de.egatlovs.lind.components.linkpoint.control.LinkpointLinker;
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

	@Inject
	private LinkpointLinker linkpointLinker;

	@Inject
	private FieldLinker fieldLinker;

	public LinkpointDTO getLinkpointById(long id) {
		Linkpoint linkpoint = linkpointManager.getLinkpoint(id);
		LinkpointDTO dto = optimus.linkpointDTO(linkpoint);
		return linkpointLinker.link(linkpoint, dto);
	}

	public void createLinkpoint(LinkpointDTO linkpointDTO) throws Exception {
		Structure structure = structureManager.getStructure(linkpointDTO.getStructureId());
		if (linkpointValidation.isValid(structure, linkpointDTO)) {
			Linkpoint linkpoint = optimus.linkpoint(linkpointDTO);
			linkpoint.setParent(structure);
			linkpointManager.persist(linkpoint);
		} else {
			throw new Exception("Creation failed. Caused by bad validation.");
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
		Linkpoint linkpoint = linkpointManager.getLinkpoint(id);
		List<Field> fields = linkpoint.getFields();
		for (Field field : fields) {
			if (field.getName().equals(fieldname)) {
				FieldDTO dto = optimus.fieldDTO(field);
				return fieldLinker.link(linkpoint, dto);
			}
		}
		return null; // TODO throw exception instead!
	}

}
