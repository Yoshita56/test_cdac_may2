	 	hotkeys('ctrl+a,ctrl+s', function(event,handler) {
		  switch(handler.key){
		    case "ctrl+a":$('.ipdIssueEntryAddBtn').click(); event.preventDefault(); break;  
		    case "ctrl+s":$('.issueSaveBtn').click(); event.preventDefault(); break;  
		  }
		});
		$(document).ready(function(){    
			
			/*getPatDtlAjx($('input[name=strCrNo]').val());
			getPatAdmDtlAjx($('input[name=strCrNo]').val(),$('input[name=strHospitalCode]').val());
			$('input[name=crNo]').on('input', function(){ 
				var crNo = $(this).val(); 
				if($('#crNoDataLst option').filter(function(){
		 		   return $(this).val() === crNo;        
		 		  }).length)
		 		{
		 			console.log($('#crNoDataLst option[value='+crNo+']').attr('id'));
		 			var crNoId = $('#crNoDataLst option[value='+crNo+']').attr('id');
					var currentRow = $(this).closest('tr');
					$('.patientName').text(crNoId.split('#')[1]);
					$('.admNo').text(crNoId.split('#')[2]);
					currentRow.find('input[name=ward]').val(crNoId.split('#')[3]);
					currentRow.find('input[name=indentNo]').val(crNoId.split('#')[4]); 
		 		}
		 		else
		 		{
					var currentRow = $(this).closest('tr');
					currentRow.find('input[name=ward]').val('');
					currentRow.find('input[name=indentNo]').val(''); 
		 		} 
			});*/
	 
			if(sessionStorage.getItem('ipdIssueEntryObj') && false)
			{ 
				var ObjItem = JSON.parse(sessionStorage.getItem('ipdIssueEntryObj').toString()); 
				var str;
				for(var i=0;i<ObjItem.data.length;i++)
				{ 
					/*str += 
						"<tr>
							<td><input type="text" class="form-control" list="crNoDataLst" name="crNo" placeholder="CRN" value="${ObjItem.data[i].crNo}" style="min-width: 146px" maxlength="15" onkeypress="return isNumber(event)"></td>
							<td><input type="text" class="form-control" name="ward" placeholder="Dept-Ward" value="${ObjItem.data[i].ward}" style="min-width: 180px;"></td>
							<td style="display:none;"><input type="text" class="form-control" name="indentNo" placeholder="Indent No" value="${ObjItem.data[i].indentNo.substr(0,3)+Number(ObjItem.data[i].indentNo.substr(4,3))+1}"></td>
							<td style="min-width: 250px;"> 
								<input type="text" class="form-control" name="medicine" placeholder="Medicine" onfocus="updateFooter(this);" autocomplete="off" value="${ObjItem.data[i].medicine}">
							</td>
							<td>
								<select class="form-control" name="batchNo" onchange="updateFooter(this);setRate(this);" > 
								</select>
							</td>
							<td>
								<input type="text" class="form-control" name="issueQty" placeholder="IssueQty" onkeypress="return isNumber(event)" onkeyup="return validateIssueQty(this);" style="max-width: 100px" value="${ObjItem.data[i].issueQty}"  onblur="updateCost(this)" onkeypress="return isNumberQtyCst(this,event)">								
							</td>
							<td>
								<input type="text" class="form-control" name="lpQty" placeholder="lP Qty" onkeypress="return isNumber(event)" value="${ObjItem.data[i].lpQty}" style="max-width: 100px" onkeypress="return isNumberQtyCst(this,event)">
							</td>
							<td>
								<input type="text" class="form-control" name="ratePerUnit" placeholder="Rate" style="max-width: 100px" readonly="true"> 
							</td>
							<td>
								<input type="text" class="form-control" name="cost" placeholder="cost" style="max-width: 100px" value="${ObjItem.data[i].cost}" onkeypress="return isNumber(event)" readonly="true">
							</td>
							<td>
								<button type="button" class="btn btn-xs btn-info ipdIssueEntryAddBtn" onclick="removeNewEntryRow(this)"><i class="fa fa-minus"></i></button>
							</td>
							<input type="hidden" name="strNewItemId">
							<input type="hidden" name="strNewBrandId"> 
						</tr>
					`; 
					//<input type="text" class="form-control" name="batchNo" list="drugBatchList" placeholder="BatchNo" onblur="setRate(this)" value="${ObjItem.data[i].batchNo}" autocomplete='off'>
					

//					<td><input type="text" class="form-control" name="indentNo" placeholder="Indent No" value="${ObjItem.data[i].indentNo}"></td>
					
					/*<td><input type="text" class="form-control" name="diagnosis" placeholder="Diagnosis" value=""></td>*/
					
					/*var currentRow = $('.ipdIssueDeskEntryFrmTbl tbody tr').eq(i);
					currentRow.find('input[name=crNo]').val(ObjItem.data[i].crNo);
					currentRow.find('input[name=ward]').val(ObjItem.data[i].ward);
					currentRow.find('input[name=indentNo]').val(ObjItem.data[i].indentNo);
					currentRow.find('input[name=diagnosis]').val(ObjItem.data[i].diagnosis);
					currentRow.find('input[name=medicine]').val(ObjItem.data[i].medicine);
					currentRow.find('input[name=batchNo]').val(ObjItem.data[i].batchNo);
					currentRow.find('input[name=issueQty]').val(ObjItem.data[i].issueQty);
					currentRow.find('input[name=lpQty]').val(ObjItem.data[i].lpQty);
					currentRow.find('input[name=cost]').val(ObjItem.data[i].cost);*/
				}
				$('.ipdIssueDeskEntryFrmTbl tbody').prepend(str);
				/*$('input[name=diagnosis]').flexdatalist({
				     minLength: 1,
				     focusFirstResult: true,
				     maxShownResults: 50,
				     searchIn: 'diagnosisName', 
				   	 data: 'http://10.226.21.120:8088/HISDRDESK/services/restful/DrDesk/diagnosisList'
				 }); */
				$('input[name=medicine]').flexdatalist({
				     minLength: 1,
				     focusFirstResult: true,
				     maxShownResults: 50,
				     searchIn: 'drugName', 
				   	 data: '/INVMGM/services/restful/DrugList/drugList?storeId='+$('input[name=strStoreId]').val()+'&hospCode='+$('input[name=strHospitalCode]').val()+'&seatId='+$('input[name=strSeatId]').val()
				 }); 

				$('input[name=medicine].flexdatalist').on('select:flexdatalist', function(event, set, options) {
					$(this).attr('drugId',set.drugId+'#'+(set.drugQuan==""?"0":set.drugQuan));   
					$(this).attr('batchRate',set.batchesAndRates=="@"?"":set.batchesAndRates);    
					$(this).attr('brandId',set.brandId);   
					$(this).closest('tr').find('input[name=ratePerUnit]').val(set.batchesAndRates.split('@')[1].split(',')[0]);   
					$(this).closest('tr').find('input[name=strNewItemId]').val(set.drugId);   
					$(this).closest('tr').find('input[name=strNewBrandId]').val(set.brandId);    
					$(this).closest('tr').find('select[name=batchNo]').empty();
					for(var i=0;i<set.batchesAndRates.split('@')[0].split(',').length;i++)
					{
						//$('#drugBatchList').append('<option id="'+set.batchesAndRates.split('@')[1].split(',')[i]+'" value="'+set.batchesAndRates.split('@')[0].split(',')[i]+'"></option>');
						$(this).closest('tr').find('select[name=batchNo]').append('<option id="'+set.batchesAndRates.split('@')[1].split(',')[i]+'@'+set.batchesAndRates.split('@')[2].split(',')[i]+'" value="'+set.batchesAndRates.split('@')[0].split(',')[i]+'">'+set.batchesAndRates.split('@')[0].split(',')[i]+'</option>');
					}
					$('tfoot .drugTypeAvl').text(set.batchesAndRates.split('@')[2].split(',')[0]);     
				});
			}  
		});
	
			function addNewEntryRow(e){
					var currentRow = $(e).closest('tr');
					let crNo = currentRow.find('input[name=crNo]').val();
					let ward = currentRow.find('input[name=ward]').val();
					let indentNo = currentRow.find('input[name=indentNo]').val();
					/*let diagnosis = currentRow.find('input[name=diagnosis]').val();*/
					let medicine = currentRow.find('input[name=medicine]').val();
					let batchNo = currentRow.find('select[name=batchNo]').val();
					let issueQty = currentRow.find('input[name=issueQty]').val();
					let lpQty = currentRow.find('input[name=lpQty]').val();
					let cost = currentRow.find('input[name=cost]').val(); 
					let batchLength = currentRow.find('select[name=batchNo] option'); 
				if(crNo!='' && ward!='' && medicine !='' && batchNo!='' && (issueQty!='0' || lpQty!='0') && cost!='' && (batchLength.length > 0))
				{
					if($(e).closest('tr').find('.ipdIssueEntryRemoveBtn'))
						$(e).closest('tr').find('.ipdIssueEntryRemoveBtn').remove();
					
					var str = `*/
						<tr>
							<td><input type="text" class="form-control" list="crNoDataLst" name="crNo" placeholder="CRN" style="min-width: 146px" maxlength="15" onkeypress="return isNumber(event)" value="${crNo}" readonly="true"></td>
							<td><input type="text" class="form-control" name="ward" placeholder="Dept-Ward" value="${ward}" readonly="true"></td>
							<td style="display:none;"><input type="text" class="form-control" name="indentNo" placeholder="Indent No" value="${indentNo.substr(0,3)+Number(indentNo.substr(4,3))+1}" style="min-width: 180px;"></td>
							<td style="min-width: 250px;">
								<input type="text" class="form-control" name="medicine" placeholder="Medicine" onfocus="updateFooter(this);" autocomplete="off">
							</td>
							<td>
								<select class="form-control" name="batchNo" onchange="updateFooter(this);setRate(this);" > 
								</select> 
							</td>
							<td>
								<input type="text" class="form-control" name="issueQty" placeholder="IssueQty" onkeypress="return isNumber(event)" onkeyup="return validateIssueQty(this);" style="max-width: 100px" value="0">
							</td>
							<td> 
								<input type="text" class="form-control" name="lpQty" placeholder="lP Qty" onkeypress="return isNumber(event)" value="0" style="max-width: 100px">
							</td>
							<td>
								<input type="text" class="form-control" name="ratePerUnit" placeholder="Rate" style="max-width: 100px" readonly="true">
							</td>
							<td>
								<input type="text" class="form-control" name="cost" placeholder="cost" style="max-width: 100px" value="0.00" onkeypress="return isNumber(event)" readonly="true">
							</td>
							<td>
								<button type="button" class="btn btn-xs btn-info ipdIssueEntryRemoveBtn" onclick="removeCurrentEntryRow(this)"><i class="fa fa-minus"></i></button>
								<button type="button" class="btn btn-xs btn-info ipdIssueEntryAddBtn" onclick="addNewEntryRow(this)"><i class="fa fa-plus"></i></button>
							</td>
							<input type="hidden" name="strNewItemId">
							<input type="hidden" name="strNewBrandId">
						</tr>
					`; 
					/*<input type="text" class="form-control" name="batchNo" list="drugBatchList" placeholder="BatchNo" onblur="setRate(this)" autocomplete='off'>
					  <td><input type="text" class="form-control" name="diagnosis" placeholder="Diagnosis" value=""></td>*/
					$(e).closest('tr').find('input[name=crNo]').attr('readonly','true');
					$(e).closest('tr').find('.ipdIssueEntryAddBtn').toggleClass('ipdIssueEntryAddBtn ipdIssueEntryRemoveBtn').attr('onclick','removeCurrentEntryRow(this)').find('i').toggleClass('fa-plus fa-minus');
					$(e).closest('tbody').append(str); 
					$('.drugItemCount').text((Number($('.drugItemCount').text())+1)); 
					
					/*$('input[name=diagnosis]').flexdatalist({
					     minLength: 1,
					     focusFirstResult: true,
					     maxShownResults: 50,
					     searchIn: 'diagnosisName', 
					   	 data: 'http://10.226.21.120:8088/HISDRDESK/services/restful/DrDesk/diagnosisList'
					 }); */
					$(e).closest('tbody').find('tr:last-child input[name=medicine]').flexdatalist({
					     minLength: 1,
					     focusFirstResult: true,
					     maxShownResults: 50,
					     searchIn: 'drugName',
					     /*visibleProperties: ["drugName","drugCpaCode","drugTypeName"],  */ 
					   	 data: '/INVMGM/services/restful/DrugList/drugList?storeId='+$('input[name=strStoreId]').val()
					 });  

					$(e).closest('tbody').find('tr:last-child input[name=medicine].flexdatalist').on('select:flexdatalist', function(event, set, options) {
						$(this).attr('drugId',set.drugId+'#'+(set.drugQuan==""?"0":set.drugQuan));   
						$(this).attr('batchRate',set.batchesAndRates=="@"?"":set.batchesAndRates);    
						$(this).attr('brandId',set.brandId);   
						$(this).closest('tr').find('input[name=ratePerUnit]').val(set.batchesAndRates.split('@')[1].split(',')[0]);   
						$(this).closest('tr').find('input[name=strNewItemId]').val(set.drugId);   
						$(this).closest('tr').find('input[name=strNewBrandId]').val(set.brandId);    
						$(this).closest('tr').find('select[name=batchNo]').empty();
						for(var i=0;i<set.batchesAndRates.split('@')[0].split(',').length;i++)
						{
							//$('#drugBatchList').append('<option id="'+set.batchesAndRates.split('@')[1].split(',')[i]+'" value="'+set.batchesAndRates.split('@')[0].split(',')[i]+'"></option>');
							$(this).closest('tr').find('select[name=batchNo]').append('<option id="'+set.batchesAndRates.split('@')[1].split(',')[i]+'@'+set.batchesAndRates.split('@')[2].split(',')[i]+'" value="'+set.batchesAndRates.split('@')[0].split(',')[i]+'">'+set.batchesAndRates.split('@')[0].split(',')[i]+'</option>');
						}
						$('tfoot .drugTypeAvl').text(set.batchesAndRates.split('@')[2].split(',')[0]);  
					});
					var jsonObj = {
						"crNo":crNo,
						"ward":ward,
						"indentNo":indentNo, 
						"medicine":medicine,
						"batchNo":batchNo,
						"issueQty":issueQty,
						"lpQty":lpQty,
						"cost":cost
					};
					console.log(jsonObj);
					if(sessionStorage.getItem('ipdIssueEntryObj'))
					{ 
						var ObjItem = JSON.parse(sessionStorage.getItem('ipdIssueEntryObj').toString()); 
						ObjItem.data.push(jsonObj); 
						sessionStorage.setItem('ipdIssueEntryObj',JSON.stringify(ObjItem).toString());
					}
					else
					{
						console.log(sessionStorage.getItem('ipdIssueEntryObj'));
						sessionStorage.setItem('ipdIssueEntryObj',JSON.stringify(JSON.parse('{ "data":['+JSON.stringify(jsonObj)+']}')));
					}
				}
				else
				{
					swal ( "Warning" ,  "Kindly fill each field" ,  "warning" );  
				}
			}
			function removeCurrentEntryRow(e){
				if($(e).closest('tr').find('.ipdIssueEntryAddBtn').length>0)
				{
					$(e).closest('tr').prev().find('td').eq(9).append('<button type="button" class="btn btn-xs btn-info ipdIssueEntryAddBtn" onclick="addNewEntryRow(this)"><i class="fa fa-plus"></i></button>');
				} 
				$(e).closest('tr').remove(); 
				$('.drugItemCount').text((Number($('.drugItemCount').text())-1)); 
				if($('.ipdIssueDeskEntryFrmTbl tbody').find('tr').length == 1)
				{
					$('.ipdIssueDeskEntryFrmTbl tbody tr input[name=crNo]').removeAttr('readonly');
				}
			}
			function isNumber(evt)
			{	 
			   var charCode = evt.which; 
			   if (charCode > 32 && (charCode < 48 || charCode > 57)) {
			      return false;
			    } 
			    return true;
			}
			function isNumberQtyCst(e,evnt)
			{	 
				   var charCode = evnt.which; 
				   console.log(charCode);
				   if (charCode == 13) {
					   updateCost(e);
				      return false;
				    } 
				   else if (charCode > 32 && (charCode < 46 || charCode > 57)) {
					  return false;
					}  
				    return true;
			}
			function filterDrugDataList(e){ 
				/* if($(e).val().length > 2)
				{ 
					$.ajax({
						url:"http://10.226.21.120:8088/HISDRDESK/services/restful/DrDesk/drugList",
						async: true,
						type:'GET',
						success:function(result){ 
							$('#medicineDataList').empty(); 
							result = jQuery.grep(result, function( n, i ) {
							  return ( n.drugName.toUpperCase().includes($(e).val().toUpperCase()) );
							});
							for(var i=0;i<(result.length>100 ? 100:result.length);i++)
							{
								$('#medicineDataList').append('<option id="'+result[i].drugId+'" value="'+result[i].drugName+'">');
							}
						}
					});
				} */
			}
			function filterDiagnosisDataList(e){ 
				/* if($(e).val().length > 2)
				{ 
					$.ajax({
						url:"http://10.226.21.120:8088/HISDRDESK/services/restful/DrDesk/diagnosisList",
						async: true,
						type:'GET',
						success:function(result){ 
							$('#diagnosisDataList').empty(); 
							result = jQuery.grep(result, function( n, i ) {
							  return ( n.diagnosisName.toUpperCase().includes($(e).val().toUpperCase()) );
							});
							for(var i=0;i<(result.length>100 ? 100:result.length);i++)
							{
								$('#diagnosisDataList').append('<option id="'+result[i].icdCode+'" value="'+result[i].diagnosisName+'">');
							}
						}
					});
				} */
			}
			function getPatDtlAjx(crNo){ 
				var jsonRs = {};
				$.ajax({
					url:"/INVMGM/mms/transactions/LPIssueDeskTransCNT.cnt?hmode=PATDTLSERVICE&crno="+crNo+"",
					async:false,
					type:'GET',
					success:function(result){   
						jsonRs = result;
					}
				});
				return jsonRs;
			}
			function getPatAdmDtlAjx(crNo,hosp){ 
				var jsonRs = {};
				$.ajax({
					url:"/INVMGM/mms/transactions/LPIssueDeskTransCNT.cnt?hmode=PATADMDTLSERVICE&crno="+crNo+"&hospCode="+hosp,
					async:false,
					type:'GET',
					success:function(result){  
						$('.ipdIssueDeskEntryFrmTbl input[name=ward]').val(result.strDeptName+'/'+result.strWardName);
						jsonRs = result;
					}
				});
				return jsonRs;
			} 
			
			function cancelToDesk()
			{
				document.forms[0].hmode.value="RETURNTOMAINDESK";
				document.forms[0].submit();
			}
			
			function updateCost(e)
			{
				var qty = $(e).closest('tr').find('input[name=issueQty]').val();	
				var rate = $(e).closest('tr').find('input[name=ratePerUnit]').val();	
				var cost = Number(qty) * Number(rate);
				if(Number($('.patAcBal').text()) < cost && (cost != 0))
				{
					//$(e).closest('tr').find('input[name=issueQty]').val('0'); 
					/*swal ( "Oops" ,  "Insufficient A/c Balance !!" ,  "info" ).then((value) => {
						$(e).closest('tr').find('input[name=issueQty]').focus();
					}); 
					return true;*/
				}
				$(e).closest('tr').find('input[name=cost]').val(cost.toFixed(2));	
			} 
			
			function updateFooter(e)
			{
				resetFooter();
				if($(e).closest('tr').find('input[name=medicine]').attr('drugid'))
					updateFooterDrug(e);
				var crNo = $(e).closest('tr').find('input[name=crNo]').val().trim();
				var hosp = $('input[name=strHospitalCode]').val().trim();
				var patDtlObj = getPatDtlAjx(crNo);
				var patAdmDtlObj = getPatAdmDtlAjx(crNo,hosp);
				var footerRow = $('.ipdIssueDeskEntryFrmTbl tfoot tr');
				footerRow.find('.patientName').text(patDtlObj.strPatientName);
				footerRow.find('.admNo').text(patAdmDtlObj.strAdmissionNo);
				footerRow.find('.expDate').text('');
				footerRow.find('.ratePerUnit').text(''); 
			}
			function updateFooterDrug(e){ 
				var drugId = $(e).closest('tr').find('input[name=medicine]').attr('drugid').trim() || "";
				//$('.ipdIssueDeskEntryFrmTbl tfoot tr').find('.drugTypeAvl').text((drugId!="" ? drugId.split('#')[1] : ""));
			}
			function resetFooter()
			{
				var footerRow = $('.ipdIssueDeskEntryFrmTbl tfoot tr');
				footerRow.find('.patientName').text('');
				footerRow.find('.admNo').text('');
				footerRow.find('.drugTypeAvl').text('');
				footerRow.find('.expDate').text('');
				footerRow.find('.ratePerUnit').text(''); 
			}
			
			
			function saveIssueVouchers(toPrintFlg){
				var finalJsonObjArr = [];
				/*alert('Save called');*/
								
				$('.ipdIssueDeskEntryFrmTbl tbody tr').each(function(){
					var finalJsonObj = {};
					var crNo = $(this).find('input[name=crNo]').val();
					var ward = $(this).find('input[name=ward]').val();
					var indentNo = $(this).find('input[name=indentNo]').val();
					var medicine = $(this).find('input[name=medicine]').val();
					var medicineId = $(this).find('input[name=medicine]').attr('drugid') || "0#0#0#N#0";
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
					var strEmpNo = $('input[name=strEmpNo]').val();    
					var strSeatId = $('input[name=strSeatId]').val();    
					var strRemarks = $('textarea[name=remarks]').val();   
					var strPoNo = $('input[name=strPoNo]').val();    
					var strPoStoreId = $('input[name=strPoStoreId]').val();  
					var strReceivedby = $('input[name=strReceivedby]').val();     
					

					finalJsonObj.crNo = crNo;
					finalJsonObj.strEmpNo = strEmpNo;
					finalJsonObj.strPoNo = strPoNo;
					finalJsonObj.strPoStoreId = strPoStoreId;
					finalJsonObj.strSeatId = strSeatId; 
					finalJsonObj.strReceivedby = strReceivedby; 
					finalJsonObj.ward = ward;
					finalJsonObj.indentNo = indentNo;
					finalJsonObj.medicine = medicine;
					finalJsonObj.medicineId = medicineId.split('#')[0]; 
					finalJsonObj.medicineBrandId = medicineId.split('#')[4]; 
					finalJsonObj.batchNo = batchNo;
					finalJsonObj.issueQty = issueQty;
					finalJsonObj.lpQty = lpQty;
					finalJsonObj.ratePerUnit = ratePerUnit;
					finalJsonObj.cost = cost;
					finalJsonObj.strChk = strChk;
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
					finalJsonObj.strRemarks = strRemarks;
					finalJsonObj.patDtlAjx = getPatDtlAjx(crNo);
					finalJsonObj.patAdmDtlAjx = getPatAdmDtlAjx(crNo,hospCode); 
					finalJsonObjArr.push(finalJsonObj); 
				}); 
				
				console.log(JSON.stringify(finalJsonObjArr));
				console.log(finalJsonObjArr);
				$('input[name=issueDtlJson]').val(JSON.stringify(finalJsonObjArr));
				$('input[name=hmode]').val('NEWISSUEPRINT'); 
				$('input[name=toPrintFlg]').val(toPrintFlg); 
				//$('form').submit();
				//window.location = '/INVMGM/mms/transactions/LPIssueDeskTransCNT.cnt?hmode=NEWISSUEPRINT&toPrintFlg='+toPrintFlg+'';
				var myNewWin = window.open('/INVMGM/mms/transactions/LPIssueDeskTransCNT.cnt?hmode=NEWISSUEPRINT&toPrintFlg='+toPrintFlg,'','width='+window.innerWidth+',height=700');
				myNewWin.window.issueDtlJson2 = finalJsonObjArr;
				/*if(sessionStorage.getItem('ipdIssueEntryObj'))
				{
					console.log(JSON.parse(sessionStorage.getItem('ipdIssueEntryObj')));
					window.open('/INVMGM/mms/transactions/LPIssueDeskTransCNT.cnt?hmode=NEWISSUEPRINT&json='+JSON.stringify(finalJsonObjArr)+'','','width=1000,height=700');	
				}
				else
				{
					alert('No Record Found');
				}*/
			}
			

			$(document).ready(function(){ 
				/*var crNo = $('input[name=strCrNo]').val().trim();
				var hosp = $('input[name=strHospitalCode]').val().trim();
				var patDtlObj = getPatDtlAjx(crNo);
				var patAdmDtlObj = getPatAdmDtlAjx(crNo,hosp);
				var footerRow = $('.ipdIssueDeskEntryFrmTbl tfoot tr');
				footerRow.find('.patientName').text(patDtlObj.strPatientName);
				footerRow.find('.admNo').text(patAdmDtlObj.strAdmissionNo);
				$('input[name=ward]').val(patAdmDtlObj.strDeptName);
				$('input[name=strAdmissionDtlHidVal]').val(patAdmDtlObj.strHiddenValue);*/ 
			});
			

			function getStrDrugDtlAjx(){ 
				var jsonRs = {};
				$.ajax({
					url:"/INVMGM/services/restful/DrugList/drugList?storeId="+$('input[name=strStoreId]').val(),
					async:false,
					type:'GET',
					success:function(result){   
						jsonRs = result;
					}
				});
				return jsonRs;
			} 
			
			function setRate(e)
			{
				var rate = $(e).find('option:selected').attr('id');  
				$(e).closest('tr').find('input[name=ratePerUnit]').val(rate.split('@')[0]); 
				$('.drugTypeAvl').text(rate.split('@')[1]);
			} 
			
			function newSave()
			{
				//alert('to be saved');
				 var conf = confirm("You Are Going To Save Records");
	              if(conf == true){
	            	  
	            	  var conf1 = confirm("Are you sure !!!");
	                   if(conf1 == true)
	                   {					     
	                	    document.forms[0].hmode.value="NEWISSUESAVE";
	       					document.forms[0].submit();
	                   }else{
	                	   return false;
	                   }
	              }else{
	            	  return false;
	              } 
			}
			
			function validateIssueQty(e)
			{
				var batchNo = $(e).closest('tr').find('select[name=batchNo]').val();
				if(batchNo==null)
				{
					$(e).val('0');
					return swal('Sorry','Please select a valid Item !!!','warning').then((value) => {
						$(e).closest('tr').find('input[name=flexdatalist-medicine]').focus();
					});
				}
				var batchNoId = $(e).closest('tr').find('select[name=batchNo] option:selected').attr('id');
				var currentVal = $(e).val();
				if((batchNo!='NA') && ($(e).val()!='0'))
				{
					if(Number(batchNoId.split('@')[1]) >= Number(currentVal))
					{
						updateCost(e);
						return true; 
					}
					else
					{
						//alert('Available Qty is '+batchNoId.split('@')[1]);
						swal('Sorry','Available Qty is '+batchNoId.split('@')[1],'warning').then((value) => {
							$(e).closest('tr').find('input[name=issueQty]').focus();
						});
						$(e).val('0');
						$(e).closest('tr').find('input[name=cost]').val('0.00');
						return false;
					}
				}
				else if($(e).val()!='0')
				{
					swal ( "Warning" ,  "Item Not available" ,  "warning" ).then((value) => {
						$(e).closest('tr').find('input[name=lpQty]').focus();
					});  
					//alert('Item Not available');
					$(e).val('0');
					$(e).closest('tr').find('input[name=cost]').val('0.00');
					return false;
				}
			}
			function validateLpQty(e)
			{
				var batchNo = $(e).closest('tr').find('select[name=batchNo]').val();
				if(batchNo=='NA' || ($(e).val()=='0'))
				{
					return true;
				}
				else
				{
					swal ( "Warning" ,  "Item available" ,  "warning" );  
					//alert('Item Available');
					$(e).val('0');
					return false;
				}
			}
			
			function validateCrNo(e)
			{
				if($(e).val().trim().length==15)
				{
					var crNo = $(e).val().trim();
					var hosp = $('input[name=strHospitalCode]').val();
					var patDtlObj = getPatDtlAjx(crNo);
					if(JSON.stringify(patDtlObj)=="{}")
					{
						$(e).closest('tr').find('input[name=ward]').val('');
						swal ( "Warning" ,  "Invalid CR" ,  "warning" );  
						//alert('Invalid Cr');
						return false;
					}
					else
					{
						var patAdmDtlObj = getPatAdmDtlAjx(crNo,hosp);
						if(JSON.stringify(patAdmDtlObj)=="{}")
						{
							$(e).closest('tr').find('input[name=ward]').val('');
							swal ( "Warning" ,  "Invalid CR" ,  "warning" );  
							return false;
						}
						else
						{ 
							$('tfoot .patientName').text(patDtlObj.strPatientName);
							$('tfoot .patAcBal').text(patDtlObj.setStrPatAccountBal);   
							$('tfoot .admNo').text(patAdmDtlObj.strAdmissionNo);  
							if(patAdmDtlObj.strDeptName != undefined)
							$(e).closest('tr').find('input[name=ward]').val(patAdmDtlObj.strDeptName);
							$('input[name=strCrNo]').val(crNo);
							$('input[name=strAdmissionDtlHidVal]').val(patAdmDtlObj.strHiddenValue);
							return true;
						}
					}
				}
				else
				{ 
					$(e).closest('tr').find('input[name=ward]').val('');
					$(e).closest('tr').find('input[name=medicine]').val('');
					$(e).closest('tr').find('select[name=batchNo] option').remove(); 
					$(e).closest('tr').find('input[name=issueQty]').val('0');
					$(e).closest('tr').find('input[name=lpQty]').val('0');
					$(e).closest('tr').find('input[name=ratePerUnit]').val('0.00');
					$(e).closest('tr').find('input[name=cost]').val('0.00');
					$('tfoot .patientName').text('');
					$('tfoot .patAcBal').text('');   
					$('tfoot .admNo').text('');  
					$('input[name=strCrNo]').val('');
					$('input[name=strAdmissionDtlHidVal]').val('');
				}
			}
			
			function validateSave(e)
			{
				var flg = 0;
				var tempItemName = [];
				$('table.ipdIssueDeskEntryFrmTbl tbody tr').each(function(i,n){
					var temp = [];
					temp[0] = $(n).find('input[name=crNo]').val();
					temp[1] = $(n).find('input[name=ward]').val();
					temp[2] = $(n).find('input[name=medicine]').val();
					temp[3] = $(n).find('select[name=batchNo]').val();
					temp[4] = $(n).find('input[name=issueQty]').val();
					temp[5] = $(n).find('input[name=lpQty]').val();
					temp[6] = $(n).find('input[name=cost]').val();
					temp[7] = $(n).find('input[name=strNewItemId]').val();
					temp[8] = $(n).find('input[name=strNewBrandId]').val();
					tempItemName.push($(n).find('input[name=medicine]').val());
					for(var i=0;i<temp.length;i++)
					{
						if(temp[i]=="")
						{
							flg=1;
							break;
							return false;
						}
					}
				}); 
				if(flg==1)
				{
					swal ( "Warning" ,  "Please fill each mandatory details" ,  "warning" );  
					//alert('Please fill each mandatory details');
					return false;
				}
				else
				{  
					var acBal = Number($('.patAcBal').text());
					var totalCost = 0;
					$('.ipdIssueDeskEntryFrmTbl tbody tr').each(function(){
						totalCost+= Number($(this).find('input[name=cost]').val());
					});
					
					var isDupl = 0;
					var tempItemNameArray = tempItemName.sort();
					for (var i = 0; i < tempItemNameArray.length - 1; i++) {
					    if (tempItemNameArray[i + 1] == tempItemNameArray[i]) {
					        isDupl = 1;
					        break;
					    }
					}
					if(isDupl==1)
					{
						var isConfirm = confirm("You have duplicate items. Are you sure to save ?");
						if(isConfirm)
						{ 
							if(acBal < totalCost)
							{
								swal ( "Warning" ,  "A/c Balance is low !!" ,  "info" ).then((value) => {
									newSave();
								});
							} 
							else
							{
								newSave();
							}
							 return true;
						}
						else
						{ 
							 return false;							
						}
					}
					else
					{ 
						if(acBal < totalCost)
						{
							swal ( "Warning" ,  "A/c Balance is low !!" ,  "info" ).then((value) => {
								newSave();
							});
						} 
						else
						{
							newSave();
						}
						return true;
					}
					
				}
			}
			 
			function getIssueVoucher()
			{
				//getIssueDtls('1', storeId, issueNo,IndentNo,IndentDate,ucReq); 
				var storeId = $('input[name=strStoreId]').val(); //10001175
				var issueNo = $('input[name=strIssueNo]').val();
				$.ajax({
					url:"/INVMGM/mms/transactions/MmsCNT.cnt?hmode=ISSUEDTLSINIT&strMode=1&strStoreId="+storeId+"&strIssueNo=103219020600023&strIndentNo=0&strIndentDate=0&strUCReq=0",
					async:true,
					success:function(data){
						$('#issueDtlsDivId').html(data);
						$('#printid1 img:first-child').hide();
					}
				});
			}
			$(document).ready(function(){
				if($('input[name=strIssueNo]').val()!='' && $('input[name=strIssueNo]').val()!='0')	
				{
					var storeId = $('input[name=strStoreId]').val();
					var issueNo = $('input[name=strIssueNo]').val();
					var url = '/INVMGM/mms/transactions/LPIssueDeskTransCNT.cnt?hmode=NEWISSUEPRINT&toPrintFlg=1&storeId='+storeId+'&issueNo='+issueNo;
					//var myNewWin = window.open('/INVMGM/mms/transactions/LPIssueDeskTransCNT.cnt?hmode=NEWISSUEPRINT&toPrintFlg=1&storeId='+storeId+'&issueNo='+issueNo,'','directories=no,titlebar=no,toolbar=no,location=no,status=no,menubar=no,width=825,height=700');
					$('#voucherPrintModal #printModalIframeId').attr('src',url);
					$('#voucherPrintModal').modal('show');
					
					
					//var url="/INVMGM/mms/transactions/MmsCNT.cnt?hmode=ISSUEDTLSINIT&strMode=1&strStoreId="+storeId+"&strIssueNo="+issueNo+"&strIndentNo=0&strIndentDate=0&strUCReq=0";
					//var myNewWin = window.open(url,'','width='+window.innerWidth+',height=700'); 
				}
				

				

			});
			
			