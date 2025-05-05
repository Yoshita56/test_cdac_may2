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

<link href="../../hisglobal/bootstrap4.0_newgui/css/bootstrap.css" rel="stylesheet" />
<link href="../../hisglobal/bootstrap4.0_newgui/css/bootstrap-theme.css" rel="stylesheet" />
<link href="../../hisglobal/bootstrap4.0_newgui/datatable/css/dataTables.bootstrap.css"   rel="stylesheet" />
<link href="../../hisglobal/bootstrap4.0_newgui/font-awesome/css/all.css" rel="stylesheet">
<link href="../../hisglobal/bootstrap4.0_newgui/swAl/swal.css" rel="stylesheet">
<link href="../../ipd/css/newlayout.css" rel="stylesheet" type="text/css">
<link href="../../hisglobal/bootstrap4.0_newgui/datetimepicker/css/gijgo.min.css" rel="stylesheet" type="text/css">
	
<script type="text/javascript" src="../../hisglobal/bootstrap4.0_newgui/swAl/swal.js"></script>
<script type="text/javascript" src="../../hisglobal/jquery/3.6.0.min.js"></script>
<script type="text/javascript" src="../../hisglobal/bootstrap4.0_newgui/datatable/js/jquery.dataTables.js"></script>
<script type="text/javascript" src="../../hisglobal/bootstrap4.0_newgui/js/bootstrap.min.js"></script>
<script type="text/javascript" src="../../hisglobal/bootstrap4.0_newgui/datatable/js/dataTables.bootstrap4.js"></script>
<script type="text/javascript" src="../../hisglobal/bootstrap4.0_newgui/datetimepicker/js/gijgo.min.js"></script>



<link href="../../hisglobal/css/popup.css" rel="stylesheet" type="text/css">	
<link href="../../hisglobal/css/newpopup.css" rel="stylesheet" type="text/css">


<script language="JavaScript" src="../../hisglobal/js/calendar.js"></script>
<script language="JavaScript" src="../../hisglobal/js/util.js"></script>
<script language="JavaScript" src="../../hisglobal/js/validation.js"></script>
<script language="JavaScript" src="../../hisglobal/js/multiRowTLD.js"></script>
<script language="JavaScript" src="../../hisglobal/js/multirow.js"></script>
<script language="Javascript" src="../../hisglobal/js/newpopup.js"></script>
<script language="Javascript" src="../../hisglobal/js/popup.js"></script>
<script language="Javascript" src="../js/mms.js"></script>
<script language="Javascript" src="../js/newchallanprocess_mmstransBS.js"></script>
<style type="text/css">
.table th, .table td {
    padding: 0.15rem;
    text-align: left;
}

.popUpDiv {

    width: 1291px;
}
.table{
        
          background-color: white;
}
TR.HEADER {
    background: white;
    color: gray;
    height: 40px;
    color: #005B88;
    color: white;
    text-transform: capitalize;
    font-family:  "Helvetica Neue", Helvetica, Arial, sans-serif;
    font-size: 13px;
    font-style: normal;
    line-height: 18pt;
    font-weight: bold;
    font-variant: normal;
}
.prescriptionTile {
	margin: 20px;
	border-bottom: 1px solid #d7d7d7;
	padding-bottom: 10px;
	padding: 1% 2% 0.5% 2%;
	background-color: #fff;
	transition: 0.5s;
	box-shadow: 0.5px 0.5px 10px 2px #b0acac;
	border-radius: .35rem;
	color: #666;
	color: rgba(75, 75, 75, 0.9);
	color: rgb(21, 21, 21);
}
.legend2 {
	position: absolute;
	top: 0.5em;
	right: 44px;
	line-height: 1.2em;
}
</style>
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
	action="/transactions/NewChallanProcessTransBSCNT"
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

	<div class="errMsg" id="errMsg" align="center" style='color:red'><bean:write
		name="newchallanProcessBean" property="strErr" /></div>
	<div class="warningMsg" id="warningMsg"><bean:write
		name="newchallanProcessBean" property="strWarning" /></div>
	<div class="normalMsg" id="normalMsg"><bean:write
		name="newchallanProcessBean" property="strMsg" /></div>

<div class="container-fluid">
		<div class="prescriptionTile">	
	
  <div style="width:auto; margin-bottom: 0px;font-size: 1.5rem;font-weight: 400; color: #666;" id='nonPrintableLegend'>Challan Process</div>
  <div class="legend2" id='nonPrintableLegend2'>
			<button type="button"
				class="float-right btn btn-danger mt-1 btn-circle cancelbtn"
				onclick="cancelPage('LIST');" style="border-radius:50%; padding:12px 12px;">
				<i class="fas fa-times fa-lg" title="Cancel"></i>
			</button>
			
			<button type="button" class="float-right btn btn-secondary btn-circle"
				onclick="pageReset();"
				style="border-radius:50%; padding:12px 7px; background: #2196f3; border-color: #b9b9b9; margin-top: 0.25rem !important;" >
				<i class="fas fa-broom fa-lg iround" title="Clear"></i>
			</button>
		
			<button type="button" id="savebutton" class="float-right btn btn-success mt-1 btn-circle savebtn" name="requestForLpPatient" id="submitId" tabindex='2'style="border-radius:50%; padding:12px;" onclick='return validationRec();'>
				<i class="fa fa-download fa-beat iround" title="Save"></i>
			</button>
		</div>
