<%@ page language="java" contentType="text/html;"	%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic"%>
<%@ taglib uri="/WEB-INF/hisTab.tld" prefix="tag"%>
<%@taglib uri="/WEB-INF/dateTag.tld" prefix="date"%>
<%@ taglib uri="/WEB-INF/dateTag.tld" prefix="dateTag"%>
<%@ taglib uri="/WEB-INF/comboPersistence.tld" prefix="cmbPers"%>
<%@ taglib uri="/WEB-INF/crNo.tld" prefix="crNo"%>


<html>
<head>
<meta charset=UTF-8">
<title>Return Process</title>
<link href="../css/transaction.css" rel="stylesheet" type="text/css">
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
<script language="Javascript" src="../js/advanceRequestTrans.js"></script>
<script language="Javascript" src="../js/returnFrom_mmsTrans.js"></script>
<script language="Javascript" src="../../hisglobal/js/validationCommon.js"></script>
<script language="Javascript" src="../js/mms.js"></script>
<script type="text/javascript">

</script>
</head>

<body onload="onCheckCategory();">
<html:form action="/transactions/ReturnFromTransCNT.cnt" name="returnFromTransBean" type="mms.transactions.controller.fb.ReturnFromTransFB" method="post">
	<div class="errMsg" id="errMsg"><bean:write name="returnFromTransBean" property="strErr" /></div>
	<div class="warningMsg" id="warningMsg"><bean:write name="returnFromTransBean" property="strWarning" /></div>
	<div class="normalMsg" id="normalMsg"><bean:write name="returnFromTransBean" property="strMsg" /></div>


	<tag:tab tabLabel="Return From Patient" selectedTab="FIRST" align="center"
		width="TABLEWIDTH">
	</tag:tab>
	<table class="TABLEWIDTH" align="center" border="0" cellspacing ="1px">
	<tr class="HEADER"> 
	 <td colspan="4">Return From Patient&gt;&gt;
    </td>
    </tr>
    </table>
	

	
	<table class="TABLEWIDTH" align="center" cellpadding="1" cellspacing="1">
		<tr>
			<td width="25%" colspan="1" class="LABEL"><font color="red">*</font>Store Name</td>
			<td width="25%" colspan="1" class="CONTROL">
				<bean:write name="returnFromTransBean" property="storeName" filter="false" />
			</td>

			<td width="25%" colspan="1" class="LABEL"><font color="red">*</font>Item Category</td>
			<td width="25%" colspan="1" class="CONTROL">
				<bean:write name="returnFromTransBean" property="itemCatName" filter="false" />
			</td>			
		</tr>
		 <tr> 
		    <td width="25%" class="LABEL"><font color="red">*</font>CR No.</td>
		    <td colspan="3" class="CONTROL">
		   <bean:write name="returnFromTransBean" property="crNo" filter="false" /> </td>   
		  </tr>
	</table>

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
      <bean:write name="returnFromTransBean" property="strPatientDetail" filter="false" />
  </tr>
 </table>
 </div>
 
 <table class="TABLEWIDTH" align="center" border="0" cellspacing="1px">
           <tr>
	   			<td colspan="4" bgcolor="black"></td>
	   		</tr>
		<tr>
			<td colspan="4" class="TITLE" align="left">Issue Detail(s)</td>
		</tr>
		<tr>
			<td colspan="3" class="LABEL"><font color="red">*</font>Issue No
			</td>
			<td colspan="1" class="CONTROL">
			<select name="strIssueNo" class='comboMax' onchange="IssueDetails();">
				<bean:write name="returnFromTransBean" property="strIssueNoCombo" filter="false" />
				</select>
			</td>
		</tr>
		</table>
	<div id="issueDivId" style="display: none;">
 <table class="TABLEWIDTH" align="center" border="0" cellspacing="1px">
		<tr>
			<td width="50%" class="LABEL">Issue Date</td>
			<td class="CONTROL" width="50%">
			<div id="issueDtDivId"></div>
			</td>
			<td width="50%" class="CONTROL"></td>
			<td width="50%" class="CONTROL">	
			
			</td>
		</tr>
	<%--	
	     <tr>
			<td class="LABEL" colspan="1">Department Name</td>
			<td class="CONTROL" colspan="3">
			        <div id="deptNameDivId"></div>
			
			</td>
		</tr>
		--%>

	</table>
	</div>
	<div id="id1" style="display: none;">
	<table class="TABLEWIDTH" align="center" border="0" cellspacing="1px">
		<tr>
			<td colspan="4" class="TITLE" align="left">Issue Item/Drug Detail(s)</td>
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
     
     <table class="TABLEWIDTH" align="center" cellpadding="1px" cellspacing="1px">
     <tr>
			<td colspan="1" class="LABEL">Recommended By</td>
			<td colspan="1" class="CONTROL">
			<select name="strRecommendedBy" class='comboNormal'>
				<bean:write name="returnFromTransBean" property="strRecommendNameCombo" filter="false" />
				</select>
			</td>
			<td colspan="1" class="LABEL">Recommend Date</td>
			<td class ="CONTROL"><date:date name="strRecommendDate" value="${returnFromTransBean.strCtDate}"></date:date></td>
		</tr>
		<tr>
			<td colspan="2" class="LABEL">
			Remarks
			</td>
			<td colspan="2" class="CONTROL">
			  <div align="left">
        		<textarea name="strRemarks" rows="2"></textarea>
              </div>
			</td>
		</tr>
     </table>
       </div>
	

