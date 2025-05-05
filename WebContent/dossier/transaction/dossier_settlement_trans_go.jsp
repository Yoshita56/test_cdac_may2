<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page import="java.util.Map"%>
<%@page import="java.util.HashMap"%>

<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic"%>
<%@ taglib uri="/WEB-INF/hisTab.tld" prefix="tag"%>
<%@taglib uri="/WEB-INF/dateTag.tld" prefix="date"%>
<%@ taglib uri="/WEB-INF/dateTag.tld" prefix="dateTag"%>
<%@ taglib uri="/WEB-INF/comboPersistence.tld" prefix="cmbPers"%>
<%@ taglib uri="/WEB-INF/crNo.tld" prefix="crNo"%>


<html>
<head>
<title>Issue To Patient Process</title>




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

<link href="../../hisglobal/css/jquery-confirm.min.css" rel="stylesheet" type="text/css">









<script type="text/javascript" src="../../hisglobal/jquery/3.6.0.min.js"></script>

<script language="Javascript" src="/INVMGM/hisglobal/js/jquery/jquery-confirm.min.js"></script>


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
<script language="Javascript" src="/INVMGM/dossier/js/dossier_settlement_trans.js"></script>
<script language="Javascript" src="/INVMGM/dossier/js/dossierItems_util1.js"></script>
<script language="Javascript" src="/INVMGM/dossier/js/dossierDetails_util.js"></script>
<script language="Javascript" src="/INVMGM/dossier/js/dossierissueDetails_util.js"></script>
<script type="text/javascript">
function controlToIssueToPatientPage()
{	    
	//cancelIssue();
	//alert(document.getElementsByName("3")[0].value);
	
	  if($("#requestMode").val()=='OT'){  //Added By Ranjit for Dossier OT Integration
	/*	 
		 $.alert({
             title: '',
             boxWidth: '30%',
             useBootstrap: false,
             content: 'Dossier is Finalized.Please Validate OT List for raising of Saved Dossier',
             onClose: function () {
              		     window.close()
             		  }
         }); */
	 
		 $.confirm({
			    title: 'Confirm!',
			    boxWidth: '30%',
	             useBootstrap: false,
			    content: 'Dossier is Finalized.',
			    buttons: {
			        confirm: function () {
			        	 $.alert({
			                 title: '',
			                 boxWidth: '30%',
			                 useBootstrap: false,
			                 content: 'Validate OT List for raising of saved dossier',
			                 onClose: function () {
			                  		     window.close()
			                 		  }
			             });
			        },
			        cancel: function () {
			        	$.alert({
			                 title: '',
			                 boxWidth: '30%',
			                 useBootstrap: false,
			                 content: 'Canceled !!'
			                
			             });
			        }
			        
			    }
			});
		 
		
	 }else{
	
		document.forms[0].hmode.value="INITVAl";
		document.forms[0].submit();
	 }
}

function getDossierItemDtls()
{
	//alert('1');
	var url = "DossierSettlementCNT.cnt?hmode=GETDOSSIERITEMDTLS&dossiercode="
		+ document.forms[0].strDossiercat.value+"&storeId="+document.forms[0].strToStoreName.value;
		ajaxFunction(url,"15");

}

function getServicesDtls()
{

	var url = "DossierSettlementCNT.cnt?hmode=GETSERVICEDTLS&deptcode="
		+ document.forms[0].strDepartment.value+"&ServiceId="+document.forms[0].strSericeType.value;
		ajaxFunction(url,"116");
}


function getDossierName()
{

	var url = "DossierSettlementCNT.cnt?hmode=GETDOSSIERNAME&deptcode="
		+document.forms[0].strDepartment.value+"&ServiceId="+document.forms[0].strService.value;
		ajaxFunction(url,"117");
}


	function getAjaxResponse(res, mode) {

		//alert(res);
	//	alert(mode);
	if (mode == "15") {
		
			document.getElementById("dossierId").innerHTML = res;
		} 
	//alert(mode);
	if (mode == "116") {
		
		//alert(res);
		var objVal = document.getElementById("serviceCmb");
		var toStoreobjVal = document.getElementById("strToStoreDiv");
		objVal.innerHTML = "<select name ='strService' class='comboNormal' onchange='getDossierName()' >"
				+ res.split('###')[0] + "</select>";

	/* 	toStoreobjVal.innerHTML = "<select name ='strToStoreName' class='comboNormal' onchange='' >"
			+ res.split('###')[1] + "</select>"; */
		
	
	
	}	
if (mode == "117") {
		
		//alert(res);
		var objVal = document.getElementById("DossierId");
		objVal.innerHTML = "<select name ='strDossiercat' class='comboNormal' >"
				+ res + "</select>";
	
	
	}
if (mode == "22") {
	//alert(res);
	var objVal = document.getElementById("reqitemDtlDivId");

	objVal.innerHTML = res;

	document.getElementById('svbtn').style.display='block';

	getPatDossierDtl1();

}
}
function getLfDetails()
{
	document.getElementById('lfDiv').style.display='block';
}

