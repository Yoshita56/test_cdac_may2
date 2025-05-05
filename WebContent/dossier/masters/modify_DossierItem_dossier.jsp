<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic"%>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<%@taglib uri="/WEB-INF/dateTag.tld" prefix="dateTag"%>
<%@ taglib uri="/WEB-INF/hisTab.tld" prefix="tag"%>
<%@ taglib uri="/WEB-INF/comboPersistence.tld" prefix="cmbPers"%>


<html>
<head>
<meta charset=utf-8>
<title>Dossier Item Mapping Master</title>

<link href="/INVMGM/mms/css/master.css" rel="stylesheet" type="text/css">
<link href="../../hisglobal/css/tab.css" rel="stylesheet" type="text/css">
<link href="../../hisglobal/css/calendar-tas.css" rel="stylesheet" type="text/css">
<link href="../../hisglobal/css/popup.css" rel="stylesheet" type="text/css">
<link href="../../hisglobal/css/newpopup.css" rel="stylesheet" type="text/css">
<link href="../../hisglobal/css/buttons.css" rel="stylesheet" type="text/css">

<!-- <link href="/INVMGM/mms/css/master.css" rel="stylesheet" type="text/css">
<link href="/INVMGM/hisglobal/css/tab.css" rel="stylesheet" type="text/css">
<link href="/INVMGM/hisglobal/css/calendar-tas.css" rel="stylesheet" type="text/css">

<link href="../../hisglobal/css/popup.css" rel="stylesheet" type="text/css">
 -->
<!-- <script language="JavaScript" src="../../hisglobal/js/tab.js"></script>
<script language="JavaScript" src="../../hisglobal/js/calendar.js"></script>
<script language="Javascript" src="../../hisglobal/js/validation.js"></script>
<script language="Javascript" src="../../hisglobal/js/util.js"></script> -->

<script language="JavaScript" src="../../hisglobal/masterutil/js/master.js"></script>
<script language="Javascript" src="../../hisglobal/js/util.js"></script>
<script language="Javascript" src="../js/mms.js"></script>
<script language="Javascript" src="../../hisglobal/js/newpopup.js"></script>
<script language="Javascript" src="../../hisglobal/js/popup.js"></script>
<script language="Javascript" src="../../hisglobal/js/multirow.js"></script>
<script language="JavaScript" src="../../hisglobal/masterutil/js/master.js"></script>
<script language="JavaScript" src="../../hisglobal/js/tab.js"></script>
<script language="JavaScript" src="../../hisglobal/js/calendar.js"></script>
<script language="Javascript" src="../../hisglobal/js/validation.js"></script>

<script language="Javascript" src="/INVMGM/dossier/masters/dossiernew_trans.js"></script>
<script language="Javascript" src="/INVMGM/dossier/masters/dossierItemsnew_util.js"></script>
<script language="Javascript" src="/INVMGM/dossier/masters/dossierDetailsnew_util.js"></script>
<!-- <script language="Javascript" src="/INVMGM/dossier/masters/dossierissueDetailsnew_util.js"></script> -->
<script language="Javascript" src="../../hisglobal/jquery/3.6.0.min.js"></script>

<script language="javaScript">
/* var newStoreName="";
	$(document).ready(function(){
		setInterval(function () {
			var tmp=$('table[id*="td1-"]');
		     if(tmp.length>0){
		    	 var txt=$('select[name="strNewStoreName"]').val();
		         var txt1=$('select[name="strNewStoreName"] option:selected').text();
		         //alert(txt +" *** "+txt1);
		         newStoreName=txt;
		         $("#strStoreNameId").prop("disabled", true);
		         $('input[name="strNewStoreName"]').val(newStoreName);
		           
		     }
	    },30000);
	});	

 */	
</script>

<script language="javaScript">
var storeId="";
var total_cost_before_modify=0.00;
$(document).ready(function(){
	$('input[id*="strQtyText95"]').each(function(){
		var tmp1 = $(this).closest('tr').find('div[id*="itemParaId97"]').text();
		var tmp2 = $(this).closest('tr').find('input[name=strQtyText1]').val();
		console.log('modify cost cal :::: tmp2:'+tmp2+'::::tmp1:'+tmp1);
		var cost = Number(tmp1) * Number(tmp2);
		$(this).closest('tr').find('input[name=strTotalCostText1]').val(cost.toFixed(2)); 
	});
	calculateTotalCost();

	$('div[id*="id101"] input[name="strTotalCostText1"]').attr("tabindex","-1");
	$('div[id*="id101"] img[id*="strDeleteButtonDivId1"]').attr("tabindex","-1");

	var e = document.getElementById("strStoreNameId");
	storeId = e.options[e.selectedIndex].value;
		
});
</script>

