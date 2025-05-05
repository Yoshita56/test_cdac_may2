
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

<!-- <script language="Javascript" src="../../hisglobal/js/commonFunctions.js"></script>
<script language="Javascript" src="../../hisglobal/js/time.js"></script> -->

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

<style>
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

 		var hisValidator = new HISValidator("issueRptBean");
 		
        hisValidator.addValidation("strStoreId", "dontselect=0", "Please Select Store Combo" );
        //hisValidator.addValidation("strItemCategNo", "dontselect=0", "Please Select Item Category Combo" );
        hisValidator.addValidation("strFromDate", "date","From Date is a mandatory field");
		hisValidator.addValidation("strToDate", "date","To Date is a mandatory field");
		hisValidator.addValidation("strToDate","dtltet="+document.forms[0].strCurrentDate.value,"Please Select To Date Less Than or Equal To Current Date");
		hisValidator.addValidation("strToDate","dtgtet="+document.forms[0].strFromDate.value,"Please Select To Date Greater Than Or Equal To From Date");
        
            var retVal = hisValidator.validate();
            var dd= dateDiff(document.forms[0].strFromDate.value ,document.forms[0].strToDate.value);
        	// alert(dd);
        	var dd2 = dd.split(' ')[0];
        		     /*if( dd2> 30)
        			     {
        			     alert("Time difference couldn't be more than 30 days");
        			    retVal= false;
        			     }*/
        		
            hisValidator.clearAllValidations(); 
   
	/* if(retVal){
		document.forms[0].hmode.value = "SHOWRPT";
		
			if(document.forms[0].strReportFormat[document.forms[0].strReportFormat.selectedIndex].value == "html")
			{
				document.forms[0].target = "_self";
			}else{
				document.forms[0].target = "_blank";
			}
		document.forms[0].submit();
		} */
	if(retVal){
    	var hmode = "SHOWRPTNEW"; 
    	var url = "IssueDetailRptCNT.cnt?hmode="+hmode+
    	//strToDate,strFromDate,strItemBrandId,strItemCategNo,strStoreId
    	"&storeId="+document.forms[0].strStoreId[document.forms[0].strStoreId.selectedIndex].value+
    	"&strItemCategNo="+document.forms[0].strItemCategNo[document.forms[0].strItemCategNo.selectedIndex].value.split('^')[0]+
    	
    	"&strItemBrandId="+document.forms[0].strItemBrandId[document.forms[0].strItemBrandId.selectedIndex].value+
    	
    	"&strFromDate="+document.forms[0].strFromDate.value+
    	"&strToDate="+document.forms[0].strToDate.value+
    	
    	"&storeName="+document.forms[0].strStoreId[document.forms[0].strStoreId.selectedIndex].text+
    	
    	"&itemName="+document.forms[0].strItemCategNo[document.forms[0].strItemCategNo.selectedIndex].text.split('^')[0]+
    	"&itemBrandName="+document.forms[0].strItemBrandId[document.forms[0].strItemBrandId.selectedIndex].text;
    	
    	ajaxFunction(url,"4");
    }
	else{
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
		      
   }
   
   if(mode=="2")
   {
        var objVal = document.getElementById("drugNameDivId");
        objVal.innerHTML = "<select name = 'strItemBrandId' class='custom-select'   onchange='getBatchNo();' >" + res + "</select>";
		      
   }
   
   if(mode=="3")
   {
   	//alert("res"+res);
        var objVal = document.getElementById("ExistingBatchId");
        objVal.innerHTML = "<select name = 'strBatchNo' class='custom-select'  >" + res + "</select>";
		      
   }
   if(mode=="4")
   {
	   objVal = document.getElementById("AckReport");
		objVal.style.display = "block";
		var x = document.getElementById("myDIV");
		var y = document.getElementById("myDIV1");
		x.style.display = "none";
		y.style.display = "none";
		objVal.innerHTML = res;
	   document.getElementById("strStoreId").disabled = true;
	   document.getElementById("datepicker1").disabled = true;
	   document.getElementById("datepicker2").disabled = true; 
	   document.getElementById("drugNameDivId").getElementsByTagName("select")[0].disabled = true;
	    document.getElementById("itemCategDIV").getElementsByTagName("select")[0].disabled = true;
   }   
     
}



