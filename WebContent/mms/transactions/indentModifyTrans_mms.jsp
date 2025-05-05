<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<%@taglib uri="/WEB-INF/dateTag.tld" prefix="date"%>
<%@ taglib uri="/WEB-INF/hisTab.tld" prefix="tag"%>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic"%>

<%@ taglib uri="/WEB-INF/comboPersistence.tld" prefix="cmbPers"%>


<head>
<meta charset=UTF-8">
<title>Indent Modify</title>

<link href="../css/master.css" rel="stylesheet" type="text/css">
<link href="../../hisglobal/css/tab.css" rel="stylesheet" type="text/css">
<link href="../../hisglobal/css/calendar-tas.css" rel="stylesheet" type="text/css">
<link href="../../hisglobal/css/popup.css" rel="stylesheet" type="text/css">

<script language="JavaScript" src="../../masterutil/js/master.js"></script>
<script language="JavaScript" src="../../hisglobal/js/tab.js"></script>
<script language="JavaScript" src="../../hisglobal/js/calendar.js"></script>
<script language="Javascript" src="../../hisglobal/js/validation.js"></script>
<script language="Javascript" src="../../hisglobal/js/util.js"></script>
<script language="Javascript" src="../js/indentViewTrans.js"></script>
<script language="JavaScript" src="../../masterutil/js/master.js"></script>
<script language="JavaScript" src="../../hisglobal/js/tab.js"></script>
<script language="JavaScript" src="../../hisglobal/js/calendar.js"></script>
<script language="JavaScript" src="../../hisglobal/js/multirow.js"></script>
<script language="Javascript" src="../../hisglobal/js/validation.js"></script>
<script language="Javascript" src="../../hisglobal/js/util.js"></script>
<script language="Javascript" src="../../hisglobal/js/popup.js"></script>
<script language="Javascript" src="../../hisglobal/js/dropdown.js"></script>

<style type="text/css">

  .Approved 
   {
	font-family: Verdana, Arial, Helvetica, sans-serif;
	font-size: 12px;
	font-style: normal;
	font-weight: normal;
	color: #151AFB;
	background-color: #D3D5C9;
	height: 16px;
	text-align:center;
    }
    
   .NotApproved 
   {
	font-family: Verdana, Arial, Helvetica, sans-serif;
	font-size: 12px;
	font-style: normal;
	font-weight: normal;
	color: #000000;
	background-color: #F1ECE2;
	height: 16px;
	text-align:center;
    }
    .pg-normal {
        color: blue;
        font-weight: normal;
        text-decoration: none;
        cursor: pointer;
    }
    .pg-selected 
    {
        color: red;
        font-weight: bold;
        text-decoration: underline;
        cursor: pointer;
    }
    .class3
    { 
      A:link {text-decoration: none}
      A:visited {text-decoration: none}
      A:active {text-decoration: none}
      A:hover {font-size:30; font-weight:bold; color: red;}
    }
</style>
<script type="text/javascript">
function validate1()
{
  var str="";
  var i =0;
  for(var i=0;i<document.getElementsByName("strReqQty").length;i++)
  {
  if(str=="")
  str=document.getElementsByName("strReqQty")[i].value;
  else
  str= str+"^"+document.getElementsByName("strReqQty")[i].value;
  } 
  
  document.forms[0].strModifedQty.value = str;
  document.forms[0].hmode.value = "INSERT";
document.forms[0].submit();
}
</script>

	
</head>
<body>
<html:form name="indentViewBean" action="/transactions/IndentViewTransCNT" type="mms.transactions.controller.fb.IndentViewTransFB">
	
<center>
	<div id="errMsg" class="errMsg"><bean:write name="indentViewBean" property="strErr" /></div>
	<div id="warningMsg" class="warningMsg"><bean:write name="indentViewBean" property="strWarningMsg" /></div>
	<div id="normalMsg" class="normalMsg"><bean:write name="indentViewBean" property="strMsg" /></div>
	
</center>


