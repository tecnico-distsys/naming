package pt.ulisboa.tecnico.sdis.ws.uddi;

import javax.xml.registry.JAXRException;

/**
 * Class that represents a UDDI naming exception. This class extends
 * JAXRException and is intended to provide more meaningful exception messages.
 * 
 * @author Miguel Pardal
 */
public class UDDINamingException extends JAXRException {

	private static final long serialVersionUID = 1L;

	public UDDINamingException() {
	}

	public UDDINamingException(String message) {
		super(message);
	}

	public UDDINamingException(Throwable cause) {
		super(cause);
	}

	public UDDINamingException(String message, Throwable cause) {
		super(message, cause);
	}

}
