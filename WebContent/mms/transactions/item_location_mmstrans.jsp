<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic"%>
<%@ taglib uri="/WEB-INF/dateTag.tld" prefix="date"%>
<%@ taglib uri="/WEB-INF/hisTab.tld" prefix="tag"%>
<%@ taglib uri="/WEB-INF/patientDtl.tld" prefix="pDtl"%>
<%@ taglib uri="/WEB-INF/onLineReqDiscountDtl.tld" prefix="DisDtl"%>
<%@ taglib uri="/WEB-INF/crNo.tld" prefix="crNo"%>

<!-- 
/**
 * Developer : Tanvi Sappal 
 * Version : 1.0 
 * Date : 18/June/2009
 * 
 */
-->
<html>
<head>
<meta charset=UTF-8">
<title>Item Search Engine</title>
<link href="../css/master.css" rel="stylesheet" type="text/css">
<link href="../../hisglobal/css/tab.css" rel="stylesheet" type="text/css">
<link href="../../hisglobal/css/calendar-tas.css" rel="stylesheet" type="text/css">

<link href="../../hisglobal/css/popup.css" rel="stylesheet"	type="text/css">
<link href="../../hisglobal/css/newpopup.css" rel="stylesheet" type="text/css">
<link href="../../hisglobal/css/buttons.css" rel="stylesheet" type="text/css">
<link href="../../hisglobal/css/autocomplete.css" rel="stylesheet"	type="text/css">

<script language="JavaScript" src="../../masterutil/js/master.js"></script>
<script language="JavaScript" src="../../hisglobal/js/tab.js"></script>
<script language="JavaScript" src="../../hisglobal/js/calendar.js"></script>
<script language="Javascript" src="../../hisglobal/js/validation.js"></script>
<script language="Javascript" src="../../hisglobal/js/datepicker1.js"></script>
<script language="Javascript" src="../js/searchItems_util.js"></script>
<script language="JavaScript" src="../../hisglobal/js/tab.js"></script>
<script language="Javascript" src="../../hisglobal/js/newpopup.js"></script>
<script language="Javascript" src="../../hisglobal/js/popup.js"></script>
<script language="Javascript" src="../../hisglobal/js/multirow.js"></script>
<script language="Javascript" src="../../hisglobal/js/util.js"></script>
<script language="Javascript" src="../js/item_location_mmstrans.js"></script>
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
			  // alert(suggestion.data);
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

</script>
<style type="text/css">

            .pg-normal 
            {
                color: blue;
                font-weight: normal;
                text-decoration: none;
                cursor: pointer;             
                
            }
            .pg-selected 
            {
                color: red;
                font-weight: bold;
                text-decoration: underline;
                cursor: pointer;
                
            }
            .pg-qualified 
            {
                color: green;
                font-weight: bold;
                text-decoration: underline;
                cursor: pointer;
                
            }
</style>
</head>
<body>
<html:form action="/transactions/ItemLocationTransCNT.cnt" name="itemLocationBean" type="mms.transactions.controller.fb.ItemLocationTransFB" method="post" >
	<center><div class="errMsg" id="errMsg"><bean:write name="itemLocationBean" property="strErrorMsg" /></div>
	<div class="warningMsg" id="warningMsg"><bean:write name="itemLocationBean" property="strWarningMsg" /></div>
	<div class="normalMsg" id="normalMsg"><bean:write name="itemLocationBean" property="strNoramalMsg" /></div>
		
	<tag:tab tabLabel="Item Search Engine" selectedTab="FIRST" align="center" width="TABLEWIDTH"></tag:tab></center>
	
	
	
	<center>
<table align='center' class='TABLEWIDTH' cellpadding='1px' cellspacing='1px' >
<tr class="HEADER">
		<td colspan="4"></td>
	</tr>
<tr>
		<td class="LABEL" width='25%'><font color="red">*</font>Category</td>
		<td width='75%' colspan='3' class="CONTROL"><div id="itemCategoryDivId"><html:radio property="strItemCategoryNo" name="itemLocationBean" value="1" onclick="getStoreList(this);" >Drug</html:radio><html:radio property="strItemCategoryNo" name="itemLocationBean" value="2" onclick="getStoreList(this);" >Item</html:radio> </div></td>
	</tr>
	<tr>
		<td width="25%" class="LABEL"><font color="red">*</font>Store Name</td>
		<td width="75%" colspan="3" class="CONTROL">
			<div id="strStoreDivId" >
				<select name="strStoreId" class="comboMax" onChange="itemCombo();">
					<bean:write name="itemLocationBean" property="strStoreValues" filter="false"/>
				</select>
			</div>		
		</td>
	
		
	</tr>
		<tr class='multiLabel'>
		<td  colspan="1" align='right' class="LABEL">Search </td>
		<td colspan="2" align='left'>
			<div id="itemBrandDivId" style="display: none;">
				<select name="strMultiRowItemId" id="strMultiRowItemId" class="comboTooMax" >
					<bean:write name="itemLocationBean" property="strItemBrandCombo" filter="false" />
				</select> 
			</div><input type="text" id="strSearchDrug" placeholder='Enter atleast 3 characters' name="strSearchDrug" size="140%" onkeypress="handleEnter(this,event);"/> </td>
			
		</tr>
		</table>
		<div id='generic' style='display:none;'></div>
