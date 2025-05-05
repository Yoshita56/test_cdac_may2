<!DOCTYPE html>
<%@page import="java.util.*"%>
<%@page import="org.apache.commons.collections.*"%>
<%@page import="org.apache.commons.collections.map.MultiValueMap"%>
<%@page import="com.google.common.collect.LinkedHashMultimap"%>

<html>
<head>
	<title>LPO</title>
	<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
	<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
	<%@ taglib uri="/WEB-INF/hisTab.tld" prefix="tag"%>
	<%@taglib uri="/WEB-INF/dateTag.tld" prefix="dateTag"%>
	<%@ taglib uri="/WEB-INF/comboPersistence.tld" prefix="cmbPers"%>

	<meta charset="utf-8">
  	<meta name="viewport" content="width=device-width, initial-scale=1">
  	<link rel="stylesheet" href="/HBIMS/mms/fontawesome/css/fontawesome.min.css">
  	<link rel="stylesheet" href="/HBIMS/mms/fontawesome/css/all.min.css">
  	<link rel="stylesheet" href="/HBIMS/mms/bootstrap/css/bootstrap.min.css">
  	<script src="../../hisglobal/jquery/3.6.0.min.js"></script>
  	
  	<script src="/HBIMS/mms/assets/swal/sweetalert2.all.min.js"></script>
  	<link rel="stylesheet" type="text/css" href="/HBIMS/mms/assets/swal/sweetalert2.min.css">
  	<link rel="stylesheet" type="text/css" href="/HBIMS/mms/assets/animate/animate.css">
  	<script type="text/javascript" src="assets/sisyphus.min.js"></script>
    <script src="/HBIMS/mms/assets/popper/popper.min.js"></script>
	<script src="/HBIMS/mms/assets/tippy/tippy.all.min.js"></script>
	<script src="/HBIMS/mms/js/newLpChlRev.js"></script>
	
	<link rel="stylesheet" href="/HIS/hisglobal/drDeskAssets/gijgo/css/gijgo.min.css">
	<script src="/HIS/hisglobal/drDeskAssets/gijgo/js/gijgo.min.js"></script>
	
  	<style>  
  		body{
  			background-color: #e6e6e6;
  		}
  		.poContainer{
  			margin-top: 10px;
  			background-color: #fff;
  			box-shadow: 0 0 15px -5px #787878;
  		}
  		.onLocalPoEnterView input.form-control{
  			height: 28px;
  		}
  		.onLocalPoEnterView select.form-control{
  			height: 28px;
  		}
  		input[type="date"].form-control{
  			line-height: 16px;
  		}
  		.drugDtlRow input.form-control{
  			height: 28px;
  			max-width: 130px;
  		} 
  		.batchDtlRow input.form-control{
  			height: 28px;
  		} 
  		.gstType2{
  			display: none;
  		}
  	</style>
</head>
<body>
<html:form name="newchallanProcessBean"
	action="/transactions/NewChallanProcessTransCNT"
	type="mms.transactions.controller.fb.NewChallanProcessTransFB">
