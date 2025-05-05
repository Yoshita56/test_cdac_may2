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
<script type="text/javascript" src="../../hisglobal/bootstrap4.0_newgui/datatable/js/jquery.dataTables.js"></script>
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
<script language="Javascript" src="../../hisglobal/js/validationBootstrap.js"></script>
<script language="Javascript" src="../../hisglobal/js/util.js"></script>
<script language="Javascript"
	src="../../mms/js/approving_authority_mstBS.js"></script>

</head>
<body>
<html:form action="/masters/ApprovingAuthorityMstBSCNT"
	name="approvingAuthorityMstBean"
	type="mms.masters.controller.fb.ApprovingAuthorityMstFB">

	<center>
	<div id="errMsg" class="errMsg"><bean:write
		name="approvingAuthorityMstBean" property="strErrMsg" /></div>
	<div id="warningMsg" class="warningMsg"><bean:write
		name="approvingAuthorityMstBean" property="strWarningMsg" /></div>
	<div id="normalMsg" class="normalMsg"><bean:write
		name="approvingAuthorityMstBean" property="strNormalMsg" /></div>


	<%-- <tag:tab tabLabel="Approving Authority" selectedTab="FIRST"
		align="center" width="TABLEWIDTH">
	</tag:tab> --%></center>

<div class=" px-1 px-md-4  mx-auto">
<div class="row">
<div class="col-sm-9">
<h3 style="text-align: left; margin-bottom: 0; margin-top:0;margin-left:5px;">Approving Authority
        	<b style="font-weight: normal;font-size: 16px;font-family: courier;">[</b>
        	<b id="patDeptName" style="font-weight: normal;font-size: 16px;font-family: courier;">
        	<bean:write name="approvingAuthorityMstBean" property="strApprovingType" />/<bean:write name="approvingAuthorityMstBean" property="strStoreName" /></b>
        	<b style="font-weight: normal;font-size: 16px;font-family: courier;">]</b>
        </h3>
</div>
<div class="col-sm-3">
	<div class="legendNew" id="nonPrintableLegend2" align="right" style="margin-right:6px;">
									<button type="button" class="float-right btn btn-outline-danger cancelbtn" onclick="cancel('LIST');">
										<i class="fas fa-ban iround" title="Cancel"></i>
									</button>
									<button type="button" class=" btn btn-secondary " onclick="document.forms[0].reset();" style="background: #b9b9b9; border-color: #b9b9b9; padding: .0rem .16rem;line-height: 0.8;">
										<img src="/HIS/hisglobal/images/clear3.png" title="Clear" style="width: 22px; color: #fff;">
									</button>
									<button type="button" id="submitId" class="float-right btn btn-outline-success  " tabindex="2" onclick="return validate1();" style="background-color: #5cb85c;padding: .2rem .5rem;margin:0px 3px;">
										<i class="fas fa-save iround" title="save"></i>
									</button>
								</div>
							
</div>
</div>
</div>


<div class=" px-1 px-md-4  mx-auto">
<div class="card">
<div class="row">
   <div class="col-sm-5" align="left">
   
				
							<p class="subHeaders" style="margin-bottom: 0;">
								<i class="fas fa-university" style="font-size: 26px;">&nbsp;</i>Approving Authority			
							</p>
				
						
				
   
   </div>
   <div class="col-sm-3" align="center">
   <input
				type="text" class="form-control" style="width: 200px" name="searchVal"
				onkeyup="searchInList();" />
   </div>
   <div class="col-sm-4" align="right">
   <input
				type="radio" name="strCommitteeFlag" id="nonCommitteeId" value="0" checked="checked"
				onchange="populateList(this);">Non-Committee&nbsp;&nbsp;<input type="radio"
				name="strCommitteeFlag" id="committeeId" value="1" onchange="populateList(this);">Committee
				
   </div>
   
   </div>

 
 
 
 <div class="row">
	<!-- <div class="col-sm-2"></div> -->
	<div class="col-sm-5">
	<div id="LeftUserDivId" align="center"><select class="form-control"
				name="strLUserName" size="8" multiple style="width: 480px">
				<bean:write name="approvingAuthorityMstBean" property="strUserList"
					filter="false" />
			</select></div>
	</div>
	<div class="col-sm-2">
		
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
	<div class="col-sm-5">
	<div id="RightUserDivId" align="center"><select class="form-control" name="strUserName" size="8"
				multiple style="width: 480px">
				<bean:write name="approvingAuthorityMstBean" property="strRUserList"
					filter="false" />
			</select></div>
	</div>
	<!-- <div class="col-sm-2"></div> -->
	</div>
 
 
 
  
  <div class="row mt-1" >
  <div class="col-sm-2" align="right">
  <label><font color="red">*</font>Effective Date</label>
  </div>
  <div class="col-sm-2">
  <input  type="text" class="form-control datepicker" name="strEffectiveDate" value="${approvingAuthorityMstBean.strCtDate}">
  
 
  </div>
  <div class="col-sm-2" align="right">
  <label>Remark</label>
  </div>
  <div class="col-sm-6">
  <textarea class="form-control" name="strRemarks" rows="2" col="25"></textarea>
  </div>
  </div>
   <hr>
   <div class="row rowFlex reFlex">
							<div class="col-sm-9"></div>
							<div class="col-sm-3" align="right">
								<i class="fas fa-asterisk" style="color: red; font-size: smaller;"></i>&nbsp;Fields Mandatory
							</div>
						</div>
 
