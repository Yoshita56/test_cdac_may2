<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<%@taglib uri="/WEB-INF/dateTag.tld" prefix="dateTag"%>
<%@ taglib uri="/WEB-INF/hisTab.tld" prefix="tag"%>
<%@ taglib uri="/WEB-INF/comboPersistence.tld" prefix="cmbPers"%>


<html>
<head>
<meta charset="utf-8">
<title>Store Request Type Master Modify Page</title>
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
<link href="../../hisglobal/css/tab.css" rel="stylesheet" type="text/css">
<link href="../../hisglobal/css/calendar-tas.css" rel="stylesheet" type="text/css">
<link href="../../hisglobal/css/buttons.css" rel="stylesheet" type="text/css">
<link href="../../hisglobal/css/popup.css" rel="stylesheet" type="text/css">	
	
<script language="JavaScript" src="../../hisglobal/masterutil/js/master.js"></script>
<script language="JavaScript" src="../../hisglobal/js/tab.js"></script>
<script language="JavaScript" src="../../hisglobal/js/calendar.js"></script>
<script language="Javascript" src="../../hisglobal/js/validation.js"></script>

<script language="javaScript">

function validate1(){   
     
      var hisValidator = new HISValidator("storeReqTypeBean"); 
        hisValidator.addValidation("strRemarks", "maxlen=100", "Remarks should have less than or equal to 100 Characters" );
        //hisValidator.addValidation("strEffectiveFrom", "date","Effective Date is a mandatory field");
        
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
.legendvs{
    position: absolute;
    right: 100px;
    line-height: 1.2em;
     top: 0.8em; 
}
</style>
</head>
<body onLoad="">
<html:form name="storeReqTypeBean" action="/masters/StoreReqTypeMstBSCNT"
	type="mms.masters.controller.fb.StoreReqTypeMstFB">
 <fieldset form="form1"> 
<br> 
<div class="row rowFlex reFlex" >
<div class="legendvs" id="saveId">
<button  type="button" class="float-right btn btn-outline-danger mt-1 btn-circle cancelbtn" onclick="cancel('LIST');">
<i class="fas fa-ban iround"  title="Cancel"></i>
</button>
<button  type="button" id="submitId" onclick=' return validate1();' class="float-right btn btn-outline-success mt-1 btn-circle" tabindex='2' style="background-color: #5cb85c;">					
<i class="fa fa-save iround"  title="Save" ></i>
</button> 							                 
  </div> 
</div>  
<div class="prescriptionTile">
<div class="row" align="left">
<p class="subHeaders" style="margin-bottom: 0;">
<i class="fas fa-university" style="font-size: 26px;">&nbsp;</i>
Store Request Type Master
<i class="fas fa-angle-double-right"></i>
<label>Modify</label></p>
<div class="col-sm-8" align="center">
<div class="row">
<div class="col-sm-2" align="right">
<label>Store Name:</label>
</div>
<div class="col-sm-4" align="left" style="font-weight: 400;">
<bean:write name="storeReqTypeBean" property="strStoreName" filter="false" />
</div>
<div class="col-sm-3">
<label>Request Type:</label>
</div>
<div class="col-sm-3" align="left" style="font-weight: 400;">
<bean:write	name="storeReqTypeBean" property="strReqType" filter="false"  />
</div> 
</div>
</div>
</div>
<hr>
<div class="row">
<%-- <div class="col-sm-4">
<div class="row">
<div class="col-sm-4">
<label>Store Name:</label>
</div>
<div class="col-sm-8" align="left" style="font-weight: 400;">
<bean:write name="storeReqTypeBean" property="strStoreName" filter="false" />
</div>
</div>
</div>
<div class="col-sm-2">
<label>Request Type:</label>
</div>
<div class="col-sm-2" align="left" style="font-weight: 400;">
<bean:write	name="storeReqTypeBean" property="strReqType" filter="false"  />
</div> --%>

<div class="col-sm-2">
<label>Record Status</label>&nbsp;
</div>
<div class="col-sm-2" align="left">
<html:radio name="storeReqTypeBean" property="strIsValid" value="1">&nbsp;Active</font></html:radio>&nbsp;
<html:radio name="storeReqTypeBean" property="strIsValid" value="2">&nbsp;Inactive</font></html:radio>
</div>
<div class="col-sm-2">
<label>Effective From:</label>
</div>
<div class="col-sm-2" align="left" style="font-weight: 400;">
<bean:write name="storeReqTypeBean" property="strEffectiveFrom" filter="false"></bean:write>
</div>
<div class="col-sm-4">
<div class="row">
<div class="col-sm-2">
<label>Remark</label>
</div>
<div class="col-sm-10">
<textarea name="strRemarks" class="form-control" cols="25" rows="2">
<bean:write name="storeReqTypeBean" property="strRemarks" filter="false"/>
</textarea>
</div>
</div>
</div>
</div>
<hr>
<div class="row">
<div class='col-sm-9'>
</div>
<div class='col-sm-3' align="right">

<label><font size="2" color="red">*</font>&nbsp;Mandatory Fields</label>

</div>
</div>


<!-- <table border="0" class="TABLEWIDTH" align="center" cellpadding="1px" cellspacing="1px">
		<tr>

			<td align="center">
			<img style="cursor: pointer; " src="../../hisglobal/images/btn-sv.png" title="Save Record" onClick=" return validate1();" /> 
			<img style="cursor: pointer; " src="../../hisglobal/images/btn-ccl.png" title="Cancel Process" onClick="cancel('LIST');" />
			</td>
		</tr>
	</table>-->
	<br>
<!-- <div align="center" id="saveId">					 
					 	<a href="#" class="button" id="submitId" onclick=' return validate1();'><span class="save">Save</span></a>
						<a href="#" class="button" onclick="cancel('LIST');"><span class="cancel">Cancel</span></a>
				</div> -->
<input type="hidden" name="hmode"/>
 <input type="hidden" name="chk" value="${storeReqTypeBean.strChk1 }">
 <input type="hidden" name="strEffectiveFrom" value="${storeReqTypeBean.strEffectiveFrom}" />
<cmbPers:cmbPers/>
</div>
</fieldset>
</html:form>
<tag:autoIndex></tag:autoIndex>
</body>
</html>