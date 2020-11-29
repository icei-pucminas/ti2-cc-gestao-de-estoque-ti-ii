package service;

import java.net.URISyntaxException;

/**
 * Interface service
 * 
 * @author danniel
 *
 * �ltima altera��o 07/11/2020
 */
import spark.Request;
import spark.Response;

public interface Service {
	public Object add(Request r, Response p) throws URISyntaxException;
	public Object get(Request r, Response p) throws URISyntaxException;
	public Object remove(Request r, Response p) throws URISyntaxException;
	public Object update(Request r, Response p) throws Exception, Throwable;
	public Object getAll(Request r, Response p) throws URISyntaxException;
}
