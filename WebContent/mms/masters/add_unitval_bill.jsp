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
<meta charset=utf-8>
<title>Unit Value Master Add Page</title>
<link href="../css/master.css" rel="stylesheet" type="text/css">
<link href="../../hisglobal/css/tab.css" rel="stylesheet" type="text/css">
<link href="../../hisglobal/css/calendar-tas.css" rel="stylesheet" type="text/css">
<script language="JavaScript" src="../../hisglobal/masterutil/js/master.js"></script>
<script language="JavaScript" src="../../hisglobal/js/tab.js"></script>
<script language="JavaScript" src="../../hisglobal/js/calendar.js"></script>
<script language="Javascript" src="../../hisglobal/js/datepicker1.js"></script>
<script language="Javascript" src="../../hisglobal/js/util.js"></script>
<script language="Javascript" src="../../hisglobal/js/validation.js"></script>
<script language ="javaScript">

function validate1(){   
    // alert("inside validate1");
      var hisValidator = new HISValidator("unitvalueBean");
            //alert("Objec :"+hisValidator);  
            hisValidator.addValidation("moduleName","dontselect=0","Please select a value from Module Combo");
            hisValidator.addValidation("fromUnit","dontselect=0","Please select a value from From Unit Combo");
            hisValidator.addValidation("toUnit","dontselect=0","Please select a value from To Unit Combo");
            hisValidator.addValidation("convertedValue", "req", "Converted Value is a Mandatory Field" );
            hisValidator.addValidation("convertedValue", "amount=9,3", "Converted Value should be less than 10000 and decimal digits can be upto 3 ,eg: 000000.000" );
            hisValidator.addValidation("effectiveFrom", "req","Effective Date is a Mandatory Field");
            hisValidator.addValidation("effectiveFrom", "date","Effective Date should be a valid Date");
            hisValidator.addValidation("effectiveFrom", "dtgtet=${unitvalueBean.strCtDate}" , "Effective From should be Greater than or Equal to Current Date");        
            hisValidator.addValidation("remark", "maxlen=50", "Remarks should have less than or equal to 50 Characters" );
            var retVal = hisValidator.validate(); 
     //    alert(retVal);
          if(retVal){
                       document.forms[0].hmode.value = "SAVE";
         //alert("inside if");
                        document.forms[0].submit();
            }else{

           return false;

          }
    }
/*function submitSave(mode)
{
document.forms[0].hmode.value=mode;
document.forms[0].submit();
}*/

function combo1(mode)
 { 
	 var url;
	 if(mode=="FROMUNITVAL")
	 {
	  url="CNTUnitValueMst.cnt?hmode="+mode+"&modName="+document.forms[0].moduleName.value;
	  ajaxFunction(url,"1");
	 }
	else
	if(mode=="TOUNITVAL")
	{
	 var frmUnitId = document.forms[0].fromUnit.value.split("#")[1]; 
	 url="CNTUnitValueMst.cnt?hmode="+mode+"&modName="+document.forms[0].moduleName.value+"&fromunit="+frmUnitId;
	 ajaxFunction(url,"2");
	}
  }
  function getAjaxResponse(res,mode)
  {
	if(mode=="1")
	{   
	var objVal= document.getElementById("fromUnitId");
	objVal.innerHTML = "<select name ='fromUnit' onChange ='combo1(\"TOUNITVAL\");'>" + res + "</select>";
	}
	else if(mode=="2")
	{
	var objVal = document.getElementById("toUnitId");
	objVal.innerHTML = "<select name='toUnit'>" + res + "</select>";
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
<div class="warningMsg"><bean:write name="unitvalueBean" property="strWarning"/></div>
<div class="normalMsg" id='normalMsg'><bean:write name="unitvalueBean" property="strMsg"/></div>



<tag:tab tabLabel="Add Unit Value" selectedTab="FIRST" align ="center" width ="TABLEWIDTH"> </tag:tab>
<table CLASS ="TABLEWIDTH" align ="center" cellpadding="1px" cellspacing="1px">
   <tr class="HEADER"> 
    <td colspan="2">Unit Value Master&gt;&gt;Add</td>
  </tr>               
   <tr>
    <td class="LABEL"><span class="style1">*</span>Module Name </td>
    <td width="50%" class ="CONTROL">
    <select name ="moduleName" class="comboNormal" onChange="combo1('FROMUNITVAL');">
	<bean:write name="unitvalueBean" property="strCmbval" filter="false"/>
	</select></td>
  </tr>
 
  <tr>
    <td class="LABEL"><span class="style1">*</span>From Unit </td>
    <td width="50%" class ="CONTROL"><div id ="fromUnitId"><select name ="fromUnit" class="comboNormal" ><option value="0">Select Value</option></select> </div>
    </td>
  </tr>
   <tr >
    <td class="LABEL"><span class="style1">*</span>To Unit </td>
    <td width="50%" class ="CONTROL"><div id ="toUnitId">
      <select name ="toUnit" class="comboNormal">
        <option value ="0">Select Value</option>
      </select>
    </div></td>
  </tr>
   <tr >
    <td class="LABEL"><span class="style1">*</span>Converted Value </td>
    <td width="50%" class ="CONTROL"><input type="text" class="txtFldMax" name="convertedValue" value ="" maxlength="10" onKeypress ='return validateData(event,7);'> </td>
  </tr>
  <tr >
    <td class ="LABEL" width ="50%"><div align="right"><span class="style1">*</span> Effective From</div></td>
    <td class ="CONTROL"><date:date name="effectiveFrom" value ="${unitvalueBean.strCtDate}"> </date:date></td>
  </tr>
  <tr >
    <td width ="50%" class ="LABEL"valign="top">Remarks if Any </td>
    <td width ="50%" class ="CONTROL"><textarea  name="remark" ></textarea></td>
  </tr>
    <tr class="FOOTER"> 
    <td colspan="2" ><font size="2" color="red">*</font> Mandatory Fields  </td>
   </tr>
</table>
	 
	    <table CLASS ="TABLEWIDTH" align="center">
	      <tr> 
	<td align="center">
		<img style="cursor:pointer;cursor:hand" src="../../hisglobal/images/btn-sv.png" title="Save Record" onClick=" return validate1(); "/>
		<img style="cursor:pointer;cursor:hand"  src="../../hisglobal/images/btn-clr.png" title="Reset Content" onClick="document.forms[0].reset(),document.forms[0].moduleName.focus();" />
		<img style="cursor:pointer;cursor:hand" src="../../hisglobal/images/btn-ccl.png" title="Cancel Process" onClick ="cancel('LIST');"/>
	    </td>
	      </tr>
	    </table>
	    
	   	<input type="hidden" name="hmode">
	   	<input type="hidden" name="StrHospitalCode" value =""/>
	   	<input type="hidden" name="StrModuleId" value =""/>
	   	<cmbPers:cmbPers/>

</html:form>
<tag:autoIndex></tag:autoIndex>
</body>
</html>	
			
			