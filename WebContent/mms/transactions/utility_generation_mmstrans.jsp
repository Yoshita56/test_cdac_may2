<%@ page language="java" contentType="text/html;"	pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic"%>
<%@ taglib uri="/WEB-INF/dateTag.tld" prefix="date"%>
<%@ taglib uri="/WEB-INF/hisTab.tld" prefix="tag"%>
<%@ taglib uri="/WEB-INF/patientDtl.tld" prefix="pDtl"%>
<%@ taglib uri="/WEB-INF/onLineReqDiscountDtl.tld" prefix="DisDtl"%>
<%@ taglib uri="/WEB-INF/crNo.tld" prefix="crNo"%>

<!-- 
/**
 * Developer : Tanvi Sappal 
 * Version : 1.0 
 * Date : 18/June/2009
 * 
 */
-->
<html>
<head>
<meta charset=UTF-8">
<title>Utility Generation</title>
<link href="../css/master.css" rel="stylesheet" type="text/css">
<link href="../../hisglobal/css/tab.css" rel="stylesheet" type="text/css">
<link href="../../hisglobal/css/calendar-tas.css" rel="stylesheet" type="text/css">

<link href="../../hisglobal/css/popup.css" rel="stylesheet"	type="text/css">
<link href="../../hisglobal/css/newpopup.css" rel="stylesheet" type="text/css">
<link href="../../hisglobal/css/buttons.css" rel="stylesheet" type="text/css">
<link href="../../hisglobal/css/autocomplete.css" rel="stylesheet"	type="text/css">

<script language="JavaScript" src="../../masterutil/js/master.js"></script>
<script language="JavaScript" src="../../hisglobal/js/tab.js"></script>
<script language="JavaScript" src="../../hisglobal/js/calendar.js"></script>
<script language="Javascript" src="../../hisglobal/js/validation.js"></script>
<script language="Javascript" src="../../hisglobal/js/util.js"></script>
<script language="Javascript" src="../../hisglobal/js/newpopup.js"></script>
<script language="Javascript" src="../../hisglobal/js/popup.js"></script>

<script type="text/javascript">  
function handleEnter(obj,eve)
{
	if(eve.keyCode == 13)
	{
		if(obj.value.length == 15)
		{
			  return goFunc();
		}
		else
		{
			return false;
		}
	}
	
}

function getItemdiv(obj)
{
//	if(document.forms[0].strPuk.value.length != 15)
	//{

var form=document.getElementsByName('strrSupplier');

for (var i = 0; i < form.length; i++) {
	
	
if(form[i].checked)
	{
	
document.getElementById('itemlabel').style.display = "block";
var checkbox = document.getElementsByName('chk');

for(var j=0; j< checkbox.length; j++) {
	

    if(checkbox[j].value==form[i].value)
     {
    	var splitId=checkbox[j].id.substr(5,10);
    	// alert(form[i].value+"sup"+splitId);
   	document.getElementById(form[i].value+"sup"+splitId).style.display = "block";
    	document.getElementById("chkid"+splitId).disabled=false;
    	document.getElementById("chkid"+splitId).checked=true;
	}
    
   
}
	}
	else
		{
		document.getElementById('itemlabel').style.display = "block";
		var checkbox = document.getElementsByName('chk');

		for(var j=0; j< checkbox.length; j++) {
			

		    if(checkbox[j].value==form[i].value)
		     {
		    	var splitId=checkbox[j].id.substr(5,10);
		    	
		   	document.getElementById(form[i].value+"sup"+splitId).style.display = "none";
		    	document.getElementById("chkid"+splitId).disabled=true;
		    	document.getElementById("chkid"+splitId).checked=false;
		    	
			}
		    
		   
		}
		}


	
}
chk();
}
	/*if (radios[i].checked == false) {
	    myradiovalue = radios[i].value */
	
//	}
/*	else
	{
		document.forms[0].hmode.value="GETPATDTL";
		document.forms[0].submit();
	}*/

