	function controlToMainPage()
	{
		document.forms[0].hmode.value="LISTPAGETOMAINPAGE";
		document.forms[0].submit();
	}
	
function GetIndex(index,endVal){
   
       for(var i = 1; i <= endVal ; i++)
	  {
	 
	    document.getElementById("DivId"+i).style.display="none";
	  }
		
		  document.getElementById("DivId"+index).style.display="block";
		 
}
function fetchDiscrepancyReport(){
	
  
   if(document.forms[0].strGroupId.value!="0"){
	   var mode="NONDISCREPANCYREPORT"
	   var url="PhyStockVerificationTransCNT.cnt?hmode="+mode+"&storeId="+document.forms[0].strStoreId.value+"&stockNo="+document.forms[0].strStockNo.value+
	   "&groupId="+document.forms[0].strGroupId.value;
	   ajaxFunction(url,"1"); 
	}else{
		alert('Please Select Group Combo');
		document.forms[0].strGroupId.focus();
	}
	

}

function openSpecification(obj1,obj,index)
{
	   
       
        
        var strItemDetail = document.getElementById(obj1+index).value;     
      
       
        myArray = strItemDetail.split("@");
        
        document.getElementById("popUpItemId").innerHTML="Item Details-"+myArray[0];
        //alert("myArray--size"+myArray.length);
       
        var objVal1 = document.getElementById("1");
       
        if(myArray[0]!='null' || myArray[0]!='')
        {
          objVal1.innerHTML = myArray[1];
        }
        else
        {
          objVal1.innerHTML = "  ----";
        }  
              
        var objVal2 = document.getElementById("2");
        
        if(myArray[1]!='null')
        {
          objVal2.innerHTML = myArray[2];
        }
        else
        {
          objVal2.innerHTML = "  ----";
        }  
        
          objVal2 = document.getElementById("3");
        
        if(myArray[1]!='null')
        {
          objVal2.innerHTML = myArray[3];
        }
        else
        {
          objVal2.innerHTML = "  ----";
        }  
        display_popup_menu(obj,'itemDtlId','300','');
        	
	
}

function closeItemPopUp(divId)
{
 	hide_popup_menu(divId);
}


function getAjaxResponse(res,mode)
 {
     
    
     /* var err = document.getElementById("errMsg");
      var temp = res.split("####");
      if(temp[0] == "ERROR")
	  {
          	err.innerHTML = temp[1];
          	return;
      } */
     if(mode=="1")
     {
        var objVal1 = document.getElementById("paginationNonDisId");
        objVal1.innerHTML = res;
     }
     if(mode=="2")
     {			
		document.getElementById("memberDtlInner").innerHTML=res;	
	 }
	  if(mode=="3")
     {			
			
		document.getElementById("batchWiseId").innerHTML=res
		display_popup_menu(obj,'batchWiseId','300','');
		
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
function getMemberDtl(mode)
{
	var mode=mode
	var url="PhyStockVerificationTransCNT.cnt?hmode="+mode+"&committeType="+document.forms[0].strCommitteeTypeId.value+"&catgCode="+document.forms[0].strItemCategNo.value;
	//alert(url);
	ajaxFunction(url,"2");
}
 
 function openDivPopu()
{
		if(document.getElementsByName("strCommitteeTypeId")[0].value=="0")
   	 	{
   	 		alert("Please Select Committee Type")
   	 	}
 	 	else{
  			 popup('memberDtl' , '130','250');
  		}
}
function closePopUpDiv()
{
	hide_popup('memberDtl');
}
function clearData()
{
	var size=document.getElementsByName("strMemberRecommendation").length;
	if(size>1){
		for(var i=0;i<size;i++){
			document.getElementsByName("strMemberRecommendation")[i].value="";
		}
	}
	else{
		document.getElementsByName("strMemberRecommendation")[0].value="";
	}
}
var obj=""
 function openBatchwiseDtl(objStr,objVal,index){
 var strId="";
 var strStockNo="";
 var strItemId="";
 var strItemBrandId="";
 var myArray=document.getElementById(objStr+index).value.split("@");
 var mode="BATCHWISEDTL";
 strId=myArray[0];
 strStockNo=myArray[1];
 strItemId=myArray[2];
 strItemBrandId=myArray[3];
 obj=objVal;
 
  var url="PhyStockVerificationTransCNT.cnt?hmode="+mode+"&strId="+strId+"&stockNo="+strStockNo+"&itemId="+strItemId+"&itemBrandId="+strItemBrandId;
  ajaxFunction(url,"3");

  }
  
  
  function save()
{
	  var hisValidator = new HISValidator("physicalStockVerificationBean");
	  var retVal=true;
 	 hisValidator.addValidation("strCommitteeTypeId","dontselect=0","Please Select Committee Type" );
 	 hisValidator.addValidation("strRemarks","req","Final Remarks is mandatory Field" );
	 hisValidator.addValidation("strRemarks", "maxlen=100", "Final Remarks should have less than or equal to 100 Characters" );

     var retVal = hisValidator.validate(); 
     hisValidator.clearAllValidations();
    	 if(retVal)
    	 {
    	 	
    	 	                          var conf = confirm("You Are Going To Save Records");
					                  if(conf == true)
					                  {
					                       var conf1 = confirm("Are you sure !!!");
					                       if(conf1 == true)
					                       {					                       	 
					                          document.forms[0].hmode.value = "REVIEWUPDATE";
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
		else
		{
			return false;
		}
}
  
  