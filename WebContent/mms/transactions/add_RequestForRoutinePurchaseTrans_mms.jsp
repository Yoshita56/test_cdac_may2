<%@page language="java" contentType="text/html" pageEncoding="UTF-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<%@ taglib uri="/WEB-INF/dateTag.tld" prefix="dateTag"%>
<%@ taglib uri="/WEB-INF/hisTab.tld" prefix="tag"%>
<%@ taglib uri="/WEB-INF/comboPersistence.tld" prefix="cmbPers"%>

<%@ taglib uri="/WEB-INF/crNo.tld" prefix="crNo"%>
<!-- 
/**
 * @author Amit Kumar
 * Date of Creation : 05/5/2009
 * Date of Modification :  /  / 
 * Version : 1.0
 * Module  : Store
 */
 -->
<html>
<head>
<meta charset=UTF-8">
<title>Annual Indent</title>
<link href="../css/master.css" rel="stylesheet" type="text/css">
<link href="../../hisglobal/css/tab.css" rel="stylesheet"
	type="text/css">
<link href="../../hisglobal/css/calendar-tas.css" rel="stylesheet"
	type="text/css">
<link href="../../hisglobal/css/popup.css" rel="stylesheet"
	type="text/css">
<link href="../../hisglobal/css/newpopup.css" rel="stylesheet"
	type="text/css">


<script language="JavaScript" src="../../masterutil/js/master.js"></script>
<script language="JavaScript" src="../../hisglobal/js/tab.js"></script>
<script language="JavaScript" src="../../hisglobal/js/calendar.js"></script>
<script language="Javascript" src="../../hisglobal/js/validation.js"></script>

<script language="Javascript" src="../js/searchItems_util.js"></script>
<script language="JavaScript" src="../../hisglobal/js/tab.js"></script>
<script language="Javascript" src="../../hisglobal/js/util.js"></script>
<script language="Javascript" src="../../hisglobal/js/newpopup.js"></script>
<script language="Javascript" src="../../hisglobal/js/popup.js"></script>
<script language="Javascript" src="../../hisglobal/js/multirow.js"></script>
<script language="JavaScript" src="../js/mms.js"></script>



<script language="JavaScript" src="../js/RoutinePurchase.js"></script>

