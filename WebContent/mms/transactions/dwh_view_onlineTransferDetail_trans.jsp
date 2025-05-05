<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic"%>
<%@ taglib uri="/WEB-INF/dateTag.tld" prefix="dateTag"%>
<%@ taglib uri="/WEB-INF/hisTab.tld" prefix="tag"%>
<%@ taglib uri="/WEB-INF/comboPersistence.tld" prefix="cmbPers"%>
<%@ taglib uri="/WEB-INF/crNo.tld" prefix="crNo"%>


<html>
<head>
<meta charset=UTF-8">
<title>Online Transfer Detail</title>
<link href="../css/master.css" rel="stylesheet" type="text/css">
<link href="../css/transaction.css" rel="stylesheet" type="text/css">
<link href="../../hisglobal/css/tab.css" rel="stylesheet" type="text/css">
<link href="../../hisglobal/css/calendar-tas.css" rel="stylesheet" type="text/css">
<link href="../../hisglobal/css/popup.css" rel="stylesheet" type="text/css">
<link href="../../hisglobal/css/newpopup.css" rel="stylesheet" type="text/css">

<script language="JavaScript"
	src="../../hisglobal/masterutil/js/master.js"></script>
<script language="JavaScript" src="../../hisglobal/js/tab.js"></script>
<script language="JavaScript" src="../../hisglobal/js/calendar.js"></script>
<script language="Javascript" src="../../hisglobal/js/validation.js"></script>
<script language="Javascript" src="../../hisglobal/js/util.js"></script>
<script language="Javascript" src="../../hisglobal/js/popup.js"></script>
<script language="Javascript" src="../../hisglobal/js/newpopup.js"></script>
<script language="Javascript" src="../js/issueDetails_util.js"></script>
<script language="JavaScript" src="../js/dwh_main_onlineTransferDetail_trans.js"></script>


<script type="text/javascript">

</script>
</head>
<body onload="">

<html:form name="onlineTransferDetailTransFB"
	action="/transactions/OnlineTransferDetailTransCNT"
	type="mms.transactions.controller.fb.OnlineTransferDetailTransFB">

	<div id="errMsg" class="errMsg"><bean:write
		name="onlineTransferDetailTransFB" property="strErrMsg" /></div>
	<div id="warningMsg" class="warningMsg"><bean:write
		name="onlineTransferDetailTransFB" property="strWarningMsg" /></div>
	<div id="normalMsg" class="normalMsg"><bean:write
		name="onlineTransferDetailTransFB" property="strNormalMsg" /></div>

	<tag:tab tabLabel="Online Transfer Detail" selectedTab="FIRST"
		align="center" width="TABLEWIDTH">
	</tag:tab>

	<table class="TABLEWIDTH" align="center" border="0" cellspacing="1px">


		<tr class="HEADER">
			<td colspan="4">Online Transfer Detail&gt;&gt;View</td>

			<td align="right"><span> <html:checkbox
				property="strViewChk" name="onlineTransferDetailTransFB" value="1"
				onclick="transferToViewPage();">View/Cancel</html:checkbox> </span></td>
		</tr>

	</table>



	<table class="TABLEWIDTH" align="center" cellpadding="1"
		cellspacing="1">
		<tr>
			<td width="25%" colspan="1" class="LABEL"><font color="red">*</font>Store Name</td>
			<td width="25%" colspan="1" class="CONTROL"><select
				name="strStoreId" class="comboNormal" onchange="clearDivId();">
				<option value="0">Select Value</option>
				<bean:write name="onlineTransferDetailTransFB"
					property="strStoreValues" filter="false" />
			</select></td>
			<td class="LABEL" colspan="1"></td>
			<td class="CONTROL" colspan="1"></td>

		</tr>


		<tr>
			<td class="LABEL" colspan="1"><font color="red">*</font>From Date</td>
			<td class="CONTROL" colspan="1"><dateTag:date name="strFromDate" 
				value="${onlineTransferDetailTransFB.strCtDate}" /></td>

			<td class="LABEL" colspan="1"><font color="red">*</font>To Date</td>
			<td class="CONTROL" colspan="1"><dateTag:date name="strToDate" 
				value="${onlineTransferDetailTransFB.strCtDate}" /></td>
		</tr>	
		
		<tr>
			<td width="100%" colspan="4" class="CONTROL">

			<div align="center"><img src="../../hisglobal/images/btn-search.png" 
									onClick="searchTransferDetails();" style="cursor: pointer; "/></div>
			</td>

		</tr>


	</table>

	<div id="searchTransferDtlsDivId" style="display: none;"></div>
	
	<div id="itemDtlId" style="display: none;"></div>

	<div id="remarksDtlId" style="display: none;">
		<table class="TABLEWIDTH" align="center" cellpadding="1" cellspacing="1">
				<tr>
					<td width="50%" colspan="2" class="LABEL"><font color="red">*</font> Remarks(if any)</td>
					<td width="50%" colspan="2" class="CONTROL">
						<html:textarea property="strRemarks"  name="onlineTransferDetailTransFB">
						</html:textarea>
					</td>
				</tr>
			</table>
	</div>

	<table class="TABLEWIDTH" align="center" cellpadding="1"
		cellspacing="1">
		<tr class="FOOTER">
			<td colspan="4"><font color="red">*</font> Mandatory Fields</td>
		</tr>
	</table>
	<table border="0" class="TABLEWIDTH" align="center" cellpadding="1"
		cellspacing="1">
		<tr>

			<td align="center">				 
				<img style="cursor: pointer" src="../../hisglobal/images/btn-clr.png" onClick="clearViewPage();" title="Click to Clear Page">				
				<img style="cursor: pointer" src="../../hisglobal/images/btn-del.png" onClick="cancelTransferRequest();" title="Click to Delete Request">
				<img style="cursor: pointer" src="../../hisglobal/images/back_tab.png" onClick="clickBackButton();" title="Click to Back ">				
				<img style="cursor: pointer" src="../../hisglobal/images/print_tab.png" onClick="printVoucher();" title="Click to Print Page">
			</td>

		</tr>
	</table>
	<input type="hidden" name="hmode" />
	<input type="hidden" name="strStoreName" value="${onlineTransferDetailTransFB.strStoreName} " />
	<input type="hidden" name="strTmpTransferNo" value="${onlineTransferDetailTransFB.strTmpTransferNo} " />
	<input type="hidden" name="strTmpStoreName" value="${onlineTransferDetailTransFB.strTmpStoreName} " />
	<input type="hidden" name="strTmpTransferDate" value="${onlineTransferDetailTransFB.strTmpTransferDate} " />
	<input type="hidden" name="strTmpStoreNo" value="${onlineTransferDetailTransFB.strTmpStoreNo} " />
	<input type="hidden" name="strDwhName" value="${onlineTransferDetailTransFB.strDwhName} " />

<input type="hidden" name="strTransferNo" value="0" />



	<cmbPers:cmbPers />

	<div id="blanket" style="display: none;"></div>
	<div class="popUpDiv" id="popUpDiv" style="display: none;">
	<table bgcolor="white">
		<tr>
			<td>

			<div id="transferDtlsDivId" style="display: block;"></div>

			</td>
		</tr>
	</table>
	</div>


</html:form>
<tag:autoIndex></tag:autoIndex>
</body>
</html>
