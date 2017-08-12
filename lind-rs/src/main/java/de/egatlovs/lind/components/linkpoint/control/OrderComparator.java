package de.egatlovs.lind.components.linkpoint.control;

import java.util.Comparator;

import de.egatlovs.lind.components.linkpoint.entity.Field;
import de.egatlovs.lind.components.linkpoint.entity.Linkpoint;

public class OrderComparator implements Comparator<Linkpoint> {

	String fieldname;

	public OrderComparator(String fieldname) {
		super();
		this.fieldname = fieldname;
	}

	@Override
	public int compare(Linkpoint l1, Linkpoint l2) {
		int l1OrderValue = orderValueOf(l1);
		int l2OrderValue = orderValueOf(l2);

		if (l1OrderValue < l2OrderValue) {
			return -1;
		} else if (l1OrderValue == l2OrderValue) {
			return 0;
		} else {
			return 1;
		}
	}

	private int orderValueOf(Linkpoint l1) {
		for (Field field : l1.getFields()) {
			if (field.getName().equals(fieldname)) {
				return Integer.valueOf(field.getValue());
			}
		}
		return 0;
	}

}
