<%@ page language="java" contentType="text/html;"	pageEncoding="UTF-8"%>


<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<%@taglib uri="/WEB-INF/dateTag.tld" prefix="dateTag"%>
<%@ taglib uri="/WEB-INF/hisTab.tld" prefix="tag"%>
<%@ taglib uri="/WEB-INF/comboPersistence.tld" prefix="cmbPers" %>


<html>
<head>
<meta charset=UTF-8">
<title>Insert Title Here</title>
	<style>
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
		#gobutton{
		width:80px;
		}
		#go-btn i{
		transition: 500ms;
		}	
		#gobutton:hover #go-btn i{
		transform: translateY(7px) ;	
		} 
		.table .thead-dark {
		  color: #fff !important;
		  border: none !important;
		  background:linear-gradient(to right, rgb(73, 178, 243), rgb(2, 98, 156)) !important;
		}
		.thead-dark th{
		  background:none !important;
		  border: none !important;	
		  padding:0.25rem;	
		  
		}
			
	</style>
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

<link href="../css/transaction.css" rel="stylesheet" type="text/css">
<link href="../../hisglobal/css/tab.css" rel="stylesheet" type="text/css">
<link href="../../hisglobal/css/calendar-tas.css" rel="stylesheet" type="text/css">
<link href="../../hisglobal/css/popup.css" rel="stylesheet" type="text/css">	
<link href="../../hisglobal/css/newpopup.css" rel="stylesheet" type="text/css">
<link href="../../hisglobal/css/buttons.css" rel="stylesheet" type="text/css">
	
<script language="JavaScript" src="../../masterutil/js/master.js"></script>
<script language="JavaScript" src="../../hisglobal/js/tab.js"></script>
<script language="JavaScript" src="../../hisglobal/js/calendar.js"></script>
<script language="Javascript" src="../../hisglobal/js/validation.js"></script>
<script language="Javascript" src="../js/searchItems_util.js"></script>
<script language="Javascript" src="../../hisglobal/js/util.js"></script>
<script language="Javascript" src="../../hisglobal/js/newpopup.js"></script>
<script language="Javascript" src="../../hisglobal/js/popup.js"></script>
<script language="Javascript" src="../../hisglobal/js/multirow.js"></script>
<script language="JavaScript" src="../js/mms.js"></script>

<script language="Javascript" src="../js/issueDetails_utilNEW.js"></script> 

<script language="JavaScript" src="../js/SpecilaOffLineIssue.js"></script>

<script type="text/javascript">
	function controlToMainPage()
	{	    
		document.forms[0].hmode.value="unspecified";
		document.forms[0].submit();
	}
	
</script>

</head>
<body>

<html:form action="/transactions/OffLineIssueForSpPPCNT.cnt"  name="offLineIssueForSpPPBean" type="mms.transactions.controller.fb.OffLineIssueForSpPPFB" method="post">

		<div class="errMsg"     id="errMsg"><bean:write name="offLineIssueForSpPPBean" property="strErr"/></div>
		<div class="warningMsg" id="warningMsg"><bean:write name="offLineIssueForSpPPBean" property="strWarning"/></div>
		<div class="normalMsg"  id="normalMsg"><bean:write name="offLineIssueForSpPPBean" property="strMsg"/></div>

