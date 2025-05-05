<%@ page language="java" contentType="text/html;"	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<%@taglib uri="/WEB-INF/dateTag.tld" prefix="date"%>
<%@ taglib uri="/WEB-INF/hisTab.tld" prefix="tag"%>
<%@ taglib uri="/WEB-INF/comboPersistence.tld" prefix="cmbPers"%>
<!--  
 * Developer : Deepak Tewari
 * Version : 1.0 
 * Date : 23/Jan/2009
 * Module:MMS
 * Unit:Supplier Return Request Details   
 -->
 
<html>
<head>
<meta charset=UTF-8">
<title>Supplier Return Sanction Details</title>
<link href="../css/master.css" rel="stylesheet" type="text/css">
<link href="../../hisglobal/css/tab.css" rel="stylesheet" type="text/css">
<link href="../../hisglobal/css/calendar-tas.css" rel="stylesheet" type="text/css">

<link href="../../hisglobal/css/popup.css" rel="stylesheet" type="text/css">	
<link href="../../hisglobal/css/newpopup.css" rel="stylesheet" type="text/css">	
	
<script language="JavaScript" src="../../hisglobal/masterutil/js/master.js"></script>
<script language="JavaScript" src="../../hisglobal/js/tab.js"></script>
<script language="JavaScript" src="../../hisglobal/js/calendar.js"></script>
<script language="Javascript" src="../../hisglobal/js/validation.js"></script>
<script language="Javascript" src="../../hisglobal/js/util.js"></script>
<script language="Javascript" src="../../hisglobal/js/popup.js"></script>
<script language="Javascript" src="../../hisglobal/js/newpopup.js"></script>
<script language="Javascript" src="../../hisglobal/js/multirow.js"></script>
<script language="Javascript" src="../../mms/js/supplier_return_req.js"></script>
<script language="JavaScript" src="../js/searchItems_util.js"></script>
<script language="Javascript" src="../js/issueDetails_util.js"></script>
<script language="Javascript" src="../js/stockDetails_util.js"></script>
<script language="JavaScript" src="../js/mms.js"></script>
<script language="javaScript">
function validate1()
 {
    
    var issueStatus=document.forms[0].issueStatus.value;   
    var retFlag=document.forms[0].strReturnFlag.value; 
    if((parseInt(retFlag)==4) && (parseInt(issueStatus)>0))
    {
      retVal=false;
      alert("Invalid DATA::Sanction Qty Greater than Available Qty.");
    }  
    else if(document.forms[0].strDeliveryDate.value=="")
    {
      retVal=false;
      alert("Delivery Date is Mandatory Field.");
    }
    else
    {
      var hisValidator = new HISValidator("supplierReturnModifyBean");
      hisValidator.addValidation("strRemarks","req","Please enter Remarks" );
      hisValidator.addValidation("strDeliveryDate","dtgtet="+document.forms[0].strCurrentDate.value,"Please select Delivery Date greater than equal to Current Date!!" );
      var retVal = hisValidator.validate();
    }  
	
		if(retVal)
		{
		  document.forms[0].hmode.value="INSERT";
	      document.forms[0].submit();
	    }
	    else
	    {
		  return false;
		}
 }

function onReplace()
{
  var objVal=document.forms[0].strReturnType.value;
  var divId=document.getElementById("deliveryDateDIV");
  if(objVal=="1")
  {
     divId.style.display="block";
  }
  else
  {
     divId.style.display="none"; 
  }
}
function init()
{
  var objVal=document.forms[0].strRetType.value;
  document.forms[0].strReturnType.value=objVal;
  var divId=document.getElementById("deliveryDateDIV");
  if(objVal=="1")
  {
     divId.style.display="block";
  }
  else
  {
     divId.style.display="none"; 
  }
}
</script>

</head>
<body onLoad="init();"> 
<html:form name="supplierReturnModifyBean" action="transactions/SupplierReturnModifyTransCNT"
	type="mms.transactions.controller.fb.SupplierReturnModifyTransFB">
	
<center>
	<div id="errMsg" class="errMsg"><bean:write name="supplierReturnModifyBean" property="strErrMsg" /></div>
	<div id="warningMsg" class="warningMsg"><bean:write name="supplierReturnModifyBean" property="strWarningMsg"/></div>
	<div id="normalMsg" class="normalMsg"><bean:write name="supplierReturnModifyBean" property="strNormalMsg"/></div>
</center>
	
<center>
    <tag:tab tabLabel="Supplier Return" selectedTab="FIRST" align="center" width="TABLEWIDTH"></tag:tab>