<script language="javaScript">
	$(document).ready(function(){
			 //console.log("hello");
			 var rows = $('div[id*=itemParaId97]');
			 for(var i=0;i<rows.length;i++)
			{
				 $('div[id*=itemParaId97]').eq(i).hide();
				//console.log($('div[id*=itemParaId97]').eq(i).text() + i);
				if($('div[id*=itemParaId97]').eq(i).text().trim()!='')
				 $('.itemParaId1').eq(i).val($('div[id*=itemParaId97]').eq(i).text().split('/')[0]);
			}

			var n = $('div[id*=itemParaId85]');
		    for(var i=0;i<n.length;i++)
		 	{
		 		 if($('div[id*=itemParaId85]').eq(i).text().trim()!='')
		 			 $('.IsMiscItemNew').eq(i).val($('div[id*=itemParaId85]').eq(i).text());
		 	}
		    var n1 = $('div[id*=itemParaId75]');
		    for(var i=0;i<n1.length;i++)
		 	{
		 		 if($('div[id*=itemParaId75]').eq(i).text().trim()!='')
		 			 $('.IsReturnableItemNew').eq(i).val($('div[id*=itemParaId75]').eq(i).text());
		 	}
		    var n2 = $('div[id*=itemParaId86]');
		    for(var i=0;i<n2.length;i++)
		 	{
		 		 if($('div[id*=itemParaId86]').eq(i).text().trim()!='')
		 			 $('.IsRCItemNew').eq(i).val($('div[id*=itemParaId86]').eq(i).text());
		 	}
		 	
	});
	
</script>

<script language="javaScript">
	var gblFlag=0;
	var total_cost_modify=0.0;
	var total_cost=0.0;
	var defRate=[];
	defRate[0]="";
	var defRate="";
	var defRate1="";
	
	function changeDefRateValueNew(e){
		var temp=$(e).val();
        defRate1+=$(e).closest('tr').find('div[id*="itemParaId97"]').text()+"#";
        //console.log(temp);
        temp1=defRate1;
        //console.log("defRate1 --->> "+temp1);
        if(temp=="1"){
        	$(e).closest('tr').find('div[id*="itemParaId97"]').text("0.00");
        	$(e).closest('tr').find('input[name="strDefRateText1"]').attr("readonly",true);
        }
        else{
        	$(e).closest('tr').find('div[id*="itemParaId97"]').text(defRate1.split('#')[0]);
        	$(e).closest('tr').find('input[name="strDefRateText1"]').removeAttr("readonly");
        	defRate1="";
        }
        updateCostValNew();
        calCost1(e); 
		
	}
	function updateDivValueNew(e){
		var temp=$(e).closest('tr').find('input[name="strDefRateText1"]').val();
		//alert("input box value -->> "+temp);
		$(e).closest('tr').find('div[id*="itemParaId97"]').text(temp);
    }
	function updateCostValNew(){
		
		//console.log("updateCostValNew");
		 var rows = $('div[id*=itemParaId97]');
		 for(var i=0;i<rows.length;i++)
		{
			 $('div[id*=itemParaId97]').eq(i).hide();
			
			if($('div[id*=itemParaId97]').eq(i).text().trim()!='')
			 $('.itemParaId1').eq(i).val($('div[id*=itemParaId97]').eq(i).text());
		}

	}
	function changeDefRateValueOld(e){
 		var temp=$(e).val();
        defRate+=$(e).closest('tr').find('div[id*="itemParaId3"]').text()+"#";
        //console.log(temp);
        temp1=defRate;
        //console.log(temp1);
        if(temp=="1"){
        	$(e).closest('tr').find('div[id*="itemParaId3"]').text("0.00");
        	$(e).closest('tr').find('input[name="strDefRateText"]').attr("readonly",true);
        }
        else{
        	$(e).closest('tr').find('div[id*="itemParaId3"]').text(defRate.split('#')[0]);
        	$(e).closest('tr').find('input[name="strDefRateText"]').removeAttr("readonly");
        	defRate="";
        }
        updateCostVal();
        calCost(e); 
		
    }

    function updateDivValue(e){
		var temp=$(e).closest('tr').find('input[id*="strDefRateText"]').val();
		//alert("input box value -->> "+temp);
		$(e).closest('tr').find('div[id*="itemParaId3"]').text(temp);
    }
