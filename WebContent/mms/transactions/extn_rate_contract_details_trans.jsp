<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<%@taglib uri="/WEB-INF/dateTag.tld" prefix="dateTag"%>
<%@ taglib uri="/WEB-INF/hisTab.tld" prefix="tag"%>
<%@ taglib uri="/WEB-INF/comboPersistence.tld" prefix="cmbPers" %>


<html>
<head>
<meta charset=UTF-8">
<title>Rate Contract Details</title>
<link href="../css/transaction.css" rel="stylesheet" type="text/css">
<link href="../../hisglobal/css/tab.css" rel="stylesheet" type="text/css">
<link href="../../hisglobal/css/calendar-tas.css" rel="stylesheet" type="text/css">
<link href="../../hisglobal/css/buttons.css" rel="stylesheet" type="text/css">
<link href="../../hisglobal/css/popup.css" rel="stylesheet" type="text/css">	
<link href="../../hisglobal/css/newpopup.css" rel="stylesheet" type="text/css">
	
<script language="JavaScript" src="../../masterutil/js/master.js"></script>
<script language="JavaScript" src="../../hisglobal/js/tab.js"></script>
<script language="JavaScript" src="../../hisglobal/js/calendar.js"></script>
<script language="Javascript" src="../../hisglobal/js/validation.js"></script>
<script language="Javascript" src="../../hisglobal/js/util.js"></script>
<script language="Javascript" src="../../hisglobal/js/newpopup.js"></script>
<script language="Javascript" src="../../hisglobal/js/multirow.js"></script>
<script language="Javascript" src="../js/rate_contract_trans.js"></script>



<script language="javaScript">


function validateRenew()
{   
     
      var hisValidator = new HISValidator("rateContractDtlBean"); 
       var retVal=true;
         
            hisValidator.addValidation("strDeliveryDays",     "req", "Delivery Day(s) is a Mandatory Field" );
             if(parseInt(document.forms[0].strDeliveryDays.value)==0)
             {
             	alert("Please Enter Delivery Day(s) Greater than Zero!!!");
             	return false;
             }
            //alert("Contract From:::"+document.forms[0].strContractFromDate.value);
            //alert("Previous Contract From:::"+document.forms[0].strPreviousContractFromDate.value);
            hisValidator.addValidation("strContractFromDate", "req", "Contract From Date is a Mandatory Field" );
	        hisValidator.addValidation("strContractToDate",   "req", "Contract To Date is a Mandatory Field" ); 
            hisValidator.addValidation("strTenderDate",       "req", "Tender Date is a Mandatory Field" );
            
            if(document.forms[0].strContractFromDate.value!='')
            {
            	//alert("document.forms[0].ctDate.value"+document.forms[0].ctDate.value);
            	hisValidator.addValidation("strContractFromDate", "dtgtet="+document.forms[0].ctDate.value+"", "Contract From Date should be Greater than or Equal to Current Date");
            }
            
            if(document.forms[0].strContractToDate.value!='')
            {
            	hisValidator.addValidation("strContractToDate",   "dtgt="+document.forms[0].ctDate.value+"", "Contract To Date should be greater than Contract From Date");
            }
            
            
            //hisValidator.addValidation("strContractFromDate", "dtgtet=${rateContractDtlBean.strCtDate}", "Contract To Date should be greater than or Equal to Current Date");
//            hisValidator.addValidation("strContractToDate",   "dtgtet=${rateContractDtlBean.strNextContractFromDate}", "Contract To Date should be greater than or Equal to Contract From Date");
            hisValidator.addValidation("strTenderDate",       "dtltet="+document.forms[0].strContractFromDate.value+"", "Tender Date should be Less than or Equal to Contract From Date");
            hisValidator.addValidation("strRemarks",          "maxlen=100", "Remarks should have less than or equal to 100 Characters" );
            hisValidator.addValidation("strRenewRate",        "req", "Rate is a Mandatory Field" );  
            hisValidator.addValidation("strRenewRate",        "amount=11,2", "Rate should be in format 000000000.00" );
            hisValidator.addValidation("strRenewRateUnitId",  "dontselect=0", "Please select a Unit" );  
            hisValidator.addValidation("strRenewRateContQty",       "req",  "Qty is a Mandatory Field" );  
            hisValidator.addValidation("strRenewSecurityAmtPercent", "req", "Security Amount is a Mandatory Field" ); 
            hisValidator.addValidation("strRenewShelfLife", "req", "Shelf Life is a Mandatory Field" ); 
            retVal = hisValidator.validate(); 
            hisValidator.clearAllValidations();
         
           if(retVal)
           {
          				var conf = confirm("You are going to save data. Are you sure?");
          				if(conf = true)
          				{
	          				document.forms[0].hmode.value = "INSERTRENEW";
	                        document.forms[0].submit();          				
          				}
          				else
          				{
          					return false;
          				}          				
            }
            else
            {
					return false;
			}
    }

