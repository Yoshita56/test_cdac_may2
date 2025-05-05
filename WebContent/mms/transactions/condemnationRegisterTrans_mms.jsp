<%@page language="java" contentType="text/html" pageEncoding="UTF-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<%@taglib uri="/WEB-INF/dateTag.tld" prefix="dateTag"%>
<%@ taglib uri="/WEB-INF/hisTab.tld" prefix="tag"%>
<%@ taglib uri="/WEB-INF/comboPersistence.tld" prefix="cmbPers" %>


<head>
<meta charset=UTF-8">
<title>Condemnation Register View</title>
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
<script language="Javascript" src="../js/condemnationRegisterTrans.js"></script>

</head>
<body onload="chkCondemnDtls();">
<html:form name="condemnRegisterViewBean" action="/transactions/CondemnationRegisterViewTransCNT"
	type="mms.transactions.controller.fb.CondemnationRegisterViewTransFB">
	
<center>
	<div id="errMsg" class="errMsg"><bean:write name="condemnRegisterViewBean" property="strErrMsg" /></div>
	<div id="warningMsg" class="warningMsg"><bean:write name="condemnRegisterViewBean" property="strWarningMsg"/></div>
	<div id="normalMsg" class="normalMsg"><bean:write name="condemnRegisterViewBean" property="strNormalMsg"/></div>
	
