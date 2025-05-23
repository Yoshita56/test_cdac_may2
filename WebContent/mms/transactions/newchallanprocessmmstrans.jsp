<%@ page language="java" contentType="text/html;"	%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">


<!--  Developer : Balasubramaniam M
	  Version	: 1.0	 
	  Date 		: 12-Jun-2009
	  Module 	: Mms
	  Process	: Challan Process
-->

<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic"%>
<%@ taglib uri="/WEB-INF/hisTab.tld" prefix="tag"%>
<%@taglib uri="/WEB-INF/dateTag.tld" prefix="dateTag"%>
<%@ taglib uri="/WEB-INF/comboPersistence.tld" prefix="cmbPers"%>



<html>
<head>
<meta charset=UTF-8">
<title>Challan Process</title>

<link href="../css/transaction.css" rel="stylesheet" type="text/css">
<link href="../../hisglobal/css/tab.css" rel="stylesheet"	type="text/css">
<link href="../../hisglobal/css/calendar-tas.css" rel="stylesheet"	type="text/css">
<link href="../../hisglobal/css/popup.css" rel="stylesheet" type="text/css">	
<link href="../../hisglobal/css/newpopup.css" rel="stylesheet" type="text/css">	
<link href="../../hisglobal/css/buttons.css" rel="stylesheet" type="text/css">

<script language="JavaScript" src="../../hisglobal/js/calendar.js"></script>
<script language="JavaScript" src="../../hisglobal/js/util.js"></script>
<script language="JavaScript" src="../../hisglobal/js/validation.js"></script>
<script language="JavaScript" src="../../hisglobal/js/multiRowTLD.js"></script>
<script language="JavaScript" src="../../hisglobal/js/multirow.js"></script>
<script language="Javascript" src="../../hisglobal/js/newpopup.js"></script>
<script language="Javascript" src="../../hisglobal/js/popup.js"></script>
<script language="Javascript" src="../js/mms.js"></script>
<script language="Javascript" src="../js/newchallanprocess_mmstrans.js"></script>
<script type="text/javascript">



/**
	  This function is used to set condition during change of name of reciever.
**/
function checkValCombo()
{
		var recievedByName=document.forms[0].strReceivedComboBy[document.forms[0].strReceivedComboBy.selectedIndex].text;
		if(document.forms[0].strReceivedComboBy[document.forms[0].strReceivedComboBy.selectedIndex].text=='Other')
		{
			
			document.getElementById("labelId").className="LABEL";
			document.getElementById("labelNameId").innerHTML="";
			document.getElementById("nameOtherFld").style.display="block";
			if(document.forms[0].strReceivedBy.readOnly)
				document.forms[0].strReceivedBy.readOnly=false;
			document.forms[0].strReceivedBy.value="";
			document.getElementById("labelNameId").innerHTML="<font color='red'>*</font>Name of the Receiver";
			document.forms[0].strReceivedBy.focus();
			
		
		}
		else 
		if(document.forms[0].strReceivedComboBy.value!="0" && document.forms[0].strReceivedComboBy.value!="1")
		{
			
			document.getElementById("labelId").className="LABEL";
			
			document.getElementById("labelNameId").innerHTML="";
			document.getElementById("nameOtherFld").style.display="block";
			document.getElementById("labelNameId").innerHTML="Name of the Receiver";
			document.forms[0].strReceivedBy.value=recievedByName;
			if(!document.forms[0].strReceivedBy.readOnly)
				document.forms[0].strReceivedBy.readOnly=true;
			document.getElementsByName("strRemarks")[0].focus();
			
			
			
		}else{
			document.getElementById("labelId").className="CONTROL";
			document.getElementById("nameOtherFld").style.display="none";
			document.getElementById("labelNameId").innerHTML="";
			document.forms[0].strOtherDeliveryModeFlg.value = '0';
		}
}

