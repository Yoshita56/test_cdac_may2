package in.cdac.rajashthan.dao;

import global.transactionmgnt.HisDAO;
import global.utility.HisUtil;
import in.cdac.rajashthan.bo.PatientDataSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Calendar;
import java.util.LinkedHashMap;
import java.util.List;

import javax.sql.rowset.WebRowSet;
import org.json.JSONArray;
import org.json.JSONObject;



public class IssuetoPatListDAO {
	public static String getPatientIssueData(String strServiceID,String crNo) {
       //public static PatientDataSet getPatientVisitData(String strServiceID,String fromTime,String toTime) {
       //Rajshthan- System.out.println("fromTime :"+fromTime);
       //Rajshthan - System.out.println("toTime :"+toTime);
		//System.out.println("Calling..Service");
    	String err = "";
    	String status="";
        String proc_name1 = "{call PKG_WEBSERVICES.getIssuePatientData(?,?,?,?)}";
    	//String proc_name1 = "{call PKG_WEBSERVICES.getTodayVisitedPatientData(?,?,?,?,?,?)}";
        int procIndex1 = 0;
        HisDAO dao = null;
        WebRowSet ws = null;
        JSONObject mainObj = new JSONObject();
        JSONObject mainObj1 = new JSONObject();
        JSONArray ja = new JSONArray();
        ArrayList<String> columnlist = new ArrayList<String>();
        List jsonolist = new ArrayList();
        int length=0;
        try {
            dao = new HisDAO("WebServices", "DailyPatientListDAO.getTodayVisitedPatientData()");
            procIndex1 = dao.setProcedure(proc_name1);
            dao.setProcInValue(procIndex1, "modeval", "1");
            dao.setProcInValue(procIndex1, "cr_no", crNo);
            dao.setProcOutValue(procIndex1, "err", 1);
            dao.setProcOutValue(procIndex1, "resultset", 2);
            //System.out.println("calling proced..");
            dao.executeProcedure(procIndex1);
            err = dao.getString(procIndex1, "err");
            if(err.equals(""))
			{
				ws = dao.getWebRowSet(procIndex1, "resultset");
				 length=	ws.getMetaData().getColumnCount();
				for(int i=1;i<=length;i++)
				{
					columnlist.add(ws.getMetaData().getColumnName(i).toUpperCase());
				}
				
			}
          if (ws != null && ws.size() > 0) {
              while (ws.next()) {
            	  int j=0;
                	status="1";
                	JSONObject js=new JSONObject();
                	for (int i=1;i<=length;i++)
                	{
                		String key=columnlist.get(i-1);
                		String value=ws.getString(i);
                		js.put(key, value);
                		
                	}
                	jsonolist.add(js) ;               	
                	
                }
              //ja.put(jsonolist);
              }
          //System.out.println("jsonolist"+jsonolist);
          
         
          mainObj.put("status", status);
          mainObj.put("Pat_issueDetails", jsonolist);
          //jsonObject3 =  Json.createObjectBuilder().add("status", status).add("pat_dealis", Json.createArrayBuilder().add(jsonolist.toString())).build();
     	 
        
             if(ws != null){
        		ws.close();
        		ws = null;
        	}          
            return mainObj.toString();
        }
        catch (Exception e) {
            e.printStackTrace();
            return mainObj.toString();
        }
        finally {
        	if (dao != null) {
                dao.free();
                dao = null;
            }
        }
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