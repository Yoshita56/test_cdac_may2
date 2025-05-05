/**
 * 
 */
package mms.transactions.controller.hlp;

import hisglobal.utility.HisUtil;

import java.sql.SQLException;

import javax.sql.rowset.WebRowSet;

import mms.transactions.bo.IssueDeskTransBO;
import mms.transactions.controller.fb.IssueDeskTransFB;
import mms.transactions.dao.IssueDeskTransDAO;
import mms.transactions.vo.IssueDeskTransVO;

/**
 * Developer : Anshul Jindal Version : 1.1 Date : 11/June/2009 (Changes)
 * 
 */
/**
 * Developer : Anshul Jindal (To Continue) Version : 1.0 Date : 02/Apr/2009
 * 
 */

public class IssueDeskTransBSHLP {

	static int i = 0;

	/**
	 * This method is used to show item Details on ISSUE PAGE
	 * 
	 * @param wb
	 * @param strItemCategory
	 * @param strHospitalCode
	 * @return
	 */
	public static String getItemDetails_Drug(String strItemCategoryNo,
			String strHospitalCode, WebRowSet wb, String strRaisingStoreId,String strBudgetFlg, String strIssueStoreID)
			throws SQLException {
		StringBuffer br = new StringBuffer();

		IssueDeskTransBO bo = null;
		IssueDeskTransVO vo = null;
		HisUtil hisutil = null;

		String strUnitComboValues = "";

		String strHiddenId = ""; // item id^brandid^RESERVED FLAG^GROUPID^SUBGROUP ID^CONSUMABLE FLAG
									// ^strItemCategory^strRaisingStoreId
	//	String strItemName = "";
		String strBrandName = "";
		String strAvlQty = "";
		String strAvlQtyWithUnitId = "";
		String strAvlQtyBaseVal = "";
		String strBalQty = "";
		String strSancUnitId = "";
		String strSancUnitName = "";
		String strBalQtyBaseVal = "";
		String strReqSancQty;
	//	String strRateBaseVal = "";
	//	String strRate = "";
	//	String strRateUnitId = "";
		String[] temp = null;
		String strReOrderFlg;
		String strApplyClass;
		String strCompSancUnit;
		String strReceivingStoreAvlQty = "";
		String strTotalNoOfBatch = "";
		int i = 0;

		try {
			hisutil = new HisUtil("mms", "IssueDeskTransHLP");
			bo = new IssueDeskTransBO();
			vo = new IssueDeskTransVO();

			vo.setStrHospitalCode(strHospitalCode);
			if (wb.size() != 0) 
			{

				br.append("<table class='table'>");
				while (wb.next()) 
				{
					/*
					 1. Hidden Id
					 2. Genrec Name
					 3. Brand Name
					 4. Avl Qty
					 5. Bal Qty
					 6. Sanc Qty Unit ID
					 7. Unit Name
					 8. Sanc Qty - Issue Qty
					 9. Req / Sanc Qty
					10. Reorder Flag
					11. Unit Id
					12. Rate
					13. Batch No
					14. Rec Store Avl Qty
					15. Total No of batch
					 
					 */
					strHiddenId = wb.getString(1); // item id^brand id
			//		strItemName = wb.getString(2);
					strBrandName = wb.getString(3);
					strAvlQty = wb.getString(4);
					strBalQty = wb.getString(5);
					//System.out.println(strAvlQty);
					//System.out.println(strBalQty);
					if (wb.getString(6) == null) 
					{
						strSancUnitId = "0";
					}
					else 
					{
						strSancUnitId = wb.getString(6);
					}
					strSancUnitName  = wb.getString(7);
					strBalQtyBaseVal = wb.getString(8);
					
					
					strReqSancQty    = wb.getString(9);
					
					
					
					
					strCompSancUnit  = wb.getString(11);  // Adding in Change Request 28-July-2011
					strReceivingStoreAvlQty  = wb.getString(14);
					strTotalNoOfBatch = wb.getString(15);		//added by shalini on 14th Jan 2015 to provide multiple batch selection on issue desk
					
					if (strBalQty.equals("0")) {
						strSancUnitName = " ";
					}
					
					
					if (Integer.parseInt(strTotalNoOfBatch) == 1) { // Item ID ^ ItemBrand Id ^ Batch No ^ StoreID
						vo.setStrSingleItemDtl(strHiddenId.split("\\^")[0]+ "^" + strHiddenId.split("\\^")[1] + "^"+ wb.getString(13) + "^" + strIssueStoreID+ "^"+strItemCategoryNo);
						bo.getSingleBatchItemDtl(vo);
					}
					if (Integer.parseInt(strTotalNoOfBatch) == 0) { // Item ID ^ ItemBrand Id ^ Batch No ^ StoreID
						vo.setStrSingleBatchDtlWs(null);
					}
					
					/*
					 *  Change Color for Re-Order Level
					   //System.out.println("Inside Issue Desk Trans HLP:::::"+wb.getString(10));
					   
					   if(wb.getString(10).equals("0")) 
				       {
				    	 strApplyClass = "Approved";				    	   
				       }
				       else
				       {
				    	 strApplyClass = "NotApproved";    				    	   
				       }
					*/

					//strBalQty = HisUtil.getAmountWithDecimal(strBalQty, 2); // By Amit Kr Date 23-Feb-2011
					////System.out.println("strHiddenId-" + strHiddenId);
					////System.out.println("strItemName-" + strItemName);
					////System.out.println("strBrandName-" + strBrandName);
					////System.out.println("strAvlQty-" + strAvlQty);
					////System.out.println("strBalQty-" + strBalQty);
					////System.out.println("strSancUnitId-" + strSancUnitId);
					////System.out.println("strSancUnitName-" + strSancUnitName);
					////System.out.println("strBalQtyBaseVal-" + strBalQtyBaseVal);
					////System.out.println("strItemCategory-" + strItemCategoryNo);
					////System.out.println("strRate-" + strRate);
					////System.out.println("strRateUnitId-" + strRateUnitId);
					temp = strAvlQty.replace("^", "#").split("#");

					strAvlQty = temp[0];
					strAvlQtyWithUnitId = temp[1];
					strAvlQtyBaseVal = temp[2];
					//System.out.println(strAvlQty+" "+strAvlQtyWithUnitId+" "+strAvlQtyBaseVal);
					vo.setStrSancUnitId(strSancUnitId);
					// Calling BO Method
					bo.getUnitCombo(vo);
                     
					if (vo.getStrMsgType().equals("1")) 
					{
						throw new Exception(vo.getStrMsgString());
					}

					if (vo.getUnitComboWS() != null	&& vo.getUnitComboWS().size() > 0) 
					{
					
						strUnitComboValues = hisutil.getOptionValue(vo.getUnitComboWS(), strCompSancUnit, "", true);
						vo.getUnitComboWS().beforeFirst(); // needed bcoz
															// sometimes it
															// gives invalid
															// cursor position
															// when there is
															// value in heap due
															// to loop
						
					} 
					else 
					{

						strUnitComboValues = "<option value='0'>Select Value</option>";
					}
					if(strBudgetFlg.equals("0"))
					{	
							br.append("<tbody>");
							
							////System.out.println("strStoreId-" + strRaisingStoreId);
							/*
							 * br.append("<TR>"); br .append(" <input type='hidden'
							 * name='strItemDetailsChk' id='strItemDetailsChk" + i + "'
							 * onclick='ClickCheckBox(this,\"" + i + "\");' value= '" +
							 * strHiddenId + "^" + strItemCategoryNo + "^" + strStoreId + "' />
							 * "); br.append(" <input type='hidden' name='flag'
							 * id='flag"+i+"' value=" + "0" + " >");
							 */
		                    
							
							br.append("<td WIDTH='30%' id='td1" + i + "' style='font-weight:350 !important ;font-size: 16px !important;'>");
							br.append(" <input type='hidden' name='strItemDetailsChk' id='strItemDetailsChk"
											+ i
											+ "' value= '"
											+ strHiddenId
											+ "^"
											+ strItemCategoryNo
											+ "^"
											+ strRaisingStoreId + "' /> ");
							br.append(" <input type='hidden' name='flag' id='flag" + i + "' value=" + "0" + " />");
							br.append(" <input type='hidden' name='reOrderFlag' id='reOrderFlag" + i + "' value=" + wb.getString(10) + " />");
							br.append(" <input type='hidden' name='strReceivingStoreAvlQtyChk' id='strReceivingStoreAvlQtyChk" + i + "' value=" + strReceivingStoreAvlQty + " />");
							br.append(" <input type='hidden' name='strAvlQtyForChk' id='strAvlQtyForChk" + i + "' value=" + strAvlQty + " />");
							br.append("<a STYLE='cursor:pointer;cursor:pointer;color:blue' title='Batch Wise Item Details' onClick='showPopUp(this,\""
											+ i + "\");'>" + strBrandName + "</a></td>");
							
							
							br.append("<td width='7%' text-align='center' id='td16"+i+"' style='font-weight:350 !important ;font-size: 16px !important;'>"+wb.getString(16)+" </td>");
						
							br.append("<td width='7%' text-align='center' id='td17"+i+"' style='font-weight:350 !important ;font-size: 16px !important;'>"+strReceivingStoreAvlQty+" </td>");
							
							br.append("<td WIDTH='7%' text-align='center' id='td2" + i + "'   style='font-weight:350 !important ;font-size: 16px !important;'>"
											+ strAvlQty
											+ "<input type='hidden' name='strAvlQty' id='strAvlQty"
											+ i
 											+ "' value='"
											+ strAvlQtyWithUnitId
											+ "' /><input type='hidden' name='strAvlQtyBaseVal' id='strAvlQtyBaseVal"
											+ i + "' value='" + strAvlQtyBaseVal
											+ "' /></td>");
							
							br.append("<input type='hidden' name='strBalQty' id='strBalQty"
											+ i
											+ "' value='"
											+ strBalQty
											+ "' /><input type='hidden' name='strSancUnitId' id='strSancUnitId"
											+ i
											+ "' value='"
											+ strSancUnitId
											+ "' /> <input type='hidden' name='strBalQtyBaseVal' id='strBalQtyBaseVal"
											+ i + "' value='" + strBalQtyBaseVal
											+ "' />");
		                    
							br.append("<td WIDTH='7%'  text-align='center' id='td3" + i + "'   style='font-weight:350 !important ;font-size: 16px !important;'>"+strReqSancQty+"</TD>");
							
							br.append("<td WIDTH='7%' text-align='center' id='td4" + i + "'  style='font-weight:350 !important ;font-size: 16px !important;'><input type='text' autocomplete='off' maxlength='8' onkeypress='return validateData(event,5);' onkeyup='return QtyValidation("
											+ i
											+ ");' name='strIssueQty' id='strIssueQty"
											+ i
											+ "' class='form-control' value='' > </TD>");
							br.append("<input type='hidden' name='strTotalBatch' id='strTotalBatch"
									+ i + "' value='" + strTotalNoOfBatch + "' />");
							br.append("<input type='hidden' name='strTotBatch' id='strTotBatch"
									+ i + "' value='" + strTotalNoOfBatch + "' />");
							if (Integer.parseInt(strTotalNoOfBatch) > 1) 
							{
								br.append("<input type='hidden' name='strSingleManufId'      id='strSingleManufId"
										+ i
										+ "' value='' />");
								br.append("<input type='hidden' name='strSingleProgId'      id='strSingleProgId"
										+ i
										+ "' value='' />");
								br.append("<input type='hidden' name='strSingleBatch'      id='strSingleBatch"+ i + "' value='' />");
								br.append("<input type='hidden' name='strSingleExpiry'     id='strSingleExpiry"+ i + "' value='' />");
								br.append("<input type='hidden' name='strSingleMfgName'    id='strSingleMfgName"+ i + "' value='' />");
								br.append("<input type='hidden' name='strProgrammeName'    id='strProgrammeName"+ i + "' value='' />");
								br.append("<input type='hidden' name='strSingleStockRate'  id='strSingleStockRate"+ i + "' value='' />");
								br.append("<input type='hidden' name='strStockQty'         id='strStockQty"+ i + "' value='' />");
								br.append("<input type='hidden' name='strStockRate'        id='strStockRate"+ i + "' value='' />");
								br.append("<input type='hidden' name='strCheckBatchExists' id='strCheckBatchExists"+ i + "' value='1' />");
								
								br.append("<td WIDTH='7%' text-align='center' id='td9" 
										+ i
										+ "'   style='font-weight:350 !important ;font-size: 16px !important;'><input type='hidden' name='stockDtlsId' id='stockDtlsId"
										+ i
										+ "' value='' />"
										+ "<div name='issueDrugDtl' id='issueDrugDtl"
										+ i
										+ "'></div>"
										+ " <a STYLE='cursor:pointer;cursor:pointer;color:blue'  onClick='callStockDetails(this,\""
										+ i
										+ "\");' TITLE='Click Here For Item Preferences' >auto</td>");
								br.append("<td WIDTH='7%'  text-align='center' id='td8"
										+ i
										+ "' style='font-weight:350 !important ;font-size: 16px !important; text-align:center;'><div name='expDrugDtl' id='expDrugDtl"
										+ i + "'></div></td>");
								
							} 
							else 
							{
								if(vo.getStrSingleBatchDtlWs() != null && vo.getStrSingleBatchDtlWs().size() > 0)
								{
									
										if (vo.getStrSingleBatchDtlWs().next()) 
										{
											/*MMS_MST.get_item_dtl(1,GNUM_HOSPITAL_CODE,HSTNUM_ITEM_ID),
											   Mms_Mst.get_item_dtl(1,GNUM_HOSPITAL_CODE,HSTNUM_ITEMBRAND_ID),
											   HSTSTR_BATCH_NO,
											   NVL(TO_CHAR(HSTDT_MANUF_DATE , ''DD-Mon-yyyy''),'''') ,
											   NVL(TO_CHAR(HSTDT_EXPIRY_DATE, ''Mon/yyyy''),'''') ,
											   NVL(HSTNUM_RATE,0),
											   Mms_Mst.get_stock_dtl() AS AVAL_QTY,
											   MMS_MST.GET_SUPP_DTL(1,'||hosp_code||',HSTNUM_SUPPLIER_ID) as MANUF_NAME,
											   NVL(HSTNUM_RATE,0)||''/''||Mms_Mst.getUnitName(GNUM_HOSPITAL_CODE,
											   HSTNUM_RATE_UNITID) AS Rate_WTHUNIT,
											   HSTNUM_PO_NO,
											   HSTNUM_PROGRAMME_ID,
											   NVL(MMS_MST.GET_PROGRAMME_NAME(1,GNUM_HOSPITAL_CODE,HSTNUM_PROGRAMME_ID),''---''),
											   HSTNUM_SUPPLIER_ID*/
											
											br.append("<input type='hidden' name='strSingleManufId'      id='strSingleManufId"
													+ i
													+ "' value='"
													+ vo.getStrSingleBatchDtlWs().getString(13)
													+ "' />");
											br.append("<input type='hidden' name='strSingleProgId'      id='strSingleProgId"
													+ i
													+ "' value='"
													+ vo.getStrSingleBatchDtlWs().getString(11)
													+ "' />");
											br.append("<input type='hidden' name='strTotBatch' id='strTotBatch"	+ i + "' value='" + strTotalNoOfBatch + "' />");
											br.append("<input type='hidden' name='strStockRate'        id='strStockRate"+ i+ "' value='"+ vo.getStrSingleBatchDtlWs().getString(6)+ "' />");
											br.append("<input type='hidden' name='strStockQty'         id='strStockQty"+ i+ "' value='"+ vo.getStrSingleBatchDtlWs().getString(7).split("\\^")[0] + "' />");
											br.append("<input type='hidden' name='strSingleStockRate'        id='strSingleStockRate"+ i+ "' value='"+ vo.getStrSingleBatchDtlWs().getString(9)+ "' />");
		
											
											
											br.append("<input type='hidden' name='strSingleBatch'      id='strSingleBatch"
													+ i
													+ "' value='"
													+ vo.getStrSingleBatchDtlWs().getString(3)
													+ "' />");
											br.append("<input type='hidden' name='strSingleExpiry'     id='strSingleExpiry"
													+ i
													+ "' value='"
													+ vo.getStrSingleBatchDtlWs().getString(5)
													+ "' />");
											br.append("<input type='hidden' name='strSingleMfgName'     id='strSingleMfgName"
													+ i
													+ "' value='"
													+ vo.getStrSingleBatchDtlWs().getString(8)
													+ "' />");
											br.append("<input type='hidden' name='strProgrammeName'     id='strProgrammeName"
													+ i
													+ "' value='"
													+ vo.getStrSingleBatchDtlWs().getString(12)
													+ "' />");
										
											br.append("<td WIDTH='7%' id='td8"
													+ i
													+ "'  style='font-weight:350 !important ;font-size: 16px !important; text-align:center;' >"
													+ vo.getStrSingleBatchDtlWs().getString(3)
													+ "</td>");
											br.append("<td WIDTH='7%'  id='td9"
													+ i
													+ "'  style='font-weight:350 !important ;font-size: 16px !important; text-align:center;'  >"
													+ ((vo.getStrSingleBatchDtlWs()
															.getString(5) == null || vo
															.getStrSingleBatchDtlWs()
															.getString(5).equals("")) ? "NA"
															: vo.getStrSingleBatchDtlWs()
																	.getString(5)) + "</td>");
										} 
										else 
										{
											
											
											br.append("<input type='hidden' name='strSingleManufId'      id='strSingleManufId"
													+ i
													+ "' value='' />");
											br.append("<input type='hidden' name='strSingleProgId'      id='strSingleProgId"
													+ i
													+ "' value='' />");
											
											br.append("<input type='hidden' name='strTotBatch' id='strTotBatch"	+ i + "' value='" + strTotalNoOfBatch + "' />");
											br.append("<input type='hidden' name='strSingleBatch'      id='strSingleBatch"+ i + "' value='' />");
											br.append("<input type='hidden' name='strSingleExpiry'     id='strSingleExpiry"+ i + "' value='' />");
											br.append("<input type='hidden' name='strSingleMfgName'    id='strSingleMfgName"+ i + "' value='' />");
											br.append("<input type='hidden' name='strProgrammeName'    id='strProgrammeName"+ i + "' value='' />");
											br.append("<input type='hidden' name='strSingleStockRate'  id='strSingleStockRate"+ i + "' value='' />");
											br.append("<input type='hidden' name='strStockQty'         id='strStockQty"+ i + "' value='' />");
											br.append("<input type='hidden' name='strStockRate'        id='strStockRate"+ i + "' value='' />");
											br.append("<TD WIDTH='7%' id='td8"
													+ i
													+ "'  style='font-weight:350 !important ;font-size: 16px !important; text-align:center;' >NA</TD>");
											br.append("<TD WIDTH='7%'  id='td9"
													+ i
													+ "'  style='font-weight:350 !important ;font-size: 16px !important; text-align:center;' >NA</TD>");
										}
										br.append("<input type='hidden' name='strCheckBatchExists'        id='strCheckBatchExists"+ i + "' value='0' />");
										br.append("<input type='hidden' name='stockDtlsId' id='stockDtlsId"
												+ i + "' value='' />");
		
									}
								else 
								{
									
									
									br.append("<input type='hidden' name='strSingleManufId'      id='strSingleManufId"
											+ i
											+ "' value='' />");
									br.append("<input type='hidden' name='strSingleProgId'      id='strSingleProgId"
											+ i
											+ "' value='' />");
									
									br.append("<input type='hidden' name='strTotBatch' id='strTotBatch"	+ i + "' value='" + strTotalNoOfBatch + "' />");
									
									br.append("<input type='hidden' name='strSingleBatch'      id='strSingleBatch"+ i + "' value='' />");
									br.append("<input type='hidden' name='strSingleExpiry'     id='strSingleExpiry"+ i + "' value='' />");
									br.append("<input type='hidden' name='strSingleMfgName'    id='strSingleMfgName"+ i + "' value='' />");
									br.append("<input type='hidden' name='strProgrammeName'    id='strProgrammeName"+ i + "' value='' />");
									br.append("<input type='hidden' name='strSingleStockRate'  id='strSingleStockRate"+ i + "' value='' />");
									br.append("<input type='hidden' name='strStockQty'         id='strStockQty"+ i + "' value='' />");
									br.append("<input type='hidden' name='strStockRate'        id='strStockRate"+ i + "' value='' />");
									br.append("<input type='hidden' name='stockDtlsId' id='stockDtlsId" + i + "' value='' />");
									br.append("<TD WIDTH='7%' id='td8"
											+ i
											+ "' style='font-weight:350 !important ;font-size: 16px !important; text-align:center;' >NA</TD>");
									br.append("<TD WIDTH='7%'  id='td9"
											+ i
											+ "' style='font-weight:350 !important ;font-size: 16px !important; text-align:center;' >NA</TD>");
								}
		
									br.append("<input type='hidden' disabled='disabled' class='form-control form-control-sm'  value='0.00' name='finalCostDivId' id='finalCostDivId"
											+ i + "' >");
									br.append("<input type='hidden' name='strFinalCost' id='strFinalCost"
											+ i + "' value='0.00' />");
							}		
									br.append("<TD WIDTH='7%' id='td5" + i + "'   ><Select name='strIssueUnitId' class='form-control' onChange='return QtyValidation("
													+ i
													+ ");' id='strIssueUnitId"
													+ i
													+ "' >"
													+ strUnitComboValues + "</select></TD>");
				                    					
									br.append("<TD WIDTH='7%' id='td6" + i + "'   >"
													+ "<textarea  class='form-control' style='height:38px;' onkeypress='return validateData(event,9);' name='strItemRemarks' id='strItemRemarks"
													+ i
													+ "' value='' ></textarea></TD>");
				                   
									/*br.append("<TD WIDTH='3%' id='td7" + i + "'   ><input type='hidden' name='stockDtlsId' id='stockDtlsId"
													+ i
													+ "' value='' /> <a STYLE='cursor:pointer;cursor:pointer;color:blue'  onClick='callStockDetails(this,\""+i+ "\");' TITLE='Click Here For Item Preferences' >auto</TD>");*/
									if(strAvlQty.equals("0.00"))
										br.append("<TD WIDTH='7%' style='font-weight:350 !important ;font-size: 16px !important; text-align:center;' id='td8" + i + "'  >"
												+ "<input type='text' class='form-control' maxlength='8' onkeypress='return validateData(event,5);' autocomplete='off' name='strBSQuantity' id='strBSQuantity"
												+ i
												+ "' value='"+strReqSancQty.split(" ")[0]+"' ></TD>");
									else
										br.append("<TD WIDTH='7%' style='font-weight:350 !important ;font-size: 16px !important; text-align:center;' id='td8" + i + "'>"
												+ "<input type='text' class='form-control' maxlength='8' onkeypress='return validateData(event,5);' autocomplete='off' name='strBSQuantity' id='strBSQuantity"
												+ i
												+ "' value='' ></TD>");
									
									br.append("</tbody>");
									br.append("</div>");
									i++;
						   
							
					}
					else
					{
						br.append("<tbody>");
						
						////System.out.println("strStoreId-" + strRaisingStoreId);
						/*
						 * br.append("<TR>"); br .append(" <input type='hidden'
						 * name='strItemDetailsChk' id='strItemDetailsChk" + i + "'
						 * onclick='ClickCheckBox(this,\"" + i + "\");' value= '" +
						 * strHiddenId + "^" + strItemCategoryNo + "^" + strStoreId + "' />
						 * "); br.append(" <input type='hidden' name='flag'
						 * id='flag"+i+"' value=" + "0" + " >");
						 */
	                    
						
						br.append("<TD WIDTH='30%'  style='font-weight:350 !important ;font-size: 16px !important; text-align:left;'id='td1" + i + "'>");
						br.append(" <input type='hidden' name='strItemDetailsChk' id='strItemDetailsChk"
										+ i
										+ "' value= '"
										+ strHiddenId
										+ "^"
										+ strItemCategoryNo
										+ "^"
										+ strRaisingStoreId + "' /> ");
						br.append(" <input type='hidden' name='flag' id='flag" + i + "' value=" + "0" + " />");
						br.append(" <input type='hidden' name='strAvlQtyForChk' id='strAvlQtyForChk" + i + "' value=" + strAvlQty + " />");
						
						br.append(" <input type='hidden' name='reOrderFlag' id='reOrderFlag" + i + "' value=" + wb.getString(10) + " />");
						br.append( strBrandName+"</TD>");
						br.append("<td width='7%' style='font-weight:350 !important ;font-size: 16px !important; text-align:center;' id='td16"+i+"' >"+wb.getString(16)+" </td>");
						br.append("<td width='7%' style='font-weight:350 !important ;font-size: 16px !important; text-align:center;' id='td17"+i+"' >"+strReceivingStoreAvlQty+" </td>");
//						br.append("<a STYLE='cursor:pointer;cursor:pointer;color:blue' title='Batch Wise Item Details' onClick='showPopUp(this,\""
//										+ i + "\");'>" + strBrandName + "</a></TD>");
						
						br.append("<TD WIDTH='7%'  style='font-weight:350 !important ;font-size: 16px !important; text-align:center;' id='td2" + i + "'   >"
										+ strAvlQty	+"/"+strReceivingStoreAvlQty+"<input type='hidden' name='strAvlQty' id='strAvlQty"
										+ i
										+ "' value='"
										+ strAvlQtyWithUnitId
										+ "' /><input type='hidden' name='strAvlQtyBaseVal' id='strAvlQtyBaseVal"
										+ i + "' value='" + strAvlQtyBaseVal
										+ "' /></TD>");
						
						br.append("<input type='hidden' name='strBalQty' id='strBalQty"
										+ i
										+ "' value='"
										+ strBalQty
										+ "' /><input type='hidden' name='strSancUnitId' id='strSancUnitId"
										+ i
										+ "' value='"
										+ strSancUnitId
										+ "' /> <input type='hidden' name='strBalQtyBaseVal' id='strBalQtyBaseVal"
										+ i + "' value='" + strBalQtyBaseVal
										+ "' />");
	                    
						br.append("<TD WIDTH='7%' style='font-weight:350 !important ;font-size: 16px !important; text-align:center;' id='td3" + i + "'   >"+strReqSancQty+"</TD>");
						
	                    
						
						br.append("<TD WIDTH='7%' style='font-weight:350 !important ;font-size: 16px !important; text-align:center;' id='td4" + i + "'  ><input type='text' maxlength='8' onkeypress='return validateData(event,5);' onkeyup='return QtyValidation("
										+ i
										+ ");' name='strIssueQty' id='strIssueQty"  
										+ i
										+ "' class='txtFldMin' value='' > </TD>");
						
						br.append("<TD WIDTH='7%' style='font-weight:350 !important ;font-size: 16px !important; text-align:center;' id='td7"
								+ i
								+ "'  ><input type='text' maxlength='8' onkeypress='return validateData(event,5);' onblur=' ' autocomplete='off' name='strIssueQty' " + "id='strIssueQty"
								+ i + "' class='txtFldMin' value='' > </TD>");

						br.append("<input type='hidden' name='strTotalBatch' id='strTotalBatch"
								+ i + "' value='" + strTotalNoOfBatch + "' />");
						
						br.append("<input type='hidden' name='strTotBatch' id='strTotBatch"	+ i + "' value='" + strTotalNoOfBatch + "' />");

						if (Integer.parseInt(strTotalNoOfBatch) > 1) 
						{
							br.append("<input type='hidden' name='strSingleManufId'      id='strSingleManufId"
									+ i
									+ "' value='' />");
							br.append("<input type='hidden' name='strSingleProgId'      id='strSingleProgId"
									+ i
									+ "' value='' />");
							br.append("<input type='hidden' name='strSingleBatch'      id='strSingleBatch"
									+ i + "' value='' />");
							br.append("<input type='hidden' name='strSingleExpiry'     id='strSingleExpiry"
									+ i + "' value='' />");
							br.append("<input type='hidden' name='strSingleMfgName'     id='strSingleMfgName"
									+ i + "' value='' />");
							br.append("<input type='hidden' name='strProgrammeName'     id='strProgrammeName"
									+ i + "' value='' />");
							br.append("<input type='hidden' name='strSingleStockRate'        id='strSingleStockRate"
									+ i + "' value='' />");
							br.append("<input type='hidden' name='strStockQty'        id='strStockQty"
									+ i + "' value='' />");
							br.append("<input type='hidden' name='strStockRate'        id='strStockRate"
									+ i + "' value='' />");
							br.append("<input type='hidden' name='strCheckBatchExists'        id='strCheckBatchExists"+ i + "' value='1' />");
							br.append("<TD WIDTH='7%' id='td9"
									+ i
									+ "'   ><input type='hidden' name='stockDtlsId' id='stockDtlsId"
									+ i
									+ "' value='' />"
									+ "<div name='issueDrugDtl' id='issueDrugDtl"
									+ i
									+ "'></div>"
									+ " <a STYLE='cursor:pointer;cursor:pointer;color:blue'  onClick='callStockDetails(this,\""
									+ i
									+ "\");' TITLE='Click Here For Item Preferences' >auto</TD>");
							br.append("<TD WIDTH='7%' id='td8"
									+ i
									+ "'  style=\"text-align:center;\" ><div name='expDrugDtl' id='expDrugDtl"
									+ i + "'></div></TD>");
						} else {
							
							if (vo.getStrSingleBatchDtlWs().next()) 
							{
								
								/*MMS_MST.get_item_dtl(1,GNUM_HOSPITAL_CODE,HSTNUM_ITEM_ID),
								   Mms_Mst.get_item_dtl(1,GNUM_HOSPITAL_CODE,HSTNUM_ITEMBRAND_ID),
								   HSTSTR_BATCH_NO,
								   NVL(TO_CHAR(HSTDT_MANUF_DATE , ''DD-Mon-yyyy''),'''') ,
								   NVL(TO_CHAR(HSTDT_EXPIRY_DATE, ''Mon/yyyy''),'''') ,
								   NVL(HSTNUM_RATE,0),
								   Mms_Mst.get_stock_dtl() AS AVAL_QTY,
								   MMS_MST.GET_SUPP_DTL(1,'||hosp_code||',HSTNUM_SUPPLIER_ID) as MANUF_NAME,
								   NVL(HSTNUM_RATE,0)||''/''||Mms_Mst.getUnitName(GNUM_HOSPITAL_CODE,
								   HSTNUM_RATE_UNITID) AS Rate_WTHUNIT,
								   HSTNUM_PO_NO,
								   HSTNUM_PROGRAMME_ID,
								   NVL(MMS_MST.GET_PROGRAMME_NAME(1,GNUM_HOSPITAL_CODE,HSTNUM_PROGRAMME_ID),''---''),
								   HSTNUM_SUPPLIER_ID*/
								
								br.append("<input type='hidden' name='strSingleManufId'      id='strSingleManufId"
										+ i
										+ "' value='"
										+ vo.getStrSingleBatchDtlWs().getString(13)
										+ "' />");
								br.append("<input type='hidden' name='strSingleProgId'      id='strSingleProgId"
										+ i
										+ "' value='"
										+ vo.getStrSingleBatchDtlWs().getString(11)
										+ "' />");
								br.append("<input type='hidden' name='strStockRate'        id='strStockRate"
										+ i
										+ "' value='"
										+ vo.getStrSingleBatchDtlWs().getString(6)
										+ "' />");
								br.append("<input type='hidden' name='strStockQty'         id='strStockQty"
										+ i
										+ "' value='"
										+ vo.getStrSingleBatchDtlWs().getString(7)
												.split("\\^")[0] + "' />");
								br.append("<input type='hidden' name='strSingleStockRate'        id='strSingleStockRate"
										+ i
										+ "' value='"
										+ vo.getStrSingleBatchDtlWs().getString(9)
										+ "' />");

								br.append("<input type='hidden' name='strTotBatch' id='strTotBatch"	+ i + "' value='" + strTotalNoOfBatch + "' />");
								br.append("<input type='hidden' name='strSingleBatch'      id='strSingleBatch"
										+ i
										+ "' value='"
										+ vo.getStrSingleBatchDtlWs().getString(3)
										+ "' />");
								br.append("<input type='hidden' name='strSingleExpiry'     id='strSingleExpiry"
										+ i
										+ "' value='"
										+ vo.getStrSingleBatchDtlWs().getString(5)
										+ "' />");
								br.append("<input type='hidden' name='strSingleMfgName'     id='strSingleMfgName"
										+ i
										+ "' value='"
										+ vo.getStrSingleBatchDtlWs().getString(8)
										+ "' />");
								br.append("<input type='hidden' name='strProgrammeName'     id='strProgrammeName"
										+ i
										+ "' value='"
										+ vo.getStrSingleBatchDtlWs().getString(12)
										+ "' />");

								br.append("<TD WIDTH='9%' id='td8"
										+ i
										+ "'  style=\"text-align:center;\" >"
										+ vo.getStrSingleBatchDtlWs().getString(3)
										+ "</TD>");
								br.append("<TD WIDTH='9%'  id='td9"
										+ i
										+ "'  style=\"text-align:center;\"   >"
										+ ((vo.getStrSingleBatchDtlWs()
												.getString(5) == null || vo
												.getStrSingleBatchDtlWs()
												.getString(5).equals("")) ? "NA"
												: vo.getStrSingleBatchDtlWs()
														.getString(5)) + "</TD>");
							} 
							else 
							{
								br.append("<input type='hidden' name='strSingleManufId'      id='strSingleManufId"
										+ i
										+ "' value='' />");
								br.append("<input type='hidden' name='strSingleProgId'      id='strSingleProgId"
										+ i
										+ "' value='' />");
								br.append("<input type='hidden' name='strTotBatch' id='strTotBatch"	+ i + "' value='" + strTotalNoOfBatch + "' />");
								br.append("<input type='hidden' name='strSingleBatch'      id='strSingleBatch"+ i + "' value='' />");
								br.append("<input type='hidden' name='strSingleExpiry'     id='strSingleExpiry"+ i + "' value='' />");
								br.append("<input type='hidden' name='strSingleMfgName'    id='strSingleMfgName"+ i + "' value='' />");
								br.append("<input type='hidden' name='strProgrammeName'    id='strProgrammeName"+ i + "' value='' />");
								br.append("<input type='hidden' name='strSingleStockRate'  id='strSingleStockRate"+ i + "' value='' />");
								br.append("<input type='hidden' name='strStockQty'         id='strStockQty"+ i + "' value='' />");
								br.append("<input type='hidden' name='strStockRate'        id='strStockRate"+ i + "' value='' />");
								br.append("<TD WIDTH='7%' id='td8"
										+ i
										+ "'  style='font-weight:350 !important ;font-size: 16px !important; text-align:center;' > </TD>");
								br.append("<TD WIDTH='7%'  id='td9"
										+ i
										+ "'  style='font-weight:350 !important ;font-size: 16px !important; text-align:center;' ></TD>");
							}
							br.append("<input type='hidden' name='strCheckBatchExists'        id='strCheckBatchExists"+ i + "' value='0' />");
							br.append("<input type='hidden' name='stockDtlsId' id='stockDtlsId"
									+ i + "' value='' />");

						}
						
						br.append("<input type='hidden' disabled='disabled' class='txtFldNormal'  value='0.00' name='finalCostDivId' id='finalCostDivId"
								+ i + "' >");
						br.append("<input type='hidden' name='strFinalCost' id='strFinalCost"
								+ i + "' value='0.00' />");

	                   
						br.append("<TD WIDTH='7%' style='font-weight:350 !important ;font-size: 16px !important; text-align:center;' id='td5" + i + "'   ><Select name='strIssueUnitId' onChange='return QtyValidation("
										+ i
										+ ");' id='strIssueUnitId"
										+ i
										+ "' >"
										+ strUnitComboValues + "</select></TD>");
						
						/*br.append("<TD WIDTH='3%' id='td8" + i + "'   ><input type='hidden' name='stockDtlsId' id='stockDtlsId"
								+ i
								+ "' value='' /> <a STYLE='cursor:pointer;cursor:pointer;color:blue'  onClick='callStockDetails(this,\""
								+ i + "\");' TITLE='Click Here For Item Preferences' >auto</TD>");*/
	                    					
						
	                   
						br.append("<TD WIDTH='7%' style='font-weight:350 !important ;font-size: 16px !important; text-align:center;' id='td7" + i + "' ><input type='text' disabled='disabled' class='txtFldNormal'  value='0.00' name='finalCostDivId' id='finalCostDivId"+i+"' ></TD>");
						br.append("<input type='hidden' name='strFinalCost' id='strFinalCost"	+ i	+ "' value='0.00' />");
						
						br.append("<TD WIDTH='7%' style='font-weight:350 !important ;font-size: 16px !important; text-align:center;' id='td6" + i + "' >"
								+ "<input type='text' class='txtFldNormal' maxlength='100' onkeypress='return validateData(event,9);' name='strItemRemarks' id='strItemRemarks"
								+ i
								+ "' value='' ></TD>");
						br.append("<TD WIDTH='7%' style='font-weight:350 !important ;font-size: 16px !important; text-align:center;' id='td8" + i + "' >"
								+ "<input type='text' class='txtFldMin' maxlength='8' onkeypress='return validateData(event,5);' autocomplete='off' name='strBSQuantity' id='strBSQuantity"
								+ i
								+ "' value='' ></TD>");
						
						br.append("</tbody>");
						br.append("</div>");
						i++;
					}	
					
				}

				br.append("</table> ");
			} 
			else 
			{
				br.append("<table class='table'>");
				br.append("<tr>");
				br.append("<td   colspan='8' style='font-weight:350 !important ;font-size: 16px !important; text-align:center;'>"
						+ "No Record Found" + "</td>");
				br.append("</tr>");
				br.append("</table> ");
			}

		} catch (Exception e) {
			e.printStackTrace();
			return "ERROR";

		}
        ////System.out.println("O/P String:::::"+br.toString());
		return br.toString();
	}
	public static String getItemDetails_Item(String strItemCategoryNo,
			String strHospitalCode, WebRowSet wb, String strRaisingStoreId,String strBudgetFlg, String strIssueStoreID)
			throws SQLException {
		StringBuffer br = new StringBuffer();

		IssueDeskTransBO bo = null;
		IssueDeskTransVO vo = null;
		HisUtil hisutil = null;

		String strUnitComboValues = "";

		String strHiddenId = ""; // item id^brandid^RESERVED FLAG^GROUPID^SUBGROUP ID^CONSUMABLE FLAG
									// ^strItemCategory^strRaisingStoreId
	//	String strItemName = "";
		String strBrandName = "";
		String strAvlQty = "";
		String strAvlQtyWithUnitId = "";
		String strAvlQtyBaseVal = "";
		String strBalQty = "";
		String strSancUnitId = "";
		String strSancUnitName = "";
		String strBalQtyBaseVal = "";
		String strReqSancQty;
	//	String strRateBaseVal = "";
	//	String strRate = "";
	//	String strRateUnitId = "";
		String[] temp = null;
		String strReOrderFlg;
		String strApplyClass;
		String strCompSancUnit;
		String strReceivingStoreAvlQty = "";
		String strTotalNoOfBatch = "";
		int i = 0;

		try {
			hisutil = new HisUtil("mms", "IssueDeskTransHLP");
			bo = new IssueDeskTransBO();
			vo = new IssueDeskTransVO();

			vo.setStrHospitalCode(strHospitalCode);
			if (wb.size() != 0) 
			{

				br.append("<table class='TABLEWIDTH' bgcolor='#6097BC' align='center'cellpadding='1px' cellspacing='1px'>");
				
				while (wb.next()) 
				{
					/*
					 1. Hidden Id
					 2. Genrec Name
					 3. Brand Name
					 4. Avl Qty
					 5. Bal Qty
					 6. Sanc Qty Unit ID
					 7. Unit Name
					 8. Sanc Qty - Issue Qty
					 9. Req / Sanc Qty
					10. Reorder Flag
					11. Unit Id
					12. Rate
					13. Batch No
					14. Rec Store Avl Qty
					15. Total No of batch
					 
					 */
					strHiddenId = wb.getString(1); // item id^brand id
			//		strItemName = wb.getString(2);
					strBrandName = wb.getString(3);
					strAvlQty = wb.getString(4);
					strBalQty = wb.getString(5);
					//System.out.println(strAvlQty);
					//System.out.println(strBalQty);
					if (wb.getString(6) == null) 
					{
						strSancUnitId = "0";
					}
					else 
					{
						strSancUnitId = wb.getString(6);
					}
					strSancUnitName  = wb.getString(7);
					strBalQtyBaseVal = wb.getString(8);
					
					
					strReqSancQty    = wb.getString(9);
					
					
					
					
					strCompSancUnit  = wb.getString(11);  // Adding in Change Request 28-July-2011
					strReceivingStoreAvlQty  = wb.getString(14);
					strTotalNoOfBatch = wb.getString(15);		//added by shalini on 14th Jan 2015 to provide multiple batch selection on issue desk
					
					if (strBalQty.equals("0")) {
						strSancUnitName = " ";
					}
					
					
					if (Integer.parseInt(strTotalNoOfBatch) == 1) { // Item ID ^ ItemBrand Id ^ Batch No ^ StoreID
						vo.setStrSingleItemDtl(strHiddenId.split("\\^")[0]+ "^" + strHiddenId.split("\\^")[1] + "^"+ wb.getString(13) + "^" + strIssueStoreID + "^"+strItemCategoryNo);
						bo.getSingleBatchItemDtl(vo);
					}
					if (Integer.parseInt(strTotalNoOfBatch) == 0) { // Item ID ^ ItemBrand Id ^ Batch No ^ StoreID
						vo.setStrSingleBatchDtlWs(null);
					}
					
					/*
					 *  Change Color for Re-Order Level
					   //System.out.println("Inside Issue Desk Trans HLP:::::"+wb.getString(10));
					   
					   if(wb.getString(10).equals("0")) 
				       {
				    	 strApplyClass = "Approved";				    	   
				       }
				       else
				       {
				    	 strApplyClass = "NotApproved";    				    	   
				       }
					*/

					//strBalQty = HisUtil.getAmountWithDecimal(strBalQty, 2); // By Amit Kr Date 23-Feb-2011
					////System.out.println("strHiddenId-" + strHiddenId);
					////System.out.println("strItemName-" + strItemName);
					////System.out.println("strBrandName-" + strBrandName);
					////System.out.println("strAvlQty-" + strAvlQty);
					////System.out.println("strBalQty-" + strBalQty);
					////System.out.println("strSancUnitId-" + strSancUnitId);
					////System.out.println("strSancUnitName-" + strSancUnitName);
					////System.out.println("strBalQtyBaseVal-" + strBalQtyBaseVal);
					////System.out.println("strItemCategory-" + strItemCategoryNo);
					////System.out.println("strRate-" + strRate);
					////System.out.println("strRateUnitId-" + strRateUnitId);
					temp = strAvlQty.replace("^", "#").split("#");

					strAvlQty = temp[0];
					strAvlQtyWithUnitId = temp[1];
					strAvlQtyBaseVal = temp[2];
					//System.out.println(strAvlQty+" "+strAvlQtyWithUnitId+" "+strAvlQtyBaseVal);
					vo.setStrSancUnitId(strSancUnitId);
					// Calling BO Method
					bo.getUnitCombo(vo);
                     
					if (vo.getStrMsgType().equals("1")) 
					{
						throw new Exception(vo.getStrMsgString());
					}

					if (vo.getUnitComboWS() != null	&& vo.getUnitComboWS().size() > 0) 
					{
					
						strUnitComboValues = hisutil.getOptionValue(vo.getUnitComboWS(), strCompSancUnit, "", true);
						vo.getUnitComboWS().beforeFirst(); // needed bcoz
															// sometimes it
															// gives invalid
															// cursor position
															// when there is
															// value in heap due
															// to loop
						
					} 
					else 
					{

						strUnitComboValues = "<option value='0'>Select Value</option>";
					}
					if(strBudgetFlg.equals("0"))
					{	
							br.append("<TR>");
							
							////System.out.println("strStoreId-" + strRaisingStoreId);
							/*
							 * br.append("<TR>"); br .append(" <input type='hidden'
							 * name='strItemDetailsChk' id='strItemDetailsChk" + i + "'
							 * onclick='ClickCheckBox(this,\"" + i + "\");' value= '" +
							 * strHiddenId + "^" + strItemCategoryNo + "^" + strStoreId + "' />
							 * "); br.append(" <input type='hidden' name='flag'
							 * id='flag"+i+"' value=" + "0" + " >");
							 */
		                    
							
							br.append("<TD WIDTH='30%' id='td1" + i + "'   >");
							br.append(" <input type='hidden' name='strItemDetailsChk' id='strItemDetailsChk"
											+ i
											+ "' value= '"
											+ strHiddenId
											+ "^"
											+ strItemCategoryNo
											+ "^"
											+ strRaisingStoreId + "' /> ");
							br.append(" <input type='hidden' name='flag' id='flag" + i + "' value=" + "0" + " />");
							
							
							
							br.append(" <input type='hidden' name='reOrderFlag' id='reOrderFlag" + i + "' value=" + wb.getString(10) + " />");
							br.append(" <input type='hidden' name='strAvlQtyForChk' id='strAvlQtyForChk" + i + "' value=" + strAvlQty + " />");
							
							br.append("<a STYLE='cursor:pointer;cursor:pointer;color:blue' title='Batch Wise Item Details' onClick='showPopUp(this,\""
											+ i + "\");'>" + strBrandName + "</a></TD>");
							
							br.append("<TD WIDTH='10%' id='td2" + i + "'   >"
											+ strAvlQty
											+ "<input type='hidden' name='strAvlQty' id='strAvlQty"
											+ i
 											+ "' value='"
											+ strAvlQtyWithUnitId
											+ "' /><input type='hidden' name='strAvlQtyBaseVal' id='strAvlQtyBaseVal"
											+ i + "' value='" + strAvlQtyBaseVal
											+ "' /></TD>");
							
							br.append("<input type='hidden' name='strBalQty' id='strBalQty"
											+ i
											+ "' value='"
											+ strBalQty
											+ "' /><input type='hidden' name='strSancUnitId' id='strSancUnitId"
											+ i
											+ "' value='"
											+ strSancUnitId
											+ "' /> <input type='hidden' name='strBalQtyBaseVal' id='strBalQtyBaseVal"
											+ i + "' value='" + strBalQtyBaseVal
											+ "' />");
		                    
							br.append("<TD WIDTH='10%' id='td3" + i + "'   >"+strReqSancQty+"</TD>");
							
		                    
							
							br.append("<TD WIDTH='8%' id='td4" + i + "'  ><input type='text' autocomplete='off' maxlength='8' onkeypress='return validateData(event,5);' onkeyup='return QtyValidation("
											+ i
											+ ");' name='strIssueQty' id='strIssueQty"
											+ i
											+ "' class='txtFldMin' value='' > </TD>");
							
							br.append("<input type='hidden' name='strTotalBatch' id='strTotalBatch"
									+ i + "' value='" + strTotalNoOfBatch + "' />");
							
							br.append("<input type='hidden' name='strTotBatch' id='strTotBatch"
									+ i + "' value='" + strTotalNoOfBatch + "' />");

							if (Integer.parseInt(strTotalNoOfBatch) > 1) 
							{
								br.append("<input type='hidden' name='strSingleManufId'      id='strSingleManufId"
										+ i
										+ "' value='' />");
								
								
								br.append("<input type='hidden' name='strSingleProgId'      id='strSingleProgId"
										+ i
										+ "' value='' />");
								br.append("<input type='hidden' name='strSingleBatch'      id='strSingleBatch"+ i + "' value='' />");
								br.append("<input type='hidden' name='strSingleExpiry'     id='strSingleExpiry"+ i + "' value='' />");
								br.append("<input type='hidden' name='strSingleMfgName'    id='strSingleMfgName"+ i + "' value='' />");
								br.append("<input type='hidden' name='strProgrammeName'    id='strProgrammeName"+ i + "' value='' />");
								br.append("<input type='hidden' name='strSingleStockRate'  id='strSingleStockRate"+ i + "' value='' />");
								br.append("<input type='hidden' name='strStockQty'         id='strStockQty"+ i + "' value='' />");
								br.append("<input type='hidden' name='strStockRate'        id='strStockRate"+ i + "' value='' />");
								br.append("<input type='hidden' name='strCheckBatchExists' id='strCheckBatchExists"+ i + "' value='1' />");
								br.append("<input type='hidden' name='strFinalCost' id='strFinalCost"+ i + "' value='0.00' />");
								br.append("<TD WIDTH='9%' id='td9"
										+ i
										+ "'   ><input type='hidden' name='stockDtlsId' id='stockDtlsId"
										+ i
										+ "' value='' />"
										+ "<div name='issueDrugDtl' id='issueDrugDtl"
										+ i
										+ "'></div>"
										+ " <a STYLE='cursor:pointer;cursor:pointer;color:blue'  onClick='callStockDetails(this,\""
										+ i
										+ "\");' TITLE='Click Here For Item Preferences' >auto</TD>");
								br.append("<TD WIDTH='9%' id='td8"
										+ i
										+ "'  style=\"text-align:center;\" ><div name='expDrugDtl' id='expDrugDtl"
										+ i + "'></div></TD>");
								
							} 
							else 
							{
								if(vo.getStrSingleBatchDtlWs() != null && vo.getStrSingleBatchDtlWs().size() > 0)
								{
									
										if (vo.getStrSingleBatchDtlWs().next()) 
										{
											/*MMS_MST.get_item_dtl(1,GNUM_HOSPITAL_CODE,HSTNUM_ITEM_ID),
											   Mms_Mst.get_item_dtl(1,GNUM_HOSPITAL_CODE,HSTNUM_ITEMBRAND_ID),
											   HSTSTR_BATCH_NO,
											   NVL(TO_CHAR(HSTDT_MANUF_DATE , ''DD-Mon-yyyy''),'''') ,
											   NVL(TO_CHAR(HSTDT_EXPIRY_DATE, ''Mon/yyyy''),'''') ,
											   NVL(HSTNUM_RATE,0),
											   Mms_Mst.get_stock_dtl() AS AVAL_QTY,
											   MMS_MST.GET_SUPP_DTL(1,'||hosp_code||',HSTNUM_SUPPLIER_ID) as MANUF_NAME,
											   NVL(HSTNUM_RATE,0)||''/''||Mms_Mst.getUnitName(GNUM_HOSPITAL_CODE,
											   HSTNUM_RATE_UNITID) AS Rate_WTHUNIT,
											   HSTNUM_PO_NO,
											   HSTNUM_PROGRAMME_ID,
											   NVL(MMS_MST.GET_PROGRAMME_NAME(1,GNUM_HOSPITAL_CODE,HSTNUM_PROGRAMME_ID),''---''),
											   HSTNUM_SUPPLIER_ID*/
											
											br.append("<input type='hidden' name='strSingleManufId'      id='strSingleManufId"
													+ i
													+ "' value='"
													+ vo.getStrSingleBatchDtlWs().getString(13)
													+ "' />");
											br.append("<input type='hidden' name='strSingleProgId'      id='strSingleProgId"
													+ i
													+ "' value='"
													+ vo.getStrSingleBatchDtlWs().getString(11)
													+ "' />");
											br.append("<input type='hidden' name='strTotBatch' id='strTotBatch"	+ i + "' value='" + strTotalNoOfBatch + "' />");
											br.append("<input type='hidden' name='strStockRate'        id='strStockRate"+ i+ "' value='"+ vo.getStrSingleBatchDtlWs().getString(6)+ "' />");
											br.append("<input type='hidden' name='strStockQty'         id='strStockQty"+ i+ "' value='"+ vo.getStrSingleBatchDtlWs().getString(7).split("\\^")[0] + "' />");
											br.append("<input type='hidden' name='strSingleStockRate'        id='strSingleStockRate"+ i+ "' value='"+ vo.getStrSingleBatchDtlWs().getString(9)+ "' />");
		
											
											
											br.append("<input type='hidden' name='strSingleBatch'      id='strSingleBatch"
													+ i
													+ "' value='"
													+ vo.getStrSingleBatchDtlWs().getString(3)
													+ "' />");
											br.append("<input type='hidden' name='strSingleExpiry'     id='strSingleExpiry"
													+ i
													+ "' value='"
													+ vo.getStrSingleBatchDtlWs().getString(5)
													+ "' />");
											br.append("<input type='hidden' name='strSingleMfgName'     id='strSingleMfgName"
													+ i
													+ "' value='"
													+ vo.getStrSingleBatchDtlWs().getString(8)
													+ "' />");
											br.append("<input type='hidden' name='strProgrammeName'     id='strProgrammeName"
													+ i
													+ "' value='"
													+ vo.getStrSingleBatchDtlWs().getString(12)
													+ "' />");
											br.append("<TD WIDTH='9%' id='td8"
													+ i
													+ "'  style=\"text-align:center;\" >"
													+ vo.getStrSingleBatchDtlWs().getString(3)
													+ "</TD>");
											br.append("<TD WIDTH='9%'  id='td9"
													+ i
													+ "'  style=\"text-align:center;\"   >"
													+ ((vo.getStrSingleBatchDtlWs()
															.getString(5) == null || vo
															.getStrSingleBatchDtlWs()
															.getString(5).equals("")) ? "NA"
															: vo.getStrSingleBatchDtlWs()
																	.getString(5)) + "</TD>");
										} 
										else 
										{
											
											
											br.append("<input type='hidden' name='strSingleManufId'      id='strSingleManufId"
													+ i
													+ "' value='' />");
											br.append("<input type='hidden' name='strSingleProgId'      id='strSingleProgId"
													+ i
													+ "' value='' />");
											
											br.append("<input type='hidden' name='strTotBatch' id='strTotBatch"	+ i + "' value='" + strTotalNoOfBatch + "' />");
											
											br.append("<input type='hidden' name='strSingleBatch'      id='strSingleBatch"+ i + "' value='' />");
											br.append("<input type='hidden' name='strSingleExpiry'     id='strSingleExpiry"+ i + "' value='' />");
											br.append("<input type='hidden' name='strSingleMfgName'    id='strSingleMfgName"+ i + "' value='' />");
											br.append("<input type='hidden' name='strProgrammeName'    id='strProgrammeName"+ i + "' value='' />");
											br.append("<input type='hidden' name='strSingleStockRate'  id='strSingleStockRate"+ i + "' value='' />");
											br.append("<input type='hidden' name='strStockQty'         id='strStockQty"+ i + "' value='' />");
											br.append("<input type='hidden' name='strStockRate'        id='strStockRate"+ i + "' value='' />");
											br.append("<TD WIDTH='8%' id='td8"
													+ i
													+ "'  style=\"text-align:center;\" > </TD>");
											br.append("<TD WIDTH='9%'  id='td9"
													+ i
													+ "'  style=\"text-align:center;\" ></TD>");
										}
										br.append("<input type='hidden' name='strCheckBatchExists'        id='strCheckBatchExists"+ i + "' value='0' />");
										br.append("<input type='hidden' name='stockDtlsId' id='stockDtlsId"
												+ i + "' value='' />");
		
									}
								else 
								{
									
									
									br.append("<input type='hidden' name='strSingleManufId'      id='strSingleManufId"
											+ i
											+ "' value='' />");
									br.append("<input type='hidden' name='strSingleProgId'      id='strSingleProgId"
											+ i
											+ "' value='' />");
									
									br.append("<input type='hidden' name='strTotBatch' id='strTotBatch"	+ i + "' value='" + strTotalNoOfBatch + "' />");
									
									br.append("<input type='hidden' name='strSingleBatch'      id='strSingleBatch"+ i + "' value='' />");
									br.append("<input type='hidden' name='strSingleExpiry'     id='strSingleExpiry"+ i + "' value='' />");
									br.append("<input type='hidden' name='strSingleMfgName'    id='strSingleMfgName"+ i + "' value='' />");
									br.append("<input type='hidden' name='strProgrammeName'    id='strProgrammeName"+ i + "' value='' />");
									br.append("<input type='hidden' name='strSingleStockRate'  id='strSingleStockRate"+ i + "' value='' />");
									br.append("<input type='hidden' name='strStockQty'         id='strStockQty"+ i + "' value='' />");
									br.append("<input type='hidden' name='strStockRate'        id='strStockRate"+ i + "' value='' />");
									br.append("<input type='hidden' name='stockDtlsId' id='stockDtlsId" + i + "' value='' />");
									br.append("<TD WIDTH='9%' id='td8"
											+ i
											+ "'  style=\"text-align:center;\" >NA</TD>");
									br.append("<TD WIDTH='9%'  id='td9"
											+ i
											+ "'  style=\"text-align:center;\" >NA</TD>");
								}
		
									br.append("<input type='hidden' disabled='disabled' class='txtFldNormal'  value='0.00' name='finalCostDivId' id='finalCostDivId"
											+ i + "' >");
									br.append("<input type='hidden' name='strFinalCost' id='strFinalCost"
											+ i + "' value='0.00' />");
							}		
									br.append("<TD WIDTH='7%' id='td5" + i + "'   ><Select name='strIssueUnitId' onChange='return QtyValidation("
													+ i
													+ ");' id='strIssueUnitId"
													+ i
													+ "' >"
													+ strUnitComboValues + "</select></TD>");
				                    					
									br.append("<TD WIDTH='10%' id='td6" + i + "'   >"
													+ "<textarea  class='txtFldMin' size = '100' maxlength='500' onkeypress='return validateData(event,9);' name='strItemRemarks' id='strItemRemarks"
													+ i
													+ "' value='' ></textarea></TD>");
				                   
									/*br.append("<TD WIDTH='3%' id='td7" + i + "'   ><input type='hidden' name='stockDtlsId' id='stockDtlsId"
													+ i
													+ "' value='' /> <a STYLE='cursor:pointer;cursor:pointer;color:blue'  onClick='callStockDetails(this,\""+i+ "\");' TITLE='Click Here For Item Preferences' >auto</TD>");*/
									if(strAvlQty.equals("0.00"))
										br.append("<TD WIDTH='10%' id='td8" + i + "' >"
												+ "<input type='text' class='txtFldMin' maxlength='8' onkeypress='return validateData(event,5);' autocomplete='off' name='strBSQuantity' id='strBSQuantity"
												+ i
												+ "' value='"+strReqSancQty.split(" ")[0]+"' ></TD>");
									else
										br.append("<TD WIDTH='10%' id='td8" + i + "' >"
												+ "<input type='text' class='txtFldMin' maxlength='8' onkeypress='return validateData(event,5);' autocomplete='off' name='strBSQuantity' id='strBSQuantity"
												+ i
												+ "' value='' ></TD>");
									
									br.append("</TR>");
									br.append("</div>");
									i++;
						   
							
					}
					else
					{
						br.append("<TR>");
						
						////System.out.println("strStoreId-" + strRaisingStoreId);
						/*
						 * br.append("<TR>"); br .append(" <input type='hidden'
						 * name='strItemDetailsChk' id='strItemDetailsChk" + i + "'
						 * onclick='ClickCheckBox(this,\"" + i + "\");' value= '" +
						 * strHiddenId + "^" + strItemCategoryNo + "^" + strStoreId + "' />
						 * "); br.append(" <input type='hidden' name='flag'
						 * id='flag"+i+"' value=" + "0" + " >");
						 */
	                    
						
						br.append("<TD WIDTH='28%' id='td1" + i + "'   style=\"text-align:left;\">");
						br.append(" <input type='hidden' name='strItemDetailsChk' id='strItemDetailsChk"
										+ i
										+ "' value= '"
										+ strHiddenId
										+ "^"
										+ strItemCategoryNo
										+ "^"
										+ strRaisingStoreId + "' /> ");
						br.append(" <input type='hidden' name='flag' id='flag" + i + "' value=" + "0" + " />");
						br.append(" <input type='hidden' name='strAvlQtyForChk' id='strAvlQtyForChk" + i + "' value=" + strAvlQty + " />");
						
						br.append(" <input type='hidden' name='reOrderFlag' id='reOrderFlag" + i + "' value=" + wb.getString(10) + " />");
						br.append( strBrandName+"</TD>");
						
//						br.append("<a STYLE='cursor:pointer;cursor:pointer;color:blue' title='Batch Wise Item Details' onClick='showPopUp(this,\""
//										+ i + "\");'>" + strBrandName + "</a></TD>");
						
						br.append("<TD WIDTH='13%' id='td2" + i + "'   >"
										+ strAvlQty	+"/"+strReceivingStoreAvlQty+"<input type='hidden' name='strAvlQty' id='strAvlQty"
										+ i
										+ "' value='"
										+ strAvlQtyWithUnitId
										+ "' /><input type='hidden' name='strAvlQtyBaseVal' id='strAvlQtyBaseVal"
										+ i + "' value='" + strAvlQtyBaseVal
										+ "' /></TD>");
						
						br.append("<input type='hidden' name='strBalQty' id='strBalQty"
										+ i
										+ "' value='"
										+ strBalQty
										+ "' /><input type='hidden' name='strSancUnitId' id='strSancUnitId"
										+ i
										+ "' value='"
										+ strSancUnitId
										+ "' /> <input type='hidden' name='strBalQtyBaseVal' id='strBalQtyBaseVal"
										+ i + "' value='" + strBalQtyBaseVal
										+ "' />");
	                    
						br.append("<TD WIDTH='15%' id='td3" + i + "'   >"+strReqSancQty+"</TD>");
						
	                    
						
						br.append("<TD WIDTH='10%' id='td4" + i + "'  ><input type='text' maxlength='8' onkeypress='return validateData(event,5);' onkeyup='return QtyValidation("
										+ i
										+ ");' name='strIssueQty' id='strIssueQty"  
										+ i
										+ "' class='txtFldMin' value='' > </TD>");
						
						br.append("<TD WIDTH='9%' id='td7"
								+ i
								+ "'  ><input type='text' maxlength='8' onkeypress='return validateData(event,5);' onblur=' ' autocomplete='off' name='strIssueQty' " + "id='strIssueQty"
								+ i + "' class='txtFldMin' value='' > </TD>");

						br.append("<input type='hidden' name='strTotalBatch' id='strTotalBatch"
								+ i + "' value='" + strTotalNoOfBatch + "' />");
						
						br.append("<input type='hidden' name='strTotBatch' id='strTotBatch"	+ i + "' value='" + strTotalNoOfBatch + "' />");

						if (Integer.parseInt(strTotalNoOfBatch) > 1) 
						{
							br.append("<input type='hidden' name='strSingleManufId'      id='strSingleManufId"
									+ i
									+ "' value='' />");
							br.append("<input type='hidden' name='strSingleProgId'      id='strSingleProgId"
									+ i
									+ "' value='' />");
							br.append("<input type='hidden' name='strSingleBatch'      id='strSingleBatch"
									+ i + "' value='' />");
							br.append("<input type='hidden' name='strSingleExpiry'     id='strSingleExpiry"
									+ i + "' value='' />");
							br.append("<input type='hidden' name='strSingleMfgName'     id='strSingleMfgName"
									+ i + "' value='' />");
							br.append("<input type='hidden' name='strProgrammeName'     id='strProgrammeName"
									+ i + "' value='' />");
							br.append("<input type='hidden' name='strSingleStockRate'        id='strSingleStockRate"
									+ i + "' value='' />");
							br.append("<input type='hidden' name='strStockQty'        id='strStockQty"
									+ i + "' value='' />");
							br.append("<input type='hidden' name='strStockRate'        id='strStockRate"
									+ i + "' value='' />");
							br.append("<input type='hidden' name='strCheckBatchExists'        id='strCheckBatchExists"+ i + "' value='1' />");
							br.append("<TD WIDTH='9%' id='td9"
									+ i
									+ "'   ><input type='hidden' name='stockDtlsId' id='stockDtlsId"
									+ i
									+ "' value='' />"
									+ "<div name='issueDrugDtl' id='issueDrugDtl"
									+ i
									+ "'></div>"
									+ " <a STYLE='cursor:pointer;cursor:pointer;color:blue'  onClick='callStockDetails(this,\""
									+ i
									+ "\");' TITLE='Click Here For Item Preferences' >auto</TD>");
							br.append("<TD WIDTH='9%' id='td8"
									+ i
									+ "'  style=\"text-align:center;\" ><div name='expDrugDtl' id='expDrugDtl"
									+ i + "'></div></TD>");
						} else {
							
							if (vo.getStrSingleBatchDtlWs().next()) 
							{
								
								/*MMS_MST.get_item_dtl(1,GNUM_HOSPITAL_CODE,HSTNUM_ITEM_ID),
								   Mms_Mst.get_item_dtl(1,GNUM_HOSPITAL_CODE,HSTNUM_ITEMBRAND_ID),
								   HSTSTR_BATCH_NO,
								   NVL(TO_CHAR(HSTDT_MANUF_DATE , ''DD-Mon-yyyy''),'''') ,
								   NVL(TO_CHAR(HSTDT_EXPIRY_DATE, ''Mon/yyyy''),'''') ,
								   NVL(HSTNUM_RATE,0),
								   Mms_Mst.get_stock_dtl() AS AVAL_QTY,
								   MMS_MST.GET_SUPP_DTL(1,'||hosp_code||',HSTNUM_SUPPLIER_ID) as MANUF_NAME,
								   NVL(HSTNUM_RATE,0)||''/''||Mms_Mst.getUnitName(GNUM_HOSPITAL_CODE,
								   HSTNUM_RATE_UNITID) AS Rate_WTHUNIT,
								   HSTNUM_PO_NO,
								   HSTNUM_PROGRAMME_ID,
								   NVL(MMS_MST.GET_PROGRAMME_NAME(1,GNUM_HOSPITAL_CODE,HSTNUM_PROGRAMME_ID),''---''),
								   HSTNUM_SUPPLIER_ID*/
								
								br.append("<input type='hidden' name='strSingleManufId'      id='strSingleManufId"
										+ i
										+ "' value='"
										+ vo.getStrSingleBatchDtlWs().getString(13)
										+ "' />");
								br.append("<input type='hidden' name='strSingleProgId'      id='strSingleProgId"
										+ i
										+ "' value='"
										+ vo.getStrSingleBatchDtlWs().getString(11)
										+ "' />");
								br.append("<input type='hidden' name='strStockRate'        id='strStockRate"
										+ i
										+ "' value='"
										+ vo.getStrSingleBatchDtlWs().getString(6)
										+ "' />");
								br.append("<input type='hidden' name='strStockQty'         id='strStockQty"
										+ i
										+ "' value='"
										+ vo.getStrSingleBatchDtlWs().getString(7)
												.split("\\^")[0] + "' />");
								br.append("<input type='hidden' name='strSingleStockRate'        id='strSingleStockRate"
										+ i
										+ "' value='"
										+ vo.getStrSingleBatchDtlWs().getString(9)
										+ "' />");

								br.append("<input type='hidden' name='strTotBatch' id='strTotBatch"	+ i + "' value='" + strTotalNoOfBatch + "' />");
								br.append("<input type='hidden' name='strSingleBatch'      id='strSingleBatch"
										+ i
										+ "' value='"
										+ vo.getStrSingleBatchDtlWs().getString(3)
										+ "' />");
								br.append("<input type='hidden' name='strSingleExpiry'     id='strSingleExpiry"
										+ i
										+ "' value='"
										+ vo.getStrSingleBatchDtlWs().getString(5)
										+ "' />");
								br.append("<input type='hidden' name='strSingleMfgName'     id='strSingleMfgName"
										+ i
										+ "' value='"
										+ vo.getStrSingleBatchDtlWs().getString(8)
										+ "' />");
								br.append("<input type='hidden' name='strProgrammeName'     id='strProgrammeName"
										+ i
										+ "' value='"
										+ vo.getStrSingleBatchDtlWs().getString(12)
										+ "' />");

								br.append("<TD WIDTH='9%' id='td8"
										+ i
										+ "'  style=\"text-align:center;\" >"
										+ vo.getStrSingleBatchDtlWs().getString(3)
										+ "</TD>");
								br.append("<TD WIDTH='9%'  id='td9"
										+ i
										+ "'  style=\"text-align:center;\"   >"
										+ ((vo.getStrSingleBatchDtlWs()
												.getString(5) == null || vo
												.getStrSingleBatchDtlWs()
												.getString(5).equals("")) ? "NA"
												: vo.getStrSingleBatchDtlWs()
														.getString(5)) + "</TD>");
							} 
							else 
							{
								br.append("<input type='hidden' name='strSingleManufId'      id='strSingleManufId"
										+ i
										+ "' value='' />");
								br.append("<input type='hidden' name='strSingleProgId'      id='strSingleProgId"
										+ i
										+ "' value='' />");
								br.append("<input type='hidden' name='strTotBatch' id='strTotBatch"	+ i + "' value='" + strTotalNoOfBatch + "' />");
								br.append("<input type='hidden' name='strSingleBatch'      id='strSingleBatch"+ i + "' value='' />");
								br.append("<input type='hidden' name='strSingleExpiry'     id='strSingleExpiry"+ i + "' value='' />");
								br.append("<input type='hidden' name='strSingleMfgName'    id='strSingleMfgName"+ i + "' value='' />");
								br.append("<input type='hidden' name='strProgrammeName'    id='strProgrammeName"+ i + "' value='' />");
								br.append("<input type='hidden' name='strSingleStockRate'  id='strSingleStockRate"+ i + "' value='' />");
								br.append("<input type='hidden' name='strStockQty'         id='strStockQty"+ i + "' value='' />");
								br.append("<input type='hidden' name='strStockRate'        id='strStockRate"+ i + "' value='' />");
								br.append("<TD WIDTH='9%' id='td8"
										+ i
										+ "'  style=\"text-align:center;\" > </TD>");
								br.append("<TD WIDTH='9%'  id='td9"
										+ i
										+ "'  style=\"text-align:center;\" ></TD>");
							}
							br.append("<input type='hidden' name='strCheckBatchExists'        id='strCheckBatchExists"+ i + "' value='0' />");
							br.append("<input type='hidden' name='stockDtlsId' id='stockDtlsId"
									+ i + "' value='' />");

						}
						
						br.append("<input type='hidden' disabled='disabled' class='txtFldNormal'  value='0.00' name='finalCostDivId' id='finalCostDivId"
								+ i + "' >");
						br.append("<input type='hidden' name='strFinalCost' id='strFinalCost"
								+ i + "' value='0.00' />");

	                   
						br.append("<TD WIDTH='10%' id='td5" + i + "'   ><Select name='strIssueUnitId' onChange='return QtyValidation("
										+ i
										+ ");' id='strIssueUnitId"
										+ i
										+ "' >"
										+ strUnitComboValues + "</select></TD>");
						
						/*br.append("<TD WIDTH='3%' id='td8" + i + "'   ><input type='hidden' name='stockDtlsId' id='stockDtlsId"
								+ i
								+ "' value='' /> <a STYLE='cursor:pointer;cursor:pointer;color:blue'  onClick='callStockDetails(this,\""
								+ i + "\");' TITLE='Click Here For Item Preferences' >auto</TD>");*/
	                    					
						
	                   
						br.append("<TD WIDTH='10%' id='td7" + i + "' ><input type='text' disabled='disabled' class='txtFldNormal'  value='0.00' name='finalCostDivId' id='finalCostDivId"+i+"' ></TD>");
						br.append("<input type='hidden' name='strFinalCost' id='strFinalCost"	+ i	+ "' value='0.00' />");
						
						br.append("<TD WIDTH='10%' id='td6" + i + "' >"
								+ "<input type='text' class='txtFldNormal' maxlength='100' onkeypress='return validateData(event,9);' name='strItemRemarks' id='strItemRemarks"
								+ i
								+ "' value='' ></TD>");
						br.append("<TD WIDTH='10%' id='td8" + i + "' >"
								+ "<input type='text' class='txtFldMin' maxlength='8' onkeypress='return validateData(event,5);' autocomplete='off' name='strBSQuantity' id='strBSQuantity"
								+ i
								+ "' value='' ></TD>");
						
						br.append("</TR>");
						br.append("</div>");
						i++;
					}	
					
				}

				br.append("</table> ");
			} 
			else 
			{
				br.append("<table class='TABLEWIDTH' align='center'cellpadding='1px' cellspacing='1px'>");
				br.append("<TR>");
				br.append("<TD   colspan='8'>"
						+ "No Record Found" + "</TD>");
				br.append("</TR>");
				br.append("</table> ");
			}

		} catch (Exception e) {
			e.printStackTrace();
			return "ERROR";

		}
        ////System.out.println("O/P String:::::"+br.toString());
		return br.toString();
	}
	public static String getItemDetails(String strItemCategoryNo,
			String strHospitalCode, WebRowSet wb, String strRaisingStoreId,String strBudgetFlg)
			throws SQLException {
		StringBuffer br = new StringBuffer();

		IssueDeskTransBO bo = null;
		IssueDeskTransVO vo = null;
		HisUtil hisutil = null;

		String strUnitComboValues = "";

		String strHiddenId = ""; // item id^brandid^RESERVED FLAG^GROUPID^SUBGROUP ID^CONSUMABLE FLAG
									// ^strItemCategory^strRaisingStoreId
	//	String strItemName = "";
		String strBrandName = "";
		String strAvlQty = "";
		String strAvlQtyWithUnitId = "";
		String strAvlQtyBaseVal = "";
		String strBalQty = "";
		String strSancUnitId = "";
		String strSancUnitName = "";
		String strBalQtyBaseVal = "";
		String strReqSancQty;
	//	String strRateBaseVal = "";
	//	String strRate = "";
	//	String strRateUnitId = "";
		String[] temp = null;
		String strReOrderFlg;
		String strApplyClass;
		String strCompSancUnit;
		String strReceivingStoreAvlQty = "";

		int i = 0;

		try {
			hisutil = new HisUtil("mms", "IssueDeskTransHLP");
			bo = new IssueDeskTransBO();
			vo = new IssueDeskTransVO();

			vo.setStrHospitalCode(strHospitalCode);
			if (wb.size() != 0) 
			{

				br.append("<table class='TABLEWIDTH' bgcolor='#6097BC' align='center'cellpadding='1px' cellspacing='1px'>");
				
				while (wb.next()) 
				{
					/*
					 1. Hidden Id
					 2. Genrec Name
					 3. Brand Name
					 4. Avl Qty
					 5. Bal Qty
					 6. Sanc Qty Unit ID
					 7. Unit Name
					 8. Sanc Qty - Issue Qty
					 9. Req / Sanc Qty
					10. Reorder Flag
					11. Unit Id
					12. Rate
					13. Batch No
					14. Rec Store Avl Qty
					 
					 */
					strHiddenId = wb.getString(1); // item id^brand id
			//		strItemName = wb.getString(2);
					strBrandName = wb.getString(3);
					strAvlQty = wb.getString(4);
					strBalQty = wb.getString(5);
					//System.out.println(strAvlQty);
					//System.out.println(strBalQty);
					if (wb.getString(6) == null) 
					{
						strSancUnitId = "0";
					}
					else 
					{
						strSancUnitId = wb.getString(6);
					}
					strSancUnitName  = wb.getString(7);
					strBalQtyBaseVal = wb.getString(8);
					
					
					strReqSancQty    = wb.getString(9);
					
					
					
					
					strCompSancUnit  = wb.getString(11);  // Adding in Change Request 28-July-2011
					strReceivingStoreAvlQty  = wb.getString(14);
									
					
					if (strBalQty.equals("0")) {
						strSancUnitName = " ";
					}
					
					
					/*
					 *  Change Color for Re-Order Level
					   //System.out.println("Inside Issue Desk Trans HLP:::::"+wb.getString(10));
					   
					   if(wb.getString(10).equals("0")) 
				       {
				    	 strApplyClass = "Approved";				    	   
				       }
				       else
				       {
				    	 strApplyClass = "NotApproved";    				    	   
				       }
					*/

					//strBalQty = HisUtil.getAmountWithDecimal(strBalQty, 2); // By Amit Kr Date 23-Feb-2011
					////System.out.println("strHiddenId-" + strHiddenId);
					////System.out.println("strItemName-" + strItemName);
					////System.out.println("strBrandName-" + strBrandName);
					////System.out.println("strAvlQty-" + strAvlQty);
					////System.out.println("strBalQty-" + strBalQty);
					////System.out.println("strSancUnitId-" + strSancUnitId);
					////System.out.println("strSancUnitName-" + strSancUnitName);
					////System.out.println("strBalQtyBaseVal-" + strBalQtyBaseVal);
					////System.out.println("strItemCategory-" + strItemCategoryNo);
					////System.out.println("strRate-" + strRate);
					////System.out.println("strRateUnitId-" + strRateUnitId);
					temp = strAvlQty.replace("^", "#").split("#");

					strAvlQty = temp[0];
					strAvlQtyWithUnitId = temp[1];
					strAvlQtyBaseVal = temp[2];
					//System.out.println(strAvlQty+" "+strAvlQtyWithUnitId+" "+strAvlQtyBaseVal);
					vo.setStrSancUnitId(strSancUnitId);
					// Calling BO Method
					bo.getUnitCombo(vo);
                     
					if (vo.getStrMsgType().equals("1")) 
					{
						throw new Exception(vo.getStrMsgString());
					}

					if (vo.getUnitComboWS() != null	&& vo.getUnitComboWS().size() > 0) 
					{
					
						strUnitComboValues = hisutil.getOptionValue(vo.getUnitComboWS(), strCompSancUnit, "", true);
						vo.getUnitComboWS().beforeFirst(); // needed bcoz
															// sometimes it
															// gives invalid
															// cursor position
															// when there is
															// value in heap due
															// to loop
						
					} 
					else 
					{

						strUnitComboValues = "<option value='0'>Select Value</option>";
					}
					if(strBudgetFlg.equals("0"))
					{	
							br.append("<TR>");
							
							////System.out.println("strStoreId-" + strRaisingStoreId);
							/*
							 * br.append("<TR>"); br .append(" <input type='hidden'
							 * name='strItemDetailsChk' id='strItemDetailsChk" + i + "'
							 * onclick='ClickCheckBox(this,\"" + i + "\");' value= '" +
							 * strHiddenId + "^" + strItemCategoryNo + "^" + strStoreId + "' />
							 * "); br.append(" <input type='hidden' name='flag'
							 * id='flag"+i+"' value=" + "0" + " >");
							 */
		                    
							
							br.append("<TD WIDTH='32%' id='td1" + i + "'   >");
							br.append(" <input type='hidden' name='strItemDetailsChk' id='strItemDetailsChk"
											+ i
											+ "' value= '"
											+ strHiddenId
											+ "^"
											+ strItemCategoryNo
											+ "^"
											+ strRaisingStoreId + "' /> ");
							br.append(" <input type='hidden' name='flag' id='flag" + i + "' value=" + "0" + " />");
							
							br.append(" <input type='hidden' name='reOrderFlag' id='reOrderFlag" + i + "' value=" + wb.getString(10) + " />");
							br.append(" <input type='hidden' name='strAvlQtyForChk' id='strAvlQtyForChk" + i + "' value=" + strAvlQty + " />");
							
							br.append("<a STYLE='cursor:pointer;cursor:pointer;color:blue' title='Batch Wise Item Details' onClick='showPopUp(this,\""
											+ i + "\");'>" + strBrandName + "</a></TD>");
							
							br.append("<td width='7%' id='td17"+i+"' >"+strReceivingStoreAvlQty+" </td>");
							
							br.append("<TD WIDTH='7%' id='td2" + i + "'   >"
											+ strAvlQty
											+ "<input type='hidden' name='strAvlQty' id='strAvlQty"
											+ i
											+ "' value='"
											+ strAvlQtyWithUnitId
											+ "' /><input type='hidden' name='strAvlQtyBaseVal' id='strAvlQtyBaseVal"
											+ i + "' value='" + strAvlQtyBaseVal
											+ "' /></TD>");
							
							br.append("<input type='hidden' name='strBalQty' id='strBalQty"
											+ i
											+ "' value='"
											+ strBalQty
											+ "' /><input type='hidden' name='strSancUnitId' id='strSancUnitId"
											+ i
											+ "' value='"
											+ strSancUnitId
											+ "' /> <input type='hidden' name='strBalQtyBaseVal' id='strBalQtyBaseVal"
											+ i + "' value='" + strBalQtyBaseVal
											+ "' />");
		                    
							br.append("<TD WIDTH='10%' id='td3" + i + "'   >"+strReqSancQty+"</TD>");
							
		                    
							
							br.append("<TD WIDTH='10%' id='td4" + i + "'  ><input type='text' maxlength='8' onkeypress='return validateData(event,5);' onkeyup='return QtyValidation("
											+ i
											+ ");' name='strIssueQty' id='strIssueQty"
											+ i
											+ "' class='txtFldMin' value='' > </TD>");
		                   
							br.append("<TD WIDTH='10%' id='td5" + i + "'   ><Select name='strIssueUnitId' onChange='return QtyValidation("
											+ i
											+ ");' id='strIssueUnitId"
											+ i
											+ "' >"
											+ strUnitComboValues + "</select></TD>");
		                    					
							br.append("<TD WIDTH='10%' id='td6" + i + "'   >"
											+ "<textarea  class='txtFldMin' size = '100' maxlength='500' onkeypress='return validateData(event,9);' name='strItemRemarks' id='strItemRemarks"
											+ i
											+ "' value='' ></textarea></TD>");
							
							br.append("<TD WIDTH='10%' id='td7" + i + "' >"
									+ "<input type='text' class='txtFldMin' maxlength='8' onkeypress='return validateData(event,5);' autocomplete='off' name='strBSQuantity' id='strBSQuantity"
									+ i
									+ "' value='' ></TD>");
		                   
							/*br.append("<TD WIDTH='3%' id='td7" + i + "'   ><input type='hidden' name='stockDtlsId' id='stockDtlsId"
											+ i
											+ "' value='' /> <a STYLE='cursor:pointer;cursor:pointer;color:blue'  onClick='callStockDetails(this,\""+i+ "\");' TITLE='Click Here For Item Preferences' >#</TD>");*/
							
							
							br.append("</TR>");
							br.append("</div>");
							i++;
				    }
					else
					{
						br.append("<TR>");
						
						////System.out.println("strStoreId-" + strRaisingStoreId);
						/*
						 * br.append("<TR>"); br .append(" <input type='hidden'
						 * name='strItemDetailsChk' id='strItemDetailsChk" + i + "'
						 * onclick='ClickCheckBox(this,\"" + i + "\");' value= '" +
						 * strHiddenId + "^" + strItemCategoryNo + "^" + strStoreId + "' />
						 * "); br.append(" <input type='hidden' name='flag'
						 * id='flag"+i+"' value=" + "0" + " >");
						 */
	                    
						
						br.append("<TD WIDTH='32%' id='td1" + i + "'   style=\"text-align:left;\">");
						br.append(" <input type='hidden' name='strItemDetailsChk' id='strItemDetailsChk"
										+ i
										+ "' value= '"
										+ strHiddenId
										+ "^"
										+ strItemCategoryNo
										+ "^"
										+ strRaisingStoreId + "' /> ");
						br.append(" <input type='hidden' name='flag' id='flag" + i + "' value=" + "0" + " />");
						br.append(" <input type='hidden' name='strAvlQtyForChk' id='strAvlQtyForChk" + i + "' value=" + strAvlQty + " />");
						
						br.append(" <input type='hidden' name='reOrderFlag' id='reOrderFlag" + i + "' value=" + wb.getString(10) + " />");
						br.append( strBrandName+"</TD>");
						
//						br.append("<a STYLE='cursor:pointer;cursor:pointer;color:blue' title='Batch Wise Item Details' onClick='showPopUp(this,\""
//										+ i + "\");'>" + strBrandName + "</a></TD>");
						
						br.append("<TD WIDTH='13%' id='td2" + i + "'   >"
										+ strAvlQty	+"/"+strReceivingStoreAvlQty+"<input type='hidden' name='strAvlQty' id='strAvlQty"
										+ i
										+ "' value='"
										+ strAvlQtyWithUnitId
										+ "' /><input type='hidden' name='strAvlQtyBaseVal' id='strAvlQtyBaseVal"
										+ i + "' value='" + strAvlQtyBaseVal
										+ "' /></TD>");
						
						br.append("<input type='hidden' name='strBalQty' id='strBalQty"
										+ i
										+ "' value='"
										+ strBalQty
										+ "' /><input type='hidden' name='strSancUnitId' id='strSancUnitId"
										+ i
										+ "' value='"
										+ strSancUnitId
										+ "' /> <input type='hidden' name='strBalQtyBaseVal' id='strBalQtyBaseVal"
										+ i + "' value='" + strBalQtyBaseVal
										+ "' />");
	                    
						br.append("<TD WIDTH='15%' id='td3" + i + "'   >"+strReqSancQty+"</TD>");
						
	                    
						
						br.append("<TD WIDTH='10%' id='td4" + i + "'  ><input type='text' maxlength='8' onkeypress='return validateData(event,5);' onkeyup='return QtyValidation("
										+ i
										+ ");' name='strIssueQty' id='strIssueQty"  
										+ i
										+ "' class='txtFldMin' value='' > </TD>");
	                   
						br.append("<TD WIDTH='10%' id='td5" + i + "'   ><Select name='strIssueUnitId' onChange='return QtyValidation("
										+ i
										+ ");' id='strIssueUnitId"
										+ i
										+ "' >"
										+ strUnitComboValues + "</select></TD>");
						
						/*br.append("<TD WIDTH='3%' id='td8" + i + "'   ><input type='hidden' name='stockDtlsId' id='stockDtlsId"
								+ i
								+ "' value='' /> <a STYLE='cursor:pointer;cursor:pointer;color:blue'  onClick='callStockDetails(this,\""
								+ i + "\");' TITLE='Click Here For Item Preferences' >#</TD>");*/
	                    					
						
	                   
						br.append("<TD WIDTH='10%' id='td7" + i + "' ><input type='text' disabled='disabled' class='txtFldNormal'  value='0.00' name='finalCostDivId' id='finalCostDivId"+i+"' ></TD>");
						br.append("<input type='hidden' name='strFinalCost' id='strFinalCost"	+ i	+ "' value='0.00' />");
						
						br.append("<TD WIDTH='10%' id='td6" + i + "' >"
								+ "<input type='text' class='txtFldNormal' maxlength='100' onkeypress='return validateData(event,9);' name='strItemRemarks' id='strItemRemarks"
								+ i
								+ "' value='' ></TD>");
						br.append("<TD WIDTH='10%' id='td7" + i + "' >"
								+ "<input type='text' class='txtFldMin' maxlength='8' onkeypress='return validateData(event,5);' autocomplete='off' name='strBSQuantity' id='strBSQuantity"
								+ i
								+ "' value='' ></TD>");
						
						br.append("</TR>");
						br.append("</div>");
						i++;
					}	
					
				}

				br.append("</table> ");
			} 
			else 
			{
				br.append("<table class='TABLEWIDTH' align='center'cellpadding='1px' cellspacing='1px'>");
				br.append("<TR>");
				br.append("<TD   colspan='8'>"
						+ "No Record Found" + "</TD>");
				br.append("</TR>");
				br.append("</table> ");
			}

		} catch (Exception e) {
			e.printStackTrace();
			return "ERROR";

		}
        ////System.out.println("O/P String:::::"+br.toString());
		return br.toString();
	}

