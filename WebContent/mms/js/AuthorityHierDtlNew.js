
/** This is the validate function for day end transaction jsp file
 *  i.e:- dayend_billtrans.jsp and 
 *  transfer control to the controller 'PROCESS' method.  
 */
 
 function validate1()
 {
     
	  var hisValidator = new HISValidator("authHierTransBean");  
	  hisValidator.addValidation("strStoreName","dontselect=0","Please select a value from Drug Warehouse Name Combo" );
	  hisValidator.addValidation("strItemCatCmb","dontselect=0","Please select a value from Item Category Combo" );
	  hisValidator.addValidation("strReqTypeCmb","dontselect=0","Please select a value from Request Type Combo" );
	  hisValidator.addValidation("strRemarks","req","Remarks is a Mandatory Field" );
	 /* hisValidator.addValidation("chk_1text","req","Level corresponding to selected record should be entered!!" );
	  hisValidator.addValidation("chk_2text","req","Level corresponding to selected record should be entered!!" );
	  hisValidator.addValidation("chk_3text","req","Level corresponding to selected record should be entered!!" );
	  hisValidator.addValidation("chk_4text","req","Level corresponding to selected record should be entered!!" );*/
	  hisValidator.addValidation("strRemarks", "maxlen=100", "Remarks should have less than or equal to 100 Characters" );
	  var retVal = hisValidator.validate(); 
	  if(retVal==true)
	  {
	    var chk_1Obj=document.getElementsByName("chk_1");
	    var chk_2Obj=document.getElementsByName("chk_2");
	    var chk_3Obj=document.getElementsByName("chk_3");
	    var chk_4Obj=document.getElementsByName("chk_4");
	    var chk_1textObj=document.getElementsByName("chk_1text");
	    var chk_2textObj=document.getElementsByName("chk_2text");
	    var chk_3textObj=document.getElementsByName("chk_3text");
	    var chk_4textObj=document.getElementsByName("chk_4text");
	    var nChecked="0";
	    var nTxtBlank="0";
	    var myArrObjs=new Array(chk_1Obj,chk_2Obj,chk_3Obj,chk_4Obj);
	    var myArrTxtObjs=new Array(chk_1textObj,chk_2textObj,chk_3textObj,chk_4textObj);
	    var hLevelTypObj=document.getElementsByName("hLevelType");
	    var max="0";
	    for(var i=0;i<4;i++)
	    {
	      max="0";
	      for(var j=0;j<myArrObjs[i].length;j++)
	      {
	        if(myArrObjs[i][j].checked)
	        {
	          nChecked=parseInt(nChecked)+1;
	          if(myArrTxtObjs[i][j].value=="")
	             nTxtBlank=parseInt(nTxtBlank)+1;
	          else
	          {
	          	if(parseInt(myArrTxtObjs[i][j].value)>parseInt(max))//for storing max values for a level
	          	  max=myArrTxtObjs[i][j].value;
	          }   
	        }  
	      }
	      hLevelTypObj[i].value=max;
	    }
	    if(nChecked=="0")
	    {
	      alert("At Least one entry corresponding to any Level should be done.!!!");
	      retVal=false;
	    } 
	    if(nTxtBlank!="0")
	    {
	      alert("Level against selected record cannot be left blank.!!!");
	      retVal=false;
	    } 
      }
      
      // finally submit on true validate
	  if(retVal)
	  {
		  // Storing Max values for raise,admin1,rec,admin2
         var hLevelTypeLen=document.forms[0].hLevelType.length;
         var strTemp="";
         for(var i=0;i<hLevelTypeLen;i++)
         {
          if(i==0)
            strTemp=hLevelTypObj[i].value;
          else
            strTemp=strTemp+"^"+hLevelTypObj[i].value;   
         }
         //alert("maxLevTyp->"+strTemp);
         document.forms[0].strLevelTypeMaxval.value=strTemp;
		 document.forms[0].hmode.value="INSERT";
	     document.forms[0].submit();
	  }
	  else
	  {
		 return false;
	  }
 }
	 

function cancel()
{
	document.forms[0].hmode.value="INITIALPAGE";
    document.forms[0].submit();
}
 

