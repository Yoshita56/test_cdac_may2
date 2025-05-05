<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<%@taglib uri="/WEB-INF/dateTag.tld" prefix="dateTag"%>
<%@ taglib uri="/WEB-INF/hisTab.tld" prefix="tag"%>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic"%>

<html>
<head>
<meta charset="utf-8">
<title>Generic Item Master View Page</title>

<meta name="viewport" content="width=device-width, initial-scale=1.0">





<link rel="stylesheet" href="../../hisglobal/bootstrap/css/bootstrap.min.css">  
<link href="../../hisglobal/DataTables/css/dataTables.bootstrap4.min.css" rel="stylesheet">
	
<script src="../../hisglobal/jquery/3.6.0.min.js"></script>

<script language="JavaScript" src="../../hisglobal/js/DataTables.js"></script>
<script src="../../hisglobal/DataTables/js/dataTables.bootstrap.min.js"></script> 
<script type="text/javascript" src="../../hisglobal/DataTables/js/dataTables.buttons.min.js"></script>

<script type="text/javascript" src="../../hisglobal/DataTables/js/pdfmake.min.js"></script>
<script type="text/javascript" src="../../hisglobal/DataTables/js/vfs_fonts.js"></script>
<script type="text/javascript" src="../../hisglobal/DataTables/js/buttons.html5.min.js"></script>


<link href="../../hisglobal/bootstrap4.0_newgui/font-awesome/css/all.css" rel="stylesheet">





<link href="../css/master.css" rel="stylesheet" type="text/css">
<link href="../../hisglobal/css/tab.css" rel="stylesheet" type="text/css">
<link href="../../hisglobal/css/calendar-tas.css" rel="stylesheet" type="text/css">

<link href="../../hisglobal/css/popup.css" rel="stylesheet" type="text/css">	
<link href="../../hisglobal/css/newpopup.css" rel="stylesheet" type="text/css">
<link href="../../hisglobal/css/buttons.css" rel="stylesheet" type="text/css">

<script language="JavaScript" src="../../hisglobal/masterutil/js/master.js"></script>
<script language="JavaScript" src="../../hisglobal/js/tab.js"></script>
<script language="JavaScript" src="../../hisglobal/js/calendar.js"></script>
<script language="Javascript" src="../../hisglobal/js/validationBootstrap.js"></script>
<script language="JavaScript" src="../../hisglobal/js/multirow.js"></script>
<script language="JavaScript" src="../../hisglobal/js/util.js"></script>
<script language="Javascript" src="../../hisglobal/js/newpopup.js"></script>
<script language="Javascript" src="../js/itemparameterdetails_util.js"></script>
<script type="text/javascript">
	var flag=false;
	
	
	function closeView()
	{
		window.close();
	}
	function checkForPopup(these){
		showPopup(these , '3' , document.forms[0].strCatNo.value , document.forms[0].strItemID.value);
		
	}
	function showParamButton(){
	
		if(document.forms[0].strParamFlag.value=="Yes") 
			document.getElementById("modifyParamShow").style.display="block";
	}
	
</script>
<style>
.card {
	margin: 1% 0;
	border-bottom: 1px solid #d7d7d7;
	padding-bottom: 10px;
	padding: 1% 2% 1.5% 2%;
	background-color: #fff;
	transition: 0.5s;
	box-shadow: 0 0.5px 10px 2px #b0acac;
	color: gray;
}