	/**
	 * This method is used to show item Details on view PAGE
	 * 
	 * @param wb
	 * @param strItemCategory
	 * @param strHospitalCode
	 * @return
	 */
	public static String getViewItemDetails(String strItemCategoryNo,
			String strHospitalCode, WebRowSet wb, String strStoreId)
			throws SQLException {
		StringBuffer br = new StringBuffer();

		IssueDeskTransBO bo = null;
		IssueDeskTransVO vo = null;
	//	HisUtil hisutil = null;

		//String strUnitComboValues = "";

		String strHiddenId = ""; // item id^brand
		// id^strItemCategory^strStoreId
		//String strItemName = "";
		String strBrandName = "";
		String strAvlQty = "";
		String strBalQty = "";
		String strSancUnitId = "";
		String strUnitName = "";

		String[] temp = null; 
		int i = 0;

		try {
		//	hisutil = new HisUtil("mms", "IssueDeskTransHLP");
			bo = new IssueDeskTransBO();
			vo = new IssueDeskTransVO();

			vo.setStrHospitalCode(strHospitalCode);
			if (wb.size() != 0) {

				br
						.append("<table class='TABLEWIDTH' align='center' cellpadding='1px' cellspacing='1px'>");

				while (wb.next()) {
					strHiddenId = wb.getString(1); // item id^brand id
		//			strItemName = wb.getString(2);
					strBrandName = wb.getString(3);
					strAvlQty = wb.getString(4);
					////System.out.println("strAvlQty"+strAvlQty);
					temp = strAvlQty.replace("@", "#").split("#");
					temp = temp[0].replace("^", "#").split("#");
					strBalQty = wb.getString(5);
					strSancUnitId = wb.getString(6);
					strUnitName = wb.getString(7);
					// ////System.out.println("strHiddenId-" + strHiddenId);
					// ////System.out.println("strItemCategory-" +
					// strItemCategoryNo);

					vo.setStrSancUnitId(strSancUnitId);

					bo.getUnitCombo(vo);

					if (vo.getStrMsgType().equals("1")) {
						throw new Exception(vo.getStrMsgString());
					}

				/*	if (vo.getUnitComboWS() != null
							&& vo.getUnitComboWS().size() > 0) {
						strUnitComboValues = hisutil.getOptionValue(vo
								.getUnitComboWS(), "", "0^Select Value", true);
					} else {

						strUnitComboValues = "<option value='0'>Select Value</option>";
					}*/

					/*
					 * br.append("<TR>"); br .append(" <input type='hidden'
					 * name='strItemDetailsChk' id='strItemDetailsChk" + i + "'
					 * onclick='ClickCheckBox(this,\"" + i + "\");' value= '" +
					 * strHiddenId + "^" + strItemCategoryNo + "^" + strStoreId + "' />
					 * "); br.append(" <input type='hidden' name='flag'
					 * id='flag"+i+"' value=" + "0" + " >");
					 */

					br.append("<TD WIDTH='33%'  >");
					br
							.append(" <input type='hidden' name='strItemDetailsChk' id='strItemDetailsChk"
									+ i
									+ "' onclick='ClickCheckBox(this,\""
									+ i
									+ "\");' value= '"
									+ strHiddenId
									+ "^"
									+ strItemCategoryNo
									+ "^"
									+ strStoreId
									+ "' /> ");
					br.append(" <input type='hidden' name='flag' id='flag" + i
							+ "' value=" + "0" + " >");

					br
							.append("<a STYLE='cursor:pointer;cursor:pointer;color:blue' title='Batch Wise Item Details' onClick='showPopUp(this,\""
									+ i + "\");'>" + strBrandName + "</a></TD>");

					br.append("<TD WIDTH='33%'  >"
							+ temp[0] + "</TD>");
					br.append("<TD WIDTH='33%'  >"
							+ wb.getString(9) + "</TD>");
					br.append("</TR>");
					i++;
				}

				br.append("</table> ");
			} else {
				br
						.append("<table class='TABLEWIDTH' align='center'cellpadding='1px' cellspacing='1px'>");
				br.append("<TR>");
				br.append("<TD   colspan='3'>"
						+ "No Record Found" + "</TD>");
				br.append("</TR>");
				br.append("</table> ");
			}

		} catch (Exception e) {
			e.printStackTrace();
			return "ERROR";

		}

		return br.toString();
	}

