	function onActionChange(e)
	{
		if($(e).val() == '2')
		{
			$(e).closest('tr').find('input[name=isChecked]').removeAttr('checked');
			$(e).closest('tr').find('input').attr('disabled','true');
		}
		else
		{ 
			$(e).closest('tr').find('input[name=isChecked]').attr('checked','');
			$(e).closest('tr').find('input').removeAttr('disabled','true');
		}
	}
	function onTaxChange(e)
	{
		if($(e).closest('tr').next().is('.batchDtlRow'))
		{
			updateBulkPoBatchRow($(e).closest('tr').next().find('table tbody tr:first-child input[name=qty]'));
		}
	}
	function onEnter(e,evnt,str)
	{
		if($(e).val().trim().length==11)
		{
			//alert('2');
			document.forms[0].hmode.value="NEWCHLRECITEMDTL";
			document.forms[0].submit();
		}
		else if(evnt.which == 13)
		{
			return Swal.fire({ 
				  type: 'info',
				  title: 'Please enter valid PO !!!',
				  showConfirmButton: false,
				  timer: 2500,
				  animation: false,
  				  customClass: 'animated tada'
				});
		}
		//eval(str);
	} 
	function isNumber(evt)
	{	 
	   var charCode = evt.which; 
	   console.log(charCode);
	   if (charCode > 32 && (charCode < 48 || charCode > 57)) {
	      return false;
	    } 
	    return true;
	} 
	function isNumberRate(evt)
	{	 
	   var charCode = evt.which; 
	   console.log(charCode);
	   if (charCode > 32 && (charCode < 45 || charCode > 57)) {
	      return false;
	    } 
	    return true;
	}
	function checkAllRow(e){
		if($(e).is(':checked'))
			$(e).closest('table').find('tbody tr').each(function(){$(this).find('input[name=isChecked]').attr('checked','true');});
		else
			$(e).closest('table').find('tbody tr').each(function(){$(this).find('input[name=isChecked]').removeAttr('checked');});
	}
	function changePoType(){
		if ($('input[name=challanOpt]:checked').val()=='1') {
			$('.localPoNoInputView').hide();
			$('.onLocalPoEnterView').hide();
			$('.bulkPoNoInputView').show();
		}
		else{
			$('.bulkPoNoInputView').hide();
			$('.onBulkPoEnterView').hide();
			$('.localPoNoInputView').show();
		}
	} 
	function onEnterPoNo(){
		if ($('input[name=challanOpt]:checked').val()=='1') {
			$('.onBulkPoEnterView').show(); 
			$('.onLocalPoEnterView').hide();
		}
		else{
			$('.onLocalPoEnterView').show();
			$('.onBulkPoEnterView').hide(); 
		}
	}
	function onEnterLocalPoNo(){
		if($('.onLocalPoEnterView').is(':hidden'))
		$('.onLocalPoEnterView').show();
		$('.onBulkPoEnterView').hide(); 
	}
	function onEnterBulkPoNo(){
		if($('.onBulkPoEnterView').is(':hidden'))
		$('.onBulkPoEnterView').show(); 
		$('.onLocalPoEnterView').hide();
	}
	function addDrugDtl(e){ 
		if($('.drugDtlRow:visible'))
		{
			var isEmpty = 0;
			$('.drugDtlRow:visible').find(' input[type=text]').each(function(){
				if($(this).val()=='')
				{
					isEmpty = 1;
				}
			});
			if(isEmpty==0)
			{
				$('.drugDtlRow:visible').prev().css('background-color','#b5f3b8');
				$('.drugDtlRow:visible').hide(); 
			} 
			else
			{ 
				$('.drugDtlRow:visible').prev().css('background-color','#ffcec1');
				$('.drugDtlRow:visible').hide(); 
			}
			if($(e).closest('tr').next().hasClass('drugDtlRow'))
				$(e).closest('tr').next().show();
		} 

		var tmpStr='';
		for (var i = 0; i < 4; i++) {
			tmpStr+=`<tr class="localPoBatchItem${i} middleParentRow">
						<td><input type="checkbox" name="isChecked" checked></td>
						<td>Ethionamide Eto ${i+1}</td>
						<td><input type="text" class="form-control" name="altRemarks" placeholder="Remarks"></td> 
						<td><input type="text" class="form-control" name="mrpRate" placeholder="MRP" style="max-width:80px;"></td>
						<td class="orderQty">45</td>
						<td class="pndQty">45</td>
						<td class="netPurAmt">0.00</td>
						<td><input type="text" class="form-control" name="strBatch" placeholder="Batch No"></td>
						<td><input type="text" class="form-control" name="reqQty" onkeypress="return isLocalPoQtyNumeric(this,event);" onblur="updateLocalPoDrugRow(this,event)" placeholder="Quantity" style="max-width:80px;"></td>
						<td><input type="date" class="form-control" name="strExpDate" value="2019-09-20"></td>
						<td><input type="date" class="form-control" name="strMfgDate" value="2019-09-20"></td>
						<td>
							<select class="form-control" name="stractionRNI">
								<option>I</option>
								<option>R</option>
								<option>N</option>
							</select>
						</td>
						<td><a class="btn btn-link" href="javascript:;" onclick="addDrugDtlRow(this); $(this).hide()"><i class="fa fa-plus"></i></a></td> 
					</tr>`; //setCurrentDate()  or  new Date('2019-01-05').toDateString().substring(4) 
				}
		var str = `	<tr class="drugDtlRow info" style="font-size:12px;">
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
														<th>Alternatives Remarks</th> 
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
													${tmpStr} 
												</tbody>
											</table>
										</div>
									</div>
								</div>
							</td>
						</tr>`;
		if(! $(e).closest('tr').next().hasClass('drugDtlRow'))
			$(e).closest('tr').after(str);
		//$('form').sisyphus( {timeout: 5 } );
	}
	var subDrugDtlRowCount = 0;
	function addDrugDtlRow(e){
		var chkVal = $(e).closest('tr').find('input[name=isChecked]').val();
		var strMRP = $(e).closest('tr').find('input[name=strMRP]').val();
		
		var tmpStr = `<tr class="${$(e).closest('tr').attr('class').split(' ')[0]}SubRow warning">
						<td><input type="checkbox" name="isChecked" value="${chkVal}" checked></td>
						<td></td> 
						<td><input type="text" class="form-control" name="strMRP"  onkeypress="return isNumberRate(event);" placeholder="MRP" style="max-width:80px;" value="${strMRP}" readonly="true"></td> 
						<td></td>
						<td></td>
						<td></td>
						<td><input type="text" class="form-control" name="strBatch" placeholder="Batch No"></td>
						<td><input type="text" class="form-control" name="strAcceptedQty" onkeypress="return isLocalPoQtyNumeric(this,event);" onblur="updateLocalPoDrugRow(this,event)" placeholder="Quantity" style="max-width:80px;"></td> 
						<td><input type="text" class="form-control itemExpDtInputSub${subDrugDtlRowCount}" name="strExpDate"></td>
						<td><input type="text" class="form-control itemMfcDtInputSub${subDrugDtlRowCount}" name="strMfgDate"></td>
						<td>
							<select class="form-control" name="stractionRNI" onchange="onActionChange(this);">
								<option value="1">I</option>
								<option value="2">R</option>
								<option value="3">N</option>
							</select>
						</td>
						<td>
							<a class="btn btn-link" href="javascript:;" onclick="removeDrugDtlLstRow(this)"><i class="fa fa-minus"></i></a>
							<a class="btn btn-link" href="javascript:;" onclick="addDrugDtlRow(this)"><i class="fa fa-plus"></i></a>
						</td> 
					</tr>`;
		//$(e).find('i').removeClass('fa-plus').addClass('fa-minus');
		//$(e).attr('onclick','removeDrugDtlRow(this)');
		
		$(e).closest('tr').after(tmpStr);
		//$('form').sisyphus( {timeout: 5 } ); 
	  	var monArr = ['Jan','Feb','Mar','Apr','May','Jun','Jul','Aug','Sep','Oct','Nov','Dec'];
	  	var dateSumObj = new Date();
	     $('.itemExpDtInputSub'+subDrugDtlRowCount).datepicker({
	         format: 'dd-mmm-yyyy',
	         uiLibrary: 'bootstrap',
	         value: (dateSumObj.getDate() + 1)+'-'+monArr[dateSumObj.getMonth()]+'-'+dateSumObj.getFullYear(),
	              });
	     $('.itemMfcDtInputSub'+subDrugDtlRowCount).datepicker({
	         format: 'dd-mmm-yyyy',
	         uiLibrary: 'bootstrap',
	         value: (dateSumObj.getDate() - 1)+'-'+monArr[dateSumObj.getMonth()]+'-'+dateSumObj.getFullYear(),
	              }); 
	 		$('.itemExpDtInputSub'+subDrugDtlRowCount).attr('min',(dateSumObj.getDate() + 1)+'-'+monArr[dateSumObj.getMonth()]+'-'+dateSumObj.getFullYear());
			$('.itemMfcDtInputSub'+subDrugDtlRowCount).attr('max',(dateSumObj.getDate() - 1)+'-'+monArr[dateSumObj.getMonth()]+'-'+dateSumObj.getFullYear()); 

			$(e).prev().attr('onclick','removeDrugDtlRow(this);');
			$(e).remove();
			subDrugDtlRowCount++;
	}
	function removeDrugDtlRow(e){
		$(e).closest('tr').remove();
	}
	function removeDrugDtlLstRow(e){ 
		$(e).closest('tr').prev().find('td').last().append('<a class="btn btn-link" href="javascript:;" onclick="addDrugDtlRow(this)"><i class="fa fa-plus"></i></a>');
		$(e).closest('tr').remove();
	}
	
	function isLocalPoQtyNumeric(e,evnt){
		if (evnt.chacode == 13 || evnt.which == 13) {
			updateLocalPoDrugRow(e);
		}
		return isNumber(evnt);
	} 
	function updateLocalPoDrugRow(e){
		var orderQty = 0;
		var rcvQty = 0;
		var pndQty = 0;
		var rcRate = 0.00;
		var netAmt = 0.00; 
		var parentItemRow = $(e).closest('tr').attr('class').split(' ')[0];
		if(parentItemRow.includes('SubRow'))
			parentItemRow = parentItemRow.split('SubRow')[0];
		orderQty = Number($(e).closest('tbody').find('[class*='+parentItemRow+']').children('td.orderQty').text().trim());   
		rcRate = Number($(e).closest('tbody').find('tr.'+parentItemRow).children('td').children('input[name=strMRP]').val());   
		$(e).closest('tbody').find('[class*='+parentItemRow+']').each(function(i){
			//console.log($(this).find('input[name=reqQty]').val());
			rcvQty += Number(($(this).find('input[name=strAcceptedQty]').val() =="" || $(this).find('input[name=strAcceptedQty]').val() == null)?"0":$(this).find('input[name=strAcceptedQty]').val());
		});
		//rcvQty += Number($(e).val());
		pndQty = orderQty - rcvQty;
		netAmt = calNetAmtLocalPo(rcRate,rcvQty);
		console.log('rcvQty::>>>'+rcvQty);
		if(rcvQty<=orderQty)
		{  
			$(e).closest('tbody').find('[class*='+parentItemRow+']').children('td.pndQty').text(pndQty); 
			$(e).closest('tbody').find('[class*='+parentItemRow+']').children('td.netPurAmt').text(netAmt);  
			//$(e).closest('tr.drugDtlRow').prev().children('td.netAmt').text(netAmt);
			//var myMstJSON = ConvertFormToJSON($('form[name=onLocalPoEnterView]'));
			//console.log(myMstJSON);
		}
		else
		{
			/*Swal.fire('Max Qty. of '+$(e).closest('tbody').find('[class*='+parentItemRow+']').children('td').eq(1).text()+' to be Received is '+orderQty);*/
			Swal.fire({ 
				  type: 'info',
				  title: 'Max Qty. allowed is '+orderQty,
				  showConfirmButton: false,
				  timer: 2000,
				  animation: false,
  				  customClass: 'animated tada'
				});
			$(e).closest('tbody').find('[class*='+parentItemRow+']').last().find('input[name=strAcceptedQty]').val('');
		}
	} 
	function calNetAmtLocalPo(rcRate,rcvQty){ 
		var netAmt = 0.00; 
		var discountVal = 0.00; 
		discountVal = Number($('.onLocalPoEnterView .discountVal').text().trim().split(' ')[0]);
		netAmt += rcRate * rcvQty;
		netAmt -= (discountVal * netAmt) / 100;  
		console.log('netAmt:::>>> '+netAmt);
		return netAmt.toFixed(2);
	}



	function addBatchDtl(e){ 
		if($('.batchDtlRow:visible'))
		{
			$('.batchDtlRow:visible').hide(); 
			if($(e).closest('tr').next().hasClass('batchDtlRow'))
				$(e).closest('tr').next().show();
		}  
		var str = `	<tr class="batchDtlRow info" style="font-size:12px;">
							<td colspan="10">
								<div class="row">
									<div class="col-sm-12"> 
										<div class="table-responsive">
											<table class="table table-condensed">
												<thead>
													<tr> 
														<th>Batch</th>
														<th>Exp. Date</th>
														<th>Mfg. Date</th>
														<th>MRP/Unit</th>
														<th>Pur Rate/Unit</th>
														<th>Qty</th>
														<th colspan="2">Free Qty</th> 
													</tr>
												</thead>
												<tbody>
													<tr> 
														<td><input type="text" class="form-control" value="123456" name="batchNo"></td> 
														<td><input type="date" class="form-control" name="strExpDate" value="2019-09-20"></td> 
														<td><input type="date" class="form-control" name="strMfgDate" value="2019-09-20"></td> 
														<td><input type="text" class="form-control" value="40.00" name="mrpRate"></td> 
														<td><input type="text" class="form-control" value="40.00" name="purRate"></td> 
														<td><input type="text" class="form-control" value="0" name="qty" onkeypress="return isQtyNumeric(this,event);" onblur="updateBulkPoBatchRow(this,event)"></td> 
														<td><input type="text" class="form-control" value="" name="freeQty"></td> 
														<td><a class="btn btn-link" href="javascript:;" onclick="addNewBatch(this)"><i class="fa fa-plus"></i></a></td> 
													</tr>
												</tbody>
											</table>
										</div>
									</div>
								</div>
							</td>
						</tr>`;
		if(! $(e).closest('tr').next().hasClass('batchDtlRow'))
			$(e).closest('tr').after(str); 
	} 
	function addNewBatch(e)
	{
		var tmpStr = `<tr> 
						<td><input type="text" class="form-control" value="123456" name="batchNo"></td> 
						<td><input type="date" class="form-control" name="strExpDate" value="2019-09-20"></td> 
						<td><input type="date" class="form-control" name="strMfgDate" value="2019-09-20"></td> 
						<td><input type="text" class="form-control" value="40.00" name="mrpRate"></td> 
						<td><input type="text" class="form-control" value="40.00" name="purRate"></td> 
						<td><input type="text" class="form-control" value="0" name="qty" onkeypress="return isQtyNumeric(this,event);" onblur="updateBulkPoBatchRow(this,event)"></td> 
						<td><input type="text" class="form-control" value="" name="freeQty"></td> 
						<td><a class="btn btn-link" href="javascript:;" onclick="addNewBatch(this)"><i class="fa fa-plus"></i></a></td> 
					</tr>`;
		$(e).find('i').removeClass('fa-plus').addClass('fa-minus');
		$(e).attr('onclick','removeNewBatch(this)');
		$(e).closest('tbody').append(tmpStr);
	} 
	function removeNewBatch(e){
		$(e).closest('tr').remove();
	}
	function setCurrentDate()
	{
		var today = new Date(); 
    	return today.getFullYear() + '-' + ('0' + (today.getMonth() + 1)).slice(-2) + '-' + ('0' + today.getDate()).slice(-2);
	} 
	function taxTypeChange(e){
		if($(e).val()==1)
		{
			$('.gstType1').hide();
			$('.gstType2').show();
		}
		else{ 
			$('.gstType2').hide();
			$('.gstType1').show();
		}
	}
	function isQtyNumeric(e,evnt){
		if (evnt.chacode == 13 || evnt.which == 13) {
			updateBulkPoBatchRow(e);
		}
		return isNumber(evnt);
	}
	function updateBulkPoBatchRow(e){
		var orderQty = 0;
		var rcvQty = 0;
		var pndQty = 0;
		var netAmt = 0.00; 
		orderQty = Number($(e).closest('tr.batchDtlRow').prev().children('td.orderQty').text().trim()); 
		$(e).closest('tbody').find('tr').each(function(i){
			rcvQty += Number($(this).find('input[name=qty]').val());
		});
		pndQty = orderQty - rcvQty;
		netAmt = calNetAmtBulkPo(e,rcvQty);
		console.log('rcvQty::>>>'+rcvQty);
		if(rcvQty<=orderQty)
		{ 
			$(e).closest('tr.batchDtlRow').prev().children('td.rcdQty').children('a').text(rcvQty);
			$(e).closest('tr.batchDtlRow').prev().children('td.pndQty').text(pndQty);
			$(e).closest('tr.batchDtlRow').prev().children('td.netAmt').text(netAmt);
		}
		else
			alert('Max Qty. to be Received is '+orderQty);
	} 
	function calNetAmtBulkPo(e,rcvQty){ 
		var netAmt = 0.00;
		var rcRate = 0.00;
		var totalTax = 0.00;
		rcRate = Number($(e).closest('tr.batchDtlRow').prev().children('td.rcRate').text().trim());
		console.log('rcRate:::>>> '+Number($(e).closest('tr.batchDtlRow').prev().children('td.rcRate').text().trim()));
		console.log('rcRate:::>>> '+rcRate);
		if($('select[name=taxType]').val()==2)
		{
			var currentRow = $(e).closest('tr.batchDtlRow').prev();
			totalTax += Number($(currentRow).find('input[name=gst1Input]').eq(0).val().trim().split(' ')[0]);
			totalTax += Number($(currentRow).find('input[name=gst1Input]').eq(1).val().trim().split(' ')[0]);
		}
		else 
		{
			totalTax += Number($(e).closest('tr.batchDtlRow').prev().children('input[name=gst2Input]').val().trim().split(' ')[0]);
		}
		netAmt += rcRate * rcvQty;
		netAmt += (totalTax * netAmt) / 100;  
		console.log('netAmt:::>>> '+netAmt);
		return netAmt.toFixed(2);
	}
	function updateTaxInput(e)
	{
		$(e).closest('tr').find('input[name=gst1Input]').val($(e).val());
	}
	function ConvertFormToJSON(form){
	    var array = jQuery(form).serializeArray();
	    var json = {};
	    
	    jQuery.each(array, function(i) {
	        json[this.name] = this.value || ''; 
	    });
	    
	    return json;
	}
	$(document).ready(function(){
		// $('form').sisyphus( {timeout: 5 } );

		 tippy('.rcdQtyHoverToolTip', {
		     content: 'Click to fill details',
		     delay: 100,
		     arrow: true,
		     arrowType: 'round',
		     size: 'large',
		     duration: 500,
		     animation: 'scale'
		 }); 
		 
		 
		if($('input[name=strIsOpenFlg]').val() == "1")
		{
			onEnterPoNo(); 
		}
	});

	var finalJsonObj = {};

				
				$('.ipdIssueDeskEntryFrmTbl tbody tr').each(function(){
					var crNo = $(this).find('input[name=crNo]').val();
					var ward = $(this).find('input[name=ward]').val();
					var indentNo = $(this).find('input[name=indentNo]').val();
					var medicine = $(this).find('input[name=medicine]').val();
					var batchNo = $(this).find('input[name=batchNo]').val();
					var issueQty = $(this).find('input[name=issueQty]').val();
					var lpQty = $(this).find('input[name=lpQty]').val();
					var ratePerUnit = $(this).find('input[name=ratePerUnit]').val();
					var cost = $(this).find('input[name=cost]').val();
					var strChk = $('input[name=chk]').val();  
					var hospCode = $('input[name=strHospitalCode]').val(); 
					var seatId = $('input[name=seatId]').val();  
					var strRequestTypeId = $('input[name=strRequestTypeId]').val();  
					var strStoreId = $('input[name=strStoreId]').val();  
					var strRequestDate = $('input[name=strRequestDate]').val();  
					var strLpRequestNo = $('input[name=strLpRequestNo]').val();  
					var strItemCategNo = $('input[name=strItemCategNo]').val();  
					var strRaisingReqTypeId = $('input[name=strRaisingReqTypeId]').val();  
					var strRaisingStoreId = $('input[name=strRaisingStoreId]').val();  
					var strStoreName = $('input[name=strStoreName]').val();  
					var strBillPaidCat = $('input[name=strBillPaidCat]').val();  
					var strSCMIntegrationflg = $('input[name=strSCMIntegrationflg]').val();  
					
					finalJsonObj.crNo = crNo;
					finalJsonObj.ward = ward;
					finalJsonObj.indentNo = indentNo;
					finalJsonObj.medicine = medicine;
					finalJsonObj.batchNo = batchNo;
					finalJsonObj.issueQty = issueQty;
					finalJsonObj.lpQty = lpQty;
					finalJsonObj.ratePerUnit = ratePerUnit;
					finalJsonObj.cost = cost;
					finalJsonObj.strChk = strChk;
					finalJsonObj.hospCode = hospCode;
					finalJsonObj.hospCode = hospCode;
					finalJsonObj.seatId = seatId;
					finalJsonObj.strRequestTypeId = strRequestTypeId;
					finalJsonObj.strStoreId = strStoreId;
					finalJsonObj.strRequestDate = strRequestDate;
					finalJsonObj.strLpRequestNo = strLpRequestNo;
					finalJsonObj.strItemCategNo = strItemCategNo;
					finalJsonObj.strRaisingReqTypeId = strRaisingReqTypeId;
					finalJsonObj.strRaisingStoreId = strRaisingStoreId;
					finalJsonObj.strStoreName = strStoreName;
					finalJsonObj.strBillPaidCat = strBillPaidCat;
					finalJsonObj.strSCMIntegrationflg = strSCMIntegrationflg;
					console.log(finalJsonObj);
				});
				
				
				
				function saveForm(e){
					
					if($('select[name=strReceivedBy]').val() == '0')
						return Swal.fire({ 
							  type: 'info',
							  title: 'Select Received By !!',
							  showConfirmButton: false,
							  timer: 2000,
							  animation: false,
			  				  customClass: 'animated tada'
							});
					if($('input[name=strSupplierReceiptNo]').val().trim() == '')
						return Swal.fire({ 
							  type: 'info',
							  title: 'Enter CD No !!',
							  showConfirmButton: false,
							  timer: 2000,
							  animation: false,
			  				  customClass: 'animated tada'
							});
					if($('.lpoMainTable tbody input[name=isChecked]:checked').length <= 0)
						return Swal.fire({ 
							  type: 'info',
							  title: 'Atleast One row should be checked !!',
							  showConfirmButton: false,
							  timer: 2000,
							  animation: false,
			  				  customClass: 'animated tada'
							});
						
					var isEmpty = 0;
					$('.drugDtlRow table tbody tr').has('input[name=isChecked]:checked').find(' input[type=text]').each(function(){
						if($(this).val()=='')
						{
							isEmpty = 1;
						}
					});
					if(isEmpty==0)
					{
						if($('.lpoMainTable tbody input[name=strBatch]').filter(function(){
							return $(this).val() == '0';
						}).length > 0)
						{
							Swal.fire({ 
								  type: 'info',
								  title: 'Batch No. should not be 0 !!',
								  showConfirmButton: false,
								  timer: 2000,
								  animation: false,
				  				  customClass: 'animated tada'
								});
						}
						else
						{
							$('input[name=hmode]').val('insertLP');
							$('form[name=newchallanProcessBean]').submit();
						}
					} 
					else
					{ 
						Swal.fire({ 
							  type: 'info',
							  title: 'fill each field !!',
							  showConfirmButton: false,
							  timer: 2000,
							  animation: false,
			  				  customClass: 'animated tada'
							});
					}
				}
				
				function closePage(mode){
					document.forms[0].hmode.value = mode;
					document.forms[0].submit();
				}