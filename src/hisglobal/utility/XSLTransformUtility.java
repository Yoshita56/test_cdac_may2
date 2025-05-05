package hisglobal.utility;

import java.io.File;
import java.io.IOException;
import java.io.StringReader;
import java.io.StringWriter;
import java.net.MalformedURLException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;

import org.apache.xerces.parsers.DOMParser;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.w3c.dom.Element;
import org.w3c.dom.CharacterData;
import com.mims.cds.FastTrackDSM;

public class XSLTransformUtility 
{
	public static String osType = System.getProperties().getProperty("os.name");
	
	//public static String XSL_FILE_PATH="C:\\NIMS\\AHIMSG5\\CIMSDatabase\\xslt\\Monograph-Interaction-CDSDefault.xsl";
	//public static String CIMSDatabaseFilePath="C:\\NIMS\\AHIMSG5\\CIMSDatabase\\FastTrackData.mr2";
	
	
	public static String getXSLFilePath(String xslType) 
	{
		String XSL_FILE_PATH="";
		String xSlFileName="";
		if(xslType.equals("1"))//Monograph
			xSlFileName="Monograph-Interaction-CDSDefault.xsl";
		if(xslType.equals("2"))//Contraindications
			xSlFileName="Contraindications.xsl";
		if(xslType.equals("3"))//FoodInteraction
			xSlFileName="Food Interaction.xsl";
		if(xslType.equals("4"))//Drug To Drug Reaction
			xSlFileName="Monograph-Interaction-CDSDefault.xsl";
		                                                         
		try		
		{
			if (osType.startsWith("Win"))
			{
				XSL_FILE_PATH="C:\\NIMS\\AHIMSG5\\CIMSDatabase\\xslt\\"+xSlFileName;
			} 
			else 
			{
				XSL_FILE_PATH="/opt/NIMS/AHIMSG5/CIMSDatabase/xslt/"+xSlFileName;
			}
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}	
		return XSL_FILE_PATH;
	}
	public static String getCIMSDBFilePath() 
	{
		String CIMSDatabaseFilePath="";
		try		
		{
			if (osType.startsWith("Win"))
			{
				CIMSDatabaseFilePath="C:\\NIMS\\AHIMSG5\\CIMSDatabase\\FastTrackData.mr2";
			} 
			else 
			{
				CIMSDatabaseFilePath="/opt/NIMS/AHIMSG5/CIMSDatabase/FastTrackData.mr2";
			}
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}
		return CIMSDatabaseFilePath;
	}
	/*public static void main(String[] args)
	{
		FastTrackDSM ft=new FastTrackDSM();
		String CIMSDatabaseFilePath=getCIMSDBFilePath();
		if (!ft.open(CIMSDatabaseFilePath, "GDDBDEMO"))
			System.err.println("Unable to open data file");
		else {
			String reqXML=createReqXML("{DAABD513-72A6-41F2-ABEC-DDAEABBC18D9}","1","2");
			String drugMonographXML=ft.requestXml(reqXML);
			System.out.println(drugMonographXML);
//			String drugMonographXMLFilePath="D:\\CIMS\\MyExamples\\Monograph\\monograph.xml";
//			XSLTransformUtility.stringToXMLFile(drugMonographXML,drugMonographXMLFilePath);
//			
//			// transform xml to html
//			String drugMonographHTMLFilePath="D:\\CIMS\\MyExamples\\Monograph\\monograph.html";
//			XSLTransformUtility.transformXMLFiletoHTMLFile(drugMonographXMLFilePath, drugMonographHTMLFilePath);
			
			System.out.println(transformXMLtoHTML(drugMonographXML,"1"));
		
		}
	}*/
	
	public static String createReqXML(String strCIMSId,String dataMode,String drugTypeMode) 
	{
		String REQ_XML="";
		try		
		{
			
			//dataMode==1-By Reference,2-ByName 
			//drugTypeMode,1-GenericItem,2-Product,3-GGPI,4-Reaction,5-ByMolecules combination
			if(dataMode.equals("1"))
			{
				if(drugTypeMode.equals("1"))//GenericItem
					REQ_XML="<Request><Content><GenericItem reference='"+strCIMSId+"' /></Content></Request>";
				if(drugTypeMode.equals("2"))//Product
					REQ_XML="<Request><Content><Product reference='"+strCIMSId+"' /></Content></Request>";
				if(drugTypeMode.equals("3"))//GGPI
					REQ_XML="<Request><Content><GGPI reference='"+strCIMSId+"' /></Content></Request>";
				if(drugTypeMode.equals("4"))//Reaction
					REQ_XML="<Request><Content><GGPI reference='"+strCIMSId+"' /></Content></Request>";
				if(drugTypeMode.equals("5"))//ByMolecules combination Search Brand
					REQ_XML="<Request><List><Product><ByMolecules combination=\"OR\"><ByMolecule reference='"+strCIMSId+"'/></ByMolecules></Product></List></Request>";
				System.out.println("***"+REQ_XML);
			}
			else
			{
				//String REQ_XML="<Request><List><Product><ByName>"+strCIMSId+"</ByName></Product></Request>"; DAABD513-72A6-41F2-ABEC-DDAEABBC18D9
			     //Search Brand 68EC41A6-71EE-427C-B261-03425BAA3DD3              DAABD513-72A6-41F2-ABEC-DDAEABBC18D9    DAABD513-72A6-41F2-ABEC-DDAEABBC18D9
			}
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}	
		return REQ_XML;
	}
	
	
	