function getItemCateg(){
 	var mode="ITEMCATEGORYCOMBO";
   var url="IssueDetailRptCNT.cnt?hmode="+mode+"&strId="+document.forms[0].strStoreId.value;
   ajaxFunction(url,"1");
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

	document.forms[0].strStoreId.value = "0";
	document.forms[0].strFromDate.value = document.forms[0].strCurrentDate.value;
	document.forms[0].strToDate.value = document.forms[0].strCurrentDate.value;
}

function onClearButton(){
	document.forms[0].hmode.value="unspecified";
	document.forms[0].submit();

}

function getDrugName()
{
	if(document.forms[0].strItemCategNo.value == "0")
	{
		document.forms[0].strItemBrandId.innerHTML = "<option value='0'>Select Value</option>";
		document.forms[0].strBatchNo.innerHTML = "<option value='0'>All</option>";
	}
	else
	{
		var mode="DRUGNAMECOMBO";
   		var url="IssueDetailRptCNT.cnt?hmode="+mode+"&catCode="+document.forms[0].strItemCategNo.value;
   		ajaxFunction(url,"2");
	}
	
}


function getBatchNo()
{
	var mode="EXISTINGBATCH";
   var url="IssueDetailRptCNT.cnt?hmode="+mode
	+"&strItemBrandId="+ document.forms[0].strItemBrandId.value 
	+ "&storeId="+ document.forms[0].strStoreId.value;
	
   ajaxFunction(url,"3");
   
}

