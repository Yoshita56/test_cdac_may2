<%@page language="java" contentType="text/html" pageEncoding="UTF-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<%@taglib uri="/WEB-INF/dateTag.tld" prefix="dateTag"%>
<%@ taglib uri="/WEB-INF/hisTab.tld" prefix="tag"%>
<%@ taglib uri="/WEB-INF/comboPersistence.tld" prefix="cmbPers"%>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic"%>



<html>
<head>
<meta charset=UTF-8">
<title>Bill Approval View</title>
<link href="../css/master.css" rel="stylesheet" type="text/css">
<link href="../../hisglobal/css/tab.css" rel="stylesheet" type="text/css">
<link href="../../hisglobal/css/calendar-tas.css" rel="stylesheet" type="text/css">

<link href="../../hisglobal/css/popup.css" rel="stylesheet" type="text/css">	
	
<script language="JavaScript" src="../../hisglobal/masterutil/js/master.js"></script>
<script language="JavaScript" src="../../hisglobal/js/tab.js"></script>
<script language="JavaScript" src="../../hisglobal/js/calendar.js"></script>
<script language="Javascript" src="../../hisglobal/js/validation.js"></script>
<script language="Javascript" src="../../hisglobal/js/util.js"></script>
<script language="Javascript" src="../js/billApprovalViewTrans.js"></script>
<script language="Javascript" type="text/javascript">

function view1(obj1,obj2,obj3)
{
	document.getElementById(obj1).style.display="none"  ;
	document.getElementById(obj2).style.display="block" ;
	document.getElementById(obj3).style.display="block" ;
}
function view2(obj1,obj2,obj3)
{
	document.getElementById(obj1).style.display="block" ;
	document.getElementById(obj2).style.display="none"  ;
	document.getElementById(obj3).style.display="none"  ;
}
function cancelPage()
{
	document.forms[0].hmode.value="MAINPAGE";
	document.forms[0].submit();
}
function initPage()
{
	if(document.forms[0].strAgentNameShow.value=="1")
	   document.getElementById("agentNameDivId").style.display="block";
	else
	   document.getElementById("agentNameDivId").style.display="none";   
	
}

</script>

</head>
<body onLoad="initPage();">
<html:form name="billApprovalViewBean" action="/transactions/BillApprovalViewTransCNT"
	type="mms.transactions.controller.fb.BillApprovalViewTransFB">
	
<center>
	<div id="errMsg" class="errMsg"><bean:write name="billApprovalViewBean" property="strErrMsg" /></div>
	<div id="warningMsg" class="warningMsg"><bean:write name="billApprovalViewBean" property="strWarningMsg"/></div>
	<div id="normalMsg" class="normalMsg"><bean:write name="billApprovalViewBean" property="strNormalMsg"/></div>
	
	<tag:tab tabLabel="Bill Approval Veiw" selectedTab="FIRST" align="center" width="TABLEWIDTH">
    </tag:tab>
</center>