.card:hover {
	box-shadow: 0 2px 10px 2px #847d7d;
}
.subHeaders {
	font-weight: 500 !important;
	/*color: rgba(33, 32, 32, 0.7);

    font-family: "Helvetica Neue", "Helvetica";*/
	font-size: 19px !important;
	padding-bottom: 0px !important;
}
body {
    
    color: gray;
}
.addtoolbar a{
	margin: 0 1px;
}
html{
	overflow-x: hidden;
}
#mainDataTableId_length{
	/* text-align: left; */
}
#mainDataTableId_info{
	/* text-align: left; */
	color: #0237c0;
}
.buttonsCls{
	margin-right: 1px;
}
#mainDataTableId_wrapper{
	font-size: 12px;
}
#mainDataTableId{
	font-size: 12px;
}
.TDCOMBOHEADER select[name="combo"]{
	max-width: 220px;
}
.TDCOMBOHEADER b{
	font-weight: normal;
	text-transform: uppercase;
	font-size:13px;
}
.dt-buttons{
	float: left;
	padding-left: 10px;
}
.MASTERNAME{
	text-transform:uppercase;
}
.legendNew {
    position: absolute;
    right: 100px;
    line-height: 1.2em;
    top: -2.5em;
    
}
</style>
</head>
<body onload="showParamButton();">
<html:form action="/masters/GenericItemMstBSCNT" name="genericitemBean" type="mms.masters.controller.fb.GenericItemMstFB">
	

	<center>
	<div class="errMsg" id="errMsgId"><bean:write name="genericitemBean" property="strErrMssgstring"/></div>
	<div class="warningMsg" id="warningMsgId"><bean:write name="genericitemBean" property="strWarnMssgstring"/></div>
	<div class="normalMsg" id="normalMsg"><bean:write name="genericitemBean" property="strNormMssgstring"/></div>
<%-- 	<tag:tab tabLabel="Generic Item Master" selectedTab="FIRST" align="center" width="TABLEWIDTH">
		
	</tag:tab> --%>
	</center>
	
	
	
	
	
   <div class="row">
				<div class="col-sm-9" align="left">
							<p class="subHeaders" style="margin-bottom: 0;">
								<i class="fas fa-university" style="font-size: 26px;">&nbsp;</i>Generic Item Master&nbsp;&nbsp;<i class="fas fa-angle-double-right"></i>&nbsp;View		
							</p>
				       </div>
							<div class="col-sm-3" align="right" style="margin-top: -30px;">
							</div>
						</div>
		<hr>	
	<div class="row">
	<div class="col-sm-2">
	<label>Group Name:</label>
	</div>
	<div class="col-sm-5" align="right" style="color:gray;">
	<bean:write name="genericitemBean" property="strGroupNameValue" filter="false"/>
	</div>
	<div class="col-sm-3" align="right">
	<label>Sub Group Name:</label>
	</div>
	<div class="col-sm-2" style="color:gray;">
	<bean:write name="genericitemBean" property="strSubGroupNameValue" filter="false"/>
	</div>
	</div>
			
		
	<div class="row">
	<div class="col-sm-3">
	<label>Generic Item Name:</label>
	</div>
	<div class="col-sm-5" style="color:gray;">
	<bean:write name="genericitemBean" property="strItemName" filter="false"/>
	</div>
	<div class="col-sm-2">
	<label>Item Category:</label>
	</div>
	<div class="col-sm-2" style="color:gray;">
	<bean:write name="genericitemBean" property="strCatValues" filter="false"/>
	</div>
	
	
	</div>
	
	<div class="row">
	<div class="col-sm-3">
	<label>Consumable Type:</label>
	</div>
	<div class="col-sm-3" style="color:gray;">
	<bean:write name="genericitemBean" property="strConsumableType" filter="false"/>
	</div>
	<div class="col-sm-6"></div>
	</div>
		
<br>
	<nav>
					<div class="nav nav-tabs nav-fill" id="nav-tab" role="tablist">
						
						 <a class="nav-item nav-link" id="nav-profile-tab" data-toggle="tab" href="#nav-home" role="tab" aria-controls="nav-profile" aria-selected="false">
						   <button type="button" class="btn btn-info btn-sm btnbg" >
							Item Managed By</button> 
						  </a>
						 
						 
						<a class="nav-item nav-link" id="nav-profile-tab" data-toggle="tab" href="#nav-profile" role="tab" aria-controls="nav-profile" aria-selected="false">
						   <button type="button" class="btn btn-info btn-sm btnbg" >
							Purchase/Inventory</button> 
						  </a>
					
						</div>
				</nav>
				<div class="tab-content py-3 px-3 px-sm-0" id="nav-tabContent">
					<div class="tab-pane fade" id="nav-home" role="tabpanel" aria-labelledby="nav-home-tab">
					<br>
					<div class="row">
