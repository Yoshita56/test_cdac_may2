<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<%@ taglib uri="/WEB-INF/hisTab.tld" prefix="tag"%>
<%@taglib uri="/WEB-INF/dateTag.tld" prefix="date"%>
<%@ taglib uri="/WEB-INF/comboPersistence.tld" prefix="cmbPers" %>

<html>
<head>
<meta charset=utf-8>
<title>Process Letter Type Master</title>
<link href="../css/master.css" rel="stylesheet" type="text/css">
<link href="../../hisglobal/css/tab.css" rel="stylesheet" type="text/css">
<link href="../../hisglobal/css/calendar-tas.css" rel="stylesheet" type="text/css">
<link href="../../hisglobal/css/popup.css" rel="stylesheet" type="text/css">	
	
<script language="JavaScript" src="../../hisglobal/masterutil/js/master.js"></script>
<script language="JavaScript" src="../../hisglobal/js/tab.js"></script>
<script language="JavaScript" src="../../hisglobal/js/calendar.js"></script>
<script language="Javascript" src="../../hisglobal/js/datepicker1.js"></script>
<script language="Javascript" src="../../hisglobal/js/validation.js"></script>
<script language="Javascript" src="../../hisglobal/js/util.js"></script>
<script language ="javaScript">

function validate1(){   
     
            var hisValidator = new HISValidator("ProcessLetterTypeMstBean");
            hisValidator.addValidation("strStoreTypeName", "dontselect=0", "Please select a value from Store Type" );
            hisValidator.addValidation("strRightLetterName", "dontselect=0","Please move atleast one Letter Name from left to right \n And select only those Letter Name which are to be added from right list");
           // hisValidator.addValidation("strLetterTypeName", "req", "Letter Type Name should not available" );
            hisValidator.addValidation("strRemarks", "maxlen=100", "Remarks should have less than or equal to 100 Characters" );
            hisValidator.addValidation("strEffectiveFrom", "date","Effective Date is a mandatory field");
		    //hisValidator.addValidation("strEffectiveFrom", "dtgtet=${ProcessLetterTypeMstBean.strCtDate}" , "Effective Date should be Greater than or Equal to Current Date");
            var retVal = hisValidator.validate(); 

          if(retVal){
                       selectListRecords("strRightLetterName");
                       document.forms[0].hmode.value = "SAVE";
                       document.forms[0].submit();
          }else{
             return false;
          }
}

function ajaxFunLeftList()

{ 
   var mode ="LEFTLETTERNAME";
   var url="ProcessLetterTypeMstCNT.cnt?hmode=LEFTLETTERNAME&storeName="+document.forms[0].strStoreTypeName.value;
   ajaxFunction(url,"1");
}
function ajaxFunRightBed()
{ 
  var mode ="RIGHTLETTERNAME";
  var url="ProcessLetterTypeMstCNT.cnt?hmode=RIGHTLETTERNAME&processName="+document.forms[0].strProcessId.value;
  ajaxFunction(url,"2");
}

function getAjaxResponse(res,mode){
			
				 if(mode=="1")
				 {
				   	var obj1 = document.getElementById("LeftLetterId");
			        obj1.innerHTML = "<select name='strLeftLetterName' size='8' multiple style='width: 280px'>" + res + "</select>";
			 	    ajaxFunRightBed();
			 	    
				}
				else if(mode=="2"){
				
					var obj2= document.getElementById("RightLetterId");
					obj2.innerHTML = "<select name='strRightLetterName' size='8' multiple style='width: 280px'> " + res + " </select>";
					}
}

function LeftListTransfer()
{
	var ob1=document.forms[0].strLeftLetterName.value;
	var ob=document.getElementById("LeftLetterId");
	shiftToRight("strLeftLetterName","strRightLetterName",1);
}

function clearList(list_name)

{
listobj = document.getElementsByName(list_name);
    if(listobj.length > 0){
           listobj[0].length = 0;
		 }
}




