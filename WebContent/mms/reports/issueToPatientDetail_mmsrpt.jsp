<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<%@taglib uri="/WEB-INF/dateTag.tld" prefix="dateTag"%>
<%@ taglib uri="/WEB-INF/hisTab.tld" prefix="tag"%>


<html>
<head>
<title></title>

<link href="../../hisglobal/bootstrap4.0_newgui/css/bootstrap.css" rel="stylesheet" />
<link href="../../hisglobal/bootstrap4.0_newgui/font-awesome/css/all.css" rel="stylesheet">
<link href=".../../css/newlayout.css" rel="stylesheet" type="text/css">
<link href="../../hisglobal/bootstrap4.0_newgui/datetimepicker/css/gijgo.min.css" rel="stylesheet" type="text/css">

<script type="text/javascript" src="../../hisglobal/jquery/3.6.0.min.js"></script>
<script type="text/javascript" src="../../hisglobal/bootstrap4.0_newgui/swAl/swal.js"></script>
<script type="text/javascript" src="../../hisglobal/bootstrap4.0_newgui/js/bootstrap.min.js"></script>
<script type="text/javascript" src="../../hisglobal/bootstrap4.0_newgui/datetimepicker/js/gijgo.min.js"></script>
	
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

<style type="text/css">
body {
	font-family: "Helvetica Neue", Helvetica, Arial, sans-serif;
	font-size: 14px;
	line-height: 1.42857143;
	color: rgba(0, 0, 0, 1);
	font-weight: 501;
}

.table th, .table td {
	padding: 0.05rem;
}

.form-control {
	color: rgba(0, 0, 0, 1);
}

.table {
	width: 100%;
	margin-bottom: 1rem;
	color: rgba(0, 0, 0, 1);
}

.prescriptionTile {
	margin: 0.5% 0;
	border-bottom: 1px solid #d7d7d7;
	padding-bottom: 10px;
	padding: 1% 2% 0.5% 2%;
	background-color: #fff;
	transition: 0.5s;
	box-shadow: 0 0.5px 10px 2px #b0acac;
	border-radius: .25rem;
	color: rgba(0, 0, 0, 1);
}

