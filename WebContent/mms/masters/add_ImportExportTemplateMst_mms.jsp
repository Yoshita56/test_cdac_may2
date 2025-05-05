<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<%@ taglib uri="/WEB-INF/hisTab.tld" prefix="tag"%>
<%@taglib uri="/WEB-INF/dateTag.tld" prefix="date"%>
<%@ taglib uri="/WEB-INF/comboPersistence.tld" prefix="cmbPers" %>

<html>
<head>
<meta charset=utf-8>
<title>Import Export Template Master</title>
<link href="../css/master.css" rel="stylesheet" type="text/css">
<link href="../../hisglobal/css/tab.css" rel="stylesheet" type="text/css">
<link href="../../hisglobal/css/calendar-tas.css" rel="stylesheet" type="text/css">
<link href="../../hisglobal/css/popup.css" rel="stylesheet" type="text/css">	
	
<script language="JavaScript" src="../../hisglobal/masterutil/js/master.js"></script>
<script language="JavaScript" src="../../hisglobal/js/tab.js"></script>
<script language="JavaScript" src="../../hisglobal/js/calendar.js"></script>
<script language="Javascript" src="../../hisglobal/js/datepicker1.js"></script>
<script language="Javascript" src="../../hisglobal/js/validation.js"></script>
<script language="Javascript" src="../../hisglobal/js/util.js"></script>

<script language ="javaScript">

function validate1(){   
     
     	 
     
            var hisValidator = new HISValidator("impexpTemplateMstBean");
            
          if(document.forms[0].strTemplate[document.forms[0].strTemplate.selectedIndex].value == '0'){
          
          	  hisValidator.addValidation("strProcedure", "dontselect=0", "Please Select a Procedure Name" );
          	  
          	  if(document.getElementsByName("strTemplateType")[0].checked){
          	  
          	  	hisValidator.addValidation("strExcelFilePath", "req", "Please Select The Excel File");
          	  	hisValidator.addValidation("strExcelFilePath", "pathext=xls", "Please Select The Excel File");
          	  	
          	  	
          	  }
          	  
          } 
          
                      
            var retVal = hisValidator.validate(); 
          	
          	hisValidator.clearAllValidations();
          	
            
          if(retVal){
                 	   document.forms[0].hmode.value = "PARAMAPPING";
                       document.forms[0].submit();
          }else{
             return false;
          }
}
 
	function displayDetails(obj){
	
		if(obj.value == '0'){
		
			document.getElementById("oldTemplateDivId").style.display = "none"
			document.getElementById("newTemplateDivId").style.display = "block"
		
		
		}else{
		
			var temp = obj.value.split('^');
		
			document.getElementById("procDivId").innerHTML = temp[1];
			//document.getElementById("tempTypeDivId").innerHTML = temp[3];
			
			
			if(temp[2] == '1'){
			
				document.forms[0].strTemplateType[0].checked = true;
			
			}else{
			
				document.forms[0].strTemplateType[1].checked = true;
			
			}
			
			
		
			document.getElementById("oldTemplateDivId").style.display = "block"
			document.getElementById("newTemplateDivId").style.display = "none"
		
		getTemplateDtls(temp[0] , temp[2]);
		
		}
	
	}
	
	
	
function getTemplateDtls(templateId , templateType)
{ 
   var mode ="GETTEMPLATEDTLS";  
   var url="ImportExportTemplateMstCNT.cnt?hmode="+mode+"&strTemplateId="+templateId+"&strTemplateType="+templateType;
     
   ajaxFunction(url,"1");
  
}
	
		
function getTemplateList(templateType)
{ 
   var mode ="GETTEMPLATELIST";  
   var url="ImportExportTemplateMstCNT.cnt?hmode="+mode+"&strTemplateType="+templateType;
   ajaxFunction(url,"2");
  
}
	
	
		
function getProcedureList( templateType)
{ 
   var mode ="GETPROCLIST";  
   var url="ImportExportTemplateMstCNT.cnt?hmode="+mode+"&strTemplateType="+templateType;
   
   ajaxFunction(url,"3");
  
}
	
	
	
	function getAjaxResponse(res,mode){
				
				if(mode=="1"){		
					var objVal= document.getElementById("paramDetailsDivId");
					objVal.innerHTML = res;
					
			}
			
			
			if(mode=="2"){		
					var objVal= document.getElementById("strTemplateDivId");
					objVal.innerHTML = "<select name='strTemplate' class='comboMax' onchange='displayDetails(this);'>"+res+"</select>";
					
					getProcedureList(gblval );
					
			}
			
			if(mode=="3"){		
					var objVal= document.getElementById("strProcedureDivId");
					
					objVal.innerHTML = "<select name='strProcedure' class='comboMax' >"+res+"</select>";
					
			}
			
			
		}
	
	
	function deleteDetails(){
	
			var conf = confirm("Template will be Deleted, Are You Sure");
	
			if(conf){
				 document.forms[0].hmode.value = "DELETETEMPLATE";
         		 document.forms[0].submit();
			}else{
				return false;
			}
			
	}
	
	var gblval = "";
	
	function excelFileVisibility(obj){
	
	
	document.getElementById("oldTemplateDivId").style.display = "none"
	document.getElementById("newTemplateDivId").style.display = "block"
	
		
		if(obj.value == '1'){
		
			document.getElementById("excelFileDivId").style.display = "block"
		
		}else{
			document.getElementById("excelFileDivId").style.display = "none"
		}
	
	gblval = obj.value;
	
	getTemplateList(obj.value);
	
	}
	

