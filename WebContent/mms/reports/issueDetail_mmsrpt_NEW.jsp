<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<%@taglib uri="/WEB-INF/dateTag.tld" prefix="dateTag"%>
<%@ taglib uri="/WEB-INF/hisTab.tld" prefix="tag"%>


<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title></title>

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

$(function() {	
	 displaySelectedDrug("strItemBrandId");
});

function loadAutocompleteItems()
{
	$('#strSearchDrug').val("");
     displaySelectedDrug("strItemBrandId");
     
     var itemList = [];
	$('#strItemBrandId option').each(function() {
	    itemList.push({ "value" :this.textContent , "data" : this.value });
	});
	
	$('#strSearchDrug').autocomplete({
	   lookup: itemList,
	   minChars:3,
	   onSelect: function (suggestion) {        
	     getDrugNameSelected(suggestion.data, "strItemBrandId");
	     getBatchNo();	     
	   }	    
	 });
	 
	 $('#strSearchDrug').click(function(){	 
	 	$(this).val("");
	 });	
}

function validate(){
 		var hisValidator = new HISValidator("issuedtlRptBean");
 		
        hisValidator.addValidation("strStoreId", "dontselect=-1", "Please Select Store Combo" );
        hisValidator.addValidation("strItemCatId", "dontselect=-1", "Please Select Category " );
        hisValidator.addValidation("strFromDate", "date","From Date is a mandatory field");
		hisValidator.addValidation("strToDate", "date","To Date is a mandatory field");
		//hisValidator.addValidation("strToDate","dtltet="+document.forms[0].strCurrentDate.value,"Please Select To Date Less Than or Equal To Current Date");
		hisValidator.addValidation("strToDate","dtgtet="+document.forms[0].strFromDate.value,"Please Select To Date Greater Than Or Equal To From Date");
        
            var retVal = hisValidator.validate();
            hisValidator.clearAllValidations(); 
   
	
	if(retVal){
		  /* document.forms[0].hmode.value = "SHOWRPT";
		
			if(document.forms[0].strReportFormat[document.forms[0].strReportFormat.selectedIndex].value == "html")
			{
				document.forms[0].target = "_self";
			}else{
				document.forms[0].target = "_blank";
			}
		document.forms[0].submit(); */  
		var mode="SHOWRPTNEW";
		var storeName = document.forms[0].strStoreId.options[document.forms[0].strStoreId.selectedIndex].innerText;
		var categoryName = document.forms[0].strItemCatId.options[document.forms[0].strItemCatId.selectedIndex].innerText;
   		var url="IssueDetailRptCNT_NEW.cnt?hmode="+mode+"&storeId="+document.forms[0].strStoreId.value+"&catId="+document.forms[0].strItemCatId.value
   				+"&fromDate="+document.forms[0].datepicker1.value+"&toDate="+document.forms[0].datepicker2.value+"&storeName="+storeName+
   				"&categoryName="+categoryName;
   		ajaxFunction(url,"6");
		
	}
	else{
		return false;
	}
}	


function validate1(){


if(true){
	document.forms[0].hmode.value = "SHOWRPT1";
	
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
        objVal.innerHTML = "<select name = 'strItemCategNo' class='custom-select' onchange='getDrugName();' >" + res + "</select>";
		getProgName();      
   }
   
   if(mode=="2")
   {
        var objVal = document.getElementById("drugNameDivId");
        objVal.innerHTML = "<select id='strItemBrandId' name='strItemBrandId' class='custom-select' onchange='getBatchNo();' >" + res + "</select>";
       loadAutocompleteItems();		      
   }
   
   if(mode=="3")
   {
   
        var objVal = document.getElementById("ExistingBatchId");
        objVal.innerHTML = "<select name = 'strBatchNo'  class='custom-select'  >" + res + "</select>";
		      
   }
   
   if(mode=="4")
   {			
			var objVal1= document.getElementById("progNameDivId");
			objVal1.innerHTML = "<select id='strProgId' name='strProgId' class='custom-select'>"+res+"</select>";
   }
   if(mode=="5")
   {			
			var objVal1= document.getElementById("ItemNameDivId");
			objVal1.innerHTML = "<select id='strItemCatId' name='strItemCatId' class='custom-select' onchange='getDrugName();'  >"+res+"</select>";
   }
   
   if(mode=="6")
   {		
	    document.getElementById("FMid").style.display="none";
		var voucherDiv= document.getElementById("voucherDivId");
		//console.log(res);
		voucherDiv.innerHTML = res;
		voucherDiv.style.display = "block";
   }
}


