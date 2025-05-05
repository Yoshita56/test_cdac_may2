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
<meta charset=utf-8>
<title>CIMS Generic Drug Master</title>
<link href="../css/master.css" rel="stylesheet" type="text/css">
<link href="../../hisglobal/css/tab.css" rel="stylesheet" type="text/css">
<link href="../../hisglobal/css/calendar-tas.css" rel="stylesheet" type="text/css">
<link href="../../hisglobal/css/popup.css" rel="stylesheet" type="text/css">
<link href="../../hisglobal/css/newpopup.css" rel="stylesheet" type="text/css">
<link href="../../hisglobal/css/buttons.css" rel="stylesheet" type="text/css">

<script language="JavaScript" src="../../hisglobal/masterutil/js/master.js"></script>
<script language="JavaScript" src="../../hisglobal/js/tab.js"></script>
<script language="JavaScript" src="../../hisglobal/js/calendar.js"></script>
<script language="Javascript" src="../../hisglobal/js/validation.js"></script>
<script language="JavaScript" src="../../hisglobal/js/multirow.js"></script>
<script language="JavaScript" src="../../hisglobal/js/util.js"></script>
<script language="Javascript" src="../../hisglobal/js/newpopup.js"></script>
<script language="Javascript" src="../../hisglobal/js/popup.js"></script>

