<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<%@ taglib uri="/WEB-INF/hisTab.tld" prefix="tag"%>
<%@taglib uri="/WEB-INF/dateTag.tld" prefix="date"%>
<%@ taglib uri="/WEB-INF/comboPersistence.tld" prefix="cmbPers"%>

<html>
<head>
<meta charset=UTF-8">
<title>Export Records Transaction</title>
<link href="../css/master.css" rel="stylesheet" type="text/css">
<link href="../../hisglobal/css/tab.css" rel="stylesheet"
	type="text/css">
<link href="../../hisglobal/css/calendar-tas.css" rel="stylesheet"
	type="text/css">
<link href="../../hisglobal/css/popup.css" rel="stylesheet"
	type="text/css">

<script language="JavaScript"
	src="../../hisglobal/masterutil/js/master.js"></script>
<script language="JavaScript" src="../../hisglobal/js/tab.js"></script>
<script language="JavaScript" src="../../hisglobal/js/calendar.js"></script>
<script language="Javascript" src="../../hisglobal/js/datepicker1.js"></script>
<script language="Javascript" src="../../hisglobal/js/validation.js"></script>
<script language="Javascript" src="../../hisglobal/js/util.js"></script>

<script type="text/javascript">



function validate1(){   
     
            var hisValidator = new HISValidator("exportRecordTransBean");
                             
          	    hisValidator.addValidation("strTemplate", "dontselect=0", "Please Select a Template Name" );
          	    hisValidator.addValidation("strExportType", "dontselect=0", "Please Select an Export Type" );
				hisValidator.addValidation("strXlsColumnIndex", "req", "Column Index is a Mandatory Field" );
				
				var obj = document.getElementsByName("strXlsColumnIndex");
				var len = parseInt(0);
				
				for(var i = 0 ; i <obj.length; i++){
				
					if(obj[i].disabled == false){
						
							len = len + 1;
					}
				
				}
				
				
				hisValidator.addValidation("strXlsColumnIndex", "numltet="+len, "Column Index Value should be Less than or Equal to "+len );
                      
            var retVal = hisValidator.validate(); 
          	
          	hisValidator.clearAllValidations();
          	
          	            
          if(retVal){
          
          	var chkObj = document.getElementsByName("strChkVal");
          	var count = parseInt("0");
          	
          	for( var temp = 0 ; temp < chkObj.length ; temp ++ ){
          	
          		if(chkObj[temp].checked == true){
          		
          			count = count + 1;
          		}
          	
          	}
          	
          	if(count == 0){
          		
          		alert("Atleast one Export Column should be selected");
          		return false;
          		
          	}
          	
          
          
          		var newObj = document.getElementsByName("strXlsColumnIndex");
          			for(var i = 0 ; i <newObj.length; i++){
						
					for(var j = 1; j <= newObj.length - 1; j++){
					
						if(newObj[i].disabled == false && newObj[j].disabled == false){
							
							if(newObj[i].value == 0){
								
								alert("Indexing must be Greater than Zero");
									newObj[i].focus();
									return false;
							}
							
								if( i != j && newObj[i].value == newObj[j].value){
								
									alert("Duplicate indexing is not Allowed");
									newObj[j].focus();
									return false;
									
								}
								
						}
					}	
				
				}
				
				
				document.forms[0].strReportName.value = document.forms[0].strTemplate[document.forms[0].strTemplate.selectedIndex].text;
				
				document.forms[0].target = "_blank";
			document.forms[0].hmode.value = "EXPORTRECORDS";
			document.forms[0].submit(); 
			
          }else{
             return false;
          }
}
 


function displayFooterDtls(obj)
{ 

	var val = obj.value;
	
	if(val == '2' || val == '3'){
	
		document.getElementById("footerDivId").style.display = "block";
	
	}else{
	
		document.getElementById("footerDivId").style.display = "none";
  
  }
}

	
function getTemplateDtls(obj)
{ 

	var val = obj.value.split('^')[0];
	
	if(val == '0'){
	
		document.getElementById("templateDivId").style.display = "none";
		
	}else{
	  	
	
   var mode ="GETTEMPLATEDTLS";  
   var url="ExportRecordsTransCNT.cnt?hmode="+mode+"&strTemplateId="+val;
     
   ajaxFunction(url,"1");
  }
}
	
	function getAjaxResponse(res,mode){
				
				if(mode=="1"){		
					var objVal= document.getElementById("templateDivId");
					objVal.innerHTML = res;
					
					document.getElementById("templateDivId").style.display = "block";
					
			}
			 
		}
	
	
	function cancelPage(mode)
	{
	    document.forms[0].reset();
	    document.getElementById("templateDivId").innerHTML="";
		//document.forms[0].hmode.value = mode;
		//document.forms[0].submit();
}

function cancelPage1(mode)
{
		document.forms[0].hmode.value = mode;
		document.forms[0].submit();
}


