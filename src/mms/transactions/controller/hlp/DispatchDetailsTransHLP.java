package mms.transactions.controller.hlp;

import hisglobal.exceptions.HisException;

import javax.sql.rowset.WebRowSet;

import mms.MmsConfigUtil;
import mms.transactions.bo.DispatchDetailsTransBO;
import mms.transactions.vo.DispatchDetailsTransVO;

public class DispatchDetailsTransHLP {

	public static String getRequestDetails(String hospCode,String storeId,String itemCatId,String poNo)
	{ 
		StringBuffer br = new StringBuffer();
		DispatchDetailsTransBO bo = null;
		DispatchDetailsTransVO vo = null;
		
		try{
		
			bo = new DispatchDetailsTransBO();
			vo = new DispatchDetailsTransVO();
			vo.setStrHospitalCode(hospCode);
			vo.setStrStoreId(storeId);
			vo.setStrItemCatId(itemCatId);
			vo.setStrPONO(poNo);
			bo.getRequestDetails(vo);
			 WebRowSet wb=vo.getStrRequestDetailsValuesWS();
			
			if(wb.size() != 0)
				{
					 
	                 while (wb.next())
	                    {
	                    	br.append("<TR>");
	                    	br.append("<TD WIDTH='10%' CLASS='multiControl'><input type='checkbox' name='strCheckBoxValue' value="+ wb.getString(1) + "></TD>");
	    				    br.append("<TD WIDTH='45%' CLASS='multiControl'>"+ wb.getString(2) + "</TD>");
	    				    br.append("<TD WIDTH='20%' CLASS='multiControl'>"+ wb.getString(3) + "</TD>");
	    				    br.append("<TD WIDTH='25%' CLASS='multiControl'>"+ wb.getString(4) );
	    				    br.append("<input type='hidden' name='strAdvReqAmt' value='"+wb.getString(6)+"' >"+ "</TD>");
	    				    br.append("</TR>");
	    				}
	                 br.append("</table> ");
				}else{
					br.append("<TR>");
			br.append("<TD WIDTH='25%' CLASS='multiControl' colspan='5'>"
					+ "No Record Found" + "</TD>");
			br.append("</TR>");
			
				}
			
		}catch(Exception e){
			new HisException("Dispatch Details Transaction","DispatchDetailsTransHLP.getRequestDetails()-->",e.getMessage());
		}
	return br.toString();
	}
	
	public static String getBillDetails(String hospCode,String storeId,String itemCatId,String poNo)
	{ 
		StringBuffer br = new StringBuffer();
		DispatchDetailsTransBO bo = null;
		DispatchDetailsTransVO vo = null;
		
		try{
			
			bo = new DispatchDetailsTransBO();
			vo = new DispatchDetailsTransVO();
			vo.setStrHospitalCode(hospCode);
			vo.setStrStoreId(storeId);
			vo.setStrItemCatId(itemCatId);
			vo.setStrPONO(poNo);
			
			bo.getBillDetails(vo);
			 WebRowSet wb=vo.getStrBillDetilsValuesWS();
			
			if(wb.size() != 0)
				{
					 
	                 while (wb.next())
	                    {
	                    	br.append("<TR>");
	                    	br.append("<TD WIDTH='5%' CLASS='multiControl'><input type='checkbox' name='strCheckBoxValue' value="+ wb.getString(1) + "></TD>");
	    				    br.append("<TD WIDTH='15%' CLASS='multiControl'>"+ wb.getString(2) + "</TD>");
	    				    br.append("<TD WIDTH='20%' CLASS='multiControl'>"+ wb.getString(3) + "</TD>");
	    				    br.append("<TD WIDTH='20%' CLASS='multiControl'>"+ wb.getString(4) + "</TD>");
	    				    br.append("<TD WIDTH='20%' CLASS='multiControl'>"+ wb.getString(5) + "</TD>");
	    				    br.append("<TD WIDTH='20%' CLASS='multiControl'>"+ wb.getString(6));
	    				    br.append("<input type='hidden' name='strAdvReqAmt' value='"+wb.getString(7)+"'>"+ "</TD>");
	    				 
	    				    br.append("</TR>");
	    				}
	                 
	                 br.append("</table>");
	                
				}else{
					br.append("<TR>");
			br.append("<TD WIDTH='25%' CLASS='multiControl' colspan='7'>"
					+ "No Record Found" + "</TD>");
			br.append("</TR>");
			
				}
			
		}catch(Exception e){
			new HisException("Dispatch Details Transaction","DispatchDetailsTransHLP.getBillDetails()-->",e.getMessage());
		}
	return br.toString();
	}
	
