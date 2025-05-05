<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" 
"http://www.w3.org/TR/html4/loose.dtd">

<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<%@taglib uri="/WEB-INF/dateTag.tld" prefix="dateTag"%>
<%@ taglib uri="/WEB-INF/hisTab.tld" prefix="tag"%>
<%@ taglib uri="/WEB-INF/comboPersistence.tld" prefix="cmbPers" %>
		
<html>
<head>
<meta charset="utf-8">
<title>PO Componet Master Modify Page</title>

<link href="../css/master.css" rel="stylesheet" type="text/css">
<link href="../../hisglobal/css/tab.css" rel="stylesheet" type="text/css">
<link href="../../hisglobal/css/calendar-tas.css" rel="stylesheet" type="text/css">
<link href="../../hisglobal/css/buttons.css" rel="stylesheet" type="text/css">
<script language="JavaScript" src="../../hisglobal/masterutil/js/master.js"></script>
<script language="JavaScript" src="../../hisglobal/js/tab.js"></script>
<script language="JavaScript" src="../../hisglobal/js/calendar.js"></script>
<script language="Javascript" src="../../hisglobal/js/validation.js"></script>
<script language ="javaScript">

function validate1(){   
     
             var hisValidator = new HISValidator("pocomponentBean");
           
            // hisValidator.addValidation("strProcessName", "dontselect=0","Please select Process Name" );
            // hisValidator.addValidation("strComponentName", "dontselect=0","Please select Component Name" );
             hisValidator.addValidation("strComponentValue1", "req", "Component Value 1 is a Mandatory Field" );
               hisValidator.addValidation("strParameterId", "dontselect=0", "Parameter Name is a Mandatory Field" );
             hisValidator.addValidation("strComponentValue1", "maxlen=4000", "Component Value 1 should have less than or equal to 4000 Characters" );
             hisValidator.addValidation("strComponentValue2", "maxlen=4000", "Component Value 2 should have less than or equal to 4000 Characters" );
           	hisValidator.addValidation("strRemarks", "maxlen=100", "Remarks should have less than or equal to 100 Characters" );
            hisValidator.addValidation("strEffectiveFrom", "date","Effective Date is a mandatory field");
		 	hisValidator.addValidation("strEffectiveFrom", "req", "Effective from is a Mandatory Field" );  
            var retVal = hisValidator.validate(); 
          if(retVal){
                 	   
                 	   document.forms[0].hmode.value = "UPDATE";
                      document.forms[0].submit();
          }else{
             return false;
          }
}


function addParameterNameToComp1()
{
	if(document.forms[0].strParameterId.value!='0')
	{
		document.forms[0].strComponentValue1.value =	document.forms[0].strComponentValue1.value + "##"+ document.forms[0].strParameterId.value + "##" ;
	}
	else
	{
		alert("Select the Parameter Name to be added to the Component Value 1");
	}
	
}

function addParameterNameToComp2()
{
	if(document.forms[0].strParameterId.value!='0')
	{
		document.forms[0].strComponentValue2.value =	document.forms[0].strComponentValue2.value + "##"+ document.forms[0].strParameterId.value + "##" ;
	}
	else
	{
		alert("Select the Parameter Name to be added to the Component Value 2");
	}
}

</script>
</head>

<body onLoad="document.forms[0].strComponentValue1.focus()">
<html:form name="pocomponentBean" action="/masters/POComponentMstCNT" type="mms.masters.controller.fb.POComponentMstFB">
 	
 	<div class="errMsg"><bean:write name="pocomponentBean" property="strErr"/></div>
	<div class="warningMsg"><bean:write name="pocomponentBean" property="strWarning"/></div>
	<div id="normalMsg" class="normalMsg"><bean:write name="pocomponentBean" property="strMsg"/></div>
 <tag:tab tabLabel="PO Component Master"
				selectedTab="FIRST" align="center" width="TABLEWIDTH">
			</tag:tab>
	<table class="TABLEWIDTH" align="center" cellpadding="1px" cellspacing="1px">
  <tr class="HEADER"> 
    <td colspan="2">PO Component Master&gt;&gt;Modify</td>
  </tr> 
  <tr >
      <td class="LABEL">Component Type</td>
      <td width="50%" class ="CONTROL"> 
       <bean:write name="pocomponentBean" property="strPOTypeName" filter="false"/>
       </td>
    </tr>   
    <tr >
      <td class="LABEL">Component Name</td>
      <td width="50%" class ="CONTROL"> 
       <bean:write name="pocomponentBean" property="strComponentNameModify" filter="false"/>
       
      </td>
    </tr>   
    
    <%-- Change Request --%>

	<tr >
      <td class="LABEL"><font color="red">*</font>Parameter Name</td>
      <td width="50%" class ="CONTROL">
      	<html:select name="pocomponentBean" property="strParameterId" value='${pocomponentBean.strParameterId}'>
      			<html:option value="0">Select Value</html:option>
				<html:option value="CONTRACT_VALUE">Contract Value</html:option>
				<html:option value="CONTRACT_AMOUNT">Contract Amount</html:option>
				<html:option value="DELIVERY_PERIOD">Delivery Period</html:option>
				<html:option value="PO_AMOUNT">PO Amount</html:option>
				<html:option value="STAMP_PAPER_AMT">Stamp Paper Amount</html:option>
		</html:select>
      </td>
    </tr> 
    
