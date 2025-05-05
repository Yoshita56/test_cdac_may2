package in.cdac.rajashthan.dao;

import global.transactionmgnt.HisDAO;
import global.utility.HisUtil;
import in.cdac.rajashthan.bo.DrugStockList;
import in.cdac.rajashthan.bo.NewDataSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.sql.rowset.WebRowSet;

public class CreateDrugStockDao {
    public static final String query = " SELECT B.HSTSTR_CPA_CODE ,  MMS_MST.GET_ITEM_DTL(1 , A.GNUM_HOSPITAL_CODE , A.HSTNUM_ITEMBRAND_ID) AS ITEM_NAME, A.HSTSTR_BATCH_NO AS BATCH_NO ,  SUM(NVL(A.HSTNUM_INHAND_QTY,0)) AS QTY, MMS_MST.GET_INVENTORY_UNITID(1,A.GNUM_HOSPITAL_CODE,A.SSTNUM_ITEM_CAT_NO,A.HSTNUM_ITEM_ID) AS UNIT_ID,  A.HSTNUM_RATE ,  ( SELECT HSTSTR_STORE_CODE FROM HSTT_STORE_MST X  WHERE X.HSTNUM_STORE_ID =  A.HSTNUM_STORE_ID )   FROM HSTT_DRUG_CURRSTOCK_DTL A , HSTT_DRUGBRAND_MST B WHERE A.GNUM_ISVALID = 1 AND B.HSTNUM_ITEM_ID = A.HSTNUM_ITEM_ID AND B.HSTNUM_ITEMBRAND_ID = A.HSTNUM_ITEMBRAND_ID  AND B.GNUM_HOSPITAL_CODE = A.GNUM_HOSPITAL_CODE AND NVL(A.HSTNUM_INHAND_QTY,0) > 0 AND A.GNUM_HOSPITAL_CODE = 998  AND A.HSTDT_EXPIRY_DATE > SYSDATE  AND A.HSTNUM_STORE_ID IN ( SELECT HSTNUM_STORE_ID  FROM HSTT_STORE_MST WHERE UPPER(HSTSTR_STORE_CODE) = UPPER('###') )  GROUP BY A.GNUM_HOSPITAL_CODE,A.SSTNUM_ITEM_CAT_NO,A.HSTNUM_ITEM_ID,A.HSTNUM_ITEMBRAND_ID,  B.HSTSTR_CPA_CODE ,A.HSTSTR_BATCH_NO , A.HSTNUM_RATE , A.HSTNUM_STORE_ID ORDER BY ITEM_NAME ";

    public static NewDataSet getStockDtls(String strStoreId) {
        HisDAO dao = null;
        try {
            if (strStoreId == null || strStoreId != null && "0".equals(strStoreId) || strStoreId != null && strStoreId.length() != 3) {
                NewDataSet newDataSet = new NewDataSet("Not a Valid Location Code", CreateDrugStockDao.getCurrentTime());
                return newDataSet;
            }
            dao = new HisDAO("CreateUserLogDao", "getUserLog");
            int qryIndex = dao.setQuery(" SELECT B.HSTSTR_CPA_CODE ,  MMS_MST.GET_ITEM_DTL(1 , A.GNUM_HOSPITAL_CODE , A.HSTNUM_ITEMBRAND_ID) AS ITEM_NAME, A.HSTSTR_BATCH_NO AS BATCH_NO ,  SUM(NVL(A.HSTNUM_INHAND_QTY,0)) AS QTY, MMS_MST.GET_INVENTORY_UNITID(1,A.GNUM_HOSPITAL_CODE,A.SSTNUM_ITEM_CAT_NO,A.HSTNUM_ITEM_ID) AS UNIT_ID,  A.HSTNUM_RATE ,  ( SELECT HSTSTR_STORE_CODE FROM HSTT_STORE_MST X  WHERE X.HSTNUM_STORE_ID =  A.HSTNUM_STORE_ID )   FROM HSTT_DRUG_CURRSTOCK_DTL A , HSTT_DRUGBRAND_MST B WHERE A.GNUM_ISVALID = 1 AND B.HSTNUM_ITEM_ID = A.HSTNUM_ITEM_ID AND B.HSTNUM_ITEMBRAND_ID = A.HSTNUM_ITEMBRAND_ID  AND B.GNUM_HOSPITAL_CODE = A.GNUM_HOSPITAL_CODE AND NVL(A.HSTNUM_INHAND_QTY,0) > 0 AND A.GNUM_HOSPITAL_CODE = 998  AND A.HSTDT_EXPIRY_DATE > SYSDATE  AND A.HSTNUM_STORE_ID IN ( SELECT HSTNUM_STORE_ID  FROM HSTT_STORE_MST WHERE UPPER(HSTSTR_STORE_CODE) = UPPER('###') )  GROUP BY A.GNUM_HOSPITAL_CODE,A.SSTNUM_ITEM_CAT_NO,A.HSTNUM_ITEM_ID,A.HSTNUM_ITEMBRAND_ID,  B.HSTSTR_CPA_CODE ,A.HSTSTR_BATCH_NO , A.HSTNUM_RATE , A.HSTNUM_STORE_ID ORDER BY ITEM_NAME ".replace("###", strStoreId));
            WebRowSet ws = dao.executeQry(qryIndex);
            if (ws != null && ws.size() > 0) {
                ArrayList<DrugStockList> drugStockList = new ArrayList<DrugStockList>();
                ws.beforeFirst();
                while (ws.next()) {
                    drugStockList.add(new DrugStockList(ws.getString(1), ws.getString(2), ws.getString(3), ws.getString(4), ws.getString(5), ws.getString(6), ws.getString(7)));
                }
                NewDataSet newDataSet = new NewDataSet(drugStockList, "", CreateDrugStockDao.getCurrentTime());
                return newDataSet;
            }
            NewDataSet newDataSet = new NewDataSet("No Stock in the Given Location", CreateDrugStockDao.getCurrentTime());
            return newDataSet;
        }
        catch (Exception e) {
            e.printStackTrace();
            NewDataSet newDataSet = new NewDataSet("INTERNAL ERROR", CreateDrugStockDao.getCurrentTime());
            return newDataSet;
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
			return util.getASDate("dd-MMM-yyyy HH:mm:ss");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return new SimpleDateFormat("dd-MMM-yyyy HH:mm:ss")
				.format(new Date());

	}
}