function closeLfDetails()
{
	document.getElementById('lfDiv').style.display='none';
}
function shwoDiv1()
	{
		//alert('1');
		var chkvalue=document.forms[0].strCIMSIntegration.value;
		//alert(chkvalue);
		if(chkvalue == '1')
			{
			//alert('in');
			 document.getElementById('cimsId1').style.display = '';
			 document.getElementById('cimsId2').style.display = 'none';
			}else
				{
				//alert('else');
				document.getElementById('cimsId1').style.display ='none';
				document.getElementById('cimsId2').style.display ='';
			}
		
	}
</script>

<script type="text/javascript">
	function setRowIndex()
	{
		//alert(document.forms[0].strRowCount.value);
		document.getElementsByName("rowIndex1")[0].value="0";
		document.getElementsByName("rowLength1")[0].value="0";
		//document.forms[0].rowIndex1.value=document.forms[0].strRowCount.value;
		//document.forms[0].rowLength1.value=document.forms[0].strRowCount.value;
	}
	
	
	
	function validateIssueOT()
	{
		var retVal = false;
		var hisValidator = new HISValidator("DossierSettlementBean");
		hisValidator.addValidation("strToStoreName", "dontselect=0",	 "Please Select Store Name");
		hisValidator.addValidation("strRemarks", "maxlen=100","Remarks should have less than or equal to 100 Characters");
		hisValidator.addValidation("strRemarks", "req",	 "Please Enter Remarks");
		var itemParVal     = document.getElementsByName("strDossierHlpHidden");
		 var itemUserValue  = document.getElementsByName("itemUserValue");

	 

		if((itemParVal.length>1)  && (itemUserValue.length>1) )
			{												
				 for(var i=0;i<=itemParVal.length-1;i++)
				 {
					for(var j=0;j<itemUserValue.length-1;j++)
					 {
						 //alert(itemUserValue[i].value);
						//alert(itemParVal[i].value.split('^')[6]);
						//alert(itemUserValue[i].valueitemParValitemParValitemParVal);
						//alert(itemUserValue[j].value.split('^')[1]); 
						if(itemParVal[i].value.split('^')[6] == itemUserValue[j].value.split('^')[1])
							{
								alert('Kindly Remove Duplicate Drug '+itemParVal[i].value.split('^')[0]+' From List');
								return false;
							}
					 	
					 }	
				 	//itemUserValue[i].disabled=false;
				 }									  
			}


	//alert("Hi");
		
		var len=document.getElementsByName("strQtyText2").length;
		var totqty=0.00;
		for(var j = 1 ;j <=len ; j++ )
			{
				if(document.getElementById("strQtyText1-"+j).value == '')
					{
						alert('Please Enter Quantity');
						return false;
					}else{
						totqty=totqty+parseFloat(document.getElementById("strQtyText1-"+j).value);
						}	
			}


		var len1=document.getElementsByName("strQtyText1").length;
		var totqty1=0.00;
		//alert(len1);
		for(var k = 0 ;k <len1-1 ; k++ )
			{

					if(document.getElementsByName("strQtyText1")[k].value == '')
					{
						alert('Please Enter Quantity');
						return false;
					}
					else
					{
						totqty1=totqty1+parseFloat(document.getElementsByName("strQtyText1")[k].value);
					}	
			}
		//alert((totqty1+totqty1));
		if((totqty+totqty1) <= 0)
			{
			alert('Please Select One Item Quantity Is greater Than Zero');
			return false;	
			}
		retVal = hisValidator.validate();
		hisValidator.clearAllValidations();

		//alert("bal"+document.forms[0].strBalanceAmount.value);
		//alert("inner"+document.getElementById("strtotalDiv").innerHTML.split(" ")[1]);
		if(parseFloat(document.forms[0].strBalanceAmount.value) < parseFloat(document.getElementById("strtotalDiv").innerHTML.split(" ")[1]))
		{
			alert("Patient's Account balance is in-sufficient!!!");
			return false;
		}
		if(retVal){
		var conf = confirm("Are you Sure, Want to Save!!!!");

		//alert(document.getElementsByName("IsBroughtByPatient1")[0].value);
		if(conf)
			{
			   if($("#requestMode").val()=='OT'){    //Added By Ranjit for Dossier OT Integration
				   
				   $('#loadingmessage').show();
				  
				  $.ajax({
					     url:'/INVMGM/dossier/transaction/DossierSettlementCNT.cnt?hmode=INSERTOT',
					     data: $("#form1").serialize(),
					     success: function (data) {
					            
					             var dossradio=document.getElementsByName("strDossiercat");
					             
					           
					            
					            for (var i=0;i<dossradio.length;i++){
					               
					            		if(dossradio[i].value==data.split("#")[1]){
					            	
					            	   			dossradio[i].checked = false;
					            	   			dossradio[i].disabled = true;
					            		}
					            }
					            
					            document.getElementById("dossierId").innerHTML="";
					            document.getElementById("strRemarks").value="";
					            
					            document.getElementById("dossierStatusDiv").innerHTML="";
					              
					              document.getElementById("dossierStatusDiv").innerHTML=data.split("#")[1];
					              
					              $("#id1").html("");
					            
					            getDossierOT($("#raisedOperation"));
					            
					            $('#loadingmessage').hide();
					            
					          
					            
					            $.alert({
					                title: '',
					                boxWidth: '30%',
					                useBootstrap: false,
					                content: data.split("#")[0]
					            });
					            
					            
					    }
					});
					  
			  }else{ 
			
				document.forms[0].hmode.value="INSERT";
			  document.forms[0].submit();
				
				
			  }
			}else
				{
					return false;
				}
		}else{
			return false;
			}
		
	}
	
	
	
