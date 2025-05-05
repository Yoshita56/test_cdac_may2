<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<%@taglib uri="/WEB-INF/dateTag.tld" prefix="dateTag"%>
<%@ taglib uri="/WEB-INF/hisTab.tld" prefix="tag"%>


<html>
<head>
<title>List of Items That Are Auctioned</title>
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

	var hisValidator = new HISValidator("listItemAuctionedRpt");

	hisValidator.addValidation("strItemCategoryNo", "dontselect=0","Please Select Item Category");
	
	hisValidator.addValidation("strFromDate", "date","From Date is a mandatory field");
	hisValidator.addValidation("strToDate", "date","To Date is a mandatory field");
	
	hisValidator.addValidation("strToDate","dtltet="+document.forms[0].strCtDate.value,"Please Select To Date Less Than or Equal To Current Date");
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

function onLoadPage(){
	document.forms[0].strItemCategoryNo.value = "0";
	document.forms[0].strFromDate.value = document.forms[0].strCtDate.value;
	document.forms[0].strToDate.value = document.forms[0].strCtDate.value;
}


</script>
</head>
<body onload="onLoadPage();">
<html:form action="/reports/ListItemAuctionedRptCNT" method="post">
	
<div class="errMsg" id="errMsg"><bean:write name="listItemAuctionedRpt" property="strErrMsg"/></div>
<div class="normalMsg" id="normalMsg"><bean:write name="listItemAuctionedRpt" property="strNormalMsg"/></div>
<div class="warningMsg" id="warningMsg"><bean:write name="listItemAuctionedRpt" property="strWarningMsg"/></div>


	<tag:tab tabLabel="List of Items that are Auctioned"
                        selectedTab="FIRST" align="center" width="TABLEWIDTH">
                  </tag:tab>

	<table class="TABLEWIDTH" align="center" cellspacing="1px" cellpadding="1px" >   
	<tr class="HEADER">
			<td colspan="4">List of Items that are Auctioned</td>
		</tr>
		
		<tr>
		<td width ="50%" class="LABEL" colspan="2">
			<font color="red">*</font>Category		
		</td>
		<td width ="50%" class="CONTROL" colspan="2">
			<select name="strItemCategoryNo" class='comboNormal'>
					<bean:write name="listItemAuctionedRpt" property="strItemCategoryCombo"filter="false" />
			</select>
		</td>
	    </tr>
		<tr >
    		<td class ="LABEL" width ="50%" colspan="2"><font color="red">*</font>From Date</td>
    		<td class ="CONTROL" width="50%" colspan="2">
    		<dateTag:date name="strFromDate" value ="${listItemAuctionedRpt.strCtDate}"></dateTag:date></td>
  		</tr>
  		<tr>
  			<td class ="LABEL" width ="50%" colspan="2"><font color="red">*</font>To Date</td>
    		<td class ="CONTROL" width ="50%" colspan="2">
    		<dateTag:date name="strToDate" value ="${listItemAuctionedRpt.strCtDate}"></dateTag:date></td>
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
			<html:checkbox property="strIsFooter" name="listItemAuctionedRpt" value="1"></html:checkbox>
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
			<img style="cursor: pointer" src="../../hisglobal/images/btn-clr.png" onClick="document.forms[0].reset();" >
			<img style="cursor: pointer" src="../../hisglobal/images/btn-ccl.png" onClick="cancelFunc();" >
			</td>
			
		</tr>
	</table>
<input type="hidden" name="hmode"/>
<input type="hidden" name="strCtDate" value="${listItemAuctionedRpt.strCtDate}"/>

</html:form>
<tag:autoIndex></tag:autoIndex>
</body>
</html>