
function getUnitValues()
 {

	var deptId = document.forms[0].strDeptId.value;
	
	
		//alert("deptId"+deptId);
		var url = "DrugDistributionMonitoringDetailTransCNT.cnt?hmode=UNITCMB&deptId="
				+document.forms[0].strDeptId.value;
		
		ajaxFunction(url, "1");
	
}



function getAjaxResponse(res, mode)
{
	

  var err = document.getElementById("errMsg");
      var temp = res.split("####");
      if(temp[0] == "ERROR")
	  {
          	err.innerHTML = temp[1];
          	return;
      } 

	if (mode == "1") 
	{
		if (res == "")
		{
			document.getElementById("unitDivId").innerHTML = "<select  name ='strUnitId' class='comboNormal' ><option value='0'>Select Value</option></select>";
		} else 
		{
			var objVal = document.getElementById("unitDivId");
			objVal.innerHTML = "<select name ='strUnitId' class='comboNormal' >" + res + "</select>";
					
					
		}
	}	
	
	if(mode=="2")
    {
       var objVal = document.getElementById("patientDetailsDivId");
       objVal.innerHTML = res;
    }  
    
    if(mode=="3")
    {
    	
    	
    	if (res == "")
		{
       		document.getElementById("issuedDetailsDivId").innerHTML = "<select  name ='strIssuedDtl' class='comboNormal'  ><option value='0'>Select Value</option></select>";
		} else 
		{
			 var objVal = document.getElementById("issuedDetailsDivId");
       
       		objVal.innerHTML = "<select name ='strIssuedDtl' class='comboNormal' onchange='getIssuedDrugDtls();'>" + res + "</select>";
       		
       		getPrescribedDtls();
		}
      
    }  
    
    if(mode=="4")
    {
    	
    	
//    	if (res == "")
//		{
//       		document.getElementById("prescribedDetailsDivId").innerHTML = "<select  name ='strPrescribedDtl' class='comboNormal' ><option value='0'>Select Value</option></select>";
//		}
//		 else 
//		{
//			// var objVal = document.getElementById("prescribedDetailsDivId");
//       
//       		//objVal.innerHTML = "<select name ='strPrescribedDtl' onchange='getScanFlag();'  class='comboNormal' >" + res + "</select>";
//		}  	
    	      
    	      document.getElementById("issuedAndPrescribedDetailsLabelDivId").style.display='';
    	      
    	      getIssuedDrugDtls();
    }  
    
    
     if(mode=="5")
    {
    	
    	
    	if (res == "")
		{
       		document.getElementById("issuedDrugDtlsDivId").innerHTML = "";
		}
		 else 
		{
			 var objVal = document.getElementById("issuedDrugDtlsDivId");
       
       		objVal.innerHTML = res;
		}  	
    	      
    	      document.getElementById("issuedDrugDtlsDivId").style.display='';
    	      OnLoadCheck();
    	      getScanFlag();
    }  
    
    
    if (mode == "6") 
	{
		
		autoTabIndexing();
		
		//document.getElementById("strScanDocDivId").style.display='';
		 //document.getElementById("strScanButnDivId").style.display='';
			 
		 var objVal = document.getElementById("strScanButnDivId");
		 if(res == '0')
		 {		 
		 	
		   objVal.src = "/AHIMS/hisglobal/images/Red.png";
		    
		   objVal.title = "Scanned Document Not Avalaible";
		   document.forms[0].strScanDocFlg.value=res;
		   
		 }
		 else
		 {
		 	objVal.src = "/AHIMS/hisglobal/images/Green.png";
		 	objVal.title = "Click Here To Get Scanned Document";
		 	 
		 	
		    document.forms[0].strScanDocFlg.value=res;
		 }
				 
				 
		document.getElementById("strScanButnDivId").focus();	 
		//document.getElementById("strScanButnDivId").select();	 
		 
				 
	}
}		