	/**
	 * This method is used to show issued item Details on VIEW PAGE2
	 * 
	 * @param wb
	 * @param strItemCategory
	 * @param strHospitalCode
	 * @return
	 */
	public static String getIssuedItemDetail(String strItemCategoryNo,
			String strHospitalCode, WebRowSet wb, String strStoreId,String strIssueNo)
			throws SQLException {
		StringBuffer br = new StringBuffer();

	//	IssueDeskTransBO bo = null;
		IssueDeskTransVO vo = null;

		String strItemName = "";
		String strBatchSlNo = "";
		String strSancQty = "";
		String strIssuedQty = "";
		String strItemRemarks = "";
		
		String strRecievedBy = "";
		String strRemarks = "";
		String strIndentNo="0";
		String strIndentDate="";

		int i = 0;

		try {

		//	bo = new IssueDeskTransBO();
			vo = new IssueDeskTransVO();

			vo.setStrHospitalCode(strHospitalCode);
			if (wb.size() != 0) 
			{

				br.append("<table class='table' align='center'cellpadding='1px' cellspacing='1px'>");
				br.append("<input type='hidden' name='strStoreId' id='strStoreId' value=" + strStoreId + " />");
				br.append("<input type='hidden' name='strIssueNo' id='strIssueNo' value=" + strIssueNo + " />");
				
				
				while (wb.next()) 
				{				
					strIndentNo      = wb.getString(14);//14
					strIndentDate    = wb.getString(18);//15				
				}	
				br.append("<input type='hidden' name='strIndentNo' id='strIndentNo' value=" + strIndentNo + " />");
				br.append("<input type='hidden' name='strIndentDate' id='strIndentDate' value=" + strIndentDate + " />");
				
				wb.beforeFirst();
				
				while (wb.next()) 
				{

					strItemName    = wb.getString(7);
					strBatchSlNo   = wb.getString(8);
					strIssuedQty   = wb.getString(9);
					strSancQty     = wb.getString(11);
					strItemRemarks = wb.getString(12);					
					strRecievedBy  = wb.getString(3);
					strRemarks     = wb.getString(4);

					br.append("<tbody><TD  width='40%' align='left'>"+ strItemName + "</TD>");

				
					br.append("<TD width='15%' align='left'>"
							+ strBatchSlNo + "</TD>");
					br.append("<TD width='15%' align='right'>"
							+ strSancQty + "</TD>");

					br.append("<TD width='15%' align='right'>"
							+ strIssuedQty + "</TD>");

					br.append("<TD width='15%' align='left'>"
							+ strItemRemarks + "</TD>");

					br.append("</tbody>");
					i++;
				}

				br.append("</table> ");
			} else {
				br
						.append("<table class='table' align='center'cellpadding='1px' cellspacing='1px'>");
				br.append("<tbody>");
				br.append("<TD   colspan='5'>"
						+ "No Record Found" + "</TD>");
				br.append("</tbody>");
				br.append("</table> ");
			}
if(strRecievedBy.equals("") || strRemarks.equals("")){
	br.append("#"+"--"+"#"+"--");
}
else{
	br.append("#"+strRecievedBy+"#"+strRemarks);
}
			

		} catch (Exception e) {
			e.printStackTrace();
			return "ERROR";

		}

		return br.toString();
	}