/* 	function deleteRowOld(rowIndex,layerIndex,minRow,e) {
		var rowLength = 0;
		var delRowID;
		var rowLengthObj;
		
		rowLengthObj = document.getElementsByName("rowLength" + layerIndex);
		rowLength = parseInt(rowLengthObj[0].value);

		if(rowLength > parseInt(minRow)) {
			delRowID = document.getElementById("id" + rowIndex);
			if(delRowID != null) {
				delRowID.style.display = "NONE";
				delRowID.innerHTML = "";
				
				rowLengthObj[0].value = parseInt(rowLength) - 1;
			}
		}
		calculateTotalCostOld();
		
	} */
	function deleteRowOld(rowIndex,layerIndex,minRow,e) {
		 $(e).closest('div[id="id'+rowIndex+'"]').remove();
		 calculateTotalCostOld();
	}
	
	function deleteRowNew(rowIndex,layerIndex,minRow,e) {
		 $(e).closest('div[id="id101'+rowIndex+'"]').remove();
		 calculateTotalCost();
	}

	function calCost(e){
 		var cost=0.00;
		var temp = $(e).closest('tr').find('input[name=strDefRateText]').val();
		var tem1 = $(e).closest('tr').find("input[name=strQtyText]").val();
		//console.log('temp::>>'+temp);
		//console.log('temp1===>>'+tem1);
		if(temp!='' && tem1!=''){
			cost=(Number(tem1) * Number(temp));
			//console.log('cost::>>'+cost);
		    $(e).closest('tr').find("input[name=strTotalCostText]").val(cost.toFixed(2));
		    calculateTotalCostOld();
		}
		else{
			cost=0;
		    $(e).closest('tr').find("input[name=strTotalCostText]").val(cost.toFixed(2));
		    calculateTotalCostOld();
		}
		 
	}
	function calculateTotalCostOld(){
		var total_cost=0.00;
		var rows=$('input[name="strTotalCostText"]');
		for(var i=0;i<rows.length;i++){
			var temp1=$('input[name="strTotalCostText"]').eq(i).val();
			//console.log(temp1);
			total_cost+=(temp1==''? 0:Number(temp1));
		} 
		$('#tableTotal #totalCost').text(total_cost.toFixed(2)); 
		calculateTotalCostDossier();
	}
	function calCost1(e){
 		
		var cost=0.00;
		var temp = $(e).closest('tr').find('input[name=strDefRateText1]').val();
		var tem1 = $(e).closest('tr').find("input[name=strQtyText1]").val();
		//console.log('temp::>>'+temp);
		//console.log('temp1===>>'+tem1);
		if(temp!='' && tem1!=''){
			cost=(Number(tem1) * Number(temp));
			//console.log('cost::>>'+cost);
		    $(e).closest('tr').find("input[name=strTotalCostText1]").val(cost.toFixed(2));
		    calculateTotalCost();
		}
		else{
			cost=0;
			$(e).closest('tr').find("input[name=strTotalCostText1]").val(cost.toFixed(2));
		    calculateTotalCost();
		}
		 
	} 
	function calculateTotalCost(){
		var total_cost=0.00;
		var rows=$('input[id*="strTotalCostText94"]');
		for(var i=0;i<rows.length;i++){
			var temp1=$('input[id*="strTotalCostText94"]').eq(i).val();
			//console.log(temp1);
			total_cost+=(temp1==''? 0:Number(temp1));
		} 
		$('#tableTotalModify #totalCostModify').text(total_cost.toFixed(2)); 
		calculateTotalCostDossier();
	}
	function deletePreviousElementsFunc(){		

		var e = document.getElementById("strStoreNameId");
		var temp = e.options[e.selectedIndex].value;
		var conf = confirm("You have changed the store name and some of these items may not be available in the selected store."
					+"Are you sure you want to change the store name? If yes, please delete the displayed items and add new items using Item Finder.");
		if(conf){
			gblFlag=1;
		}	
		else{
			document.getElementById("strStoreNameId").value=storeId;
		}
		
		
	}
	function calculateTotalCostDossier(){
		var total_cost=0.00;
		var temp1=$('#tableTotalModify #totalCostModify').text();
		var temp2=$('#tableTotal #totalCost').text();

		//console.log("cost calc --->> "+temp1+" ---->>> "+temp2);
		total_cost+=Number(temp1)+Number(temp2);
		$('#tableTotalDossier #totalCostDossier').text(total_cost.toFixed(2)); 
		$('input[name="strDossierTotalCost"]').val(total_cost.toFixed(2));
	}
