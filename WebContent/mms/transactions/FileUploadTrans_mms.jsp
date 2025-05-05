<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<%@ taglib uri="/WEB-INF/dateTag.tld" prefix="dateTag"%>
<%@ taglib uri="/WEB-INF/hisTab.tld" prefix="tag"%>
<%@ taglib uri="/WEB-INF/comboPersistence.tld" prefix="cmbPers"%>

<%@ taglib uri="/WEB-INF/crNo.tld" prefix="crNo"%>
<!-- 
/**
 * @author Amit Kumar
 * Date of Creation : 05/5/2009
 * Date of Modification :  /  / 
 * Version : 1.0
 * Module  : Store
 */
 -->
<html>
<head>
<title>Demand Notification Detail</title>
<link href="../../hisglobal/css/dwh.css" rel="stylesheet" type="text/css">
<link href="../../hisglobal/css/control.css" rel="stylesheet" type="text/css">
<link href="../../hisglobal/css/autocomplete.css" rel="stylesheet"	type="text/css">
<link href="../../hisglobal/css/calendar-tas.css" rel="stylesheet" type="text/css">
<link href="../../hisglobal/css/popup.css" rel="stylesheet" type="text/css">
<link href="../../hisglobal/css/newpopup.css" rel="stylesheet" type="text/css">
<link href="../../hisglobal/css/smoothness/jquery-ui-1.10.4.custom.min.css" rel="stylesheet" type="text/css">
<link href="../../hisglobal/css/select2.min.css" rel="stylesheet" type="text/css">
 <style>
.custom-combobox {
	position: relative;
	display: inline-block;
}

.custom-combobox-toggle {
	position: absolute;
	top: 0;
	bottom: 0;
	margin-left: -1px;
	padding: 0;
	/* support: IE7 */ *
	height: 1.7em; *
	top: 0.1em;
}

.custom-combobox-input {
	margin: 0;
	padding: 0.3em;
}
</style>
<script language="JavaScript" src="../../hisglobal/js/jquery-1.11.1.js"></script> 
<script language="JavaScript" src="../../hisglobal/js/select2.min.js"></script>
<!-- <script language="JavaScript" src="../../hisglobal/js/jquery-1.10.1.min.js"></script> -->
<script language="JavaScript" src="../../hisglobal/js/jquery-ui.min.js"></script>
<script language="JavaScript" src="../../hisglobal/js/jquery.autocomplete.min.js"></script>
<script language="Javascript" src="../../hisglobal/js/autocompleteItemSearch.js"></script>
<script language="JavaScript" src="../../masterutil/js/master.js"></script>
<script language="JavaScript" src="../../hisglobal/js/tab.js"></script>
<script language="JavaScript" src="../../hisglobal/js/calendar.js"></script>
<script language="Javascript" src="../../hisglobal/js/validation.js"></script>
<script language="Javascript" src="../../hisglobal/js/validationCommon.js"></script>
<script language="Javascript" src="../js/searchItems_util.js"></script>
<script language="Javascript" src="../../hisglobal/js/util.js"></script>
<script language="Javascript" src="../../hisglobal/js/newpopup.js"></script>
<script language="Javascript" src="../../hisglobal/js/popup.js"></script>
<script language="Javascript" src="../../hisglobal/js/multirow.js"></script>
<script language="Javascript" src="../../hisglobal/js/commonFunctions.js"></script>
<script language="JavaScript" src="../js/mms.js"></script>
<script language="JavaScript" src="../js/FileUploadTrans.js"></script>
<script src="../../hisglobal/js/jquery-1.10.1.min.js"></script>
<script type="text/javascript">
function view1(obj1,obj2,obj3)
{
	document.getElementById(obj1).style.display="none";
	document.getElementById(obj2).style.display="block";
	document.getElementById(obj3).style.display="block";
}
function view2(obj1,obj2,obj3)
{
	document.getElementById(obj1).style.display="block";
	document.getElementById(obj2).style.display="none";
	document.getElementById(obj3).style.display="none";
}

 	
	function FileSize(obj)
	{		
		var file=obj.files[0];		
		if (file) 
		{	             
	                var fileSize = 0;
	                if (file.size > 1024 * 1024)
	                {
	                    fileSize = (Math.round(file.size * 100 / (1024 * 1024)) / 100)).toString() + 'MB';                   
	                    if(parseInt(fileSize)>5)
	                    {
	                      alert("File Size [ "+fileSize+" ] MB should Not be Gretaer than 5 MB");
	                      obj.value="";
	                      return false;
	                    }
	                }
	                else
	                {
	                    fileSize = (Math.round(file.size * 100 / 1024) / 100)).toString() + 'KB';
	                    
	                }    
	
	    }	
	}
	
	
