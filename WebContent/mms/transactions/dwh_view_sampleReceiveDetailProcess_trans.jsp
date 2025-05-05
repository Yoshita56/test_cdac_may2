<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>	
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<%@taglib uri="/WEB-INF/dateTag.tld" prefix="dateTag"%>
<%@ taglib uri="/WEB-INF/hisTab.tld" prefix="tag"%>



<html>
<head>
<meta charset=UTF-8">
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
            </style>
<title>Sample receive Details</title>
<link href="../css/transaction.css" rel="stylesheet" type="text/css">
<link href="../../hisglobal/css/tab.css" rel="stylesheet" type="text/css">
<link href="../../hisglobal/css/calendar-tas.css" rel="stylesheet" type="text/css">

<link href="../../hisglobal/css/popup.css" rel="stylesheet" type="text/css">	
<link href="../../hisglobal/css/newpopup.css" rel="stylesheet" type="text/css">

<link href="../../hisglobal/css/popup.css" rel="stylesheet" type="text/css">	

<script language="Javascript" src="../../hisglobal/js/newpopup.js"></script>
<script language="Javascript" src="../../hisglobal/js/popup.js"></script>	
<script type="text/javascript" src="../../hisglobal/js/calendar.js"></script>
<script language="Javascript" src="../../hisglobal/js/datepicker1.js"></script>
<script language="JavaScript" src="../../hisglobal/js/tab.js"></script>
<script language="JavaScript" src="../../hisglobal/masterutil/js/master.js"></script>
<script language="JavaScript" src="../../hisglobal/js/validation.js"></script>
<script language="Javascript" src="../../hisglobal/js/util.js"></script>
<script language="Javascript" src="../../hisglobal/js/multirow.js"></script>
<script language="JavaScript" src="../js/dwh_main_sampleReceiveDetailProcess_trans.js"></script>
<script language="JavaScript">

function hideDrugDetails(divId) 
{
	hide_popup_menu(divId);
}


</script>

</head>
<body >
<html:form name="sampleReceiveDetailProcessTransFB" action="/transactions/SampleReceiveDetailProcessTransCNT.cnt" type="mms.transactions.controller.fb.sampleReceiveDetailProcessTransFB">
	<div id="errMsg" class="errMsg"><bean:write name="sampleReceiveDetailProcessTransFB" property="strErrMsg" /></div>
	<div id="warningMsg" class="warningMsg"><bean:write name="sampleReceiveDetailProcessTransFB" property="strWarningMsg" /></div>
	<div id="normalMsg" class="normalMsg"><bean:write name="sampleReceiveDetailProcessTransFB" property="strNormalMsg" /></div>
	
	
	<div class='popup' id='drugDtlId' style="display: none">
		<table width='400' border="0" cellspacing="1" cellpadding="1">
			<tr class="HEADER">
				<td colspan='3'>Details</td>
	
				<th align='right'><img style='cursor: pointer; '
					src='../../hisglobal/images/popUp_cancel.JPG' title='Click to Close Pop-Up'
					onClick="hideDrugDetails('drugDtlId');"></th>
			</tr>
		</table>


		<table width='400' border="0" cellspacing="1" cellpadding="1">
	
			<tr>
				<td colspan="1" class='multiRPTLabel'>PO No.</td>
				<td colspan="1" class='multiRPTLabel'>PO Date</td>
	
			</tr>
			<tr>
				<td colspan="1" class='multiPOControl'>
				<div id='1'></div>
				</td>
				<td colspan="1" class='multiPOControl'>
				<div id='2'></div>
				</td>
	
			</tr>
			<tr>
				<td colspan="1" class='multiRPTLabel'>Exp. Date</td>
				<td colspan="1" class='multiRPTLabel'>Manuf.Date</td>
	
			</tr>
			<tr>
				<td colspan="1" class='multiPOControl'>
				<div id='3'></div>
				</td>
				<td colspan="1" class='multiPOControl'>
				<div id='4'></div>
				</td>
	
			</tr>
			<tr>
				<td colspan="2" class='multiRPTLabel'>Whether Re-Issued</td>
				
	
			</tr>
			<tr>
				<td colspan="2" class='multiPOControl'>
				<div id='5'></div>
				</td>
				
	
			</tr>
		</table>
	</div>
