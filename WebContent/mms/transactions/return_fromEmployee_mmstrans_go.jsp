<%@ page language="java" contentType="text/html;"	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic"%>
<%@ taglib uri="/WEB-INF/hisTab.tld" prefix="tag"%>
<%@taglib uri="/WEB-INF/dateTag.tld" prefix="date"%>
<%@ taglib uri="/WEB-INF/dateTag.tld" prefix="dateTag"%>
<%@ taglib uri="/WEB-INF/comboPersistence.tld" prefix="cmbPers"%>
<%@ taglib uri="/WEB-INF/crNo.tld" prefix="crNo"%>

<!-- 
/**
 * Developer : Tanvi Sappal
 * Version : 1.0
 * Date : 17/June/2009
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

<script language="JavaScript" src="../../hisglobal/masterutil/js/master.js"></script>
<script language="JavaScript" src="../../hisglobal/js/tab.js"></script>
<script language="JavaScript" src="../../hisglobal/js/calendar.js"></script>
<script language="Javascript" src="../../hisglobal/js/validation.js"></script>
<script language="Javascript" src="../../hisglobal/js/util.js"></script>
<script language="Javascript" src="../../hisglobal/js/popup.js"></script>
<script language="Javascript" src="../js/advanceRequestTrans.js"></script>
<script language="Javascript" src="../js/returnFromEmployee_mmsTrans.js"></script>
<script language="Javascript" src="../js/mms.js"></script>
<script type="text/javascript">

</script>
</head>

<body>
<html:form action="/transactions/ReturnFromEmployeeTransCNT.cnt" name="returnFromEmployeeBean" type="mms.transactions.controller.fb.ReturnFromEmployeeTransFB" method="post">
	<div class="errMsg" id="errMsg"><bean:write name="returnFromEmployeeBean" property="strErr" /></div>
	<div class="warningMsg" id="warningMsg"><bean:write name="returnFromEmployeeBean" property="strWarning" /></div>
	<div class="normalMsg" id="normalMsg"><bean:write name="returnFromEmployeeBean" property="strMsg" /></div>


	
	<tag:tab tabLabel="Return From Employee" selectedTab="FIRST" align="center"
		width="TABLEWIDTH">
	</tag:tab>
	<table class="TABLEWIDTH" align="center" border="0" cellspacing ="1px">
	<tr class="HEADER"> 
	 <td colspan="4">Return From Employee&gt;&gt;
    </td>
    </tr>
    </table>
	
	
	

	
	<table class="TABLEWIDTH" align="center" cellpadding="1" cellspacing="1">
		<tr>
			<td width="25%" colspan="1" class="LABEL"><font color="red">*</font>Store Name</td>
			<td width="25%" colspan="1" class="CONTROL">
				<bean:write name="returnFromEmployeeBean" property="storeName" filter="false" />
			</td>

			<td width="25%" colspan="1" class="LABEL"><font color="red">*</font>Item Category</td>
			<td width="25%" colspan="1" class="CONTROL">
				<bean:write name="returnFromEmployeeBean" property="itemCatName" filter="false" />
			</td>			
		</tr>
		 <tr> 
		    <td width="25%" class="LABEL"><font color="red">*</font>Employee No.</td>
		    <td colspan="3" class="CONTROL">
		   <bean:write name="returnFromEmployeeBean" property="empNo" filter="false" /> </td>   
		  </tr>
	</table>


 <table class="TABLEWIDTH" align="center" border="0" cellspacing ="1px">
    <tr>  
     <td width="5%" class="TITLE" align="center"><input type='hidden'
				name='button1' value="0">
     <img src="../../hisglobal/images/plus.gif"   id="plus1"  style="display:block;cursor:pointer" onClick="ftn11();">
     <img src="../../hisglobal/images/minus.gif"  id="minus1" style="display:none;cursor:pointer" onClick="ftn11();"></td>
     
    <td colspan="3" class="TITLE" align="left"><b>Employee Detail</b></td>   
  </tr>
 </table>
 
 <div id = "EmployeeDivId" style="display:none;">
  <table class="TABLEWIDTH" align="center" cellspacing ="1px">
  <tr>
      <bean:write name="returnFromEmployeeBean" property="strEmployeeDtl" filter="false" />
  </tr>
 </table>
 </div>
 
 <table class="TABLEWIDTH" align="center" border="0" cellspacing="1px">
           <tr>
	   			<td colspan="4" bgcolor="black"></td>
	   		</tr>
		<tr>
			<td colspan="4" class="TITLE" align="left">Issue Details</td>
		</tr>
		<tr>
			<td colspan="2" class="LABEL"><font color="red">*</font>Issue No
			</td>
			<td colspan="2" class="CONTROL">
			<select name="strIssueNo" class='comboNormal' onchange="IssueDetails();">
				<bean:write name="returnFromEmployeeBean" property="strIssueNoCombo" filter="false" />
				</select>
			</td>
		</tr>
		</table>
	<div id="issueDivId" style="display: none;">
 <table class="TABLEWIDTH" align="center" border="0" cellspacing="1px">
		<tr>
			<td colspan="1" class="LABEL">Issue Date</td>
			<td class="CONTROL" colspan="1">
			<div id="issueDtDivId"></div>
			</td>
			<td colspan="1" class="LABEL">Dept/Unit Name</td>
			<td colspan="1" class="CONTROL">
			<div id="deptNameDivId"></div>
			</td>
		</tr>
		<tr>
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
			<td colspan="4" class="TITLE" align="left">Issue Drug/Item Details</td>
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
				<td colspan="1" class='multiLabel'>Expiry Date</td>
				<td colspan="1" class='multiControl'><div id ='6'></div></td>	
			</tr>
			<tr>
				<td colspan="1" class='multiLabel'>Consumable</td>
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
     
     <table class="TABLEWIDTH" align="center" cellpadding="1px" cellspacing="1px">
     <tr>
			<td colspan="1" class="LABEL"><font color="red">*</font>Recommended By
			</td>
			<td colspan="1" class="CONTROL">
			<select name="strRecommendedBy" class='comboNormal'>
				<bean:write name="returnFromEmployeeBean" property="strRecommendNameCombo" filter="false" />
				</select>
			</td>
			<td colspan="1" class="LABEL">
			<font color="red">*</font>Recommend Date
			</td>
			<td class ="CONTROL"><date:date name="strRecommendDate" value="${returnFromEmployeeBean.strCtDate}"></date:date></td>
		</tr>
		<tr>
			<td colspan="1" class="LABEL">
			Remarks
			</td>
			<td colspan="3" class="CONTROL">
			  <div align="left">
        		<textarea name="strRemarks" rows="2"></textarea>
              </div>
			</td>
		</tr>
     </table>
       
	

<table class="TABLEWIDTH" align="center" cellpadding="1" cellspacing="1">
		<tr class="FOOTER">
			<td colspan="4"><font color="red">*</font> Mandatory Fields</td>
		</tr>
	</table>
	<table border="0" class="TABLEWIDTH" align="center" cellpadding="1"
		cellspacing="1">
		<tr>
			<td align="center">
			    <img style=" cursor: pointer" src="../../hisglobal/images/btn-sv.png" onclick="return validate1();" /> 
				<img style=" cursor: pointer" src="../../hisglobal/images/btn-clr.png" onClick="clearIssue();">
			    <img style=" cursor: pointer" src="../../hisglobal/images/btn-ccl.png" onClick="cancel();">
			</td>

		</tr>
	</table>
	<input type="hidden" name="hmode" />
	<input type="hidden" name="storeName" value="${returnFromEmployeeBean.storeName}" />
	<input type="hidden" name="itemCatName" value="${returnFromEmployeeBean.itemCatName}" />
	<input type="hidden" name="empNo" value="${returnFromEmployeeBean.empNo}" />
	<input type="hidden" name="strEmpNo" value="${returnFromEmployeeBean.strEmpNo}" />
	<input type="hidden" name="strId" value="${returnFromEmployeeBean.strId}" />
	<input type="hidden" name="itemCategory" value="${returnFromEmployeeBean.itemCategory}" />
	<input type="hidden" name="strConfCatCode" value="${returnFromEmployeeBean.strConfCatCode}" />

</html:form>
<tag:autoIndex></tag:autoIndex>
</body>
</html>