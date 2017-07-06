package de.egatlovs.lind.components.structure.control.manager;

import java.util.ArrayList;
import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;

import de.egatlovs.lind.components.linkpoint.control.hateoas.LinkpointLinks;
import de.egatlovs.lind.components.linkpoint.entity.Linkpoint;
import de.egatlovs.lind.components.linkpoint.entity.dto.MinimalLinkpointDTO;
import de.egatlovs.lind.components.structure.control.hateoas.StructureLinks;
import de.egatlovs.lind.components.structure.entity.Structure;
import de.egatlovs.lind.components.structure.entity.dbaccess.StructureDao;
import de.egatlovs.lind.components.structure.entity.dto.MinimalStructureDTO;
import de.egatlovs.lind.components.structure.entity.dto.StructureDTO;

@RequestScoped
public class StructureManager {

	@Inject
	private StructureDao dao;

	@Inject
	private StructureLinks structureLinks;

	@Inject
	private LinkpointLinks linkpointLinks;

	public StructureDTO dto(long id) {
		Structure structure = dao.read(id);
		StructureDTO dto = structure.asDto();
		dto.set_links(structureLinks.links(structure));
		return dto;
	}

	public MinimalStructureDTO minimal(long id) {
		Structure structure = dao.read(id);
		MinimalStructureDTO dto = structure.asMinimal();
		dto.set_links(structureLinks.links(structure));
		return dto;
	}

	public List<MinimalStructureDTO> minimals() {
		List<MinimalStructureDTO> minimals = new ArrayList<>();
		List<Structure> structures = dao.readAll();
		for (Structure structure : structures) {
			MinimalStructureDTO dto = structure.asMinimal();
			dto.set_links(structureLinks.links(structure));
			minimals.add(dto);
		}
		return minimals;
	}

	public void save(StructureDTO structureDTO) {
		dao.save(structureDTO.asEntity());
	}

	public void remove(long id) {
		dao.remove(id);
	}

	public List<MinimalLinkpointDTO> matchingLinkpoints(long id) {
		List<MinimalLinkpointDTO> minimals = new ArrayList<>();
		List<Linkpoint> linkpoints = dao.matchingLinkpoints(id);
		for (Linkpoint linkpoint : linkpoints) {
			MinimalLinkpointDTO dto = linkpoint.asMinimal();
			dto.set_links(linkpointLinks.links(linkpoint));
			minimals.add(dto);
		}
		return minimals;
	}

}
