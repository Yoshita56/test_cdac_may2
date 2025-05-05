<%@page language="java" contentType="text/html" pageEncoding="UTF-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<%@taglib uri="/WEB-INF/dateTag.tld" prefix="dateTag"%>
<%@ taglib uri="/WEB-INF/hisTab.tld" prefix="tag"%>

<!-- 
/**
 * @author Amit Kumar
 * Date of Creation : 07/4/2009
 * Date of Modification :  /  / 
 * Version : 1.0
 * Module  : Store
 */
 -->
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
<script language="Javascript" src="../../hisglobal/js/popup.js"></script>
<script language="JavaScript" src="../js/PODeskTransADD.js"></script>

</head>

<body>

<html:form action="/transactions/PODeskTransADDCNT.cnt"  name="poDeskTransADDBean" type="mms.transactions.controller.fb.PODeskTransADDFB" method="post">

    <div class="errMsg"     id="errMsg">    <bean:write name="poDeskTransADDBean" property="strErr"/></div>
	<div class="warningMsg" id="warningMsg"><bean:write name="poDeskTransADDBean" property="strWarning"/></div>
	<div class="normalMsg"  id="normalMsg"> <bean:write name="poDeskTransADDBean" property="strMsg"/></div>


<center>

   <div class='popup' id='ItemDtlPopUp' style="display:none">
	<table width='400' border="0" cellpadding="1px" cellspacing ="1px">
		<tr class="HEADER"> 
			<th colspan='3' align='left'>&nbsp;<div id='' style='color:blue;'>Item Details</div></th>
			<th colspan='1' align='right'><img  style='cursor:pointer;cursor:pointer' src='../../hisglobal/images/popUp_cancel.JPG'
				onClick="hideItemDetails('ItemDtlPopUp');"></th>
	    </tr>
	 </table>   
	 <table  width='400' border="0" cellpadding="1px" cellspacing ="1px">
		<tr>
			<td width="25%" class='LABEL'>Brand Name</td>
			<td width="25%" class='CONTROL'><div id ='1'></div></td>
			<td width="25%" class='LABEL'>Req Qty</td>
			<td width="25%" class='CONTROL'><div id ='2'></div></td>
		</tr>
		
        </table>
	</div>

<tag:tab tabLabel="PO DESK ADD" selectedTab="FIRST" align="center" width="TABLEWIDTH">
	</tag:tab>
