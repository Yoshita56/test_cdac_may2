
//$(document).ready(function() {
//    $('#example').DataTable( {
//        dom: 'Qlfrtip'
//    });
//});

var arrayReturn = [];

function getJqueryAjaxGenerate_ORG()
{ 
        var lenh;	      
        var count = 0;
	    var strDtl = "";
	    var drugSearchCombo;
	    var stratStr1;
	    var stratStr2;
	    var strGroupName;
	    var strValueToSave;
	    var totalCostStr;
	    var strConcatQty;      			

	$.ajax
	({
		type: "POST",
		url: "../../mms/transactions/IssueDeskPrintTransCNT.cnt?hmode=HLP_JSON",
		dataType:"json",
		data : 
		{                    
                 'storeId':"10201100",
                 'statusId':"4",
                 'reqTypeId':"35"
                
         },  			
		success: function(data)
		{	
			lenh = data.Messages.length;
			if(data.Messages.length)
			{
			   var msgObject = eval('(' + JSON.stringify(data) + ')');            
									   
			   for (var i = 0, len = data.length; i < len; i++) 
		        {
		          
		            arrayReturn.push([ 
		            	msgObject.Messages[i].Chk_ID, 
		            	msgObject.Messages[i].issueNo, 
		            	msgObject.Messages[i].indentNo,
		            	msgObject.Messages[i].issueDate,
		            	msgObject.Messages[i].reqStoreName,
		            	msgObject.Messages[i].crNO,
		            	msgObject.Messages[i].patientName]);
		        }
			   inittable(arrayReturn);
			  
			}
		  	
						
		},
        error: function(jqXHR, textStatus, errorThrown)
        {
            alert('error: ' + textStatus + ': ' + errorThrown);
        }
	});
}
function getViewCNT_NEW()
{
	let patientWidget="";
	var patdata;
	var careof="";
	var strDtl = "";
	 var action = "http://10.10.10.193:8082/eSushrutEMRServices/service/ehr/get/patient/vitals/recent";
	  $.ajax({url: action,type:'GET',async:false,dataType:"json",
		  data:{crNo: "379132100133674"},
		  success:function(data)
	  {
			  //alert("Data--->>"+JSON.stringify(data));
			  //console.log("getPatInfo:: "+data);
			// convert data into JSON object
                var patdata = data;
			
             // Converting JSON object to JS object
                var obj = data;
                var i=0;
                /*
                var lenh = obj.vitals_detail.all_data.length;
                for (i=0; i<lenh; i++) 
 			    {
                	console.log("Data-"+i+"--"+obj.vitals_detail.all_data[i].encounter_detail.cr_no);
 			    }
 			    */
                
               
                //console.log("i-->"+i);
                //console.log("Data-"+(i-1)+"--"+obj.vitals_detail.all_data[i-1].weight.value+" "+obj.vitals_detail.all_data[i-1].weight.uom);
                
              
                /*
                console.log(obj.vitals_detail.all_data);
                console.log(obj.vitals_detail.all_data.length);
                */
                //obj.vitals_detail.all_data[0].record_date
                
                
                strDtl="<div  id='wId'><table  id='mainTableRptId'  border = '1px' style='width: 95%;'  align='center'  cellspacing='0px'   cellpadding='1px'>"+
				"<thead><tr>"+
				"<th  colspan='1' width='16%'><font size='2' face='Verdana, Arial, Helvetica, sans-serif' >Weight</font></th>"+
				"<th  colspan='1' width='16%'><font size='2' face='Verdana, Arial, Helvetica, sans-serif' >Height</font></th>"+
				"<th  colspan='1' width='16%'><font size='2' face='Verdana, Arial, Helvetica, sans-serif' >BMI</font></th>"+
				"<th  colspan='1' width='16%'><font size='2' face='Verdana, Arial, Helvetica, sans-serif' >Temp</font></th>"+
				"<th  colspan='1' width='16%'><font size='2' face='Verdana, Arial, Helvetica, sans-serif' >BP</font></th>"+
				"<th  colspan='1' width='16%'><font size='2' face='Verdana, Arial, Helvetica, sans-serif' >Heart Rate</font></th>"+				
				"</tr>"+
				"</thead><tbody>";
                

                console.log("Recent.Weight-->"+obj.vitals_detail.recent.weight.value);
                console.log("Recent.uom-->"+obj.vitals_detail.recent.weight.uom);
                
                console.log("Recent.height-->"+obj.vitals_detail.recent.height.value);
                console.log("Recent.uom-->"+obj.vitals_detail.recent.height.uom);
                
                console.log("Recent.bmi-->"+obj.vitals_detail.recent.bmi.value);
                console.log("Recent.bmi-->"+obj.vitals_detail.recent.bmi.uom);
                
                console.log("Recent.temperature-->"+obj.vitals_detail.recent.temperature.value);
                console.log("Recent.temperature-->"+obj.vitals_detail.recent.temperature.uom);
                
                console.log("Recent.bp-->"+obj.vitals_detail.recent.bp.value);
                console.log("Recent.bp-->"+obj.vitals_detail.recent.bp.uom);
                
                console.log("Recent.heart_rate-->"+obj.vitals_detail.recent.heart_rate.value);
                console.log("Recent.heart_rate-->"+obj.vitals_detail.recent.heart_rate.uom);
                
                var weight 		= obj.vitals_detail.recent.weight.value 	 +" - "+obj.vitals_detail.recent.weight.uom;
                var height 		= obj.vitals_detail.recent.height.value 	 +" - "+obj.vitals_detail.recent.height.uom;
                var bmi    		= obj.vitals_detail.recent.bmi.value    	 +" - "+obj.vitals_detail.recent.bmi.uom;
                var temperature = obj.vitals_detail.recent.temperature.value +" - "+obj.vitals_detail.recent.temperature.uom;
                var bp 			= obj.vitals_detail.recent.bp.value 		 +" - "+obj.vitals_detail.recent.bp.uom;
                var heart_rate 	= obj.vitals_detail.recent.heart_rate.value  +" - "+obj.vitals_detail.recent.heart_rate.uom;
                
                strDtl=strDtl+"<tr class='item-row' id='tableRowId"+i+"' >"+
	              "<td  name='tdId' id='tdId01"+i+"'  width='16%' style='text-align:center;'><font size='1' face='Verdana, Arial, Helvetica, sans-serif' >"+weight+"</font></td>"+
	              "<td  name='tdId' id='tdId02"+i+"'  width='16%' style='text-align:center;'><font size='1' face='Verdana, Arial, Helvetica, sans-serif' >"+height+"</font></td>"+
	              "<td  name='tdId' id='tdId03"+i+"'  width='16%' style='text-align:center;'><font size='1' face='Verdana, Arial, Helvetica, sans-serif' >"+bmi+"</font></td>"+
	              "<td  name='tdId' id='tdId04"+i+"'  width='16%' style='text-align:center;'><font size='1' face='Verdana, Arial, Helvetica, sans-serif' >"+temperature+"</font></td>"+
	              "<td  name='tdId' id='tdId05"+i+"'  width='16%' style='text-align:center;'><font size='1' face='Verdana, Arial, Helvetica, sans-serif' >"+bp+"</font></td>"+
	              "<td  name='tdId' id='tdId06"+i+"'  width='16%' style='text-align:center;'><font size='1' face='Verdana, Arial, Helvetica, sans-serif' >"+heart_rate+"</font></td>"+
				  "</tr>";         
                
                strDtl=strDtl+"</tbody></table></div>";
                
                //alert("Table HLP--->>"+strDtl);

		
	  },error: function(errorMsg,textstatus,errorthrown) 
	  {
		
	  }
	  
	  });	
}