function validateIssue1()
{
		document.forms[0].hmode.value="INSERT";
		document.forms[0].submit();
}


//Added By Ranjit for Dossier OT Integration
function getDossierOT(){
	
	
	var opcode=$("#raisedOperation").val();
	
	document.getElementById("dossierId").innerHTML="";
	
	  $.ajax({
          url: "/INVMGM/dossier/transaction/DossierSettlementCNT.cnt?hmode=getOTDossierRadio",
          type: "POST",
          cache: false,
          data: {
        	  raisedOperation: opcode,
        	  departmentCode:$("#departmentCode").val(),
        	  otReqNo:$("#otPacReqNo").val()
        	  
          },
          success: function(data) {
            //  alert("data=="+data);
              
              document.getElementById("dossierDiv").innerHTML=data;
              
          },
          error: function(errorMsg, textstatus, errorthrown) {
              alert('stockValue' + errorMsg + "textstatus::" + textstatus + "errorthrown::" + errorthrown);
          }
      })

	
}


//Added By Ranjit for Dossier OT Integration
function rejectDossier(otReqNo,opCode,dossCode){
	
	 
	
	  $.ajax({
          url: "/INVMGM/dossier/transaction/DossierSettlementCNT.cnt?hmode=rejectDossier",
          type: "POST",
          cache: false,
          data: {
        	  otReqNo:$("#otPacReqNo").val(),
        	  raisedOperation:opCode,
        	  strDossiercat:dossCode
        	  
          },
          success: function(data) {
              
              
              document.getElementById("dossierStatusDiv").innerHTML="";
              
              document.getElementById("dossierStatusDiv").innerHTML=data;
              
              getDossierOT();
              
             
              
          },
          error: function(errorMsg, textstatus, errorthrown) {
              alert('stockValue' + errorMsg + "textstatus::" + textstatus + "errorthrown::" + errorthrown);
          }
      })

	
}

//Added By Ranjit for Dossier OT Integration
function  checkDossier(){
	
	
	if($("#raisedOperation").val()=="-1"){
	
	  alert("Please Select Operation.");
	  return false;
	}
	
	if(document.getElementById("strDossiercat")){
		
		if(document.getElementById("dossierId").innerHTML==""){
			  alert("Please Select Dossier");
			  return false;
		}
	}
		
	else{
	
		alert("Dossier is Not Mapped with selected Operation");
		 return false;
	} 
	
	getItemSelectPopup();
}

function checkData(){
	
	if($("#raisedOperation").val()=="-1"){
		
		  alert("Please Select Operation.");
		  return false;
		}
	
	if(document.getElementById("strDossiercat")){
		
		if( $("#dossierId").html()==""){
			alert("Please Select Dossier which is not saved");
		}
		
	}else{
		alert("Dossier is Not Mapped with selected Operation");
		 return false;
	}
	
}


</script>
</head>
<body onload="onCheckCategory(),chkVisitDtl(),getReportnew()">  <!-- return OnLoadFunction(), commented by ashutosh pandey function not on use -->