function checkValComboTwo()
{
		var recievedByName = document.forms[0].strDeliveryMode[document.forms[0].strDeliveryMode.selectedIndex].text;
		
		if(document.forms[0].strDeliveryMode[document.forms[0].strDeliveryMode.selectedIndex].text=='Other' )
		{
			document.getElementById("labelIdOne").className="LABEL";
			document.getElementById("labelNameIdOne").innerHTML="";
			document.getElementById("nameOtherFldOne").style.display="block";
			if(document.forms[0].strDeliveryModeText.readOnly)
				document.forms[0].strDeliveryModeText.readOnly=false;
			document.forms[0].strDeliveryModeText.value="";
			document.getElementById("labelNameIdOne").innerHTML="<font color='red'>*</font>Delivery Mode Type";
			document.forms[0].strDeliveryModeText.focus();
			document.forms[0].strOtherDeliveryModeTxtValue.value = document.forms[0].strDeliveryModeText.value;
			document.forms[0].strOtherDeliveryModeFlg.value = '1';  // Means Other Value Selected
		
		}else if(document.forms[0].strDeliveryMode.value!="0" && document.forms[0].strDeliveryMode.value!="1"){
			
			document.getElementById("labelIdOne").className="LABEL";
			
			document.getElementById("labelNameIdOne").innerHTML="";
			document.getElementById("nameOtherFldOne").style.display="block";
			document.getElementById("labelNameIdOne").innerHTML="Delivery Mode Type";
			document.forms[0].strDeliveryModeText.value=recievedByName;
			if(!document.forms[0].strDeliveryModeText.readOnly)
				//document.forms[0].strDeliveryModeText.readOnly=true;
			//document.getElementsByName("strRemarks")[0].focus();
			document.forms[0].strOtherDeliveryModeFlg.value = '1';   // Means Value Same As  Selected in Combo
			document.forms[0].strOtherDeliveryModeTxtValue.value = document.forms[0].strDeliveryMode[document.forms[0].strDeliveryMode.selectedIndex].text;
			
			
		}else{
			document.getElementById("labelIdOne").className="CONTROL";
			document.getElementById("nameOtherFld").style.display="none";
			document.getElementById("labelNameIdOne").innerHTML="";
			document.forms[0].strOtherDeliveryModeFlg.value = '0';
		}
}






</script>

</head>