function printReport() {
    document.getElementById("printRptId").style.display = "none";
    
    // Clone the content excluding the last column
    const contentToPrint = document.getElementById("AckReport").cloneNode(true);
    


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

</script>

</head>

<body onload="onLoadPage();">
<html:form action="/reports/IssueDetailRptCNT" method="post">
	
<div class="errMsg" id="errMsg"><bean:write name="issueRptBean" property="strErrMsg"/></div>
<div class="normalMsg" id="normalMsg"><bean:write name="issueRptBean" property="strNormalMsg"/></div>
<div class="warningMsg" id="warningMsg"><bean:write name="issueRptBean" property="strWarningMsg"/></div>
	
<div class="container-fluid">
	<div class="prescriptionTile">
		<div class='legendHeader' style='font-size: 16px;font-weight: bold;'>
		<i aria-hidden="true" class="fa fa-clipboard"></i> &nbsp;Issue Detail
		</div>

		<div class="row " style="display: none;">
			<div class="col" ><label>Store Name<font color="red">*</font></label></div>
			<div class="col" >
				<html:radio property="strCase" name="issueRptBean" value="1" onclick="setValueChk();">Issuing Store</html:radio>
			</div>
						
			<div class="col" ><label>Hospital name<font color="red">*</font></label></div>
			<div class="col" >
				<select name="strHospCode" class="custom-select">
					<bean:write name="issueRptBean" property="strHospNameValues" filter="false"/>
				</select>		
			</div>
		</div>
		
		<div class="row ">
			<div class="legend2" id='nonPrintableLegend2'>
				<button type="button" title="Cancel" id="cancelButton" class="float-right btn btn-danger mt-1 btn-icon printbtn" style="border-radius:50%; padding:12px 11px;" onClick="cancelFunc();">	
					<div class="popupToast" style="color: #fff;">
						<i class="fas fa-times fa-lg" title="Cancel"></i>
					</div>
				</button>
				
				<button type="button" title="Clear" class="float-right btn btn-secondary mt-1 btn-icon clearbtn" style="background-color: #2196f3; border-radius:50%; padding:12px 7px;" onClick="onClearButton();">	
					<div class="popupToast" style="color: #fff;">
						<i class="fas fa-broom fa-lg" title="Clear"></i>
					</div>
				</button>	
				
				<button  type="button" title="Generate" id="generatebutton" class="float-right btn btn-success mt-1 btn-icon savebtn"  style="border-radius:50%; padding:12px 12px;" tabindex='2' onClick="return validate();"  data-toggle="" data-target="#previewModal" >
					<div class="popupToast" style="color: #fff;">
						<i class="fas fa-download" title="Generate"></i>
					</div>
				</button>
  			</div>  
		</div>
		
		<div class="container">
			<div class="row " style="margin: 1% 12%;">
				<div class="col-sm-2"><label>Store Name<font color="red">*</font></label></div>
				<div class="col-sm-4">
					<select id="strStoreId" name="strStoreId" class='custom-select' onchange="getItemCateg();"> 
						<bean:write name="issueRptBean" property="strStoreVal" filter="false" />
					</select>
				</div>
	
				<div class="col-sm-2"><label>Category<font color="red">*</font></label></div>
				<div class="col-sm-4" id="itemCategDIV">
					<select id="strItemCategNo" name="strItemCategNo"   class="custom-select" onchange="getDrugName();">
						<bean:write name="issueRptBean" property="strItemCategCmb" filter="false" />
					</select>		
				</div> 
			</div>
				
			<div class="row " style="margin: 1% 12%;">
				<div class="col-sm-2"><label>Drug Name<font color="red">*</font></label></div>
				<div  class="col-sm-4" id="drugNameDivId">
					<select id="strItemBrandId"	name="strItemBrandId"  class="custom-select" onChange='getBatchNo();'>
						<option value="0">All</option>
					</select>
				</div>
			</div>
	
			<div class="row " style="display: none;">
				<div class="col" ><label>Batch No.<font color="red">*</font></label></div>
				<div class="col" id="ExistingBatchId" >
	 				<select name="strBatchNo"	class='custom-select' >
						<option value="0">All</option>
				    </select>			
				</div>
			</div>
			
			<div class="row " style="margin: 1% 12%;">
				<div class="col-sm-2"><label>From Date<font color="red">*</font> </label></div>
				<div class="col-sm-4">
					<input name="strFromDate" id="datepicker1" class="form-control datepicker1" value="${issueRptBean.strCurrentDate}" />
				</div>
			
				<div class="col-sm-2"><label>To Date<font color="red">*</font> </label></div>
				<div class="col-sm-4">
					<input name="strToDate" id="datepicker2" class="form-control datepicker2" value="${issueRptBean.strCurrentDate}" />
	 			</div>
			</div>	
			
			<%-- <div class="row " style="margin: 1% 12%;">
				<div class="col-sm-2 "><label>Footer Required<font color="red">*</font></label></div>
				<div class="col-sm-2 p-2">
					<html:checkbox property="strIsFooter" name="issueRptBean" value="1"></html:checkbox>
				</div>
				
			    <div class="col-sm-2 "><label>Report Format<font color="red">*</font></label></div>
				<div class="col-sm-4">
					<select name="strReportFormat"  class="custom-select" onChange="">
						<option value="html">HTML</option>
						<option value="pdf">PDF</option>
						<option value="xls">EXCEL</option>
				    </select>		
				</div>
				 
				<div class="col-sm-2"><label>User Remarks<font color="red">*</font></label></div>
				<div class="col-sm-4">
					<textarea name="strUserRemarks" class="form-control" rows="1"  style="height:38px;" onkeyup="maxLengthRemarks(this,'500')" ></textarea>
				</div>
			</div> --%>
		</div>		
					
			<hr id='hr4' style="display: none;"><hr>
		<div class="col-sm-12" id="myDIV" align="center">
    		<label><font color="red">We keep a record here for Issue details.</font></label>
    	</div>
	    	
    	<div align="center" id="AckReport"></div>
    	
    	
 		<hr id='hr4' style="display: none;"><hr>
			
		<div class="col-sm-12" align="right" id="myDIV1">
    		<i class="fas fa-asterisk" style="color: red; font-size: smaller;margin-top: 5px;"></i>Fields Mandatory
    	</div>
	</div>
	</div>	
	
<input type="hidden" name="hmode"/>
<input type="hidden" name="strCurrentDate" value="${issueRptBean.strCurrentDate}" />

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