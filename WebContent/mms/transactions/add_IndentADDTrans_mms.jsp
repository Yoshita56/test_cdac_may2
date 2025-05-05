<%@page language="java" contentType="text/html" pageEncoding="UTF-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<%@taglib uri="/WEB-INF/dateTag.tld" prefix="dateTag"%>
<%@ taglib uri="/WEB-INF/hisTab.tld" prefix="tag"%>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic"%>
<%@ taglib uri="/WEB-INF/comboPersistence.tld" prefix="cmbPers"%>
<!-- 
/**
 * @author Amit Kumar
 * Date of Creation : 31/3/2009
 * Date of Modification :  /  / 
 * Version : 1.0
 * Module  : Store
 */
 -->
<html>
<head>
<meta charset=UTF-8">
<title>Indent For Issue</title>
<link href="../css/transaction.css" rel="stylesheet" type="text/css">
<link href="../../hisglobal/css/tab.css" rel="stylesheet"
	type="text/css">
<link href="../../hisglobal/css/calendar-tas.css" rel="stylesheet"
	type="text/css">
<link href="../../hisglobal/css/newpopup.css" rel="stylesheet"
	type="text/css">
<link href="../../hisglobal/css/popup.css" rel="stylesheet"
	type="text/css">
<link href="../../hisglobal/css/buttons.css" rel="stylesheet" 
type="text/css">
<script language="JavaScript" src="../../masterutil/js/master.js"></script>
<script language="JavaScript" src="../../hisglobal/js/tab.js"></script>
<script language="JavaScript" src="../../hisglobal/js/calendar.js"></script>
<script language="Javascript" src="../../hisglobal/js/validation.js"></script>
<script language="Javascript" src="../../hisglobal/js/datepicker1.js"></script>
<script language="Javascript" src="../js/searchItems_util.js"></script>
<script language="JavaScript" src="../../hisglobal/js/tab.js"></script>
<script language="Javascript" src="../../hisglobal/js/util.js"></script>
<script language="Javascript" src="../../hisglobal/js/newpopup.js"></script>
<script language="Javascript" src="../../hisglobal/js/popup.js"></script>
<script language="Javascript" src="../../hisglobal/js/multirow.js"></script>
<script language="JavaScript" src="../js/mms.js"></script>

<script language="JavaScript" src="../js/IndentTransADD.js"></script>

<script type="text/javascript">

	function clearItemDiv()
	{
	 var itemParaObj = document.getElementById("id1");
          itemParaObj.innerHTML = ""; 	
	}
	
	function getItemSelectPopup()
	{
		
	     setItemDtlWithIssueQty();
	     var issueStore = document.forms[0].strToStoreCombo.value;
	     if(issueStore!=0)
	     {
		    var strModeVal 		= "1" ; 
	        var strItemCategory = document.forms[0].strItemCatNo.value ;
	        var strRequestType 	= document.forms[0].strIndentTypeId.value;
	        var strFromStoreId 	= document.forms[0].strStoreId.value;
	        var strUserInfo 	= document.forms[0].strToStoreCombo.value;
			// alert('strUserInfo'+strUserInfo);
		    var strMultiRowCompArray     = new Array('itemParamValue','itemCalcValue','itemUserValue','strReqQty','strUnitName','strCost');
	
	        var strMultiRowCompTypeArray = new Array('t','t','t','t','s');
	
	            // for mode val 1
	             
	     //   var strMultiRowFetchDataArray  = new Array('1','4','8','9','0^strUnitName^invokeCheckQty');
	        var strMultiRowFetchDataArray  = new Array('1','66','4','0^strUnitName^invokeCheckQty');
	
			var layerIndex = "1";
			document.getElementById("strToStoreCombo").disabled=true;
			searchItems( strModeVal , strItemCategory , strRequestType, strFromStoreId, strMultiRowCompArray , strMultiRowCompTypeArray , strMultiRowFetchDataArray , layerIndex , strUserInfo);
		    //searchItems( strModeVal , strItemCategory , strRequestType, strFromStoreId, strMultiRowCompArray , strMultiRowCompTypeArray , strMultiRowFetchDataArray , layerIndex);
		 }
		 else
		 {
		   alert("Please Select Issuing Store Name");
		   return false;
		 }
			  
			    
	}		
	
	function onChangeCatg()
	{
		
		document.getElementById("id1").innerHTML = "";		
		//document.getElementById("searchItemsDtlsDivId").innerHTML = "";		
		getItemSelectPopup();
		
	}

    function invokeCheckQty(mode, index, unitObject)
	{ 
		       
		        // Pass '0' If User Dont Want to Compare Req Qty with Avalaible Quantity 
		        
		 		calculateCost(mode, 'strReqQty', 'strUnitName', 'strCost', index , 'strApproxAmt','0');
		 
			
	}	
	
	function changeUnitCmb(obj,index)
	{	    
       	document.getElementById("strCostDivId" + index).innerHTML = "0.00";
       	document.getElementById("strCost" + index).value = "0";
 
        calculateCost('1', 'strReqQty', 'strUnitName', 'strCost', index , 'strApproxAmt','0');  	
       	
	}
	
	
