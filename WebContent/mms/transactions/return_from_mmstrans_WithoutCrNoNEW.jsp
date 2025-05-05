<%@ page language="java" contentType="text/html;"	pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic"%>
<%@ taglib uri="/WEB-INF/dateTag.tld" prefix="date"%>
<%@ taglib uri="/WEB-INF/hisTab.tld" prefix="tag"%>

<%@ taglib uri="/WEB-INF/crNo.tld" prefix="crNo"%>

<!-- 
/**
 * Developer : Tanvi Sappal
 * Version : 1.0
 * Date : 23/Apr/2009
*/
-->
<html>
<head>
<meta charset=UTF-8">
<title>Return Process</title>
<link href="../css/master.css" rel="stylesheet" type="text/css">
<link href="../../hisglobal/css/tab.css" rel="stylesheet" type="text/css">
<link href="../../hisglobal/css/calendar-tas.css" rel="stylesheet" type="text/css">
<link href="../../hisglobal/css/popup.css" rel="stylesheet" type="text/css">
<link href="../../hisglobal/css/buttons.css" rel="stylesheet" type="text/css">
<script language="JavaScript" src="../../hisglobal/masterutil/js/master.js"></script>
<script language="JavaScript" src="../../hisglobal/js/tab.js"></script>
<script language="JavaScript" src="../../hisglobal/js/calendar.js"></script>
<script language="Javascript" src="../../hisglobal/js/validation.js"></script>
<script language="Javascript" src="../../hisglobal/js/util.js"></script>
<script language="Javascript" src="../../hisglobal/js/popup.js"></script>
<script language="Javascript" src="../js/returnFrom_mmsTrans_WithoutCrNo.js"></script>
<script language="Javascript" src="../js/mms.js"></script>
<script type="text/javascript">

</script>
</head>


<body onload="onLoadFuncWithoutCrNo();">
<html:form action="/transactions/ReturnFromTransCNT.cnt" name="duplicateIssueToPatientVoucherTransBean" type="mms.transactions.controller.fb.ReturnFromTransFB" method="post">
	<div class="errMsg" id="errMsg"><bean:write name="duplicateIssueToPatientVoucherTransBean" property="strErr" /></div>
	<div class="warningMsg" id="warningMsg"><bean:write name="duplicateIssueToPatientVoucherTransBean" property="strWarning" /></div>
	<div class="normalMsg" id="normalMsg"><bean:write name="duplicateIssueToPatientVoucherTransBean" property="strMsg" /></div>

	<logic:equal value="0" name="duplicateIssueToPatientVoucherTransBean" property="strMode" >
	<tag:tab tabLabel="Return From Patient" selectedTab="FIRST" align="center"
		width="TABLEWIDTH">
	</tag:tab>
	<table class="TABLEWIDTH" align="center" border="0" cellspacing ="1px">
	<tr class="HEADER"> 
	 <td colspan="4"></td>
    </tr>
    </table>
	</logic:equal>
	
	<logic:equal value="1" name="duplicateIssueToPatientVoucherTransBean" property="strMode" >
	<tag:tab tabLabel="Return From Staff" selectedTab="FIRST" align="center"
		width="TABLEWIDTH">
	</tag:tab>
	<table class="TABLEWIDTH" align="center" border="0" cellspacing ="1px">
	<tr class="HEADER"> 
	 <td colspan="4">Return From Staff&gt;&gt;
    </td>
    </tr>
    </table>
	</logic:equal>
	
	
	<logic:equal value="2" name="duplicateIssueToPatientVoucherTransBean" property="strMode" >
	<tag:tab tabLabel="Return From Patient/Staff" selectedTab="FIRST" align="center"
		width="TABLEWIDTH">
	</tag:tab>
	<table class="TABLEWIDTH" align="center" border="0" cellspacing ="1px">
		<tr class="HEADER"> 
		 <td colspan="4">Return From Patient/Staff&gt;&gt;
	    </td>
	    </tr>
    </table>
	</logic:equal>

		<table class="TABLEWIDTH" align="center" cellpadding="1" cellspacing="1">
		<tr>

			<td width="25%" class="LABEL"><font color="red">*</font>Drug Warehouse Name</td>
			<td width="25%" class="CONTROL">
				<select name="strStoreId" id="strStoreId" class='comboNormal' onchange="itemCategoryCombo();">
					<bean:write name="duplicateIssueToPatientVoucherTransBean" property="strStoreNameCombo" filter="false" />
					<option value="0">Select Value</option>
				</select></td>

			<td width="25%" class="LABEL"><font color="red">*</font>Drug Category</td>
			<td width="25%" class="CONTROL">
				<div id="itemCategoryId" style="display:block;">
					<select name="strItemCategoryNo" id="strItemCategoryNo" class='comboNormal'>
						<bean:write name="duplicateIssueToPatientVoucherTransBean" property="strItemCategoryCombo" filter="false" />
						<option value="0">Select Value</option>
					</select></div>	</td>
		</tr>

		
		<tr>
			<td width="25%" class="LABEL"><font color="red">*</font>Issue No.</td>
			<td colspan="2" class="CONTROL">
				<input type="text" name="strIssueNumber" value="${duplicateIssueToPatientVoucherTransBean.strIssueNumber}" >
