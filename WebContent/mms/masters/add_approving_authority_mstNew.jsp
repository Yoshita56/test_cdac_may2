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
<title>Approving Authority</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link href="../../hisglobal/bootstrap4.0_newgui/css/bootstrap.css" rel="stylesheet" />
<link href="../../hisglobal/bootstrap4.0_newgui/css/bootstrap-theme.css" rel="stylesheet" />
<link href="../../hisglobal/bootstrap4.0_newgui/datatable/css/dataTables.bootstrap.css" rel="stylesheet" />
<link href="../../hisglobal/bootstrap4.0_newgui/font-awesome/css/all.css" rel="stylesheet">
<link href="../../hisglobal/bootstrap4.0_newgui/swAl/swal.css" rel="stylesheet">
<link href="../../ipd/css/newlayout.css" rel="stylesheet" type="text/css">
<link href="../../hisglobal/bootstrap4.0_newgui/datetimepicker/css/gijgo.min.css" rel="stylesheet" type="text/css">

<script type="text/javascript" src="../../hisglobal/bootstrap4.0_newgui/swAl/swal.js"></script>
<script type="text/javascript" src="../../hisglobal/jquery/3.6.0.min.js"></script>
<script language="JavaScript" src="../../hisglobal/js/DataTables.js"></script>
<script type="text/javascript" src="../../hisglobal/bootstrap4.0_newgui/js/bootstrap.min.js"></script>
<script type="text/javascript" src="../../hisglobal/bootstrap4.0_newgui/datatable/js/dataTables.bootstrap4.js"></script>
<script type="text/javascript" src="../../hisglobal/bootstrap4.0_newgui/datetimepicker/js/gijgo.min.js"></script>


<link href="../css/master.css" rel="stylesheet" type="text/css">
<link href="../../hisglobal/css/tab.css" rel="stylesheet"
	type="text/css">
<link href="../../hisglobal/css/calendar-tas.css" rel="stylesheet"
	type="text/css">

<link href="../../hisglobal/css/popup.css" rel="stylesheet"
	type="text/css">
<link href="../../hisglobal/css/buttons.css" rel="stylesheet" 
type="text/css">
<script language="JavaScript"
	src="../../hisglobal/masterutil/js/master.js"></script>
<script language="JavaScript" src="../../hisglobal/js/tab.js"></script>
<script language="JavaScript" src="../../hisglobal/js/calendar.js"></script>
<script language="Javascript" src="../../hisglobal/js/validation.js"></script>
<script language="Javascript" src="../../hisglobal/js/util.js"></script>
<script language="Javascript"
	src="../../mms/js/approving_authority_mstBS.js"></script>

<style type="text/css">
.prescriptionTile {
				margin: 20px;
				border-bottom: 1px solid #d7d7d7;
				padding-bottom: 10px;
				padding: 1% 2% 0.5% 2%;
				background-color: #fff;
				transition: 0.5s;
				box-shadow: 0.5px 0.5px 10px 2px #b0acac;
				border-radius: .35rem;
				color: #666;
				color: rgba(75, 75, 75, 0.9);
				color: rgb(21, 21, 21);
			}
		.legend2 {
			  position: absolute;
			  top: 0.5em;
			  right: 44px;
			  line-height: 1.2em;
			}
</style>	

</head>
<body>
<html:form action="/masters/ApprovingAuthorityMstBSCNT" name="approvingAuthorityMstBean" type="mms.masters.controller.fb.ApprovingAuthorityMstFB">
	<div id="errMsg" class="errMsg"><bean:write
		name="approvingAuthorityMstBean" property="strErrMsg" /></div>
	<div id="warningMsg" class="warningMsg"><bean:write
		name="approvingAuthorityMstBean" property="strWarningMsg" /></div>
	<div id="normalMsg" class="normalMsg"><bean:write
		name="approvingAuthorityMstBean" property="strNormalMsg" /></div>

