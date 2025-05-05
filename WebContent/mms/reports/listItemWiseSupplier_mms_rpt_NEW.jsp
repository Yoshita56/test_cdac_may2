<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<%@taglib uri="/WEB-INF/dateTag.tld" prefix="dateTag"%>
<%@ taglib uri="/WEB-INF/hisTab.tld" prefix="tag"%>


<html>
<head>

<title>Rate Contract Detail</title>
<!-- <link href="../../hisglobal/css/autocomplete.css" rel="stylesheet" type="text/css">
<link href="../../hisglobal/css/calendar-tas.css" rel="stylesheet" type="text/css">
<link href="../../hisglobal/css/popup.css" rel="stylesheet" type="text/css">	
<link href="../../hisglobal/css/dwh.css" rel="stylesheet" type="text/css">
<link href="../../hisglobal/css/control.css" rel="stylesheet" type="text/css">
 -->
 <!-- <link href="../../hisglobal/css/dwh.css" rel="stylesheet" type="text/css"> -->
 <link href="../../hisglobal/css/autocomplete.css" rel="stylesheet" type="text/css">
<link href="../css/master.css" rel="stylesheet" type="text/css">
<link href="../../hisglobal/css/tab.css" rel="stylesheet" type="text/css">
<link href="../../hisglobal/css/calendar-tas.css" rel="stylesheet" type="text/css">
<link href="../../hisglobal/css/buttons.css" rel="stylesheet" type="text/css">
<link href="../../hisglobal/css/popup.css" rel="stylesheet" type="text/css">	

<script language="JavaScript" src="../../hisglobal/jquery/3.6.0.min.js"></script>

<script language="JavaScript" src="../../hisglobal/js/jquery.autocomplete.min.js"></script>	
<script language="JavaScript" src="../../masterutil/js/master.js"></script>
<script language="JavaScript" src="../../hisglobal/js/tab.js"></script>
<script language="JavaScript" src="../../hisglobal/js/calendar.js"></script>
<script language="Javascript" src="../../hisglobal/js/validation.js"></script>
<script language="Javascript" src="../../hisglobal/js/util.js"></script>
<script language="Javascript" src="../../hisglobal/js/autocompleteItemSearch.js"></script>
<script type="text/javascript"><!--
$(function() {	
	loadAutocompleteItems();
});

function loadAutocompleteItems()
{
	$('#strSearchDrug').val("");
	displaySelectedDrug("strItemId");
	 	
	var itemList = [];
	$('#strItemId option').each(function() {
	    itemList.push({ "value" :this.textContent , "data" : this.value });
	});

	$('#strSearchDrug').autocomplete({
	   lookup: itemList,
	   minChars:3,
	   onSelect: function (suggestion) {        
	     getDrugNameSelected(suggestion.data,"strItemId");	     
	   }	    
	});
	 
	$('#strSearchDrug').click(function(){	 
		$(this).val("");
	});
}

function onLoadCancelCheck() {
	
	var seatId= '<%=(String) request.getSession().getAttribute("SEATID")%>';
	if(seatId== "null")
	{
		document.getElementById('cancelBtn').style.display='none';
	}	
 }

function validate(){

	var hisValidator = new HISValidator("listItemWiseSupplierRPT1");

	hisValidator.addValidation("strItemCategoryNo", "dontselect=0","Please Select Item Category");
	//hisValidator.addValidation("strItemId", "dontselect=0","Please Select Item Name");
	hisValidator.addValidation("strSupplierId", "dontselect=-1","Please Select Supplier Name");

	if(document.getElementsByName("strActiveOrNearExpiry")[1].checked == true)
	{
		hisValidator.addValidation("strFrmExpiryDays", "req","Expiry days is a mandatory field");
	}
	var retVal = hisValidator.validate();
	hisValidator.clearAllValidations();
	if(retVal)
	{
		if( parseInt(document.getElementsByName("strFrmExpiryDays")[0].value) ==0)
		{
			alert("Please select the Expiry Days > 0");
			document.getElementsByName("strFrmExpiryDays")[0].focus();
			return false;
		}	
			document.forms[0].hmode.value = "SHOWRPT";
		
			if(document.forms[0].strReportFormat[document.forms[0].strReportFormat.selectedIndex].value == "html")
			{
				document.forms[0].target = "_self";
			}
			else
			{
				document.forms[0].target = "_blank";
			}
			document.forms[0].submit();
	}
	else
	{
		return false;
	}
	
}
	
