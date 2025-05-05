<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<%@taglib uri="/WEB-INF/dateTag.tld" prefix="dateTag"%>
<%@ taglib uri="/WEB-INF/hisTab.tld" prefix="tag"%>
<%@ taglib uri="/WEB-INF/comboPersistence.tld" prefix="cmbPers"%>


<html>
<head>
<meta charset=utf-8>
<title>Store Request Type Master Add Page</title>
<link href="../css/master.css" rel="stylesheet" type="text/css">
<link href="../../hisglobal/css/tab.css" rel="stylesheet" type="text/css">
<link href="../../hisglobal/css/calendar-tas.css" rel="stylesheet" type="text/css">
<link href="../../hisglobal/css/buttons.css" rel="stylesheet" type="text/css">
<link href="../../hisglobal/css/popup.css" rel="stylesheet" type="text/css">	
	
<script language="JavaScript" src="../../hisglobal/masterutil/js/master.js"></script>
<script language="JavaScript" src="../../hisglobal/js/tab.js"></script>
<script language="JavaScript" src="../../hisglobal/js/calendar.js"></script>
<script language="Javascript" src="../../hisglobal/js/validation.js"></script>
<script language="Javascript" src="../../hisglobal/js/util.js"></script>

<script language="javaScript">

function validate1(){   
     
     
     selectListRecords("strRightRequestTypes"); 
      var hisValidator = new HISValidator("storeReqTypeBean"); 
        hisValidator.addValidation("strRemarks", "maxlen=100", "Remarks should have less than or equal to 100 Characters" );
        hisValidator.addValidation("strEffectiveFrom", "date","Effective Date is a mandatory field");
      //   hisValidator.addValidation("strRightRequestTypes", "dontselect=0","Please move atleast one Request Type from left to right \n And select only those Requests which are to be added from right list");
      
      var retVal = hisValidator.validate(); 
      hisValidator.clearAllValidations();
    	
          if(retVal)
          {
        		 var count = selectListRecords("strRightRequestTypes");
        		 if(count==0)
        		 {
        		   alert("Please select a Request Type which is not already added");
        		   return false;
        		 }
       			   document.forms[0].hmode.value = "SAVE";
                        document.forms[0].submit();
            }else{
	           return false;
			   }
    }


function LeftListTransfer()
{
	var ob1=document.forms[0].strLeftReqTypes.value;
	var ob=document.getElementById("LeftReqTypes");
	shiftToRight("strLeftReqTypes","strRightRequestTypes",1);
}
</script>

</head>
<body onLoad="">
<html:form name="storeReqTypeBean" action="/masters/StoreReqTypeMstCNT"
	type="mms.masters.controller.fb.StoreReqTypeMstFB">