</script>
<script>
duplicateItemFlag=0;
function checkForDuplicateItems(){
	var tempBrandId=[];
	var tempBId=[];
	var index=0, j=0;
		$('input[name="strItemBrandIdArray"]').each(function(){
			//alert($(this).val());    	
			tempBrandId[index]=$(this).val();
			index++;
		});
		$('div[id*="id1-"] input[name="itemParamValue"]').each(function(){
			var txt=$(this).closest('div').attr('id');
			//alert(txt);
			var itemName=this.value.split('^')[0];
			//alert(itemName);
			var combined = this.value.split('#')[2];
			//alert(combined);
			tmp=combined.split('^');
			tempBId[j]=tmp[1]+"^"+txt+"^"+itemName;
			//alert(tmp[1]);
			j++;
		});
		
	  
			for(var i=0;i<tempBrandId.length;i++){
				for(var k=0;k<tempBId.length;k++){
					if(tempBrandId[i]==tempBId[k].split("^")[0]){
					alert("Duplicate item found. Removing Item Name: "+tempBId[k].split("^")[2]);	
					$('input[name="itemParamValue"]').closest('div[id="'+tempBId[k].split("^")[1]+'"]').remove();
					calculateTotalCostOld();
					}
				}
			}
	 
	//return true;
}
	

</script>
 <script language="javaScript">

function LeftListTransfer()
	{
	 var ob1=document.forms[0].strLeftReqTypes.value;
	 var ob=document.getElementById("LeftReqTypes");
	 shiftToRight("strLeftReqTypes","strRightRequestTypes",1);
	}

function validate1(){   

	var hisValidator = new HISValidator("DossierItemMasterBean");

	/* hisValidator.addValidation("strNewStoreName", "dontselect=0", "Store Name is a Mandatory Field"); */
	/* var selectedValue = document.getElementsByName("strNewStoreName")[0].value;
	if(selectedValue=="0"){
		alert("Issuing Store Name is a mandatory field.");
		return false;
	} */

	if($('div[id*="id101"]').length>0)
	{	
		/* if(gblFlag==1){
			alert("You changed the Issuing store name. Please delete the previously existing items and then proceed.");
			return false;
		} */
		var flag=1;
		$('div[id*="id101"] input[name="strDefRateText1"]').each(function(){
			var tmp1 = $(this).closest('tr').find('input[name="strDefRateText1"]');
			var tmp2 = $(this).closest('tr').find('input[name="strQtyText1"]');

			if(tmp1.val()==''){
				alert('Please enter the value for Unit Price.');
				tmp1.focus();
				flag=0;
				return false;
			} 
			if(tmp2.val()==''){
				alert('Please enter the value for No. Of Units.');
				tmp2.focus();
				flag=0;
				return false;
			} 
		});
		if(flag==0){
			return false;
		}
		else{
			if($('div[id*="id1-"]').length>0)
			{
				var flag=1;
				$('div[id*="id1-"] input[name="strDefRateText"]').each(function(){
					var tmp1 = $(this).closest('tr').find('input[name="strDefRateText"]');
					var tmp2 = $(this).closest('tr').find('input[name="strQtyText"]');

					if(tmp1.val()==''){
						alert('Please enter the value for Unit Price.');
						tmp1.focus();
						flag=0;
						return false;
					} 
					if(tmp2.val()==''){
						alert('Please enter the value for No. Of Units.');
						tmp2.focus();
						flag=0;
						return false;
					} 
				});
				if(flag==0){
					return false;
				}
				else{
					checkForDuplicateItems();
					var conf = confirm("Are you Sure, Want to Update!!!!");

					if(conf)
					{	
						document.forms[0].hmode.value="UPDATE";
						document.forms[0].submit();
					}else{
						return false;
					}
				}
			}
			else if($('div[id*="id1-"]').length==0){
				checkForDuplicateItems();
				var conf = confirm("Are you Sure, Want to Update!!!!");

					if(conf)
					{	
						document.forms[0].hmode.value="UPDATE";
						document.forms[0].submit();
					}else{
						return false;
					}
			}
			else{
				alert("Dossier must have atleast 1 item. Please select an item from ItemFinder and then proceed.");
				return false;
			}

		}
	}
	else{
		if($('div[id*="id1-"]').length>0)
		{
			var flag=1;
			$('div[id*="id1-"] input[name="strDefRateText"]').each(function(){
				var tmp1 = $(this).closest('tr').find('input[name="strDefRateText"]');
				var tmp2 = $(this).closest('tr').find('input[name="strQtyText"]');

				if(tmp1.val()==''){
					alert('Please enter the value for default rate.');
					tmp1.focus();
					flag=0;
					return false;
				} 
				if(tmp2.val()==''){
					alert('Please enter the value for quantity.');
					tmp2.focus();
					flag=0;
					return false;
				} 
			});
			if(flag==0){
				return false;
			}
			else{
				checkForDuplicateItems();
				var conf = confirm("Are you Sure, Want to Update!!!!");

				if(conf)
				{	
					document.forms[0].hmode.value="UPDATE";
					document.forms[0].submit();
				}else{
					return false;
				}
			}
		}
		else{
			alert("Dossier must have atleast 1 item. Please select an item from ItemFinder and then proceed.");
			return false;
		}

	
	}

}