function searchPatientDtls()
{
	
	
		var hisValidator = new HISValidator("drugDistributionMonitoringDetailTransFB");
 		 	
        
        hisValidator.addValidation("strFromDate", "date","From Date is a mandatory field");
		hisValidator.addValidation("strToDate", "date","To Date is a mandatory field");
		hisValidator.addValidation("strToDate","dtltet="+document.forms[0].strCurrentDate.value,"Please Select To Date Less Than or Equal To Current Date");
		hisValidator.addValidation("strToDate","dtgtet="+document.forms[0].strFromDate.value,"Please Select To Date Greater Than Or Equal To From Date");
 
            var retVal = hisValidator.validate();
            hisValidator.clearAllValidations(); 
   
   var diffdate = dateDiff1(document.forms[0].strFromDate.value,document.forms[0].strToDate.value); 
 	//alert(diffdate);
 	 if(parseInt(diffdate)>30)
 	 {
 		alert("Difference Between From Date and To Date Should not be greater than 30 days");
 		return false;
 	 }
   
	
	if(retVal)
	{
		var crNo = document.forms[0].strCrNo.value;
		var patientName = document.forms[0].strPatientName.value;
		var deptId = document.forms[0].strDeptId.value;
		var unitId = document.forms[0].strUnitId.value;
				
		var fromDate = document.forms[0].strFromDate.value;
		var toDate = document.forms[0].strToDate.value;
				
		var url="DrugDistributionMonitoringDetailTransCNT.cnt?hmode=searchPatientDtls" +
				"&crNo="+crNo+"&patientName="+patientName+
				"&deptId="+deptId+"&unitId="+unitId+
				"&fromDate="+fromDate+"&toDate="+toDate;
				
				
		 document.getElementById("patientDetailsDivId").innerHTML = "";
		 document.getElementById("issuedDrugDtlsDivId").innerHTML = "";
		 document.getElementById("issuedDetailsDivId").innerHTML = "";
		// document.getElementById("prescribedDetailsDivId").innerHTML = "";
		 
		 document.getElementById("issuedAndPrescribedDetailsLabelDivId").style.display = 'none';
		 
		// document.getElementById("strScanDocDivId").style.display = 'none';
		 
		 
//		 document.getElementById("strScanDocDivId").innerHTML = "";
		 
		 
       		
				
   		 ajaxFunction(url,"2");   		
			
			
	}
	else
	{
		return false;
	}
}




function validate1(){


 	
}

function cancelPage(){
	document.forms[0].hmode.value="CANCEL";
	document.forms[0].target = "_self";
	document.forms[0].submit();

}


function clearIssue() 
{
	
	              var conf = confirm("Do you want to reset the data?");
                   if(conf == true)
                   {
                       var conf1 = confirm("Are you sure !!!");
                       if(conf1 == true)
                       {
                           
                            document.forms[0].strPatientName.value = "";
                            document.forms[0].strCrNo.value = "";
                            
							document.forms[0].strDeptId.value = "0";
							document.forms[0].strUnitId.value = "0";
							var url;
							var mode = "INITVAL";
							document.forms[0].hmode.value = mode;
							document.forms[0].submit();
                       }
                      else
                       {
                         return false;
                       }
                   }
                  else
                   {
                         return false;
                   }
  	    		 		
	
}


function cancelPage(){
	document.forms[0].hmode.value="CANCEL";
	document.forms[0].target = "_self";
	document.forms[0].submit();

}


function getIssuedDtls()
{
	var objVal = document.getElementsByName("strPatientDtls");
	
	for(var i = 0; i < objVal.length; i++)
	{
		if(objVal[i].checked==true)
		{
			var	crNo	= objVal[i].value.split("^")[0];
			var deptId	= objVal[i].value.split("^")[1];
			var unitId	= objVal[i].value.split("^")[2];
			var fromDate = document.forms[0].strFromDate.value;
			var toDate = document.forms[0].strToDate.value;
		}
	}
	
	
	var url="DrugDistributionMonitoringDetailTransCNT.cnt?hmode=getIssuedDtls" +
				"&crNo="+crNo+
				"&deptId="+deptId+"&unitId="+unitId+
				"&fromDate="+fromDate+"&toDate="+toDate;
				
				
   		 ajaxFunction(url,"3");   		
}

function getIssuedDrugDtls()
{
	var url="DrugDistributionMonitoringDetailTransCNT.cnt?hmode=getIssuedDrugDtls" +
				"&issueNo="+document.forms[0].strIssuedDtl.value;
				
				
   		 ajaxFunction(url,"5");   
	
}


function getPrescribedDtls()
{
	var objVal = document.getElementsByName("strPatientDtls");
	
	for(var i = 0; i < objVal.length; i++)
	{
		if(objVal[i].checked==true)
		{
			var	crNo	= objVal[i].value.split("^")[0];
			var deptId	= objVal[i].value.split("^")[1];
			var unitId	= objVal[i].value.split("^")[2];
			var fromDate = document.forms[0].strFromDate.value;
			var toDate = document.forms[0].strToDate.value;
		}
		
	}
	
	
	var url="DrugDistributionMonitoringDetailTransCNT.cnt?hmode=getPrescribedDtls" +
				"&crNo="+crNo+
				"&deptId="+deptId+"&unitId="+unitId+
				"&fromDate="+fromDate+"&toDate="+toDate;
				
   		 ajaxFunction(url,"4");   		
}


function getVisitForScanDocPopup()
{
	var objVal = document.getElementsByName("strPatientDtls");
	var unitObj=document.forms[0].strUnitId;
	var deptUnit="0";
	var crNo="0";
	var index;
	var strVisitNo="0";
	
	
	for(var i = 0 ; i < objVal.length; i++)
    {
		if(objVal[i].checked)
		{
			index=i;
			crNo=objVal[i].value.split("^")[0];
			deptUnit=objVal[i].value.split("^")[2];
			break;
		}
		
    }
	var popUrl = "DrugDistributionMonitoringDetailTransCNT.cnt?hmode=GETEPISODEVISITPOPUP"+
				"&strCrNo="+ crNo+
				"&strUnitCode="+deptUnit+
				"&strVisitNo="+strVisitNo+
				"&strScanDocFlg="+document.forms[0].strScanDocFlg.value+
				"&index="+index;
	//alert("popUrl :"+popUrl);
	window.open(popUrl,"GETEPISODEVISITPOPUP","height=250,width=350,scrollbars=yes");
    
}