function getViewCNT(index)
{	
	
	var chkValue   =  document.getElementById("strCheckHidValue"+index).value;	
	var storeId    = document.forms[0].strStoreId[document.forms[0].strStoreId.selectedIndex].value;
	var statusId   = document.forms[0].strStatusCode[document.forms[0].strStatusCode.selectedIndex].value;
	var storeName  = document.forms[0].strStoreId[document.forms[0].strStoreId.selectedIndex].text;
	if(storeId=="0")
	{
		alert("Please Select Store");
	}
	else
	{
			
			if(statusId=="1")
			{
				
				
				document.forms[0].strStoreName.value  = storeName;
			    document.forms[0].chk.value  = chkValue;
				document.forms[0].hmode.value="ISSUEVIEW";
				document.forms[0].submit();
			}
			else
			{
				
				document.forms[0].strStoreName.value  = storeName;
				document.forms[0].chk.value  = chkValue;
				document.forms[0].hmode.value="RETURNVIEW";
				document.forms[0].submit();
			}
			
	}
}
function onGoButton() 
{	
	
	var storeId    = document.forms[0].strStoreId[document.forms[0].strStoreId.selectedIndex].value;
    var catgId     = document.forms[0].strItemCatgNo[document.forms[0].strItemCatgNo.selectedIndex].value;
    var reqTypeId  = (document.forms[0].strRequestTypeId[document.forms[0].strRequestTypeId.selectedIndex].value).split("^")[1];
    var statusId   = document.forms[0].strStatusCode[document.forms[0].strStatusCode.selectedIndex].value;	
    
		if(strCrNo.value.length > 14) 
		{			    
			document.forms[0].strStoreName.value  = document.forms[0].strStoreId[document.forms[0].strStoreId.selectedIndex].text;
			document.forms[0].strCatgName.value   = document.forms[0].strItemCatgNo[document.forms[0].strItemCatgNo.selectedIndex].text;
			document.forms[0].strReqName.value    = document.forms[0].strRequestTypeId[document.forms[0].strRequestTypeId.selectedIndex].text;
			
			
		    
		    
			document.forms[0].chk.value  		  = storeId+"@"+catgId+"@"+reqTypeId+"@"+document.forms[0].strCrNo.value;
			document.forms[0].hmode.value         = "ADD";
			document.forms[0].submit();
	
		} 
		else 
		{
			alert("Please Enter 15 Digit CR Number");
			return false;
		}
   
}