<div class="container-fluid poContainer">
	<div class="row">
		<div class="col-sm-12">
			<h4>LPO</h4>
		</div>
	</div>
	<div class="row text-uppercase">
		<div class="col-sm-6">
			<div class="col-xs-4 text-right">
				<label for="storeName">Store Name:</label>
			</div>
			<div class="col-xs-8">
			<bean:write name="newchallanProcessBean" property="strStoreName"/>
				<!-- <select class="form-control" id="storeName">
			    	<option>Store 1</option>
			    	<option>Store 2</option>
			    </select> -->
			</div> 
		</div>
		<div class="clearfix visible-xs"></div>
		<div class="col-sm-6">
			<div class="col-xs-4 text-right">
				<label for="categoryName">Item Category:</label>
			</div>
			<div class="col-xs-8">
			<bean:write name="newchallanProcessBean" property="strItemCategoryName"/>
				<!-- <select class="form-control" id="categoryName">
			    	<option>Drug</option>
			    	<option>Item</option>
			    </select> -->
			</div>  
		</div>
	</div>
	<br>
	<div class="row text-center text-uppercase">
		<div class="col-xs-4 col-sm-2 text-right">
			<label>PO Type :</label>
		</div> 
		<div class="col-xs-4 col-sm-2 text-left">
			<label class="radio-inline"><input style="display:none;" type="radio" name="challanOpt" value="2" onchange="changePoType()" checked>Local PO</label>
		</div> 
		<div class="col-xs-4 col-sm-2">
			<label class="radio-inline" style="display:none"><input type="radio" name="challanOpt" value="1" onchange="changePoType()">Bulk PO</label>
		</div>
		<div class="clearfix visible-xs"></div>
		<div class="col-xs-4 col-sm-2 text-right">
			<label>Enter PO No :</label>
		</div> 
		<div class="col-xs-8 col-sm-3">
			<input type="text" class="form-control" name="strPoNo" maxlength="11" minlength="11" placeholder="Enter LPO No" onkeypress="return isNumber(event)" onkeyup="return onEnter(this,event,'onEnterPoNo()')" autocomplete="off" required>
		</div> 
	</div>
