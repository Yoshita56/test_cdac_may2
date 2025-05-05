package hisglobal.exceptions;

import hisglobal.utility.HisUtil;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ResourceBundle;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;


/**
 * 
 * The Class Used to Interact with ErrorId.xml file and read/write the 
 * errorCounter value.
 * 
 * @author Balasubramaniam M <br> Copyright ©C-DAC Noida
 *
 */
public class ErrorCounter {

	private static final String pathFileName = "hisglobal.hisconfig.hisPath";
	private String path = null;
	
	private String errorCount = "0";
	
	
	/**
	 * reads errorCounter Value from ErrorId.xml File in hisglobal.error package
	 * @return errorCounter.
	 */
	public String getErrorCount() throws Exception{
		
		JAXBElement<HisErrorType> jaxB = this.readXMLDataObject();
				
		HisErrorType err = (HisErrorType)jaxB.getValue();
		
				errorCount = err.getErrorId();
			
				//if(jaxB != null)jaxB = null;
				
		return errorCount;
	}

	/**
	 * writes errorCounter Value to ErrorId.xml File in hisglobal.error package 
	 * @param errorCount String value.
	 */
	public void setErrorCount(String errorCount) throws Exception{
		
		JAXBElement<HisErrorType> jaxB = null;
		
		jaxB = this.readXMLDataObject();
		
		HisErrorType err = (HisErrorType)jaxB.getValue();
		
		err.setErrorId(errorCount);
		
		this.writeXMLDataObject(jaxB);
		
		if(err != null) err = null;
		if(jaxB != null)jaxB = null;
		
	}

	private String getPath() {
		path = HisUtil.getParameterFromHisPathXML("ERROR_ID");
		return path;
	}
	
	/**
	 * common method for creating a XML Root Elements Data Object
	 * @return JAXBElement Object 
	 */
	private JAXBElement<HisErrorType> readXMLDataObject() throws Exception{

		JAXBElement<HisErrorType> jaxB = null;

		JAXBContext jc;
		try {
			jc = JAXBContext.newInstance("hisglobal.exceptions");

			Unmarshaller u = jc.createUnmarshaller();
			System.out.println("this.getPath()  "+this.getPath());
			jaxB = (JAXBElement<HisErrorType>) u.unmarshal(new FileInputStream(this.getPath()));

		} catch (JAXBException e) {
			
			e.printStackTrace();
			
			throw new Exception(e.getMessage());
			
			//new HisException("Error Counter", "ErrorCounter.readXMLDataObject()", e.getMessage());
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
			//new HisException("Error Counter", "ErrorCounter.readXMLDataObject()", e.getMessage());
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
			//new HisException("Error Counter", "ErrorCounter.readXMLDataObject()", e.getMessage());
		}

		return jaxB;

	}

	/**
	 * retrieves JAXBElement Object and Updates the XML file
	 * @param jaxB - JAXBElement Object
	 */
	private void writeXMLDataObject(JAXBElement<HisErrorType> jaxB) throws Exception{

		JAXBContext jc;
		try {
			jc = JAXBContext.newInstance("hisglobal.exceptions");

			Marshaller m = jc.createMarshaller();

			m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);

			m.marshal(jaxB, new FileWriter(new File(this.getPath())));

		}  catch (JAXBException e) {
			throw new Exception(e.getMessage());
			
			//new HisException("Error Counter", "ErrorCounter.readXMLDataObject()", e.getMessage());
		} catch (IOException e) {
			throw new Exception(e.getMessage());
			//new HisException("Error Counter", "ErrorCounter.readXMLDataObject()", e.getMessage());
		}

	}
	
}
