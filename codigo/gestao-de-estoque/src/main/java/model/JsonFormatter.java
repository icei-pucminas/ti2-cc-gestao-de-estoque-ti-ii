package model;

import org.json.JSONArray;
import org.json.JSONObject;

/**
 * Interface que delcara protocolo para conversão de um object Java em JSOn
 * 
 * @author diogo
 *
 */
public interface JsonFormatter {
	public JSONObject toJson();
	
	public default JSONArray toJsonArray() {
		return new JSONArray().put(toJson());
	}
	
}
