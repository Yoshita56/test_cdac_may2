<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<%@taglib uri="/WEB-INF/dateTag.tld" prefix="dateTag"%>
<%@ taglib uri="/WEB-INF/hisTab.tld" prefix="tag"%>


<html>
<head>
<title>Stock Status</title>
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

<!-- 
/**
 * Developer : Tanvi Sappal
 * Version : 1.0 
 * Date : 21/July/2009
 * Module : MMS 
 */ -->

<script type="text/javascript">

function validate(){

	var hisValidator = new HISValidator("stockStatusRpt1");
	hisValidator.addValidation("strHospitalCode", "dontselect=0","Please Select Hospital Name");
    hisValidator.addValidation("strStoreId", "dontselect=0","Please Select Store Name");
	hisValidator.addValidation("strItemCategoryNo", "dontselect=0","Please Select Item Category");
	

	hisValidator.addValidation("strDate", "date","Date is a mandatory field");
	hisValidator.addValidation("strDate","dtltet="+document.forms[0].strCtDate.value,"Date Should be less than or equals to Current Date");
	
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

function itemCategoryCombo()
{
//alert(document.forms[0].strStoreVal.value);
	if(document.forms[0].strStoreVal.value!="0"){	
		
	   var mode ="ITEMCATEGORY";  
	   var url="StockStatusRptCNT_NEW.cnt?hmode=ITEMCATEGORY&storeid="+document.forms[0].strStoreVal.value;
	   ajaxFunction(url,"1");
	   }else{
	   		
	   		document.forms[0].strStoreVal.value = "0"
	   		document.getElementById('itemCatId').innerHTML = "<select name='strItemCategoryNo' class='comboNormal' onchange='groupNameCombo();'><option value='0'>Select Value</option></select>";  
	   		document.getElementById('groupId').innerHTML = "<select name='strGroupId' class='comboNormal'><option value='0'>All</option></select>";
	   
	   }
}

function groupNameCombo()
{
if(document.forms[0].strItemCategoryNo.value!="0"){
   var mode ="GROUPNAME";  
   var url="StockStatusRptCNT_NEW.cnt?hmode=GROUPNAME&itemCatNo="+document.forms[0].strItemCategoryNo.value;
   ajaxFunction(url,"2");
   }else{
	   		document.getElementById('itemCatId').innerHTML = "<select name='strItemCategoryNo' class='comboNormal' onchange='groupNameCombo();'><option value='0'>Select Value</option></select>";  
	   		document.getElementById('groupId').innerHTML = "<select name='strGroupId' class='comboNormal'><option value='0'>All</option></select>";
	   
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
       	  objVal= document.getElementById("itemCatId");
		  objVal.innerHTML = "<select name='strItemCategoryNo' class='comboNormal' onchange='groupNameCombo();'>" + res + "</select>";  
        }
       
    }
    
  	if(mode=="2")
	{	
	
	   var err = document.getElementById("errMsg");
	   var temp1 = res.split("####");
	   if(temp1[0] == "ERROR")
	   {
         err.innerHTML = temp1[1];	
       }else
        {
        	var temp = res.split('@');
        	
            objVal= document.getElementById("groupId");
		    objVal.innerHTML = "<select name='strGroupId' class='comboNormal'>" + res + "</select>";
		     
        }
        }
        
        
         if(mode=="3")
   {
        var objVal = document.getElementById("storeDIV");
        objVal.innerHTML = "<select class='comboNormal' name = 'strStoreVal'  onchange='itemCategoryCombo();'>" + res + "</select>";
		      
     }
    }
    

function checkValue()
{
	if(document.forms[0].strGroupWise.checked == true){
		document.getElementById('groupDivId').style.display = "block";
		document.forms[0].strGroupWise.value = "1";
	}else if(document.forms[0].strGroupWise.checked == false){
		document.getElementById('groupDivId').style.display = "none";
		document.forms[0].strGroupWise.value = "0";
	}
}

function onLoadPage(){

	document.forms[0].strStoreId.value = "0";
	document.forms[0].strItemCategoryNo.value = "0";
	document.forms[0].strGroupWise.checked = false;
	document.getElementById('groupDivId').style.display = "none";

}
function getStoreCmb(){
 	var mode="ITEMSTORECOMBO";
   var url="StockStatusRptCNT_NEW.cnt?hmode="+mode+"&HOSPITAL_CODE="+document.forms[0].strHospitalCode.value;
   ajaxFunction(url,"3");
}
</script>
</head>
<body onload="onLoadPage();">
<html:form action="/reports/StockStatusRptCNT_NEW" method="post">
	