function setItemDtlWithIssueQty(){
	
		var itemWithIssueQty = document.getElementById("strItemDtlWithIssueQty");
		var  itemUserVal    = document.getElementsByName("itemUserValue");
	    //var issueQty    = document.getElementsByName("strIssueQty");
  		var reqQty      = document.getElementsByName("strReqQty");
  		var unitNameCmb = document.getElementsByName("strUnitName");
  		//var costObj     = document.getElementsByName("strCost");
		  
				
			if(itemUserVal.length > 1)
			{
				
				var tempIssueDtls ; 
				
				for(var i = 0 ; i < itemUserVal.length - 1 ; i++)
				{

															
					if(i == 0 )
					{
						
						tempIssueDtls = itemUserVal[i].value+"@@@@"+reqQty[i].value+"@@@@"+unitNameCmb[i].value;	
						
					}
					else
					{
					
						tempIssueDtls = tempIssueDtls+"$$$$"+itemUserVal[i].value+"@@@@"+reqQty[i].value+"@@@@"+unitNameCmb[i].value;
					
					}
				
				}
				
				itemWithIssueQty.value = tempIssueDtls;
				
				
			}else{
				itemWithIssueQty.value = "";
					
			}
				
		
	
	}


function hideBalQtyDetails(divId) {
	hide_popup_menu(divId);
}

function getReport() 
{
 
	
    var fromStoreId = document.forms[0].strStoreId.value;
    var indentNo    = document.forms[0].indentNo.value;
    var toStoreId   = document.forms[0].toStoreCombo.value;

		//alert(document.forms[0].indentNo.value+"---"+document.forms[0].tmpIndentNo.value);
 
		if (parseInt(indentNo)>0 && indentNo !=null) 
		{

			var hmode = "ISSUEDTLSINIT";
			var url = "IndentTransADDCNT.cnt?hmode=" + hmode + "&strMode=1 &fromStoreId=" + fromStoreId + "&indentNo=" + indentNo+"&toStoreId="+toStoreId;
			
			ajaxFunction(url, "1");

		} 

	

}
/**
 * Customized ajax response function for stock details
 * @param res - result 
 * @param mode - mode
 * @return
 */
function getAjaxResponse(res, mode) 
{

	//STOCKDTLSINIT
	if (mode == '1') 
	{
       // alert(res);
		var itemStockObj = document.getElementById("indentCreateDivId");

		itemStockObj.innerHTML = res;

		popup('popUpDiv', '80', '60');

	}	
	
	

}

/**
 * Prints the report.
 * @return
 */