function BrandCombo()
{ 
	 var url;
	 var mode = 'BRANDNAME';   
	 var itemid = document.forms[0].strItemId.value;
	 if(itemid!='0')
	 {
	       var  objVal = document.getElementById("mandatory");
				objVal.innerHTML = "<font color='red'>*</font>Item Name";
	 }
	 else
	 {
	   var  objVal = document.getElementById("mandatory");
				objVal.innerHTML = "ItemName";
	 }
	 var temp = itemid.split('^');
	 url="DossierItemMstCNT.cnt?hmode=BRANDNAME&ItemId="+temp[0]+"&combo="+document.forms[0].strStoreId.value+"&CategoryNo="+document.forms[0].strCategoryNo.value;    
	 
	 ajaxFunction(url,"1");
}
function SubGroupCombo()
{	
	 var url;
	 var mode = 'SUBGROUPNAME';   
	 url="DossierItemMstCNT.cnt?hmode=SUBGROUPNAME&GroupId="+document.forms[0].strGroupId.value+"&CategoryNo="+document.forms[0].strCategoryNo.value+"&StoreId="+document.forms[0].strStoreId.value;     
	 
	 ajaxFunction(url,"2");
}

function ItemNameCombo()
{

	 var url;
	 var mode = 'ITEMNAME';   
	 url="DossierItemMstCNT.cnt?hmode=ITEMNAME&GroupId="+document.forms[0].strGroupId.value+
	 "&SubGroupId="+document.forms[0].strSubGroupId.value+"&StoreComboId="+document.forms[0].strStoreId.value+"&CategoryNo="+document.forms[0].strCategoryNo.value;     
	 ajaxFunction(url,"3");
}


function UnitCombo()
{

	 var url;
	 var mode = 'UNITCOMBO';   
	 var strItemId = document.forms[0].strItemId.value;
	
	
	if(strItemId == 0){
		
		document.forms[0].strLevelUnitId.value = 0;
				
				objVal= document.getElementById("UnitDivId"); 
				objVal.innerHTML = "/";
		
	}else{
		 url="DossierItemMstCNT.cnt?hmode=UNITCOMBO&strItemId="+strItemId; 
		 ajaxFunction(url,"4");
	 }
}

function reSetDiv()
{
           var  objVal = document.getElementById("mandatory");
				objVal.innerHTML = "<font color='red'>*</font>Item Name";

}


function getAjaxResponse(res,mode)
{
		var objVal;
		var objVal2;
		
		if(mode=="5")
		{   
	
				var err = document.getElementById("errMsg");
		 		var temp1 = res.split("####");
			         
        		 if(temp1[0] == "ERROR")
        		 {
         			err.innerHTML = temp1[1];	
        		 }
				else
				{
				   objVal= document.getElementById("Brand");
				   objVal.innerHTML = "<select name ='strItemBrandId' >" + res + "</select>";
							
				}
		 }
	   if(mode=="1"){   
	
				var err = document.getElementById("errMsg");
		 		var temp1 = res.split("####");
			         
        		 if(temp1[0] == "ERROR"){
         			err.innerHTML = temp1[1];	
        			 }
				else{
				objVal= document.getElementById("Brand");
				objVal.innerHTML = "<select name ='strItemBrandId' >" + res + "</select>";
				
				UnitCombo();
				
				
				}
		 }
		  if(mode=="2")
		  {   
	
				var err = document.getElementById("errMsg");
		 		var temp1 = res.split("####");
			         
        		 if(temp1[0] == "ERROR"){
         			err.innerHTML = temp1[1];	
        			 }
				else{
				var temp = res.split("#");	
				
				objVal= document.getElementById("SubGroupDivId"); 
				objVal.innerHTML = "<select name ='strSubGroupId' onChange='ItemNameCombo();'>" + temp[0] + "</select>";
				
				objVal2= document.getElementById("ItemNameDivId");
				objVal2.innerHTML = "<select name ='strItemId' class='comboNormal' onchange='BrandCombo();' >" + temp[1] + "</select>";
				
				   objVal3= document.getElementById("Brand");
				   objVal3.innerHTML = "<select name ='strItemBrandId' >" + temp[2] + "</select>";
				}
		 }
		 if(mode=="3"){   
	
				var err = document.getElementById("errMsg");
		 		var temp1 = res.split("####");
			         
        		 if(temp1[0] == "ERROR"){
         			err.innerHTML = temp1[1];	
        			 }
				else{
				objVal= document.getElementById("ItemNameDivId"); 
				objVal.innerHTML = "<select name ='strItemId' onchange='BrandCombo();'>" + res + "</select>";
				}
		 }
		 if(mode=="4"){   
	
				var err = document.getElementById("errMsg");
		 		var temp1 = res.split("####");
			         
        		 if(temp1[0] == "ERROR"){
         			err.innerHTML = temp1[1];	
        			 }
				else{
				
				var vals = res.split("^");
				
				if(vals.length > 0){
				
				document.forms[0].strLevelUnitId.value = vals[0];
				
				objVal= document.getElementById("UnitDivId"); 
				objVal.innerHTML = vals[1];
				}else{
				
				document.forms[0].strLevelUnitId.value = 0;
				
				objVal= document.getElementById("UnitDivId"); 
				objVal.innerHTML = "/";
				
				}
				
				}
		 }
}

