<%@ page language="java" contentType="text/html;"	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<%@taglib uri="/WEB-INF/dateTag.tld" prefix="date"%>
<%@ taglib uri="/WEB-INF/hisTab.tld" prefix="tag"%>
<%@ taglib uri="/WEB-INF/comboPersistence.tld" prefix="cmbPers"%>
 <!--  
 * Developer : Deepak Tewari
 * Version : 1.0 
 * Date : 23/Jan/2009
 * Module:MMS
 * Unit:Supplier Return Request Details   
 -->
 
<html>
<head>
<meta charset=UTF-8">
<title>Supplier Return Sanction Details</title>
<link href="../css/master.css" rel="stylesheet" type="text/css">
<link href="../../hisglobal/css/tab.css" rel="stylesheet" type="text/css">
<link href="../../hisglobal/css/calendar-tas.css" rel="stylesheet" type="text/css">

<link href="../../hisglobal/css/popup.css" rel="stylesheet" type="text/css">	
<link href="../../hisglobal/css/newpopup.css" rel="stylesheet" type="text/css">	
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
<script language="JavaScript" src="../../hisglobal/masterutil/js/master.js"></script>
<script language="JavaScript" src="../../hisglobal/js/tab.js"></script>
<script language="JavaScript" src="../../hisglobal/js/calendar.js"></script>
<script language="Javascript" src="../../hisglobal/js/validation.js"></script>
<script language="Javascript" src="../../hisglobal/js/util.js"></script>
<script language="Javascript" src="../../hisglobal/js/popup.js"></script>
<script language="Javascript" src="../../hisglobal/js/newpopup.js"></script>
<script language="Javascript" src="../../hisglobal/js/multirow.js"></script>
<script language="Javascript" src="../../mms/js/supplier_return_req.js"></script>
<script language="JavaScript" src="../js/searchItems_util.js"></script>
<script language="Javascript" src="../js/issueDetails_util.js"></script>
<script language="Javascript" src="../js/stockDetails_util.js"></script>
<script language="JavaScript" src="../js/mms.js"></script>
<script language="javaScript">

</script>

</head>
<body> 
<html:form name="supplierReturnDeskTransBean" action="transactions/SupplierReturnDeskCNT"
	type="mms.transactions.controller.fb.SupplierReturnDeskFB">
	
<center>
	<div id="errMsg" class="errMsg"><bean:write name="supplierReturnDeskTransBean" property="strErrMsg" /></div>
	<div id="warningMsg" class="warningMsg"><bean:write name="supplierReturnDeskTransBean" property="strWarningMsg"/></div>
	<div id="normalMsg" class="normalMsg"><bean:write name="supplierReturnDeskTransBean" property="strNormalMsg"/></div>
</center>
	
<center>
    <tag:tab tabLabel="Supplier Return" selectedTab="FIRST" align="center" width="TABLEWIDTH"></tag:tab>
