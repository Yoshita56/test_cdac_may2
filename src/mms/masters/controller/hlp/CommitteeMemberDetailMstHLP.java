package mms.masters.controller.hlp;

import javax.sql.rowset.WebRowSet;

import mms.masters.vo.CommitteeMemberDetailMstVO;

// TODO: Auto-generated Javadoc
/**
 * The Class CommitteeMemberDetailMstHLP.
 */
public class CommitteeMemberDetailMstHLP {

	/**
	 * Gets the member dtl.
	 * 
	 * @param ws the ws
	 * 
	 * @return the member dtl
	 */
	public static String getMemberDTL(WebRowSet ws) {

		String strMemberName = null;
		String strPhoneNo = null;
		String strEmail = null;
		String strCommitteNo;
		String strEmpCode;
		String strChairPersonFlg;
		String strUserId;
		StringBuffer strResponse = null;
		StringBuffer strDummy = null;
        String strApplyClass;
		StringBuffer sb = new StringBuffer("");

		try {

			sb.append("<table class='TABLEWIDTH' align='center' border='0' cellpadding='1px' cellspacing ='1px' bgcolor='black'>");
			sb.append("<tr><td width='10%' class='multiLabel'>Delete</td>");
			sb.append("<td width='25%' class='multiLabel'>Member Name</td>");
			sb.append("<td width='25%' class='multiLabel'>Phone No</td>");
			sb.append("<td width='20%' class='multiLabel'>E-Mail</td></tr></table>");
       if(ws!=null)
       {
    	   if (ws.size()!= 0) 
    	   {
				for (int i = 0; ws.next(); i++)
				{
					strMemberName = ws.getString(1);
					   strPhoneNo = ws.getString(2);
					     strEmail = ws.getString(3);
					strCommitteNo = ws.getString(4);
					   strEmpCode = ws.getString(5);
			    strChairPersonFlg = ws.getString(6);
			            strUserId = ws.getString(7);

					if (strMemberName == null || strMemberName.equals(""))
						strMemberName = "-----";
					if (strPhoneNo == null || strPhoneNo.equals(""))
						strPhoneNo = "-----";
					if (strEmail == null || strEmail.equals(""))
						strEmail = "-----";
					if (strCommitteNo == null || strCommitteNo.equals(""))
						strCommitteNo = "-----";
					if (strEmpCode == null || strEmpCode.equals(""))
						strEmpCode = "-----";

					strDummy =  new StringBuffer(strMemberName ).append( "$$" ).append( strPhoneNo ).append( "$$"
							).append( strEmail ).append( "$$" ).append( strCommitteNo ).append( "$$").append(( strEmpCode).toString()).append( "$$").append(strChairPersonFlg).append( "$$").append(strUserId);

					if (i == 0)
						strResponse = new StringBuffer(strMemberName ).append( "^" ).append( strPhoneNo ).append("^"
								).append( strEmail ).append( "^" ).append( strCommitteNo ).append( "^"
								).append(( strEmpCode).toString()).append( "^").append(strChairPersonFlg).append("^").append(strUserId);
					else
						strResponse = new StringBuffer(strResponse ).append( "@@" ).append( strMemberName ).append( "^"
								).append( strPhoneNo ).append( "^" ).append( strEmail ).append( "^"
								).append( strCommitteNo ).append( "^" ).append(( strEmpCode).toString()).append("^").append(strChairPersonFlg).append("^").append(strUserId);

					   if(strChairPersonFlg.equals("1")) 
				       {
				    	 strApplyClass = "Approved";				    	   
				       }
				       else
				       {
				    	 strApplyClass = "NotApproved";    				    	   
				       }	
					
					
					sb.append("<input type='hidden' name='userIdFlg' id='userIdFlg"+i+"' value='"+ws.getString(6)+"'>");
					
					sb.append("<input type='hidden' name='flag'  id='flag" ).append( i
							).append( "' value='" ).append( strDummy ).append( "'>");
					sb.append("<table class='TABLEWIDTH' align='center' border='0' cellpadding='1px' cellspacing ='1px' bgcolor='#1277b5'>");
					sb.append("<tr>");
					sb.append("<td width='10%' class='LABEL'><b>");
					sb.append("<input type='checkbox' name='strCheckBox' id='strCheckBox").append( i ).append( "'  value='" ).append( 0 ).append( "'>");
					sb.append("</b></td>");
					sb.append("<td width='25%' class='LABEL'>");
					
					 if(strApplyClass.equals("Approved")) 
				     {
						 sb.append("[CP] "+strMemberName);				    	   
				     }
				     else
				     {
				    	 sb.append(strMemberName);   				    	   
				     }	
					
					
					sb.append("</td>");
					sb.append("<td width='25%' class='LABEL'>");
					sb.append(strPhoneNo);
					sb.append("</td>");
					sb.append("<td width='20%' class='LABEL'>");
					sb.append(strEmail);
					sb.append("</td>");
					sb.append("</tr></table>");
				}
				
				sb.append("<input type='hidden' name='strPrevVal'  value='"
						).append( strResponse ).append( "'>");
			} else {
				sb
						.append("<table class='TABLEWIDTH' align='center'   bgcolor='#000000' border='0' cellpadding='1px' cellspacing ='1px'>");
				sb.append("<tr>");
				sb
						.append("<td colspan='5'  CLASS='multiControl' >"
								).append( "<DIV class='errMsg' align='center'> No Record Details Found </div>"
								).append( "</TD>");

				sb.append("</tr>");
				sb.append("</table>");
				sb.append("<input type='hidden' name='strPrevVal'  value=''>");

			}

       }else{
    	   	throw new Exception("CommitteeMemberDetailMstHLP-->getMemberDTL()---No Record Found!!!");
       }
			
		} catch (Exception e) {
			e.printStackTrace();
			return "ERROR";

		}

		return sb.toString();
	}

