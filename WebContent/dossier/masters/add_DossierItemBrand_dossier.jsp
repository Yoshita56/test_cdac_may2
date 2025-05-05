<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<%@taglib uri="/WEB-INF/dateTag.tld" prefix="date"%>
<%@ taglib uri="/WEB-INF/hisTab.tld" prefix="tag"%>
<%@ taglib uri="/WEB-INF/comboPersistence.tld" prefix="cmbPers"%>


<html>
<head>
<meta charset=utf-8>
<title>Dossier Item Brand Master</title>
<link href="/INVMGM/mms/css/master.css" rel="stylesheet" type="text/css">
<link href="../../hisglobal/css/tab.css" rel="stylesheet" type="text/css">
<link href="../../hisglobal/css/calendar-tas.css" rel="stylesheet" type="text/css">
<link href="../../hisglobal/css/popup.css" rel="stylesheet" type="text/css">
<link href="../../hisglobal/css/newpopup.css" rel="stylesheet" type="text/css">
<link href="../../hisglobal/css/buttons.css" rel="stylesheet" type="text/css">
<!--
<link href="/INVMGM/mms/css/master.css" rel="stylesheet" type="text/css">
<link href="/INVMGM/hisglobal/css/tab.css" rel="stylesheet" type="text/css">
<link href="/INVMGM/hisglobal/css/calendar-tas.css" rel="stylesheet" type="text/css">
<link href="../../hisglobal/css/popup.css" rel="stylesheet" type="text/css">
<link href="../../hisglobal/css/newpopup.css" rel="stylesheet" type="text/css">
<link href="../../hisglobal/css/buttons.css" rel="stylesheet" type="text/css">
-->
<script language="JavaScript" src="../../hisglobal/masterutil/js/master.js"></script>
<script language="JavaScript" src="../../hisglobal/js/tab.js"></script>
<script language="JavaScript" src="../../hisglobal/js/calendar.js"></script>
<script language="Javascript" src="../../hisglobal/js/validation.js"></script>
<script language="JavaScript" src="../../hisglobal/js/multirow.js"></script>
<script language="JavaScript" src="../../hisglobal/js/util.js"></script>

<script language="Javascript" src="../../hisglobal/js/newpopup.js"></script>
<script language="Javascript" src="/INVMGM/dossier/masters/dossiernew_trans.js"></script>
<script language="Javascript" src="/INVMGM/dossier/masters/dossierItemsnew_util.js"></script>
<script language="Javascript" src="/INVMGM/dossier/masters/dossierDetailsnew_util.js"></script>
<script language="Javascript" src="/INVMGM/dossier/masters/dossierissueDetailsnew_util.js"></script>
<script language="Javascript" src="../../hisglobal/jquery/3.6.0.min.js"></script>

<script>
	$(document).ready(function(){
		$('#isBroughtByPatientRow').remove();
	});
</script>

<script language="javaScript">
	var total_cost=0.0;
	function calCost(e){
 		var cost=0.00;
		var temp = $(e).closest('tr').find('input[name=strDefRateText]').val();
		var tem1 = $(e).closest('tr').find("input[name=strQtyText]").val();
		//console.log('temp::>>'+temp);
		//console.log('temp1===>>'+tem1);
		if(temp!='' && tem1!=''){
			cost=(Number(tem1) * Number(temp));
			//console.log('cost::>>'+cost);
		    $(e).closest('tr').find("input[name=strTotalCostText]").val(cost.toFixed(2));
		    calculateTotalCostOld();
		}
		else{
			cost=0;
			$(e).closest('tr').find("input[name=strTotalCostText]").val(cost.toFixed(2));
		    calculateTotalCostOld();
		}
		 
	}
	function calculateTotalCostOld(){
		var total_cost=0.00;
		var rows=$('input[name="strTotalCostText"]');
		for(var i=0;i<rows.length;i++){
			var temp1=$('input[name="strTotalCostText"]').eq(i).val();
			console.log(temp1);
			total_cost+=(temp1==''? 0:Number(temp1));
		} 
		$('#tableTotal #totalCost').text(total_cost.toFixed(2)); 
	}
	
	/* function deleteRowOld(rowIndex,layerIndex,minRow,e) {
		var rowLength = 0;
		var delRowID;
		var rowLengthObj;
		
		rowLengthObj = document.getElementsByName("rowLength" + layerIndex);
		rowLength = parseInt(rowLengthObj[0].value);
	
		if(rowLength > parseInt(minRow)) {
			delRowID = document.getElementById("id" + rowIndex);
			if(delRowID != null) {
				delRowID.style.display = "NONE";
				delRowID.innerHTML = "";
				
				rowLengthObj[0].value = parseInt(rowLength) - 1;
			}
		}
		calculateTotalCostOld();		
	} */

	function deleteRowOld(rowIndex,layerIndex,minRow,e) {
		 $(e).closest('div[id="id'+rowIndex+'"]').remove();
		 calculateTotalCostOld();
	}
		
