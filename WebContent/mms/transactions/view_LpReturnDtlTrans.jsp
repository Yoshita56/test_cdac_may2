<%@ page language="java" contentType="text/html;"	%>
  <%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic"%>

<%@ taglib uri="/WEB-INF/hisTab.tld" prefix="tag"%>
<%@taglib uri="/WEB-INF/dateTag.tld" prefix="date"%>
<%@ taglib uri="/WEB-INF/comboPersistence.tld" prefix="cmbPers" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<link href="../css/master.css" rel="stylesheet" type="text/css">
<link href="../../hisglobal/css/tab.css" rel="stylesheet" type="text/css">
<link href="../../hisglobal/css/calendar-tas.css" rel="stylesheet" type="text/css">
<link href="../../hisglobal/css/newpopup.css" rel="stylesheet" type="text/css">
<link href="../../hisglobal/css/popup.css" rel="stylesheet" type="text/css">
<link href="../../hisglobal/css/buttons.css" rel="stylesheet" type="text/css">	
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">


	
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
<script language="JavaScript" src="../js/BreakageItemDtlTrans.js"></script>
<script language="Javascript" src="../../hisglobal/js/popup.js"></script>
<script language="JavaScript" src="../js/lpIssue_Print.js"></script>
<style type="text/css">
.multiControlRed {
	font-family: Verdana, Arial, Helvetica, sans-serif;
	font-size: 12px;
	font-style: normal;
	font-weight: normal;
	color: #000000;
	background-color: #F5786B;
	height: 16px;
	text-align:center;
}




</style>
<script type="text/javascript">
function getReport()
{

var issueNo = document.forms[0].strIssueNo.value;
var storeId =  document.forms[0].strStoreId.value;
var IndentNo=document.forms[0].strLpRequestNo.value;
var IndentDate=document.forms[0].strRequestDate.value

/*alert("issueNo-"+issueNo);
alert("storeId-"+storeId);
alert("IndentNo-"+IndentNo);
alert("IndentDate-"+IndentDate);*/

	if(issueNo!="0" && issueNo != "" )
	{
		getIssueDtls('1', storeId, issueNo,IndentNo,IndentDate);
	}
	//document.forms[0].strIssueNo.value ="0";
}
	function openDiv()
	{
		if(document.getElementsByName("strRaisingReqTypeId")[0].value=="13" || document.getElementsByName("strRaisingReqTypeId")[0].value=="12"){
			document.getElementById("patientDtlId").style.display="block";
		}
	}
function view1(obj1,obj2,obj3)
{
	document.getElementById(obj1).style.display="none";
	document.getElementById(obj2).style.display="block";
	document.getElementById(obj3).style.display="block";
}
function view2(obj1,obj2,obj3)
{
	document.getElementById(obj1).style.display="block";
	document.getElementById(obj2).style.display="none";
	document.getElementById(obj3).style.display="none";
}

function openSpecification(obj,index)
{
	    var strItemDetail = document.getElementById("strItemDtl"+index).value;    
        var itemParamValue= document.getElementById("strItemParamValue"+index).value;    
        var myArray = strItemDetail.split("@");
        document.getElementById("popUpItemId").innerHTML="Balance Qty. Details";
        var myArray2=itemParamValue.split("@");      
        var objVal1 = document.getElementById("1");
       
        if(myArray[0]!='null' || myArray[0]!='')
        {
          objVal1.innerHTML = myArray2[0]+" "+myArray[1];
        }
        else
        {
          objVal1.innerHTML = "  ----";
        }  
              
        var objVal2 = document.getElementById("2");
        
        if(myArray[1]!='null')
        {
          objVal2.innerHTML = myArray[2]+" "+myArray[1];; 
        }
        else
        {
          objVal2.innerHTML = "  ----";
        }  
        display_popup_menu(obj,'itemDtlId','300','');
        	
	
}
function cancelToDesk()
{
	document.forms[0].hmode.value="RETURNTOMAINDESK";
	document.forms[0].submit();
}
function closeItemPopUp(divId)
{
 	hide_popup_menu(divId);
}





</script>
<title>Issue Desk</title>
</head>
<body onload="openDiv();">
<html:form action="/transactions/LPIssueDeskTransCNT"  name="lpIssueDeskTransBean" type="mms.transactions.controller.fb.LPIssueDeskTransFB" method="post">

    <div class="errMsg"     id="errMsg"><bean:write name="lpIssueDeskTransBean" property="strErr"/></div>
	<div class="warningMsg" id="warningMsg"><bean:write name="lpIssueDeskTransBean" property="strWarning"/></div>
	<div class="normalMsg"  id="normalMsg"><bean:write name="lpIssueDeskTransBean" property="strMsg"/></div>


