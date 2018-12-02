package com.interfaces;

import org.json.JSONObject;

public interface LoadFromJSONInterface<T> {
	T loadFromJson(JSONObject rawJsonObject);
}