<center>
	<div class="errMsg"><bean:write name="storeReqTypeBean"
		property="strErr" /></div>
	<div class="warningMsg"><bean:write name="storeReqTypeBean"
		property="strWarning" /></div>
	<div id="normalMsg"  class="normalMsg"><bean:write name="storeReqTypeBean"
		property="strMsg" /></div>

	<tag:tab tabLabel="Store Request Type Master"
				selectedTab="FIRST" align="center" width="TABLEWIDTH">
			</tag:tab>
	</center>		
	<table class="TABLEWIDTH" align="center" cellpadding="1px" cellspacing="1px">
		<tr class="HEADER">
			<td colspan="2">Store Request Type Master Add</td>
		</tr>


		<tr>
			<td class="LABEL">Store Name</td>
			<td width="50%" class="CONTROL"><bean:write
				name="storeReqTypeBean" property="strStoreName" filter="false" />

			</td>

		</tr>
		<tr>
			<td class="LABEL">Drug Warehouse Category </td>
			<td width="50%" class="CONTROL"><bean:write
				name="storeReqTypeBean" property="strStoreCategory" filter="false" />

			</td>

		</tr>

		<tr>
		<td colspan="2"  class="LABEL"><center><font color="red">*</font>Request Type</center></td>
		</tr>
		</table>
		<table class="TABLEWIDTH" align="center" cellpadding="1px" cellspacing="1px">
 			 <tr>
  			 <td class="CONTROL" colspan="3">
  			 
			<div id="LeftReqTypes" align="right">
			<select name="strLeftReqTypes" size="8" 
				multiple style="width: 280px">
				<bean:write name="storeReqTypeBean" property="strLeftRequestTypeList" filter="false"/>
				</select></div>
			</td>
			<td width="6%" class="CONTROL" colspan="2">
			
			<center>
			<img src="../../hisglobal/images/forward3.gif" width="35"
				height="31" 
				onclick ="LeftListTransfer();"></center>
				
				<center><img src="../../hisglobal/images/forwardward.gif" width="35" height="31" 
				align="middle" onClick="shiftAllToRight('strLeftReqTypes','strRightRequestTypes',1);"/></center>
				<br/>
				<center>
				
				<img src="../../hisglobal/images/backward.gif" width="35"
				height="31" 
				onClick="shiftAllToLeft('strLeftReqTypes','strRightRequestTypes',1);">
				</center>
				
				<center><img src="../../hisglobal/images/back3.gif" width="35" 
				height="31" 
				onclick="shiftToLeft('strLeftReqTypes','strRightRequestTypes',1);"/></center>
			</td>
			
			<td colspan="3" class="CONTROL" >
			<div id="RightReqTypes" align="left"><select name="strRightRequestTypes" size="8" 
			multiple style="width: 280px"><bean:write name="storeReqTypeBean" property="strRightRequestTypeList" filter="false"/>
			</select></div>
			</td>		
			</tr> 
		</table>
		<table class="TABLEWIDTH" align="center" cellpadding="1px" cellspacing="1px">
		<tr>
			<td width="50%" class="LABEL" valign="top">Remarks</td>
			<td width="50%" class="CONTROL"><textarea name="strRemarks"
				cols="25" rows="2"></textarea></td>
		</tr>
		
		<tr>
			<td class="LABEL" width="50%">
			<div align="right"><font
				color="red">*</font> Effective From</div>
			</td>
			<td class="CONTROL"><dateTag:date name="strEffectiveFrom"
				value="${storeReqTypeBean.strCtDate}"></dateTag:date></td>
		</tr>


		

		
		<tr class="FOOTER">
			 <td colspan="2"><font size="2" color="red">*</font> Mandatory Fields  </td>
		</tr>
	</table>
	<!-- <table border="0" class="TABLEWIDTH" align="center">
		<tr>

			<td align="center">
			<img style="cursor: pointer; " src="../../hisglobal/images/btn-sv.png" title="Save Record" onClick=" return validate1();" /> 
			<img style="cursor: pointer; " src="../../hisglobal/images/btn-clr.png" title="Reset Content" onClick="document.forms[0].reset()" />
			<img style="cursor: pointer; " src="../../hisglobal/images/btn-ccl.png" title="Cancel Process" onClick="cancel('LIST');" />
			
			</td>
		</tr>
	</table> -->
<br>
<div align="center" id="saveId">					 
					 	<a href="#" class="button" id="submitId" onclick=' return validate1();'><span class="save">Save</span></a>
						<a href="#" class="button"	onclick="document.forms[0].reset()"><span class="clear">Clear</span></a> 
						<a href="#" class="button" onclick="cancel('LIST');"><span class="cancel">Cancel</span></a>
				</div>
<input type="hidden" name="hmode"/>
<input type="hidden" name="dummy"	value="${storeReqTypeBean.strDummy}">
<input type="hidden" name="comboValue" value="${storeReqTypeBean.comboValue}">
<input type="hidden" name="storeId" value="${storeReqTypeBean.strStoreId}">
<input type="hidden" name="storeCategoryId" value="${storeReqTypeBean.strStoreCategoryId}">
<cmbPers:cmbPers/>
</html:form>
<tag:autoIndex></tag:autoIndex>
</body>
</html>