</center>

	<table class="TABLEWIDTH" align="center" cellpadding="1" cellspacing="1">   
	    <tr class="HEADER">
			<td colspan="4"></td>
		</tr>
		<tr>
			<td width="25%" colspan="1" class="LABEL">
				Store Name
			</td>
			<td width="25%" colspan="1" class="CONTROL">
				<bean:write name="supplierReturnModifyBean" property="strStoreName" filter="false" />
			</td>
		
			<td width="25%" colspan="1" class="LABEL">Item Category</td>
			<td width="25%" colspan="1" class="CONTROL">
			 <bean:write name="supplierReturnModifyBean" property="strItemCategoryNameH" filter="false" />
			</td>
		</tr>
		
		<tr>
			<td width="25%" colspan="1" class="LABEL">Req No.</td>
			<td width="25%" colspan="1" class="CONTROL">
			  <font color="blue"><bean:write name="supplierReturnModifyBean" property="strReqNo" filter="false" /></font>
			</td>
			<td width="25%" colspan="1" class="LABEL">
				Req Date
			</td>
			<td width="25%" colspan="1" class="CONTROL">
				<bean:write name="supplierReturnModifyBean" property="strReqDate" filter="false" />
			</td>
		</tr>
		
		<tr>
			<td width="25%" colspan="1" class="LABEL">
				Return Type
			</td>
			<td width="25%" colspan="1" class="CONTROL">
				<bean:write name="supplierReturnModifyBean" property="strReturnTypeName" filter="false" />
			</td>
		
			<td width="25%" colspan="1" class="LABEL">Return Reason</td>
			<td width="25%" colspan="1" class="CONTROL">
			  <bean:write name="supplierReturnModifyBean" property="strReturnReason" filter="false" />
			</td>
		</tr>
	</table>
	
  <div id="PODetailsDIV">	
	<table class="TABLEWIDTH" align="center" cellpadding="1px" cellspacing="1px">   
		<tr class="TITLE">
			<td colspan="4"><div id='' style='display:block;cursor:pointer;color:blue;'>PO Details</div>
			</td>
		</tr>
		<tr>
			<td width="25%" colspan="1" class="LABEL">
				PO No.
			</td>
			<td width="25%" colspan="1" class="CONTROL">
				<bean:write name="supplierReturnModifyBean" property="strPONo" />
			</td>
			<td width="25%" colspan="1" class="LABEL">PO Store Name</td>
			<td width="25%" colspan="1" class="CONTROL">
			  <bean:write name="supplierReturnModifyBean" property="strPOStoreName" filter="false" />
			</td>
	   </tr>
		<tr>
			<td width="25%" colspan="1" class="LABEL">
				PO Date
			</td>
			<td width="25%" colspan="1" class="CONTROL">
				<bean:write name="supplierReturnModifyBean" property="strPODate" />
			</td>
			<td width="25%" colspan="1" class="LABEL">PO Type</td>
			<td width="25%" colspan="1" class="CONTROL">
			  <bean:write name="supplierReturnModifyBean" property="strPOType"  />
			</td>
	   </tr>
	   <tr>
	   
	       <td width="25%" colspan="1" class="LABEL">
				Supplier Name
			</td>
			<td width="55%" colspan="3" class="CONTROL">
				<bean:write name="supplierReturnModifyBean" property="strSupplierName" filter="false" />
			</td>
			
	   </tr>
     </table>
 
	<table class="TABLEWIDTH" align="center" cellpadding="1" cellspacing="1">   
		<tr class="TITLE">
			<td colspan="4"><div id='' style='display:block;cursor:pointer;color:blue;'>Item/Drug Details</div>
			</td>
		</tr>
		<tr>
			<td width="50%" class="LABEL" ><font size="1" color="red">*</font>
			Group Name
			</td>
			<td width="50%" class="CONTROL" >
			
			      <bean:write name="supplierReturnModifyBean" property="strGroupName" filter="false" />
			 
			</td>
	   </tr>
     </table>
 
	<table class="TABLEWIDTH" align="center" cellpadding="1px" cellspacing="1px" bgcolor="black">
			<tr>
			<td width="15%" class="multiLabel">Item/Drug Name
			</td>
			<td width="15%" class="multiLabel">Batch/Serial No.
			</td>
			<td width="15%" class="multiLabel">Rate/Unit
			</td>
			<td width="15%" class="multiLabel">Avl. Qty
			</td>
			<td width="15%" class="multiLabel"><font size="1" color="red">*</font>Req. Qty
			</td>
			<td width="15%" class="multiLabel"><font size="1" color="red">*</font>Sanc. Qty
			</td>
			<td width="10%" class="multiLabel">Cost
			</td>
			</tr>
	</table>
 		
	<div id="id1"><bean:write name="supplierReturnModifyBean" property="strItemDtls" filter="false" /></div>
	
	<table class="TABLEWIDTH" align="center" cellpadding="1px" cellspacing="1px">   
		<tr class="TITLE">
			<td colspan="4"><div id='' style='display:block;cursor:pointer;color:blue;'>To Be Modified Details</div>
			</td>
		</tr>
		<tr>
			<td width="50%" colspan="2" class="LABEL" ><font size="1" color="red">*</font>
			Return Reason
			</td>
			<td width="50%" colspan="2" class="CONTROL" >
			    <select name="strReturnType"  onchange="onReplace();">
			       <bean:write name="supplierReturnModifyBean" property="strReturnType" filter="false" />
			    </select>
			</td>
	   </tr>
	  </table> 
	  <div id="deliveryDateDIV" style="display:block">
	    <table  class="TABLEWIDTH" align="center" cellpadding="1px" cellspacing="1px">
	      <tr>
	         <td width="50%" colspan="2" class="LABEL" ><font size="1" color="red">*</font>
	           Delivery Date
	         </td>
	         <td width="50%"colspan="2"  class="CONTROL" >
	           <date:date name="strDeliveryDate" value="${supplierReturnModifyBean.strCurrentDate}"></date:date>
	         </td>
	      </tr>
	    </table>
	  </div>
	    <table  class="TABLEWIDTH" align="center" cellpadding="1px" cellspacing="1px">
	    <tr>
		         <td  class="LABEL" width="50%" colspan="2"><font color="red">*</font>Remarks</td>
		         <td  class="CONTROL" width="50%" colspan="2">
		           <textarea name="strRemarks" rows="2" cols="11"><bean:write name="supplierReturnModifyBean" property="strRemarks" filter="false" /></textarea>
		         </td>
	    </tr>	
	 </table>   
	
  </div>
  
	
