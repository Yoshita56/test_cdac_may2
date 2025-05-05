<%@page language="java" contentType="text/html" pageEncoding="UTF-8" %>
  <%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic"%>

<%@ taglib uri="/WEB-INF/hisTab.tld" prefix="tag"%>
<%@taglib uri="/WEB-INF/dateTag.tld" prefix="date"%>
<%@ taglib uri="/WEB-INF/comboPersistence.tld" prefix="cmbPers" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset=UTF-8">
<link href="../css/master.css" rel="stylesheet" type="text/css">
<link href="../../hisglobal/css/tab.css" rel="stylesheet" type="text/css">
<link href="../../hisglobal/css/calendar-tas.css" rel="stylesheet" type="text/css">
<link href="../../hisglobal/css/newpopup.css" rel="stylesheet" type="text/css">
<link href="../../hisglobal/css/popup.css" rel="stylesheet" type="text/css">
<link href="../../hisglobal/css/buttons.css" rel="stylesheet" type="text/css">	
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">


	
<script language="JavaScript" src="../../masterutil/js/master.js"></script>
<script language="JavaScript" src="../../hisglobal/js/tab.js"></script>
<script language="JavaScript" src="../../hisglobal/js/calendar.js"></script>
<script language="Javascript" src="../../hisglobal/js/validation.js"></script>
<script language="Javascript" src="../../hisglobal/js/datepicker1.js"></script>
<script language="Javascript" src="../js/searchItems_util.js"></script>
<script language="JavaScript" src="../../hisglobal/js/tab.js"></script>
<script language="Javascript" src="../../hisglobal/js/newpopup.js"></script>
<script language="Javascript" src="../../hisglobal/js/multirow.js"></script>
<script language="Javascript" src="../../hisglobal/js/util.js"></script>
<script language="JavaScript" src="../js/BreakageItemDtlTrans.js"></script>
<script language="Javascript" src="../../hisglobal/js/popup.js"></script>
<script language="Javascript" src="../js/lpReturn.js"></script>
<script language="JavaScript" src="../js/lpIssue_Print.js"></script>
<style type="text/css">
.multiControlRed {
	font-family: Verdana, Arial, Helvetica, sans-serif;
	font-size: 12px;
	font-style: normal;
	font-weight: normal;
	color: #000000;
	background-color: #F5786B;
	height: 16px;
	text-align:center;
}</style>
<script type="text/javascript">
	


</script>
<title>LP Issue</title>
</head>
<body onload="openDiv();getReport();">
<html:form action="/transactions/LPIssueDeskTransCNT"  name="lpIssueDeskTransBean" type="mms.transactions.controller.fb.LPIssueDeskTransFB" method="post">

    <div class="errMsg"     id="errMsg"><bean:write name="lpIssueDeskTransBean" property="strErr"/></div>
	<div class="warningMsg" id="warningMsg"><bean:write name="lpIssueDeskTransBean" property="strWarning"/></div>
	<div class="normalMsg"  id="normalMsg"><bean:write name="lpIssueDeskTransBean" property="strMsg"/></div>


<center>
<tag:tab tabLabel="LP Issue/Return Transaction" selectedTab="FIRST" align="center" width="TABLEWIDTH">
	</tag:tab>
</center>
<table class="TABLEWIDTH" align="center" cellpadding="1px" cellspacing="1px">

		<tr class="HEADER">
			<td colspan="4"></td>
		</tr>
</table>

<table class='TABLEWIDTH' align='center'cellpadding='1px' cellspacing='1px'>
	<tr>
		<td class='LABEL' width='50%'>Store Name</td>
		<td class='CONTROL' width='50%'>
			<bean:write property="strStoreName" name="lpIssueDeskTransBean" filter="false"/>
		</td>
	</tr>
