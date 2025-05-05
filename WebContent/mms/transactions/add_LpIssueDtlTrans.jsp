<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
  <%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic"%>

<%@ taglib uri="/WEB-INF/hisTab.tld" prefix="tag"%>
<%@taglib uri="/WEB-INF/dateTag.tld" prefix="date"%>
<%@ taglib uri="/WEB-INF/comboPersistence.tld" prefix="cmbPers" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link href="../css/transaction.css" rel="stylesheet" type="text/css">
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

<script language="JavaScript" src="../js/lpIssue_Print.js"></script>
<script language="Javascript" src="../../hisglobal/js/popup.js"></script>
<script language="Javascript" src="../js/itemparameterdetails_util.js"></script> 
<script language="JavaScript" src="../js/lpIssue.js"></script>


<script type="text/javascript">

function callStockDetails(obj,index)
{
	
	if(document.getElementById("strIssueQuantity"+index).value=="")
	{
		alert("Please Enter Issue Quantity");
		document.getElementById("strIssueQuantity"+index).focus();		
	}

	else
	{
		
		if(document.getElementById("strAvlQtyForChk"+index).value != "0")
		{
			var               hiddenVal =  document.getElementById("strItemParamValue"+index).value;
			
			//alert("hiddenVal-"+hiddenVal); // item id^brandid^RESERVED FLAG^GROUPID^SUBGROUP ID^CONSUMABLE FLAG
			// ^strItemCategory^strRaisingStoreId
			var             	   temp = hiddenVal.split("@");
			//var         	    strMode = "1^"+document.forms[0].strBudgetFlg.value+"^"+index;
			var         	    strMode = "1^"+"0"+"^"+index;
			var     	 strStockStatus = "10";
			var      	   strGenItemId = temp[0];
			var       	      strItemId = temp[1];				
			var             strIssueQty = document.getElementById("strIssueQuantity"+index).value;
			//var       strIssueQtyUnitId = temp[3];
			var        	    strUnitName = "No.";				 
			//var               	  temp2 = strIssueQtyUnitId.split("^");
			//var  strIssueQtyUnitBaseVal = parseFloat(temp2[1]);				
			var              strCatCode = document.forms[0].strItemCategNo.value;
			var                 storeId = document.forms[0].strStoreId.value;
			var         strReservedFlag = "0";//hardcoded
			var strUserHiddenFieldDivId = "stockDtlsId"+index;
			var     strUserDrugDtlDivId = "issueDrugDtl"+index;
			var     strUserExpDtlDivId = "expDrugDtl"+index;
			//var     strUserMrpDtlDivId = "mrpDtl"+index;
			
			var   strUserDrugExpRemarks = "issueDrugDtl"+index; 	
			//document.getElementById("strIssueQty"+index).readOnly = true;
			//document.getElementById("strIssueUnitId"+index).readOnly = true;			
			document.getElementById("issueDrugDtl"+index).innerHTML="";
			document.getElementById("expDrugDtl"+index).innerHTML="";
			//document.getElementById("mrpDtl"+index).innerHTML="";
			

			gblMode 					= strMode;
			gblStockStatus 				= strStockStatus;
			gblGenItemId 				= strGenItemId;
			gblItemId 					= strItemId;
			gblIssueQty 				= strIssueQty;
			//gblIssueQtyInBase 			= strIssueQtyUnitBaseVal; 
			gblStoreId 					= storeId;
			gblCatCode 					= strCatCode;
			gblReservedFlag			    = strReservedFlag;	
			gblUserHiddenFieldDivId     = strUserHiddenFieldDivId;
			gblUserDrugDtlDivId         = strUserDrugDtlDivId;
			gblUserExpDtlDivId          = strUserExpDtlDivId;
			//gblUserMrpDtlDivId          = strUserMrpDtlDivId;
			gblUserDrugExpDrugRemarksId = strUserDrugExpRemarks;
			var        hmode = "STOCKDTLSINIT";
			
			var      hidVal = document.getElementById("stockDtlsId"+index).value.replace(/#/g , "@");
			var         url = "IssueDeskTransCNT.cnt?hmode=" + hmode + "&strMode=" + strMode+"&strStockStatus="+
			strStockStatus +"&strGenItemId="+strGenItemId+"&strItemId="+strItemId+
			"&strIssueQty="+strIssueQty+"&strIssueQtyInBase=1&strStoreId="+storeId+"&strCatCode="+strCatCode+"&strReservedFlag="+strReservedFlag+"&strHiddenFieldVal="+hidVal+"&strUnitName="+strUnitName;
			//getStockDtls(strMode, strStockStatus, strGenItemId, strItemId, strIssueQty, strIssueQtyUnitBaseVal,storeId, strCatCode, strReservedFlag, strUnitName, strUserHiddenFieldDivId);
			
			//alert(url);
			
			ajaxFunction(url,"2");
		}
		else
		{
			alert("No Batches to be Select!!");
			return false;
		}					

	}
	


}
function getVoucher() 
{    
	//alert('1');
   var strChk         = document.forms[0].strChk.value;
   var strReqTypeId   = document.forms[0].strRequestTypeId.value;
   var strStoreId     = document.forms[0].strStoreId.value;
   
	 
   var mode="BEFOREISSUEPRINT";
   var url="LPIssueDeskTransCNT.cnt?hmode="+mode+"&strChk="+ strChk+"&strReqTypeId="+strReqTypeId+"&strStoreId="+strStoreId;
   ajaxFunction(url,"1");
	 
}

function getAjaxResponse(res,mode)
{
	  var err = document.getElementById("errMsg");
      var temp = res.split("####");
      if(temp[0] == "ERROR")
	  {
          	err.innerHTML = temp[1];
          	return;
       } 
      if(mode=="1")
       {
          
			var itemStockObj = document.getElementById("issueDtlsPrintDivId");
			itemStockObj.innerHTML = res;
			
			popup('popUpDivPrint', '60', '80');	
			
		}
      if(mode=="2")	
		{
			var itemStockObj = document.getElementById("stockDtlsDivId");
	
			//alert(res);
			
			itemStockObj.innerHTML = res;
	
			popup('popUpDiv', '150', '60');
		}
       
}	

function printData1() 
{

	newwin = window.open('', 'printwin',
			'left=100,top=100,width=700,height=700,scrollbars=yes');
	newwin.document.write('<HTML><HEAD>');
	newwin.document.write((document.getElementsByTagName("head")[0]).innerHTML);
	newwin.document.write('<style type="text/css"> .hidecontrol { display: none; } @media screen and (orientation: portrait) {  #toolbar { width: 100%; }} </style>\n')
	newwin.document.write('<script>\n');
	newwin.document.write('function chkstate(){ \n');
	// newwin.document.write('if(document.readystate=="complete" ||
	// document.readystate=="undefined"){\n');
	newwin.document.write('window.close();\n');
	// newwin.document.write('}\n');
	// newwin.document.write('else{\n');
	// newwin.document.write('setTimeout("chkstate()",2000)\n');
	// newwin.document.write('}\n');
	newwin.document.write('}\n');
	newwin.document.write('function print_win(){\n');
	newwin.document.write('window.print();\n');
	newwin.document.write('chkstate();\n');
	newwin.document.write('}\n');

	newwin.document.write('<\/script>\n');
	newwin.document.write('</HEAD>\n');
	newwin.document.write('<BODY onload="print_win()">\n');
	newwin.document.write(document.getElementById('issueDtlsPrintDivId').innerHTML);
	newwin.document.write('</BODY>\n');
	newwin.document.write('</HTML>\n');
	newwin.document.close();

}

function hideIssuePopup() 
{	
	document.getElementById("issueDtlsPrintDivId").innerHTML = "";
	hide_popup('popUpDivPrint');	
}

</script>
<title>LP Issue</title>
    <style>
        .example {
            page-break-after: always;
        }
    </style>
</head>
<body onload="openDiv();getReport();">
<html:form action="/transactions/LPIssueDeskTransCNT"  name="lpIssueDeskTransBean" type="mms.transactions.controller.fb.LPIssueDeskTransFB" method="post">

    <div class="errMsg"  id="errMsg"><bean:write name="lpIssueDeskTransBean" property="strErr"/></div>
	<div class="warningMsg" id="warningMsg"><bean:write name="lpIssueDeskTransBean" property="strWarning"/></div>
	<div class="normalMsg" id="normalMsg"><bean:write name="lpIssueDeskTransBean" property="strMsg"/></div>


<center>
<tag:tab tabLabel="Issue to Patient(IPD)" selectedTab="FIRST" align="center" width="TABLEWIDTH">
	</tag:tab>
</center>
<table class="TABLEWIDTH" align="center" cellpadding="1px" cellspacing="1px">

		<tr class="HEADER">
			<td colspan="4"></td>
		</tr>
</table>
<div style=''><table class='TABLEWIDTH' align='center'cellpadding='1px' cellspacing='1px'>
	<tr>
		<td class='LABEL' width='25%'>Store Name</td>
		<td class='CONTROL' width='25%'>
			<bean:write property="strStoreName" name="lpIssueDeskTransBean" filter="false"/>
		</td>
		<td class='LABEL' width='25%'>Indenting Store Name</td>
		<td class='CONTROL' width='25%'>
			<bean:write property="strRaisingStoreName" name="lpIssueDeskTransBean" filter="false"/>
		</td>
	</tr>
	<tr>
	    <td class='LABEL'   colspan="1"></td>		
		<td class='CONTROL' colspan="3">
			<bean:write property="strAppRemarks" name="lpIssueDeskTransBean" filter="false"/>
		</td>
	</tr>
</table></div>

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
				<td colspan="1" class='multiLabel'>Sanction Qty.</td>
				<td colspan="1" class='multiControl'><div id ='1'></div></td>
						
			</tr>
			<tr>
				<td colspan="1" class='multiLabel'>Issue Qty.</td>
				<td colspan="1" class='multiControl'><div id ='2'></div></td>	
			</tr>
			<tr class="FOOTER">
				<td colspan="4"></td>
			</tr>
	        </table>
	</div>

<bean:write property="strRequestDtl" name="lpIssueDeskTransBean" filter="false"/>

<div id="patientDtlId" style="display: none;">
<table class="TABLEWIDTH" align="center" cellspacing="1px" cellpadding="1px">
		<tr>
			<td  colspan="4" class="TITLE">
			<div id="plusPatientDetailId" align="left" style="display:block;color:white;">
					<img src="../../hisglobal/images/plus.gif" 
									onClick="view1('plusPatientDetailId','minusPatientDetailId','patientAdmissionDtlId');" style="cursor: pointer; "/>
						Patient Detail
						
					</div>
					<div id="minusPatientDetailId" style="display:none;color:white;" align="left">
						<img src="../../hisglobal/images/minus.gif" 
								onClick="view2('plusPatientDetailId','minusPatientDetailId','patientAdmissionDtlId');" style="cursor: pointer; "/>
								Patient Details
					</div>
				</td>
		</tr>
	</table>
</div>	
		<div id="patientAdmissionDtlId" style="display:none">
			<bean:write property="strPatientDtl" name="lpIssueDeskTransBean" filter="false"/>
		</div>
		
	<div style='display:none'>	<table class="TABLEWIDTH" align="center" cellspacing="1px" cellpadding="1px">
		<tr>
			<td  colspan="4" class="TITLE">
			<div id="plusRequestItemDtlId" align="left" style="display:block;color:white;">
					<img src="../../hisglobal/images/plus.gif" 
									onClick="view1('plusRequestItemDtlId','minusRequestItemDtlId','strRequestItemDtlId');" style="cursor: pointer; "/>
						Requested Item Detail
						
					</div>
					<div id="minusRequestItemDtlId" style="display:none;color:white;" align="left">
						<img src="../../hisglobal/images/minus.gif" 
								onClick="view2('plusRequestItemDtlId','minusRequestItemDtlId','strRequestItemDtlId');" style="cursor: pointer; "/>
							Requested Item Detail
					</div>
				</td>
		</tr>
	</table></div>
	
	

	
		<div id="strRequestItemDtlId" style="display: none">
		<bean:write property="strRequestItemDtl" name="lpIssueDeskTransBean" filter="false" />
		</div>
		
		<table class="TABLEWIDTH" align="center" cellspacing="1px" cellpadding="1px">
		<tr>
			<td  colspan="4" class="TITLE">
			<div id="plusDiagId" align="left" style="display:block;color:white;">
					<img src="../../hisglobal/images/plus.gif" 
									onClick="view1('plusDiagId','minusDiagId','strDiagId');" style="cursor: pointer; "/>
						Diagnosis Detail
						
					</div>
					<div id="minusDiagId" style="display:none;color:white;" align="left">
						<img src="../../hisglobal/images/minus.gif" 
								onClick="view2('plusDiagId','minusDiagId','strDiagId');" style="cursor: pointer; "/>
							Diagnosis Detail
					</div>
				</td>
		</tr>
	</table>
	
	

	
		<div id="strDiagId" style="display: none">
		<bean:write property="strDiagDtl" name="lpIssueDeskTransBean" filter="false" />
		</div>
		
		<table class="TABLEWIDTH" align="center" cellspacing="1px" cellpadding="1px">
		<tr>
			<td  colspan="4" class="TITLE">
			<div id="plusIssueItemDtlId" align="left" style="display:none;color:white;">&nbsp;&nbsp;&nbsp;
						Issue Item Detail
						
					</div>
					<div id="minusIssueItemDtlId" style="display:block;color:white;" align="left">&nbsp;&nbsp;&nbsp;
							Issue Item Detail
					</div>
				</td>
		</tr>
	</table>
	
	

	
		<div id="issueItemDtlId" style="display: block">
		<bean:write property="strIssueItemId" name="lpIssueDeskTransBean" filter="false" />
		
		<input type="hidden" value="0.00" name="strApproxAmtDivId" id="strApproxAmtDivId" >
			<input type="hidden" name="strFinalApproxAmt">
		</div>
		<logic:equal value="0" property='strBSReqNo' name='lpIssueDeskTransBean' ><table class="TABLEWIDTH" align="center" cellspacing="1px">
	 	<tr>
	 		<td class="LABEL" width="50%"><font color='red'>*</font>Raise LP Indent</td>
	 		<td class="CONTROL" width="50%">
	 			<input type="radio" name="strBSIndent" onchange='chkradio(this);' value="1"  />Yes &nbsp;&nbsp;
	 			 <input type="radio" name="strBSIndent" onchange='chkradio(this);' value="0" checked/>No
	 		</td>
	 		
	 	</tr>
	 	
	 </table></logic:equal>
	 <div style='display:none;'>  <table class="TABLEWIDTH" align="center" cellspacing="1px">
		  <tr>
	 		<td class="LABEL" width="50%">Utility Certificate Required</td>
	 		<td class="CONTROL" width="50%">
	 		<html:radio property="strUCReq" name="lpIssueDeskTransBean" value="1">Yes&nbsp;&nbsp;&nbsp;&nbsp;</html:radio>
	 		<html:radio property="strUCReq"  name="lpIssueDeskTransBean" value="0">No</html:radio>
	 			
	 		</td>
	 		
	 	</tr>
	</table> 	</div>
		  <table class="TABLEWIDTH" align="center" cellspacing="1px">
	 	<tr>
	 		<td class="LABEL" width="50%">Received by</td>
	 		<td class="CONTROL" width="50%">
	 			<input name="strReceivedby" autocomplete='off' value="" class="txtFldMax" onkeypress="return validateData(event,4);" >
	 		</td>
	 		
	 	</tr>
	 	<tr>
	 		<td class="LABEL">
	 			Remarks
	 		</td>
	 		<td class="CONTROL">
	 			<textarea maxlength = 100 name="strRemarks"></textarea>
	 		</td>
	 	</tr>
	 	
	 </table>
	 
		<table CLASS ="TABLEWIDTH" align="center" cellspacing="1px">
		<tr class="FOOTER"> 
    	<td  ><div align='left'><font size='2' color="red">Issue Qty disabled for the items for which tariff is not available</font></div></td>
    	<td ><font size="2" color="red">*</font> Mandatory Fields  </td>
  		</tr>
	     <tr> 
		<!-- <td align="center">
		<img src="../../hisglobal/images/btn-sv.png"   onClick="SAVE();" style="cursor: pointer;" title="Click Here To Save"/>
		<img src="../../hisglobal/images/btn-clr.png"
				onClick="document.forms[0].reset();" style="cursor: pointer;" title="Click here to reset the data">
		<img src="../../hisglobal/images/back_tab.png" onClick ="cancelToDesk();" style="cursor: pointer;" title="Click Here To Cancel"/>
	   </td> -->
	   
	   <td colspan='2' align="center">
	   <br>
	   			        <a href="#" class="button" id="" onclick=" getVoucher();" tabindex="1"><span class="print">Print</span></a> 
	                    <a href="#" class="button" id="submitId" onclick='SAVE();'><span class="save">Save</span></a>
						<a href="#" class="button"	onclick="document.forms[0].reset();"><span class="clear">Clear</span></a> 
						<a href="#" class="button" onclick="cancelToDesk();"><span class="cancel">Cancel</span></a>
	   </td>
	  </tr>
	  
	<!-- <tr >
			<td align='left'><font color="Blue" size="2" >Integration with e-Aushadhi : <logic:equal name="lpIssueDeskTransBean" property="strSCMIntegration" value="1">Yes</logic:equal><logic:notEqual name="lpIssueDeskTransBean" property="strSCMIntegration" value="1">No</logic:notEqual></font></td>
			
		</tr>  --> 
</table>

<div id="blanket" style="display:none;"></div>
<div class="popUpDiv" id="popUpDiv" style="display:none;">

<table bgcolor="white">

<tr>

<td>

 <div id="stockDtlsDivId" style="display:block;"></div>
 <div id="issueDtlsDivId" style="display:block;"></div>
 
 <!--<div id="divBrandDtlId" class='popup' style="display: none; left:500px; top:170px;"></div>-->

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
	     <input type="hidden" name="strPoNo" value="${lpIssueDeskTransBean.strPoNo}"/>
	     <input type="hidden" name="strPoStoreId" value="${lpIssueDeskTransBean.strPoStoreId}"/>
	      <input type="hidden" name="chk" value="${lpIssueDeskTransBean.strChk}"/>
	      <input type="hidden" name="strChk" value="${lpIssueDeskTransBean.strChk}"/>
	      <input type="hidden" name="strIssueNo" value="${lpIssueDeskTransBean.strIssueNo}"/>
	       <input type="hidden" name="strStoreName" value="${lpIssueDeskTransBean.strStoreName}"/>
	       <input type="hidden" name="strBudgetFlg" value ="${lpIssueDeskTransBean.strBudgetFlg}"/>
	        <input type="hidden" name="strUrgentFlg" value ="${lpIssueDeskTransBean.strUrgentFlg}"/>
	        <input type="hidden" name="strBSReqNo" value ="${lpIssueDeskTransBean.strBSReqNo}"/>
	        <input type="hidden" name="strBillPaidCat" value ="${lpIssueDeskTransBean.strBillPaidCat}"/>
	           <input type="hidden" name="strBillingHiddenValue" value ="${lpIssueDeskTransBean.strBillingHiddenValue}"/>
	          <input type="hidden" name="itmnotissued"/> 
<cmbPers:cmbPers/>
<div id="blanket" style="display: none;"></div>
     <div class="popUpDiv" id="popUpDivPrint" style="display: none;">
		<table bgcolor="white">
			<tr>
				<td>
							
					<div id="issueDtlsPrintDivId" style="display: block;"></div>
			
				</td>
			</tr>
	    </table>
	 </div>
</html:form>
<tag:autoIndex></tag:autoIndex>  
</body>
</html>