<div class="container">
    <div class="row">
		<div class="col-sm-2"><label>Store Name</label></div>
		<div class="col-sm-2" style="font-weight: normal; "><bean:write name="newchallanProcessBean" property="strStoreName" /></div>
		<div class="col-sm-2"><label>Item Category</label></div>
		<div class="col-sm-2" style="font-weight: normal; "><bean:write name="newchallanProcessBean" property="strItemCategoryName" /></div>
		<div class="col-sm-2"><label>P.O. No.</label></div>
		<div class="col-sm-2" style="font-weight: normal; "><bean:write name="newchallanProcessBean" property="strPoNoDisplay" /></div>
	</div>
	
	<div class="row">
		<div class="col-sm-2"><label>P.O. Date</label></div>
		<div class="col-sm-2" style="font-weight: normal;color: #46b8da; "><bean:write name="newchallanProcessBean" property="strPoDate" /></div>
		<div class="col-sm-2"><label>P.O. Type</label></div>
		<div class="col-sm-2" style="font-weight: normal; "><bean:write name="newchallanProcessBean" property="strPoType" /></div>
		<div class="col-sm-2"><label>Supplier Name</label></div>
		<div class="col-sm-2" style="font-weight: normal; "><bean:write name="newchallanProcessBean" property="strSupplierName" /></div>
	</div>
</div>	
      
<!-- 	   <div id="scheduleDtlsDivId" style="display:none;" ></div>
 -->	   <p class="subHeaders"><i class="fas fa-file-invoice" style="font-size: 26px;"></i>&nbsp;&nbsp;Challan Details</p>
<div class="container">	     	
	   <div class="row my-1 ">
		   <div class="col-sm-2"><label>Received Date<font color="red">*</font></label></div>
		   <div class="col-sm-4"> <div id='dateVal'></div><div id='calDate'><input class="form-control datepicker"	name="strReceiveDate"  value="${newchallanProcessBean.strCtDate}"></div></div>
		   <div class="col-sm-2"><label>Received By<font color="red">*</font></label></div>
		   <div class="col-sm-4">
  			  <select name="strReceivedComboBy" class="browser-default custom-select" onchange="checkValCombo(this);">
              	<bean:write name="newchallanProcessBean" property="strReceivedByOptionVal" filter="false"/>
              </select>
           </div>
		   </div>
	    <div class="row my-1">
		   <div class="col-sm-2"><label>Challan/Invoice No.<font color="red">*</font></label></div>
		   <div class="col-sm-4"> <input type="text" autocomplete='off' size="25" name="strSupplierReceiptNo" maxlength="20" class="form-control" onkeypress="return validateData(event,18);"></div>
		   <div class="col-sm-2"><label>Challan/Invoice Date<font color="red">*</font></label></div>
		   <div class="col-sm-4"><div id='supplierRecDate'></div>  <div id='recpCalender'><input class="form-control datepicker"	name="strSupplierReceiptDate"	value="${newchallanProcessBean.strCtDate}"></div></div>
		   </div>
	   <div class="row my-1">
		   <div class="col-sm-2"><label>Rack No.</div>
		   <div class="col-sm-4"><input type='text' class="form-control" name="strRackNo" value='' onkeypress='return validateData(event,8);' maxlength='10'></div>
		   <div class="col-sm-2"><label>Remarks</div>
		   <div class="col-sm-4"> <textarea name="strRemarks" class="form-control" cols="20" rows="2" id="strRemarks" style="height:38px;"></textarea></div>
	   </div>
</div>	   
       <div id="nameOtherFld" style="display: none">
       		<input type='text' name='strReceivedBy' autocomplete='off' value=''  maxlength='50'>
       		<!-- <input type='text' name='strReceivedBy' value='' onkeypress='return validateData(event,11);' maxlength='50'>  Orignal Code -->
       </div>

<hr>
	<div class="row rowFlex reFlex" id="footerid">
					        <div class="col-sm-10">
					         	<logic:equal name="newchallanProcessBean" property="strPoTypeId" value="21" >
         							 <font color="red">Whether you want to keep The PO Active</font>
           						 	 <input type='checkbox'  name="strchkbox" id="strchkbox" value="0"  onclick="setvalue()"> 
           						 </logic:equal>
					        </div>
					        
					        <div class="col-sm-2" align="right">
					        	 <i class="fa fa-asterisk" style="color: red;font-size: smaller;"></i>Fields Mandatory</div>				
				           	</div>


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
	</div>
	</div>
</html:form>
 
<script type="text/javascript">
	
	$('.datepicker').each(function(){
	    $(this).datepicker({ modal: true, header: true, footer: true ,format: 'dd-mmm-yyyy'});
	});
	var today=new Date();
	var arr=["Jan","Feb","Mar","Apr","May","Jun","Jul","Aug","Sep","Oct","Nov","Dec"];
	var mmm=arr[today.getMonth()];
	var hrs=today.getHours();
	var dd=today.getDate()+"-"+mmm+"-"+today.getFullYear();
	$('.datepicker').val(dd);
	</script>
</body>
</html>








