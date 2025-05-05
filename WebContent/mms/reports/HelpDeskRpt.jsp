<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<%@taglib uri="/WEB-INF/dateTag.tld" prefix="dateTag"%>
<%@ taglib uri="/WEB-INF/hisTab.tld" prefix="tag"%>


<html>
<head>
<style type="text/css">

            .pg-normal 
            {
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
            .pg-qualified 
            {
                color: green;
                font-weight: bold;
                text-decoration: underline;
                cursor: pointer;
                
            }
            div.ex
			{
			width:190px;
			padding:8px;
			border:2px solid gray;
			margin:0px;
			}
            
            </style>
<title>Help Desk Report</title>
<link href="../css/master.css" rel="stylesheet" type="text/css">
<link href="../../hisglobal/css/tab.css" rel="stylesheet" type="text/css">
<link href="../../hisglobal/css/calendar-tas.css" rel="stylesheet" type="text/css">
<link href="../../hisglobal/css/popup.css" rel="stylesheet" type="text/css">	
<link href="../../hisglobal/css/newpopup.css" rel="stylesheet" type="text/css">

<link href="../../hisglobal/css/popup.css" rel="stylesheet" type="text/css">	
	


<script language="Javascript" src="../../hisglobal/js/newpopup.js"></script>
<script language="Javascript" src="../../hisglobal/js/popup.js"></script>
	
<script language="JavaScript" src="../../masterutil/js/master.js"></script>
<script language="JavaScript" src="../../hisglobal/js/tab.js"></script>
<script language="JavaScript" src="../../hisglobal/js/calendar.js"></script>
<script language="Javascript" src="../../hisglobal/js/validation.js"></script>
<script language="Javascript" src="../../hisglobal/js/util.js"></script>
<script language="Javascript" src="../../hisglobal/js/commonFunctions.js"></script>
<script language="Javascript" src="../../hisglobal/js/time.js"></script>

<script language="Javascript" src="../../mms/js/HelpDeskRpt.js"></script>


</head>
<body onload="onLoadPage();">
<html:form action="/reports/HelpDeskRptCNT" method="post">
	
<div class="errMsg" id="errMsg"><bean:write name="HelpDeskRptFB" property="strErrMsg"/></div>
<div class="normalMsg" id="normalMsg"><bean:write name="HelpDeskRptFB" property="strNormalMsg"/></div>
<div class="warningMsg" id="warningMsg"><bean:write name="HelpDeskRptFB" property="strWarningMsg"/></div>


	<tag:tab tabLabel="Help Desk Report" selectedTab="FIRST" align="center" width="TABLEWIDTH"></tag:tab>

	<table class="TABLEWIDTH" align="center" cellspacing="1px" cellpadding="1px" >   
	<tr class="HEADER">
			<td colspan="4"></td>
			
	</tr>
	</table>
			
	
	
	
	<table class="TABLEWIDTH" align="center" cellspacing="1px" cellpadding="1px" >
		
		<tr>
			<td width="25%" colspan="1" class="LABEL">DDW Name</td>
			<td width="25%" colspan="1" class="CONTROL">
			<div id="strStoreDivId" >
				<select name="strStoreId" class="comboMax" >
					<bean:write name="HelpDeskRptFB" property="strManufactureCombo" filter="false"/>
				</select>
			</div>				
			</td>
		
		
			<td width="25%" colspan="1" class="LABEL">Department</td>
			<td width="25%" colspan="1" class="CONTROL">
			<div id="strDeptDivId" >
				<select name="strDeptId" class="comboMax" onclick="getMenuCmb();" >
					<bean:write name="HelpDeskRptFB" property="strDeptcmb" filter="false"/>
				</select>
			</div>				
			</td>
		</tr>
		</table>		
			
			
			<div id="MenuDiv" style="display:none;">
		<table class="TABLEWIDTH" align="center" cellspacing="1px" cellpadding="1px" >
		<tr>
			<td width="50%" colspan="2" class="LABEL">Menu Name</td>
			<td width="50%" colspan="2" class="CONTROL">
			<div id="strMenuDivId" >
				<select name="strMenuId" class="comboMax" >
					<bean:write name="HelpDeskRptFB" property="strMenuCmb" filter="false"/>
				</select>
			</div>				
			</td>
		</tr>
		</table>	
		</div>
		
		<table class="TABLEWIDTH" align="center" cellspacing="1px" cellpadding="1px" >		
		
		<tr>
			<td width="50%" colspan="2" class="LABEL">Status</td>
			<td width="50%" colspan="2" class="CONTROL">
			<div id="strStatusDivId" >
				<select name="strStatus" class="comboMax" >
					<bean:write name="HelpDeskRptFB" property="strStatuscmb" filter="false"/>
				</select>
			</div>				
			</td>
		</tr>		
	
		
		
     </table>
	<table border="0" class="TABLEWIDTH" align="center" cellspacing="1px" cellpadding="1px">

 
         <tr>
			<td class="LABEL" colspan="1"><font color="red">*</font>From Date</td>
			<td class="CONTROL" colspan="1"><dateTag:date name="strFromDate" value="${HelpDeskRptFB.strCurrentDate}" /></td>
			<td class="LABEL" colspan="1"><font color="red">*</font>To Date</td>
			<td class="CONTROL" colspan="1"><dateTag:date name="strToDate" value="${HelpDeskRptFB.strCurrentDate}" /></td>
		</tr>
		<tr>
		  
		  <td class="CONTROL" colspan="4"><div id='id' align='center'><img style="cursor: pointer" src="../../hisglobal/images/btn-generate.png" onClick="genrateHelpDeskHlp();" /></div></td>
		</tr>		
		

		
		
		
		
	</table>
	
	
	
	<div id="consolidatedPODetailDIV"></div> 
	
	
	<div id="consolidatedChallanDetailDIV"></div> 
	 
	<table border="0" class="TABLEWIDTH" align="center" cellspacing="1px" cellpadding="1px">
	
	<tr class="FOOTER">
			 <td colspan="4"><font color='red'>*</font>Mandatory Field </td>
		</tr>
		</table>
<div id="showButtonID" style="display:none;"> 
	<table border="0" class="TABLEWIDTH" align="center" cellspacing="1px" cellpadding="1px">
		<tr>

			<td align="center">
			<img style="cursor: pointer" src="../../hisglobal/images/print_tab.gif" onClick="getScreenTwoPrint();" />
			<img style="cursor: pointer" src="../../hisglobal/images/btn-clr.png" onClick="resetPage();" >
			<img style="cursor: pointer" src="../../hisglobal/images/btn-ccl.png" onClick="cancelPage();" >
			</td>
			
		</tr>
	</table>
</div>
	  

	
<input type="hidden" name="hmode"/>

<input type="hidden" name="strCurrentDate" value="${HelpDeskRptFB.strCurrentDate}"/>



<input type="hidden" name="strDateTypeFlg"  value="1"/>

<input type="hidden" name="strDiv1" value="0" />
<input type="hidden" name="strDiv2" value="0" />
<input type="hidden" name="strDiv3" value="0" />
<input type="hidden" name="strCurrDiv" value="0" />

<div class="popup" id="issueDtlsDivId" style="display: none">
	<table width='400' cellpadding="0" cellspacing="0">
		<tr class='HEADER'>
			<td colspan='4' align="left">
			<div id='issuedesctitleDivId'></div>
			</td>
			<td   align="right"><img
				src="../../hisglobal/images/popUp_cancel.JPG"
				style=" cursor: pointer" align="middle"
				onclick="hide_popup_menu('issueDtlsDivId');"></td>
		</tr>
	</table>
	<table width='400' cellpadding="1px" cellspacing="1px">
		<tr>
			<td width="400%" align = "left" class = "LABEL">Issue Description</td>
			
			
		</tr>
		<tr>
			
			<td width="400%" align = "left" class="CONTROL">
			<div id='issuedescDivId'></div>
			</td>
		</tr>
	</table>
	<table width='400' cellpadding="0" cellspacing="0">
		<tr class="FOOTER">
			<td></td>
		</tr>
	</table>
	</div>
	
	<div class="popup" id="StatusOpenDtlsDivId" style="display: none">
	<table width='400' cellpadding="0" cellspacing="0">
		<tr class='HEADER'>
			<td colspan='1' align="left">
			<div id='StatusdesctitleDivId'></div>
			</td>
			<td   align="right"><img
				src="../../hisglobal/images/popUp_cancel.JPG"
				style=" cursor: pointer" align="middle"
				onclick="hide_popup_menu('StatusOpenDtlsDivId');"></td>
		</tr>
	</table>
	<table width='400' cellpadding="1px" cellspacing="1px">
		<tr>
			
			<td width="100%" align = "left" class="CONTROL">
			<div id='StatusOpendescDivId'></div>
			</td>
		</tr>
	</table>
	<table width='400' cellpadding="0" cellspacing="0">
		<tr class="FOOTER">
			<td></td>
		</tr>
	</table>
	</div>
	
	<div class="popup" id="StatusResolvedDtlsDivId" style="display: none">
	<table width='400' cellpadding="0" cellspacing="0">
		<tr class='HEADER'>
			<td colspan='2' align="left">
			<div id='StatusdesctitleDivId'></div>
			</td>
			<td   align="right"><img
				src="../../hisglobal/images/popUp_cancel.JPG"
				style=" cursor: pointer" align="middle"
				onclick="hide_popup_menu('StatusResolvedDtlsDivId');"></td>
		</tr>
	</table>
	<table width='400' cellpadding="1px" cellspacing="1px">
		<tr>
			<td width="90%" align = "left" class = "LABEL">Solution</td>
			<td width="10%" align = "left" class = "LABEL">Solution Date</td>
			
		</tr>
		<tr>
			
			<td width="90%" align = "left" class="CONTROL">
			<div id='StatusSoldescDivId'></div>
			</td>
			<td width="10%" align = "left" class="CONTROL">
			<div id='StatusSolDatedescDivId'></div>
			</td>
		</tr>
	</table>
	<table width='400' cellpadding="0" cellspacing="0">
		<tr class="FOOTER">
			<td></td>
		</tr>
	</table>
	</div>
	
	<div class="popup" id="StatusRejectedDtlsDivId" style="display: none">
	<table width='400' cellpadding="0" cellspacing="0">
		<tr class='HEADER'>
			<td colspan='2' align="left">
			<div id='StatusdesctitleDivId'></div>
			</td>
			<td   align="right"><img
				src="../../hisglobal/images/popUp_cancel.JPG"
				style=" cursor: pointer" align="middle"
				onclick="hide_popup_menu('StatusRejectedDtlsDivId');"></td>
		</tr>
	</table>
	<table width='400' cellpadding="1px" cellspacing="1px">
		<tr>
			<td width="90%" align = "left" class = "LABEL">Remarks</td>
			<td width="10%" align = "left" class = "LABEL">Rejected Date</td>
			
		</tr>
		<tr>
			
			<td width="90%" align = "left" class="CONTROL">
			<div id='StatusRemarksdescDivId'></div>
			</td>
			<td width="10%" align = "left" class="CONTROL">
			<div id='StatusRejectedDateDivId'></div>
			</td>
		</tr>
	</table>
	<table width='400' cellpadding="0" cellspacing="0">
		<tr class="FOOTER">
			<td></td>
		</tr>
	</table>
	</div>

<div id="blanket" style="display:none;"></div>
   <div class="popUpDiv" id="popUpDiv1" style="display:none;">
   <table bgcolor="white">
     <tr>
      <td>
           <div id="supplierPoDtlsDivId" style="display:block;"></div> 
           
       </td>
     </tr>
    </table>
   </div>
   
   
   
   <div id="blanket" style="display:none;"></div>
   <div class="popUpDiv" id="popUpDiv2" style="display:none;">
   <table bgcolor="white">
     <tr>
      <td>
         
           <div id="poChallanDtlsDivId" style="display:block;"></div>
       </td>
     </tr>
    </table>
   </div>
   
    <div id="blanket" style="display:none;"></div>
   <div class="popUpDiv" id="popUpDiv3" style="display:none;">
   <table bgcolor="white">
     <tr>
      <td>
         
           <div id="poChallanItemDtlsDivId" style="display:block;"></div>
       </td>
     </tr>
    </table>
   </div>
  <div id="blanket" style="display:none;"></div>
   <div class="popUpDiv" id="popUpDiv4" style="display:none;">
   <table bgcolor="white">
     <tr>
      <td>
         
           <div id="suppliedPOPrintDtlsDivId" style="display:block;"></div>
       </td>
     </tr>
    </table>
   </div>


</html:form>
<tag:autoIndex></tag:autoIndex>
</body>
</html>