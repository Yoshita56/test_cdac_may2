package mms;

/**
 * Developer : Anurudra Goel
 * Version : 1.0
 * Purpose : This Java Class is used where file is attached with our transaction 
 *  
*/


import hisglobal.utility.HisUtil;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.Unmarshaller;

import mms.setup.MmsConfigGeneral;
import mms.setup.MmsConfigType;
public class AttachFileGlobal {

	  StringBuffer fileContent = null;
	  private String FILE_PATH="";
	  OutputStream out=null;
	/***
	 * This Function is used to save the file into hardisk
	 * @param bs
	 * @param fileName
	 * @param filePath
	 */    
	  public void saveFile(byte[] bs,String fileName)
	  {
		   try
		   {
			   	   out = new FileOutputStream( new File(HisUtil.getParameterFromHisPathXML("TEMP_PATH")+"/"+fileName));
			   	   //System.out.println("HisUtil.getParameterFromHisPathXML"+HisUtil.getParameterFromHisPathXML("TEMP_PATH"));
				   out.write(bs);
				   out.close();
			   
		   }
		   catch(Exception e)
		   {
			   e.printStackTrace();
			   try{
				   throw new Exception("AttachFileGlobal.saveFile---->"+e.getMessage());
			   }catch(Exception _err){
				   
			   }
		   }
		  
	   }

	  @SuppressWarnings("unchecked")
	/***
	 * This Function is to find exact path of folder from xml 
	 * @param fileData
	 * @param fileName
	 * @param filePath
	 */     
public void getFilePathFromXML(){
	    	 
	    	String strXmlPath=""; 
	    	JAXBElement<MmsConfigType> jaxB = null;
	    	MmsConfigGeneral mmsGen=null;
	    	String osType="";
			try{
	    		 
	    		 	strXmlPath=HisUtil.getParameterFromHisPathXML("MMS_CONFIG");
	    		 	
	    		 	JAXBContext jc;
	    			jc = JAXBContext.newInstance("mms.setup");
	    			Unmarshaller u = jc.createUnmarshaller();
	    			jaxB = (JAXBElement<MmsConfigType>) u.unmarshal(new FileInputStream(
	    					strXmlPath));
	    			MmsConfigType mmsConf = (MmsConfigType) jaxB.getValue();
	    			mmsGen=mmsConf.getMmsConfigGerneral();
	    			osType = System.getProperties().getProperty("os.name");
	    			if(osType.startsWith("Win")){
	    				FILE_PATH=mmsGen.getCommitteeFilePathWin();	
	    			}else{
	    			
	    				FILE_PATH=mmsGen.getCommitteeFilePathLin();
	    			}
	    	 
	    	 }catch(Exception e){
	    		 
	    		 try{
	    			 
	    			 	throw new Exception("AttachFileGlobal.getFilePathFromXML---->"+e.getMessage());
	    		 
	    		 }catch(Exception _err){
	    			 
	    		 }
	    	 }
	     
	     }
	
}