<!-- 	<br>
	<div class="row localPoNoInputView">
		<div class="col-xs-4 col-sm-3 text-right">
			<label>Local PO No :</label>
		</div>
		<div class="col-xs-8 col-sm-9">
			<input type="text" class="form-control" name="localPoNo" maxlength="11" minlength="11" placeholder="Enter Local PO No" onkeypress="return isNumber(event)" onkeyup="return onEnter(this,event,'onEnterLocalPoNo()')">
		</div>
	</div>
	<div class="row bulkPoNoInputView" style="display: none;">
		<div class="col-xs-4 col-sm-3 text-right">
			<label>Bulk PO No :</label>
		</div>
		<div class="col-xs-8 col-sm-9">
			<input type="text" class="form-control" name="bulkPoNo" maxlength="11" minlength="11" placeholder="Enter Bulk PO No" onkeypress="return isNumber(event)" onkeyup="return onEnter(this,event,'onEnterBulkPoNo()')">
		</div>
	</div> -->
	<hr> 
	<div class="onLocalPoEnterView" style="display: none;">
		<div class="row">
			<div class="col-sm-6">
				<div class="col-xs-6 text-right">
					<b>Purchase Order No : </b>
				</div>
				<div class="col-xs-6">
					<font><bean:write name="newchallanProcessBean" property="strPoNoDisplay"/></font>
				</div> 
			</div>
			<div class="clearfix visible-xs"></div>
			<div class="col-sm-6">
				<div class="col-xs-6 text-right">
					<b>Purchase Order Dt :</b>
				</div>
				<div class="col-xs-6">
					<font><bean:write name="newchallanProcessBean" property="strPoDate"/></font>
				</div>  
			</div>
		</div>
		<!-- <div class="row">
			<div class="col-sm-6">
				<div class="col-xs-6 text-right">
					<b>MRN No :</b>
				</div>
				<div class="col-xs-6">
					<font></font>
				</div>   
			</div>
			<div class="clearfix visible-xs"></div>
			<div class="col-sm-6">
				<div class="col-xs-6 text-right">
					<b>MRN Dt :</b>
				</div>
				<div class="col-xs-6">
					<font>04/01/2018</font>
				</div>    
			</div>
		</div> -->
		<div class="row">
			<div class="col-sm-6">
				<div class="col-xs-6 text-right">
					<b>Entry Dt : </b>
				</div>
				<div class="col-xs-6">
					<font>04/01/2019</font>
				</div> 
			</div>
			<div class="clearfix visible-xs"></div>
			<div class="col-sm-6">
				<div class="col-xs-6 text-right">
					<b>VND Name :</b>
				</div>
				<div class="col-xs-6">
					<font><bean:write name="newchallanProcessBean" property="strSupplierName"/></font>
				</div>  
			</div>
		</div>
		<!-- <div class="row">
			<div class="col-sm-6">
				<div class="col-xs-6 text-right">
					<b>VND CD : </b>
				</div>
				<div class="col-xs-6">
					<font></font>
				</div> 
			</div>
			<div class="clearfix visible-xs"></div>
			<div class="col-sm-6">
				<div class="col-xs-6 text-right">
					<b>Order Amt :</b>
				</div>
				<div class="col-xs-6">
					<font></font>
				</div>  
			</div>
		</div> -->
		<div class="row">
			<div class="col-sm-6">
				<div class="col-xs-6 text-right">
					<b>CD No : </b>
				</div>
				<div class="col-xs-6 col-sm-4">
					<font><input type="text" name="strSupplierReceiptNo" class="form-control" placeholder="Enter CD No." required></font>
				</div> 
			</div>
			<div class="clearfix visible-xs"></div>
			<div class="col-sm-6">
				<div class="col-xs-6 text-right">
					<b>DC Dt :</b>
				</div>
				<div class="col-xs-6 col-sm-4">
					<font><input id="dcDateInput" type="text" name="strSupplierReceiptDate" class="form-control currentDate" required></font>
				</div>  
			</div>
		</div> 
		<div class="row">
			<div class="col-sm-6">
				<div class="col-xs-6 text-right">
					<b>RCD Store CD : </b>
				</div>
				<div class="col-xs-6">
					<font>MEDSTR</font>
				</div> 
			</div>
			<div class="clearfix visible-xs"></div>
			<div class="col-sm-6">
				<div class="col-xs-6 text-right">
					<b>DC Received By :</b>
				</div>
				<div class="col-xs-6">
					<font>
						<select name="strReceivedBy" class="comboMax form-control">    <!-- onchange="checkValCombo(this);" -->
			               	<bean:write name="newchallanProcessBean" property="strReceivedByOptionVal" filter="false"/>
			            </select>
					</font>
				</div>  
			</div>
		</div>
		<div class="row">
			<div class="col-sm-6">
				<div class="col-xs-6 text-right">
					<b>Supplier Discount : </b>
				</div>
				<div class="col-xs-6">
					<font class="discountVal">20 %</font>
				</div> 
			</div>
			<div class="col-sm-6"> 
			</div>
		</div>
		<!-- <div class="row">
			<div class="col-sm-6">
				<div class="col-xs-6 text-right">
					<b>Receiving Store Name : </b>
				</div>
				<div class="col-xs-6">
					<font>Main Store</font>
				</div> 
			</div>
			<div class="col-sm-6">
				<div class="col-xs-6 text-right">
					<b>Item Category :</b>
				</div>
				<div class="col-xs-6">
					<font>Drug</font>
				</div>  
			</div>
		</div>
		<div class="row">
			<div class="col-sm-6">
				<div class="col-xs-6 text-right">
					<b>LPO No :</b>
				</div>
				<div class="col-xs-6">
					<font>/10211800002</font>
				</div>   
			</div>
			<div class="col-sm-6">
				<div class="col-xs-6 text-right">
					<b>LPO Date :</b>
				</div>
				<div class="col-xs-6">
					<font>10-Aug-2018</font>
				</div>    
			</div>
		</div>
		<div class="row">
			<div class="col-sm-6">
				<div class="col-xs-6 text-right">
					<b>Supplier Name : </b>
				</div>
				<div class="col-xs-6">
					<font>Abboti Pvt Ltd</font>
				</div> 
			</div>
			<div class="col-sm-6">
				<div class="col-xs-6 text-right">
					<b>Supplier Discount (%) :</b>
				</div>
				<div class="col-xs-6">
					<font>20 %</font>
				</div>  
			</div>
		</div>
		<div class="row">
			<div class="col-sm-6">
				<div class="col-xs-6 text-right">
					<b>Challan/Invoice No : </b>
				</div>
				<div class="col-xs-6 col-sm-4">
					<input type="text" class="form-control" name="challanInvoiceNo">
				</div> 
			</div>
			<div class="col-sm-6">
				<div class="col-xs-6 text-right">
					<b>Challan/Invoice Date :</b>
				</div>
				<div class="col-xs-6 col-sm-4">
					<input type="date" class="form-control" name="challanInvoiceDate">
				</div>  
			</div>
		</div>  -->
		<hr>
		<div class="row">
			<div class="col-sm-12"> 
				<div class="table-responsive" style="overflow-x:hidden">
					<table class="table table-striped table-hover lpoMainTable">
						<thead>
							<tr>
								<th>S.No.</th>
								<th>CRN</th>
								<th></th>
								<th></th>
								<th>Action</th> 
							</tr>
						</thead>
						<tbody>
						<%
						LinkedHashMultimap<String, List> itemDtls= (LinkedHashMultimap) request.getSession().getAttribute("CHALITEMDTL");
						ArrayList<String> list=null;
						 List<String> list1=null;
						 
						 Set<List<String>> set=null;
	                   	if(itemDtls != null)
	                   	{
	                   		//System.out.println("itemDtls\n"+itemDtls);
		                  if(itemDtls.size() > 0)
		                  {  
		                	  int len=0;
		                	  String patDtls=null;
		                	  //itemDtls.get
		                	  
		                	  Set<String> keys = itemDtls.keySet();
		                   	 for (String key : keys) {
		                   	
		                   		len ++;
		                   		list=new  ArrayList<String>();
		                   		 String CrNo= key;
		                   		
		                   		 %>
		                   		  <tr>
								
									<td><%=len%>.</td>
									<td><%=CrNo%></td>
									 <td></td>
									<td></td> 
									<td><a href="javascript:;" onclick="addDrugDtl(this);">Receive Items</a></td> 
									
								</tr> 
								<tr class="drugDtlRow info" style="font-size:12px;display: none;">
							<td colspan="5">
								<div class="row">
									<div class="col-sm-12">
										<p class="text-center"><b>Drug Details</b></p> 
										<div class="table-responsive">
											<table class="table table-condensed">
												<thead>
													<tr>
														<th><input type="checkbox" name="checkAllRows" onchange="checkAllRow(this)"></th>
														<th>Medicine</th>
														<!-- <th>Alternatives Remarks</th> --> 
														<th>MRP/Unit</th>
														<th>Order Qty</th>
														<th>Pnd Qty</th>
														<th>Net Pur Amt</th>
														<th>Batch No.</th>
														<th>Rec. Qty</th>
														<th>Expiry Date.</th>
														<th>Mfg. Date.</th>
														<th colspan="2">Action (R,N,I)</th>
													</tr>
												</thead>
												<tbody>
		                   		 <%
		                   		//itemDtls.
		                   			
			 					set =new HashSet<List<String>>();
			 					set = (Set)itemDtls.get(key);
			 					
			 					
			 	           		Iterator value = set.iterator(); 
			 	            	
				 	           	String itemName=null;
	                  			 String purQty=null;
	                  			 String hiddenValue=null;
	                  			 String strItemId=null;
	                  			 String strBrandId=null;
	                  			 String strlpReqNo=null;
	                  			String strlpQty=null;
	                  			String OrderQty=null;
	                  			int  tempCount=0;
	                  			int j=0;
	                  			list1=new  ArrayList<String>();
	                  			//System.out.println("Set Size:::::::::::"+set.size());
	                  			 //list1 = (List)value.next();                                                                                                                                                                                                                                                                                                                                                                                   
			 	           	while (value.hasNext()) { 
			 	           		list1 = (List)value.next();   
			 	                 //System.out.println("list1\n"+list1); 
			 	                
			 	                //System.out.println(list1);
			 	                                                                                                                                                                                                                                                                                                                       
			 	                	j++;                                                                                                                                       
			 	                	 //System.out.println(list1.get(j)); 
			 	                	
			 	                	patDtls=(String)	list1.get(4);
		                   			itemName=(String)	list1.get(2);
		                   			purQty=(String)	list1.get(3);
		                   			strlpReqNo=(String)	list1.get(0);
		                   			strBrandId=(String)	list1.get(1);
		                   			strItemId=(String)	list1.get(6);
		                   			OrderQty=(String)	list1.get(3);
		                   			hiddenValue=CrNo+"#"+strlpReqNo+"#"+strItemId+"#"+strBrandId+"#"+OrderQty+"#"+patDtls.split("\\^")[5]+"#"+patDtls.split("\\^")[6]+"#"+patDtls.split("\\^")[7]+"^"+patDtls.split("\\^")[1]+"^"+patDtls.split("\\^")[4]+"^"+patDtls.split("\\^")[8];
		                   			//System.out.println("patDtls"+patDtls);
			 	           
		                   	 %>
		                       
		    			
													<tr class="localPoBatchItem<%=j %> middleParentRow">
														<td><input type="checkbox" name="isChecked" value=<%=hiddenValue%> checked></td>
														<td><%=itemName %></td>
														<!-- <td><input type="text" class="form-control" name="altRemarks" placeholder="Remarks"></td> --> 
														<td><input type="text" class="form-control" name="strMRP" onkeypress="return isNumberRate(event);"  placeholder="MRP" style="max-width:80px;"></td>
														<td class="orderQty"><%=purQty %></td>
														<td class="pndQty"><%=purQty %></td>
														<td class="netPurAmt">0.00</td>
														<td><input type="text" class="form-control" name="strBatch" placeholder="Batch No"></td>
														<td><input type="text" class="form-control" name="strAcceptedQty"   onkeypress="return isLocalPoQtyNumeric(this,event);" onblur="updateLocalPoDrugRow(this,event)" placeholder="Quantity" style="max-width:80px;"></td>
														<td><input type="text" class="form-control itemExpDtInput itemExpDtInput<%=len %><%=j %>" name="strExpDate" value=""></td>
														<td><input type="text" class="form-control itemMfcDtInput itemMfcDtInput<%=len %><%=j %>" name="strMfgDate" value=""></td>
														<td>
															<select class="form-control" name="stractionRNI" onchange="onActionChange(this);">
																<option value="1" >I</option>
																<option value="2" >R</option>
																<option value="3" >N</option>
															</select>
														</td>
														<td><a class="btn btn-link" href="javascript:;" onclick="addDrugDtlRow(this); $(this).hide()"><i class="fa fa-plus"></i></a></td> 
													</tr> 
		                   
		                   		 
		                   		 <%
		                   		 
		                   		 
			 	                 
			 	                 
			 	           	}
			 	           		%>
			 	           		</tbody>
											</table>
										</div>
									</div>
								</div>
							</td>
						</tr> 
			 	           		<%
			 	           	}
		                   }
		                  }else{
		                   		%>
		                   		<tr>
		                   		<td colspan="5" class="text-danger text-center">No Record Found / Please enter correct PO number</td>
		                   		</tr>
		                   		<%
		                   	}
		                   	%>
							
							<!-- <tr>
								<td>2.</td>
								<td>331019299393343</td>
								<td>Patient Name</td>
								<td>ICU</td>
								<td><a href="javascript:;" onclick="addDrugDtl(this);">Receive Items</a></td> 
							</tr>
							<tr>
								<td>3.</td>
								<td>331019299393343</td>
								<td>Patient Name</td>
								<td>ICU</td>
								<td><a href="javascript:;" onclick="addDrugDtl(this);">Receive Items</a></td> 
							</tr>  -->
						</tbody>
					</table>
				</div>
			</div>
		</div>
		<div class="row">
			<div class="col-sm-6 text-center">
				<button type="button" class="btn btn-danger" onclick="closePage('LIST')">Cancel</button>
			</div>
			<div class="col-sm-6 text-center">
				<button type="button" class="btn btn-success" onclick="saveForm(this)">Save</button>
			</div>
		</div>
	</div>  
	
	<div class="onBulkPoEnterView" style="display: none;">
		<div class="row">
			<div class="col-sm-6">
				<div class="col-xs-6 text-right">
					<b>Purchase Order No : </b>
				</div>
				<div class="col-xs-6">
					<font><bean:write name="newchallanProcessBean" property="strPoNoDisplay"/></font>
				</div> 
			</div>
			<div class="clearfix visible-xs"></div>
			<div class="col-sm-6">
				<div class="col-xs-6 text-right">
					<b>Purchase Order Dt :</b>
				</div>
				<div class="col-xs-6">
					<font></font>
				</div>  
			</div>
		</div>