<body onload="getScheduleDetails();">
<html:form name="newchallanProcessBean"
	action="/transactions/NewChallanProcessTransCNT"
	type="mms.transactions.controller.fb.NewChallanProcessTransFB">
	
	
	<div id="blanket" style="display: none;"></div>
	
	<div class="popup" id="itemDtlsDivId" style="display: none">
	<table width='500' cellpadding="0" cellspacing="0">
		<tr class='HEADER'>
			<td colspan='6' align="left">
			<div id='itemDtlsTitleDivId' style='color:black;'></div>
			</td>
			<td   align="right"><img
				src="../../hisglobal/images/popUp_cancel.JPG"
				style=" cursor: pointer" align="middle"
				onclick="hide_popup_menu('itemDtlsDivId');"></td>
		</tr>
	</table>
	<table width='500' cellpadding="1px" cellspacing="1px">
		<tr>
			<td width="50%" class="multiRPTLabel">Manufacture</td>
			<td width="50%" class="multiPOControl">
			<div id='itemManufDivId'></div>
			</td>
		</tr>
		<tr>
			<td width="50%" class="multiRPTLabel">Rate/Unit</td>
			<td width="50%" class="multiPOControl">
			<div id='itemRateDivId'></div>
			</td>
		</tr>
	</table>
	<table width='500' cellpadding="0" cellspacing="0">
		<tr class="FOOTER">
			<td></td>
		</tr>
	</table>
	</div>

	<div class="popup" id="balQtyDtlsDivId" style="display: none">
	<table width='500' cellpadding="0" cellspacing="0">
		<tr class='HEADER'>
			<td colspan='2' align="left">
			<div id='balQtyTitleDivId' style='color:black;'></div>
			</td>
			<td align="right"><img
				src="../../hisglobal/images/popUp_cancel.JPG"
				style=" cursor: pointer" align="middle"
				onclick="hide_popup_menu('balQtyDtlsDivId');"></td>
		</tr>
	</table>
	<table width='500' cellpadding="1px" cellspacing="1px">
		<tr>
			<td width="50%" class="multiRPTLabel">Ordered Qty.</td>
			<td width="50%" class="multiPOControl">
			<div id='ordQtyDivId'></div>
			</td>
		</tr>
		<tr>
			<td width="50%" class="multiRPTLabel">Received Qty.</td>
			<td width="50%" class="multiPOControl">
			<div id='recQtyDivId'></div>
			</td>
		</tr>
	</table>
	<table width='500' cellpadding="0" cellspacing="0">
		<tr class="FOOTER">
			<td></td>
		</tr>
	</table>
	</div>

	<div class="errMsg" id="errMsg"><bean:write
		name="newchallanProcessBean" property="strErr" /></div>
	<div class="warningMsg" id="warningMsg"><bean:write
		name="newchallanProcessBean" property="strWarning" /></div>
	<div class="normalMsg" id="normalMsg"><bean:write
		name="newchallanProcessBean" property="strMsg" /></div>

	<center><tag:tab tabLabel="Challan Process "
		selectedTab="FIRST" align="center" width="TABLEWIDTH">
	</tag:tab></center>


	<table class="TABLEWIDTH" align="center" border="0" cellpadding="1px"
		cellspacing="1px">
		<tr class="HEADER">
			<td colspan="6">Challan Process </td>
		</tr>


		<tr>
			<td width="25%" class="LABEL">Store Name</td>
			<td width="25%" class="CONTROL"><bean:write
				name="newchallanProcessBean" property="strStoreName" /></td>
			<td width="25%" class="LABEL">Item Category</td>
			<td width="25%" class="CONTROL"><bean:write
				name="newchallanProcessBean" property="strItemCategoryName" /></td>
		</tr>


		<tr>
			<td class="LABEL" width="25%">P.O. No.</td>
			<td class="CONTROL" width="25%"><bean:write
				name="newchallanProcessBean" property="strPoNoDisplay" /></td>
				

			<td class="LABEL" width="25%">P.O. Date</td>
			<td class="CONTROL" width="25%"><bean:write
				name="newchallanProcessBean" property="strPoDate" /></td>
		</tr>


		<tr>
		
		<td class="LABEL" width="25%">P.O. Type</td>
			<td class="CONTROL" width="25%"><bean:write
				name="newchallanProcessBean" property="strPoType" /></td>
				
			<td class="LABEL">Supplier Name</td>
			<td width="25%" class="CONTROL"><bean:write
				name="newchallanProcessBean" property="strSupplierName" /></td>
				
			
		</tr>

   
		
		
		</table>
      
	    <div id="scheduleDtlsDivId" style="display:none;" ></div>
	    

	    <table class="TABLEWIDTH" align="center" border="0" cellpadding="1px" cellspacing="1px" style="display: none;" id="remarksid">
	    <tr class="HEADER">
			<td width='100%' colspan='6'>Challan Details</td>
		</tr>
	    
	     <tr>
			


			<td class="LABEL" width='25%'><font color="red">*</font>Received Date</td>
			<td width="25%" class="CONTROL">
			   <div id='dateVal'></div><div id='calDate'><dateTag:date	name="strReceiveDate"  value="${newchallanProcessBean.strCtDate}"></dateTag:date></div>
			</td>				
			
			 <td width="25%" class="LABEL"> <font color="red">*</font>Received By</td>
            <td class="CONTROL" width="25%">
              
               <select name="strReceivedComboBy" class="comboMax" onchange="checkValCombo(this);">
               	<bean:write name="newchallanProcessBean" property="strReceivedByOptionVal" filter="false"/>
               </select>
               
            </td>

		</tr>
		<tr>
			<td class="LABEL" width="25%"><font color="red">*</font>Challan No.</td>
			<td class="CONTROL" width="25%"><input type="text" autocomplete='off' size="25"
				name="strSupplierReceiptNo" maxlength="20" class="txtFldNormal"
				onkeypress="return validateData(event,18);"></td>


			<td class="LABEL" width='25%'><font color="red">*</font>Challan Date</td>
			<td width="25%" class="CONTROL">
			  <div id='supplierRecDate'></div>  <div id='recpCalender'><dateTag:date 	name="strSupplierReceiptDate"	value="${newchallanProcessBean.strCtDate}"></dateTag:date></div>
			  </td>
		 
           
        </tr> 
        
        <tr>
			<td class="LABEL" width="25%">Invoice No.</td>
			<td class="CONTROL" width="25%"><input type="text" autocomplete='off' size="25"
				name="strSupplierInvNo" maxlength="20" class="txtFldNormal"
				onkeypress="return validateData(event,18);"></td>


			<td class="LABEL" width='25%'>Invoice Date</td>
			<td width="25%" class="CONTROL">
			  <div id='supplierRecDate'></div>  <div id='recpCalender'><dateTag:date 	name="strSupplierInvDate"	value="${newchallanProcessBean.strCtDate}"></dateTag:date></div>
			  </td>
		 
           
            </tr> 
	
		  <tr>
            <td class="CONTROL" width="25%" id='labelId'>
            	<div id='labelNameId'></div>
            </td>
            <td class="CONTROL" width="25%">
            	<div id="nameOtherFld" style="display: none">
            		<input type='text' name='strReceivedBy' autocomplete='off' value=''  maxlength='50'>
            		<!-- <input type='text' name='strReceivedBy' value='' onkeypress='return validateData(event,11);' maxlength='50'>  Orignal Code -->
            	</div>
            </td>
          </tr>	  
          <tr> 
          <td width="25%"  class="LABEL">Rack No.</td>
            <td class="CONTROL" width='25%' >
            <input type='text'  name="strRackNo" value='' onkeypress='return validateData(event,8);' maxlength='10'> </td>
          
            <td width="25%"  class="LABEL">Remarks</td>
            <td class="CONTROL" width='25%'>
            <textarea name="strRemarks" cols="20" rows="2" id="strRemarks" ></textarea> </td>
          </tr>
          <logic:equal name="newchallanProcessBean" property="strPoTypeId" value="21" >
           <tr> 
          <td width="25%"  class="LABEL"><font color="red">Whether you want to keep The PO Active</font></td>
            <td class="CONTROL" width='25%' >
            <input type='checkbox'  name="strchkbox" id="strchkbox" value="0"  onclick="setvalue()"> </td></tr></logic:equal>
	</table>

	<table class="TABLEWIDTH" align="center" border="0" cellpadding="1px"
		cellspacing="1px">

		<tr class="FOOTER">
			<td colspan="6" width="25%"><font size="2" color="red">*</font>
			Mandatory Fields 
			</td>
		</tr>
	</table>

	<table class="TABLEWIDTH" align="center" border="0" cellpadding="1px"
		cellspacing="1px">
		<tr>

			<td align="center"><!-- <img style="cursor: pointer; "
				src="../../hisglobal/images/btn-sv.png"
				onClick="return validationRec();" /> <img
				style="cursor: pointer; "
				src="../../hisglobal/images/btn-clr.png"
				onClick="pageReset();" /> <img
				style="cursor: pointer; "
				src="../../hisglobal/images/back_tab.png"
				onClick="cancelPage('LIST');" />
				 -->
				<br>
				<a href="#" class="button" id="" onclick=' return validationRec();'><span class="save">Save</span></a>
				<a href="#" class="button"	onclick="pageReset()"><span class="clear">Clear</span></a> 
				<a href="#" class="button" onclick="cancelPage('LIST');"><span class="cancel">Cancel</span></a>
				</td>
		</tr>



	</table>


	<input type="hidden" name="strStoreId"		value="${newchallanProcessBean.strStoreId}" />

	<input type="hidden" name="strItemCategoryId"		value="${newchallanProcessBean.strItemCategoryId}" />

	<input type="hidden" name="strPoNo"		value="${newchallanProcessBean.strPoNo}" />

	<input type="hidden" name="strPoDate"		value="${newchallanProcessBean.strPoDate}" />		
		
	<input type="hidden" name="strPourchaseOrderDate"	value="${newchallanProcessBean.strPoDate}" />

	<input type="hidden" name="strPoStoreId"		value="${newchallanProcessBean.strPoStoreId}" />

	<input type="hidden" name="strPoTypeId"		value="${newchallanProcessBean.strPoTypeId}" />

	<input type="hidden" name="strPurchaseSourceId" 	value="${newchallanProcessBean.strPurchaseSourceId}" />

	<input type="hidden" name="strSupplierId"		value="${newchallanProcessBean.strSupplierId}" />

	<input type="hidden" name="strCtDate"	value="${newchallanProcessBean.strCtDate}"/>

	<input type="hidden" name="strPuk" value="${newchallanProcessBean.strPuk}"/>

	<input type="hidden" name="strEmployeeNo" value="${newchallanProcessBean.strEmployeeNo}"/>
	<input type="hidden" name="strChallanCount" value="${newchallanProcessBean.strChallanCount}"/>
	<input type="hidden" name="strchkvalue" value="${newchallanProcessBean.strchkvalue}"/>
	
	<input type="hidden" name="strOtherDeliveryModeFlg" />
	<input type="hidden" name="strOtherDeliveryModeTxtValue" />

	<input type="hidden" name="hmode" />

	<cmbPers:cmbPers />
</html:form>
<tag:autoIndex></tag:autoIndex>  
</body>
</html>