<%-- Change Request --%>
    
   <tr>
  		<td class="LABEL"><font color="red">*</font>Component Value 1</td>
  		<td class="CONTROL">
	  <div align="left">
        <textarea name="strComponentValue1" rows="4" cols="40"><bean:write name="pocomponentBean" property="strComponentValue1" filter="false"/></textarea>
       <!-- <img src="../../hisglobal/images/add_parameter.png" style="cursor:pointer;cursor:pointer;" title="Add Parameter Name To Component Value 1" onClick="addParameterNameToComp1();" /> -->
 		 <a href="#" class="button" id="" onclick='addParameterNameToComp1();'><span class="add">Add</span></a>
      </div></td>
   </tr>
       <tr>
  		<td class="LABEL">Component Value 2</td>
  		<td class="CONTROL">
	  <div align="left">
        <textarea name="strComponentValue2" rows="4" cols="40"><bean:write name="pocomponentBean" property="strComponentValue2" filter="false"/></textarea>
      <!--    <img src="../../hisglobal/images/add_parameter.png" style="cursor:pointer;cursor:pointer;" title="Add Parameter Name To Component Value 2" onClick="addParameterNameToComp2();" /> -->
      	<a href="#" class="button" id="" onclick='addParameterNameToComp2();'><span class="add">Add</span></a>
      </div></td>
   </tr>
    <tr >
    <td class ="LABEL" width ="50%"><font color="red">*</font>Effective From</td>
    <td class ="CONTROL"><bean:write name="pocomponentBean" property="strEffectiveFrom"></bean:write></td>
    </tr>
    
    <tr>
      <td class="LABEL"><div align="right">Remarks</div></td>
      <td class="CONTROL">
	  <div align="left">
        <textarea name="strRemarks" rows="2"><bean:write name="pocomponentBean" property="strRemarks" filter="false"/></textarea>
      </div></td>
      </tr>
    <tr >
    <td width ="45%" class ="LABEL">Record Status </td>
    <td width ="45%" class ="CONTROL" >
   <html:radio name="pocomponentBean" property="strIsValid" value="1">Active</html:radio>
    <html:radio name="pocomponentBean" property="strIsValid" value="2">Inactive</html:radio>
    
   </td>
    </tr>
    
   
   <tr class="FOOTER"> 
    <td colspan="2" ><font size="2" color="red">*</font> Mandatory Fields  </td>
  </tr>
</table>
	 
	    <table CLASS ="TABLEWIDTH" align="center" cellpadding="1px" cellspacing="1px">
	      <tr> 
		<td align="center">
			
			<!-- <img
				src="../../hisglobal/images/btn-sv.png" title="Save Record" style="cursor:pointer;cursor:pointer;" title="Save Record" onClick=" return validate1();" />
			
				<img src="../../hisglobal/images/btn-ccl.png" style="cursor:pointer;cursor:pointer;" title="Cancel Process"
				title="Cancel Process" onClick="cancel('LIST');" /> -->
				<br>
					<a href="#" class="button" id="" onclick=' return validate1();'><span class="save">Save</span></a>
					<a href="#" class="button" onclick="cancel('LIST');"><span class="cancel">Cancel</span></a>
			</td>
	      </tr>
	    </table>
	    <input type="hidden" name="hmode" />
	    <input type="hidden" name="strProcessNameId" value="${pocomponentBean.strIndentTypeId}">
		<input type="hidden" name="strChk" value="${pocomponentBean.strChk}">
		<input type="hidden" name="strComponentName" value="${pocomponentBean.strComponentName}">
		<input type="hidden" name="strEffectiveFrom" value ="${pocomponentBean.strEffectiveFrom}">

<cmbPers:cmbPers/>
</html:form>
<tag:autoIndex></tag:autoIndex>
</body>
</html>	