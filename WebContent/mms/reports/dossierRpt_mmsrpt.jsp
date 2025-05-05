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
<script type="text/javascript">

function validate(){

 		var hisValidator = new HISValidator("dossierRBean");
        hisValidator.addValidation("strFromDate", "date","From Date is a mandatory field");
		hisValidator.addValidation("strToDate", "date","To Date is a mandatory field");
		hisValidator.addValidation("strToDate","dtltet="+document.forms[0].strCurrentDate.value,"Please Select To Date Less Than or Equal To Current Date");
		hisValidator.addValidation("strToDate","dtgtet="+document.forms[0].strFromDate.value,"Please Select To Date Greater Than Or Equal To From Date");
		if(document.forms[0].strIfArchival.checked)	       	 
			document.forms[0].strIfArchival.value = "1";
		else
			document.forms[0].strIfArchival.value = "0";

		//alert(document.forms[0].strIfArchival.value);
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

	//document.forms[0].strStoreId.value = "0";
	document.forms[0].strFromDate.value = document.forms[0].strCurrentDate.value;
	document.forms[0].strToDate.value = document.forms[0].strCurrentDate.value;
	
}

function onClearButton(){

if((document.getElementsByName("strCase")[0].checked)||(document.getElementsByName("strCase")[1].checked)||
		(document.getElementsByName("strCase")[2].checked)){

	//document.forms[0].strStoreId.value = "0";
	//document.forms[0].strItemCategNo.value = "0";
	document.forms[0].strFromDate.value = document.forms[0].strCurrentDate.value;
	document.forms[0].strToDate.value = document.forms[0].strCurrentDate.value;
	}
}


</script>
</head>
<body onload="onLoadPage();">
<html:form action="/reports/DossierRptCNT" method="post">
	
<div class="errMsg" id="errMsg"><bean:write name="dossierRBean" property="strErrMsg"/></div>
<div class="normalMsg" id="normalMsg"><bean:write name="dossierRBean" property="strNormalMsg"/></div>
<div class="warningMsg" id="warningMsg"><bean:write name="dossierRBean" property="strWarningMsg"/></div>

	<table class="TABLEWIDTH" align="center" cellspacing="1px" cellpadding="1px" >   
	<tr class="HEADER">
			<td colspan="4"><div align='right'><html:checkbox property="strIfArchival" name="dossierRBean"  onclick="">Archived Data</html:checkbox></div> </td>
		</tr>
		
		<tr style="display: none;">
			<td class="LABEL" colspan="4">
			
				<html:radio property="strCase" name="dossierRBean" value="1" onclick="setValueChk();">Issuing Store</html:radio>
		    	
			
			</td>
		</tr>
		
		 <tr style="display: none;">
			<td width="50%" class="LABEL" colspan="2"><font color="red">*</font>Hospital name</td>
			<td width="50%" class="CONTROL" colspan="2">
			<select name="strHospCode" class="comboNormal">
			<bean:write name="dossierRBean" property="strHospNameValues" filter="false"/>
			</select>
			</td>			
		</tr>	
			
		<tr  style="display: none;">
			<td width="50%" colspan="2" class="LABEL">
			<font color="red">*</font>User
			</td>
			<td width="50%" colspan="2" class="CONTROL">
			<select name="strStoreId"  onchange="" class="comboNormal">
			<bean:write name="dossierRBean" property="strStoreVal" filter="false" /></select>
			</td>
			
		</tr> 
		<tr  style="display: none;">
			<td width="50%" colspan="2" class="LABEL"><font color="red">*</font>Type</td>
			<td width="50%" colspan="2" class="CONTROL" >
			<div id="itemCategDIV">
				<select name="strItemCategNo"   class="comboNormal" onchange="">
				<option title="Select Value" selected="" value="0">All</option>
				<option title="OPD" value="2">OPD</option>
				<option title="IPD" value="1">IPD</option>
					
				</select>
			</div>
			</td>
			
		</tr> 
		
		<tr style="display: none;">
			<td class="LABEL" width="50%" colspan="2">Drug Name</td>
			<td class="CONTROL" width="50%" colspan="2">
				<div id="drugNameDivId">			
					<select name="strItemBrandId" class='comboNormal' onChange='getBatchNo();'>
						<option value="0">Select Value</option>
					</select>
				</div>
			</td>

		</tr>

		<tr style="display: none;">
				<td class="LABEL" width="50%" colspan="2">Batch No.</td>
	
				<td class="CONTROL" width="50%" colspan="2">
				    <div id="ExistingBatchId">
					    <select name="strBatchNo"	class='comboNormal' >
						<option value="0">All</option>
					    </select>
				    </div>
				</td>
				
		</tr>
		
		<tr>
			<td width="50%" colspan="2" class="LABEL"><font color="red">*</font>From Date</td>
			<td width="50%" colspan="2" class="CONTROL">
				<dateTag:date name="strFromDate" value="${dossierRBean.strCurrentDate}"/>
			</td>
			
		</tr> 
		
		<tr>
			<td width="50%" colspan="2" class="LABEL"><font color="red">*</font>To Date</td>
			<td width="50%" colspan="2" class="CONTROL">
				<dateTag:date name="strToDate" value="${dossierRBean.strCurrentDate}"/>
			</td>
			
		</tr> 
		<tr>
			<td width="50%" colspan="2" class="LABEL">Report Format</td>
			<td width="50%" colspan="2" class="CONTROL">
				<select name="strReportFormat"  onchange="">
					<option value="html">Html</option>
					<option value="pdf">Pdf</option>
					<option value="xls">Excel</option>
				</select>
			</td>
			
		</tr> 
		<tr>
			<td width="50%" colspan="2" class="LABEL">Footer Required</td>
			<td width="50%" colspan="2" class="CONTROL">
				<html:checkbox property="strIsFooter" name="dossierRBean" value="1"></html:checkbox>
			</td>
		</tr>
		
		<tr>
			<td width="50%" colspan="2" class="LABEL">User Remarks</td>
			<td width="50%" colspan="2" class="CONTROL">
				<input class="txtFldMax" type="text" name="strUserRemarks" >
			</td>
			
		</tr>
		
		<tr class="FOOTER">
			 <td colspan="4"> <font color='red'>*</font>Mandatory Field</td>
		</tr>
		
	</table>
	<!-- <table border="0" class="TABLEWIDTH" align="center" cellspacing="1px" cellpadding="1px">
		<tr>

			<td align="center">
			<img style="cursor: pointer" src="../../hisglobal/images/btn-generate.png" onClick="return validate();" />
			<img style="cursor: pointer" src="../../hisglobal/images/btn-clr.png" onClick="onClearButton();" >
			<img style="cursor: pointer" src="../../hisglobal/images/btn-ccl.png" onClick="cancelFunc();" >
			</td>
			
		</tr>
	</table>-->
	<br>
<div align="center" id="">					 
					 	<a href="#" class="button" id="" onclick=' return validate();'><span class="generate">Generate</span></a>
						<a href="#" class="button"	onclick="onClearButton()"><span class="clear">Clear</span></a> 
						<a href="#" class="button" onclick="cancelFunc();"><span class="cancel">Cancel</span></a>
				</div>
<input type="hidden" name="hmode"/>
<input type="hidden" name="strCurrentDate" value="${dossierRBean.strCurrentDate}" />

</html:form>
<tag:autoIndex></tag:autoIndex>
</body>
</html>