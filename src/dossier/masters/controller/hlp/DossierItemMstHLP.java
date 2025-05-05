package dossier.masters.controller.hlp;

import ipd.IpdConfigUtil;

import java.util.ResourceBundle;

import hisglobal.utility.HisUtil;

import javax.sql.rowset.WebRowSet;

import dossier.masters.vo.*;

public class DossierItemMstHLP {
	
	/*
	 * Function to get item details for modify
	 * 
	 * 
	 * 
	 */
	public static String getItemDetails(DossierItemMstVO vo)
	{
		StringBuffer sb = new StringBuffer("");
		WebRowSet ws=vo.getItemDetailWS();
		//String 
		int size=4;
		int count=1;
		int i=1;
		System.out.println("Web row set size --->>> "+ws.size());
		try
		{
			sb.append("<table class='TABLEWIDTH' cellspacing='1px' cellpadding='0px' align='center'>");
			sb.append("<tbody><tr>");
			sb.append("<td class='multiLabel' width='23%'>Item Name</td>");
			/*sb.append("<td class='multiLabel' width='8%'>Is Misc</td>");*/
			/*sb.append("<td class='multiLabel' width='8%'>Is Returnable</td>");*/
			sb.append("<td class='multiLabel' width='8%'>Category</td>");
			/*sb.append("<td class='multiLabel' width='8%'>Is RC</td>");*/
			sb.append("<td class='multiLabel' width='8%'>Type</td>");
			sb.append("<td class='multiLabel' width='8%'>Is Brought By Patient</td>");
			sb.append("<td class='multiLabel' width='8%'>Unit Price</td>");
			sb.append("<td class='multiLabel' width='8%'>No. Of Units</td>");
			sb.append("<td class='multiLabel' width='8%'>Approx. Cost</td>");
			sb.append("<td class='multiLabel' width='8%'>Remarks</td>");
			sb.append("<td class='multiLabel' width='4%'>Remove</td>");
			sb.append("</tr>");
			sb.append("</tbody></table>");
			
				if(ws.size()>0){
					while(ws.next()){
						
						sb.append("<div id='id100"+i+"-"+count+"' style='display: block;'>");
						sb.append("<div id='id101"+i+"-"+count+"'>");
						
						sb.append("<input type='hidden' name='strItemTypeIdArray' value="+ws.getString(8)+">");
						sb.append("<input type='hidden' name='strItemIdArray' value="+ws.getString(6)+">");
						sb.append("<input type='hidden' name='strItemBrandIdArray' value="+ws.getString(5)+">");
						
						sb.append("<table class='TABLEWIDTH' id='td"+count+"' cellspacing='1px' cellpadding='1px' bgcolor='#6097BC' align='center'>");
						sb.append("<tbody><tr>");
						sb.append("<td class='multiControl' width='23%' align='left'>");
						sb.append("<div id='itemParaId99"+i+"-"+count+"'>");
						
						sb.append(ws.getString(1));
						sb.append("</div>");
						sb.append("</td>");
				
						sb.append("<td class='multiControl' width='8%' style='display:none;'>");
						sb.append("<div id='itemParaId85"+i+"-"+count+"'>"+ws.getString(10)+"</div>");
						sb.append("<input type='hidden' id='strIsMisc1"+i+"-"+count+"' style='width:80px;' name='strIsMisc1' class='IsMiscItemNew' />");
						sb.append("</td>");
						
						sb.append("<td class='multiControl' width='8%' style='display:none;'>");
						sb.append("<div id='itemParaId75"+i+"-"+count+"'>"+ws.getString(11)+"</div>");
						sb.append("<input type='hidden' id='strIsReturnableArr1"+i+"-"+count+"' style='width:80px;' name='strIsReturnableArr1' class='IsReturnableItemNew' />");
						sb.append("</td>");
					
						sb.append("<td class='multiControl' width='8%'>");
						sb.append("<div id='itemParaId98"+i+"-"+count+"'>"+ws.getString(2)+"</div>");
						sb.append("</td>");

						sb.append("<td class='multiControl' width='8%' style='display:none;'>");
						sb.append("<div id='itemParaId86"+i+"-"+count+"'>"+ws.getString(12)+"</div>");
						sb.append("<input type='hidden' id='strIsRC1"+i+"-"+count+"' style='width:80px;' name='strIsRC1' class='IsRCItemNew' />");
						sb.append("</td>");
						
						sb.append("<td class='multiControl' width='8%'>");
						sb.append("<div id='itemParaId87"+i+"-"+count+"'>"+ws.getString(9)+"</div>");
						sb.append("</td>");
						
						sb.append("<td class='multiControl' width='8%'>");
						sb.append("<select name='isBroughtByPatient1' onchange='changeDefRateValueNew(this);'>");
						sb.append("<option value='0'>No</option>");
						sb.append("<option value='1'>Yes</option>");
						sb.append("</select>");
						sb.append("</td>");
				
						sb.append("<td class='multiControl' width='8%'>");
						sb.append("<div id='itemParaId97"+i+"-"+count+"'"); 
						sb.append("style='display: none;'>"+ws.getString(3)+"</div>");
						
						sb.append("<input type='text' style='width:80px;text-align:right;' id='itemParaId90"+i+"-"+count+"' name='strDefRateText1' class='txtFldMin itemParaId1' maxlength='5' onkeypress='return validateData(event,7);' onkeyup='updateDivValueNew(this);calCost1(this);' tabindex='1'>");
						sb.append("</td>");
						sb.append("<td class='multiControl' width='8%'>");
					
						sb.append("<input type='hidden' name='strReqQty'"); 
						sb.append("id='strReqQty96"+i+"-"+count+"' class='txtFldMin'>");
						sb.append("<div id='strQuantity96"+i+"-"+count+"'");
						sb.append("style='display: none'>0</div>");
						sb.append("<div id='strQuantityText96"+i+"-"+count+"'"); 
						sb.append("style='display: block'>");
						sb.append("<input type='text' name='strQtyText1'"); 
						sb.append(" id='strQtyText95"+i+"-"+count+"' class='txtFldMin' style='text-align:right;' onkeypress='return validateData(event,5);' onkeyup='calCost1(this);'");
						sb.append(" maxlength='5' value='"+ws.getString(4)+"' ");
						sb.append(" tabindex='1'>");
						sb.append("</div>");
				
						sb.append("</td>");
				
						sb.append("<td class='multiControl' width='8%'>");
					
						sb.append("<input type='hidden' name='strTotalCost1' id='strTotalCost"+i+"-"+count+"' class='txtFldMin'>");
						sb.append("<div id='strQuantityText94"+i+"-"+count+"' style='display: block'>");
						sb.append("<input type='text' style='width:80px;text-align:right;' name='strTotalCostText1' id='strTotalCostText94"+i+"-"+count+"' class='txtFldMin' onkeyup='' maxlength='7' readonly=''>");
						sb.append("</div>");
				
						sb.append("</td>");
						
						sb.append("<td class='multiControl' width='8%'>");
						sb.append("<textarea rows='2' cols='5' name='strRemarksText1' style='width: 91px; height: 17px;'>"+ws.getString(13)+"</textarea>");
						sb.append("</td>");
						
						sb.append("<td class='multiControl' width='4%'>");
						sb.append("<div id='strQuantityText93"+i+"-"+count+"'"); 
						sb.append("style='display: block'>");
						sb.append("<img style='cursor: pointer;height:"); 
						sb.append("20px' id='strDeleteButtonDivId"+i+"-"+count+"' ");
						sb.append(" src='../../hisglobal/images/Minus.png'");
						sb.append("onclick=\"deleteRowNew('"+i+"-"+count+"','1','0',this);\" title='Click here to Delete Item'"); 
						sb.append("onkeypress='onPressingEnter(this,event)'>");
						sb.append("</div>");
				
						sb.append("</td>");
						sb.append("</tr>");
						sb.append("</tbody></table>");
						sb.append("</div>");
			
						count++;

					}
					sb.append("<table id='tableTotalModify' class='TABLEWIDTH' cellspacing='0px' cellpadding='0px' align='center'>");
					
					sb.append("<tbody>");
					sb.append("<tr>");
					sb.append("<td class='multiLabel' width='23%'></td>");
					sb.append("<td class='multiLabel' width='8%'></td>");
					sb.append("<td class='multiLabel' width='8%'></td>");
					sb.append("<td class='multiLabel' width='8%'></td>");
					sb.append("<td class='multiLabel' width='8%'>Total Cost</td>");
					sb.append("<td class='multiLabel' id='totalCostModify' width='8%'></td>");
					sb.append("<td class='multiLabel' width='4%'></td>");
					sb.append("</tr>");
					sb.append("</tbody>");
					sb.append("</table>");
										
				}
				else{
					sb.append("<table class='TABLEWIDTH' cellspacing='1px' cellpadding='0px' align='center'>");
					sb.append("<tbody>");
					sb.append("<tr>");
					sb.append("<td class='LABEL' style='color:red;text-align:center;'>No Record Found.</td>");
					sb.append("</tr>");
					sb.append("</tbody>");
					sb.append("</table>");
					
				}
				ws.beforeFirst();	
				
		}
		
		catch(Exception e)
		{
			
			vo.setStrMsgString("DossierItemMstHLP.getItemDetails() --> "
					+ e.getMessage());
			vo.setStrMsgType("1");
		}
		return sb.toString();
	}
	
