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
<title>Physical Stock Verification</title>
<link href="../css/master.css" rel="stylesheet" type="text/css">
<link href="../../hisglobal/css/tab.css" rel="stylesheet" type="text/css">
<link href="../../hisglobal/css/calendar-tas.css" rel="stylesheet" type="text/css">
<link href="../../hisglobal/css/newpopup.css" rel="stylesheet" type="text/css">	
<link href="../../hisglobal/css/popup.css" rel="stylesheet" type="text/css">		
	
<script language="JavaScript" src="../../hisglobal/masterutil/js/master.js"></script>
<script language="JavaScript" src="../../hisglobal/js/tab.js"></script>
<script language="JavaScript" src="../../hisglobal/js/calendar.js"></script>
<script language="Javascript" src="../../hisglobal/js/validation.js"></script>
<script language="JavaScript" src="../../hisglobal/js/util.js"></script>
<script language="JavaScript" src="../../hisglobal/js/newpopup.js"></script>
<script language="JavaScript" src="../../hisglobal/js/multirow.js"></script>
<script language="Javascript" src="../../hisglobal/js/popup.js"></script>
<script language="JavaScript" src="../js/phyStockVerification_trans.js"></script>
<script type="text/javascript">





</script>
</head>
<body >
<html:form name="physicalStockVerificationBean"
	action="/transactions/PhyStockVerificationTransCNT"
	type="mms.transactions.controller.fb.PhyStockVerificationTransFB">
	
<center>
	<div id="errMsg" class="errMsg"><bean:write name="physicalStockVerificationBean" property="strErrMsg" /></div>
	<div id="warningMsg" class="warningMsg"><bean:write name="physicalStockVerificationBean" property="strWarningMsg" /></div>
	<div id="normalMsg" class="normalMsg"><bean:write name="physicalStockVerificationBean" property="strNormalMsg" /></div>
	
</center>
	
         <tr>
               <td width="TABLEWIDTH"><tag:tab tabLabel="Physical Stock Verification"
				selectedTab="FIRST" align="center" width="TABLEWIDTH">
              </tag:tab></td>
         </tr>
   
   
   <div id="blanket" style="display: none;"></div>

	<div class="popUpDiv" id="newdetailsdivid" style="display: none;">
	<table bgcolor="white">
		<tr>
			<td>
			<div class='popup' id='newdetailsdividInner' style="display: block">
  			
			<table width="500" align="center" cellspacing="1px" cellpadding="1px">
			<tr class="HEADER">
				<td  colspan="4" >
						Counted Details
				</td>
			</tr>
			
			<tr>
			<td width="50%" colspan="2" class="LABEL">
				Item Name
			</td>
			<td width="50%" colspan="2" class="CONTROL">
				<div id="itemNameId"></div>
			</td>
			</tr>
			
			
			</table>
			
			<div id="countedDtlID">
			</div>
			<div id="id1">
			</div>
			<table width="500" align="center" cellspacing="1px" cellpadding="1px">
			<tr>
				<td  colspan="4" class="TITLE">
						New Details
				</td>
			</tr>
			
			<tr>
			<td width="50%" colspan="2" class="LABEL"><font size="1" color="red">*</font>
			Brand Name
			</td>
			<td width="50%" colspan="2" class="CONTROL">
			<div id="brandDivId"><select name="strItemBrandId" class="comboNormal">
			<option value="0">Select Value</option>
			</select>
			</div>
			</td>
			
		</tr>
			
			<tr>
			<td width="50%" colspan="2" class="LABEL"><font size="1" color="red">*</font>
				Batch/SlNo.
			</td>
			<td width="50%" colspan="2" class="CONTROL">
				<input type="text" class="txtFldNormal" name="strBatchSerialNo" maxlength="30" onkeypress="return validateData(event,5);" >
		
		</tr>
		<tr>
			<td width="50%" colspan="2" class="LABEL"><font size="1" color="red">*</font>
				Counted Qty
			</td>
			<td width="50%" colspan="2" class="CONTROL">
				<input type="text" class="txtFldNormal" name="strCountedQuantity" maxlength="7" onkeypress="return validateData(event,7);" >
		
		</tr>
		<tr>
			<td width="50%" colspan="2" class="LABEL"><font size="1" color="red">*</font>
			Unit Name
			</td>
			<td width="50%" colspan="2" class="CONTROL">
			<div id="unitDivID"><select name="strUnitId" class="comboNormal">
			<option value="0">Select Value</option>
			</select>
			</div>
			</td>
			
		</tr>
		
		<tr class="FOOTER">
			<td width="50%" colspan="4" ><font style="color: red" size="2">*</font> Mandatory Fields
			</td>
			
		
		</tr>
		
		<tr>

			<td align="center" colspan="4">
			<img style="cursor: pointer; " src="../../hisglobal/images/btn-add.png" onClick="addNewDtl();" />
			<img style="cursor: pointer; " src="../../hisglobal/images/btn-sv.png" onClick="onSave();" />
			<img  style="cursor: pointer; " src="../../hisglobal/images/btn-ccl.png" onClick="cancelButton();" >
		</td>
		
		</tr>
		
		   </table>
		   </div>
		   </td>
		   </tr>
		   </table>
		   </div>
	
		
			


	<table class="TABLEWIDTH" align="center" cellpadding="1" cellspacing="1">   
	<tr class="HEADER">
			<td colspan="4"></td>
		</tr>
		<tr>
			<td width="50%" colspan="2" class="LABEL">
				Store Name
			</td>
			<td width="50%" colspan="2" class="CONTROL">
				<bean:write name="physicalStockVerificationBean" property="strStoreName" filter="false" />
		
		</tr>
		<tr>
			<td width="50%" colspan="2" class="LABEL">
				Physical Inventory Name
			</td>
			<td width="50%" colspan="2" class="CONTROL">
				<input type="text" class="txtFldMax" name="strPhyInventoryId" onkeypress="return validateData(event,4);">
		
		</tr>
		<tr>
			<td width="50%" colspan="2" class="LABEL"><font size="1" color="red">*</font>
			Group Name
			</td>
			<td width="50%" colspan="2" class="CONTROL">
			<select name="strGroupId" onchange="fetchPatientList('1','1');" >
			<bean:write name="physicalStockVerificationBean" property="strGroupList" filter="false"/>
			
			</select>
			</td>
			
		</tr>
		
		
		</table>
	
	
			<table class="TABLEWIDTH" align="center" cellspacing="1px" cellpadding="1px">
			<tr>
				<td  colspan="4" class="TITLE">
						Item Details
				</td>
			</tr>
		</table>
		
			<div id="itemDetailsId">
			
			</div>
			
			
						
			
			<table class="TABLEWIDTH" align="center" cellpadding="1px" cellspacing="1px">
		
			
		<tr class="FOOTER">
			 <td colspan="4"><font size="2" color="red">*</font> Mandatory Fields  </td>
		</tr>
	
		<tr>

			<td align="center" colspan="4">
			<img style="cursor: pointer; " src="../../hisglobal/images/btn-sv.png" onClick="return validate1();" />
			<img  style="cursor: pointer; " src="../../hisglobal/images/back_tab.png" onClick="cancelPage();" >
		</td>
		</tr>
	</table>
	
<input type="hidden" name="hmode"/>

<input type="hidden" name="strUnitValId" />
<input type="hidden" name="strItemValId" />

<input type="hidden" name="strCurrentCountDtl"  value="0"/>

<cmbPers:cmbPers />


</html:form>

<jsp:include page="phyStockVerification_multirow_trans.jsp"></jsp:include>
	<tag:autoIndex></tag:autoIndex>   
</body>
</html>