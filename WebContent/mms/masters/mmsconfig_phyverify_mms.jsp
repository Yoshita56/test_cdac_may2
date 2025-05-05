<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<%@ taglib uri="/WEB-INF/hisTab.tld" prefix="tag"%>
<%@taglib uri="/WEB-INF/dateTag.tld" prefix="date"%>
<%@taglib uri="http://struts.apache.org/tags-logic" prefix="logic"%>

<html>
<head>
<meta charset="utf-8">
<title>Store Setup</title>
<link href="../css/master.css" rel="stylesheet" type="text/css">
<link href="../../hisglobal/css/tab.css" rel="stylesheet" type="text/css">
<link href="../../hisglobal/css/calendar-tas.css" rel="stylesheet" type="text/css">
<link href="../../hisglobal/css/buttons.css" rel="stylesheet" type="text/css">
<link href="../../hisglobal/css/popup.css" rel="stylesheet" type="text/css">	
	
<script language="JavaScript" src="../../hisglobal/masterutil/js/master.js"></script>
<script language="JavaScript" src="../../hisglobal/js/tab.js"></script>
<script language="JavaScript" src="../../hisglobal/js/calendar.js"></script>
<script language="Javascript" src="../../hisglobal/js/validation.js"></script>
<script language="Javascript" src="../../hisglobal/js/util.js"></script>

<script type="text/javascript">

	
	function validatePhyStockVerify(){	
	
		retVal = false;
		var hisValidator = new HISValidator("mmsConfigBean");
	
	hisValidator.addValidation("strStoreId", "dontselect=0","Please Select a Store Name");
	hisValidator.addValidation("strItemCategoryCode", "dontselect=0","Please Select an Item Cateogry ");
		
		if(document.forms[0].strIsPeriodAvailable.value == "0"){
		
		hisValidator.addValidation("strPeriodId", "dontselect=0","Please Select a Period ");
		
			
		}	
	
		retVal = hisValidator.validate(); 
		hisValidator.clearAllValidations();
		if(retVal){
		
			
			if(!document.getElementsByName("strIsStockLedgerRequired")[0].checked){
			
				var conf = confirm("Opening Balance May be Inconsistence, \nAre You Sure");
			
				if(!conf) return false;
			
			
			}
							
			document.forms[0].selectedTab.value = "SAVEPHYSTKVERIFYDTLS";
			document.forms[0].submit();

		}else{
		
		return false;
		}
		
	}

	function getItemCategory(obj){
	
		
	var mode="GETCATEGORY";
   var url="MmsConfigMstCNT.cnt?selectedTab="+mode+"&strStoreId="+obj.value;
 //  alert("url:"+url);
   ajaxFunction(url,"1");
		
	
	}

function getPeriodDetails(){
	
		
   var mode="GETPERIODDTLS";
   var url="MmsConfigMstCNT.cnt?selectedTab="+mode+"&strStoreId="+document.forms[0].strStoreId[document.forms[0].strStoreId.selectedIndex].value+"&strCategoryId="+document.forms[0].strItemCategoryCode[document.forms[0].strItemCategoryCode.selectedIndex].value;
    ajaxFunction(url,"2");
		
	
}


function getAjaxResponse(res,mode)
{
                 	
   if(mode=="1")
   {
      
       document.getElementById("periodPartDivId").style.display = "none";
        	document.getElementById("isStockLedgeDivId").style.display = "none";
      
        var objVal = document.getElementById("categoryDivId");
        objVal.innerHTML = "<select name='strItemCategoryCode' onchange='getPeriodDetails();'>" + res + "</select>";
     
       
     }
   if(mode=="2")
   {
   
       document.getElementById("periodPartDivId").style.display = "block";
       
       var temp = res.split('@');
       
       	if(temp[0] == '1'){
       	
       			 var objVal = document.getElementById("periodDivId");
        		objVal.innerHTML = temp[1].split('^')[0]; 
       	
       		document.forms[0].strIsPeriodAvailable.value = 1;
       		
       		document.getElementById("itemCatLableDivId1").style.display = "none";
       		
       		document.getElementById("itemCatLableDivId2").innerHTML = "Period <input type='hidden' name='strPeriodId' value='"+temp[1].split('^')[1]+"' /> "; 
       		
       		document.getElementById("itemCatLableDivId2").style.display = "block";
       		document.getElementById("isStockLedgeDivId").style.display = "block";
       	
       	if(temp[1].split('^')[2] != '0'){
       	
       		document.getElementsByName("strIsStockLedgerRequired")[0].checked = true;
       		document.forms[0].strPreviousStockLedgerRequired.value = '1';
       		
       	}else{
       	
       		document.getElementsByName("strIsStockLedgerRequired")[0].checked = false;
       		document.forms[0].strPreviousStockLedgerRequired.value = '0';
       	
       	}
       	
       	}else{
       	
       	 var objVal = document.getElementById("periodDivId");
        	objVal.innerHTML = "<select name = 'strPeriodId' >" + temp[1] + "</select>";
        	
        	document.forms[0].strIsPeriodAvailable.value = 0;
       	
       	document.getElementById("itemCatLableDivId1").style.display = "block";
       	
       	document.getElementById("itemCatLableDivId2").innerHTML = "Period";
       	
       		document.getElementById("itemCatLableDivId2").style.display = "none";
       	document.getElementById("isStockLedgeDivId").style.display = "block";
       	}
       
       

     }
     
}



