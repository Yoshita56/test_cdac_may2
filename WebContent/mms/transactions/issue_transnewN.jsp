<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic"%>
<%@ taglib uri="/WEB-INF/dateTag.tld" prefix="dateTag"%>
<%@ taglib uri="/WEB-INF/hisTab.tld" prefix="tag"%>

<%@ taglib uri="/WEB-INF/crNo.tld" prefix="crNo"%>


<html>
<head>
<meta charset=UTF-8">
<title>Issue Process</title>


<link href="../../hisglobal/bootstrap4.0_newgui/css/bootstrap.css" rel="stylesheet" />
<link href="../../hisglobal/bootstrap4.0_newgui/css/bootstrap-theme.css" rel="stylesheet" />
<link href="../../hisglobal/bootstrap4.0_newgui/datatable/css/dataTables.bootstrap.css"   rel="stylesheet" />
<link href="../../hisglobal/bootstrap4.0_newgui/font-awesome/css/all.css" rel="stylesheet">
<link href="../../hisglobal/bootstrap4.0_newgui/swAl/swal.css" rel="stylesheet">
<link href="../../ipd/css/newlayout.css" rel="stylesheet" type="text/css">
<link href="../../hisglobal/bootstrap4.0_newgui/datetimepicker/css/gijgo.min.css" rel="stylesheet" type="text/css">
	
<script type="text/javascript" src="../../hisglobal/bootstrap4.0_newgui/swAl/swal.js"></script>
<script type="text/javascript" src="../../hisglobal/jquery/3.6.0.min.js"></script>
<script type="text/javascript" src="../../hisglobal/bootstrap4.0_newgui/datatable/js/jquery.dataTables.js"></script>
<script type="text/javascript" src="../../hisglobal/bootstrap4.0_newgui/js/bootstrap.min.js"></script>
<script type="text/javascript" src="../../hisglobal/bootstrap4.0_newgui/datatable/js/dataTables.bootstrap4.js"></script>
<script type="text/javascript" src="../../hisglobal/bootstrap4.0_newgui/datetimepicker/js/gijgo.min.js"></script>


<link href="../css/master.css" rel="stylesheet" type="text/css">
<link href="../../hisglobal/css/tab.css" rel="stylesheet" type="text/css">
<link href="../../hisglobal/css/calendar-tas.css" rel="stylesheet" type="text/css">
<link href="../../hisglobal/css/popup.css" rel="stylesheet" type="text/css">
<link href="../../hisglobal/css/newpopup.css" rel="stylesheet" type="text/css">
<link href="../../hisglobal/css/buttons.css" rel="stylesheet" type="text/css">
<script language="JavaScript" src="../../hisglobal/masterutil/js/master.js"></script>
<script language="JavaScript" src="../../hisglobal/js/tab.js"></script>
<script language="JavaScript" src="../../hisglobal/js/calendar.js"></script>
<script language="Javascript" src="../../hisglobal/js/validation.js"></script>
<script language="Javascript" src="../../hisglobal/js/util.js"></script>
<script language="Javascript" src="../../hisglobal/js/popup.js"></script>
<script language="Javascript" src="../../hisglobal/js/newpopup.js"></script>
<script language="Javascript" src="../js/issue_trans.js"></script>
<script language="Javascript" src="../js/issueDetails_util.js"></script>
<script language="Javascript" src="../../hisglobal/js/validationCommon.js"></script>
<script type="text/javascript">
function setvalue()
{
	//document.forms[0].strStoreId.disabled=false;

	//var store=document.forms[0].strId.value;
	//document.forms[0].strStoreId.value=store;
	
	
	
}
</script>
<style>
        .example {
            page-break-after: always;
        }
    </style>
</head>
<body  onLoad="getReport();">

<html:form name="issueBean" action="/transactions/IssueTransBSCNT"
	type="mms.transactions.controller.fb.IssueTransFB">
	
<fieldset>
	<legend class='legendHeader' id='nonPrintableLegend'>Issue To Patient</legend>
	<div class="legend2" id="saveId">
	
	<button id="cancelButton" type="button" class="btn btn-outline-danger mt-1 btn-circle cancelbtn" onclick="cancelIssue();">
		<div class="popupToast"><i class="fa fa-ban iround"  title="Cancel"></i><span class="popuptextToast">Cancel</span></div>
		</button>	
		<button type="button" class=" btn btn-secondary btn-circle" onclick="clearIssue();" style="background: #b9b9b9; border-color:#b9b9b9;margin-top: 0.25rem !important;">
		<img  src="/HIS/hisglobal/images/clear3.png" title="Clear" style="width: 23px; color: #fff;">
		</button>	
													                 
  </div>
	<div id="errMsg" class="errMsg"><bean:write name="issueBean" property="strErrMsg" /></div>
	<div id="warningMsg" class="warningMsg"><bean:write name="issueBean" property="strWarningMsg" /></div>
	<div id="normalMsg" class="normalMsg"><bean:write name="issueBean" property="strNormalMsg" /></div>
