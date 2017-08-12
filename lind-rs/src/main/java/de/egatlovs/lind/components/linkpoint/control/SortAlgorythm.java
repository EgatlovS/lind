package de.egatlovs.lind.components.linkpoint.control;

import java.util.Collections;
import java.util.List;

import de.egatlovs.lind.components.linkpoint.entity.Linkpoint;

public class SortAlgorythm {

	public void sort(List<Linkpoint> linkpoints, String fieldname) {
		if(fieldname != null)
		Collections.sort(linkpoints, new OrderComparator(fieldname));
	}

}