</script>
<script>
	$(document).ready(function(){
		$('input[id*="strDefRateText"]').each(function(){
			$(this).removeAttr("onkeyup");
			$(this).attr("onkeyup","calCost(this);");
		});
	});

</script>
<script type="text/javascript">
	function LeftListTransfer()
	{
	 var ob1=document.forms[0].strLeftReqTypes.value;
	 var ob=document.getElementById("LeftReqTypes");
	 shiftToRight("strLeftReqTypes","strRightRequestTypes",1);
	}
	
	function validate() {
	    var hisValidator = new HISValidator("DossierItemBrandMasterBean");

		var flag=1;
		hisValidator.addValidation("strItemKitName", "req", "Item Kit Name is a Mandatory Field");
		hisValidator.addValidation("strItemKitDescription", "req", "Item Kit Description is a Mandatory Field");
		/* hisValidator.addValidation("strItemKitRate", "amount=11,2", "Item Kit Rate is a Mandatory Field"); */
		/* hisValidator.addValidation("strBillingMode", "req", "Billing Mode is a Mandatory Field"); */
		
		var retVal = hisValidator.validate();
		
		if(!retVal){
			return false;
		}
		
		if(document.getElementsByName("strItemKitRate")[0].value==''){
			alert("Item Kit Rate is a mandatory field.");
			document.getElementsByName("strItemKitRate")[0].focus();
			return false;
		}
    	
		if($('div[id*="id1-"]').length>0)
		{
			$('div[id*="id1-"] input[name="strDefRateText"]').each(function(){
				var tmp1 = $(this).closest('tr').find('input[name="strDefRateText"]');
				var tmp2 = $(this).closest('tr').find('input[name="strQtyText"]');

				if(tmp1.val()==''){
					alert('Please enter the value for default rate.');
					tmp1.focus();
					flag=0;
					return false;
				} 
				if(tmp2.val()==''){
					alert('Please enter the value for quantity.');
					tmp2.focus();
					flag=0;
					return false;
				} 
			});
			if(flag==0){
				return false;
			}
			else{
				var conf = confirm("Are you Sure, You Want to Save!!!!");

		    	if(conf)
		    		{	
		    			document.forms[0].hmode.value="INSERT";
		    			document.forms[0].submit();
		    		}else{
		    			return false;
		    		}
			}
		}
		else{
			alert("Dossier should have atleast 1 item. Please select an item from ItemFinder and then proceed.");
			return false;
		}
	
	    
		
		//var hisValidator = new HISValidator("DossierItemBrandMasterBean");
		/*
		selectListRecords("strRightRequestTypes"); 
	    var hisValidator = new HISValidator("DossierItemBrandMasterBean"); 

	    hisValidator.addValidation("strItemKitName", "req", "Item Kit Name is a Mandatory Field");
		hisValidator.addValidation("strItemKitDescription", "req", "Item Kit Description is a Mandatory Field");
		hisValidator.addValidation("strItemKitRate", "amount=11,2", "Item Kit Rate is a Mandatory Field");
		hisValidator.addValidation("strBillingMode", "req", "Billing Mode is a Mandatory Field");
    
	    var retVal = hisValidator.validate(); 
	  	
	        if(retVal){
	      		 var count = selectListRecords("strRightRequestTypes");
	      		 if(count==0)
	      		 {alert("Please select an item.");
	      		 return false;
	      		 }
	     			   document.forms[0].hmode.value = "INSERT";
	                      document.forms[0].submit();
	         }else{
	          return false;
		   }
		  */

/* 	    var hisValidator = new HISValidator("DossierItemBrandMasterBean");

		hisValidator.addValidation("strItemKitName", "req", "Item Kit Name is a Mandatory Field");
		hisValidator.addValidation("strItemKitDescription", "req", "Item Kit Description is a Mandatory Field");
		hisValidator.addValidation("strItemKitRate", "amount=11,2", "Item Kit Rate is a Mandatory Field");
		hisValidator.addValidation("strQtyText","req","Req. Qty is a mandatory field");
		
		var retVal = hisValidator.validate();
	    
	    if(retVal)
	    {
	    	var conf = confirm("Are you Sure, Want to Save!!!!");

			if(conf)
				{	
					document.forms[0].hmode.value="INSERT";
					document.forms[0].submit();
				}else{
					return false;
				}
							    
	    } */
		
}
	
