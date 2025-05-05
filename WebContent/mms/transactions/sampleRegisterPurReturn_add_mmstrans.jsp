<%@ page language="java" contentType="text/html;"	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<%@ taglib uri="/WEB-INF/hisTab.tld" prefix="tag"%>
<%@taglib uri="/WEB-INF/dateTag.tld" prefix="dateTag"%>
<%@ taglib uri="/WEB-INF/comboPersistence.tld" prefix="cmbPers"%>



<html>
<head>
<meta charset=UTF-8">
<title>Item/Drug Inventory</title>

<link href="../css/transaction.css" rel="stylesheet" type="text/css">
<link href="../../hisglobal/css/tab.css" rel="stylesheet" type="text/css">
<link href="../../hisglobal/css/calendar-tas.css" rel="stylesheet" type="text/css">

<script language="JavaScript" src="../../masterutil/js/master.js"></script>
<script language="JavaScript" src="../../hisglobal/js/tab.js"></script>
<script language="JavaScript" src="../../hisglobal/js/calendar.js"></script>
<script language="JavaScript" src="../../hisglobal/js/util.js"></script>
<script language="JavaScript" src="../../hisglobal/js/validation.js"></script>
<script language="JavaScript" src="../../hisglobal/js/multirow.js"></script>
<script type="text/javascript">

function save(){

 	  var hisValidator = new HISValidator("sampleRegisterPurTransBean");
	  var retVal=false;
	  hisValidator.addValidation("strReturnTo","req","Return To is Mandatory Field" );
   	  hisValidator.addValidation("strRemarks","req","Remarks is Mandatory Field" );
	  hisValidator.addValidation("strRemarks", "maxlen=100", "Remarks should have less than or equal to 100 Characters" );
	  var retVal = hisValidator.validate(); 
	  hisValidator.clearAllValidations();
	  if(retVal){
			document.forms[0].hmode.value="INSERTRETURN";
			document.forms[0].submit();
		}
}

function cancelWindow()
{
	document.forms[0].hmode.value="INITIALPAGE";
	document.forms[0].submit();
}
function clearFun(obj)
{
	document.forms[0].mode.value=obj;
	document.forms[0].hmode.value="CLEAR";
	document.forms[0].submit();
}

</script>

</head>

<body>
<html:form name="sampleRegisterPurTransBean" action="/transactions/SampleRegisterPurTransCNT"
	type="mms.transactions.controller.fb.SampleRegisterPurTransFB">


<div class="errMsg" id="errMsg"><bean:write name="sampleRegisterPurTransBean" property="strErr"/></div>
<div class="warningMsg"><bean:write name="sampleRegisterPurTransBean" property="strWarning"/></div>
<div class="normalMsg" id="normalMsg"><bean:write name="sampleRegisterPurTransBean" property="strMsg"/></div>