<center>
<tag:tab tabLabel="Issue Desk" selectedTab="FIRST" align="center" width="TABLEWIDTH">
	</tag:tab>
</center>
<table class="TABLEWIDTH" align="center" cellpadding="1px" cellspacing="1px">

		<tr class="HEADER">
			<td colspan="4">Issue Desk&gt;&gt; View</td>
		</tr>
</table>
<table class='TABLEWIDTH' align='center'cellpadding='1px' cellspacing='1px'>
	<tr>
		<td class='LABEL' width='25%'>Store Name</td>
		<td class='CONTROL' width='25%'>
			<bean:write property="strStoreName" name="lpIssueDeskTransBean" filter="false"/>
		</td>
		<td class='LABEL' width='25%'>CR No.</td>
		<td class='CONTROL' width='25%'>
			<bean:write property="strCrNo" name="lpIssueDeskTransBean" filter="false"/>
		</td>
	</tr>
	<tr>
		<td class='LABEL' width='25%'>Issue No.</td>
		<td class='CONTROL' width='25%'>
			<bean:write property="strIssueNo" name="lpIssueDeskTransBean" filter="false"/>
		</td>
		<td class='LABEL' width='25%'>Indent No.</td>
		<td class='CONTROL' width='25%'>
			<bean:write property="strLpRequestNo" name="lpIssueDeskTransBean" filter="false"/>
		</td>
	</tr>
</table>

<logic:equal value="13" name="lpIssueDeskTransBean" property="strRaisingReqTypeId">
<table class='TABLEWIDTH' align='center'cellpadding='1px' cellspacing='1px'>
					<tr>
						<td class='TITLE' colspan='4'>
							<div id='' style='color:white;'>Issue Detail</div>
						</td>
					</tr>					
					<tr>
					<td class='LABEL' width='25%'>Issue No.</td>
					<td class='CONTROL' width='25%'>
					<bean:write property="strIssueNo" name="lpIssueDeskTransBean" filter="false"/>
					</td>
				<td class='LABEL' width='25%'>Issue Date</td>
					<td class='CONTROL' width='25%'>
					<bean:write property="strIssueDate" name="lpIssueDeskTransBean" filter="false"/>
					</td>
					</tr>
					<tr>
					<td class='LABEL' width='25%'>C.R No.</td>
					<td class='CONTROL' width='25%' colspan='3'>
						<bean:write property="strCrNo" name="lpIssueDeskTransBean" filter="false"/>
						
					</td>
					
					</tr>
					</table>
</logic:equal>

<logic:equal value="12" name="lpIssueDeskTransBean" property="strRaisingReqTypeId">
<table class='TABLEWIDTH' align='center'cellpadding='1px' cellspacing='1px'>
					<tr>
						<td class='TITLE' colspan='4'>
							<div id='' style='color:white;'>Issue Detail</div>
						</td>
						</tr>
					<tr>
					<td class='LABEL' width='25%'>Issue No.</td>
					<td class='CONTROL' width='25%'>
					<bean:write property="strIssueNo" name="lpIssueDeskTransBean" filter="false"/>
					</td>
				<td class='LABEL' width='25%'>Issue Date</td>
					<td class='CONTROL' width='25%'>
					<bean:write property="strIssueDate" name="lpIssueDeskTransBean" filter="false"/>
					</td>
					</tr>
					<tr>
					<td class='LABEL' width='25%'>C.R No.</td>
					<td class='CONTROL' width='25%' colspan='1'>
						<bean:write property="strCrNo" name="lpIssueDeskTransBean" filter="false"/>
						
					</td>
					<td class='LABEL' width='25%'>Emp No.</td>
					<td class='CONTROL' width='25%' colspan='1'>
						<bean:write property="strCrNo" name="lpIssueDeskTransBean" filter="false"/>
						
					</td>
					</tr>
					</table>
</logic:equal>

	<div class='popup' id='itemDtlId' style="display:none">
		<table width='400' border="0" cellspacing ="0px" cellpadding="0px">
			<tr class="HEADER"> 
				<th align='left'><div id="popUpItemId" style='color:white;'></div></th>
				<th align='right'><img  style='cursor:pointer;cursor:pointer' src='../../hisglobal/images/popUp_cancel.JPG'
					onClick="closeItemPopUp('itemDtlId');" title="Click Here To Close Popup"></th>
		    </tr>
		 </table>  
	  
	  
		 <table width='400' border="0" cellspacing ="1px" cellpadding="1px">
			<tr>
				<td colspan="1" class='multiLabel'>Issue Qty</td>
				<td colspan="1" class='multiControl'><div id ='1'></div></td>
						
			</tr>
			<tr>
				<td colspan="1" class='multiLabel'>Return Qty</td>
				<td colspan="1" class='multiControl'><div id ='2'></div></td>	
			</tr>
			<tr class="FOOTER">
				<td colspan="4"></td>
			</tr>
	        </table>
	</div>
	
		

