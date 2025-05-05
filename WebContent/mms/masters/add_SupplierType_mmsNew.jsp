<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" 
"http://www.w3.org/TR/html4/loose.dtd">

<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<%@taglib uri="/WEB-INF/dateTag.tld" prefix="dateTag"%>
<%@ taglib uri="/WEB-INF/hisTab.tld" prefix="tag"%>
<%@ taglib uri="/WEB-INF/comboPersistence.tld" prefix="cmbPers" %>
	
	
		
<html>
<head>
<meta charset=utf-8>
<title>Supplier Type Master</title>

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
<script language="JavaScript" src="../../hisglobal/masterutil/js/master.js"></script>
<script language="JavaScript" src="../../hisglobal/js/tab.js"></script>
<script language="JavaScript" src="../../hisglobal/js/calendar.js"></script>
<script language="Javascript" src="../../hisglobal/js/validationBootstrap.js"></script>
<script language ="javaScript">

<!-- 
	/**
 	 * Developer : Tanvi Sappal
     * Create Date : 26/Oct/2009
     * Process Name : Supplier Type Master
     * Version : 1.1
     * Modify By/Date : 
     */ 
    -->


function validate1(){   
     
             var hisValidator = new HISValidator("suppliertypeBean");
           
           hisValidator.addValidation("strSupplierTypeName", "req", "Supplier Type Name is a Mandatory Field" );  
            hisValidator.addValidation("strSupplierTypeName", "maxlen=50" , "Supplier Type Name should have less than or equal to 50 Characters" );
       		hisValidator.addValidation("strRemarks", "maxlen=100", "Remarks should have less than or equal to 100 Characters" );
            hisValidator.addValidation("strEffectiveFrom", "date","Effective Date is a mandatory field");
		  hisValidator.addValidation("strEffectiveFrom", "req", "Effective from is a Mandatory Field" );  
            var retVal = hisValidator.validate(); 

          if(retVal){
                 	   document.forms[0].hmode.value = "SAVE";
                       document.forms[0].submit();
          }else{
             return false;
          }
}

</script>
<style type="text/css">
/* .legendNew {
    position: absolute;
    right: 100px;
    line-height: 1.2em;
    top: -2.9em;
} */
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

