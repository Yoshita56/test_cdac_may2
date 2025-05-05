 <%@ page language="java" contentType="text/html;" pageEncoding="UTF-8"%> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<%@ taglib uri="/WEB-INF/hisTab.tld" prefix="tag"%>
<%@taglib uri="/WEB-INF/dateTag.tld" prefix="dateTag"%>
<%@ taglib uri="/WEB-INF/comboPersistence.tld" prefix="cmbPers"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" /> 
<title>Drug Transfer Order Generation</title>
<link href="../../hisglobal/css/dwh.css" rel="stylesheet" type="text/css">
<link href="../../hisglobal/css/control.css" rel="stylesheet" type="text/css">
<link href="../../hisglobal/css/calendar-tas.css" rel="stylesheet" type="text/css">
<link href="../../hisglobal/css/popup.css" rel="stylesheet" type="text/css">

<script language="JavaScript" src="../../hisglobal/js/tab.js"></script>
<script language="JavaScript" src="../../hisglobal/js/calendar.js"></script>
<script language="JavaScript" src="../../hisglobal/js/util.js"></script>
<script language="JavaScript" src="../../hisglobal/js/validation.js"></script>
<script language="Javascript" src="../../hisglobal/js/popup.js"></script>
<script language="Javascript" src="../js/transfer_order_dtl_generation_new.js"></script>
<style type="">
.circle{
    -webkit-border-radius:8px;
    -moz-border-radius:8px;
    border-radius:8px;
    border:1px solid #faad07;
    width:15px;
    height:15px;
    background-color:#faad07;
}
</style>
</head>

<body class="background">
		<html:form name="TransferOrderDetailTransBean"
		action="/transactions/TransferOrderDetailTransCNT"
		type="mms.transactions.controller.fb.TransferOrderDetailTransFB"
		styleClass="formbg">

<input type='hidden' name='IMCS_TOKEN' value='<%=request.getSession().getAttribute("IMCS_TOKEN").toString().trim() %>'/>	

		<div class="errMsg" id="errMsg">
			<bean:write name="TransferOrderDetailTransBean" property="strErr" />
		</div>
		<div class="warningMsg" id="warningMsg">
			<bean:write name="TransferOrderDetailTransBean" property="strWarning" />
		</div>
		<div class="normalMsg" id="normalMsg">
			<bean:write name="TransferOrderDetailTransBean" property="strMsg" />
		</div>

	   <table class="TABLEWIDTH" align="center" border="0" cellpadding="1px" cellspacing="1px">
			<tr class="HEADER">
				<td colspan="4"><bean:message key="label.common.Transfer_order"/> &gt;&gt;
					<bean:message key="label.common.Modify"/></td>
			</tr>
			
			<bean:write name="TransferOrderDetailTransBean" property="strTransferingOrderDetails" filter="false" />

			

		</table>

		<div id="transferingDtlsDivId">
			<bean:write name="TransferOrderDetailTransBean"
				property="strTransferingDetails" filter="false" />
		</div>

		<table class="TABLEWIDTH" align="center" border="0" cellpadding="1px"
			cellspacing="1px">
			<tr>
				<td width="50%" class="LABEL" valign="middle" colspan="2"><bean:message key="label.common.Remarks(if_any)"/></td>
				<td width="50%" class="CONTROL" colspan="2"><textarea
						name="strRemarks" cols="25" rows="2"
						onkeypress="return validateData(event,9);"></textarea></td>
			</tr>
		</table>

		<table class="TABLEWIDTH" align="center" border="0" cellpadding="1px"
			cellspacing="1px">

			<tr class="FOOTER">
				<td colspan="4" width="25%"></td>
			</tr>
		</table>
		
		<div>		   
		 <div class="control_button"><table  class="TABLEWIDTH" align="center">
			<tr>
			<td align="center"><div >
						<a href="#" class="button" title="Click to Save Record" onClick="validate_orderModify();"><span class="save"><bean:message key="label.common.Save"/></span></a>
						<a href="#" class="button" title="Click to Clear Page" onclick="document.forms[0].reset();"><span class="clear"><bean:message key="label.common.Clear"/></span></a>
						<a href="#" class="button" title="Click to Return On Desk" onClick="cancel('LIST');"><span class="back"><bean:message key="label.common.Back"/></span></a>				 
						</div></td>
			</tr>	  
		 </table>
		 </div>
		</div>	
		
		<div class="legends" style="width:95%;">
			<ul>
				<li style='float:none;'><font size="2" color="red">*</font><bean:message key="label.common.Mandatory_Field(s)"/></li> 				
				<li style='float:none;'><div class="circle" style="float:left;margin-right:5px;"></div> <bean:message key="label.common.No_available_quantity_or_expired_drug"/></li>
			</ul>
	    </div>

		<input type="hidden" name="hmode" />
		<input type='hidden' name="strOrderNo" value="${TransferOrderDetailTransBean.strOrderNo }">
		<input type='hidden' name="strDemandNo" value="${TransferOrderDetailTransBean.strDemandNo }">
		<input type='hidden' name="strItemBrandId" value="${TransferOrderDetailTransBean.strItemBrandId }">
		<input type='hidden' name="strTransStoreId" value="${TransferOrderDetailTransBean.strTransStoreId }">
		<input type='hidden' name="strTransRequestNo" value="${TransferOrderDetailTransBean.strTransRequestNo }">
		<input type='hidden' name="strBalanceQtyBaseValue" value="${TransferOrderDetailTransBean.strBalanceQtyBaseValue }">
		<input type='hidden' name="strStoreId" value="${TransferOrderDetailTransBean.strStoreId }">
		<input type='hidden' name="strOrderSlNo" value="${TransferOrderDetailTransBean.strOrderSlNo }">
		<input type="hidden" name="strTmpStoreId"  value="${TransferOrderDetailTransBean.strTmpStoreId}">
		

		<div class='popup' id='itemDtlId' style="display: none">
			<table width='300' border="0" cellspacing="0px" cellpadding="0px">
				<tr class="HEADER">
					<th align='left'><div id="popUpItemId" style='color: white;'><bean:message key="label.common.Excess_qty._Details"/></div></th>
					<th align='right'><img
						style='cursor: pointer; cursor: pointer'
						src='../../hisglobal/images/popUp_cancel.JPG'
						onClick="closeItemPopUp('itemDtlId');"
						title="Click Here To Close Popup"></th>
				</tr>
			</table>
			<table width='300' border="0" cellspacing="1px" cellpadding="1px">
				<tr>
					<td colspan="1" class='multiLabel'>Req. Qty.(A)</td>
					<td colspan="1" class='multiControl'><div id='reqQtyDivId'></div></td>
				</tr>
				<tr>
					<td colspan="1" class='multiLabel'>Total Ordered Qty.(B)</td>
					<td colspan="1" class='multiControl'><div id='ordQtyDivId'></div></td>
				</tr>
				<tr>
					<td colspan="1" class='multiLabel'>Current Ordered Qty.(C)</td>
					<td colspan="1" class='multiControl'><div id='curOrdQtyDivId'></div></td>
				</tr>
				<tr class="FOOTER">
					<td colspan="2"></td>
				</tr>
				<tr>
					<td colspan="1" class='multiLabel'>Balance Qty.(A-B+C)</td>
					<td colspan="1" class='multiControl'><div id='balQtyDivId'></div></td>
				</tr>
				<tr class="FOOTER">
					<td colspan="2"></td>
				</tr>
				
			</table>
		</div>


		<cmbPers:cmbPers />
	</html:form>
	<tag:autoIndex></tag:autoIndex>
</body>
</html>
