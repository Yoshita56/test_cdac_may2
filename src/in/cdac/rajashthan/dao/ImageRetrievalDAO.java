package in.cdac.rajashthan.dao;

import global.transactionmgnt.HisDAO;
import global.utility.HisUtil;
import in.cdac.rajashthan.bo.ImageRetrievalDataSet;
import in.cdac.rajashthan.bo.ImageRetrievalData;
import global.utility.FTPFileTransfer;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Calendar;
import java.io.InputStream;


import javax.sql.rowset.WebRowSet;

import org.apache.axis.encoding.Base64;
import org.apache.commons.io.IOUtils;



public class ImageRetrievalDAO{
	
     
	  public static ImageRetrievalDataSet getImageData(String eid,String sln,String hospCode) {
    	
    	String err = "";
    	String proc_name1 = "{call PKG_WEBSERVICES.getImageofstaff(?,?,?,?,?,?)}";
        int procIndex1 = 0;
        HisDAO dao = null;
        WebRowSet ws = null;
        String path = "/emp_img";
   	    String imageDataString =null;
         
        try {
          //  if (!"4".equals(strServiceID)) {
             //   PatientDataSet patientDataSet = new PatientDataSet("Not a Valid ServiceId", DailyPatientListDAO.getCurrentTime());
             //   return patientDataSet;
          //  }       	            
            dao = new HisDAO("WebServices", "DailyPatientListDAO.ImageRetrievalDataSet()");
            procIndex1 = dao.setProcedure(proc_name1);
            dao.setProcInValue(procIndex1, "modeval", "1");
            dao.setProcInValue(procIndex1, "eid", eid);
            dao.setProcInValue(procIndex1, "slno", sln);
            dao.setProcInValue(procIndex1, "hosp_code", hospCode); 
            dao.setProcOutValue(procIndex1, "err", 1);
            dao.setProcOutValue(procIndex1, "resultset", 2);
            //System.out.println("calling proced..");
            dao.executeProcedure(procIndex1);
            err = dao.getString(procIndex1, "err");
            if (err == null || err.equals("")) {
                err = "";
            }else{
            	
            	throw new Exception(err);
            }
            
            ws = dao.getWebRowSet(procIndex1, "resultset");           
          //  System.out.println("ws"+ws.size());
            
            if (ws != null && ws.size() > 0) {
                ArrayList<ImageRetrievalData> imageRetrievalData = new ArrayList<ImageRetrievalData>();
                ws.beforeFirst();
                while (ws.next()) {
                    //Call FTP if 1 flag
                	if(ws.getString(3).equalsIgnoreCase("1")) {             		
        				try {
        				    InputStream fis =FTPFileTransfer.retrieveFile(path,ws.getString(2));
        				    byte[] bytes = IOUtils.toByteArray(fis); 
        				    imageDataString = new String(Base64.encode(bytes));
        				//	System.out.println("imageDataString : " + imageDataString);    
        					} catch (Exception e) {
        					  e.printStackTrace();
        				    }
                     }
                	else
                	{                		
                		imageDataString =ws.getString(1);
                	//	System.out.println("imageDataString : " + imageDataString);   
                	}
                   	imageRetrievalData.add(new ImageRetrievalData(eid,sln,imageDataString));                                             	
                 }            
                ImageRetrievalDataSet imageRetrievalDataSet = new ImageRetrievalDataSet(imageRetrievalData, "", ImageRetrievalDAO.getCurrentTime());
                return imageRetrievalDataSet;
            }
              ImageRetrievalDataSet imageRetrievalDataSet = new ImageRetrievalDataSet("No Image Found", ImageRetrievalDAO.getCurrentTime());
            
            if(ws != null){
        		ws.close();
        		ws = null;
        	}          
            return imageRetrievalDataSet;
        }
        catch (Exception e) {
            e.printStackTrace();
            ImageRetrievalDataSet imageRetrievalDataSet = new ImageRetrievalDataSet("INTERNAL ERROR",new SimpleDateFormat("yyyy/MM/dd HH:mm:ss").format(Calendar.getInstance().getTime()));
            return imageRetrievalDataSet;
        }
        finally {
        	
        	
        	
            if (dao != null) {
                dao.free();
                dao = null;
            }
        }
    }
    
	  public static String encodeImage(byte[] imageByteArray) {
		    return Base64.encode(imageByteArray);
		}

    public static String getCurrentTime() {

		HisUtil util = null;

		try {
             util = new HisUtil("CreateUserLogDao", "getCurrentTime");
			 return util.getDSDate("YYYY-MM-DD HH24:mi:ss");
		} catch (Exception e) {
			e.printStackTrace();
		}

		try {
			return util.getASDate("YYYY-MM-DD HH24:mi:ss");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
                 return new SimpleDateFormat("YYYY-MM-DD HH24:mi:ss").format(new Date());

	}
}