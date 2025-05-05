<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<!--
Developer : Anshul Jindal
  Version : 1.0 
  Date : 11/June/2009
   Module:MMS
  Unit:Issue Desk Transaction
    -->
    
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic"%>
<%@taglib uri="/WEB-INF/dateTag.tld" prefix="dateTag"%>
<%@ taglib uri="/WEB-INF/hisTab.tld" prefix="tag"%>
<%@ taglib uri="/WEB-INF/comboPersistence.tld" prefix="cmbPers" %>


<html>
<head>
<meta charset=UTF-8">
<title>Issue Indent</title>
<link href="../css/transaction.css" rel="stylesheet" type="text/css">
<link href="../../hisglobal/css/tab.css" rel="stylesheet" type="text/css">
<link href="../../hisglobal/css/calendar-tas.css" rel="stylesheet" type="text/css">
<link href="../../hisglobal/css/popup.css" rel="stylesheet" type="text/css">	
<link href="../../hisglobal/css/newpopup.css" rel="stylesheet" type="text/css">
<link href="../../hisglobal/css/buttons.css" rel="stylesheet" type="text/css">

	
 <script language="JavaScript" src="../../hisglobal/masterutil/js/master.js"></script>
<script language="JavaScript" src="../../hisglobal/js/tab.js"></script>
<script language="JavaScript" src="../../hisglobal/js/calendar.js"></script>
<script language="Javascript" src="../../hisglobal/js/validation.js"></script>
<script language="Javascript" src="../../hisglobal/js/util.js"></script>
<script language="Javascript" src="../../hisglobal/js/popup.js"></script>
<script language="Javascript" src="../../hisglobal/js/newpopup.js"></script>
<script language="Javascript" src="../../hisglobal/js/multirow.js"></script>
<script language="Javascript" src="../js/issueDetails_util.js"></script> 
<script language="Javascript" src="../js/itemparameterdetails_util.js"></script> 
<script language="Javascript" src="../js/issuedesk_trans.js"></script>
<style>

 
@media screen and (orientation: portrait) {
  #toolbar {
    width: 100%;
  }
}

</style>

<script type="text/javascript">


function hideIssuePopup() 
{	
	document.getElementById("issueDtlsPrintDivId").innerHTML = "";
	hide_popup('popUpDivPrint');	
}



</script>
<style>
        .example {
            page-break-after: always;
        }
    </style>
</head>
<body   onload="getReport();">
<html:form name="issueDeskTransBean" action="/transactions/IssueDeskTransCNT" type="mms.transactions.controller.fb.IssueDeskTransFB">
<center>
	<div id="errMsg" class="errMsg"><bean:write name="issueDeskTransBean"
		property="strErr" /></div>
	<div class="warningMsg"><bean:write name="issueDeskTransBean"
		property="strWarning" /></div>
	<div id="normalMsg" class="normalMsg"><bean:write name="issueDeskTransBean"
		property="strNormalMsg" /></div>


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




