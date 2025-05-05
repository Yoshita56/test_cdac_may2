<%@ page language="java" contentType="text/html;"	pageEncoding="UTF-8"%>
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
<title>Third Party Issue Items</title>
<link href="../css/master.css" rel="stylesheet" type="text/css">
<link href="../../hisglobal/css/tab.css" rel="stylesheet" type="text/css">
<link href="../../hisglobal/css/calendar-tas.css" rel="stylesheet" type="text/css">
<link href="../../hisglobal/css/newpopup.css" rel="stylesheet" type="text/css">		
<link href="../../hisglobal/css/buttons.css" rel="stylesheet" type="text/css">
<style type="text/css">

  .Approved 
   {
	font-family: Verdana, Arial, Helvetica, sans-serif;
	font-size: 12px;
	font-style: normal;
	font-weight: normal;
	color: #151AFB;
	background-color: #D3D5C9;
	height: 16px;
	text-align:center;
    }
    
   .NotApproved 
   {
	font-family: Verdana, Arial, Helvetica, sans-serif;
	font-size: 12px;
	font-style: normal;
	font-weight: normal;
	color: #000000;
	background-color: #F1ECE2;
	height: 16px;
	text-align:center;
    }
  

           
</style>
<script language="JavaScript" src="../../masterutil/js/master.js"></script>
<script language="JavaScript" src="../../hisglobal/js/tab.js"></script>
<script language="JavaScript" src="../../hisglobal/js/calendar.js"></script>
<script language="Javascript" src="../../hisglobal/js/validation.js"></script>
<script language="JavaScript" src="../../hisglobal/js/util.js"></script>
<script language="JavaScript" src="../../hisglobal/js/newpopup.js"></script>
<script language="JavaScript" src="../../hisglobal/js/multirow.js"></script>
<script language="JavaScript" src="../js/thirdPartyIssueDesk.js"></script>
<script language="JavaScript" src="../js/searchItems_util.js"></script>
<script language="JavaScript" src="../js/issueDetails_util.js"></script>
<script type="text/javascript">





</script>
</head>
<body >
<html:form name="thirdPartyIssueDeskBean"
	action="/transactions/ThirdPartyIssueDeskCNT"
	type="mms.transactions.controller.fb.ThirdPartyIssueDeskFB">
	
<center>
	<div id="errMsg" class="errMsg"><bean:write name="thirdPartyIssueDeskBean" property="strErrMsg" /></div>
	<div id="warningMsg" class="warningMsg"><bean:write name="thirdPartyIssueDeskBean" property="strWarningMsg" /></div>
	<div id="normalMsg" class="normalMsg"><bean:write name="thirdPartyIssueDeskBean" property="strNormalMsg" /></div>
	<tag:tab tabLabel="Third Party Issue Detail View" selectedTab="FIRST" align="center" width="TABLEWIDTH"> </tag:tab>
