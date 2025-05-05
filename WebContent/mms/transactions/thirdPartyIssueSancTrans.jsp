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
<title>Third Party Issued Items</title>
<link href="../css/master.css" rel="stylesheet" type="text/css">
<link href="../../hisglobal/css/tab.css" rel="stylesheet" type="text/css">
<link href="../../hisglobal/css/calendar-tas.css" rel="stylesheet" type="text/css">
<link href="../../hisglobal/css/newpopup.css" rel="stylesheet" type="text/css">		
<link href="../../hisglobal/css/buttons.css" rel="stylesheet" type="text/css">
<script language="JavaScript" src="../../masterutil/js/master.js"></script>
<script language="JavaScript" src="../../hisglobal/js/tab.js"></script>
<script language="JavaScript" src="../../hisglobal/js/calendar.js"></script>
<script language="Javascript" src="../../hisglobal/js/validation.js"></script>
<script language="JavaScript" src="../../hisglobal/js/util.js"></script>
<script language="JavaScript" src="../../hisglobal/js/newpopup.js"></script>
<script language="JavaScript" src="../../hisglobal/js/multirow.js"></script>

<script language="JavaScript" src="../js/thirdPartyIssueSancTrans.js"></script>
<script language="JavaScript" src="../js/searchItems_util.js"></script>
<script language="JavaScript" src="../js/issueDetails_util.js"></script>
<script type="text/javascript">

</script>
</head>
<!-- onLoad="openIssueReport();" -->
<body onLoad="openIssueReport();">
<html:form name="thirdPartyIssueSancBean"
	action="/transactions/ThirdPartyIssueSancTransCNT"
	type="mms.transactions.controller.fb.ThirdPartyIssueSancTransFB">
	
<center>
	<div id="errMsg" class="errMsg"><bean:write name="thirdPartyIssueSancBean" property="strErrMsg" /></div>
	<div id="warningMsg" class="warningMsg"><bean:write name="thirdPartyIssueSancBean" property="strWarningMsg" /></div>
	<div id="normalMsg" class="normalMsg"><bean:write name="thirdPartyIssueSancBean" property="strNormalMsg" /></div>
	<tag:tab tabLabel="Third Party Issue" selectedTab="FIRST" align="center" width="TABLEWIDTH"> </tag:tab>
</center>

			<table class="TABLEWIDTH" align="center" cellpadding="1" cellspacing="1">   
			    <tr class="HEADER">
					<td colspan="4"></td>
				</tr>
				<tr>
					<td width="25%" colspan="1" class="LABEL">
						Store Name
					</td>
					<td width="25%" colspan="1" class="CONTROL">
						<bean:write name="thirdPartyIssueSancBean" property="strStoreName" filter="false" />
					</td>
					<td width="25%" colspan="1" class="LABEL">Issue Date &amp; Time</td>
					<td width="25%" colspan="1" class="CONTROL">
					   <font color="blue"><bean:write name="thirdPartyIssueSancBean" property="strCurrentDate" filter="false" /></font>
					</td>
				</tr>
				<tr>
					<td width="50%" colspan="2" class="LABEL"><font size="1" color="red">*</font>
					Third Party Name
					</td>
					<td width="50%" colspan="2" class="CONTROL">
					  <bean:write name="thirdPartyIssueSancBean" property="strInstituteValues" filter="false"/>
					</td>
					
				</tr>
				<tr>
					<td width="50%" colspan="2" class="LABEL"><font size="1" color="red">*</font>
					Item Category
					</td>
					<td width="50%" colspan="2" class="CONTROL">
					  <bean:write name="thirdPartyIssueSancBean" property="strItemCatValues" filter="false"/>
					</td>
				</tr>
			</table>
		
			<table class="TABLEWIDTH" align="center" cellpadding="1" cellspacing="1">   
				<tr class="TITLE">
					<td colspan="4"><div id='' style='color:blue;'>Item/Drug Details</div>
					</td>
					</tr>
					
					<tr>
					<td width="50%" class="LABEL" ><font size="1" color="red">*</font>
					Group Name
					</td>
					<td width="50%" class="CONTROL" >
					  <bean:write name="thirdPartyIssueSancBean" property="strGroupName" filter="false"/>
					</td>
				</tr>
			</table>
			
			<table class="table">
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
			<bean:write name="thirdPartyIssueSancBean" property="strItemDtls" filter="false"/>
			</div>
			
			<table class="TABLEWIDTH" align="center" cellpadding="1px" cellspacing="1px">
			 <tr>
					<td colspan="2" width="50%" class="LABEL">Received By</td>
					<td colspan="2" width="50%" class="CONTROL">
			  		<input type="text" name="strReceiveBy" class="txtFldMax">
    	 			</td>
			  </tr>
		      <tr>
					<td colspan="2" width="50%" class="LABEL">Remarks</td>
					<td colspan="2" width="50%" class="CONTROL">
			  		<textarea name="strRemarks" rows="2"></textarea>
    	 			</td>
			  </tr>
		      <tr class="FOOTER">
			        <td colspan="4"><font size="2" color="red">*</font>Mandatory Fields</td>
		      </tr>
	        </table>
<!-- 	<table border="0" class="TABLEWIDTH" align="center">
		<tr>

			<td align="center">
			<img style="cursor: pointer; "
				src="../../hisglobal/images/btn-sv.png" onClick="return validate1();" title='Click Here To Save Data'/>
				<img style="cursor: pointer; " src="../../hisglobal/images/btn-clr.png" onClick="clearDtl('requestPage');" >
			<img  style="cursor: pointer; " src="../../hisglobal/images/back_tab.png" onClick="cancel1();" title='Click Here Go Back To Main Desk'>
		</td>
		</tr>
	</table>-->
	<br>
			 <div align="center" >					 
			 	<a href="#" class="button" id="submitId" onclick=' return validate1();'><span class="save">Save</span></a>
				<a href="#" class="button"	onclick="clearDtl('requestPage');"><span class="clear">Clear</span></a> 
				<a href="#" class="button" onclick="cancel1();"><span class="cancel">Cancel</span></a>
			</div> 
			
		<input type="hidden" name="hmode"/>
		<input type="hidden" name="mode" value="${thirdPartyIssueSancBean.mode}"/>
		<input type="hidden" name="strChk" value="${thirdPartyIssueSancBean.strChk}"/>
		<input type="hidden" name="strCurrentDate" value="${thirdPartyIssueSancBean.strCurrentDate}"/>
		<input type="hidden" name="strStoreId" value="${thirdPartyIssueSancBean.strStoreId}" />
		<input type="hidden" name="strReqNo" value="${thirdPartyIssueSancBean.strReqNo}" />
		<input type="hidden" name="strItemCatNo" value="${thirdPartyIssueSancBean.strItemCatNo}" />
		<input type="hidden" name="strStoreTypeId" value="${thirdPartyIssueSancBean.strStoreTypeId}" />
		<input type="hidden" name="comboValue" value="${thirdPartyIssueSancBean.strStoreName}">

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