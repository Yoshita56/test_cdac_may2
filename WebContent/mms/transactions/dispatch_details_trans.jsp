<%@page language="java" contentType="text/html" pageEncoding="UTF-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<%@taglib uri="/WEB-INF/dateTag.tld" prefix="dateTag"%>
<%@ taglib uri="/WEB-INF/hisTab.tld" prefix="tag"%>
<%@ taglib uri="/WEB-INF/comboPersistence.tld" prefix="cmbPers"%>
<!--  
 * Developer : Pramod Kumar Mehta 
 * Version : 1.0 
 * Date : 09/April/2009
 *  Module:MMS
 * Process:Dispatch Details   
 -->
 
 
 
<html>
<head>
<meta charset=UTF-8">
<title>Dispatch Details</title>
<link href="../css/master.css" rel="stylesheet" type="text/css">
<link href="../../hisglobal/css/tab.css" rel="stylesheet" type="text/css">
<link href="../../hisglobal/css/calendar-tas.css" rel="stylesheet" type="text/css">

<link href="../../hisglobal/css/popup.css" rel="stylesheet" type="text/css">	
	
<script language="JavaScript" src="../../hisglobal/masterutil/js/master.js"></script>
<script language="JavaScript" src="../../hisglobal/js/tab.js"></script>
<script language="JavaScript" src="../../hisglobal/js/calendar.js"></script>
<script language="Javascript" src="../../hisglobal/js/validation.js"></script>
<script language="Javascript" src="../../hisglobal/js/util.js"></script>
<script language="Javascript" src="../js/dispatch_details_trans.js"></script>


</head>
<body >
<html:form name="dispatchDetailsBean" action="/transactions/DispatchDetailsTransCNT"
	type="mms.transactions.controller.fb.DispatchDetailsTransFB">
	