<center><tag:tab tabLabel="Sample Register"
		selectedTab="FIRST" align="center" width="TABLEWIDTH">
	</tag:tab></center>
	
	<table class="TABLEWIDTH" align="center" cellspacing="1px" cellpadding="0Px">
		<tr class="HEADER">
			<td colspan="4">Sample Register Return&gt;&gt; Add
				
			</td>
		</tr>
		
		
		<tr>
			<td  width="25%" class="LABEL">Store Name</td>
			<td  width="25%" class="CONTROL" colspan="3">
			<bean:write name="sampleRegisterPurTransBean" property="strStoreName" filter="false"/>
			</td>
			
		</tr>
			<tr>
			<td  width="25%" class="LABEL">Item Category</td>
			<td  width="25%" class="CONTROL">
				<bean:write name="sampleRegisterPurTransBean" property="strItemCategDtl" filter="false"/>
			</td>
			<td  class="LABEL" width="25%">
					Supplier Name
					</td>
					<td  class="CONTROL" width="25%">
						<bean:write name="sampleRegisterPurTransBean" property="strSupplierName" filter="false"/>
								
					</td>
		</tr>
		
		
			<tr>
				<td  width="25%" class="LABEL">Item/Drug Name</td>
				<td  width="25%" class="CONTROL">
					<bean:write name="sampleRegisterPurTransBean" property="strItemName" filter="false"/>
				</td>
				<td  class="LABEL" width="25%">
					Brand Name
					</td>
					<td  class="CONTROL" width="25%">
						<bean:write name="sampleRegisterPurTransBean" property="strItemBrandName" filter="false"/>
								
					</td>
		</tr>
		
		<tr>
				<td  width="25%" class="LABEL">Batch/Sl.No</td>
				<td  width="25%" class="CONTROL">
					<bean:write name="sampleRegisterPurTransBean" property="strBatchSlno" filter="false"/>
				</td>
				<td  class="LABEL" width="25%">
					Received Qty/Unit
					</td>
					<td  class="CONTROL" width="25%">
						<bean:write name="sampleRegisterPurTransBean" property="strRecQty" filter="false"/> &nbsp; <bean:write name="sampleRegisterPurTransBean" property="strRecQtyUnit" filter="false"/>
								
					</td>
		</tr>
		<tr>
				<td  width="25%" class="LABEL">Tender No.</td>
				<td  width="25%" class="CONTROL">
					<bean:write name="sampleRegisterPurTransBean" property="strTenderNo" filter="false"/>
				</td>
				<td  class="LABEL" width="25%">
					Quotation No.
					</td>
					<td  class="CONTROL" width="25%">
						<bean:write name="sampleRegisterPurTransBean" property="strQuotationNo" filter="false"/>
								
					</td>
		</tr>
		
		</table>
		
		<table cellspacing="1px" class="TABLEWIDTH" align="center" cellpadding="0Px">
		<tr>
			<td class="TITLE" colspan="4">
				Return Details
			</td>
		</tr>
		<tr>
			<td  class="LABEL" width="25%">
						Gate Pass No 
			</td>
			<td class="CONTROL" width="25%" >
				<input type="text" name="strGatePassNo" value="" onkeypress="return validateData(event,9);" maxlength="10">
			</td>
			<td  class="LABEL" width="25%">
				<font color="red">*</font>Return To 
			</td>
			<td class="CONTROL" width="25%" >
				<input type="text" name="strReturnTo" value="" onkeypress="return validateData(event,9);" maxlength="50">
			</td>	
		</tr>	
		<tr>
				<td  class="LABEL" width="25%" >
				<font color="red">*</font>Remarks 
				</td>
				<td class="CONTROL" width="25%" colspan="3">
					<textarea rows="2" cols="20" name="strRemarks"></textarea>
				</td>
		</tr>
		</table>
		<table cellspacing="1px" class="TABLEWIDTH" align="center" cellpadding="0Px">
		
		<tr class="FOOTER">
		<td colspan="4" width="25%"><font size="2" color="red">*</font> Mandatory Fields  </td>
		</tr>
	</table>
	<table border="0" class="TABLEWIDTH" align="center">
		<tr>

			<td align="center">
			<img src="../../hisglobal/images/btn-sv.png" title="Click to Save Record"
				onClick="save();" style="cursor: pointer;">
			<img src="../../hisglobal/images/btn-clr.png" title="Click to Clear Page"
				onClick="document.forms[0].reset();" style="cursor: pointer;">
			<img src="../../hisglobal/images/back_tab.png" title="Click to Return On Desk"
				onClick="cancelWindow();" style="cursor: pointer;">
				</td>
		</tr>
	</table>

				
<input type="hidden" name="comboValue" value="${sampleRegisterPurTransBean.strStoreName}"/>
<input type="hidden" name="strStoreId" value="${sampleRegisterPurTransBean.strStoreId}"/>
<input type="hidden" name="strStoreTypeId" value="${sampleRegisterPurTransBean.strStoreTypeId}"/>
<input type="hidden" name="strStoreName" value="${sampleRegisterPurTransBean.strStoreName}"/>
<input type="hidden" name="strGroupName" value="${sampleRegisterPurTransBean.strGroupName}"/>
<input type="hidden" name="strSubGroupName" value="${sampleRegisterPurTransBean.strSubGroupName}"/>
<input type="hidden" name="strChk" value="${sampleRegisterPurTransBean.strChk}"/>	
<input type="hidden" name="strPath" value="${sampleRegisterPurTransBean.strPath}"/>
<input type="hidden" name="chk" value="${sampleRegisterPurTransBean.strChk}"/>	
<input type="hidden" name="hmode"/>
<cmbPers:cmbPers/>
<div id="blanket" style="display:none;"></div>
<div class="popUpDiv" id="popUpDivId" style="display:none;">
<table bgcolor="white">
<tr>
<td>
<div id="itemParameterDtlDivId" style="display:block;"></div>
</td>
</tr>
</table>
</div>

</html:form>
<tag:autoIndex></tag:autoIndex>
</body>
</html>








