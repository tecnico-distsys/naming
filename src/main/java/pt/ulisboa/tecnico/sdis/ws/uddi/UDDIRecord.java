package pt.ulisboa.tecnico.sdis.ws.uddi;

public class UDDIRecord {

	private String organization;
	private String url;
	
	public UDDIRecord(String organization, String url) {
		super();
		// TODO validation
		this.organization = organization;
		this.url = url;
	}

	public String getOrganization() {
		return organization;
	}

	public String getUrl() {
		return url;
	}

}
