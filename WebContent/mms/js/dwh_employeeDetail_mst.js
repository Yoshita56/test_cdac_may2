function setLocalAddress()
{
		if(document.getElementsByName("strLocalAddressCheckbox")[0].checked==true)
		{
			document.getElementsByName("strLocalAddress")[0].value = document.getElementsByName("strPermanentAddress")[0].value;
			document.getElementById("localAddressTextAreaId").readOnly=true;
		}
		else if(document.getElementsByName("strLocalAddressCheckbox")[0].checked==false)
		{
			document.getElementsByName("strLocalAddress")[0].value="";
			document.getElementById("localAddressTextAreaId").readOnly=false;
			
		}
}


function getRelationshipCombo(obj)
{
	if(document.forms[0].strDependentName)
	{
			var dependentLength = document.getElementsByName("strDependentName").length - 1;
			
				if(dependentLength>1)
				{
					var relation_ship=document.getElementsByName("strRelationshipId");
					
					
						for(var j=0;j<dependentLength;j++)
						{
							if(obj!=relation_ship[j])
							{
								//alert(relation_ship[j].options[relation_ship[j].selectedIndex].value);	
								
								if(relation_ship[j].options[relation_ship[j].selectedIndex].value=='10' && obj.value=='10')
								{
									alert("Cannot choose father again");	
									obj.value='0';
								}	
								
								if(relation_ship[j].options[relation_ship[j].selectedIndex].value=='11'&& obj.value=='11')
								{
									alert("Cannot choose Mother again");	
									obj.value='0';
								}	
							}
						}
					}
	}		
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
       var objVal = document.getElementById("salutation_Id");
       objVal.innerHTML = "<select name = 'strSalutationValues' class='comboNormal' >" + res + "</select>";
    }  
    /*if(mode=="2")
    {
     var objVal = document.getElementById("ItemNameId");
     objVal.innerHTML = "<select name = 'strItemCategoryCmb' id='strItemCategoryCmb'>" + res + "</select>";
    }*/  
}


