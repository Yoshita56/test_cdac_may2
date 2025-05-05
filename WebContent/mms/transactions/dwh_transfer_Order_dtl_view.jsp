<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<%@ taglib uri="/WEB-INF/hisTab.tld" prefix="tag"%>
<%@taglib uri="/WEB-INF/dateTag.tld" prefix="dateTag"%>
<%@ taglib uri="/WEB-INF/comboPersistence.tld" prefix="cmbPers"%>


<html>
<head>
<meta charset=UTF-8">
<title>Item/Drug Transfer Order View</title>

<link href="../css/transaction.css" rel="stylesheet" type="text/css">
<link href="../../hisglobal/css/tab.css" rel="stylesheet"
	type="text/css">
<link href="../../hisglobal/css/calendar-tas.css" rel="stylesheet"
	type="text/css">


<link href="../../hisglobal/css/popup.css" rel="stylesheet"
	type="text/css">
<link href="../../hisglobal/css/newpopup.css" rel="stylesheet"
	type="text/css">
<style type="text/css">

            .pg-normal 
            {
                color: blue;
                font-weight: normal;
                text-decoration: none;
                cursor: pointer;
                
                
            }
            .pg-selected 
            {
                color: red;
                font-weight: bold;
                text-decoration: underline;
                cursor: pointer;
                
            }
            .pg-qualified 
            {
                color: green;
                font-weight: bold;
                text-decoration: underline;
                cursor: pointer;
                
            }
            div.ex
			{
			width:190px;
			padding:8px;
			border:2px solid gray;
			margin:0px;
			}
            
            </style>


<script language="JavaScript" src="../../hisglobal/js/tab.js"></script>
<script language="JavaScript" src="../../hisglobal/js/calendar.js"></script>
<script language="JavaScript" src="../../hisglobal/js/util.js"></script>
<script language="JavaScript" src="../../hisglobal/js/validation.js"></script>
<script language="Javascript" src="../../hisglobal/js/newpopup.js"></script>
<script language="Javascript" src="../../hisglobal/js/popup.js"></script>
<script language="Javascript" src="../../hisglobal/js/multirow.js"></script>
<script language="JavaScript" src="../js/drug_transfer_demand_generation.js"></script>
<script language="JavaScript" src="../js/item_OtherDtls_util.js"></script>

</head>