<html:form action="/transaction/DossierSettlementCNT.cnt" styleId="form1"  name="DossierSettlementBean" type="dossier.transaction.controller.fb.DossierSettlementFB" method="post" >

	<div id="errMsg" class="errMsg"><bean:write name="DossierSettlementBean"
		property="strErrMsg" /></div>
	<div id="warningMsg" class="warningMsg"><bean:write
		name="DossierSettlementBean" property="strWarningMsg" /></div>
	<div id="normalMsg" class="normalMsg"><bean:write
		name="DossierSettlementBean" property="strNormalMsg" /></div>


	<logic:equal value="0" name="DossierSettlementBean" property="strMode">

		<tag:tab tabLabel="Issue To Patient" selectedTab="FIRST"
			align="center" width="TABLEWIDTH">
		</tag:tab>
		<table class="TABLEWIDTH" align="center" border="0" cellspacing="1px">
			<tr class="HEADER">
				<td colspan="4">Issue To Patient&gt;&gt;</td>
			</tr>
		</table>

	</logic:equal>

	<logic:equal value="1" name="DossierSettlementBean" property="strMode">
		<tag:tab tabLabel="Issue To Staff" selectedTab="FIRST" align="center"
			width="TABLEWIDTH">
		</tag:tab>
		<table class="TABLEWIDTH" align="center" border="0" cellspacing="1px">
			<tr class="HEADER">
				<td colspan="4">Issue To Staff&gt;&gt;</td>
			</tr>
		</table>
	</logic:equal>


	<logic:equal value="2" name="DossierSettlementBean" property="strMode">
		<tag:tab tabLabel="Issue To Patient/Staff" selectedTab="FIRST"
			align="center" width="TABLEWIDTH">
		</tag:tab>
		<table class="TABLEWIDTH" align="center" border="0" cellspacing="1px">
			<tr class="HEADER">
				<td colspan="4">Issue To Patient/Staff&gt;&gt;</td>
			</tr>

		</table>

	</logic:equal>


	<div class='popup' id='balQtyDtlId' style="display: none">
	<table width='400' border="0" cellspacing="1" cellpadding="1">
		<tr class="HEADER">
			<td colspan='3'>Quantity Details</td>

			<th align='right'><img style='cursor: pointer; '
				src='../../hisglobal/images/popUp_cancel.JPG'
				onClick="hideBalQtyDetails('balQtyDtlId');"></th>
		</tr>
	</table>


	<table width='400' border="0" cellspacing="1" cellpadding="1">

		<tr>
			<td colspan="1" class='multiLabel'>Req Qty</td>
			<td colspan="1" class='multiLabel'>Issue Qty</td>

		</tr>
		<tr>
			<td colspan="1" class='multiControl'>
			<div id='1'></div>
			</td>
			<td colspan="1" class='multiControl'>
			<div id='2'></div>
			</td>

		</tr>
	</table>
	</div>

<table class="TABLEWIDTH" align="center" cellpadding="1"
		cellspacing="1" width='400'>
		<tr class="HEADER">
			<td colspan='4'>Dossier Details</td>

			
		</tr>
	</table>
	<table class="TABLEWIDTH" align="center" cellpadding="1"
		cellspacing="1">
		<tr style="display: none;">
			<td width="25%" colspan="1" class="LABEL">Store Name</td>
			<td width="25%" colspan="1" class="CONTROL"><bean:write
				name="DossierSettlementBean" property="storeName" filter="false" /></td>

			<td width="25%" colspan="1" class="LABEL">Item Category</td>
			<td width="25%" colspan="1" class="CONTROL"><bean:write
				name="DossierSettlementBean" property="itemCatName" filter="false" /></td>
		</tr>
		<tr>
			<td width="25%" colspan="1" class="LABEL">CR No.</td>
			<td width="25%" colspan="1" class="CONTROL"><bean:write name="DossierSettlementBean"
				property="crNo" filter="false" /></td>
				
			<td width="25%" colspan="1" class="LABEL"></td>
			<td width="25%" colspan="1" class="CONTROL"><a href="#" onclick='getLfDetails();'><bean:write name="DossierSettlementBean"
				property="strLFAccountNo" filter="false" /></a></td>
		</tr>
	</table>
  <div id='lfDiv' style='display:none;'>
<table class="TABLEWIDTH" align="center" cellpadding="1px"
		cellspacing="1px">

		<tr>
			<td colspan="3" width='75%'><div class='line'><label class='DIVLABEL'>Patient LF Account Details</label></div></td>
			<td colspan="1" width='25%'><div class='line'><label onclick='closeLfDetails();' class='DIVLABEL'><font color='red'>Hide LF Details</font></label></div></td>
		</tr>
	
		<tr>
			<td width="25%" colspan="1" class="LABEL">Account Opening Date</td>
			<td width="25%" colspan="1" class="CONTROL"><bean:write
				name="DossierSettlementBean" property="strLFAccountOpenDate" filter="false" /></td>

			<td width="25%" colspan="1" class="LABEL">Current Balance</td>
			<td width="25%" colspan="1" class="CONTROL"><bean:write
				name="DossierSettlementBean" property="strLFBalanceAmount" filter="false" /></td>
		</tr>
		
		<tr>

			<td width="25%" colspan="1" class="LABEL">LF Account Status</td>
			<td width="25%" colspan="3" class="CONTROL"><bean:write
				name="DossierSettlementBean" property="strLFAccountStatus" filter="false" /></td>
		</tr>
		
	
	</table></div>
 