.subHeaders {
	font-weight: 500 !important;
	font-family: "Helvetica Neue", "Helvetica";
	font-size: 19px !important;
	padding-bottom: 0px !important;
	color: rgba(0, 0, 0, 1);
	margin-bottom: 0;
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

function setBatchOrIssueDetailCheckBox()
{
	if(document.getElementsByName("strConsolidatedOrDetailed")[0].checked)
	{
		document.getElementById("whetherBatchRequiredCheckBoxId").style.display='';
		document.getElementById("onlyIssueDetailRequiredCheckBoxId").style.display='none';
	}
	else
	{
		document.getElementById("whetherBatchRequiredCheckBoxId").style.display='none';
		document.getElementById("onlyIssueDetailRequiredCheckBoxId").style.display='';
	}
}

function validate()
{
 	var hisValidator = new HISValidator("issueToPatientRptBean");
 		
	
	document.forms[0].strStoreName.value = document.forms[0].strStoreId[document.forms[0].strStoreId.selectedIndex].text;
	document.forms[0].strItemCategoryName.value = document.forms[0].strItemCategNo[document.forms[0].strItemCategNo.selectedIndex].text;
	document.forms[0].strCrNo.value = document.forms[0].strCrNo.value;

	hisValidator.addValidation("strCase", "dontselect=0", "Please Select Report Type Combo" );
	
    hisValidator.addValidation("strStoreId", "dontselect=0", "Please Select Store Combo" );
        //hisValidator.addValidation("strItemCategNo", "dontselect=0", "Please Select Item Category Combo" );
        
    if(document.getElementsByName("strByCurrentAndDate")[1].checked==true)
    {
    	hisValidator.addValidation("strFromDate", "date","From Date is a mandatory field");
		hisValidator.addValidation("strToDate", "date","To Date is a mandatory field");
		hisValidator.addValidation("strToDate","dtltet="+document.forms[0].strCurrentDate.value,"Please Select To Date Less Than Current Date ");
		hisValidator.addValidation("strToDate","dtgtet="+document.forms[0].strFromDate.value,"Please Select To Date Greater Than Or Equal To From Date");	
	      }
        var retVal = hisValidator.validate();
        var dd= dateDiff(document.forms[0].strFromDate.value ,document.forms[0].strToDate.value);
    	var dd2 = dd.split(' ')[0];
   	     if( dd2> 365)
   		 {
   		     alert("Time difference couldn't be more than 365 days");
   		      return false;
   		 }
            hisValidator.clearAllValidations(); 
	
	if(retVal)
	{
		document.forms[0].hmode.value = "SHOWRPT";		
		document.forms[0].submit();
	}else{
		return false;
	}
}

function cancelPage(){
	document.forms[0].hmode.value="CANCEL";
	document.forms[0].target = "_self";
	document.forms[0].submit();

}

function getAjaxResponse(res,mode)
{
      var err = document.getElementById("errMsg");
      var temp = res.split("####");
   
       if(temp[0] == "ERROR")
	   {
          	err.innerHTML = temp[1];
          	return;
       } 
       
  	
   if(mode=="1")
   {
        var objVal = document.getElementById("itemCategDIV");
        objVal.innerHTML = "<select name = 'strItemCategNo' class='browser-default custom-select' onchange='getDrugName();'>" + res + "</select>";
		      
     }
   
   if(mode=="2")
   {
        var objVal = document.getElementById("drugNameDivId");
        objVal.innerHTML = " <select name='strItemBrandId'  name='strItemBrandId' onchange='' class='browser-default custom-select'>" + res + "</select>";
         
   }
   
   if (mode == "3") 
   {
		objVal = document.getElementById("PatientIssueRpt");
		objVal.style.display = "block";
		objVal.innerHTML = res;
   }
}

function getItemCateg(){
 	var mode="ITEMCATEGORYCOMBO";
   var url="IssueToPatientDetailRptCNT.cnt?hmode="+mode+"&strId="+document.forms[0].strStoreId.value;
   ajaxFunction(url,"1");
}

function getDrugName()
{
	var mode="DRUGNAMECOMBO";
  	var url="IssueToPatientDetailRptCNT.cnt?hmode="+mode+"&strId="+document.forms[0].strStoreId.value+"&catId="+document.forms[0].strItemCategNo.value;
  	ajaxFunction(url,"2");
}

 function getDrugName1()
 {
 		var mode="DRUGNAMECOMBO";
 		var url="IssueToPatientDetailRptCNT.cnt?hmode="+mode+"&strId="+document.forms[0].strStoreId.value+"&catId="+document.forms[0].strItemCategNo.value;
    	ajaxFunction(url,"2");
 }
 
function setValueChk(){
	if(document.getElementsByName("strCase")[0].checked){
		document.getElementsByName("strCase")[0].value="1";
		document.getElementsByName("strUserRemarks")[0].value="";
		document.getElementsByName("strItemCategNo")[0].value="0";
		document.getElementsByName("strStoreId")[0].value="0";
		
	}else if(document.getElementsByName("strCase")[1].checked){
		document.getElementsByName("strCase")[1].value="2";
		document.getElementsByName("strUserRemarks")[0].value="";
		document.getElementsByName("strItemCategNo")[0].value="0";
		document.getElementsByName("strStoreId")[0].value="0";
	}else{
			document.getElementsByName("strCase")[2].value="3";
			document.getElementsByName("strUserRemarks")[0].value="";
			document.getElementsByName("strItemCategNo")[0].value="0";
			document.getElementsByName("strStoreId")[0].value="0";
	}
}

function onLoadPage()
{
    document.forms[0].reset();	
	document.forms[0].strFromDate.value = document.forms[0].strCurrentDate.value;
	document.forms[0].strToDate.value = document.forms[0].strCurrentDate.value;
	
	document.getElementsByName("strByCurrentAndDate")[0].checked=true;	
	
}

function onClearButton(){

// if((document.getElementsByName("strCase")[0].checked)||(document.getElementsByName("strCase")[1].checked)||
//		(document.getElementsByName("strCase")[2].checked)){
	document.forms[0].strStoreId.value = "0";
	document.forms[0].strItemCategNo.value = "0";
	document.forms[0].strFromDate.value = document.forms[0].strCurrentDate.value;
	document.forms[0].strToDate.value = document.forms[0].strCurrentDate.value;
	document.forms[0].strUserRemarks.value="";
//	}
}

function setDates()
{
	if(document.getElementsByName("strByCurrentAndDate")[0].checked==true)
	{
		document.getElementById("fromDateDivId").style.display='none';
		document.getElementById("toDateDivId").style.display='none';
	}
	else
	{
		document.getElementById("fromDateDivId").style.display='';
		document.getElementById("toDateDivId").style.display='';
	}
}

</script>
</head>

<body onload="onLoadPage();">
<html:form action="/reports/IssueToPatientDetailRptCNT" method="post">
	<div class="errMsg" id="errMsg"><bean:write name="issueToPatientRptBean" property="strErrMsg"/></div>
	<div class="normalMsg" id="normalMsg"><bean:write name="issueToPatientRptBean" property="strNormalMsg"/></div>
	<div class="warningMsg" id="warningMsg"><bean:write name="issueToPatientRptBean" property="strWarningMsg"/></div>
	<br>
		<div class="container">
			<div class="row">
				<div class="prescriptionTile col-sm-12" align="center">

					<div class="row rowFlex reFlex">
						<div class="col-sm-6" style="text-align: initial;">
							<p class="subHeaders">

								<i class="fas fa-file-alt iround"
									style="font-size: 20px; color: #28a745" title="Cancel"></i>
								&nbsp; Patient Issue Report
							</p>
							<!-- <button  type="button" class="btn btn-outline-success mt-1  savebtn" onclick="cancelFunc();">
		                                        <i class="fas fa-file-alt iround"  title="Cancel"></i>
	                                      </button> -->
						</div>
						
						<div class="col-sm-6">
							<div class="legend2" id='nonPrintableLegend2'>
								<button type="button"
									class="float-right btn btn-outline-danger mt-1 btn-circle cancelbtn"
									onclick="cancelFunc();">
									<i class="fas fa-ban iround" title="Cancel"></i>
								</button>
								<button type="button" class=" btn btn-secondary btn-circle"
									onclick="onClearButton();"
									style="background: #b9b9b9; border-color: #b9b9b9; margin-top: 0.25rem !important;">
									<img src="/HIS/hisglobal/images/clear3.png" title="Clear"
										style="width: 23px; color: #fff;">
								</button>

								<button type="button" id="saveid"
									class="float-right btn btn-outline-success mt-1 btn-circle savebtn"
									tabindex='2' onclick='return validate();'>
									<i class="fas fa-download iround" title="Save"></i>
								</button>


							</div>
						</div>
					</div>
					<div class="row" align="right">
					<div class="col-sm-12">
						<html:radio property="strByCurrentAndDate"  name="issueToPatientRptBean" value="1" onclick="setDates();">Current Date</html:radio>
						<html:radio property="strByCurrentAndDate" name="issueToPatientRptBean" value="2" onclick="setDates();">Back Date</html:radio>
					</div>
					</div>

					<div class="row">
						<div class="col-sm-12" align="right">
				             <input type="radio"  name="strConsolidatedOrDetailed"  value="2" checked="checked"    onclick="setBatchOrIssueDetailCheckBox();"/>Issue 
					    	 <input type="radio"  name="strConsolidatedOrDetailed"  value="3"                      onclick="setBatchOrIssueDetailCheckBox();"/>Return
					    	 <input type="radio"  style='display:none;' name="strConsolidatedOrDetailed" value="4" onclick="setBatchOrIssueDetailCheckBox();"/><div style='display:none;'>Net Sale</div>
						    	   	
						</div>
					</div>

					<div class="row">
						<div class="col-sm-3">
							<label><font color="red">*</font>Store Name</label>
						</div>
						<div class="col-sm-3">
							<!-- <select name="strStoreId"  onchange="getItemCateg();" class="browser-default custom-select"> -->
							<select name="strStoreId"  onchange="" class="browser-default custom-select">
				                  <bean:write name="issueToPatientRptBean" property="strStoreVal" filter="false" />
				            </select>
						</div>
						<div class="col-sm-3">
							<label><font color="red">*</font>Category</label>
						</div>
						<div class="col-sm-3">
							<div id="itemCategDIV">
								<select name="strItemCategNo" onchange="getDrugName();" class="browser-default custom-select">
									<bean:write name="issueToPatientRptBean" property="strItemVal" filter="false" />
								</select>
							</div>
						</div>
					</div>
					<div class="row mb-3">
						<div class="col-sm-3">
							<label><font color="red">*</font>Item Name</label>
						</div>
						<div class="col-sm-3">
							<div id="drugNameDivId">								
								 <select name="strItemBrandId"  name="strItemBrandId" onchange="" class="browser-default custom-select">
								   	    <option value="0">All</option>
								 </select>
							</div>
						</div>
						
						<div class="col-sm-3">
							<label><font color="red"></font>CR No</label>
						</div>
						<div class="col-sm-3">
							<input type="text" name="strCrNo" id="strCrNo"  value="${issueToPatientRptBean.strHospCode}" class="form-control" maxlength="15">
						</div>
						
					</div>
				
   					<div class="row" id="fromDateDivId" style="display: none;">
						<div class="col-sm-3">
							<label><font color="red">*</font>Entry Date From</label>
						</div>
						<div class="col-sm-3">
							<input class="form-control" name="strFromDate" id='datepicker'>
						</div>
						<div class="col-sm-3">
							<label><font color="red">*</font>Entry Date To</label>
						</div>
						<div class="col-sm-3">
							<input class="form-control" name="strToDate" id='datepicker1'>
						</div>
					</div>
					
					<table class="TABLEWIDTH" align="center" cellspacing="1px" cellpadding="1px" >   
					<%-- <tr style="display: none;">
						<td width="50%" colspan="2" class="LABEL" >
						<font color="red">*</font>Only Dossier Data
						</td>
						<td width="50%" colspan="2" class="CONTROL">
							<html:checkbox property="isdossier" name="issueToPatientRptBean" value="1"></html:checkbox> 
						</td>
						
					</tr>  --%>
				
					<tr style="display: none;">
						<td width="50%" colspan="2" class="LABEL">
						Footer Required
						</td>
						<td width="50%" colspan="2" class="CONTROL">
						<html:checkbox property="strIsFooter" name="issueToPatientRptBean" value="1"></html:checkbox>
						</td>
					</tr>
				</table>
		<hr>
					<div class="row">
						<div class="col-sm-12" align="right" >
							<font color='red'>*</font>Mandatory Field
						</div>
					</div>
	<!-- <table border="0" class="TABLEWIDTH" align="center" cellspacing="1px" cellpadding="1px">
		<tr>

			<td align="center">
			<img style="cursor: pointer" src="../../hisglobal/images/btn-generate.png" onClick="return validate();" />
			<img style="cursor: pointer" src="../../hisglobal/images/btn-clr.png" onClick="onClearButton();" >
			<img style="cursor: pointer" src="../../hisglobal/images/btn-ccl.png" onClick="cancelFunc();" >
			</td>
			
		</tr>
	</table> -->

			<input type="hidden" name="hmode"/>
			<input type="hidden" name="strCurrentDate" value="${issueToPatientRptBean.strCurrentDate}" />
			<input type="hidden" name="strStoreName" value="${issueToPatientRptBean.strStoreName}" />
			<input type="hidden" name="strItemCategoryName" value="${issueToPatientRptBean.strItemCategoryName}"/>
			<input type="hidden" name="strCrNo" value="${issueToPatientRptBean.strCrNo}"/>

		</div>
	</div>
</div>

</html:form>
<tag:autoIndex></tag:autoIndex>

<script type="text/javascript">
	$('#datepicker').datepicker({uiLibrary: 'bootstrap4',modal: true, header: true, footer: true ,format: 'dd-mmm-yyyy'});
	$('#datepicker1').datepicker({uiLibrary: 'bootstrap4',modal: true, header: true, footer: true ,format: 'dd-mmm-yyyy'});
	var today=new Date();
	var arr=["Jan","Feb","Mar","Apr","May","Jun","Jul","Aug","Sep","Oct","Nov","Dec"];
	var mmm=arr[today.getMonth()];
	var hrs=today.getHours();
	var dd=today.getDate()+"-"+mmm+"-"+today.getFullYear();
	$('#datepicker1').val(dd);
	$('#datepicker').val(dd);
	</script>
</body>
</html>