<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
        <%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
		<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
		<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
		<%@taglib uri="/WEB-INF/dateTag.tld" prefix="date"%>
	    <%@taglib uri="/WEB-INF/hisTab.tld" prefix="tag"%>
	    <%@ taglib uri="/WEB-INF/comboPersistence.tld" prefix="cmbPers"%>
		
<html>
<head>
<meta charset="utf-8">
<title>Unit Value Master Modify Page</title>
<link href="../css/master.css" rel="stylesheet" type="text/css">
<link href="../../hisglobal/css/tab.css" rel="stylesheet" type="text/css">
<link href="../../hisglobal/css/calendar-tas.css" rel="stylesheet" type="text/css">
<script language="JavaScript" src="../../hisglobal/js/tab.js"></script>
<script language="JavaScript" src="../../hisglobal/js/calendar.js"></script>
<script language="Javascript" src="../../hisglobal/js/datepicker1.js"></script>
<script language="JavaScript" src="../../hisglobal/masterutil/js/master.js"></script>
<script language="Javascript" src="../../hisglobal/js/validation.js"></script>
<script language ="javaScript">





function validate1(){   
   
      var hisValidator = new HISValidator("unitvalueBean");
            // alert("Objec :"+hisValidator);  
          
            hisValidator.addValidation("convertedValue", "req", "Converted Value is a Mandatory Field" );
            hisValidator.addValidation("convertedValue", "amount=9,3", "Converted Value should be less than 10000 and decimal digits can be upto 3,eg: 0000000.000" );
            hisValidator.addValidation("convertedValue", "num", "Converted Value is a numeric Field" );
            hisValidator.addValidation("effectiveFrom", "req","Effective Date is a Mandatory Field");
            
                     
            var retVal = hisValidator.validate(); 
       //  alert(retVal);
          if(retVal){
                       document.forms[0].hmode.value = "UPDATE"  ;
         // alert("inside if");
                        document.forms[0].submit();
            }else{

           return false;

          }
    }


</script>
<style type="text/css">
<!--
.style1 {color: #FF0000}
-->
</style>
</head>
<body >
<html:form name="unitvalueBean" action="/masters/CNTUnitValueMst" type="mms.masters.vo.VOUnitValueMst">
<div class="errMsg"><bean:write name="unitvalueBean" property="strErrorMsg"/></div>
<div class="normalMsg" id='normalMsg'><bean:write name="unitvalueBean" property="strMsg"/></div>
<div class="warningMsg"><bean:write name="unitvalueBean" property="strWarning"/></div>

<tag:tab tabLabel="Modify Unit Value" selectedTab="FIRST" align ="center" width ="TABLEWIDTH"> </tag:tab>
<table CLASS ="TABLEWIDTH" align ="center" cellpadding="1px" cellspacing="1px">
   <tr class="HEADER"> 
    <td colspan="2">Unit Value Master&gt;&gt;Modify</td>
  </tr>              
   <tr>
    <td class="LABEL"><font color="red">*</font>Module  Name</td>
    <td width="50%" class ="CONTROL"><input type="text" name="moduleName" value ="${unitvalueBean.moduleName}" readonly></td>
  </tr>
  <tr>
    <td class="LABEL"><font color="red">*</font>From Unit</td>
    <td width="50%" class ="CONTROL"><input type="text" name="fromUnit" value ="${unitvalueBean.fromUnit}" readonly> </td>
  </tr>
  <tr >
    <td class="LABEL"><font color="red">*</font>To Unit</td>
    <td width="50%" class ="CONTROL"><input type="text" name="toUnit" value ="${unitvalueBean.toUnit}" readonly>  </td>
	
  </tr>
   <tr >
    <td class="LABEL"><font color="red">*</font>Converted Value </td>
    <td width="50%" class ="CONTROL"><input type="text" name="convertedValue" value ="${unitvalueBean.convertedValue}" maxlength="10" onKeypress ='return validateData(event,7);'> </td>
	
  </tr>
  
   <tr >
    
   
  <td class ="LABEL" width ="50%">Effective From</td>
  <td class ="CONTROL"><bean:write name="unitvalueBean" property="effectiveFrom" /></td>
   </tr>
  
  
  <tr >
    <td width ="50%" class ="LABEL"valign="top">Remarks if Any </td>
    <td width ="50%" class ="CONTROL"><textarea name="remark" cols="20" rows="2"
				id="remarks"><bean:write name="unitvalueBean" property="remark"/></textarea> </td>
  </tr>
   
    <tr >
    <td width ="45%" class ="LABEL"><font color="red">*</font>Record Status</td>
    <td width ="45%" class ="CONTROL" >
    <html:radio name="unitvalueBean" property="isValid" value="1" />Active
    <html:radio name="unitvalueBean" property="isValid" value="2" />Inactive
    </td>
    </tr>
    
  <tr class="FOOTER"> 
    <td colspan="2" ><font size="2" color="red">*</font> Mandatory Fields  </td>
  </tr>
</table>
	 
	    <table CLASS ="TABLEWIDTH" align="center">
	      <tr> 
		<td align="center">
		<img src="../../hisglobal/images/btn-sv.png" title="Save Record" style="cursor:pointer;cursor:hand;" title="Save Record" onClick="return validate1();"/> 
		<img src="../../hisglobal/images/btn-ccl.png" title="Cancel Process" style="cursor:pointer;cursor:hand;"  title="Cancel the Process" onClick="cancel('LIST');"/>
	  </td>
	   </tr>
	    </table>
	    
	   	<input type="hidden" name="hmode">
	 	<input type="hidden" name="chk" value="${unitvalueBean.chk[0]}">
	 	<input type="hidden" name="effectiveFrom" value ="${unitvalueBean.effectiveFrom}"/>
	 	<cmbPers:cmbPers/>
</html:form>
<tag:autoIndex></tag:autoIndex>
</body>
</html>	
			
			