package com;

import org.apache.commons.lang3.StringUtils;
import org.json.JSONException;
import org.json.JSONObject;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.UUID;

import com.fields.CommandFieldName;
import com.interfaces.ConvertToJSONInterface;
import com.interfaces.LoadFromJSONInterface;;

public class Command implements ConvertToJSONInterface, LoadFromJSONInterface<Command> {
	private UUID id;
	public UUID getId() {
		return this.id;
	}
	public Command setId(UUID id) {
		this.id = id;
		return this;
	}

	private String name;
	public String getLookupCode() {
		return this.name;
	}
	public Command setLookupCode(String name) {
		this.name = name;
		return this;
	}

	private Date createdOn;
	public Date getCreatedOn() {
		return this.createdOn;
	}
	public Command setCreatedOn(Date createdOn) {
		this.createdOn = createdOn;
		return this;
	}

	@Override
	public Command loadFromJson(JSONObject rawJsonObject) {
		String value = rawJsonObject.optString(CommandFieldName.ID.getFieldName());
		if (!StringUtils.isBlank(value)) {
			this.id = UUID.fromString(value);
		}

		this.name = rawJsonObject.optString(CommandFieldName.COMMAND_NAME.getFieldName());

		value = rawJsonObject.optString(CommandFieldName.CREATED_ON.getFieldName());
		if (!StringUtils.isBlank(value)) {
			try {
				this.createdOn = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS", Locale.US).parse(value);
			} catch (ParseException e) {
				e.printStackTrace();
			}
		}

		return this;
	}

	@Override
	public JSONObject convertToJson() {
		JSONObject jsonObject = new JSONObject();

		try {
			jsonObject.put(CommandFieldName.ID.getFieldName(), this.id.toString());
			jsonObject.put(CommandFieldName.COMMAND_NAME.getFieldName(), this.name);
			jsonObject.put(CommandFieldName.CREATED_ON.getFieldName(), (new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS", Locale.US)).format(this.createdOn));
		} catch (JSONException e) {
			e.printStackTrace();
		}

		return jsonObject;
	}

	public Command() {
		this.name = "";
		this.id = new UUID(0, 0);
		this.createdOn = new Date();
	}
}