<div class="col-sm-3">
<label>Batch No.</label>
</div>
<div class="col-sm-3" style="color:gray;">
<bean:write name="genericitemBean" property="strBatchNo" filter="false"/>
</div>
<div class="col-sm-3">
<label>Expiry Date:</label>
</div>
<div class="col-sm-3" style="color:gray;">
<bean:write name="genericitemBean" property="strExpiryDate" filter="false"/>
</div>
</div>


<div class="row">
<div class="col-sm-3">
<label>Serial No. Required:</label>
</div>
<div class="col-sm-3" style="color:gray;">
<bean:write property="strSerialNo" name="genericitemBean" filter="false"/>
</div>
<div class="col-sm-4">
<label>Whether Item Has Specific Parameter</label>
</div>
<div class="col-sm-2" style="color:gray;">
<div id="strParam"><bean:write property="strParam" name="genericitemBean" filter="false"/></div>
</div>
</div>
					
						</div>
					<div class="tab-pane fade" id="nav-profile" role="tabpanel" aria-labelledby="nav-profile-tab">
					<br>
					<div class="row">
	<div class="col-sm-2">
	<label>Purchase Lead Time:</label>
	</div>
	<div class="col-sm-2" style="color:gray;">
	<bean:write name="genericitemBean" property="strPurchaseLeadTime" filter="false"/>
	</div>
	<div class="col-sm-2">
	<label>Time Format:</label>
	</div>
	<div class="col-sm-2" style="color:gray;">
	<bean:write name="genericitemBean" property="strTimeFormat" filter="false"/>
	</div>
	<div class="col-sm-2">
	<label>Inventory Unit:</label>
	</div>
	<div class="col-sm-2" style="color:gray;">
	<bean:write name="genericitemBean" property="strStockMaintain" filter="false"/>
	</div>
	</div>
	
	<div class="row">
	<div class="col-sm-2">
	<label>Shelf Life:</label>
	</div>
	<div class="col-sm-2" style="color:gray;">
	<bean:write name="genericitemBean" property="strShelfLife" filter="false"/>
	</div>
	<div class="col-sm-2">
	<label>Time Format:</label>
	</div>
	<div class="col-sm-2" style="color:gray;">
	<bean:write name="genericitemBean" property="strShelfTimeFormat" filter="false"/>
	</div>
	<div class="col-sm-2">
	<label>Remark</label>
	</div>
	<div class="col-sm-2" style="color:gray;">
	<bean:write name="genericitemBean" property="strRemarks" filter="false"/>
	</div>
	</div>
	
	<div class="row">
	<div class="col-sm-2">
	<label>Effective From:</label>
	</div>
	<div class="col-sm-2" style="color:gray;">
	<bean:write name="genericitemBean" property="strEffectiveFrom" filter="false"/>
	</div>
	<div class="col-sm-2">
	<label>Record Status:</label>
	</div>
	<div class="col-sm-2" style="color:gray;">
	<bean:write name="genericitemBean" property="strIsValid" filter="false"/>
	</div>
	</div>
					
					</div>
					
				</div>
	
		<hr>
