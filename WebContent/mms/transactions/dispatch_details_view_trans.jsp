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
<body onload="ViewHideandBlock();">
<html:form name="dispatchDetailsBean" action="/transactions/DispatchDetailsTransCNT"
	type="mms.transactions.controller.fb.DispatchDetailsTransFB">
	
<center>
	<div id="errMsg" class="errMsg"><bean:write name="dispatchDetailsBean" property="strErrMsg" /></div>
	<div id="warningMsg" class="warningMsg"><bean:write name="dispatchDetailsBean" property="strWarningMsg"/></div>
	<div id="normalMsg" class="normalMsg"><bean:write name="dispatchDetailsBean" property="strNormalMsg"/></div>
	
</center>
	
                	<tag:tab tabLabel="Dispatch Details" selectedTab="FIRST" align="center" width="TABLEWIDTH"></tag:tab>
               
	
	<table class="TABLEWIDTH" align="center" cellpadding="1px" cellspacing="1px">   
	<tr class="HEADER">
			<td colspan="3"></td>
			<td colspan="1" width="5%" align="right">
		<input type="checkbox" name="strDispatchViewRadio" value="1" onclick="diplayView();" checked="checked">
		
		View
		</td>
	</tr>
	
	
	
	
	
	
	 <tr> 
         <td width="25%" class="LABEL" colspan="2"><font color="red">*</font>Store Name</td>
         <td width="25%" class="CONTROL" colspan="1">
         
                 <div align="left" id="StoreNameId" style="display:block;" >
                  <select name="strStoreId" class="comboNormal"  >
                        <bean:write name="dispatchDetailsBean" property="strStoreNameCmbValues" filter="false"/>
                 </select>
                 </div>
                <div align="left" id="StoreNamedivId" style="display:none;" >
               			 <bean:write name="dispatchDetailsBean" property="strStoreName" filter="false"/>
                </div>
         </td>   
        
       
           <td  class="CONTROL" colspan="1" nowrap> 
            <div align="left" id="imageDivId" style="display:block" >
            <input type="image" style="cursor:pointer;cursor:pointer" title="Dispatch Details" align="top" src ="../../hisglobal/images/Go.png" name="go" value="Go" onclick="return goFuncView();" onkeyup="goFuncOnView(event);">
           </div>
	     </td>
	    
	</tr>
	</table>
		 
	  
	 
	 
	 
	<div id="DispatchDetailsDivId" style="display:none">
	
		
					       
				<bean:write name="dispatchDetailsBean" property="strDispatchDetails" filter="false"/>
			
	</div>	

	
<table class="TABLEWIDTH" align="center" cellpadding="1" cellspacing="1">
     <tr class="FOOTER">
			 <td colspan="4"><font size="2" color="red">*</font> Mandatory Fields  </td>
	</tr>
	
		<tr>

			<td colspan="4" align="center">
				<img style="cursor: pointer; " src="../../hisglobal/images/btn-clr.png" onClick="clearAdvance();" >
				<img  style="cursor: pointer; " src="../../hisglobal/images/btn-ccl.png" onClick="cancel();" >
			</td>
		</tr>
	</table>
<input type="hidden" name="hmode"/>
<input type="hidden" name="displayFlag" value="${dispatchDetailsBean.displayFlag}"/>

<input type="hidden" name="strStoreName" value="${dispatchDetailsBean.strStoreName}"/>
<input type="hidden" name="hideStoreId" value="${dispatchDetailsBean.hideStoreId}"/>

<input type="hidden" name="strDispatchNo" value="${dispatchDetailsBean.strDispatchNo}"/>
<input type="hidden" name="strDispatchDate" value="${dispatchDetailsBean.strDispatchDate}"/>
<input type="hidden" name="strInstFor" value="${dispatchDetailsBean.strInstFor}"/>
<input type="hidden" name="strPONoView" value="${dispatchDetailsBean.strPONoView}"/>
<input type="hidden" name="strSuppNameView" value="${dispatchDetailsBean.strSuppNameView}"/>
<input type="hidden" name="strInstAmtView" value="${dispatchDetailsBean.strInstAmtView}"/>

<cmbPers:cmbPers/>
</html:form>
<tag:autoIndex></tag:autoIndex>  
</body>
</html>