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
<meta name="viewport" content="width=device-width, initial-scale=1.0">

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
	src="../../hisglobal/bootstrap4.0_newgui/swAl/swal.js"></script>
<script type="text/javascript"
	src="../../hisglobal/jquery/3.6.0.min.js"></script>
<script type="text/javascript"
	src="../../hisglobal/bootstrap4.0_newgui/datatable/js/jquery.dataTables.js"></script>
<script type="text/javascript"
	src="../../hisglobal/bootstrap4.0_newgui/js/bootstrap.min.js"></script>
<script type="text/javascript"
	src="../../hisglobal/bootstrap4.0_newgui/datatable/js/dataTables.bootstrap4.js"></script>
<script type="text/javascript"
	src="../../hisglobal/bootstrap4.0_newgui/datetimepicker/js/gijgo.min.js"></script>

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
<script language="Javascript" src="../../mms/js/approving_authority_mstBS.js"></script>
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
/* .legendNew {
    position: absolute;
    right: 100px;
    line-height: 1.2em;
    top: -2.9em;
} */

</style>
</head>
<body >
	<html:form action="/masters/ApprovingAuthorityMstBSCNT" name="approvingAuthorityMstBean" type="mms.masters.controller.fb.ApprovingAuthorityMstFB">
	
		<div id="errMsg" class="errMsg"><bean:write name="approvingAuthorityMstBean" property="strErrMsg" /></div>
		<div id="warningMsg" class="warningMsg"><bean:write name="approvingAuthorityMstBean" property="strWarningMsg" /></div>
		<div id="normalMsg" class="normalMsg"><bean:write name="approvingAuthorityMstBean" property="strNormalMsg" /></div>
	
		<div class="container-fluid">
			<div class="prescriptionTile">
				<div class='legendHeader'><i class="fas fa-university" style="font-size: 26px;">&nbsp;</i>Approving Authority&nbsp;&nbsp;<i class="fas fa-angle-double-right"></i>&nbsp;Modify</div>
		
				<div class="row ">
					<div class="legend2" id='nonPrintableLegend2'>
						
						<button type="button" id="savebutton" class="float-right btn btn-success mt-1 btn-icon savebtn" style="border-radius:50%; padding:12px 12px; background-color: #5cb85c;" tabindex="2" onclick="return validate1();">
							<i class="fas fa-save fa-lg iround" title="save"></i>
						</button>
						
						<button type="button" class="float-right btn btn-danger mt-1 btn-icon cancelbtn" style="border-radius:50%; padding:12px 14px;" onclick="cancel('LIST');">
							<i class="fas fa-times fa-lg" title="Cancel"></i>
						</button>
					</div>
				</div>
			
				<div class="container my-3 ">
				   <div class="row my-2">
						<div class="col-sm-3"><label>Approving Type:</label></div>
						<div class="col-sm-3">
						<bean:write name="approvingAuthorityMstBean" property="strApprovingType"/>
						</div>
						
						<div class="col-sm-3"><label>Store Name:</label></div>
						<div class="col-sm-3">
						<bean:write name="approvingAuthorityMstBean" property="strStoreName"/>
						</div>
					</div>
						
					<div class="row my-2">
						<div class="col-sm-3"><label>User Name:</label></div>
						<div class="col-sm-3">
						<bean:write name="approvingAuthorityMstBean" property="strUserNameModify"/>
						</div>
						
						<div class="col-sm-3"><label>Effective Date<font color="red">*</font></label></div>
						<div class="col-sm-3">
						<input type="text" class="form-control" name="strEffectiveDate" value="${approvingAuthorityMstBean.strEffectiveDate}" readonly="readonly" size="8">
						</div>
					</div>
					
					<div class="row my-2">
						<div class="col-sm-3"><label>Record Status:</label></div>
						<div class="col-sm-3">
						<html:radio name="approvingAuthorityMstBean" property="strIsValid" value="1">Active</html:radio>&nbsp;&nbsp;
					    <html:radio name="approvingAuthorityMstBean" property="strIsValid" value="2">Inactive</html:radio>
						</div>
						<div class="col-sm-3" ><label>Remarks</label></div>
						<div class="col-sm-3">
						<textarea name="strRemarks" class="form-control" cols="25" rows="1" style="height:38px;">
						<bean:write name="approvingAuthorityMstBean" property="strRemarks" filter="false"/></textarea>
						</div>
					</div>
				</div>
			
				<hr>
			 
				<div class="row text-right">
			    	<div class="col">
			    		<i class="fas fa-asterisk" style="color: red; font-size: smaller;"></i>Fields Mandatory
			    	</div>
				</div>
			
			</div>
		</div>
	
	
		<table class="TABLEWIDTH" align="center" cellpadding="1px" cellspacing="1px" style="display:none;">   
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
		  			</td>
		    </tr>
			
		</table>
		<table CLASS="TABLEWIDTH" align="center" cellspacing="1px" style="display:none;">
			<tr class="FOOTER">
				 <td colspan="2"><font size="2" color="red">*</font> Mandatory Fields  </td>
			</tr>
		</table>
		<br>
		<div align="center" id="" style="display:none;">					 
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