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
<title>Item/Drug Transfer Request</title>

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
<script language="JavaScript" src="../js/drug_transfer_demand_request.js"></script>
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
			<td colspan="4">Item/Drug Transfer &gt;&gt; Request &gt;&gt;  View</td>
		</tr>

		<tr>
			<td width="25%" class="LABEL">Store Name</td>
			<td width="25%" class="CONTROL">
			     <bean:write	name="transferReqTrans" property="strStoreNameView" filter="false" />
			</td>
			<td width="25%" class="LABEL">Request Date</td>
			<td width="25%" class="CONTROL">
			     <bean:write	name="transferReqTrans" property="strRequestDateView" filter="false" />
			</td>

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
			<td class="LABEL" width="25%">Approved By</td>

			<td class="CONTROL" width="25%">
			        <bean:write	name="transferReqTrans" property="strApprovedByView" filter="false" />
			   </td>
			<td class="LABEL" width="25%">Approved Date</td>
			<td class="CONTROL" width="25%">
			          <bean:write	name="transferReqTrans" property="strApprovedDateView" filter="false" />
			</td>
		</tr>	
		
		<tr>
			
           
			<td class="LABEL" width="25%">Status</td>
			<td class="CONTROL" width="25%">				
						<bean:write	name="transferReqTrans" property="strApprovedStatusView" filter="false" />
			</td>
			<td class="CONTROL" width="25%"></td>
                    
			<td class="CONTROL" width="25%"></td>
		</tr>	
		
		<tr>
			<td class="LABEL" width="25%">Demanded Qty.</td>

			<td class="CONTROL" width="25%">
			        <bean:write	name="transferReqTrans" property="strReqQtyWithUnitView" filter="false" />
			   </td>
			<td class="LABEL" width="25%">Approved Qty.</td>
			<td class="CONTROL" width="25%">
			          <bean:write	name="transferReqTrans" property="strApprovedQtyWithUnitView" filter="false" />
			</td>
		</tr>	
		
		<tr>
			<td class="LABEL" width="25%">Transfer Qty.</td>

			<td class="CONTROL" width="25%">
			        <bean:write	name="transferReqTrans" property="strRaisingAvlQtyWithUnitView" filter="false" />
			   </td>
			<td class="LABEL" width="25%">Acknowledge Qty.</td>
			<td class="CONTROL" width="25%">
			          <bean:write	name="transferReqTrans" property="strAckQtyWithUnitView" filter="false" />
			</td>
		</tr>	
		</table>
		<table class="TABLEWIDTH" align="center" cellpadding="1px"	cellspacing="1px">
		<tr>
			<td class="TITLE" colspan="5">
			<div id="divPOScheduleDetailsPlusID" style="display: none;"
				align="left"><img src="../../hisglobal/images/plus.gif"
				onclick="showDiv('divPOScheduleDetailsMinusID'),hideDiv('divPOScheduleDetailsPlusID'),showDiv('divTransferOrderDetails');"
				style="cursor: pointer;"> Order Detail(s)</div>
			<div id="divPOScheduleDetailsMinusID" style="display: block;"
				align="left"><img src="../../hisglobal/images/minus.gif"
				onclick="hideDiv('divPOScheduleDetailsMinusID'),hideDiv('divTransferOrderDetails'),showDiv('divPOScheduleDetailsPlusID');"
				style="cursor: pointer;"> Order Detail(s)</div>
			</td>
		 </tr>
	   </table>
	    <div id=divTransferOrderDetails>
	      <bean:write name="transferReqTrans" property="strTransferOrderDetails" filter="false"></bean:write>
	   </div>
	  <div id=divTransferDetailsId style="display:none;"> 
		   <table class="TABLEWIDTH" align="center" cellpadding="1px"	cellspacing="1px">
			<tr>
				<td class="TITLE" colspan="5">
				Transfer Detail(s)
				</td>
			</tr>
		 </table>
		 <div id=divTransferDetails></div>
	 </div>
		<div id="" style="display:none;">
	 <table class="TABLEWIDTH" align="center" cellpadding="1px"	cellspacing="1px">			
		 <tr>
				<td class="TITLE" colspan="5">
				Approval Detail(s)
				</td>
			</tr>
		
		<tr>
			<td class="LABEL" width="25%">Approved By</td>

			<td class="CONTROL" width="25%">
			        <bean:write	name="transferReqTrans" property="strOrderBySeatIdView" filter="false" />
			   </td>
			<td class="LABEL" width="25%">Approved Date</td>
			<td class="CONTROL" width="25%">
			          <bean:write	name="transferReqTrans" property="strOrderByDateView" filter="false" />
			</td>
		</tr>	
		
		<tr>
			<td class="LABEL" width="25%">Remarks</td>

			<td class="CONTROL" colspan="3">
			        <bean:write	name="transferReqTrans" property="strOrderRemarksView" filter="false" />
			   </td>
			
		</tr>	
	<!--  	
		<tr >
		    <td width ="50%" class ="LABEL" valign="middle" colspan="2">Remarks(if Any)</td>
		    <td width ="50%" class ="CONTROL" colspan="2"> <bean:write	name="transferReqTrans" property="strOrderRemarksView" filter="false" /></td>
		  </tr>
		  -->
	</table>
	</div>

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
	<input type="hidden" name="strPath"   	value="${transferReqTrans.strPath}">
	<input type="hidden" name="strApprovalFlg"  value="0">
	<input type="hidden" name="strRegFlag" value="" />

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