<div class="prescriptionTile">

	<logic:equal value="0" name="issueBean" property="strMode" >
	<%-- <table class="TABLEWIDTH" align="center" border="0" cellspacing ="1px">
		<tr class="HEADER"> 
			 <td colspan="4">Issue To Patient&gt;&gt;</td>
	
	Change Request		
	
			 <td align="right" >
			 	<span>
			     	<!--<html:checkbox property="strWithoutCrNoCheckBox" name="issueBean" value="1" onclick="goToWithoutCrNoPage();">Without CR No.</html:checkbox>-->
		     	  <html:checkbox property="strCancelCheckBox"      name="issueBean" value="1" onclick="goToCancelPage();"      >Cancel Issue</html:checkbox> 
		     	  <div style="display: none;">  <html:checkbox name="issueBean" property="strViewChk" onclick="transferToViewPage();" title="Click Here To View Off Line Issue Drug Detail">Issue/View</html:checkbox></div>
		     	</span>		 
		    </td>
	    </tr>
    </table> --%>
	</logic:equal>
	
	<logic:equal value="1" name="issueBean" property="strMode" >
	<tag:tab tabLabel="Issue To Staff" selectedTab="FIRST" align="center"
		width="TABLEWIDTH">
	</tag:tab>
	<table class="TABLEWIDTH" align="center" border="0" cellspacing ="1px">
	<tr class="HEADER"> 
	 <td colspan="1">Issue To Staff&gt;&gt;</td>
	  	 <td align="right" colspan="3">
		 	<span>
		     	<%--<html:checkbox property="strWithoutCrNoCheckBox" name="issueBean" value="1" onclick="goToWithoutCrNoPage();">Without CR No.</html:checkbox>--%>
		    <%-- 	<html:checkbox property="strCancelCheckBox"      name="issueBean" value="1" onclick="goToCancelPage();"      >Cancel Issue</html:checkbox>  --%>
		     	<html:checkbox name="issueBean" property="strViewChk" onclick="transferToViewPage();" title="Click Here To View Off Line Issue Drug Detail">View</html:checkbox>
	     	</span>		 
	    </td>
    </tr>
    </table>
	</logic:equal>
	
	
	<logic:equal value="2" name="issueBean" property="strMode" >
	<tag:tab tabLabel="Issue To Patient/Staff" selectedTab="FIRST" align="center"
		width="TABLEWIDTH">
	</tag:tab>
	<table class="TABLEWIDTH" align="center" border="0" cellspacing ="1px">
	<tr class="HEADER"> 
	 <td colspan="4">Issue To Patient/Staffi&gt;&gt;</td>
	 	
	 	 <td align="right" >
		 	<span>
		     	<!--<html:checkbox property="strWithoutCrNoCheckBox" name="issueBean" value="1" onclick="goToWithoutCrNoPage();">Without CR No.</html:checkbox>-->
		     <%--	<html:checkbox property="strCancelCheckBox"      name="issueBean" value="1" onclick="goToCancelPage();"      >Cancel Issue</html:checkbox>   --%>
		     	<html:checkbox name="issueBean" property="strViewChk" onclick="transferToViewPage();" title="Click Here To View Off Line Issue Drug Detail">View</html:checkbox>
	     	</span>		 
	    </td>
	 
    </tr>
    	
    </table>
	</logic:equal>
	<div class='row' style='display: none;'>
	<div class='col-sm-9'></div>
	<div class='col-sm-3' align="right">
	<html:radio property="strCRorLFwise" name="issueBean" value="1" onclick="IsCrOrLFWise('1');">&nbsp;CR No. wise</html:radio>
	<html:radio property="strCRorLFwise" name="issueBean" value="2" onclick="IsCrOrLFWise('2');">&nbsp;LF No. wise</html:radio>
 	</div>	
	</div>
	
	
	
	
	 <table class="TABLEWIDTH" align="center" cellpadding="1" cellspacing="1">
		<%-- <tr>
		<td class="LABEL" colspan="4">
		<html:radio property="strCRorLFwise" name="issueBean" value="1" onclick="IsCrOrLFWise('1');">CR No. wise</html:radio>
		<html:radio property="strCRorLFwise" name="issueBean" value="2" onclick="IsCrOrLFWise('2');">LF No. wise</html:radio></td>
		</tr>
		 --%>
		<tr style="display: none;">
			<td width="25%" colspan="1" class="LABEL"><font color="red">*</font>Store Name</td>
			<td width="25%" colspan="1" class="CONTROL">
				<select name="strStoreId" class="comboMax" disabled>
					<option value="0">Select Value</option>
					<bean:write name="issueBean" property="strStoreValues"
						filter="false" />
				</select>
			</td></tr>
		<%-- 	<tr>
			<td width="25%" colspan="1" class="LABEL" style='background-color: #E0EBEB00;'><font color="red">*</font><label>Category</label></td>
			<td width="25%" colspan="1">
				<div id="itemcatDivId">
					<select	name="strItemCat" class="form-control" >
					<bean:write name="issueBean" property="strCatValues" filter="false" />
				</select>
				</div>
			</td>			
		 
	
    <td width="25%" class="LABEL" style='background-color: #E0EBEB00;' id="CrNOOrLf"><font color="red">*</font><label>CR No.</label></td>
    <td colspan="1" style="display:block"><div id="CRWise">
     <crNo:crNo value ="${issueBean.strCrNo}" js=" onkeypress='return initGoFunc(event);'"></crNo:crNo>
   <!--  <input type="text" name="strCrNo" value ="${issueBean.strCrNo}" js=" onkeypress='return initGoFunc(event);'"/>   -->
    <input type="image" style="cursor:pointer;cursor:pointer;margin-top: 3px;" title="Issue Process" 
		    align="top" src ="../../hisglobal/images/Go.png" name="go" value="Go" 
		    onclick="return onGoButton();" onkeyup="goFuncOnEnter(event);">  
			<!-- <a href="#" class="buttonGo" id="go" onclick="return onGoButton();" onkeyup="goFuncOnEnter(event);"></a> -->
		</div>
		
		<div id="LFWise" class="LABEL" style='display:none; background-color: #E0EBEB00;'> 
    <input type="text" class='form-control' name="strLFNo" value ="${issueBean.strLFNo}" js=" onkeypress='return initGoFunc(event);'"/>
   <input type="image" style="cursor:pointer;cursor:pointer;margin-top: 3px;" title="Issue Process" 
		    align="top" src ="../../hisglobal/images/Go.png" name="go" value="Go" 
		    onclick="return onGoButton();" onkeyup="goFuncOnEnter(event);">   
		    <!-- <a href="#" class="buttonGo" id="go" onclick="return onGoButton();" onkeyup="goFuncOnEnter(event);"></a> -->
		    </div>   
  </td>
  
  
  </tr> --%>
	</table>  
