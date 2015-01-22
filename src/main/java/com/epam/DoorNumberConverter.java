package com.epam;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

@Converter
public class DoorNumberConverter implements AttributeConverter<DoorNumber, Integer> {

	public Integer convertToDatabaseColumn(DoorNumber attribute) {
		if (attribute == null) {
			return null;
		}
		switch (attribute) {
			case TWO:
				return 2;
			case THREE:
				return 3;
			case FOUR:
				return 4;
			case FIVE:
				return 5;
			default:
				throw new RuntimeException("Unexpected number of doors " + attribute);
		}
	}
	
	public DoorNumber convertToEntityAttribute(Integer dbData) {
		if (dbData == null) {
			return null;
		}
		switch (dbData) {
			case 2:
				return DoorNumber.TWO;
			case 3:
				return DoorNumber.THREE;
			case 4:
				return DoorNumber.FOUR;
			case 5:
				return DoorNumber.FIVE;
			default:
				throw new RuntimeException("Unexpected number of doors " + dbData);
		}
	}
}