</center>
	
	<div id="strBatchDivId" style="display: none;">
	
	<table class="TABLEWIDTH" align="center" cellpadding="1px" cellspacing="1px">	
	<tr>
		<td width="50%" class="LABEL">
			Batch No		
		</td>
		<td width="50%" class="CONTROL" colspan="3">
			<div id="batchNoId"><select name="strBatchNo" class='comboMax'>
					<bean:write name="itemLocationBean" property="strBatchNoCmb" filter="false" />
					<option value="0">Select Value</option>
			</select></div>
		</td>
	</tr>
	</table>
	</div>
	
	<div id="strBatchItemDivId" style="display: none;">
	<table class="TABLEWIDTH" align="center" cellpadding="1px" cellspacing="1px">	
	<tr>
		<td width="50%" class="LABEL">
			Item Serial No		
		</td>
		<td width="50%" class="CONTROL" >
			<div id="itemSlNoId"><select name="strItemSlNo" class='comboMax'>
					<bean:write name="itemLocationBean" property="strItemSlNoCmb" filter="false" />
					<option value="0">Select Value</option>
			</select></div>
		</td>
	</tr>
	</table>
	</div>
	
	<!-- <table class="TABLEWIDTH" align="center" cellpadding="1px" cellspacing="1px">
		<tr>
			<td colspan="4" align="center" class="LABEL">
           <div align="center"> <img style="cursor: pointer; " title="To Search" src="../../hisglobal/images/btn-search.png" onClick="validate1();" /> 
           <a href="#" class="button"	onclick="validate1();"><span class="search">Search</span></a> 
           </div></td>
		</tr>
	</table>-->
	<div align="center" id=" ">					 
					<a href="#" class="button" id='go'	onclick="validate1();"></a>
				</div> 
					
	
	<div id="StockDtlDivId" style="display: none;">
	</div>
	
	 <div class='popup' id='avlQtyId' style="display:none">
		<table width='400' border="0" cellspacing ="0px" cellpadding="0px">
			<tr class="HEADER"> 
				<th align='left'><div id="popUpAvlQtyId"></div></th>
				<th align='right'>
				<a href="#" class="button" onclick="closeAvlQtyPopUp('avlQtyId');"><span class="cancel">Cancel</span></a>
				<!--<img  style='cursor:pointer;cursor:pointer' src='../../hisglobal/images/popUp_cancel.JPG'
					onClick="closeAvlQtyPopUp('avlQtyId');" title="Click Here To Close Popup">-->
					</th>
		    </tr>
		 </table>  
	  
	
					
	  
		 <table width='400' border="0" cellspacing ="1px" cellpadding="1px">
			<tr>
				<td colspan="1" class='multiLabel'>Reserved Qty</td>
				<td colspan="1" class='multiControl'><div id ='1'></div></td>
						
			</tr>
			<tr>
				<td colspan="1" class='multiLabel'>Blocked Qty</td>
				<td colspan="1" class='multiControl'><div id ='2'></div></td>	
			</tr>
			<tr class="FOOTER">
				<td colspan="4"></td>
			</tr>
	        </table>
	    </div>
	
	<table class="TABLEWIDTH" align="center" cellpadding="1px" cellspacing="1px">	
	   <tr class="FOOTER">
			 <td colspan="4"><font size="2" color="red">*</font> Mandatory Fields  </td>
	  </tr>
	  <tr>
			<td colspan="4" align="center" >
			<br>
			<div align="center" id=" ">					 
					 	<a href="#" class="button" onclick="cancelFunc();"><span class="cancel">Cancel</span></a>
				</div> 
           <!--<div align="center"> <img style="cursor: pointer; " title="To Search" src="../../hisglobal/images/btn-ccl.png"  onclick="cancelFunc();"/></div>--></td>
		</tr>
    </table>
    

					
		
<input type="hidden" name="hmode"/>

</html:form>
	<tag:autoIndex></tag:autoIndex>   
</body>
</html>