	/**
	 * This method is used to show a PopUp (ON CLICK OF AN ITEM NAME)
	 * 
	 * @param wb
	 * @param index
	 * @return
	 */
	public static String getPopUpInfo(WebRowSet wb, String index) {

		// String temp[] = null;
		StringBuffer br = null;
		StringBuffer br1 = null;
		String strItemName = "";
		String strBrandname = "";
		String strBatchNo = "";
		String strManufactDate = "";
		String strExpiryDate = "";
		String strInHandQty = "";
		String strAvlQty = "";

		try {
			br = new StringBuffer();
			br1 = new StringBuffer();

			br.append("<table width='500' cellpadding='0' cellspacing='0'>");

			br
					.append("<tr class='HEADER' align='left'><td>&nbsp;Batch Wise Item Details</td> ");
			br
					.append("<td align='right'><img src='../../hisglobal/images/popUp_cancel.JPG' title='To Close PopUp Window' align='middle' onclick='hide_popup_menu(\"popup\");'> </td></tr>");

			br.append("</tr>");
			br.append("</table> ");

			br.append("<table width='500' align='left'>");

			br.append("<tr>");

			br
					.append("<td class='multiLabel' WIDTH='16%' align='CENTER'>Generic Item Name</td>");

			br
					.append("<td class='multiLabel' WIDTH='16%' align='CENTER'>Item Name</td>");

			br
					.append("<td class='multiLabel' WIDTH='16%' align='CENTER'>Batch No.</td>");

			br
					.append("<td class='multiLabel' WIDTH='20%' align='CENTER'>Manfactured Date</td>");

			br
					.append("<td class='multiLabel' WIDTH='16%' align='CENTER'>Expiry Date</td>");

			br
					.append("<td class='multiLabel' WIDTH='16%' align='CENTER'>Avl Qty</td>");

			br.append("</tr>");

			////System.out.println("wb size" + wb.size());

			if (wb == null || wb.size() == 0) {
				////System.out.println("wb size" + wb.size());
				br.append("<TR>");
				br
						.append("<TD colspan='6'   >"
								+ "<DIV class='errMsg' align='center'> NO RECORD FOUND</div> "
								+ "</TD>");

				br.append("</TR>");
			} else {
				while (wb.next())

				{
					strItemName = wb.getString(1);
					strBrandname = wb.getString(2);
					strBatchNo = wb.getString(3);
					strManufactDate = wb.getString(4);
					strExpiryDate = wb.getString(5);
					strInHandQty = wb.getString(6);
					String temp[] = strInHandQty.replace("^", "#").split("#");
					strAvlQty = temp[0];

					if (strItemName == null || strItemName.equals("null"))
						strItemName = "";
					if (strBrandname == null || strBrandname.equals("null"))
						strBrandname = "";
					if (strBatchNo == null || strBatchNo.equals("null"))
						strBatchNo = "";
					if (strManufactDate == null
							|| strManufactDate.equals("null"))
						strManufactDate = "";
					if (strExpiryDate == null || strExpiryDate.equals("null"))
						strExpiryDate = "";
					if (strInHandQty == null || strInHandQty.equals("null"))
						strInHandQty = "";

					br.append("<TR>");

					br.append("<TD  WIDTH='16%' >"
							+ strItemName + "</TD>");

					br.append("<TD WIDTH='16%' >"
							+ strBrandname + "</TD>");

					br.append("<TD WIDTH='16%'  >"
							+ strBatchNo + "</TD>");

					br.append("<TD WIDTH='20%'  >"
							+ strManufactDate + "</TD>");

					br.append("<TD WIDTH='16%'  >"
							+ strExpiryDate + "</TD>");
					br.append("<TD WIDTH='16%'  >"
							+ strAvlQty + "</TD>");

					br.append("</TR>");

					br1.append(strItemName + "^" + strBrandname + "^"
							+ strBatchNo + "^" + strManufactDate + "^"
							+ strExpiryDate + "^" + strInHandQty + "^");

					i++;
				}
			}
			br.append("</table>");
			br.append("@");
			br.append(br1);
			br.append("@");
			br.append(index);

		} catch (Exception e) {
			e.printStackTrace();
			return "ERROR";

		}
		////System.out.println("br.toString()-" + br.toString());
		return br.toString();

	}