<table border="0" class="TABLEWIDTH" align="center" cellpadding="1px" cellspacing="1px">
	    <tr class="FOOTER">
			 <td colspan="4"><font size="2" color="red">*</font> Mandatory Fields  </td>
		</tr>
		<tr>
			<td align="center">
			<img style="cursor: pointer; " src="../../hisglobal/images/btn-sv.png" onClick="return validate1();" />
				<img style="cursor: pointer; " src="../../hisglobal/images/btn-clr.png" onClick="clearDtl();" >
			<img  style="cursor: pointer; " src="../../hisglobal/images/btn-ccl.png" onClick="cancel1();" >
		</td>
		</tr>
	</table>
<input type="hidden" name="hmode"/>
<input type="hidden" name="mode"/>  

<input type="hidden" name="strStoreName" value="${supplierReturnModifyBean.strStoreName}"/>
<input type="hidden" name="strReqDate" value="${supplierReturnModifyBean.strReqDate}"/>
<input type="hidden" name="strRetType" value="${supplierReturnModifyBean.strRetType}"/>
<input type="hidden" name="strReturnTypeName" value="${supplierReturnModifyBean.strReturnTypeName}"/>
<input type="hidden" name="strReturnFlag" value="${supplierReturnModifyBean.strReturnFlag}"/>
<input type="hidden" name="strReturnReason" value="${supplierReturnModifyBean.strReturnReason}"/>

<input type="hidden" name="strCurrentDate" value="${supplierReturnModifyBean.strCurrentDate}"/>
<input type="hidden" name="strSupplierId" value="${supplierReturnModifyBean.strSupplierId}"/>
<input type="hidden" name="strPONo" value="${supplierReturnModifyBean.strPONo}"/>
<input type="hidden" name="strPODate" value="${supplierReturnModifyBean.strPODate}"/>
<input type="hidden" name="strPOStoreId" value="${supplierReturnModifyBean.strPOStoreId}"/>
<input type="hidden" name="strReqNo" value="${supplierReturnModifyBean.strReqNo}" />
<input type="hidden" name="strStoreId" value="${supplierReturnModifyBean.strStoreId}" />
<input type="hidden" name="strItemCategoryNoH" value="${supplierReturnModifyBean.strItemCategoryNoH}" />
<input type="hidden" name="strItemCategoryNameH" value="${supplierReturnModifyBean.strItemCategoryNameH}" />
<input type="hidden" name="comboValue" value="${supplierReturnModifyBean.strStoreName}">

<cmbPers:cmbPers />
</html:form>
<tag:autoIndex></tag:autoIndex>
</body>
</html>