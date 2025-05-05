/**
 * 
 */
package mms.transactions.controller.hlp;

import hisglobal.exceptions.HisException;

import javax.sql.rowset.WebRowSet;

import mms.MmsConfigUtil;
import mms.transactions.controller.fb.QualityCheckControlTransFB;
import mms.transactions.vo.QualityCheckControlTransVO;
import mms.transactions.vo.SampleSentTransVO;

/**
 * @author user
 *
 */
public class QualityCheckControlTransHLP {
	
	public static String createMemberDetails(QualityCheckControlTransFB formBean)
	{ 
		StringBuffer br = new StringBuffer();
		WebRowSet wb1=null;
		int count=0;
			try{
				wb1=formBean.getCommitteMemberWS();
				br.append("<table width='400'>\n");
				br.append("<tr class='HEADER'>\n");
				br.append("<td colspan='2'>Committee Member Details</td>");
				br.append("</tr>\n");
				br.append("<tr>\n");
				br.append("<td class='multiLabel'>\n");
				br.append("Committe Member Name");
				br.append("</td>");
				br.append("<td class='multiLabel'>\n");
				br.append("Recommendation");
				br.append("</td>");
				br.append("</tr>\n");
				
				//System.out.println("size of Webrowsswt"+wb1.size());
				if(wb1!=null && wb1.size()!=0){
					
					
					while(wb1.next())
					{
						br.append("<tr>\n");
						br.append("<td class='multiControl'>\n");
						br.append("<input type='hidden' name='strCommitteeMemberHidden' value='"+wb1.getString(1)+"' id='strCommitteeMemberHiddenId="+(++count)+"'/>");
						br.append(wb1.getString(2)+"</td>");
						br.append("<td class='multiControl'>\n");
						br.append("<textarea rows='2' cols='15' name='strMemberRecommendation'></textarea>");
						br.append("</td>");
						br.append("</tr>\n");
					}
				}
				else
				{
					br.append("<tr>\n");
					br.append("<td class='multiControl' colspan='2'>\n");
					br.append("No Record Found");
					br.append("</tr>\n");
				}
				
				br.append("<tr class='FOOTER'>");
				br.append("<td colspan='2' align ='center'></td>");
				br.append("</tr>");
				br.append("<tr>\n");
				br.append("<td  colspan='2' align='center'>\n");
				
				br.append("<img src='../../hisglobal/images/btn-ok.png' 	onClick='closePopUpDiv();' style='cursor: pointer;' title='Click Here To Save Remarks'>&nbsp;");
				br.append("<img src='../../hisglobal/images/btn-clr.png' onClick='clearData();' style='cursor: pointer;' title='Click Here To Clear Data'>&nbsp;");
				br.append("<img src='../../hisglobal/images/close_tab.png' onClick='closePopUpDiv();' style='cursor: pointer;' title='Click Here To Close Popup'>");
				
				br.append("</tr>\n");
				br.append("</table>");
		
		}catch(Exception e){
			try{
				////System.out.println("Error"+e.getMessage());
				throw new Exception(e.getMessage());
			}
			catch(Exception e1)
			{}
		}
		finally
		{
			wb1=null;
			
		}
	return br.toString();
	}
	
