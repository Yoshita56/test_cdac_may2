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
<link href="../../hisglobal/css/buttons.css" rel="stylesheet" type="text/css">
<link href="../../hisglobal/css/popup.css" rel="stylesheet" type="text/css">	
	
<script language="JavaScript" src="../../masterutil/js/master.js"></script>
<script language="JavaScript" src="../../hisglobal/js/tab.js"></script>
<script language="JavaScript" src="../../hisglobal/js/calendar.js"></script>
<script language="Javascript" src="../../hisglobal/js/validation.js"></script>
<script language="Javascript" src="../../hisglobal/js/datepicker1.js"></script>

<script language="JavaScript" src="../../masterutil/js/master.js"></script>
<script language="JavaScript" src="../../hisglobal/js/tab.js"></script>

<script language="Javascript" src="../../hisglobal/js/multirow.js"></script>
<script language="Javascript" src="../../hisglobal/js/datepicker1.js"></script>
<script language="Javascript" src="../../hisglobal/js/validation.js"></script>
<script language="Javascript" src="../../hisglobal/js/util.js"></script>
<script language="JavaScript" src="../js/DrugDoseIndicationMst.js"></script>

</head>
<body onload="getNetAmt(),getSumOfAmount()";>


<html:form action="/masters/DrugDosageIndicationMstCNT.cnt"  name="drugDosageIndicationBean" type="mms.masters.controller.fb.DrugDosageIndicationMstFB" method="post">
<center>
 	<div class="errMsg" id="errMsg"><bean:write name="drugDosageIndicationBean" property="strErr"/></div>
	<div class="warningMsg" id="warningMsg"><bean:write name="drugDosageIndicationBean" property="strWarning"/></div>
	<div class="normalMsg"  id="normalMsg"><bean:write name="drugDosageIndicationBean" property="strMsg"/></div>
 

<tag:tab tabLabel="Drug Dose Indication" selectedTab="FIRST" align="center" width="TABLEWIDTH">
	</tag:tab></center>
	<table class="TABLEWIDTH" align="center">   
	   <tr class="HEADER">
			<td colspan="2">Drug Dose/Indication &gt;&gt;Modify</td>
		</tr>
		<tr>
			<td width="50%" class="LABEL">
			<font color="red"></font>Group Name
			</td>
			<td width="50%" class="CONTROL">
	                   <bean:write name="drugDosageIndicationBean" property="strGroupName"/>
     	    </td>
		</tr>
		<tr>
			<td width="50%" class="LABEL">
			<font color="red"></font>Sub-GroupName
			</td>
			<td width="50%" class="CONTROL">
			 
			     
			           <bean:write name="drugDosageIndicationBean" property="strSubGroupName"/>
                  
                
			</td>
		</tr>
		<tr>
			<td width="50%" class="LABEL">
			<font color="red"></font>Generic Drug Name
			</td>
			<td width="50%" class="CONTROL">
			   
			      
                         <bean:write name="drugDosageIndicationBean" property="strDrugName"/>
                  
                
			</td>
			
		</tr>
		</table>
		
       <table class="TABLEWIDTH" align="center" cellspacing ="1px" cellpadding="1px">
       <tr>
             <bean:write name="drugDosageIndicationBean" property="strItemDtlHlp" filter="false"/>
       </tr>
      </table>
      <table class="TABLEWIDTH" align="center" cellspacing ="1px" cellpadding="1px">
		<tr> 
          <td width="50%" class="LABEL"><font color="red">*</font>Effective From </td>
          <td class="CONTROL"><bean:write name="drugDosageIndicationBean" property="strEffectiveFrom"/>
          </td>
        </tr>
  
  <tr> 
    <td width="50%" class="LABEL"> Remarks</td>
    <td class="CONTROL">
    <textarea name="strRemarks" cols="20" rows="2"id="strRemarks"><bean:write name="drugDosageIndicationBean" property="strRemarks" filter="false"/></textarea> </td>
  </tr>
		
		
		<tr class="FOOTER">
			 <td colspan="2"><font size="2" color="red">*</font> Mandatory Fields  </td>
		</tr>
	</table>
	<table border="0" class="TABLEWIDTH" align="center" cellspacing ="1px" cellpadding="1px">
		<tr>

			<td align="center">
			<!-- <img style="cursor: pointer; " title="Save Record" src="../../hisglobal/images/btn-sv.png" onClick=" return validateUpdate();" /> 
			
            <img style="cursor: pointer; " title="Cancel Process" src="../../hisglobal/images/btn-ccl.png" onClick="cancel('LIST');" /> -->
			<br>
				<a href="#" class="button" id="" onclick=' return validate1();'><span class="save">Save</span></a>
				<a href="#" class="button" onclick="cancel('LIST');"><span class="cancel">Cancel</span></a>
			</td>
		</tr>
	</table>
    <input type="hidden" name="hmode"/>
    <input type="hidden" name="chk" value="${drugDosageIndicationBean.strChk1}">
    <input type="hidden" name="strEffectiveFrom" id="strEffectiveFrom" value="${drugDosageIndicationBean.strEffectiveFrom}"/>  
</html:form>
<tag:autoIndex></tag:autoIndex>
</body>
</html>