<tag:tab tabLabel="Issue Desk"
				selectedTab="FIRST" align="center" width="TABLEWIDTH">
			</tag:tab>
		</center>	
	<table class="TABLEWIDTH" align="center" cellpadding="1px" cellspacing="1px" border="0" >

		<tr class="HEADER">
		
			<td colspan="4"></td>
		</tr>

		<tr>
			<td class="LABEL" width="50%" colspan="2">Store Name</td>
			<td width="50%" class="CONTROL" colspan="2"><bean:write name="issueDeskTransBean" property="strStoreName" /></td>

		</tr>
		<tr>
			
			 <td  colspan="4" class="TITLE" width="25%">
				<div id="PlusDivId" align="left" style="display:none;">
					<img src="../../hisglobal/images/plus.gif" title='Show Details'
									onClick="clickPlus();" style="cursor: pointer; "/>
						Request Details
					</div>
					<div id="MinusDivId" style="display:block;" align="left">
						<img src="../../hisglobal/images/minus.gif"  title='Hide Details'
								onClick="clickMinus();" style="cursor: pointer; "/>
								Request Details
					</div>
					</td>
		</tr>
			</table>
			<div id="ReqDtlsDiv">
	<table class="TABLEWIDTH" align="center" cellpadding="1px" cellspacing="1px" border="0" style="">
		
		<tr>
				<td width="25%" class="LABEL">Request No.</td>
				<td width="25%" class="CONTROL"><bean:write name="issueDeskTransBean" property="strIndentNo" /></td>
					<td width="25%" class="LABEL">Request Date</td>
				<td width="25%" class="CONTROL"><bean:write name="issueDeskTransBean" property="strIndentDate" /></td>
			</tr>
			<tr>
					<td width="25%" class="LABEL">Item Category</td>
				<td width="25%" class="CONTROL"><bean:write name="issueDeskTransBean" property="strItemCategory" /></td>
					<td class="LABEL" width="25%">Raising Store</td>
			<td width="25%" class="CONTROL"><bean:write name="issueDeskTransBean" property="strRaisingStoreName" /></td>
		</tr>
			<tr>
			<td class="LABEL" width="25%">Req. Status </td>
			<td  class="CONTROL" width="25%"><bean:write name="issueDeskTransBean" property="strReqStatusName" /></td>
			<td class="LABEL" width="25%"><div style='display:none;' id="budgetIDOne">Budget Avl.</div></td>
			<td  class="CONTROL" width="25%">
			<div id="budgetIDTwo">
			   <a STYLE='cursor:pointer;cursor:pointer;color:blue'  onClick='avlBudgetDtl(this);' TITLE='Click Here Get Budget Details' >			
			<bean:write name="issueDeskTransBean" property="strAvalaibleBudget" /></a></div>
			</td>
		</tr>
		<tr>
			<td class="LABEL" width="25%">Remarks from Indenting Store</td>
			<td  class="CONTROL" width="25%"><bean:write name="issueDeskTransBean" property="strRemarksIndent" /></td>
			<td class="LABEL" width="25%">Remarks from Last Approval</td>
			<td  class="CONTROL" width="25%"><bean:write name="issueDeskTransBean" property="strRemarksApptwo" /></td>
		</tr>
		</table>
		</div>
		
		<table class="TABLEWIDTH" align="center" cellpadding="1px" cellspacing="1px" border="0">
		<tr class="TITLE">
			<td colspan="4"><div id='' style="font-family: Arial, Helvetica, sans-serif;font-size:13px;">Item Detail(s)</div></td>
		</tr>
		</table>
		
		 <logic:equal value="0" name="issueDeskTransBean" property="strBudgetFlg">
			<logic:equal value="10" property='strItemCategoryNo' name='issueDeskTransBean'>
				<table class="TABLEWIDTH" bgcolor='black' align="center" cellpadding="1px" cellspacing="1px" border="0">
				<tr>		
					<td class="multiRPTLabel" width="25%">Item Name</td>
					<td class="multiRPTLabel" width="5%">Item Type</td>
					<td class="multiRPTLabel" width="5%">Ind.Str Qty.</td>
					<td class="multiRPTLabel" width="5%">Avl. Qty.</td>
					<td class="multiRPTLabel" width="10%">Req Qty./Sanc Qty.</td>
					<td class="multiRPTLabel" width="8%"><font  color="red">*</font>Issue Qty.</td>
					<td class="multiRPTLabel" width="9%"><font  color="red">*</font>Batch</td>
					<td class="multiRPTLabel" width="9%" title="Exp. Date">Exp. Date</td>
					<td class="multiRPTLabel" width="7%"><font  color="red">*</font>Unit</td>
					<td class="multiRPTLabel" width="10%">Remarks</td>
					<td class="multiRPTLabel" width="10%">LP Qty</td>	
					<!--   <td class="multiRPTLabel" width="4%" title="Item Preferences">#</td> -->
				</tr>
				</table>
			</logic:equal>
			<logic:notEqual value="10" property='strItemCategoryNo' name='issueDeskTransBean'>
				<table class="TABLEWIDTH" bgcolor='black' align="center" cellpadding="1px" cellspacing="1px" border="0">
				<tr>		
					<td class="multiRPTLabel" width="25%">Item Name</td>
					<td class="multiRPTLabel" width="5%">Item Type</td>
					<td class="multiRPTLabel" width="5%">Bal Qty.</td>
					<td class="multiRPTLabel" width="5%">Avl. Qty.</td>
					<td class="multiRPTLabel" width="10%">Req Qty./Sanc Qty.</td>
					<td class="multiRPTLabel" width="8%"><font  color="red">*</font>Issue Qty.</td>
					<td class="multiRPTLabel" width="9%"><font  color="red">*</font>Batch</td>
					<td class="multiRPTLabel" width="9%" title="Exp. Date">Exp. Date</td>
					<td class="multiRPTLabel" width="7%"><font  color="red">*</font>Unit</td>
					<td class="multiRPTLabel" width="10%">Remarks</td>
					<td class="multiRPTLabel" width="10%">LP Qty</td>	
					<!--   <td class="multiRPTLabel" width="4%" title="Item Preferences">#</td> -->
				</tr>
				</table>
			</logic:notEqual>
			<div id="itemDtlsDiv"><bean:write name="issueDeskTransBean" property="strItemDtls" filter="false"></bean:write></div>
			<input type="hidden" value="0.00" name="strApproxAmtDivId" id="strApproxAmtDivId" >
			<input type="hidden" name="strFinalApproxAmt">
		</logic:equal>
		<logic:equal value="1" name="issueDeskTransBean" property="strBudgetFlg">
			<logic:equal value="10" property='strItemCategoryNo' name='issueDeskTransBean'>
				<table class="TABLEWIDTH" bgcolor='black' align="center" cellpadding="1px" cellspacing="1px" border="0">
				<tr>		
					<td class="multiRPTLabel" width="28%">Item Name</td>
					<td class="multiRPTLabel" width="13%">Issue/Receiving Store Qty.</td>
					<td class="multiRPTLabel" width="15%">Req Qty./Sanc Qty.</td>
					<td class="multiRPTLabel" width="10%"><font  color="red">*</font>Issue Qty.</td>
					<td class="multiRPTLabel" width="10%"><font  color="red">*</font>Batch</td>
					<td class="multiRPTLabel" width="9%" title="Exp. Date">Exp. Date</td>
					<td class="multiRPTLabel" width="10%"><font  color="red">*</font>Unit</td>
					<!--   <td class="multiRPTLabel" width="4%" title="Item Preferences">#</td> -->				
					<td class="multiRPTLabel" width="10%">Cost</td>	
					<td class="multiRPTLabel" width="10%">Remarks</td>
					<td class="multiRPTLabel" width="10%">LP Qty</td>				
				</tr>
				</table>
			</logic:equal>
			<logic:notEqual value="10" property='strItemCategoryNo' name='issueDeskTransBean'>
				<table class="TABLEWIDTH" bgcolor='black' align="center" cellpadding="1px" cellspacing="1px" border="0">
				<tr>		
					<td class="multiRPTLabel" width="28%">Item Name</td>
					<td class="multiRPTLabel" width="13%">Issue/Receiving Store Qty.</td>
					<td class="multiRPTLabel" width="15%">Req Qty./Sanc Qty.</td>
					<td class="multiRPTLabel" width="10%"><font  color="red">*</font>Issue Qty.</td>
					<td class="multiRPTLabel" width="10%"><font  color="red">*</font>Batch</td>
					<td class="multiRPTLabel" width="9%" title="Exp. Date">Exp. Date</td>
					<td class="multiRPTLabel" width="10%"><font  color="red">*</font>Unit</td>
					<!--   <td class="multiRPTLabel" width="4%" title="Item Preferences">#</td> -->				
					<td class="multiRPTLabel" width="10%">Cost</td>	
					<td class="multiRPTLabel" width="10%">Remarks</td>
					<td class="multiRPTLabel" width="10%">LP Qty</td>			
					
				</tr>
				</table>
			</logic:notEqual>
			<div id="itemDtlsDiv"><bean:write name="issueDeskTransBean" property="strItemDtls" filter="false"></bean:write></div>		
		
			<table class="TABLEWIDTH" align="center" cellpadding="1" cellspacing="1">
				<tr>
					<td width="80%" class="LABEL">Total Approx Cost(Rs):</td>
					<td width="18%" class="CONTROL" style="color: red; font-weight: bold;text-align:left;">
		    	<!--<input type="text" style="color: red; font-weight: bold"  disabled="disabled" class="txtFldNormal"  value="0.00" name="strApproxAmtDivId" id="strApproxAmtDivId" >
					<input type="hidden" name="strFinalApproxAmt"></td>  -->	
				</tr>
			</table>
			
			<input type="hidden" value="0.00" name="strApproxAmtDivId" id="strApproxAmtDivId" >
			<input type="hidden" name="strFinalApproxAmt">
		</logic:equal>
		
		
				
		<table class="TABLEWIDTH" align="center" cellpadding="1px" cellspacing="1px" border="0">
		<tr class="TITLE">
			<td colspan="4"></td>
		</tr>
		<tr >
    		<td width ="50%" class ="LABEL" valign="middle" colspan="2">Raise LP Indent</td>
    		<td width ="50%" class ="CONTROL" colspan="2">
					<input type="radio" name="strBSIndent" onchange='chkradio(this);' value="1"  />Yes &nbsp;&nbsp;
	 			 	<input type="radio" name="strBSIndent" onchange='chkradio(this);' value="0" checked/>No</td>
  		</tr>
		<tr>
           <td width ="25%%" class ="LABEL" valign="middle" ><font color="red">*</font>Received By</td>
           <td width ="25%" class ="CONTROL">
    
            <select name="strReceivedComboBy" onchange="checkValCombo();" class="comboNormal">
               	<bean:write name="issueDeskTransBean" property="strReceivedByOptionVal" filter="false"/>
               </select>
               
            </td>
            <td class="CONTROL" width="25%" id='labelId'>
            	<div id='labelNameId'></div>
   </td>
    <td class="CONTROL" width="25%">
            	<div id="nameOtherFld" style="display: none">
            		<input type='text' name='strReceivedBy' value='' onkeypress='return validateData(event,16);' maxlength='50'>
            	</div>
            </td>
  </tr>
			<tr >
    <td width ="50%" class ="LABEL" valign="middle" colspan="2"><font color="red">*</font>Issue By & Remarks</td>
    <td width ="50%" class ="CONTROL" colspan="2"><textarea  name="strRemarks" cols="25" rows="2" onkeypress="return validateData(event,9);"></textarea></td>
  </tr>
		<tr class="FOOTER">
			 <td  colspan="4"><font id='manFld'>[ InHand Qty Less than Re-Order Level ]</font>&nbsp;&nbsp;&nbsp;<font  color="red">*</font> Mandatory Fields  </td>
		</tr>
	</table>
	<!-- <table border="0" class="TABLEWIDTH" align="center">
	<tr id="saveId">
	  <td align="center">
		<img style="cursor: pointer; " src="../../hisglobal/images/btn-sv.png" onClick=" return validate1();" title="Save Record"/> 
		<img style="cursor: pointer; " title="Clear Content" src="../../hisglobal/images/btn-clr.png" onClick="document.forms[0].reset();clearPage();" />
		<img style="cursor: pointer;" title="Click Here Go Back  To Main Desk" src="../../hisglobal/images/back_tab.png" onClick="cancel();" />
	  </td>
	</tr>
	</table> -->
	<br>
	<div align="center" id="saveId">			
	                    <a href="#" class="button" id=""         onclick="getVoucher();" tabindex="1"><span class="print">Print</span></a> 		 
					 	<a href="#" class="button" id="submitId" onclick="return validate1();"><span class="save">Save</span></a>
						<a href="#" class="button"	             onClick="document.forms[0].reset();clearPage();"><span class="clear">Clear</span></a> 
						<a href="#" class="button"               onclick="cancel();"><span class="cancel">Cancel</span></a>
					</div> 
	