</script>

</head>
<body onLoad="">
<html:form name="DossierItemMasterBean" action="/masters/DossierItemMstCNT"
	type="dossier.masters.controller.fb.DossierItemMstFB">
	<center>
	<div id="errMsg" class="errMsg">
		<bean:write name="DossierItemMasterBean" property="strErr" />
	</div>
	<div class="warningMsg">
		<bean:write name="DossierItemMasterBean" property="strWarning" />
	</div>
	<div id="normalMsg" class="normalMsg">
		<bean:write name="DossierItemMasterBean" property="strMsg" />
	</div>


	<tag:tab tabLabel="Dossier Item Mapping Master" selectedTab="FIRST"
		align="center" width="TABLEWIDTH">
	</tag:tab></center>
	<table class="TABLEWIDTH" align="center" cellpadding="1px"
		cellspacing="1px">

		<tr class="HEADER">
			<td colspan="8">Dossier Item mapping Master&gt;&gt; Modify</td>
		</tr>
		<tr>
			<td width="25%" class="LABEL"><font color="red">*</font>Service Type Name</td>
			<td width="25%" class="CONTROL">
				<bean:write name="DossierItemMasterBean" property="strServiceTypeName" filter="false" />
			</td>
			<td width="25%" class="LABEL"><font color="red">*</font>Dossier Name/Service Name</td>
			<td width="25%" class="CONTROL">
				<bean:write name="DossierItemMasterBean" property="strDossierName" filter="false" />
			</td>
		</tr>
		
		<tr style="display:none;">			
			<td class="LABEL" width="25%"><font color="red">*</font>Issuing Store</td>
			<td width="25%" class="CONTROL" id="storeNameIdRow">
				<select name="strNewStoreName" class="comboNormal" id="strStoreNameId" onchange="deletePreviousElementsFunc();">
					<bean:write name="DossierItemMasterBean" property="strStoreNameValues" filter="false" />
				</select>
			</td>
			<td class="LABEL" width="25%"></td>
			<td width="25%" class="CONTROL"></td>

		</tr>
	</TABLE>

	<%-- <table class="TABLEWIDTH" align="center" cellpadding="1px" cellspacing="1px">
 			 <tr class="HEADER">
				<td colspan="8"><font color="red">*</font>Item Name</td>
			</tr>
			<tr>
  			 		<td class="CONTROL" colspan="3">  			 
						<div id="LeftReqTypes" align="right">
							<select name="strLeftReqTypes" size="8" multiple style="width: 280px">
								<bean:write name="DossierItemMasterBean" property="strLeftRequestTypeList" filter="false"/>
							</select></div>
					</td>
					<td width="6%" class="CONTROL" colspan="2">			
						<center><img src="../../hisglobal/images/forward3.gif" width="35" height="31" onclick ="LeftListTransfer();"></center>
						<center><img src="../../hisglobal/images/forwardward.gif" width="35" height="31" align="middle" onClick="shiftAllToRight('strLeftReqTypes','strRightRequestTypes',1);"/></center>
						<br/>
						<center><img src="../../hisglobal/images/backward.gif" width="35" height="31" onClick="shiftAllToLeft('strLeftReqTypes','strRightRequestTypes',1);"></center>
						<center><img src="../../hisglobal/images/back3.gif" width="35" height="31" onclick="shiftToLeft('strLeftReqTypes','strRightRequestTypes',1);"/></center>
					</td>
					<td colspan="3" class="CONTROL">
						<div id="RightReqTypes" align="left">
							<select name="strRightRequestTypes" id="RightReqTypes1" size="8" multiple style="width: 280px">
								<bean:write name="DossierItemMasterBean" property="strRightRequestTypeList" filter="false"/>
							</select></div>
					</td>
			</tr> 
		</table> --%>
		
		<bean:write name="DossierItemMasterBean" property="strItemDataDiv" filter="false" />
		
		
		<table class="TABLEWIDTH" align="center" cellpadding="1px"
		cellspacing="1px">

			<tr>
				<td class="LABEL" width="50%"><font color="red">*</font>Item Category</td>
				<td class="CONTROL" width="50%">
					<select id='dep' name="stritemcat" class="comboNormal" onchange="">
						<bean:write name="DossierItemMasterBean" property="strItemCatValues"
							filter="false" />
					</select>
				</td>		
			</tr>
		
		</table>
		<div id="dossierId">
		</div>