function onGoButton_OtherIndent() 
{	
	
	var storeId    = document.forms[0].strStoreId[document.forms[0].strStoreId.selectedIndex].value;
    var catgId     = document.forms[0].strItemCatgNo[document.forms[0].strItemCatgNo.selectedIndex].value;
    var reqTypeId  = (document.forms[0].strRequestTypeId[document.forms[0].strRequestTypeId.selectedIndex].value).split("^")[1];
    var statusId   = document.forms[0].strStatusCode[document.forms[0].strStatusCode.selectedIndex].value;	
    			    
	document.forms[0].strStoreName.value  = document.forms[0].strStoreId[document.forms[0].strStoreId.selectedIndex].text;
	document.forms[0].strCatgName.value   = document.forms[0].strItemCatgNo[document.forms[0].strItemCatgNo.selectedIndex].text;
	document.forms[0].strReqName.value    = document.forms[0].strRequestTypeId[document.forms[0].strRequestTypeId.selectedIndex].text;
	
	
    
    
	document.forms[0].chk.value  		  = storeId+"@"+catgId+"@"+reqTypeId+"@0";
	document.forms[0].hmode.value         = "ADD";
	document.forms[0].submit();
	
}

function getDataTableOnSelection()
{     		     	
	
	
	
        var mode       ="GET_LIST_DATA";	
	    var storeId    = document.forms[0].strStoreId[document.forms[0].strStoreId.selectedIndex].value;
	    var catgId     = document.forms[0].strItemCatgNo[document.forms[0].strItemCatgNo.selectedIndex].value;
	    var reqTypeId  = (document.forms[0].strRequestTypeId[document.forms[0].strRequestTypeId.selectedIndex].value).split("^")[1];
	    var statusId   = document.forms[0].strStatusCode[document.forms[0].strStatusCode.selectedIndex].value;	
	    //var url = "IndentTransNEWCNT.cnt?hmode="+mode+"&storeId="+ storeId+"&catgId="+ catgId+"&statusId="+ statusId+"&reqTypeId="+ reqTypeId;
	    
	    if(reqTypeId == "13")
	    {
	    	var fieldInput = $('#strCrNo');
	    	var fldLength= fieldInput.val().length;
	    	fieldInput.focus();
	    	fieldInput[0].setSelectionRange(fldLength, fldLength);
	    	
	    	document.getElementById("crTextBoxId1").style.display="block";
	    	document.getElementById("crTextBoxId2").style.display="none";
	    }	
	    else
	    {
	    	document.getElementById("crTextBoxId1").style.display="none";
	    	document.getElementById("crTextBoxId2").style.display="block";
	    }
	    var url = "IndentTransNEWCNT.cnt?hmode="+mode+"&storeId="+ storeId+"&statusId="+ statusId+"&reqTypeId="+ reqTypeId+"&catgId="+catgId;
        //alert('HLP--'+url);
 		ajaxFunction(url,"1");		
}
function getCatgCombo()
{     	
        var mode       ="CATG_COMBO";	
	    var storeId    = document.forms[0].strStoreId[document.forms[0].strStoreId.selectedIndex].value;
	    var catgId     = document.forms[0].strItemCatgNo[document.forms[0].strItemCatgNo.selectedIndex].value;
	    var reqTypeId  = (document.forms[0].strRequestTypeId[document.forms[0].strRequestTypeId.selectedIndex].value).split("^")[1];
	    var statusId   = document.forms[0].strStatusCode[document.forms[0].strStatusCode.selectedIndex].value;	
	    //var url = "IndentTransNEWCNT.cnt?hmode="+mode+"&storeId="+ storeId+"&catgId="+ catgId+"&statusId="+ statusId+"&reqTypeId="+ reqTypeId;
	    var url = "IndentTransNEWCNT.cnt?hmode="+mode+"&storeId="+ storeId+"&statusId="+ statusId+"&reqTypeId="+ reqTypeId+"&catgId="+catgId;
       // alert(url);
 		ajaxFunction(url,"2");		
}
function getReqTypeCombo()
{     	
        var mode       ="REQ_TYPE_COMBO";	
	    var storeId    = document.forms[0].strStoreId[document.forms[0].strStoreId.selectedIndex].value;
	    var catgId     = document.forms[0].strItemCatgNo[document.forms[0].strItemCatgNo.selectedIndex].value;
	    var reqTypeId  = (document.forms[0].strRequestTypeId[document.forms[0].strRequestTypeId.selectedIndex].value).split("^")[1];
	    var statusId   = document.forms[0].strStatusCode[document.forms[0].strStatusCode.selectedIndex].value;	
	    //var url = "IndentTransNEWCNT.cnt?hmode="+mode+"&storeId="+ storeId+"&catgId="+ catgId+"&statusId="+ statusId+"&reqTypeId="+ reqTypeId;
	    var url = "IndentTransNEWCNT.cnt?hmode="+mode+"&storeId="+ storeId+"&statusId="+ statusId+"&reqTypeId="+ reqTypeId+"&catgId="+catgId;
        //alert(url);
 		ajaxFunction(url,"3");		
}
function getAjaxResponse(res,mode)
{
      var err = document.getElementById("errMsg");
      var temp = res.split("####");
      if(temp[0] == "ERROR")
	   {
          	err.innerHTML = temp[1];
          	return;
       } 

	if(mode=="1")
	{
	   	 var objVal= document.getElementById("id1");
	    	 objVal.innerHTML = "";
     
			if(res=="")
			{
				objVal.innerHTML="";
			}
			else
			{
				
				var table = $('#example').DataTable();

				//clear datatable
				table.clear().draw();

				//destroy datatable
				table.destroy();
				
				
				
				objVal.innerHTML = res;
				
				  $('#example').DataTable( {
				        dom: 'Qlfrtip',
				        rowNum:5,
				        rowList:[5,20,50],						
						sortname: 'drugName',
						rownumbers: false,
						viewrecords: true,
						sortorder: "desc",
						caption:"Indent Print ",
						editable: false, 
						ignoreCase: true,
						 //footerrow: true,
						
					    autowidth: true,
					    height: 210,
				    });
			
			}
			if (document.getElementById("normalMsg").innerHTML != "")
				document.getElementById("normalMsg").style.display="";
			//alert("-----res-----"+res);					
	}	
	if (mode == "2") 
	{
				 
		var objVal1 = document.getElementById("catgComboId");
		    objVal1.innerHTML = "<select name = 'strItemCatgNo' id='strItemCatgNo' class='browser-default custom-select' onchange='getReqTypeCombo();' >"
				+ res + "</select>";
				
		    getReqTypeCombo();
				
	}
	if (mode == "3") 
	{
		var objVal1 = document.getElementById("reqTypeComboId");
	    objVal1.innerHTML = "<select name = 'strRequestTypeId' id='strRequestTypeId' class='browser-default custom-select' onchange='getDataTableOnSelection();' >"
			+ res + "</select>";
				
		getDataTableOnSelection();
				
	}
		
		
}	