<!-- 		<div class="row">
			<div class="col-sm-6">
				<div class="col-xs-6 text-right">
					<b>MRN No :</b>
				</div>
				<div class="col-xs-6">
					<font></font>
				</div>   
			</div>
			<div class="clearfix visible-xs"></div>
			<div class="col-sm-6">
				<div class="col-xs-6 text-right">
					<b>MRN Dt :</b>
				</div>
				<div class="col-xs-6">
					<font>04/01/2018</font>
				</div>    
			</div>
		</div> -->
		<div class="row">
			<div class="col-sm-6">
				<div class="col-xs-6 text-right">
					<b>VND CD : </b>
				</div>
				<div class="col-xs-6">
					<font></font>
				</div> 
			</div>
			<div class="clearfix visible-xs"></div>
			<div class="col-sm-6">
				<div class="col-xs-6 text-right">
					<b>VND Name :</b>
				</div>
				<div class="col-xs-6">
					<font></font>
				</div>  
			</div>
		</div>
		<div class="row">
			<div class="col-sm-6">
				<div class="col-xs-6 text-right">
					<b>Entry Dt : </b>
				</div>
				<div class="col-xs-6">
					<font>04/01/2019</font>
				</div> 
			</div>
			<div class="clearfix visible-xs"></div>
			<div class="col-sm-6">
				<div class="col-xs-6 text-right">
					<b>Order Amt :</b>
				</div>
				<div class="col-xs-6">
					<font></font>
				</div>  
			</div>
		</div>
		<div class="row">
			<div class="col-sm-6">
				<div class="col-xs-6 text-right">
					<b>CD No : </b>
				</div>
				<div class="col-xs-6 col-sm-4">
					<font></font>
				</div> 
			</div>
			<div class="clearfix visible-xs"></div>
			<div class="col-sm-6">
				<div class="col-xs-6 text-right">
					<b>DC Dt :</b>
				</div>
				<div class="col-xs-6 col-sm-4">
					<font>04/01/2019</font>
				</div>  
			</div>
		</div> 
		<div class="row">
			<div class="col-sm-6">
				<div class="col-xs-6 text-right">
					<b>RCD Store CD : </b>
				</div>
				<div class="col-xs-6">
					<font>MEDSTR</font>
				</div> 
			</div>
			<div class="clearfix visible-xs"></div>
			<div class="col-sm-6">
				<div class="col-xs-6 text-right">
					<b>DC Received By :</b>
				</div>
				<div class="col-xs-6">
					<font></font>
				</div>  
			</div>
		</div>
		<div class="row">
			<div class="col-sm-6">
				<div class="col-xs-6 text-right">
					<b>Select Tax Type : </b>
				</div>
				<div class="col-xs-6 col-sm-5 col-md-4">
					<select name="taxType" id="taxType" class="form-control" onchange="taxTypeChange(this)">
						<option value="2">CGST+SGST</option>
						<option value="1">GST</option>
					</select>
				</div> 
			</div>
			<div class="col-sm-6">  
			</div>
		</div>
		<hr>
		<div class="row">
			<div class="col-sm-12"> 
				<div class="table-responsive">
					<table class="table table-striped table-hover">
						<thead>
							<tr>
								<th>Item Name</th>
								<th>Item Cd</th>
								<th>Type</th>
								<th>RC Rate/Unit</th>
								<th class="gstType1">Tax % CGST</th>
								<th class="gstType1">Tax % SGST</th>
								<th class="gstType2">Tax % GST</th>
								<th>Order Qty</th>
								<th>Rcd Qty</th>
								<th>Pnd Qty</th