function printDataOne() 
{
   
	newwin = window.open('', 'printwin',
			'left=100,top=100,width=700,height=700,scrollbars=yes');
	newwin.document.write('<HTML><HEAD>');
	newwin.document.write((document.getElementsByTagName("head")[0]).innerHTML);
	newwin.document
			.write('<style type="text/css"> .hidecontrol { display: none; } </style>\n')
	newwin.document.write('<script>\n');
	newwin.document.write('function chkstate(){ \n');
	// newwin.document.write('if(document.readystate=="complete" ||
	// document.readystate=="undefined"){\n');
	newwin.document.write('window.close();\n');
	// newwin.document.write('}\n');
	// newwin.document.write('else{\n');
	// newwin.document.write('setTimeout("chkstate()",2000)\n');
	// newwin.document.write('}\n');
	newwin.document.write('}\n');
	newwin.document.write('function print_win(){\n');
	newwin.document.write('window.print();\n');
	newwin.document.write('chkstate();\n');
	newwin.document.write('}\n');

	newwin.document.write('<\/script>\n');
	newwin.document.write('</HEAD>\n');
	newwin.document.write('<BODY onload="print_win()">\n');
	newwin.document.write(document.getElementById('indentCreateDivId').innerHTML);
	newwin.document.write('</BODY>\n');
	newwin.document.write('</HTML>\n');
	newwin.document.close();

}

function  hideIssuePopupOne()
{

	hide_popup('popUpDiv');

	var itemStockObj = document.getElementById("indentCreateDivId");

	itemStockObj.innerHTML = "";
}

</script>

</head>

<body onload="getReport();">

<html:form action="/transactions/IndentTransADDCNT.cnt"
	name="indentTransADDBean"
	type="mms.transactions.controller.fb.IndentTransADDFB" method="post">

	<div class="errMsg" id="errMsg"><bean:write
		name="indentTransADDBean" property="strErr" /></div>
	<div class="warningMsg" id="warningMsg"><bean:write
		name="indentTransADDBean" property="strWarning" /></div>
	<div class="normalMsg" id="normalMsg"><bean:write
		name="indentTransADDBean" property="strMsg" /></div>

<%-- Change Request --%>

<div class='popup' id='avalaibleBudgetDtlId' style="display: none">
		<table width='400' border="0" cellspacing="1" cellpadding="1">
			<tr class="HEADER">
				<td colspan='3'>Budget Details</td>
	
				<th align='right'><img style='cursor: pointer; '
					src='../../hisglobal/images/popUp_cancel.JPG' title='Click to Close Pop-Up'
					onClick="hideBalQtyDetails('avalaibleBudgetDtlId');"></th>
			</tr>
		</table>


		<table width='400' border="0" cellspacing="1" cellpadding="1">
	
			<tr>
				<td colspan="1" class='multiLabel'>Budget Allocated</td>
				<td colspan="1" class='multiLabel'>Budget Consumed</td>
	
			</tr>
			<tr>
				<td colspan="1" class='multiControl'>
				<div id='1'></div>
				</td>
				<td colspan="1" class='multiControl'>
				<div id='2'></div>
				</td>
	
			</tr>
		</table>
	</div>
