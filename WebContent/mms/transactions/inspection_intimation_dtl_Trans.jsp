<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<%@taglib uri="/WEB-INF/dateTag.tld" prefix="date"%>
<%@ taglib uri="/WEB-INF/hisTab.tld" prefix="tag"%>

<!--  
 * Developer : Anshul Jindal
 * Version : 1.0 
 * Date : 10/April/2009
 *  Module:MMS
 * Unit:Bill Approval   
 -->
 


<html>
<head>
<meta charset=UTF-8">
<title>Inspection Intimation</title>
<link href="../css/master.css" rel="stylesheet" type="text/css">
<link href="../../hisglobal/css/tab.css" rel="stylesheet" type="text/css">
<link href="../../hisglobal/css/calendar-tas.css" rel="stylesheet" type="text/css">

<link href="../../hisglobal/css/popup.css" rel="stylesheet" type="text/css">	
	
<script language="JavaScript" src="../../hisglobal/masterutil/js/master.js"></script>
<script language="JavaScript" src="../../hisglobal/js/tab.js"></script>
<script language="JavaScript" src="../../hisglobal/js/calendar.js"></script>
<script language="Javascript" src="../../hisglobal/js/validation.js"></script>
<script language="Javascript" src="../../hisglobal/js/util.js"></script>
<script language="Javascript" src="../js/inspection_intimation_trans.js"></script>


</head>
<body>
<html:form name="inspectionIntimationBean" action="transactions/InspectionIntimationTransCNT"
	type="mms.transactions.controller.fb.InspectionIntimationTransFB">
	
<center>
	<div id="errMsg" class="errMsg"><bean:write name="inspectionIntimationBean" property="strErrMsg" /></div>
	<div id="warningMsg" class="warningMsg"><bean:write name="inspectionIntimationBean" property="strWarningMsg"/></div>
	<div id="normalMsg" class="normalMsg"><bean:write name="inspectionIntimationBean" property="strNormalMsg"/></div>
	

			<tag:tab tabLabel="Inspection Intimation"
				selectedTab="FIRST" align="center" width="TABLEWIDTH">
              </tag:tab>
</center>

<table class="TABLEWIDTH" align="center" cellpadding="1px" cellspacing="1px">   
	<tr class="HEADER">
			<td colspan="6">Inspection Intimation &gt;&gt;</td>
	</tr>
	<tr>
		<td class="LABEL" width="" colspan="2">Store Name</td>
    	<td width="" class ="CONTROL" colspan="2">
    	<bean:write name="inspectionIntimationBean" property="strStoreName" filter="false" /></td>
		
  	</tr>
  	
  	<tr>
  		<td class="LABEL" width="25%"><font color="red">*</font>Order No.</td>
    	<td width="25%" class ="CONTROL">
    	<select name="strOrderNo" class="comboNormal" onchange="OrderDetails(this);">
					<bean:write name="inspectionIntimationBean" property="strOrderNoCmb" filter="false"/>
					</select>
			</td>
			
  		<td class="LABEL" width="25%" >Order Date</td>
    	<td width="25%" class ="CONTROL" >
    		<div id="orderDateDivId"> </div>
		</td>	
  	</tr>
  	<tr>
		<td class="LABEL" width="25%">Tender No.</td>
    	<td width="25%" class ="CONTROL">
    		<bean:write name="inspectionIntimationBean" property="strTenderNo" filter="false"/>
		</td>
			
			<td class="LABEL" width="25%">Quotation No.</td>
    	<td width="25%" class ="CONTROL">
    		<bean:write name="inspectionIntimationBean" property="strQuotationNo" filter="false"/>
		</td>		
  	</tr>
  	
  	<tr>
		<td class="LABEL" width="25%">Supplier Name</td>
    	<td width="25%" class ="CONTROL">
    			<div id="supplierNameDivId"> </div>
		</td>
			
			<td class="LABEL" width="25%">Item Category</td>
    	<td width="25%" class ="CONTROL">
    		<div id="itemCatDivId"> </div>
		</td>		
  	</tr>
  	
</table>

<div id="orderDetailsDivId"></div>
<div id="receiptDivId"></div>

<table class="TABLEWIDTH" align="center" cellpadding="1px" cellspacing="1px"> 

	<tr>
  		<td class="LABEL" ><font color="red">*</font>Committee Name</td>
    	<td  class ="CONTROL">
    	<select name="strCommittee" class="comboNormal" onchange="">
					<bean:write name="inspectionIntimationBean" property="strCommitteeCmb" filter="false"/>
					</select>
			</td>
		
  	</tr>
  	<tr>
  	
    <td width ="50%" class ="LABEL"valign="top">Remarks if Any </td>
    <td width ="50%" class ="CONTROL"><textarea  name="strRemarks" cols="25" rows="2" ></textarea></td>
  	</tr>
</table>
		 <table border="0" class="TABLEWIDTH" align="center" cellpadding="1px"
         cellspacing="1px">
        
		<tr class="FOOTER">
			 <td colspan="4"><font size="2" color="red">*</font> Mandatory Fields  </td>
		</tr>
	
	
		<tr>
			<td colspan="4" align="center">
			<img style="cursor: pointer; " title="Save Record" src="../../hisglobal/images/btn-sv.png" onClick=" return saveIntimation();" /> 
			<img style="cursor: pointer; " title="Clear Content"  src="../../hisglobal/images/btn-clr.png" onClick="document.forms[0].reset();" />
            <img style="cursor: pointer; " title="Cancel Process" src="../../hisglobal/images/btn-ccl.png" onClick="cancel();" /></td>
		</tr>
	</table>
<input type="hidden" name="hmode"/>
<input type="hidden" name="strPath" value="${inspectionIntimationBean.strPath}"/> 
<input type="hidden" name="strComboValue" value="${inspectionIntimationBean.strComboValue}"/>

</html:form>	
	<tag:autoIndex></tag:autoIndex>   
</body>
</html>

