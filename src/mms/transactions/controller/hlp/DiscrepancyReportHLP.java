package mms.transactions.controller.hlp;

import hisglobal.utility.HisUtil;

import javax.sql.rowset.WebRowSet;

import mms.transactions.bo.DiscrepancyReportGlobalBO;
import mms.transactions.vo.DiscrepancyReportGlobalVO;

public class DiscrepancyReportHLP {

public static String getGroupCombo(String hospCode,String strStoreId,String stockNo){
	
	StringBuffer buff=null;
	String strGroupList="";
	DiscrepancyReportGlobalVO vo=null;
	DiscrepancyReportGlobalBO bo=null;
	HisUtil util=null;
	try{
		vo=new DiscrepancyReportGlobalVO();
		bo=new DiscrepancyReportGlobalBO();
		buff=new StringBuffer();
		vo.setStrHospitalCode(hospCode);
		vo.setStrStoreId(strStoreId);
		vo.setStrStockNo(stockNo);
		util = new HisUtil("MMS Transaction", "Physical Stock Verification");
		//System.out.println("Chk1");
		bo.getGroupCombo(vo);
		//System.out.println("Chk1asdsad"+vo.getStrGroupWs().size());
		if (vo.getStrGroupWs().size() != 0) {
			strGroupList = util.getOptionValue(vo.getStrGroupWs(), "0",
					"0^Select Value", true);

		}else{
			strGroupList="<option value='0'>Select Value</option>";
		}
			
		buff.append("<table  class='TABLEWIDTH' align='center' cellspacing='1px' cellpadding='1px'>");
 		buff.append("<tr><td class='LABEL' width='25%'><font color='red'>*</font>Group Name </td>"); 
 		buff.append("<td class='CONTROL' width='25%'>");
		buff.append("<select class='comboNormal' name='strGroupId' onchange='resetList();'> ");
		buff.append(strGroupList);
		buff.append("</select>");
		buff.append("</td>");
		buff.append("<td class='LABEL' width='25%' colspan='2'>");
		buff.append("<div align='center'><img style='cursor: pointer;' src='../../hisglobal/images/Go.png' onclick='fetchDiscrepancyReport();' name='searchName' title='Click here to Search Item'>");
		buff.append("</div></td></tr></table>");
		
		
	}catch(Exception e){
		try{
			throw new Exception("DiscrepancyReportHLP----->getGroupCombo"+e.getMessage());
		}catch(Exception e1){
			
		}
	}
	
	return buff.toString();
}
public static String getNonDiscrepancyReport(String hospCode,String strStoreId,String stockNo,String strGroupId){
	
		
		StringBuffer buff=null;
		int start = 1;
		final int REC_PER_PAGE = 10;
		final int PAGE_PER_BLOCK = 10;
		int totalFetchRecord = (REC_PER_PAGE * PAGE_PER_BLOCK) + 1;
		int totalRecordsToManipulate = totalFetchRecord - 1;
		
		int count=0;
		WebRowSet ws=null;
		DiscrepancyReportGlobalVO vo=null;
		DiscrepancyReportGlobalBO bo=null;
		
		try{
			
			vo=new DiscrepancyReportGlobalVO();
			bo=new DiscrepancyReportGlobalBO();
			buff=new StringBuffer();
			vo.setStrHospitalCode(hospCode);
			vo.setStrStoreId(strStoreId);
			vo.setStrStockNo(stockNo);
			vo.setStrGroupId(strGroupId);
			bo.getNonDiscrepancyReport(vo);
			ws=vo.getDiscrepancyWs();
			if (ws != null) 
			{
				if(ws.size() != 0)
				{
					int actualFetchRecord = ws.size();
			
		         if(totalFetchRecord != actualFetchRecord)
				 {
					totalFetchRecord = actualFetchRecord;
					totalRecordsToManipulate = actualFetchRecord;
				 }
				 int totalLayer = totalRecordsToManipulate / REC_PER_PAGE;
				 int reminder = totalRecordsToManipulate % REC_PER_PAGE;
				 if (reminder > 0)
					totalLayer = totalLayer + 1;
				 
				 buff.append("<input type='hidden' name='TotalLayer'  value='").append(totalLayer).append("'>");
				 buff.append("<input type='hidden' name='RecordShowOnPage'  value='").append(REC_PER_PAGE).append("'>");
				 buff.append("<table class='TABLEWIDTH' align='center' cellspacing='1px'>");
				 buff.append("<tr>");
				 buff.append("<td class='LABEL' >");

				 for (int i = 1; i <= totalLayer; i++)
				 {
					buff.append("<a STYLE='cursor:pointer;cursor:pointer;' color:'blue' onClick='GetIndex(\"").append(i).append("\",\"").append(totalLayer).append("\")'>" ).append( (i+start-1)
							).append( "</a> &nbsp;");
				 }
				buff.append("</td>");
				buff.append("</tr>");
			//	buff.append("<tr><td class='LABEL'><div id='pageNavPosition'></div></td></tr>");
				buff.append("</table>");
				buff.append("<table class='TABLEWIDTH' align='center'cellpadding='1px' cellspacing='1px' bgcolor='black'>");
		        buff.append("<tr>");
		        buff.append("<td width='14.29%'class='multiLabel'>Item Name");
			    buff.append("</td>");
		        buff.append("<td width='14.29%'class='multiLabel'>Inhand Qty");
		        buff.append("</td>");
		        buff.append("<td width='14.29%'class='multiLabel'>Tolerance Limit");
		        buff.append("</td>");
		        buff.append("<td width='14.29%'class='multiLabel'>Counted Qty");
		        buff.append("</td>");
		        buff.append("<td width='14.29%'class='multiLabel'>Variance Qty");
			    buff.append("</td>");
			    buff.append("<td width='14.29%'class='multiLabel'>Variance Cost");
			    buff.append("</td>");
			    buff.append("<td width='14.29%'class='multiLabel'>#");
			    buff.append("</td>");
		        buff.append("</tr>");
		        buff.append("</table>");
		        
			    for (int i = 1; i <= totalLayer; i++) 
			    {
				 if (i <= totalLayer) 
				 {
					 
					if (i == 1) 
					{
						buff.append("<div id='DivId" ).append(i).append( "' style='display:block'>");
					} 
					else
					{
						buff.append("<div id='DivId" ).append(i).append( "' style='display:none'>");
					}
					
					buff.append("<table class='TABLEWIDTH' align='center' cellspacing='1px' bgcolor='black' cellpadding='1px'>");
					for (int j = 0; j < REC_PER_PAGE; j++) 
					{
						if(ws.next()){
						buff.append("<tr>");
						
						
						
						buff.append("<td width='14.29%' class='multiControl'><a  onclick=openSpecification('strItemDtl',this,").append((++count)).append("); style='color:blue; cursor:pointer;' title='Click Here To View Item Detail' >").append(ws.getString(1)).append("</a>");
						buff.append("<input type='hidden' name='strItemDtl' id='strItemDtl").append(count).append("' value='").append(ws.getString(1)).append("@").append(ws.getString(7)).append("@").append(ws.getString(8)).append("@").append(ws.getString(9)).append("' >");
						buff.append("<input type='hidden' name='strItemParamDtl' id='strItemParamDtl").append(count).append("' value='").append(ws.getString(10)).append("' >");
						buff.append("</td>");
						
						
						buff.append("<td class='multiControl' width='14.29%'>");
						buff.append(ws.getString(2));
						buff.append("</td>");
						buff.append("<td class='multiControl' width='14.29%'>");
						buff.append(ws.getString(3));
						buff.append("</td>");
						buff.append("<td class='multiControl' width='14.29%'>");
						buff.append(ws.getString(4));
						buff.append("</td>");
						buff.append("<td class='multiControl' width='14.29%'>");
						buff.append(ws.getString(5));
						buff.append("</td>");
						buff.append("<td class='multiControl' width='14.29%'>");
						buff.append(ws.getString(6));
						buff.append("</td>");
						buff.append("<td class='multiControl' width='14.29%'>");
						buff.append("<img src='../../hisglobal/images/viewDetails.gif'").append(
							"onClick=openBatchwiseDtl('strItemParamDtl',this,").append(count).append("); style='cursor: pointer; ' title='Click here to view batch wise detail'/>");
						buff.append("</td>");
						buff.append("</tr>");
						}else{
							break;
						}
					}
					buff.append("</table>");
					buff.append("</div>");

				} 
				else 
				{
					buff.append("<div id='DivId" ).append( i).append( "' style='display:none'>");
					
					buff.append("<table class='TABLEWIDTH' align='center' cellspacing='1px' bgcolor='black' cellpadding='1px'>");
					for (int k = 0; k < reminder; k++) 
					{
						ws.next();
						buff.append("<tr>");
						buff.append("<td width='14.29%' class='multiControl'><a  onclick=openSpecification('strItemDtl',this,").append((++count)).append("); style='color:blue; cursor:pointer;' title='Click Here To View Item Detail' >").append(ws.getString(1)).append("</a>");
						buff.append("<input type='hidden' name='strItemDtl' id='strItemDtl").append(count).append("' value='").append(ws.getString(1)).append("@").append(ws.getString(7)).append("@").append(ws.getString(8)).append("@").append(ws.getString(9)).append("' >");
						buff.append("<input type='hidden' name='strItemParamDtl' id='strItemParamDtl").append(count).append("' value='").append(ws.getString(10)).append("' >");
						buff.append("</td>");
						buff.append("<td class='multiControl' width='14.29%'>");
						buff.append(ws.getString(2));
						buff.append("</td>");
						buff.append("<td class='multiControl' width='14.29%'>");
						buff.append(ws.getString(3));
						buff.append("</td>");
						buff.append("<td class='multiControl' width='14.29%'>");
						buff.append(ws.getString(4));
						buff.append("</td>");
						buff.append("<td class='multiControl' width='14.29%'>");
						buff.append(ws.getString(5));
						buff.append("</td>");
						buff.append("<td class='multiControl' width='14.29%'>");
						buff.append(ws.getString(6));
						buff.append("</td>");
						buff.append("<td class='multiControl' width='14.29%'>");
						buff.append("<img src='../../hisglobal/images/viewDetails.gif'").append(
						"onClick=openBatchwiseDtl('strItemParamDtl',this,").append(count).append("); style='cursor: pointer; ' title='Click here to view batch wise detail'/>");
						buff.append("</td>");
						buff.append("</tr>");
					
					}
					buff.append("</table>");
					buff.append("</div>");
					}
			   	}
			buff.append("</td>");
			buff.append("</tr>");
			buff.append("</table>");
			}
			else
			{
				buff.append("<table class='TABLEWIDTH' align='center' cellspacing='1px' bgcolor='black' cellpadding='1px'>");
				buff.append("<tr>");
				buff.append("<td class='multiControl'><font color='red'>No Record Found</font></td>");
				buff.append("</tr>");
				buff.append("</table>");
			}
		}

			
		}catch(Exception e){
			try{
				e.printStackTrace();
				throw new Exception("DiscrepancyReportHLP----->getNonDiscrepancyReport"+e.getMessage());
			}catch(Exception e1){
				
			}
		}
		return buff.toString();
		
	}

public static String getDiscrepancyReport(String hospCode,String strStoreId,String stockNo){
	
	
	StringBuffer buff=null;
	int start = 1;
	final int REC_PER_PAGE = 10;
	final int PAGE_PER_BLOCK = 10;
	int totalFetchRecord = (REC_PER_PAGE * PAGE_PER_BLOCK) + 1;
	int totalRecordsToManipulate = totalFetchRecord - 1;
	WebRowSet ws=null;
	DiscrepancyReportGlobalVO vo=null;
	DiscrepancyReportGlobalBO bo=null;
	int count=0;
	try{
		
		vo=new DiscrepancyReportGlobalVO();
		bo=new DiscrepancyReportGlobalBO();
		buff=new StringBuffer();
		vo.setStrHospitalCode(hospCode);
		vo.setStrStoreId(strStoreId);
		vo.setStrStockNo(stockNo);
		bo.getDiscrepancyReport(vo);
		ws=vo.getDiscrepancyWs();
		if (ws != null) 
		{
			if(ws.size() != 0)
			{
				int actualFetchRecord = ws.size();
		
	         if(totalFetchRecord != actualFetchRecord)
			 {
				totalFetchRecord = actualFetchRecord;
				totalRecordsToManipulate = actualFetchRecord;
			 }
			 int totalLayer = totalRecordsToManipulate / REC_PER_PAGE;
			 int reminder = totalRecordsToManipulate % REC_PER_PAGE;
			 if (reminder > 0)
				totalLayer = totalLayer + 1;
			 
			 buff.append("<input type='hidden' name='TotalLayer'  value='").append(totalLayer).append("'>");
			 buff.append("<input type='hidden' name='RecordShowOnPage'  value='").append(REC_PER_PAGE).append("'>");
			 buff.append("<table class='TABLEWIDTH' align='center' cellspacing='1px'>");
			 buff.append("<tr>");
			 buff.append("<td class='LABEL' >");

			 for (int i = 1; i <= totalLayer; i++)
			 {
				buff.append("<a STYLE='cursor:pointer;cursor:pointer;' color:'blue' onClick='GetIndex(\"").append(i).append("\",\"").append(totalLayer).append("\")'>" ).append( (i+start-1)
						).append( "</a> &nbsp;");
			 }
			buff.append("</td>");
			buff.append("</tr>");
		//	buff.append("<tr><td class='LABEL'><div id='pageNavPosition'></div></td></tr>");
			buff.append("</table>");
			buff.append("<table class='TABLEWIDTH' align='center'cellpadding='1px' cellspacing='1px' bgcolor='black'>");
	        buff.append("<tr>");
	        buff.append("<td width='14.29%'class='multiLabel'>Item Name");
		    buff.append("</td>");
	        buff.append("<td width='14.29%'class='multiLabel'>Inhand Qty");
	        buff.append("</td>");
	        buff.append("<td width='14.29%'class='multiLabel'>Tolerance Limit");
	        buff.append("</td>");
	        buff.append("<td width='14.29%'class='multiLabel'>Counted Qty");
	        buff.append("</td>");
	        buff.append("<td width='14.29%'class='multiLabel'>Variance Qty");
		    buff.append("</td>");
		    buff.append("<td width='14.29%'class='multiLabel'>Variance Cost");
		    buff.append("</td>");
		    buff.append("<td width='14.29%'class='multiLabel'>#");
		    buff.append("</td>");
	        buff.append("</tr>");
	        buff.append("</table>");
	        
		    for (int i = 1; i <= totalLayer; i++) 
		    {
			 if (i <= totalLayer) 
			 {
				 
				if (i == 1) 
				{
					buff.append("<div id='DivId" ).append(i).append( "' style='display:block'>");
				} 
				else
				{
					buff.append("<div id='DivId" ).append(i).append( "' style='display:none'>");
				}
				
				buff.append("<table class='TABLEWIDTH' align='center' cellspacing='1px' bgcolor='black' cellpadding='1px'>");
				for (int j = 0; j < REC_PER_PAGE; j++) 
				{
					if(ws.next()){
					buff.append("<tr>");
					buff.append("<td width='14.29%' class='multiControl'><a  onclick=openSpecification('strItemDtl1',this,").append((++count)).append("); style='color:blue; cursor:pointer;' title='Click Here To View Item Detail' >").append(ws.getString(1)).append("</a>");
					buff.append("<input type='hidden' name='strItemDtl1' id='strItemDtl1").append(count).append("' value='").append(ws.getString(1)).append("@").append(ws.getString(7)).append("@").append(ws.getString(8)).append("@").append(ws.getString(9)).append("' >");
					buff.append("<input type='hidden' name='strItemParamDtl1' id='strItemParamDtl1").append(count).append("' value='").append(ws.getString(10)).append("' >");
					
					buff.append("</td>");
					buff.append("<td class='multiControl' width='14.29%'>");
					buff.append(ws.getString(2));
					buff.append("</td>");
					buff.append("<td class='multiControl' width='14.29%'>");
					buff.append(ws.getString(3));
					buff.append("</td>");
					buff.append("<td class='multiControl' width='14.29%'>");
					buff.append(ws.getString(4));
					buff.append("</td>");
					buff.append("<td class='multiControl' width='14.29%'>");
					buff.append(ws.getString(5));
					buff.append("</td>");
					buff.append("<td class='multiControl' width='14.29%'>");
					buff.append(ws.getString(6));
					buff.append("</td>");
					buff.append("<td class='multiControl' width='14.29%'>");
					buff.append("<img src='../../hisglobal/images/viewDetails.gif'").append(
					"onClick=openBatchwiseDtl('strItemParamDtl1',this,").append(count).append("); style='cursor: pointer; ' title='Click here to view batch wise detail'/>");
					buff.append("</td>");
					buff.append("</tr>");
					}else{
						break;
					}
				}
				buff.append("</table>");
				buff.append("</div>");

			} 
			else 
			{
				buff.append("<div id='DivId" ).append( i).append( "' style='display:none'>");
				
				buff.append("<table class='TABLEWIDTH' align='center' cellspacing='1px' bgcolor='black' cellpadding='1px'>");
				for (int k = 0; k < reminder; k++) 
				{
					ws.next();
					buff.append("<tr>");
					buff.append("<td width='14.29%' class='multiControl'><a  onclick=openSpecification('strItemDtl1',this,").append((++count)).append("); style='color:blue; cursor:pointer;' title='Click Here To View Item Detail' >").append(ws.getString(1)).append("</a>");
					buff.append("<input type='hidden' name='strItemDtl1' id='strItemDtl1").append(count).append("' value='").append(ws.getString(1)).append("@").append(ws.getString(7)).append("@").append(ws.getString(8)).append("@").append(ws.getString(9)).append("' >");
					buff.append("<input type='hidden' name='strItemParamDtl1' id='strItemParamDtl1").append(count).append("' value='").append(ws.getString(10)).append("' >");
					buff.append("</td>");
					buff.append("<td class='multiControl' width='14.29%'>");
					buff.append(ws.getString(2));
					buff.append("</td>");
					buff.append("<td class='multiControl' width='14.29%'>");
					buff.append(ws.getString(3));
					buff.append("</td>");
					buff.append("<td class='multiControl' width='14.29%'>");
					buff.append(ws.getString(4));
					buff.append("</td>");
					buff.append("<td class='multiControl' width='14.29%'>");
					buff.append(ws.getString(5));
					buff.append("</td>");
					buff.append("<td class='multiControl' width='14.29%'>");
					buff.append(ws.getString(6));
					buff.append("</td>");
					buff.append("<td class='multiControl' width='14.29%'>");
					buff.append("<img src='../../hisglobal/images/viewDetails.gif'").append(
					"onClick=openBatchwiseDtl('strItemParamDtl1',this,").append(count).append("); style='cursor: pointer; ' title='Click here to view batch wise detail'/> ");
					buff.append("</td>");
					buff.append("</tr>");
				
				}
				buff.append("</table>");
				buff.append("</div>");
				}
		   	}
		buff.append("</td>");
		buff.append("</tr>");
		buff.append("</table>");
		}
		else
		{
			buff.append("<table class='TABLEWIDTH' align='center' cellspacing='1px' bgcolor='black' cellpadding='1px'>");
			buff.append("<tr>");
			buff.append("<td class='multiControl'><font color='red'>No Record Found</font></td>");
			buff.append("</tr>");
			buff.append("</table>");
		}
	}

		
	}catch(Exception e){
		try{
			e.printStackTrace();
			throw new Exception("DiscrepancyReportHLP----->getNonDiscrepancyReport"+e.getMessage());
		}catch(Exception e1){
			
		}
	}
	return buff.toString();
	
}

public static String getBatchWiseDtl(WebRowSet ws){
	
	StringBuffer buff=null;
	try{
			buff=new StringBuffer();
			if(ws!=null){
				
				buff.append("<table width='400' border='0' cellspacing ='1px' cellpadding='1px'>");
				buff.append("<tr class='HEADER'>"); 
						buff.append("<th align='left' colspan='4' >Batch Wise Detail</th>");
								buff.append("<th align='right'><img  style='cursor:pointer;cursor:pointer' src='../../hisglobal/images/popUp_cancel.JPG'");
										buff.append("onClick=closeItemPopUp('batchWiseId'); title='Click Here To Close Popup'></th></tr>");
				buff.append("<tr>");
				buff.append("<td class='multiLabel' width='20%'>Batch No.</td>");
				buff.append("<td class='multiLabel' width='20%'>Rate/Unit</td>");
				buff.append("<td class='multiLabel' width='20%'>Expiry Date</td>");
				buff.append("<td class='multiLabel' width='20%'>Aval Qty</td>");
				buff.append("<td class='multiLabel' width='20%'>Counted Qty</td>");
				buff.append("</tr>");
				if(ws.size()!=0){
					
								
								while(ws.next()){
									buff.append("<tr>");
									buff.append("<td class='multiControl' width='20%'>").append(ws.getString(1)).append("</td>");
									buff.append("<td class='multiControl' width='20%'>").append(ws.getString(2)).append("</td>");
									buff.append("<td class='multiControl' width='20%'><font color='red'>").append(ws.getString(3)).append("</font></td>");
									buff.append("<td class='multiControl' width='20%'>").append(ws.getString(4)).append("</td>");
									buff.append("<td class='multiControl' width='20%'>").append(ws.getString(5)).append("</td>");
									buff.append("</tr>");
								}
				
				}else{
						buff.append("<tr>");
						buff.append("<td class='multiControl' colspan='5'><font color='red'>No Record Found</font></td>");
						buff.append("</tr>");
						
				}
				
				buff.append("<tr class='FOOTER'>");
				buff.append("<td colspan='5'></td>");
				buff.append("</tr>");
				buff.append("</table>");
			}
			
		
	}catch(Exception _err){
		try{
			_err.printStackTrace();
			throw new Exception("DiscrepancyReportHLP----->getBatchWiseDtl"+_err.getMessage());
		}catch(Exception e1){
			
		}
	}
	return buff.toString();
}


}
