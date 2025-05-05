<%@ page language="java" contentType="text/html;"	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<%@taglib uri="/WEB-INF/dateTag.tld" prefix="dateTag"%>
<%@ taglib uri="/WEB-INF/hisTab.tld" prefix="tag"%>
<%@ taglib uri="/WEB-INF/comboPersistence.tld" prefix="cmbPers"%>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic"%>

<html>
<head>
<meta charset=UTF-8">
<title>Third Party Issue</title>
<link href="../css/transaction.css" rel="stylesheet" type="text/css">
<link href="../../hisglobal/css/tab.css" rel="stylesheet" type="text/css">
<link href="../../hisglobal/css/calendar-tas.css" rel="stylesheet" type="text/css">
<link href="../../hisglobal/css/newpopup.css" rel="stylesheet" type="text/css">		
<link href="../../hisglobal/css/popup.css" rel="stylesheet" type="text/css">	
<link href="../../hisglobal/css/buttons.css" rel="stylesheet" type="text/css">
	
<script language="JavaScript" src="../../masterutil/js/master.js"></script>
<script language="JavaScript" src="../../hisglobal/js/tab.js"></script>
<script language="JavaScript" src="../../hisglobal/js/calendar.js"></script>
<script language="Javascript" src="../../hisglobal/js/validation.js"></script>
<script language="JavaScript" src="../../hisglobal/js/util.js"></script>
<script language="JavaScript" src="../../hisglobal/js/newpopup.js"></script>
<script language="Javascript" src="../../hisglobal/js/popup.js"></script>
<script language="JavaScript" src="../../hisglobal/js/multirow.js"></script>
<script language="JavaScript" src="../js/thirdPartyIssueReqTrans.js"></script>
<script language="JavaScript" src="../js/searchItems_util.js"></script>
<script language="JavaScript" src="../js/issueDetails_util.js"></script>
<script language="JavaScript" src="../js/mms.js"></script>

<script type="text/javascript">

</script>
</head>
<body onLoad="openIssueReport();">
<html:form name="thirdPartyIssueReqBean"
	action="/transactions/ThirdPartyIssueReqTransCNT"
	type="mms.transactions.controller.fb.ThirdPartyIssueReqTransFB">
	
<center>
	<div id="errMsg" class="errMsg" style="font-size:18px;"><bean:write name="thirdPartyIssueReqBean" property="strErrMsg" /></div>
	<div id="warningMsg" class="warningMsg" style="font-size:18px;"><bean:write name="thirdPartyIssueReqBean" property="strWarningMsg" /></div>
	<div id="normalMsg" class="normalMsg" style="font-size:18px;"><bean:write name="thirdPartyIssueReqBean" property="strNormalMsg" /></div>
	<tag:tab tabLabel="Third Party Issue" selectedTab="FIRST" align="center" width="TABLEWIDTH"> </tag:tab>