function searchOutList() {
	searchOutListBox("strRightItemIds", document.forms[0].searchOutVal.value);
}
function Backbtn()
{	    
	//cancelIssue();
	//alert(document.getElementsByName("strId")[0].value);
		document.forms[0].hmode.value="RETURNTOMAINDESK";
		document.forms[0].submit();
}

function getReport()
{

	   var issueNo    = "0";
	   var storeId    = document.forms[0].strStoreId.value;
	  
	   var IndentNo   = document.forms[0].strLpRequestNo.value;
	   var IndentDate = document.forms[0].strRequestDate.value;
	   var CrNo       = document.forms[0].strCrNo.value;
	   var raisingStoreId = document.forms[0].strRaisingStoreId.value;
		if(IndentNo!="0" && IndentNo != "" )
		{
			var hmode = "ISSUEDTLSINIT";
			var url = "IndentTransNEWCNT.cnt?hmode=" + hmode + "&strMode=1&strStoreId=" + storeId + 
					"&strIssueNo=" + issueNo+"&strIndentNo="+IndentNo+"&strIndentDate="+IndentDate+"&crNo="+CrNo+"&strRaisingStoreId="+raisingStoreId;
			
			ajaxFunction2(url, "1", "getIssueDtlsAjaxResponse");
		}
	
}

