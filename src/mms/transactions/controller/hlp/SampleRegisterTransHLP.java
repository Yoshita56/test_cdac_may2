package mms.transactions.controller.hlp;

import hisglobal.utility.HisUtil;

import javax.sql.rowset.WebRowSet;

import mms.transactions.controller.fb.SampleRegisterTransFB;

public class  SampleRegisterTransHLP {
	public static String getAddedItemDetails(SampleRegisterTransFB formbean)
	{ 
		StringBuffer br = new StringBuffer();
		WebRowSet wb1=null;
	//	WebRowSet wb2=null;
		int iCount=0;
		HisUtil hisutil=null;
		String strHidden=formbean.getStrChk()+"^"+formbean.getStrTenderNo()+"^"+formbean.getStrQuotationNo()+"^"+formbean.getStrSupplierId();
		try{
			
			wb1=formbean.getItemDetailsWS();
		//	wb2=formbean.getUnitWS();
			hisutil = new HisUtil("mms", "SampleRegisterTransDATA");
			String cmb = hisutil.getOptionValue(formbean.getUnitWS(),
					formbean.getStrUnitId(), "0^Select Value", true);
			br.append("<table class='TABLEWIDTH' align='center' cellspacing='1px' cellpadding='0px'>\n");
			br.append("<tr class='HEADER'>\n");
			br.append("<td >\n");
			br.append("Item Details");
			br.append("</td>");
			br.append("</tr>\n");
			br.append("</table>");
			br.append("<table class='TABLEWIDTH' align='center' cellspacing='1px' cellpadding='0px'>\n");
			br.append("<tr>\n");
			br.append("<td class='multiLabel' width='5%'>#</td>\n");
			br.append("<td class='multiLabel' width='15.26%'>Item Name</td>\n");
			br.append("<td class='multiLabel' width='15.26%'>Brand Name</td>\n");
			br.append("<td class='multiLabel' width='15.26%'>Batch/Serial No.</td>\n");
			br.append("<td class='multiLabel' width='15.26%'>Rec Quantity</td>\n");
			
			br.append("<td class='multiLabel' width='15.26%'>Return Only</td>\n");
			br.append("<td class='multiLabel' width='15.26%'>Unit</td>\n");
			br.append("</tr>\n");
			//System.out.println("size of Webrowsswt"+wb1.size());
			if(wb1!=null && wb1.size()!=0){
				wb1.beforeFirst();
				
				while(wb1.next())
				{
					
					br.append("<input type='hidden' name='strChkHidden' value='"+strHidden+"'>");
					br.append("<tr>\n");
					br.append("<td class='multiControl'><div id='idA"+iCount+"'><input type='checkbox' name='strChkBox' value='0' onClick='itemDtl_view(this,"+iCount+")'></div></td>\n");
					br.append("<td class='multiControl' width='15.26%'><div id='idB"+iCount+"'>"+wb1.getString(1)+"</div></td>");
					br.append("<td class='multiControl' width='15.26%'><div id='idC"+iCount+"'>"+wb1.getString(2)+"<div></td>");
					br.append("<td class='multiControl' width='15.26%'><div id='idD"+iCount+"'>"+wb1.getString(3)+"</div></td>\n");
					br.append("<td class='multiControl' width='15.26%'><div id='idE"+iCount+"'>"+wb1.getString(4)+"</div></td>\n");
					br.append("<td class='multiControl' width='15.26%'><input type='text' name='strReturnTo' value=''  class='txtFldMin' disabled='disabled'>\n");
					br.append("<td class='multiControl' width='15.26%'><select name='strUnit' class='comboNormal' disabled='disabled'>\n"+cmb+"</select>");
					br.append("</tr>\n");
					//System.out.println("wb1.getString(18)HLP"+wb1.getString(20));
					strHidden=wb1.getString(10)+"^"+wb1.getString(11)+"^"+wb1.getString(12)+"^"+wb1.getString(13)+"^"+wb1.getString(14)+"^"+wb1.getString(15)+"^"+wb1.getString(18)+"^"+wb1.getString(19)+"^"+wb1.getString(3)+"^"+wb1.getString(20);
					br.append("<input type='hidden' name='strQtyHidden' value='"+strHidden+"'>");
					iCount++;
				}
			}
			br.append("<input type='hidden' name='strSizeHlp' value='"+iCount+"'>");
			br.append("</table>");
	                
				
			
		}catch(Exception e){
			try{
				//System.out.println("Error"+e.getMessage());
				throw new Exception(e.getMessage());
			}
			catch(Exception e1)
			{}
		}
		finally
		{
			wb1=null;
		//	wb2=null;
		}
	return br.toString();
	}
	
	public static String createMemberDetails(SampleRegisterTransFB _SampleRegisterTransFB)
	{ 
		StringBuffer br = new StringBuffer();
		WebRowSet wb1=null;
		int count=0;
			try{
				wb1=_SampleRegisterTransFB.getCommitteMemberWS();
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
				br.append("<img src='../../hisglobal/images/btn-ok.png' 	onClick='closePopUpDiv();' style='cursor: pointer;' title='Click Here To Save Remarks'>");
				br.append("<img src='../../hisglobal/images/btn-ccl.png' onClick='clearData();' style='cursor: pointer;' title='Click Here To Clear Data'>");
				br.append("</tr>\n");
				br.append("</table>");
		
		}catch(Exception e){
			try{
				
				throw new Exception("SampleRegisterTransHLP.createMemberDetails--->"+e.getMessage());
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


}