<body onLoad="document.forms[0].strSupplierTypeName.focus()">
<html:form name="suppliertypeBean" action="/masters/SupplierTypeMstBSCNT" type="mms.masters.controller.fb.SupplierTypeMstFB">
<div class="container-fluid">
	<div class="prescriptionTile">
	 	<div class="errMsg"><bean:write name="suppliertypeBean" property="strErr"/></div>
		<div class="warningMsg"><bean:write name="suppliertypeBean" property="strWarning"/></div>
		<div id="normalMsg" class="normalMsg"><bean:write name="suppliertypeBean" property="strMsg"/></div>
		<%-- <tag:tab tabLabel="Supplier Type Master" selectedTab="FIRST" align="center" width="TABLEWIDTH"> </tag:tab> --%>
	
		<div class="row">
			<p class="subHeaders" style="margin-bottom: 0;">
				<i class="fas fa-university" style="font-size: 26px;">&nbsp;</i>Supplier Type Master&nbsp;&nbsp;<i class="fas fa-angle-double-right"></i>&nbsp;Add			
			</p>
		</div>
		
		<div class="row" >
			 <div class="legend2" id="nonPrintableLegend2">
				<button type="button" class="float-right btn btn-danger cancelbtn my-1" style="border-radius:50%; padding:10px 12px;" onclick="cancel('LIST');">
					<i class="fas fa-times" title="Cancel"></i>
				</button>
				<button type="button" class="float-right btn btn-secondary my-1" onclick="document.forms[0].reset(),document.forms[0].strSupplierTypeName.focus();" style="border-radius:50%; background: royalblue;padding:10px 9px;">
					<i class="fas fa-broom" title="Clear"></i>
					<!-- <img src="/HIS/hisglobal/images/clear3.png" title="Clear" style="width: 22px; color: #fff;"> -->
				</button>
				<button type="button" id="submitId" class="float-right btn btn-success my-1" tabindex="2" onclick="return validate1();" style="border-radius:50%; padding:10px 12px; background-color: #5cb85c;">
					<i class="fas fa-save iround" title="save"></i>
				</button> 	
			 </div>	
		</div> 
		<hr> 
		<div class="container">
			<div class="row my-2">
				<div class="col-sm-3">
					<label>Supplier Type Name<font color="red">*</font></label>
				</div>
				<div class="col-sm-3">
					<input type="text" class="form-control" name="strSupplierTypeName" value ="" maxlength="100" onkeypress="return validateData(event,18);"> 
				</div>
				<div class="col-sm-3">
					<label>Effective From<font color="red">*</font></label>
				</div>
				<div class="col-sm-3">
					<input  type="text" class="form-control datepicker" name="strEffectiveFrom" value ="${suppliertypeBean.strCtDate}">
				</div>
			</div>
		
			<div class="row my-2">
				<div class="col-sm-3">
					<label>Remark</label>
				</div>
				<div class="col-sm-3">
				 	<textarea name="strRemarks" class="form-control" rows="2" style="height:38px;"></textarea>
				</div>
				<div class="col-sm-6"></div>
			</div>
		</div>
		<hr>
			 
		<div class="row text-right">
	    	<div class="col">
	    		<i class="fas fa-asterisk" style="color: red; font-size: smaller;"></i>&nbsp;Fields Mandatory
	    	</div>
		</div>
		
	
	
	<table class="TABLEWIDTH" align="center" cellpadding="1px" cellspacing="1px" style="display:none;">
  <tr class="HEADER"> 
    <td colspan="2">Supplier Type Master&gt;&gt;Add</td>
  </tr> 
 
  <!-- <tr >
    <td class="LABEL"><font color="red">*</font>Supplier Type Name</td>
    <td width="50%" class ="CONTROL"><input type="text" class='txtFldMax' name="strSupplierTypeName" value ="" maxlength="100" onkeypress="return validateData(event,18);"> </td>
  </tr> -->
  
      
    <tr >
    <td class ="LABEL" width ="50%"><font color="red">*</font>Effective From</td>
    <td class ="CONTROL"><dateTag:date name="strEffectiveFrom" value ="${suppliertypeBean.strCtDate}"></dateTag:date></td>
    </tr>
    
    <tr>
      <td class="LABEL"><div align="right">Remarks</div></td>
      <td class="CONTROL">
	  <div align="left">
        <textarea name="strRemarks" rows="2"></textarea>
      </div></td>
      </tr>
    
    
   
   <tr class="FOOTER"> 
    <td colspan="2" ><font size="2" color="red">*</font> Mandatory Fields  </td>
  </tr>
</table>
	 
	    <table CLASS ="TABLEWIDTH" align="center" cellpadding="1px" cellspacing="1px" style="display:none;">
	      <tr> 
		<td align="center">
		<!-- 	<img
				src="../../hisglobal/images/btn-sv.png" style="cursor:pointer;cursor:pointer;" title="Save Record" onClick=" return validate1();" />
			<img src="../../hisglobal/images/btn-clr.png" style="cursor:pointer;cursor:pointer;" title="Reset Content"
				onClick="document.forms[0].reset(),document.forms[0].strSupplierTypeName.focus();" />
				<img src="../../hisglobal/images/btn-ccl.png" style="cursor:pointer;cursor:pointer;" title="Cancel Process"
				onClick="cancel('LIST');" /> -->
				
				<br>					 
				<a href="#" class="button" id="" onclick=' return validate1();'><span class="save">Save</span></a>
				<a href="#" class="button"	onclick="document.forms[0].reset(),document.forms[0].strSupplierTypeName.focus();"><span class="clear">Clear</span></a> 
				<a href="#" class="button" onclick="cancel('LIST');"><span class="cancel">Cancel</span></a>
			</td>
	      </tr>
	    </table>
	    <input type="hidden" name="hmode" />
	    


<cmbPers:cmbPers/>
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