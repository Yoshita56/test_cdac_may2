<%@page language="java" contentType="text/html" pageEncoding="UTF-8" %>
  <%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic"%>

<%@ taglib uri="/WEB-INF/hisTab.tld" prefix="tag"%>
<%@taglib uri="/WEB-INF/dateTag.tld" prefix="date"%>
<%@ taglib uri="/WEB-INF/comboPersistence.tld" prefix="cmbPers" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset=UTF-8">
<!-- <link href="../css/master.css" rel="stylesheet" type="text/css">
<link href="../../hisglobal/css/tab.css" rel="stylesheet" type="text/css">
<link href="../../hisglobal/css/calendar-tas.css" rel="stylesheet" type="text/css">
<link href="../../hisglobal/css/newpopup.css" rel="stylesheet" type="text/css">
<link href="../../hisglobal/css/popup.css" rel="stylesheet" type="text/css">
<link href="../../hisglobal/css/buttons.css" rel="stylesheet" type="text/css">	
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1"> -->

<link href="/INVMGM/mms/css/master.css" rel="stylesheet" type="text/css">
<link href="../../hisglobal/css/tab.css" rel="stylesheet"
	type="text/css">
<link href="../../hisglobal/css/calendar-tas.css" rel="stylesheet"
	type="text/css">
<link href="../../hisglobal/css/popup.css" rel="stylesheet"
	type="text/css">
<link href="../../hisglobal/css/newpopup.css" rel="stylesheet"
	type="text/css">
<link href="../../hisglobal/css/buttons.css" rel="stylesheet" type="text/css">



<script language="Javascript" src="../../hisglobal/js/util.js"></script>
<script language="Javascript" src="../js/mms.js"></script>
<script language="Javascript" src="../../hisglobal/js/newpopup.js"></script>
<script language="Javascript" src="../../hisglobal/js/popup.js"></script>
<script language="Javascript" src="../../hisglobal/js/multirow.js"></script>
<script language="JavaScript"
	src="../../hisglobal/masterutil/js/master.js"></script>
	

<script language="JavaScript" src="../../hisglobal/js/tab.js"></script>
<script language="JavaScript" src="../../hisglobal/js/calendar.js"></script>
<script language="Javascript" src="../../hisglobal/js/validation.js"></script>
<script language="Javascript" src="../../hisglobal/js/datepicker1.js"></script>
<script language="JavaScript" src="../../hisglobal/js/tab.js"></script>

<script language="JavaScript" src="../js/BreakageItemDtlTrans.js"></script>
<script language="Javascript" src="../js/lpReturnReq.js"></script>
<script language="JavaScript" src="../js/lpReturnReq_Print.js"></script>
<script language="Javascript" src="/INVMGM/dossier/js/dossier_return_trans.js"></script>
<script language="Javascript" src="/INVMGM/dossier/js/dossierItems_util.js"></script>
<!-- <script language="Javascript" src="/INVMGM/dossier/js/dossierDetails_util.js"></script> -->
<!-- <script language="Javascript" src="/INVMGM/dossier/js/dossierissueDetails_util.js"></script> -->
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
}</style>
<script type="text/javascript">
	function checkReturn()
	{
		/*if(document.getElementById("strReturnChk0").value > 0)
		{
				alert("Return Request already generated for the same patient!!!");
				cancelToDesk();
			}*/

			//var smode = "4";
			var transferNo    = document.forms[0].strReturnNo.value;
			//alert(transferNo);
		    
			 var storeId       = document.forms[0].strStoreId.value;
			 
			 //alert("transferNo"+transferNo);
			// alert("storeId"+storeId);
			 if(parseInt(transferNo)!=0 && document.forms[0].printReq.value == 1)
			 { 
			   var mode="ISSUEDTLSINITONE";
			   var url="LPIssueDeskTransCNT.cnt?hmode="+mode+"&strIssueNo="+ transferNo+"&strStoreId="+storeId+"&strMode=4";
			   //ajaxFunction(url,"119");
			   ajaxFunction2(url, "119", "getIssueDtlsAjaxResponse");
			 }
	}

	function getIssueDtlsAjaxResponse(res, mode) {

		//STOCKDTLSINIT
		if (mode == '1') {

			var itemStockObj = document.getElementById("issueDtlsDivId");

			itemStockObj.innerHTML = res;
			/*+"<p class='example'>.</p>"+res;*/

			popup('popUpDiv', '80', '60');

		}
		
		if (mode == "119") 
		{	//alert('res'+res);
			var itemStockObj = document.getElementById("transferDtlsDivId");
			itemStockObj.innerHTML = res;
			document.getElementById("normalMsg").innerHTML = "Data Saved Successfully";
			//document.forms[0].strStoreId.disabled=false;
			popup('popUpDiv1', '60', '80');	
			
		}

	}