<div class="errMsg" id="errMsg"><bean:write name="stockStatusRpt1" property="strErrMsg"/></div>
<div class="normalMsg" id="normalMsg"><bean:write name="stockStatusRpt1" property="strNormalMsg"/></div>
<div class="warningMsg" id="warningMsg"><bean:write name="stockStatusRpt1" property="strWarningMsg"/></div>


	<tag:tab tabLabel="Stock Status"
                        selectedTab="FIRST" align="center" width="TABLEWIDTH">
                  </tag:tab>

	<table class="TABLEWIDTH" align="center" cellspacing="1px" cellpadding="1px" >   
	<tr class="HEADER">
			<td colspan="4"></td>
		</tr>
		
		<tr>
    	<td class="LABEL" colspan="4"><input name="strGroupWise" type="checkbox"
				onclick="checkValue();">Group Wise</td>
			
       </tr>
       
     <tr>
			<td width="50%" class="LABEL" colspan="2"><font color="red">*</font>Hospital name</td>
			<td width="50%" class="CONTROL" colspan="2">
			<select name="strHospitalCode" onchange="getStoreCmb();" class="comboNormal">
			<bean:write name="stockStatusRpt1" property="strHospNameValues" filter="false"/>
			</select>
			</td>			
		</tr>	
		<tr>
			<td width="50%" colspan="2" class="LABEL">
			<font color="red">*</font>Store Name
			</td>
		<td colspan="2" width="50%" class="CONTROL">
		<div id="storeDIV">
				<select name="strStoreId"  onchange="itemCategoryCombo();" class="comboNormal">
				<option value="0">Select Value</option>
			</select>
			</div>
		</td>
	</tr>
		
		<tr>
		<td colspan="2" width="50%" class="LABEL">
			<font color="red">*</font> Category		
		</td>
		<td colspan="2" width="50%" class="CONTROL">
			<div id="itemCatId"><select name="strItemCategoryNo" class='comboNormal' onchange="groupNameCombo();">
					<bean:write name="stockStatusRpt1" property="strItemCategoryCombo" filter="false" />
					<option value="0">Select Value</option>
			</select></div>
		</td>
	</tr>
	</table>
	<div id="groupDivId" style="display: none;">
	<table class="TABLEWIDTH" align="center" cellspacing="1px" cellpadding="1px" >  
	<tr>
		<td colspan="2" width="50%" class="LABEL">
			Group Name		
		</td>
		<td colspan="2" width="50%" class="CONTROL">
			<div id="groupId"><select name="strGroupId" class='comboNormal'>
					
					<option value="0">All</option>
			</select></div>
		</td>
	</tr>
	</table>
	</div>
	<table class="TABLEWIDTH" align="center" cellspacing="1px" cellpadding="1px" >  
		
	<tr >
    		<td class ="LABEL" width ="50%"><font color="red">*</font>Date</td>
    		<td class ="CONTROL" width ="50%"><dateTag:date name="strDate" value ="${stockStatusRpt1.strCtDate}"></dateTag:date></td>
  		</tr>
	
	</table>
	
		
	<table class="TABLEWIDTH" align="center" cellspacing="1px" cellpadding="1px" >  	
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
			<html:checkbox property="strIsFooter" name="stockStatusRpt1" value="1"></html:checkbox>
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
			 <td colspan="4"><font color='red'>*</font>Mandatory Field</td>
		</tr>
	</table>
	<!-- <table border="0" class="TABLEWIDTH" align="center" cellspacing="1px" cellpadding="1px">
		<tr>

			<td align="center">
			<img style="cursor: pointer" src="../../hisglobal/images/btn-generate.png" onClick="return validate();" />
			<img style="cursor: pointer" src="../../hisglobal/images/btn-clr.png" onClick="clearButton();" >
			<img style="cursor: pointer" src="../../hisglobal/images/btn-ccl.png" onClick="cancelFunc();" >
			</td>
			
		</tr>
	</table>-->
	<br>
<div align="center" id="">					 
					 	<a href="#" class="button" id="" onclick=' return validate();'><span class="generate">Generate</span></a>
						<a href="#" class="button"	onclick="clearButton();"><span class="clear">Clear</span></a> 
						<a href="#" class="button" onclick="cancelFunc();"><span class="cancel">Cancel</span></a>
				</div>
<input type="hidden" name="hmode"/>
<input type="hidden" name="strCtDate" value="${stockStatusRpt1.strCtDate}"/>

</html:form>
<tag:autoIndex></tag:autoIndex>
</body>
</html>