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
<meta charset=utf-8>
<title>Process Component Master Add Page</title>

<link href="../css/master.css" rel="stylesheet" type="text/css">
<link href="../../hisglobal/css/tab.css" rel="stylesheet" type="text/css">
<link href="../../hisglobal/css/calendar-tas.css" rel="stylesheet" type="text/css">

<script language="JavaScript" src="../../hisglobal/masterutil/js/master.js"></script>
<script language="JavaScript" src="../../hisglobal/js/tab.js"></script>
<script language="JavaScript" src="../../hisglobal/js/calendar.js"></script>
<script language="Javascript" src="../../hisglobal/js/validation.js"></script>
<script language ="javaScript">

function validate1(){   
     
             var hisValidator = new HISValidator("processcomponentBean");
           
             hisValidator.addValidation("strProcessName", "dontselect=0","Please select Process Name" );
             hisValidator.addValidation("strComponentName", "dontselect=0","Please select Component Name" );
             hisValidator.addValidation("strComponentValue1", "req", "Component Value 1 is a Mandatory Field" );
             hisValidator.addValidation("strComponentValue1", "maxlen=4000", "Component Value 1 should have less than or equal to 4000 Characters" );
             hisValidator.addValidation("strComponentValue2", "maxlen=4000", "Component Value 2 should have less than or equal to 4000 Characters" );
           	hisValidator.addValidation("strRemarks", "maxlen=100", "Remarks should have less than or equal to 100 Characters" );
            hisValidator.addValidation("strEffectiveFrom", "date","Effective Date is a mandatory field");
		 	hisValidator.addValidation("strEffectiveFrom", "req", "Effective from is a Mandatory Field" ); 
		 	hisValidator.addValidation("strEffectiveFrom", "dtgtet=${processcomponentBean.strCtDate}" , "Effective From should be Greater than or Equal to Current Date");
		 	
            var retVal = hisValidator.validate(); 
          if(retVal){
                 	   document.forms[0].hmode.value = "SAVE";
                      document.forms[0].submit();
          }else{
             return false;
          }
}

</script>
</head>

<body onLoad="document.forms[0].strStoreTypeName.focus()">
<html:form name="processcomponentBean" action="/masters/ProcessComponentMstCNT" type="mms.masters.controller.fb.ProcessComponentMstFB">
 	
 	<div class="errMsg"><bean:write name="processcomponentBean" property="strErr"/></div>
	<div class="warningMsg"><bean:write name="processcomponentBean" property="strWarning"/></div>
	<div id="normalMsg" class="normalMsg"><bean:write name="processcomponentBean" property="strMsg"/></div>
 <tag:tab tabLabel="Process Component Master"
				selectedTab="FIRST" align="center" width="TABLEWIDTH">
			</tag:tab>
	<table class="TABLEWIDTH" align="center" cellpadding="1px" cellspacing="1px">
  <tr class="HEADER"> 
    <td colspan="2">Process Component Master&gt;&gt;Add</td>
  </tr> 
  <tr >
      <td class="LABEL">Process Name</td>
      <td width="50%" class ="CONTROL"> 
       <bean:write name="processcomponentBean" property="strProcessName" filter="false"/>
       </td>
    </tr>   
    <tr >
      <td class="LABEL"><font color="red">*</font>Component Name</td>
      <td width="50%" class ="CONTROL"> <html:select name="processcomponentBean" property="strComponentName"  >
       <bean:write name="processcomponentBean" property="strComponentNameValues" filter="false"/>
       </html:select>
      </td>
    </tr>   
   <tr>
  		<td class="LABEL"><font color="red">*</font>Component Value 1</td>
  		<td class="CONTROL">
	  <div align="left">
        <textarea name="strComponentValue1" rows="2"></textarea>
      </div></td>
   </tr>
       <tr>
  		<td class="LABEL">Component Value 2</td>
  		<td class="CONTROL">
	  <div align="left">
        <textarea name="strComponentValue2" rows="2"></textarea>
      </div></td>
   </tr>
    <tr >
    <td class ="LABEL" width ="50%"><font color="red">*</font>Effective From</td>
    <td class ="CONTROL"><dateTag:date name="strEffectiveFrom" value ="${processcomponentBean.strCtDate}"></dateTag:date></td>
    </tr>
    
    <tr>
      <td class="LABEL"><div align="right">Remarks</div></td>
      <td class="CONTROL">
	  <div align="left">
        <textarea name="strRemarks" rows="2"></textarea>
      </div></td>
      </tr>
    
    
   
   <tr class="FOOTER"> 
    <td colspan="2" ><font size="2" color="red">*</font> Mandatory Fields  </td>
  </tr>
</table>
	 
	    <table CLASS ="TABLEWIDTH" align="center" cellpadding="1px" cellspacing="1px">
	      <tr> 
		<td align="center">
			<img
				src="../../hisglobal/images/btn-sv.png" style="cursor:pointer;cursor:pointer;" title="Save Record" onClick=" return validate1();" />
			<img src="../../hisglobal/images/btn-clr.png" style="cursor:pointer;cursor:pointer;" title="Reset Content"
				onClick="document.forms[0].reset(),document.forms[0].strStoreTypeName.focus();" />
				<img src="../../hisglobal/images/btn-ccl.png" style="cursor:pointer;cursor:pointer;" title="Cancel Process"
				onClick="cancel('LIST');" />
			</td>
	      </tr>
	    </table>
	    <input type="hidden" name="hmode"/>
	    <input type="hidden" name="strProcessNameId" value="${processcomponentBean.strProcessNameId}">
	     <input type="hidden" name="strProcessNameHidden" value="${processcomponentBean.strProcessName}">
	      <input type="hidden" name="strCtDate" value="${processcomponentBean.strCtDate}">
	       <input type="hidden" name="comboValue" value="${processcomponentBean.comboValue}">     
	<cmbPers:cmbPers/>
</html:form>
<tag:autoIndex></tag:autoIndex>
</body>
</html>	