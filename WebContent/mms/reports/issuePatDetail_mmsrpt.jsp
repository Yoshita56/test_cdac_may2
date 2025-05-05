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

function validate(){


 		var hisValidator = new HISValidator("issuePatRptBean");
 		
 	
		document.forms[0].strStoreName.value = document.forms[0].strStoreId[document.forms[0].strStoreId.selectedIndex].text;
 	
 	
 		
 		hisValidator.addValidation("strCase", "dontselect=0", "Please Select Report Type Combo" );
 		
        hisValidator.addValidation("strStoreId", "dontselect=0", "Please Select Store Combo" );
        hisValidator.addValidation("strItemCategNo", "dontselect=0", "Please Select Item Category Combo" );
        hisValidator.addValidation("strFromDate", "date","From Date is a mandatory field");
		hisValidator.addValidation("strToDate", "date","To Date is a mandatory field");
		hisValidator.addValidation("strToDate","dtltet="+document.forms[0].strCurrentDate.value,"Please Select To Date Less Than or Equal To Current Date");
		hisValidator.addValidation("strToDate","dtgtet="+document.forms[0].strFromDate.value,"Please Select To Date Greater Than Or Equal To From Date");
	       	 
        
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
        objVal.innerHTML = "<select name = 'strItemCategNo' class='comboNormal'>" + res + "</select>";
		      
     }
}

function getItemCateg(){
 	var mode="ITEMCATEGORYCOMBO";
   var url="IssuePatDetailRptCNT.cnt?hmode="+mode+"&strId="+document.forms[0].strStoreId.value;
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

	
	document.forms[0].strFromDate.value = document.forms[0].strCurrentDate.value;
	document.forms[0].strToDate.value = document.forms[0].strCurrentDate.value;
	
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

</script>
</head>
<body onload="onLoadPage();">
<html:form action="/reports/IssuePatDetailRptCNT" method="post">
	
<div class="errMsg" id="errMsg"><bean:write name="issuePatRptBean" property="strErrMsg"/></div>
<div class="normalMsg" id="normalMsg"><bean:write name="issuePatRptBean" property="strNormalMsg"/></div>
<div class="warningMsg" id="warningMsg"><bean:write name="issuePatRptBean" property="strWarningMsg"/></div>


	<tag:tab tabLabel="Issue Detail"
                        selectedTab="FIRST" align="center" width="TABLEWIDTH">
                  </tag:tab>

	<table class="TABLEWIDTH" align="center" cellspacing="1px" cellpadding="1px" >   
	<tr class="HEADER">
			<td colspan="4">Issue Detail</td>
		</tr>
	
	<tr>
    	<td colspan="4" class="LABEL" align="center">
	    	 <input type="radio"  name="strConsolidatedOrDetailed" value="1"  onclick="setBatchOrIssueDetailCheckBox();" />Consolidated 
	    	 <input type="radio" name="strConsolidatedOrDetailed" value="2" checked="checked" onclick="setBatchOrIssueDetailCheckBox();"/>Detail
    	 
    	 </td>
	</tr>
		
			
		<tr>
		<td width="50%" colspan="2" class="LABEL">
			<font color="red">*</font>Report Type
		</td>
		
			<td width="50%" colspan="2" class="CONTROL">
				<select name="strReportType" onchange="">
					<option value="0">Select Value</option>
					<option value="3">Patient</option>
				</select>
			</td>
			
		</tr>
		
		<tr id="whetherBatchRequiredCheckBoxId" style="display: none">
		<td width="50%" colspan="2" class="LABEL">
					
			<html:checkbox property="strWhetherBatchRequiredCheckBox" name="issuePatRptBean" value="1" onclick="" onclick=""/>
		
		</td>
		<td width="50%" colspan="2" class="CONTROL">Whether Batch Required</td>
		</tr>
		
		<tr id="onlyIssueDetailRequiredCheckBoxId" >
		<td  width="50%" colspan="2" class="LABEL">
					
			<html:checkbox property="strOnlyIssueDetailRequiredCheckBox" name="issuePatRptBean" value="1" onclick="" onclick=""/>
		
		</td>
			<td width="50%" colspan="2" class="CONTROL">Only Issue Detail (Without Drug)</td>

		</tr>
			
		<tr>
			<td width="50%" colspan="2" class="LABEL">
			<font color="red">*</font>Store Name
			</td>
			<td width="50%" colspan="2" class="CONTROL">
			<select name="strStoreId"  onchange="getItemCateg();" class="comboNormal">
				<bean:write name="issuePatRptBean" property="strStoreVal" filter="false" /></select>
			</td>
			
		</tr> 
		<tr>
			<td width="50%" colspan="2" class="LABEL">
			<font color="red">*</font>Item Category
			</td>
			<td width="50%" colspan="2" class="CONTROL" >
			<div id="itemCategDIV">
			<select name="strItemCategNo"  onchange="" class="comboNormal">
				<bean:write name="issuePatRptBean" property="strItemVal" filter="false" />
			</select>
			</div>
			</td>
			
		</tr> 
		<tr>
			<td width="50%" colspan="2" class="LABEL">
			<font color="red">*</font>From Date
			</td>
			<td width="50%" colspan="2" class="CONTROL">
				<dateTag:date name="strFromDate"
				 value="${issuePatRptBean.strCurrentDate}"/>
			</td>
			
		</tr> 
		<tr>
			<td width="50%" colspan="2" class="LABEL">
			<font color="red">*</font>To Date
			</td>
			<td width="50%" colspan="2" class="CONTROL">
				<dateTag:date name="strToDate"
				 value="${issuePatRptBean.strCurrentDate}"/>
			</td>
			
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
			<html:checkbox property="strIsFooter" name="issuePatRptBean" value="1"></html:checkbox>
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
			 <td colspan="4"> <font color='red'>*</font>Mandatory Field</td>
		</tr>
	</table>
	<table border="0" class="TABLEWIDTH" align="center" cellspacing="1px" cellpadding="1px">
		<tr>

			<td align="center">
			<img style="cursor: pointer" src="../../hisglobal/images/btn-generate.png" onClick="return validate();" />
			<img style="cursor: pointer" src="../../hisglobal/images/btn-clr.png" onClick="onClearButton();" >
			<img style="cursor: pointer" src="../../hisglobal/images/btn-ccl.png" onClick="cancelFunc();" >
			</td>
			
		</tr>
	</table>
<input type="hidden" name="hmode"/>
<input type="hidden" name="strCurrentDate" value="${issuePatRptBean.strCurrentDate}" />

<input type="hidden" name="strStoreName" value="${issuePatRptBean.strStoreName}" />


</html:form>
<tag:autoIndex></tag:autoIndex>
</body>
</html>