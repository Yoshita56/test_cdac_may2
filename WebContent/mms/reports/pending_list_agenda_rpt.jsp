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

<link href="../../hisglobal/css/popup.css" rel="stylesheet" type="text/css">	
	
<script language="JavaScript" src="../../masterutil/js/master.js"></script>
<script language="JavaScript" src="../../hisglobal/js/tab.js"></script>
<script language="JavaScript" src="../../hisglobal/js/calendar.js"></script>
<script language="Javascript" src="../../hisglobal/js/validation.js"></script>
<script language="Javascript" src="../../hisglobal/js/util.js"></script>
<script type="text/javascript">

function validate(){

	var hisValidator = new HISValidator("pendingListAgendaRpt");
	
		hisValidator.addValidation("strStoreId", "dontselect=0","Select Store Name from Store Combo ");
		hisValidator.addValidation("strCategoryNo", "dontselect=0","Select Item Category from Item Category Combo ");
		
		var retVal = hisValidator.validate();
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

function onLoadPage(){
		document.forms[0].strStoreId.value="0";
		document.forms[0].strCategoryNo.value="0";

	}
	
function cancelPage(){
	document.forms[0].hmode.value="CANCEL";
	document.forms[0].target = "_self";
	document.forms[0].submit();

}


// This function is used to call the CATEGORY cnt action which populates the value of category combo box

function getCategoryCombo()
{
	 //alert("getCategoryCombo calling ");
	var url;
	var mode = "CATEGORYNAME";
	url="PendingListAgendaRptCNT.cnt?hmode="+mode+"&storeComboId="+document.forms[0].strStoreId.value;
 	ajaxFunction(url,"1");

}


function getAjaxResponse(res,mode)
	{
	
	
	var objVal;
	// alert(res+"mode==="+mode);
	var err = document.getElementById("errMsg");
		 	var temp1 = res.split("####");
			         
        	 if(temp1[0] == "ERROR"){
         		err.innerHTML = temp1[1];	
        	 }
			else{
	if(mode=="1"){   
	
			
			//alert("res-"+res);
			objVal= document.getElementById("CategoryDivId");
			objVal.innerHTML = "<select name ='strCategoryNo' class='comboNormal'  >" +res+ "</select>";
			}
			
			
	}
}

</script>
</head>
<body onload="onLoadPage();">
<html:form name="pendingListAgendaRpt" action="/reports/PendingListAgendaRptCNT"
	type="mms.reports.controller.fb.PendingListAgendaRptFB" method="post">
	
<div class="errMsg" id="errMsg"><bean:write name="pendingListAgendaRpt" property="strErrMsg"/></div>
<div class="normalMsg" id="normalMsg"><bean:write name="pendingListAgendaRpt" property="strNormalMsg"/></div>
<div class="warningMsg" id="warningMsg"><bean:write name="pendingListAgendaRpt" property="strWarningMsg"/></div>


	<tag:tab tabLabel="Pending List of Agenda"
                        selectedTab="FIRST" align="center" width="TABLEWIDTH">
                  </tag:tab>

	<table class="TABLEWIDTH" align="center" cellspacing="1px" cellpadding="1px" >   
	<tr class="HEADER">
			<td colspan="4">Pending List of Agenda</td>
		</tr>
		
		<tr>
			<td width="50%" colspan="2" class="LABEL"><font color="red">*</font>Drug Warehouse Name</td>
			<td width="50%" colspan="2" class="CONTROL">
				<select name="strStoreId" class="comboNormal" onchange="getCategoryCombo();">
					<bean:write name="pendingListAgendaRpt" property="strStoreNameValues" filter="false" />
				</select>
			</td>
		</tr>
	
		<tr>
			<td class="LABEL" colspan="2"><font color="red">*</font>Category</td>
			<td class="CONTROL" colspan="2" ><div id="CategoryDivId">
	       <select name ="strCategoryNo" class="comboNormal" >
	       <option value="0">Select Value</option>
      </select></div></td>
				
				

		</tr>
		
		
			
		<tr>
			<td width="50%" colspan="2" class="LABEL">
			Report Format
			</td>
			<td width="50%" colspan="2" class="CONTROL">
			<select name="strReportFormat"  onchange="">
			<option value="html">Html</option>
			<option value="pdf">Pdf</option></select>
			</td>
			
		</tr> 
		
		<tr>
			<td width="50%" colspan="2" class="LABEL">
			Footer Required
			</td>
			<td width="50%" colspan="2" class="CONTROL">
			<html:checkbox property="strIsFooter" name="pendingListAgendaRpt" value="1"></html:checkbox>
			</td>
			
		</tr>
		<tr>
			<td width="50%" colspan="2" class="LABEL">
			User Remarks
			</td>
			<td width="50%" colspan="2" class="CONTROL">
			<input class="txtFldMax" type="text" name="strUserRemarks" >
			</td>
			
		</tr>
		<tr class="FOOTER">
			 <td colspan="4"><font color='red'>*</font>Mandatory Field </td>
		</tr>
	</table>
	<table border="0" class="TABLEWIDTH" align="center" cellspacing="1px" cellpadding="1px">
		<tr>

			<td align="center">
			<img style="cursor: pointer" TITLE='Generate Report' src="../../hisglobal/images/btn-generate.png" onClick="return validate();" />
			<img style="cursor: pointer" title='Clear Content' src="../../hisglobal/images/btn-clr.png" onClick="document.forms[0].reset();" >
			<img style="cursor: pointer" title='Cancel Process' src="../../hisglobal/images/btn-ccl.png" onClick="cancelFunc();" >
			</td>
			
		</tr>
	</table>
<input type="hidden" name="hmode"/>

</html:form>
<tag:autoIndex></tag:autoIndex>
</body>
</html>