</center>
	<table class="TABLEWIDTH" align="center" cellspacing="1px">
	 <tr class="HEADER">
			<td colspan="4"></td>
	 </tr>
	   <tr>
		<td class="LABEL" width="25%">Store Name:</td>
    	<td width="25%" class ="CONTROL"><bean:write name="poDeskTransADDBean" property="strStoreName" filter="false"/></td>
    	<td width="25%" class="CONTROL"></td>
         <td width="25%" class="CONTROL"></td>   
   	</tr>
	 
		<tr> 
         <td width="25%" class="LABEL">PO Type:</td>
         <td width="25%" class="CONTROL">
                 <select name="strPOType" class="comboNormal"   onChange="">
                        <bean:write name="poDeskTransADDBean" property="strPOType" filter="false"/>
                 </select>
         </td>   
         <td width="25%" class="LABEL"><div id="Indent" style="display:block;">Indent No:</div><div id="Agenda" style="display:none;">Agenda No:</div></td>
         <td width="25%" class="CONTROL">
         
         <div id='Agenda1' style='display:none'>
		               <input class="txtFldNormal" type="text" name="strAgendaNo" value="" maxlength="13" onkeypress="return validateData(event,8);" disabled="disabled">
         </div>
		 <div id='Indent1' style='display:block'>
		                 <select name="strIndentNo" class="comboNormal"   onChange="">
                               <bean:write name="poDeskTransADDBean" property="strIndentNo" filter="false"/>
                         </select>
		 </div>
         
         
         
         
                 
         </td>   
        </tr>
		  
	<tr>
		<td class="LABEL" width="25%">Supplier Name:</td>
    	<td width="25%" class ="CONTROL">
    	<select name="strSupplName" class="comboNormal">
					<bean:write name="poDeskTransADDBean" property="strSupplName" filter="false"/>
					</select>
					<img style="cursor:pointer;cursor:pointer" title="Get Supplier Details" src="../../hisglobal/images/Go.png" align="top" onclick="goFunc();"/></td>
    	<td width="25%" class="CONTROL"></td>
         <td width="25%" class="CONTROL"></td>   
   	</tr>
   	<tr>
		<td class="LABEL" width="25%">CR NO\Emp Id:</td>
    	<td width="25%" class ="CONTROL"></td>
    	<td width="25%" class="LABEL">Patient Name\Emp Name</td>
         <td width="25%" class="CONTROL"></td>   
   	</tr>
   	
   	
	    </table>
	    
	<div id="forigenSupplDtl" style="display:block;">    
    <table class="TABLEWIDTH" align="center" cellspacing="1px">
    <tr class="TITLE"> 
      <td colspan="4"><div id="ag" style="color:blue;">Agency Details</div></td>
    </tr>
	 <tr> 
         <td width="25%" class="LABEL">Agency Name:</td>
         <td width="25%" class="CONTROL">
                 <select name="strAgencyName" class="comboNormal"   onChange="">
                        <bean:write name="poDeskTransADDBean" property="strAgencyName" filter="false"/>
                 </select>
         </td>   
         <td width="25%" class="LABEL">CA Name:</td>
         <td width="25%" class="CONTROL">
                 <select name="strCAName" class="comboNormal"   onChange="">
                        <bean:write name="poDeskTransADDBean" property="strCAName" filter="false"/>
                 </select>
         </td>   
        </tr>
        <tr> 
         <td width="25%" class="LABEL">Curreny Code:</td>
         <td width="25%" class="CONTROL">
                 <select name="strCurrencyCode" class="comboNormal"   onChange="">
                        <bean:write name="poDeskTransADDBean" property="strCurrencyCode" filter="false"/>
                 </select>
         </td>   
         <td width="25%" class="LABEL">IAC Change(%):</td>
         <td width="25%" class="CONTROL">
                 <select name="strIACChg" class="comboNormal"   onChange="">
                        <bean:write name="poDeskTransADDBean" property="strIACChg" filter="false"/>
                 </select>
         </td>   
        </tr>
        
        <tr>
		    <td class="LABEL" width="25%">Freight &amp; Insurance Charges(%):</td>
        	<td width="25%" class ="CONTROL"><input type="text" class="txtFldNormal"
					name="strFrghtInsurChg" maxlength="25" value=""
					onkeypress="return validateData(event,9);"></td>
					
			<td width="25%" class="LABEL"></td>
             <td width="25%" class="CONTROL">
                
         </td>   		
      	</tr>
        
        
      </table>
    
    </div>
    
    <div id="tenderDtl" style="display:block;">
     <table class="TABLEWIDTH" align="center" cellspacing="1px">
     <tr class="TITLE"> 
      <td colspan="4"><div id="Te" style="color:blue;">Tender Details</div></td>
    </tr>  
       <tr>
				<td width="25%" class="LABEL">
				   <div id="ast1" style='display:block'><font  color="red">*</font>Tender No.</div>
				   <div id="ast11" style='display:none'>Tender No.</div>
				</td>
				<td width="25%" class="CONTROL"><input type="text" class="txtFldNormal"
					name="strTenderNo" maxlength="25" value=""
					onkeypress="return validateData(event,9);"></td>
					<td width="25%" class="LABEL">
					<div id="ast2" style='display:block'><font color="red">*</font>Tender Date.</div>
					<div id="ast22" style='display:none'>Tender Date.</div>
					</td>
					
				<td width="25%" class="CONTROL" colspan="2">
				  <dateTag:date name="strTenderDate" value ="${poDeskTransADDBean.strCtDate}"></dateTag:date>
				</td>
			</tr>
			<tr>
				<td width="25%" class="LABEL" >
				<div id="ast3" style='display:block'><font  color="red">*</font>Quotation No</div>
				<div id="ast33" style='display:none'>Quotation No</div>
				</td>
				<td width="25%" class="CONTROL"><input type="text" class="txtFldNormal"
					name="strQutNo" maxlength="25" value=""
					onkeypress="return validateData(event,9);"></td>
					<td width="25%" class="LABEL">
					<div id="ast4" style='display:block'><font color="red">*</font>Quotation Date</div>
					<div id="ast44" style='display:none'>Quotation Date</div>
					</td>
				<td width="25%" class="CONTROL"><dateTag:date name="strQutDate" value ="${poDeskTransADDBean.strCtDate}"></dateTag:date></td>
			</tr>
			
    </table>
    </div>
          
          <table class="TABLEWIDTH" align="center">
           <tr>
              <bean:write name="poDeskTransADDBean" property="strItemDtl" filter="false"/>
           </tr>
          </table>
      
      
   <table class="TABLEWIDTH" align="center"  border="0" cellspacing ="1px">
 	<tr> 
    <td width="50%" class="LABEL"><input type='checkbox' name='strChkBox' onClick="ftnTick(this)">Whether Advance Has To Pay:</td>
   
    <td width="50%" class="CONTROL"><input name="strAdvanceToPay" type="text"  class="txtFldMin"  value="${poDeskTransADDBean.strQutNo}"  onkeypress="return validateData(event,7);" disabled='disabled'>(%)</td>
       
       
      

    </tr>
    </table>
     <table class="TABLEWIDTH" align="center"  border="0" cellspacing ="1px">
    <tr> 
         <td width="25%" class="LABEL">Delivery Date:</td>
         <td width="25%" class="CONTROL">
                 <dateTag:date name="strQutDate" value ="${poDeskTransADDBean.strCtDate}"></dateTag:date>
         </td>   
         <td width="25%" class="LABEL">Dilevery Location:</td>
         <td width="25%" class="CONTROL">
                 <select name="strIndentNo" class="comboNormal"   onChange="">
                        <bean:write name="poDeskTransADDBean" property="strIndentNo" filter="false"/>
                 </select>
         </td>   
        </tr>
        
        <tr> 
         <td width="25%" class="LABEL">Payment Mode:</td>
         <td width="25%" class="CONTROL">
                 <select name="strIndentNo" class="comboNormal"   onChange="">
                        <bean:write name="poDeskTransADDBean" property="strIndentNo" filter="false"/>
                 </select>
         </td>   
         <td width="25%" class="LABEL">Part Deleivery Allowed:</td>
         <td width="25%" class="CONTROL"><input type='checkbox' name='strQutNo' onClick="ftnTick()"></td>   
        </tr>
        
    
      
  </table>
  <table class="TABLEWIDTH" align="center" cellspacing="1px">  
        <tr class="TITLE">
			 <td colspan="4"><div id="Comp" style="color:blue;">Component Details</div></td>
		</tr>
		<tr >
         <td width ="50%" class ="LABEL" valign="top">Component Name</td>
         <td width ="50%" class ="CONTROL"><textarea  name="remark" cols="10" rows="2" ></textarea><textarea  name="remark" cols="10" rows="2" ></textarea></td>
         
      </tr>
      <tr >
         <td width ="50%" class ="LABEL" valign="top">Company Name</td>
         <td width ="50%" class ="CONTROL"><textarea  name="remark" cols="10" rows="2" ></textarea><textarea  name="remark" cols="10" rows="2" ></textarea></td>
         
      </tr>
      <tr >
    <td width ="50%" class ="LABEL" valign="top">Remarks if Any</td>
    <td width ="50%" class ="CONTROL"><textarea  name="remark" cols="10" rows="2" ></textarea></td>
    </tr>
	</table>
  
  
      
	<table class="TABLEWIDTH" align="center" cellspacing="1px">  
        <tr class="FOOTER">
			 <td colspan="2"><font size="2" color="red">*</font> Mandatory Fields  </td>
		</tr>
	</table>
	
	
	<table  class="TABLEWIDTH" align="center">
	  <tr>
			<td align="center">
	                <img style="cursor:pointer;cursor:pointer" title="Click to Save Record" src="../../hisglobal/images/btn-sv.png"  onClick=" return validate1();" />
	                <img style="cursor:pointer;cursor:pointer" title="Click to Clear Page" src="../../hisglobal/images/btn-clr.png" name="clearImg" onclick="initPage();">
	                <img style="cursor: pointer; " title="Click to Return Main Menu" src="../../hisglobal/images/back_tab.png" onClick="cancel('CANCEL');" />
			</td>
		</tr>
	</table>	
    
    <input type="hidden" name="hmode"/>
     
</html:form>

<tag:autoIndex></tag:autoIndex>  
</body>
</html>