<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<%@taglib uri="/WEB-INF/dateTag.tld" prefix="date"%>
<%@ taglib uri="/WEB-INF/hisTab.tld" prefix="tag"%>

<!--  
 * Developer : Tanvi Sappal
 * Version : 1.0 
 * Date : 15/April/2009
 *  Module:MMS
 * Unit:Inspection View   
 -->
 


<html>
<head>
<meta charset=UTF-8">
<title>Inspection View Details</title>
<link href="../css/master.css" rel="stylesheet" type="text/css">
<link href="../../hisglobal/css/tab.css" rel="stylesheet" type="text/css">
<link href="../../hisglobal/css/calendar-tas.css" rel="stylesheet" type="text/css">

<link href="../../hisglobal/css/popup.css" rel="stylesheet" type="text/css">	
	
<script language="JavaScript" src="../../hisglobal/masterutil/js/master.js"></script>
<script language="JavaScript" src="../../hisglobal/js/tab.js"></script>
<script language="JavaScript" src="../../hisglobal/js/calendar.js"></script>
<script language="Javascript" src="../../hisglobal/js/validation.js"></script>
<script language="Javascript" src="../../hisglobal/js/util.js"></script>
<script language="Javascript" src="../js/inspection_view_mmstrans.js"></script>
<script language="Javascript" src="../../hisglobal/js/util.js"></script>
<script language="Javascript" src="../../hisglobal/js/popup.js"></script>
<script language="Javascript" src="../../hisglobal/js/newpopup.js"></script>


</head>
<body>
<html:form name="inspectionViewBean" action="transactions/InspectionViewTransCNT"
	type="mms.transactions.controller.fb.InspectionViewTransFB">
	
<center>
	<div id="errMsg" class="errMsg"><bean:write name="inspectionViewBean" property="strErrMsg" /></div>
	<div id="warningMsg" class="warningMsg"><bean:write name="inspectionViewBean" property="strWarningMsg"/></div>
	<div id="normalMsg" class="normalMsg"><bean:write name="inspectionViewBean" property="strNormalMsg"/></div>
	

			<tag:tab tabLabel="Inspection View"
				selectedTab="FIRST" align="center" width="TABLEWIDTH">
              </tag:tab>
</center>

<table class="TABLEWIDTH" align="center" cellpadding="1px" cellspacing="1px">   
	<tr class="HEADER">
			<td colspan="4"></td>
	</tr>
	
</table>



<table class="TABLEWIDTH" align="center" cellpadding="1px" cellspacing="1px">

<tr>
	
    <td class="LABEL" width="25%">Request No</td>
    <td width="25%" class ="CONTROL">
    <bean:write name="inspectionViewBean" property="strRequestNo" filter="false" /></td>
    
    <td class="LABEL" width="25%">Request Date</td>
    <td width="25%" class ="CONTROL">
    <bean:write name="inspectionViewBean" property="strRequestDate" filter="false" />
     </td>      
  </tr>
	<tr>
	
    <td class="LABEL" width="25%">PO No</td>
    <td width="25%" class ="CONTROL">
    <bean:write name="inspectionViewBean" property="strPONo" filter="false" /></td>
    
    <td class="LABEL" width="25%">PO Date</td>
    <td width="25%" class ="CONTROL">
    <bean:write name="inspectionViewBean" property="strPODate" filter="false" />
     </td>      
  </tr>
  
  <tr>
   <td class="LABEL" width="25%">Supplier Name</td>
    <td width="25%" class ="CONTROL">
    <bean:write name="inspectionViewBean" property="strSupplierName" filter="false" />
     </td>
    <td class="LABEL" width="25%">Drug Category</td>
    <td width="25%" class ="CONTROL">
    <bean:write name="inspectionViewBean" property="strItemCategory" filter="false" />
     </td>
  </tr>
  
  <tr>
  		<td class="LABEL" width="25%">Committee Name</td>
    	<td width="25%" class ="CONTROL" colspan="3">
    	<bean:write name="inspectionViewBean" property="strCommitteeName" filter="false" />
    	 </td>
 	</tr> 
</table>



<table class="TABLEWIDTH" align="center" cellpadding="1px" cellspacing="1px">   
	<tr><td class="TITLE" colspan="4">Drug Details</td></tr>
	
</table>

             <bean:write name="inspectionViewBean" property="strItemDetails" filter="false"/>
             


	 
		 <table border="0" class="TABLEWIDTH" align="center" cellpadding="1px"
         cellspacing="1px">
        
		<tr class="FOOTER">
			 <td colspan="4"><font size="2" color="red">*</font> Mandatory Fields  </td>
		</tr>
	
	
		<tr>
			<td colspan="4" align="center">
            <img style="cursor: pointer; " title="Cancel Process" src="../../hisglobal/images/btn-ccl.png" onClick="cancel();" /></td>
		</tr>
	</table>
<input type="hidden" name="hmode"/>
<input type="hidden" name="strPath" value="${inspectionViewBean.strPath}"/>

</html:form>	
<div class="popup" id="popup" style="display: none"></div>
	<tag:autoIndex></tag:autoIndex>   
</body>
</html>

