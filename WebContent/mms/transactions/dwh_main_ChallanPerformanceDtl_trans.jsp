<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic"%>
<%@ taglib uri="/WEB-INF/comboPersistence.tld" prefix="combPer"%>
<%@ taglib uri="/WEB-INF/dateTag.tld" prefix="dateTag"%>

<html>
<head>
<meta charset=UTF-8">
<title>CHALLAN MODIFY (BACKLOG)</title>

<link href="../css/master.css" rel="stylesheet" type="text/css">
<link href="../css/transaction.css" rel="stylesheet" type="text/css">
<link href="../../hisglobal/css/tab.css" rel="stylesheet" type="text/css">
<link href="../../hisglobal/css/calendar-tas.css" rel="stylesheet" type="text/css">
<link href="../../hisglobal/css/popup.css" rel="stylesheet" type="text/css">	
<link href="../../hisglobal/css/newpopup.css" rel="stylesheet" type="text/css">
<link href="../../hisglobal/css/popup.css" rel="stylesheet" type="text/css">	
	

<script language="Javascript" src="../../hisglobal/js/newpopup.js"></script>
<script language="Javascript" src="../../hisglobal/js/popup.js"></script>
<script language="Javascript" src="../../hisglobal/js/multirow.js"></script>	
<script language="JavaScript" src="../../masterutil/js/master.js"></script>
<script language="JavaScript" src="../../hisglobal/js/calendar.js"></script>
<script language="Javascript" src="../../hisglobal/js/validation.js"></script>
<script language="Javascript" src="../../hisglobal/js/validationCommon.js"></script>
<script language="Javascript" src="../../hisglobal/js/util.js"></script>
<script language="JavaScript" src="../js/dwh_main_ChallanPerformanceDtl_trans.js"></script>
</head>
<body onLoad="hideMenuFrame();">
<html:form action="/transactions/ChallanPerformanceCNT.cnt"  name="challanPerformanceFB" type="mms.transactions.controller.fb.ChallanPerformanceFB" method="post">
    <div class="errMsg"     id="errMsg"><bean:write name="challanPerformanceFB" property="strErrMsg"/></div>
	<div class="warningMsg" id="warningMsg"><bean:write name="challanPerformanceFB" property="strWarningMsg"/></div>
	<div class="normalMsg"  id="normalMsg"><bean:write name="challanPerformanceFB" property="strNormalMsg"/></div>
     
 <table width='1200' align="center" border="0" cellspacing ="1px">
		<tr class="HEADER"> 
			 <td colspan="2">CHALLAN MODIFY (BACKLOG)</td><td colspan="2"><div id="" align="right"> Modify :  : <input type="checkbox" name="modifyChk" onClick="setFlag(this);"></div></td>		      
	  </tr>
  </table>
  

  
 <table width='1200' align="center" border="0" cellspacing ="1px">