</div>
</div>





	<table class="TABLEWIDTH" align="center" style="display:none;">
		<tr class="HEADER">
			<td colspan="2">Approving Authority&gt;&gt; Add</td>
		</tr>
		<tr>
			<td width="50%" class="LABEL">Approving Type</td>

			<td width="50%" class="CONTROL"><bean:write
				name="approvingAuthorityMstBean" property="strApprovingType" /></td>
		</tr>
		<tr>
			<td width="50%" class="LABEL">Store Name</td>


			<td width="50%" class="CONTROL"><bean:write
				name="approvingAuthorityMstBean" property="strStoreName" /></td>
		</tr>

	</table>

	<%-- <table class="TABLEWIDTH" align="center" cellpadding="1px"
		cellspacing="1px" style="border-collapse: collapse;" style="display:none;">
		<tr>
			<td class="TITLE" width="50%">Approving Authority Details</td>
			<td class="TITLE" width="50%" style="text-align: right;"><input
				type="radio" name="strCommitteeFlag" id="nonCommitteeId" value="0" checked="checked"
				onchange="populateList(this);">Non-Committee&nbsp;&nbsp;<input type="radio"
				name="strCommitteeFlag" id="committeeId" value="1" onchange="populateList(this);">Committee</td>
		</tr>
		<tr>
			<td colspan="2" class="LABEL"></td>
		</tr>
		<tr>

			<td class="CONTROL" style="text-align: center;"><input
				type="text" class="txtFldMax" style="width: 200px" name="searchVal"
				onkeyup="searchInList();" /></td>
			<td class="LABEL"></td>
		</tr>

	</table>

	<table class="TABLEWIDTH" align="center" cellpadding="1px"
		cellspacing="1px" style="display:none;">

		<tr>
			<td colspan="3" class="LABEL">&nbsp;</td>
		</tr>
		<tr>
			<td class="CONTROL" width="47%">

			<div id="LeftUserDivId" align="center"><select
				name="strLUserName" size="8" multiple style="width: 280px">
				<bean:write name="approvingAuthorityMstBean" property="strUserList"
					filter="false" />
			</select></div>
			</td>
			<td width="6%" class="CONTROL">

			<center><img src="../../hisglobal/images/forward3.gif"
				width="35" height="31" onclick="LeftListTransfer();"></center>

			<center><img src="../../hisglobal/images/forwardward.gif"
				width="35" height="31" align="middle"
				onClick='shiftAllToRight("strLUserName","strUserName",1);'></center>

			<center><img src="../../hisglobal/images/backward.gif"
				width="35" height="31"
				onClick="shiftAllToLeft('strLUserName','strUserName',1);"></center>

			<center><img src="../../hisglobal/images/back3.gif"
				width="35" height="31"
				onClick='shiftToLeft("strLUserName","strUserName",1);'></center>
			</td>

			<td class="CONTROL" width="47%">
			<div id="RightUserDivId" align="center"><select name="strUserName" size="8"
				multiple style="width: 280px">
				<bean:write name="approvingAuthorityMstBean" property="strRUserList"
					filter="false" />
			</select></div>
			</td>
		</tr>
	</table> --%>



	<table border="0" class="TABLEWIDTH" align="center" style="display:none;">
		<tr>
			<td colspan="4" class="LABEL"></td>
		</tr>
		<tr>
			<td class="LABEL" width="25%" colspan="1"><font color="red">*</font>Effective
			Date</td>
			<td width="25%" class="CONTROL" colspan="1"><dateTag:date
				name="strEffectiveDate"
				value="${approvingAuthorityMstBean.strCtDate}"></dateTag:date></td>
			<td class="LABEL" width="25%" colspan="1">Remarks</td>
			<td width="25%" class="CONTROL" colspan="1"><textarea
				name="strRemarks" rows="2"></textarea></td>
		</tr>
	</table>

	<table border="0" class="TABLEWIDTH" align="center" style="display:none;">
		<tr class="FOOTER">
			<td colspan="2"><font size="2" color="red">*</font> Mandatory
			Fields</td>
		</tr>
	</table>
<!-- 	<table border="0" class="TABLEWIDTH" align="center">
		<tr>

			<td align="center"><img style="cursor: pointer;"
				src="../../hisglobal/images/btn-sv.png"
				onClick="return validate1();" /> <img style="cursor: pointer;"
				src="../../hisglobal/images/btn-clr.png"
				onClick="document.forms[0].reset();"> <img
				style="cursor: pointer;" src="../../hisglobal/images/btn-ccl.png"
				onClick="cancel('LIST');"></td>
		</tr>
	</table>-->
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