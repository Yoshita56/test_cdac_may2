<%@ page language="java" contentType="text/html;"	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<%@taglib uri="/WEB-INF/dateTag.tld" prefix="dateTag"%>
<%@ taglib uri="/WEB-INF/hisTab.tld" prefix="tag"%>
<%@ taglib uri="/WEB-INF/comboPersistence.tld" prefix="cmbPers"%>

 
 
<html>
<head>
<meta charset=UTF-8">
<title>Solution Desk</title>
<link href="../css/master.css" rel="stylesheet" type="text/css">
<link href="../../hisglobal/css/tab.css" rel="stylesheet" type="text/css">
<link href="../../hisglobal/css/calendar-tas.css" rel="stylesheet" type="text/css">

<link href="../../hisglobal/css/popup.css" rel="stylesheet" type="text/css">	
	
<script language="JavaScript" src="../../hisglobal/masterutil/js/master.js"></script>
<script language="JavaScript" src="../../hisglobal/js/tab.js"></script>
<script language="JavaScript" src="../../hisglobal/js/calendar.js"></script>
<script language="Javascript" src="../../hisglobal/js/validation.js"></script>
<script language="Javascript" src="../../hisglobal/js/util.js"></script>
<script language="Javascript" src="../../hisglobal/js/popup.js"></script>
<script language="Javascript" src="../js/SolutionDesk_view_trans.js"></script>

</head>
<body>
<html:form name="SolutionDeskTransBean" action="/transactions/SolutionDeskCNT"
	type="mms.transactions.controller.fb.SolutionDeskFB">
	
<center>
	<div id="errMsg" class="errMsg"><bean:write name="SolutionDeskTransBean" property="strErr" /></div>
	<div id="warningMsg" class="warningMsg"><bean:write name="SolutionDeskTransBean" property="strWarning"/></div>
	<div id="normalMsg" class="normalMsg"><bean:write name="SolutionDeskTransBean" property="strMsg"/></div>
	
</center>
		<tag:tab tabLabel="Solution Desk"
				selectedTab="FIRST" align="center" width="TABLEWIDTH">
              </tag:tab>
	
	<table class="TABLEWIDTH" align="center" cellpadding="1px" cellspacing="1px">   
	<tr class="HEADER">
			<td colspan="4"></td>
	</tr>
		
   </table>
 
	<bean:write name="SolutionDeskTransBean" property="strAcknowledgeDetails" filter="false"/>
	<table class="TABLEWIDTH" align="center" cellpadding="1" cellspacing="1">
	  <tr>
			<td class="LABEL" width="25%">Approval Status</td>
			<td width="25%" class="CONTROL" colspan="3"><input type="radio" name="strApproved" value="1" onClick="FuncTick(this)"/>
		 Enter Solution <input type="radio" name="strRejected" value="2" onClick="FuncTick(this),setApprovedQty();"/>Rejected
		</tr>
		</table>
	<div id="approveDiv" style="display:none;">
								
				<table class="TABLEWIDTH" align="center" cellspacing="1px" cellpadding="1px" > 
				<tr>
			<td width="25%" colspan="1" class="LABEL"><font color="red">*</font>Solution</td>
			<td width="25%" colspan="3" class="CONTROL">
			<textarea name="strprobsol" rows="10" cols="50"></textarea>
			</td>
			<td width="25%" colspan="1" class="LABEL"><font color="red">*</font>Solution Given By</td>
			<td width="25%" colspan="3" class="CONTROL">
				<input class="txtFldMax" type="text" size='45' name="strsubmitby" >
			</td>
			</tr>
		
			  </table>
			</div>
			<div id="rejectDiv" style="display:none;">
								
				<table class="TABLEWIDTH" align="center" cellspacing="1px" cellpadding="1px" > 
				<tr>
			<td width="25%" colspan="1" class="LABEL"><font color="red">*</font>Remarks</td>
			<td width="25%" colspan="3" class="CONTROL">
			<textarea name="strremarks" rows="5" cols="25"></textarea>
			</td>
			<td width="25%" colspan="1" class="LABEL"><font color="red">*</font>Rejected By</td>
			<td width="25%" colspan="3" class="CONTROL">
				<input class="txtFldMax" type="text" size='45' name="strsubmitby" >
			</td>
			</tr>
		
			  </table>
			</div>
			
		<table class="TABLEWIDTH" align="center" cellpadding="1" cellspacing="1">
  		<tr class="FOOTER">
			 <td colspan="4"></td>
		</tr>
		<tr>
			<td align="center" colspan="4">
			<img style="cursor:pointer;cursor:pointer"  title="Click to Save Record" src="../../hisglobal/images/btn-sv.png"  onClick="savedata();" />
	        <img style="cursor:pointer;cursor:pointer"  title="Click to Clear Page" src="../../hisglobal/images/btn-clr.png" name="clearImg" onclick="initPage();">
			<img style="cursor: pointer" src="../../hisglobal/images/btn-ccl.png" title="Click to Return On Desk" onClick="cancelToDesk();" >
			</td>
		</tr>
	</table>
	 
	
	
<input type="hidden" name="hmode"/>

<input type="hidden" name="strPath" value="${SolutionDeskTransBean.strPath}">
<input type="hidden" name="chk" value="${SolutionDeskTransBean.chk[0]}">
<input type="hidden" name="strHidVal" value="${SolutionDeskTransBean.strHidVal}">
<input type="hidden" name="strAckStatus" value="${SolutionDeskTransBean.strAckStatus}">
<input type="hidden" name="strTransNo" value="${SolutionDeskTransBean.strTransNo}">
<input type="hidden" name="strStoreId" value="${SolutionDeskTransBean.strStoreId}">
 <!--<input type="hidden" name="strComboVal" value="${SolutionDeskTransBean.strComboVal}"> -->
<cmbPers:cmbPers/>
</html:form>
<tag:autoIndex></tag:autoIndex>
</body>
</html>