<!-- Drug Ware House Name and PO NO -->
	<tr> 
          
	     <td width="50%"  colspan='2' class="LABEL"><font color="red">*</font>Store Name</td>
             <td width="50%" colspan='2' class="CONTROL">
         
	          <html:select name="challanPerformanceFB" property="strDrugWareHouseName" styleClass="comboMax" onchange="getSupplierCombo();">
	                 <bean:write name="challanPerformanceFB" property="strDrugWareHouseNameCmb" filter="false"/>
	          </html:select>
            </td>   
      </tr>    
       <tr>     
            <td width="50%" colspan='2' class="LABEL"><font color="red">*</font>Supplier Name</td>
         <td width="50%" colspan='2' class="CONTROL">    		 
         <div id="supplierCmb">   
	          <html:select name="challanPerformanceFB" property="strSupplierId" styleClass="comboTooMax"  onchange="getPoNoCombo();">
	                 <option value="0">Select Value</option>
	           </html:select>
	     </div>      
	        
         </td>   
        </tr>
 	 <tr> 
       
      <tr>     
            <td width="50%" colspan='2' class="LABEL"><font color="red">*</font>PO No</td>
         <td width="50%" colspan='2' class="CONTROL">
    		<div id="poNoComboDivId">     
	          <html:select name="challanPerformanceFB" property="strPoNo" styleClass="comboTooMax" >
	                 <bean:write name="challanPerformanceFB" property="strPoNoCmb" filter="false"/>
	                 <option value="0">Select Value</option>
	          </html:select>
	        </div>  
         </td>   
        </tr>
 	 <tr> 
     <tr>                 
	     <td width="50%" colspan='2' class="LABEL"><font color="red">*</font>Item Name</td>
         <td width="25%" colspan='1' class="CONTROL">
    		<div id="itemComboDivId">     
	          <html:select name="challanPerformanceFB" property="strItemId" styleClass="comboTooMax"   >
	                 <bean:write name="challanPerformanceFB" property="strItemNameCmb" filter="false"/>
	                 <option value="0">Select Value</option>
	          </html:select>
	        </div>  
         </td> 
         <td width="25%" colspan='1' class="CONTROL">  
            <img style="cursor: pointer;text-align:right;"  title="Get Item Challan Details" src="../../hisglobal/images/Go.png" onclick="getChallanDetails();"/>
         </td>
   </tr>
   </table> 
   <table width='1200' align="center" border="0" cellspacing ="1px">
   <tr id="showQtyDivId" style="display: none;">
	   	 <td width="25%" colspan='1' class="LABEL">Ordered Qty</td>
	   	 
         <td width="25%" colspan='1' class="CONTROL">
         	<input type="text" name="strOrderQty" maxlength="9"   readonly/>
         </td>
         
         <td width="25%" colspan='1' class="LABEL">Previous Accepted Qty</td>
	   	 
         <td width="25%" colspan='1' class="CONTROL">	
        	 <input type="text" name="strAcceptedQty" maxlength="9"  readonly/>
         </td>
         
   </tr>
   <tr id="showQtyDivId1" style="display: none;">
	   	 <td width="50%" colspan='2' class="LABEL"></td>         
         <td width="25%" colspan='1' class="LABEL">New Accepted Qty</td>   	 
         <td width="25%" colspan='1' class="CONTROL">	
        	 <input type="text" name="strNewAcceptedQty" maxlength="9"  readonly/>
         </td>
         
   </tr>
  </table> 
      	
	<div id="challanDetails"></div>
	<div id="id1"></div>
    <table width='1200' align="center" cellpadding="1" cellspacing="1"> 
	 <tr class="FOOTER">
			 <td colspan="2"><font size="2" color="red">*</font> Mandatory Fields  </td>
		</tr>
	</table>	
	<table  width='1200' align="center">
	  <tr>
			<td align="center">
	                <img style="cursor:pointer;cursor:pointer" title="Click to Save Record" src="../../hisglobal/images/Verify.gif"  onClick=" return validate2();" onkeypress="if(event.keyCode==13) validate2();"/>
	                <img style="cursor:pointer;cursor:pointer" title="Click to Clear Page" src="../../hisglobal/images/btn-clr.png" name="clearImg" onclick="document.forms[0].reset(),clearMsg('INITVAL')" onkeypress="if(event.keyCode==13) document.forms[0].reset(),clearMsg('INITVAL');">
	                <img style="cursor: pointer; " title="Click to Return Main Menu" src="../../hisglobal/images/btn-ccl.png" onClick="hideMenuFrame();cancelPage();" onkeypress="if(event.keyCode==13) hideMenuFrame();cancelPage()" />
			</td>
		</tr>
	</table>	
    
     <html:hidden name="challanPerformanceFB" property="hmode" />
     <html:hidden name="challanPerformanceFB" property="strStoreId" />
     <html:hidden name="challanPerformanceFB" property="strSubStoreCmb" />
     
      <html:hidden name="challanPerformanceFB" property="strCtDate" value="${challanPerformanceFB.strCtDate}"/>
    
    <html:hidden name="challanPerformanceFB" property="strGoDetailsFlag" value="0" />
    <html:hidden name="challanPerformanceFB" property="strModifyFlag" value="${challanPerformanceFB.strModifyFlag}" />
    
	<html:hidden name="challanPerformanceFB" property="strOrderedQty"  value="${challanPerformanceFB.strOrderedQty}" />
   <html:hidden name="challanPerformanceFB" property="strResetOrderedQty"  value="${challanPerformanceFB.strResetOrderedQty}" />
   <input type="hidden" name="strBeforeSaveFlg" value="0">
     
</html:form>
<jsp:include page="challan_backlog_multiRow.jsp"></jsp:include>
	<tag:autoIndex></tag:autoIndex>   

<combPer:cmbPers />
</body>
</html>