<%-- Change Request End --%>
	
	
	<tag:tab tabLabel="Sample Receive Details" selectedTab="FIRST" align="center" width="TABLEWIDTH">
    </tag:tab>
              
              <table class="TABLEWIDTH" align="center" cellspacing="1px">   
	   	
	   		   	
		<tr class="HEADER">
			<td colspan="3" style="width: 760px"></td>
		</tr>
				
	    </table>
              
              
	<table class="TABLEWIDTH" align="center" cellpadding="1px" cellspacing="1px">   
	     
	     <tr>
			<td width="25%" class="LABEL">
			<font color="red">*</font>HQ Name
			</td>
			<td width="25%" class="CONTROL">
					<html:select name="sampleReceiveDetailProcessTransFB" property="strDrugWareHouseId" styleClass="comboMax" onchange="itemCategoryCombo1();"   >
	                 <bean:write name="sampleReceiveDetailProcessTransFB" property="strDrugWareHouseNameCmb" filter="false"/>
					</html:select>
			</td>
			
			<td  width="25%" class="LABEL">
			<font color="red">*</font>Category
			</td>
			<td width="25%" class="CONTROL">
				<div id="itemCategoryId"><select name="strItemCategoryNo" class='comboNormal' >
							<bean:write name="sampleReceiveDetailProcessTransFB" property="strItemCatNoCmb"filter="false" />
							<option value="0">Select Value</option>
					</select></div>
			</td>			
	   </tr>
	   
	   <tr>
			<td class="LABEL" colspan="1"><font color="red">*</font>From Date</td>
			<td class="CONTROL" colspan="1"><dateTag:date name="strFromDate" value="${sampleReceiveDetailProcessTransFB.strCurrentDate}" /></td>
			<td class="LABEL" colspan="1"><font color="red">*</font>To Date</td>
			<td class="CONTROL" colspan="1"><dateTag:date name="strToDate" value="${sampleReceiveDetailProcessTransFB.strCurrentDate}" /></td>
		</tr>
	   
	   <tr>
		  
		  <td class="CONTROL" colspan="4"><div id='id' align='center'><img style="cursor: pointer" src="../../hisglobal/images/btn-generate.png" onClick="genrateSampleReceiveDtlViewHlp();" /></div></td>
		</tr>		
		
	   </table>
	   	<div id="sampleReceiveDtlViewHlpDivId"></div>
	    <table border="0" class="TABLEWIDTH" align="center" cellspacing="1px" cellpadding="1px">

			<tr class="FOOTER">
				 <td colspan="4"><font color='red'>*</font>Mandatory Field </td>
			</tr>
		</table>
	<div id="showButtonID" style="display:block;"> 
	<table border="0" class="TABLEWIDTH" align="center" cellspacing="1px" cellpadding="1px">
		<tr>

			<td align="center">
			<img style="cursor: pointer" src="../../hisglobal/images/print_tab.gif" onClick="genrateSampleReceiveDtlViewPrintHlp();" />
			<img style="cursor: pointer" src="../../hisglobal/images/btn-clr.png" onClick="pageResetMethod(2);" >
			<img style="cursor: pointer" src="../../hisglobal/images/btn-ccl.png" onClick ="controlToMainPage();" >
			</td>
			
		</tr>
	</table>
</div>

	
	
	
<input type="hidden" name="hmode"/>

<input type="hidden" name="strSDrugWareHouseName" value=""/>
<input type="hidden" name="strItemCategoryName" value=""/>
<!-- <input type="hidden" name="strItemCategoryNo" value=""/> -->
<!-- <input type="hidden" name="strInstituteName" value=""/> 
<input type="hidden" name="strStatus" value=""/>-->

<div id="blanket" style="display:none;"></div>
   <div class="popUpDiv" id="popUpDiv1" style="display:none;">
   <table bgcolor="white">
     <tr>
      <td>
           <div id="sampleReceiveDtlViewPrintHlpDivId" style="display:block;"></div>
           
       </td>
     </tr>
    </table>
</div>

</html:form>
	<tag:autoIndex></tag:autoIndex>   
</body>
</html>