<center>
	<div id="errMsg" class="errMsg"><bean:write name="dispatchDetailsBean" property="strErrMsg" /></div>
	<div id="warningMsg" class="warningMsg"><bean:write name="dispatchDetailsBean" property="strWarningMsg"/></div>
	<div id="normalMsg" class="normalMsg"><bean:write name="dispatchDetailsBean" property="strNormalMsg"/></div>
	

	
                	<tag:tab tabLabel="Dispatch Details" selectedTab="FIRST" align="center" width="TABLEWIDTH"></tag:tab>
               
	</center>
	<table class="TABLEWIDTH" align="center" cellpadding="1px" cellspacing="1px">   
	<tr class="HEADER">
			<td colspan="4"></td>
	</tr>
	
	
	<tr>
		<td class="LABEL" colspan="4" >
		<html:radio property="strAdvanceBillRadio" value="1"  onclick="disPlay();">Advance</html:radio>
		<html:radio property="strAdvanceBillRadio" value="2" onclick="disPlay();">Bill</html:radio>
		</td>
	</tr>
    <tr>
		<td class="LABEL" width="50%" colspan="2"><font color="red">*</font>PO No</td>
		<td width="50%" class ="CONTROL" colspan="2" align="center" > 
	      <html:select name="dispatchDetailsBean" property="strPONO" onchange="return getPONODetails();">
	       <bean:write name="dispatchDetailsBean" property="strPONONameValues" filter="false"/>
	       </html:select>
	     </td>
	</tr>
	</table>
	<div id="PONODetailsDivId" style="display:block">
		<table class="TABLEWIDTH" align="center" cellpadding="1px" cellspacing="1px">  
		<tr>	
	      <td class="LABEL" width="25%" colspan="1">PO Date</td>
	      <td width="25%" class="CONTROL" colspan="1">
	        <bean:write name="dispatchDetailsBean" property="strPODate" filter="false" /> </td>
	      <td class="LABEL" width="25%" colspan="1">Supplier Name</td>
	      <td width="25%" class="CONTROL" colspan="1">
	       <bean:write name="dispatchDetailsBean" property="strSupplierName" filter="false" /> 
	      </td>
        </tr>
 
        <tr>	
	      <td class="LABEL" width="50%" colspan="2">
	           <div id="ReqNo1" style="display:block"> Req NO</div>
	           <div id="BillNo1" style="display:none"> Bill NO</div>
	      </td>
	        <td width="50%" class="CONTROL" colspan="2">
	        <div id="BillNo2" style="display:none">
	            <html:select name="dispatchDetailsBean" property="strBillNo">
	                  <bean:write name="dispatchDetailsBean" property="strBillNoValues" filter="false"/>
	            </html:select>
	         </div>
	         <div id="ReqNo2" style="display:block"> 
	             <bean:write name="dispatchDetailsBean" property="strReqNoValues" filter="false" /> 
	         </div>
	       </td>
	      
	      
        </tr>
	 
	   
	
	</table>
	
	</div>
	
	<table class="TABLEWIDTH" align="center" cellpadding="1px" cellspacing="1px">
	<tr>
  		<td class="LABEL" width="50%" colspan="3">Instrument Received Date</td>
	   <td class="CONTROL" width="50%" ><dateTag:date name="strInstrReceivedDate" value="${dispatchDetailsBean.strCtDate}"></dateTag:date></td>
	</tr>
	<tr>
		<td class="LABEL" width="25%" colspan="1"><font color="red">*</font>Instrument No</td>
	    <td width="25%" class ="CONTROL" colspan="1">
	   <input type="text" class='txtFldMax' name=strInstrNo value ="" > </td>
	     <td class="LABEL" width="25%" colspan="1">Instrument Date</td>
	    <td width="25%" class ="CONTROL" colspan="1">
	    <dateTag:date name="strInstrDate" value="${dispatchDetailsBean.strCtDate}"></dateTag:date></td>
	    
	</tr>
	<tr>
		<td class="LABEL" width="25%" colspan="1"><font color="red">*</font>Drawee Bank</td>
	    <td width="25%" class ="CONTROL" colspan="1">
	   <input type="text" class='txtFldMax' name=strDraweeBank value ="" > </td>
	   
	   	<td class="LABEL" width="25%" colspan="1">Instrument Validity</td>
		<td width="25%" class ="CONTROL" colspan="1" align="center" > 
	       <dateTag:date name="strInstrValidity" value="${dispatchDetailsBean.strCtDate}"></dateTag:date>
	    </td>
	 </tr>
	 <tr>
	     <td class="LABEL" width="25%" colspan="1"><font color="red">*</font>Instrument Amount</td>
	    <td width="25%" class ="CONTROL" colspan="1">
	   <input type="text" class='txtFldMax' name=strInstrAmt value ="" maxlength="14"> </td>
	   
	   <td class="LABEL" width="25%" colspan="1"><font color="red">*</font>Instrument Type</td>
		<td width="25%" class ="CONTROL" colspan="1" align="center" > 
	      <html:select name="dispatchDetailsBean" property="strInstrType">
	      <html:option value="0">Select Value</html:option>
	      <html:option value="1">Cheque</html:option>
	      <html:option value="2">DD</html:option>
       </html:select>
	      </td>
	    </tr>
	    <tr>
	     <td class="LABEL" width="25%" colspan="1"><font color="red">*</font>Dispatch Mode</td>
		<td width="25%" class ="CONTROL" colspan="1" align="center" > 
	      	<html:select name="dispatchDetailsBean" property="strDispatchMode">
	       		<bean:write name="dispatchDetailsBean" property="strDispatchModeNameValues" filter="false"/>
	      	 </html:select>
	      </td>
	    
	    <td class="LABEL" width="25%" colspan="1">Remarks</td>
	    <td width="25%" class ="CONTROL" colspan="1">
	   		<textarea name="strRemarks"cols="16" rows="2"></textarea> 
	   	</td>
     </tr>
	  
     <tr class="FOOTER">
			 <td colspan="4"><font size="2" color="red">*</font> Mandatory Fields  </td>
	</tr>
	</table>
	 
	<table class="TABLEWIDTH" align="center" cellpadding="1" cellspacing="1">
		<tr>

			<td align="center">
			<img style="cursor: pointer; "
				src="../../hisglobal/images/btn-sv.png" onClick="return validate1();" title="Click to Save Record" />
				<img style="cursor: pointer; " src="../../hisglobal/images/btn-clr.png" onClick="Clear();" title="Click to Clear Page" >
			<img  style="cursor: pointer; " src="../../hisglobal/images/btn-ccl.png" title="Click to Return On Desk" onClick="cancel();" >
		</td>
		</tr>
	</table>
<input type="hidden" name="hmode"/>
<cmbPers:cmbPers/>
</html:form>
<tag:autoIndex></tag:autoIndex>  
</body>
</html>