function getIssueDtlsAjaxResponse(res, mode) {

	//STOCKDTLSINIT
	if (mode == '1') 
	{

		var itemStockObj = document.getElementById("issueDtlsDivId");

		itemStockObj.innerHTML = res;

		popup('popUpDiv', '80', '60');

	}

}


function printDataOne() 
{
	newwin = window.open('', 'printwin',
			'left=100,top=100,width=700,height=700,scrollbars=yes');
	newwin.document.write('<HTML><HEAD>');
	newwin.document.write((document.getElementsByTagName("head")[0]).innerHTML);
	newwin.document.write('<style type="text/css"> .hidecontrol { display: none; } </style>\n')
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
	newwin.document.write(document.getElementById('issueDtlsDivId').innerHTML);		
	newwin.document.write('</BODY>\n');
	newwin.document.write('</HTML>\n');
	newwin.document.close();


}
function hideIssuePopupOne() 
{
	document.getElementById("issueDtlsDivId").innerHTML = "";
	hide_popup('popUpDiv');	

}


function openDiv()
{
	if(document.getElementsByName("strRaisingReqTypeId")[0].value=="13" || document.getElementsByName("strRaisingReqTypeId")[0].value=="12"){
		document.getElementById("patientDtlId").style.display="block";
	}
}
function view1(obj1,obj2,obj3)
{
	document.getElementById(obj1).style.display="none";
	document.getElementById(obj2).style.display="block";
	document.getElementById(obj3).style.display="block";
}
function view2(obj1,obj2,obj3)
{
	document.getElementById(obj1).style.display="block";
	document.getElementById(obj2).style.display="none";
	document.getElementById(obj3).style.display="none";
}

function openSpecification(obj,index)
{
	    var strItemDetail = document.getElementById("strItemDtl"+index).value;    
        var itemParamValue= document.getElementById("strItemParamValue"+index).value;    
        var myArray = strItemDetail.split("@");
        document.getElementById("popUpItemId").innerHTML="Balance Qty. Details";
        var myArray2=itemParamValue.split("@");      
        var objVal1 = document.getElementById("1");
       
        if(myArray[0]!='null' || myArray[0]!='')
        {
          objVal1.innerHTML = myArray2[0]+" "+myArray[1];
        }
        else
        {
          objVal1.innerHTML = "  ----";
        }  
              
        var objVal2 = document.getElementById("2");
        
        if(myArray[1]!='null')
        {
          objVal2.innerHTML = myArray[2]+" "+myArray[1];; 
        }
        else
        {
          objVal2.innerHTML = "  ----";
        }  
        display_popup_menu(obj,'itemDtlId','300','');
        	
	
}
function cancelToDesk()
{
	document.forms[0].hmode.value="RETURNTOMAINDESK";
	document.forms[0].submit();
}
function closeItemPopUp(divId)
{
 	hide_popup_menu(divId);
}