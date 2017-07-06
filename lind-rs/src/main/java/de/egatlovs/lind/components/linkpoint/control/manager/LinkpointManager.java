package de.egatlovs.lind.components.linkpoint.control.manager;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;

import de.egatlovs.lind.components.linkpoint.control.hateoas.FieldLinks;
import de.egatlovs.lind.components.linkpoint.control.hateoas.LinkpointLinks;
import de.egatlovs.lind.components.linkpoint.entity.Linkpoint;
import de.egatlovs.lind.components.linkpoint.entity.dbaccess.LinkpointDao;
import de.egatlovs.lind.components.linkpoint.entity.dto.FieldDTO;
import de.egatlovs.lind.components.linkpoint.entity.dto.LinkpointDTO;
import de.egatlovs.lind.components.linkpoint.entity.dto.MinimalLinkpointDTO;
import de.egatlovs.lind.components.structure.entity.dto.StructureDTO;

@RequestScoped
public class LinkpointManager {

	@Inject
	private LinkpointDao dao;

	@Inject
	private LinkpointLinks linkpointLinks;

	@Inject
	private FieldLinks fieldLinks;

	public LinkpointDTO dto(long id) {
		Linkpoint linkpoint = dao.read(id);
		LinkpointDTO dto = linkpoint.asDto();
		dto.set_links(linkpointLinks.links(linkpoint));
		for (FieldDTO fieldDTO : dto.getFields()) {
			fieldDTO.set_links(fieldLinks.links(linkpoint, fieldDTO));
		}
		return dto;
	}

	public MinimalLinkpointDTO minimal(long id) {
		Linkpoint linkpoint = dao.read(id);
		MinimalLinkpointDTO dto = linkpoint.asMinimal();
		dto.set_links(linkpointLinks.links(linkpoint));
		return dto;
	}

	public void save(LinkpointDTO linkpointDTO, StructureDTO structureDto) {
		dao.save(linkpointDTO.asEntity(structureDto));
	}

	public void update(LinkpointDTO linkpointDTO, StructureDTO structureDto) {
		dao.update(linkpointDTO.asEntity(structureDto));
	}

	public void remove(long id) {
		dao.remove(id);
	}

}