</table>
<logic:equal value="13" name="lpIssueDeskTransBean" property="strRaisingReqTypeId">
<table class='TABLEWIDTH' align='center'cellpadding='1px' cellspacing='1px'>
					<tr>
						<td class='TITLE' colspan='4'>
							<div id="ii" style="color:white;">Issue Detail</div>
						</td>
						
						
					
					</tr>
					
					<tr>
					<td class='LABEL' width='25%'>Issue No.</td>
					<td class='CONTROL' width='25%'>
					<bean:write property="strIssueNo" name="lpIssueDeskTransBean" filter="false"/>
					</td>
				<td class='LABEL' width='25%'>Issue Date</td>
					<td class='CONTROL' width='25%'>
					<bean:write property="strIssueDate" name="lpIssueDeskTransBean" filter="false"/>
					</td>
					</tr>
					<tr>
					<td class='LABEL' width='25%'>C.R No.</td>
					<td class='CONTROL' width='25%' colspan='3'>
						<bean:write property="strCrNo" name="lpIssueDeskTransBean" filter="false"/>
						
					</td>
					
					</tr>
					</table>
</logic:equal>

<logic:equal value="12" name="lpIssueDeskTransBean" property="strRaisingReqTypeId">
<table class='TABLEWIDTH' align='center'cellpadding='1px' cellspacing='1px'>
					
					<tr>
						<td class='TITLE' colspan='4'>
							<div id="u" style="color:white;">Issue Detail</div>
						</td>
						
						
					
					</tr>
					<tr>
					<td class='LABEL' width='25%'>Issue No.</td>
					<td class='CONTROL' width='25%'>
					<bean:write property="strIssueNo" name="lpIssueDeskTransBean" filter="false"/>
					</td>
				<td class='LABEL' width='25%'>Issue Date</td>
					<td class='CONTROL' width='25%'>
					<bean:write property="strIssueDate" name="lpIssueDeskTransBean" filter="false"/>
					</td>
					</tr>
					<tr>
					<td class='LABEL' width='25%'>C.R No.</td>
					<td class='CONTROL' width='25%' colspan='1'>
						<bean:write property="strCrNo" name="lpIssueDeskTransBean" filter="false"/>
						
					</td>
					<td class='LABEL' width='25%'>Emp No.</td>
					<td class='CONTROL' width='25%' colspan='1'>
						<bean:write property="strCrNo" name="lpIssueDeskTransBean" filter="false"/>
						
					</td>
					</tr>
					</table>
</logic:equal>


<logic:equal value="14" name="lpIssueDeskTransBean" property="strRaisingReqTypeId">
<table class='TABLEWIDTH' align='center'cellpadding='1px' cellspacing='1px'>
					
					<tr>
						<td class='TITLE' colspan='4'>
							<div id="r" style="color:white;">Return Detail</div>
						</td>
						
						
					
					</tr>
					<tr>
					<td class='LABEL' width='25%'>Issue No.</td>
					<td class='CONTROL' width='25%'>
					<bean:write property="strIssueNo" name="lpIssueDeskTransBean" filter="false"/>
					</td>
				<td class='LABEL' width='25%'>Issue Date</td>
					<td class='CONTROL' width='25%'>
					<bean:write property="strIssueDate" name="lpIssueDeskTransBean" filter="false"/>
					</td>
					</tr>
					<tr>
					<td class='LABEL' width='25%'>Store Name</td>
					<td class='CONTROL' width='25%' colspan='1'>
						<bean:write property="strStoreName" name="lpIssueDeskTransBean" filter="false"/>
						
					</td>
					<td class='LABEL' width='25%'>Dept/Ward</td>
					<td class='CONTROL' width='25%' colspan='1'>
						<bean:write property="strDeptName" name="lpIssueDeskTransBean" filter="false"/>
						
					</td>
					</tr>
					</table>