</script>
<title>LP Issue</title>
</head>
<body onload="checkReturn();">
<html:form action="/transaction/DossierDeskTransCNT"  name="DossierDeskBean" type="dossier.transaction.controller.fb.DossierDeskTransFB" method="post">

    <div class="errMsg"     id="errMsg"><bean:write name="DossierDeskBean" property="strErr"/></div>
	<div class="warningMsg" id="warningMsg"><bean:write name="DossierDeskBean" property="strWarning"/></div>
	<div class="normalMsg"  id="normalMsg"><bean:write name="DossierDeskBean" property="strMsg"/></div>


<center>
<tag:tab tabLabel="Dossier Settlement" selectedTab="FIRST" align="center" width="TABLEWIDTH">
	</tag:tab>
</center>
<table class="TABLEWIDTH" align="center" cellpadding="1px" cellspacing="1px">

		<tr class="HEADER">
			<td colspan="4"></td>
		</tr>
</table>

<table class='TABLEWIDTH' align='center'cellpadding='1px' cellspacing='1px'>
	<tr>
		<td class='LABEL' width='25%'>Cr No.</td>
		<td class='CONTROL' width='25%'>
			<bean:write property="strCrno1" name="DossierDeskBean" filter="false"/>
		</td>
		<td class='LABEL' width='25%'>Returning Store</td>
		<td class='CONTROL' width='25%'>
			<bean:write property="strStoreName" name="DossierDeskBean" filter="false"/>
		</td>
	</tr>
	
</table>
<logic:equal value="13" name="DossierDeskBean" property="strRaisingReqTypeId">
<table class='TABLEWIDTH' align='center'cellpadding='1px' cellspacing='1px'>
					<tr>
						<td class='TITLE' colspan='4'>
							<div id="ii" style="color:white;">Issue Detail</div>
						</td>
						
						
					
					</tr>
					
					<tr>
					<td class='LABEL' width='25%'>Issue No.</td>
					<td class='CONTROL' width='25%'>
					<bean:write property="strIssueNo" name="DossierDeskBean" filter="false"/>
					</td>
				<td class='LABEL' width='25%'>Issue Date</td>
					<td class='CONTROL' width='25%'>
					<bean:write property="strIssueDate" name="DossierDeskBean" filter="false"/>
					</td>
					</tr>
					<tr>
					<td class='LABEL' width='25%'>C.R No.</td>
					<td class='CONTROL' width='25%' colspan='3'>
						<bean:write property="strCrNo" name="DossierDeskBean" filter="false"/>
						
					</td>
					
					</tr>
					</table>
</logic:equal>

<logic:equal value="12" name="DossierDeskBean" property="strRaisingReqTypeId">
<table class='TABLEWIDTH' align='center'cellpadding='1px' cellspacing='1px'>
					
					<tr>
						<td class='TITLE' colspan='4'>
							<div id="u" style="color:white;">Issue Detail</div>
						</td>
						
						
					
					</tr>
					<tr>
					<td class='LABEL' width='25%'>Issue No.</td>
					<td class='CONTROL' width='25%'>
					<bean:write property="strIssueNo" name="DossierDeskBean" filter="false"/>
					</td>
				<td class='LABEL' width='25%'>Issue Date</td>
					<td class='CONTROL' width='25%'>
					<bean:write property="strIssueDate" name="DossierDeskBean" filter="false"/>
					</td>
					</tr>
					<tr>
					<td class='LABEL' width='25%'>C.R No.</td>
					<td class='CONTROL' width='25%' colspan='1'>
						<bean:write property="strCrNo" name="DossierDeskBean" filter="false"/>
						
					</td>
					<td class='LABEL' width='25%'>Emp No.</td>
					<td class='CONTROL' width='25%' colspan='1'>
						<bean:write property="strCrNo" name="DossierDeskBean" filter="false"/>
						
					</td>
					</tr>
					</table>
</logic:equal>


