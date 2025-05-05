<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic"%>
<%@taglib uri="/WEB-INF/dateTag.tld" prefix="dateTag"%>
<%@ taglib uri="/WEB-INF/hisTab.tld" prefix="tag"%>
<%@ taglib uri="/WEB-INF/comboPersistence.tld" prefix="cmbPers"%>

<html>
<head>
<meta charset="utf-8">
<title>CIMS Generic Drug Master</title>
<link href="../css/master.css" rel="stylesheet" type="text/css">
<link href="../../hisglobal/css/buttons.css" rel="stylesheet" type="text/css">
<link href="../../hisglobal/css/tab.css" rel="stylesheet"
	type="text/css">
<link href="../../hisglobal/css/calendar-tas.css" rel="stylesheet"
	type="text/css">

<link href="../../hisglobal/css/popup.css" rel="stylesheet"
	type="text/css">


<script language="JavaScript"
	src="../../hisglobal/masterutil/js/master.js"></script>
<script language="JavaScript" src="../../hisglobal/js/tab.js"></script>
<script language="JavaScript" src="../../hisglobal/js/calendar.js"></script>
<script language="Javascript" src="../../hisglobal/js/validation.js"></script>
<script language="JavaScript" src="../../hisglobal/js/multirow.js"></script>
<script language="JavaScript" src="../../hisglobal/js/util.js"></script>


<script type="text/javascript"><!--
	var flag=false;
	function view1(id1,id2,id3)
	{
		document.getElementById(id1).style.display="none";
		document.getElementById(id2).style.display="block";
		document.getElementById(id3).style.display="block";
	}
	function view2(id1,id2,id3)
	{
		document.getElementById(id1).style.display="block";
		document.getElementById(id2).style.display="none";
		document.getElementById(id3).style.display="none";
	}
	
	function setConsentReq()
	{ 
		if(document.forms[0].strConsentReq.checked==true)
		{
		// alert("consent 1");
			document.forms[0].strConsentReq.value="1";
		}
		else
		{
		// alert(" consent 0");
			document.forms[0].strConsentReq.value="0";
		}
	}
	function setBatchNo()
	{
		if(document.forms[0].strBatchNo.checked)
		{
			document.forms[0].strBatchNo.value="1";
		}
		else
		{
			document.forms[0].strBatchNo.value="0";
		}
	}
	function setExpiryDate()
	{
		if(document.forms[0].strExpiryDate.checked)
		{
			document.forms[0].strExpiryDate.value="1";
		}
		else
		{
			document.forms[0].strExpiryDate.value="0";
		}
		
	}
	function setIsItemNarcotic()
	{
		if(document.forms[0].strIsItemNarcotic.checked)
		{
			document.forms[0].strIsItemNarcotic.value="1";
		}
		else
		{
			document.forms[0].strIsItemNarcotic.value="0";
		}
	}
	
	function validate()
	{
		     var hisValidator = new HISValidator("cimsgenericdrugBean");
		    hisValidator.addValidation("strDrugName", "req", "Drug Name is a Mandatory Field" );
		    
		    /*
	    		The following code is commented due to change request from Ajay Sir(Dec 2010).
				Generic Drug Code Should not be mandatory. 
	    	*/
		    /*
		    if(document.forms[0].strCPACode != null){
        	
     	   		hisValidator.addValidation("strCPACode", "req","Drug Code is a Mandatory Field");
     
    		 }
		    */
		     
		    
          // hisValidator.addValidation("strPurchaseLeadTime", "req", "Purchase Lead Time is a Mandatory Field" );
            hisValidator.addValidation("strStockMaintain", "dontselect=0","Please Select Inventory Unit"); 
         hisValidator.addValidation("strShelfLife", "req", "Shelf Life Time is a Mandatory Field" );
           // hisValidator.addValidation("strEffectiveFrom", "date","Effective Date is a mandatory field");
            
         /*   if(document.getElementById("pregnancySafeFlag").checked!=1) {
         hisValidator.addValidation("strTrimester", "dontselect='NOT_SELECTED'","Please Select a Trimester.");
         hisValidator.addValidation("strEffectsOnFoetus", "req", "Effects on Foetus is a Mandatory Field" );
         hisValidator.addValidation("strEffectsOnFoetus", "maxlen=250", "Effects on Foetus cannot exceeds 250 characters." );
        }
        
        hisValidator.addValidation("strRemarks", "maxlen=100", "Remarks cannot exceeds 100 characters." );*/
   
        hisValidator.addValidation("strAdminRoute", "dontselect=0","Please Select Administration Route");
        hisValidator.addValidation("strContraindictioncode", "dontselect=0","Please Select Contraindications");
        hisValidator.addValidation("strDrugAdmincode", "dontselect=0","Please Select Administration");
            
            var retVal = hisValidator.validate();
            hisValidator.clearAllValidations();

            var tempArr=[],tempArr1=[];
            var c=0;
            for(var i=0;i<document.forms[0].strDrugval.length;i++)
            {
                  	if(document.forms[0].strDrugval[i].selected)
                	{
            		tempArr[c]=document.forms[0].strDrugval[i].value.split("^")[0];
            		tempArr1[c]=document.forms[0].strDrugval[i].value.split("^")[1];
            		c++;
                	}	
            }
            for(var i=0;i<tempArr.length;i++)
            {
                if(i==0)
                {
                    document.forms[0].strContradictoryDrugArray.value=tempArr[i];
                    document.forms[0].strContradictoryDrugIdArray.value=tempArr1[i];
                }
                else
                {
                	document.forms[0].strContradictoryDrugArray.value+=","+tempArr[i];
                	document.forms[0].strContradictoryDrugIdArray.value+=","+tempArr1[i];
                }
            }




            
            if(retVal)
		    {
		   		// alert("strConsentReq-"+document.forms[0].strConsentReq.value);
		   		document.forms[0].hmode.value="UPDATE";
		   		document.forms[0].submit();
		   }
	}

	function getDetails()
	{
	/*
		if(document.forms[0].strBatchNo.value==1)
		{
			document.forms[0].strBatchNo.checked=true;
		}
		if(document.forms[0].strExpiryDate.value==1)
		{
			document.forms[0].strExpiryDate.checked=true;
		}
		
		if(document.forms[0].strIsItemNarcotic.value==1)
		{
			document.forms[0].strIsItemNarcotic.checked=true;
		}
		if(document.forms[0].strConsentReq.value==1)
		{
			document.forms[0].strConsentReq.checked=true;
		}*/
		
	}
	
	function setPreviousSelectedDrugVal()
	{
		
			var earlierSelVal=document.getElementsByName('strDrugIdval')[0];
			var tempArr=earlierSelVal.value.split(',');
			var obj=document.getElementsByName('strDrugval')[0];
			obj.options[0].selected=false;
			for(var i=0;i<obj.options.length;i++)
			{
				for(var j=0;j<tempArr.length;j++)
				{
					//alert(obj.options[i].value.split("^")[1]);
					//alert(tempArr[j]);
					if(obj.options[i].value.split("^")[1]==tempArr[j])
					{
						obj.options[i].selected=true;
					}
				}
				
			}
	}
	