function chk()
	{

		var checkbox = document.getElementsByName('chk');
		var ln = 0;
		for(var i=0; i< checkbox.length; i++) {
		    if(checkbox[i].checked)
			    {
		     
	
		        var splitId=checkbox[i].id.substr(5,10);
		       
		        //var txtid="condemqty"+splitId;
		        document.getElementById("strRate"+splitId).disabled=false;
		        document.getElementById("strInvoiceDate"+splitId).disabled=false;
		        document.getElementById("strInvoiceNo"+splitId).disabled=false;
		        document.getElementById("strDCNo"+splitId).disabled=false;
		        document.getElementById("strQty"+splitId).disabled=false;
		        document.getElementById("strItemId"+splitId).disabled=false;
		        document.getElementById("strItem"+splitId).disabled=false;
		        document.getElementById("strSupplierId"+splitId).disabled=false;
		        document.getElementById("strPONo"+splitId).disabled=false;
		       // alert(checkbox[i].value);strQty
		       
		        ln++;
			    }
		    else
			    {
		    	var splitId=checkbox[i].id.substr(5,10);
		    	document.getElementById("strItem"+splitId).disabled=true;
			    }
		
		}
		
		}
function goFunc()
{
	if(document.forms[0].strPuk.value.length != 15)
	{
		alert('CR No. should be of 15 digits');
		return false;
	}
	else
	{
		if(document.forms[0].strItemCategoryNo.value==1)
{
		document.forms[0].hmode.value="GETINDENTNO";
		document.forms[0].submit();
}
		else
			{		
			document.forms[0].hmode.value="GETUTILITYNO";
		document.forms[0].submit();
		}
		}
}

function getmodifyDtl(obj)
{

	if(document.forms[0].strPuk.value.length != 15)
	{
		alert('CR No. should be of 15 digits');
		return false;
	}
	else
	{
	
		document.forms[0].hmode.value="GETPATDTL";
		document.forms[0].submit();
		
		}
} 

function getNewDtl(obj)
{

	if(document.forms[0].strPuk.value.length != 15)
	{
		alert('CR No. should be of 15 digits');
		return false;
	}
	else
	{
	
		document.forms[0].hmode.value="GETPATDTL";
		document.forms[0].submit();
		
		}
} 

function initfunc()
{
	
	if(document.forms[0].strIndentDtl1.value != "")
		{

		document.getElementById("indentDtls").style.display="";
		document.getElementById("utilityDtls").style.display="none";
		document.getElementById("savebtnid").style.display="none";
		document.getElementById("modifybtnid").style.display="none";
		}

	else
		{
if(document.forms[0].strUtilityDtl1.value != "")
	{
	document.getElementById("utilityDtls").style.display="";
	document.getElementById("savebtnid").style.display="none";
	document.getElementById("modifybtnid").style.display="none";
	}
else
	{
	if(document.forms[0].strPatDetails1.value != "")
	{
	
		document.getElementById("utilityDtls").style.display="none";
		document.getElementById("patDtls").style.display="";
		document.getElementById("rem").style.display="";
		document.getElementById("gobtn").style.display="none";
		if(document.forms[0].strItemCategoryNo.value == '1')
		{
				document.getElementById("savebtnid").style.display="";
				document.getElementById("modifybtnid").style.display="none";
		}
				
		else
		{
				document.getElementById("modifybtnid").style.display="";
				document.getElementById("savebtnid").style.display="none";
		}
	}
	else
	{
		document.getElementById("patDtls").style.display="none";
		document.getElementById("gobtn").style.display="";
		document.getElementById("savebtnid").style.display="none";
		document.getElementById("modifybtnid").style.display="none";
	}
	if(document.forms[0].strPrintFlag.value == "1")
	{
		popup('popUpDiv', '80', '60');
		document.forms[0].strPrintFlag.value="0";
	}
	}
		}
}
function fn_DateCompare(DateA, DateB) {
	alert(DateA);
	alert(DateB);
    var a = new Date(DateA);
    var b = new Date(DateB);
	alert("a"+a);
	alert(b);
    var msDateA = Date.UTC(a.getFullYear(), a.getMonth()+1, a.getDate());
    var msDateB = Date.UTC(b.getFullYear(), b.getMonth()+1, b.getDate());
	alert("ms"+msDateA);
	alert(msDateB);
    if (parseFloat(msDateA) < parseFloat(msDateB))
      return -1;  // less than
    else if (parseFloat(msDateA) == parseFloat(msDateB))
      return 0;  // equal
    else if (parseFloat(msDateA) > parseFloat(msDateB))
      return 1;  // greater than
    else
      return null;  // error
}
function validatesave()
{
	

	if(document.getElementsByName("strDPhoneEmail")[0].value == '0')
	{
		alert("Item(s) are not available in inventory for UC generation");
		return false;
	}
	
	//return false;
	 if(parseFloat(document.forms[0].strBalanceAmount.value) < parseFloat(document.forms[0].strRate.value))
	 {
		 alert("Patient Account Balance is insufficient,Kindly deposit Part Payment!!");
		 return false;
	 }
	var hisValidator = new HISValidator("UtilityGenerationTransBean");  
	// hisValidator.addValidation("strImpCharges","req","Kindly Enter implant Charges" );
	  hisValidator.addValidation("strSurgeonCharges","req","Kindly Enter surgery Charges" );
	  hisValidator.addValidation("strSurgeonDetail","req","Kindly Enter surgery detail" );
	 // hisValidator.addValidation("strRate","req","Kindly Enter Rate" );
	 // hisValidator.addValidation("strHandlingCharges","req","Kindly Enter Handling Charges" );
	  hisValidator.addValidation("strDiag","req","Diagnosis is mandatory" );
	  hisValidator.addValidation("strDiag", "maxlen=200", "Diagnosis should have less than or equal to 200 Characters" );
	  hisValidator.addValidation("strSurgeryDate","req","Date of Surgery can't be left blank");
	  hisValidator.addValidation("strSurgeryDate","dtltet="+document.forms[0].strCtDate.value,"Please Select Surgery Date Less Than or Equal To today's Date");

	 // hisValidator.addValidation("strSurgeryDate","dtltet="+document.forms[0].strCtDate.value,"Please Select Challan/Invoice Date Less Than or Equal To Current Date");
		//hisValidator.addValidation("strCtDate", "dtgtet="+document.forms[0].strSurgeryDate.value,"Received Date should be Greater Than or Equal Challan/Invoice Date");
		

	  var retVal = hisValidator.validate(); 
	 
	  
	  document.getElementById("gobtn").style.display="";
	  if(confirm("Are you want to proceed"))
		  {
	  if(retVal)
	     {  	
			if(document.forms[0].strHandlingCharges.value == "" || document.forms[0].strHandlingCharges.value == null)
		     	document.forms[0].strHandlingCharges.value="0";
			  document.forms[0].hmode.value="SAVE";						  
		      document.forms[0].submit();
	     }
		  }
	  else
		  {
		  return false;
		  }
}

