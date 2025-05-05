<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<%@taglib uri="/WEB-INF/dateTag.tld" prefix="dateTag"%>

<%@ taglib uri="/WEB-INF/hisTab.tld" prefix="tag"%>


<html>
<head>
<title>Summary List Of Samples</title>
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

	var hisValidator = new HISValidator("samplesSummaryListRpt");
		
		hisValidator.addValidation("strCategoryNo", "dontselect=0","Select Item Category from Item Category Combo ");
		if(document.forms[0].strCase[0].checked){
			hisValidator.addValidation("strTenderNo", "dontselect=0","Select Tender No from Tender Combo ");
		}else if(document.forms[0].strCase[1].checked){
			hisValidator.addValidation("strSupplierId", "dontselect=0","Select Supplier Name from Supplier Combo ");
		}
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

function chkCase(obj){
	
	document.forms[0].strCategoryNo.value="0";
	document.forms[0].strTenderNo.value="0";
	document.forms[0].strSupplierId.value="0"; 
	
	
	
	if(obj.value=='1')
	{
	document.getElementById("TenderDiv").style.display="block";
	document.getElementById("SupplierDiv").style.display="none";
	
	}
	else
	{
	document.getElementById("SupplierDiv").style.display="block";
	document.getElementById("TenderDiv").style.display="none";
	
	}

}


// This function is used to call the CATEGORY cnt action which populates the value of category combo box

function getComboValues()
{
	 
	var url;
	var mode = "SUPPLIERANDTENDER";
	url="SamplesSummaryListRptCNT.cnt?hmode="+mode+"&categoryNo="+document.forms[0].strCategoryNo.value;
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
	
			
			
			var temp = res.split("@@");
			
			objVal= document.getElementById("SupplierDivId");
			objVal.innerHTML = "<select name ='strSupplierId' class='comboNormal'  >" +temp[0]+ "</select>";
			
			objVal= document.getElementById("TenderNoDivId"); 
			objVal.innerHTML = "<select name ='strTenderNo' class='comboNormal' >" +temp[1]+ "</select>";
			}
			
			
	}
	}

function onLoadPage(){
		if(document.forms[0].strCase[0].checked){
		
			document.getElementById("TenderDiv").style.display = "block";
			document.getElementById("SupplierDiv").style.display = "none";
			document.forms[0].strCategoryNo.value = "0";
			document.forms[0].strTenderNo.value = "0";
			document.forms[0].strFromDate.value=document.forms[0].strCurrentDate.value; 
			document.forms[0].strToDate.value=document.forms[0].strCurrentDate.value; 
	
			
		}else if(document.forms[0].strCase[1].checked){
		
			document.getElementById("TenderDiv").style.display = "none";
			document.getElementById("SupplierDiv").style.display = "block";
			document.forms[0].strCategoryNo.value = "0";
			document.forms[0].strSupplierId.value = "0";
			document.forms[0].strFromDate.value=document.forms[0].strCurrentDate.value; 
			document.forms[0].strToDate.value=document.forms[0].strCurrentDate.value; 
	
		}
}

</script>
</head>
<body onload="onLoadPage();">
<html:form name="samplesSummaryListRpt" action="/reports/SamplesSummaryListRptCNT"
	type="mms.reports.controller.fb.SamplesSummaryListRptFB" method="post">
	
<div class="errMsg" id="errMsg"><bean:write name="samplesSummaryListRpt" property="strErrMsg"/></div>
<div class="normalMsg" id="normalMsg"><bean:write name="samplesSummaryListRpt" property="strNormalMsg"/></div>
<div class="warningMsg" id="warningMsg"><bean:write name="samplesSummaryListRpt" property="strWarningMsg"/></div>


	<tag:tab tabLabel="Summary List Of Samples"
                        selectedTab="FIRST" align="center" width="TABLEWIDTH">
                  </tag:tab>

	<table class="TABLEWIDTH" align="center" cellspacing="1px" cellpadding="1px" >   
	<tr class="HEADER">
			<td colspan="4">Summary List Of Samples</td>
		</tr>
		
	
		<tr>
			<td class="LABEL" colspan="4">
			<div align="right"><html:radio property="strCase" 
				name="samplesSummaryListRpt" value="1" 
				onclick="chkCase(this);" >Tender Wise</html:radio> <html:radio
				property="strCase" name="samplesSummaryListRpt" value="2"
				onclick="chkCase(this);">Supplier Wise</html:radio></div>
			</td>
		</tr>
		<tr>
			<td width="50%" colspan="2" class="LABEL"><font color="red">*</font>Category</td>
			<td width="50%" colspan="2" class="CONTROL">
				<select name="strCategoryNo" class="comboNormal" onchange="getComboValues();">
					<bean:write name="samplesSummaryListRpt" property="strCategoryValues"
						filter="false" />
				</select>
			</td>
		</tr>
		
		
		</table>
		<div id="SupplierDiv" style="display:none ">
		
		<table class="TABLEWIDTH" align="center" cellspacing="1px" cellpadding="1px" >   
		<tr>
			<td class="LABEL" colspan="2" width="50%"><font color="red">*</font>Supplier Name</td>
			
			<td class="CONTROL" colspan="2" width="50%">
			<div id="SupplierDivId">
       <select name ="strSupplierId" class="comboNormal" ><option value="0">Select Value</option>
      </select></div>
      
       </td>
       </tr>
       </table></div>
       
      <div id="TenderDiv">
      <table class="TABLEWIDTH" align="center" cellspacing="1px" cellpadding="1px" >  
       <tr>
			<td class="LABEL" colspan="2" width="50%"><font color="red">*</font>Tender No.</td>
			
			<td class="CONTROL" colspan="2" width="50%">
			<div id="TenderNoDivId">
       <select name ="strTenderNo" class="comboNormal" ><option value="0">Select Value</option>
      </select></div>
      
       </td>
       </tr>
       </table>
       </div>
       
		
	<table class="TABLEWIDTH" align="center" cellspacing="1px" cellpadding="1px" >   
			
			<tr>
			<td width="50%" colspan="2" class="LABEL">
			From Date
			</td>
			<td width="50%" class="CONTROL" colspan="2"><dateTag:date name="strFromDate" value="${samplesSummaryListRpt.strCurrentDate}"></dateTag:date></td>
			
		</tr> 
		<tr>
			<td width="50%" colspan="2" class="LABEL">
			To Date
			</td>
				<td width="50%" class="CONTROL" colspan="2"><dateTag:date name="strToDate" value="${samplesSummaryListRpt.strCurrentDate}"></dateTag:date></td>
			
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
			<html:checkbox property="strIsFooter" name="samplesSummaryListRpt" value="1"></html:checkbox>
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
			<img style="cursor: pointer" TITLE='Generate Report' src="../../hisglobal/images/btn-generate.png" onClick="return validate();" />
			<img style="cursor: pointer" title='Clear Content' src="../../hisglobal/images/btn-clr.png" onClick="document.forms[0].reset();" >
			<img style="cursor: pointer" title='Cancel Process' src="../../hisglobal/images/btn-ccl.png" onClick="cancelPage();" >
			</td>
			
		</tr>
	</table>
<input type="hidden" name="hmode"/>
<input type="hidden" name="strCurrentDate" value="${samplesSummaryListRpt.strCurrentDate}"/>

</html:form>
<tag:autoIndex></tag:autoIndex>
</body>
</html>