<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<%@taglib uri="/WEB-INF/dateTag.tld" prefix="dateTag"%>
<%@ taglib uri="/WEB-INF/hisTab.tld" prefix="tag"%>


<html>
<head>
<title>Not Issued Items</title>

<script src="../../hisglobal/jquery/3.6.0.min.js" type="text/javascript"></script>

<link href="../css/master.css" rel="stylesheet" type="text/css">
<link href="../../hisglobal/css/tab.css" rel="stylesheet" type="text/css">
<link href="../../hisglobal/css/calendar-tas.css" rel="stylesheet" type="text/css">
<link href="../../hisglobal/css/buttons.css" rel="stylesheet" type="text/css">
<link href="../../hisglobal/css/popup.css" rel="stylesheet" type="text/css">	
	
<script language="JavaScript" src="../../masterutil/js/master.js"></script>
<script language="JavaScript" src="../../hisglobal/js/tab.js"></script>
<script language="JavaScript" src="../../hisglobal/js/calendar.js"></script>
<script language="Javascript" src="../../hisglobal/js/validation.js"></script>
<script language="Javascript" src="../../hisglobal/js/util.js"></script>

<!-- JQuery -->
<script src="../../hisglobal/jquery/3.6.0.min.js"></script>

<script src="/INVMGM/hisglobal/js/jquery.autocomplete.min.js"></script> 

<!-- BS   -->
<link href="/INVMGM/hisglobal/bootstrap4.0_newgui/css/bootstrap.css" rel="stylesheet" />
<link href="/INVMGM/hisglobal/bootstrap4.0_newgui/css/bootstrap-theme.css" rel="stylesheet" />
<link href="/INVMGM/hisglobal/bootstrap4.0_newgui/datetimepicker/css/gijgo.min.css" rel="stylesheet" type="text/css"> 
<link href="/INVMGM/hisglobal/bootstrap4.0_newgui/font-awesome/css/all.css" rel="stylesheet">

<!-- BS JS   -->
<script type="text/javascript" src="/INVMGM/hisglobal/bootstrap4.0_newgui/js/bootstrap.min.js""></script>
<script type="text/javascript" src="/INVMGM/hisglobal/bootstrap4.0_newgui/datetimepicker/js/gijgo.min.js"></script>

<style type="text/css">
body {
	font-family: "Helvetica Neue", Helvetica, Arial, sans-serif;
	font-size: 14px;
	line-height: 1.42857143;
	/* color: rgba(75, 75, 75, 0.7); */
	color: rgba(0, 0, 0, 1);
	font-weight: 501;
}

.table th, .table td {
	padding: 0.05rem;
}

.form-control {
	/* color: rgba(75, 75, 75, 0.7); */
	color: rgba(0, 0, 0, 1);
}

.table {
	width: 100%;
	margin-bottom: 1rem;
	/* color: rgba(75, 75, 75, 0.7); */
	color: rgba(0, 0, 0, 1);
}

.prescriptionTile {
	margin: 1.75% 0;
	border-bottom: 1px solid #d7d7d7;
	padding-bottom: 10px;
	padding: 1% 2% 0.5% 2%;
	background-color: #fff;
	transition: 0.5s;
	box-shadow: 0 0.5px 10px 2px #b0acac;
	border-radius: .25rem;
	/* color: rgba(75, 75, 75, 0.7); */
	color: rgba(0, 0, 0, 1);
	
}

.subHeaders {
	font-weight: 500 !important;
	font-family: "Helvetica Neue", "Helvetica";
	font-size: 19px !important;
	padding-bottom: 0px !important;
	/* color: rgba(75, 75, 75, 0.7); */
	color: rgba(0, 0, 0, 1);
}

.row {
	padding-bottom: 5px;
}

.legend2 {
	position: absolute;
	top: -2.5em;
	right: 44px;
	line-height: 1.2em;
}

.cancelbtn {
	padding: .175rem .35rem;
	line-height: 0.8;
	background-color: #d9534f;
}

.btn-circle {
	width: 37px;
	height: 34px;
	text-align: center;
	padding: 6px 0;
	font-size: 12px;
	line-height: 1.428571429;
	border-radius: 17px;
	color: white;
	float: right;
}

.iround {
	color: white;
	font-size: 16px;
}

.btn-outline-success {
	color: #28a745;
	border-color: #28a745;
	background-color: #28a745;
}
</style>

<script type="text/javascript">

