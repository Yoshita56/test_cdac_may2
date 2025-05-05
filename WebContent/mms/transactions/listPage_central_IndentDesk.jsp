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
<script src="../js/listPage_CenDesk.js"></script>
</head>

<body onload="getDataTableOnSelection();">

<html:form action="/transactions/IndentTransNEWCNT"  name="indentTransBean" type="mms.transactions.controller.fb.IndentTransFB" method="post">

<fieldset form="form1">
	
  <legend class='legendHeader' id='nonPrintableLegend'>INDENT DESK</legend>
  	<div class="legend2" id='nonPrintableLegend2'></div>
	<div  class="viewport" id="nonPrintable">
	<div class="container-fluid">
		
	<div class="alert alert-danger alert-dismissible fade show" id="errMsg"  style="display:none;"><bean:write name="indentTransBean" property="strErrMsg" /></div>
	<div class="alert alert-success alert-dismissible fade show" id="normalMsg" style="display:none;"><bean:write  name="indentTransBean" property="strMsg"/></div>
	<div class="alert alert-warning alert-dismissible fade show"  id="warningMsg" style="display:none;"><bean:write name="indentTransBean" property="strWarning"/></div>			  	
	<div class="row justify-content-center">
	<div class="col-sm-12">
				<div class="prescriptionTile">	
							
                            <div class="row" style="margin-top: 0%;">
                            
                                 
								                                                           
                            	 <div class="col-sm-2.5">									
										<div class="input-group mb-3">
											  <div class="input-group-prepend">
											    <span class="input-group-text" id="basic-addon1" style='font-family: "Helvetica Neue", Helvetica, Arial, sans-serif;font-size: 14px;line-height: 1.42857143;color: #333;color: rgb(26, 26, 26);font-weight: 501;'>Store Name</span>
											  </div>
												 <select name="strStoreId" id="strStoreId" class="browser-default custom-select"  onchange="getCatgCombo();" >
												    <bean:write name="indentTransBean" property="strStoreCombo" filter="false" />
											     </select>
										</div>
								</div>			
								
								
								 <div class="col-sm-4.5">	
								
								        <div class="input-group mb-3">
											  <div class="input-group-prepend">
											    <span class="input-group-text" id="basic-addon1" style='font-family: "Helvetica Neue", Helvetica, Arial, sans-serif;font-size: 14px;line-height: 1.42857143;color: #333;color: rgb(26, 26, 26);font-weight: 501;'>Category</span>
											  </div>
											  <div id="catgComboId">
											       <select name="strItemCatgNo" id="strItemCatgNo" class="browser-default custom-select" onchange="getReqTypeCombo();" >
												     <bean:write name="indentTransBean" property="strCatgCombo" filter="false" />
											       </select>
								               </div>
												
										</div>								
										
								</div> 
								<div class="col-sm-4.5">	
								
								      <div class="input-group mb-3">
											  <div class="input-group-prepend">
											    <span class="input-group-text" id="basic-addon1" style='font-family: "Helvetica Neue", Helvetica, Arial, sans-serif;font-size: 14px;line-height: 1.42857143;color: #333;color: rgb(26, 26, 26);font-weight: 501;'>Request Type</span>
											  </div>
											   <div id="reqTypeComboId">
												 <select name="strRequestTypeId" id="strRequestTypeId" class="browser-default custom-select" onchange="getDataTableOnSelection();" >
												    <option value="0^0">Select Value</option>
												    <bean:write name="indentTransBean" property="strReqTypeCombo" filter="false" />
											     </select>
											   </div>
										</div>	
								
								</div> 	
								<div class="col-sm-0.5">						
										
								        <div class="input-group mb-3">
											  <div class="input-group-prepend">
											    <span class="input-group-text" id="basic-addon1" style='font-family: "Helvetica Neue", Helvetica, Arial, sans-serif;font-size: 14px;line-height: 1.42857143;color: #333;color: rgb(26, 26, 26);font-weight: 501;'>Status</span>
											  </div>
										 <select name="strStatusCode" id="strStatusCode" class="browser-default custom-select" onchange="getDataTableOnSelection();">
											 <option value="0">Pending</option>
											 <option value="2">Partial</option>
											 <option value="1">Processed</option>	
										</select>
										</div>
								</div> 	
								<div class="col-sm-0.5">
								       
								</div>						
							</div>	
							
							<div class="row" style="margin-top: 0%;">
                            
                                                                                
                            	 <div class="col-sm-3">									
									
								</div>											
								
								 <div class="col-sm-3">	
								
								</div> 
								<div class="col-sm-3">	
								
								</div> 	
								<div class="col-sm-3">						
										 <div id="crTextBoxId1" style="display:none;">
									         <div class="input-group mb-3">
									          
												  <div class="input-group-prepend">											    
												    <span class="input-group-text" id="basic-addon1" style='font-family: "Helvetica Neue", Helvetica, Arial, sans-serif;font-size: 14px;line-height: 1.42857143;color: #333;color: rgb(26, 26, 26);font-weight: 501;'>CR</span>
												  </div>
												  <input type="text" class="form-control" name="strCrNo" id="strCrNo"  value="${indentTransBean.strHospCode}">
												  <!-- <button id="getFilterData" type="button" class="btn btn-primary" data-toggle="tooltip" data-placement="top" title="" data-original-title="Go" onclick="onGoButton();">Go</button> -->
												  <button type='button' id='getFilterData' onclick="onGoButton();" class='btn pmd-btn-fab pmd-ripple-effect btn-info pmd-btn-raised' data-placement='top' data-toggle='tooltip' title='Click Here To Generate Indent'><i class='material-icons pmd-sm' aria-hidden='true'></i> G O </button>
												
											</div>
										</div>
										 <div id="crTextBoxId2" style="display:none;">
										 
										    <div class="input-group mb-3">
									          
												  <div class="input-group-prepend">											    
												    <span class="input-group-text" id="basic-addon1" style='font-family: "Helvetica Neue", Helvetica, Arial, sans-serif;font-size: 14px;line-height: 1.42857143;color: #333;color: rgb(26, 26, 26);font-weight: 501;'> # </span>
												  </div>
												  <button type='button' id='getFilterData' onclick="onGoButton_OtherIndent();" class='btn pmd-btn-fab pmd-ripple-effect btn-info pmd-btn-raised' data-placement='top' data-toggle='tooltip' title='Click Here To Generate Indent'><i class='material-icons pmd-sm' aria-hidden='true'></i>GENERATE</button>
												
											</div>
									        
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


  	
  	<input type="hidden" name="hmode" />
  	<input type="hidden" name="strStoreName" 	      value="${indentTransBean.strStoreName}" />
  	<input type="hidden" name="strCatgName" 	      value="${indentTransBean.strCatgName}" />
  	<input type="hidden" name="strReqName" 	          value="${indentTransBean.strReqName}" />  	
  	<input type="hidden" name="chk"     			  id="chk"   value="" />
  	<input type="hidden" name="strChk"     			  id="strChk"   value="${indentTransBean.strChk}"  />	 
 
		
</html:form>

</body>
</html>