function enableValues(obj , index){

	if(obj.checked == true){
	
		document.getElementById("strOutParamName"+index).disabled = false;
		document.getElementById("strXlsColumnIndex"+index).value = "";
		document.getElementById("strXlsColumnIndex"+index).disabled = false;
		document.getElementById("strXlsColumnName"+index).disabled = false;
		document.getElementById("strOutConstantValue"+index).disabled = false;
		document.getElementById("strIsGrandTotal"+index).checked = false;
		document.getElementById("strIsGrandTotal"+index).disabled = false;
		document.getElementById("strGrandTotalStatus"+index).disabled = false;
		document.getElementById("strColumnWidth"+index).disabled = false;
		document.getElementById("strColumnWidthUnit"+index).disabled = false;
	
	
	
		var obj = document.getElementsByName("strXlsColumnIndex");
	var indexVal = parseInt("0");
	for(var i = 0 ; i <obj.length; i++){
				
					if(obj[i].disabled == false){
						
						indexVal = indexVal + 1;
						
						 obj[i].value = indexVal;
					}
				
				}
	
	
	}else{
	
		document.getElementById("strOutParamName"+index).disabled = true;
		document.getElementById("strXlsColumnIndex"+index).value = "0";
		document.getElementById("strXlsColumnIndex"+index).disabled = true;
		document.getElementById("strXlsColumnName"+index).disabled = true;
		document.getElementById("strOutConstantValue"+index).disabled = true;
		document.getElementById("strIsGrandTotal"+index).checked = false;
		document.getElementById("strIsGrandTotal"+index).disabled = true;
		document.getElementById("strGrandTotalStatus"+index).disabled = true;
		document.getElementById("strColumnWidth"+index).disabled = true;
		document.getElementById("strColumnWidthUnit"+index).disabled = true;
	
		var obj = document.getElementsByName("strXlsColumnIndex");
	var indexVal = parseInt("0");
	for(var i = 0 ; i <obj.length; i++){
				
					if(obj[i].disabled == false){
						
						indexVal = indexVal + 1;
						
						 obj[i].value = indexVal;
					}
				
				}
	
	}

}

function changeGrandTotalStatus(obj , index){

	if(obj.checked == true){
		
			document.getElementById("strGrandTotalStatus"+index).value = 1;
			
	}else{
	
		document.getElementById("strGrandTotalStatus"+index).value = 0;
	
	}

}

 /**
	  * showView
	  * @param {String} divId 
	  */
	  function showView(divId) 
	  {
	  	
	  	document.getElementById(divId+"PlusId").style.display = "none";
	  	document.getElementById(divId+"MinusId").style.display = "block";
	  	
	  	document.getElementById(divId).style.display = "block";
	  	
	  }
	 	 
	 	 
	 /**
	  * hideView
	  * @param {String} divId 
	  */
	  function hideView(divId) {
	  	
	  	document.getElementById(divId+"PlusId").style.display = "block";
	  	document.getElementById(divId+"MinusId").style.display = "none";
	  	
	  	document.getElementById(divId).style.display = "none";
	  	
	  }	 

</script>

</head>
<body>
<html:form name="exportRecordTransBean"
	action="/transactions/ExportRecordsTransCNT"
	type="mms.transactions.controller.fb.ExportRecordsTransFB"
	method="post" enctype="multipart/form-data">

	<div id="errMsg" class="errMsg"><bean:write
		name="exportRecordTransBean" property="strErrorMsg" /></div>
	<div id="normalMsg" class="normalMsg"><bean:write
		name="exportRecordTransBean" property="strMsg" /></div>
	<div id="warningMsg" class="warningMsg"><bean:write
		name="exportRecordTransBean" property="strWarning" /></div>


	<tag:tab tabLabel="Export Report" selectedTab="FIRST"
		align="center" width="TABLEWIDTH">
	</tag:tab>

	<table class="TABLEWIDTH" align="center" cellpadding="1px"
		cellspacing="1px">
		<tr class="HEADER">
			<td colspan="2"></td>
		</tr>

		<tr>
			<td width="50%" class="LABEL"><font color="red">*</font>Report Name</td>
			<td width="50%" class="CONTROL"><select name="strTemplate"
				class="comboMax" onchange="getTemplateDtls(this);">
				<bean:write name="exportRecordTransBean"
					property="strTemplateValues" filter="false" />
			</select></td>
		</tr>
	</table>
	
	
	
	    <div id="templateDivId"></div>
	
	
	<table class="TABLEWIDTH" align="center" cellpadding="1px"
		cellspacing="1px">
		<tr>
			<td width="50%" class="LABEL"><font color="red">*</font>Export
			Type</td>
			<td width="50%" class="CONTROL"><select name="strExportType"
				class="comboMax" onchange="displayFooterDtls(this);">
				<option value="0">Select Value</option>
				<option value="1">Excel</option>
				<option value="2">Html</option>
				<option value="3">Pdf</option>
			</select></td>
		</tr>
	</table>
	<div id="footerDivId" style="display: none;">
	<table class="TABLEWIDTH" align="center" cellpadding="1px"
		cellspacing="1px">
		<tr>
			<td width="50%" class="LABEL">Footer</td>
			<td width="50%" class="CONTROL"><input type="text"
				class="txtFldMax" name="strFooter" maxlength="100"></td>
		</tr>
	</table>
	</div>

	<table class="TABLEWIDTH" align="center" cellpadding="1px"
		cellspacing="1px">

		<tr class="FOOTER">
			<td colspan="2"><font size="2" color="red">*</font> Mandatory
			Fields</td>
		</tr>
	</table>

	<table border="0" class="TABLEWIDTH" align="center" cellpadding="1px"
		cellspacing="1px">
		<tr>

			<td align="center"><img style="cursor: pointer; "
				src="../../hisglobal/images/btn-ok.png" title="Delete Record"
				onClick=" return validate1();" /> <img
				style="cursor: pointer; "
				src="../../hisglobal/images/btn-clr.png" title="Reset Content"
				onClick="cancelPage('CLEAR');" /> <img
				style="cursor: pointer; "
				src="../../hisglobal/images/btn-ccl.png" title="Cancel Process"
				onClick="cancelPage1('CANCELPAGE');" /></td>
		</tr>
	</table>

	<input type="hidden" name="hmode" />
 <input type="hidden" name="strReportName" value='' />
	

</html:form>
<tag:autoIndex></tag:autoIndex> 
<body>

</body>
</html>