<%-- Change Request --%>
<div class='popup' id='avalaibleBudgetDtlId' style="display: none">
	<table width='400' border="0" cellspacing="1" cellpadding="1">
		<tr class="HEADER">
			<td colspan='3'>Budget Details</td>
			<th align='right'><img style='cursor: pointer; '
				src='../../hisglobal/images/popUp_cancel.JPG' title='Click to Close Pop-Up'
				onClick="hideBalQtyDetails('avalaibleBudgetDtlId');">
			</th>
		</tr>
	</table>

	<table width='400' border="0" cellspacing="1" cellpadding="1">
		<tr>
			<td colspan="1" class='multiLabel'>Budget Allocated</td>
			<td colspan="1" class='multiLabel'>Budget Consumed</td>
		</tr>
		<tr>
			<td colspan="1" class='multiControl'>
				<div id='1'></div>
			</td>
			<td colspan="1" class='multiControl'>
				<div id='2'></div>
			</td>
		</tr>
	</table>
</div>
<%-- Change Request End --%>
        
    <tag:tab tabLabel="Indent Desk View" selectedTab="FIRST"
		align="center" width="TABLEWIDTH">
	</tag:tab>
              
	 <div class='popup' id='issueDtl' style="display:none">
		<table width='400' border="0" cellspacing ="0px">
			<tr class="HEADER"> 
				<th colspan='6' align='left'><div id='201' style='color: blue;'></div></th>
				<th align='right'><img  style='cursor:pointer;cursor:pointer' src='../../hisglobal/images/popUp_cancel.JPG' onClick="hideItemDetails('issueDtl');"></th>
		    </tr>
		</table>   
		<table width='400' bgcolor='#CC9966' border="0" cellspacing ="1px" cellpadding="1px">
			<tr>
				<td colspan="1" class='multiLabel'>Issue Qty.</td>
				<td colspan="1" class='multiLabel'>ReOrder Value</td>
				<td colspan="1" class='multiLabel'>Last Indent Qty</td>
				<td colspan="1" class='multiLabel'>Last Issue Qty</td>
			</tr>
			<tr>
				<td colspan="1" class='multiControl'><div id ='1'></div></td>
				<td colspan="1" class='multiControl'><div id ='2'></div></td>
				<td colspan="1" class='multiControl'><div id ='3'></div></td>
				<td colspan="1" class='multiControl'><div id ='4'></div></td>
			</tr>
			<tr class="FOOTER">
				<td colspan="4"></td>
			</tr>
	     </table>
		</div>  
   
	    <div class='popup' id='LpPatStaff' style="display:none">
			<table width='400' border="0" cellspacing ="0px">
				<tr class="HEADER"> 
					<th colspan='6' align='left'><div id='202' style='color: blue;'></div></th>
					<th align='right'><img  style='cursor:pointer;cursor:pointer' src='../../hisglobal/images/popUp_cancel.JPG' onClick="hideItemDetails('LpPatStaff');"></th>
			    </tr>
			 </table>   
			 <table width='400' bgcolor='#CC9966' border="0" cellspacing ="1px" cellpadding="1px">
				<tr>
					<td colspan="1" class='multiLabel'>Issue Qty.</td>
					<td colspan="1" class='multiLabel'>Return Qty</td>
							
				</tr>
				<tr>
					<td colspan="1" class='multiControl'><div id ='12'></div></td>
					<td colspan="1" class='multiControl'><div id ='13'></div></td>
				</tr>
				<tr class="FOOTER">
					<td colspan="2"></td>
				</tr>
		      </table>
		</div>  
   
	   <div class='popup' id='LpDept' style="display:none">
		<table width='400' border="0" cellspacing ="0px">
			<tr class="HEADER"> 
				<th colspan='6' align='left'><div id='203' style='color: blue;'></div></th>
				<th align='right'><img  style='cursor:pointer;cursor:pointer' src='../../hisglobal/images/popUp_cancel.JPG'
					onClick="hideItemDetails('LpDept');"></th>
		    </tr>
		 </table>   
		 <table width='400' bgcolor='#CC9966' border="0" cellspacing ="1px" cellpadding="1px">
			<tr>
				<td colspan="1" class='multiLabel'>Issue Qty.</td>
				<td colspan="1" class='multiLabel'>Last Rec Qty</td>
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
   
	   <div class='popup' id='IndentCondemnation' style="display:none">
		<table width='400' border="0" cellspacing ="0px">
			<tr class="HEADER"> 
				<th colspan='6' align='left'><div id='204' style='color: blue;'></div></th>
				<th align='right'><img  style='cursor:pointer;cursor:pointer' src='../../hisglobal/images/popUp_cancel.JPG'
					onClick="hideItemDetails('IndentCondemnation');"></th>
		    </tr>
		 </table>   
		 <table width='400' bgcolor='#CC9966' border="0" cellspacing ="1px" cellpadding="1px">
			
			<tr>
			   <td width='25%' class='multiLabel'>Last PO No</td>
			   <td width='25%' class='multiControl'><div id ='17'></div></td>
			   <td width='25%' class='multiLabel'>Last PO Date</td>
			   <td width='25%' class='multiControl'><div id ='18'></div></td>
			</tr>
			<tr>
			   <td width='25%' class='multiLabel'>Exp Date</td>
			   <td width='25%' class='multiControl'><div id ='19'></div></td>
			   <td width='25%' class='multiLabel'>Last Supply By</td>
			   <td width='25%' class='multiControl'><div id ='20'></div></td>	
			 </tr> 
			 <tr class="FOOTER">
				<td colspan="4"></td>
			</tr>
		 </table>
		</div>
	
		<div class='popup' id='IndentForImported' style="display:none">
		<table width='400' border="0" cellspacing ="0px">
			<tr class="HEADER"> 
				<th colspan='6' align='left'><div id='205' style='color: blue;'></div></th>
				<th align='right'><img  style='cursor:pointer;cursor:pointer' src='../../hisglobal/images/popUp_cancel.JPG'
					onClick="hideItemDetails('IndentForImported');"></th>
		    </tr>
		 </table>   
		 <table width='400' bgcolor='#CC9966' border="0" cellspacing ="1px" cellpadding="1px">
			
			<tr>
			   <td width='25%' class='multiLabel'>Last PO No</td>
			   <td width='25%' class='multiControl'><div id ='24'></div></td>
			   <td width='25%' class='multiLabel'>Last PO Date</td>
			   <td width='25%' class='multiControl'><div id ='25'></div></td>
			</tr>
			<tr>
			   <td width='25%' class='multiLabel'>Lst Recev Date</td>
			   <td width='25%' class='multiControl'><div id ='26'></div></td>
			   <td width='25%' class='multiLabel'>Manufact By</td>
			   <td width='25%' class='multiControl'><div id ='27'></div></td>	
			 </tr>  
			 <tr class="FOOTER">
				<td colspan="4"></td>
			</tr>
		 </table>
		</div>

	    <div class='popup' id='ReturnRequest' style="display:none">
		<table width='400' border="0" cellspacing ="0px">
			<tr class="HEADER"> 
				<th colspan='6' align='left'><div id='206' style='color: blue;'></div></th>
				<th align='right'><img  style='cursor:pointer;cursor:pointer' src='../../hisglobal/images/popUp_cancel.JPG'
					onClick="hideItemDetails('ReturnRequest');"></th>
		    </tr>
		 </table>   
		 <table width='400' bgcolor='#CC9966' border="0" cellspacing ="1px" cellpadding="1px">
			
			<tr>
			   <td width='25%' class='multiLabel'>Last PO No</td>
			   <td width='25%' class='multiControl'><div id ='21'></div></td>
			   <td width='25%' class='multiLabel'>Last PO Date</td>
			   <td width='25%' class='multiControl'><div id ='22'></div></td>
			</tr>
			<tr>
			   <td width='25%' class='multiLabel'>Exp Date</td>
			   <td width='25%' class='multiControl'><div id ='23'></div></td>
			   <td width='25%' colspan='2' class='multiLabel'></td>
			   
			 </tr>  
			<tr class="FOOTER">
				<td colspan="4"></td>
			</tr>
		 </table>
		</div>
   
	   <div class='popup' id='AnnualPurchase' style="display:none">
		<table width='400' border="0" cellspacing ="0px">
			<tr class="HEADER"> 
				<th colspan='6' align='left'><div id='207' style='color: blue;'></div></th>
				<th align='right'><img  style='cursor:pointer;cursor:pointer' src='../../hisglobal/images/popUp_cancel.JPG'
					onClick="hideItemDetails('AnnualPurchase');"></th>
		    </tr>
		 </table>   
		 <table width='400' bgcolor='#CC9966' border="0" cellspacing ="1px" cellpadding="1px">
			<tr>
			   <td width='25%' class='multiLabel'>Re-OrderLevel</td>
			   <td width='25%' class='multiControl'><div id ='5'></div></td>
			   <td width='25%' class='multiLabel'>Last Year Consumption</td>
			   <td width='25%' class='multiControl'><div id ='6'></div></td>
			</tr>
			<tr>
			   <td width='25%' class='multiLabel'>Last PO No</td>
			   <td width='25%' class='multiControl'><div id ='7'></div></td>
			   <td width='25%' class='multiLabel'>Last Po Date</td>
			   <td width='25%' class='multiControl'><div id ='8'></div></td>	
			 </tr>  
			 <tr>
			   <td width='25%' class='multiLabel'>Last Rec Qty</td>
			   <td width='25%' class='multiControl'><div id ='9'></div></td>
			   <td width='25%' class='multiLabel'>Last Rec Date</td>
			   <td width='25%' class='multiControl'><div id ='10'></div></td>	
			 </tr>  
			 <tr>
			   <td width='25%' class='multiLabel'>Last Supplied By</td>
			   <td colspan="3" class='multiControl'><div id ='11'></div></td>
			 </tr>  
			 <tr class="FOOTER">
				<td colspan="4"></td>
			</tr>
	      </table>
		</div>
 
	     <table class="TABLEWIDTH" align="center" cellspacing="1" cellpadding="1">   
		 <tr class="HEADER">
			<td colspan="4"><b><bean:write name="indentViewBean" property="strRequestName" filter="false"/></b></td>
		 </tr>
		 </table>
		 <table class="TABLEWIDTH" align="center" cellspacing="1" cellpadding="1">   
		      <bean:write name="indentViewBean" property="strIndentDetails"	filter="false" />
		</table>
		
		<logic:equal   value="1" name="indentViewBean" 	property="strBudgetRequired">