    public static String getDispatchDetails(WebRowSet ws , String strStoreId , String strHospitalCode) 
	 {
		StringBuffer sb = new StringBuffer("");
		int start = 1;
		final int REC_PER_PAGE = 10;
		final int PAGE_PER_BLOCK = 10;
		
		MmsConfigUtil mcu = null;
		
		int totalFetchRecord = (REC_PER_PAGE * PAGE_PER_BLOCK) + 1;
		int totalRecordsToManipulate = totalFetchRecord - 1;
		
	    try
	    {
	    	mcu = new MmsConfigUtil(strHospitalCode);
	    	
	    	
	    	String[] strStartYr = mcu.getStrFinancialStartDate(strStoreId , strHospitalCode).replace("-","@").split("@");
	    	String[] strEndYr = mcu.getStrFinancialEndDate(strStoreId , strHospitalCode).replace("-","@").split("@");
	    	
	    	
	    	
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
			 
			 sb.append("<input type='hidden' name='TotalLayer'  value='"+totalLayer+"'>");
			 sb.append("<input type='hidden' name='RecordShowOnPage'  value='"+REC_PER_PAGE+"'>");
			 sb.append("<table class='TABLEWIDTH' align='center' cellspacing='1px'>");
			 sb.append("<tr>");
			 sb.append("<td class='TITLE' >Dispatch Details For Financial Year : "+strStartYr[2]+"-"+strEndYr[2]);
			 sb.append("</td></tr>");
			 sb.append("<tr>");
			 sb.append("<td class='LABEL' >");

			 for (int i = 1; i <= totalLayer; i++)
			 {
				sb.append("<a STYLE='cursor:pointer;cursor:pointer;' color:'blue' onClick='GetIndex(\""+i+"\",\""+totalLayer+"\")'>" + (i+start-1)
						+ "</a> &nbsp;");
			 }
			sb.append("</td>");
			sb.append("</tr>");
		//	sb.append("<tr><td class='LABEL'><div id='pageNavPosition'></div></td></tr>");
			sb.append("</table>");
			sb.append("<table class='TABLEWIDTH' align='center' cellspacing='1px'>");
	        sb.append("<tr>");
	        sb.append("<td width='17%'class='multiLabel'>Dispatch No");
		    sb.append("</td>");
	        sb.append("<td width='15%'class='multiLabel'>Dispatch Date");
	        sb.append("</td>");
	        sb.append("<td width='15%'class='multiLabel'>Inst For");
	        sb.append("</td>");
	        sb.append("<td width='17%'class='multiLabel'>PO No");
	        sb.append("</td>");
	        sb.append("<td width='21%'class='multiLabel'>Supplier");
		    sb.append("</td>");
		    sb.append("<td width='15%'class='multiLabel'>Inst Amt");
		    sb.append("</td>");
	        sb.append("</tr>");
	        sb.append("</table>");
	        
		    for (int i = 1; i <= totalLayer; i++) 
		    {
			 if (i <= totalLayer) 
			 {
				 
				if (i == 1) 
				{
					sb.append("<div id='DivId" +i+ "' style='display:block'>");
				} 
				else
				{
					sb.append("<div id='DivId" +i+ "' style='display:none'>");
				}
				
				sb.append("<table class='TABLEWIDTH' align='center' cellspacing='1px'>");
				for (int j = 0; j < REC_PER_PAGE; j++) 
				{
					if(ws.next()){
					sb.append("<tr>");
					sb.append("<td class='multiControl' width='17%'>");
					sb.append(ws.getString(1));
					sb.append("</td>");
					sb.append("<td class='multiControl' width='15%'>");
					sb.append(ws.getString(2));
					sb.append("</td>");
					sb.append("<td class='multiControl' width='15%'>");
					sb.append(ws.getString(3));
					sb.append("</td>");
					sb.append("<td class='multiControl' width='17%'>");
					sb.append(ws.getString(4));
					sb.append("</td>");
					sb.append("<td class='multiControl' width='21%'>");
					sb.append(ws.getString(5));
					sb.append("</td>");
					sb.append("<td class='multiControl' width='15%'>");
					sb.append(ws.getString(6));
					sb.append("</td>");
					sb.append("</tr>");
					}else{
						break;
					}
				}
				sb.append("</table>");
				sb.append("</div>");

			} 
			else 
			{
				sb.append("<div id='DivId" + i+ "' style='display:none'>");
				
				sb.append("<table class='TABLEWIDTH' align='center' cellspacing='1px'>");
				for (int k = 0; k < reminder; k++) 
				{
					ws.next();
					sb.append("<tr><td class='multiControl' width='17%'>");
					sb.append(ws.getString(1));
					sb.append("</td>");
					sb.append("<td class='multiControl' width='15%'>");
					sb.append(ws.getString(2));
					sb.append("</td>");
					sb.append("<td class='multiControl' width='15%'>");
					sb.append(ws.getString(3));
					sb.append("</td>");
					sb.append("<td class='multiControl' width='17%'>");
					sb.append(ws.getString(4));
					sb.append("</td>");
					sb.append("<td class='multiControl' width='21%'>");
					sb.append(ws.getString(5));
					sb.append("</td>");
					sb.append("<td class='multiControl' width='15%'>");
					sb.append(ws.getString(6));
					sb.append("</td>");
					sb.append("</tr>");
				}
				sb.append("</table>");
				sb.append("</div>");
				}
		   	}
		sb.append("</td>");
		sb.append("</tr>");
		sb.append("</table>");
		 }else{
			 sb.append("<table class='TABLEWIDTH' align='center' cellspacing='1px'>");
			 sb.append("<tr><td colspan='5' bgcolor='black'></td></tr>");
			   sb.append("<TR>");
			   sb.append("<TD WIDTH='25%' align='center' CLASS='multiControl' colspan='5'><font color = 'red'>"
						+ "No Record Found" + "</font></TD>");
			   sb.append("</TR>");
			   sb.append("<tr><td colspan='5' bgcolor='black'></td></tr>");
			   sb.append("</table>");
				
		   }
	   } 
	 }
	 catch(Exception e)
	 {
		    e.printStackTrace();
		    new HisException("Dispatch Details Transaction","DispatchDetailsTransHLP.getDispatchDetails()-->",e.getMessage());
	    }
	     
	    return sb.toString();
	 	}

}