<table class="TABLEWIDTH" align="center" cellpadding="1px" cellspacing="1px">   
	   <tr class="HEADER">
			<td colspan="4"></td>
	   </tr>
	   <tr>
            <td class="LABEL" width="25%" colspan="1">Store Name</td>
            <td width="25%" class ="CONTROL" colspan="1">
               <bean:write name="billApprovalViewBean" property="strStoreName" filter="false" />
            </td>
            <td class="LABEL" width="25%" colspan="1">Bill Type</td>
            <td width="25%" class ="CONTROL" colspan="1">
               <bean:write name="billApprovalViewBean" property="strBillType" filter="false" />
            </td>
        </tr>
       
        
        <tr><td class="TITLE" colspan="4"><div id="" style="color:blue;">PO Details</div></td></tr>
	    <tr>
            <td class="LABEL" width="25%" colspan="1">PO No</td>
            <td  class ="CONTROL" width="75%" colspan="3">
               <font color="blue"><bean:write name="billApprovalViewBean" property="strPoNo" filter="false" /></font>
            </td>
         </tr>
         <tr>   
              <td class="LABEL" width="25%" colspan="1">PO Date</td>
    	    <td width="75%" class ="CONTROL" colspan="3">
    	       <bean:write name="billApprovalViewBean" property="strPoDate" filter="false" />
    	    </td>
        </tr>
	    <tr>
		  
    	    <td class="LABEL" width="25%" colspan="1">PO Type</td>
    	    <td width="25%" class ="CONTROL" colspan="1">
    	       <bean:write name="billApprovalViewBean" property="strPoType" filter="false" />
    	    </td>
    	     <td class="LABEL" width="25%" colspan="1">Supplier Name</td>
            <td width="25%" class ="CONTROL" colspan="1">
               <bean:write name="billApprovalViewBean" property="strSupplierDtl" filter="false" />
            </td>
   	   </tr>
       <tr>
            <td class="LABEL" width="25%" colspan="1">Currency Name</td>
            <td width="25%" class ="CONTROL" colspan="1">
               <bean:write name="billApprovalViewBean" property="strCurrancyName" filter="false" />
            </td>
            <td class="LABEL" width="25%" colspan="1">Currency Value</td>
            <td width="25%" class ="CONTROL" colspan="1">
               <bean:write name="billApprovalViewBean" property="strCurrancyValue" filter="false" />
            </td>
       </tr>
       <tr>
	       <td width="25%" colspan="1" class="LABEL">
				PO Net Amount
			</td>
			<td width="75%" colspan="3" class="CONTROL">
				<bean:write name="billApprovalViewBean" property="strPONetAmount" filter="false" />
			</td>
	   </tr>
    </table>
     <div id="agentNameDivId" style="display:none">  
    <table class="TABLEWIDTH" align="center" cellpadding="1" cellspacing="1">  
        <tr>
	       <td width="25%" colspan="1" class="LABEL">
				Agent Name
			</td>
			<td width="25%" colspan="1" class="CONTROL">
				<bean:write name="billApprovalViewBean" property="strAgentName" filter="false" />
			</td>
			<td width="25%" colspan="1" class="LABEL">Clearing Agent Name</td>
			<td width="25%" colspan="1" class="CONTROL">
			  <bean:write name="billApprovalViewBean" property="strCAName" filter="false" />
			</td>
	   </tr>
     </table>
   </div>
    <table class="TABLEWIDTH" align="center" cellspacing="1px" cellpadding="1px">
		<tr>
			<td  colspan="4" class="TITLE">
			<div id="plusScheduleDetailId" align="left" style="display:none;color:blue;">
					<img src="../../hisglobal/images/plus.gif" 
									onClick="view1('plusScheduleDetailId','minusScheduleDetailId','scheduleDivId');" style="cursor: pointer; "/>
						Schedule Detail
						
					</div>
					<div id="minusScheduleDetailId" style="display:block;" style="color:blue;" align="left">
						<img src="../../hisglobal/images/minus.gif" 
								onClick="view2('plusScheduleDetailId','minusScheduleDetailId','scheduleDivId');" style="cursor: pointer; "/>
								Schedule Details
					</div>
				</td>
		</tr>
	</table>
    
    <div id="scheduleDivId" style="display: block">
    <bean:write name="billApprovalViewBean" property="strScheduleDtl" filter="false" /></div>
    <div>
    <table class="TABLEWIDTH" align="center" cellpadding="1" cellspacing="1">
	  <tr>
  		 <td colspan="4" class="TITLE"><div id="" style="color:blue;">Other Details</div></td>
     </tr>
	 <tr>
	      <td class="LABEL" width="25%" colspan="1">Overall Tax</td>
    	  <td width="25%" class ="CONTROL" colspan="1">
    	  <bean:write name="billApprovalViewBean" property="strTax" filter="false" />
    	  </td>
  		  <td class="LABEL" width="25%" colspan="1">Balance Advance</td>
    	  <td width="25%" class ="CONTROL" colspan="1">
    	    <bean:write name="billApprovalViewBean" property="strAdvanceAmount" filter="false" />
    	  </td>
	   </tr>
	   <tr>
	   	<td class="LABEL">Penalty Imposed</td>
	   	  <td width="25%" class ="CONTROL" colspan="3">
	   	  		<bean:write name="billApprovalViewBean" property="strPeneltyAmt" filter="false" />
	   	  </td>
	   </tr>
	 </table>
	 <logic:equal value="1" name="billApprovalViewBean" property="strWaveOffDtl">
	   <table class="TABLEWIDTH" align="center" cellpadding="1" cellspacing="1">
	  <tr>
  		 <td colspan="4" class="TITLE"><div id="" style="color:blue;">Waive Off Details</div></td>
     </tr>
	 <tr>
	      <td class="LABEL" width="25%" colspan="1">Waive Off Amount</td>
    	  <td width="25%" class ="CONTROL" colspan="1">
    	   <bean:write name="billApprovalViewBean" property="strWaveOffAmt" filter="false" />
    	  </td>
  		  <td class="LABEL" width="25%" colspan="1">Approved By</td>
    	  <td width="25%" class ="CONTROL" colspan="1">
    	      <bean:write name="billApprovalViewBean" property="strApprovedBy" filter="false" />
    	  </td>
	   </tr>
	   <tr>
	   	<td class="LABEL">Approval Date</td>
	   	  <td width="25%" class ="CONTROL" colspan="3">
	   	  		<bean:write name="billApprovalViewBean" property="strApprovalDate" filter="false" />
	   	  </td>
	   </tr>
	 </table>
	 </logic:equal>
	</div>
	 <table class="TABLEWIDTH" align="center" cellpadding="1" cellspacing="1">
	  <tr>
	 		<td class="LABEL" width="25%" colspan="1">Advance Adjusted</td>
	 		<td width="75%" class ="CONTROL" colspan="1">
    	      <bean:write name="billApprovalViewBean" property="strAdvanceAdjustedAmt" filter="false" />
    	  </td>
	  </tr>
	   <tr>
	 		<td class="LABEL" width="25%" colspan="1">Net Calculated Cost</td>
	 		<td width="75%" class ="CONTROL" colspan="1">
    	      <bean:write name="billApprovalViewBean" property="strNetcalCost" filter="false" />
    	  </td>
	  </tr>
	 </table>
	
	  <table class="TABLEWIDTH" align="center" cellpadding="1" cellspacing="1">
	  	 <tr>
	  		<td class="TITLE" colspan="4"><div id="" style="color:blue;">Supplier Bill Details</div></td>
	  	 </tr>
	  	 <tr>
	      <td class="LABEL" width="25%" colspan="1">Bill No.</td>
    	  <td width="25%" class ="CONTROL" colspan="1">
    	      <bean:write name="billApprovalViewBean" property="strBillNo" filter="false" />
    	  </td>
  		  <td class="LABEL" width="25%" colspan="1">Bill Date</td>
    	  <td width="25%" class ="CONTROL" colspan="1">
    	      <bean:write name="billApprovalViewBean" property="strBillDate" filter="false" />
    	  </td>
	     </tr>
	     <tr>
	      <td class="LABEL">Bill Amount</td>
	   	  <td width="25%" class ="CONTROL" colspan="3">
	   	  		<bean:write name="billApprovalViewBean" property="strBillAmt" filter="false" />
	   	  </td>
	     </tr>
	     <tr>
	   	  <td colspan="1" class="LABEL">Remarks</td>
	   	  <td colspan="3" class="CONTROL"><bean:write name="billApprovalViewBean" property="strRemarks" filter="false" /></td>
	     </tr>
	   </table>
	
	 <table class="TABLEWIDTH" align="center" cellpadding="1" cellspacing="1">
	 <tr class="FOOTER">
			<td colspan="6"></td>
	</tr>
	 
		<tr>
			<td align="center">
			<img  style="cursor: pointer; " 
					src="../../hisglobal/images/btn-ccl.png" onClick="cancelPage();" title='Click Here To Go Back To Main Desk' >
		</td>
		</tr>
	</table>
	
	
<input type="hidden" name="hmode"/>
<input type="hidden" name="strAgentNameShow" value="${billApprovalViewBean.strAgentNameShow}" />
<cmbPers:cmbPers/>
</html:form>
<tag:autoIndex></tag:autoIndex>  
</body>
</html>