	/**
	 * Method to convert XML string to HTML String
	 * @param dataXML
	 * @return
	 */
	public static String transformXMLtoHTML(String dataXML,String xslType)
	{
		String htmlString="";
		try 
		{
			String XSL_FILE_PATH=getXSLFilePath(xslType);
			String xsltSystemId = new File(XSL_FILE_PATH).toURL().toExternalForm();
			TransformerFactory factory = TransformerFactory.newInstance();
			StreamSource xslStream = new StreamSource(xsltSystemId);
			Transformer transformer = factory.newTransformer(xslStream);
			StreamSource in = new StreamSource(new StringReader(dataXML));
			StringWriter writer = new StringWriter();
			StreamResult out = new StreamResult(writer);
			transformer.transform(in, out);
			htmlString=writer.toString();
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (TransformerConfigurationException e) {
			e.printStackTrace();
		} catch (TransformerException e) {
			e.printStackTrace();
		} catch (Exception e){
			e.printStackTrace();
		}
		return htmlString;
	}


	/**
	 * Method to convert XML String to File
	 * @param xmlSource
	 * @param xmlFilePath
	 */
	public static void stringToXMLFile(String xmlSource, String xmlFilePath) {
		try{
			// Parse the given input
			DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
			DocumentBuilder builder = factory.newDocumentBuilder();
			Document doc = builder.parse(new InputSource(new StringReader(xmlSource)));

			// Write the parsed document to an xml file
			TransformerFactory transformerFactory = TransformerFactory.newInstance();
			Transformer transformer = transformerFactory.newTransformer();
			DOMSource source = new DOMSource(doc);

			StreamResult result =  new StreamResult(new File(xmlFilePath));
			transformer.transform(source, result);
		}catch(SAXException e){
			e.printStackTrace();
		}catch(ParserConfigurationException e){
			e.printStackTrace();
		}catch(IOException e){
			e.printStackTrace();
		}catch (Exception e){
			e.printStackTrace();
		}
	}
	
	/**
	 * Method to transform XML file to HTML file
	 * @param dataXML
	 * @param HTMLOutputFileName
	 */
	public static void transformXMLFiletoHTMLFile(String dataXML, String HTMLOutputFileName,String xslType){

		try {
			String XSL_FILE_PATH=getXSLFilePath(xslType);
			String xsltSystemId = new File(XSL_FILE_PATH).toURL().toExternalForm();
			TransformerFactory factory = TransformerFactory.newInstance();
			StreamSource xslStream = new StreamSource(xsltSystemId);
			Transformer transformer = factory.newTransformer(xslStream);
			StreamSource in = new StreamSource(new File(dataXML));
			StreamResult out = new StreamResult(new File(HTMLOutputFileName));
			transformer.transform(in, out);
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (TransformerConfigurationException e) {
			e.printStackTrace();
		} catch (TransformerException e) {
			e.printStackTrace();
		} catch (Exception e){
			e.printStackTrace();
		}
	}

	/*public static void iterateXMLString()
	{
		String xml = "<Result buildId='1914' copyright='Copyright (c) 2012 UBM Medica' expiryDate='2023-12-31'><List total='14' from='0' to='14'><Product reference='{63B9060F-BFFF-46F0-92FD-ECB299CF917F}' name='ALPYRIN TAB 150mg' /><Product reference='{665EA00F-9F3E-4B4D-9B01-2583617F8527}' name='ARRENO CAP' /><Product reference='{3471A216-4FFF-458F-A964-1ED1495D09DC}' name='ASA TAB 75mg' /><Product reference='{9C228D9E-5D69-4407-A55E-7F14A49496DC}' name='ASCAD TAB 150mg' /><Product reference='{0A3EA830-18F2-4339-8A3B-4E8327BB308F}' name='ASICOM PLUS TAB' /><Product reference='{DA0AD662-A15C-45D5-BD5B-C9B45AF70A2F}' name='ASPENT TAB 60mg' /><Product reference='{BA011F24-DCF1-471A-8FD1-7652CFC4B15C}' name='CARDIWELL PLUS TAB' /><Product reference='{5DA47D23-693F-4D7A-84B9-217BAD1709A4}' name='CLODREL PLUS TAB' /><Product reference='{6896D03C-FCE1-43D6-A823-6C19D923BEEF}' name='COLSPRIN 650 TAB' /><Product reference='{27E75B0F-1DC1-4479-82D3-BF3A3F6C751F}' name='E-PRIN TAB 150mg' /><Product reference='{DE584474-F0A9-42FA-AADB-7B8720D19CEA}' name='NUGREL PLUS TAB' /><Product reference='{67984399-739B-4F75-BA70-958E716A04BD}' name='NUSPRIN TAB 100mg' /><Product reference='{4AE068E3-F727-4EEE-9F8A-AA360427931A}' name='PRIN TAB 81mg' /><Product reference='{22F56A9A-06D8-44AA-BA17-3EDDA9D7A074}' name='TINYSPIRIN TAB 80mg' /></List></Result>";
		DOMParser parser = new DOMParser();
		try {
		    parser.parse(new InputSource(new java.io.StringReader(xml)));
		    Document doc = parser.getDocument();
		    String message = doc.getDocumentElement().getTextContent();
		    System.out.println(message);
		} catch (SAXException e) {
		    // handle SAXException 
		} catch (IOException e) {
		    // handle IOException 
		}
	}
	
	public static void main(String[] args)
	{
		
		iterateXMLString();
	}*/
	
	 public static void main(String arg[]) throws Exception{
		    String xmlRecords = "<Result buildId='1914' copyright='Copyright (c) 2012 UBM Medica' expiryDate='2023-12-31'><List total='14' from='0' to='14'><Product reference='{63B9060F-BFFF-46F0-92FD-ECB299CF917F}' name='ALPYRIN TAB 150mg' /><Product reference='{665EA00F-9F3E-4B4D-9B01-2583617F8527}' name='ARRENO CAP' /><Product reference='{3471A216-4FFF-458F-A964-1ED1495D09DC}' name='ASA TAB 75mg' /><Product reference='{9C228D9E-5D69-4407-A55E-7F14A49496DC}' name='ASCAD TAB 150mg' /><Product reference='{0A3EA830-18F2-4339-8A3B-4E8327BB308F}' name='ASICOM PLUS TAB' /><Product reference='{DA0AD662-A15C-45D5-BD5B-C9B45AF70A2F}' name='ASPENT TAB 60mg' /><Product reference='{BA011F24-DCF1-471A-8FD1-7652CFC4B15C}' name='CARDIWELL PLUS TAB' /><Product reference='{5DA47D23-693F-4D7A-84B9-217BAD1709A4}' name='CLODREL PLUS TAB' /><Product reference='{6896D03C-FCE1-43D6-A823-6C19D923BEEF}' name='COLSPRIN 650 TAB' /><Product reference='{27E75B0F-1DC1-4479-82D3-BF3A3F6C751F}' name='E-PRIN TAB 150mg' /><Product reference='{DE584474-F0A9-42FA-AADB-7B8720D19CEA}' name='NUGREL PLUS TAB' /><Product reference='{67984399-739B-4F75-BA70-958E716A04BD}' name='NUSPRIN TAB 100mg' /><Product reference='{4AE068E3-F727-4EEE-9F8A-AA360427931A}' name='PRIN TAB 81mg' /><Product reference='{22F56A9A-06D8-44AA-BA17-3EDDA9D7A074}' name='TINYSPIRIN TAB 80mg' /></List></Result>";

		    DocumentBuilder db = DocumentBuilderFactory.newInstance().newDocumentBuilder();
		    InputSource is = new InputSource();
		    is.setCharacterStream(new StringReader(xmlRecords));

		    Document doc = db.parse(is);
		    NodeList nodes = doc.getElementsByTagName("Product");

		    for (int i = 0; i < nodes.getLength(); i++) {
		      Element element = (Element) nodes.item(i);

		      NodeList name = element.getElementsByTagName("name");
		      Element line = (Element) name.item(0);
		      System.out.println("Name: " + getCharacterDataFromElement(line));

		      NodeList title = element.getElementsByTagName("reference");
		      line = (Element) title.item(0);
		      System.out.println("Title: " + getCharacterDataFromElement(line));
		    }

		  }

		  public static String getCharacterDataFromElement(Element e) {
		    Node child = e.getFirstChild();
		    if (child instanceof CharacterData) {
		      CharacterData cd = (CharacterData) child;
		      return cd.getData();
		    }
		    return "";
		  }
}

