/**
 * 
 */
package mms.transactions.controller.hlp;

import mms.transactions.bo.DrugProfileBO;
import mms.transactions.vo.DrugProfileVO;

/**
 * @author pankaj Date-- 22-Jan-2009 Business Object Class for Drug Profile
 *         Transaction
 * 
 */
public class DrugProfileHLP {
	public static String drugCombos(DrugProfileVO _drugProfileVO) {
		StringBuffer sbTmp = null;
		DrugProfileBO drugProfileBO = null;
		try {
			drugProfileBO = new DrugProfileBO();

			drugProfileBO.setGroupComboValues(_drugProfileVO);
			
			if (_drugProfileVO.getStrMsgType().equals("1"))
				throw new Exception(_drugProfileVO.getStrMsgString());

			sbTmp = new StringBuffer("");

			//sbTmp.append("<tr><td width='25%' class='LABEL'><font size='2' color='red'>*</font> Group Name</td>");
			//sbTmp.append("<td width='25%' class='CONTROL'><select name='strGroupID' onchange='getSubGroupCombo()' class='comboNormal'>");
			//sbTmp.append(_drugProfileVO.getStrGroupComboValues());
			//sbTmp.append("</select></td>");
			//sbTmp.append("<td width='25%' class='LABEL'>Sub-Group Name</td>");
			//sbTmp.append("<td width='25%' class='CONTROL'><div id='strSubGroupID'><select name='strSubGroupID' onchange='getDrugCombo()' class='comboNormal'>");
			//sbTmp.append("<option value='0'>Select Value</option>");
			//sbTmp.append("</select></div></td></tr>");

			//sbTmp.append("<tr><td width='25%' class='LABEL'><font size='2' color='red'>*</font> Generic Item Name</td>");
			//sbTmp.append("<td width='75%' class='CONTROL' colspan='3'><div id='strItemID'><select name='strItemID' onchange='hideAllDetails()' class='comboNormal'>");
			//sbTmp.append("<option value='0'>Select Value</option>");
			//sbTmp.append("</select></div></td></tr></table>");

			sbTmp.append("<table align='center' class='TABLEWIDTH' cellpadding='1px' cellspacing='1px'>");
			sbTmp.append("<tr><td  colspan='4' class='TITLE' width='25%'>");
			sbTmp.append("<div id='dosagePlusID' align='left' style='display:block;'>");
			sbTmp.append("<img src='../../hisglobal/images/plus.gif'");
			sbTmp.append("onClick=\"getDosageData();\" style='cursor: pointer; '/>");
			sbTmp.append("Dosage And Indication");
			sbTmp.append("</div><div id='dosageMinusID' style='display:none;' align='left'>");
			sbTmp.append("<img src='../../hisglobal/images/minus.gif'");
			sbTmp.append("onClick=\"hideDosageData();\" style='cursor: pointer; '/>");
			sbTmp.append("Dosage And Indication</div></td></tr></table>");
			sbTmp.append("<div id='dosageDATAID'></div>");

			sbTmp.append("<table align='center' class='TABLEWIDTH' cellpadding='1px' cellspacing='1px'>");
			sbTmp.append("<tr><td  colspan='4' class='TITLE' width='25%'>");
			sbTmp.append("<div id='saftyPlusID' align='left' style='display:block;'>");
			sbTmp.append("<img src='../../hisglobal/images/plus.gif'");
			sbTmp.append("onClick=\"getSaftyData();\" style='cursor: pointer; '/>");
			sbTmp.append("Safty Alert");
			sbTmp.append("</div><div id='saftyMinusID' style='display:none;' align='left'>");
			sbTmp.append("<img src='../../hisglobal/images/minus.gif'");
			sbTmp.append("onClick=\"hideSaftyData();\" style='cursor: pointer; '/>");
			sbTmp.append("Safty Alert</div></td></tr></table>");
			sbTmp.append("<div id='saftyDATAID'></div>");

			sbTmp.append("<table align='center' class='TABLEWIDTH' cellpadding='1px' cellspacing='1px'>");
			sbTmp.append("<tr><td  colspan='4' class='TITLE' width='25%'>");
			sbTmp.append("<div id='brandPlusID' align='left' style='display:block;'>");
			sbTmp.append("<img src='../../hisglobal/images/plus.gif'");
			sbTmp.append("onClick=\"getBrandData();\" style='cursor: pointer; '/>");
			sbTmp.append("Alternate Brands");
			sbTmp.append("</div><div id='brandMinusID' style='display:none;' align='left'>");
			sbTmp.append("<img src='../../hisglobal/images/minus.gif'");
			sbTmp.append("onClick=\"hideBrandData();\" style='cursor: pointer; '/>");
			sbTmp.append("Alternate Brands</div></td></tr></table>");
			sbTmp.append("<div id='brandDATAID'></div>");

			//sbTmp.append("<table align='center' class='TABLEWIDTH' cellpadding='1px' cellspacing='1px'>");
			//  sbTmp.append("<tr class='FOOTER'><td colspan='4' width='25%'><font size='2' color='red'>*</font> Mandatory Fields  , ['*'] Reserved/Branded Item </td></tr></table>");

			
			if (_drugProfileVO.getStrMsgType().equals("1"))
				throw new Exception(_drugProfileVO.getStrMsgString());
		} catch (Exception _Err) {

			_drugProfileVO.setStrMsgType("1");
			_drugProfileVO.setStrMsgString("DrugProfileHLP.drugCombos---->"
					+ _drugProfileVO.getStrMsgString());
		}
		return sbTmp.toString();
	}
	