function validatemodify()
{
	var hisValidator = new HISValidator("UtilityGenerationTransBean");  
	  //hisValidator.addValidation("strRate","req","Kindly Enter Rate" );
	  // hisValidator.addValidation("strHandlingCharges","req","Kindly Enter Handling Charges" );
	//  hisValidator.addValidation("strImpCharges","req","Kindly Enter implant Charges" );
	  hisValidator.addValidation("strSurgeonCharges","req","Kindly Enter surgery Charges" );
	  hisValidator.addValidation("strSurgeonDetail","req","Kindly Enter surgery detail" );
	   hisValidator.addValidation("strDiag","req","Diagnosis is mandatory" );
	  hisValidator.addValidation("strDiag", "maxlen=200", "Diagnosis should have less than or equal to 200 Characters" );
	  hisValidator.addValidation("strSurgeryDate","req","Date of Surgery can't be left blank");
	  hisValidator.addValidation("strSurgeryDate","dtltet="+document.forms[0].strCtDate.value,"Please Select Surgery Date Less Than or Equal To today's Date");
	  
		  var retVal = hisValidator.validate(); 
	  document.getElementById("gobtn").style.display="";

	  if(confirm("Are you want to proceed"))
	  {
	  if(retVal)
	     {  	
		  if(document.forms[0].strHandlingCharges.value == "" || document.forms[0].strHandlingCharges.value == null)
		     	document.forms[0].strHandlingCharges.value="0";
			  document.forms[0].hmode.value="SAVE";						  
		      document.forms[0].submit();
	     }
	  }
	  else
	  {
	  return false;
	  }
		  
	
}

function printData() 
{

	newwin = window.open('', 'printwin',
			'left=100,top=100,width=700,height=700,scrollbars=yes');
	newwin.document.write('<HTML><HEAD>');
	newwin.document.write((document.getElementsByTagName("head")[0]).innerHTML);
	newwin.document
			.write('<style type="text/css"> .hidecontrol { display: none; } </style>\n');
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
	newwin.document.write(document.getElementById('issueDtlsDivId').innerHTML);
	newwin.document.write('</BODY>\n');
	newwin.document.write('</HTML>\n');
	newwin.document.close();

}

