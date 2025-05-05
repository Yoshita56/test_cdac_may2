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
<title>Import Records Transaction</title>
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
     
     	 
     
            var hisValidator = new HISValidator("importRecordTransBean");
            
                 
          	    hisValidator.addValidation("strTemplate", "dontselect=0", "Please Select a Template Name" );
          	   	hisValidator.addValidation("strExcelFilePath", "req", "Please Select The Excel File");
          	  	hisValidator.addValidation("strExcelFilePath", "pathext=xls", "Please Select The Excel File");
         
          
                      
            var retVal = hisValidator.validate(); 
          	
          	hisValidator.clearAllValidations();
          	
            
          if(retVal){
                   
               
                 	   document.forms[0].hmode.value = "IMPORTRECORDS";
                       document.forms[0].submit();
          }else{
             return false;
          }
}
 

	
function getTemplateDtls(obj)
{ 


	document.forms[0].strTemplateName.value =  document.forms[0].strTemplate[document.forms[0].strTemplate.selectedIndex].text;

	document.getElementById("errMsg").innerHTML = "";

	var val = obj.value.split('^')[0];
	
	if(val == '0'){
	
		document.getElementById("templateDivId").style.display = "none";
	
	}else{
	
   var mode ="GETTEMPLATEDTLS";  
   var url="ImportRecordsTransCNT.cnt?hmode="+mode+"&strTemplateId="+val;
     
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
	
	
	function cancelPage(mode){
	
		document.forms[0].hmode.value = mode;
		document.forms[0].submit();
}


</script>

</head>
<body>
<html:form name="importRecordTransBean"
	action="/transactions/ImportRecordsTransCNT"
	type="mms.transactions.controller.fb.ImportRecordsTransFB" method="post"
	enctype="multipart/form-data">

	<div id="errMsg" class="errMsg"><bean:write
		name="importRecordTransBean" property="strErrorMsg" filter="false" /></div>
	<div id="normalMsg" class="normalMsg"><bean:write
		name="importRecordTransBean" property="strMsg"  filter="false"/></div>
	<div id="warningMsg" class="warningMsg"><bean:write
		name="importRecordTransBean" property="strWarning"  filter="false"/></div>


	<tag:tab tabLabel="Import Records Transaction" selectedTab="FIRST"
		align="center" width="TABLEWIDTH">
	</tag:tab>

	<table class="TABLEWIDTH" align="center" cellpadding="1px"
		cellspacing="1px">
		<tr class="HEADER">
			<td colspan="2"></td>
		</tr>

		<tr>
			<td width="50%" class="LABEL"><font color="red">*</font>Template
			Name</td>
			<td width="50%" class="CONTROL"><select name="strTemplate"
				class="comboMax" onchange="getTemplateDtls(this);">
				<bean:write name="importRecordTransBean"
					property="strTemplateValues" filter="false" />
			</select></td>
		</tr>

	</table>

	<div id="templateDivId" style="display: none;"></div>

	<table class="TABLEWIDTH" align="center" cellpadding="1px"
		cellspacing="1px">

		<tr>
			<td width="50%" class="LABEL"><font color="red">*</font>Excel
			File</td>
			<td class="CONTROL"><html:file name="importRecordTransBean"
				property="strExcelFilePath"></html:file></td>
		</tr>
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
				src="../../hisglobal/images/back_tab.png" title="Cancel Process"
				onClick="cancelPage('CANCELPAGE');" /></td>
		</tr>
	</table>

	<input type="hidden" name="hmode" />
	<input type="hidden" name="strTemplateName" value="" />

</html:form>
<tag:autoIndex></tag:autoIndex>  
</body>
</html>