	public static String genericDtls(DrugProfileVO _drugProfileVO) {
		StringBuffer sbTmp = null;
		DrugProfileBO drugProfileBO = null;
		try {
			drugProfileBO = new DrugProfileBO();

			drugProfileBO.setGenericDtl(_drugProfileVO);
			
			if (_drugProfileVO.getStrMsgType().equals("1"))
				throw new Exception(_drugProfileVO.getStrMsgString());

			sbTmp = new StringBuffer("");

			//sbTmp.append("<tr><td width='25%' class='LABEL'><font size='2' color='red'>*</font> Group Name</td>");
			//sbTmp.append("<td width='25%' class='CONTROL'><select name='strGroupID' onchange='getSubGroupCombo()' class='comboNormal'>");
			//sbTmp.append(_drugProfileVO.getStrGroupComboValues());
			//sbTmp.append("</select></td>");
			//sbTmp.append("<td width='25%' class='LABEL'>Sub-Group Name</td>");
			//sbTmp.append("<td width='25%' class='CONTROL'><div id='strSubGroupID'><select name='strSubGroupID' onchange='getDrugCombo()' class='comboNormal'>");
			//sbTmp.append("<option value='0'>Select Value</option>");
			//sbTmp.append("</select></div></td></tr>");

			//sbTmp.append("<tr><td width='25%' class='LABEL'><font size='2' color='red'>*</font> Generic Item Name</td>");
			//sbTmp.append("<td width='75%' class='CONTROL' colspan='3'><div id='strItemID'><select name='strItemID' onchange='hideAllDetails()' class='comboNormal'>");
			//sbTmp.append("<option value='0'>Select Value</option>");
			//sbTmp.append("</select></div></td></tr></table>");
			if(_drugProfileVO.getStrItemWS().size() > 0)
			{
				while(_drugProfileVO.getStrItemWS().next())
				{
					sbTmp.append("<table align='center' class='TABLEWIDTH' cellpadding='1px' cellspacing='1px'>");
					sbTmp.append("<tr><td class='multiLabel' width='25%'><div align='right'>Group Name(CIMS class-code) </div></td><td class='multiControl' width='25%'><input type='hidden' name='strGroupID' value = "+_drugProfileVO.getStrItemWS().getString(4)+"><div align='left'>"+_drugProfileVO.getStrItemWS().getString(1)+"</div></td>");
					sbTmp.append("<td class='multiLabel' width='25%'><div align='right'>SubGroup Name </div></td><td class='multiControl' width='25%'><input type='hidden' name='strSubGroupID' value = "+_drugProfileVO.getStrItemWS().getString(5)+"><div align='left'>"+_drugProfileVO.getStrItemWS().getString(2)+"</div></td></tr>");
					sbTmp.append("<tr><td class='multiLabel' width='25%'><div align='right'>Generic Drug Name </div></td><td class='multiControl' width='25%'><input type='hidden' name='strItemID' value = "+_drugProfileVO.getStrItemID()+"><div align='left'>"+_drugProfileVO.getStrItemWS().getString(3)+"</div></td><td class='multiLabel' width='25%'><div align='right'>ATC Classification Code </div></td><td class='multiControl' width='25%'><div align='left'>"+_drugProfileVO.getStrItemWS().getString(6).toUpperCase()+"</div></td></tr>");
					sbTmp.append("<tr><td class='multiLabel' width='25%'><div align='right'>Branded/Non-Branded : </div></td><td class='multiControl' width='25%'><div align='left'>"+_drugProfileVO.getStrItemWS().getString(7)+"</div></td><td class='multiLabel' width='25%'><div align='right'> </div></td><td class='multiControl' width='25%'><div align='left'></div></td></tr>");
					sbTmp.append("</table>");
				}
			}
			if (_drugProfileVO.getStrMsgType().equals("1"))
				throw new Exception(_drugProfileVO.getStrMsgString());
		} catch (Exception _Err) {

			_drugProfileVO.setStrMsgType("1");
			_drugProfileVO.setStrMsgString("DrugProfileHLP.drugCombos---->"
					+ _drugProfileVO.getStrMsgString());
		}
		return sbTmp.toString();
	}

