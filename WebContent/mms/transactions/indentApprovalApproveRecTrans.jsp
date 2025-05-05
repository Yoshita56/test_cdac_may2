<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<%@taglib uri="/WEB-INF/dateTag.tld" prefix="dateTag"%>
<%@ taglib uri="/WEB-INF/hisTab.tld" prefix="tag"%>

<!--  
 * Developer : Deepak Tiwari 
 * Version : 1.0 
 * Date : 23/Jan/2009
 * Module:MMS
 * Unit:Indent Approval   
 -->
 


<html>
<head>
<meta charset=UTF-8">
<title>Indent Approval Details</title>
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

<script language="javaScript">

function itemDetails_Ajax()
{
    var url;
	var mode = "ITEMDETAILS";
	url="IndentApprovalApproveRecTransCNT.cnt?hmode="+mode;//+"&itemId="+document.forms[0].strSetSachetId.value; 
 	ajaxFunction(url,"1");
}
function getAjaxResponse(res,mode)
{
	var objVal;
	if(mode=="1")
	{   
	  var err = document.getElementById("errMsg");
	  var temp1 = res.split("####");
      if(temp1[0] == "ERROR")
      {
          err.innerHTML = temp1[1];	
      }
	  else
	  {
		  //alert("res-"+res);
		  objVal= document.getElementById("ItemDetailsDivId");
		  objVal.innerHTML = res;
	  }
	}
}

function ClosePopUp()
{
 var divId="PopUpDiv";
 styledPopupClose(divId);
}	

function cancelToDesk()
{
  var mode="CANCEL";
  document.forms[0].hmode.value=mode;
  document.forms[0].submit();
}
</script>

</head>
<body onLoad="itemDetails_Ajax();">
<html:form name="indentApprovalApproveRecTransBean" action="transactions/IndentApprovalApproveRecTransCNT"
	type="mms.transactions.controller.fb.IndentApprovalApproveRecTransFB">
	
<center>
	<div id="errMsg" class="errMsg"><bean:write name="indentApprovalApproveRecTransBean" property="strErr" /></div>
	<div id="warningMsg" class="warningMsg"><bean:write name="indentApprovalApproveRecTransBean" property="strWarning"/></div>
	<div id="normalMsg" class="normalMsg"><bean:write name="indentApprovalApproveRecTransBean" property="strMsg"/></div>
	</center>
	<div id="PopUpDiv" style="display:none" class="popup">
	  <table width="400" align="center" cellpadding="0" class="popup" cellspacing="1px"  bgcolor="pink">
         <tr class="HEADER">
               <td width="95%" colspan="2" >Last Approval Details</td>
               <td width="5%" align="right" ><img src="../../hisglobal/images/popUp_cancel.JPG" onclick="ClosePopUp();" style="cursor: pointer;"></td>
         </tr>
         <tr>
               <td width="35%" colspan="1" class='multiLabel' >Approved By</td>
               <td width="35%" colspan="1" class='multiLabel' >Approval Date</td>
               <td width="30%" colspan="1" class='multiLabel' >Sanction Qty</td>
         </tr>
         <tr>
               <td colspan='3' class='multiControl'><div id="popUpApproveDtl"><font color="red">No Matching Record Found</font></div></td>
         </tr>
      </table>
	</div>
<center>
<tag:tab tabLabel="Indent Approval Details Transaction>>Receiving End" selectedTab="FIRST" align="center" width="TABLEWIDTH">
	</tag:tab>
</center>
	
<table  align="center" cellpadding="1px" cellspacing="1px" class="TABLEWIDTH">
  <tr class="HEADER"> 
    <td colspan="4"></td>
  </tr>
  <tr> 
    <td class="LABEL" width="25%">Store Name</td>
    <td  class ="CONTROL" width="25%"></td>
    <td class="LABEL" width="25%" >Indent Date</td>
    <td  class ="CONTROL" width="25%"></td>
  </tr>
  <tr> 
    <td class="LABEL" width="25%" colspan="1">Indent Type</td>
    <td width="25%" class ="CONTROL" colspan="1"></td>
    <td class="LABEL" width="25%" colspan="1">Item Category</td>
    <td width="25%" class ="CONTROL" colspan="1"></td>
  </tr>
  <tr> 
    <td class="LABEL" width="25%" colspan="1">Indent Period </td>
    <td width="25%" class ="CONTROL" colspan="1"></td>
    <td class="LABEL" width="25%" >Indent Sate</td>
    <td class="CONTROL" width="25%" >
      <select name="select">
        <option value="1">Normal</option>
        <option value="2">Urgent</option>
      </select>
    </td>
  </tr>
</table>
   <table class="TABLEWIDTH" align="center"cellpadding="1px" cellspacing="1px">
   <tr>
   <td colspan="7" class="TITLE">Item/Drug Details</td>
   </tr>
   <tr>
   <td class='multiLabel' width='15%' >Item/Drug Name</td>
    <td class='multiLabel' width='15%'>In Hand Qty</td>
    <td class='multiLabel' width='14%'>Lst Indent Qty</td>
	<td class='multiLabel' width='14%'>Lst Issue Qty</td>
    <td class='multiLabel' width='14%'>Req Qty</td>
    <td class='multiLabel' width='14%'><font color='red'>*</font>Sanctioned Qty</td>
   <td class='multiLabel' width='14%'><font color='red'>*</font>Unit</td>
   </tr>
   </table>
    <div id="ItemDetailsDivId"></div>
    
  
  
   
   
   <table class="TABLEWIDTH" align="center" cellpadding="0px" cellspacing="1px">
   	<tr>
    <td class="LABEL" width="50%" colspan="1">Remarks</td>
    <td width="50%" class ="CONTROL" colspan="1">
   <textarea name="strRemarks"cols="16" rows="2"></textarea> </td>
    
  </tr>
   </table>
  
  
	
	
	
	
	<table class="TABLEWIDTH" align="center" cellpadding="1px" cellspacing="1px">		
		<tr class="FOOTER">
			 <td colspan="4"><font size="2" color="red">*</font> Mandatory Fields  </td>
		</tr>
	</table>
	<table class="TABLEWIDTH" align="center" cellpadding="1px" cellspacing="1px">
		<tr>

			<td align="center">
			<img style="cursor: pointer; "
				src="../../hisglobal/images/btn-sv.png" onClick="return validate1();" />
				<img style="cursor: pointer; " src="../../hisglobal/images/btn-clr.png" onClick="Clear();" >
			<img  style="cursor: pointer; " src="../../hisglobal/images/back_tab.png" onClick="cancelToDesk();" >
		</td>
		</tr>
	</table>
<input type="hidden" name="hmode"/>


</html:form>
	<tag:autoIndex></tag:autoIndex>   
</body>
</html>