<script type="text/javascript">

	function invokeCheckQty(mode, index, unitObject)
	{ 
	    gblIsAvailReq = "0";	
	    if( checkQty(index,'strReqQty','strUnitName'))
		 {
		       
		        // Pass '0' If User Dont Want to Compare Req Qty with Avalaible Quantity 
		 		calculateCost(mode, 'strReqQty', 'strUnitName', 'strCost', index , 'strApproxAmtTotal','0');
		 }
			
	}	
	function changeUnitCmb(obj,index)
	{	   
	
	        var costArray           = new Array();
	        var rateObj             = document.getElementsByName("itemCalcValue");
	        var qtyObj              = document.getElementsByName("strReqQty");
	        var qty_base_value      = document.getElementsByName("strUnitName");
	        var cost                = document.getElementsByName("strCost");
	        var costDiv             = document.getElementsByName("strCostDivId");
	        
	        var total               = parseFloat("0.00");
	        for(var nTmpI=0;nTmpI<rateObj.length-1;nTmpI++)
			{
				 if(qty_base_value[nTmpI].value!="0")
				 {		
			            if(isNaN(qtyObj[nTmpI].value)  || qtyObj[nTmpI].value=="" || isNaN(rateObj[nTmpI].value.split("^")[1]) || rateObj[nTmpI].value.split("^")[1]=="" ) 
			            {
			                qtyObj[nTmpI].value = "0";
			                rateObj[nTmpI].value.split("^")[1] = "0";
			                costArray[nTmpI] = "0";
						}
						else
						{
						   costArray[nTmpI] = roundValue(parseFloat(qtyObj[nTmpI].value * qty_base_value[nTmpI].value.split("^")[1] * rateObj[nTmpI].value.split("^")[1]), 2)
						}
						cost[nTmpI].value    = costArray[nTmpI];
						costDiv[nTmpI].value = costArray[nTmpI];
				 }
				 else
				 {
				   alert("Please Select Unit!!!");
				   cost[nTmpI].value    = "0";
				   costDiv[nTmpI].value = "0";
				   return false;
				 
				 }		
												
						
			}
			            var costObj = document.getElementsByName("strCost");
						var total   = parseFloat("0.00");
						
					   	if (costObj.length > 0) 
						{
					       
							for ( var i = 0; i <costObj.length; i++)
							{		        	
									
								total = total + parseFloat(costObj[i].value);
					 		}
					
						}
			
				      total = roundValue(total, 2);
				      document.getElementById("strApproxAmtDivId").innerHTML = total;
			          document.forms[0].strApproxAmtTotal.value=total;
	    /*****************************************************/
       	
       	
	}
	function CallFunc()
	{
			 var unitNameCmb = document.getElementsByName("strUnitName");
			    for(var j=0;j<unitNameCmb.length;j++)
				{
					unitNameCmb[j].value = "0";
				}
	   
	}
	
	function getAnnualPeriod()
	{
		alert("inside getAnnualPeriod");
	   if(document.forms[0].strIndentPeriod.value!='0')
	   {
	     document.forms[0].strIndentPeriodValue.value = document.forms[0].strCurrentFinancialYear.value;
	     document.forms[0].strIndentPeriodValue.disabled=true;
	   }
	   else
	   {
	     document.forms[0].strIndentPeriodValue.value ="";	     
	     document.forms[0].strIndentPeriodValue.disabled=true; 
	   }  
	}
	
	function getItemSelectPopup()
	{
	
	    var itemParVal  = document.getElementsByName("itemParamValue");
        var finalTotal  = parseFloat("0.00");
		document.getElementById("strApproxAmtDivId").innerHTML ="0.00";
		 document.forms[0].strApproxAmtTotal.value=finalTotal;
        if(itemParVal.length>1)
        {
          var costObj = document.getElementsByName("strCost");
                    for ( var i = 0; i <costObj.length; i++)
					{		        					
						finalTotal = finalTotal + parseFloat(costObj[i].value);
			 		}		
			        finalTotal = roundValue(finalTotal, 2);
			        document.getElementById("strApproxAmtDivId").innerHTML = finalTotal;
                    document.forms[0].strApproxAmtTotal.value=finalTotal;
        }
	
	  var ItemTypeCmb = document.forms[0].strItemType;
 	  var ToStoreCmb   = document.forms[0].strToStore;
      	
	    var strModeVal 					= "1" ; 
		var strRequestType              = document.forms[0].strTmpReqType.value;
		var strItemCategory 			= document.forms[0].strTmpItemCatg.value; 
		var strFromStoreId 				= document.forms[0].strTmpStoreName.value;
		var strMultiRowCompArray 		= new Array('itemParamValue','itemCalcValue','itemUserValue','strReqQty','strUnitName','strCost');
		var strMultiRowCompTypeArray 	= new Array('t','t','t','t','s','t');
		var testFunction                = "CallFunc";
		var arg                         = " ";  
		var userInfo = "0";
		var unitMode = "1";  // only base unit  1 Means Only Base Unit Show 0 Means All Unit Show in Unit Combo
		var strMultiRowFetchDataArray 	= new Array('1','4','10','0^strUnitName^invokeCheckQty');

		    
	    var layerIndex = "1";
	
        searchItemsWithUserFunction ( strModeVal , strItemCategory , strRequestType, strFromStoreId, strMultiRowCompArray , strMultiRowCompTypeArray , strMultiRowFetchDataArray , layerIndex, testFunction,arg);
	}
function costReq(){
	if(document.getElementsByName("strCostRequired")[0].value=="1"){
		document.getElementById("costDivReqId").style.display="block";
		document.getElementById("costDivNotReqId").style.display="none";
		document.getElementById("totalCostId").style.display="block";
		
	}else{
		document.getElementById("costDivNotReqId").style.display="block";
		document.getElementById("costDivReqId").style.display="none";
		document.getElementById("totalCostId").style.display="none";
	}
}

</script>
</head>

<body onload="OnLoadFunction(),costReq();">