<logic:equal value="14" name="DossierDeskBean" property="strRaisingReqTypeId">
<table class='TABLEWIDTH' align='center'cellpadding='1px' cellspacing='1px'>
					
					<tr>
						<td class='TITLE' colspan='4'>
							<div id="r" style="color:white;">Return Detail</div>
						</td>
						
						
					
					</tr>
					<tr>
					<td class='LABEL' width='25%'>Issue No.</td>
					<td class='CONTROL' width='25%'>
					<bean:write property="strIssueNo" name="DossierDeskBean" filter="false"/>
					</td>
				<td class='LABEL' width='25%'>Issue Date</td>
					<td class='CONTROL' width='25%'>
					<bean:write property="strIssueDate" name="DossierDeskBean" filter="false"/>
					</td>
					</tr>
					<tr>
					<td class='LABEL' width='25%'>Store Name</td>
					<td class='CONTROL' width='25%' colspan='1'>
						<bean:write property="strStoreName" name="DossierDeskBean" filter="false"/>
						
					</td>
					<td class='LABEL' width='25%'>Dept/Ward</td>
					<td class='CONTROL' width='25%' colspan='1'>
						<bean:write property="strDeptName" name="DossierDeskBean" filter="false"/>
						
					</td>
					</tr>
					</table>
