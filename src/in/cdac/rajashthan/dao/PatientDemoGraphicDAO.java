package in.cdac.rajashthan.dao;

import global.transactionmgnt.HisDAO;
import global.utility.HisUtil;
import in.cdac.rajashthan.bo.DGParametreList;
import in.cdac.rajashthan.bo.PatientDemoGraphicDataSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.sql.rowset.WebRowSet;

public class PatientDemoGraphicDAO {
    public static PatientDemoGraphicDataSet getPatientDemoGraphicData(String CR) {
        String err = "";
        String proc_name1 = "{call PKG_WEBSERVICES.getPatientDemoGraphicData(?,?,?,?,?)}";
        int procIndex1 = 0;
        HisDAO dao = null;
        WebRowSet ws = null;
        String strCR = CR;
        String strServiceName = "";
 
        //CR Number validation-On client side in SCM
             try {
          /*  if (!"4".equals(CR)) {
            	PatientDemoGraphicDataSet patientdemographicdata = new PatientDemoGraphicDataSet("Not a Valid CR No.", PatientDemoGraphicDAO.getCurrentTime());
                return patientdemographicdata;
            } */
        
            strServiceName = "Demographic Detail on CR number";
            dao = new HisDAO("WebServices", "DailyPatientListDAO.getPatientDemoGraphicData(?,?,?,?,?)");
            procIndex1 = dao.setProcedure(proc_name1);
            dao.setProcInValue(procIndex1, "modeval", "1");
            dao.setProcInValue(procIndex1, "crNo",strCR );
            dao.setProcInValue(procIndex1, "hosp_code", "0");
            dao.setProcOutValue(procIndex1, "err", 1);
            dao.setProcOutValue(procIndex1, "resultset", 2);
            dao.executeProcedure(procIndex1);
            err = dao.getString(procIndex1, "err");
            if (err == null) {
                err = "";
            }
            if ((ws = dao.getWebRowSet(procIndex1, "resultset")) != null && ws.size() > 0) {
                ArrayList<DGParametreList> patientVisitData = new ArrayList<DGParametreList>();
                ws.beforeFirst();
                while (ws.next()) {
                	patientVisitData.add(new DGParametreList(ws.getString(1), ws.getString(2), ws.getString(3), ws.getString(4), ws.getString(5), ws.getString(6), ws.getString(7), ws.getString(8), ws.getString(9), ws.getString(10), ws.getString(11)));
                }
                PatientDemoGraphicDataSet patientDGDataSet = new PatientDemoGraphicDataSet(patientVisitData, "", PatientDemoGraphicDAO.getCurrentTime());
                return patientDGDataSet;
            }
            PatientDemoGraphicDataSet patientDGDataSet = new PatientDemoGraphicDataSet("No Detail on CRN found", PatientDemoGraphicDAO.getCurrentTime());
            return patientDGDataSet;
        }
        catch (Exception e) {
            e.printStackTrace();
            PatientDemoGraphicDataSet patientDGDataSet = new PatientDemoGraphicDataSet("INTERNAL ERROR", PatientDemoGraphicDAO.getCurrentTime());
            return patientDGDataSet;
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