</script>

</head>
<body>
	<html:form action="/masters/DossierItemBrandMstCNT" name="DossierItemBrandMasterBean"
		type="dossier.masters.controller.fb.DossierItemBrandMstFB"
		enctype="multipart/form-data">


		<center>
			<div class="errMsg" id="errMsgId">
				<bean:write name="DossierItemBrandMasterBean" property="strErrMssgstring" />
			</div>
			<div class="warningMsg" id="warningMsgId">
				<bean:write name="DossierItemBrandMasterBean" property="strWarnMssgstring" />
			</div>
			<div class="normalMsg" id="normalMsg">
				<bean:write name="DossierItemBrandMasterBean" property="strNormMssgstring" />
			</div>
			<tag:tab tabLabel="Item Master" selectedTab="FIRST" align="center"
				width="TABLEWIDTH" onlyTabIndexing="1">

			</tag:tab>


		</center>

		<table class="TABLEWIDTH" align="center" cellspacing="1px">
			<tr class="HEADER">
				<td colspan="4">Dossier Item Brand Master&gt;&gt; Add</td>
			</tr>
		</table>
	   <table class="TABLEWIDTH" align="center" cellspacing="1px">
			<%-- 
			<tr>
				<td class="LABEL" width="25%">Item Category</td>
				<td class="CONTROL" width="15%">
					<bean:write name="DossierItemBrandMasterBean" property="strItemCatName" filter="false" />
				</td>
			    <td class="LABEL" width="25%">Group Name</td>
				<td class="CONTROL" width="15%">
					<bean:write name="DossierItemBrandMasterBean" property="strGroupName" filter="false" />
				</td>
			</tr> 
			--%>
			<tr>
				<td width="25%" class="LABEL"><font color="red">*</font>Department Name</td>
				<td width="25%" class="CONTROL">
					<bean:write name="DossierItemBrandMasterBean" property="strDeptName" filter="false" />
				</td>
				<td width="25%" class="LABEL"></td>
				<td width="25%" class="CONTROL">
					
				</td>
			</tr>
			<tr>
				<td width="25%" class="LABEL"><font color="red">*</font>Item Kit Name</td>
				<td width="25%" class="CONTROL">
					<input type="text" name="strItemKitName" maxlength="100" class="txtFldMax" onkeypress="return validateData(event,18);">
				</td>
				<td width="25%" class="LABEL"><font color="red">*</font>Item Kit Description</td>
				<td width="25%" class="CONTROL">
					<textarea rows="2" cols="20" name="strItemKitDescription"></textarea>
				</td>
			</tr>
			<tr>
				<td width="25%" class="LABEL"><font color="red">*</font>Item Kit Rate(per day)</td>
				<td width="25%" class="CONTROL">
					<input type="text" name="strItemKitRate" maxlength="100" class="txtFldMax" onkeypress="return validateData(event,7);">
				</td>
				<td width="25%" class="LABEL"><font color="red">*</font>Billing Mode</td>
				<td width="25%" class="CONTROL">
					<input type="radio" name="strBillingMode" value="1" checked="true">Item-Wise Cost&nbsp;
					<input type="radio" name="strBillingMode" value="2">Dossier-Wise Cost
				</td>
			</tr>
			<!-- <tr>
				<td class="LABEL"  width="25%">Is Miscellaneous Item?</td>
				<td class="CONTROL"  width="15%">
					<input type="radio" name="strIsMisc" value="1" checked>Yes &nbsp;
					<input type="radio" name="strIsMisc" value="2">No
				</td>
			</tr> -->
		</table>
	<%-- 	
		<table class="TABLEWIDTH" align="center" cellpadding="1px" cellspacing="1px">
 			 <tr class="HEADER">
				<td colspan="8"><font color="red">*</font>Item Name</td>
			</tr>
			<tr>
  			 		<td class="CONTROL" colspan="3">  			 
						<div id="LeftReqTypes" align="right">
							<select name="strLeftReqTypes" size="8" multiple style="width: 280px">
								<bean:write name="DossierItemBrandMasterBean" property="strLeftRequestTypeList" filter="false"/>
							</select></div>
					</td>
					<td width="6%" class="CONTROL" colspan="2">			
						<center><img src="../../hisglobal/images/forward3.gif" width="35" height="31" onclick ="LeftListTransfer();"></center>
						<center><img src="../../hisglobal/images/forwardward.gif" width="35" height="31" align="middle" onClick="shiftAllToRight('strLeftReqTypes','strRightRequestTypes',1);"/></center>
						<br/>
						<center><img src="../../hisglobal/images/backward.gif" width="35" height="31" onClick="shiftAllToLeft('strLeftReqTypes','strRightRequestTypes',1);"></center>
						<center><img src="../../hisglobal/images/back3.gif" width="35" height="31" onclick="shiftToLeft('strLeftReqTypes','strRightRequestTypes',1);"/></center>
					</td>
					<td colspan="3" class="CONTROL">
						<div id="RightReqTypes" align="left">
							<select name="strRightRequestTypes" id="RightReqTypes1" size="8" multiple style="width: 280px">
								<bean:write name="DossierItemBrandMasterBean" property="strRightRequestTypeList" filter="false"/>
							</select></div>
					</td>
			</tr> 
		</table>
		 --%>
		 <table class="TABLEWIDTH" align="center" cellpadding="1px"
		cellspacing="1px">

			<tr>
				<td class="LABEL" width="50%"><font color="red">*</font>Item Category</td>
				<td class="CONTROL" width="50%">
					<select id='dep' name="stritemcat" class="comboNormal" onchange="">
						<bean:write name="DossierItemBrandMasterBean" property="strItemCatValues"
							filter="false" />
					</select>
				</td>		
			</tr>
		
		</table>
		<div id="dossierId">
		</div>