<div class="container-fluid">
	<div class="prescriptionTile">
			<div class="row">
				<div class="col-sm-9">
					<h3 style="text-align: left; margin-bottom: 0; margin-top:0;margin-left:5px;">Approving Authority
			        	<b style="font-weight: normal;font-size: 16px;font-family: courier;">[</b>
			        	<b id="patDeptName" style="font-weight: normal;font-size: 16px;font-family: courier;">
			        	<bean:write name="approvingAuthorityMstBean" property="strApprovingType" />/<bean:write name="approvingAuthorityMstBean" property="strStoreName" /></b>
			        	<b style="font-weight: normal;font-size: 16px;font-family: courier;">]</b>
		        	</h3>
				</div>
			</div>
			<div class="row">
				<div class="legend2" id="nonPrintableLegend2" align="right">
					<button type="button" id="submitId" class="float-right btn btn-success" tabindex="2" onclick="return validate1();" style="border-radius:50%; padding:10px 12px; background-color: #5cb85c;">
						<i class="fas fa-save iround" title="save"></i>
					</button>
					
					<button type="button" class=" btn btn-secondary " onclick="document.forms[0].reset();" style="border-radius:50%; background: royalblue;padding:10px 9px;">
						<i class="fas fa-broom" title="Clear"></i>
						<!-- <img src="/HIS/hisglobal/images/clear3.png" title="Clear" style="width: 22px; color: #fff;"> -->
					</button>
					
					<button type="button" class="float-right btn btn-danger cancelbtn" style="border-radius:50%; padding:10px 12px;" onclick="cancel('LIST');">
						<i class="fas fa-times" title="Cancel"></i>
					</button>
				</div>
		   </div>
		   
		<div class="container">
			<div class="row my-3">
			   <div class="col-sm-4">
				<p class="subHeaders" style="margin-bottom: 0;">
					<i class="fas fa-university" style="font-size: 26px;">&nbsp;</i>Approving Authority			
				</p>
			   </div>
			 </div>
			
			<div class="row my-2">   
			   <div class="col-sm-5 input-group sm" align="">
			   <div class="input-group-prepend"><span class="input-group-text"><i class="fas fa-search"></i></span></div>
			   <input type="text" class="form-control" style="width: 200px" name="searchVal" onkeyup="searchInList();">
			   </div>
			   
			   <div class="col-sm-7" align="center">
			   <input type="radio" name="strCommitteeFlag" id="nonCommitteeId" value="0" checked="checked" onchange="populateList(this);">
			   	Non-Committee&nbsp;&nbsp;<input type="radio"
				name="strCommitteeFlag" id="committeeId" value="1" onchange="populateList(this);">
				Committee
			   </div>
			</div>
 
 			<div class="row">
				<div class="col-sm-5" id="LeftUserDivId">
					<select class="form-control" name="strLUserName" size="8" multiple style="width: 100%">
						<bean:write name="approvingAuthorityMstBean" property="strUserList" filter="false" />
					</select>
				</div>
				<div class="col-sm-2 my-auto">
						<center>
								<i class="fas fa-caret-right" onclick="LeftListTransfer();" align="middle" style="border: 1px solid ; padding: 0.3rem 0.7rem; margin-bottom:0.3rem; "></i>		
						</center>
						<center>
						<i class="fas fa-forward" align="middle" onClick='shiftAllToRight("strLUserName","strUserName",1);' style="border: 1px solid; padding: 0.3rem 0.4rem;"></i>
							
					 	</center>
						<br/>
						<center>				
						
							<i class="fas fa-backward" onClick="shiftAllToLeft('strLUserName','strUserName',1);" align="middle" style="border: 1px solid; padding: 0.3rem 0.4rem; margin-bottom:0.3rem;"></i>
								</center>
						
						<center>
							<i class="fas fa-caret-left" onClick='shiftToLeft("strLUserName","strUserName",1);' align="middle" style="border: 1px solid ; padding: 0.3rem 0.7rem;"></i>
								</center>
				</div>
				<div class="col-sm-5" id="RightUserDivId">
						<select class="form-control" name="strUserName" size="8" multiple style="width: 100%">
							<bean:write name="approvingAuthorityMstBean" property="strRUserList"
								filter="false" />
						</select>
				</div>
			  </div>
		 	  <hr>
			  <div class="row my-2" >
				  <div class="col-sm-2">
				  <label><font color="red">*</font>Effective Date</label>
				  </div>
				  <div class="col-sm-3">
				  <input  type="text" class="form-control datepicker" name="strEffectiveDate" value="${approvingAuthorityMstBean.strCtDate}">
				  </div>
				  
				   <div class="col-sm-2"></div>
				  
				  <div class="col-sm-2">
				  <label>Remark</label>
				  </div>
				  <div class="col-sm-3">
				  <textarea class="form-control" name="strRemarks" rows="1" cols="25" style="height:38px;"></textarea>
				  </div>
			  </div>
		  </div>
 			<hr>
			 
			<div class="row text-right">
		    	<div class="col">
		    		<i class="fas fa-asterisk" style="color: red; font-size: smaller;"></i>&nbsp;Fields Mandatory
		    	</div>
			</div>

				<br>
			<div align="center" id=" " style="display:none;">					 
				 	<a href="#" class="button" id="submitId" onclick=' return validate1();'><span class="save">Save</span></a>
					<a href="#" class="button"	onclick="document.forms[0].reset();"><span class="clear">Clear</span></a> 
					<a href="#" class="button" onclick="cancel('LIST');"><span class="cancel">Cancel</span></a>
			</div> 
				
			<input type="hidden" name="hmode" />
			<input type="hidden" name="strApprovingTypeId"
				value="${approvingAuthorityMstBean.strApprovingTypeId}">
			<input type="hidden" name="strStoreId"
				value="${approvingAuthorityMstBean.strStoreId}">
			<input type="hidden" name="strStoreName"
				value="${approvingAuthorityMstBean.strStoreName}">
			<input type="hidden" name="strApprovingType"
				value="${approvingAuthorityMstBean.strApprovingType}">
			<input type="hidden" name="comboValue"
				value="${approvingAuthorityMstBean.comboValue}">
			<cmbPers:cmbPers />

	</div>
</div>

</html:form>
<tag:autoIndex></tag:autoIndex>
<script type="text/javascript">

$('.datepicker').each(function(){
    $(this).datepicker({ modal: true, header: true, footer: true ,format: 'dd-mmm-yyyy'});
});
var today=new Date();
var arr=["Jan","Feb","Mar","Apr","May","Jun","Jul","Aug","Sep","Oct","Nov","Dec"];
var mmm=arr[today.getMonth()];
var hrs=today.getHours();
var dd=today.getDate()+"-"+mmm+"-"+today.getFullYear();
$('.datepicker').val(dd);

</script>
</body>
</html>