<%--			<crNo:crNo value="${duplicateIssueToPatientVoucherTransBean.strCrNo}" js=" onkeypress='return initGoFunc(event);'"></crNo:crNo> --%>
			<input type="image" style="cursor: pointer; " title="Return Process" align="top"
				src="../../hisglobal/images/search_icon1.gif" name="search" value="Search"
				onclick="return searchFunc();" onkeyup="searchFuncOnEnter(event);"></td>
			
			<td colspan="1" class="CONTROL">
			
			<input type="image" style="cursor: pointer; " title="Return Process" align="top"
				src="../../hisglobal/images/Go.png" name="go" value="Go"
				onclick="return goFunc();" onkeyup="goFuncOnEnter(event);"></td>				
		</tr>	
		
	</table>
	
<!-- return_from_mmstrans_go.jsp	-->
		
	
<div id="allDivId" style="display: block;">
 <table class="TABLEWIDTH" align="center" border="0" cellspacing ="1px">
    <tr>  
     <td width="5%" class="TITLE" align="center"><input type='hidden'
				name='button1' value="0">
     <img src="../../hisglobal/images/plus.gif"   id="plus1"  style="display:block;cursor:pointer" onClick="ftn11();">
     <img src="../../hisglobal/images/minus.gif"  id="minus1" style="display:none;cursor:pointer" onClick="ftn11();"></td>
     
    <td colspan="3" class="TITLE" align="left"><b>Patient Demographic Detail</b></td>   
  </tr>
 </table>
 
 <div id = "patientDetailsDivId" style="display:none;">
  <table class="TABLEWIDTH" align="center" cellspacing ="1px">
  
  			<tr>
				<td class="LABEL" colspan="1">Patient Name</td>
				<td class="CONTROL" colspan="1">
					<bean:write name="duplicateIssueToPatientVoucherTransBean" property="strPatientName" filter="false" />
				</td>
				
				
				<td class="LABEL" colspan="1">Father's Name</td>
			
				<td class="CONTROL" colspan="1">
					<bean:write name="duplicateIssueToPatientVoucherTransBean" property="strPatientFatherName" filter="false" />
				</td>
				
				
			</tr>

			
			<tr>
				<td class="LABEL" colspan="1">Patient's Age</td>
				<td class="CONTROL" colspan="1">
					<bean:write name="duplicateIssueToPatientVoucherTransBean" property="strPatientAge" filter="false" />
				</td>
			
				<td colspan="1" class="LABEL">Gender</td>
				<td colspan="1" class="CONTROL">
					<bean:write name="duplicateIssueToPatientVoucherTransBean" property="strPatientGenderCode" filter="false" />
				</td>
		</tr>
<%--  Address --%>		

		<tr>	
			<td colspan="1" class="LABEL">Address</td>
			<td class="CONTROL">
				<bean:write name="duplicateIssueToPatientVoucherTransBean" property="strPatientAddress"/>
			</td>		
			<td class="CONTROL" colspan="3"></td>	
		</tr>			
 </table>
 </div>
 

	<div id="issueDivId" style="display: none;">
 <table class="TABLEWIDTH" align="center" border="0" cellspacing="1px">
		<tr style="display: none;">
			<td colspan="1" class="LABEL">Issue Date</td>
			<td class="CONTROL" colspan="1">
			<div id="issueDtDivId"></div>
			</td>
			<td colspan="1" class="LABEL">Dept/Unit Name</td>
			<td colspan="1" class="CONTROL">
			<div id="deptNameDivId"></div>
			</td>
		</tr>
		<tr style="display: none;">
			<td class="LABEL" colspan="1">Consultant Name</td>
			<td class="CONTROL" colspan="3">
			<div id="consultantNameDivId"></div>
			</td>
		</tr>

	</table>
	</div>
	<div id="id1" style="display: none;">
	<table class="TABLEWIDTH" align="center" border="0" cellspacing="1px">
		<tr>
			<td colspan="4" class="TITLE" align="left">Issue Drug Details</td>
		</tr>
	</table>
	</div>
	
	<div id="itemDetailsNewDivId" style="display: block;"></div>
	
	 <table class="TABLEWIDTH" align="center" cellpadding="1px" cellspacing="1px">
       
       
          <tr>
	   			<td colspan="4" bgcolor="black"></td>
	   		</tr>
     </table>
     
      <div class='popup' id='itemDtlId' style="display:none">
		<table width='400' border="0" cellspacing ="0px" cellpadding="0px">
			<tr class="HEADER"> 
				<th align='left'><div id="popUpItemId"></div></th>
				<th align='right'><img  style='cursor:pointer;cursor:pointer' src='../../hisglobal/images/popUp_cancel.JPG'
					onClick="closeItemPopUp('itemDtlId');" title="Click Here To Close Popup"></th>
		    </tr>
		 </table>  
	  
	  
		 <table width='400' border="0" cellspacing ="1px" cellpadding="1px">
			<tr>
				<td colspan="1" class='multiLabel'>Rate/Unit</td>
				<td colspan="1" class='multiControl'><div id ='1'></div></td>
						
			</tr>
			<tr>
				<td colspan="1" class='multiLabel'>Manufacturer Date</td>
				<td colspan="1" class='multiControl'><div id ='2'></div></td>	
			</tr>
			<tr>
				<td colspan="1" class='multiLabel'>Consumeable</td>
				<td colspan="1" class='multiControl'><div id ='3'></div></td>	
			</tr>
			<tr class="FOOTER">
				<td colspan="4"></td>
			</tr>
	        </table>
	    </div>
     
     <div class='popup' id='balQtyId' style="display:none">
		<table width='400' border="0" cellspacing ="0px" cellpadding="0px">
			<tr class="HEADER"> 
				<th align='left'><div id="popUpBalId"></div></th>
				<th align='right'><img  style='cursor:pointer;cursor:pointer' src='../../hisglobal/images/popUp_cancel.JPG'
					onClick="closeItemPopUp('balQtyId');" title="Click Here To Close Popup"></th>
		    </tr>
		 </table>  
	  
	  
		 <table width='400' border="0" cellspacing ="1px" cellpadding="1px">
			<tr>
				<td colspan="1" class='multiLabel'>Issued Qty</td>
				<td colspan="1" class='multiControl'><div id ='4'></div></td>
						
			</tr>
			<tr>
				<td colspan="1" class='multiLabel'>Returned Qty</td>
				<td colspan="1" class='multiControl'><div id ='5'></div></td>	
			</tr>
			<tr class="FOOTER">
				<td colspan="4"></td>
			</tr>
	        </table>
	    </div>
	
