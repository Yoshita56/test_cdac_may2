<%@ page language="java" contentType="text/html;"	pageEncoding="UTF-8"%>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<%@taglib uri="/WEB-INF/dateTag.tld" prefix="dateTag"%>
<%@ taglib uri="/WEB-INF/hisTab.tld" prefix="tag"%>
<%@ taglib uri="/WEB-INF/comboPersistence.tld" prefix="cmbPers" %>

<html>
<head>
<meta charset=UTF-8">
<title>Return from Patient</title>

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
<!-- <script type="text/javascript"
	src="../../hisglobal/bootstrap4.0_newgui/js/jquery-3.3.1.min.js"></script> -->
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
	
<script type="text/javascript" src="../../masterutil/js/master.js"></script>
<script type="text/javascript" src="../../hisglobal/js/tab.js"></script>
<script type="text/javascript" src="../../hisglobal/js/calendar.js"></script>
<script type="text/javascript" src="../../hisglobal/js/validation.js"></script>

<script type="text/javascript" src="../../hisglobal/js/util.js"></script>
<script type="text/javascript" src="../../hisglobal/js/newpopup.js"></script>
<script type="text/javascript" src="../../hisglobal/js/popup.js"></script>
<script type="text/javascript" src="../../hisglobal/js/multirow.js"></script>
<script type="text/javascript" src="../js/mms.js"></script>

<script language="Javascript" src="../../mms/js/miscellaneous_consumption_trans.js"></script>

<script>
$(document).ready(function() {
    $('#example').DataTable();
} );
</script>
<script type="text/javascript">
	function controlToMainPage()
	{
		document.forms[0].hmode.value="FIRSTDATA";
		document.forms[0].submit();
	}
	
	
	function printDataOne() 
	  {
		  var x = document.getElementById("printImg");
		  x.style.display = "none";
			
	  	newwin = window.open('', 'printwin','left=100,top=100,width=700,height=700,scrollbars=yes');
	  	newwin.document.write('<HTML><HEAD>');
	  	newwin.document.write((document.getElementsByTagName("head")[0]).innerHTML);
	  	newwin.document
	  			.write('<style type="text/css"> .hidecontrol { display: none; } </style>\n')
	  	newwin.document.write('<script>\n');
	  	newwin.document.write('function chkstate(){ \n');
	  	// newwin.document.write('if(document.readystate=="complete" ||
	  	// document.readystate=="undefined"){\n');
	  	newwin.document.write('window.close();\n');
	  	// newwin.document.write('}\n');
	  	// newwin.document.write('else{\n');
	  	// newwin.document.write('setTimeout("chkstate()",2000)\n');
	  	// newwin.document.write('}\n');
	  	newwin.document.write('}\n');
	  	newwin.document.write('function print_win(){\n');
	  	newwin.document.write('window.print();\n');
	  	newwin.document.write('chkstate();\n');
	  	newwin.document.write('}\n');

	  	newwin.document.write('<\/script>\n');
	  	newwin.document.write('</HEAD>\n');
	  	newwin.document.write('<BODY onload="print_win()">\n');
	  	newwin.document.write(document.getElementById('breakageItemDtlId').innerHTML);
	  	newwin.document.write('</BODY>\n');
	  	newwin.document.write('</HTML>\n');
	  	newwin.document.close();
		  var x = document.getElementById("printImg");
		  x.style.display = "block";

	  }
	
</script>
<style type="text/css">
body {
	font-family: "Helvetica Neue", Helvetica, Arial, sans-serif;
	font-size: 14px;
	line-height: 1.42857143;
	color: rgba(0, 0, 0, 1);
	font-weight: 501;
} 
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
	align:center;
}
.subHeaders {
	font-weight: 500 !important;
	font-family: "Helvetica Neue", "Helvetica";
	font-size: 19px !important;
	padding-bottom: 0px !important;
	color: rgba(0, 0, 0, 1);
}
.legend2 {
	position: absolute;
	top: -2.1em;
	right: 44px;
	line-height: 1.2em;
}
.btn-circle {
	width: 37px;
	height: 34px;
	text-align: center;
	padding: 6px 0;
	font-size: 12px;
	line-height: 1.428571429;
	border-radius: 17px;
	color: white;
	float: right;
}
.iround {
	color: white;
	font-size: 16px;
}
.cancelbtn {
	padding: .175rem .35rem;
	line-height: 0.8;
	background-color: #d9534f;
}
.table {
	width: 100%;
	margin-bottom: 1rem;
	color: rgba(0, 0, 0, 1);
	border-collapse: separate;
}
.table th, .table td {
	padding: 0.05rem;
	border-top: 0px solid #dee2e6;
}
.table .thead-dark {
  	color: #fff !important;
  	border: none !important;
  	background:linear-gradient(to right, rgb(73, 178, 243), rgb(2, 98, 156)) !important;
  	align:center;
}
.thead-dark th{
	background:none !important;
	border: none !important;	
	align:center;
}
</style>