function cancelPage(){
	document.forms[0].hmode.value="CANCEL";
	document.forms[0].target = "_self";
	document.forms[0].submit();

}

function onLoadPage(){

	document.getElementsByName("strActiveOrNearExpiry")[0].checked = true;

	//document.forms[0].strItemCategoryNo.value = "0";
	displaySelectedDrug("strItemId");
}

function groupNameCombo()
{
   var mode ="GROUPNAME";
  // alert("itemcatno"+document.forms[0].strItemCategoryNo.value);  
   var url="ListItemWiseSupplierRptCNT_NEW.cnt?hmode=GROUPNAME&itemCatNo="+document.forms[0].strItemCategoryNo.value;
   ajaxFunction(url,"1");
} 

function subGroupNameCombo()
{
	var mode ="SUBGROUPNAME";  
   var url="ListItemWiseSupplierRptCNT_NEW.cnt?hmode=SUBGROUPNAME&groupId="+document.forms[0].strGroupId.value+
   								"&itemCateg=10";    //+document.forms[0].strItemCategoryNo.value;
   ajaxFunction(url,"2");
} 

function itemNameCombo()
{
	if(document.forms[0].strGroupId.value!="0"){
		var mode ="ITEMNAME";
	   var url="ListItemWiseSupplierRptCNT_NEW.cnt?hmode=ITEMNAME&itemCatNo="+document.forms[0].strItemCategoryNo[document.forms[0].strItemCategoryNo.selectedIndex].value+
	   				"&groupId="+document.forms[0].strGroupId[document.forms[0].strGroupId.selectedIndex].value+
	   				"&subgrpid="+document.forms[0].strSubGroupId.value;
	   ajaxFunction(url,"3");
   }
} 
function getDrugName()
{


}
function getAjaxResponse(res,mode)
{
	var objVal;
	var objVal1;
	if(mode=="1")
	{	
	   var err = document.getElementById("errMsg");
	   var temp1 = res.split("####");
	   if(temp1[0] == "ERROR")
	   {
         err.innerHTML = temp1[1];	
       }else
        {
          var res1=res.split("^")[0];
          var res2=res.split("^")[1];
        objVal= document.getElementById("groupId");
		  objVal.innerHTML = "<select name ='strGroupId' class='comboMax' onChange='itemNameCombo();'>" + res1 + "</select>";
		  objVal1= document.getElementById("strsupplire");
		  objVal1.innerHTML = "<select name ='strSupplierId' class='comboMax' onChange=' '>" + res2 + "</select>";
        }
        subGroupNameCombo();
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
        	
          objVal= document.getElementById("subGroupId");
		  objVal.innerHTML = "<select name ='strSubGroupId' class='comboNormal' onChange='itemNameCombo()'>" + temp[0] + "</select>";
		   
		  objVal= document.getElementById("ItemId");
		  objVal.innerHTML = "<select id='strItemId' name ='strItemId' class='comboTooMax1' >" + temp[1] + "</select>";
		  
		  objVal= document.getElementById("strDrugCodeId");
		  objVal.innerHTML = "<select name ='strDrugCode' class='comboNormal' onChange='getSelectedDrugName();'>" + temp[2] + "</select>";
		  
		  loadAutocompleteItems();
		     
        }
    }
     if(mode=="3")
	{	
	   var err = document.getElementById("errMsg");
	   var temp1 = res.split("####");
	   if(temp1[0] == "ERROR")
	   {
         err.innerHTML = temp1[1];	
       }else
        {
        	objVal= document.getElementById("ItemId");
		    objVal.innerHTML = "<select id='strItemId' name ='strItemId' class='comboMax' >" + res + "</select>";
		    loadAutocompleteItems();		   
        }
    }
}

