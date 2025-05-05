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

function validate(){

	var hisValidator = new HISValidator("IssueToPatientRPT");

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
		document.forms[0].hmode.value = "SHOWRPT";
		
			if(document.forms[0].strReportFormat[document.forms[0].strReportFormat.selectedIndex].value == "html")
			{
				document.forms[0].target = "_self";
			}else{
				document.forms[0].target = "_blank";
			}
		document.forms[0].submit();
		}else{
			return false;
		}
	}
	
	
function getItemCatCmb(){ 

		if(document.forms[0].strStoreId.value!=0){
			var url ="IssueToPatientCNT_NEW.cnt?hmode=ITEMCATCMB&storeId="+document.forms[0].strStoreId.value;
	 		ajaxFunction(url,"1");
	 	}else{
		document.forms[0].strItemCatNo.value="0";
	}
}
function getReqTypeCmb(){ 
	if(document.forms[0].strStoreId.value!=0 && document.forms[0].strItemCatNo.value!=0 ){
		var url ="IssueToPatientCNT_NEW.cnt?hmode=REQTYPECMB&storeId="+document.forms[0].strStoreId.value+"&catId="+document.forms[0].strItemCatNo.value;
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

</script>

</head>
<body onload="onLoadpage();">
<html:form action="/reports/IssueToPatientCNT_NEW" method="post">
	
<div class="errMsg" id="errMsg"><bean:write name="IssueToPatientRPT" property="strErrMsg"/></div>
<div class="normalMsg" id="normalMsg"><bean:write name="IssueToPatientRPT" property="strNormalMsg"/></div>
<div class="warningMsg" id="warningMsg"><bean:write name="IssueToPatientRPT" property="strWarningMsg"/></div>

<div class="container-fluid">
	<div class="prescriptionTile">
		<div class='legendHeader' style='font-size: 16px;font-weight: bold;'><i aria-hidden="true" class="fa fa-clipboard"></i> &nbsp;Issue To Patient Department Wise Report</div>
		
		<div class="row ">
			<div class="legend2" id='nonPrintableLegend2'>
				<button type="button" title="Cancel" id="cancelButton" class="float-right btn btn-danger mt-1 btn-icon printbtn" style="border-radius:50%; padding:12px 11px;" onClick="cancelPage();">	
					<div class="popupToast" style="color: #fff;">
						<i class="fas fa-times fa-lg" title="Cancel"></i>
					</div>
				</button>	
				<button type="button" title="Clear" class="float-right btn btn-secondary mt-1 btn-icon clearbtn"  style="background-color: #2196f3; border-radius:50%; padding:12px 7px;" onClick="document.forms[0].reset()">	
					<div class="popupToast" style="color: #fff;">
						<i class="fas fa-broom fa-lg" title="Clear"></i>
					</div>
				</button>
				<button  type="button" title="Generate" id="generatebutton" class="float-right btn btn-success mt-1 btn-icon savebtn" style="border-radius:50%; padding:12px 12px;" tabindex='2' onClick="return validate();"  data-toggle="" data-target="#previewModal" >
					<div class="popupToast" style="color: #fff;">
						<i class="fas fa-download" title="Generate"></i>
					</div>
				</button>
  			</div>  
		</div>
		
		<div class="container">
			<div class="row" style="margin: 1% 12%;">
				<div class="col-sm-2"><label>Store Name<font color="red">*</font></label></div>
				<div class="col-sm-4">
					<select name="strStoreId" class='custom-select' onchange="getItemCatCmb();"> 
						<bean:write name="IssueToPatientRPT" property="strStoreValues" filter="false" />
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
		
			<div class="row " style="margin: 1% 12%;">
				<div class="col-sm-2"><label>From Date<font color="red">*</font> </label></div>
				<div class="col-sm-4">
					<input name="strFromDate" id="datepicker1" class="form-control datepicker1" value="${IssueToPatientRPT.strCurrentDate}" />
				</div>
					
				<div class="col-sm-2"><label>To Date<font color="red">*</font> </label></div>
				<div class="col-sm-4">
					<input name="strToDate" id="datepicker2" class="form-control datepicker2" value="${IssueToPatientRPT.strCurrentDate}" />
				</div>
			</div>
			
			<%-- <div class="row " style="margin: 1% 12%;">
				<div class="col-sm-2 "><label>Report Format<font color="red">*</font></label></div>
				<div class="col-sm-4" >
					<select name="strReportFormat"   class="custom-select" onchange="">
						<option value="html">Html</option>
						<option value="pdf">Pdf</option>
					</select>
				</div>
				
				<div class="col-sm-2 "><label>Footer Required<font color="red">*</font></label></div>
				<div class="col-sm-2 p-2">
				<html:checkbox property="strIsFooter" name="IssueToPatientRPT" value="1"></html:checkbox>
				</div>
			
				<div class="col-sm-2"><label>User Remarks<font color="red">*</font></label></div>
				<div class="col-sm-4">
					<textarea name="strUserRemarks" class="form-control" rows="1"  style="height:38px;" onkeyup="maxLengthRemarks(this,'500')" ></textarea>
				</div> 
			</div>	 --%>
		</div>
					
		<hr>
		
		<div class="row text-right">
	    	<div class="col">
	    		<i class="fas fa-asterisk" style="color: red; font-size: smaller;"></i>Fields Mandatory
	    	</div>
		</div>
		
		<input type="hidden" name="hmode"/>
		<input type="hidden" name="strCurrentDate" value="${IssueToPatientRPT.strCurrentDate}"/>

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