<div id="blanket" style="display: none;"></div>

	<div class="popUpDiv" id="popUpDiv" style="display: none;">
		<table bgcolor="white">
			<tr>
				<td>
				<div id="searchItemsDtlsDivId" style="display: block;"></div>
				<div id="stockDtlsDivId" style="display: block;"></div>
	
				</td>
			</tr>
		</table>
	</div>
	<div class="popUpDiv" id="popUpDiv1" style="display: none;">
		<table bgcolor="white">
			<tr>
				<td>
							
					<div id="issueDtlsDivId" style="display: block;"></div>
			
				</td>
			</tr>
		</table>
	</div>

		<div id="itemDtlOffDivId" style="display: block">
			<table class="TABLEWIDTH" align="center" cellspacing="1px"
				cellpadding="1px">
				<tr>
					<td class='TITLE' colspan='5'><div align="right"><img style="cursor: pointer;height: 20px"
						id='strSearchItemButtonDivId' src="../../hisglobal/images/ItemFinder.png"
						onclick='getItemSelectPopup();' name="searchName"
						title="Click here to Search Item"></div></td>
				</tr>
				<tr>
					<td colspan="5" bgcolor="black"></td>
				</tr>
				
			</table>
		
			<table cellspacing="1px" class="TABLEWIDTH" align="center"
				cellpadding="0px" cellpadding="1px">
	
				<tr>
					<td class="multiLabel" width="23%">Item Name</td>
			
					<td class="multiLabel" width="8%">Category</td>
					<!-- <td class="multiLabel" width="8%">Is Brought By Patient</td> -->
					<!-- <td class="multiLabel" width="8%">Avl Qty</td> -->
			     	<td class="multiLabel" width="8%"><font color="red">*</font>Default Cost/Unit</td>
			     	<td class="multiLabel" width="8%"><font color="red">*</font>Req. Qty</td>
			     	<td class="multiLabel" width="8%"><font color="red">*</font>Approx. Cost</td>
					<td class="multiLabel" width="4%">Action</td>
				</tr>
			</table>
			<%-- 	</logic:equal> --%>
	
			<!-- <table cellspacing="1px" class="TABLEWIDTH" align="center"
				cellpadding="0px" cellpadding="1px">
	
				<tr>
					<td class="multiLabel" width="23%">Item Name</td>
					<td width="33%" class="multiLabel">CIMS Action</td>     Added by warish 22-12-17
					<td width=33%" class="multiLabel" id="cimsId1">CIMS Action</td>
					<td width=33%" class="multiLabel" id="cimsId2"></td>
					<td class="multiLabel" width="8%">Batch No</td>
					<td class="multiLabel" width="8%">Avl Qty</td>
						<td class="multiLabel" width="8%"><font color="red">*</font>Cost/Unit</td>
					<td class="multiLabel" width="8%"><font color="red">*</font>Quantity</td>
					<td class="multiLabel" width="8%"><font color="red">*</font>Cost</td>
					<td class="multiLabel" width="4%">-</td>
				</tr>
			</table> -->

			<div id="id1"></div>
		
          	<table cellspacing="1px" class="TABLEWIDTH" align="center" cellpadding="0px" cellpadding="1px">
				<tr style="display: none;">
					<td class="" width="85%" align="right"><font color="red"><b>Net Cost</b></font></td>
					<td class="" width="15%" align="right"><div id="strNetCost"></div></td>
					
				</tr>
			</table>
			<table id="tableTotal" class="TABLEWIDTH" cellspacing="0px" cellpadding="0px" align="center">
	
				<tbody>
					<tr>
						<td class="multiLabel" width="23%"></td>
						<td class="multiLabel" width="8%"></td>
						<td class="multiLabel" width="8%"></td>
						<td class="multiLabel" width="8%"></td>
				     	<td class="multiLabel" width="8%">Total Cost</td>
				     	<td class="multiLabel" id="totalCost" width="8%"></td>
						<td class="multiLabel" width="4%"></td>
					</tr>
				</tbody>
			</table>
			<table cellspacing="1px" class="TABLEWIDTH" align="center"
				cellpadding="1px">
				<tr>
					<td colspan="5" bgcolor="black"></td>
				</tr>
				<tr class="FOOTER">
					<td colspan="5"></td>
				</tr>
			</table>
		</div>
		<table cellspacing="0px" class="TABLEWIDTH" align="center">
			<tr class="FOOTER">
				<td colspan="2" >
					<div align="left">
						<font size="2" color="red">*</font>Rates are default, may vary as per the actual batch no.
					</div>
				</td>
				<td colspan="2"><font size="2" color="red">*</font>
				Mandatory Fields</td>
			</tr>
		</table>
		
		<table class="TABLEWIDTH" align="center" cellspacing="1px">
			<tr>
				<td align="center" colspan="2" width="25%">
					<br>					 
						<a href="#" class="button" id="" onclick=' return validate();'><span class="save">Save</span></a>
						<a href="#" class="button"	onclick="document.forms[0].reset()"><span class="clear">Clear</span></a> 
						<a href="#" class="button" onclick="cancel('LIST');"><span class="cancel">Cancel</span></a>
					</td>
			</tr>
		</table>
		
		<input type="hidden" name="hmode" />
		<input type="hidden" value="${DossierItemBrandMasterBean.strCurrentDate}" name="strCurrentDate" />
		<input type="hidden" value="${DossierItemBrandMasterBean.strIsMisc}" name="strIsMisc" />
		<input type="hidden" value="${DossierItemBrandMasterBean.strItemCatName}" name="strItemCatName" />
		<input type="hidden" value="${DossierItemBrandMasterBean.strGroupName}" name="strGroupName" />
		<input type="hidden" value="${DossierItemBrandMasterBean.strItemCatNo}" name="strItemCatNo" />
		<input type="hidden" value="${DossierItemBrandMasterBean.strGroupId}" name="strGroupId" />
		<input type="hidden" value="${DossierItemBrandMasterBean.strDeptName}" name="strDeptName" />
		<input type="hidden" value="${DossierItemBrandMasterBean.strDeptCode}" name="strDeptCode" />
		<input type="hidden" value="${DossierItemBrandMasterBean.strIsItemCodeRequired}"
			name="strIsItemCodeRequired" />
		<input type="hidden" name="comboValue" value="${DossierItemBrandMasterBean.strComboValues}" />
		
		<input type="hidden" value="10201100" name="strStoreId" />

		<cmbPers:cmbPers />
	</html:form>
	<jsp:include page="dossier_trans_itemmst_mulirow.jsp"></jsp:include>
	<tag:autoIndex></tag:autoIndex>
</body>
</html>