</logic:equal>


	<div class='popup' id='itemDtlId' style="display:none">
		<table width='400' border="0" cellspacing ="0px" cellpadding="0px">
			<tr class="HEADER"> 
				<th align='left'><div id="popUpItemId"></div></th>
				<th align='right'><img  style='cursor:pointer;cursor:pointer' src='../../hisglobal/images/popUp_cancel.JPG'
					onClick="closeItemPopUp('itemDtlId');" title="Click Here To Close Popup"></th>
		    </tr>
		 </table>  
	  
	  
		 <table width='400' border="0" cellspacing ="1px" cellpadding="1px">
			<tr>
				<td colspan="1" class='multiLabel'>Issue Qty.</td>
				<td colspan="1" class='multiControl'><div id ='1'></div></td>
						
			</tr>
			<tr>
				<td colspan="1" class='multiLabel'>Return Qty.</td>
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
		<div id="patientAdmissionDtlId" style="">
			<bean:write property="strPatientDtl" name="DossierDeskBean" filter="false"/>
		</div>
		
		<table class="TABLEWIDTH" align="center" cellspacing="1px" cellpadding="1px">
		<tr>
			<td  colspan="4" class="TITLE">
			<div id="plusRequestItemDtlId" align="left" style="display:none;color:white;">
					<img src="../../hisglobal/images/plus.gif" 
									onClick="view1('plusRequestItemDtlId','minusRequestItemDtlId','strRequestItemDtlId');" style="cursor: pointer; "/>
						 Item Detail
						
					</div>
					<div id="minusRequestItemDtlId" style="display:block;color:white;" align="left">
						<img src="../../hisglobal/images/minus.gif" 
								onClick="view2('plusRequestItemDtlId','minusRequestItemDtlId','strRequestItemDtlId');" style="cursor: pointer; "/>
							 Item Detail
					</div>
				</td>
		</tr>
	</table>
	
	
	
	
	
		
	
	<div id="strRequestItemDtlId" style="display: block">
		<bean:write property="strRequestDtl" name="DossierDeskBean" filter="false" />
		</div>
		
		
		<div id="itemDtlOffDivId" style="display: block">
		<table class="TABLEWIDTH" align="center" cellspacing="1px"
			cellpadding="1px">
			<tr>
			<td class="LABEL" width="100%"><font color="red">*</font>Item Category</td>
				<td class="CONTROL" width="25%"><select id='dep' name="stritemcat"
					class="comboNormal" onchange="">
					<bean:write name="DossierDeskBean" property="strItemCatValues"
						filter="false" />
				</select></td>
				</tr>
				</table>
		<table class="TABLEWIDTH" align="center" cellspacing="1px"
			cellpadding="1px">
			<tr>
			
				
				<td class='TITLE' width="90%"><div align="right"><a style="color:Red;cursor: pointer;" onClick="getItemSelectPopup();">+ Add Consumed Items</a></div></td><td class='TITLE' width="10%"><div align="left"><img style="cursor: pointer;height: 20px"
					id='strSearchItemButtonDivId' src="../../hisglobal/images/ItemFinder.png"
					onclick='getItemSelectPopup();' name="searchName"
					title="Click here to Search Item"></div></td>
			</tr>
			
			 
				
			<!-- <tr>
				<td colspan="4" bgcolor="black"></td>
			</tr> -->
			
		</table>

		<%-- <logic:equal value="0" name="DossierRequisitionBean" property="strCIMSIntegration"> --%>
		<table cellspacing="1px" class="TABLEWIDTH" align="center"
			cellpadding="0px" cellpadding="1px">

			<tr>
				<td class="multiLabel" width="23%">Item Name</td>
				<td class="multiLabel" width="16%">ItemType</td>
				<td class="multiLabel" width="5%">Category</td>
				<td class="multiLabel" width="3%">Batch</td>
				<td class="multiLabel" width="8%">Avl Qty</td>
				<td class="multiLabel" width="8%">Rate/Unit</td>
				
		     	<!-- <td class="multiLabel" width="8%"><font color="red">*</font>Cost/Unit</td> -->
				<td class="multiLabel" width="8%"><font color="red">*</font>Quantity</td>
				<td class="multiLabel" width="8%"><font color="red">*</font>Cost</td>
				<td class="multiLabel" width="4%">-</td>
			</tr>
		</table>
	<%-- 	</logic:equal> --%>

		<!-- <table cellspacing="1px" class="TABLEWIDTH" align="center"
			cellpadding="0px" cellpadding="1px">

			<tr>
				<td class="multiLabel" width="23%">Item Name</td>
				<td width="33%" class="multiLabel">CIMS Action</td>     Added by warish 22-12-17
				<td width=33%" class="multiLabel" id="cimsId1">CIMS Action</td>
				<td width=33%" class="multiLabel" id="cimsId2"></td>
				<td class="multiLabel" width="8%">Batch No</td>
				<td class="multiLabel" width="8%">Avl Qty</td>
					<td class="multiLabel" width="8%"><font color="red">*</font>Cost/Unit</td>
				<td class="multiLabel" width="8%"><font color="red">*</font>Quantity</td>
				<td class="multiLabel" width="8%"><font color="red">*</font>Cost</td>
				<td class="multiLabel" width="4%">-</td>
			</tr>
		</table> -->

		<div id="id1"></div>
		
          <table cellspacing="1px" class="TABLEWIDTH" align="center"
			cellpadding="0px" cellpadding="1px">

			<tr style="">
				<td class="LABEL" colspan="" width="85%"><font color="red"><b>Total Cost</b></font></td>
				<td  class="LABEL" colspan=""><font color="red"><div id="strNetCost" align="left"></div></font></td>
				<input type="hidden" name="strNetCost1" id="strNetCost1" value="0.00" />
			</tr>
		</table>
		
		 <table cellspacing="1px" class="TABLEWIDTH" align="center"
			cellpadding="0px" cellpadding="1px">

			<!-- <tr style="">
				<td class="LABEL" " width="85%" colspan=""><font color="red"><b>Total Amount</b></font></td>
				<td  class="LABEL" colspan=""><font color="red"><div align="left" id="strTotalAmtDiv"></div></font></td>
				
			</tr> -->
		</table>
		
		<table cellspacing="1px" class="TABLEWIDTH" align="center"
			cellpadding="1px">
			<tr>
				<td colspan="5" bgcolor="black"></td>
			</tr>
			<tr class="FOOTER">
				<td colspan="5"></td>
			</tr>
		</table>
		</div>
		
		<div id='recommendationId'>
		  <table class="TABLEWIDTH" align="center" cellspacing="1px">
		  <tr>
		  <td class="TITLE" colspan="2"><div id="re" style="color:white;">Recommendation Details</div></td>
		  
		  </tr>
	 	<tr>
	 		<td class="LABEL" width="50%"><font color='red'>*</font>Recommend by</td>
	 		<td class="CONTROL" width="50%">
	 			<select name="strRecommendBy" class='comboNormal'>
	 				<bean:write property="strRecommendByVal" name="DossierDeskBean" filter="false" />
	 			</select>
	 		</td>
	 		
	 	</tr>
	 	<tr>
	 		<td class="LABEL">
	 			Remarks
	 		</td>
	 		<td class="CONTROL">
	 			<textarea name="strRemarks"></textarea>
	 		</td>
	 	</tr>
	 	
	 </table>
	 </div>
	 
	 <table border="0" class="TABLEWIDTH" align="center" cellspacing="0px" cellpadding="0px">
		<tr class="FOOTER">
		<td width='3%'><div id="plusHelpId" align="center"><img
						src="../../hisglobal/images/plus.gif" name="plusHelp"
						align="middle" style="cursor: pointer;"
						onclick="view1('plusHelpId','minusHelpId','HelpId');" /></div>
					<div id="minusHelpId" style="display: none" align="center"><img style="cursor: pointer;"
						src="../../hisglobal/images/minus.gif" name="minusHelp"
							onclick="view2('plusHelpId','minusHelpId','HelpId');"> </div></td>
						<td><div align="left">Help</div></td>
	</tr>
	</table>
	
	
	
	<div id="HelpId" style="display:none">
			<table border="0" class="TABLEWIDTH" align="center" bgcolor="#000000" cellspacing="1px" cellpadding="1px">
			<tr >
			<td class="CONTROL" style="background-color:#FFFFFF;"> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			 <button style="background-color:#F5786B;height: 20px;width: 20px;" disabled></button>&nbsp;Drug/Item has been expired
			</td>
			</tr>
			</table>
       </div>
	 
		<table CLASS ="TABLEWIDTH" align="center" cellspacing="1px">
		<tr class="FOOTER"> 
    	<td colspan="2" ><font size="2" color="red">*</font> Mandatory Fields  </td>
  		</tr>
	     <tr> 
		<td align="center">
		<!-- <img src="../../hisglobal/images/btn-sv.png"   onClick="SAVERETURN();" style="cursor: pointer;" title="Click Here To Save"/>
		<img src="../../hisglobal/images/btn-clr.png"
				onClick="document.forms[0].reset();" style="cursor: pointer;" title="Click here to reset the data">
		<img src="../../hisglobal/images/back_tab.png" onClick ="cancelToDesk();" style="cursor: pointer;" title="Click Here To Cancel"/>
	   -->
	   <br>
							<a href="#" class="button" id="" onclick='SAVERETURN();'><span class="save">Save</span></a>
							<a href="#" class="button"	onclick="document.forms[0].reset()"><span class="clear">Clear</span></a> 
							<a href="#" class="button" onclick="cancelToDesk();"><span class="cancel">Cancel</span></a>	   
	   
	   </td>
	  </tr>
