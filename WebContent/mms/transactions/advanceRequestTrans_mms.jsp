<%@page language="java" contentType="text/html" pageEncoding="UTF-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<%@taglib uri="/WEB-INF/dateTag.tld" prefix="dateTag"%>
<%@ taglib uri="/WEB-INF/hisTab.tld" prefix="tag"%>
<%@ taglib uri="/WEB-INF/comboPersistence.tld" prefix="cmbPers"%>


<html>
<head>
<meta charset=UTF-8">
<title>Advance Request</title>
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
<script type="text/javascript">

</script>
</head>
<body>


<html:form name="advanceRequestBean" action="/transactions/AdvanceRequestTransCNT"
	type="mms.transactions.controller.fb.AdvanceRequestTransFB">
		
	<div id="errMsg" class="errMsg"><bean:write name="advanceRequestBean" property="strErrMsg" /></div>
	<div id="warningMsg" class="warningMsg"><bean:write name="advanceRequestBean" property="strWarningMsg"/></div>
	<div id="normalMsg" class="normalMsg"><bean:write name="advanceRequestBean" property="strNormalMsg"/></div>

	<tag:tab tabLabel="Advance Request"
                        selectedTab="FIRST" align="center" width="TABLEWIDTH">
                  </tag:tab>

	<table class="TABLEWIDTH" align="center" cellpadding="1" cellspacing="1">   
	<tr class="HEADER">
			<td colspan="4"></td>
		</tr>
		<tr>
		<td class="LABEL" colspan="4" >
		<html:radio property="strChkAdvanceReq" value="1" onclick="disPlay();">New</html:radio>
		<html:radio property="strChkAdvanceReq" value="2" onclick="disPlay();">Duplicate</html:radio>
		</td>
	</tr>
		</table>
		
		
	<div id="newDivId" style="display:block">	
		<table class="TABLEWIDTH" align="center" cellpadding="1" cellspacing="1">  
	 <tr> 
    		<td width="25%" colspan="1" class="LABEL"><font color="red">*</font>Store Name</td>
    		<td width="25%" colspan="1" class="CONTROL">
    		<select name="strStoreId" class="comboNormal"  onchange="getPONOCombo(this);" >
        	<bean:write name="advanceRequestBean" property="strStoreValues" filter="false"/>
        	<option value="0">SelectValue</option>
        	</select> </td>
  		
			<td width="25%" colspan="1" class="LABEL"><font color="red">*</font>PO NO</td>
			<td width="25%" colspan="1" class="CONTROL">
			<div id="ponoDivId">
			<select name="strPONO" class="comboNormal" onchange="onSelPONO();" >
			<option value="0">SelectValue</option>
			</select> 
			</div>
			</td>
			
		</tr>
  		<tr>
    <td class="LABEL" width="25%" colspan="1">PO Date</td>
    <td width="25%" class ="CONTROL" colspan="1">
    	
     </td>
   
       
 
    <td class="LABEL" width="25%" colspan="1">Supplier Name</td>
    <td width="25%" class ="CONTROL" colspan="1">
<div id="supplierNameId"></div>
 </td>
    </tr>
    
    
    
  <tr>
			<td class="LABEL" width="50%" colspan="2">Item Category</td>
    <td width="50%" class ="CONTROL" colspan="2">
    <div id="itemCatNameId"></div> </td>
    
    
    
    
    </tr>
 <tr>
 
 <td class="LABEL" colspan="2" width="50%"> 
			Remarks
		</td>
		<td class="CONTROL" width="50%" colspan="2">
				<textarea rows="2" cols="20" name="strRemarks"></textarea>
			</td>
 
 </tr>
 </table>
 </div>
 
 <div id="duplicateDivId" style="display:none">
 <table class="TABLEWIDTH" align="center" cellpadding="1" cellspacing="1">
   	<tr>
		<td class="LABEL" width="50%" colspan="1"><font color="red">*</font>Req No</td>
	    <td width="50%" class ="CONTROL" colspan="1">
	   <input type="text" class='txtFldMax' name=strReqNo value ="" > </td>
	   </tr>
 </table>
 </div> 
 
		<table class="TABLEWIDTH" align="center" cellpadding="1" cellspacing="1">  		
		<tr class="FOOTER">
			 <td colspan="4"><font color="red">*</font> Mandatory Fields  </td>
		</tr>
	</table>
	<table border="0" class="TABLEWIDTH" align="center">
		<tr>

			<td align="center">
			<img style="cursor: pointer"
				src="../../hisglobal/images/btn-generate.png" title='Save Data'  onClick="return validate();" />
				<img style="cursor: pointer" src="../../hisglobal/images/btn-clr.png" title='Clear Content' onClick="document.forms[0].reset();" >
			<img style="cursor: pointer" src="../../hisglobal/images/btn-ccl.png" onClick="cancel();" title='Cancel Process'>
			</td>
			
		</tr>
	</table>
<input type="hidden" name="hmode"/>
<input type="hidden" name="strTreatCatName" value="All"/>  
<input type="hidden" name="strCurrentDate" value="${admissionRegRpt.strCurrentDate}"/>
</html:form>
<tag:autoIndex></tag:autoIndex>  
</body>
</html>