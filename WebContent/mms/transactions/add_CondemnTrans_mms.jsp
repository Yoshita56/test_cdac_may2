<%@page language="java" contentType="text/html" pageEncoding="UTF-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>

<%@ taglib uri="/WEB-INF/hisTab.tld" prefix="tag"%>
<%@taglib uri="/WEB-INF/dateTag.tld" prefix="date"%>
<%@ taglib uri="/WEB-INF/comboPersistence.tld" prefix="cmbPers" %>


<html>
<head>
<meta charset=UTF-8">
<title>Insert Title Here</title>
<link href="../css/master.css" rel="stylesheet" type="text/css">
<link href="../../hisglobal/css/tab.css" rel="stylesheet" type="text/css">
<link href="../../hisglobal/css/calendar-tas.css" rel="stylesheet" type="text/css">
<link href="../../hisglobal/css/newpopup.css" rel="stylesheet" type="text/css">
<link href="../../hisglobal/css/popup.css" rel="stylesheet" type="text/css">	
	
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
<script language="Javascript" src="../../mms/js/condemnRegister.js"></script>
<script type="text/javascript">

</script>

</head>

<body onload="openAutionDetails();">

<html:form action="/transactions/CondemnationRegisterTransCNT"  enctype="multipart/form-data"
name="condemnRegisterTransBean" type="mms.transactions.controller.fb.CondemnationRegisterTransFB" method="post" >

    <div class="errMsg"     id="errMsg"><bean:write name="condemnRegisterTransBean" property="strErr"/></div>
	<div class="warningMsg" id="warningMsg"><bean:write name="condemnRegisterTransBean" property="strWarning"/></div>
	<div class="normalMsg"  id="normalMsg"><bean:write name="condemnRegisterTransBean" property="strMsg"/></div>


<center>
<tag:tab tabLabel="Condemnsation Register Transaction" selectedTab="FIRST" align="center" width="TABLEWIDTH">
	</tag:tab>
</center>
<table class="TABLEWIDTH" align="center" cellpadding="1px" cellspacing="1px">

		<tr class="HEADER">
			<td colspan="4"></td>
		</tr>