</head>
<body>
<html:form name="miscellaneousTransIgimsBean" action="transactions/MiscellaneousIgimsTransCNT" type="mms.transactions.controller.fb.MiscellaneousIgimsTransFB">
<center>
	<div id="errMsg" class="errMsg"><bean:write name="miscellaneousTransIgimsBean" property="strErrMsg" /></div>
	<div id="warningMsg" class="warningMsg"><bean:write name="miscellaneousTransIgimsBean" property="strWarningMsg" /></div>
	<div id="normalMsg" class="normalMsg"><bean:write name="miscellaneousTransIgimsBean" property="strNormalMsg" /></div>
</center>

<div class="container-fluid pt-2">
    <div class="prescriptionTile">
  			<div class="row ">
				<div class="col-sm-6" style="text-align: initial;">
					<p class="subHeaders">

						<i class="fas fa-file-alt iround"
							style="font-size: 20px; color: #28a745" title="Cancel"></i>
						&nbsp; Miscellaneous Consumption IGIMS Report
					</p>
				</div>
				<div class="col-sm-6" id="">
					<div class="legend2" id='nonPrintableLegend2'>
						<button type="button" class="float-right btn btn-danger mt-1 btn-circle cancelbtn" onclick="cancelFunc();">
							<i class="fas fa-times iround" title="Cancel"></i>
						</button>
						
						<button type="button" class=" btn btn-secondary btn-circle" style="background: #2196f3; border-color: #b9b9b9; margin-top: 0.25rem !important;" onclick="controlToMainPage();">
							<!-- <img src="/HIS/hisglobal/images/clear3.png" title="Clear" style="width: 23px; color: #fff;"> -->
							<i class="fas fa-broom  iround" title="Clear"></i>
						</button>
					</div>
				</div>
			</div>

 	<div class="container">
		 	<div class="row my-1">
		  		<div class="col-md-2 ">
					<label><font color="red">*</font>Store Name</label>
		  		</div>
		  		<div class="col-md-4 ">
		  		<div id="storeComboID">
		         	<select name="strStoreName" id="" class="browser-default custom-select" onchange="">
						<bean:write name="miscellaneousTransIgimsBean" property="strStoreName" filter="false" />
					</select>
		        </div>
		        <div id="storeComboNameID" style="display:none; color:blue;"></div>
		        </div>
		  		
		  		<div class="col-md-2"><font color="red">*</font><label>CR No.</label></div>
	 		     <div class="col-md-4">
	 		    	  <div id="ItemCatgViewId" >
       						<input type="text" class="form-control" name="strItemCatgCombo"	onkeypress="return validateData(event,18) && validateNumeric(event);" value="10811" maxlength="15">
			          </div>  
			          <div id="itemCategViewNameID" style="display: none"></div>
	          	 </div>
		    </div>
		    
		    <div class="row my-1">
				<div class="col-md-2 "><font color="red">*</font><label>From Date</label></div>
				<div class="col-md-4">
					<input  name="strFromDate" class="form-control datepicker" value="${miscellaneousTransIgimsBean.strFromDate}" style="color: rgba(113, 111, 111, 0.87);"> 
				</div>
				
		  		<div class="col-md-2"><font color="red">*</font><label>To Date</label></div>
		       	<div class="col-md-4">
		       		<input  name="strToDate" class="form-control datepicker" value="${miscellaneousTransIgimsBean.strToDate}" style="color: rgba(113, 111, 111, 0.87);">    	
		       	</div>
		    </div> 
			 <hr>
			<div class="row ">
				<div class="col-sm-12" align="center"> <a class="btn btn-sm btn-success" href="#" onclick="getViewItemDtl();" style="font-size:1rem;">GO <i class="fas fa-angle-double-right"></i></a></div>
			</div>
		</div>
		
		
		<div class="row ">
	 		<div class="col-md-12 px-4" align="center">
	 			<div id="breakageItemDtlId" align="center" style="display: none"></div>
	 		</div>
		</div>
 			 
 			<input type="hidden" name="hmode"/>
		    <input type="hidden" name="strCurrentDate" value="${miscellaneousTransIgimsBean.strCurrentDate}"/>
		    
		    <div id="blanket" style="display:none;"></div>
		    <div class="popUpDiv" id="popUpDiv1" style="display:none;">
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