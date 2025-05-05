<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<%@taglib uri="/WEB-INF/dateTag.tld" prefix="date"%>
<%@ taglib uri="/WEB-INF/hisTab.tld" prefix="tag"%>
<%@ taglib uri="/WEB-INF/comboPersistence.tld" prefix="cmbPers"%>


<head>
<meta charset=UTF-8">
<title>Indent Return</title>

<link href="../css/master.css" rel="stylesheet" type="text/css">
<link href="../../hisglobal/css/tab.css" rel="stylesheet" type="text/css">
<link href="../../hisglobal/css/calendar-tas.css" rel="stylesheet" type="text/css">
<link href="../../hisglobal/css/popup.css" rel="stylesheet" type="text/css">

<script language="JavaScript" src="../../masterutil/js/master.js"></script>
<script language="JavaScript" src="../../hisglobal/js/tab.js"></script>
<script language="JavaScript" src="../../hisglobal/js/calendar.js"></script>
<script language="Javascript" src="../../hisglobal/js/validation.js"></script>
<script language="Javascript" src="../../hisglobal/js/util.js"></script>

<script language="JavaScript" src="../../masterutil/js/master.js"></script>
<script language="JavaScript" src="../../hisglobal/js/tab.js"></script>
<script language="JavaScript" src="../../hisglobal/js/calendar.js"></script>
<script language="JavaScript" src="../../hisglobal/js/multirow.js"></script>
<script language="Javascript" src="../../hisglobal/js/validation.js"></script>
<script language="Javascript" src="../../hisglobal/js/util.js"></script>
<script language="Javascript" src="../../hisglobal/js/popup.js"></script>

<script language="Javascript" src="../js/IndentReturn.js"></script>
</head>
<body>
<html:form name="indentReturnBean" action="/transactions/IndentReturnTransCNT" type="mms.transactions.controller.fb.IndentReturnTransFB">
	
<center>
	<div id="errMsg" class="errMsg"><bean:write name="indentReturnBean" property="strErrMsg" /></div>
	<div id="warningMsg" class="warningMsg"><bean:write name="indentReturnBean" property="strWarningMsg" /></div>
	<div id="normalMsg" class="normalMsg"><bean:write name="indentReturnBean" property="strNormalMsg" /></div>
	
</center>
        
              <tag:tab tabLabel="Return Request" selectedTab="FIRST"
		align="center" width="TABLEWIDTH">
	</tag:tab>
              
          
       
     
   <div class='popup' id='Return' style="display:none">
	<table width='400' border="0" cellspacing ="0px">
		<tr class="HEADER"> 
			<th colspan='6' align='left'></th>
			<th align='right'><img  style='cursor:pointer;cursor:pointer' src='../../hisglobal/images/popUp_cancel.JPG'
				onClick="hideItemDetails('Return');"></th>
	    </tr>
	 </table>   
	 <table width='400' border="0" cellspacing ="1px" cellpadding="1px">
		<tr>
			<td colspan="1" class='multiLabel'>Lst PO No.</td>
			<td colspan="1" class='multiLabel'>Last PO Date</td>
			<td colspan="1" class='multiLabel'>Last Rec date</td>
					
		</tr>
		<tr>
			<td colspan="1" class='multiControl'><div id ='14'></div></td>
			<td colspan="1" class='multiControl'><div id ='15'></div></td>
			<td colspan="1" class='multiControl'><div id ='16'></div></td>
		  </tr>
		 <tr class="FOOTER">
			<td colspan="3"></td>
		</tr>
        </table>
	</div>  
   
  	     <table class="TABLEWIDTH" align="center" cellspacing="1" cellpadding="1">   
		 <tr class="HEADER">
			<td colspan="4"><b><bean:write name="indentReturnBean" property="strRequestName" filter="false"/></b></td>
		 </tr>
		 </table>
		 <table class="TABLEWIDTH" align="center" cellspacing="1" cellpadding="1">   
		      <bean:write name="indentReturnBean" property="strIndentDetails"	filter="false" />
		</table>
		
		
		<table class="TABLEWIDTH" align="center" cellspacing="1" cellpadding="1">   
		<tr class="TITLE">
			<td colspan="4">Item Details</td>
		</tr>
		</table>
		<table class="TABLEWIDTH" align="center" cellspacing="1" cellpadding="1"> 
		<bean:write name="indentReturnBean" property="strSetItemDetails"	filter="false" />
		
		</table>
			 
			
	<table class="TABLEWIDTH" align="center" cellpadding="1px"
		cellspacing="1px">
	<tr>
		
		
		<td width="50%" class="LABEL" colspan="2" >Received By</td>
		<td width="50%" class="CONTROL"  colspan="2"><input type="text" class="txtFldMax" name="strReceviedBy"></td>
		
		
	
	</tr>
	</table>
	<table class="TABLEWIDTH" align="center" cellpadding="1px"
		cellspacing="1px">	
	<tr>
		<td width="50%" class="LABEL" ><font color="red">*</font>Remarks</td>
			<td width="50%" class="CONTROL" colspan="3"><textarea
				name="strRemarks" cols="25" rows="2"></textarea></td>
	</tr>
		
		
		
		
	</table>
	
	
	
	
	<table border="0" class="TABLEWIDTH" align="center" cellpadding="1" cellspacing="1">
	<tr class="FOOTER">
               <td width="TABLEWIDTH" colspan="2" ></td>
               </tr>
		<tr>

			<td align="center">
			 <img style="cursor:pointer;cursor:pointer"  title="Click to Save Record" src="../../hisglobal/images/btn-sv.png"  onClick=" return validate1();" />
			 <img style="cursor:pointer;cursor:pointer"  title="Click to Clear Page" src="../../hisglobal/images/btn-clr.png" name="clearImg" onclick="initPage();">		
			<img style="cursor: pointer; " src="../../hisglobal/images/back_tab.png" onClick="cancelToDesk();" title="Cancel Process"/>
			
			</td>
		</tr>
		
	</table>
	<input type="hidden" name="hmode"/>
	<input type="hidden" name="strItemCategory" value="${indentReturnBean.strItemCategory}">
	<input type="hidden" name="strPath" value="${indentReturnBean.strPath}">
	<input type="hidden" name="strChk" value="${indentReturnBean.strChk}">
	<input type="hidden" name="strReqNo" value="${indentReturnBean.strReqNo}">
	<input type="hidden" name="strReqTypeId" value="${indentReturnBean.strReqTypeId}">
	<input type="hidden" name="strStoreId" value="${indentReturnBean.strStoreId}">
	<input type="hidden" name="strToStoreId" value="${indentReturnBean.strToStoreId}">
	<cmbPers:cmbPers/>
	</html:form>
		<tag:autoIndex></tag:autoIndex>   
</body>