</table>



<table bgcolor="white">

<tr>

<td>

 <div id="issueDtlsDivId" style="display:block;"></div>

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
   
   
		<input type="hidden" name="hmode"/>
		 <input type="hidden" name="strRequestTypeId" value="${DossierDeskBean.strRequestTypeId}"/>
	    <input type="hidden" name="strStoreId" value="${DossierDeskBean.strStoreId}"/>
	     <input type="hidden" name="strIssueDate" value="${DossierDeskBean.strIssueDate}"/>
	     <input type="hidden" name="strCrNo" value="${DossierDeskBean.strCrNo}"/>
	     <input type="hidden" name="strEmpNo" value="${DossierDeskBean.strEmpNo}"/>
	     <input type="hidden" name=strIssueNo value="${DossierDeskBean.strIssueNo}"/>
	     <input type="hidden" name="strItemCategNo" value="${DossierDeskBean.strItemCategNo}"/>
	      <input type="hidden" name="strRaisingReqTypeId" value="${DossierDeskBean.strRaisingReqTypeId}"/>
	     <input type="hidden" name="strIssueStoreId" value="${DossierDeskBean.strIssueStoreId}"/>
	     <input type="hidden" name="chk" value="${DossierDeskBean.strChk}"/>
	         <input type="hidden" name="strStoreName" value="${DossierDeskBean.strStoreName}"/>
	         <input type="hidden" name="strReturnNo" value="${DossierDeskBean.strReturnNo}"/>
	          <input type="hidden" name="strServicetype" value="${DossierDeskBean.strServicetype}"/>
	         <input type="hidden" name="strDossierId" value="${DossierDeskBean.strDossierId}"/>
			<input type="hidden" name="printReq" value="${DossierDeskBean.printReq}"/>
	      <input type="hidden" name="strBillingHiddenValue" value ="${DossierDeskBean.strBillingHiddenValue}"/>
	    <input type="hidden" name="strPatientType" value ="${DossierDeskBean.strPatientType}"/>
	      
	      
<cmbPers:cmbPers/>
<div id="blanket" style="display: none;"></div>

	<div class="popUpDiv" id="popUpDiv" style="display: none;">
	<table bgcolor="white">
		<tr>
			<td>
			<div id="searchItemsDtlsDivId" style="display: block;"></div>
			<div id="stockDtlsDivId" style="display: block;"></div>

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
	
</html:form>


	
<jsp:include page="dossier_Return_req_trans_search_row.jsp"></jsp:include>
<tag:autoIndex></tag:autoIndex>  
</body>
</html>