<!-- <div class="row rowFlex reFlex">
							<div class="col-sm-9"></div>
							<div class="col-sm-3" align="right">
							<button type="button" class="btn btn-danger"  data-dismiss="modal"	style="cursor: pointer;">Cancel</button>
							</div>
						</div> -->
						
						

	
				
		
	
	
	
	
	
	
	
	
	
	

	<table class="TABLEWIDTH" align="center" cellpadding="1px" cellspacing="1px" style="display:none;">   
	<tr class="HEADER">
		<td colspan="4" width="25%">Generic Item Master&gt;&gt; view</td>
		</tr>
		<tr>
			<td width="25%" class="LABEL">
			Group Name
			</td>
			<td class="CONTROL">
				<bean:write name="genericitemBean" property="strGroupNameValue" filter="false"/>
			</td>
			<td width="25%" class="LABEL">
				Sub Group Name
			</td>
			<td width="25%" class="CONTROL">
				<bean:write name="genericitemBean" property="strSubGroupNameValue" filter="false"/>
			</td>
		</tr>
		<tr>
			
			<td width="25%" class="LABEL">
			Generic Item Name
			</td>
			<td width="25%" class="CONTROL" colspan="">
				<bean:write name="genericitemBean" property="strItemName" filter="false"/>
				
			</td>
			<td width="25%" class="LABEL">
			Item Category
			</td>
			<td class="CONTROL" width="25%">
				<bean:write name="genericitemBean" property="strCatValues" filter="false"/>
			</td>
		</tr>
		<tr>
		<td class="LABEL" colspan="1" width="25%">
			Consumable Type
			</td>
			<td class="CONTROL" colspan="3" width="">
				<bean:write name="genericitemBean" property="strConsumableType" filter="false"/>
				
				
			</td>
		</tr>
		<logic:equal value="0" name="genericitemBean" property="strConsumableFlag" >
		<tr>
						
		<td class="LABEL" >
			Is Asset
			</td>
			<td class="CONTROL">
				<bean:write name="genericitemBean" property="strAssetsReq"/>
				
				
			</td>
			<td class="LABEL" >
			Depriciation Cost
			</td>
			<td class="CONTROL">
				<bean:write name="genericitemBean" property="strDepreciationcost"/>&nbsp;%
				
				
			</td>
		</tr>
		</logic:equal>
					
	</table>
	
	
	
	<table class="TABLEWIDTH" align="center" cellpadding="1px" cellspacing="1px" style="display:none;">		
				<tr>
				  <td  colspan="4" class="TITLE" width="25%">
				<div id="itemManagePlusId" align="left" style="display:none;">
					Item Managed By
					</div>
					<div id="itemManageMinusId" style="display:block;" align="left">
						
								Item Managed By
					</div>
					</td>
				</tr>
	</table>
	<div id="itemManageDtlId" style="display: block">
	<table class="TABLEWIDTH" align="center" cellspacing="1px" cellpadding="1px" style="display:none;">
		<tr>
			<td class="LABEL" colspan="1" width="25%">
				Batch No.
			</td>
			<td class="CONTROL" colspan="" width="25%">
				<bean:write name="genericitemBean" property="strBatchNo" filter="false"/>
			</td>
			<td class="LABEL" width="25%">
				Expiry Date
			</td>
			<td class="CONTROL" width="25%">
				<bean:write name="genericitemBean" property="strExpiryDate" filter="false"/>
			</td>
			
		</tr>
		<tr>
			<td class="LABEL" colspan="1" width="25%">
				Serial No. Required
			</td>
			<td class="CONTROL" colspan="3" width="25%">
				<bean:write property="strSerialNo" name="genericitemBean" filter="false"/>
				
			</td>
			
			
		</tr>
		<tr>
			<td class="LABEL" colspan="1" width="25%">
				Whether Item Has Specific Parameter
			</td>
			<td class="CONTROL" colspan="1" width="25%">
				<div id="strParam"><bean:write property="strParam" name="genericitemBean" filter="false"/></div>
				
			</td>
			
			<td class="CONTROL" colspan="2" width="50%">
			<div id="modifyParamShow" style="display:none">
			<img src="../../hisglobal/images/show_parameter_values.GIF" onclick="checkForPopup(this)" style="cursor: pointer; ">
			</div>				
			</td>
		</tr>
	</table>
	
	</div>
	<table class="TABLEWIDTH" align="center" cellspacing="1px" cellpadding="1px" style="display:none;">		
				<tr>
				  <td  colspan="4" class="TITLE" width="25%">
				<div id="purchasePlusId" align="left" style="display:none;">
					<img src="../../hisglobal/images/plus.gif" 
									onClick="view1('purchasePlusId','purchaseMinusId','purchaseId');" style="cursor: pointer; "/>
						Purchase/Inventory
					</div>
					<div id="purchaseMinusId" style="display:block;" align="left">
						
								Purchase/Inventory
					</div>
					</td>
				</tr>
	</table>
	
	
	
	<div id="purchaseId" style="display:block;">
	<table class="TABLEWIDTH" align="center" cellspacing="1px" cellpadding="1px" style="display:none;">
		<tr>
			<td class="LABEL" colspan="1" width="25%">
				Purchase Lead Time
			</td>
			<td class="CONTROL" colspan="" width="25%">
				
				<bean:write name="genericitemBean" property="strPurchaseLeadTime" filter="false"/>
				
				
			</td>
			<td class="LABEL" colspan="1" width="25%">Time Format</td>
			<td class="CONTROL" colspan="1" width="25%">
				<bean:write name="genericitemBean" property="strTimeFormat" filter="false"/>
				
			</td>
			
		</tr>
		<tr>
			<td class="LABEL" colspan="1" width="25%">
				Inventory Unit
			</td>
			<td class="CONTROL" colspan="" width="25%">
				
					<bean:write name="genericitemBean" property="strStockMaintain" filter="false"/>
				
			</td>
			<td class="LABEL" colspan="2" >
				
			</td>
			</tr>
		<tr>
			<td class="LABEL" colspan="1" width="25%">
				Shelf Life
			</td>
			<td class="CONTROL" colspan="" width="25%">
				<bean:write name="genericitemBean" property="strShelfLife" filter="false"/>
				
			</td>
			<td class="LABEL" colspan="1" width="25%">Time Format</td>
			<td class="CONTROL" colspan="1" width="25%">
				<bean:write name="genericitemBean" property="strShelfTimeFormat" filter="false"/>
				
			</td>
		</tr>
		
	</table>
	</div>
	