<script type="text/javascript">
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
		if(document.forms[0].strConsentReq.checked)
		{
			document.forms[0].strConsentReq.value="1";
		}
		else
		{
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
	
	function validate1()
	{
		 var hisValidator = new HISValidator("cimsgenericdrugBean");
	    hisValidator.addValidation("strDrugName", "req", "Drug Name is a Mandatory Field" );
	    
	    /*
	    	The following code is commented due to change request from Ajay Sir(Dec 2010).
	    */
	    /*
	     if(document.forms[0].strCPACode != null){
        	
        	   hisValidator.addValidation("strCPACode", "req","Drug Code is a Mandatory Field");
        
        }
	     */
	    
        /*commented by vikrant after discussion with Priyesh Ranjan Sir
	    
         hisValidator.addValidation("strPurchaseLeadTime", "req", "Purchase Lead Time is a Mandatory Field" );
        
	     */
         
        hisValidator.addValidation("strStockMaintain", "dontselect=0","Please Select Inventory Unit");
        hisValidator.addValidation("strShelfLife", "req", "Shelf Life Time is a Mandatory Field" );
        hisValidator.addValidation("strAdminRoute", "dontselect=0","Please Select Administration Route");
        hisValidator.addValidation("strContraindictioncode", "dontselect=0","Please Select Contraindications");
        hisValidator.addValidation("strDrugAdmincode", "dontselect=0","Please Select Administration");
      //  hisValidator.addValidation("strEffectiveFrom", "date","Effective Date is a mandatory field");
      /*  if(document.getElementById("pregnancySafeFlag").checked!=1) {
         hisValidator.addValidation("strTrimester", "dontselect='NOT_SELECTED'","Please Select a Trimester.");
         hisValidator.addValidation("strEffectsOnFoetus", "req", "Effects on Foetus is a Mandatory Field" );
         hisValidator.addValidation("strEffectsOnFoetus", "maxlen=250", "Effects on Foetus cannot exceeds 250 characters." );
        }
        
        hisValidator.addValidation("strRemarks", "maxlen=100", "Remarks cannot exceeds 100 characters." );*/
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
      // alert(document.forms[0].strContradictoryDrugIdArray.value);
     //  alert(document.forms[0].strContradictoryDrugArray.value);
               if(retVal ) 
		    {
 	   		document.forms[0].hmode.value="INSERT";
		   		document.forms[0].submit();
		    }
	}
	
	/*
	* This function checks the length of a input text in a text area is permissable of not.
	*
	* parameters:
	*	id			: id of the textarea element.
	*	maxLength	: maximum permissable length of text.
	*
	* returns	:bollean value {true,false}
	*/	
	function checkLength(id,maxLength){
	
		inputText=document.getElementById(id).value;
    	if (inputText.length > maxLength){
        	alert("Text too long. Must be " + maxLength + " characters or less");
        	return false;
    	}
    	return true;
	}
	
	function clearScreen() {
		document.forms[0].hmode.value="CLEAR";
		document.forms[0].submit();
	}
	function displayPregnancySafetyDetail(pregnancySafeFlagElement) {
	    //var pregnancySafetyDetail = document.getElementById("pregnancySafetyDetail");
	    var pregnancySafetyDetailTd1 = document.getElementById("pregnancySafetyDetailTd1");
	    var pregnancySafetyDetailTd2 = document.getElementById("pregnancySafetyDetailTd2");
	    var pregnancySafetyDetailTd3 = document.getElementById("pregnancySafetyDetailTd3");
	    var pregnancySafetyDetailTd4 = document.getElementById("pregnancySafetyDetailTd4");
		if(pregnancySafeFlagElement.checked==1) {
			//alert("Checked");
			//pregnancySafetyDetail.style.display="none";
			pregnancySafetyDetailTd1.style.display="none";
			pregnancySafetyDetailTd2.style.display="none";
			pregnancySafetyDetailTd3.style.display="none";
			pregnancySafetyDetailTd4.style.display="none";
		}else{
			//alert("Unchecked");
			//pregnancySafetyDetail.style.display="block";
			pregnancySafetyDetailTd1.style.display="block";
			pregnancySafetyDetailTd2.style.display="block";
			pregnancySafetyDetailTd3.style.display="block";
			pregnancySafetyDetailTd4.style.display="block";
		}
		//pregnancySafetyDetail.style.display="none";
	}
	function displayOnloadPregnancySafetyDetail() {
	    var pregnancySafeFlag = document.getElementById("pregnancySafeFlag");
		displayPregnancySafetyDetail(pregnancySafeFlag);
	}
	
	
	
</script>
</head>
<body onload="displayOnloadPregnancySafetyDetail();">
<html:form action="/masters/CIMSGenericDrugMstCNT" name="cimsgenericdrugBean"
	type="mms.masters.controller.fb.CIMSGenericDrugMstFB">


	<center>
		<div class="errMsg" id="errMsgId"><bean:write name="cimsgenericdrugBean" property="strErrMssgstring" /></div>
		<div class="warningMsg" id="warningMsgId"><bean:write name="cimsgenericdrugBean" property="strWarnMssgstring" /></div>
		<div class="normalMsg" id="normalMsgId"><bean:write name="cimsgenericdrugBean" property="strNormMssgstring" /></div>		
	</center>
	
<tag:tab tabLabel="CIMS Generic Drug Master" selectedTab="FIRST" align="center" width="TABLEWIDTH" onlyTabIndexing="1"></tag:tab>

<div id="blanket" style="display: none;"></div>

	<table class="TABLEWIDTH" align="center" cellspacing="1px" bgcolor='lightblue'>
		<tr class="HEADER">
			<td colspan="4" width="25%">CIMS Generic Drug Master&gt;&gt; Add</td>
		</tr>
		<tr>
			<td width="25%" class="LABEL">CIMS Class/Group Name</td>
			<td class="CONTROLCIMS"><html:hidden name="cimsgenericdrugBean"
				property="strGroupNameValue" /> <bean:write name="cimsgenericdrugBean"
				property="strGroupNameValue" filter="false" /></td>
			<td width="25%" class="LABEL">CIMS Subclass/Sub Group Name</td>
			<td width="25%" class="CONTROLCIMS"><html:hidden
				name="cimsgenericdrugBean" property="strSubGroupNameValue" /> <bean:write
				name="cimsgenericdrugBean" property="strSubGroupNameValue"
				filter="false" /></td>
		</tr>
		<tr>
			<td width="25%" colspan="1" class="LABEL">ATC Classification</td>
			<td width="75%" class="CONTROLCIMS" colspan="3">
				<input type="text" autocomplete='off' name="strCPACode" maxlength="7" style="text-transform: uppercase" class="txtFldNormal" onkeyup="lTrim(this);" onkeypress="return validateData(event,9);" value="0" />
			</td>
		</tr>
		<tr>
			<td class="LABEL" colspan="1" width="25%">Consumable Type</td>
			<td class="CONTROLCIMS" width="25%"><html:select
				property="strConsumableType" name="cimsgenericdrugBean" styleClass="comboNormalCIMS">
				<html:option value="1"> Consumable</html:option>

			</html:select></td>
			<td width="25%" class="LABEL"><font color="red">*</font>Generic
			Drug Name</td>
			<td width="25%" class="CONTROLCIMS" ><input type="text" autocomplete='off'
				name="strDrugName" maxlength="100" class="txtFldMax" onkeyup="lTrim(this);"
				onkeypress="return validateDataWithSpecialChars(event,18,'%.:;+-/*,');" /></td>
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
		<td width="25%" colspan="1"  class="LABEL"><font color="red">*</font>Administration Route</td>			
			<td width="25%" class="CONTROLCIMS">
			   	<html:select property="strAdminRoute" name="cimsgenericdrugBean" styleClass="comboNormalCIMS">
					<bean:write property="strAdminRoute" name="cimsgenericdrugBean"  filter="false"/>				
				</html:select>		
			</td>
			
			<td class="LABEL" colspan="1" width="25%">Special Precautions</td>
			<td class="CONTROLCIMS" width="25%">
				<textarea rows="2" cols="20" name="strsprecau" id="strsprecau" onkeyup="lTrim(this);"></textarea>
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
				<textarea rows="2" cols="20" name="stradvdrug" id="stradvdrug" onkeyup="lTrim(this);"></textarea>
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
				<textarea rows="2" cols="20" name="strmechact" id="strmechact" onkeyup="lTrim(this);"></textarea>
			</td>
			<td class="LABEL" colspan="1" width="25%">Laboratory Interferance</td>
			<td class="CONTROLCIMS" width="25%">
				<textarea rows="2" cols="20" name="strlabintfrnce" id="strlabintfrnce" onkeyup="lTrim(this);"></textarea>
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
				<textarea rows="2" cols="20" name="strdosageadult" id="strdosageadult" onkeyup="lTrim(this);"></textarea>
			</td>
			<td class="LABEL" colspan="1" width="25%">Dosage(Peads)</td>
			<td class="CONTROLCIMS" width="25%">
				<textarea rows="2" cols="20" name="strdosagepeads" id="strdosagepeads" onkeyup="lTrim(this);"></textarea>
			</td>
		</tr>	
		<tr>
			<td class="LABEL" colspan="1" width="25%"><font color="red">*</font>Drug Inventory Unit</td>
			<td class="CONTROLCIMS" colspan="" width="25%"><select
				name="strStockMaintain">
				<bean:write name="cimsgenericdrugBean"
					property="strStockMaintainedValues" filter="false" />

			</select></td>
			<td class="LABEL" colspan="3" width="25%"></td>
		</tr>
		<tr>
			<td class="LABEL" colspan="1" width="25%"><font color="red">*</font>Shelf Life</td>
			<td class="CONTROLCIMS" colspan="" width="25%">
			<input type="text" autocomplete='off' value='365'	name="strShelfLife" maxlength="3" class="txtFldMin"	onkeypress="return validateData(event,5);" value="${cimsgenericdrugBean.strShelfLife}" /></td>
			<td class="LABEL" colspan="1" width="25%">Time Format</td>
			<td class="CONTROLCIMS" colspan="1" width="25%"><html:select
				property="strShelfTimeFormat">
				<html:option value="1"> Day</html:option>
				<html:option value="2"> Month</html:option>
				<html:option value="3">Year</html:option>
			</html:select></td>
		</tr>
		</table>
		
	


	<div class="popUpDiv" style="display: none; left: 110px; top: 201px;" id='itemDetails'>
	<table border="0" cellpadding="1" cellspacing="1" width="800">
			<tbody>
			<tr class="HEADER">
				<td colspan="3">Drug Details</td>	
				<th align="right">
				<img onkeypress="onPressingEnter(this,event)" tabindex="1" style="cursor: pointer; " src="../../hisglobal/images/popUp_cancel.JPG" 
					title="Click to Close Pop-Up" onclick="hide_popup('itemDetails');"></th>
			</tr>
		</tbody>
	</table>
		
    
    <table border="0" cellpadding="3" cellspacing="0" width="800">
        <tbody>
        <tr>
            <td colspan="3" class='monographbrandheadertext'>Spectinomycin
            </td>
        </tr>  
        <tr bgcolor="#D4D5D5">
            <td colspan="2" class="border-main" bgcolor="#999999" height="2"></td>
        </tr>
            <tr>
                <td class="tdoutline" bgcolor="#E9F1FA" valign="top" width="20%">
                <a class="aaanchor" name="Indications"></a>
                	<span class="normaltext" title="Approved therapeutic uses of the medicine and dosing regimen arranged logically by route of administration, age and disease, where appropriate">Indication &amp; Dosage</span>
                </td>
                <td class="tdoutline">
                <span class="normaltext"><i>Intramuscular</i><br><b>Gonorrhoea<br>
                <b><i>Adult: </i></b>2 g as a single dose. In cases whereby antibiotic resistance is prevalent, 4 g (10 mL) may be given but divided as two 5 mL inj, admin to 2 different inj sites.<br>
                <b><i>Child: </i></b>Beyond newborn period and &lt;45 kg: 40 mg/kg as a single dose. Max: 2 g.<br><br>
                <b><i>Reconstitution: </i></b>Add 3.2 mL of sterile water for inj to the vial containing 2 g to make a 400 mg/mL susp (as HCl). Shake the vial vigorously after adding the diluent and prior to withdrawing the dose.</b></span></td>
            </tr>
            <tr>
                <td class="tdoutline" bgcolor="#E9F1FA" valign="top" width="20%">
	                <a class="aanchor" name="Contraindications"></a>
	                <span class="normaltext" title="Pre-existing medical conditions or disorders that are contraindicated with use of the medicine">Contraindications</span>
	            </td>
                <td class="tdoutline">
                	<span class="normaltext">Hypersensitivity.</span>
                </td>
            </tr>
            <tr>
                <td class="tdoutline" bgcolor="#E9F1FA" valign="top" width="20%">
                <a class="aanchor" name="SpecialPrecautions"></a>
                	<span class="normaltext" title="Medical conditions or disorders that can have adverse effects with the use of the medicine">Special Precautions</span>
               	</td>
                <td class="tdoutline">
                	<span class="normaltext">Ineffective in the treatment of syphilis and may mask or delay symptoms of incubating syphilis. Pregnancy and lactation. <i>Monitoring Parameters</i> Perform serologic test for syphilis at the time of gonorrhoea diagnosis and 3 mth later.</span>
                </td>
            </tr>
            <tr>
                <td class="tdoutline" bgcolor="#E9F1FA" valign="top" width="20%">
                	<a class="aanchor" name="AdverseReactions"></a>
                		<span class="normaltext" title="Adverse drug reactions, from mild reactions to potentially life-threatening ones">Adverse Drug Reactions</span>
               	</td>
                <td class="tdoutline">
                	<span class="normaltext">Nausea, dizziness, fever and chills, insomnia, urticaria, mild to moderate pain after IM inj, alterations in kidney and liver function, decrease in Hb and haematocrit. Rarely, anaphylaxis or anaphylactiod reactions.</span>
                </td>
            </tr>
            <tr>
                <td class="tdoutline" bgcolor="#E9F1FA" valign="top" width="20%">
                	<a class="aanchor" name="Interactions"></a>
                	<span class="normaltext" title="Drug-to-drug interactions, ranging from clinically significant interactions to theoretical ones">Drug Interactions</span>
               	</td>
                <td class="tdoutline">
                	<span class="normaltext">May result in lithium toxicity when used concurrently. May increase or prolong the neuromuscular blocking effect of atracurium.<br></span>
                </td>
            </tr>
            <tr>
                <td class="tdoutline" bgcolor="#E9F1FA" valign="top" width="20%">
	                <a class="aanchor" name="PregnancyCategory"></a>
	                <span class="normaltext" title="Categorization of risk of drug use in pregnancy from the United States Food &amp; Drug Administration">Pregnancy Category</span>
                </td>
                <td class="tdoutline">
                        <table border="0" cellpadding="1" cellspacing="0">
                            <tbody><tr>
                                <td width="40px"><img src="/resources/drugs/common/persafe_chip01_n.gif" alt=""></td>
					            <td width="40px"><img src="/resources/drugs/common/persafe_chip02_a.gif" alt=""></td>
					            <td width="40px"><img src="/resources/drugs/common/persafe_chip03_n.gif" alt=""></td>
					            <td width="40px"><img src="/resources/drugs/common/persafe_chip04_n.gif" alt=""></td>
					            <td width="40px"><img src="/resources/drugs/common/persafe_chip05_n.gif" alt=""></td>
                                <td width="300px"></td>
                            </tr>
                            <tr>
                                <td></td>
					            <td align="center"><img src="/resources/drugs/common/persafe_indicdot001.gif" alt=""></td>
					            <td></td>
					            <td></td>
					            <td></td>
                                <td></td>
				            </tr>
                        </tbody></table>
                        <span class="normaltext">
                        	<b>Category B</b>: Either animal-reproduction studies have not demonstrated a foetal risk but there are no controlled studies in pregnant women or animal-reproduction studies have shown an adverse effect (other than a decrease in fertility) that was not confirmed in controlled studies in women in the 1<sup>st</sup> trimester (and there is no evidence of a risk in later trimesters).</span>
                </td>
            </tr>
            <tr>
                <td class="tdoutline" bgcolor="#E9F1FA" valign="top" width="20%">
                	<a class="aanchor" name="Storage"></a>
                		<span class="normaltext" title="Special storage condition(s) to ensure optimal shelf life of medicine">Storage</span>
                </td>
                <td class="tdoutline">
                	<span class="normaltext"><b>Intramuscular: </b>Store between 20-25°C. Reconstituted soln should be used w/in 24 hr after preparation.</span></td>
            </tr>
            <tr>
                <td class="tdoutline" bgcolor="#E9F1FA" valign="top" width="20%">
                	<a class="aanchor" name="Actions"></a>
                		<span class="normaltext" title="Pharmacodynamic and pharmacokinetic properties are featured">Mechanism of Action</span>
                </td>
                <td class="tdoutline">
                	<span class="normaltext">Spectinomycin binds to 30S subunit of the bacterial ribosome, thus inhibiting protein synthesis. It has modest activity against a wide range of gm+ve and gm-ve organisms, though anaerobic organisms are mostly resistant.<br>
                	<b>Absorption: </b>Rapidly absorbed after IM inj. Time to peak plasma concentration: 1 hr (2-g dose).<br>
                	<b>Distribution: </b>Poorly distributed into saliva. Not significantly bound to plasma proteins.<br>
                	<b>Excretion: </b>Via urine as active metabolites. Plasma half-life: Approx 1-3 hr.</span>
                </td>
            </tr>
            <tr>
                <td class="tdoutline" bgcolor="#E9F1FA" valign="top" width="20%">
                    <a class="aanchor" name="MIMSClass"></a>
                    <span class="normaltext" title="Pharmacological classification system used in CIMS reference system">CIMS Class</span>
                </td>
                <td class="tdoutline">
                    <span class="normaltext">
                                <a href="/India/drug/search?q=Other%20Antibiotics">Other Antibiotics</a>
                    </span>
                </td>
            </tr>
            <tr>
                <td class="tdoutline" bgcolor="#E9F1FA" valign="top" width="20%">
                	<a class="aanchor" name="ATC"></a>
                		<span class="normaltext" title="Anatomical Therapeutic and Chemical Classification System introduced by World Health Organisation">ATC Classification</span>
                	</td>
                <td class="tdoutline">
                    <span class="normaltext">
                            <span>J01XX04 -</span>spectinomycin<span>;</span>
                    </span>
                </td>
            </tr>
        	<tr><td></td></tr>
        	<tr class="FOOTER">
				<td colspan="4"></td>				
			</tr>
    </tbody></table>
</div>

<table cellspacing="1px" cellpadding="1px" class="TABLEWIDTH"
		align="center">
		<tr class="FOOTER" >
			<td colspan="4" width="25%" align="left"><font size="2" color="red">*</font>
			Mandatory Fields</td>
		</tr>
	</table>
	<table class="TABLEWIDTH" align="center" cellspacing="1px"
		cellpadding="1px">

		<tr>

			<td align="center" colspan="2" width="25%"><!-- <img
				src="../../hisglobal/images/btn-sv.png" title="Save Record"
				onClick="validate1();" style="cursor: pointer; " /> <%--
			** Inactivated on 28th May, 2010 by Aritra
			** Reason: Not functioning properly if Exception occured. 
			<img src="../../hisglobal/images/btn-clr.png"
				onClick="document.forms[0].reset();" style="cursor: pointer; " title="Clear Content"/>
			--%> <%--
			** Added on 28th May, 2010 by Aritra
			** Reason: To clear content even if Exception occured.  
			--%> <img src="../../hisglobal/images/btn-clr.png"
				onClick="clearScreen();" style="cursor: pointer; "
				title="Clear Content" /> <img
				src="../../hisglobal/images/btn-ccl.png"
				onClick="cancel('LIST');" style="cursor: pointer; "
				title="Cancel Process"> -->
				
				<br>					 
				<a href="#" class="button" id="" onclick='validate1();'><span class="save">Save</span></a>
				<a href="#" class="button"	onclick="clearScreen()"><span class="clear">Clear</span></a> 
				<a href="#" class="button" onclick="cancel('LIST');"><span class="cancel">Cancel</span></a>
				
				</td>
		</tr>
	</table>
	
	
	<a tabindex="1" style="color:blue;cursor: pointer;display:none;" onclick="popup('itemDetails','10','250')">CIMS DIV</a>

	<input type="hidden" name="hmode" />
	<input type="hidden" value="${cimsgenericdrugBean.strCurrentDate}" name="strCurrentDate" />
	<input type="hidden" value="${cimsgenericdrugBean.strGroupId}" name="strGroupId" />
	<input type="hidden" value="${cimsgenericdrugBean.strSubGroupId}" name="strSubGroupId" />		
	<input type="hidden" value="${cimsgenericdrugBean.strIsItemCodeRequired}" name="strIsItemCodeRequired" />
	<input type="hidden" value="${cimsgenericdrugBean.strContradictoryDrugArray}" name="strContradictoryDrugArray" />
	<input type="hidden" value="${cimsgenericdrugBean.strContradictoryDrugIdArray}" name="strContradictoryDrugIdArray" />
	<input type="hidden" value="${cimsgenericdrugBean.comboValue}" name="comboValue" />
		
	<cmbPers:cmbPers />

</html:form>
<tag:autoIndex></tag:autoIndex>
</body>
</html>