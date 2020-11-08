package service;

/**
 * Interface service
 * 
 * @author danniel
 *
 * Última alteração 07/11/2020
 */
import spark.Request;
import spark.Response;

public interface Service {
	public Object add(Request r, Response p);
	public Object get(Request r, Response p);
	public Object remove(Request r, Response p);
	public Object update(Request r, Response p) throws Exception, Throwable;
	public Object getAll(Request r, Response p);
}