	/**
	 * This method is used to show a PopUp (ON CLICK OF A BILL NO. AGAIN)of Bill
	 * SERVICE DETAILS by using the WebRowSet
	 * 
	 * @param vo
	 * @return
	 */
	public static String getPopUpData(String strPopUpData) {

		StringBuffer br = null;
		String data = "";
		String temp[] = null;

		try {

			data = strPopUpData;

			temp = data.replace('^', '#').split("#");
			////System.out.println("temp length-->" + temp.length);

			br = new StringBuffer();

			br.append("<table width='500' cellpadding='0' cellspacing='0'>");

			br
					.append("<tr class='HEADER' align='left'><td>&nbsp;Batch Wise Item Details</td> ");
			br
					.append("<td align='right'><img src='../../hisglobal/images/popUp_cancel.JPG' align='middle' onclick='hide_popup_menu(\"popup\");'> </td></tr>");

			br.append("</tr>");
			br.append("</table> ");

			br.append("<table width='500' align='left'>");

			br.append("<tr>");

			br
					.append("<td class='multiLabel' WIDTH='16%' align='CENTER'>Item Name</td>");

			br
					.append("<td class='multiLabel' WIDTH='16%' align='CENTER'>Brand Name</td>");

			br
					.append("<td class='multiLabel' WIDTH='16%' align='CENTER'>Batch No.</td>");

			br
					.append("<td class='multiLabel' WIDTH='20%' align='CENTER'>Manfactured Date</td>");

			br
					.append("<td class='multiLabel' WIDTH='16%' align='CENTER'>Expiry Date</td>");

			br
					.append("<td class='multiLabel' WIDTH='16%' align='CENTER'>Avl Qty</td>");

			br.append("</tr>");
			if (temp.length > 1) {
				for (int j = 0; j <= (temp.length / 2); j = j + 6) {

					br.append("<TR>");

					br.append("<TD  WIDTH='16%' >"
							+ temp[j + 0] + "</TD>");

					br.append("<TD WIDTH='16%' >"
							+ temp[j + 1] + "</TD>");

					br.append("<TD WIDTH='16%'  >"
							+ temp[j + 2] + "</TD>");

					br.append("<TD WIDTH='20%'  >"
							+ temp[j + 3] + "</TD>");

					br.append("<TD WIDTH='16%'  >"
							+ temp[j + 4] + "</TD>");
					br.append("<TD WIDTH='16%'  >"
							+ temp[j + 5] + "</TD>");

					br.append("</TR>");
				}
			}

			br.append("</table>");

		} catch (Exception e) {
			e.printStackTrace();
			return "ERROR";

		}

		return br.toString();

	}
	