<div class='row'>
<div class='col-sm-2'></div>
<div class='col-sm-2'><font color="red">*</font><label>Category</label></div>
<div class='col-sm-2'id="itemcatDivId">
<select	name="strItemCat" class="form-control" >
<bean:write name="issueBean" property="strCatValues" filter="false" />
</select>
</div>
<div class='col-sm-6'>
<div class='row'>
<div class='col-sm-3' id="CrNOOrLf"><font color="red">*</font><label>CR No.</label>
</div>
<div class='col-sm-9'>
<div class='row' id="CRWise">
<div class='col-sm-8'>
     <crNo:crNo value ="${issueBean.strCrNo}" js=" onkeypress='return initGoFunc(event);'"></crNo:crNo>
     </div>
     <div class='col-sm-4'>
   <!--  <input type="text" name="strCrNo" value ="${issueBean.strCrNo}" js=" onkeypress='return initGoFunc(event);'"/>   -->
  <!--   <input type="image" style="cursor:pointer;cursor:pointer;margin-top: 3px;" title="Issue Process" 
		    align="top" src ="../../hisglobal/images/Go.png" name="go" value="Go" 
		    onclick="return onGoButton();" onkeyup="goFuncOnEnter(event);">  
			<a href="#" class="buttonGo" id="go" onclick="return onGoButton();" onkeyup="goFuncOnEnter(event);"></a>
		-->
		<button type="button" class="btn btn-info btn-sm" title="Issue Process" onclick="return onGoButton();" onkeyup="goFuncOnEnter(event);">GO</button>
		</div>
		</div>
		
		  