<div id="patientDtlId" style="display: none;">
<table class="TABLEWIDTH" align="center" cellspacing="1px" cellpadding="1px">
		<tr>
			<td  colspan="4" class="TITLE">
			<div id="plusPatientDetailId" align="left" style="display:none;color:white;">
					<img src="../../hisglobal/images/plus.gif" 
									onClick="view1('plusPatientDetailId','minusPatientDetailId','patientAdmissionDtlId');" style="cursor: pointer; "/>
						Patient Detail
						
					</div>
					<div id="minusPatientDetailId" style="display:block;color:white;" align="left">
						<img src="../../hisglobal/images/minus.gif" 
								onClick="view2('plusPatientDetailId','minusPatientDetailId','patientAdmissionDtlId');" style="cursor: pointer; "/>
								Patient Details
					</div>
				</td>
		</tr>
	</table>
</div>	
		<div id="patientAdmissionDtlId" style="display:block">
			<bean:write property="strPatientDtl" name="lpIssueDeskTransBean" filter="false"/>
		</div>
		
		<table class="TABLEWIDTH" align="center" cellspacing="1px" cellpadding="1px">
		<tr>
			<td  colspan="4" class="TITLE">
			<div id="plusRequestItemDtlId" align="left" style="display:none;color:white;">
					
						 Item/Drug Detail
						
					</div>
					<div id="minusRequestItemDtlId" style="display:block;color:white;" align="left">
						
							 Item/Drug Detail
					</div>
				</td>
		</tr>
	</table>
	
	

	
		<div id="strRequestItemDtlId" style="display: block">
		<bean:write property="strRequestDtl" name="lpIssueDeskTransBean" filter="false" />
		</div>
		
	
	

	
		
		
		  	<table CLASS ="TABLEWIDTH" align="center" cellspacing="1px">
		<tr class="FOOTER"> 
    	<td colspan="2" > </td>
  		</tr>
	     <tr> 
		<td align="center">
		<!-- <img src="../../hisglobal/images/btn-pnt.png" onClick ="getReport();" style="cursor: pointer;" title="Click Here To Re-print"/>
		<img src="../../hisglobal/images/back_tab.png" onClick ="cancelToDesk();" style="cursor: pointer;" title="Click Here To Cancel"/> -->
	   <br>
	   <a href="#" class="button" id="" onclick=' getReport();'><span class="print">Print</span></a>
	   <a href="#" class="button"	onclick="cancelToDesk()"><span class="cancel">Cancel</span></a> 
	   </td>
	  </tr>
</table>

<div id="blanket" style="display:none;"></div>
<div class="popUpDiv" id="popUpDiv" style="display:none;">

<table bgcolor="white">

<tr>

<td>

 <div id="issueDtlsDivId" style="display:block;"></div>


</td>

</tr>

</table>

</div>
		<input type="hidden" name="hmode"/>
		 <input type="hidden" name="strRequestTypeId" value="${lpIssueDeskTransBean.strRequestTypeId}"/>
	    <input type="hidden" name="strStoreId" value="${lpIssueDeskTransBean.strStoreId}"/>
	     <input type="hidden" name="strRequestDate" value="${lpIssueDeskTransBean.strRequestDate}"/>
	     <input type="hidden" name="strCrNo" value="${lpIssueDeskTransBean.strCrNo}"/>
	     <input type="hidden" name="strEmpNo" value="${lpIssueDeskTransBean.strEmpNo}"/>
	     <input type="hidden" name="strLpRequestNo" value="${lpIssueDeskTransBean.strLpRequestNo}"/>
	     <input type="hidden" name="strItemCategNo" value="${lpIssueDeskTransBean.strItemCategNo}"/>
	      <input type="hidden" name="strRaisingReqTypeId" value="${lpIssueDeskTransBean.strRaisingReqTypeId}"/>
	     <input type="hidden" name="strRaisingStoreId" value="${lpIssueDeskTransBean.strRaisingStoreId}"/>
	      <input type="hidden" name="strIssueNo" value="${lpIssueDeskTransBean.strIssueNo}"/>
	      

	      
<cmbPers:cmbPers/>

</html:form>
<tag:autoIndex></tag:autoIndex>
</body>
</html>