/*  
 
function validate_org(){
		var hisValidator = new HISValidator("pendingIndentStatusRecordRpt");

	    hisValidator.addValidation("strStoreId", "dontselect=-1","Select Store Name from Store Combo ");
		hisValidator.addValidation("strItemCatNo", "dontselect=0","Select Item Category From Item Category Combo");
		hisValidator.addValidation("strReqTypeId", "dontselect=0","Select Request Type From Request Type Combo");
		
		hisValidator.addValidation("strFromDate", "date","From Date is a mandatory field");
		hisValidator.addValidation("strToDate", "date","To Date is a mandatory field");
		hisValidator.addValidation("strToDate","dtltet="+document.forms[0].strCurrentDate.value,"Please Select To Date Less Than or Equal To Current Date");
		hisValidator.addValidation("strToDate","dtgtet="+document.forms[0].strFromDate.value,"Please Select To Date Greater Than Or Equal To From Date");
	   var retVal = hisValidator.validate();
	   var dd= dateDiff(document.forms[0].strFromDate.value ,document.forms[0].strToDate.value);
		// alert(dd);
		var dd2 = dd.split(' ')[0];
	     if( dd2> 120)
		     {
		    // alert("Time difference couldn't be more than 120 days");
		    retVal= false;
		     }			
	hisValidator.clearAllValidations();
	
	if(retVal)
	{
		document.forms[0].strStoreName.value = document.forms[0].strStoreId[document.forms[0].strStoreId.selectedIndex].text;
		document.forms[0].strCategoryName.value = document.forms[0].strItemCatNo[document.forms[0].strItemCatNo.selectedIndex].text;


	   	var radioButtons = document.getElementsByName('strRptType');
	  	var selectedRadioButton;

	  	for (var i = 0; i < radioButtons.length; i++) {
	    if (radioButtons[i].checked) {
	      selectedRadioButton = radioButtons[i];
	      break;
	    	}
	  	}

	  	if (selectedRadioButton) {
	    document.forms[0].strRptType.value = selectedRadioButton.value;
// 		document.forms[0].strRptTypetext.text = selectedRadioButton.text;

	  	} 
		
		if(document.forms[0].strRptType.value=="3")
		{
			document.forms[0].hmode.value = "PARTIALISSUERPT";
			document.forms[0].submit();
		}
		else
		{	
			document.forms[0].hmode.value = "SHOWRPT";
			 if(document.forms[0].strReportFormat[document.forms[0].strReportFormat.selectedIndex].value == "html")
			{
				document.forms[0].target = "_self";
			}else{
				document.forms[0].target = "_blank";
			} 
		   document.forms[0].submit();
		}  
	}
	else
	{
			return false;
	}
}  */

function validate(){
	
		if(document.forms[0].strRptType.value=="3")
		{

			document.forms[0].strStoreName.value = document.forms[0].strStoreId[document.forms[0].strStoreId.selectedIndex].text;
			document.forms[0].strCategoryName.value = document.forms[0].strItemCatNo[document.forms[0].strItemCatNo.selectedIndex].text;
			
			document.forms[0].hmode.value = "PARTIALISSUERPT";
			document.forms[0].submit();

		} else {
			
			var hmode = "SHOWRPT"; 
			var url = "PendingIndentStatusRecordRptCNT.cnt?hmode="+hmode+
			
			"&strStoreId="+document.forms[0].strStoreId[document.forms[0].strStoreId.selectedIndex].value+
			"&storeName="+document.forms[0].strStoreId[document.forms[0].strStoreId.selectedIndex].text+
			
			//"&strCategoryId="+document.forms[0].strItemCatNo[document.forms[0].strItemCatNo.selectedIndex].value.split('^')[0]+
			"&strCategoryId="+document.forms[0].strItemCatNo[document.forms[0].strItemCatNo.selectedIndex].value+
			"&strCategoryName="+document.forms[0].strItemCatNo[document.forms[0].strItemCatNo.selectedIndex].text+
			
			"&strReqTypeId="+document.forms[0].strReqTypeId[document.forms[0].strReqTypeId.selectedIndex].value+
			"&strRptType="+document.forms[0].strRptType.value+
			
			"&strFromDate="+document.forms[0].strFromDate.value+
			"&strToDate="+document.forms[0].strToDate.value+
			"&strIsConsolidated="+document.forms[0].strIsConsolidated.value;
	 		alert(url);		
			ajaxFunction(url,"3");
		}
	}  
	