	/*
	 * public static String dosageData(DrugProfileVO _drugProfileVO) {
	 * StringBuffer sbTmp = null; DrugProfileBO drugProfileBO = null; String[]
	 * strLabel = null; String[] strData = null; try { drugProfileBO = new
	 * DrugProfileBO();
	 * drugProfileBO.setDosageAndIndicationData(_drugProfileVO); if
	 * (_drugProfileVO.getStrMsgType().equals("1")) throw new
	 * Exception(_drugProfileVO.getStrMsgString());
	 * 
	 * strLabel = _drugProfileVO.getStrDosAndIndLable(); strData =
	 * _drugProfileVO.getStrDosAndIndData();
	 * 
	 * sbTmp = new StringBuffer(""); boolean fTmp = true; boolean fStartTable =
	 * true;
	 * 
	 * for (int nTmpI = 0; nTmpI < 26; nTmpI++) { while (fTmp) { if
	 * (strData[nTmpI] == null || strData[nTmpI].equals("")) { if (nTmpI == 25) {
	 * break; } nTmpI++; } else fTmp = false; } if (!fTmp) { if (fStartTable) {
	 * sbTmp .append("<table align='center'class='TABLEWIDTH' cellpadding='1px'
	 * cellspacing='1px'>"); fStartTable = false; } sbTmp.append("<tr><td width='25%' class='LABEL'>");
	 * sbTmp.append(strLabel[nTmpI]); if (nTmpI == 25) sbTmp .append("</td><td width='75%'  colspan='3' class='CONTROL'>");
	 * else sbTmp.append("</td><td width='25%' class='CONTROL'>");
	 * sbTmp.append(strData[nTmpI++]); if (nTmpI == 26) sbTmp.append("</td></tr>");
	 * else sbTmp.append("</td>"); fTmp = true; if (nTmpI < 26) { while (fTmp) {
	 * if (strData[nTmpI] == null || strData[nTmpI].equals("")) { nTmpI++; }
	 * else fTmp = false; } sbTmp.append("<td width='25%' class='LABEL'>");
	 * sbTmp.append(strLabel[nTmpI]); sbTmp.append("</td><td width='25%' class='CONTROL'>");
	 * sbTmp.append(strData[nTmpI]); sbTmp.append("</select></td></tr>"); }
	 * fTmp = true; if (nTmpI == 25) sbTmp.append("</table>"); } }
	 * 
	 * if (_drugProfileVO.getStrMsgType().equals("1")) throw new
	 * Exception(_drugProfileVO.getStrMsgString()); } catch (Exception _Err) {
	 * _Err.printStackTrace();
	 * 
	 * _drugProfileVO.setStrMsgType("1");
	 * _drugProfileVO.setStrMsgString("DrugProfileHLP.dosageData---->" +
	 * _drugProfileVO.getStrMsgString()); } if (sbTmp.toString().equals("")) {
	 * sbTmp .append("<table align='center'class='TABLEWIDTH' cellpadding='1px'
	 * cellspacing='1px'> "); sbTmp .append("<tr><td class='multiControl'><font
	 * color='red'>No Record Found</font></td></tr>"); sbTmp.append("</table>"); }
	 * 
	 * return sbTmp.toString(); }
	 */

