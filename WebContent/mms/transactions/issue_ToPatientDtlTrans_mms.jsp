<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic"%>
<%@ taglib uri="/WEB-INF/dateTag.tld" prefix="date"%>
<%@ taglib uri="/WEB-INF/hisTab.tld" prefix="tag"%>
<%@ taglib uri="/WEB-INF/crNo.tld" prefix="crNo"%>

<!-- 
/**
 * Developer : Amit Kumar
 * Version : 1.0
 * Date : 09/Apr/2009
 * Modif Date : / /2009 
*/
-->
<html>
<head>
<meta charset=UTF-8">
<title>Issue to Employee</title>
<link href="../css/master.css" rel="stylesheet" type="text/css">
<link href="../../hisglobal/css/tab.css" rel="stylesheet" type="text/css">
<link href="../../hisglobal/css/calendar-tas.css" rel="stylesheet" type="text/css">

<link href="../../hisglobal/css/popup.css" rel="stylesheet" type="text/css">	
<link href="../../hisglobal/css/newpopup.css" rel="stylesheet" type="text/css">
	
<script language="JavaScript" src="../../masterutil/js/master.js"></script>
<script language="JavaScript" src="../../hisglobal/js/tab.js"></script>
<script language="JavaScript" src="../../hisglobal/js/calendar.js"></script>
<script language="Javascript" src="../../hisglobal/js/validation.js"></script>
<script language="Javascript" src="../../hisglobal/js/datepicker1.js"></script>
<script language="Javascript" src="../js/searchItems_util.js"></script>
<script language="JavaScript" src="../../hisglobal/js/tab.js"></script>
<script language="Javascript" src="../../hisglobal/js/newpopup.js"></script>
<script language="Javascript" src="../../hisglobal/js/multirow.js"></script>
<script language="Javascript" src="../../hisglobal/js/util.js"></script>
<script language="Javascript" src="../js/patientListing.js"></script>
<script language="JavaScript" src="../js/IssueToPatient.js"></script>
</head>
<body onload="checkOnOffLineFlag()";>
<html:form action="/transactions/IssueToPatientTransCNT.cnt"  name="issueToPatTransBean" type="mms.transactions.controller.fb.IssueToPatientTransFB" method="post">
    <div class="errMsg"     id="errMsg"><bean:write name="issueToPatTransBean" property="strErr"/></div>
	<div class="warningMsg" id="warningMsg"><bean:write name="issueToPatTransBean" property="strWarning"/></div>
	<div class="normalMsg"  id="normalMsg"><bean:write name="issueToPatTransBean" property="strMsg"/></div>
    
    <div id="Patient" style="display:none">
       <tag:tab tabLabel="Issue To Patient" selectedTab="FIRST" align="center" width="TABLEWIDTH"></tag:tab>
       
    </div>
    <div id="Staff" style="display:none">
      <tag:tab tabLabel="Issue To Staff" selectedTab="FIRST" align="center" width="TABLEWIDTH"></tag:tab>
    </div>
	
 <table class="TABLEWIDTH" align="center" border="0" cellspacing ="1px">
  <tr class="HEADER"> 
     <td colspan="4">
        <div id="Patient1" style="display:none"></div>
     	<div id="Staff1" style="display:none"></div>
     	<div id="OffLine" style="display:none"></div>
     	<div id="OnLine" style="display:none"></div>
    </td>
  </tr>
  <tr> 
         <td width="25%" class="LABEL"><font color="red">*</font>Store Name:</td>
         <td width="25%" class="CONTROL">
         
                  <select name="strStoreNameCmb" id="strStoreNameCmb" class="comboNormal"   onChange="getItemCategory();" disabled="disabled">
                        <bean:write name="issueToPatTransBean" property="strStoreName" filter="false"/>
                 </select>
         </td>   
         <td width="25%" class="LABEL"><font color="red">*</font>Item Category:</td>
    
         <td width="25%" class="CONTROL">   
            <div align="left" id="ItemNameId" style="display:block;" >
               <select name="strItemCategoryCmb" class='comboNormal' id="strItemCategoryCmb"><option value="0">Select Value</option></select>
           </div>
            <div align="left" id="ItemNameIdName" style="display:block;" ></div>
        </td> 
           
        </tr>
  <tr> 
    <td width="25%" class="LABEL"><font color="red">*</font>CR No.</td>
    <td colspan="3" class="CONTROL">
    <crNo:crNo value ="${issueToPatTransBean.strCrNo}" js=" onkeypress='return initGoFunc(event);'"></crNo:crNo>
    <input type="image" style="cursor:pointer;cursor:pointer" title="Issue To Patient Details" align="top" src ="../../hisglobal/images/Go.png" name="go" value="Go" onclick="return goFunc();" onkeyup="goFuncOnEnter(event);">
  </td>   
  </tr>
  </table>
