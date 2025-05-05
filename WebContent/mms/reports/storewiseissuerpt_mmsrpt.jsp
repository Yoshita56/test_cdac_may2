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

		var hisValidator = new HISValidator("storeWiseIssueRpt");

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
				     alert("Time difference couldn't be more than 120 days");
				    retVal= false;
				     }			
	hisValidator.clearAllValidations();
	
	if(retVal)
	{
		document.forms[0].strStoreName.value = document.forms[0].strStoreId[document.forms[0].strStoreId.selectedIndex].text;
		document.forms[0].strItemCatName.value = document.forms[0].strItemCatNo[document.forms[0].strItemCatNo.selectedIndex].text;
		document.forms[0].strRptType.value = document.forms[0].strReqTypeId[document.forms[0].strReqTypeId.selectedIndex].text;

		document.forms[0].hmode.value = "STOREWISEISSUERPT";
		
		document.forms[0].submit();
	}  
	else
	{
			return false;
	}
} 
 


function getItemCatCmb(){ 

		if(document.forms[0].strStoreId.value!=0){
			var url ="StoreWiseIssueRptCNT.cnt?hmode=ITEMCATCMB&storeId="+document.forms[0].strStoreId.value;
	 		ajaxFunction(url,"1");
	 	}else{
		//document.forms[0].strItemCatNo.value="0";
	 		var url ="StoreWiseIssueRptCNT.cnt?hmode=ITEMCATCMB&storeId="+document.forms[0].strStoreId.value;
	 		ajaxFunction(url,"1");	
	}
}
function getReqTypeCmb(){ 
	if(document.forms[0].strStoreId.value!=0 && document.forms[0].strItemCatNo.value!=0 ){
		var url ="StoreWiseIssueRptCNT.cnt?hmode=REQTYPECMB&storeId="+document.forms[0].strStoreId.value+"&catId="+document.forms[0].strItemCatNo.value;
 		ajaxFunction(url,"2");
 	}else{
	//document.forms[0].strItemCatNo.value="0";
 		var url ="StoreWiseIssueRptCNT.cnt?hmode=REQTYPECMB&storeId="+document.forms[0].strStoreId.value+"&catId="+document.forms[0].strItemCatNo.value;
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

</script>

</head>

<body onload="onLoadpage();">
<html:form action="/reports/StoreWiseIssueRptCNT" method="post">
	
<div class="errMsg" id="errMsg"><bean:write name="storeWiseIssueRpt" property="strErrMsg"/></div>
<div class="normalMsg" id="normalMsg"><bean:write name="storeWiseIssueRpt" property="strNormalMsg"/></div>
<div class="warningMsg" id="warningMsg"><bean:write name="storeWiseIssueRpt" property="strWarningMsg"/></div>

<div class="container-fluid">
	<div class="prescriptionTile">
		<div class='legendHeader' style='font-size: 16px;font-weight: bold;'><i aria-hidden="true" class="fa fa-clipboard"></i> &nbsp;Store Wise Issue Report</div>
		
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
		</div>
		
		
	<div class="container">

		<div class="row" style="margin: 1% 10%;">
			<div class="col-sm-2"><label>Store Name<font color="red">*</font></label></div>
			<div class="col-sm-4">
				<select name="strStoreId" class='custom-select' onchange="getItemCatCmb(); getStoreName(this);"> 
					<bean:write name="storeWiseIssueRpt" property="strStoreValues" filter="false" />
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
			<div class="col-sm-2"><label>From Date<font color="red">*</font> </label></div>
			<div class="col-sm-4">
				<input name="strFromDate" id="datepicker1" class="form-control datepicker1" value="${storeWiseIssueRpt.strCurrentDate}" />
			</div>
				
			<div class="col-sm-2"><label>To Date<font color="red">*</font> </label></div>
			<div class="col-sm-4">
				<input name="strToDate" id="datepicker2" class="form-control datepicker2" value="${storeWiseIssueRpt.strCurrentDate}" />
			</div>
	
		</div>
			<div class="row" style="margin: 1% 10%;">
			<div class="col-sm-2 "><label>Request Type<font color="red">*</font></label></div>
			<div  class="col-sm-4" id="reqDivId">
				<select	name="strReqTypeId"  class="custom-select">
					<option value="0">SelectValue</option>
				</select>
			</div>
			<div class="col-sm-2 "></div>
			<div class="col-sm-4 "></div>
		</div>
		
		<!-- 		 added by vipul on 10.05.2021 -->
			<input type="hidden" name="filter" id="filter">
		<!-- 		 ended by vipul on 10.05.2021 -->	

		
		</div>	
	</div>
		
		<hr>
		
		<div class="row text-right">
	    	<div class="col">
	    		<i class="fas fa-asterisk" style="color: red; font-size: smaller;"></i>Fields Mandatory
	    	</div>
		</div>

<input type="hidden" name="hmode"/>
<input type="hidden" name="strCurrentDate" value="${storeWiseIssueRpt.strCurrentDate}"/>

<input type="hidden" name="strStoreName" />
<input type="hidden" name="strItemCatName" />
<input type="hidden" name="strRptType"/>





	
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