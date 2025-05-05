<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<%@ taglib uri="/WEB-INF/dateTag.tld" prefix="dateTag"%>


<script language="JavaScript" src="../../masterutil/js/master.js"></script>
<form name="multirow">
<div id="rowAdded1" style="display: none">
<table class="TABLEWIDTH" align="center" cellpadding="1px" cellspacing="0px" id="td#delIndex#">

						<input type="hidden" name="strRowIndex"            id="strRowIndex#delIndex#"        value="#delIndex#" />
						<input type="hidden" name="strMultiRowPKKey1"      id="strMultiRowPKKey1#delIndex#"  value="" />
						<input type="hidden" name="strMultiRowPKKey2"      id="strMultiRowPKKey2#delIndex#"  value="" />						
					    <input type="hidden" name="strMultiNewItemFlg"     id="strMultiNewItemFlg#delIndex#" value="1">		
					    
					    
						
  					<tr>  
						
						<td WIDTH="20%"   class="multiRPTControl">
						  <div id="strMultiRowDrugName#delIndex#" align="left"></div>						 
						</td>
						<!--  <td WIDTH="18%"   class="multiRPTControl">
						  <div id="strMultiRowProgramName#delIndex#" align="left"></div>						 
						</td>-->
						<td WIDTH="10%"   class="multiRPTControl">
						  <div id="strMultiRowBatchNo#delIndex#"></div>						  
						</td>
						<td WIDTH="10%"   class="multiRPTControl">
						  <div id="strMultiRowStockStatus#delIndex#"></div>	
						  
						</td>
						
						<td WIDTH="8%"   class="multiRPTControl">
							<div id="strMultiRowExpDate#delIndex#"></div>	
						 
						</td>
						
						<td WIDTH="10%"   class="multiRPTControl">
							<div id="strMultiRowCountedQty#delIndex#"></div>	
						 
						</td>
											
						<td WIDTH="10%"   class="multiRPTControl">
							<div id="strMultiRowRateWithUnit#delIndex#"></div>	
						 
						</td>						
						
						<td WIDTH="10%"   class="multiRPTControl">
						     <div id="strMultiRowRemarks#delIndex#"></div>						    
						</td>
						<td WIDTH="4%"   class="multiRPTControl">
						
						     <img name=""
									onkeypress="onPressingEnter(this,event)"
									src="../../hisglobal/images/minus.gif" style="cursor: pointer;"
									title="Delete Row" onclick="deleteRow('#delIndex#',1,0);">
						  
						</td>
							
						
	</tr>
</table>
</div>
<input type="hidden" name="rowIndex1" value="0"> <input
	type="hidden" name="rowLength1" value="0"></form>