function hideIssuePopup(){
	
	hide_popup('popUpDiv');
	document.forms[0].hmode.value="unspecified";
	document.forms[0].submit();
	
}
</script>
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
</head>
<body onload="initfunc();">
<html:form action="/transactions/UtilityGenerationTransCNT.cnt" name="UtilityGenerationTransBean" type="mms.transactions.controller.fb.UtilityGenerationTransFB" method="post" >
	<center><div class="errMsg" id="errMsg"><bean:write name="UtilityGenerationTransBean" property="strErrorMsg" /></div>
	<div class="warningMsg" id="warningMsg"><bean:write name="UtilityGenerationTransBean" property="strWarningMsg" /></div>
	<div class="normalMsg" id="normalMsg"><bean:write name="UtilityGenerationTransBean" property="strNoramalMsg" /></div>
		
	<tag:tab tabLabel="Utility Generation" selectedTab="FIRST" align="center" width="TABLEWIDTH"></tag:tab></center>
	
	
	
	<center>
<table align='center' class='TABLEWIDTH' cellpadding='1px' cellspacing='1px' >
<tr class="HEADER">
		<td colspan="5"></td>
	</tr>
<tr>
		<td class="LABEL" width='25%'><font color="red">*</font>Generation Type</td>
		<td width='75%'  colspan='4' class="CONTROL"><div id="itemCategoryDivId" ><html:radio tabindex='1' property="strItemCategoryNo" name="UtilityGenerationTransBean" value="1" onclick="document.getElementById('gobtn').style.display='';" >New</html:radio><html:radio tabindex='1' property="strItemCategoryNo" name="UtilityGenerationTransBean" value="2" onclick="document.getElementById('gobtn').style.display='';" >Modify</html:radio> </div></td>
	</tr>
	<tr>
		<td width="25%" class="LABEL"><font color="red">*</font>CR No.</td>
		<td width="25%" colspan="3" class="CONTROL">
				<input type='text' tabindex='1' onkeypress='return handleEnter(this,event);' autocomplete='off' value="${UtilityGenerationTransBean.strPuk}" name='strPuk' maxlength='15'>(Enter CR No. of 15 digits)
		</td><td width="25%" colspan="3" class="CONTROL"><div align="left" style='' id="gobtn">					 
					<a href="#" class="button" id='go'	onclick="return goFunc();"></a>
				</div> 
		</td>
	
		
	</tr>
		</table>
		<div id='generic' style='display:none;'></div>