<table cellpadding="1px" cellspacing="1px" class="TABLEWIDTH" align="center" style="display:none;">
	<tr>
		<td class="LABEL" width="25%"> 
		
			Remarks
		</td>
		<td class="CONTROL"  width="75%" colspan="3">
		<bean:write name="genericitemBean" property="strRemarks" filter="false"/>
			</td>
		
			
		</tr>
			<tr> 
			<td class="LABEL" width="25%"> 
			Effective From
		</td>
		<td class="CONTROL"  width="25%" colspan="">
				<bean:write name="genericitemBean" property="strEffectiveFrom" filter="false"/>
		</td>
    <td class="LABEL">Record Status</td>
    <td  class="CONTROL" > 
    	<bean:write name="genericitemBean" property="strIsValid" filter="false"/>
       
    </td>
    
  </tr>
	</table>
	<table cellpadding="1px" cellspacing="1px" class="TABLEWIDTH" align="center" style="display:none;">
		<tr class="FOOTER">
		<td colspan="4" width="25%"></td>
		</tr>
	</table>
	<table  class="TABLEWIDTH" align="center" cellpadding="1px" cellspacing="1px" style="display:none;">
	
		<tr>

			<td align="center" colspan="2" width="25%">
			
			<!--	<img src="../../hisglobal/images/btn-ccl.png" onClick ="closeView();" style="cursor: pointer; " title="Cancel View">-->
				<br>
				<a href="#" class="button" onclick="closeView();"><span class="cancel">Cancel</span></a>
			</td>
		</tr>
	</table>
<input type="hidden" name="hmode"/>
<input type="hidden" value="${genericitemBean.strCurrentDate}" name="strCurrentDate"/>
<input type="hidden" value="${genericitemBean.strGroupId}" name="strGroupId"/>
<input type="hidden" value="${genericitemBean.strSubGroupId}" name="strSubGroupId"/>
<input type="hidden" value="${genericitemBean.strChk}" name="strChk"/>
<input type="hidden" value="${genericitemBean.strParam}" name="strParamFlag"/>
<input type="hidden" value="${genericitemBean.strCatNo}" name="strCatNo"/>
<input type="hidden" value="${genericitemBean.strItemID}" name="strItemID"/>



<div id="blanket" style="display:none;"></div>
<div class="popUpDiv" id="popUpDivId" style="display:none;">
<table bgcolor="white">
<tr>
<td>
<div id="itemParameterDtlDivId" style="display:block;"></div>
</td>
</tr>
</table>
</div>
</html:form>
<tag:autoIndex></tag:autoIndex>
</body>
</html>