<html:form action="/transactions/RoutinePurchaseCNT.cnt"
	name="requestForRoutinePurchase"
	type="mms.transactions.controller.fb.RoutinePurchaseFB"
	method="post">

	<div class="errMsg" id="errMsg"><bean:write
		name="requestForRoutinePurchase" property="strErr" /></div>
	<div class="warningMsg" id="warningMsg"><bean:write
		name="requestForRoutinePurchase" property="strWarning" /></div>
	<div class="normalMsg" id="normalMsg"><bean:write
		name="requestForRoutinePurchase" property="strMsg" /></div>

	<center><tag:tab tabLabel="Annual Indent"
		selectedTab="FIRST" align="center" width="TABLEWIDTH">
	</tag:tab></center>

    <div class='popup' id='purchaseDtl' style="display: none">
	<table width='400' border="0" cellspacing="0px">
		<tr class="HEADER">
			<th colspan='6' align='left'><div id='11' style='color: blue;'></div>
			</th>
			<th align='right'><img style='cursor: pointer; ' title='To Close Pop-Up'
				src='../../hisglobal/images/popUp_cancel.JPG'
				onClick="hideItemDetails('purchaseDtl');"></th>
		</tr>
	</table>
	<table width='400' border="0" cellspacing="1px" bgcolor='#CC9966' cellpadding="1px">
		<tr>
			<td colspan="1" class='multiLabel'>PO NO</td>
			<td colspan="1" class='multiLabel'>PO Date</td>
			<td colspan="1" class='multiLabel'>Supplier Name</td>


		</tr>
		<tr>
			<td colspan="1" class='multiControl'>
			<div id='1'></div>
			</td>
			<td colspan="1" class='multiControl'>
			<div id='2'></div>
			</td>
			<td colspan="1" class='multiControl'>
			<div id='3'></div>
			</td>


		</tr>

		<tr>
			<td colspan="1" class='multiLabel'>Received Qty</td>
			<td colspan="1" class='multiLabel'>Rate/Unit</td>
			<td colspan="1" class='multiLabel'></td>


		</tr>
		<tr>
			<td colspan="1" class='multiControl'>
			<div id='5'></div>
			</td>
			<td colspan="1" class='multiControl'>
			<div id='7'></div>
			</td>
			<td colspan="1" class='multiControl'></td>

		</tr>


	</table>
	</div>


	<table class="TABLEWIDTH" align="center" cellspacing="1px">
		<tr class="HEADER">
			<td colspan="4"></td>
		</tr>

		<tr>
			<td width="25%" class="LABEL">Store Name:</td>
			<td width="25%" class="CONTROL"><bean:write
				name="requestForRoutinePurchase" property="strStoreName" filter="false" /></td>

			<td width="25%" class="LABEL"><font color="red">*</font>Item
			Category:</td>
			<td width="25%" class="CONTROL"><bean:write
				name="requestForRoutinePurchase" property="strItemCatg" filter="false" />

			</td>

		</tr>
		<tr>
			<td width="25%" class="LABEL">Req Date:</td>
			<td width="25%" class="CONTROL"><bean:write
				name="requestForRoutinePurchase" property="strReqDate" filter="false" />
			</td>



			<td width="25%" class="LABEL"><font color="red">*</font>Receiving
			Store:</td>
			<td width="25%" class="CONTROL"><select class='comboMax'
				name='strToStore'>
				<bean:write name="requestForRoutinePurchase" property="strToStoreCombo"
					filter="false" />
			</select></td>
		</tr>

		<tr>

			<td class="LABEL" colspan="1">Urgent:</td>
			<td class="CONTROL" colspan="1"><%-- 
     <b><input type='checkbox' name='strIsNormal' value="0" onClick="ftnTick()">No<input type='checkbox' name='strIsUrgent' value="0" onClick="ftnTick()">Yes</b> &nbsp;&nbsp; 
     --%> <input type="radio" name="strIsNormal" value="1"
				checked="checked" />Normal &nbsp;&nbsp; <input type="radio"
				name="strIsNormal" value="0" />Urgent</td>

			<td width="25%" class="CONTROL"></td>
			<td width="25%" class="CONTROL"></td>

		</tr>
		<tr>
			<td class="LABEL" colspan="1">Indent Period:</td>
			<td class="CONTROL" colspan="3">
			<!--<input type="hidden" name="strIndentPeriod" value="${requestForRoutinePurchase.strIndentPeriod}" />
			<html:select name="requestForRoutinePurchase" property="strIndentPeriod" disabled="false" >
				<bean:write name="requestForRoutinePurchase" property="strIndentPeriodCombo" filter="false" />
			</html:select>-->
			<select class='comboNormal'name='strIndentPeriod' disabled="disabled" >
				<bean:write name="requestForRoutinePurchase" property="strIndentPeriodCombo" filter="false" />
			</select>
			&nbsp;&nbsp;<input type="text" class="txtFldMax"
				name="strIndentPeriodValue" value="${requestForRoutinePurchase.strIndentPeriodValue}"
				onkeypress="return validateData(event,3);" maxlength="" disabled="disabled"></td>

		</tr>
		
	</table>

	<table class="TABLEWIDTH" align="center" cellpadding="1"
		cellspacing="1">
		<tr class="TITLE">
			<td colspan="6">
			<div align="right"><img style="cursor: pointer;height: 20px"
					id='strSearchItemButtonDivId' src="../../hisglobal/images/ItemFinder.png" 
					onclick='getItemSelectPopup();'></div>
			</td>
		</tr>
		
	</table>

	<div id="costDivReqId" style="display: none">
	<table class="TABLEWIDTH" align="center" cellpadding="1px" bgcolor='black'
		cellspacing="1px">
		<tr>
			<td width="30%" class="multiLabel">Item/Drug Name</td>

			<td width="8%" class="multiLabel">Available Qty</td>
			<td width="10%" class="multiLabel">Consumption Qty(Last Year)</td>
			<td width="8%" class="multiLabel">Last Purchase Detail</td>
			<td width="10%" class="multiLabel"><font size="2" color="red">*</font>Req	Qty</td>
			<td width="12%" class="multiLabel"><font size="2" color="red">*</font>Unit</td>
			<td width="13%" class="multiLabel">Approx Cost</td>

		</tr>
	</table>
	</div>
	<div id="costDivNotReqId" style="display: none">
	<table class="TABLEWIDTH" align="center" cellpadding="1px" bgcolor='black'
		cellspacing="1px">
		<tr>
			<td width="35%" class="multiLabel">Item/Drug Name</td>

			<td width="12%" class="multiLabel">Available Qty</td>
			<td width="12%" class="multiLabel">Consumption Qty(Last Year)</td>
			<td width="8%" class="multiLabel">Last Purchase Detail</td>
			<td width="10%" class="multiLabel"><font size="2" color="red">*</font>Req
			Qty</td>
			<td width="14%" class="multiLabel"><font size="2" color="red">*</font>Unit
			</td>


		</tr>
	</table>

	</div>



	<div id="id1"></div>
	<div id="totalCostId" style="display: none">
	<table class="TABLEWIDTH" align="center" cellpadding="1"
		cellspacing="1">
		<tr>
			<td width="85%" class="LABEL">Total Approx Cost(Rs):</td>
			<td width="15%" class="CONTROL" style="color: red; font-weight: bold">
			<div id="strApproxAmtDivId" align="center">0.00</div>
			<input type="hidden" name="strApproxAmtTotal"></td>
		</tr>
	</table>
	</div>
	
	<table class="TABLEWIDTH" align="center" cellpadding="1"
		cellspacing="1">
		<tr class="TITLE">
			<td colspan="6"></td>
		</tr>
		<tr>
			<td colspan="3" class="LABEL">Remarks</td>
			<td class="CONTROL" colspan="3"><textarea name="strRemarks" cols="20"
				rows="2" id="strRemarks"></textarea></td>
		</tr>


		<tr class="FOOTER">
			<td colspan="6"><font size="2" color="red">*</font> Mandatory
			Fields</td>
		</tr>
	</table>


	<table class="TABLEWIDTH" align="center">
		<tr>
			<td align="center"><img style="cursor: pointer; "
				title="Click to Save Record"
				src="../../hisglobal/images/btn-sv.png"
				onClick=" return validate1();" /> <img
				style="cursor: pointer; " title="Click to Clear Page"
				src="../../hisglobal/images/btn-clr.png" name="clearImg"
				onclick="initPage();"> <img
				style="cursor: pointer; "
				title="Click to Return Main Menu"
				src="../../hisglobal/images/back_tab.png" onClick="cancelToDesk();" />
			</td>
		</tr>
	</table>

	<input type="hidden" name="hmode" />

	<input type="hidden" name="strStoreTypeId"
		value="${requestForLpStaff.strStoreTypeId}">
	<input type="hidden" name="strTmpStoreName"
		value="${requestForRoutinePurchase.strTmpStoreName}">
	<input type="hidden" name="strTmpCrNo"
		value="${requestForRoutinePurchase.strTmpCrNo}">
	<input type="hidden" name="strTmpToStore"
		value="${requestForRoutinePurchase.strTmpToStore}">
	<input type="hidden" name="strTmpGrantType"
		value="${requestForRoutinePurchase.strTmpGrantType}">
	<input type="hidden" name="strTmpItemCatg"
		value="${requestForRoutinePurchase.strTmpItemCatg}">
	<input type="hidden" name="strTmpReqType"
		value="${requestForRoutinePurchase.strTmpReqType}">
	<input type="hidden" name="strGoFlg"
		value="${requestForRoutinePurchase.strGoFlg}">
	<input type="hidden" name="strPath"
		value="${requestForRoutinePurchase.strPath}">
	<input type="hidden" name="strCostRequired"
		value="${requestForRoutinePurchase.strCostRequired}">
		<input type="hidden" name="strItemDtlWithIssueQty" id="strItemDtlWithIssueQty" value="0"/>


	<div id="blanket" style="display: none;"></div>
	<div class="popUpDiv" id="popUpDiv" style="display: none;">
	<table bgcolor="white">
		<tr>
			<td>
			<div id="searchItemsDtlsDivId" style="display: block;"></div>
			</td>
		</tr>
	</table>
	</div>
	<cmbPers:cmbPers />
</html:form>
<jsp:include page="requestForRoutinePurchase_itemSearchRow.jsp"></jsp:include>
<tag:autoIndex></tag:autoIndex>
</body>
</html>