<div id="allDivId" style="display: block;">
	<table class="TABLEWIDTH" align="center" border="0" cellspacing="1px">
		<tr>
			<td width="5%" class="TITLE" align="center"><img
				src="../../hisglobal/images/plus.gif" id="plus1"
				style="display: block; cursor: pointer" onClick="getPatDtl();">
			<img src="../../hisglobal/images/minus.gif" id="minus1"
				style="display: none; cursor: pointer" onClick="getPatDtl1();"></td>

			<td colspan="3" class="TITLE" align="left"><b>Patient
			Demographic Detail</b></td>
		</tr>
	</table>

	<div id="patientDetailsDivId" style="display: none;">
	<table class="TABLEWIDTH" align="center" cellspacing="1px">
		<tr>
			<bean:write name="DossierSettlementBean" property="strPatientDetails"
				filter="false" />
		</tr>
	</table>
	</div>
	
	<div id="diagDivId" style="display: none;">
	<table class="TABLEWIDTH" align="center" border="0" cellspacing="1px">
		<tr>
			<td width="5%" class="TITLE" align="center"><img
				src="../../hisglobal/images/plus.gif" id="plus4"
				style="display: none; cursor: pointer" onClick="getPatDiagDtl();">
			<img src="../../hisglobal/images/minus.gif" id="minus4"
				style="display: block; cursor: pointer" onClick="getPatDiagDtl1();"></td>

			<td colspan="3" class="TITLE" align="left"><b>Patient
			Diagnosis Detail</b></td>
		</tr>
	</table>
</div>
	<div id="patientDiagDetailsDivId" style="display: none;">
	<table class="TABLEWIDTH" align="center" cellspacing="1px">
		<tr>
			<bean:write name="DossierSettlementBean" property="strPatientDiagDetails"
				filter="false" />
		</tr>
	</table>
	</div>

<div style='display: none;'>
 <table class="TABLEWIDTH" align="center" border="0" cellspacing="1px">
		<tr>
			<td width="5%" class="TITLE" align="center"><img
				src="../../hisglobal/images/plus.gif" id="plus3"
				style="display: block; cursor: pointer" onClick="getPatTrtDtl();">
			<img src="../../hisglobal/images/minus.gif" id="minus3"
				style="display: none; cursor: pointer" onClick="getPatTrtDtl1();"></td>

			<td colspan="3" class="TITLE" align="left"><b>Patient
			Treatment Detail</b></td>
		</tr>
	</table>
	<div id="patientTreatmentDetailsDivId" style="">
	<table class="TABLEWIDTH" align="center" cellspacing="1px">
		<tr>
			<bean:write name="DossierSettlementBean" property="strPatientTreatmentDtl"
				filter="false" />
		</tr>
	</table>
	</div>

	<table class="TABLEWIDTH" align="center" cellspacing="1px">
		<tr>
			<td width="5%" class="TITLE" align="center">
			<img src="../../hisglobal/images/plus.gif" id="plus2" 
			style="display: block; cursor: pointer;"
				onClick="disPreviousIssueDtl(),getPrevIssueDtl();"> 
			<img src="../../hisglobal/images/minus.gif" id="minus2" 
			style="display: none; cursor: pointer;"
				onClick="disPreviousIssueDtl1();"></td>
			<td colspan="3" class="TITLE"><b>Previous Issue Details</b></td>
		</tr>
	</table>

	<div id="issueDtlDivId"></div></div>