</logic:equal>


	<div class='popup' id='itemDtlId' style="display:none">
		<table width='400' border="0" cellspacing ="0px" cellpadding="0px">
			<tr class="HEADER"> 
				<th align='left'><div id="popUpItemId"></div></th>
				<th align='right'><img  style='cursor:pointer;cursor:pointer' src='../../hisglobal/images/popUp_cancel.JPG'
					onClick="closeItemPopUp('itemDtlId');" title="Click Here To Close Popup"></th>
		    </tr>
		 </table>  
	  
	  
		 <table width='400' border="0" cellspacing ="1px" cellpadding="1px">
			<tr>
				<td colspan="1" class='multiLabel'>Issue Qty.</td>
				<td colspan="1" class='multiControl'><div id ='1'></div></td>
						
			</tr>
			<tr>
				<td colspan="1" class='multiLabel'>Return Qty.</td>
				<td colspan="1" class='multiControl'><div id ='2'></div></td>	
			</tr>
			<tr class="FOOTER">
				<td colspan="4"></td>
			</tr>
	        </table>
	</div>
	
		

<div id="patientDtlId" style="display: none;">
<table class="TABLEWIDTH" align="center" cellspacing="1px" cellpadding="1px">
		<tr>
			<td  colspan="4" class="TITLE">
			<div id="plusPatientDetailId" align="left" style="display:block;color:white;">
					<img src="../../hisglobal/images/plus.gif" 
									onClick="view1('plusPatientDetailId','minusPatientDetailId','patientAdmissionDtlId');" style="cursor: pointer; "/>
						Patient Detail
						
					</div>
					<div id="minusPatientDetailId" style="display:none;color:white;" align="left">
						<img src="../../hisglobal/images/minus.gif" 
								onClick="view2('plusPatientDetailId','minusPatientDetailId','patientAdmissionDtlId');" style="cursor: pointer; "/>
								Patient Details
					</div>
				</td>
		</tr>
	</table>
</div>	
		<div id="patientAdmissionDtlId" style="display:none">
			<bean:write property="strPatientDtl" name="lpIssueDeskTransBean" filter="false"/>
		</div>
		
		<table class="TABLEWIDTH" align="center" cellspacing="1px" cellpadding="1px">
		<tr>
			<td  colspan="4" class="TITLE">
			<div id="plusRequestItemDtlId" align="left" style="display:none;color:white;">
					<img src="../../hisglobal/images/plus.gif" 
									onClick="view1('plusRequestItemDtlId','minusRequestItemDtlId','strRequestItemDtlId');" style="cursor: pointer; "/>
						 Item Detail
						
					</div>
					<div id="minusRequestItemDtlId" style="display:block;color:white;" align="left">
						<img src="../../hisglobal/images/minus.gif" 
								onClick="view2('plusRequestItemDtlId','minusRequestItemDtlId','strRequestItemDtlId');" style="cursor: pointer; "/>
							 Item Detail
					</div>
				</td>
		</tr>
	</table>
	
	<div id="strRequestItemDtlId" style="display: block">
		<bean:write property="strRequestDtl" name="lpIssueDeskTransBean" filter="false" />
		</div>
		
		
		<div id='recommendationId'>
		  <table class="TABLEWIDTH" align="center" cellspacing="1px">
		  <tr>
		  <td class="TITLE" colspan="2"><div id="re" style="color:white;">Recommendation Details</div></td>
		  
		  </tr>
	 	<tr>
	 		<td class="LABEL" width="50%"><font color='red'>*</font>Recommend by</td>
	 		<td class="CONTROL" width="50%">
	 			<select name="strRecommendBy" class='comboNormal'>
	 				<bean:write property="strRecommendByVal" name="lpIssueDeskTransBean" filter="false" />
	 			</select>
	 		</td>
	 		
	 	</tr>
	 	<tr>
	 		<td class="LABEL">
	 			Remarks
	 		</td>
	 		<td class="CONTROL">
	 			<textarea name="strRemarks"></textarea>
	 		</td>
	 	</tr>
	 	
	 </table>
	 </div>
	 
	 <table border="0" class="TABLEWIDTH" align="center" cellspacing="0px" cellpadding="0px">
		<tr class="FOOTER">
		<td width='3%'><div id="plusHelpId" align="center"><img
						src="../../hisglobal/images/plus.gif" name="plusHelp"
						align="middle" style="cursor: pointer;"
						onclick="view1('plusHelpId','minusHelpId','HelpId');" /></div>
					<div id="minusHelpId" style="display: none" align="center"><img style="cursor: pointer;"
						src="../../hisglobal/images/minus.gif" name="minusHelp"
							onclick="view2('plusHelpId','minusHelpId','HelpId');"> </div></td>
						<td><div align="left">Help</div></td>
	</tr>
	</table>
	
	
	
	<div id="HelpId" style="display:none">
			<table border="0" class="TABLEWIDTH" align="center" bgcolor="#000000" cellspacing="1px" cellpadding="1px">
			<tr >
			<td class="CONTROL" style="background-color:#FFFFFF;"> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			 <button style="background-color:#F5786B;height: 20px;width: 20px;" disabled></button>&nbsp;Drug/Item has been expired
			</td>
			</tr>
			</table>
       </div>
	 
		<table CLASS ="TABLEWIDTH" align="center" cellspacing="1px">
		<tr class="FOOTER"> 
    	<td colspan="2" ><font size="2" color="red">*</font> Mandatory Fields  </td>
  		</tr>
	     <tr> 
		<td align="center">
		<!-- <img src="../../hisglobal/images/btn-sv.png"   onClick="SAVERETURN();" style="cursor: pointer;" title="Click Here To Save"/>
		<img src="../../hisglobal/images/btn-clr.png"
				onClick="document.forms[0].reset();" style="cursor: pointer;" title="Click here to reset the data">
		<img src="../../hisglobal/images/back_tab.png" onClick ="cancelToDesk();" style="cursor: pointer;" title="Click Here To Cancel"/>
	   -->
	   <br>
							<a href="#" class="button" id="" onclick='SAVERETURN();'><span class="save">Save</span></a>
							<a href="#" class="button"	onclick="document.forms[0].reset()"><span class="clear">Clear</span></a> 
							<a href="#" class="button" onclick="cancelToDesk();"><span class="cancel">Cancel</span></a>	   
	   
	   </td>
	  </tr>