	/*
	 * Thjis method generates new HLP UPDATED
	 */
	/**
	 * Gets the updated member hlp1.
	 * 
	 * @param vo the vo
	 * 
	 * @return the updated member hlp1
	 */
	public static String getUpdatedMemberHLP1(CommitteeMemberDetailMstVO vo) {
		String strMemberName = null;
		String strPhoneNo = null;
		StringBuffer strResponseNew = null;
		String strEmail = null;
		String strResponse[] = null;
		String strRec[] = null;
	    String strApplyClass;
		StringBuffer strDummy = null;
		String strCommitteNo;
		String strEmpCode;
		String strChairPersonFlg;
		String strUserId;


		StringBuffer sb = new StringBuffer("");
		try 
		{
			strResponse = vo.getStrTmp().replace("@@", "#").split("#");

			sb
					.append("<table class='TABLEWIDTH' align='center' border='0' cellpadding='1px' cellspacing ='1px' bgcolor='black'>");
			sb.append("<tr><td width='10%' class='multiLabel'>Delete</td>");
			sb.append("<td width='25%' class='multiLabel'>Member Name</td>");
			sb.append("<td width='25%' class='multiLabel'>Phone No</td>");
			sb
					.append("<td width='20%' class='multiLabel'>E-Mail</td></tr></table>");

			int i = 0;

			           strRec = strResponse[1].replace('^', '#').split("#");
			    strMemberName = strRec[0];
			       strPhoneNo = strRec[1];
			         strEmail = strRec[2];
			    strCommitteNo = strRec[3];
			       strEmpCode = strRec[4];
			strChairPersonFlg = strRec[5];
                    strUserId = strRec[6];
                    
                    if(strChairPersonFlg.equals("1")) 
				       {
				    	 strApplyClass = "Approved";				    	   
				       }
				       else
				       {
				    	 strApplyClass = "NotApproved";    				    	   
				       }	
			
			strDummy = new StringBuffer(strRec[0]).append( "$$" ).append( strRec[1] ).append( "$$" ).append( strRec[2] ).append( "$$"
					).append( strRec[3] ).append( "$$" ).append(( strEmpCode).toString()).append( "$$").append(strChairPersonFlg).append( "$$").append(strUserId);

			if (i == 0)
				
				strResponseNew = new StringBuffer( strMemberName ).append( "^" ).append( strPhoneNo ).append( "^"
						).append( strEmail ).append( "^" ).append( strCommitteNo ).append( "^" ).append(( strEmpCode).toString()).append( "^" ).append(strChairPersonFlg).append( "^").append(strUserId);

			if (strMemberName == null || strMemberName.equals(""))
				strMemberName = "-----";
			if (strPhoneNo == null || strPhoneNo.equals(""))
				strPhoneNo = "-----";
			if (strEmail == null || strEmail.equals(""))
				strEmail = "-----";
			if (strCommitteNo == null || strCommitteNo.equals(""))
				strCommitteNo = "-----";
			if (strEmpCode == null || strEmpCode.equals(""))
				strEmpCode = "-----";

			sb.append("<input type='hidden' name='userIdFlg' id='userIdFlg"+i+"' value='"+strRec[5]+"'>");
			sb.append("<input type='hidden' name='flag' id='flag" ).append( i
					).append( "' value='" ).append( strDummy ).append( "'>");
			sb
					.append("<table class='TABLEWIDTH' align='center' border='0' cellpadding='1px' cellspacing ='1px' bgcolor='#6097BC'>");
			sb.append("<tr>");
			sb.append("<td width='10%' class='"+strApplyClass+"'><b>");
			sb
					.append("<input type='checkbox' name='strCheckBox' id='strCheckBox"
							).append( i ).append( "'  value='" ).append( 0 ).append( "'>");
			sb.append("</b></td>");
			sb.append("<td width='25%' class='"+strApplyClass+"'>");
			if(strApplyClass.equals("Approved")) 
		     {
				 sb.append("[CP] "+strMemberName);				    	   
		     }
		     else
		     {
		    	 sb.append(strMemberName);   				    	   
		     }	
			//sb.append(strMemberName);
			sb.append("</td>");
			sb.append("<td width='25%' class='"+strApplyClass+"'>");
			sb.append(strPhoneNo);
			sb.append("</td>");
			sb.append("<td width='20%' class='"+strApplyClass+"'>");
			sb.append(strEmail);
			sb.append("</td>");
			sb.append("</tr></table>");

			sb.append("<input type='hidden' name='strPrevVal'  value='"
					).append( strResponseNew ).append( "'>");
		} catch (Exception e) {

			e.printStackTrace();
			return "ERROR";

		}

		return sb.toString();
	}