	public static String getViewSampleSentDetails(QualityCheckControlTransVO vo) 
	 {
		StringBuffer sb = new StringBuffer("");
		int start = 1;
		final int REC_PER_PAGE = 10;
		final int PAGE_PER_BLOCK = 10;
		int count=0;
		
		MmsConfigUtil mcu = null;
		WebRowSet ws = null;
		int totalFetchRecord = (REC_PER_PAGE * PAGE_PER_BLOCK) + 1;
		int totalRecordsToManipulate = totalFetchRecord - 1;
		
	    try
	    {
	    	mcu = new MmsConfigUtil(vo.getStrHospitalCode());
	    	ws = vo.getQualityViewWS();
	    	
		if (ws != null) 
		{
			if(ws.size() != 0)
			{
				//System.out.println("Hello1");
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
			 
			 sb.append("<input type='hidden' name='TotalLayer'  value='").append(totalLayer).append("'>");
			 sb.append("<input type='hidden' name='RecordShowOnPage'  value='").append(REC_PER_PAGE).append("'>");
			 sb.append("<table class='TABLEWIDTH' align='center' cellspacing='1px'>");
			 sb.append("<tr>");
			 sb.append("<td class='LABEL' >");

			 for (int i = 1; i <= totalLayer; i++)
			 {
				sb.append("<a STYLE='cursor:pointer;cursor:pointer;' color:'blue' onClick='GetIndex(\"").append(i).append("\",\"").append(totalLayer).append("\")'>" ).append( (i+start-1)
						).append( "</a> &nbsp;");
			 }
			sb.append("</td>");
			sb.append("</tr>");
		//	sb.append("<tr><td class='LABEL'><div id='pageNavPosition'></div></td></tr>");
			sb.append("</table>");
			sb.append("<table class='TABLEWIDTH' align='center'cellpadding='1px' cellspacing='1px' bgcolor='black'>");
	        sb.append("<tr>");
	        sb.append("<td width='15%'class='multiLabel'>Lab Name");
	        sb.append("</td>");
	        sb.append("<td width='30%'class='multiLabel'>Drug Name");
	        sb.append("</td>");
	        sb.append("<td width='10%'class='multiLabel'>Batch No.");
	        sb.append("</td>");
	        sb.append("<td width='15%'class='multiLabel'>Exp Date");
		    sb.append("</td>");
		    sb.append("<td width='10%'class='multiLabel'>CTR No.");
		    sb.append("</td>");
		    sb.append("<td width='10%'class='multiLabel'>QC Status");
		    sb.append("</td>");
		    sb.append("<td width='10%'class='multiLabel'>Report Date");
		    sb.append("</td>");
	        sb.append("</tr>");
	        sb.append("</table>");
	        
		    for (int i = 1; i <= totalLayer; i++) 
		    {
			 if (i <= totalLayer) 
			 {
				 
				if (i == 1) 
				{
					sb.append("<div id='DivId" ).append(i).append( "' style='display:block'>");
				} 
				else
				{
					sb.append("<div id='DivId" ).append(i).append( "' style='display:none'>");
				}
				
				sb.append("<table class='TABLEWIDTH' align='center' cellspacing='1px' bgcolor='black' cellpadding='1px'>");
				for (int j = 0; j < REC_PER_PAGE; j++) 
				{
					/*
					 1- Item Id
					 2- Lab Sent Date
					 3- Sent Store Name
					 4- Generic Name
					 5-Brand Name
					 6- Batch
					 7-Exp Date
					 8-Transfer Qty
					 9-Store Id Sent
					 10-Item Id
					 11-Item Brand ID
					 12-Rate With Unit
					 13-Rate Base value
					 14-Consumed Qty
					 15=Consumed Qty Wit Unit
					 16-Qty Base Value
					 17-Item Sl No
					 18-Item Sl No
					 19-Catg Code
					 20- Lab Send No
					 21-Lab Name
					 22-CTR Number
					 23-Net Cost
					 24-PO No
					 25-PO Date
					 26-Mfd Date
					 27-Is Send Decode Value
                    28-Lab No
                    29-Manufacter By
                    30.QC Status
                    31. Report Date
                    */
					if(ws.next())
					{
					String strCheckHidValue = ws.getString(1)+"^"+ws.getString(2)+"^"+ws.getString(3)+"^"+ws.getString(4)+"^"+ws.getString(5)+"^"+ws.getString(6)+"^"+ws.getString(7)+"^"+ws.getString(8)+"^"+ws.getString(9)
					                          +"^"+ws.getString(10)+"^"+ws.getString(11)+"^"+ws.getString(12)+"^"+ws.getString(13)+"^"+ws.getString(14)+"^"+ws.getString(15)+"^"+ws.getString(16)+"^"+ws.getString(17)+"^"+ws.getString(18)
					                          +"^"+ws.getString(19)+"^"+ws.getString(20)+"^"+ws.getString(21)+"^"+ws.getString(22)+"^"+ws.getString(23)+"^"+ws.getString(24)+"^"+ws.getString(25)+"^"+ws.getString(26)+"^"+ws.getString(27)+"^"+ws.getString(28)+"^"+ws.getString(29)+"^"+ws.getString(30)+"^"+ws.getString(31);			
					
					//                           Lab Sne No +      CTR No  + Item Brand Name  + Batch No  + Mfd Date +  Lab Number + Exp Date + Mfd By
					String strPrintLabelValue = ws.getString(20)+"^"+ws.getString(22)+"^"+ws.getString(5)+"^"+ws.getString(6)+"^"+ws.getString(26)+"^"+ws.getString(28)+"^"+ws.getString(7)+"^"+ws.getString(29);
                   		sb.append("<tr>");
					sb.append("<input type='hidden' name='strCheckHidValue' id='strCheckHidValue"+count+"' value='"+strCheckHidValue+"'>");
					sb.append("<input type='hidden' name='strPrintLabelValue' id='strPrintLabelValue"+count+"' value='"+strPrintLabelValue+"'>");
					sb.append("<td class='multiControl' width='15%'>");
					sb.append(ws.getString(21));
					sb.append("</td>");
					sb.append("<td class='multiControl' width='30%'>");
					sb.append("<a STYLE='cursor:pointer;cursor:hand;color:blue' name='strDrugName' id='strDrugName"+count+"' onClick='drugDtl(this,\""+count+"\");'>"+ws.getString(5)+"</a> &nbsp;");
					sb.append("</td>");
					sb.append("<td class='multiControl' width='10%'>");
					sb.append(ws.getString(6));
					sb.append("</td>");
					sb.append("<td class='multiControl' width='15%'>");
					sb.append(ws.getString(7));
					sb.append("</td>");
					sb.append("<td class='multiControl' width='10%'>");
					sb.append(ws.getString(22));
					sb.append("</td>");
					sb.append("<td class='multiControl' width='10%'>");
					sb.append(ws.getString(30));
					sb.append("</td>");
					sb.append("<td class='multiControl' width='10%'>");
					sb.append(ws.getString(31));
					sb.append("</td>");
					sb.append("</tr>");
					}
					else
					{
						break;
					}
					count++;
				}
				sb.append("</table>");
				sb.append("</div>");

			} 
			else 
			{
				sb.append("<div id='DivId" ).append( i).append( "' style='display:none'>");
				
				sb.append("<table class='TABLEWIDTH' align='center' cellspacing='1px' bgcolor='black' cellpadding='1px'>");
				for (int k = 0; k < reminder; k++) 
				{
					ws.next();
					String strCheckHidValue = ws.getString(1)+"^"+ws.getString(2)+"^"+ws.getString(3)+"^"+ws.getString(4)+"^"+ws.getString(5)+"^"+ws.getString(6)+"^"+ws.getString(7)+"^"+ws.getString(8)+"^"+ws.getString(9)
                    +"^"+ws.getString(10)+"^"+ws.getString(11)+"^"+ws.getString(12)+"^"+ws.getString(13)+"^"+ws.getString(14)+"^"+ws.getString(15)+"^"+ws.getString(16)+"^"+ws.getString(17)+"^"+ws.getString(18)
                    +"^"+ws.getString(19)+"^"+ws.getString(20)+"^"+ws.getString(21)+"^"+ws.getString(22)+"^"+ws.getString(23)+"^"+ws.getString(24)+"^"+ws.getString(25)+"^"+ws.getString(26)+"^"+ws.getString(27)+"^"+ws.getString(28)+"^"+ws.getString(29)+"^"+ws.getString(30)+"^"+ws.getString(31);			

					//                           Lab Sne No +      CTR No  + Item Brand Name  + Batch No  + Mfd Date +  Lab Number + Exp Date + Mfd By
					String strPrintLabelValue = ws.getString(20)+"^"+ws.getString(22)+"^"+ws.getString(5)+"^"+ws.getString(6)+"^"+ws.getString(26)+"^"+ws.getString(28)+"^"+ws.getString(7)+"^"+ws.getString(29);
						sb.append("<tr>");
					sb.append("<input type='hidden' name='strCheckHidValue' id='strCheckHidValue"+count+"' value='"+strCheckHidValue+"'>");
					sb.append("<input type='hidden' name='strPrintLabelValue' id='strPrintLabelValue"+count+"' value='"+strPrintLabelValue+"'>");
					sb.append("<td class='multiControl' width='15%'>");
					sb.append(ws.getString(21));
					sb.append("</td>");
					sb.append("<td class='multiControl' width='30%'>");
					sb.append("<a STYLE='cursor:pointer;cursor:hand;color:blue' name='strDrugName' id='strDrugName"+count+"' onClick='drugDtl(this,\""+count+"\");'>"+ws.getString(5)+"</a> &nbsp;");
					sb.append("</td>");
					sb.append("<td class='multiControl' width='10%'>");
					sb.append(ws.getString(6));
					sb.append("</td>");
					sb.append("<td class='multiControl' width='15%'>");
					sb.append(ws.getString(7));
					sb.append("</td>");
					sb.append("<td class='multiControl' width='10%'>");
					sb.append(ws.getString(22));
					sb.append("</td>");
					sb.append("<td class='multiControl' width='10%'>");
					sb.append(ws.getString(30));
					sb.append("</td>");
					sb.append("<td class='multiControl' width='10%'>");
					sb.append(ws.getString(31));
					sb.append("</td>");
					sb.append("</tr>");
					count++;
				
				}
				sb.append("</table>");
				sb.append("</div>");
				}
		   	}
		sb.append("</td>");
		sb.append("</tr>");
		sb.append("</table>");
		}
		else
		{
			sb.append("<table class='TABLEWIDTH' align='center' cellspacing='1px' bgcolor='black' cellpadding='1px'>");
			sb.append("<tr>");
			sb.append("<td class='multiControl'><font color='red'>No Record Found</font></td>");
			sb.append("</tr>");
			sb.append("</table>");
		}
	   } 
		
	 }
	 catch(Exception e)
	 {
		    e.printStackTrace();
		    new HisException("Breakage Details Transaction","BreakageItemDtlTransHLP.getBreakageDetails()-->",e.getMessage());
	    }
	     //System.out.println("sb"+sb);
	    return sb.toString();
	 	}
	
	
	
	
	