<logic:equal value="OT"  name="DossierSettlementBean"  property="requestMode" >  <!-- Added By Ranjit for Dossier OT Integration  -->
     <div id="dossierStatusDiv" >
     
      <bean:write name="DossierSettlementBean" property="dossierStatusString" filter="false" />
  </div>
     
 </logic:equal>

		
		<table class="TABLEWIDTH" align="center" cellspacing="1px"
			cellpadding="1px">
			

			<tr style="">
			<td width="5%" class="TITLE" align="center"><img
				src="../../hisglobal/images/plus.gif" id="plus22"
				style="display: none; cursor: pointer" onClick="getPatDossierDtl();">
			<img src="../../hisglobal/images/minus.gif" id="minus22"
				style="display: block; cursor: pointer" onClick="getPatDossierDtl1();"></td>
				<td class="TITLE" colspan="4">Issued Dossier(s)</td>
			</tr></table>
			<div id="reqDtlDivId" style="display: block;">
			<bean:write name="DossierSettlementBean" property="strReqValues"
				filter="false" /></div>
				
				<div id="reqitemDtlDivId" style="display: block;"></div>
				
			<%-- <tr>
				<td class="LABEL" width="25%"><font color="red">*</font>Department</td>
				<td class="CONTROL" width="25%"><select id='dep' name="strDeptCode"
					class="comboNormal" onchange="getUnitCombo();">
					<bean:write name="DossierSettlementBean" property="strDeptValues"
						filter="false" />
				</select></td>
				<td width="25%" class="LABEL"><font color="red">*</font>Unit</td>
				<td width="25%" class="CONTROL">
				<div id="unitDivId"><select id='unit' name="strUnitCode"
					class="comboNormal" onchange="getConsultantCombo();">
					<option value="0">Select Value</option>
					<bean:write name="DossierSettlementBean" property="strUnitValues"
						filter="false" />
				</select></div>
				</td>
			</tr>
			<tr>
				<td width="25%" class="LABEL">Prescribed
				By</td>
				<td width="25%" class="CONTROL">
				<div id="consultantDivId"><select name="strPrescribedBy"
					class="comboNormal">
					<option value="0">Select Value</option>
				</select></div>
				</td>
				<td width="25%" class="LABEL">Prescribed
				For</td>
				<td width="25%" class="CONTROL"><input type="text"
					class="txtFldMin" name="strPrescribedFor" maxlength="3"
					onkeypress="return validateData(event,5);">Days</td>

			</tr> --%>
		<!-- <tr style="display: none;">
				<td width="25%" class="LABEL">Prescription
				Date</td>
				<td width="25%" class="CONTROL"><date:date name="strPrescriptionDate"
					value="${DossierSettlementBean.strCtDate}"></date:date></td>

				<td width="25%" colspan="1" class="LABEL">Prescription
				From</td>
				<td width="25%" colspan="1" class="CONTROL"><select
					name="strPrescriptionFrom" class="comboNormal">
						<option title="Opd Special" value="4" class="important">Opd Special</option>
	<option title="Opd Morning"  value="1" class="noneimportant">Opd Morning</option>
	<option title="Ipd" value="2" class="noneimportant">Ipd</option>
	<option title="Emergency" value="3" selected="" class="noneimportant">Emergency</option>
				</select></td>
			</tr>
			
			<tr style="display: none">
			<td class="LABEL" width="25%"><font color="red">*</font>Issuing Store</td>
				<td class="CONTROL" width="25%"><select id='strToStoreDiv' name="strToStoreName"
					class="comboNormal" onchange="">
					<option value="0">Select Store</option>
					<bean:write name="DossierSettlementBean" property="strToStoreNameValues"
						filter="false" />
				</select></td>
				<td class="LABEL" width="25%"></td>
				<td class="CONTROL" width="25%"></td>
			</tr>
			
			<logic:notEqual value="OT"  name="DossierSettlementBean"  property="requestMode" >  <!-- Added By Ranjit for Dossier OT Integration  -->
			
		<!-- <logic:equal value="11" name="DossierSettlementBean" property="strSericeType">
			<tr style="display: none">
			<td class="LABEL" width="25%"><font color="red">*</font>Raising From</td>
			<td class="CONTROL" width="25%">
			<select id='dep1' name="strDepartment"
					class="comboNormal" onchange="getServicesDtls()" >
					<bean:write name="DossierSettlementBean" property="strDepartmentValues"
						filter="false" />
				</select>
			
				</td>
			
			<td class="LABEL" width="25%"><font color="red">*</font>Service</td>
				<td class="CONTROL" width="25%"><select id='serviceCmb' name="strService"
					class="comboNormal" onchange="getDossierName()">
					<option value="0">Select Value</option>
					<bean:write name="DossierSettlementBean" property="strServiceValues"
						filter="false" />
				</select></td>
				
				</tr>
			</logic:equal>
			</logic:notEqual>
			
			
			<logic:notEqual value="OT"  name="DossierSettlementBean"  property="requestMode" >  <!-- Added By Ranjit for Dossier OT Integration  -->
			
		<!-- <logic:equal value="12" name="DossierSettlementBean" property="strSericeType">
			<tr style="display: none">
			<td class="LABEL" width="25%"><font color="red">*</font>Labs</td>
			<td class="CONTROL" width="25%">
			<select id='dep1' name="strDepartment"
					class="comboNormal" onchange="getServicesDtls()" >
					<bean:write name="DossierSettlementBean" property="strDepartmentValues"
						filter="false" />
				</select>
			
				</td>
			
			<td class="LABEL" width="25%"><font color="red">*</font>Test</td>
				<td class="CONTROL" width="25%"><select id='serviceCmb' name="strService"
					class="comboNormal" onchange="getDossierName()">
					<option value="0">Select Value</option>
					<bean:write name="DossierSettlementBean" property="strServiceValues"
						filter="false" />
				</select></td>
				
				</tr>
			</logic:equal>
			</logic:notEqual>
			
			<logic:notEqual value="OT"  name="DossierSettlementBean"  property="requestMode" >  <!-- Added By Ranjit for Dossier OT Integration  -->
		<!-- <logic:equal value="13" name="DossierSettlementBean" property="strSericeType">
			<tr style="display: none">
			<td class="LABEL" width="25%"><font color="red">*</font>Service</td>
			<td class="CONTROL" width="25%">
			<select id='dep1' name="strDepartment"
					class="comboNormal" onchange="getServicesDtls()" >
					<bean:write name="DossierSettlementBean" property="strDepartmentValues"
						filter="false" />
				</select>
			
				</td>
			
			<td class="LABEL" width="25%"><font color="red">*</font>Procedure</td>
				<td class="CONTROL" width="25%"><select id='serviceCmb' name="strService"
					class="comboNormal" onchange="getDossierName()">
					<option value="0">Select Value</option>
					<bean:write name="DossierSettlementBean" property="strServiceValues"
						filter="false" />
				</select></td>
				
				</tr>
			</logic:equal>
			</logic:notEqual>
			
			<logic:notEqual value="OT"  name="DossierSettlementBean"  property="requestMode" >  <!-- Added By Ranjit for Dossier OT Integration  -->
		<!--  	<tr style="display: none">
			<td class="LABEL" width="25%"><font color="red">*</font>Dossier Name</td>
			<td class="CONTROL" width="25%">
			<select id='DossierId' name="strDossiercat"
					class="comboNormal" onchange="getDossierItemDtls()" >
					<option value="0">Select Value</option>
					<bean:write name="DossierSettlementBean" property="strDossiercatValues"
						filter="false" />
				</select>
			
				</td>
			
		<td class="LABEL" width="25%"></td>
				<td class="CONTROL" width="25%"></td>
				
				</tr>
				</logic:notEqual>
				
				
	
	<logic:equal value="OT"  name="DossierSettlementBean"  property="requestMode" >	-->	<!-- Added By Ranjit for Dossier OT Integration  -->
	<!-- <tr style="display: none">
			<td class="LABEL" width="25%"><font color="red">*</font>Operation Name</td>
			<td class="CONTROL" width="75%">
			
			<select name="raisedOperation"  id="raisedOperation"  onChange="getDossierOT(this);"  >
			<option value="-1" >Select Value</option>
			<c:forEach var='entry' items='<%=session.getAttribute("OTOPERATIONNAMELIST") %>'>
				<option value="${entry.key}" >${entry.value}</option>
			</c:forEach>
			</select>
			
				</td>
		</tr>
		</logic:equal>				
				
				
		<logic:equal value="OT"  name="DossierSettlementBean"  property="requestMode" >		<!-- Added By Ranjit for Dossier OT Integration  -->
			<!-- 		<tr style="display: none">
			<td class="LABEL" width="25%"><font color="red">*</font>Dossier Name</td>
			<td class="CONTROL" width="75%">
			<div id="dossierDiv" >
			
			</div>
			
				</td>
		</tr>
		</logic:equal>	
		
			

		</table> -->
		
		
		<%-- <bean:write name="DossierSettlementBean" property="strOnlineTreatment"
				filter="false" /> --%>
		
		
		
					
		<div id="dossierIdty" style="display:none">
		<table class="TABLEWIDTH" align="center" cellspacing="1px"
			cellpadding="1px">