function clearPage(mode){

	document.forms[0].selectedTab.value = mode ;
	document.forms[0].submit();
}

</script>

</head>
<body >
<html:form action="/masters/MmsConfigMstCNT" method="post" name="mmsConfigBean" type="mms.masters.controller.fb.MmsConfigMstFB" >
	
<center>
	<div id="errMsg" class="errMsg"><bean:write name="mmsConfigBean" property="strErrMsg" /></div>
	<div id="normalMsg" class="normalMsg"><bean:write name="mmsConfigBean" property="strNormalMsg" /></div>
	
                    <tag:tab tabList="${mmsConfigBean.lhm}" selectedTab="mmsphysicalstockverifydtls" align="center" width="TABLEWIDTH"></tag:tab>
</center>
	<table class="TABLEWIDTH" align="center" cellpadding="1px" cellspacing="1px">   
	<tr class="HEADER">
			<td colspan="2">Store Setup &gt;&gt; General Details</td>
		</tr>
		<tr>
		<td class="LABEL" width="50%" ><font color="red">*</font>Store Name
		</td>
		<td class="CONTROL" width="50%" ><select name="strStoreId" onchange="getItemCategory(this);">
		<bean:write  name="mmsConfigBean" property="strStoreDetailsValues"  filter="false"/>
		</select>
		</td>
		</tr>
		<tr>
		<td class="LABEL" width="50%" ><font color="red">*</font>Item Category
		</td>
		<td class="CONTROL" width="50%" >
		<div id="categoryDivId">
		<select name="strItemCategoryCode" onchange="getPeriodDetails();">
		<bean:write  name="mmsConfigBean" property="strItemCategoryCode"  filter="false"/>
		</select>
		</div>
		</td>
		</tr>
		</table>
		
		<logic:empty name="mmsConfigBean" property="strPeriodId">		
		<div id="periodPartDivId" style="display: none">
		<table class="TABLEWIDTH" align="center" cellpadding="1px" cellspacing="1px">   
		<tr>
		<td class="LABEL" width="50%" ><div id="itemCatLableDivId1" style="display:none"><font color="red">*</font>Period</div>
		<div id="itemCatLableDivId2" style="display:none" > Period</div>
		<input type="hidden" name="strIsPeriodAvailable" value="${mmsConfigBean.strIsPeriodAvailable}">
		</td>
		<td class="CONTROL" width="50%" ><div id="periodDivId"></div>
		</td>
		</tr>
		</table>
		</div>
		</logic:empty>
		
		<logic:notEmpty name="mmsConfigBean" property="strPeriodId">		
		<div id="periodPartDivId">
		<table class="TABLEWIDTH" align="center" cellpadding="1px" cellspacing="1px">   
		<tr>
		<td class="LABEL" width="50%" ><div id="itemCatLableDivId1"><font color="red">*</font>Period</div>
		<div id="itemCatLableDivId2" style="display:none" > Period</div>
		<input type="hidden" name="strIsPeriodAvailable" value="${mmsConfigBean.strIsPeriodAvailable}">
		</td>
		<td class="CONTROL" width="50%" >
		<div id="periodDivId">
		<select name="strPeriodId" >
		<bean:write  name="mmsConfigBean" property="strPeriodName"  filter="false"/>
		</select>
		</div>
		</td>
		</tr>
		</table>
		</div>
		</logic:notEmpty>
		
		
		<div id="isStockLedgeDivId">
		<table class="TABLEWIDTH" align="center" cellpadding="1px" cellspacing="1px" > 
		<tr>
		   <td class="LABEL" width="50%" >Is Stock Ledger Required
		</td>
		<td class="CONTROL" width="50%" > 
		<html:checkbox name="mmsConfigBean"  property="strIsStockLedgerRequired" value="1"></html:checkbox>
		</td>
		</tr>
		</table>
		</div>
		
		<table class="TABLEWIDTH" align="center" cellpadding="1px" cellspacing="1px">   
		<tr class="FOOTER">
			 <td colspan="2"><font size="2" color="red">*</font> Mandatory Fields  </td>
		</tr>
	</table>
	<!--<table border="0" class="TABLEWIDTH" align="center">
		<tr>

			<td align="center">
			<img style="cursor: pointer; "
				src="../../hisglobal/images/btn-sv.png" onClick="return validatePhyStockVerify();" />
				<img style="cursor: pointer; " src="../../hisglobal/images/btn-clr.png" onClick="clearPage('mmsphysicalstockverifydtls')" >
			<img  style="cursor: pointer; " src="../../hisglobal/images/btn-ccl.png" onClick="clearPage('CANCEL');" >
			</td>
		</tr>
	</table>-->
	<br>
	<div align="center" id=" ">					 
					 	<a href="#" class="button" id="submitId" onclick=' return validatePhyStockVerify();'><span class="save">Save</span></a>
						<a href="#" class="button"	onclick="clearPage('mmsphysicalstockverifydtls');"><span class="clear">Clear</span></a> 
						<a href="#" class="button" onclick="clearPage('CANCEL');"><span class="cancel">Cancel</span></a>
				</div>
<input type="hidden" name="strPreviousStockLedgerRequired" value="0">
<input type="hidden" name="strCtDate" value="${mmsConfigBean.strCtDate}">	
	
<input 	type="hidden" name="selectedTab">
</html:form>
<tag:autoIndex></tag:autoIndex>
</body>
</html>