</center>

	<table class="TABLEWIDTH" align="center" cellpadding="1" cellspacing="1">   
	    <tr class="HEADER">
			<td colspan="4">Return To Supplier &gt;&gt; Return Details</td>
		</tr>
		<tr>
			<td width="25%" colspan="1" class="LABEL">
				Store Name
			</td>
			<td width="25%" colspan="1" class="CONTROL">
				<bean:write name="supplierReturnDeskTransBean" property="strStoreName" filter="false" />
			</td>
		
			<td width="25%" colspan="1" class="LABEL">Item Category</td>
			<td width="25%" colspan="1" class="CONTROL">
			 <bean:write name="supplierReturnDeskTransBean" property="strItemCategoryNameH" filter="false" />
			</td>
		</tr>
		
		<tr>
			<td width="25%" colspan="1" class="LABEL">Req No.</td>
			<td width="25%" colspan="1" class="CONTROL">
			  <font color="blue"><bean:write name="supplierReturnDeskTransBean" property="strReqNo" filter="false" /></font>
			</td>
			<td width="25%" colspan="1" class="LABEL">
				Req Date
			</td>
			<td width="25%" colspan="1" class="CONTROL">
				<bean:write name="supplierReturnDeskTransBean" property="strReqDate" filter="false" />
			</td>
		</tr>
		
		<tr>
			<td width="25%" colspan="1" class="LABEL">
				Return Type
			</td>
			<td width="25%" colspan="1" class="CONTROL">
				<bean:write name="supplierReturnDeskTransBean" property="strReturnTypeName" filter="false" />
			</td>
		
			<td width="25%" colspan="1" class="LABEL">Return Reason</td>
			<td width="25%" colspan="1" class="CONTROL">
			  <bean:write name="supplierReturnDeskTransBean" property="strReturnReason" filter="false" />
			</td>
		</tr>
	</table>
	
  <div id="PODetailsDIV">	
	<table class="TABLEWIDTH" align="center" cellpadding="1px" cellspacing="1px">   
		<tr class="TITLE">
			<td colspan="4">PO Details
			</td>
		</tr>
		<tr>
			<td width="25%" colspan="1" class="LABEL">
				PO No.
			</td>
			<td width="25%" colspan="1" class="CONTROL">
				<bean:write name="supplierReturnDeskTransBean" property="strPONo" />
			</td>
			<td width="25%" colspan="1" class="LABEL">PO Store Name</td>
			<td width="25%" colspan="1" class="CONTROL">
			  <bean:write name="supplierReturnDeskTransBean" property="strPOStoreName" filter="false" />
			</td>
	   </tr>
		<tr>
			<td width="25%" colspan="1" class="LABEL">
				PO Date
			</td>
			<td width="25%" colspan="1" class="CONTROL">
				<bean:write name="supplierReturnDeskTransBean" property="strPODate" />
			</td>
			<td width="25%" colspan="1" class="LABEL">PO Type</td>
			<td width="25%" colspan="1" class="CONTROL">
			  <bean:write name="supplierReturnDeskTransBean" property="strPOType"  />
			</td>
	   </tr>
	   <tr>
	   
	       <td width="25%" colspan="1" class="LABEL">
				Supplier Name
			</td>
			<td width="55%" colspan="3" class="CONTROL">
				<bean:write name="supplierReturnDeskTransBean" property="strSupplierName" filter="false" />
			</td>
			
	   </tr>
     </table>
 
	<table class="TABLEWIDTH" align="center" cellpadding="1" cellspacing="1">   
		<tr class="TITLE">
			<td colspan="4">Item/Drug Details
			</td>
		</tr>
		<tr>
			<td width="50%" class="LABEL" ><font size="1" color="red">*</font>
			Group Name
			</td>
			<td width="50%" class="CONTROL" >
			
			      <bean:write name="supplierReturnDeskTransBean" property="strGroupName" filter="false" />
			 
			</td>
	   </tr>
     </table>
 
	<table class="TABLEWIDTH" align="center" cellpadding="1px" cellspacing="1px" bgcolor="black">
			<tr>
			<td width="15%" class="multiLabel">Item/Drug Name
			</td>
			<td width="15%" class="multiLabel">Batch/Serial No.
			</td>
			<td width="15%" class="multiLabel">Rate/Unit
			</td>
			<td width="15%" class="multiLabel">Avl. Qty
			</td>
			<td width="15%" class="multiLabel"><font size="1" color="red">*</font>Req. Qty
			</td>
			<td width="15%" class="multiLabel"><font size="1" color="red">*</font>Sanc. Qty
			</td>
			<td width="10%" class="multiLabel">Cost
			</td>
			</tr>
	</table>
 		
	<div id="id1"><bean:write name="supplierReturnDeskTransBean" property="strItemDtls" filter="false" /></div>
	
	<table class="TABLEWIDTH" align="center" cellpadding="1" cellspacing="1">   
		<tr class="TITLE">
			<td colspan="4">Approval Details</td>
		</tr>
		
	</table>
	
	<div id="approvalDtlsDIV"><bean:write name="supplierReturnDeskTransBean" property="strApprovalDetails" filter="false" /></div>
		  
    <table class="TABLEWIDTH" align="center" cellpadding="1" cellspacing="1"> 
	 <tr>
		    <td  class="LABEL" width="50%" >Remarks</td>
		     <td  class="CONTROL" width="50%" >
		           <textarea name="strRemarks" rows="2" cols="11" readonly><bean:write name="supplierReturnDeskTransBean" property="strRemarks" filter="false" /></textarea>
		     </td>
	  </tr>	
	</table>   
	
  </div>
  
	
<table border="0" class="TABLEWIDTH" align="center" cellpadding="1px" cellspacing="1px">
	    <tr class="FOOTER">
			 <td colspan="4"><font size="2" color="red">*</font> Mandatory Fields  </td>
		</tr>
		<tr>
			<td align="center">
			<img  style="cursor: pointer; " src="../../hisglobal/images/btn-ccl.png" onClick="cancelView();" >
		</td>
		</tr>
	</table>
<input type="hidden" name="hmode"/>
<input type="hidden" name="mode"/>  

<input type="hidden" name="strStoreName" value="${supplierReturnDeskTransBean.strStoreName}"/>
<input type="hidden" name="strReqDate" value="${supplierReturnDeskTransBean.strReqDate}"/>
<input type="hidden" name="strReturnTypeName" value="${supplierReturnDeskTransBean.strReturnTypeName}"/>
<input type="hidden" name="strReturnReason" value="${supplierReturnDeskTransBean.strReturnReason}"/>

<input type="hidden" name="strCurrentDate" value="${supplierReturnDeskTransBean.strCurrentDate}"/>
<input type="hidden" name="strSupplierId" value="${supplierReturnDeskTransBean.strSupplierId}"/>
<input type="hidden" name="strPONo" value="${supplierReturnDeskTransBean.strPONo}"/>
<input type="hidden" name="strPODate" value="${supplierReturnDeskTransBean.strPODate}"/>
<input type="hidden" name="strPOStoreId" value="${supplierReturnDeskTransBean.strPOStoreId}"/>
<input type="hidden" name="strReqNo" value="${supplierReturnDeskTransBean.strReqNo}" />
<input type="hidden" name="strStoreId" value="${supplierReturnDeskTransBean.strStoreId}" />
<input type="hidden" name="strItemCategoryNoH" value="${supplierReturnDeskTransBean.strItemCategoryNoH}" />
<input type="hidden" name="strItemCategoryNameH" value="${supplierReturnDeskTransBean.strItemCategoryNameH}" />
<input type="hidden" name="comboValue" value="${supplierReturnDeskTransBean.strStoreName}">

<cmbPers:cmbPers />
</html:form>
<tag:autoIndex></tag:autoIndex>
</body>
</html>