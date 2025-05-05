<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
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
<script language="Javascript" src="../../hisglobal/js/autocompleteItemSearch.js"></script>
<script language="JavaScript" src="../../hisglobal/jquery/3.6.0.min.js"></script>

<script language="JavaScript" src="../../hisglobal/js/jquery.autocomplete.min.js"></script>



<script type="text/javascript">

function validate(){


 			 var hisValidator = new HISValidator("conumptionRptBean");
            hisValidator.addValidation("strStoreId", "dontselect=0", "Please Select Store Combo" );
            hisValidator.addValidation("strItemCategNo", "dontselect=0", "Please Select Item Category Combo" );
          
		  
		  if(document.getElementsByName("dateYearWise")[0].checked){
		  		  hisValidator.addValidation("strFromDate", "date","From Date is a mandatory field");
				  hisValidator.addValidation("strToDate", "date","To Date is a mandatory field");
		  		  hisValidator.addValidation("strToDate","dtltet="+document.forms[0].strCurrentDate.value,"Please Select To Date Less Than or Equal To Current Date");
			      hisValidator.addValidation("strToDate","dtgtet="+document.forms[0].strFromDate.value,"Please Select To Date Greater Than Or Equal To From Date");
		  }else{
		  	 	hisValidator.addValidation("strFromYear", "req","From Year is a mandatory field");
				hisValidator.addValidation("strToYear", "req","To Year is a mandatory field"); 
				hisValidator.addValidation("strFromYear","numltet="+document.forms[0].strToYear.value,"Please Select To Year Greater Than or Equal To From Year ");
		  }
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
   var url="IssueDetailRptCNT.cnt?hmode="+mode+"&strId="+document.forms[0].strStoreId.value;
   ajaxFunction(url,"1");
}
function setValueChk(){




	if(document.getElementsByName("dateYearWise")[0].checked){
		document.getElementById("dateWiseId").style.display="block";
		document.getElementById("yearWiseId").style.display="none";
		document.getElementsByName("dateYearWise")[0].value="1";
		document.getElementsByName("strUserRemarks")[0].value="";
		document.getElementsByName("strItemCategNo")[0].value="0";
		document.getElementsByName("strStoreId")[0].value="0";
		document.forms[0].strFromDate.value = document.forms[0].strCurrentDate.value;
	 	document.forms[0].strToDate.value = document.forms[0].strCurrentDate.value;
		
	}else {
		document.getElementById("dateWiseId").style.display="none";
		document.getElementById("yearWiseId").style.display="block";
		document.getElementsByName("dateYearWise")[1].value="2";
		document.getElementsByName("strUserRemarks")[0].value="";
		document.getElementsByName("strItemCategNo")[0].value="0";
		document.getElementsByName("strStoreId")[0].value="0";
		document.forms[0].strFromYear.value="";
	 	document.forms[0].strToYear.value="";
	}
}


$(function() {	
	loadAutocompleteItems();	
});

function loadAutocompleteItems()
{
	$('#strSearchDrug').val("");
	displaySelectedDrug("strDrugName");
	
	var itemList = [];			
	$('#strDrugName option').each(function() {
	    itemList.push({ "value" :this.textContent , "data" : this.value });
	});

	$('#strSearchDrug').autocomplete({
	   lookup: itemList,
	   minChars:3,
	   onSelect: function (suggestion) {        
	     getDrugNameSelected(suggestion.data, "strDrugName");
	     getDrugNameSelectedInLeftBox(suggestion.data, "strLeftItemIds");	     
	   }	    
	 });
	 
	 $('#strSearchDrug').click(function(){	 
	 	$(this).val("");
	 });		
}

function getDrugNameSelectedInLeftBox(itemId, selectId)
{	
	var flag = 0;
	var sel = document.getElementById(selectId);
	
	for (i=0; i<sel.options.length; i++) {				
		if ( sel.options[i].value == itemId) 
		{
			sel.selectedIndex = i;			
			flag = 1;
			break;
		}				
	}	
	if(flag == 0)
	{
		sel.selectedIndex=0;
		document.forms[0].strSearchDrug.value = "";
	}	 
	else
	{
		showSelection(sel);
	}   
	 
}