function CalculateSecurityAmt1()
{
	  	var  rate  = "";    
	  	var  qty   = "";
	  	var  finalRate  = 0.00;
	  	var  cost  = 0.00;
	  	var  rate_unit_base_value = "";
        
        rate    = trimAll(document.getElementById("strRenewRate").value);
        qty     = trimAll(document.getElementById("strRenewRateContQty").value);
       
		if(rate == "" || rate.length <=0)
		{
			rate = "0";
		}
		if(qty == "" || qty.length <=0)
		{
			qty = "0";
		}		
		if(document.getElementById("strRenewRateUnitId").value!="0")
        {
          rate_unit_base_value = document.getElementById("strRenewRateUnitId").value.split("^")[1];
          cost = parseFloat((qty  * rate)/rate_unit_base_value);
		}
		else
		{
		   cost = parseFloat(qty  * rate);
		}
		var  amtPerecentage = "";
		var  amtPerecentage = trimAll(document.getElementById("strRenewSecurityAmtPercent").value);
			   
	    if(amtPerecentage != "" && amtPerecentage.length > 0)
	    {
	    	finalRate = ( cost * parseFloat(amtPerecentage))/100;
	    }
	    else
	    {
	        finalRate  = cost;
	    }
	    
	    document.getElementById("strRenewSecurityAmount").value = roundValue(finalRate, 2);	    
} 

function showPrevRenewDtls()
{
    
	if(document.forms[0].strPrevRenewFlag.value==1)
	
	document.getElementById("previousRenewDtlsDiv").style.display="block";
	
	//document.forms[0].strContractToDate.focus();
	
	if(document.forms[0].strTaxTypeNumValue.value==1)
	{
	   document.getElementById("taxTypeDiv").innerHTML ="VAT";				
    }
    else
    {
       document.getElementById("taxTypeDiv").innerHTML ="CST";				
    }
    
    
    document.getElementById("importedType").innerHTML=document.getElementsByName("strImportTypeViewFlag")[0].value;
    
}
</script>

</head>
<body onLoad="showPrevRenewDtls();">
<html:form name="rateContractDtlBean" action="/transactions/RateContractDtlTransCNT"
	type="mms.transactions.controller.fb.RateContractDtlTransFB">

