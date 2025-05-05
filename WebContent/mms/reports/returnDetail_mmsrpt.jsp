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

		 var hisValidator = new HISValidator("returnRptBean");
		 	hisValidator.addValidation("strHospitalCode", "dontselect=0","Please Select Hospital Name");
             hisValidator.addValidation("strStoreVal", "dontselect=0", "Please Select Store Combo" );
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
			}else
			{
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
        objVal.innerHTML = "<select class='comboNormal' name = 'strItemCategNo'  >" + res + "</select>";
		      
     }
     
     if(mode=="2")
   {
        var objVal = document.getElementById("storeDIV");
        objVal.innerHTML = "<select class='comboNormal' name = 'strStoreVal'  onchange='getItemCateg();'>" + res + "</select>";
		      
     }
}

function getItemCateg()
{
 	//alert(document.forms[0].strStoreVal.value);
 	var mode="ITEMCATEGORYCOMBO";
    var url="ReturnDetailsRptCNT.cnt?hmode="+mode+"&strId="+document.forms[0].strStoreVal.value;
   ajaxFunction(url,"1");
}

function getStoreCmb(){
 	var mode="ITEMSTORECOMBO";
   var url="ReturnDetailsRptCNT.cnt?hmode="+mode+"&HOSPITAL_CODE="+document.forms[0].strHospitalCode.value;
   ajaxFunction(url,"2");
}
function setValueChk(){
	if(document.getElementsByName("issueChkDetail")[0].checked){
		document.getElementsByName("issueChkDetail")[0].value="1";
		document.getElementsByName("strUserRemarks")[0].value="";
		document.getElementsByName("strItemCategNo")[0].value="0";
		document.getElementsByName("strStoreVal")[0].value="0";
		
	}else if(document.getElementsByName("issueChkDetail")[1].checked){
		document.getElementsByName("issueChkDetail")[1].value="2";
		document.getElementsByName("strUserRemarks")[0].value="";
		document.getElementsByName("strItemCategNo")[0].value="0";
		document.getElementsByName("strStoreVal")[0].value="0";
	}else{
			document.getElementsByName("issueChkDetail")[1].value="3";
			document.getElementsByName("strUserRemarks")[0].value="";
			document.getElementsByName("strItemCategNo")[0].value="0";
			document.getElementsByName("strStoreVal")[0].value="0";
	}
}
function onLoadPage(){

	
	document.forms[0].strFromDate.value = document.forms[0].strCurrentDate.value;
	document.forms[0].strToDate.value = document.forms[0].strCurrentDate.value;
	
}
</script>
</head>
<body onload="onLoadPage();">
<html:form action="/reports/ReturnDetailsRptCNT" method="post">
	
<div class="errMsg" id="errMsg"><bean:write name="returnRptBean" property="strErrMsg"/></div>
<div class="normalMsg" id="normalMsg"><bean:write name="returnRptBean" property="strNormalMsg"/></div>
<div class="warningMsg" id="warningMsg"><bean:write name="returnRptBean" property="strWarningMsg"/></div>


	<tag:tab tabLabel="Return Detail"
                        selectedTab="FIRST" align="center" width="TABLEWIDTH">
                  </tag:tab>

	<table class="TABLEWIDTH" align="center" cellspacing="1px" cellpadding="1px" >   
	<tr class="HEADER">
			<td colspan="4"></td>
		</tr>
		
		<tr>
			<td class="LABEL" colspan="4">
				
				<html:radio property="issueChkDetail" name="returnRptBean" value="1" onclick="setValueChk();">Sub Store</html:radio>
		 	<html:radio property="issueChkDetail" name="returnRptBean" value="2" onclick="setValueChk();" style="display:none">Employee</html:radio>      
		    	<html:radio property="issueChkDetail" name="returnRptBean" value="3" onclick="setValueChk();">Patient</html:radio>
			
			</td>
		</tr>
			<tr>
			<td width="50%" class="LABEL" colspan="2"><font color="red">*</font>Hospital name</td>
			<td width="50%" class="CONTROL" colspan="2">
			<select name="strHospitalCode" onchange="getStoreCmb();" class="comboNormal">
			<bean:write name="returnRptBean" property="strHospNameValues" filter="false"/>
			</select>
			</td>			
		</tr>	
		<tr>
			<td width="50%" colspan="2" class="LABEL">
			<font color="red">*</font>Store Name
			</td>
			
			
			
			<td width="50%" colspan="2" class="CONTROL">
			<div id="storeDIV">
			<select name="strStoreId"  onchange="getItemCateg();" class="comboNormal">
			<option value="0">Select Value</option></select>
			</div>
			</td>
						
		</tr> 
		<tr>
			<td width="50%" colspan="2" class="LABEL">
			<font color="red">*</font>Category
			</td>
			<td width="50%" colspan="2" class="CONTROL" >
			<div id="itemCategDIV">
			<select name="strItemCategNo"  onchange="" class="comboNormal">
				<option value="0">Select Value</option>
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
				 value="${returnRptBean.strCurrentDate}"/>
			</td>
			
		</tr> 
		<tr>
			<td width="50%" colspan="2" class="LABEL">
			<font color="red">*</font>To Date
			</td>
			<td width="50%" colspan="2" class="CONTROL">
				<dateTag:date name="strToDate" 
				 value="${returnRptBean.strCurrentDate}"/>
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
			<html:checkbox property="strIsFooter" name="returnRptBean" value="1"></html:checkbox>
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
			<img style="cursor: pointer" src="../../hisglobal/images/btn-generate.png" onClick="return validate();" />
			<img style="cursor: pointer" src="../../hisglobal/images/btn-clr.png" onClick="document.forms[0].reset();" >
			<img style="cursor: pointer" src="../../hisglobal/images/btn-ccl.png" onClick="cancelPage();" >
			</td>
			
		</tr>
	</table>
<input type="hidden" name="hmode"/>
<input type="hidden" name="strCurrentDate" value="${returnRptBean.strCurrentDate}" />

</html:form>
<tag:autoIndex></tag:autoIndex>
</body>
</html>