function getScanDocPopup(episodeCode)
{
	//child.close();
	if(episodeCode!='0')
	{	
		if(document.forms[0].strScanDocFlg.value=='1')
		{ 
			var epiVisitNo=document.forms[0].strVisitNo.value.split("^")[0];
			 var scanPopupUrl = "/AHIMS/scanning/viewScannedTile.cnt?patCrNo="+document.forms[0].strCrNo.value+
			 					"&episodeVisitNo="+epiVisitNo+"&episodeCode="+episodeCode+"&strDocTypeId=10";
			 //alert("scanPopupUrl :"+scanPopupUrl);	
			 var child = window.open(scanPopupUrl,'popupWindow','status=yes,scrollbars=yes,height=700,width=800,left=10,top=10');  
			 child.moveTo(250,250);
			 child.focus();
		}
		else
		{
			alert("Scan Document not Avalaible!!!!");
			return false;
		}  	
	  }
	else
	{
	  	alert("Please Select Visit!!!");
	  	return false;
	}
}

function getScanFlag()
{
	var objVal = document.getElementsByName("strPatientDtls");
	var unitObj=document.forms[0].strUnitId;
	var deptUnit="0";
	var crNo="0";
	var index;
	var strVisitNo="0";
	/*if(unitObj.value=="0"){
		for(var i=0; i<unitObj.length; i++){
			var deptUnit=unitObj.value.split("^")[0];
			if(deptUnit!="" && deptUnit==)
		}
	}*/	
	/*for(var i = 0 ; i < objVal.length; i++)
    {
		if(objVal[i].checked)
		{
			index=i;
			crNo=objVal[i].value.split("^")[0];
			deptUnit=objVal[i].value.split("^")[2];
			break;
		}
		
    }
	var popUrl = "DrugDistributionMonitoringDetailTransCNT.cnt?hmode=GETEPISODEVISITPOPUP&crNo="+ crNo+"&strUnitCode="+deptUnit+"&strVisitNo="+strVisitNo;
	alert("popUrl :"+popUrl);
    openPopUp(popUrl,'700','400','1',null);*/
	 	//window.open(url,"popupWindow","width=610,height=390,scrollbars=yes");
	 	
	//if(document.forms[0].strUnitId.value.split("^")[2]!='0')
    //{	
    	
    	for(var i = 0 ; i < objVal.length; i++)
    	{
    		
    		if(objVal[i].checked==true)
    		{
    			 var url = "DrugDistributionMonitoringDetailTransCNT.cnt?hmode=GETSCANEDDOC&crNo=" + objVal[i].value.split("^")[0]
	  			+"&strEpisodeCode=0";
			
				ajaxFunction(url, "6");
    		}
    		
    	}
    	
    	
	 
    //} 
    //else
    //{
  	//   document.forms[0].strScanDocFlg.value="0";
  	   
  	   
	//autoTabIndexing();
	
	
	//document.getElementById("strScanButnDivId").focus();
  	   
    //}
	  	
}



function hideIssueDetails(divId) {
	hide_popup_menu(divId);
}

function goFuncOnEnterOne(e) 
{
	  
	
	if (e.keyCode == 13) 
	{
		getVisitForScanDocPopup();
	} 
	else 
	{
		return false;
	}
}



function initGoFunc(eve) 
{
	var flag = validateData(eve, 5);
	if (flag) 
	{
		
	}
	else
	{
		return false;
	}

}

function OnLoadCheck()
{	
   /*Color Change for SDF Durg
    * */
              
              var sdfFlg   = document.getElementsByName("strSDFFlag");
              
              //alert("sdfFlg"+sdfFlg);
              var colorOne = document.forms[0].strSDFFlgColor.value;
              
					          	  for(var i = 0; i < sdfFlg.length ; i++)
								  {				
								  	//alert("sdfFlg[i]"+sdfFlg[i].value);													  
								   if(sdfFlg[i].value=='Yes')
								   {
								   	//alert("Inside"+i);
							       	  document.getElementById("tdId1"+i).style.backgroundColor = colorOne; 
									  document.getElementById("tdId2"+i).style.backgroundColor = colorOne;
									  document.getElementById("tdId3"+i).style.backgroundColor = colorOne;
									  document.getElementById("tdId4"+i).style.backgroundColor = colorOne;
									 // document.getElementById("tdId5"+i).style.backgroundColor = colorOne;
									//  document.getElementById("tdId6"+i).style.backgroundColor = colorOne;
									//  document.getElementById("tdId7"+i).style.backgroundColor = colorOne;
									//  document.getElementById("tdId8"+i).style.backgroundColor = colorOne;
								   }
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