<center>
	<div id="errMsg" class="errMsg"><bean:write name="rateContractDtlBean"
		property="strErr" /></div>
	<div class="warningMsg"><bean:write name="rateContractDtlBean"
		property="strWarning" /></div>
	<div id="normalMsg" class="normalMsg"><bean:write name="rateContractDtlBean"
		property="strMsg" /></div>


	<tag:tab tabLabel="Rate Contract Details"
				selectedTab="FIRST" align="center" width="TABLEWIDTH">
			</tag:tab>
			</center>
	<table class="TABLEWIDTH" align="center" cellpadding="1px" cellspacing="1px">

		<tr class="HEADER">
			<td colspan="4">Rate Contract Details&gt;&gt; Extension</td>
		</tr>

		<tr>
			<td class="LABEL" width="25%" >Supplier Name</td>
			<td width="25%" class="CONTROL" ><bean:write name="rateContractDtlBean"
				property="strSupplierName" filter="false" /></td>
				
				<td class="LABEL" width="25%" >Contract Type</td>
			<td width="25%" class="CONTROL" ><bean:write name="rateContractDtlBean"
				property="strContractType" filter="false" /></td>			

		</tr>		
		</table>
		<div id="previousRenewDtlsDiv" style="display: none" >
		<table class="TABLEWIDTH" align="center" cellpadding="1px" cellspacing="1px">
		<tr>
			<td class="TITLE"  colspan="4">Renew Detail(s)</td>
		</tr>
		<tr>
			
			<td class="LABEL" width="25%">Validity</td>
			<td class="CONTROL" colspan="1">
			   <bean:write name="rateContractDtlBean" property ="strPrevRenewContractFromDate" filter="false"></bean:write>/<bean:write name="rateContractDtlBean" property ="strPrevRenewContractToDate" filter="false"></bean:write>
			</td>
			
		</tr>
				
		     <tr>
				<td width="25%" class="LABEL">Tender No.</td>
				<td width="25%" class="CONTROL"><bean:write name="rateContractDtlBean" property ="strPrevRenewTenderNo" filter="false"></bean:write>
				</td>
					<td width="25%" class="LABEL">Quotation No.</td>
				<td width="25%" class="CONTROL"><bean:write name="rateContractDtlBean" property ="strPrevRenewQuotationNo" filter="false"></bean:write>
				</td>
			</tr>
			
			 <tr>
				<td width="25%" class="LABEL">Tender Date.</td>
				<td width="25%" class="CONTROL"><bean:write name="rateContractDtlBean" property ="strPrevTenderDate" filter="false"></bean:write>
				</td>
					<td width="25%" class="LABEL">Quotation Date.</td>
				<td width="25%" class="CONTROL"><bean:write name="rateContractDtlBean" property ="strPrevQuotationDate" filter="false"></bean:write>
				</td>
			</tr>
			<tr>
				<td width="25%" class="LABEL">Drug Name</td>
				<td width="25%" class="CONTROL">
				    <bean:write name="rateContractDtlBean" property ="strPrevRenewItemName" filter="false"></bean:write>
				</td>
			    <td width="25%" class="LABEL">Rate/Unit</td>
				<td width="25%" class="CONTROL">
				    <bean:write name="rateContractDtlBean" property ="strPrevRenewRate" filter="false"></bean:write> <bean:write name="rateContractDtlBean" property ="strPrevRenewRateUnit" filter="false"></bean:write>
				</td>
			</tr>
			<tr>
				<td width="25%" class="LABEL">Tax(%).</td>
				<td width="25%" class="CONTROL"><bean:write name="rateContractDtlBean" property ="strPrevTaxWithType" filter="false"></bean:write>
				</td>
				<td width="25%" class="LABEL">Security Amount(%)</td>
				<td width="25%" class="CONTROL">
				   <bean:write name="rateContractDtlBean" property ="strPrevSecurityAmt" filter="false"></bean:write>
				</td>
				
			</tr>	
			<tr>
				
				<td width="25%" class="LABEL">Rate Contract Qty</td>
				<td width="25%" class="CONTROL">
				   <bean:write name="rateContractDtlBean" property ="strPrevContractQty" filter="false"></bean:write>
				</td>
				<td width="25%" class="LABEL">Shelf Life (In Days)</td>
				<td width="25%" class="CONTROL">
				   <bean:write name="rateContractDtlBean" property ="strRenewShelfLife" filter="false"></bean:write>
				</td>
			</tr>
			<tr>				
				<td width="25%" class="LABEL">Level</td>
				<td width="25%" class="CONTROL"><bean:write name="rateContractDtlBean" property ="strRenewLevel" filter="false"/></td>
			   
			   <td width="25%" class="LABEL">Remarks</td>
				<td  class="CONTROL" >
				<bean:write name="rateContractDtlBean" property ="strPrevRenewRemarks" filter="false"></bean:write>
				</td>
		  </table> 
		</div>
		<table class="TABLEWIDTH" align="center" cellpadding="1px" cellspacing="1px">
		<tr>
			<td class="TITLE"  colspan="4">Current Contract Detail(s)</td>
		</tr>
		<tr>
			<td class="LABEL" width="25%">Current Validity</td>
			<td class="CONTROL" ><bean:write name="rateContractDtlBean" property ="strContractValidity" filter="false"/></td>
			<td class="LABEL" width="25%"></td>
			<td class="CONTROL" width="25%"></td>
		</tr>
		
			<tr>
				<td width="25%" class="LABEL" ><font  color="red">*</font>Contract From</td>
				<td width="25%" class="CONTROL"><bean:write name="rateContractDtlBean" property ="strContractFromDate" filter="false"></bean:write></td>
				<td width="25%" class="LABEL"><font color="red">*</font>Contract To</td>
				<td width="25%" class="CONTROL"><bean:write name="rateContractDtlBean" property="strContractToDate"></bean:write></td>
			</tr>
			
			 <tr>
				<td width="25%" class="LABEL">Tender No.</td>
				<td width="25%" class="CONTROL">
				<bean:write name="rateContractDtlBean" property ="strTenderNo" filter="false"/>
				<input type="hidden" class="txtFldMax" name="strTenderNo" maxlength="50" value="${rateContractDtlBean.strTenderNo}">
				</td>
					<td width="25%" class="LABEL">Quotation No.</td>
				<td width="25%" class="CONTROL">
					<bean:write name="rateContractDtlBean" property ="strQuotationNo" filter="false"></bean:write>				
				</td>
			</tr>
			
			<tr>
				<td class="LABEL" width="25%" colspan='1'>Tender Date:</td>
				<td class="CONTROL" width="25%" colspan='1'>				   
				   <bean:write name="rateContractDtlBean" property ="strTenderDate" filter="false"/>
				   <input type="hidden" class="txtFldMax" name="strTenderDate" maxlength="50" value="${rateContractDtlBean.strTenderDate}">
				</td>
				
				<td class="LABEL" width="25%" colspan='1'>Quotation Date</td>
				<td class="CONTROL" width="25%">
					<bean:write name="rateContractDtlBean" property ="strQuotationDate" filter="false"></bean:write>				 
				</td>			    
			</tr>
		
		    <tr>
				<td class="LABEL" width="25%" colspan='1'>Tax Type:</td>
				<td class="CONTROL" width="25%"  colspan='1'>
				<div id="taxTypeDiv"></div>	    
			   </td>
				
				<td class="LABEL" width="25%" colspan='1'><font  color="red">*</font>TAX(%)</td>
				<td class="CONTROL" width="25%">
					<bean:write name="rateContractDtlBean" property ="strTax" filter="false"></bean:write>
				</td>			    
			</tr>
			<tr>
				<td class="LABEL" width="25%"><font  color="red">*</font>Delivery Day(s)</td>
				<td class="CONTROL" >
				  <bean:write name="rateContractDtlBean" property ="strDeliveryDays" filter="false"></bean:write>
				</td>
				<td class="LABEL" width="25%">Whether Item Is Imported</td>
				<td class="CONTROL" width="25%"><div id="importedType"><b></b></div></td>
			</tr>	
					    				
			<tr>
				<td class="TITLE" colspan="4">Drug Detail(s)</td>
			</tr>
		
		
			<tr>
				<td colspan="1" width="25%" class="LABEL">Drug Name
				</td>
				<td colspan="1" width="25%" class="CONTROL"><bean:write name="rateContractDtlBean" property="strItemBrandName" filter="false"></bean:write>
				</td>
				<td colspan="1" width="25%" class="LABEL">Contracted Rate/Unit
				</td>
				<td colspan="1" width="25%" class="CONTROL">
					<bean:write name="rateContractDtlBean" property="strLastPurchaseRate" filter="false"></bean:write>/
					<bean:write name="rateContractDtlBean" property="strLastPurchaseRateUnit" filter="false"/>
				</td>
		    </tr>
		    <tr>
				<td colspan="1" width="25%" class="LABEL">Security Amt(%)
				</td>
				<td colspan="1" width="25%" class="CONTROL"><bean:write name="rateContractDtlBean" property="strLastSecurityAmount" filter="false"></bean:write>
				</td>
				<td colspan="1" width="25%" class="LABEL">Rate Contract Qty
				</td>
				<td colspan="2" width="25%" class="CONTROL"><bean:write name="rateContractDtlBean" property="strLastContractQty" filter="false"></bean:write>
				</td>
			</tr>
			<tr>
				<td width="25%" class="LABEL">Shelf Life (In Days)</td>
				<td width="25%" class="CONTROL">
				   <bean:write name="rateContractDtlBean" property ="strRenewShelfLife" filter="false"></bean:write>
				</td>
				<td width="25%" class="LABEL">Level</td>
				<td width="25%" class="CONTROL">
				  <bean:write name="rateContractDtlBean" property ="strRenewLevel" filter="false"></bean:write>
				</td>
			</tr>	
		</table>
		
			<table class="TABLEWIDTH" align="center" cellpadding="1px" cellspacing="1px">
			<tr>
			<td class="TITLE" colspan="4">Rate Contract Extension Details</td>
		</tr>
		
		<tr>
			<td class="LABEL" width="25%">
			     <font color="red">*</font>Letter No
			</td>

			<td class="CONTROL"  width="25%">
			   <input type="text" name="strLettrNo" maxlength="14" class="txtFldMax" 	onkeypress="return validateData(event,18);" />
			</td>

			<td class="LABEL" width="25%"><font color="red">*</font>Letter Date</td>
			<td class="CONTROL" width="25%">			
				<dateTag:date name="strLetterDate" value="${rateContractDtlBean.strCtDate}"></dateTag:date>
			</td>
		</tr>	
		<tr>
			<td width="25%" class="LABEL" colspan="1"><font color="red">*</font>Contract To</td>
			<td width="25%" class="CONTROL" colspan="1">
			<dateTag:date name="strNewContractToDate" value ="${rateContractDtlBean.strContractToDate}"></dateTag:date>
			</td>
		    
		    <td width ="25%" class ="LABEL" valign="middle" colspan="1"><font color="red">*</font>Rate Contract Extension Remarks</td>
		    <td width ="25%" class ="CONTROL" colspan="1">
		    <textarea  name="strRemarks" cols="25" rows="2" onkeypress="return validateData(event,9);"></textarea>
		    </td>
	  	</tr>
		<tr class="FOOTER">
			 <td colspan="4"><font size="2" color="red">*</font> Mandatory Fields  </td>
		</tr>
	</table>