function cancelPage(mode){
	
		document.forms[0].hmode.value = mode;
		document.forms[0].submit();
}

</script>
</head>
<body >
<html:form name="impexpTemplateMstBean" action="/masters/ImportExportTemplateMstCNT" type="mms.masters.controller.fb.ImportExportTemplateMstFB" method="post" enctype="multipart/form-data">
 	
 	<div id="errMsg" class="errMsg"><bean:write name="impexpTemplateMstBean" property="strErrorMsg"/></div>
	<div id="normalMsg" class="normalMsg"><bean:write name="impexpTemplateMstBean" property="strMsg"/></div>
	<div id="warningMsg" class="warningMsg"><bean:write name="impexpTemplateMstBean" property="strWarning"/></div>
	

	<tag:tab tabLabel="Import Export Template Master" selectedTab="FIRST" align="center" width="TABLEWIDTH">
              </tag:tab>

	<table class="TABLEWIDTH" align="center" cellpadding="1px"
         cellspacing="1px">   
	<tr class="HEADER">
			<td colspan="2">Import Export Template Master&gt;&gt; Add</td>
		</tr>
		 <tr>
			<td width="50%" class="LABEL">
			Template Type
			</td>
			<td width="50%" class="CONTROL">
			
			<html:radio name="impexpTemplateMstBean" property="strTemplateType" value="1" onclick="excelFileVisibility(this);">Import</html:radio>
			<html:radio name="impexpTemplateMstBean" property="strTemplateType" value="2" onclick="excelFileVisibility(this);" >Export</html:radio>
			
			</td>
		</tr>
		<tr>
			<td width="50%" class="LABEL">
			 Template Name
			</td>
			<td width="50%" class="CONTROL">
			<div id="strTemplateDivId">
			<select name="strTemplate" class="comboMax" onchange="displayDetails(this);">
			<bean:write name="impexpTemplateMstBean" property="strTemplateValues" filter="false" />
			</select>
			</div>
			</td>
		</tr>
		</table>
		<div id="newTemplateDivId">
		<table border="0" class="TABLEWIDTH" align="center" cellpadding="1px"
         cellspacing="1px">
		<tr>
			<td width="50%" class="LABEL">
			<font color="red">*</font>Procedure Name
			</td>
			<td width="50%" class="CONTROL">
			<div id="strProcedureDivId">
			<select name="strProcedure" class="comboMax"> 
				<bean:write name="impexpTemplateMstBean" property="strProcedureValues" filter="false"/>
			</select>
			</div>
			</td> </tr>
			
			</table>
			
	<div id="excelFileDivId" >
			
	<table border="0" class="TABLEWIDTH" align="center" cellpadding="1px"
         cellspacing="1px">
	

						
	<tr>
			<td width="50%" class="LABEL">
			<font color="red">*</font>Excel File
			</td>
			<td  class="CONTROL">
			<html:file name="impexpTemplateMstBean" property="strExcelFilePath"></html:file>
			</td>
		</tr>
	 
</table>

</div>

	<table border="0" class="TABLEWIDTH" align="center" cellpadding="1px"
         cellspacing="1px">
		 			
		<tr class="FOOTER">
			 <td colspan="2"><font size="2" color="red">*</font> Mandatory Fields  </td>
		</tr>
	</table>
	<table border="0" class="TABLEWIDTH" align="center" cellpadding="1px"
         cellspacing="1px">
		<tr>

			<td align="center">
			<img style="cursor: pointer; " src="../../hisglobal/images/btn-next.png" title="Save Record" onClick=" return validate1();"/> 
			<img style="cursor: pointer; " src="../../hisglobal/images/btn-clr.png" title="Reset Content" onClick="cancelPage('CLEAR');"/>
			<img style="cursor: pointer; " src="../../hisglobal/images/btn-ccl.png" title="Cancel Process" onClick="cancelPage('CANCELPAGE');"/>
			
			</td>
		</tr>
	</table>
		
		
		</div>
		
			<div id="oldTemplateDivId" style="display: none;">
			
			<table border="0" class="TABLEWIDTH" align="center" cellpadding="1px"
         cellspacing="1px">
          
		<tr>
			<td width="50%" class="LABEL">
			 Procedure Name
			</td>
			<td width="50%" class="CONTROL">
			 <div id="procDivId"></div>
			</td>
		</tr>
		 			
	</table>
		
	<div id="paramDetailsDivId"></div>
	<table border="0" class="TABLEWIDTH" align="center" cellpadding="1px"
         cellspacing="1px">
	<tr class="FOOTER">
			 <td colspan="2"><font size="2" color="red">*</font> Mandatory Fields  </td>
		</tr>
	</table>
	
	<table border="0" class="TABLEWIDTH" align="center" cellpadding="1px"
         cellspacing="1px">
		<tr>

			<td align="center">
			<img style="cursor: pointer; " src="../../hisglobal/images/btn-del.png" title="Delete Record" onClick=" return deleteDetails();"/> 
			<img style="cursor: pointer; " src="../../hisglobal/images/btn-clr.png" title="Reset Content" onClick="cancelPage('CLEAR');"/>
			<img style="cursor: pointer; " src="../../hisglobal/images/btn-ccl.png" title="Cancel Process" onClick="cancelPage('CANCELPAGE');"/>
			
			</td>
		</tr>
	</table>
			
			
			</div>
		
	
	
<input type="hidden" name="hmode"/>
</html:form>
<tag:autoIndex></tag:autoIndex>
</body>
</html>