// For saving the data on Add Page
function validate1(mode)
{   

     
             var hisValidator = new HISValidator("employeeDetailMstBean");
             
	          hisValidator.addValidation("strEmpCode","req", "Please enter the Employee Code" );
	          hisValidator.addValidation("strGenderCode","dontselect=0","Please select the Gender" );
	          hisValidator.addValidation("strSalutationId","dontselect=0","Please select the Employee Name Salutation" );
	          hisValidator.addValidation("strFirstName","req", "Please enter the Employee First Name" );
  	          hisValidator.addValidation("strFatherName","req", "Please enter the Father  Name" );
  	          hisValidator.addValidation("strMotherName","req", "Please enter the Mother Name" );
  			  hisValidator.addValidation("strBirthDate", "date","Please select the Birth Date");
	  	      hisValidator.addValidation("strBirthDate","dtltet="+document.forms[0].strCurrentDate.value,"Please Select Birth Date Less Than or Equal To Current Date");
  	          hisValidator.addValidation("strDesigId","dontselect=0","Please select the Designation" );
  	          hisValidator.addValidation("strPermanentAddress","req", "Please enter the Permanent Address" );
			  hisValidator.addValidation("strPermanentAddress", "maxlen=250", "Permanent Address should have less than or equal to 250 Characters" );
	          hisValidator.addValidation("strLocalAddress","req", "Please enter the Local Address" );
  			  hisValidator.addValidation("strLocalAddress", "maxlen=250", "Local Address should have less than or equal to 250 Characters" );
 	          hisValidator.addValidation("strRemarks","maxlen=100", "Remarks should have less than or equal to 100 Characters" );
 	          if(document.getElementsByName("strJoiningDate")[0].value!="" )
 	          {
			    hisValidator.addValidation("strJoiningDate","dtltet="+document.forms[0].strCurrentDate.value,"Please Select Joining Date Less Than or Equal To Current Date");
 	         	hisValidator.addValidation("strBirthDate","dtlt="+document.forms[0].strJoiningDate.value,"Please Select Birth Date Less Than Joining Date");
 	         	 	
 	          }
			 
 
 					//For Dependent details
            		if(document.forms[0].strDependentName)
                	{
                		for(var k=0;k<document.getElementsByName("strDependentName").length;k++)
                		{
                			hisValidator.addValidation("strDependentName","req", "Please enter the Dependent Name" );
                			hisValidator.addValidation("strAge","req", "Please enter the Age" );
				          	hisValidator.addValidation("strRelationshipId","dontselect=0","Please select the Relationship" );
                		}
                	}
            
            
 		 var retVal = hisValidator.validate(); 

          if(retVal)
          {
     			if(mode.toString()=="Add")
     			{
     					   document.forms[0].hmode.value = "SAVE";	
     			}
                
                if(mode.toString()=="Modify")
                {
                	
                	//
                		var count=0;
                		if(document.forms[0].strDeleteCheckbox)
                		{
                			
                			if(document.getElementsByName("strDeleteCheckbox").length>0)
                			{
                				/*var flag = confirm("Are you sure you want to delete these records");
                				
                				if(flag==false)
                				{
                					return false;
                				}*/
                				
                				for(var i=0;i<document.getElementsByName("strDeleteCheckbox").length;i++)
                				{
                					if(document.getElementsByName("strDeleteCheckbox")[i].checked==true)
                					{
										count++;
                					}
                					else
                					{
                						document.getElementsByName("strDeleteCheckbox")[i].value='0';
                					}
                					
                				}
                				if(count>0)
                				{
                					var flag = confirm("Are you sure you want to delete the Selected Records For Entered Dependent Details ? ");
                				
	                				if(flag==false)
	                				{
	                					return false;
	                				}	
                				}
                				
                			}
                		}
     					   document.forms[0].hmode.value = "UPDATE";	
     			}
                 	   
                       document.forms[0].submit();
          }
          else
          {
             return false;
          }
}



function tableShow(strTableId, imageElement) {
	var elementTable = document.getElementById(strTableId);
	elementTable.style.display = "table";
	var strOnclick = "tableHide('" + strTableId + "',this);";
	imageElement.setAttribute("onclick", strOnclick);
	imageElement.setAttribute("src", "../../hisglobal/images/minus.gif");

}

function tableHide(strTableId, imageElement) {

	var elementTable = document.getElementById(strTableId);
	elementTable.style.display = "none";
	var strOnclick = "tableShow('" + strTableId + "',this);";
	imageElement.setAttribute("onclick", strOnclick);
	imageElement.setAttribute("src", "../../hisglobal/images/plus.gif");

}


function clearMsg(strTmp)
{
	document.forms[0].hmode.value = strTmp;
	document.forms[0].submit();
}

function setDeleteRecord()
{
	
}
	

	
function generateSlNo()
{
	 var depNamelength= document.getElementsByName("strDependentName").length - 1;
     
    // alert("depNamelength: "+depNamelength);
     
     for(var i=0;i<depNamelength;i++)
     {
     	document.getElementsByName("strSNo")[i].value=i+1;
     	
     }
}

function viewData(form1) 
{

	var chkObj = document.getElementsByName("chk");
	
	var len = chkObj.length;

	var countChk = 0;

	for ( var i = 0; i < len; i++)
		if (chkObj[i].checked)
			countChk = countChk + 1;

	if (countChk != 1) 
	{
		alert("Please Select One Record!!!");
		return false;
	}
	

	for ( var i = 0; i < len; i++) 
	{

		if (chkObj[i].checked) 
		{
			url = 'EmployeeDetailMstCNT.cnt?hmode=GETVIEWPAGE' + '&chk=' + chkObj[i].value;
			window.open(url, "popupWindow",	"width=610,height=450,top=250,left=350,scrollbars=yes");
		}
	}

}