function getExpiryDays()
{
	if(document.getElementsByName("strActiveOrNearExpiry")[0].checked == true)
		document.getElementById("expDaysDiv").style.display = 'none';
	else
			document.getElementById("expDaysDiv").style.display = '';
}


function getSelectedDrugName()
{
	var flag = 0;
	var sel = document.forms[0].strItemId;

	var str = document.getElementsByName("strDrugCode")[0].value.toUpperCase();
		
	for (i=0; i<sel.options.length; i++) 
	{

		if ( sel.options[i].text.toUpperCase().indexOf(str)==0) 
		{
			sel.selectedIndex = i;
			flag = 1;
			break;
		}
	}
	if(flag == 0)
	{
		for (i=0; i<sel.options.length; i++) 
		{
	       if ( sel.options[i].text.toUpperCase().indexOf(str)> -1 ) 
	       {
				sel.selectedIndex = i;
				flag = 1;
				break;
		   }
		}
	
	}
	if(flag == 0)
	{
		sel.selectedIndex=0;
	}
	else
	{
		$('#strSearchDrug').val("");
		displaySelectedDrug("strItemId");
	}	
}
function clearButton(){	 
	 document.forms[0].reset();
	 document.getElementsByName("strActiveOrNearExpiry")[0].checked = true;	
	 displaySelectedDrug("strItemId");	
}

--></script>
</head>
<body class="background" onload="onLoadPage();onLoadCancelCheck();">
<html:form  action="/reports/ListItemWiseSupplierRptCNT_NEW" method="post" styleClass="formbg">
	
<div class="errMsg" id="errMsg"><bean:write name="listItemWiseSupplierRPT1" property="strErrMsg"/></div>
<div class="normalMsg" id="normalMsg"><bean:write name="listItemWiseSupplierRPT1" property="strNormalMsg"/></div>
<div class="warningMsg" id="warningMsg"><bean:write name="listItemWiseSupplierRPT1" property="strWarningMsg"/></div>


<table class="TABLEWIDTH" align="center" cellspacing="1px" cellpadding="1px" >   
	<tr class="HEADER">
			<td colspan="4" class='all-four-rounded-corners'>Rate Contract Detail</td>
		</tr>
		
		<tr>
			<td class="LABEL" colspan="4">
				<input type="radio" name="strActiveOrNearExpiry"   value="1" onclick="getExpiryDays();">Active
				<input type="radio" name="strActiveOrNearExpiry" value="2" onclick="getExpiryDays();">Near Expiry
			</td>
		</tr>
		
		
		<tr>
		<td colspan="2" width="25%" class="LABEL">
			<font color="red">*</font> Category	</td>
		<td colspan="2" width="25%" class="CONTROL">
			<select name="strItemCategoryNo" class="comboMax"  onChange="groupNameCombo();">
					<bean:write name="listItemWiseSupplierRPT1" property="strItemCategoryCombo" filter="false" />
			</select>
		</td>
		</tr>
		<tr>
		<td colspan="2" width="50%" class="LABEL">Group Name</td>
		<td colspan="2" width="50%" class="CONTROL">
			<div id="groupId"><select name="strGroupId" class="comboMax" onchange="itemNameCombo();">
					
					<bean:write name="listItemWiseSupplierRPT1" property="strGroupCombo" filter="false" />
			</select></div>
		</td>
		<td colspan="1" width="25%" class="LABEL"></td>
		<td colspan="1" width="25%" class="CONTROL"></td>
		</tr>
		<tr style="display: none;">
		<td colspan="2" class="LABEL">Sub Group Name</td>
		<td colspan="2" class="CONTROL">
			<div id="subGroupId" >
			<select name="strSubGroupId" class="comboNormal" onChange="itemNameCombo();">
					<option value="0">All</option>
			       </select></div>
		</td>
	</tr>
	
	   <tr style="display: none;">
			<td width="25%" colspan="1" class="LABEL"><font color="red">*</font>Code</td>
			<td width="25%" colspan="1" class="CONTROL">
			<div id="strDrugCodeId" >
				<select name="strDrugCode" class="comboMax"  onChange="getSelectedDrugName();">
					<bean:write name="listItemWiseSupplierRPT1" property="strCodeCombo" filter="false"/>
				</select>
			</div>				
			</td>
			
		   <td width="50%" colspan="2" class="CONTROL">
			<div id="ItemId" style="display: none;">
			   <select id="strItemId" name="strItemId" class="comboMax" >
					<bean:write name="listItemWiseSupplierRPT1" property="strItemCombo" filter="false" />
			   </select>
			   </div>
		</td>		
	</tr>
	<tr>
		<td width="50%" colspan="2" class="LABEL">Item Name</td>
		<td width="50%" colspan="2" class="CONTROL"><input type="text" id="strSearchDrug" class="" name="strSearchDrug" size="70%" /></td>
	</tr>

	<tr>
		<td class="LABEL" width="50%" colspan="2"><font color="red">*</font>Selected Item Name</td>
		<td class="CONTROL" width="50%" colspan="2">
		<div id="DrugNameId" style="color: blue; font-weight: bold"></div>
		</td>
	</tr>
		
	