</table>

	<table class="TABLEWIDTH" align="center" cellspacing="1px">   
	 	<tr>
	 		<td class="LABEL"  width="25%">
	 			Store Name
	 		</td>
	 		<td class="CONTROL"  width="25%">
	 		<bean:write name="condemnRegisterTransBean" property="strStoreName" filter="false"/>
	 		</td>
	 		<td class="LABEL" colspan="1" width="25%">
	 			Item Category Name
	 		</td>
	 		<td class="CONTROL"  width="25%">
	 		<bean:write name="condemnRegisterTransBean" property="strItemCategoryName" filter="false"/>
	 		</td>
	 	
	 	</tr>
	 	<tr>
	 		<td class="LABEL" width="25%">
	 			Agenda No
	 		</td>
	 		<td class="CONTROL">
	 		<bean:write name="condemnRegisterTransBean" property="strAgendaNo" filter="false"/>
	 			
	 		</td>
	 		<td class="LABEL" width="25%">
	 		Agenda Date
	 		</td>
	 		<td class="CONTROL" width="25%">
	 			<bean:write name="condemnRegisterTransBean" property="strAgendaDate" filter="false"/>
	 		</td>
	 	</tr>
	 
	 </table> 
		 
	 
	<table class="TABLEWIDTH" align="center" cellspacing="1px">
		<tr>
			<td  colspan="4" class="TITLE">
			<div id="plusAddItemId" align="left" style="display:none;color:blue;">
					<img src="../../hisglobal/images/plus.gif" 
									onClick="view1('plusAddItemId','minusAddItemId','itemDetailsId');" style="cursor: pointer; "/>
						Item Details
					</div>
					<div id="minusAddItemId" style="display:block;color:blue;" align="left">
						<img src="../../hisglobal/images/minus.gif" 
								onClick="view2('plusAddItemId','minusAddItemId','itemDetailsId');" style="cursor: pointer; "/>
								Item Details
					</div>
				</td>
		</tr>
	</table>
	<div id="itemDetailsId">
	 	<bean:write name="condemnRegisterTransBean" property="strItemDetailsValue" filter="false"/>
	 </div> 
	 <div class='popup' id='itemDtlId' style="display:none">
		<table width='450' border="0" cellspacing ="0px" cellpadding="0px">
			<tr class="HEADER"> 
				<th align='left'><div id="popUpItemId" style='color:blue;'></div></th>
				<th align='right'><img  style='cursor:pointer;cursor:pointer' src='../../hisglobal/images/popUp_cancel.JPG'
					onClick="closeItemPopUp('itemDtlId');" title="Click Here To Close Popup"></th>
		    </tr>
		 </table>  
	  
	  
		 <table width='450' border="0" cellspacing ="1px" cellpadding="1px">
			<tr>
				<td colspan="1" class='multiLabel'>Last P.O. No.</td>
				<td colspan="1" class='multiControl'><div id ='1'></div></td>
				<td colspan="1" class='multiLabel'>Last P.O. Date</td>
				<td colspan="1" class='multiControl'><div id ='2'></div></td>			
			</tr>
			<tr>
				<td colspan="1" class='multiLabel'>Last Rate/Unit</td>
				<td colspan="1" class='multiControl'><div id ='3'></div></td>
				<td colspan="1" class='multiLabel'>Specification</td>
				<td colspan="1" class='multiControl'><div id ='4'></div></td>
						  
			</tr>
			<tr>
				<td colspan="1" class='multiLabel'>Last Receive Qty.</td>
				<td colspan="1" class='multiControl'><div id ='5'></div></td>
				<td colspan="1" class='multiLabel'>Supplied By</td>
				<td colspan="1" class='multiControl'><div id ='6'></div></td>
						  
			</tr>
			<tr class="FOOTER">
				<td colspan="4"></td>
			</tr>
	        </table>
	</div>
	 <table class="TABLEWIDTH" align="center" cellspacing="1px">
	 <tr>
	 	<td colspan="4" class="TITLE">
	 		<div id="condmnId" style="color:blue">Condemnation Details</div>
	 	</td>
	 </tr>   
	 <tr>
	 <td class="LABEL" width="50%">Condemnation Type</td>
	 <td class="CONTROL" >
	 	<bean:write name="condemnRegisterTransBean" property="strCondemnationTypeName" filter="false"/>	
	</td>
	 	 
	 	
	 </tr>
	 </table>
	 <div id="autionDetailId" style="display: none">
	 	<table class="TABLEWIDTH" align="center" cellspacing="1px">
	 		<tr>
	 			<td colspan="4" class="TITLE"><div id="auctionId" style="color:blue">Auction Details</div></td>
	 		</tr>
	 		<TR>
	 			<td class="LABEL" width="25%"><font color='red'>*</font>Tender No</td>
	 			<td class="CONTROL" width="25%"><input type="text" name="strTenderNo" class="txtFldNormal" maxlength="50" onkeypress="return validateData(event,9);"></td>
	 			<td class="LABEL" width="25%">Tender Date</td>
	 			<td class="CONTROL" width="25%"><date:date name="strTenderDate" value ="${condemnRegisterTransBean.strCtDate}"></date:date></td>
	 		</TR>	
	 		<TR>
	 			<td class="LABEL" width="25%"><font color='red'>*</font>Quotation Number</td>
	 			<td class="CONTROL" width="25%"><input type="text" name="strQuotationNo" class="txtFldNormal" maxlength="50" onkeypress="return validateData(event,9);"></td>
	 			<td class="LABEL" width="25%">Quotation Date</td>
	 			<td class="CONTROL" width="25%"><date:date name="strQuotationDate" value ="${condemnRegisterTransBean.strCtDate}"></date:date></td>
	 		
	 		</TR>	
	 		<TR>
	 			<td class="LABEL" width="25%"><font color='red'>*</font>Buyer Name</td>
	 			<td class="CONTROL" width="25%">
	 				<select name="strBuyerName" class="comboNormal">
	 					<bean:write name="condemnRegisterTransBean" property="strBuyerListValues" filter="false"/>
	 				</select>
	 			</td>
	 			<td class="LABEL" width="25%">Weight</td>
	 			<td class="CONTROL" width="25%">
	 				<input name="strWt" value="0" onkeypress="return validateData(event,5);"  class="txtFldMin" maxlength="10">
	 			</td>
	 		</TR>	
	 		<TR>
	 			<td class="LABEL" width="25%">Payment Mode</td>
	 			<td class="CONTROL" width="25%" colspan="">
	 				<select name="strPaymentMode" class="comboNormal">
	 					<option value="1">Cheque</option>
	 					<option value="2">Demand Draft</option>
	 				</select>
	 			
	 			</td>
	 			<td class="LABEL" width="25%"><font color='red'>*</font>Amount Receive </td>
	 			<td class="CONTROL" width="25%"><input type="text" name="strAmountRecieved" class="txtFldNormal" maxlength="14" onkeypress="return validateData(event,7);"></td>
	 		</TR>	
	 		<TR>
	 			<td class="LABEL" width="25%"><font color='red'>*</font>Cheque No./Draft No.</td>
	 			<td class="CONTROL" width="25%"><input type="text" name="strInstrumentNo" class="txtFldNormal" maxlength="10" onkeypress="return validateData(event,5);">
	 			</td>
	 			<td class="LABEL" width="25%">Instrument Date</td>
	 			<td class="CONTROL" width="25%"><date:date name="strInstrumentDate" value ="${condemnRegisterTransBean.strCtDate}"></date:date></td>
	 		</TR>
	 		<TR>
	 			<td class="LABEL" width="25%"><font color='red'>*</font>Bank Name</td>
	 			<td class="CONTROL" width="25%" colspan="3"><input type="text" name="strBankName" class="txtFldMax" maxlength="100">
	 			
	 			
	 			</td>
	 			
	 		</TR>	
	 		<tr>
	 			<td colspan="4" class="TITLE"></td>
	 		</tr>
	 	</table>
	 </div>
	<table class="TABLEWIDTH" align="center" cellspacing="1px">
	 	<TR>
	 		<td class="LABEL" width="25%"><font color='red'>*</font>Committe Type</td>
	 		<td class="CONTROL" width="25%">
	 			<select name="strCommitteType" class="comboNormal" onchange="getMemberDtl('COMMITEEMEMBERDTL');"> 
	 				<bean:write name="condemnRegisterTransBean" property="strCommitteTypeValue" filter="false"/>
	 			</select>
	 		</td>
	 	<td  class="LABEL" width="25%" >
					Committee Member Dtl  
		</td>
		<td class="CONTROL" >
			<img src="../../hisglobal/images/Patient.png" 
									onClick="openDivPopu();" style="cursor: pointer; " title="Click Here To See Member Details"/>
		</td>
	 		
	 </table> 
	 <jsp:include page="uploadFile.jsp"></jsp:include>
	 <table class="TABLEWIDTH" align="center" cellspacing="0px" cellpadding="1px">
	 	<TR>
	 		<td class="LABEL" width="50%">Remarks</td>
	 		<td class="CONTROL" width="50%">
	 			<textarea rows="2" cols="25" name="strRemarks"></textarea>
	 		</td>
	 		<td class="CONTROL" width="25%" colspan=""></td>
	 		<td class="CONTROL" width="25%" colspan=""></td>
	 </table>
	 
		<table CLASS ="TABLEWIDTH" align="center" cellspacing="1px">
		<tr class="FOOTER"> 
    	<td colspan="2" ><font size="2" color="red">*</font> Mandatory Fields  </td>
  		</tr>
	     <tr> 
		<td align="center">
		<img src="../../hisglobal/images/btn-sv.png"   onClick="return validate1();" style="cursor: pointer;" title="Click Here To Save"/>
		<img src="../../hisglobal/images/btn-clr.png" onClick ="document.forms[0].reset();" style="cursor: pointer;" title="Click Here To Reset Data"/>
		<img src="../../hisglobal/images/back_tab.png" onClick ="cancelToDesk();" style="cursor: pointer;" title="Click Here To Cancel"/>
	   </td>
	  </tr>