<body>
<html:form name="transferReqTrans"
	action="/transactions/TransferRequestTransCNT"
	type="mms.transactions.controller.fb.TransferRequestTransFB">


	<div class="errMsg"     id="errMsg"><bean:write    	    name="transferReqTrans" property="strErrMsg" /></div>
	<div class="warningMsg" id="warningMsg"><bean:write	name="transferReqTrans" property="strWarningMsg" /></div>
	<div class="normalMsg"  id="normalMsg"><bean:write   name="transferReqTrans" property="strNormalMsg" /></div>

	<center><tag:tab tabLabel="Item/Drug Transfer"
		selectedTab="FIRST" align="center" width="TABLEWIDTH">
	</tag:tab></center>
    

	<table class="TABLEWIDTH" align="center" border="0" cellpadding="1px"
		cellspacing="1px">
		<tr class="HEADER">
			<td colspan="4">Item/Drug Transfer &gt;&gt; Order &gt;&gt; View</td>
		</tr>

		
	
		<tr>
			<td class="LABEL">Group Name</td>

			<td class="CONTROL" width="25%">
			<bean:write	name="transferReqTrans" property="strGroupNameView" filter="false" />
			</td>


			<td class="LABEL">Sub Group Name</td>

			<td class="CONTROL" width="25%">
			     <bean:write	name="transferReqTrans" property="strSubGroupNameView" filter="false" />
			</td>
		</tr>
		
		<tr>
			<td class="LABEL" width="25%" colspan="1">Item/Drug Name</td>
			<td class="CONTROL" width="75%" colspan="3">
			      <bean:write	name="transferReqTrans" property="strItemNameView" filter="false" />
		  </td>
		</tr>		
		<tr>
			<td class="LABEL" width="25%">Order No.</td>

			<td class="CONTROL" width="25%">
			        <bean:write	name="transferReqTrans" property="strOrderNoView" filter="false" />
			   </td>
			<td class="LABEL" width="25%">Order Date</td>
			<td class="CONTROL" width="25%">
			          <bean:write	name="transferReqTrans" property="strOrderNoDate" filter="false" />
			</td>
		</tr>	
		
		<tr>
			<td class="LABEL" width="25%">Raising Store</td>

			<td class="CONTROL" width="25%">
			        <bean:write	name="transferReqTrans" property="strRaisingDDWView" filter="false" />
			   </td>
			<td class="LABEL" width="25%">Request No.</td>
			<td class="CONTROL" width="25%">
			          <bean:write	name="transferReqTrans" property="strRequestNoView" filter="false" />
			</td>
		</tr>	
		
		<tr>
			<td class="LABEL" width="25%">Transfer Store</td>

			<td class="CONTROL" width="25%">
			        <bean:write	name="transferReqTrans" property="strTransferDDWView" filter="false" />
			   </td>
			<td class="LABEL" width="25%">Transfer Request No.</td>
			<td class="CONTROL" width="25%">
			          <bean:write	name="transferReqTrans" property="strTransferReqNoView" filter="false" />
			</td>
		</tr>	
		
		<tr>
			<td class="LABEL" width="25%">Order Qty.</td>

			<td class="CONTROL" width="25%">
			        <bean:write	name="transferReqTrans" property="strOrderQtyView" filter="false" />
			   </td>
			<td class="LABEL" width="25%">Transfer Qty.</td>
			<td class="CONTROL" width="25%">
			          <bean:write	name="transferReqTrans" property="strTransferQtyView" filter="false" />
			</td>
		</tr>	
		<tr>
			<td class="LABEL" width="25%" colspan="1">Ack Qty.</td>
			<td class="CONTROL" width="75%" colspan="3">
			      <bean:write	name="transferReqTrans" property="strAckQtyWithUnitView" filter="false" />
		  </td>
		</tr>	
		<tr>
			<td class="LABEL" width="25%">Remarks</td>

			<td class="CONTROL" colspan="3">
			        <bean:write	name="transferReqTrans" property="strOrderRemarksView" filter="false" />
			   </td>
			
		</tr>		
		</table>
		
		<bean:write	name="transferReqTrans" property="strTransferDetailsView" filter="false" />
	    
	<table class="TABLEWIDTH" align="center" border="0" cellpadding="1px"
		cellspacing="1px">

		<tr class="FOOTER">
			<td colspan="4" width="25%"></td>
		</tr>
	</table>

	<table class="TABLEWIDTH" align="center" border="0" cellpadding="1px"
		cellspacing="1px">
		<tr>

			<td align="center"><img style="cursor: pointer;"
				src="../../hisglobal/images/back_tab.png" onClick="cancel('CANCELTOLIST');"
				title="Click to Return On Desk" /></td>
		</tr>



	</table>

	<input type="hidden" name="strStoreId"	 value="${transferReqTrans.combo[0]}" />
	<input type="hidden" name="strStoreName" value="${transferReqTrans.strStoreName}" />
	<input type="hidden" name="strReqDate" value="${transferReqTrans.strReqDate}" />

	<input type="hidden" name="strGroupName"	value="${transferReqTrans.strGroupName}" />
	<input type="hidden" name="strCtDate"   	value="${transferReqTrans.strCtDate}">
	<input type="hidden" name="strApprovalFlg"  value="0">
	<input type="hidden" name="strRegFlag" value="" />
	<input type="hidden" name="strPath"   	value="${transferReqTrans.strPath}">
	

	<input type="hidden" name="hmode" />




	<div id="blanket" style="display: none;"></div>
	<div class="popUpDiv" id="otherDtlspopUpDiv" style="display: none;">
	<table bgcolor="white">
		<tr>
			<td>
			<div id="itemsOtherDtlsDivId" style="display: block;"></div>
			</td>
		</tr>
	</table>
	</div>



	<cmbPers:cmbPers />
</html:form>

<jsp:include page="drugInventory_multirow_mmstrans.jsp"></jsp:include>
<tag:autoIndex></tag:autoIndex>
</body>
</html>