	/*
	 * Thjis method generates new HLP UPDATED
	 */
	/**
	 * Gets the updated member hlp.
	 * 
	 * @param vo the vo
	 * 
	 * @return the updated member hlp
	 */
	public static String getUpdatedMemberHLP(CommitteeMemberDetailMstVO vo) {
		String strMemberName = null;
		String strPhoneNo = null;
		StringBuffer strResponseNew = null;
		String strEmail = null;
		String strResponse[] = null;
		String strRec[] = null;
	//	String strTemp[] = null;
		StringBuffer strDummy = null;
		String strCommitteNo;
		String strEmpCode;
		String strChairPersonFlg;
		String strUserId;
		String strApplyClass;

		StringBuffer sb = new StringBuffer("");
		try 
		{
			strResponse = vo.getStrTmp().replace("@@", "#").split("#");

			sb.append("<table class='TABLEWIDTH' align='center' border='0' cellpadding='1px' cellspacing ='1px' bgcolor='black'>");
			sb.append("<tr><td width='10%' class='multiLabel'>Delete</td>");
			sb.append("<td width='25%' class='multiLabel'>Member Name</td>");
			sb.append("<td width='25%' class='multiLabel'>Phone No</td>");
			sb.append("<td width='20%' class='multiLabel'>E-Mail</td></tr></table>");

			for (int i = 0; i < strResponse.length; i++) 
			{

				       strRec = strResponse[i].replace('^', '#').split("#");
				strMemberName = strRec[0];
				   strPhoneNo = strRec[1];
				     strEmail = strRec[2];
				strCommitteNo = strRec[3];
				   strEmpCode = strRec[4];
            strChairPersonFlg = strRec[5];
				    strUserId = strRec[6];
				    
				   
				     strDummy = new StringBuffer(strRec[0] ).append( "$$" ).append( strRec[1] ).append( "$$" ).append( strRec[2]
					        	).append( "$$" ).append( strRec[3] ).append( "$$" ).append(( strEmpCode).toString()).append( "$$").append(strChairPersonFlg).append("$$").append(strUserId);

				if (i == 0)
					strResponseNew = new StringBuffer(strMemberName ).append( "^" ).append( strPhoneNo ).append( "^"
							).append( strEmail ).append( "^" ).append( strCommitteNo ).append( "^" ).append(( strEmpCode).toString()).append( "^").append(strChairPersonFlg).append("^").append(strUserId);
				else
					strResponseNew = new StringBuffer(strResponseNew ).append( "@@" ).append( strMemberName
							).append( "^" ).append( strPhoneNo ).append( "^" ).append( strEmail ).append( "^"
							).append( strCommitteNo ).append( "^" ).append(( strEmpCode).toString()).append( "^").append(strChairPersonFlg).append("^").append(strUserId);

				if (strMemberName == null || strMemberName.equals(""))
					strMemberName = "-----";
				if (strPhoneNo == null || strPhoneNo.equals(""))
					strPhoneNo = "-----";
				if (strEmail == null || strEmail.equals(""))
					strEmail = "-----";
				if (strCommitteNo == null || strCommitteNo.equals(""))
					strCommitteNo = "-----";
				if (strEmpCode == null || strEmpCode.equals(""))
					strEmpCode = "-----";

				 if(strChairPersonFlg.equals("1")) 
			       {
			    	 strApplyClass = "Approved";				    	   
			       }
			       else
			       {
			    	 strApplyClass = "NotApproved";    				    	   
			       }	
				
				 sb.append("<input type='hidden' name='userIdFlg' id='userIdFlg"+i+"' value='"+strRec[5]+"'>");
				sb.append("<input type='hidden' name='flag' id='flag" ).append( i).append( "' value='" ).append( strDummy ).append( "'>");
				sb.append("<table class='TABLEWIDTH' align='center' border='0' cellpadding='1px' cellspacing ='1px' bgcolor='#6097BC'>");
				sb.append("<tr>");
				sb.append("<td width='10%' class='"+strApplyClass+"'><b>");
				sb.append("<input type='checkbox' name='strCheckBox' id='strCheckBox").append( i ).append( "'  value='" ).append( 0 ).append( "'>");
				sb.append("</b></td>");
				sb.append("<td width='25%' class='"+strApplyClass+"'>");
				if(strApplyClass.equals("Approved")) 
			     {
					 sb.append("[CP] "+strMemberName);				    	   
			     }
			     else
			     {
			    	 sb.append(strMemberName);   				    	   
			     }	
				//sb.append(strMemberName);
				sb.append("</td>");
				sb.append("<td width='25%' class='"+strApplyClass+"'>");
				sb.append(strPhoneNo);
				sb.append("</td>");
				sb.append("<td width='20%' class='"+strApplyClass+"'>");
				sb.append(strEmail);
				sb.append("</td>");
				sb.append("</tr></table>");
			}
			sb.append("<input type='hidden' name='strPrevVal'  value='"	).append( strResponseNew ).append( "'>");
		} catch (Exception e) {

			e.printStackTrace();
			return "ERROR";

		}

		return sb.toString();
	}

}