function getProgName()
{
		
	    var url ="IssueDetailRptCNT_NEW.cnt?hmode=PROGNAME&storeId="+document.forms[0].strStoreId.value+
		         "&itemcat="+document.forms[0].strStoreId.value;
	    
	    ajaxFunction(url,"4");
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

function onLoadPage(){

	document.forms[0].strFromDate.value = document.forms[0].strCurrentDate.value;
	document.forms[0].strToDate.value = document.forms[0].strCurrentDate.value;
	getDrugName1();
}

function onClearButton(){

if((document.getElementsByName("strCase")[0].checked)||(document.getElementsByName("strCase")[1].checked)||
		(document.getElementsByName("strCase")[2].checked)){
    document.forms[0].reset();
	document.forms[0].strStoreId.value = "0";
	document.forms[0].strItemCategNo.value = "0";
	document.forms[0].strFromDate.value = document.forms[0].strCurrentDate.value;
	document.forms[0].strToDate.value = document.forms[0].strCurrentDate.value;
	displaySelectedDrug("strItemBrandId");
	}
}

 function getDrugName()
{
		var mode="DRUGNAMECOMBO";
   		var url="IssueDetailRptCNT_NEW.cnt?hmode="+mode+"&storeId="+document.forms[0].strStoreId.value+"&catId="+document.forms[0].strItemCatId.value;
   		ajaxFunction(url,"2");
	
	
}

 function getDrugName1()
 {
 		var mode="DRUGNAMECOMBO";
    		var url="IssueDetailRptCNT_NEW.cnt?hmode="+mode+"&storeId="+0+"&catId="+10;
    		ajaxFunction(url,"2");
 	
 	
 }
function getItemCatName()
{
		var mode="ITEMCATEGORYCOMBO";
   		var url="IssueDetailRptCNT_NEW.cnt?hmode="+mode+"&storeId="+document.forms[0].strStoreId.value;  
   		ajaxFunction(url,"5");
	
	
}

function getBatchNo()
{  var mode="EXISTINGBATCH";
    var url="IssueDetailRptCNT_NEW.cnt?hmode="+mode
	 +"&strItemBrandId="+ document.forms[0].strItemBrandId.value 
	 + "&storeId="+ document.forms[0].strStoreId.value+"&catId="+document.forms[0].strItemCatId.value;
	ajaxFunction(url,"3");
   
}
function printReport() {
    document.getElementById("printRptId").style.display = "none";
    
    // Clone the content excluding the last column
    const contentToPrint = document.getElementById("voucherDivId").cloneNode(true);
    


    const newWin = window.open('', '', 'width=700,height=700,scrollbars=yes');
    newWin.document.write('<html><head>');
    newWin.document.write('<title>Issue Detail Report</title>');
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


</script>
</head>

<body class="background" onload=" "><!-- onload="onLoadPage();" commented--> 

<html:form action="/reports/IssueDetailRptCNT_NEW" method="post" styleClass="formbg">
	
<div class="errMsg" id="errMsg"><bean:write name="issuedtlRptBean" property="strErrMsg"/></div>
<div class="normalMsg" id="normalMsg"><bean:write name="issuedtlRptBean" property="strNormalMsg"/></div>
<div class="warningMsg" id="warningMsg"><bean:write name="issuedtlRptBean" property="strWarningMsg"/></div>

<div class="container-fluid">
	<div class="prescriptionTile">
		<div class='legendHeader'><i class="fas fa-file-alt" style="font-size: 20px;"></i>&nbsp; &nbsp;Issue Detail Report</div>
		
		<div class="row ">
			<div class="legend2" id='nonPrintableLegend2'>
				<button type="button" title="Cancel" id="cancelButton" class="float-right btn btn-danger btn-icon printbtn" style="border-radius:50%; padding:12px 14px" onClick="cancelFunc();">	
					<div class="popupToast" style="color: #fff;">
						<i class="fas fa-times" title="Cancel"></i>
					</div>
				</button>	
		
				<button type="button" title="Clear" class="float-right btn btn-secondary btn-icon clearbtn"  style="background-color: #2196f3; border-radius:50%; padding:12px 10px" onClick="onClearButton();">	
					<div class="popupToast" style="color: #fff;">
						<i class="fas fa-broom" title="Clear"></i>
					</div>
				</button>	
				
				<button  type="button" title="Generate" id="generatebutton" class="float-right btn btn-success  btn-icon savebtn" style="border-radius:50%; padding:12px 12px" tabindex='2' onClick="return validate();"  data-toggle="" data-target="#previewModal" >
					<div class="popupToast" style="color: #fff;">
						<i class="fas fa-download" title="Generate"></i>
					</div>
				</button>
				
  			</div>  
		</div>
		
		<div class="container">
			<div class="row"  style="margin: 1% 12%">
				<div class="col-sm-2">Store Name:<font color="red">*</font></div>
				<div class="col-sm-4">
				<select name="strStoreId"  onchange="getItemCatName();" class="custom-select">                   
					<bean:write name="issuedtlRptBean" property="strStoreVal" filter="false" />
				</select>
	            </div>
			                 
				<div class="col-sm-2">Item Category:<font color="red">*</font></div>
				<div class="col-sm-4" id="ItemNameDivId" >
			     	<select name="strItemCatId" class="custom-select" >
						<option value="0">All</option>
					</select>
			    </div>
			</div>
	
			<!-- <div class="row"  style="margin: 1% 12%">
				<div class="col-sm-2">Item Name:<font color="red">*</font></div>
				<div class="col-sm-4">
					<input type="text" id="strSearchDrug" class="form-control" name="strSearchDrug"/>
				</div>
			
				<div class="col-sm-2">Batch No.<font color="red">*</font></div>
				<div class="col-sm-4" id="ExistingBatchId" >
				    <select name="strBatchNo"	class='custom-select' >
						<option value="0">All</option>
				    </select>
			    </div>
			 </div> -->
				
			<!-- <div class="row"  style="margin: 1% 12%">
				<div id="drugNameDivId" style="display: none;">			
					<select id="strItemBrandId" name="strItemBrandId" class='custom-select' onChange='getBatchNo();'>
						<option value="0">All</option>
					</select>
				</div>
			</div> -->
			
			<!--  <div class="row"  style="margin: 1% 12%">	
				<div class="col-sm-2">Selected Item Name<font color="red">*</font></div>
				<div class="col-sm-4">
						<div id="DrugNameId" style="color:blue;font-weight:bold"></div>	
				</div>
				
				<div class="col-sm-2"></div>
				<div class="col-sm-4">
						
				</div>
				
				<div class="col-sm-2 "><label>Report Format<font color="red">*</font></label></div>
				<div class="col-sm-4" >
					<select name="strReportFormat"  class="custom-select" onchange="">
						<option value="html">Html</option>
						<option value="pdf">Pdf</option>
						<option value="xls">Excel</option>
					</select>
				</div>
			</div> -->
							
			<div class="row " style="margin: 1% 12%;">
				<div class="col-sm-2"><label>From Date<font color="red">*</font> </label></div>
				<div class="col-sm-4">
					<input name="strFromDate" id="datepicker1" class="form-control datepicker1" value="${issuedtlRptBean.strCurrentDate}" />
				</div>
		
				<div class="col-sm-2"><label>To Date<font color="red">*</font> </label></div>
				<div class="col-sm-4 ">
					<input name="strToDate" id="datepicker2" class="form-control datepicker2" value="${issuedtlRptBean.strCurrentDate}" />
				</div>
			 </div>
	 
	 
	 		<%-- <div class="row " style="margin: 1% 12%;">
				<div class="col-sm-2"><label>User Remarks<font color="red">*</font></label></div>
				<div class="col-sm-4">
					<input class="form-control" type="text" name="strUserRemarks" >
				</div> 
				
				 <div class="col-sm-2 "><label>Footer Required<font color="red">*</font></label></div>
				<div class="col-sm-4 my-auto">
					<html:checkbox property="strIsFooter" name="issuedtlRptBean" value="1"></html:checkbox>
				</div>
			</div> --%>
<hr>
			<div style="width:100%" align="right" id="FMid">
    			<i class="fas fa-asterisk" style="color: red; font-size: smaller;margin-top: 5px;"></i>Fields Mandatory
    		</div>
			
			<div id="blanket" style="display:none;"></div>
			<div id="voucherDivId" style="display:block;"></div>
<input type="hidden" name="hmode"/>
<input type="hidden" name="strCurrentDate" value="${issuedtlRptBean.strCurrentDate}" />
</div>
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