<div id="All" style="display:none">
   <table class="TABLEWIDTH" align="center" border="0" cellspacing ="1px">
    <tr>  
     <td width="5%" class="TITLE" align="center"><input type='hidden' name='button1' value="0">
     <img src="../../hisglobal/images/plus.gif"   id="plus1"  style="display:block;cursor:pointer" onClick="ftn11()">
     <img src="../../hisglobal/images/minus.gif"  id="minus1" style="display:none;cursor:pointer" onClick="ftn11()"></td>
    <td colspan="3" class="TITLE" align="left"><b><div id='' style='color:blue;'>Patient Demographic Detail</div></b></td>   
  </tr>
 </table>
 
 <div id = "detailsdivid1" style="display:none;">
  <table class="TABLEWIDTH" align="center" cellspacing ="1px">
  <tr>
      <bean:write name="issueToPatTransBean" property="strPatientDemDtl" filter="false"/>
  </tr>
 </table>
 </div>
 
 
 <table class="TABLEWIDTH" align="center" cellspacing ="1px">
  <tr> 
    <td width="5%" class="TITLE" align="center"><input type='hidden' name='button3' value="0">
    <img src="../../hisglobal/images/plus.gif"  id="plus3" style="display:block;cursor:pointer;cursor:pointer" onClick="ftn33();AjaxFunc();">
    <img src="../../hisglobal/images/minus.gif" id="minus3" style="display:none;cursor:pointer;cursor:pointer" onClick="ftn33()"></td>
    <td colspan="3" class="TITLE"><b><div id='' style='color:blue;'>Previous Issue Details</div></b></td> 
   </tr>
 </table>

 <div id = "detailsdivid2" style="display:none;">
 <table class="TABLEWIDTH" align="center" cellspacing ="1px">
  <tr>
          <bean:write name="issueToPatTransBean" property="strPrevIssueDtl" filter="false"/>
  </tr>
 </table>
 </div>
 <div id = "offlineMode" style="display:block;">
    <table class="TABLEWIDTH" align="center" cellspacing="1px">  
        <tr class="TITLE">
			 <td colspan="2"></td>
		</tr>
	</table>
 
    <table class="TABLEWIDTH" align="center" cellpadding="1" cellspacing="1"><tbody><tr><td class="CONTROL"><div align="right"> <img style="cursor: pointer;height: 20px" id='strSearchItemButtonDivId' src="../../hisglobal/images/ItemFinder.png"
 onclick='getItemSelectPopup();'></div> </td> </tr> </tbody>
	   </table> 
	   
	   <table class="TABLEWIDTH" align="center" cellpadding="1px" cellspacing="1px" bgcolor='black'>
			<tr>
			<td width="22%" class="multiLabel">Item/Drug Name
			</td>
			<td width="22%" class="multiLabel">Brand Name
			</td>
			<td width="16%" class="multiLabel">Avlaible Qty
			</td>
			<td width="16%" class="multiLabel">Issued Qty
			</td>
			<td width="24%" class="multiLabel">Unit
			</td>
			</tr>
			
			</table>	
		
		       <div id="id1"></div>
	</div>	
 <div id ="onlineMode" style="display:none;"> 
 
    <table class="TABLEWIDTH" align="center" cellspacing ="1px">
      <tr>
          <bean:write name="issueToPatTransBean" property="strOnLineDtl" filter="false"/>
      </tr>
    </table>
      
  <table class="TABLEWIDTH" align="center" border="0" cellspacing ="1px">
    <tr class="TITLE"> 
      <td colspan="2"><div id='' style='color:blue;'>OnLine Mode</div></td>
    </tr>
  <tr> 
         <td width="50%" class="LABEL">Req NO:</td>
         <td width="50%" class="CONTROL">
                 <select name="strReqCmb" id="strReqCmb" class="comboNormal"   onChange="">
                        <bean:write name="issueToPatTransBean" property="strReqNo" filter="false"/>
                 </select>
         </td>   
      
      </tr>
      </table>
      
    <table class="TABLEWIDTH" align="center" cellspacing="1px">  
        <tr class="TITLE">
			 <td colspan="4"><div id='' style='color:blue;'>Prescription Details</div></td>
		</tr>
   <tr> 
     <td width="25%" class="LABEL"><font color="red">*</font>Department:</td>
     <td width="25%" class="CONTROL">
       <select name="strDeptCombo" class="comboNormal" onChange="getUnitCombo();">
           <bean:write name="issueToPatTransBean" property="strDeptCombo" filter="false"/>
       </select>
    </td> 
   <td width="25%" class="LABEL"><font color="red">*</font>Unit:</td>
    <td width="25%" class="CONTROL">   
      <div align="left" id="GrpNameId">
         <select name="strUnitCombo" class='comboNormal' id="strUnitCombo"><option value="0">Select Value</option></select>
      </div>
       
    
     </td> 
    
   </tr>
  <tr> 
   <td width="25%" class="LABEL"><font color="red">*</font>Prescribe By:</td>
    <td width="25%" class="CONTROL">
    
      
       <select name="strPrescBy" id="strPrescBy" class="comboMax"   onChange="">
                        <bean:write name="issueToPatTransBean" property="strPrescBy" filter="false"/>
                 </select>
      
      </td>
    <td width="25%" class="LABEL"><font color="red">*</font>Prescription For:</td>
    <td width="25%" class="CONTROL"><input type='text' class='txtFldNormal' name='strPrescFor'  value=''><b>day's</b></td> 
   </tr>
	</table>
	 
    <table class="TABLEWIDTH" align="center" cellpadding="1" cellspacing="1"> 
		  
     <tr> 
        <td width="50%" class="LABEL"> Remarks</td>
        <td class="CONTROL">
        <textarea name="strRemarks" cols="20" rows="2"id="strRemarks" ></textarea> </td>
    </tr>
        
	
        
	</table>
	</div>
   </div>	
	<table class="TABLEWIDTH" align="center" cellpadding="1" cellspacing="1"> 
	 <tr class="FOOTER">
			 <td colspan="2"><font size="2" color="red">*</font> Mandatory Fields  </td>
		</tr>
	</table>	
	<table  class="TABLEWIDTH" align="center">
	  <tr>
			<td align="center">
	                <img style="cursor:pointer;cursor:pointer" title="Click to Save Record" src="../../hisglobal/images/btn-sv.png"  onClick=" return validate1();" />
	                <img style="cursor:pointer;cursor:pointer" title="Click to Clear Page" src="../../hisglobal/images/btn-clr.png" name="clearImg" onclick="initPage();">
	                <img style="cursor: pointer; " title="Click to Return Main Menu" src="../../hisglobal/images/btn-ccl.png" onClick="" />
			</td>
		</tr>
	</table>	
    
    <input type="hidden" name="hmode"/>
      <input type="hidden" name="strOnOffLineflag"       value="${issueToPatTransBean.strOnOffLineflag}">
      <input type="hidden" name="strStoreNameCmbTemp"    value="${issueToPatTransBean.strStoreNameCmb}">
      <input type="hidden" name="strItemCategoryCmbTemp" value="${issueToPatTransBean.strItemCategoryCmb}">
      <input type="hidden" name="strGoFlag"     value="${issueToPatTransBean.strGoFlag}">
      <input type="hidden" name="strCatCode"     value="${issueToPatTransBean.strCatCode}">
      <input type="hidden" name="strTempCrNo"   value="${issueToPatTransBean.strTempCrNo}">
      <input type="hidden" name="strMode"   value="${issueToPatTransBean.strMode}">
      <input type="hidden" name="strTmpMode"   value="${issueToPatTransBean.strTmpMode}">
      
     
      <input type="hidden" name="itemCatName"   value="${issueToPatTransBean.strItemCmbName}">
          
  
    <div id="blanket" style="display:none;"></div>
   <div class="popUpDiv" id="popUpDiv" style="display:none;">
   <table bgcolor="white">
     <tr>
      <td>
         <div id="searchItemsDtlsDivId" style="display:block;"></div>
       </td>
     </tr>
    </table>
   </div>
     
</html:form>
<jsp:include page="issueToPatient_itemSearchRow.jsp"></jsp:include>
	<tag:autoIndex></tag:autoIndex>   

</body>
</html>