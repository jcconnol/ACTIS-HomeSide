package com.fields;

import com.interfaces.FieldNameInterface;

public enum CommandFieldName implements FieldNameInterface {
	ID("id"),
	COMMAND_NAME("commandName"),
	API_REQUEST_STATUS("apiRequestStatus"),
	API_REQUEST_MESSAGE("apiRequestMessage"),
	CREATED_ON("createdOn");

	private String fieldName;
	public String getFieldName() {
		return this.fieldName;
	}

	CommandFieldName(String fieldName) {
		this.fieldName = fieldName;
	}
}