</script>
</head>
<body onLoad="document.forms[0].strStoreTypeName.focus()">
<html:form name="ProcessLetterTypeMstBean" action="/masters/ProcessLetterTypeMstCNT" type="mms.masters.controller.fb.ProcessLetterTypeMstFB">
 	
 	<div id="errId" class="errMsg"><bean:write name="ProcessLetterTypeMstBean" property="strErrorMsg"/></div>
	<div id="normalMsg" class="normalMsg"><bean:write name="ProcessLetterTypeMstBean" property="strMsg"/></div>
	<div id="warningId" class="warningMsg"><bean:write name="ProcessLetterTypeMstBean" property="strWarning"/></div>
	

	<tag:tab tabLabel="Process Letter Type Master" selectedTab="FIRST" align="center" width="TABLEWIDTH">               
               </tag:tab>
	
	<table class="TABLEWIDTH" align="center" cellpadding="1px"
         cellspacing="1px">   
	<tr class="HEADER">
			<td colspan="8">Process Letter Type Master&gt;&gt; Add</td>
		</tr>
		
		<tr>
			<td colspan="4" width="50%" class="LABEL">Process Name</td>
			<td colspan="4" width="50%" class="CONTROL">
			<bean:write name="ProcessLetterTypeMstBean" property="strProcessName" filter="false"/>
		</tr>
		
		<tr>
			<td colspan="4" width="50%" class="LABEL">
			<font color="red">*</font>Store Type Name
			</td>
			<td colspan="4" width="50%" class="CONTROL"><select name="strStoreTypeName" class='comboNormal' onchange="ajaxFunLeftList();">
  <bean:write name="ProcessLetterTypeMstBean" property="strStoreTypeCombo" filter="false"/>
   </select> </td>
		</tr>
		
		<tr><td colspan="8" width="TABLEWIDTH" class="LABEL"><center><font color="red">*</font>Letter Type Name</center></td></tr>
 			 <tr>
  			 <td class="CONTROL" colspan="3">
			<div id="LeftLetterId" align="right"><select name="strLeftLetterName" size="8" 
				multiple style="width: 280px"></select></div>
			</td>
			<td width="6%" class="CONTROL" colspan="2">
			
			<center><img src="../../hisglobal/images/forward3.gif" width="35"
				height="31" 
				onclick ="LeftListTransfer();"></center>
				<center><img src="../../hisglobal/images/forwardward.gif" width="35" height="31" 
				align="middle" onClick="shiftAllToRight('strLeftLetterName','strRightLetterName',1);"/></center>
				<br/>
				<center>
				<img src="../../hisglobal/images/backward.gif" width="35"
				height="31" 
				onClick='shiftAllToLeft("strLeftLetterName","strRightLetterName",1);'>
				</center>
				<center><img src="../../hisglobal/images/back3.gif" width="35" 
				height="31" 
				onclick="shiftToLeft('strLeftLetterName','strRightLetterName',1);"/></center>
			</td>
			
			<td colspan="3" class="CONTROL" >
			<div id="RightLetterId" align="left"><select name="strRightLetterName" size="8" 
			multiple style="width: 280px">
			</select></div>
			</td>		
			</tr> 
		
		<tr>
			<td colspan="4" width="50%" class="LABEL">
			Remarks
			</td>
			<td colspan="4" width="50%" class="CONTROL">
			  <div align="left">
        		<textarea name="strRemarks" rows="2"></textarea>
    	 </div>
			</td>
	</tr>
		<tr>
			<td colspan="4" width="50%" class="LABEL">
			<font color="red">*</font>Effective From
			</td>
			<td colspan="4" class ="CONTROL"><date:date name="strEffectiveFrom" value="${ProcessLetterTypeMstBean.strCtDate}"></date:date></td>
</tr>
		
		<tr class="FOOTER">
			 <td colspan="8"><font size="2" color="red">*</font> Mandatory Fields  </td>
		</tr>
	</table>
	<table class="TABLEWIDTH" align="center" cellpadding="1px"
         cellspacing="1px">
		<tr>

			<td align="center">
			<img style="cursor: pointer; " src="../../hisglobal/images/btn-sv.png" title="Save Record" onClick=" return validate1();"/> 
			<img style="cursor: pointer; " src="../../hisglobal/images/btn-clr.png" title="Reset Content" onClick="document.forms[0].reset();"/>
			<img style="cursor: pointer; " src="../../hisglobal/images/btn-ccl.png" title="Cancel Process" onClick="cancel('LIST');"/>
			
			</td>
		</tr>
	</table>
	<input type="hidden" name="comboValue" value="${ProcessLetterTypeMstBean.strProcessName}"/>
	<input type="hidden" name="strProcessId" value="${ProcessLetterTypeMstBean.combo[0]}"/>
	
<input type="hidden" name="hmode"/>
<cmbPers:cmbPers/>
</html:form>
<tag:autoIndex></tag:autoIndex>
</body>
</html>