function getItemCatCmb(){ 

		if(document.forms[0].strStoreId.value!=0){
			var url ="PendingIndentStatusRecordRptCNT.cnt?hmode=ITEMCATCMB&storeId="+document.forms[0].strStoreId.value;
	 		ajaxFunction(url,"1");
	 	}else{
		//document.forms[0].strItemCatNo.value="0";
	 		var url ="PendingIndentStatusRecordRptCNT.cnt?hmode=ITEMCATCMB&storeId="+document.forms[0].strStoreId.value;
	 		ajaxFunction(url,"1");	
	}
}
function getReqTypeCmb(){ 
	if(document.forms[0].strStoreId.value!=0 && document.forms[0].strItemCatNo.value!=0 ){
		var url ="PendingIndentStatusRecordRptCNT.cnt?hmode=REQTYPECMB&storeId="+document.forms[0].strStoreId.value+"&catId="+document.forms[0].strItemCatNo.value;
 		ajaxFunction(url,"2");
 	}else{
	//document.forms[0].strItemCatNo.value="0";
 		var url ="PendingIndentStatusRecordRptCNT.cnt?hmode=REQTYPECMB&storeId="+document.forms[0].strStoreId.value+"&catId="+document.forms[0].strItemCatNo.value;
 		ajaxFunction(url,"2");	
}
}
function getAjaxResponse(res,mode){
	
	if(mode=="1"){ 
		
			var objVal= document.getElementById("itemCatDivId");
			objVal.innerHTML = "<select name ='strItemCatNo' class='custom-select' onChange='getReqTypeCmb();' >"+res+"</select>";		
		
	}	

	if(mode=="2"){ 
		
		var objVal= document.getElementById("reqDivId");
		objVal.innerHTML = "<select name ='strReqTypeId' class='custom-select'>"+res+"</select>";		
	
	}	
	if(mode=="3"){ 
		
		var objVal= document.getElementById("reportdtl");
		objVal.style.display = "block";
		//alert(res);
		 objVal.innerHTML = res;
		 
		 document.getElementById("strStoreId").disabled = true;
		 document.getElementById("strItemCatNo").disabled = true;
		 document.getElementById("strFromDate").disabled = true; 
		 document.getElementById("strToDate").disabled = true;	
	}	
}		
	
function cancelPage(){
	document.forms[0].hmode.value="CANCEL";
	document.forms[0].target = "_self";
	document.forms[0].submit();

}

function onLoadpage(){
	document.forms[0].strItemCatNo.value = "0";
	document.forms[0].strStoreId.value = "-1";
	document.forms[0].strFromDate.value = document.forms[0].strCurrentDate.value;
	document.forms[0].strToDate.value = document.forms[0].strCurrentDate.value;
}

// added by vipul on 10.05.2021
function getStoreName(Storename){
	var filter="";
	filter +="Store Name: "+Storename.options[Storename.selectedIndex].text;
	document.getElementById("filter").value=filter;
	//alert(filter);
	
}

function getConsolidate(){
	var checkoutConsolidated = document.getElementById('StrIsConsolidated');	
	 if (checkoutConsolidated.checked) {
		 document.forms[0].strStoreId.value = "0";
		 document.forms[0].strStoreId.disabled =true;
		 getItemCatCmb();
	    } else {
	    	document.forms[0].strStoreId.disabled =false;
	    	document.forms[0].strStoreId.value = "-1";
	    }
	
}

function controlToMainPage()
{	    
	document.forms[0].hmode.value="unspecified";
	document.forms[0].submit();
}

function printReport() {
    document.getElementById("printRptId").style.display = "none";
    
    // Clone the content excluding the last column
    const contentToPrint = document.getElementById("reportdtl").cloneNode(true);
    const rows = contentToPrint.querySelectorAll('tr');
    
   /*  for (const row of rows) {
        const lastCell = row.lastElementChild;
        if (lastCell) {
            row.removeChild(lastCell);
        }
    }
 */
    const newWin = window.open('', '', 'width=700,height=700,scrollbars=yes');
    newWin.document.write('<html><head>');
    newWin.document.write('<style type="text/css">');
    newWin.document.write('.hidecontrol { display: none; }');
    newWin.document.write('@media print {');
    newWin.document.write('  table {border-collapse: collapse; }');
    newWin.document.write('}');
    newWin.document.write('</style>');
    
    newWin.document.write('</head><body>');
    newWin.document.write(contentToPrint.outerHTML);
    newWin.document.write('</body></html>');
    
    newWin.document.close();
    
    newWin.onload = function () {
        newWin.print();
        newWin.close();
        document.getElementById("printRptId").style.display = "block";
    };
}
</script>

