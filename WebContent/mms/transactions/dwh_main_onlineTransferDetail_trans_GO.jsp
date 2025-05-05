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
<link href="../css/transaction.css" rel="stylesheet" type="text/css">
<link href="../css/transaction.css" rel="stylesheet" type="text/css">
<link href="../../hisglobal/css/tab.css" rel="stylesheet"
	type="text/css">
<link href="../../hisglobal/css/calendar-tas.css" rel="stylesheet"
	type="text/css">
<link href="../../hisglobal/css/popup.css" rel="stylesheet"
	type="text/css">
<link href="../../hisglobal/css/newpopup.css" rel="stylesheet"
	type="text/css">

<script language="JavaScript"
	src="../../hisglobal/masterutil/js/master.js"></script>
<script language="JavaScript" src="../../hisglobal/js/tab.js"></script>
<script language="JavaScript" src="../../hisglobal/js/calendar.js"></script>
<script language="Javascript" src="../../hisglobal/js/validation.js"></script>
<script language="Javascript" src="../../hisglobal/js/util.js"></script>
<script language="Javascript" src="../../hisglobal/js/popup.js"></script>
<script language="Javascript" src="../../hisglobal/js/newpopup.js"></script>
<script language="JavaScript"
	src="../js/dwh_main_onlineTransferDetail_trans.js"></script>


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
			<td colspan="4">Online Transfer Detail&gt;&gt;</td>

			<td align="right"><span> <html:checkbox
				property="strViewChk" name="onlineTransferDetailTransFB" value="1"
				onclick="transferToViewPage();">View/Cancel</html:checkbox> </span></td>
		</tr>

	</table>



	<table class="TABLEWIDTH" align="center" cellpadding="1"
		cellspacing="1">
		<tr>
			<td width="25%" colspan="1" class="LABEL"><font color="red">*</font>Store Name</td>
			<td width="25%" colspan="1" class="CONTROL">
				<bean:write name="onlineTransferDetailTransFB" property="strStoreName" filter="false" />
			</td>

			<td width="25%" class="LABEL">Transfer Date &amp; Time</td>
			<td width="25%" class="CONTROL">
				<bean:write name="onlineTransferDetailTransFB" property="strTransferDateTime" filter="false" />
			</td>
		</tr>


		<tr>
			<td width="25%" colspan="1" class="LABEL"><font color="red">*</font>Order No</td>
			<td width="25%" colspan="1" class="CONTROL"><bean:write
				name="onlineTransferDetailTransFB" property="orderNO" filter="false" />
			</td>

			<td width="25%" class="CONTROL"></td>
			<td width="25%" class="CONTROL"></td>
		</tr>

		<tr>
			<td colspan="4" class="TITLE"></td>
		</tr>


		<tr>
			<td width="25%" colspan="1" class="LABEL"><font color="red">*</font>Order Date</td>
			<td width="25%" colspan="1" class="CONTROL">
				<bean:write name="onlineTransferDetailTransFB" property="strOrderDate" filter="false" />
			</td>

			<td width="25%" colspan="1" class="LABEL"><font color="red">*</font>Receiving Store Name</td>
			<td width="25%" colspan="1" class="CONTROL">
				<bean:write name="onlineTransferDetailTransFB" property="strReceivingDDWName" filter="false" />
			</td>
		</tr>

		<tr>
			<td width="25%" colspan="1" class="LABEL"><font color="red">*</font>Ordered	Qty</td>
			<td width="25%" colspan="1" class="CONTROL">
				<bean:write name="onlineTransferDetailTransFB" property="strOrderQty" filter="false" />
			</td>

			<td width="25%" class="CONTROL"></td>
			<td width="25%" class="CONTROL"></td>
			
		</tr>
		
			<tr>
			<td width="25%" colspan="1" class="LABEL"><font color="red">*</font>Item/Drug Name</td>
			<td width="75%" colspan="3" class="CONTROL">
			<div >
			 	<font color='blue'>
			 	<b>
					<bean:write name="onlineTransferDetailTransFB" property="strDrugName" filter="false" />
				</b>	
				</font>
			</div>	
			</td>
			</tr>

	</table>


	<bean:write name="onlineTransferDetailTransFB" property="strBatchDetailsTable" filter="false" />

	<table class="TABLEWIDTH" align="center" cellpadding="1" cellspacing="1">
		<tr>
			<td width="50%" class="LABEL">Remarks(if any)</td>
			<td width="50%" class="CONTROL">
				<html:textarea property="strRemarks"  name="onlineTransferDetailTransFB">
				</html:textarea>
			</td>
		</tr>
	</table>

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
				<img style="cursor: pointer" src="../../hisglobal/images/btn-sv.png" onClick="validate1();" title="Click to Save Page"> 
				<img style="cursor: pointer" src="../../hisglobal/images/btn-clr.png" onClick="clearPage();" title="Click to Clear Page"> 
				<img style="cursor: pointer"src="../../hisglobal/images/btn-ccl.png" onClick="cancelPage();" title="Click to cancel process">
			</td>
				

		</tr>
	</table>
	<input type="hidden" name="hmode" />
	<input type="hidden" name="orderNO" value="${onlineTransferDetailTransFB.orderNO} " />
<input type="hidden" name="strStoreId" value="${onlineTransferDetailTransFB.strStoreId} " />
	<input type="hidden" name="strStoreName" value="${onlineTransferDetailTransFB.strStoreName} " />
	<input type="hidden" name="strTmpTransferNo" value="${onlineTransferDetailTransFB.strTmpTransferNo} " />
	<input type="hidden" name="strTmpStoreName" value="${onlineTransferDetailTransFB.strTmpStoreName} " />
	<input type="hidden" name="strTmpTransferDate" value="${onlineTransferDetailTransFB.strTmpTransferDate} " />
	<input type="hidden" name="strTmpStoreNo" value="${onlineTransferDetailTransFB.strTmpStoreNo} " />
	<input type="hidden" name="strDwhName" value="${onlineTransferDetailTransFB.strDwhName} " />
	<input type="hidden" name="strToStoreId" value="${onlineTransferDetailTransFB.strToStoreId} " />
	<input type="hidden" name="strItemBrandId" value="${onlineTransferDetailTransFB.strItemBrandId} " />
	<input type="hidden" name="strOrderNo" value="${onlineTransferDetailTransFB.strOrderNo} " />
	<input type="hidden" name="strOrderQtyBase" value="${onlineTransferDetailTransFB.strOrderQtyBase} " />
	



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
