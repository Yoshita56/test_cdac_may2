package billing;

import javax.sql.rowset.WebRowSet;

public class HLPGrpDtl {
	public static String getProcessUnProcessDtlBS(String strGrpId,String strAcctNo, String index, String strHospCode) throws Exception 
	{
		BillingVO voObj = new BillingVO();
		BillingBO boObj = new BillingBO();
		voObj.setStrValue1(strGrpId);
		voObj.setStrValue2(strAcctNo);
		voObj.setStrValue3(strHospCode);
		int i = Integer.parseInt(index);
		// int rowSize = 0;
		int k = 0;
		StringBuffer sb = null;

		String strDefaultGrpId = "0";

		sb = new StringBuffer("");

		try 
		{
			
			strDefaultGrpId = BillConfigUtil.GROUP_ID_DEPOSIT;

			boObj.getProcessUnProcessDtl(voObj);
			boObj.getProcessServiceDtl(voObj);
			WebRowSet ws = voObj.getGblWs2(); // Getting Un-Process Dtl
			WebRowSet ws1 = voObj.getGblWs3(); // Getting Process Dtl
			if (voObj.getStrMsgType().equals("0")) 
			{
				if ((ws != null && ws.size() != 0) || (ws1 != null || ws1.size() != 0)) 
				{
					sb.append("<div id = 'headerid0" + i+ "' style='display:block;'>");
					
					sb.append("<div id = 'detailsdivid0" + i+ "' style='display:block;' class='card'><div class='alert alert-secondary' style='text-align:center'>Processed</div>");
					sb.append("<table  class='table'>");
					sb.append("<thead>");
					sb.append("<tr><th><label class='labelcaps'>Date</label></th>");
					sb.append("<th><label class='labelcaps'>Tariff Name</label></th>");
					sb.append("<th><label class='labelcaps'>Processed Qty</label></th>");
					sb.append("<th><label class='labelcaps'>Discount Amt<label></th>");
					sb.append("<th><label class='labelcaps'>Service Tax Amt</label></th>");
					sb.append("<th><label class='labelcaps'>Penelty Amt</label></th>");
					sb.append("<th><label class='labelcaps'>Net Amt</label></th></tr></thead>");
					if (ws1 != null && ws1.size() > 0) 
					{
						String strQtyUnitId = null;
						String strReqDate = null;
						String strTariffName = null;
						String strProcessQty = null;
						String strDiscAmt = null;
						String strProcessNetAmt = null;
						double strProcessNetAmtDiv = 0;
						String strServcieTaxAmt = null;
						String strPeneltyAmt = null;
						String strProcessGrpId = null;

						for (int j = 0; ws1.next(); j++) 
						{
							strReqDate = ws1.getString(1);
							strTariffName = ws1.getString(4);
							strProcessQty = ws1.getString(5);
							strDiscAmt = ws1.getString(7);
							strProcessNetAmt = ws1.getString(9);
							strServcieTaxAmt = ws1.getString(6);
							strPeneltyAmt = ws1.getString(8);
							strProcessGrpId = ws1.getString(11);
							strProcessNetAmtDiv=Double.parseDouble(strProcessNetAmt);
							boObj.getTariffUnitList(voObj);
						//	strUnitCombo = voObj.getStrValue4();

							if (strQtyUnitId == null || strQtyUnitId.equals(""))
								if (strReqDate == null || strReqDate.equals(""))
									strReqDate = "-----";
							if (strTariffName == null
									|| strTariffName.equals(""))
								strTariffName = "-----";
							if (strProcessQty == null
									|| strProcessQty.equals(""))
								strProcessQty = "-----";
							if (strProcessNetAmt == null || strProcessNetAmt.equals(""))
							{
								strProcessNetAmt = "-----";
								strProcessNetAmtDiv=0;
							}
								
							if (strDiscAmt == null || strDiscAmt.equals(""))
								strDiscAmt = "-----";
							if(strProcessGrpId.equals(strDefaultGrpId) && strProcessNetAmtDiv!=0)
								strProcessNetAmtDiv=strProcessNetAmtDiv*-1;//For Display Only
							
							String[] data2 = ws1.getString(10).split("\\^");

							String strServiceTax = data2[4];
							String strTariffRate = data2[2];
							String strRateUnit = data2[3];
							String strDiscUnit = data2[0];
							String strDiscType = data2[1];
							String strPenelty = data2[5];
							String strUnitName = data2[6];

							String CombineValue = strServiceTax + "^"+ strTariffRate + "^" + strRateUnit + "^"+ strDiscUnit + "^" + strDiscType + "^"+ strPenelty + "^" + strUnitName;

							if (strServiceTax == null || strServiceTax.equals(""))
								strServiceTax = "-----";
							sb.append("<tbody>");
							sb.append("<tr>");
							sb.append("<td>");
							sb.append(strReqDate);
							sb.append("</td>");
							sb.append("<td>");
							sb.append("<a STYLE='cursor:pointer;cursor:hand;color:blue'  name='tarriff' value='' onClick='ProServiceDtl(this,"+ i+ ",\""+ CombineValue+ "\");'>" + strTariffName + "</a>");
							sb.append("</td>");
							sb.append("<td>");
							sb.append(strProcessQty);
							sb.append("</td>");
							sb.append("<td><i class='fas fa-rupee-sign'>&nbsp;</i>");
							sb.append(strDiscAmt);
							sb.append("</td>");

							sb.append("<td><i class='fas fa-rupee-sign'>&nbsp;</i>");
							sb.append(strServcieTaxAmt);
							sb.append("</td>");

							sb.append("<td><i class='fas fa-rupee-sign'>&nbsp;</i>");
							sb.append(strPeneltyAmt);
							sb.append("</td>");

							sb.append("<td name='strProcessNetAmt'><i class='fas fa-rupee-sign'>&nbsp;</i>");
							sb.append(strProcessNetAmtDiv);
							sb.append("</td>");
							sb.append("</tr>");
						}
						sb.append("</tbody></table></div>");
					} else {
						sb.append("<div class='alert alert-danger'>NO RECORD FOUND FOR SELECTED GROUP!...</div>");
					}
					sb.append("<div id = 'headerid1" + i+ "' style='display:block;'>");
					/*
					 * sb.
					 * append("<div class='row newrow' style='margin-left:0;'><input type='hidden' name='button30' value='0'>"
					 * ); sb.append("<img src='../../hisglobal/images/plus.gif'   id='plus30" + i +
					 * "' style='display:block;cursor:pointer;cursor:hand;' onClick='ftn30(" + i +
					 * ")'>"); sb.append("<img src='../../hisglobal/images/minus.gif'  id='minus30"
					 * + i + "' style='display:none;cursor:pointer;cursor:hand;' onClick='ftn30(" +
					 * i + ")'>"); sb.append("</div>");
					 */

					sb.append("<div id = 'detailsdivid1" + i+ "' style='display:block;' class='card'><div class='alert alert-secondary' style='text-align:center'>Unprocessed</div>");
					sb.append("<table class='table'>");
					sb.append("<thead><tr>");
					sb.append("<th>#</th>");
					sb.append("<th><label class='labelcaps'>Req Date</label></th>");
					sb.append("<th><label class='labelcaps'>Tariff Name</label></th>");
					sb.append("<th><label class='labelcaps'> UnProcessed Qty</label></th>");
					sb.append("<th><label class='labelcaps'>Refund Qty</label></th>");
					sb.append("<th><label class='labelcaps'>Unit Name</label></th>");
					sb.append("<th><label class='labelcaps'>Total Amt</label></th></tr></thead><tbody>");
					if (ws != null && ws.size() != 0) {
						// rowSize = ws.size();

						String strQtyUnitId = null;
						String strReqDate = null;
						String strTariffName = null;
						String strUnProcessQty = null;
						String strDiscAmt = null;
						String strNetAmt = null;
						String strUnitCombo = null;
					//	String strSeviceTaxAmt = null;

						for (int j = 0; ws.next(); j++) {
							k++;
							strReqDate = ws.getString(1);
							strTariffName = ws.getString(4);
							strUnProcessQty = ws.getString(5);
					//		strSeviceTaxAmt = ws.getString(6);
							strDiscAmt = ws.getString(7);
							strNetAmt = ws.getString(9);

							if (strQtyUnitId == null || strQtyUnitId.equals(""))
								if (strReqDate == null || strReqDate.equals(""))
									strReqDate = "-----";
							if (strTariffName == null
									|| strTariffName.equals(""))
								strTariffName = "-----";
							if (strUnProcessQty == null
									|| strUnProcessQty.equals(""))
								strUnProcessQty = "-----";
							if (strNetAmt == null || strNetAmt.equals(""))
								strNetAmt = "-----";
							if (strDiscAmt == null || strDiscAmt.equals(""))
								strDiscAmt = "-----";

							String[] data1 = ws.getString(10).split("\\^");

							String strServiceTax = data1[20];
							String strTariffRate = data1[12];
							String strDiscUnit = data1[7];
							String strDiscType = data1[8];
							String strUnitName = data1[21];
							String strRemainedQty = data1[18];
							String strRateBaseVal = data1[19];
							
							String strActTariffRate = data1[16];
							
							String CombineValue = strServiceTax + "^"
									+ strTariffRate + "^" + strDiscUnit + "^"
									+ strDiscType + "^" + strUnitName;

						//	String strTmpRefundQty = strRemainedQty + " "
						//			+ strUnitName;

							String[] data2 = strUnProcessQty.split("\\ ");
							
							double TariffRate = Double.parseDouble(data1[12]);
							double UnProcesQty = Double.parseDouble(data2[0]);
							double UnProcNetAmt = TariffRate * UnProcesQty;
							
							if (strGrpId.equals(BillConfigUtil.GROUP_ID_DEPOSIT)) 
							{
								UnProcNetAmt = -1.0 * UnProcNetAmt;
							}						
							String strUnProcNetAmt = Double.toString(UnProcNetAmt);

							if (strServiceTax == null || strServiceTax.equals(""))
								strServiceTax = "-----";
							if (strTariffRate == null || strTariffRate.equals(""))
								strTariffRate = "-----";
							if (strDiscUnit == null || strDiscUnit.equals(""))
								strDiscUnit = "-----";
							if (strUnitName == null || strUnitName.equals(""))
								strUnitName = "-----";

							strQtyUnitId = data1[14];
							voObj.setStrValue2(data1[14]);
							if (strQtyUnitId != null) 
							{
								//boObj.getTariffUnitList(voObj);
								//strUnitCombo = voObj.getStrValue4();
								strUnitCombo=BillConfigUtil.getDefaultUnitComboWithBaseValue(strQtyUnitId+"^1");
							}							
							sb.append("<input type='hidden' id='strActTariffRate"+ k+ ""+ i+ "' name ='strActTariffRate' disabled='disabled'  value='"+strActTariffRate+"'>");
							sb.append("<input type='hidden' id='strServiceTax"+ k+ ""+ i+ "' name ='strServiceTax' disabled='disabled'  value='"+strServiceTax+"'>");
							sb.append("<input type='hidden' id='strSeviceTaxAmt"+ k+ ""+ i+ "' name ='strSeviceTaxAmt' disabled='disabled'  value='0'>");
							sb.append("<input type='hidden' id='strDiscUnit"+ k + "" + i+ "' name ='strDiscUnit'  value='"+ strDiscUnit + "'>");
							sb.append("<input type='hidden' disabled='disabled' id='strDiscAmt"+ k + "" + i+ "' name ='strDiscAmt'  value='0'>");
							
							sb.append("<input type='hidden' id='strDiscType"+ k + "" + i+ "' name ='strDiscType'  value='"+ strDiscType + "'>");
							sb.append("<input type='hidden' id='strRateBaseVal"+ k + "" + i+ "' name ='strRateBaseVal'  value='"+ strRateBaseVal + "'>");

							sb.append("<input type='hidden' id='strUnProcHiddVal"+ k+ ""+ i+ "' name ='strUnProcHiddVal'  value='"+ ws.getString(10) + "'>");
							sb.append("<input type='hidden' id='strUnProcNetAmt"+ k+ ""+ i+ "'  name ='strUnProcNetAmt'  value='"+ strUnProcNetAmt + "'>");
							sb.append("<input type='hidden' id='strRemainedQty"+ k + "" + i + "'  value='"+ strRemainedQty + "'>");
							// sb.append("<input type='hidden'
							// id='strTmpRefundQty"+k+""+i+"'
							// value='"+strTmpRefundQty+"'>");
							sb.append("<input type='hidden' id='strUnitName"+ k + "" + i + "'  value='" + strUnitName+ "'>");
							sb.append("<input type='hidden' name='strUnProcessQty' id='strUnProcessQty"+ k+ ""+ i+ "'  value='"+ strUnProcessQty + "'>");
							sb.append("<input type='hidden' id='strTariffRate"+ k + "" + i + "'  value='" + strTariffRate+ "'>");
							sb.append("<input type='hidden' name='strReqDate'  value='"+ strReqDate + "'>");
							sb.append("<input type='hidden' name='strUnProcTarriffName'  value='"+ strTariffName + "'>");
							sb.append("<tr>");
							sb.append("<td><input type='hidden' name='chkBoxHidden' value='0' disabled='disabled' id='chkBoxHidden"+k+""+i+"'><input type='checkbox' name='chkBox"+ i+ "' id='chkBox"+ k+ ""+ i+ "' value='" + k + "" + i + "'");

							if (strDefaultGrpId.equals(strGrpId)) 
							{
								sb.append("disabled = 'disabled'");
							}

							sb.append(" onClick='chkBox(" + k + "," + i+ ");'></td>");
							sb.append("</td>");
							sb.append("<td>");
							sb.append(strReqDate);
							sb.append("</td>");
							sb.append("<td>");
							sb.append("<a name='strTarriffName1'  STYLE='cursor:pointer;cursor:hand;color:blue'  value='' onClick='unProcessDtl(this,"+ i+ ",\""+ CombineValue+ "\");'>" + strTariffName + "</a>");
							sb.append("</td>");
							sb.append("<td>");
							sb.append(strUnProcessQty);
							sb.append("</td>");
							sb.append("<td style='width:5%;'>");
							sb.append("<input name='strRefundQty' id='strRefundQty"+ k+ ""+ i+ "'type='text' class='form-control' value='"+ data2[0] + "' onkeypress='return validateData(event,7);'  onKeyUp='onRefundQtyAndUnitChange("+ k+ ","+ i+ ");'    disabled='disabled'>");
							sb.append("</td>");

							sb.append("<td><select name='strUnitCombo' class='browser-default custom-select' id='strUnitCombo"+ k+ ""+ i+ "' onChange='onRefundQtyAndUnitChange("+ k+ ","+ i+ ");' disabled='disabled'>");
							sb.append(strUnitCombo);
							sb.append("</select></td>");

							sb.append("<td>");

							if (strGrpId.trim().equals(BillConfigUtil.GROUP_ID_DEPOSIT)) 
							{								
								sb.append("<i class='fas fa-rupee-sign'>&nbsp;</i><label id='netAmountDivId"+ k+ ""+ i+ "'>"+strUnProcNetAmt+"</label><input name='strNetAmt' type='hidden' id='strNetAmt"+ k+ ""+ i+ "' class='txtFldNormal' value='"+ strUnProcNetAmt+ "' disabled='disabled'>");
							} 
							else 
							{
								sb.append("<i class='fas fa-rupee-sign'>&nbsp;</i><label id='netAmountDivId"+ k+ ""+ i+ "'>0.00</label><input name='strNetAmt' type='hidden' id='strNetAmt"+ k+ ""+ i+ "' class='txtFldNormal' value='0.00' disabled='disabled'>");
							}

							sb.append("<input name='strActualTariffNetAmt' type='hidden' id='strActualTariffNetAmt"+ k+ ""+ i+ "' class='txtFldNormal' value='0.00' disabled='disabled'>");
							
							sb.append("</td>");
							sb.append("</tr>");
						}
						sb.append("</tbody></table>");
						sb.append("<input type='hidden' name ='strChkRcdOpen'  id ='strChkRcdOpen'  value='0'>");
						

						if (!strDefaultGrpId.equals(strGrpId)) 
						{
							sb.append("<div align='center'><button type='button' class='btn btn-primary' style='line-height: 0.8;font-size:0.9rem;display:none;' name='addButton' id='addButton"+ i+ "' value='0'  onclick='addUnProcessDetails("+ i + ");'/>Delete</button>&nbsp;");
							sb.append("<button type='button' class='btn btn-danger'style='line-height: 0.8;font-size:0.9rem;display:none;' onclick='cancelUnProcessDetails("+ i + ");'/>Cancel</button>");
							sb.append("</div>");
						}
					} 
					else 
					{
						sb.append("<div class='alert alert-danger'> NO RECORD FOUND FOR SELECTED GROUP!...</div>");
					}
					
					/*sb.append("</div>");
					sb.append("<div class=\"modal-footer\">");
					sb.append("<button type=\"button\" class=\"btn btn-default\" data-dismiss=\"modal\">Close</button>");
					sb.append("</div>");
					sb.append("</div>");
					sb.append("</div>");
					sb.append("</div>");*/
					
				    
				    
				} 
				else 
				{
					String err = voObj.getStrMsgString();
					sb.append("ERROR####" + err);
				}
			} 
			else 
			{
				String err = voObj.getStrMsgString();
				sb.append("ERROR####" + err);
			}
		} 
		catch (Exception e) 
		{
			throw e;
		}
		return sb.toString();
	}
	
	
	public static String getProcessUnProcessDtl(String strGrpId,
			String strAcctNo, String index, String strHospCode)
			throws Exception {
		BillingVO voObj = new BillingVO();
		BillingBO boObj = new BillingBO();
		voObj.setStrValue1(strGrpId);
		voObj.setStrValue2(strAcctNo);
		voObj.setStrValue3(strHospCode);
		int i = Integer.parseInt(index);
		// int rowSize = 0;
		int k = 0;
		StringBuffer sb = null;

		String strDefaultGrpId = "0";

		sb = new StringBuffer("");

		try 
		{
			strDefaultGrpId = BillConfigUtil.GROUP_ID_DEPOSIT;

			boObj.getProcessUnProcessDtl(voObj);
			boObj.getProcessServiceDtl(voObj);
			WebRowSet ws = voObj.getGblWs2(); // Getting Un-Process Dtl
			WebRowSet ws1 = voObj.getGblWs3(); // Getting Process Dtl
			if (voObj.getStrMsgType().equals("0")) 
			{
				if ((ws != null && ws.size() != 0) || (ws1 != null || ws1.size() != 0)) 
				{
					sb.append("<div id = 'headerid0" + i
							+ "' style='display:block;'>");
					sb.append("<table  class='TABLEWIDTH' align='center' border='0' cellspacing ='1px' cellpadding='1px' >");
					sb.append("<tr><td width='5%' class='TITLE' align='center'><input type='hidden' name='button10' value='0'><input type='hidden' id='rowNo0"
									+ i + "' name='rowNo0'  value='" + i + "'>");
					sb.append("<img src='../../hisglobal/images/plus.gif'   id='plus10"+ i
									+ "' style='display:block;cursor:pointer;cursor:hand;' onClick='ftn10("
									+ i + ")'>");
					sb.append("<img src='../../hisglobal/images/minus.gif'  id='minus10"
									+ i
									+ "' style='display:none;cursor:pointer;cursor:hand;' onClick='ftn10("
									+ i + ")'></td>");
					sb.append("<td width='95%' colspan='9' class='TITLE' align='left'><b>Processed Services</b></td>");
					sb.append("</tr></table></div>");

					sb.append("<div id = 'detailsdivid0" + i
							+ "' style='display:none;'>");
					sb.append("<table  class='TABLEWIDTH' align='center'  border='0' bgcolor='#000000' cellspacing ='1px' cellpadding='1px'>");
					sb.append("<tr><td width='5%' class='multiLabel'>Date</td>");
					sb.append("<td width='12%' class='multiLabel'>TariffName</td>");
					sb.append("<td width='14%' class='multiLabel'>Processed Qty</td>");
					sb.append("<td width='13%' class='multiLabel'>Discount Amt(<img src='../../hisglobal/images/INR.png'>)</td>");
					sb.append("<td width='15%' class='multiLabel'>Service Tax Amt(<img src='../../hisglobal/images/INR.png'>)</td>");
					sb.append("<td width='11%' class='multiLabel'>Penelty Amt(<img src='../../hisglobal/images/INR.png'>)</td>");
					sb.append("<td width='13%' class='multiLabel'>Net Amt(<img src='../../hisglobal/images/INR.png'>)</td></tr>");
					if (ws1 != null && ws1.size() > 0) 
					{
						String strQtyUnitId = null;
						String strReqDate = null;
						String strTariffName = null;
						String strProcessQty = null;
						String strDiscAmt = null;
						String strProcessNetAmt = null;
						double strProcessNetAmtDiv = 0;
						String strServcieTaxAmt = null;
						String strPeneltyAmt = null;
						String strProcessGrpId = null;

						for (int j = 0; ws1.next(); j++) 
						{
							strReqDate = ws1.getString(1);
							strTariffName = ws1.getString(4);
							strProcessQty = ws1.getString(5);
							strDiscAmt = ws1.getString(7);
							strProcessNetAmt = ws1.getString(9);
							strServcieTaxAmt = ws1.getString(6);
							strPeneltyAmt = ws1.getString(8);
							strProcessGrpId = ws1.getString(11);
							strProcessNetAmtDiv=Double.parseDouble(strProcessNetAmt);
							boObj.getTariffUnitList(voObj);
						//	strUnitCombo = voObj.getStrValue4();

							if (strQtyUnitId == null || strQtyUnitId.equals(""))
								if (strReqDate == null || strReqDate.equals(""))
									strReqDate = "-----";
							if (strTariffName == null
									|| strTariffName.equals(""))
								strTariffName = "-----";
							if (strProcessQty == null
									|| strProcessQty.equals(""))
								strProcessQty = "-----";
							if (strProcessNetAmt == null || strProcessNetAmt.equals(""))
							{
								strProcessNetAmt = "-----";
								strProcessNetAmtDiv=0;
							}
								
							if (strDiscAmt == null || strDiscAmt.equals(""))
								strDiscAmt = "-----";
							if(strProcessGrpId.equals(strDefaultGrpId) && strProcessNetAmtDiv!=0)
								strProcessNetAmtDiv=strProcessNetAmtDiv*-1;//For Display Only
							
							String[] data2 = ws1.getString(10).split("\\^");

							String strServiceTax = data2[4];
							String strTariffRate = data2[2];
							String strRateUnit = data2[3];
							String strDiscUnit = data2[0];
							String strDiscType = data2[1];
							String strPenelty = data2[5];
							String strUnitName = data2[6];

							String CombineValue = strServiceTax + "^"+ strTariffRate + "^" + strRateUnit + "^"+ strDiscUnit + "^" + strDiscType + "^"+ strPenelty + "^" + strUnitName;

							if (strServiceTax == null || strServiceTax.equals(""))
								strServiceTax = "-----";

							sb.append("<tr>");
							sb.append("<td width='12%' class='multiControl'>");
							sb.append(strReqDate);
							sb.append("</td>");
							sb.append("<td width='18%' class='multiControl'>");
							sb
									.append("<a STYLE='cursor:pointer;cursor:hand;color:blue'  name='tarriff' value='' onClick='ProServiceDtl(this,"+ i
											+ ",\""
											+ CombineValue
											+ "\");'>" + strTariffName + "</a>");
							sb.append("</td>");
							sb.append("<td width='9%' class='multiControl'>");
							sb.append(strProcessQty);
							sb.append("</td>");
							sb.append("<td width='10%' class='multiControl'>");
							sb.append(strDiscAmt);
							sb.append("</td>");

							sb.append("<td width='10%' class='multiControl'>");
							sb.append(strServcieTaxAmt);
							sb.append("</td>");

							sb.append("<td class='multiControl' width='15%'>");
							sb.append(strPeneltyAmt);
							sb.append("</td>");

							sb.append("<td width='13%' class='multiControl' name='strProcessNetAmt'>");
							sb.append(strProcessNetAmtDiv);
							sb.append("</td>");
							sb.append("</tr>");
						}
						sb.append("</table></div>");
					} else {
						sb
								.append("<table  class='TABLEWIDTH' align='center'  border='0' bgcolor='#000000' cellspacing ='1px'>");
						sb.append("<tr>");
						sb
								.append("<td  width='100%' colspan='10'  CLASS='multiControl' >"
										+ "<DIV class='errMsg' align='center'> NO RECORD FOUND FOR SELECTED GROUP </div>"
										+ "</TD>");

						sb.append("</tr>");
						sb.append("</table></div>");

					}
					sb.append("<div id = 'headerid1" + i
							+ "' style='display:block;'>");
					sb
							.append("<table  class='TABLEWIDTH' align='center' border='0' cellspacing ='1px' cellpadding='1px'>");
					sb
							.append("<tr><td width='5%' class='TITLE' align='center'><input type='hidden' name='button30' value='0'>");
					sb
							.append("<img src='../../hisglobal/images/plus.gif'   id='plus30"
									+ i
									+ "' style='display:block;cursor:pointer;cursor:hand;' onClick='ftn30("
									+ i + ")'>");
					sb
							.append("<img src='../../hisglobal/images/minus.gif'  id='minus30"
									+ i
									+ "' style='display:none;cursor:pointer;cursor:hand;' onClick='ftn30("
									+ i + ")'></td>");
					sb
							.append("<td width='95%' colspan='9' class='TITLE' align='left'><b>Un-Processed Services</b></td>");
					sb.append("</tr></table></div>");

					sb.append("<div id = 'detailsdivid1" + i
							+ "' style='display:none;'>");
					sb
							.append("<table   class='TABLEWIDTH' align='center'  border='0' bgcolor='#000000' cellspacing ='1px' cellpadding='1px'>");
					sb.append("<td width='5%'  class='multiLabel'>#</td>");
					sb
							.append("<td width='12%' class='multiLabel'>ReqDate</td>");
					sb
							.append("<td width='18%' class='multiLabel'>TariffName</td>");
					sb
							.append("<td width='9%'  class='multiLabel'>UnProcessedQty</td>");
					sb
							.append("<td width='10%' class='multiLabel'>RefundQty</td>");
					sb
							.append("<td width='15%' class='multiLabel'>UnitName</td>");
					sb
							.append("<td width='13%' class='multiLabel'>Total Amt(<img src='../../hisglobal/images/INR.png'>)</td>");
					if (ws != null && ws.size() != 0) {
						// rowSize = ws.size();

						String strQtyUnitId = null;
						String strReqDate = null;
						String strTariffName = null;
						String strUnProcessQty = null;
						String strDiscAmt = null;
						String strNetAmt = null;
						String strUnitCombo = null;
					//	String strSeviceTaxAmt = null;

						for (int j = 0; ws.next(); j++) {
							k++;
							strReqDate = ws.getString(1);
							strTariffName = ws.getString(4);
							strUnProcessQty = ws.getString(5);
					//		strSeviceTaxAmt = ws.getString(6);
							strDiscAmt = ws.getString(7);
							strNetAmt = ws.getString(9);

							if (strQtyUnitId == null || strQtyUnitId.equals(""))
								if (strReqDate == null || strReqDate.equals(""))
									strReqDate = "-----";
							if (strTariffName == null
									|| strTariffName.equals(""))
								strTariffName = "-----";
							if (strUnProcessQty == null
									|| strUnProcessQty.equals(""))
								strUnProcessQty = "-----";
							if (strNetAmt == null || strNetAmt.equals(""))
								strNetAmt = "-----";
							if (strDiscAmt == null || strDiscAmt.equals(""))
								strDiscAmt = "-----";

							String[] data1 = ws.getString(10).split("\\^");

							String strServiceTax = data1[20];
							String strTariffRate = data1[12];
							String strDiscUnit = data1[7];
							String strDiscType = data1[8];
							String strUnitName = data1[21];
							String strRemainedQty = data1[18];
							String strRateBaseVal = data1[19];
							
							String strActTariffRate = data1[16];
							
							String CombineValue = strServiceTax + "^"
									+ strTariffRate + "^" + strDiscUnit + "^"
									+ strDiscType + "^" + strUnitName;

						//	String strTmpRefundQty = strRemainedQty + " "
						//			+ strUnitName;

							String[] data2 = strUnProcessQty.split("\\ ");
							
							double TariffRate = Double.parseDouble(data1[12]);
							double UnProcesQty = Double.parseDouble(data2[0]);
							double UnProcNetAmt = TariffRate * UnProcesQty;
							
							if (strGrpId.equals(BillConfigUtil.GROUP_ID_DEPOSIT)) 
							{
								UnProcNetAmt = -1.0 * UnProcNetAmt;
							}						
							String strUnProcNetAmt = Double.toString(UnProcNetAmt);

							if (strServiceTax == null || strServiceTax.equals(""))
								strServiceTax = "-----";
							if (strTariffRate == null || strTariffRate.equals(""))
								strTariffRate = "-----";
							if (strDiscUnit == null || strDiscUnit.equals(""))
								strDiscUnit = "-----";
							if (strUnitName == null || strUnitName.equals(""))
								strUnitName = "-----";

							strQtyUnitId = data1[14];
							voObj.setStrValue2(data1[14]);
							if (strQtyUnitId != null) 
							{
								//boObj.getTariffUnitList(voObj);
								//strUnitCombo = voObj.getStrValue4();
								strUnitCombo=BillConfigUtil.getDefaultUnitComboWithBaseValue(strQtyUnitId+"^1");
							}							
							sb.append("<input type='hidden' id='strActTariffRate"+ k+ ""+ i+ "' name ='strActTariffRate' disabled='disabled'  value='"+strActTariffRate+"'>");
							sb.append("<input type='hidden' id='strServiceTax"+ k+ ""+ i+ "' name ='strServiceTax' disabled='disabled'  value='"+strServiceTax+"'>");
							sb.append("<input type='hidden' id='strSeviceTaxAmt"+ k+ ""+ i+ "' name ='strSeviceTaxAmt' disabled='disabled'  value='0'>");
							sb.append("<input type='hidden' id='strDiscUnit"+ k + "" + i+ "' name ='strDiscUnit'  value='"+ strDiscUnit + "'>");
							sb.append("<input type='hidden' disabled='disabled' id='strDiscAmt"+ k + "" + i+ "' name ='strDiscAmt'  value='0'>");
							
							sb.append("<input type='hidden' id='strDiscType"+ k + "" + i+ "' name ='strDiscType'  value='"+ strDiscType + "'>");
							sb.append("<input type='hidden' id='strRateBaseVal"+ k + "" + i+ "' name ='strRateBaseVal'  value='"+ strRateBaseVal + "'>");

							sb.append("<input type='hidden' id='strUnProcHiddVal"+ k+ ""+ i+ "' name ='strUnProcHiddVal'  value='"+ ws.getString(10) + "'>");
							sb.append("<input type='hidden' id='strUnProcNetAmt"+ k+ ""+ i+ "'  name ='strUnProcNetAmt'  value='"+ strUnProcNetAmt + "'>");
							sb.append("<input type='hidden' id='strRemainedQty"+ k + "" + i + "'  value='"+ strRemainedQty + "'>");
							// sb.append("<input type='hidden'
							// id='strTmpRefundQty"+k+""+i+"'
							// value='"+strTmpRefundQty+"'>");
							sb.append("<input type='hidden' id='strUnitName"+ k + "" + i + "'  value='" + strUnitName+ "'>");
							sb.append("<input type='hidden' name='strUnProcessQty' id='strUnProcessQty"+ k+ ""+ i+ "'  value='"+ strUnProcessQty + "'>");
							sb.append("<input type='hidden' id='strTariffRate"+ k + "" + i + "'  value='" + strTariffRate+ "'>");
							sb.append("<input type='hidden' name='strReqDate'  value='"+ strReqDate + "'>");
							sb.append("<input type='hidden' name='strUnProcTarriffName'  value='"+ strTariffName + "'>");
							sb.append("<tr>");
							sb.append("<td width='5%' class='multiLabel'><input type='hidden' name='chkBoxHidden' value='0' disabled='disabled' id='chkBoxHidden"+k+""+i+"'><input type='checkbox' name='chkBox"+ i+ "' id='chkBox"+ k+ ""+ i+ "' value='" + k + "" + i + "'");

							if (strDefaultGrpId.equals(strGrpId)) 
							{
								sb.append("disabled = 'disabled'");
							}

							sb.append(" onClick='chkBox(" + k + "," + i+ ");'></td>");
							sb.append("</td>");
							sb.append("<td width='12%' class='multiControl'>");
							sb.append(strReqDate);
							sb.append("</td>");
							sb.append("<td width='18%' class='multiControl'>");
							sb.append("<a name='strTarriffName1'  STYLE='cursor:pointer;cursor:hand;color:blue'  value='' onClick='unProcessDtl(this,"+ i+ ",\""+ CombineValue+ "\");'>" + strTariffName + "</a>");
							sb.append("</td>");
							sb.append("<td width='9%' class='multiControl'>");
							sb.append(strUnProcessQty);
							sb.append("</td>");
							sb.append("<td width='10%' class='multiControl'>");
							sb.append("<input name='strRefundQty' id='strRefundQty"+ k+ ""+ i+ "'type='text' class='txtFldMin' value='"+ data2[0] + "' onkeypress='return validateData(event,7);'  onKeyUp='onRefundQtyAndUnitChange("+ k+ ","+ i+ ");'    disabled='disabled'>");
							sb.append("</td>");

							sb.append("<td class='multiControl' width='15%'><select name='strUnitCombo' id='strUnitCombo"+ k+ ""+ i+ "' onChange='onRefundQtyAndUnitChange("+ k+ ","+ i+ ");' disabled='disabled'>");
							sb.append(strUnitCombo);
							sb.append("</select></td>");

							sb.append("<td width='13%' class='multiControl' style='font-weight:bold'>");

							if (strGrpId.trim().equals(BillConfigUtil.GROUP_ID_DEPOSIT)) 
							{								
								sb.append("<div id='netAmountDivId"+ k+ ""+ i+ "'>"+strUnProcNetAmt+"</div><input name='strNetAmt' type='hidden' id='strNetAmt"+ k+ ""+ i+ "' class='txtFldNormal' value='"+ strUnProcNetAmt+ "' disabled='disabled'>");
							} 
							else 
							{
								sb.append("<div id='netAmountDivId"+ k+ ""+ i+ "'>0.00</div><input name='strNetAmt' type='hidden' id='strNetAmt"+ k+ ""+ i+ "' class='txtFldNormal' value='0.00' disabled='disabled'>");
							}

							sb.append("<input name='strActualTariffNetAmt' type='hidden' id='strActualTariffNetAmt"+ k+ ""+ i+ "' class='txtFldNormal' value='0.00' disabled='disabled'>");
							
							sb.append("</td>");
							sb.append("</tr>");
						}
						sb.append("</table>");
						sb.append("<input type='hidden' name ='strChkRcdOpen'  id ='strChkRcdOpen'  value='0'>");
						sb.append("<table  class='TABLEWIDTH' align='center' border='0' bgcolor='#000000' cellspacing ='1px' cellpadding='1px'>");
						sb.append("<td align='center' class='multiControl'>");

						if (!strDefaultGrpId.equals(strGrpId)) 
						{
							sb.append("<img style='cursor:pointer;cursor:hand;' name='addButton' id='addButton"+ i+ "' value='0'  src='../../hisglobal/images/btn-del.png' onclick='addUnProcessDetails("+ i + ");'/>&nbsp;");
							sb.append("<img style='cursor:pointer;cursor:hand;' src='../../hisglobal/images/btn-ccl.png' onclick='cancelUnProcessDetails("+ i + ");'/></td>");
						}
						sb.append("</table>");
					} 
					else 
					{
						sb.append("<table  class='TABLEWIDTH'  align='center'  border='0' bgcolor='#000000' cellspacing ='1px' cellpadding='1px'>");
						sb.append("<tr>");
						sb.append("<td width='100%' CLASS='multiControl' >"+ "<DIV class='errMsg' align='center'> NO RECORD FOUND FOR SELECTED GROUP </div>"+ "</TD>");
						sb.append("</tr>");
						sb.append("</table></div>");
					}
				} 
				else 
				{
					String err = voObj.getStrMsgString();
					sb.append("ERROR####" + err);
				}
			} 
			else 
			{
				String err = voObj.getStrMsgString();
				sb.append("ERROR####" + err);
			}
		} 
		catch (Exception e) 
		{
			throw e;
		}
		return sb.toString();
	}

}