>								<th>Net Pur Rate</th>
							</tr>
						</thead>
						<tbody>
							
						</tbody>
					</table>
				</div>
			</div>
		</div>
	</div> 
</div>
<script>
	$(document).ready(function(){
		var dates = document.querySelectorAll('.currentDate');
		for(var i=0;i<dates.length;i++)
		{
			document.querySelectorAll('.currentDate')[i].valueAsDate = new Date();
		}  
	});
</script>
 <script>
  	var monArr = ['Jan','Feb','Mar','Apr','May','Jun','Jul','Aug','Sep','Oct','Nov','Dec'];
  	var dateSumObj = new Date();
     $('#dcDateInput').datepicker({
          format: 'dd-mmm-yyyy',
          uiLibrary: 'bootstrap',
          value: dateSumObj.getDate()+'-'+monArr[dateSumObj.getMonth()]+'-'+dateSumObj.getFullYear(),
               }); 
     $('.itemExpDtInput').each(function(i,n){
    	 $(n).datepicker({
             format: 'dd-mmm-yyyy',
             uiLibrary: 'bootstrap',
             value: (dateSumObj.getDate() + 1)+'-'+monArr[dateSumObj.getMonth()]+'-'+dateSumObj.getFullYear(),
                  }); 
         });   
      $('.itemMfcDtInput').each(function(i,n){ 
             $(n).datepicker({
                 format: 'dd-mmm-yyyy',
                 uiLibrary: 'bootstrap',
                 value: (dateSumObj.getDate() - 1)+'-'+monArr[dateSumObj.getMonth()]+'-'+dateSumObj.getFullYear(),
                      });
             }); 

     $(document).ready(function(){
 		$('.itemExpDtInput').attr('min',(dateSumObj.getDate() + 1)+'-'+monArr[dateSumObj.getMonth()]+'-'+dateSumObj.getFullYear());
		$('.itemMfcDtInput').attr('max',(dateSumObj.getDate() - 1)+'-'+monArr[dateSumObj.getMonth()]+'-'+dateSumObj.getFullYear());
         });
     
 </script>