function onLoadPage(){

	document.forms[0].strStoreId.value="0";
	document.forms[0].strItemCategNo.value="0";
	
	if(document.forms[0].dateYearWise[0].checked){
			document.getElementById("dateWiseId").style.display = "block";
			document.getElementById("yearWiseId").style.display = "none";
			document.forms[0].strFromDate.value=document.forms[0].strCtDate.value;
			document.forms[0].strToDate.value=document.forms[0].strCtDate.value;
		}else if(document.forms[0].dateYearWise[1].checked){
			document.getElementById("dateWiseId").style.display = "none";
			document.getElementById("yearWiseId").style.display = "block";
			document.forms[0].strFromYear.value="";
			document.forms[0].strToYear.value="";
		}
	

}
function LeftListTransfer()
{
	var ob1=document.forms[0].strLeftItemIds.value;
	var ob=document.getElementById("LeftItemIds");
	shiftToRight("strLeftItemIds","strRightItemIds",1);
}

function getDrugName()
{
		if(document.forms[0].strDistrictStoreId)
		{
			var districtPresent=document.forms[0].strDistrictStoreId.value;
		}
		else{
		var districtPresent='0^0';
		}
		var url ="StockOnHandRptCNT_NEW.cnt?hmode=DRUGNAME&storeId="+document.forms[0].strStoreId.value+
		         "&itemcat="+document.forms[0].strItemCatNo.value+
		         "&groupId="+document.forms[0].strGroupId.value+
		         "&itemType="+document.forms[0].strItemType.value+
	   			 "&statusId="+document.forms[0].strStatusId.value+
	   			 "&districtStoreId="+districtPresent;	    
	    
	   			  ajaxFunction(url,"7");
	   			  shiftAllToLeft('strLeftItemIds','strRightItemIds',1);
}
function getAjaxResponse(res,mode){
	
	
	if(mode=="1"){ 
	
			var objVal= document.getElementById("itemCatDivId");
			objVal.innerHTML = "<select name ='strItemCatNo' class='comboNormal' onchange='getGroupCmb();'>"+res+"</select>";
			getDrugName();		
	}	
	
	if(mode=="2"){			     
			
			var objVal= document.getElementById("districtCmbDivId");
			objVal.innerHTML = "<select name ='strDistrictId' class='comboNormal' onchange='getStoreCmb();'>"+res+"</select>";	
	}

	if(mode=="4")
	{ 	    
	
			var objVal= document.getElementById("storeTypeDivId");	
			
			objVal.innerHTML = "<select name ='strStoreTypeId' class='comboNormal' onchange='getSubStoreCmb();'>"+res+"</select>";	
			//getProgName();
	
	}	
		
	if(mode=="5"){
			
			var objVal= document.getElementById("strSubStoreDivId");			
			objVal.innerHTML = "<select name ='strStoreId' class='comboNormal' onchange='getDrugName1();'>"+res+"</select>";	
	}	
	
	if(mode=="6")
	{ 
		 var objVal= document.getElementById("groupDivId");
		 var temp= "<select name ='strGroupId' class='comboNormal' onchange='getDrugName3();'>"+res.split("^")[0]+"</select><input type='checkbox' name='strIsGroupWise' value='1' checked='checked'>Group Wise Report";

		 var objVal1= document.getElementById("itemDivId");
		 var temp1= "<select name ='strItemType' class='comboNormal' onchange=' '>"+res.split("^")[1]+"</select><input type='checkbox' name='strIsItemWise' value='1' checked='checked'>Item Wise Report";

		objVal.innerHTML = temp;
		objVal1.innerHTML = temp1;
		getDrugName();
	}
	
	if(mode=="7")
	{ 
		
			var objVal= document.getElementById("LeftItemIds");
			objVal.innerHTML = "<select id='strLeftItemIds' name='strLeftItemIds' size='6' multiple style='width: 280px' onChange='showSelection(this);' >"+res.split("^")[0] +"</select>";
			
			
			var objVal1= document.getElementById("drugNameDivId");
			objVal1.innerHTML = "<select id='strDrugName' name='strDrugName' class='comboNormal'  >"+res.split("^")[0]+"</select>";
			loadAutocompleteItems();
			
			document.forms[0].strSearchDrug.value='';
			
			document.getElementById("txtFromLeftMutltiSelectCombo").innerHTML	=	'';
			document.getElementById("txtFromLeftMutltiSelectCombo").style.display='none';

			/* var objVal2= document.getElementById("groupDivId");
			 var temp= "<select name ='strGroupId' class='comboNormal' onchange='getDrugName();'>"+res.split("^")[1]+"</select><input type='checkbox' name='strIsGroupWise' value='1' checked='checked'>Group Wise Report";

			 var objVal3= document.getElementById("itemDivId");
			 var temp1= "<select name ='strItemType' class='comboNormal' onchange='getDrugName();'>"+res.split("^")[2]+"</select><input type='checkbox' name='strIsItemWise' value='1' checked='checked'>Item Wise Report";
			 objVal2.innerHTML = temp;
			 objVal3.innerHTML = temp1;*/
					
	}
	
	if(mode=="8"){ 
			
			var objVal1= document.getElementById("progNameDivId");
			objVal1.innerHTML = "<select id='strProgId' name='strProgId' class='comboNormal'  >"+res+"</select>";
	getDrugName1();
	}
	if(mode=="9")
	{ 
			var objVal= document.getElementById("LeftItemIds");
			objVal.innerHTML = "<select id='strLeftItemIds' name='strLeftItemIds' size='6' multiple style='width: 280px' onChange='showSelection(this);' >"+res.split("^")[0] +"</select>";
			
			
			var objVal1= document.getElementById("drugNameDivId");
			objVal1.innerHTML = "<select id='strDrugName' name='strDrugName' class='comboNormal'  >"+res.split("^")[0]+"</select>";
			loadAutocompleteItems();
			
			document.forms[0].strSearchDrug.value='';
			
			document.getElementById("txtFromLeftMutltiSelectCombo").innerHTML	=	'';
			document.getElementById("txtFromLeftMutltiSelectCombo").style.display='none';
			var objVal3= document.getElementById("itemDivId");
			 var temp1= "<select name ='strItemType' class='comboNormal' onchange='getDrugName4();'>"+res.split("^")[2]+"</select><input type='checkbox' name='strIsItemWise' value='1' checked='checked'>Item Wise Report";
			 objVal3.innerHTML = temp1;
					
	}
	if(mode=="10")
	{ 
			var objVal= document.getElementById("LeftItemIds");
			objVal.innerHTML = "<select id='strLeftItemIds' name='strLeftItemIds' size='6' multiple style='width: 280px' onChange='showSelection(this);' >"+res.split("^")[0] +"</select>";
			
			
			var objVal1= document.getElementById("drugNameDivId");
			objVal1.innerHTML = "<select id='strDrugName' name='strDrugName' class='comboNormal'  >"+res.split("^")[0]+"</select>";
			loadAutocompleteItems();
			
			document.forms[0].strSearchDrug.value='';
			
			document.getElementById("txtFromLeftMutltiSelectCombo").innerHTML	=	'';
			document.getElementById("txtFromLeftMutltiSelectCombo").style.display='none';
			
					
	}
					
}	
</script>
</head>
<body onload="onLoadPage();">
<html:form action="/reports/ConsumptionDetailRptCNT" method="post">
	
