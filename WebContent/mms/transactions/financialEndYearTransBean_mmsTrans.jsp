<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<%@taglib uri="/WEB-INF/dateTag.tld" prefix="dateTag"%>
<%@ taglib uri="/WEB-INF/hisTab.tld" prefix="tag"%>
<%@ taglib uri="/WEB-INF/comboPersistence.tld" prefix="cmbPers"%>


<html>
<head>
<meta charset=UTF-8">
<title>Financial End Year</title>
<link href="../css/transaction.css" rel="stylesheet" type="text/css">
<link href="../../hisglobal/css/tab.css" rel="stylesheet" type="text/css">
<link href="../../hisglobal/css/calendar-tas.css" rel="stylesheet" type="text/css">
<!-- 
/**
 * Developer : Tanvi Sappal
 * Date : 22/Jan/2009 version : 1.0
 * Mod Date : 23/Jun/2008
 */ -->
<script type="text/javascript" src="../../hisglobal/js/calendar.js"></script>
<script language="Javascript" src="../../hisglobal/js/datepicker1.js"></script>
<script language="JavaScript" src="../../hisglobal/js/tab.js"></script>
<script language="JavaScript" src="../../hisglobal/masterutil/js/master.js"></script>
<script language="JavaScript" src="../../hisglobal/js/validation.js"></script>
<script language="Javascript" src="../../hisglobal/js/util.js"></script>
<script language="JavaScript">


function validate1(){

	 var hisValidator = new HISValidator("financialEndYearTransBean");
	  hisValidator.addValidation("strStoreId","dontselect=0","Please select Store Name");
	  
	  //document.forms[0].strFinHidEndDate.value = document.forms[0].strFinEndDate.value;
	  
	  //hisValidator.addValidation("strFinHidEndDate","req","Financial End Date should not be blank");
	 retVal = hisValidator.validate();
	 if(retVal){
	 
	 
	 		document.forms[0].strStoreName.value = document.forms[0].strStoreId[document.forms[0].strStoreId.selectedIndex].text;
	 	
              document.forms[0].hmode.value = "INSERT";
              document.forms[0].submit();
         }else{

           return false;
           }

}

function finEndDate()
{

	document.getElementById("errMsg").innerHTML = "";

if(document.forms[0].strStoreId.value!='0'){
   var mode ="FINENDDATE"; 
   var url="FinancialEndYearTransCNT.cnt?hmode=FINENDDATE&strid="+document.forms[0].strStoreId.value;
   ajaxFunction(url,"1");
   }else{
   	    objVal= document.getElementById("finEndDateDivId");
		objVal.innerHTML =  "" ;
   }

}

function getAjaxResponse(res,mode)
{
	var objVal;
	if(mode=="1")
	{	
		var err = document.getElementById("errMsg");
	   var temp1 = res.split("####");
	   if(temp1[0] == "ERROR")
	   {
         err.innerHTML = temp1[1];	
       }else
       {
	  	  objVal= document.getElementById("finEndDateDivId");
		  objVal.innerHTML =  res ;
		  document.getElementsByName("strFinEndDate")[0].value=res;
		   if(compareDate(document.getElementsByName("strCurrentDate")[0].value,document.getElementsByName("strFinEndDate")[0].value).mode=="2"){
		  		alert("Please Financial End Year Performance Process");
		  }
	   }
	}
}

function cancel(){
	document.forms[0].hmode.value = "CANCEL";
    document.forms[0].submit();
}
</script>
</head>
<body onload="finEndDate();">
<html:form name="financialEndYearTransBean" action="/transactions/FinancialEndYearTransCNT" type="mms.transactions.controller.fb.FinancialEndYearTransFB">
	<center><div id="errMsg" class="errMsg"><bean:write name="financialEndYearTransBean" property="strErrMsg" filter="true"/></div>
	<div id="warningMsg" class="warningMsg"><bean:write name="financialEndYearTransBean" property="strWarningMsg" /></div>
	<div id="normalMsg" class="normalMsg"><bean:write name="financialEndYearTransBean" property="strNormalMsg" /></div>
	

	<tag:tab tabLabel="Financial End Year"
				selectedTab="FIRST" align="center" width="TABLEWIDTH">
              </tag:tab></center>

	<table class="TABLEWIDTH" align="center" cellpadding="1px"
         cellspacing="1px">   
	<tr class="HEADER">
			<td colspan="2"></td>
		</tr>
		<tr>
		<td colspan="2" class="multiLabel">
		<font style="font-family: arial" color="#800000">This process updates the current
		Financial End Year,<br> burns the expired items, closed the last <br> year transaction, 
		please perform it<br>when new financial year starts.
		</font></td>
		</tr>
		<tr>
			<td width="50%" class="LABEL">
			<font color="red">*</font>Store Name</td>
			<td width="50%" class="CONTROL">
			<select name="strStoreId" class='comboNormal' onchange="finEndDate();">
				<bean:write name="financialEndYearTransBean" property="strStoreNameCombo" filter="false" />
			</select>
			</td>
		</tr>
		<tr>
			<td class="LABEL"><font color="red">*</font>Financial End Date</td>
			<td width="50%" class="CONTROL">
				<div id="finEndDateDivId">
				<bean:write name="financialEndYearTransBean" property="strFinEndDate" filter="false" /></div>
			</td>
		</tr>		
		<tr class="FOOTER">
			 <td colspan="2"><font size="2" color="red">*</font>Mandatory Fields</td>
		</tr>
	</table>
	<table border="0" class="TABLEWIDTH" align="center" cellpadding="1px" cellspacing="1px">
		<tr>
			<td align="right">
			<img style='cursor:pointer;cursor:pointer' src="../../hisglobal/images/btn-sv.png" title="To save the Record" onClick="return validate1();" /></td>
			<td align="left">
			<img style='cursor:pointer;cursor:pointer' src="../../hisglobal/images/btn-ccl.png" title="Go back to the Main Page" onClick="cancel();" /></td>
		</tr>
	</table>
	
<input type="hidden" name="hmode"/>
<input type="hidden" name="strStoreName" value="${financialEndYearTransBean.strStoreName}"/>
<input type="hidden" name="strFinStartDate" value="${financialEndYearTransBean.strFinStartDate}"/>
<input type="hidden" name="strFinEndDate" value="${financialEndYearTransBean.strFinEndDate}"/>
<input type="hidden" name="strCurrentDate" value="${financialEndYearTransBean.strCurrentDate}"/>
<cmbPers:cmbPers />
</html:form>
<tag:autoIndex></tag:autoIndex> 
</body>
</html>