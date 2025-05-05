<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<%@taglib uri="/WEB-INF/dateTag.tld" prefix="dateTag"%>
<%@ taglib uri="/WEB-INF/hisTab.tld" prefix="tag"%>


<html>
<head>
<title>Item Definition 2</title>
<link href="../../hisglobal/css/tab.css" rel="stylesheet" type="text/css">
<link href="../../hisglobal/css/calendar-tas.css" rel="stylesheet" type="text/css">
<link href="../css/transaction.css" rel="stylesheet" type="text/css">
<link href="../../hisglobal/css/newpopup.css" rel="stylesheet" type="text/css">	
<link href="../../hisglobal/css/autocomplete.css" rel="stylesheet"	type="text/css">
	
<script language="JavaScript" src="../../masterutil/js/master.js"></script>
<script language="JavaScript" src="../../hisglobal/js/tab.js"></script>
<script language="JavaScript" src="../../hisglobal/js/calendar.js"></script>
<script language="Javascript" src="../../hisglobal/js/validation.js"></script>

<script language="Javascript" src="../../hisglobal/js/newpopup.js"></script>
<script language="Javascript" src="../../hisglobal/js/util.js"></script>
<script language="Javascript" src="../js/DrugProfile.js"></script>
<script language="JavaScript" src="../../hisglobal/jquery/3.6.0.min.js"></script>

<script language="JavaScript" src="../../hisglobal/js/jquery.autocomplete.min.js"></script>
<script type="text/javascript">
$(function() {    
	
	var itemList = [];
	$('#strMultiRowItemId option').each(function() {
	    itemList.push({ "value" :this.textContent , "data" : this.value });
	});
	$('strSearchDrug').keyup(function(e){
		if(e.keyCode == 13)
	    {
	    	$(this).trigger("enterKey");
	        getDrugNameSelected(suggestion.data);
	    }
	});
	//alert(itemList.length);
	
	$('#strSearchDrug').autocomplete({
		   lookup: itemList,
		   minChars:3,
		   onSelect: function (suggestion) {        
		     getDrugNameSelected(suggestion.data);	    
		   }	    
		 });
		 
		 $('#strSearchDrug').click(function(){	 
		 	$(this).val("");
		 	closeAllDrugProfile();
		 });	

		 $("#strSearchDrug").focus();
	
  });
  
function handleEnter(obj,eve)
{
	//alert("before 13");
	if(eve.keyCode == 13)
	{
		//alert("13");
		document.forms[0].hmode.value="unspecified";
		document.forms[0].submit();
		
	}
}
  
 /* function count(obj)
  {
	// alert(obj.value.length);
	// return false;
	alert(document.getElementById("strMultiRowItemId").options[0].value);
	if(obj.value.length >= 3)
	{
		document.getElementById("strMultiRowItemId").options[0].selected = true;
		return;
	}
  }*/
</script>
</head>
<body onload="">
<html:form name="drugProfileBean"
	 action="/transactions/DrugProfileCNT" type="mms.transactions.controller.fb.DrugProfileFB">
	

<center>
<table align='center' class='TABLEWIDTH' cellpadding='1px' cellspacing='1px' >
	<tr align='left' class='HEADER'><td colspan='4' width='25%'>Drug Profile</td></tr>
		<tr class='multiLabel'>
		<td  colspan="1" align='right' class="LABEL">Drug Name </td>
		<td colspan="2" align='left'>
			<div id="itemBrandDivId" style="display: none;">
				<select name="strMultiRowItemId" id="strMultiRowItemId" class="comboTooMax" >
					<bean:write name="drugProfileBean" property="strItemBrandCombo" filter="false" />
				</select> 
			</div><input type="text" id="strSearchDrug" placeholder='Enter atleast 3 characters'  name="strSearchDrug" size="120%" onkeypress="handleEnter(this,event);"/> </td>
			 <td colspan="1"></td>
		</tr>
		</table>
		<div id='generic' style='display:none;'></div>
</center>

                 
<div id="normalMsg"></div>

<input type="hidden" name="hmode"/><center>
<div class="" align="center" id="popUpDivId" style="left:70px;top:40px" style="display:block;">

<td align="center">
<div id="itemParameterDtlDivId" align="center"  style="display:block;left:60px;top:40px;"></div>
</td>
</tr>
</table>
</div>
<table align='center' class='TABLEWIDTH' cellpadding='1px' cellspacing='1px'>
<tr align='left' class='FOOTER'><td colspan='4' width='25%'></td></tr>
<tr><td align='center' colspan='2' width='25%'>
<img src='../../hisglobal/images/btn-ccl.png' onClick ='window.parent.closeTab();' style='cursor: pointer; ' title='Cancel Process'></td></tr></table>
</center>
</html:form>
 
</body>
</html>