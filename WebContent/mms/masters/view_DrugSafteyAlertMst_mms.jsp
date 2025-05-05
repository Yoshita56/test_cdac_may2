<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<%@taglib uri="/WEB-INF/dateTag.tld" prefix="dateTag"%>
<%@ taglib uri="/WEB-INF/hisTab.tld" prefix="tag"%>


<html>
<head>
<meta charset="utf-8">
<title>Insert Title Here</title>
<link href="../css/master.css" rel="stylesheet" type="text/css">
<link href="../../hisglobal/css/tab.css" rel="stylesheet" type="text/css">
<link href="../../hisglobal/css/calendar-tas.css" rel="stylesheet" type="text/css">

<link href="../../hisglobal/css/popup.css" rel="stylesheet" type="text/css">	
<link href="../../hisglobal/css/buttons.css" rel="stylesheet" type="text/css">	
<script language="JavaScript" src="../../masterutil/js/master.js"></script>
<script language="JavaScript" src="../../hisglobal/js/tab.js"></script>
<script language="JavaScript" src="../../hisglobal/js/calendar.js"></script>
<script language="Javascript" src="../../hisglobal/js/validation.js"></script>
<script language="Javascript" src="../../hisglobal/js/datepicker1.js"></script>
<script language="Javascript" src="../../hisglobal/js/multirow.js"></script>
<script language="Javascript" src="../../hisglobal/js/datepicker1.js"></script>
<script language="Javascript" src="../../hisglobal/js/util.js"></script>
<script language="JavaScript" src="../js/DrugSafteyAlertMst.js"></script>
<script language="JavaScript" src="../../hisglobal/js/tabIndex.js"></script>
</head>
<body onload="getNetAmt(),getSumOfAmount()";>

<html:form action="/masters/DrugSafetyAlertMstCNT.cnt"  name="drugSaftyAlertBean" type="mms.masters.controller.fb.DrugSafetyAlertMstFB" method="post">
<table class="TABLEWIDTH" align="center" cellpadding="1px" cellspacing="1px">
</table>
	<table class="TABLEWIDTH" align="center">   
	   <tr class="HEADER">
			<td colspan="2">Drug Saftey Alert &gt;&gt;View</td>
		</tr>
		<tr>
			<td width="50%" class="LABEL">
			<font color="red"></font>Group Name
			</td>
			<td width="50%" class="CONTROL">
	                   <bean:write name="drugSaftyAlertBean" property="strGroupName"/>
     	    </td>
		</tr>
		<tr>
			<td width="50%" class="LABEL">
			<font color="red"></font>Sub-GroupName
			</td>
			<td width="50%" class="CONTROL">
			 
			              <bean:write name="drugSaftyAlertBean" property="strSubGroupName"/>
                              
			</td>
		</tr>
		<tr>
			<td width="50%" class="LABEL">
			<font color="red"></font>Drug Name
			</td>
			<td width="50%" class="CONTROL">
			   
			      
                         <bean:write name="drugSaftyAlertBean" property="strDrugName"/>
                  
                
			</td>
			
		</tr>
		</table>
		
       <table class="TABLEWIDTH" align="center" cellpadding="1px" cellspacing="1px">
       <tr>
             <bean:write name="drugSaftyAlertBean" property="strItemDtlHlp" filter="false"/>
       </tr>
       </table>
		
		<table class="TABLEWIDTH" align="center"> 
		<tr> 
          <td width="50%" class="LABEL"> <font color="red">*</font>Effective From </td>
          <td class="CONTROL"> <bean:write name="drugSaftyAlertBean" property="strEffectiveFrom" filter="false"/>
             </td>
        </tr>
  
  <tr> 
    <td width="50%" class="LABEL"> Remarks</td>
    <td class="CONTROL">
    <bean:write name="drugSaftyAlertBean" property="strRemarks" filter="false"/>
     </td>
  </tr>
		
		
		<tr class="FOOTER">
			 <td colspan="2"><font size="2" color="red">*</font> Mandatory Fields  </td>
		</tr>
	</table>
	<table border="0" class="TABLEWIDTH" align="center" cellpadding="1px" cellspacing="1px">
		<tr>

			<td align="center">
			 
			<br>
          <!--   <img style="cursor: pointer; " src="../../hisglobal/images/btn-ccl.png" onClick="window.close();" /> -->
			<a href="#" class="button" onclick="window.close();"><span class="cancel">Cancel</span></a>
			</td>
		</tr>
	</table>
    <input type="hidden" name="hmode"/>
    <input type="hidden" name="chk" value="${drugSaftyAlertBean.strChk1}">
      
</html:form>
<tag:autoIndex></tag:autoIndex>
</body>
</html>