</body>
	<input type="hidden" name="strStoreId"		value="${newchallanProcessBean.strStoreId}" />

	<input type="hidden" name="strItemCategoryId"		value="${newchallanProcessBean.strItemCategoryId}" />


	<input type="hidden" name="strPoDate"		value="${newchallanProcessBean.strPoDate}" />		
		
	<input type="hidden" name="strPourchaseOrderDate"	value="${newchallanProcessBean.strPoDate}" />

	<input type="hidden" name="strPoStoreId"		value="${newchallanProcessBean.strPoStoreId}" />

	<input type="hidden" name="strPoTypeId"		value="${newchallanProcessBean.strPoTypeId}" />

	<input type="hidden" name="strPurchaseSourceId" 	value="${newchallanProcessBean.strPurchaseSourceId}" />

	<input type="hidden" name="strSupplierId"		value="${newchallanProcessBean.strSupplierId}" />

	<input type="hidden" name="strCtDate"	value="${newchallanProcessBean.strCtDate}"/>

	<input type="hidden" name="strPuk" value="${newchallanProcessBean.strPuk}"/>
	
	<input type="hidden" name="strStoreName1" value="${newchallanProcessBean.strStoreName1}"/>
	
   <input type="hidden" name="strItemCatName1" value="${newchallanProcessBean.strItemCatName1}"/>
	

	<input type="hidden" name="strEmployeeNo" value="${newchallanProcessBean.strEmployeeNo}"/>
	<input type="hidden" name="strChallanCount" value="${newchallanProcessBean.strChallanCount}"/>
	<input type="hidden" name="strchkvalue" value="${newchallanProcessBean.strchkvalue}"/>
	<input type="hidden" name="strIsOpenFlg" value="${newchallanProcessBean.strIsOpenFlg}"/>
	<input type="hidden" name="strPoNo" value="${newchallanProcessBean.strPoNo}"/>	
	<input type="hidden" name="strPoNo1" value="${newchallanProcessBean.strPoNo1}"/>
	<input type="hidden" name="strOtherDeliveryModeFlg" />
	<input type="hidden" name="strOtherDeliveryModeTxtValue" />


	<input type="hidden" name="hmode" />
	</html:form>
</html>