<tr>
			<td class="LABEL" width="25%" ></td>
			<td class="LABEL" width="25%">Add Additional Items</td>
			
			<td class="LABEL" width="25%"><font color="red">*</font>Item Category</td>
				<td class="CONTROL" width="25%"><select id='dep' name="stritemcat"
					class="comboNormal" onchange="">
					<bean:write name="DossierSettlementBean" property="strItemCatValues"
						filter="false" />
				</select></td>
				
				</tr>

</table>
		</div>
		
		
		


	<table class="TABLEWIDTH" align="center" cellpadding="1" cellspacing="1">
		<tr style="display: none;">
			<td colspan="2" class="LABEL"><font color="red">*</font>Receive	By</td>
			
			<td colspan="2" class="CONTROL"><input type="text"
				class="txtFldMax" name="strReceiveBy" onkeypress="return validateData(event,11);">

				</td>
		</tr>

		<tr style="display: none;" >
			<td class="LABEL" align="center" colspan="2"><font color='red'>*</font>Delivery Location/Other Remarks</td>
			<td class="CONTROL"  align="center" colspan="2"><textarea name="strRemarks" id="strRemarks"	cols="25" rows="2" onkeypress="return validateData(event,9);"></textarea></td>
		</tr>
	</table>
</div>
	<table class="TABLEWIDTH" align="center" cellpadding="1"
		cellspacing="1">
		<tr class="FOOTER">
			<td colspan="4"><font color="red">*</font> Mandatory Fields</td>
		</tr>
	</table>
