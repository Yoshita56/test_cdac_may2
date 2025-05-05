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


 		var hisValidator = new HISValidator("issueRptBean");
 		
 		
 		
        hisValidator.addValidation("strStoreId", "dontselect=0", "Please Select Store Combo" );
        hisValidator.addValidation("strItemCategNo", "dontselect=0", "Please Select Item Category Combo" );
        hisValidator.addValidation("strFromDate", "date","From Date is a mandatory field");
		hisValidator.addValidation("strToDate", "date","To Date is a mandatory field");
		hisValidator.addValidation("strToDate","dtltet="+document.forms[0].strCurrentDate.value,"Please Select To Date Less Than or Equal To Current Date");
		hisValidator.addValidation("strToDate","dtgtet="+document.forms[0].strFromDate.value,"Please Select To Date Greater Than Or Equal To From Date");
	       	 
        
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
        objVal.innerHTML = "<select name = 'strItemCategNo' class='comboNormal' onchange='getDrugName();' >" + res + "</select>";
		      
   }
   
   if(mode=="2")
   {
        var objVal = document.getElementById("drugNameDivId");
        objVal.innerHTML = "<select name = 'strItemBrandId' class='comboNormal'   onchange='getBatchNo();' >" + res + "</select>";
		      
   }
   
   if(mode=="3")
   {
   	//alert("res"+res);
        var objVal = document.getElementById("ExistingBatchId");
        objVal.innerHTML = "<select name = 'strBatchNo' class='comboNormal'  >" + res + "</select>";
		      
   }
       
     
}



function getItemCateg(){
 	var mode="ITEMCATEGORYCOMBO";
   var url="ItemInventoryRptCNT.cnt?hmode="+mode+"&strId="+document.forms[0].strStoreId.value;
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

	document.forms[0].strStoreId.value = "0";
	document.forms[0].strFromDate.value = document.forms[0].strCurrentDate.value;
	document.forms[0].strToDate.value = document.forms[0].strCurrentDate.value;
	
}

function onClearButton(){

if((document.getElementsByName("strCase")[0].checked)||(document.getElementsByName("strCase")[1].checked)||
		(document.getElementsByName("strCase")[2].checked)){

	document.forms[0].strStoreId.value = "0";
	document.forms[0].strItemCategNo.value = "0";
	document.forms[0].strFromDate.value = document.forms[0].strCurrentDate.value;
	document.forms[0].strToDate.value = document.forms[0].strCurrentDate.value;
	}
}

function getDrugName()
{
	if(document.forms[0].strItemCategNo.value == "0")
	{
		document.forms[0].strItemBrandId.innerHTML = "<option value='0'>Select Value</option>";
		document.forms[0].strBatchNo.innerHTML = "<option value='0'>All</option>";
	}
	else
	{
		var mode="DRUGNAMECOMBO";
   		var url="IssueDetailRptCNT.cnt?hmode="+mode+"&catCode="+document.forms[0].strItemCategNo.value;
   		ajaxFunction(url,"2");
	}
	
}


function getBatchNo()
{
	var mode="EXISTINGBATCH";
   var url="IssueDetailRptCNT.cnt?hmode="+mode
	+"&strItemBrandId="+ document.forms[0].strItemBrandId.value 
	+ "&storeId="+ document.forms[0].strStoreId.value;
	
   ajaxFunction(url,"3");
   
}

</script>
</head>
<body onload="onLoadPage();">
<html:form action="/reports/ItemInventoryRptCNT" method="post">
	
<div class="errMsg" id="errMsg"><bean:write name="issueRptBean" property="strErrMsg"/></div>
<div class="normalMsg" id="normalMsg"><bean:write name="issueRptBean" property="strNormalMsg"/></div>
<div class="warningMsg" id="warningMsg"><bean:write name="issueRptBean" property="strWarningMsg"/></div>


	<tag:tab tabLabel="Offline Item Entry Report"
                        selectedTab="FIRST" align="center" width="TABLEWIDTH">
                  </tag:tab>

	<table class="TABLEWIDTH" align="center" cellspacing="1px" cellpadding="1px" >   
	<tr class="HEADER">
			<td colspan="4"></td>
		</tr>
		
		<tr style="display: none;">
			<td class="LABEL" colspan="4">
			
				<html:radio property="strCase" name="issueRptBean" value="1" onclick="setValueChk();">Issuing Store</html:radio>
		    	
			
			</td>
		</tr>
		
		 <tr style="display: none;">
			<td width="50%" class="LABEL" colspan="2"><font color="red">*</font>Hospital name</td>
			<td width="50%" class="CONTROL" colspan="2">
			<select name="strHospCode" class="comboNormal">
			<bean:write name="issueRptBean" property="strHospNameValues" filter="false"/>
			</select>
			</td>			
		</tr>	
			
		<tr>
			<td width="50%" colspan="2" class="LABEL">
			<font color="red">*</font>Store Name
			</td>
			<td width="50%" colspan="2" class="CONTROL">
			<select name="strStoreId"  onchange="getItemCateg();" class="comboNormal">
			<bean:write name="issueRptBean" property="strStoreVal" filter="false" /></select>
			</td>
			
		</tr> 
		
		<tr>
			<td width="50%" colspan="2" class="LABEL"><font color="red">*</font>Category</td>
			<td width="50%" colspan="2" class="CONTROL" >
			<div id="itemCategDIV">
				<select name="userId"   class="comboNormal" >
					<bean:write name="issueRptBean" property="strItemCategCmb" filter="false" />
					
				</select>
			</div>
			</td>
			
		</tr> 
		
		
		<tr>
			<td width="50%" colspan="2" class="LABEL"><font color="red">*</font>User</td>
			<td width="50%" colspan="2" class="CONTROL" >
			<div id="userDiv">
				<select name="userId"   class="comboNormal" >
					<bean:write name="issueRptBean" property="userComboString" filter="false" />
					
				</select>
			</div>
			</td>
			
		</tr> 
		
		
		
		
		
		<tr>
			<td width="50%" colspan="2" class="LABEL"><font color="red">*</font>From Date</td>
			<td width="50%" colspan="2" class="CONTROL">
				<dateTag:date name="strFromDate" value="${issueRptBean.strCurrentDate}"/>
			</td>
			
		</tr> 
		
		<tr>
			<td width="50%" colspan="2" class="LABEL"><font color="red">*</font>To Date</td>
			<td width="50%" colspan="2" class="CONTROL">
				<dateTag:date name="strToDate" value="${issueRptBean.strCurrentDate}"/>
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
				<html:checkbox property="strIsFooter" name="issueRptBean" value="1"></html:checkbox>
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
<input type="hidden" name="strCurrentDate" value="${issueRptBean.strCurrentDate}" />

</html:form>
<tag:autoIndex></tag:autoIndex>
</body>
</html>