<!-- 	<table border="0" class="TABLEWIDTH" align="center">
		<tr>
			<td align="center">
				<img style="cursor: pointer; " src="../../hisglobal/images/btn-sv.png" onClick=" return validateRateContractExtnUpdate();" title="Save Record"/> 
				<img style="cursor: pointer; " title="Clear Content" src="../../hisglobal/images/btn-clr.png" onClick="document.forms[0].reset(),document.forms[0].strContractToDate.focus();" />
				<img style="cursor: pointer; " title="Click Here Go Back To Main Desk" src="../../hisglobal/images/back_tab.png" onClick="cancel();" />			
			</td>
		</tr>
	</table> -->
	<br>
	<div align="center" id="">					 
					 	<a href="#" class="button" id="submitId" onclick=' return validateRateContractExtnUpdate();'><span class="save">Save</span></a>
						<a href="#" class="button"	onclick="document.forms[0].reset(),document.forms[0].strContractToDate.focus();"><span class="clear">Clear</span></a> 
						<a href="#" class="button" onclick="cancel();"><span class="cancel">Cancel</span></a>
					</div> 
<input type="hidden" name="hmode"/>
<input type="hidden" name="ctDate" value="${rateContractDtlBean.strCtDate}"/>

<input type="hidden" name="strContractTypeID" value="${rateContractDtlBean.strContractTypeID}"/>
<input type="hidden" name="strSlNo" value="${rateContractDtlBean.strSlNo}"/>


<input type="hidden" name="strChk1" value="${rateContractDtlBean.strChk1}"/>
<input type="hidden" name="comboValue" value="${rateContractDtlBean.comboValue}"/>
<input type="hidden" name="strPrevRenewFlag" value="${rateContractDtlBean.strPrevRenewFlag}"/>
<input type="hidden" name="strTaxTypeNumValue" value="${rateContractDtlBean.strTaxType}"/>
<input type="hidden" name="strContractToDate" value="${rateContractDtlBean.strContractToDate}"/>
<input type="hidden" name="strImportTypeViewFlag" value="${rateContractDtlBean.strImportTypeViewFlag}"/>


<div id="blanket" style="display:none;"></div>
<div class="popUpDiv" id="popUpDiv" style="display:none;">
<table bgcolor="white">
<tr>
<td>
<div id="searchItemsDtlsDivId" style="display:block;"></div>
</td>
</tr>
</table>
</div>

<cmbPers:cmbPers/>
</html:form>
<tag:autoIndex></tag:autoIndex>
</body>
</html>