</script>
</head>
<body onload="getDetails();setPreviousSelectedDrugVal();">
<html:form action="/masters/CIMSGenericDrugMstCNT" name="cimsgenericdrugBean"
	type="mms.masters.controller.fb.CIMSGenericDrugMstFB">


	<center>
	<div class="errMsg" id="errMsgId"><bean:write
		name="cimsgenericdrugBean" property="strErrMssgstring" /></div>
	<div class="warningMsg" id="warningMsgId"><bean:write
		name="cimsgenericdrugBean" property="strWarnMssgstring" /></div>
	<div class="normalMsg" id="normalMsgId"><bean:write
		name="cimsgenericdrugBean" property="strNormMssgstring" /></div>
	<tag:tab tabLabel="CIMS Generic Drug Master" selectedTab="FIRST"
		align="center" width="TABLEWIDTH" onlyTabIndexing="1">

	</tag:tab></center>

	<table class="TABLEWIDTH" align="center" cellspacing="1px">
		<tr class="HEADER">
			<td colspan="4" width="25%">CIMS Generic Drug Master&gt;&gt; Modify</td>
		</tr>
		<tr>
			<td width="25%" class="LABEL">Group Name</td>
			<td class="CONTROL"><bean:write name="cimsgenericdrugBean"
				property="strGroupNameValue" filter="false" /></td>
			<td width="25%" class="LABEL">Sub Group Name</td>
			<td width="25%" class="CONTROL"><bean:write
				name="cimsgenericdrugBean" property="strSubGroupNameValue"
				filter="false" /></td>
		</tr>
		<tr>
			<td width="25%" colspan="1" class="LABEL">ATC Classification</td>
			<td width="75%" class="CONTROLCIMS" colspan="3">
				<input type="text" autocomplete='off' name="strCPACode" maxlength="7" style="text-transform: uppercase" class="txtFldNormal" onkeyup="lTrim(this);" onkeypress="return validateData(event,9);" value="${cimsgenericdrugBean.strCPACode}" />
			</td>
		</tr>
		<tr>
			<td class="LABEL" colspan="1" width="25%">Consumable Type</td>
			<td class="CONTROL" width="25%"><html:select
				property="strConsumableType" name="cimsgenericdrugBean">
				<html:option value="1"> Consumable</html:option>

			</html:select></td>
			<td width="25%" class="LABEL"><font color="red">*</font>Generic
			Drug Name</td>
			<td width="25%" class="CONTROL"><input type="text"
				name="strDrugName" maxlength="100" class="txtFldMax" onkeyup="lTrim(this);"
				onkeypress="return validateDataWithSpecialChars(event,18,'%.:;+-/*,');"
				value="${cimsgenericdrugBean.strDrugName}" /></td>
		</tr>
	    <tr>
			<td class="LABEL" width="25%">Pregnancy Category</td>
			<td class="CONTROLCIMS" width="25%">			
				<html:select property="strPregnancySafeFlag" name="cimsgenericdrugBean" styleClass="comboNormalCIMS">
				<bean:write property="strPregnancySafeFlag" name="cimsgenericdrugBean" filter="false"/>

			</html:select>
					
			</td>
			
			<td width="25%" class="LABEL"><font color="red">*</font>Contraindications</td>
			<td width="25%" class="CONTROLCIMS">
				<html:select property="strContraindictioncode" name="cimsgenericdrugBean" styleClass="comboNormalCIMS">
					<bean:write property="strContraindictioncode" name="cimsgenericdrugBean"  filter="false"/>	
				</html:select>
			</td>
		</tr>
		<tr>
			<td width="25%" colspan="1" class="LABEL"><font color="red">*</font>Administration Route</td>			
			<td width="25%" class="CONTROLCIMS">
			   	<html:select property="strAdminRoute" name="cimsgenericdrugBean" styleClass="comboNormalCIMS">
					<bean:write property="strAdminRoute" name="cimsgenericdrugBean"  filter="false"/>				
				</html:select>		
			</td>
			<td class="LABEL" colspan="1" width="25%">Special Precautions</td>
			<td class="CONTROLCIMS" width="25%">
				<textarea rows="2" cols="20" name="strsprecau" id="strsprecau" onkeyup="lTrim(this);"><bean:write	property="strsprecau" name="cimsgenericdrugBean"  filter="false"/></textarea>
			</td>
			
		</tr>
		<tr>
			<td class="LABEL" colspan="1" width="25%">Drug Interactions & Contracdictions</td>
			<td class="CONTROLCIMS" width="25%">
				<html:select name="cimsgenericdrugBean" multiple="" styleClass="comboNormalCIMSMulti" size="5" property="strDrugval"> 
				 <bean:write	property="strDrugval" name="cimsgenericdrugBean"  filter="false"/>

			</html:select>
				
			</td>
			<td width="25%" class="LABEL">Adverse Drug Reactions</td>
			<td width="25%" class="CONTROLCIMS">
				<textarea rows="2" cols="20" name="stradvdrug" id="stradvdrug" onkeyup="lTrim(this);"><bean:write	property="stradvdrug" name="cimsgenericdrugBean"  filter="false"/></textarea>
			</td>			
		</tr>
		<tr>
			<td width="25%" class="LABEL"><font color="red">*</font>Administration</td>
			<td width="25%" class="CONTROLCIMS">
				<html:select property="strDrugAdmincode" styleClass='comboNormalCIMS' name="cimsgenericdrugBean">
					<bean:write property="strDrugAdmincode" name="cimsgenericdrugBean"  filter="false"/>
				</html:select>
			</td>
			<td width="25%" class="LABEL"><font color="red">*</font>Storage</td>
			<td width="25%" class="CONTROLCIMS">
				<html:select property="strStoragecode" name="cimsgenericdrugBean" styleClass="comboNormalCIMS">
					<bean:write property="strStoragecode" name="cimsgenericdrugBean"  filter="false"/>					
				</html:select>
			</td>
			
			
		</tr>
		
		<tr>
			<td class="LABEL" colspan="1" width="25%">Mechanism of Action</td>
			<td class="CONTROLCIMS" width="25%">
				<textarea rows="2" cols="20" name="strmechact" id="strmechact" onkeyup="lTrim(this);"><bean:write	property="strmechact" name="cimsgenericdrugBean"  filter="false"/></textarea>
			</td>
			<td class="LABEL" colspan="1" width="25%">Laboratory Interferance</td>
			<td class="CONTROLCIMS" width="25%">
				<textarea rows="2" cols="20" name="strlabintfrnce" id="strlabintfrnce" onkeyup="lTrim(this);"><bean:write	property="strlabintfrnce" name="cimsgenericdrugBean"  filter="false"/></textarea>
			</td>
			
		</tr>
		<tr>
			<!--  <td width="25%" class="LABEL"><font color="red">*</font>Available Brands</td>
			<td width="25%" class="CONTROLCIMS">
				<html:select property="strConsumableType" name="cimsgenericdrugBean" styleClass="comboNormalCIMS">
					<html:option value="1">Brand 1</html:option>
				</html:select>
			</td>-->
			
			<td class="LABEL" colspan="1" width="25%">Dosage(Adult)</td>
			<td class="CONTROLCIMS" width="25%">
				<textarea rows="2" cols="20" name="strdosageadult" ><bean:write	property="strdosageadult" name="cimsgenericdrugBean"  filter="false"/></textarea>
			</td>
			<td class="LABEL" colspan="1" width="25%">Dosage(Peads)</td>
			<td class="CONTROLCIMS" width="25%">
				<textarea rows="2" cols="20" name="strdosagepeads" ><bean:write	property="strdosagepeads" name="cimsgenericdrugBean"  filter="false"/></textarea>
			</td>
		</tr>	
		<tr>
			<td class="LABEL"  width="25%"><font color="red">*</font>Drug Inventory Unit</td>
			<td class="CONTROLCIMS"  width="25%"><select
				name="strStockMaintain">
				<bean:write name="cimsgenericdrugBean"
					property="strStockMaintainedValues" filter="false" />

			</select></td>
			<td class="LABEL" colspan="3" width="25%"></td>
		</tr>
		<tr>
			<td class="LABEL" colspan="1" width="25%"><font color="red">*</font>Shelf Life</td>
			<td class="CONTROLCIMS" colspan="" width="25%">
			<input type="text"	name="strShelfLife" maxlength="3" class="txtFldMin"	onkeypress="return validateData(event,5);" value="${cimsgenericdrugBean.strShelfLife}" /></td>
			<td class="LABEL" colspan="1" width="25%">Time Format</td>
			<td class="CONTROLCIMS" colspan="1" width="25%"><html:select value="${cimsgenericdrugBean.strShelfTimeFormat}"
				property="strShelfTimeFormat">
				<html:option value="1"> Day</html:option>
				<html:option value="2"> Month</html:option>
				<html:option value="3">Year</html:option>
			</html:select></td>
		</tr>
		</table>
		
	


	
	<table cellspacing="1px" class="TABLEWIDTH" align="center">
		<tr class="FOOTER">
			<td colspan="4" width="25%"><font size="2" color="red">*</font>
			Mandatory Fields</td>
		</tr>
	</table>
	<table class="TABLEWIDTH" align="center" cellspacing="1px">

		<tr>

			<td align="center" colspan="2" width="25%"><!-- <img
				src="../../hisglobal/images/btn-sv.png" title="Save Record"
				onClick="validate();" style="cursor: pointer;" /> <img
				src="../../hisglobal/images/btn-ccl.png" title="Cancel Process"
				onClick="cancel('LIST');" style="cursor: pointer;"> -->
				
				<br>
				<a href="#" class="button" id="" onclick='validate();'><span class="save">Save</span></a>
				<a href="#" class="button" onclick="cancel('LIST');"><span class="cancel">Cancel</span></a>
				</td>
		</tr>
	</table>
	<input type="hidden" name="hmode" />
	<input type="hidden" value="${cimsgenericdrugBean.strCurrentDate}"
		name="strCurrentDate" />
	<input type="hidden" value="${cimsgenericdrugBean.strGroupId}"
		name="strGroupId" />
	<input type="hidden" value="${cimsgenericdrugBean.strSubGroupId}"
		name="strSubGroupId" />
	<input type="hidden" value="${cimsgenericdrugBean.strChk}" name="strChk" />

	<input type="hidden" value="${cimsgenericdrugBean.strIsItemCodeRequired}"
		name="strIsItemCodeRequired" />
	<input type="hidden" name="strEffectiveFrom" value="${cimsgenericdrugBean.strEffectiveFrom}">
	<input type="hidden" name="strStockMaintainedCode" value="${cimsgenericdrugBean.strStockMaintainedCode}">
	<input type="hidden" value="${cimsgenericdrugBean.strContradictoryDrugArray}" name="strContradictoryDrugArray" />
	<input type="hidden" value="${cimsgenericdrugBean.strContradictoryDrugIdArray}" name="strContradictoryDrugIdArray" />
	<input type="hidden" value="${cimsgenericdrugBean.strDrugIdval}" name="strDrugIdval" />
	<cmbPers:cmbPers />


</html:form>
<tag:autoIndex></tag:autoIndex>
</body>
</html>