	/*
	 * Function to get item details for view
	 * 
	 * 
	 * 
	 */
	public static String getItemDetailsForView(DossierItemMstVO vo)
	{
		StringBuffer sb = new StringBuffer("");
		WebRowSet ws=vo.getItemDetailWS();

		int size=4;
		int count=1;
		int i=1;
		System.out.println("Web row set size --->>> "+ws.size());
		try
		{
			sb.append("<table class='TABLEWIDTH' cellspacing='1px' cellpadding='0px' align='center'>");
			sb.append("<tbody><tr>");
			sb.append("<td class='multiLabel' width='23%'>Item Name</td>");
			sb.append("<td class='multiLabel' width='4%'>Is Misc</td>");
			sb.append("<td class='multiLabel' width='4%'>Is Ret.</td>");
			sb.append("<td class='multiLabel' width='8%'>Category</td>");
			sb.append("<td class='multiLabel' width='8%'>Is RC</td>");
			sb.append("<td class='multiLabel' width='8%'>Type</td>");
			sb.append("<td class='multiLabel' width='8%'>Is Brought By Patient</td>");
			sb.append("<td class='multiLabel' width='8%'>Unit Price</td>");
			sb.append("<td class='multiLabel' width='8%'>No. Of Units</td>");
			sb.append("<td class='multiLabel' width='8%'>Remarks</td>");
			sb.append("<td class='multiLabel' width='8%'>RC No.</td>");
			sb.append("</tr>");
			sb.append("</tbody></table>");
			
				if(ws.size()>0){
					while(ws.next()){
						sb.append("<input type='hidden' name='strItemTypeIdArray' value="+ws.getString(8)+">");
						sb.append("<input type='hidden' name='strItemIdArray' value="+ws.getString(6)+">");
						sb.append("<input type='hidden' name='strItemBrandIdArray' value="+ws.getString(5)+">");
						
						sb.append("<div id='id100"+i+"-"+count+"' style='display: block;'>");
						sb.append("<div id='id101"+i+"-"+count+"'>");
						sb.append("<table class='TABLEWIDTH' id='td"+count+"' cellspacing='1px' cellpadding='1px' bgcolor='#6097BC' align='center'>");
						sb.append("<tbody><tr>");
						sb.append("<td class='multiControl' width='23%' align='left'>");
						sb.append("<div id='itemParaId99"+i+"-"+count+"'>");
						sb.append(ws.getString(1));
						sb.append("</div>");
						sb.append("</td>");
				
						sb.append("<td class='multiControl' width='4%'>");
						sb.append("<div id='itemParaId85"+i+"-"+count+"'>"+ws.getString(11)+"</div>");
						sb.append("</td>");
						
						sb.append("<td class='multiControl' width='4%'>");
						sb.append("<div id='itemParaId75"+i+"-"+count+"'>"+ws.getString(12)+"</div>");
						sb.append("</td>");

						sb.append("<td class='multiControl' width='8%'>");
						sb.append("<div id='itemParaId98"+i+"-"+count+"'>"+ws.getString(2)+"</div>");
						sb.append("</td>");
						
						sb.append("<td class='multiControl' width='8%'>");
						sb.append("<div id='itemParaId86"+i+"-"+count+"'>"+ws.getString(13)+"</div>");
						sb.append("</td>");
						
						sb.append("<td class='multiControl' width='8%'>");
						sb.append("<div id='itemParaId87"+i+"-"+count+"'>"+ws.getString(10)+"</div>");
						sb.append("</td>");
				
						sb.append("<td class='multiControl' width='8%'>");
						sb.append("<div id='itemParaId200"+i+"-"+count+"'>"+ws.getString(9)+"</div>");
						sb.append("</td>");
				
						sb.append("<td class='multiControl' width='8%'>");
						sb.append("<div id='itemParaId97"+i+"-"+count+"'"); 
						sb.append("style='display: block;'>"+ws.getString(3)+"</div>");
						sb.append("</td>");
						
						sb.append("<td class='multiControl' width='8%'>");
						sb.append("<div id='strReqQty96"+i+"-"+count+"'"); 
						sb.append("style='display: block;'>"+ws.getString(4)+"</div>");
						sb.append("</td>");
					
						sb.append("<td class='multiControl' width='8%'>");
						sb.append(ws.getString(14));
						sb.append("</td>");

						sb.append("<td class='multiControl' width='8%'>");
						sb.append(ws.getString(15)==null ||ws.getString(15).equalsIgnoreCase("null") ? "NA" : ws.getString(15) );
						sb.append("</td>");
						
						sb.append("</tr>");
						sb.append("</tbody></table>");
						sb.append("</div>");
			
						count++;

					}
										
				}
				else{
					sb.append("<table class='TABLEWIDTH' cellspacing='1px' cellpadding='0px' align='center'>");
					sb.append("<tbody>");
					sb.append("<tr>");
					sb.append("<td class='LABEL' style='color:red;text-align:center;'>No Record Found.</td>");
					sb.append("</tr>");
					sb.append("</tbody>");
					sb.append("</table>");
					
				}
				ws.beforeFirst();	
				
		}
		
		catch(Exception e)
		{
			
			vo.setStrMsgString("DossierItemMstHLP.getItemDetailsForView() --> "
					+ e.getMessage());
			vo.setStrMsgType("1");
		}
		return sb.toString();
	}

}
///////////////////////////////////////////////////////////////////////////////////////////////
