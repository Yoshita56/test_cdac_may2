<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<%@taglib uri="/WEB-INF/dateTag.tld" prefix="dateTag"%>
<%@ taglib uri="/WEB-INF/hisTab.tld" prefix="tag"%>


<html>
<head>
<title>Issue To Patient Report</title>

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

<!-- BS Library  -->
<link href="/INVMGM/hisglobal/bootstrap4.0_newgui/css/bootstrap.css" rel="stylesheet" />
<link href="/INVMGM/hisglobal/bootstrap4.0_newgui/css/bootstrap-theme.css" rel="stylesheet" />
<link href="/INVMGM/hisglobal/bootstrap4.0_newgui/datetimepicker/css/gijgo.min.css" rel="stylesheet" type="text/css"> 
<link href="/INVMGM/hisglobal/bootstrap4.0_newgui/font-awesome/css/all.css" rel="stylesheet">

<!-- JS Library  -->
<script type="text/javascript" src="/INVMGM/hisglobal/bootstrap4.0_newgui/js/bootstrap.min.js""></script>
<script type="text/javascript" src="/INVMGM/hisglobal/bootstrap4.0_newgui/datetimepicker/js/gijgo.min.js"></script>


<style type="text/css">
body {
	font-family: "Helvetica Neue", Helvetica, Arial, sans-serif;
	font-size: 14px;
	line-height: 1.42857143;
	color: rgba(0, 0, 0, 1);
	font-weight: 501;
}
.prescriptionTile {
	margin: 24px;
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
	top: -2.5em;
	right: 44px;
	line-height: 1.2em;
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
.subHeaders {
	font-weight: 500 !important;
	font-family: "Helvetica Neue", "Helvetica";
	font-size: 19px !important;
	padding-bottom: 0px !important;
	color: rgba(0, 0, 0, 1);
}
</style>


<script type="text/javascript">

function validate(){

	var hisValidator = new HISValidator("issuePatientRptBean");

	    hisValidator.addValidation("strStoreId", "dontselect=0","Select Store Name from Store Combo ");
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
			    /* if( dd2> 30)
				     {
				     alert("Time difference couldn't be more than 30 days");
				    retVal= false;
				     }*/
			
	hisValidator.clearAllValidations();

	
	if(retVal){
		/* document.forms[0].hmode.value = "SHOWRPT";
		document.forms[0].submit();  */
	 	
	 	var hmode = "SHOWRPT"; 
		var url = "IssueToPatientCNT.cnt?hmode="+hmode+
		
		"&storeId="+document.forms[0].strStoreId[document.forms[0].strStoreId.selectedIndex].value+
		"&storeName="+document.forms[0].strStoreId[document.forms[0].strStoreId.selectedIndex].text+
		
		"&categoryId="+document.forms[0].strItemCatNo[document.forms[0].strItemCatNo.selectedIndex].value+
		"&categoryName="+document.forms[0].strItemCatNo[document.forms[0].strItemCatNo.selectedIndex].text+

		"&patientType="+document.forms[0].strPatientType.value+
		"&patientGenderCode="+document.forms[0].strPatientGenderCode.value+
		
		"&startDate="+document.forms[0].strFromDate.value+
		"&endDate="+document.forms[0].strToDate.value;

		alert(url);		
		
		ajaxFunction(url,"7");
		 
		}else{
			return false;
		}
	}
	
	
function getItemCatCmb(){ 

		if(document.forms[0].strStoreId.value!=0){
			var url ="IssueToPatientCNT.cnt?hmode=ITEMCATCMB&storeId="+document.forms[0].strStoreId.value;
	 		ajaxFunction(url,"1");
	 	}else{
		document.forms[0].strItemCatNo.value="0";
	}
}
function getReqTypeCmb(){ 
	if(document.forms[0].strStoreId.value!=0 && document.forms[0].strItemCatNo.value!=0 ){
		var url ="IssueToPatientCNT.cnt?hmode=REQTYPECMB&storeId="+document.forms[0].strStoreId.value+"&catId="+document.forms[0].strItemCatNo.value;
 		ajaxFunction(url,"2");
 	}else{
	document.forms[0].strItemCatNo.value="0";
}
}
function getAjaxResponse(res,mode){
	
	if(mode=="1"){ 
		
		
			var objVal= document.getElementById("itemCatDivId");
			objVal.innerHTML = "<select name ='strItemCatNo' class='custom-select' onChange=' ' >"+res+"</select>";		
		
	}	

	if(mode=="2"){ 
		
		
		var objVal= document.getElementById("reqDivId");
		objVal.innerHTML = "<select name ='strReqTypeId' class='custom-select'>"+res+"</select>";		
	}
	if (mode == "7") {
		
		objVal = document.getElementById("ReplacementRpt");
		objVal.style.display = "block";
		
		document.getElementById("viewCancelButtonDivId1").style.display = "block";
		objVal.innerHTML = res;
		
	    document.getElementsByName("strStoreId")[0].disabled     = true;
		document.getElementsByName("strItemCatNo")[0].disabled   = true;
		document.getElementsByName("strPatientType")[0].disabled = true; 
		document.getElementsByName("strPatientGenderCode")[0].disabled = true; 
		document.getElementsByName("strFromDate")[0].disabled  = true; 
		document.getElementsByName("strToDate")[0].disabled    = true; 

	}
}		
	
function cancelPage(){
	document.forms[0].hmode.value="CANCEL";
	document.forms[0].target = "_self";
	document.forms[0].submit();

}

function onLoadpage(){
	document.forms[0].strItemCatNo.value = "0";
	document.forms[0].strStoreId.value = "0";
	document.forms[0].strFromDate.value = document.forms[0].strCurrentDate.value;
	document.forms[0].strToDate.value = document.forms[0].strCurrentDate.value;

}

function printReport() {
    document.getElementById("printRptId").style.display = "none";
    
    // Clone the content excluding the last column
    const contentToPrint = document.getElementById("ReplacementRpt").cloneNode(true);
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

function controlToMainPage()
{	    
	document.forms[0].hmode.value="unspecified";
	document.forms[0].submit();
}

function setDates()
{
	if(document.getElementsByName("strByCurrentAndDate")[0].checked==true)
	{
		document.getElementById("fromToDateDivId").style.display='none';
	}
	else
	{
		document.getElementById("fromToDateDivId").style.display='';
	}
}


</script>

</head>
<body onload="onLoadpage();">
<html:form action="/reports/IssueToPatientCNT" method="post">
	
<div class="errMsg" id="errMsg"><bean:write name="issuePatientRptBean" property="strErrMsg"/></div>
<div class="normalMsg" id="normalMsg"><bean:write name="issuePatientRptBean" property="strNormalMsg"/></div>
<div class="warningMsg" id="warningMsg"><bean:write name="issuePatientRptBean" property="strWarningMsg"/></div>

<div class="container-fluid">
	<div class="prescriptionTile">
		
	<div class="row ">
				<div class="col-sm-6" style="text-align: initial;">
					<p class="subHeaders">
	
						<i class="fas fa-file-alt iround"
							style="font-size: 20px; color: #28a745" title="Cancel"></i>
						&nbsp;Issue To Patient Department Wise Report
					</p>
				</div>
				
				<div class="col-sm-6" id="viewCancelButtonDivId1">
					<div class="legend2" id='nonPrintableLegend2'>
						<button type="button" class="float-right btn btn-danger mt-1 btn-circle printbtn" onclick="cancelFunc();">
							<i class="fas fa-times iround" title="Cancel"></i>
						</button>
						<button type="button" class="float-right btn btn-secondary mt-1 btn-circle clearbtn" style="background: #2196f3; border-color: #b9b9b9; margin-top: 0.25rem !important;" onClick="controlToMainPage();">
							<i class="fas fa-broom iround" title="Clear"></i>
						</button>
						
						<button type="button" id="generatebutton" class="float-right btn btn-success mt-1 btn-circle savebtn" tabindex='2' onclick='return validate();' >
							<i class="fa fa-download iround" title="Generate"></i>
						</button>
					</div>
				</div>
			</div>
		
		<div class="container">
		
			<div class="row" align="right">
				<div class="col-sm-12">
					<html:radio property="strByCurrentAndDate"  name="issuePatientRptBean" value="1" onclick="setDates();" >Current Date</html:radio>
					<html:radio property="strByCurrentAndDate" name="issuePatientRptBean" value="2" onclick="setDates();">Back Date</html:radio>
				</div>
			</div>
			
			<div class="row" style="margin: 1% 12%;">
				<div class="col-sm-2"><label>Store Name<font color="red">*</font></label></div>
				<div class="col-sm-4">
					<select name="strStoreId" class='custom-select' onchange="getItemCatCmb();"> 
						<bean:write name="issuePatientRptBean" property="strStoreValues" filter="false" />
					</select>
				</div>
		
				<div class="col-sm-2 "><label>Category<font color="red">*</font></label></div>
				<div class="col-sm-4" id="itemCatDivId">
						<select name="strItemCatNo"  class="custom-select" onChange="">
							<option value="0">Select Value</option>
					    </select>		
				</div> 
			</div>
			
			<div class="row " style="margin: 1% 12%;">
				<div class="col-sm-2 "><label>Patient Type<font color="red">*</font></label></div>
				<div  class="col-sm-4" id="reqDivId">
					<select	name="strPatientType"  class="custom-select">
						<option value="0">All</option>	
						<option value="1">OPD</option>					
						<option value="2">IPD</option>
					</select>
				</div>
		
				<div class="col-sm-2 "><label>Gender <font color="red">*</font></label></div>
				<div  class="col-sm-4">
					<select name="strPatientGenderCode" class="custom-select" onchange="">
						<option value="0">All</option>	
						<option value="1">Male</option>					
						<option value="2">Female</option>
					</select>
				</div>
			</div>
		
			<div class="row" id="fromToDateDivId" style="display: none; margin: 1% 12%;">
				<div class="col-sm-2">
					<label><font color="red">*</font>From Date</label>
				</div>
				<div class="col-sm-4">
					<input class="form-control datepicker1" name="strFromDate" id='datepicker1'>
				</div>
				<div class="col-sm-2">
					<label><font color="red">*</font>To Date</label>
				</div>
				<div class="col-sm-4">
					<input class="form-control datepicker2" name="strToDate" id='datepicker2'>
				</div>
			</div>
		</div>
					
		<hr>
		
		<div class="row text-right">
	    	<div class="col">
	    		<i class="fas fa-asterisk" style="color: red; font-size: smaller;"></i>Fields Mandatory
	    	</div>
		</div>
			   	
		<div align="center" id="ReplacementRpt"></div>
		
		<input type="hidden" name="hmode"/>
		<input type="hidden" name="strCurrentDate" value="${issuePatientRptBean.strCurrentDate}"/>
	   	
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