</head>

<body onload="onLoadpage();">
<html:form action="/reports/PendingIndentStatusRecordRptCNT" method="post">
	
<div class="errMsg" id="errMsg"><bean:write name="pendingIndentStatusRecordRpt" property="strErrMsg"/></div>
<div class="normalMsg" id="normalMsg"><bean:write name="pendingIndentStatusRecordRpt" property="strNormalMsg"/></div>
<div class="warningMsg" id="warningMsg"><bean:write name="pendingIndentStatusRecordRpt" property="strWarningMsg"/></div>

<div class="container-fluid">
	<div class="prescriptionTile">
	
	<div class="row rowFlex reFlex">
		<div class="col-sm-6" style="text-align: initial;">
			<p class="subHeaders">
				<i class="fas fa-file-alt iround"
					style="font-size: 20px; color: #28a745" title="Cancel"></i>
				&nbsp;Not Issued Drugs/Items Report
			</p>
		</div>
		
		
		<div class="col-sm-6">
			<div class="legend2" id='nonPrintableLegend2'>
				<button type="button"
					class="float-right btn btn-outline-danger mt-1 btn-circle cancelbtn"
					onclick="cancelFunc();">
					<i class="fas fa-times iround" title="Cancel"></i>
				</button>
				
				<button type="button" class=" btn btn-secondary btn-circle"
					onclick="document.forms[0].reset();"
					style="background: royalblue; border-color: royalblue; margin-top: 0.25rem !important;">
					<!-- <img src="/HIS/hisglobal/images/clear3.png" title="Clear"
						style="width: 23px; color: #fff;"> -->
					<i class="fas fa-broom iround" title="Clear"></i>
				</button>
	
				<button type="button" id="generatebutton"
					class="float-right btn btn-outline-success mt-1 btn-circle savebtn"
					tabindex='2' onclick='return validate();'>
					<i class="fas fa-download iround" title="Save"></i>
				</button>
			</div>
		</div>
	</div>
	
	
	
	<!-- 	<div class='legendHeader' style='font-size: 16px;font-weight: bold;'><i aria-hidden="true" class="fa fa-clipboard"></i> &nbsp;Not Issued Drugs/Items Report</div>
		
		<div class="row ">
			<div class="legend2" id='nonPrintableLegend2'>
				<button type="button" title="Cancel" id="cancelButton" class="float-right btn btn-danger mt-1 btn-icon printbtn" style="border-radius:50%; padding:12px 14px" onClick="cancelFunc();">	
						<div class="popupToast" style="color: #fff;">
							<i class="fas fa-times " title="Cancel"></i>
						</div>
				</button>	
				<button type="button" title="Clear" class="float-right btn btn-secondary mt-1 btn-icon clearbtn"  style="background-color: #2196f3; border-radius:50%; padding:12px 10px" onClick="document.forms[0].reset();">	
					<div class="popupToast" style="color: #fff;">
						<i class="fas fa-broom " title="Clear"></i>
					</div>
				</button>	
				<button  type="button" title="Generate" id="generatebutton" class="float-right btn btn-success mt-1 btn-icon savebtn" style="border-radius:50%; padding:12px 12px" tabindex='2' onClick="return validate();"  data-toggle="" data-target="#previewModal" >
					<div class="popupToast" style="color: #fff;">
						<i class="fas fa-download " title="Generate"></i>
					</div>
				</button>
  			</div>  
		</div> -->
		
		
	<div class="container">
		<div class="row" style="margin: 1% 10%;">
			<div class="col">
			Consolidated &nbsp;<input type="Checkbox" name="strIsConsolidated" value="3" tabindex="1" id="StrIsConsolidated" onChange="getConsolidate();">
