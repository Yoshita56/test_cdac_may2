package dossier.masters.controller.hlp;

import ipd.IpdConfigUtil;

import java.util.ResourceBundle;

import hisglobal.utility.HisUtil;

import javax.sql.rowset.WebRowSet;

import dossier.masters.vo.*;

public class DossierItemBrandMstHLP {
	

	public static String getItemDetails(DossierItemBrandMstVO vo)
	{
		StringBuffer sb = new StringBuffer("");
		WebRowSet ws=vo.getItemDetailWS();
		
		int size=4;
		int count=1;
		int i=1;
		System.out.println("Web row set size in DossierItemBrandMstHLP--->>> "+ws.size());
		try
		{
			sb.append("<table class='TABLEWIDTH' cellspacing='1px' cellpadding='0px' align='center'>");
			sb.append("<tbody><tr>");
			sb.append("<td class='multiLabel' width='23%'>Item Name</td>");
			sb.append("<td class='multiLabel' width='8%'>Category</td>");
			/*sb.append("<td class='multiLabel' width='8%'>Is Brought By Patient</td>");*/
			sb.append("<td class='multiLabel' width='8%'><font color='red'>*</font>Default Cost/Unit</td>");
			sb.append("<td class='multiLabel' width='8%'><font color='red'>*</font>Req. Qty</td>");
			sb.append("<td class='multiLabel' width='8%'><font color='red'>*</font>Approx. Cost</td>");
			sb.append("<td class='multiLabel' width='4%'>Action</td>");
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
						/*sb.append("<div class='popup' style='display:none' id='itemDetailsDivId91"+i+"-"+count+"'>");
						sb.append("<table width='500' cellspacing='0px' cellpadding='0px'>");
						sb.append("<tbody>");
						sb.append("<tr class='HEADER'>");
						sb.append("<th colspan='3' align='left'>");
						sb.append("&nbsp;"+ws.getString(1)+"  - Details");
						sb.append("</th><th align='right'>");
						sb.append("<img style='color: blue; cursor: pointer;' src='../../hisglobal/images/popUp_cancel.JPG' onclick='hide_popup_menu(&quot;itemDetailsDivId91"+i+"-"+count+"'&quot;);'></th></tr></tbody></table>");
						sb.append("<table width='500' cellspacing='1px' cellpadding='1px'>");
						sb.append("<tbody><tr><td class='multiRPTLabel' width='50%'>");
						sb.append("Last Rate</td><td colspan='3' class='multiPOControl' width='50%'>"+ws.getString(3)+"</td></tr><tr><td class='multiRPTLabel' width='25%'>Specification</td><td colspan='3' "
								+ "class='multiPOControl' width='75%'>"+ws.getString(7)+"</td></tr></tbody></table><table width='500' cellspacing='1px' cellpadding='1px'>"
								+ "<tbody><tr class='FOOTER'>");
						sb.append("<td colspan='4'></td></tr></tbody></table>");
						sb.append("</div>");*/
						//sb.append("<a style='color:blue;cursor: pointer;' onclick=''>");
						sb.append(ws.getString(1));
						//sb.append("</a>");
						sb.append("</div>");
						sb.append("</td>");
				

						sb.append("<td class='multiControl' width='8%'>");
						sb.append("<div id='itemParaId98"+i+"-"+count+"'>"+ws.getString(2)+"</div>");
						sb.append("</td>");
				
						/*sb.append("<td class='multiControl' width='8%'>");
						sb.append("<select name='isBroughtByPatient1' tabindex='1'>");
						sb.append("<option value='0'>No</option>");
						sb.append("<option value='1'>Yes</option>");
						sb.append("</select>");
						sb.append("</td>");*/
				
						sb.append("<td class='multiControl' width='8%'>");
						sb.append("<div id='itemParaId97"+i+"-"+count+"'"); 
						sb.append("style='display: none;'>"+ws.getString(3)+"</div>");
						
						sb.append("<input type='text' id='itemParaId90"+i+"-"+count+"' name='strDefRateText1' class='txtFldMin itemParaId1' maxlength='7' onkeyup='calCost1(this);' onkeypress='return validateData(event,7);' tabindex='1'>/No.");
						sb.append("</td>");
						sb.append("<td class='multiControl' width='8%'>");
					
						sb.append("<input type='hidden' name='strReqQty'"); 
						sb.append("id='strReqQty96"+i+"-"+count+"' class='txtFldMin'>");
						sb.append("<div id='strQuantity96"+i+"-"+count+"'");
						sb.append("style='display: none'>0 No.</div>");
						sb.append("<div id='strQuantityText96"+i+"-"+count+"'"); 
						sb.append("style='display: block'>");
						sb.append("<input type='text' name='strQtyText1'"); 
						sb.append("id='strQtyText95"+i+"-"+count+"' class='txtFldMin' onkeyup='calCost1(this);'");
						sb.append(" maxlength='5'  value='"+ws.getString(4)+"' ");
						sb.append("onkeypress='return validateData(event,5);' tabindex='1'> No.");
						sb.append("</div>");
				
						sb.append("</td>");
				
						sb.append("<td class='multiControl' width='8%'>");
					
						sb.append("<input type='hidden' name='strTotalCost1' id='strTotalCost"+i+"-"+count+"' class='txtFldMin'>");
						sb.append("<div id='strQuantityText94"+i+"-"+count+"' style='display: block'>");
						sb.append("<input type='text' name='strTotalCostText1' id='strTotalCostText94"+i+"-"+count+"' class='txtFldMin' onkeyup='' maxlength='5' readonly=''>");
						sb.append("</div>");
				
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
			
			vo.setStrMsgString("DossierItemBrandMstHLP.getItemDetails() --> "
					+ e.getMessage());
			vo.setStrMsgType("1");
		}
		return sb.toString();
	}
	
	public static String getItemDetailsForView(DossierItemBrandMstVO vo)
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
			sb.append("<td class='multiLabel' width='8%'>Category</td>");
			sb.append("<td class='multiLabel' width='8%'>Default Cost/Unit</td>");
			sb.append("<td class='multiLabel' width='8%'>Quantity</td>");
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
				

						sb.append("<td class='multiControl' width='8%'>");
						sb.append("<div id='itemParaId98"+i+"-"+count+"'>"+ws.getString(2)+"</div>");
						sb.append("</td>");
				
						sb.append("<td class='multiControl' width='8%'>");
						sb.append("<div id='itemParaId97"+i+"-"+count+"'"); 
						sb.append("style='display: block;'>"+ws.getString(3)+"</div>");
						sb.append("</td>");
						
						sb.append("<td class='multiControl' width='8%'>");
						sb.append("<div id='strReqQty96"+i+"-"+count+"'"); 
						sb.append("style='display: block;'>"+ws.getString(4)+"</div>");
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
			
			vo.setStrMsgString("DossierItemBrandMstHLP.getItemDetailsForView() --> "
					+ e.getMessage());
			vo.setStrMsgType("1");
		}
		return sb.toString();
	}

	
}