<div id='svbtn' style='display:none'>	<table border="0" class="TABLEWIDTH" align="center" cellpadding="1"
		cellspacing="1">
		<tr>
			<td align="center">
			<!--<img style=" cursor: pointer"
				src="../../hisglobal/images/btn-sv.png"
				onclick="return validateIssue();" /> <img
				style=" cursor: pointer"
				src="../../hisglobal/images/btn-clr.png" onClick="clearIssue();">
			<img style=" cursor: pointer"
				src="../../hisglobal/images/back_tab.png" onClick="controlToIssueToPatientPage();">-->
				<br>
				
				
				<a href="#" class="button" id="" onclick=' return validateIssue1();'><span class="save">Finalize</span></a>
				
				<a href="#" class="button" onclick="controlToIssueToPatientPage();"><span class="cancel">Cancel</span></a>
				
			</td>

		</tr>
	</table></div>
	<input type="hidden" name="hmode" />
	<input type="hidden" name="strUpdateFlag" value="" />
	
	<input type="hidden" name="storeName" value="${DossierSettlementBean.storeName}" />
	<input type="hidden" name="itemCatName"
		value="${DossierSettlementBean.itemCatName}" />
		<input type="hidden" name="strCrNo"
		value="${DossierSettlementBean.strCrNo}" />
	<input type="hidden" name="crNo" value="${DossierSettlementBean.crNo}" />
	<input type="hidden" name="strId" value="${DossierSettlementBean.strId}" />
	<input type="hidden" name="itemCategory"
		value="${DossierSettlementBean.itemCategory}" />
	<input type="hidden" name="strConfCatCode"
		value="${DossierSettlementBean.strConfCatCode}" />
	<input type="hidden" name="strIssueNo" value="${DossierSettlementBean.strIssueNo}" />
	<input type="hidden" name="strIssueDtl"
		value="${DossierSettlementBean.strIssueDtl}" />
	<input type="hidden" name="disFlag" value="${DossierSettlementBean.disFlag}" />
	<input type="hidden" name="mode" value="${DossierSettlementBean.strMode}" />
	<input type="hidden" name="strMode" value="${DossierSettlementBean.strMode}">
	<input type="hidden" name="strIssueMode"
		value="${DossierSettlementBean.strIssueMode}">
	<input type="hidden" name="strCtDate" value="${DossierSettlementBean.strCtDate}" />
	<input type="hidden" name="strVisitDtl" value="${DossierSettlementBean.strVisitDtl}" />
	<input type="hidden" name="strIssueNum" value="${DossierSettlementBean.strIssueNum}" />
	<input type="hidden" name="isUpdateOpdDrugReq" value="" />
	<input type="hidden" name="strGlobalval" value="" />
	<input type="hidden" name="strErrMsg" value="${DossierSettlementBean.strErrMsg}" />
	<input type="hidden" name="strTariff_Flag" value="1" />
	<input type="hidden" name="strcallfromipd" value="5" />
	<%-- <input 	type="hidden" name="strCIMSIntegration" value="${DossierSettlementBean.strCIMSIntegration}"> --%>
	<input type="hidden" name="strRowCount" value="0" />
	<input type="hidden" name="strSericeType" value="${DossierSettlementBean.strSericeType}" />
	<input type="hidden" name="strPatientType" value="1" />
	<input type="hidden" name="strBillingHiddenValue" value="${DossierSettlementBean.strBillingHiddenValue}" />
	
	<input type="hidden" name="requestMode"  id="requestMode"  value="${DossierSettlementBean.requestMode}" />  <!--   Added By Ranjit on 29072019  -->
	
		<input type="hidden" name="allOperationCodes" id="allOperationCodes"   value="${DossierSettlementBean.allOperationCodes}"  />  <!-- Added By Ranjit for Dossier OT Integration  -->
	<input type="hidden" name="departmentCode"  id="departmentCode" value="${DossierSettlementBean.departmentCode}" /> <!-- Added By Ranjit for Dossier OT Integration  -->
	<input type="hidden" name="otReqNo"  id="otPacReqNo" value='<%= request.getParameter("otReqNo") %>' /> <!-- Added By Ranjit for Dossier OT Integration  -->
	
	<input type="hidden" name="saveFlag"  id="saveFlag"   value="${OTDossierFB.saveFlag}"  />  <!-- Added By Ranjit for Dossier OT Integration  -->
	
	<cmbPers:cmbPers />
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
<div class="popUpDiv" id="popUpDiv1" style="display: none;">
	<table bgcolor="white">
		<tr>
			<td>
						
				<div id="issueDtlsDivId" style="display: block;"></div>
		
			</td>
		</tr>
	</table>
	</div>
	


</html:form>

	<tag:autoIndex></tag:autoIndex>   
</body>
</html>