<%-- Change Request End --%>




	<center><tag:tab tabLabel="Indent For Issue"
		selectedTab="FIRST" align="center" width="TABLEWIDTH">
	</tag:tab></center>

	<table class="TABLEWIDTH" align="center" cellspacing="1px">
		<tr class="HEADER">
			<td colspan="4"></td>
		</tr>

		<tr>
			<td width="25%" class="LABEL">Store Name:</td>
			<td width="25%" class="CONTROL"><bean:write
				name="indentTransADDBean" property="strStoreNameFunc" filter="false" /></td>
			<td width="25%" class="LABEL">Indent Date:</td>

			<td width="25%" class="CONTROL"><bean:write
				name="indentTransADDBean" property="strIndentDate" filter="false" /></td>
		</tr>
		<tr>
			<td width="25%" class="LABEL">Indent Type:</td>
			<td width="25%" class="CONTROL"><bean:write
				name="indentTransADDBean" property="strIndentTypeFunc"
				filter="false" /></td>

			<td width="25%" class="LABEL">Item Category:</td>
			<td width="25%" class="CONTROL">
			<!--  
			<bean:write
				name="indentTransADDBean" property="strItemCategoryFunc"
				filter="false" />
			-->	
			<select class='comboMax' id="strItemCatNo"	name='strItemCatNo' disabled="true" onChange="onChangeCatg();">
			   <bean:write name="indentTransADDBean" property="strItemCategoryCmb"	filter="false" />
		    </select>
			</td>
		</tr>
		<tr>
			<td width="25%" class="LABEL"><font color="red">*</font>Indent
			Status:</td>
			<td width="25%" class="CONTROL"><!-- 
    <b><input type='checkbox' name='isNormal' value="0" onClick="ftnTick()">Normal <input type='checkbox' name='isUrgent' value="0" onClick="ftnTick()">Urgent</b> &nbsp;&nbsp;
     --><input type="radio" name=isNormal value="1" checked="checked" />Normal&nbsp;&nbsp;
			<input type="radio" name="isNormal" value="0" />Urgent</td>

			<td width="25%" class="LABEL"><font color="red">*</font>Issuing Store:</td>
			<td width="25%" class="CONTROL"><select class='comboMax' id="strToStoreCombo"
				name='strToStoreCombo' onChange="clearItemDiv();">
				<bean:write name="indentTransADDBean" property="strToStoreCombo"
					filter="false" />
			</select></td>
		</tr>

		<tr>
			<td class="LABEL" colspan="1"><font size="2" color="red">*</font>Indent Period:</td>
			<td class="CONTROL" colspan="3"><select class='comboNormal'
				name='strIndentPeriod'>
				<bean:write name="indentTransADDBean"
					property="strIndentPeriodCombo" filter="false" />
			</select>&nbsp;&nbsp;<div style="display:none"><input type="text" class="txtFldMax"
				name="strIndentPeriodValue"
				onkeypress="return validateData(event,3);"  value="" maxlength="9" readonly></div></td>
		</tr>


 		<%-- <logic:present name="indentTransADDBean" property="strAvalaibleBudget" >
		<tr>
	     

			<td class="LABEL"  colspan="1">Budget Available</td>
			<td class="CONTROL" colspan="3">
			
       	    
       	    <a STYLE='cursor:pointer;cursor:pointer;color:blue'  onClick='avlBudgetDtl(this);' TITLE='Click Here Get Budget Details' ><bean:write name="indentTransADDBean" property="strAvalaibleBudget" /></a>
       	    
       				      			
			</td>
		</tr>			
		</logic:present> --%>
	</table>

	

	<table class="TABLEWIDTH"  align="center" cellpadding="1px"
		cellspacing="1px">
		<tr class="TITLE">
			<td colspan="6">
			<div align="right"><img style="cursor: pointer;height: 20px" id='strSearchItemButtonDivId'
					id='strSearchItemButtonDivId' src="../../hisglobal/images/ItemFinder.png" 
					onclick='getItemSelectPopup();'></div>
			</td>
		</tr>
	</table>
	
		
	<table class="TABLEWIDTH"  align="center" cellpadding="1px" bgcolor='#bdd9f0'
		cellspacing="1px">
			<tr>
				<td width="40%" class="multiRPTLabel">Item Name</td>
				<td width="15%" class="multiRPTLabel">Item Type</td>
				<td width="15%" class="multiRPTLabel">Avl Qty</td>
			<!--<td width="10%" class="multiRPTLabel">Last Indent Qty</td>
				<td width="10%" class="multiRPTLabel">Last Rec. Qty</td>  -->	
				<td width="15%" class="multiRPTLabel"><font size="2" color="red">*</font>Req Qty</td>
				<td width="15%" class="multiRPTLabel"><font size="2" color="red">*</font>Unit</td>
			<!-- <td width="10%" class="multiRPTLabel">Approx Cost</td> -->	
		</tr>
	</table>	
	
	
	<div id="id1" style='display:none; width:95%; margin:auto;'></div>
	<table class="TABLEWIDTH" align="center" cellpadding="1"
		cellspacing="1">
		<tr>
			<td width="89%" class="LABEL"><div style='display:none;'>Total Approx Cost(Rs):</div></td>
			<td width="11%" class="CONTROL" style="color: red; font-weight: bold">
			<div id="strApproxAmtDivId" style='display:none;' align="center">0.00</div>
			<input type="hidden" name="strApproxAmt"></td>
		</tr>
	</table>

	<table class="TABLEWIDTH" align="center" cellpadding="1"
		cellspacing="1">
		<tr class="TITLE">
			<td colspan="6"></td>
		</tr>
		</table>
		<table class="TABLEWIDTH" align="center" cellpadding="1" cellspacing="1">
		<tr>
			<td width="50%" class="LABEL"><font color="red">*</font>Indent Raised By & Remarks</td>
			<td width="50%" class="CONTROL"><textarea name="strRemarks" cols="20" value="-"
				rows="2" id="strRemarks"></textarea></td>
		</tr>


		<tr class="FOOTER">
			<td colspan="2"><font size="2" color="red">*</font> Mandatory
			Fields</td>
		</tr>
	</table>


	<!--  <table class="TABLEWIDTH" align="center">
		<tr >
			<td align="center"><img style="cursor: pointer; "
				title="Click to Save Record"
				src="../../hisglobal/images/btn-sv.png"
				onClick=" return validate1();" /> <img
				style="cursor: pointer; " title="Click to Clear Page"
				src="../../hisglobal/images/btn-clr.png" name="clearImg"
				onclick="initPage();"> <img
				style="cursor: pointer; "
				title="Click to Return Main Menu"
				src="../../hisglobal/images/back_tab.png"
				onClick="cancel('CANCEL');" /></td>
		</tr>
	</table>-->
	<br>
					<div align="center" id="saveId">					 
					 	<a href="#" class="button" id="submitId" onclick=' return validate1();'><span class="save">Save</span></a>
						<a href="#" class="button"	onclick="initPage();"><span class="clear">Clear</span></a> 
						<a href="#" class="button" onclick="cancel('CANCEL');"><span class="cancel">Cancel</span></a>
					</div> 
					
	<input type="hidden" name="hmode" />

	<div id="blanket" style="display: none;"></div>
	<div class="popUpDiv" id="popUpDiv" style="display: none;">
	<table bgcolor="white">
		<tr>
			<td>
			     <div id="searchItemsDtlsDivId" style="display: block;"></div>
			     <div id="indentCreateDivId" style="display:block;"></div>
			</td>
		</tr>
	</table>
	</div>

	<input type="hidden" name="strStoreName"  value="${indentTransADDBean.strStoreName}">
	<input type="hidden" name="strReOrderFlgColor"  value="LIGHTPINK">
	<input type="hidden" name="strStoreId"
		value="${indentTransADDBean.strStoreId}">
	<input type="hidden" name="strStoreTypeId"
		value="${indentTransADDBean.strStoreTypeId}">
	<!-- 
	<input type="hidden" name="strItemCatNo"
		value="${indentTransADDBean.strItemCatNo}">
		 -->	
	<input type="hidden" name="strIndentTypeId"
		value="${indentTransADDBean.strIndentTypeId}">
	<input type="hidden" name="strPath"
		value="${indentTransADDBean.strPath}">
	<input type="hidden" name="strCostRequired"
		value="${indentTransADDBean.strCostRequired}">
		
		<input type="hidden" name="indentNo" value="${indentTransADDBean.strGenIndentNo}">
		<input type="hidden" name="toStoreCombo" value="${indentTransADDBean.strToStoreId}">
		
		<input type="hidden" name="tmpIndentNo" value="${indentTransADDBean.strGenIndentNo}">		
			
		<input type="hidden" name="strAvalaibleBudgetDtl" value="${indentTransADDBean.strAvalaibleBudgetDtl}">
		<input type="hidden" name="strAvalaibleBudget" value="${indentTransADDBean.strAvalaibleBudget}">
		<input type="hidden" name="strRemainingBudget" value="${indentTransADDBean.strRemainingBudget}">
		
		
		<input type="hidden" name="search" value='<%=request.getParameter("search") %>' />

      <input type="hidden" name="blockNo" value='<%=request.getParameter("blockNo") %>' />

      <input type="hidden" name="prevNext" value='<%=request.getParameter("prevNext") %>' />

      <input type="hidden" name="rowNum" value='<%=request.getParameter("rowNum") %>'/>

      <input type="hidden" name="divisionId" value='<%=request.getParameter("divisionId") %>' />
      <input type="hidden" name="strItemDtlWithIssueQty" id="strItemDtlWithIssueQty" value="0"/>
		
	

	<cmbPers:cmbPers />
</html:form>
<jsp:include page="insertItemAdd_itemSearchRow.jsp"></jsp:include>

</body>
</html>