</center>

	<table class="TABLEWIDTH" align="center" cellpadding="1" cellspacing="1">   
	<tr class="HEADER">
			<td colspan="4"></td>
	</tr>
	</table>
	
		<table class="TABLEWIDTH" align="center" cellpadding="1" cellspacing="1">   
		<tr>
			<td width="25%" colspan="1" class="LABEL">
				Store Name
			</td>
			<td width="25%" colspan="1" class="CONTROL">
				<bean:write name="thirdPartyIssueDeskBean" property="strStoreName" filter="false" />
			</td>
		
			<td width="25%" colspan="1" class="LABEL">
			    Third Party Name
			</td>
			<td width="25%" colspan="1" class="CONTROL">
			  <bean:write name="thirdPartyIssueDeskBean" property="strInstituteValues" filter="false"/>
			</td>
		</tr>
		<tr>
			<td width="25%" colspan="1" class="LABEL">
			    Item Category
			</td>
			<td width="25%" colspan="1" class="CONTROL">
			  <bean:write name="thirdPartyIssueDeskBean" property="strItemCatValues" filter="false"/>
			</td>
			<td width="25%" colspan="1"  class="LABEL" >
			    Group Name
			</td>
			<td width="25%" colspan="1"  class="CONTROL" >
			  <bean:write name="thirdPartyIssueDeskBean" property="strGroupName" filter="false"/>
			</td>
		</tr>
		</table>
	<table class="TABLEWIDTH" align="center" cellpadding="1" cellspacing="1">   
		
		<tr class="TITLE">
			<td colspan="4">Item/Drug Details</td>
		</tr>
		
		</table>
		<table class="TABLEWIDTH" align="center" cellpadding="1px" cellspacing="1px">
		  <tr>
			<td width="15%" class="multiLabel">Item/Drug Name
			</td>
			<td width="15%" class="multiLabel">Batch/Sl No.
			</td>
			<td width="10%" class="multiLabel">Expiry Date
			</td>
			<td width="15%" class="multiLabel">Available Qty
			</td>
			<td width="15%" class="multiLabel">Req.Qty
			</td>
			<td width="15%" class="multiLabel">Sanct.Qty
			</td>
			<td width="15%" class="multiLabel">Issue Qty
			</td>
		  </tr>
		</table>
			
			<div id="id1">
			<bean:write name="thirdPartyIssueDeskBean" property="strItemDtls" filter="false"/>
			</div>
			
		 <logic:equal value="1" name="thirdPartyIssueDeskBean" property="strThirdPartyFlag">		
				<table class="TABLEWIDTH" align="center" cellpadding="1" cellspacing="1">   
					<tr class="TITLE">
						<td colspan="4">Approval Details</td>
					</tr>
				</table>
				
					<div id="id2">
						<bean:write name="thirdPartyIssueDeskBean" property="strApprovalDtls" filter="false"/>
					</div>
		 </logic:equal>	
			
			<table class="TABLEWIDTH" align="center" cellpadding="1px" cellspacing="1px">
		<tr>
					<td colspan="2" width="50%" class="LABEL">Remarks</td>
					<td colspan="2" width="50%" class="CONTROL">
			  		<textarea name="strRemarks" rows="2" readonly><bean:write name="thirdPartyIssueDeskBean" property="strRemarks" filter="false"/></textarea>
    	 			</td>
			  </tr>
			
		<tr class="FOOTER">
			 <td colspan="4">  </td>
		</tr>
	</table>
	<!-- 
	<table border="0" class="TABLEWIDTH" align="center">
		<tr>
		<td align="center">
		     <img style="cursor: pointer" src="../../hisglobal/images/print_tab.gif" onClick="openIssueReport();" />
			<img  style="cursor: pointer; " src="../../hisglobal/images/back_tab.png" onClick="cancelView();" title='Click Here To Come Back On Desk' >
		</td>
		</tr>
	</table>-->
	<br>
	<div align="center" id=" ">					 
					 	<a href="#" class="button" id="submitId" onclick='openIssueReport();'><span class="print">Print</span></a>
						<a href="#" class="button" onclick="cancelView();"><span class="cancel">Cancel</span></a>
					</div> 
<input type="hidden" name="hmode"/>
<input type="hidden" name="mode"/>
<input type="hidden" name="strCurrentDate" value="${thirdPartyIssueDeskBean.strCurrentDate}"/>
<input type="hidden" name="strStoreId" value="${thirdPartyIssueDeskBean.strStoreId}" />
<input type="hidden" name="strStoreTypeId" value="${thirdPartyIssueDeskBean.strStoreTypeId}" />
<input type="hidden" name="comboValue" value="${thirdPartyIssueDeskBean.strStoreName}">
<input type="hidden" name="strIssueNo" value="${thirdPartyIssueDeskBean.strReqNo}"/>


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
<cmbPers:cmbPers />
</html:form>
<tag:autoIndex></tag:autoIndex>
</body>
</html>