	public static String dosageData(DrugProfileVO _drugProfileVO) {
		StringBuffer sbTmp = null;
		DrugProfileBO drugProfileBO = null;
		String[] strLabel = null;
		String[] strData = null;
		try {
			drugProfileBO = new DrugProfileBO();
			drugProfileBO.setDosageAndIndicationData(_drugProfileVO);
			if (_drugProfileVO.getStrMsgType().equals("1"))
				throw new Exception(_drugProfileVO.getStrMsgString());

			sbTmp = new StringBuffer("");
			if(_drugProfileVO.getWsDosageAndIndicationData().size() > 0)
			{
				while(_drugProfileVO.getWsDosageAndIndicationData().next())
				{
					sbTmp.append("<table align='center' class='TABLEWIDTH' cellpadding='1px' cellspacing='1px'>");
					sbTmp.append("<tr><td class='multiLabel' width='25%'><div align='right'>Dosage Adult </div></td><td class='multiControl' width='25%'><div align='left'>"+_drugProfileVO.getWsDosageAndIndicationData().getString(1)+"</div></td>");
					sbTmp.append("<td class='multiLabel' width='25%'><div align='right'>Dosage Peads </div></td><td class='multiControl' width='25%'><div align='left'>"+_drugProfileVO.getWsDosageAndIndicationData().getString(2)+"</div></td></tr>");
					sbTmp.append("<tr><td class='multiLabel' width='25%'><div align='right'>Administration Route </div></td><td class='multiControl' width='25%'><div align='left'>"+_drugProfileVO.getWsDosageAndIndicationData().getString(3)+"</div></td><td class='multiLabel' width='25%'></td><td class='multiControl' width='25%'></td></tr>");
					sbTmp.append("</table>");
				}
			}
			else
				sbTmp.append("<table align='center' class='TABLEWIDTH' cellpadding='1px' cellspacing='1px'><tr><td class='multiControl'><font color='red'>No Record Found</font></td></tr></table>");
			if (_drugProfileVO.getStrMsgType().equals("1"))
				throw new Exception(_drugProfileVO.getStrMsgString());
		} catch (Exception _Err) {
			_Err.printStackTrace();

			_drugProfileVO.setStrMsgType("1");
			_drugProfileVO.setStrMsgString("DrugProfileHLP.dosageData---->"
					+ _drugProfileVO.getStrMsgString());
		}

		return sbTmp.toString();
	}