	 public static String getQualityDetails(WebRowSet ws, String strStartDate , String strEndDate) 
	 {
		StringBuffer sb = new StringBuffer("");
		int start = 1;
		final int REC_PER_PAGE = 10;
		final int PAGE_PER_BLOCK = 10;
		
	
		
		int totalFetchRecord = (REC_PER_PAGE * PAGE_PER_BLOCK) + 1;
		int totalRecordsToManipulate = totalFetchRecord - 1;
		
	    try
	    {
	 
	    	
	    	String[] strStartYr = strStartDate.replace('-','@').split("@");
	    	String[] strEndYr = strEndDate.replace('-','@').split("@");
	    	
		if (ws != null) 
		{
			//System.out.println("ws.size"+ws.size());
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
			 sb.append("<td class='TITLE' >Quality Details For Financial Year : "+strStartYr[2]+"-"+strEndYr[2]);
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
	        sb.append("<td width='10%'class='multiLabel'>Date");
		    sb.append("</td>");
	        sb.append("<td width='18%'class='multiLabel'>Item Name");
	        sb.append("</td>");
	        sb.append("<td width='18%'class='multiLabel'>Batch/Sl No");
	        sb.append("</td>");
	        sb.append("<td width='18%'class='multiLabel'>InHand Qty wth Unit");
	        sb.append("</td>");
	        sb.append("<td width='18%'class='multiLabel'>Item Status");
		    sb.append("</td>");
		    sb.append("<td width='18%'class='multiLabel'>Remarks");
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
					sb.append("<td class='multiControl' width='10%'>");
					sb.append(ws.getString(1));
					sb.append("</td>");
					sb.append("<td class='multiControl' width='18%'>");
					sb.append(ws.getString(2));
					sb.append("</td>");
					sb.append("<td class='multiControl' width='18%'>");
					sb.append(ws.getString(3));
					sb.append("</td>");
					sb.append("<td class='multiControl' width='18%'>");
					sb.append(ws.getString(4));
					sb.append("</td>");
					sb.append("<td class='multiControl' width='18%'>");
					sb.append(ws.getString(5));
					sb.append("</td>");
					sb.append("<td class='multiControl' width='18%'>");
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
					sb.append("<tr><td class='multiControl' width='10%'>");
					sb.append(ws.getString(1));
					sb.append("</td>");
					sb.append("<td class='multiControl' width='18%'>");
					sb.append(ws.getString(2));
					sb.append("</td>");
					sb.append("<td class='multiControl' width='18%'>");
					sb.append(ws.getString(3));
					sb.append("</td>");
					sb.append("<td class='multiControl' width='18%'>");
					sb.append(ws.getString(4));
					sb.append("</td>");
					sb.append("<td class='multiControl' width='18%'>");
					sb.append(ws.getString(5));
					sb.append("</td>");
					sb.append("<td class='multiControl' width='18%'>");
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
			sb.append("<table class='TABLEWIDTH' align='center' cellspacing='1px' bgcolor='black' cellpadding='1px'");
			 sb.append("<tr>");
			 sb.append("<td class='TITLE' >Quality Details For Financial Year : "+strStartYr[2]+"-"+strEndYr[2]);
			 sb.append("</td></tr>");
			sb.append("<tr");
			sb.append("<td class='multiControl'<font color='red'>No Record Found</font></td>");
			sb.append("</tr>");
			sb.append("</table>");
		    }
	   }
	   

	 }
	 catch(Exception e)
	 {
		    e.printStackTrace();
		    new HisException("Quality Check Control Transaction","QualityCheckControlTransHLP.getQualityDetails()--",e.getMessage());
	    }
	     
	    return sb.toString();
	 	}


}