</center>

 <logic:equal value="1" name="thirdPartyIssueReqBean" property="strThirdPartyFlag">		

			<table class="TABLEWIDTH" align="center" cellpadding="1" cellspacing="1">   
			<tr class="HEADER">
					<td colspan="4"></td>
				</tr>
				<tr>
					<td width="25%" colspan="1" class="LABEL">
						Store Name
					</td>
					<td width="25%" colspan="1" class="CONTROL">
						<bean:write name="thirdPartyIssueReqBean" property="strStoreName" filter="false" />
					</td>
				
					<td width="25%" colspan="1" class="LABEL">Req Date &amp; Time</td>
					<td width="25%" colspan="1" class="CONTROL">
					  <font color="blue"><bean:write name="thirdPartyIssueReqBean" property="strCurrentDate" filter="false" /></font>
					</td>
				</tr>
		    </table>
     </logic:equal>
  <logic:equal value="2" name="thirdPartyIssueReqBean" property="strThirdPartyFlag">	
    <table class="TABLEWIDTH" align="center" cellpadding="1" cellspacing="1">   
	<tr class="HEADER">
			<td colspan="4"></td>
		</tr>
		<tr>
			<td width="25%" colspan="1" class="LABEL">
				Store Name
			</td>
			<td width="25%" colspan="1" class="CONTROL">
				<bean:write name="thirdPartyIssueReqBean" property="strStoreName" filter="false" />
			</td>
					
			 <td class="LABEL" width="25%"><font color="red">*</font>Req Date</td>
			 <td class="CONTROL" width="25%"> <dateTag:date name="strThirdPartyIssueDate" value="${thirdPartyIssueReqBean.strCurrentDate}"></dateTag:date> </td>
		</tr>
    </table>				
   </logic:equal>
    
	  <table class="TABLEWIDTH" align="center" cellpadding="1" cellspacing="1">    
		<tr>
			<td width="50%" colspan="2" class="LABEL"><font size="1" color="red">*</font>
			Third Party Name
			</td>
			<!--
			<td width="50%" colspan="2" class="CONTROL">
			<select name="strInstituteCode"  onchange="checkValCombo();">
			<bean:write name="thirdPartyIssueReqBean" property="strInstituteValues" filter="false"/>
			</select>
			 -->
			 <td width="50%" colspan="2" class="CONTROL">
					<select name="strInstituteCode">
					      <bean:write name="thirdPartyIssueReqBean" property="strInstituteValues" filter="false"/>
					</select>
			</td>
		</tr>
		
		
	<!-- 
		<tr>
             <td width ="25%%" class ="LABEL" valign="middle" ><font  color="red">*</font>Third Party Name</td>
             <td width ="25%" class ="CONTROL">
    
	            <select name="strInstituteCode"  onchange="checkValCombo();">
				     <bean:write name="thirdPartyIssueReqBean" property="strInstituteValues" filter="false"/>
				</select>
	               
            </td>
            <td class="CONTROL" width="25%" id='labelId'>
            	<div id='labelNameId'></div>
		    </td>
		    <td class="CONTROL" width="25%">
		            	<div id="nameOtherFld" style="display: none">
		            		<input type='text' name='strThirdPartyName' value='' onkeypress='return validateData(event,16);' maxlength='50'>
		            	</div>
		    </td>
          </tr>
           -->	
			
		
		<tr>
			<td width="50%" colspan="2" class="LABEL"><font size="1" color="red">*</font>
			Item Category
			</td>
			<td width="50%" colspan="2" class="CONTROL">
			<bean:write name="thirdPartyIssueReqBean" property="strItemCatValues" filter="false"/>
			</td>
			
		</tr>
		</table>
	<table class="TABLEWIDTH" align="center" cellpadding="1" cellspacing="1">   
		
		<tr class="TITLE">
			<td colspan="4"><div align="right"><img style="cursor: pointer;height: 20px" id='strSearchItemButtonDivId' src="../../hisglobal/images/ItemFinder.png"
 
										onclick='getItemSelectPopup();'>
			</div>
			</td>
			</tr>
			
			
		</table>
	  <logic:equal value="2" name="thirdPartyIssueReqBean" property="strThirdPartyFlag">		
		<table class="TABLEWIDTH" align="center" cellpadding="1px" cellspacing="1px" bgcolor="black">
			<tr>
			<td width="32%" class="multiRPTLabel">Item/Drug Name
			</td>
			<td width="16%" class="multiRPTLabel">Batch/Serial No.
			</td>
			<td width="10%" class="multiRPTLabel">Expiry Dt
			</td>
			<td width="10%" class="multiRPTLabel">Avl Qty
			</td>
			<td width="12%" class="multiRPTLabel"><font size="1" color="red">*</font>Issue Qty.
			</td>
			<td width="20%" class="multiRPTLabel"><font size="1" color="red">*</font>Unit Name
			</td>
			</tr>
			
			</table>
		</logic:equal> 
		
		<logic:equal value="1" name="thirdPartyIssueReqBean" property="strThirdPartyFlag">		
		<table class="TABLEWIDTH" align="center" cellpadding="1px" cellspacing="1px" bgcolor="black">
			<tr>
			<td width="32%" class="multiRPTLabel">Item/Drug Name
			</td>
			<td width="16%" class="multiRPTLabel">Batch/Serial No.
			</td>
			<td width="10%" class="multiRPTLabel">Expiry Dt
			</td>
			<td width="10%" class="multiRPTLabel">Avl Qty
			</td>
			<td width="12%" class="multiRPTLabel"><font size="1" color="red">*</font>Req. Qty
			</td>
			<td width="20%" class="multiRPTLabel"><font size="1" color="red">*</font>Unit Name
			</td>
			</tr>
			
			</table>
		</logic:equal>  	 	
			
			<div id="id1">
			</div>
			
		<logic:equal name="thirdPartyIssueReqBean" property="strThirdPartyFlag" value="2" >	
		  <table class="TABLEWIDTH" align="center" cellpadding="1px" cellspacing="1px">
			   <tr>
					<td colspan="2" width="50%" class="LABEL"><font size="2" color="red">*</font>Received By</td>
					<td colspan="2" width="50%" class="CONTROL">
			  		<input type="text" name="strReceiveBy" maxlength="100" class="txtFldMax">
    	 			</td>
			   </tr>
		  </table>
		</logic:equal>  
		
		 <table border="0" class="TABLEWIDTH" align="center">
		  <tr class="FOOTER">
			 <td colspan="4"></td>
		  </tr>
		 		 <tr>
					<td colspan="2" width="50%" class="LABEL"><font size="2" color="red">*</font>Remarks</td>
					<td colspan="2" width="50%" class="CONTROL">
			  		<textarea name="strRemarks" rows="2"></textarea>
    	 			</td>
			  </tr>
			
		<tr class="FOOTER">
			 <td colspan="4"><font size="2" color="red">*</font> Mandatory Fields  </td>
		</tr>
	</table>
	<!-- 
	<table border="0" class="TABLEWIDTH" align="center">
		<tr>

			<td align="center">
			<img style="cursor: pointer; "
				src="../../hisglobal/images/btn-sv.png" Title='Click here to save data' onClick="return validate1();" />
				<img style="cursor: pointer; " src="../../hisglobal/images/btn-clr.png" Title='Click here to clear content' onClick="clearDtl('requestPage');" >
			<img  style="cursor: pointer; " src="../../hisglobal/images/back_tab.png" Title='Click here to come back on desk' onClick="cancel1();" >
		</td>
		</tr>
	</table>-->
	<br>
    <div align="center" id=" ">					 
					 	<a href="#" class="button" id="submitId" onclick=' return validate1();'><span class="save">Save</span></a>
						<a href="#" class="button"	onclick="clearDtl('requestPage');"><span class="clear">Clear</span></a> 
						<a href="#" class="button" onclick="cancel1();"><span class="cancel">Cancel</span></a>
					</div> 
