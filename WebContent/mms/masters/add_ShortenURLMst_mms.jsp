<%-- 
author 	: Niharika Srivastava
Date of Creation : 25-08-10
Process : Drug Contradiction Master
Module 	: MMS
TL 		: Mr. Ajay Kumar Gupta
Description : Add Page for Drug Contradiction Master  
 --%>

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic"%>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<%@ taglib uri="/WEB-INF/dateTag.tld" prefix="dateTag"%>
<%@ taglib uri="/WEB-INF/hisTab.tld" prefix="tag"%>
<%@ taglib uri="/WEB-INF/comboPersistence.tld" prefix="cmbPers"%>

<html>
<head>
<meta charset=utf-8>
<title>Shorten URL Master</title>
<link href="../../hisglobal/bootstrap4.0_newgui/css/bootstrap.css"
	rel="stylesheet" />
<link href="../../hisglobal/bootstrap4.0_newgui/css/bootstrap-theme.css"
	rel="stylesheet" />
<link
	href="../../hisglobal/bootstrap4.0_newgui/datatable/css/dataTables.bootstrap.css"
	rel="stylesheet" />
<link
	href="../../hisglobal/bootstrap4.0_newgui/font-awesome/css/all.css"
	rel="stylesheet">
<link href="../../hisglobal/bootstrap4.0_newgui/swAl/swal.css"
	rel="stylesheet">
<link href="../../ipd/css/newlayout.css" rel="stylesheet"
	type="text/css">
<link
	href="../../hisglobal/bootstrap4.0_newgui/datetimepicker/css/gijgo.min.css"
	rel="stylesheet" type="text/css">


<script type="text/javascript"
	src="../../hisglobal/jquery/3.6.0.min.js"></script>

<script type="text/javascript"
	src="../../hisglobal/bootstrap4.0_newgui/js/bootstrap.min.js"></script>


<link href="../css/master.css" rel="stylesheet" type="text/css">
<link href="../../hisglobal/css/tab.css" rel="stylesheet"
	type="text/css">

<link href="../../hisglobal/css/buttons.css" rel="stylesheet"
	type="text/css">
<link href="../../hisglobal/css/popup.css" rel="stylesheet"
	type="text/css">

<script language="JavaScript" src="../../hisglobal/masterutil/js/master.js"></script>
<script language="Javascript" src="../../hisglobal/js/validation.js"></script>
<script language="Javascript" src="../../hisglobal/js/util.js"></script>

<style type="text/css">

.txtFldLarge {
	font-family: Verdana, Arial, Helvetica, sans-serif;
	font-size: 13px;
	font-style: normal;
	font-weight: normal;
	color: #000000;
	height: 14px;
	width: 200px;
}
.container input {
    position: initial;
    opacity: initial;
    cursor: pointer;
}
</style>
<script language="javaScript">

function validate1() {
   	var hisValidator = new HISValidator("ShortenURLMstBean");
 	var retVal = hisValidator.validate();
	if (retVal) {
   	var hmode = "SAVE"; 
	var url = "ShortenURLMstCNT.cnt?hmode="+hmode+
	"&strBaseId="+document.forms[0].strBaseId.value+
	"&strOrgID="+document.forms[0].strOrgID.value+
	"&strProId="+document.forms[0].strProId.value;
	ajaxFunction(url,"1");
	  	} else {
			return false;
		} 
  }
  
function getAjaxResponse(res, mode) {
	var objVal;
	if (mode == "1") {
		objVal.style.display = "block";
		document.getElementById("viewCancelButtonDivId1").style.display = "block";
		objVal.innerHTML = res;
	}
}

function clearFunction(){
	document.forms[0].reset();
	document.getElementById("LeftItemIds").innerHTML =  "<select name='strLeftItemIds' size='8' multiple style='width: 280px' > </select>";
	document.getElementById("RightItemIds").innerHTML = "<select name='strRightItemIds' size='8' multiple style='width: 280px' > </select>";
	document.forms[0].strGroupId.focus();
}

</script>
<style type="text/css">
.legendvs {
	position: absolute;
	right: 100px;
	line-height: 1.2em;
	top: 0.8em;
}
</style>
</head>
<body>
<html:form name="ShortenURLMstBean" action="/masters/ShortenURLMstCNT" type="mms.masters.controller.fb.ShortenURLMstFB">
	<center>
	<div id="errMsg" class="errMsg"><bean:write name="ShortenURLMstBean" property="strErr" /></div>
	<div class="warningMsg"><bean:write name="ShortenURLMstBean" property="strWarning"/></div>
	<div id="normalMsg" class="normalMsg"><bean:write name="ShortenURLMstBean" property="strMsg"/></div>
	</center>
		<div class="container" style="max-width: 1400px;">
         <br>
				<div class="prescriptionTile">
					<div class="row rowFlex reFlex">
						<div class="col-sm-5">
							<p class="subHeaders" style="margin-bottom: 0;">
								<i class="fas fa-university" style="font-size: 26px;"></i> Shorten
								URL <i class="fas fa-angle-double-right"></i> 
								<label>Master</label>
							</p>
						</div>
					    <div class="legendvs">
							<button type="button" class="float-right btn btn-outline-danger mt-1 btn-circle cancelbtn" onclick="cancel('LIST');">
								<i class="fas fa-ban iround" title="Cancel"></i>
						    </button>
							<button type="button" class=" btn btn-secondary btn-circle" onclick="clearFunction();"style="background: #b9b9b9; border-color: #b9b9b9; margin-top: 0.25rem !important;">
								<img src="/HIS/hisglobal/images/clear3.png" title="Clear" style="width: 23px; color: #fff;">
							</button>
							<button type="button" id="submitId" onclick='return validate1();'class="float-right btn btn-outline-success mt-1 btn-circle" tabindex='2' style="background-color: #5cb85c;">
								<i class="fa fa-save iround" title="Save"></i>
							</button>
					   </div>
					 </div>
				
					<div class="row">
						<div class="col-sm-2">
							<label> Base URL :</label>
						</div>
						<div class="col-sm-10">
								<input type="text" name="strBaseId" id="strBaseId" value="" class='form-control'>
						</div>
					</div>
					<div class="row">
						<div class="col-sm-2">
							<label> Original URL :</label>
						</div>
						<div class="col-sm-10">
							    <input type="text" name="strOrgID" id="strOrgID" value="" class='form-control'>
						</div>
					</div>
					<div class="row">
						<div class="col-sm-2">
							<label> Project Code :</label>
						</div>
						<div class="col-sm-10">
							<input type="text" name="strProId" id="strProId" value="" class='form-control'>
						</div>
				    </div>
		        <input type="hidden" name="hmode" />
		        <input type="hidden" name="strMsg" value="${ShortenURLMstBean.strMsg}">
		     </div>
	      </div>
		</html:form>
	</body>
</html>
