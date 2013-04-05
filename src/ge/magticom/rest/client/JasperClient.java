package ge.magticom.rest.client;


import ge.magticom.rest.jasper.JasperserverRestClient;
import ge.magticom.rest.jasper.Report;

import java.io.File;

 

public class JasperClient {

	
	
	private final static String serverUrl = "http://192.168.9.37:8080/jasperserver-pro";
	private final static String serverUser = "jasperadmin|magticom";
	private final static String serverPassword = "jasperadmin";
	
	private static File outPutDir;
	
	public static void main(String[] argv){
		outPutDir=  new File("/opt/pdfs");
		try { 
		Report report = new Report();
		report.setUrl("/Reports/Test_Bank");
		report.setOutputFolder(outPutDir.getAbsolutePath());
		report.addParameter("department", "11");
		JasperserverRestClient client = JasperserverRestClient.getInstance(serverUrl, serverUser, serverPassword);
		File  reportFile = client.getReportAsFile(report);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 
	}
	
	
}
