<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic"%>
<%@ taglib uri="/WEB-INF/dateTag.tld" prefix="date"%>
<%@ taglib uri="/WEB-INF/hisTab.tld" prefix="tag"%>

<%@ taglib uri="/WEB-INF/crNo.tld" prefix="crNo"%>

<%@ page import="java.io.*" %>
<%@ page import ="java.util.*,java.text.*" %>
<%@ page import ="hisglobal.config.*,hisglobal.vo.*" %>


<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1.0">

<link href="../../hisglobal/bootstrap4.0_newgui/css/bootstrap.css" rel="stylesheet" />
<link href="../../hisglobal/bootstrap4.0_newgui/css/bootstrap-theme.css" rel="stylesheet" />
 <link href="../../hisglobal/bootstrap4.0_newgui/datatable/css/dataTables.bootstrap.css" rel="stylesheet" /> 
 <link href="../../hisglobal/bootstrap4.0_newgui/font-awesome/css/all.css" rel="stylesheet">
 <link href="../../hisglobal/bootstrap4.0_newgui/swAl/swal.css" rel="stylesheet">
 <link href="../../ipd/css/newlayout.css" rel="stylesheet" type="text/css">
 

<script type="text/javascript" src="../../hisglobal/jquery/3.6.0.min.js"></script>



 <link href="../../hisglobal/bootstrap4.0_newgui/datatable/css/jquery.dataTables.min.css" rel="stylesheet" /> 


 <script type="text/javascript" src="../../hisglobal/bootstrap4.0_newgui/swAl/swal.js"></script>
 <script type="text/javascript" src="../../hisglobal/jquery/3.6.0.min.js"></script>
 <script type="text/javascript" src="../../hisglobal/bootstrap4.0_newgui/datatable/js/jquery.dataTables.js"></script>
 <script type="text/javascript" src="../../hisglobal/bootstrap4.0_newgui/js/bootstrap.min.js"></script>
 <script type="text/javascript" src="../../hisglobal/bootstrap4.0_newgui/datatable/js/dataTables.bootstrap4.js"></script>
 
 
<link href="../css/transaction.css" rel="stylesheet" type="text/css">

<script src="../../hisglobal/js/validationBootstrap.js"></script>
<script src="../../hisglobal/js/util.js"></script>
<script src="../js/listPage_printDesk.js"></script>
</head>

<body onload="getDataTableOnSelection();">

<html:form action="/transactions/IssueDeskPrintTransCNT"  name="issueDeskPrintTransBean" type="mms.transactions.controller.fb.IssueDeskPrintTransFB" method="post">

<fieldset form="form1">
	
  <legend class='legendHeader' id='nonPrintableLegend'>INDENT PRINT DESK</legend>
  	<div class="legend2" id='nonPrintableLegend2'></div>
	<div  class="viewport" id="nonPrintable">
	<div class="container-fluid">
		
<div class="alert alert-danger alert-dismissible fade show" id="errMsg"  style="display:none;font-size:16px"><bean:write name="issueDeskPrintTransBean" property="strErrMsg" /></div>
<div class="alert alert-success alert-dismissible fade show" id="normalMsg" style="display:none;font-size:16px"><bean:write  name="issueDeskPrintTransBean" property="strMsg"/></div>
<div class="alert alert-warning alert-dismissible fade show"  id="warningMsg" style="display:none;font-size:16px;"><bean:write name="issueDeskPrintTransBean" property="strWarning"/></div>			  	
	
	<div class="row justify-content-center">
	<div class="col-sm-12">
				<div class="prescriptionTile">	
							
                            <div class="row" style="margin-top: 1%;">
                            
                               <div class="col-sm-3">	
								</div>	
                            
                            	<div class="col-sm-3">									
										<div class="input-group mb-3">
											  <div class="input-group-prepend">
											    <span class="input-group-text" id="basic-addon1" style='font-family: "Helvetica Neue", Helvetica, Arial, sans-serif;font-size: 14px;line-height: 1.42857143;color: #333;color: rgb(26, 26, 26);font-weight: 501;'>Store Name</span>
											  </div>
												 <select name="strStoreId" id="strStoreId" class="browser-default custom-select"  onchange="getDataTableOnSelection();" >
												    <bean:write name="issueDeskPrintTransBean" property="strStoreCombo" filter="false" />
											     </select>
										</div>
								</div>			
								
								
								<%-- <div class="col-sm-3">	
								
								        <div class="input-group mb-3">
											  <div class="input-group-prepend">
											    <span class="input-group-text" id="basic-addon1" style='font-family: "Helvetica Neue", Helvetica, Arial, sans-serif;font-size: 14px;line-height: 1.42857143;color: #333;color: rgb(26, 26, 26);font-weight: 501;'>Category</span>
											  </div>
												 <select name="strItemCategNo" id="strItemCategNo" class="browser-default custom-select" onchange="getDataTableOnSelection();" >
												    <bean:write name="issueDeskPrintTransBean" property="strStoreCombo" filter="false" />
											     </select>
										</div>								
										
								</div> --%>
								<div class="col-sm-3">	
								
								        <div class="input-group mb-3">
											  <div class="input-group-prepend">
											    <span class="input-group-text" id="basic-addon1" style='font-family: "Helvetica Neue", Helvetica, Arial, sans-serif;font-size: 14px;line-height: 1.42857143;color: #333;color: rgb(26, 26, 26);font-weight: 501;'>Request Type</span>
											  </div>
												 <select name="strRequestTypeId" id="strRequestTypeId" class="browser-default custom-select" onchange="getDataTableOnSelection();" >
												    <bean:write name="issueDeskPrintTransBean" property="strReqTypeCombo" filter="false" />
											     </select>
										</div>	
								</div>
								
								<div class="col-sm-3">									
										<div class="input-group mb-3">
											  <div class="input-group-prepend">
											    <span class="input-group-text" id="basic-addon1" style='font-family: "Helvetica Neue", Helvetica, Arial, sans-serif;font-size: 14px;line-height: 1.42857143;color: #333;color: rgb(26, 26, 26);font-weight: 501;'>Status</span>
											  </div>
										<select name="strStatusCode" id="strStatusCode" class="browser-default custom-select" onchange="getDataTableOnSelection();" >

											 <option value="1">New Request</option>
											 <option value="4">Processed</option>
																						
										</select>
										</div>
									
								</div>
										

								
							</div>	
					</div>
       
	           					
		        <div id="id1">
				</div>	 						
				
			
     	
	
	</div>
	</div>	
</div>
</div>
</fieldset>

<div class="modal fade" id="nextModal" role="dialog">
    <div class="modal-dialog modal-lg ">
    
      <!-- Modal content-->
      <div class="modal-content">
      <div class="modal-header">Indent Print Desk<button type="button" class="close" data-dismiss="modal">&times;</button></div>      
        <div class="modal-body">
        <div class="container-fluid">	

      </div>
      
    </div>
  </div>
  
  	
  	<input type="hidden" name="hmode" />
  	<input type="hidden" name="strStoreName" 	      value="${issueDeskPrintTransBean.strStoreName}" />
  	<input type="hidden" name="chk"     			  id="chk"   value="" />	
 
		
</html:form>

</body>
</html>