<%-- Supplier Name	 --%>		
		<tr>
			<td width="50%" colspan="2" class="LABEL"><font color="red">*</font>Supplier Name</td>
			<td width="50%" colspan="2" class="CONTROL">
			<div id="strsupplire" >
				<select name="strSupplierId" class="comboMax" >
					<bean:write name="listItemWiseSupplierRPT1" property="strManufactureCombo" filter="false"/>
				</select>
			</div>				
			</td>
			</tr>
			<tr>
			<td width="50%" colspan="2" class="LABEL"><font color="red">*</font>Rate Contract Type</td>
			<td width="50%" colspan="2" class="CONTROL">
			<div id="strStoreDivId" >
				<select name="strRateContractTypeId" class="comboMax">
					<bean:write name="listItemWiseSupplierRPT1" property="strRateContractTypeCombo" filter="false"/>
				</select>
			</div>				
			</td>
		</tr>		
	
		
		
		<tr id="expDaysDiv" style="display:none;">
	        <td width="50%" colspan="2" class="LABEL"><font color="red">*</font>Expiry Days</td>			        
			<td width="50%" colspan="2" class="CONTROL">
	              <input class="txtFldNormal" type="text" name="strFrmExpiryDays" onkeypress="return validateData(event,5);" maxlength="3" >
		    </td>				    
		    <!--<td width="25%" class="LABEL"></td>			        
			<td width="25%" class="CONTROL"></td>
	    --></tr>
	    
	    <tr>
	    
	    
	    
	    
	    
	    </tr>	
		
		
		<tr>
			<td width="50%" colspan="2" class="LABEL">Report Format</td>
			<td width="50%" colspan="2" class="CONTROL">
			<select name="strReportFormat"  onchange="">
			<option value="html">Html</option>
			<option value="pdf">Pdf</option>
			<option value="xls">Excel</option></select>
			</td>
			
		</tr> 
		
		<tr>
			<td width="50%" colspan="2" class="LABEL">
			Footer Required
			</td>
			<td width="50%" colspan="2" class="CONTROL">
			<html:checkbox property="strIsFooter" name="listItemWiseSupplierRPT1" value="1"></html:checkbox>
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
			 <td colspan="4" class='all-four-rounded-corners'> <font size="2" color="red">*</font> Mandatory Fields</td>
		</tr>
	</table>

	<!-- <div><div class="legends"><font size="2" color="red">*</font> Mandatory Fields</div> -->
	<div class="control_button">
	<table  class="TABLEWIDTH" align="center">
	<tr>
	<td align="center"><div>
				<br>
				<a href="#" class="button" onClick="return validate();"><span class="generate">Generate</span></a>
				<a href="#" class="button" onClick="clearButton();"><span class="clear">Clear</span></a>
				<a href="#" id='cancelBtn' class="button" onClick="cancelPage();"><span class="cancel">Cancel</span></a>				 
				</div></td>
	</tr>	  
	</table>
	</div></div>
	
	
	
<input type="hidden" name="hmode"/>

</html:form>
<tag:autoIndex></tag:autoIndex>
</body>
</html>