function initPage()
{
  document.forms[0].hmode.value="FIRSTDATA";
  document.forms[0].submit();
}
/*
function storeChng()
{
  document.forms[0].hmode.value="FIRSTDATA";
  alert("hlevTypAjax->"+document.forms[0].hlevTypAjax.value);
  if(document.forms[0].hlevTypAjax.value!="0")
    document.forms[0].storePersist.value=document.forms[0].strStoreName.value;
  document.forms[0].submit();
}

function initStoreCmb()
{
 document.forms[0].strStoreName.value=document.forms[0].storePersist.value;
}*/

 function cancel()
 {
        document.getElementById("errMsg").innerHTML = "";
	 	document.forms[0].hmode.value = "CANCEL";
  	    document.forms[0].submit();
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
        var objVal1 = document.getElementById("raisingId");
        var objVal2 = document.getElementById("adminLevel1Id");
        var objVal3 = document.getElementById("receivingId");
        var objVal4 = document.getElementById("adminLevel2Id");
        var myArr=new Array();
       // alert("res->"+res);
       // alert("res->"+res);
        myArr=res.split("####");
        document.forms[0].strUpdateAuthNo.value=myArr[1];
        //alert("strUpdateAuthNo->"+document.forms[0].strUpdateAuthNo.value);
        myArr=myArr[0].split("###");
       /* 
        alert("res1->"+myArr[0]);
        alert("res2->"+myArr[1]);
        alert("res3->"+myArr[2]);
        alert("res4->"+myArr[3]);
        */
        objVal1.innerHTML = myArr[0];
        objVal2.innerHTML  = myArr[1];
        objVal3.innerHTML  = myArr[2];
        objVal4.innerHTML  = myArr[3];
     }
     if(mode=="2")
     {
     	//alert("mode:2::res->"+res);
     	var objVal1 = document.getElementById("itemCmbDIV");
     	objVal1.innerHTML="<select name='strItemCatCmb' class='form-control' onChange='itemCatCmbChng(this);'>"+res+"</select>";
     }
     if(mode=="3")
     {
     	//alert("mode:3::res->"+res);
     	var objVal1 = document.getElementById("reqTypeCmbDIV");
     	objVal1.innerHTML="<select name='strReqTypeCmb' class='form-control' onChange='reqTypCmbChng(this)'>"+res+"</select>";
     }
     if(mode=="4")
     {
    	 var remarksAndApprovalFlag=res.split("^");
     	var remarks = document.getElementById("strRemarks");
     	var eleApprovalFlag = document.getElementById("strApprovalFlag");
     	remarks.value=remarksAndApprovalFlag[0];
     	eleApprovalFlag.value=remarksAndApprovalFlag[1];
     	displayReceivingEnd();
     	
     }
}
function itemCatCmbChng(obj)
{
	var myArr=new Array();
	myArr=(document.forms[0].strStoreName.value).split("^");
    var mode ="REQTYPCMB";  
    var url="AuthorityHierDtlBSCNT.cnt?hmode="+mode+"&storeId="+myArr[0]+"&itemCatNo="+obj.value;
    ajaxFunction(url,"3");
    var objVal1 = document.getElementById("raisingId");
    var objVal2 = document.getElementById("adminLevel1Id");
    var objVal3 = document.getElementById("receivingId");
    var objVal4 = document.getElementById("adminLevel2Id");
    view2('raisingPlusId','raisingMinusId','raisingId');
    view2('adminLevel1PlusId','adminLevel1MinusId','adminLevel1Id');
    view2('receivingPlusId','receivingMinusId','receivingId');
    view2('adminLevel2PlusId','adminLevel2MinusId','adminLevel2Id');
    objVal1.innerHTML="";
    objVal2.innerHTML="";
    objVal3.innerHTML="";
    objVal4.innerHTML="";
    var remarks = document.getElementById("strRemarks");
	remarks.value="";
    document.forms[0].hlevTypAjax.value="0";
}

function reqTypCmbChng(obj)
{
	var objVal1 = document.getElementById("raisingId");
    var objVal2 = document.getElementById("adminLevel1Id");
    var objVal3 = document.getElementById("receivingId");
    var objVal4 = document.getElementById("adminLevel2Id");
    view2('raisingPlusId','raisingMinusId','raisingId');
    view2('adminLevel1PlusId','adminLevel1MinusId','adminLevel1Id');
    view2('receivingPlusId','receivingMinusId','receivingId');
    view2('adminLevel2PlusId','adminLevel2MinusId','adminLevel2Id');
    objVal1.innerHTML="";
    objVal2.innerHTML="";
    objVal3.innerHTML="";
    objVal4.innerHTML="";
    document.forms[0].hlevTypAjax.value="0";
    setAuthHierDetailsRemarks();
}

function storeCmbChng(obj)
{
    var myArr=new Array();
	myArr=(obj.value).split("^");
    var mode ="ITEMCATCMB";  
    var url="AuthorityHierDtlBSCNT.cnt?hmode="+mode+"&storeId="+myArr[0];
    ajaxFunction(url,"2");
    
    var objVal1 = document.getElementById("raisingId");
    var objVal2 = document.getElementById("adminLevel1Id");
    var objVal3 = document.getElementById("receivingId");
    var objVal4 = document.getElementById("adminLevel2Id");
    var objRqTy = document.getElementById("reqTypeCmbDIV");
    view2('raisingPlusId','raisingMinusId','raisingId');
    view2('adminLevel1PlusId','adminLevel1MinusId','adminLevel1Id');
    view2('receivingPlusId','receivingMinusId','receivingId');
    view2('adminLevel2PlusId','adminLevel2MinusId','adminLevel2Id');
    objVal1.innerHTML="";
    objVal2.innerHTML="";
    objVal3.innerHTML="";
    objVal4.innerHTML="";
    var remarks = document.getElementById("strRemarks");
	remarks.value="";	
    objRqTy.innerHTML="<select name='strReqTypeCmb' class='form-control'><option value='0'>Select Value</option></select>";
    document.forms[0].hlevTypAjax.value="0";
}

function setAuthHierDetailsRemarks() {
	var storeId =document.forms[0].strStoreName.value;
	var itemCategory =document.forms[0].strItemCatCmb.value;
	var requestType = document.forms[0].strReqTypeCmb.value;
	
	var arr_storidToken=storeId.split('^');
	storeId=arr_storidToken[0];
	
	/*
	alert( "storeName=" + storeId
			+ "\nitemCategory=" + itemCategory
			+ "\nrequestType="  + requestType );
	*/
	if(storeId!="0" && itemCategory!="0" && requestType!="0") {
		var url="AuthorityHierDtlBSCNT.cnt?hmode=getRemarks&storeId="+storeId+"&itemCatNo="+itemCategory+"&reqTypeId="+requestType;
    	ajaxFunction(url,"4");
	} else {
		var remarks = document.getElementById("strRemarks");
		remarks.value="";	
	}
}
 
    