</table>

<div id="blanket" style="display:none;"></div>
<div class="popUpDiv" id="popUpDiv" style="display:none;">

<table bgcolor="white">

<tr>

<td>

 <div id="issueDtlsDivId" style="display:block;"></div>

</td>

</tr>

</table>

</div>
		<input type="hidden" name="hmode"/>
		 <input type="hidden" name="strRequestTypeId" value="${lpIssueDeskTransBean.strRequestTypeId}"/>
	    <input type="hidden" name="strStoreId" value="${lpIssueDeskTransBean.strStoreId}"/>
	     <input type="hidden" name="strIssueDate" value="${lpIssueDeskTransBean.strIssueDate}"/>
	     <input type="hidden" name="strCrNo" value="${lpIssueDeskTransBean.strCrNo}"/>
	     <input type="hidden" name="strEmpNo" value="${lpIssueDeskTransBean.strEmpNo}"/>
	     <input type="hidden" name=strIssueNo value="${lpIssueDeskTransBean.strIssueNo}"/>
	     <input type="hidden" name="strItemCategNo" value="${lpIssueDeskTransBean.strItemCategNo}"/>
	     <input type="hidden" name="strRaisingReqTypeId" value="${lpIssueDeskTransBean.strRaisingReqTypeId}"/>
	     <input type="hidden" name="strIssueStoreId" value="${lpIssueDeskTransBean.strIssueStoreId}"/>
	     <input type="hidden" name="chk" value="${lpIssueDeskTransBean.strChk}"/>
	     <input type="hidden" name="strStoreName" value="${lpIssueDeskTransBean.strStoreName}"/>
	     <input type="hidden" name="strReturnNo" value="${lpIssueDeskTransBean.strReturnNo}"/>

	    <input type="hidden" name="strBillingHiddenValue" value ="${lpIssueDeskTransBean.strBillingHiddenValue}"/>
	    
	      
	      
<cmbPers:cmbPers/>

</html:form>
<tag:autoIndex></tag:autoIndex>  
</body>
</html>