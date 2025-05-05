<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<%@taglib uri="/WEB-INF/dateTag.tld" prefix="date"%>
<%@taglib uri="/WEB-INF/dateTag.tld" prefix="dateTag"%>
<%@ taglib uri="/WEB-INF/hisTab.tld" prefix="tag"%>
<%@ taglib uri="/WEB-INF/comboPersistence.tld" prefix="cmbPers"%>


<html>
<head>
<meta charset="utf-8">
<title>Approving Authority Master</title>
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
<script language="Javascript" src="../../mms/js/mms.js"></script>
<script language="Javascript" src="../../mms/js/approving_authority_mst.js"></script>
<script language="javaScript">

function validate1(){   
     
      var hisValidator = new HISValidator("approvingAuthorityMstBean"); 
        hisValidator.addValidation("strRemarks", "maxlen=100", "Remarks should have less than or equal to 100 Characters" );
        hisValidator.addValidation("strEffectiveDate", "date","Effective Date is a mandatory field");
        
      var retVal = hisValidator.validate(); 
    	
          if(retVal){
       			   document.forms[0].hmode.value = "UPDATE";
                        document.forms[0].submit();
            }else{
	           return false;
			   }
    }

</script>

</head>
<body >
<html:form action="/masters/ApprovingAuthorityMstCNT" name="approvingAuthorityMstBean" type="mms.masters.controller.fb.ApprovingAuthorityMstFB">
	
<center>
	<div id="errMsg" class="errMsg"><bean:write name="approvingAuthorityMstBean" property="strErrMsg" /></div>
	<div id="warningMsg" class="warningMsg"><bean:write name="approvingAuthorityMstBean" property="strWarningMsg" /></div>
	<div id="normalMsg" class="normalMsg"><bean:write name="approvingAuthorityMstBean" property="strNormalMsg" /></div>
	
</center>
	<table class="TABLEWIDTH" align="center" cellpadding="0"
         cellspacing="0">
         <tr>
               <td width="100%"><tag:tab tabLabel="Approving Authority Master"
				selectedTab="FIRST" align="center" width="100%">
              </tag:tab></td>
         </tr>
    </table>

	<table class="TABLEWIDTH" align="center" cellpadding="1px" cellspacing="1px">   
	<tr class="HEADER">
			<td colspan="2">Approving Authority&gt;&gt; Modify</td>
		</tr>
		<tr>
			<td width="50%" class="LABEL">Approving Type</td>
			
			<td width="50%" class="CONTROL">
			<bean:write name="approvingAuthorityMstBean" property="strApprovingType"/>
			
			</td>
		</tr>
		<tr>
			<td width="50%" class="LABEL">Store Name</td>
			
			
			<td width="50%" class="CONTROL">
			<bean:write name="approvingAuthorityMstBean" property="strStoreName"/>
			</td>
		</tr>
		<tr>
			<td width="50%" class="LABEL">User Name</td>
			
			
			<td width="50%" class="CONTROL">
			<bean:write name="approvingAuthorityMstBean" property="strUserNameModify"/>
			</td>
		</tr>
		<tr>
			<td class="LABEL" width="50%">
			<div align="right"><font
				color="red">*</font> Effective Date</div>
			</td>
			<td class="CONTROL"><input type="text" name="strEffectiveDate" value="${approvingAuthorityMstBean.strEffectiveDate}" readonly="readonly" size="8"></td>
		</tr>


		<tr>
			<td width="50%" class="LABEL" valign="top">Remarks </td>
			<td width="50%" class="CONTROL"><textarea name="strRemarks"
				cols="25" rows="2"><bean:write name="approvingAuthorityMstBean" property="strRemarks" filter="false"/></textarea></td>
		</tr>
		 <tr >
    <td width ="45%" class ="LABEL">Record Status </td>
    <td width ="45%" class ="CONTROL" >
   <html:radio name="approvingAuthorityMstBean" property="strIsValid" value="1">Active</html:radio>
    <html:radio name="approvingAuthorityMstBean" property="strIsValid" value="2">Inactive</html:radio>
    
   </td>
    </tr>
		</table>
		<table CLASS="TABLEWIDTH" align="center" cellspacing="1px">
		<tr class="FOOTER">
			 <td colspan="2"><font size="2" color="red">*</font> Mandatory Fields  </td>
		</tr>
	</table>
	<!-- <table border="0" class="TABLEWIDTH" align="center">
		<tr>

			<td align="center">
			<img style="cursor: pointer; " src="../../hisglobal/images/btn-sv.png" onClick="return validate1();" />
				<img style="cursor: pointer; " src="../../hisglobal/images/btn-ccl.png" title="Cancel Process" onClick="cancel('LIST');"/>
		</td>
		</tr>
	</table>-->
	<br>
<div align="center" id="">					 
					 	<a href="#" class="button" id=" " onclick=' return validate1();'><span class="save">Save</span></a>
						<a href="#" class="button" onclick="cancel('LIST');"><span class="cancel">Cancel</span></a>
				</div> 
<input type="hidden" name="hmode"/>

<input type="hidden" name="strApprovingTypeId" value="${approvingAuthorityMstBean.strApprovingTypeId}"> 
<input type="hidden" name="strStoreId" value="${approvingAuthorityMstBean.strStoreId}">
<input type="hidden" name="strStoreName" value="${approvingAuthorityMstBean.strStoreName}">
<input type="hidden" name="strApprovingType" value="${approvingAuthorityMstBean.strApprovingType}">
<input type="hidden" name="comboValue" value="${approvingAuthorityMstBean.comboValue}">
<input type="hidden" name="chk" value="${approvingAuthorityMstBean.strChk1}">

 <cmbPers:cmbPers/>
</html:form>
<tag:autoIndex></tag:autoIndex>
</body>
</html>