	/*
	 * public static String saftyData(DrugProfileVO _drugProfileVO) {
	 * StringBuffer sbTmp = null; DrugProfileBO drugProfileBO = null; String[]
	 * strLabel = null; String[] strData = null; try { drugProfileBO = new
	 * DrugProfileBO();
	 * 
	 * drugProfileBO.setSaftyAlertData(_drugProfileVO); if
	 * (_drugProfileVO.getStrMsgType().equals("1")) throw new
	 * Exception(_drugProfileVO.getStrMsgString());
	 * 
	 * strLabel = _drugProfileVO.getStrSaftyAlertLable(); strData =
	 * _drugProfileVO.getStrSaftyAlertData();
	 * 
	 * sbTmp = new StringBuffer(""); boolean fTmp = true; boolean fStartTable =
	 * true; for (int nTmpI = 0; nTmpI < 9; nTmpI++) { while (fTmp) { if
	 * (strData[nTmpI] == null || strData[nTmpI].equals("")) { if (nTmpI == 8) {
	 * break; } nTmpI++; } else fTmp = false; } if (!fTmp) { if (fStartTable) {
	 * sbTmp .append("<table align='center'class='TABLEWIDTH' cellpadding='1px'
	 * cellspacing='1px'>"); fStartTable = false; } sbTmp.append("<tr><td width='25%' class='LABEL'>");
	 * sbTmp.append(strLabel[nTmpI]); if (nTmpI == 8) sbTmp .append("</td><td width='75%' colspan='3' class='CONTROL'>");
	 * else sbTmp.append("</td><td width='25%' class='CONTROL'>");
	 * sbTmp.append(strData[nTmpI++]); if (nTmpI == 9) sbTmp.append("</td></tr>");
	 * else sbTmp.append("</td>"); if (nTmpI < 9) { while (fTmp) { if
	 * (strData[nTmpI] == null || strData[nTmpI].equals("")) { nTmpI++; } else
	 * fTmp = false; } sbTmp.append("<td width='25%' class='LABEL'>");
	 * sbTmp.append(strLabel[nTmpI]); sbTmp.append("</td><td width='25%' class='CONTROL'>");
	 * sbTmp.append(strData[nTmpI]); sbTmp.append("</select></td></tr>"); }
	 * fTmp = true; } } if (!fStartTable) sbTmp.append("</table>");
	 * 
	 * if (_drugProfileVO.getStrMsgType().equals("1")) throw new
	 * Exception(_drugProfileVO.getStrMsgString()); } catch (Exception _Err) {
	 * 
	 * _drugProfileVO.setStrMsgType("1");
	 * _drugProfileVO.setStrMsgString("DrugProfileHLP.saftyData---->" +
	 * _drugProfileVO.getStrMsgString()); }
	 * 
	 * if (sbTmp.toString().equals("")) { sbTmp .append("<table
	 * align='center'class='TABLEWIDTH' cellpadding='1px' cellspacing='1px'> "); sbTmp
	 * .append("<tr><td class='multiControl'><font color='red'>No Record
	 * Found</font></td></tr>"); sbTmp.append("</table>"); } return
	 * sbTmp.toString(); }
	 */