</div>
 <div class='col-sm-6' id="LFWise" style='display:none; background-color: #E0EBEB00;'>
<div class="row">
<div class='col-sm-8'>
<input type="text" class='form-control' name="strLFNo" value ="${issueBean.strLFNo}" js=" onkeypress='return initGoFunc(event);'"/>
</div>
<div class='col-sm-4'>
   <input type="image" style="cursor:pointer;cursor:pointer;margin-top: 3px;" title="Issue Process" 
		    align="top" src ="../../hisglobal/images/Go.png" name="go" value="Go" 
		    onclick="return onGoButton();" onkeyup="goFuncOnEnter(event);">   
		    <!-- <a href="#" class="buttonGo" id="go" onclick="return onGoButton();" onkeyup="goFuncOnEnter(event);"></a> -->
		</div> 
		</div> 
</div>
</div>
</div>


</div>


<!-- <table class="TABLEWIDTH" align="center" cellpadding="1" cellspacing="1">
		<tr class="FOOTER">
			<td colspan="4"><font color="red">*</font> Mandatory Fields</td>
		</tr>
	</table> -->
<!-- 	<table border="0" class="TABLEWIDTH" align="center" cellpadding="1"
		cellspacing="1">
		<tr>

			<td align="center"><img
				style=" cursor: pointer"
				src="../../hisglobal/images/btn-clr.png" onClick="clearIssue();" title="Click to Clear Page">
			<img style=" cursor: pointer"
				src="../../hisglobal/images/btn-ccl.png" onClick="cancelIssue();" title="Click to cancel process">
			</td >
			
			<td align="center">
			<br>
			<a href="#" class="button"	onclick="clearIssue();"><span class="clear">Clear</span></a> 
			<a href="#" class="button" onclick="cancelIssue();"><span class="cancel">Cancel</span></a>
			</td>
		</tr>
	</table> -->
	
	<input type="hidden" name="hmode" />
	<input type="hidden" name="storeName" value="${issueBean.storeName}" />
	<input type="hidden" name="itemCatName" value="${issueBean.itemCatName}" />
	<input type="hidden" name="crNo" value="${issueBean.strCrNo}" />
	<input type="hidden" name="strId" value="${issueBean.strId}" />
	<input type="hidden" name="strConfCatCode" value="${issueBean.strConfCatCode}" />
	<input type="hidden" name="itemCategory" value="${issueBean.itemCategory}" />	
	<input type="hidden" name="strMode"   value="${issueBean.strMode}">
	<input type="hidden" name="strIssueMode"   value="${issueBean.strIssueMode}">
	<input type="hidden" name="strIssueNum" value="${issueBean.strIssueNum}" />
	<input type="hidden" name="strIssueNumber" value="${issueBean.strIssueNum}" />
	<input type="hidden" name="strVisitDtl" value="${issueBean.strVisitDtl}" />
	<input type="hidden" name="strDoseFrqFlg" value="${issueBean.strDoseFrqFlg}" />
	<input type="hidden" name="strReOrderFlgColor" value="${issueBean.strReOrderFlgColor}" />
	
	<input type="hidden" name="strLFAccountNo" value="${issueBean.strLFAccountNo}" />
	<input type="hidden" name="strLFAccountOpenDate" value="${issueBean.strLFAccountOpenDate}" />
	<input type="hidden" name="strLFDepositedAmount" value="${issueBean.strLFDepositedAmount}" />
	<input type="hidden" name="strLFBalanceAmount" value="${issueBean.strLFBalanceAmount}" />
	<input type="hidden" name="strLFAccountStatus" value="${issueBean.strLFAccountStatus}" />
	<input type="hidden" name="strPath" value="${issueBean.strPath}" />
	<input type="hidden" name="printReq" value="${issueBean.printReq}" />


<div id="blanket" style="display: none;"></div>
<div class="popUpDiv" id="popUpDiv" style="display: none;">
	<table bgcolor="white">
		<tr>
			<td>
						
				<div id="issueDtlsDivId" style="display: block;"></div>
		
			</td>
		</tr>
	</table>
	</div>
	<div class="popUpDiv" id="popUpDiv1" style="display:none;">
   <table bgcolor="white">
     <tr>
      <td>
         <div id="transferDtlsDivId" style="display:block;"></div>
      </td>
     </tr>
    </table>
   </div>
	</div>
	</fieldset>
</html:form>
	<tag:autoIndex></tag:autoIndex>   
</body>
</html>