<div id="blanket" style="display:none;"></div>
<div class="popUpDiv" id="popUpDiv" style="display:none;">

<table bgcolor="white">

<tr>

<td>

<div id="stockDtlsDivId" style="display:block;"></div>
<div id="itemOtherDtlsDiv" style="display:block;" class="popup" ></div>
 <div id="issueDtlsDivId" style="display:block;"></div>

</td>

</tr>

</table>

</div>

		<input type="hidden" name="hmode"/>
		<input type="hidden" name="strStoreName" 			value="${issueDeskTransBean.strStoreName}"/>
		<input type="hidden" name="strStoreId" 				value="${issueDeskTransBean.combo[0]}"/>
		<input type="hidden" name="strIssueNo" 				value="${issueDeskTransBean.strIssueNo}"/>
		<input type="hidden" name="strIndentNo" 			value="${issueDeskTransBean.strIndentNo}"/>
		<input type="hidden" name="strIndentDate" 			value="${issueDeskTransBean.strIndentDate}"/>
		<input type="hidden" name="strItemCategoryNo" 		value="${issueDeskTransBean.strItemCategoryNo}"/>
		<input type="hidden" name="strRaisingStoreId" 		value="${issueDeskTransBean.strRaisingStoreId}"/>
		<input type="hidden" name="strReOrderFlgColor" 		value="${issueDeskTransBean.strReOrderFlgColor}"/>
		<input type="hidden" name="strBudgetFlg" 			value="${issueDeskTransBean.strBudgetFlg}"/>
		<input type="hidden" name="strAvalaibleBudgetDtl" 	value="${issueDeskTransBean.strAvalaibleBudgetDtl}"/>
		<input type="hidden" name="strChk" 					value="${issueDeskTransBean.strChk}"/>
		<input type="hidden" name="strAvalaibleBudget" 		value="${issueDeskTransBean.strAvalaibleBudget}"/>		
		<input type="hidden" name="searchColumn" 			value='<%=request.getParameter("searchColumn") %>' />
        <input type="hidden" name="search" 					value='<%=request.getParameter("search") %>' />
        <input type="hidden" name="blockNo" 				value='<%=request.getParameter("blockNo") %>' />
        <input type="hidden" name="prevNext" 				value='<%=request.getParameter("prevNext") %>' />
        <input type="hidden" name="rowNum" 					value='<%=request.getParameter("rowNum") %>'/>
        <input type="hidden" name="divisionId" 				value='<%=request.getParameter("divisionId") %>' />



<cmbPers:cmbPers/>

<div id="blanket" style="display: none;"></div>
     <div class="popUpDiv" id="popUpDivPrint" style="display: none;">
		<table bgcolor="white">
			<tr>
				<td>
							
					<div id="issueDtlsPrintDivId" style="display: block;"></div>
			
				</td>
			</tr>
	    </table>
	 </div>
</html:form>

<div class="popup" id="popup" style="display: none"></div>
	<tag:autoIndex></tag:autoIndex>  
</body>
</html>