<div id="blanket" style="display: none;"></div>

	<div class="popUpDiv" id="popUpDiv" style="display: none;">
		<table bgcolor="white">
			<tr>
				<td>
				<div id="searchItemsDtlsDivId" style="display: block;"></div>
				<div id="stockDtlsDivId" style="display: block;"></div>
	
				</td>
			</tr>
		</table>
	</div>
	<div class="popUpDiv" id="popUpDiv1" style="display: none;">
		<table bgcolor="white">
			<tr>
				<td>
							
					<div id="issueDtlsDivId" style="display: block;"></div>
			
				</td>
			</tr>
		</table>
	</div>

		<div id="itemDtlOffDivId" style="display: block">
			<table class="TABLEWIDTH" align="center" cellspacing="1px"
				cellpadding="1px">
				<tr>
					<td class='TITLE' colspan='5'><div align="right"><img style="cursor: pointer;height: 20px"
						id='strSearchItemButtonDivId' src="../../hisglobal/images/ItemFinder.png"
						onclick='getItemSelectPopup();' name="searchName"
						title="Click here to Search Item"></div></td>
				</tr>
				<tr>
					<td colspan="5" bgcolor="black"></td>
				</tr>
				
			</table>
		
			<table cellspacing="1px" class="TABLEWIDTH" align="center"
				cellpadding="0px">
	
				<tr>
					<td class="multiLabel" width="23%">Item Name</td>
					<!-- <td class="multiLabel" width="8%">Is Misc</td> -->
					<!-- <td class="multiLabel" width="8%">Is Returnable</td> -->
					<td class="multiLabel" width="8%">Category</td>
					<!-- <td class="multiLabel" width="8%">Is RC</td> -->
					<td class="multiLabel" width="8%">Type</td>
					<td class="multiLabel" width="8%">Is Brought By Patient</td>
			     	<td class="multiLabel" width="8%">Unit Price</td>
			     	<td class="multiLabel" width="8%">No. Of Units</td>
			     	<td class="multiLabel" width="8%">Approx. Cost</td>
			     	<td class="multiLabel" width="8%">Remarks</td>
					<td class="multiLabel" width="4%">Remove</td>
				</tr>
			</table>
	

			<div id="id1">
			</div>
		
          	<table cellspacing="1px" class="TABLEWIDTH" align="center" cellpadding="0px" cellpadding="1px">
				<tr style="display: none;">
					<td class="" width="85%" align="right"><font color="red"><b>Net Cost</b></font></td>
					<td class="" width="15%" align="right"><div id="strNetCost"></div></td>
					
				</tr>
			</table>
			<table id="tableTotal" class="TABLEWIDTH" cellspacing="0px" cellpadding="0px" align="center">
	
				<tbody>
					<tr>
						<td class="multiLabel" width="23%"></td>
						<td class="multiLabel" width="8%"></td>
						<td class="multiLabel" width="8%"></td>
						<td class="multiLabel" width="8%"></td>
				     	<td class="multiLabel" width="8%">Total Cost</td>
				     	<td class="multiLabel" id="totalCost" width="8%"></td>
						<td class="multiLabel" width="4%"></td>
					</tr>
				</tbody>
			</table>
			<table id="tableTotalDossier" class="TABLEWIDTH" cellspacing="0px" cellpadding="0px" align="center">
	
				<tbody>
					<tr>
						<td class="multiLabel" width="23%"></td>
						<td class="multiLabel" width="8%"></td>
						<td class="multiLabel" width="8%"></td>
						<td class="multiLabel" width="4%"></td>
				     	<td class="multiLabel" width="12%">Total Cost Of Dossier</td>
				     	<td class="multiLabel" id="totalCostDossier" width="8%" name="strDossierTotalCost"></td>
						<td class="multiLabel" width="4%"></td>
					</tr>
				</tbody>
			</table>
			<table cellspacing="1px" class="TABLEWIDTH" align="center"
				cellpadding="1px">
				<tr>
					<td colspan="5" bgcolor="black"></td>
				</tr>
				<tr class="FOOTER">
					<td colspan="5"></td>
				</tr>
			</table>
		</div>
		
		<table cellspacing="0px" class="TABLEWIDTH" align="center">
			<tr class="FOOTER">
				<td colspan="2" >
					<div align="left">
						<font size="2" color="red">*</font>Rates are Cost To Patient on Auto batch selection, may vary as per actual batch which would be issued.
					</div>
				</td>
				<td colspan="2"><font size="2" color="red">*</font>
				Mandatory Fields</td>
			</tr>
		</table>
		
	<%-- <logic:equal name="DossierItemMasterBean" property="strStoreLevel" value="1">
		<TABLE class="TABLEWIDTH" align="center" cellpadding="1px"
			cellspacing="1px">
			<tr>
				<td width="50%" class="LABEL"><font color="red">*</font>Fore
				Cast</td>
				<td width="50%" class="CONTROL"><input type="text"
					class="txtFldNormal" name="strForeCast" maxlength="3" value=""
					onkeypress="return validateData(event,5);"><b> %</b></td>
			</tr>
		</TABLE>
	</logic:equal> --%>

	 <%-- 	
	<TABLE class="TABLEWIDTH" align="center" cellpadding="1px"
		cellspacing="1px">

		<tr>
			<td class="LABEL" width="50%">
			<div align="right"><font color="red">*</font>Effective From</div>
			</td>
			<td class="CONTROL"><dateTag:date name="strEffectiveFrom"
				value="${DossierItemMasterBean.strCtDate}"></dateTag:date></td>
		</tr>


		<tr>
			<td width="50%" class="LABEL" valign="top">Remarks if Any</td>
			<td width="50%" class="CONTROL"><textarea name="strRemarks"
				cols="25" rows="2"></textarea></td>
		</tr>


		<tr class="FOOTER">
			<td colspan="2"><font size="2" color="red">*</font> Mandatory
			Fields</td>
		</tr>

	</table>
 --%>
