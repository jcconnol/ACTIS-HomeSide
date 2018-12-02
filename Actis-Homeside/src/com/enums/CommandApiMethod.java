package com.enums;

import com.interfaces.PathElementInterface;

public enum CommandApiMethod implements PathElementInterface {
	NONE(""),
	BY_COMMAND("byCommand");

	@Override
	public String getPathValue() {
		return value;
	}

	private String value;

	CommandApiMethod(String value) {
		this.value = value;
	}
}