</script>


<script>
$(document).ready(function() {
	 $(".combojqrycls").select2({  placeholder: 'Select Value'  }); 
}); 
</script>

</head>
<body class="background" >

<html:form styleClass="formbg" action="/transactions/FileUploadTransCNT.cnt"  name="fileUploadBean"  type="mms.transactions.controller.fb.FileUploadTransFB" method="post" enctype="multipart/form-data">

	<div class="errMsg" id="errMsg">
	     <bean:write name="fileUploadBean" property="strErr" /></div>
	<div class="warningMsg" id="warningMsg">
	     <bean:write name="fileUploadBean" property="strWarning" /></div>
	<div class="normalMsg" id="normalMsg">
	     <bean:write name="fileUploadBean" property="strMsg" /></div>

    
	
   	 <table width='100%' align="center" border="0" cellspacing ="1px">
		<tr class="HEADER">
			<td colspan="4">File Upload</td>
		</tr>
	</table>
	
	<table class="TABLEWIDTH" align="center" cellspacing="1px" cellpadding="1px">

		
		<tr>
			
			<td class="LABEL" width="50%"><font color='red' id='mandatory'>*</font>Up-Load Excel File</td>
			
			
			<td class="CONTROL" width="50%"><html:file property="strLocation"  onchange="FileSize(this);"/></td>
			
		</tr>
		
		</table>
	
	 <br/>
	
	
		 	<div>
			 	 <div class="legends"><font size="2" color="red">*</font> Mandatory Fields</div>  
				 <div class="control_button">
				 	<table  class="NEWTABLEWIDTH" align="center">
						<tr id="saveId">
								<td align="center">
									<div >
									<a style="display: none;" id="saveDeleteDivId" href="#" class="button" onClick="return validateDelete();" title="Click to Save Record"><span class="delete">Delete</span></a>
									<a style="display: none;" id="saveExtendDivId" href="#" class="button" onClick="return validateExtend();" title="Click to Save Record"><span class="modify">Extend</span></a>
									<a id="saveMainFormDivId" href="#" class="button" onClick="return validate1();" title="Click to Generate"><span class="save">Upload</span></a>
									<a href="#" class="button" onclick="initPage1();" title="Click to Clear Page"><span class="clear">Clear</span></a>
									<!-- <a href="#" class="button" onClick="cancel('CANCEL');" title="Click to Cancel"><span class="cancel">Cancel</span></a> -->				 
									</div>
								</td>
						</tr>	  
				 	</table>
				  </div>
			</div>	

	<input type="hidden" name="hmode" />	
	<input type="hidden" name="strWhetherDateConstraintValue" value="${fileUploadBean.strWhetherDateConstraintValue}"/>
	<input type="hidden" name="strWhetherItemConstraintValue" value="${fileUploadBean.strWhetherItemConstraintValue}"/>
	<input type="hidden" name="strWhetherProgConstraintValue" value="${fileUploadBean.strWhetherProgConstraintValue}"/>
	
	<input type="hidden" name="strCtDate" value="${fileUploadBean.strCtDate}"/>
	<input type="hidden" name="strSearchIndex" value="$Id"/>
	<input type="hidden" name="strAlphabet" value="$"/>

	<cmbPers:cmbPers />
	
	
</html:form>

<tag:autoIndex></tag:autoIndex>
</body>
</html>