<input type="hidden" name="hmode"/>
<input type="hidden" name="mode"/>
<input type="hidden" name="strCurrentDate" value="${thirdPartyIssueReqBean.strCurrentDate}"/>
<input type="hidden" name="strItemCatNo" value="${thirdPartyIssueReqBean.strItemCatNo}"/>
<input type="hidden" name="strStoreId" value="${thirdPartyIssueReqBean.strStoreId}" />
<input type="hidden" name="strReqNo" value="${thirdPartyIssueReqBean.strReqNo}" />
<input type="hidden" name="strStoreTypeId" value="${thirdPartyIssueReqBean.strStoreTypeId}" />
<input type="hidden" name="comboValue" value="${thirdPartyIssueReqBean.comboValue}">
<input type="hidden" name="strReOrderFlgColor" value="${thirdPartyIssueReqBean.strReOrderFlgColor}"/>
<input type="hidden" name="strThirdPartyFlag" value="${thirdPartyIssueReqBean.strThirdPartyFlag}" >
<input type="hidden" name="strItemDtlWithIssueQty" id="strItemDtlWithIssueQty" value="0"/>

<cmbPers:cmbPers />
	<div id="blanket" style="display:none;"></div>
	<div class="popUpDiv" id="popUpDiv" style="display:none;">
	<table bgcolor="white">
		<tr>
		<td>
			<div id="searchItemsDtlsDivId" style="display:block;"></div>
			<div id="issueDtlsDivId" style="display:block;"></div>
		</td>
		</tr>
	</table>
	</div>


</html:form>
<jsp:include page="thirdPartyIssueReqSearchRow.jsp"></jsp:include>
<tag:autoIndex></tag:autoIndex>
</body>
</html>