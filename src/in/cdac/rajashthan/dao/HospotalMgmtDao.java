package in.cdac.rajashthan.dao;
import java.math.BigInteger;
import java.security.SecureRandom;
import java.util.ArrayList;

import hisglobal.transactionmgnt.HisDAO;
import hisglobal.utility.SMSHttpsNICPostClient;

import javax.sql.rowset.WebRowSet;
import javax.json.Json;
import javax.json.JsonArrayBuilder;
import javax.json.JsonObject;

import org.json.JSONArray;
import org.json.JSONObject;
public class HospotalMgmtDao {

	public static String getHospitalMgmtData(String modval, String hospCode, String stateCode, String fromDate, String toDate) {
		
		
		String err = "";
    	String proc_name1 = "{call PKG_WEBSERVICES.getAllHospitalstats(?,?,?,?,?,?,?)}";
        int procIndex1 = 0;
        HisDAO dao = null;
        WebRowSet ws = null;
        JsonObject jsonObject3 = null,jsonObject4=null;
         
         String status="0";
         JSONObject mainObj = new JSONObject();
         
         JSONArray ja = new JSONArray();
         JsonArrayBuilder arrayBuilder =null;
         ArrayList<String> columnlist = new ArrayList<String>();
         ArrayList<JSONObject> jsonolist = new ArrayList<JSONObject>();
         int length=0;
        try {
            dao = new HisDAO("WebServices", "HospotalMgmtDao.getHospitalMgmtData()");
            procIndex1 = dao.setProcedure(proc_name1);
            dao.setProcInValue(procIndex1, "modeval", modval,1);
            dao.setProcInValue(procIndex1, "stateCode", stateCode,2);
            dao.setProcInValue(procIndex1, "hosp_code", hospCode,3); 
            dao.setProcInValue(procIndex1, "frm_dt", fromDate,4);
            dao.setProcInValue(procIndex1, "to_dt", toDate,5);
            dao.setProcOutValue(procIndex1, "err", 1,6);
            dao.setProcOutValue(procIndex1, "resultset", 2,7);
            //dao.executeProcedureByPosition(procIndex1);
            
            dao.executeProcedureByPosition(procIndex1);
            err=dao.getString(procIndex1, "err");
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
          
         
        //mainObj.put("status", status);
       // mainObj.put("ALLHOSPITALSTATS", jsonolist);
          //jsonObject3 =  Json.createObjectBuilder().add("status", status).add("pat_dealis", Json.createArrayBuilder().add(jsonolist.toString())).build();
   	 
        
             if(ws != null){
        		ws.close();
        		ws = null;
        	}          
            return jsonolist.toString();
        }
        catch (Exception e) {
            e.printStackTrace();
            return jsonolist.toString();
        }
        finally {
        	if (dao != null) {
                dao.free();
                dao = null;
            }
        }
		
		
		//return null;
	}

}
