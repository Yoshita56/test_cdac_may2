/**
 * 
 */
package hisglobal.transactionmgnt.dao;

import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Set;

import hisglobal.transactionmgnt.vo.ComboOptionVO;
import hisglobal.transactionmgnt.HisDAO;

import javax.sql.rowset.WebRowSet;

/**
 * @author Pankaj Kumar
 *
 */
public class ComboOptionDAO {
	public static void getOptionValues(ComboOptionVO _ComboOptionVO) {
		StringBuilder strProcName = new StringBuilder();
		strProcName.append("{call ");
		strProcName.append(_ComboOptionVO.getStrProcedureName());
		strProcName.append("(");
		for(int nTmpI=0; nTmpI<_ComboOptionVO.getMapProcedureParam().size(); nTmpI++){
			if(nTmpI==_ComboOptionVO.getMapProcedureParam().size()-1)
				strProcName.append("?");
			else
				strProcName.append("?,");
		}
		strProcName.append(")}");
		int nProcIndex = 0;
		int paramIndex = 1;
		String strErr = "";
		HisDAO daoObj = null;
		WebRowSet ws = null;
		String strResultSetKey="";
		String strErrorKey="";
		try {
			daoObj = new HisDAO("ComboOptionDAO",
					"getOptionValues");
			nProcIndex = daoObj.setProcedure(strProcName.toString());
			LinkedHashMap<String, String> mapProcParam= (LinkedHashMap<String, String>) _ComboOptionVO.getMapProcedureParam();
			Set<String> setProcParam = mapProcParam.keySet();
			Iterator<String> iterator = setProcParam.iterator(); 
			while(iterator.hasNext()){
				String strKey = iterator.next();
				if(_ComboOptionVO.getMapProcedureParam().get(strKey).startsWith("#2"))
					strResultSetKey=strKey;
				if(_ComboOptionVO.getMapProcedureParam().get(strKey).startsWith("#1"))
					strErrorKey=strKey;
				if(_ComboOptionVO.getMapProcedureParam().get(strKey).startsWith("#"))
					daoObj.setProcOutValue(nProcIndex, strKey, Integer.parseInt(_ComboOptionVO.getMapProcedureParam().get(strKey).replace("#", "")),paramIndex);
				else
					daoObj.setProcInValue(nProcIndex, strKey, _ComboOptionVO.getMapProcedureParam().get(strKey),paramIndex);
				paramIndex++;
			}
			daoObj.executeProcedureByPosition(nProcIndex);
			strErr = daoObj.getString(nProcIndex, strErrorKey);

			if(strErr==null || strErr.equals("")){
				ws = daoObj.getWebRowSet(nProcIndex, strResultSetKey);
				_ComboOptionVO.setWsOptionValues(ws);
			}else
				throw new Exception(strErr);


		} catch (Exception e) {
			_ComboOptionVO
					.setStrMsgString("ComboOptionDAO.getOptionValues() --> "
							+ e.getMessage());
			_ComboOptionVO.setStrMsgType("1");

		} finally {
			if (daoObj != null) {
				daoObj.free();
				daoObj = null;
			}
		}
	}
	public static void getOptionQueryValues(ComboOptionVO _ComboOptionVO) {
		String strQuery = _ComboOptionVO.getStrQuery();
		int nQueryIndex = 0;
		HisDAO daoObj = null;
		WebRowSet ws = null;
		try {
			daoObj = new HisDAO("ComboOptionDAO",
					"getOptionValues");
			nQueryIndex = daoObj.setQuery(strQuery);
			HashMap<String, String> mapQueryParam= (HashMap<String, String>) _ComboOptionVO.getMapQueryParam();
			Set<String> setQueryParam = mapQueryParam.keySet();
			Iterator<String> iterator = setQueryParam.iterator(); 
			while(iterator.hasNext()){
				String strKey = iterator.next();
				daoObj.setQryValue(nQueryIndex, Integer.parseInt(strKey), _ComboOptionVO.getMapQueryParam().get(strKey));
			}
			ws = daoObj.executeQry(nQueryIndex);
			if(ws!=null)
				_ComboOptionVO.setWsOptionValues(ws);
			else
				throw new Exception(" null value return Please Check the Query");

		} catch (Exception e) {
			_ComboOptionVO
					.setStrMsgString("ComboOptionDAO.getOptionQueryValues() --> "
							+ e.getMessage());
			_ComboOptionVO.setStrMsgType("1");

		} finally {
			if (daoObj != null) {
				daoObj.free();
				daoObj = null;
			}
		}
	}
}