<!-- 	<table border="0" class="TABLEWIDTH" align="center" cellpadding="1px"
		cellspacing="1px">
		<tr>

			<td align="center"><img style="cursor: pointer; "
				title="Save Record" src="../../hisglobal/images/btn-sv.png"
				onClick=" return validate1();" /> <img
				style="cursor: pointer; " title="Reset Content"
				src="../../hisglobal/images/btn-clr.png"
				onClick="document.forms[0].reset();" />
			<img style="cursor: pointer; " title="Cancel Process"
				src="../../hisglobal/images/btn-ccl.png"
				onClick="cancel('LIST');" /></td>
		</tr>
	</table> -->
	<br>
	<div align="center" id=" ">					 
		 	<a href="#" class="button" id=" " onclick=' return validate1();'><span class="save">Save</span></a>
			<a href="#" class="button"	onclick="document.forms[0].reset();"><span class="clear">Clear</span></a> 
			<a href="#" class="button" onclick="cancel('LIST');"><span class="cancel">Cancel</span></a>
	</div>
	<input type="hidden" name="hmode" />
	
	<input type="hidden" name="strStoreId" value="${DossierItemMasterBean.strStoreId}" />
	<input type="hidden" name="strDossierId" value="${DossierItemMasterBean.strDossierId}" />
	<input type="hidden" name="strCtDate" value="${DossierItemMasterBean.strCtDate}" />
	<input type="hidden" name="strDossierTotalCost" value="${DossierItemMasterBean.strDossierTotalCost}" />
	<input type="hidden" name="strDossierOldTotalCost" value="${DossierItemMasterBean.strDossierOldTotalCost}" />
	<input type="hidden" name="strIsValid" value="${DossierItemMasterBean.strIsValid}" />
	<input type="hidden" name="strStoreName" value="10201100" />
	<input type="hidden" name="strNewStoreName" value="10201100" />
	
	<!-- <input type="hidden" name="strNewStoreName" value="" /> -->
	<cmbPers:cmbPers />
	
	
</html:form>
<jsp:include page="dossier_trans_itemmst_mulirow.jsp"></jsp:include>
<tag:autoIndex></tag:autoIndex>
</body>
</html>