	/**
	 * Gets the stock item dtls init view.
	 * 
	 * @param formBean
	 *            the form bean
	 * 
	 * @return the stock item dtls init view
	 * 
	 * @throws Exception
	 *             the exception
	 */
	public static String getStockItemDtlsInitView(IssueDeskTransFB formBean)
			throws Exception {

		StringBuffer sb = new StringBuffer("");

		WebRowSet ws = formBean.getWsStockDetails();
		HisUtil util = new HisUtil("IssueDeskTrans Stock Detail Util", "IssueDeskTransHLP");
		IssueDeskTransVO vo = new IssueDeskTransVO();
		int count = 0;

		boolean flag = false;

		String strHiddenVal = "0";
		String[] strHiddenValList = null;
		String[] strTemp = null;
		String[] strChkList = null;
		String[] strQtyList = null;
		String[] strUnitList = null;
		
		String[] strHiddenCost = null;
		String[] strHiddenTotalCost = null;

		String strTempQtyVal = "";
		String strTempUnitVal = "";
		String strTempCost = "0.00";
		String strTempTotalCost = "0.00";

		String strTableWidth = "800";
		//formBean.setUsrArg((String) request.getParameter("strMode").split("\\^")[1]); 
		// This Variable is Used As Budget Avalaible Flag 
		// Change By Amit Kumar 10-Aug-2011

		try 
		{

			/*
			 * if(formBean.getStrHiddenVal().trim().length() > 1) strHiddenVal =
			 * formBean.getStrHiddenVal();
			 */

			StringBuffer strChkVal = new StringBuffer("");
			if (formBean.getStrModeVal().equals("1")) 
			{

				sb.append("<table width='"+ strTableWidth+ "' align='center' cellpadding='1px' cellspacing='1px'> ");
				sb.append("<tr class='HEADER'> ");
				sb.append("<input type='hidden' name='strIndex' id='strIndex' value='"+formBean.getStrIndex()+"'>");
				sb.append("<input type='hidden' name='strParentIndex' id='strParentIndex"+count+"' value='"+formBean.getStrParentIndex()+"'>");
				if (formBean.getStrItemCategoryId().equals("10")) 
				{

					sb.append("<td colspan='4'>Drug Stock Detail(s) </td> ");

				} 
				else 
				{
					sb.append("<td colspan='4'>Item Stock Detail(s) </td> ");
				}

				sb.append("</tr> ");
				sb.append("<tr> ");
				if (formBean.getStrItemCategoryId().equals("10")) 
				{

					sb.append("<td width='50%' class='LABEL'>Drug Name</td> ");

				}
				else 
				{
					sb.append("<td width='50%' class='LABEL'>Item Name</td> ");
				}
                 
				sb.append("<td width='50%' class='CONTROL'>"+ formBean.getStrItemName() + "</td> ");
				sb.append("</tr> ");
				sb.append("<tr> ");
				sb.append("<td width='50%' class='LABEL'>Issue Qty.</td> ");
				sb.append("<td width='50%' class='CONTROL'>"+ formBean.getStrIndentIssueQty() + " "+ formBean.getStrUnitName()+ "<input type='hidden' class='txtFldNormal' ");
				sb.append("name='strItemIssueQty' value='"+ formBean.getStrIndentIssueQty()+ "'><input type='hidden' class='txtFldNormal' ");
				sb.append("name='strItemIssueQtyBaseVal' value='"+ formBean.getStrIssueQtyInBase() + "'></td> ");
				
				sb.append("</tr> ");
				sb.append("</table> ");

				sb.append("<table width='"+ strTableWidth+ "' align='center' cellpadding='1px' cellspacing='1px'> ");
				sb.append("<tr class='TITLE'> ");
				if (!formBean.getStrItemCategoryId().equals("10"))
				{
					sb.append("<td colspan='10'>Item Detail(s)</td> ");
				} 
				else
				{
					sb.append("<td colspan='10'>Drug Detail(s)</td> ");
				}
				sb.append("</tr> ");
				sb.append("<tr> ");
				sb.append("<td class='multiRPTLabel' width='5%'>#");
				sb.append("</td> ");
				sb.append("<td class='multiRPTLabel' width='9%'>Rack No");
				sb.append("</td> ");
//				if (!formBean.getStrItemCategoryId().equals("10")) 
//				{
//					sb.append("<td class='multiRPTLabel' width='14%'>Serial No. ");
//					sb.append("</td> ");
//				}
				sb.append("<td class='multiRPTLabel' width='14%'>Batch No. ");
				sb.append("</td> ");
				sb.append("<td class='multiRPTLabel' width='10%'>Expiry Date ");
				sb.append("</td> ");
//				sb.append("<td class='multiRPTLabel' width='14%'>Manufacturer ");
//				sb.append("</td> ");
				sb.append("<td class='multiRPTLabel' width='10%'>Avl. Qty. ");
				sb.append("</td> ");
				sb.append("<td class='multiRPTLabel' width='7%'>Rate/Unit");
				sb.append("</td> ");
				sb.append("<td class='multiRPTLabel' width='12%'><font color='red'>*</font>Issue Qty. ");
				sb.append("</td> ");				
				sb.append("<td class='multiRPTLabel' width='8%'><font color='red'>*</font>Unit ");
				sb.append("</td> ");
				if (formBean.getUsrArg().equals("1")) // Means Budget Required
				{
				  sb.append("<td class='multiRPTLabel' width='14%'>Cost");
				  sb.append("</td> ");
				} 
				sb.append("</tr> ");

				if (ws != null && ws.size() > 0) 
				{

					while (ws.next()) 
					{
						/*
						 * This part is added by Aritra on May 26, 2010. It will
						 * cause to produce distinct value for strStockDtlsChk
						 * checkbox, not appending with the value of previous
						 * check-box. *
						 */
						strChkVal = new StringBuffer();
						/* -- End of addtion on May 26, 2010 -- */

						/*
						 * 11. Store id, 12. Generic Item Id 13. Item Id 14.
						 * Stock Status Code 15. Batch No. 18. Expiry Date 19.
						 * Manufacture Date 20. Inhand Qty 21. Inhand Qty Unit
						 * Id 23. Rate 24. Rate Unit Id 37. Serial No. 38. Sale
						 * Price 39. Sale Price Unit Id
						 */

						String strExpDate = "";
						if (ws.getString(18) != null && ws.getString(18).length() > 10)
						{
							strExpDate = ws.getString(18);
						}
						if (formBean.getStrItemCategoryId().equals("10")) 
						{

							strChkVal.append(ws.getString(11)).append("^")
									.append(ws.getString(12)).append("^")
									.append(ws.getString(13)).append("^")
									.append(ws.getString(15)).append("^")
									.append(ws.getString(14)).append("^0")
									.append("^").append(strExpDate).append("^")
									.append(ws.getString(19)).append("^")
									.append(ws.getString(20)).append("^")
									.append(ws.getString(21)).append("^")
									.append(ws.getString(23)).append("^")
									.append(ws.getString(24)).append("^")
									.append(ws.getString(38)).append("^")
									.append(ws.getString(39));
						} 
						else 
						{

							strChkVal.append(ws.getString(11)).append("^")
									.append(ws.getString(12)).append("^")
									.append(ws.getString(13)).append("^")
									.append(ws.getString(15)).append("^")
									.append(ws.getString(14)).append("^")
									.append(ws.getString(37)).append("^")
									.append(strExpDate).append("^").append(
											ws.getString(19)).append("^")
									.append(ws.getString(20)).append("^")
									.append(ws.getString(21)).append("^")
									.append(ws.getString(23)).append("^")
									.append(ws.getString(24)).append("^")
									.append(ws.getString(38)).append("^")
									.append(ws.getString(39));

						}
						count = count + 1;

						sb.append("<tr>");
						strHiddenVal = formBean.getStrHiddenVal();
						if (strHiddenVal.length() > 1) 
						{
							  strHiddenValList = strHiddenVal.split("@");
							        strChkList = new String[strHiddenValList.length];
							        strQtyList = new String[strHiddenValList.length];
							       strUnitList = new String[strHiddenValList.length];							
							strHiddenTotalCost = new String[strHiddenValList.length];
							     strHiddenCost = new String[strHiddenValList.length];							
							////System.out.println("length::::::"+strHiddenValList.length);
							for (int i = 0, stopI = strHiddenValList.length; i < stopI; i++) 
							{
                               // //System.out.println("Hidden val:::"+strHiddenValList[i]);
								strTemp = strHiddenValList[i].replace("^", "#").split("#");                               
								strChkList[i] = new StringBuffer(strTemp[0])
										.append("^").append(strTemp[1]).append(
												"^").append(strTemp[2]).append(
												"^").append(strTemp[3]).append(
												"^").append(strTemp[4]).append(
												"^").append(strTemp[5]).append(
												"^").append(strTemp[6]).append(
												"^").append(strTemp[7]).append(
												"^").append(strTemp[8]).append(
												"^").append(strTemp[9]).append(
												"^").append(strTemp[10])
										.append("^").append(strTemp[11])
										.append("^").append(strTemp[12])
										.append("^").append(strTemp[13])
										.toString();

								        strQtyList[i] = strTemp[14];
								       strUnitList[i] = strTemp[15];
								     strHiddenCost[i] = strTemp[18];
								strHiddenTotalCost[i] = strTemp[19];
							}
						}

						if (strChkList != null) 
						{

							for (int i = 0, stopI = strChkList.length; i < stopI; i++) 
							{
								String content = strChkList[i];

								if (content.equalsIgnoreCase(strChkVal.toString())) 
								{
									            flag = true;
									   strTempQtyVal = strQtyList[i];
									  strTempUnitVal = strUnitList[i];
									
									    strTempCost  = strHiddenCost[i];
									strTempTotalCost = strHiddenTotalCost[i];									

								}

							}

						}
						if (flag) 
						{
							sb.append("<td  width='5%'><input type='checkbox' name='strStockDtlsChk' id='strStockDtlsChk"
											+ count
											+ "' checked='checked'  value='"
											+ strChkVal.toString()
											+ "' onclick='checkStockDetails(this,\""
											+ count + "\");'> ");

						} 
						else
						{

							sb.append("<td  width='5%'><input type='checkbox' name='strStockDtlsChk' id='strStockDtlsChk"
											+ count
											+ "' value='"
											+ strChkVal.toString()
											+ "' onclick='checkStockDetails(this,\""
											+ count + "\");'> ");

						}

						sb.append("</td> ");
						
						String strRackNo = "-----";

						if (ws.getString(44) != null || ws.getString(44)!="")
						{
							strRackNo = ws.getString(44);
						}

						
						sb.append("<td  width='9%'>");   // Rack No::::
						sb.append(strRackNo);
						sb.append("</td> ");

//						if (!formBean.getStrItemCategoryId().equals("10")) 
//						{
//							sb.append("<td  width='14%'>");
//							sb.append(ws.getString(37));
//							sb.append("</td> ");
//						}

						sb.append("<td  width='14%'>");
						sb.append(ws.getString(15));
						sb.append("</td> ");
						sb.append("<td  width='10%'>");
						sb.append(strExpDate);
						sb.append("</td> ");
//						sb.append("<td  width='14%'>");
//
//						if (ws.getString(5) != null	&& !ws.getString(5).equals("null"))
//							
//							sb.append(ws.getString(5));
//
//						sb.append("</td> ");
						sb.append("<td  width='10%'>");
						sb.append(ws.getString(9).split("\\ ")[0]);
						sb.append("</td> ");
						sb.append("<td  width='7%'>");
						sb.append(ws.getString(23)+"/"+ws.getString(9).split("\\ ")[1]);
											
						sb.append("<input type='hidden' name='strAvlDrugBatch'    id='strAvlDrugBatch"+count+"'    value='"+ws.getString(15)+"'>");
						sb.append("<input type='hidden' name='strDrugBatchAvlQty' id='strDrugBatchAvlQty"+count+"' value='"+ws.getString(9).split("\\ ")[0]+"'>");
						sb.append("<input type='hidden' name='strRate'            id='strRate"+count+"'            value='"+ws.getString(23)+"'>");
						sb.append("<input type='hidden' name='strRate'            id='strPurchaseRate"+count+"'    value='"+ws.getString(23)+"'>");
						sb.append("</td> ");
						
						sb.append("<td  width='12%'>");

						if (flag) 
						{
                            // Method in issueDesk_trans.js File
							sb.append("<input type='text' autocomplete='off' class='txtFldMin' maxlength='7' value='"
											+ strTempQtyVal
											+ "' onkeypress='return validateData(event,7);' onkeyup='checkAvailQtyTwo(\""
											+ count
											+ "\",\"strAvailableQty\",\"strAvailableQtyUnit\",\"strStockCostId\");' name='strAvailableQty' id='strAvailableQty"
											+ count + "'>");

						} 
						else 
						{

							sb.append("<input type='text' autocomplete='off' class='txtFldMin' maxlength='7' disabled='disabled' onkeypress='return validateData(event,7);' onkeyup='checkAvailQty(\""
											+ count
											+ "\",\"strAvailableQty\",\"strAvailableQtyUnit\");' name='strAvailableQty' id='strAvailableQty"
											+ count + "'>");

						}

						sb.append("</td> ");
						
						sb.append("<td  width='8%'>");
						sb.append("<input type='hidden' name='strDrugDtls'         id='strDrugDtls"
								+ (count - 1) + "'  value='"
								+ ws.getString(15) + "'>");
						sb.append("<input type='hidden' name='strExpDtls'          id='strExpDtls"
								+ (count - 1) + "'  value='"
								+ strExpDate + "'>");
						sb.append("<input type='hidden' name='strMrpDtls'          id='strMrpDtls"
								+ (count - 1) + "'  value='"
								+ ws.getString(23) + "'>");

						if (flag) 
						{

							sb.append("<select name='strAvailableQtyUnit' class='comboMin' id='strAvailableQtyUnit"  
											+ count
											+ "' onchange='checkAvailQty(\""
											+ count
											+ "\",\"strAvailableQty\",\"strAvailableQtyUnit\");'>");
							
							

							vo.setStrUnitId(ws.getString(21));
							vo.setStrHospitalCode(formBean.getStrHospitalCode());
							IssueDeskTransDAO.getUnitList(vo);

							if (vo.getStrUnitListWs() != null && vo.getStrUnitListWs().size() > 0) 
							{

								sb.append(util.getOptionValue(vo.getStrUnitListWs(), strTempUnitVal,"", true, true));

							} 
							else 
							{

								sb.append("<option value='0'>Select</option>");
							}

							sb.append("</select>");

						 } 
						else 
						{

							sb.append("<select name='strAvailableQtyUnit' disabled='disabled' class='comboMin' id='strAvailableQtyUnit"
											+ count
											+ "' onchange='checkAvailQty(\""
											+ count
											+ "\",\"strAvailableQty\",\"strAvailableQtyUnit\");' >");
							

							vo.setStrUnitId(ws.getString(21));
							vo.setStrHospitalCode(formBean.getStrHospitalCode());
							IssueDeskTransDAO.getUnitList(vo);

							if (vo.getStrUnitListWs() != null && vo.getStrUnitListWs().size() > 0) 
							{

								sb.append(util.getOptionValue(vo.getStrUnitListWs(), vo.getStrUnitId(),"", true, true));

							} 
							else 
							{

								sb.append("<option value='0'>Select</option>");
							}

							sb.append("</select>");

						}

						sb.append("</td> ");
						if (formBean.getUsrArg().equals("1")) // Means Budget Required
						{
							
									
									if (formBean.getStrItemCategoryId().equals("10")) 
									{
										sb.append("<td  width='14%'>");
										if (flag) 
										{
										     sb.append("<input type='text' disabled='disabled' class='txtFldMin'  value='"+strTempCost+"' name='strStockCost' id='strStockCost"+count+"' >");
										     sb.append("<input type='hidden' value='"+strTempCost+"' name='strCost' id='strCost"+count+"' >");
										} 
										else
										{
											  sb.append("<input type='text' disabled='disabled' class='txtFldMin'  value='0.00' name='strStockCost' id='strStockCost"+count+"' >");
											  sb.append("<input type='hidden' value='0.00' name='strCost' id='strCost"+count+"' >");
										}	
				
									 } 
									else 
									{
			
										sb.append("<td  width='14%'>");
										if (flag) 
										{
										     sb.append("<input type='text' disabled='disabled' class='txtFldMin'  value='"+strTempCost+"' name='strStockCost' id='strStockCost"+count+"' >");
										     sb.append("<input type='hidden' value='"+strTempCost+"' name='strCost' id='strCost"+count+"' >");
										} 
										else
										{
											  sb.append("<input type='text' disabled='disabled' class='txtFldMin'  value='0.00' name='strStockCost' id='strStockCost"+count+"' >");
											  sb.append("<input type='hidden' value='0.00' name='strCost' id='strCost"+count+"' >");
										}	
			
								}	
							sb.append("</td> ");
						}
				   	   

						
						sb.append("</tr> ");

						flag = false;

						strTempQtyVal = "";
						strTempUnitVal = "0";
					}

				}
				else 
				{

					sb.append("<tr> ");
					sb
							.append("<td colspan='8' ><font color='red'><b>Details Not Available</b></font></td> ");
					sb.append("</tr> ");

				}

				sb.append("</table> ");
				if (formBean.getUsrArg().equals("1"))
				{
						sb.append("<table width='"+ strTableWidth+ "' align='center' cellpadding='1px' cellspacing='1px'> ");
						sb.append("<tr> ");
						sb.append("<td width='68%' class='LABEL'>Total:</td> ");
						sb.append("<td width='16%' class='CONTROL' style='color: red; font-weight: bold'> ");
						sb.append("<div id='strTotalQtyDivId' align='left'>0.00</div></td> ");
						sb.append("<td width='12%' class='CONTROL' style='color: red; font-weight: bold;text-align:right;'> ");
						sb.append("<input type='text' name='strTotalCostDivId' class='txtFldNormal'  value='"+strTempTotalCost+"'  disabled='disabled' id='strTotalCostDivId' >");
						sb.append("<input type='hidden' name='strApproxAmt' value='"+strTempTotalCost+"'></td> ");
						sb.append("</tr> ");
						sb.append("</table> ");
				}
				

				sb.append("<table width='"+ strTableWidth+ "' align='center' cellpadding='1px' cellspacing='1px'> ");
				sb.append("<tr class='FOOTER'> ");
				sb.append("<td colspan='4'><font size='2' color='red'>*</font> Mandatory Fields  </td> ");
				sb.append("</tr> ");
				sb.append("</table> ");

				sb.append("<table border='0' width='" + strTableWidth+ "' align='center'> ");
				sb.append("<tr> ");
				sb.append("<td align='center'><img style='cursor: pointer; ' ");
				sb.append(" src='../../hisglobal/images/btn-ok.png' ");
				sb.append(" onClick='return validatePopUp();' title='Save Record'/>  ");
				sb.append(" <img style='cursor: pointer; ' title='Cancel Process'  ");
				sb.append(" src='../../hisglobal/images/close_tab.png' onClick='cancelStockDetails(this,\""	+ (count-1) + "\");' /> ");				sb.append(" </td> ");
				sb.append(" </tr> ");
				sb.append(" </table> ");

			} 			

		} catch (Exception e) {

			e.printStackTrace();

			throw e;
		}

		return sb.toString();
	}
	
	
}
