package in.cdac.rajashthan.dao;

import global.transactionmgnt.HisDAO;
import global.utility.HisUtil;
import in.cdac.rajashthan.bo.ETransDataList;
import in.cdac.rajashthan.bo.NewCountDataSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.sql.rowset.WebRowSet;

public class DailyTransactionsCountDAO {
    public static NewCountDataSet getCount(String strServiceID) {
        String err = "";
        String proc_name1 = "{call PKG_WEBSERVICES.getDistrictWiseStatData(?,?,?,?)}";
        int procIndex1 = 0;
        HisDAO dao = null;
        WebRowSet ws = null;
        String modeval = "";
        String strServiceName = "";
        try {
            if (!"1".equals(strServiceID)) {
                NewCountDataSet newCountDataSet = new NewCountDataSet("Not a Valid ServiceId");
                return newCountDataSet;
            }
            modeval = strServiceID;
            dao = new HisDAO("WebServices", "DailyTransactionsCountDAO.getCount(String strServiceID)");
            procIndex1 = dao.setProcedure(proc_name1);
            dao.setProcInValue(procIndex1, "modeval", "1");
            dao.setProcInValue(procIndex1, "hosp_code", "0");
            dao.setProcOutValue(procIndex1, "err", 1);
            dao.setProcOutValue(procIndex1, "resultset", 2);
            dao.executeProcedure(procIndex1);
            err = dao.getString(procIndex1, "err");
            if (err == null) {
                err = "";
            }
            if ((ws = dao.getWebRowSet(procIndex1, "resultset")) != null && ws.size() > 0) {
                ArrayList<ETransDataList> eTransList = new ArrayList<ETransDataList>();
                ws.beforeFirst();
                while (ws.next()) {
                    eTransList.add(new ETransDataList("OPD", "01", ws.getString(1), ws.getString(2), ws.getString(3)));
                    eTransList.add(new ETransDataList("IPD", "02", ws.getString(1), ws.getString(2), ws.getString(4)));
                    eTransList.add(new ETransDataList("INV", "03", ws.getString(1), ws.getString(2), ws.getString(5)));
                }
                NewCountDataSet newCountDataSet = new NewCountDataSet(eTransList, "");
                return newCountDataSet;
            }
            NewCountDataSet newCountDataSet = new NewCountDataSet("No Patient List");
            return newCountDataSet;
        }
        catch (Exception e) {
            e.printStackTrace();
            NewCountDataSet newCountDataSet = new NewCountDataSet("INTERNAL ERROR");
            return newCountDataSet;
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
                        return util.getDSDate("dd-Mon-yyyy HH24:mi:ss");
		} catch (Exception e) {
			e.printStackTrace();
		}

		try {
			 return util.getASDate("dd-Mon-yyyy HH:mm:ss");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return new SimpleDateFormat("dd-MMM-yyyy HH:mm:ss").format(new Date());

	}
}