<%--	Change Request	--%>
	     <table class="TABLEWIDTH" align="center" cellspacing="1" cellpadding="1">
		     <logic:present name="indentViewBean" property="strAvalaibleBudget" > 
		       	<tr>
				<td class="LABEL"  colspan="1">Budget Available</td>
				<td class="CONTROL" colspan="3">
				
	       	    
	       	    <a STYLE='cursor:pointer;cursor:pointer;color:blue'  onClick='avlBudgetDtl(this);' TITLE='Click Here Get Budget Details' ><bean:write name="indentViewBean" property="strAvalaibleBudget" /></a>
	       	    
	       				      			
				</td>
				</tr>	
				</logic:present>		
		     </table>   
	     </logic:equal>
<%--	Change Request End	--%>
		
		
		
	<table class="TABLEWIDTH" align="center" cellspacing="1" cellpadding="1">   
		<tr class="TITLE">
			<td colspan="4"><div id='' style='font-family: Arial, Helvetica, sans-serif;font-size:13px;'>Item Details</div></td>
		</tr>
	</table>
	<table class="TABLEWIDTH" align="center" cellspacing="1" cellpadding="1"> 
		<bean:write name="indentViewBean" property="strSetItemDetails"	filter="false" />
	</table>

	<table class="TABLEWIDTH" align="center">
	  <tr id="saveId">
		<td align="center">
			<img style="cursor: pointer; " title="Click to Save Record" src="../../hisglobal/images/btn-sv.png" onClick=" return validate1();" /> 
			<img style="cursor: pointer; " title="Click to Return Main Menu" src="../../hisglobal/images/btn-ccl.png" onClick="cancelToDesk();" />
		</td>
	  </tr>
	</table>
	
	<input type="hidden" name="hmode"/>
	<input type="hidden" name="strPath" value="${indentViewBean.strPath}">
	<input type="hidden" name="strAvalaibleBudgetDtl" value="${indentViewBean.strAvalaibleBudgetDtl}">
	<input type="hidden" name="strAvalaibleBudget" value="${indentViewBean.strAvalaibleBudget}">
	<input type="hidden" name="strRemainingBudget" value="${indentViewBean.strRemainingBudget}">
	
	<cmbPers:cmbPers/>
	</html:form>
		<tag:autoIndex></tag:autoIndex>   
</body>
