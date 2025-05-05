/**
 * 
 */
package hisglobal.transactionmgnt.controller;

import java.util.HashMap;
import java.util.LinkedHashMap;

import hisglobal.transactionmgnt.bo.ComboOptionBO;
import hisglobal.transactionmgnt.vo.ComboOptionVO;
import hisglobal.utility.HisUtil;

/**
 * @author Pankaj Kumar
 * 
 */
public class HisComboOptions {
	public static String getOptionsFromProc(String _strProcedureName,
			LinkedHashMap<String, String> _mapProcedureParam,
			String _strSelectedValue, String _strDefualtOption,
			boolean _fConcatValue) throws Exception {
		String strOptionValues="";
		try{
			HisUtil util = new HisUtil("HisComboOptions", "getOptionsFromProc");
			ComboOptionVO comboOptionVO = new ComboOptionVO();
			comboOptionVO.resetVO();
			comboOptionVO.setMapProcedureParam(_mapProcedureParam);
			comboOptionVO.setStrProcedureName(_strProcedureName);
			ComboOptionBO comboOptionBO = new ComboOptionBO();
			comboOptionBO.getOptionValues(comboOptionVO);
			if(comboOptionVO.getStrMsgType().equals("1"))
				throw new Exception("HisComboOptions--->getOptionsFromProc()--->"+comboOptionVO.getStrMsgString());
			strOptionValues = util.getOptionValue(comboOptionVO
					.getWsOptionValues(), _strSelectedValue, _strDefualtOption,
					_fConcatValue);
		}catch(Exception _Err){
			throw new Exception(_Err.getMessage());
		}
		return strOptionValues;
	}
	public static String getOptionsFromQuery(String _strQuery,
			HashMap<String, String> _mapQueryParam,
			String _strSelectedValue, String _strDefualtOption,
			boolean _fConcatValue) throws Exception {
		String strOptionValues="";
		try{
			HisUtil util = new HisUtil("HisComboOptions", "getOptionsFromProc");
			ComboOptionVO comboOptionVO = new ComboOptionVO();
			comboOptionVO.resetVO();
			comboOptionVO.setMapQueryParam(_mapQueryParam);
			comboOptionVO.setStrQuery(_strQuery);
			ComboOptionBO comboOptionBO = new ComboOptionBO();
			comboOptionBO.getOptionQueryValues(comboOptionVO);
			if(comboOptionVO.getStrMsgType().equals("1"))
				throw new Exception("HisComboOptions--->getOptionsFromQuery()--->"+comboOptionVO.getStrMsgString());
			strOptionValues = util.getOptionValue(comboOptionVO
					.getWsOptionValues(), _strSelectedValue, _strDefualtOption,
					_fConcatValue);
		}catch(Exception _Err){
			throw new Exception(_Err.getMessage());
		}
		return strOptionValues;
	}
}