	public static String saftyData(DrugProfileVO _drugProfileVO) {
		StringBuffer sbTmp = null;
		DrugProfileBO drugProfileBO = null;
		try {
			drugProfileBO = new DrugProfileBO();
			sbTmp = new StringBuffer("");
			drugProfileBO.setSaftyAlertData(_drugProfileVO);
			if (_drugProfileVO.getStrMsgType().equals("1"))
				throw new Exception(_drugProfileVO.getStrMsgString());
			
			
			if(_drugProfileVO.getWsSaftyAlertData().size() > 0)
			{
				while(_drugProfileVO.getWsSaftyAlertData().next())
				{
					sbTmp.append("<table align='center' class='TABLEWIDTH' cellpadding='1px' cellspacing='1px'>");
					sbTmp.append("<tr><td class='multiLabel' width='25%'><div align='right'>Pregnancy Category </div></td><td class='multiControl' width='25%'><div align='left'>"+_drugProfileVO.getWsSaftyAlertData().getString(1)+"</div></td>");
					sbTmp.append("<td class='multiLabel' width='25%'><div align='right'>Contraindications </div></td><td class='multiControl' width='25%'><div align='left'>"+_drugProfileVO.getWsSaftyAlertData().getString(2)+"</div></td></tr>");
					sbTmp.append("<tr><td class='multiLabel' width='25%'><div align='right'>Special Precautions </div></td><td class='multiControl' width='25%'><div align='left'>"+_drugProfileVO.getWsSaftyAlertData().getString(3)+"</div></td><td class='multiLabel' width='25%'><div align='right'>Drug Interactions & Contradictions</div></td><td class='multiControl' width='25%'><div align='left'>"+_drugProfileVO.getWsSaftyAlertData().getString(4)+"</div></td></tr>");
					sbTmp.append("<tr><td class='multiLabel' width='25%'><div align='right'>Adverse Drug Reactions </div></td><td class='multiControl' width='25%'><div align='left'>"+_drugProfileVO.getWsSaftyAlertData().getString(5)+"</div></td><td class='multiLabel' width='25%'><div align='right'>Administration</div></td><td class='multiControl' width='25%'><div align='left'>"+_drugProfileVO.getWsSaftyAlertData().getString(6)+"</div></td></tr>");
					sbTmp.append("<tr><td class='multiLabel' width='25%'><div align='right'>Storage </div></td><td class='multiControl' width='25%'><div align='left'>"+_drugProfileVO.getWsSaftyAlertData().getString(7)+"</div></td><td class='multiLabel' width='25%'><div align='right'>Mechanism of Action</div></td><td class='multiControl' width='25%'><div align='left'>"+_drugProfileVO.getWsSaftyAlertData().getString(8)+"</div></td></tr>");
					//sbTmp.append("<tr><td class='multiLabel' width='25%'><div align='right'>Laboratory Interference </div></td><td class='multiControl' width='25%'><div align='left'>"+_drugProfileVO.getWsSaftyAlertData().getString(9)+"</div></td><td class='multiLabel' width='25%'><div align='right'>Shelf Life </div></td><td class='multiControl' width='25%'><div align='left'>"+_drugProfileVO.getWsSaftyAlertData().getString(10)+"</div></td></tr>");
					sbTmp.append("</table>");
				}
			}
			else
				sbTmp.append("<table align='center' class='TABLEWIDTH' cellpadding='1px' cellspacing='1px'><tr><td class='multiControl'><font color='red'>No Record Found</font></td></tr></table>");

		} catch (Exception _Err) {
			_Err.printStackTrace();
			_drugProfileVO.setStrMsgType("1");
			_drugProfileVO.setStrMsgString("DrugProfileHLP.saftyData---->"
					+ _drugProfileVO.getStrMsgString());
		}

		
		return sbTmp.toString();
	}

	public static String setBrandedItemData(DrugProfileVO _drugProfileVO) {
		StringBuffer sbTmp = null;
		DrugProfileBO drugProfileBO = null;

		try {
			drugProfileBO = new DrugProfileBO();

			drugProfileBO.setBrandedItemData(_drugProfileVO);
			if (_drugProfileVO.getStrMsgType().equals("1"))
				throw new Exception(_drugProfileVO.getStrMsgString());

			sbTmp = new StringBuffer("");
			int f = 0;
			while (_drugProfileVO.getWsBrandedItemData().next()) {
				
					sbTmp.append("<table align='center' class='TABLEWIDTH' cellpadding='1px' cellspacing='1px'>");
				sbTmp.append("<tr><td width='100%' class='multiControl'><div align='left'>");
				sbTmp.append(++f +"."+_drugProfileVO.getWsBrandedItemData().getString(1));
				sbTmp.append("</div></td></tr>");
				sbTmp.append("</table>");
			}
				
		} catch (Exception _Err) {

			_drugProfileVO.setStrMsgType("1");
			_drugProfileVO
					.setStrMsgString("DrugProfileHLP.setBrandedItemData---->"
							+ _drugProfileVO.getStrMsgString());
		}

		if (sbTmp.toString().equals("")) {
			sbTmp
					.append("<table align='center' class='TABLEWIDTH' cellpadding='1px' cellspacing='1px'> ");
			sbTmp
					.append("<tr><td class='multiControl'><font color='red'>No Record Found</font></td></tr>");
			sbTmp.append("</table>");
		}
		return sbTmp.toString();
	}
}