<table class="TABLEWIDTH" align="center" cellpadding="1" cellspacing="1">
		<tr class="FOOTER">
			<td colspan="4"><font color="red">*</font> Mandatory Fields</td>
		</tr>
	</table>
	
	
	<!-- <table border="0" class="TABLEWIDTH" align="center" cellpadding="1"
		cellspacing="1">
		<tr id="saveId">
			<td align="center">
			    <img style=" cursor: pointer" src="../../hisglobal/images/btn-sv.png" onclick="return validate1();" /> 
				<img style=" cursor: pointer" src="../../hisglobal/images/btn-clr.png" onClick="clearIssue();">
			    <img style=" cursor: pointer" src="../../hisglobal/images/btn-ccl.png" onClick="cancel();">
			</td>

		</tr>
	</table> -->
	<br>
		<div align="center" id="saveId">					 
							<a href="#" class="button" id="" onclick=' return validate1();'><span class="save">Save</span></a>
							<a href="#" class="button"	onclick="clearIssue()"><span class="clear">Clear</span></a> 
							<a href="#" class="button" onclick="cancel();"><span class="cancel">Cancel</span></a>
					</div>
	<input type="hidden" name="hmode" />
	<input type="hidden" name="storeName" value="${returnFromTransBean.storeName}" />
	<input type="hidden" name="itemCatName" value="${returnFromTransBean.itemCatName}" />
	<input type="hidden" name="crNo" value="${returnFromTransBean.crNo}" />
	<input type="hidden" name="strCrNo" value="${returnFromTransBean.crNo}" />
	<input type="hidden" name="strId" value="${returnFromTransBean.strId}" />
	<input type="hidden" name="itemCategory" value="${returnFromTransBean.itemCategory}" />
	<input type="hidden" name="strConfCatCode" value="${returnFromTransBean.strConfCatCode}" />
	<input type="hidden" name="mode" value="${returnFromTransBean.strMode}" />
	<input type="hidden" name="strMode"   value="${returnFromTransBean.strMode}">
	<input type="hidden" name="strIssueMode"   value="${returnFromTransBean.strIssueMode}">
	<input type="hidden" name="strReturnDrugValidity"   value="${returnFromTransBean.strReturnDrugValidity}">
	
	

</html:form>
<tag:autoIndex></tag:autoIndex>
</body>
</html>