</center>
	
        <tag:tab tabLabel="Condemnation Register View"
				selectedTab="FIRST" align="center" width="TABLEWIDTH">
              </tag:tab>

		
	 <div class='popup' id='itemDtlId' style="display:none">
		<table width='450' border="0" cellspacing ="0px" cellpadding="0px">
			<tr class="HEADER"> 
				<th align='left'><div id="popUpItemId"></div></th>
				<th align='right'><img  style='cursor:pointer;cursor:pointer' src='../../hisglobal/images/popUp_cancel.JPG'
					onClick="closeItemPopUp('itemDtlId');" title="Click Here To Close Popup"></th>
		    </tr>
		 </table>  
	  
	  
		 <table width='450' border="0" cellspacing ="1px" cellpadding="1px">
			<tr>
				<td colspan="1" class='multiLabel'>Last P.O. No.</td>
				<td colspan="1" class='multiControl'><div id ='1'></div></td>
				<td colspan="1" class='multiLabel'>Last P.O. Date</td>
				<td colspan="1" class='multiControl' ><div id ='2'></div></td>			
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
			

	<table class="TABLEWIDTH" align="center" cellpadding="1px" cellspacing="1px">   
	<tr class="HEADER">
			<td colspan="4"></td>
	</tr>
	
	<tr>
    <td class="LABEL" width="25%" colspan="1">Store Name</td>
    <td width="25%" class ="CONTROL" colspan="3">
    <bean:write name="condemnRegisterViewBean" property="strStoreId" filter="false" />
     </td>
  </tr>	

    <tr>
		<td class="LABEL" width="25%" colspan="1">Agenda No</td>
    	<td width="25%" class ="CONTROL" colspan="1">
    	<bean:write name="condemnRegisterViewBean" property="strAgendaNo" filter="false" />
    	 </td>
    	<td class="LABEL" width="25%" >Agenda Date</td>
       	 <td class="CONTROL" width="25%" >
       	 <bean:write name="condemnRegisterViewBean" property="strAgendaDate" filter="false"/>
       	 
       	 </td>
 	</tr>
 
   </table>
  
  	
	 <table class="TABLEWIDTH" align="center" cellspacing="1px">
		<tr>
			<td  colspan="4" class="TITLE">
			<div id="plusItemId" align="left" style="display:none;color:blue;">
					<img src="../../hisglobal/images/plus.gif" 
									onClick="view1('plusItemId','minusItemId','itemDetailId');" style="cursor: pointer; "/>
						Item Details
					</div>
					<div id="minusItemId" style="display:block;color:blue;" align="left">
						<img src="../../hisglobal/images/minus.gif" 
								onClick="view2('plusItemId','minusItemId','itemDetailId');" style="cursor: pointer; "/>
								Item Details
					</div>
				</td>
		</tr>
	</table>
	
	
	<div id="itemDetailId" style="display:block">
		<bean:write name="condemnRegisterViewBean" property="strSetItemDetails" filter="false" />
	</div>
	 
	 
	 <table class="TABLEWIDTH" align="center" cellpadding="1" cellspacing="1">
	 <tr>
  		 <td colspan="4" class="TITLE"><div id='' style='color:blue;'>Condemnation Details</div></td>
     </tr>
	 <tr>
	 
	 <td class="LABEL" width="50%" colspan="1">Condemnation Type</td>
	 
    <td width="50%" class ="CONTROL">
    	<div id="condemnationTypeId">
    		<bean:write name="condemnRegisterViewBean" property="strCondemnationTypeName" filter="false" />
    	</div>
    </td>
    </tr>
    </table>
    
    
    <div id="showCondemnDtls" style="display:none">
		<table class="TABLEWIDTH" align="center" cellpadding="1" cellspacing="1"> 
			<tr>
				 <td colspan="4" class="TITLE"><div id="" style="color:blue;">Auction Details</div></td>
			</tr>
		    <tr>
		    
			    <td class="LABEL" width="25%" colspan="1">Tender No.</td>
			    <td width="25%" class ="CONTROL" colspan="1">
			   		 <bean:write name="condemnRegisterViewBean" property="strTenderNo" filter="false" />
			    </td>
			    <td class="LABEL" width="25%" colspan="1">Tender Date</td>
			    <td width="25%" class ="CONTROL" colspan="1">
			    	<bean:write name="condemnRegisterViewBean" property="strTenderDate" filter="false" />
			    </td>
			</tr>
			 
			<tr>
		    
			    <td class="LABEL" width="25%" colspan="1">Quotation No.</td>
			    <td width="25%" class ="CONTROL" colspan="1">
			    		<bean:write name="condemnRegisterViewBean" property="strQuotationNo" filter="false" />
			    </td>
			    <td class="LABEL" width="25%" colspan="1">Quotation Date</td>
			    <td width="25%" class ="CONTROL" colspan="1">
			    		<bean:write name="condemnRegisterViewBean" property="strQuotationDate" filter="false" />
			    </td>
			 </tr>
			 
			 <tr>
				  <td class="LABEL" width="25%" colspan="1">Buyer Name</td>
			      <td width="25%" class ="CONTROL" colspan="1">
			    		<bean:write name="condemnRegisterViewBean" property="strBuyerName" filter="false" />
			      </td>
			     <td class="LABEL" width="25%" colspan="1">Amount Received</td>
			     <td width="25%" class ="CONTROL" colspan="1">
			    		<bean:write name="condemnRegisterViewBean" property="strAmountReceived" filter="false" />
			     </td>
			 </tr>
			 <tr>
				  <td class="LABEL" width="25%" colspan="1">Weight</td>
			      <td width="25%" class ="CONTROL" colspan="1">
			    		<bean:write name="condemnRegisterViewBean" property="strWeight" filter="false" />
			      </td>
			     <td class="CONTROL" width="25%" colspan="3"></td>
			     
			 </tr>
			 <tr>
				<td class="LABEL" width="25%" colspan="1">Payment Mode</td>
			    <td width="25%" class ="CONTROL" colspan="1">
			    		<bean:write name="condemnRegisterViewBean" property="strPaymentMode" filter="false" />
			     
				<td class="LABEL" width="25%" colspan="1">Bank Name</td>
			    <td width="25%" class ="CONTROL" colspan="1">
			    		<bean:write name="condemnRegisterViewBean" property="strBankName" filter="false" />
			    </td>	
			 </tr>
			
			<tr>
			    <td class="LABEL" width="25%" colspan="1">Cheque No./Draft No.</td>
			    <td width="25%" class ="CONTROL" colspan="1">
			    		<bean:write name="condemnRegisterViewBean" property="strInstNumber" filter="false" />
			    </td>
			    <td class="LABEL" width="25%" colspan="1">Instrument Date</td>
			    <td width="25%" class ="CONTROL" colspan="1">
			    		<bean:write name="condemnRegisterViewBean" property="strInstDate" filter="false" />
			    </td>
			</tr>
		</table>
	 </div>
	 

	  <table class="TABLEWIDTH" align="center"  cellspacing="1Px"> 
	 	<tr>
	  <td class="LABEL" width="50%" colspan="1">Committee Type</td>
    <td width="50%" class ="CONTROL" >
    <bean:write name="condemnRegisterViewBean" property="strCommitteeType" filter="false" />
     </td>
	 </tr>
	 <tr>
	 	<td class="LABEL" width="50%" colspan="1">Remarks</td>
    	<td width="50%" class ="CONTROL" >
   			 <bean:write name="condemnRegisterViewBean" property="strRemarks" filter="false" />
    	 </td>
	 </tr>
	 </table>
	
	 <table class="TABLEWIDTH" align="center" cellpadding="1" cellspacing="1">
	 
	 <tr class="FOOTER">
			<td colspan="6"></td>
	</tr>
	 
	 
	 </table>
	 
	<table class="TABLEWIDTH" align="center" cellpadding="1" cellspacing="1">
		<tr>

			<td align="center">
			<img  style="cursor: pointer; " 
					src="../../hisglobal/images/back_tab.png" onClick="cancelWindow();" >
		</td>
		</tr>
	</table>
	
	
<input type="hidden" name="hmode"/>
<input type="hidden" name="strCondemnationType" value="${condemnRegisterViewBean.strCondemnationType}"/>
<input type="hidden" name="strCondemnationTypeName" value="${condemnRegisterViewBean.strCondemnationTypeName}"/>

<input type="hidden" name="strPath" value="${condemnRegisterViewBean.strPath}"/>
<cmbPers:cmbPers/>
</html:form>
<tag:autoIndex></tag:autoIndex>  
</body>