</center>
	
	<div id="strBatchDivId" style="display: none;">
	
	<table class="TABLEWIDTH" align="center" cellpadding="1px" cellspacing="1px">	
	<tr>
		<td width="50%" class="LABEL">
			Batch No		
		</td>
		<td width="50%" class="CONTROL" colspan="3">
			<div id="batchNoId"><select name="strBatchNo" class='comboMax'>
					<bean:write name="UtilityGenerationTransBean" property="strBatchNoCmb" filter="false" />
					<option value="0">Select Value</option>
			</select></div>
		</td>
	</tr>
	</table>
	</div>
	
	<div id="strBatchItemDivId" style="display: none;">
	<table class="TABLEWIDTH" align="center" cellpadding="1px" cellspacing="1px">	
	<tr>
		<td width="50%" class="LABEL">
			Item Serial No		
		</td>
		<td width="50%" class="CONTROL" >
			<div id="itemSlNoId"><select name="strItemSlNo" class='comboMax'>
					<bean:write name="UtilityGenerationTransBean" property="strItemSlNoCmb" filter="false" />
					<option value="0">Select Value</option>
			</select></div>
		</td>
	</tr>
	</table>
	</div>
	<div id='utilityDtls' style='display:none;'>
	<bean:write property='strUtilityDtl' name='UtilityGenerationTransBean' filter="false" />
	</div>
	
	<div id='indentDtls' style='display:none;'>
	<bean:write property='strIndentDtl' name='UtilityGenerationTransBean' filter="false" />
	</div>
	
	<div id='patDtls' style='display:none;'>
	<bean:write property='strPatDetails' name='UtilityGenerationTransBean' filter="false" />
	</div>
	 <!--  <table class="TABLEWIDTH" align="center" cellpadding="1px" cellspacing="1px">
		<tr>
			<td colspan="4" align="center" class="LABEL">
           <div align="center"> 
           <a href="#" class="button"	onclick="validate1();"><span class="go">g</span></a> 
           </div></td>
		</tr>
	</table>-->
	
					
	
	<div id="StockDtlDivId" style="display: none;">
	</div>
	
	 <div class='popup' id='avlQtyId' style="display:none">
		<table width='400' border="0" cellspacing ="0px" cellpadding="0px">
			<tr class="HEADER"> 
				<th align='left'><div id="popUpAvlQtyId"></div></th>
				<th align='right'>
				<a href="#" class="button" onclick="closeAvlQtyPopUp('avlQtyId');"><span class="cancel">Cancel</span></a>
				<!--<img  style='cursor:pointer;cursor:pointer' src='../../hisglobal/images/popUp_cancel.JPG'
					onClick="closeAvlQtyPopUp('avlQtyId');" title="Click Here To Close Popup">-->
					</th>
		    </tr>
		 </table>  
	  
	
					
	  
		 <table width='400' border="0" cellspacing ="1px" cellpadding="1px">
			<tr>
				<td colspan="1" class='multiLabel'>Reserved Qty</td>
				<td colspan="1" class='multiControl'><div id ='1'></div></td>
						
			</tr>
			<tr>
				<td colspan="1" class='multiLabel'>Blocked Qty</td>
				<td colspan="1" class='multiControl'><div id ='2'></div></td>	
			</tr>
			<tr class="FOOTER">
				<td colspan="4"></td>
			</tr>
	        </table>
	    </div>
	
	<table class="TABLEWIDTH" align="center" cellpadding="1px" cellspacing="1px">	
	   <tr class="FOOTER">
			 <td colspan="4"><font size="2" color="red">*</font> Mandatory Fields  </td>
	  </tr>
	   <tr >
			 <td colspan="4"><div id="rem" style="display: none;" ><font size="2" color="red"># Surgery charges and Implant Charges are not part of Utility Certificate</font> </div> </td>
	  </tr>
	  
	  <tr>
			<td colspan="4" align="center" >
			<div align="center" id="" style=''>					 
					 	<a href="#" id="savebtnid" class="button" onclick="validatesave();"><span class="save">Save</span></a>		 
					 	<a href="#" id="modifybtnid" class="button" onclick="validatemodify();"><span class="modify">Modify</span></a>			 
					 	<a href="#" class="button" onclick="cancelFunc();"><span class="cancel">Cancel</span></a>
				</div> 
           <!--<div align="center"> <img style="cursor: pointer; " title="To Search" src="../../hisglobal/images/btn-ccl.png"  onclick="cancelFunc();"/></div>--></td>
		</tr>
    </table>
    
<div id="blanket" style="display:none;"></div>
<div class="popUpDiv" id="popUpDiv" style="display:none;">

<table bgcolor="white">

<tr>

<td>

 <div id="issueDtlsDivId" style="display:block;">
 <bean:write property='strPrintDtls' name='UtilityGenerationTransBean' filter="false" />
 </div>

</td>

</tr>

</table>

</div>
					
		
<input type="hidden" name="hmode"/>
<input type="hidden" name="strPatDetails1" value="${UtilityGenerationTransBean.strPatDetails1}"/>
<input type="hidden" name="strUtilityDtl1" value="${UtilityGenerationTransBean.strUtilityDtl1}"/>
<input type="hidden" name="strIndentDtl1" value="${UtilityGenerationTransBean.strIndentDtl1}"/>
<input type="hidden" name="strPrintFlag" value="${UtilityGenerationTransBean.strPrintFlag}"/>
<input type="hidden" name="strCtDate" value="${UtilityGenerationTransBean.strCtDate}"/>
<input type="hidden" name="strPatAccountNo" value="${UtilityGenerationTransBean.strPatAccountNo}"/>
<input type="hidden" name="strBalanceAmount" value="${UtilityGenerationTransBean.strBalanceAmount}"/>
<input type="hidden" name="strStoreId" value="${UtilityGenerationTransBean.strStoreId}"/>
</html:form>
	<tag:autoIndex></tag:autoIndex>   
</body>
</html>