<%@ page language="java" contentType="text/html;"	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic"%>
<%@taglib uri="/WEB-INF/dateTag.tld" prefix="dateTag"%>
<%@ taglib uri="/WEB-INF/hisTab.tld" prefix="tag"%>

 


<html>
<head>
<meta charset=UTF-8">
<title>Set/Sachet Details</title>
<link href="../css/master.css" rel="stylesheet" type="text/css">
<link href="../../hisglobal/css/tab.css" rel="stylesheet" type="text/css">
<link href="../../hisglobal/css/calendar-tas.css" rel="stylesheet" type="text/css">

<link href="../../hisglobal/css/popup.css" rel="stylesheet" type="text/css">	
	
<script language="JavaScript" src="../../hisglobal/masterutil/js/master.js"></script>
<script language="JavaScript" src="../../hisglobal/js/tab.js"></script>
<script language="JavaScript" src="../../hisglobal/js/calendar.js"></script>
<script language="Javascript" src="../../hisglobal/js/validation.js"></script>
<script language="Javascript" src="../../hisglobal/js/util.js"></script>
<script language="Javascript" src="../../mms/js/set_sachet_details.js"></script>
<script language="javaScript">

</script>

</head>
<body>
<html:form name="setSachetDetailsBean" action="transactions/SetSachetDetailsTransCNT"
	type="mms.transactions.controller.fb.SetSachetDetailsTransFB">
	
<center>
	<div id="errMsg" class="errMsg"><bean:write name="setSachetDetailsBean" property="strErr" /></div>
	<div id="warningMsg" class="warningMsg"><bean:write name="setSachetDetailsBean" property="strWarning"/></div>
	<div id="normalMsg" class="normalMsg"><bean:write name="setSachetDetailsBean" property="strMsg"/></div>
	

	
              <tag:tab tabLabel="Set/Sachet Details"
				selectedTab="FIRST" align="center" width="TABLEWIDTH">
              </tag:tab>
              </center>
	<table class="TABLEWIDTH" align="center" cellpadding="1px" cellspacing="1px">   
	<tr class="HEADER">
			<td colspan="4">Set/Sachet Details&gt;&gt;</td>
	</tr>
	
		<tr>
			<td class="LABEL" ><font color="red">*</font>Store Name</td>
			
      <td width="25%" class ="CONTROL"  align="center" > 
      <html:select name="setSachetDetailsBean" property="strStoreId" onchange="getCategoryCombo();" styleClass='comboNormal'>
       <bean:write name="setSachetDetailsBean" property="strStoreNameValues" filter="false"/>
       </html:select>
      </td>
      
      	<td class="LABEL" ><font color="red">*</font>Item Category </td>
			
      <td width="25%" class ="CONTROL"  align="center" > <div id="CategoryDivId">
       <select name ='strSetCategoryNo' class='comboNormal'>
      <bean:write name="setSachetDetailsBean" property="strCategoryValues" filter="false"/></select></div>
      </td>
		</tr>
		
		<tr >
			<td class="LABEL" width="25%"><font color="red">*</font>Group Name</td>
      <td  class ="CONTROL" width="25%"> <div id="groupDivId">
      <select name ='strGroupId' class='comboNormal'>
		 <bean:write name="setSachetDetailsBean" property="strGroupNameValues" filter="false"/>
      </select></div>
      
      </td>
       <td class="LABEL" width="25%" >Sub-Group Name</td>
      <td  class ="CONTROL" width="25%"> 
      <div id="subGroupDivId"><select name ='strSubGroupId' class='comboNormal'>
      <logic:empty name="setSachetDetailsBean" property="strSubGroupNameValues">
     <option value='0'>Select Value</option>
      </logic:empty>
      <bean:write name="setSachetDetailsBean" property="strSubGroupNameValues" filter="false"/>
      </select></div>
      </td>
		</tr>
	
		<tr>
			<td class="LABEL" colspan="1"><font color="red">*</font>Set/Sachet Name</td>
      <td  class ="CONTROL" colspan="1"> 
      <div id="SetSachetDivId"><select name ='strSetSachetId' class='comboNormal'>
      <logic:empty name="setSachetDetailsBean" property="strSetSachetNameValues">
     <option value='0'>Select Value</option>
      </logic:empty>
      <bean:write name="setSachetDetailsBean" property="strSetSachetNameValues" filter="false"/>
      </select></div>
      </td>
       <td class="LABEL" width="25%" colspan="1"><font color="red">*</font>Prepared Qty</td>
    <td width="25%" class ="CONTROL" colspan="1">
    <input type="text" class='txtFldNormal' name="strPreparedQty" value ="" maxlength="8" onkeypress="return validateData(event,7);"> Each </td>
  
		</tr>
		<tr>
   <td class="LABEL">
             <div id="expiryDateDivId">Expiry Date</div>
          <input type="hidden" name="isExpirtReq" value="0"></td>
   <td class="CONTROL" width="25%" colspan="1" ><dateTag:date name="strExpiryDate"
    value="${setSachetDetailsBean.strCtDate}"></dateTag:date></td>
        <td class="CONTROL" width="25%" colspan="2" >
    <img style="cursor:pointer;cursor:pointer" title="Item/Drug Details" align="top" 
    src ="../../hisglobal/images/Go.png" name="go" onclick="return goFunc();" onkeyup="return goFuncOnEnter();">
    
    
   </td></tr>
   </table>
   <div id="ItemDetailsDivId"></div> 
  
   
   <table class="TABLEWIDTH" align="center" cellpadding="0px" cellspacing="1px">
   	<tr >
    <td class="LABEL" width="50%" colspan="1" >Remarks</td>
    <td width="50%" class ="CONTROL" colspan="1" bgcolor="">
   <textarea name="strRemarks"cols="16" rows="2"></textarea> </td>
    
  </tr>
   </table>
  
  
	
	
	
	<div id="redbuttonDiv" style="display:none">
	<table class="TABLEWIDTH" align="center" cellpadding="1px" cellspacing="1px">		
		<tr class="TITLE">
			 <td colspan="4"> <input type="button" style="background-color:#E8506D;" disabled="disabled" />  Required Quantity is greater than Available Quantity  </td>
		</tr>
		</table>
		</div>
		<table class="TABLEWIDTH" align="center" cellpadding="1px" cellspacing="1px">	
		<tr class="FOOTER">
			 <td colspan="4"><font size="2" color="red">*</font> Mandatory Fields  </td>
		</tr>
	</table>
	<table class="TABLEWIDTH" align="center" cellpadding="1px" cellspacing="1px">
		<tr>

			<td align="center">
			<img style="cursor: pointer; "
				src="../../hisglobal/images/btn-sv.png" onClick="return validate1();" title="Click to Save Record"/>
				<img style="cursor: pointer; " src="../../hisglobal/images/btn-clr.png" onClick="return Clear();" title="Click to Clear Page" >
			<img  style="cursor: pointer; " src="../../hisglobal/images/btn-ccl.png" onClick="cancel();" title="Click to Return On Desk">
		</td>
		</tr>
	</table>
<input type="hidden" name="hmode"/>
<input type="hidden" name="isExpirtReq" />


</html:form>
<tag:autoIndex></tag:autoIndex>
</body>
</html>