<div class="viewport" id="nonPrintable">
	<div class="container-fluid">
					<div class="prescriptionTile">
					
						<div class='legendHeader'><i class="fas fa-file-alt" style="font-size: 26px;"></i>&nbsp;Special Purpose Issue View</div>
						
						<div class="row " >
							<div class="legend2" id='nonPrintableLegend2'>
								
								<button type="button" class="float-right btn btn-danger mt-1 btn-circle" style="border-radius:50%; padding:12px;" onclick="cancelFunc();">
									<i class="fas fa-times fa-lg iround" title="Cancel"></i>
								</button>
								
								<button type="button" class=" btn btn-secondary btn-circle" style="border-radius:50%; padding:12px 7px; background: #2196f3; border-color: #b9b9b9; margin-top: 0.25rem !important;" onclick="initPage();">
									<!-- <img src="/HIS/hisglobal/images/clear3.png" title="Clear" style="width: 23px; color: #fff;"> -->
									<i class="fas fa-broom fa-lg iround" title="Clear"></i>
								</button>
								
								<button type="button" id="savebutton" class="float-right btn btn-success mt-1 btn-circle savebtn" name="patientAdmissionModiTransBean" tabindex='2'style="border-radius:50%; padding:12px;" onclick='return validateNewDemand();'>
									<i class="fa fa-download fa-beat iround" title="Save"></i>
								</button>
							</div>
						</div>
					
						<div class="row"  style="margin: 1% 12%">
								<div class="col-sm-2 ">Store Name:<font color="red">*</font></div>
								<div class="col-sm-4"> 
									<select name="strStoreName" class="browser-default custom-select"   onChange="getItemCategoryCombo();">
			        	                <bean:write name="offLineIssueForSpPPBean" property="strStoreName" filter="false"/>
					                </select>
				                </div>
						       	
						       	
						       	<div class="col-sm-2">Item Category:<font color="red">*</font></div>
						       	<div class="col-sm-4"><div id="ItemCatg" >
								     <select class='browser-default custom-select' name='strItemCatgCombo'> 
							              <bean:write name="offLineIssueForSpPPBean" property="strItemCatgCombo" filter="false"/>
							         </select>
								     </div>
						       	</div>
			       		</div>

						<div class="row " style="margin: 1% 12%">
								<div class="col-sm-2 ">From Date</div>
								<div class="col-sm-4">
									<input  name="strFromDate" class="form-control datepicker" value="${offLineIssueForSpPPBean.strFromDate}" style="color: rgba(113, 111, 111, 0.87);"> 
								</div>
		       					
						       	<div class="col-sm-2">To Date</div>
						       	<div class="col-sm-4">
						       		<input  name="strToDate" class="form-control datepicker" value="${offLineIssueForSpPPBean.strToDate}" style="color: rgba(113, 111, 111, 0.87);">    	
						       	</div>
						 </div>
						      
 					<!-- 	<div class="row " style="margin: 1% 12%">
					       	<div class="col"> 
					       		<a class="btn btn-sm btn-success"  href="#" onclick="getViewItemDtl();" style="font-size:1rem;">GO <i class="fas fa-angle-double-right"></i></a>
				       		</div>
				       	</div>  -->    
				       	
			       		<div class="row my-2">
		                    <div class="col"  align="center">
		                        <button type="button" id="gobutton" class="btn btn-success mt-1 btn-circle detailsbtn" title="Click to see Details" onClick="getViewItemDtl();"> 
		                                <div id="go-btn" class="popupToast" style="color: #fff;">
		                                    <span class="popuptextToast" >GO </span><i class="fas fa-angle-double-down"></i>
		                                </div>
		                        </button>
		                    </div>
	               		</div>
				       	
							<br>
       				<div align="center" id="breakageItemDtlId"> </div> 
					
					<!-- <div style="display:none;">
						<div class="prescriptionTile">
							<legend class='legendHeader' style='font-size: 16px !important; font-weight: bold !important;'><i aria-hidden="true" class="fa fa-clipboard"></i> &nbsp;Issue Details</legend>
							<div id ="breakageItemDtlId" class='table-responsive'></div>			
						</div>
					</div> -->
				
					
				    <input type="hidden" name="hmode"/>
				    <input type="hidden" name="strIsView" value="1"/>
				    
   				    <div id="blanket" style="display:none;"></div>
  					<div class="popUpDiv" id="popUpDiv" style="display:none;">
					   <table bgcolor="white">
					     <tr>
					      <td>
					           <div id="issueDtlsDivId" style="display:block;"></div>
					       </td>
					     </tr>
					    </table>
  					</div>
  					
    			</div>
   			 </div>
  		  </div>
  	  </div>
   </div>
    
  </html:form>
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