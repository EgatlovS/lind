package de.egatlovs.lind.components.linkpoint.control.manager;

import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;

import de.egatlovs.lind.components.linkpoint.control.hateoas.FieldLinks;
import de.egatlovs.lind.components.linkpoint.entity.Field;
import de.egatlovs.lind.components.linkpoint.entity.Linkpoint;
import de.egatlovs.lind.components.linkpoint.entity.dbaccess.LinkpointDao;
import de.egatlovs.lind.components.linkpoint.entity.dto.FieldDTO;

@RequestScoped
public class FieldManager {

	@Inject
	private LinkpointDao dao;

	@Inject
	private FieldLinks fieldLinks;

	public FieldDTO dto(long id, String fieldname) throws Exception {
		Linkpoint linkpoint = dao.read(id);
		List<Field> fields = linkpoint.getFields();
		for (Field field : fields) {
			if (field.getName().equals(fieldname)) {
				FieldDTO dto = field.asDto();
				dto.set_links(fieldLinks.links(linkpoint, dto));
				return dto;
			}
		}
		throw new Exception(); // TODO throw better exception
	}

}