<div class="errMsg" id="errMsg"><bean:write name="conumptionRptBean" property="strErrMsg"/></div>
<div class="normalMsg" id="normalMsg"><bean:write name="conumptionRptBean" property="strNormalMsg"/></div>
<div class="warningMsg" id="warningMsg"><bean:write name="conumptionRptBean" property="strWarningMsg"/></div>


	<tag:tab tabLabel="Consumption Detail"
                        selectedTab="FIRST" align="center" width="TABLEWIDTH">
                  </tag:tab>

	<table class="TABLEWIDTH" align="center" cellspacing="1px" cellpadding="1px" >   
	<tr class="HEADER">
			<td colspan="4"></td>
		</tr>
		
		<tr>
			<td class="LABEL" colspan="4">
				<input type="radio" name="dateYearWise" checked="checked" value="1" onclick="setValueChk();">Date Wise
				<input type="radio" name="dateYearWise" value="2"  style="display:none"   onclick="setValueChk();">
				
				
			</td>
		</tr>
		 <tr>
			<td width="50%" class="LABEL" colspan="2"><font color="red">*</font>Hospital name</td>
			<td width="50%" class="CONTROL" colspan="2">
			<select name="strHospitalCode" class="comboNormal">
			<bean:write name="conumptionRptBean" property="strHospNameValues" filter="false"/>
			</select>
			</td>			
		</tr>	
		
		
		
			
		<tr>
			<td width="50%" colspan="2" class="LABEL">
			<font color="red">*</font>Store Name
			</td>
			<td width="50%" colspan="2" class="CONTROL">
			<select name="strStoreId"  onchange="getItemCateg();" class="comboNormal">
			<bean:write name="conumptionRptBean" property="strStoreVal" filter="false" /></select>
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
		</table>
		<div id="dateWiseId" style="display:block">
		<table class="TABLEWIDTH" align="center" cellspacing="1px" cellpadding="1px" >   
		<tr>
			<td width="50%" colspan="2" class="LABEL">
			<font color="red">*</font>From Date
			</td>
			<td width="50%" colspan="2" class="CONTROL">
				<dateTag:date name="strFromDate"
				 value="${conumptionRptBean.strCurrentDate}"/>
			</td>
			
		</tr> 
		<tr>
			<td width="50%" colspan="2" class="LABEL">
			<font color="red">*</font>To Date
			</td>
			<td width="50%" colspan="2" class="CONTROL">
				<dateTag:date name="strToDate"
				 value="${conumptionRptBean.strCurrentDate}"/>
			</td>
			
		</tr> 
		</table>
		</div>
		<div id="yearWiseId" style="display:none">
		<table class="TABLEWIDTH" align="center" cellspacing="1px" cellpadding="1px" >   
		<tr>
			<td width="50%" colspan="2" class="LABEL">
			<font color="red">*</font>From Year
			</td>
			<td width="50%" colspan="2" class="CONTROL">
				<input type="text" name="strFromYear" value="" class='txtFldMin' maxlength="4">
			</td>
			
		</tr> 
		<tr>
			<td width="50%" colspan="2" class="LABEL">
			<font color="red">*</font>To Year
			</td>
			<td width="50%" colspan="2" class="CONTROL">
				<input type="text" name="strToYear" value="" class='txtFldMin' maxlength="4">
			</td>
			
		</tr> 
		</table>
		</div>
		
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
			<html:checkbox property="strIsFooter" name="conumptionRptBean" value="1"></html:checkbox>
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
	<!--<table border="0" class="TABLEWIDTH" align="center" cellspacing="1px" cellpadding="1px">
		<tr>

			<td align="center">
			<img style="cursor: pointer" src="../../hisglobal/images/btn-generate.png" onClick="return validate();" />
			<img style="cursor: pointer" src="../../hisglobal/images/btn-clr.png" onClick="document.forms[0].reset();" >
			<img style="cursor: pointer" src="../../hisglobal/images/btn-ccl.png" onClick="cancelFunc();" >
			</td>
			
		</tr>
	</table>-->
	<br>
<div align="center" id="">					 
					 	<a href="#" class="button" id="" onclick=' return validate();'><span class="generate">Generate</span></a>
						<a href="#" class="button"	onclick="document.forms[0].reset()"><span class="clear">Clear</span></a> 
						<a href="#" class="button" onclick="cancelFunc();"><span class="cancel">Cancel</span></a>
				</div>
<input type="hidden" name="hmode"/>
<input type="hidden" name="strCurrentDate" value="${conumptionRptBean.strCurrentDate}" />

</html:form>
<tag:autoIndex></tag:autoIndex>
</body>
</html>