</table>
		<input type="hidden" name="hmode"/>
	    <input type="hidden" name="strStoreId" value="${condemnRegisterTransBean.strStoreId}"/>
		<input type="hidden" name="strItemCategoryNo" value="${condemnRegisterTransBean.strItemCategoryNo}"/>
		<input type="hidden" name="strAgendaNo" value="${condemnRegisterTransBean.strAgendaNo}"/>
		<input type="hidden" name="strAgendaNo" value="${condemnRegisterTransBean.strAgendaNo}"/>
		<input type="hidden" name="strAgendaDate" value="${condemnRegisterTransBean.strAgendaDate}"/>
		<input type="hidden" name="strAgendaDate" value="${condemnRegisterTransBean.strAgendaDate}"/>
		<input type="hidden" name="chk" value="${condemnRegisterTransBean.chk}"/>
		<input type="hidden" name="comboName" value="${condemnRegisterTransBean.comboName}"/>
      	<input type="hidden" name="strPath" value="${condemnRegisterTransBean.strPath}"/>
      	<input type="hidden" name="strCondemnationTypeName" value="${condemnRegisterTransBean.strCondemnationTypeName}"/>
      	<input type="hidden" name="strCondemnationType" value="${condemnRegisterTransBean.strCondemnationType}"/>
      	 <input type="hidden" name="cnt_page" value="${condemnRegisterTransBean.cnt_page}"/>
      	 
	      
<cmbPers:cmbPers/>
<div id="blanket" style="display:none;"></div>
<div class="popUpDiv" id="memberDtl" style="display:none;">
<table bgcolor="white">
<tr>
<td>
<div id="memberDtlInner" style="display:block;"></div>
</td>
</tr>
</table>
</div>
</html:form>
<cmbPers:cmbPers />
<tag:autoIndex></tag:autoIndex>  
</body>
</html>