<!--		-->
	
<table class="TABLEWIDTH" align="center" cellpadding="1" cellspacing="1">
		<tr class="FOOTER">
			<td colspan="4"><font color="red">*</font> Mandatory Fields</td>
		</tr>
	</table>
	<table border="0" class="TABLEWIDTH" align="center" cellpadding="1"	cellspacing="1">
		<tr id="setSaveClearCancelButtonsId" style="display: none;">
			<td align="center">
			   <!-- <img style=" cursor: pointer" src="../../hisglobal/images/btn-sv.png" onclick="return validate1();" /> 
				<img style=" cursor: pointer" src="../../hisglobal/images/btn-clr.png" onClick="clearIssue();">
			    <img style=" cursor: pointer" src="../../hisglobal/images/btn-ccl.png" onClick="cancel();">
			     -->
			     <br>
			    <a href="#" class="button" id="" onclick=' return validate1();'><span class="save">Save</span></a>
				<a href="#" class="button"	onclick="clearIssue()"><span class="clear">Clear</span></a> 
				<a href="#" class="button" onclick="cancel();"><span class="cancel">Cancel</span></a>
			</td>

		</tr>
	</table>
	
		
							
					

	
	<table class="TABLEWIDTH" align="center">
		<tr id="removeCancelButtonId" >
			<td align="center">
			<img style="cursor: pointer; " title="Click to Return Main Menu" src="../../hisglobal/images/btn-ccl.png" onClick="cancel();" />
			</td>
		</tr>
	</table>

	<input type="hidden" name="hmode" />
	<input type="hidden" name="storeName" value="${duplicateIssueToPatientVoucherTransBean.storeName}" />
	<input type="hidden" name="itemCatName" value="${duplicateIssueToPatientVoucherTransBean.itemCatName}" />
	
	<input type="hidden" name="crNo" value="${duplicateIssueToPatientVoucherTransBean.crNo}" />
	<input type="hidden" name="strCrNo" value="${duplicateIssueToPatientVoucherTransBean.crNo}" />
	<input type="hidden" name="mode" value="${duplicateIssueToPatientVoucherTransBean.strMode}" />

	
	<input type="hidden" name="strId" value="${duplicateIssueToPatientVoucherTransBean.strId}" />
	<input type="hidden" name="strConfCatCode" value="${duplicateIssueToPatientVoucherTransBean.strConfCatCode}" />
	<input type="hidden" name="itemCategory" value="${duplicateIssueToPatientVoucherTransBean.itemCategory}" />
	<input type="hidden" name="strMode"   value="${duplicateIssueToPatientVoucherTransBean.strMode}">
	<input type="hidden" name="strIssueMode"   value="${duplicateIssueToPatientVoucherTransBean.strIssueMode}">
	<input type="hidden" name="strReturnDrugValidity"   value="${duplicateIssueToPatientVoucherTransBean.strReturnDrugValidity}">
	
	<input type="hidden" name="flagWithoutCrNo"   value="${duplicateIssueToPatientVoucherTransBean.flagWithoutCrNo}">
	
	
	
</html:form>
<tag:autoIndex></tag:autoIndex>
</body>
</html>