<%-- 		<html:checkbox property="StrIsConsolidated" name="pendingIndentStatusRecordRpt" value="1">Consolidated</html:checkbox> --%>
			</div>
		</div>
	
		<div class="row" style="margin: 1% 10%;">
			<div class="col-sm-2"><label>Store Name<font color="red">*</font></label></div>
			<div class="col-sm-4">
				<select name="strStoreId" class='custom-select' onchange="getItemCatCmb(); getStoreName(this);"> 
					<bean:write name="pendingIndentStatusRecordRpt" property="strStoreValues" filter="false" />
						<option title="All" value="0">All</option>
				</select>
			</div>

			<div class="col-sm-2 "><label>Category<font color="red">*</font></label></div>
			<div class="col-sm-4" id="itemCatDivId">
					<select name="strItemCatNo"  class="custom-select" onChange="">
						<option value="0">Select Value</option>
				    </select>		
			</div> 
		</div>
		<div class="row" style="margin: 1% 10%;">
			<div class="col-sm-2 "><label>Request Type<font color="red">*</font></label></div>
			<div  class="col-sm-4" id="reqDivId">
				<select	name="strReqTypeId"  class="custom-select">
					<option value="0">SelectValue</option>
				</select>
			</div>
			<div class="col-sm-2 "><label>Generation Type<font color="red">*</font></label></div>
			<div  class="col-sm-4 my-auto">
				<input type="radio" name="strRptType" value="1" checked="" tabindex="1">Not Issued
				<input type="radio" name="strRptType" value="2" tabindex="1">Issued
				<input type="radio" name="strRptType" value="3" tabindex="1">Partial Issued
			</div>
			
		<!-- 	<div class="btn-group col-sm-4" data-toggle="buttons">
			  <label class="btn ">
			    <input type="radio" name="strRptType" value="1" checked> Not Issued
			  </label>
			  <label class="btn ">
			    <input type="radio" name="strRptType" value="2"> Issued
			  </label>
			  <label class="btn ">
			    <input type="radio" name="strRptType" value="3"> Partial Issued
			  </label>
			</div> -->
			
		</div>
		
		<div class="row" style="margin: 1% 10%;">
			<div class="col-sm-2"><label>From Date<font color="red">*</font> </label></div>
			<div class="col-sm-4">
				<input name="strFromDate" id="datepicker1" class="form-control datepicker1" value="${pendingIndentStatusRecordRpt.strCurrentDate}" />
			</div>
				
			<div class="col-sm-2"><label>To Date<font color="red">*</font> </label></div>
			<div class="col-sm-4">
				<input name="strToDate" id="datepicker2" class="form-control datepicker2" value="${pendingIndentStatusRecordRpt.strCurrentDate}" />
			</div>
	
		</div>
		
		
		<!-- <div class="row" style="margin: 1% 10%;">
			<div class="col-sm-2 "><label>Report Format<font color="red">*</font></label></div>
			<div class="col-sm-4" >
				<select name="strReportFormat"   class="custom-select" onchange="">
					<option value="html">Html</option>
					<option value="pdf">Pdf</option>
					<option value="xls">Excel</option>
				</select>
		</div> -->

		<!-- 		 added by vipul on 10.05.2021 -->
			<input type="hidden" name="filter" id="filter">
		<!-- 		 ended by vipul on 10.05.2021 -->	

		
			<!-- <div class="col-sm-2"><label>User Remarks<font color="red">*</font></label></div>
			<div class="col-sm-4">
				<textarea name="strUserRemarks" class="form-control" rows="1"  style="height:38px;" onkeyup="maxLengthRemarks(this,'500')" ></textarea>
			</div> 
		</div>	 -->
	</div>
		
		<hr>
		
		<div class="row text-right">
	    	<div class="col">
	    		<i class="fas fa-asterisk" style="color: red; font-size: smaller;"></i>Fields Mandatory
	    	</div>
		</div>

		<input type="hidden" name="hmode"/>
		<input type="hidden" name="strCurrentDate" value="${pendingIndentStatusRecordRpt.strCurrentDate}"/>
		<!-- added -->
		<input type="hidden" name="strStoreName" />
		<input type="hidden" name="strCategoryName" />
		<input type="hidden" name="strRptType" />
		
		<!-- REPORT PRINT DIV -->
		<div  align="center" id="reportdtl"></div>
		

	</div>
</div>


</html:form>

<script type="text/javascript">
    $('#datepicker1').datepicker({modal: true, header: true, footer: true ,format: 'dd-mmm-yyyy'});
    $('#datepicker2').datepicker({ modal: true, header: true, footer: true ,format: 'dd-mmm-yyyy'});
    var today=new Date();
    var arr=["Jan","Feb","Mar","Apr","May","Jun","Jul","Aug","Sep","Oct","Nov","Dec"];
    var mmm=arr[today.getMonth()];
    var hrs=today.getHours();
    var dd=today.getDate()+"-"+mmm+"-"+today.getFullYear();
    $('#datepicker1').val(dd);
    $('#datepicker2').val(dd);
</script>
   
<tag:autoIndex></tag:autoIndex>
</body>
</html>