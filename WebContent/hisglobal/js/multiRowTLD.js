/*
 * Made By :: Deepak Tewari
 * 
 * Advantages :: Efficient than previous Multi-Row
 * 
 * Please remove Changes done at Line :: 277 & 293 for full functionality
 */

var mode= new Array();

var multiRowDIV= new Array();

var elementArray=new Array();

    elementArray=[
                   [],[],[],[],[],[],[]
                 ];

var first="0";

var rowString= new Array("","","","","","","");

var rowsObjs = new Array();

var nRowsVisibleTmp = new Array();

var nMultiRowIdTmp = new Array();

var divObjsArray =  new Array();

    divObjsArray =  [
                      [],[],[],[],[],[],[]
                    ];

var addUserEventHandlerFunc =new Array(); 

function initMultiRow(div,modeVal,rowsVisible,multiRowId,userEventHandler)
{
	mode[multiRowId]                    = modeVal;
	
	multiRowDIV[multiRowId]             = div;
	
	first                               = "0";
	
	nRowsVisibleTmp[multiRowId]         = rowsVisible;
	
	nMultiRowIdTmp[multiRowId]          = multiRowId;
	
	addUserEventHandlerFunc[multiRowId] = userEventHandler;
	
	var divObjsInput                    = document.getElementById("multiRowTableId#"+multiRowId).getElementsByTagName("input");
	
	var divObjsSelect                   = document.getElementById("multiRowTableId#"+multiRowId).getElementsByTagName("select");
	
	var divObjsTextArea                 = document.getElementById("multiRowTableId#"+multiRowId).getElementsByTagName("textarea");
	
	var divObjsAnchor                   = document.getElementById("multiRowTableId#"+multiRowId).getElementsByTagName("a");
	
	var divObjsImg                      = document.getElementById("multiRowTableId#"+multiRowId).getElementsByTagName("img");
	
	var divObjsDIV                      = document.getElementById("multiRowTableId#"+multiRowId).getElementsByTagName("div");
	
	var startIndex ;
	
	var endIndex ;
	
	var index;
	
	// Adding Div Elements to divObjs Array
	
	startIndex = 0;
	
	endIndex   = parseInt(startIndex) + parseInt(divObjsDIV.length);
	
	index = 0;
	
	for(var i=startIndex;i<endIndex;i++)
	{
		divObjsArray[multiRowId][i]=divObjsDIV[index].id;
		
		index = parseInt(index) + 1;
	}
	
	// Adding Input Tag Elements
	
	startIndex = 0;
	
	endIndex   = parseInt(startIndex) + parseInt(divObjsInput.length);
	
	index = 0;
	
	for(var i=startIndex;i<endIndex;i++)
	{
		elementArray[multiRowId][i]=divObjsInput[index].name;
		
		index = parseInt(index) + 1;
	}
	
	// Adding Select Tag Elements
	
	startIndex = endIndex;
	
	endIndex   = parseInt(startIndex) + parseInt(divObjsSelect.length);
	
	index = 0;
	
	for(var i=startIndex;i<endIndex;i++)
	{
		elementArray[multiRowId][i]=divObjsSelect[index].name;
		
		index = parseInt(index) + 1;
	}
	
	// Adding TextArea Tag Elements
	
	startIndex = endIndex;
	
	endIndex   = parseInt(startIndex) + parseInt(divObjsTextArea.length);
	
	index = 0;
	
	for(var i=startIndex;i<endIndex;i++)
	{
		elementArray[multiRowId][i]=divObjsTextArea[index].name;
		
		index = parseInt(index) + 1;
	}
	
	// Adding Anchor Tag Elements
	
	startIndex = endIndex;
	
	endIndex   = parseInt(startIndex) + parseInt(divObjsAnchor.length);
	
	index = 0;
	
	for(var i=startIndex;i<endIndex;i++)
	{
		elementArray[multiRowId][i]=divObjsAnchor[index].name;
		
		index = parseInt(index) + 1;
	}
	
	// Adding Img Tag Elements
	
	startIndex = endIndex;
	
	endIndex   = parseInt(startIndex) + parseInt(divObjsImg.length);
	
	index = 0;
	
	for(var i=startIndex;i<endIndex;i++)
	{
		elementArray[multiRowId][i]=divObjsImg[index].name;
		
		index = parseInt(index) + 1;
	}
}
function add(rowMinusImgName,multiRowId)
{
     /*
       mode -> 1. Last Row Delete Only
               2. Row Wise Delete
     */
     
     var objTableDIV  =document.getElementById("multiRowDivId#"+multiRowId);
     
     var objTableRes  =objTableDIV.innerHTML;
     
	 var typ          ="";
	 
	 var myArray      =new Array();
	 
	 var valArr       =new Array();
	 
	 var rowIndx      ="0";
	 
     if(rowString[multiRowId]=="")
     {
       rowString[multiRowId]=document.getElementById(multiRowDIV[multiRowId]).innerHTML;
       
       document.getElementById(multiRowDIV[multiRowId]).innerHTML="";
       
       document.getElementById(multiRowDIV[multiRowId]).style.display="none";
       
       if(rowString[multiRowId].indexOf("<TBODY>")!=-1)
       {
         myArray=rowString[multiRowId].split("<TBODY>");
         
         var temp=myArray[1];
         
         myArray=temp.split("</TBODY></TABLE>");
         
         rowString[multiRowId]=myArray[0];
       }
       else if(rowString[multiRowId].indexOf("<tbody>")!=-1)
       {
         myArray=rowString[multiRowId].split("<tbody>");
         
         var temp=myArray[1];
         
         myArray=temp.split("</tbody></table>");
         
         rowString[multiRowId]=myArray[0];
       }
       else
       {
       	 alert("BUG:Row String not properly set or coded.[FORMAT:<TABLE><TBODY>||Content..||</TBODY></TABLE>]");
       	 
       	 return false;
       }
     }  
    // rowString[multiRowId]=rowString[multiRowId].replace(/\"/g,'\''); // to replace double quotes with single quotes
    if(first!="0")
    {
	   rowIndx      =elementArray[multiRowId][0].length;
    }   
	   
	var len=elementArray[multiRowId].length;
	
	for(var i=0;(i<len) && (first=="0");i++)
	{
	   elementArray[multiRowId][i]=document.getElementsByName(elementArray[multiRowId][i]);
	}  
	if(first!="0")
	{
	   var start="0",end=parseInt(elementArray[multiRowId][0].length)-1,period="1";
	   
	   storePrevValues(start,end,period,valArr,multiRowId);
	}
	 
	/****** FOR REMOVING BLANK ROW ENTRIES IF ANY::START *******/
	
	if(objTableRes.indexOf("<tr></tr>")!=-1 || objTableRes.indexOf("<TR></TR>")!=-1)
	{
       if(objTableRes.indexOf("<tr></tr>")!=-1)
       {
          myArray=objTableRes.split("<tr></tr>");
       }
       else
       {
          myArray=objTableRes.split("<TR></TR>");
       }
       objTableRes=myArray[0];
       
       for(var i=1;i<myArray.length;i++)
       {
         objTableRes=objTableRes+myArray[i];
       } 
    } 
      
   /****** FOR REMOVING BLANK ROW ENTRIES IF ANY::END *******/    
     
     if(objTableRes.indexOf("</tbody></table>")!=-1)
     {
        myArray       =objTableRes.split("</tbody></table>");
     }   
     else
     {
        myArray       =objTableRes.split("</TBODY></TABLE>");
     }   
        
     myArray[1]       =rowString[multiRowId];
     
     objTableRes      =myArray[0]+myArray[1];
     
     objTableDIV.innerHTML=objTableRes;
     
     var minusDivSt = document.getElementById("multiRowMinusImgDivId#"+multiRowId);
     
     if(first!="0")
     {
       if(mode[multiRowId]=="1")
       {
     	  rowsObjs[multiRowId] = "0";
     	  
     	 // minusDivSt.style.display="block"; //Please enable it for Multi-Row functionality
       }
       else
       {
     	  rowsObjs[multiRowId] = document.getElementsByName(rowMinusImgName);
     	  
     	  minusDivSt.style.display="none";  
       }
       var start="0",end=elementArray[multiRowId][0].length-2,period="1";
       
	   updateMultiRowValues(start,end,period,valArr,multiRowId);
     }
     else
     {
       if(mode[multiRowId]=="1")
       {
     	 // minusDivSt.style.display="block";//Please enable it for Multi-Row functionality
       }
       else
       {
     	  minusDivSt.style.display="none";  
       }
       rowsObjs[multiRowId] = "0";//added
     }  
	 if(addUserEventHandlerFunc[multiRowId]!="0")
	 {
	 	eval(addUserEventHandlerFunc[multiRowId]+"("+(elementArray[multiRowId][0].length-1)+")");
	 }
	 first="1"; 
	 
	 return true;
}


function minusLastRow(multiRowId)
{
    
    if(parseInt(elementArray[multiRowId][0].length) > parseInt(nRowsVisibleTmp[multiRowId]))
    {
	    var objTableDIV  =document.getElementById("multiRowDivId#"+multiRowId);
	    
	    var objTableRes  =objTableDIV.innerHTML;
	    
	    var myArray      =new Array();
	    
	    var valArr       =new Array();
	    
	    var newStr       ="";
	    
	    if(first!="0")
		{
		   var start="0",end=elementArray[multiRowId][0].length-2,period="1";
		   
		   storePrevValues(start,end,period,valArr,multiRowId);
		}
	    if(objTableRes.indexOf("<tr>")!=-1)
	    {
	       myArray=objTableRes.split("<tr>");
	    }   
	    else
	    {
	       myArray=objTableRes.split("<TR>");
	    }
	    var len= myArray.length;
	    
	    for(var j=0;j<len-2;j++)
	    {
	       if(objTableRes.indexOf("<tr>")!=-1)
	       {
	          newStr=newStr+myArray[j]+"<tr>";
	       }   
	       else
	       {
	          newStr=newStr+myArray[j]+"<TR>";
	       }
	    }
	 
	    newStr=newStr+myArray[j];//ADDED
	    
	    objTableDIV.innerHTML=newStr;
	    
	    rowsObjs[multiRowId] = "0";
	    
	    if(first!="0")
		{
		   var start="0",end=elementArray[multiRowId][0].length-1,period="1";
		   
		   updateMultiRowValues(start,end,period,valArr,multiRowId);
		}
		return true;
	}
	else
	{
	   //alert("Sorry! Deletion not Allowed."); //commented for reset operation
	   
	   rowsObjs[multiRowId] = "0";
	   
	   return false;
	}	
}

function minusRow(rowObj,multiRowId)
{
	
    if(parseInt(elementArray[multiRowId][0].length) > parseInt(nRowsVisibleTmp[multiRowId]))
    {
	    var rowId        =rowObj.id;
	    
	    var objTableDIV  =document.getElementById("multiRowDivId#"+multiRowId);
	    
	    var objTableRes  =objTableDIV.innerHTML;
	    
	    var myArray      =new Array();
	    
	    var valArr       =new Array();
	    
	    myArray          =rowId.split("#");
	    
	    var rowIndx      =myArray[1];
	    
	    var newStr       ="";
	    
	    var newIndx      = 0;
	    
	    if(first!="0")
		{
		   for(var i=0;i<=elementArray[multiRowId][0].length-1;i++)
		   {
		      if(i!=rowIndx)
		      {
		         for(var x=0;x<elementArray[multiRowId].length;x++)
		         {
					   if(x==0)
				       {
				      	   if(elementArray[multiRowId][x][i].type=="text" || elementArray[multiRowId][x][i].type=="hidden" || elementArray[multiRowId][x][i].tagName=="SELECT" || elementArray[multiRowId][x][i].tagName=="TEXTAREA")
				      	   {
				      	      valArr[newIndx]=elementArray[multiRowId][x][i].value;
				      	   }
				      	   else
				      	   {
				      	   	  // Storing CheckBox & Radio Button Status and Values
				      	   	  if(elementArray[multiRowId][x][i].type=="checkbox" || elementArray[multiRowId][x][i].type=="radio")
				      	   	  {
				      	   	  	 if(elementArray[multiRowId][x][i].checked)
				      	   	  	 {
				      	   	  	 	valArr[newIndx]="1#" + elementArray[multiRowId][x][i].value;
				      	   	  	 }
				      	   	  	 else
				      	   	  	 {
				      	   	  	 	valArr[newIndx]="0#" + elementArray[multiRowId][x][i].value;
				      	   	  	 }
				      	   	  }
				      	   }  
				      	}
				      	else
				      	{
				      	   if(elementArray[multiRowId][x][i].type=="text" || elementArray[multiRowId][x][i].type=="hidden" || elementArray[multiRowId][x][i].tagName=="SELECT" || elementArray[multiRowId][x][i].tagName=="TEXTAREA")
				      	   {
				      	      valArr[newIndx]= valArr[newIndx]+"^"+elementArray[multiRowId][x][i].value;
				      	   }
				      	   else
				      	   {
				      	   	  // Storing CheckBox & Radio Button Status and Values
				      	   	  if(elementArray[multiRowId][x][i].type=="checkbox" || elementArray[multiRowId][x][i].type=="radio")
				      	   	  {
				      	   	  	 if(elementArray[multiRowId][x][i].checked)
				      	   	  	 {
				      	   	  	 	valArr[newIndx] = valArr[newIndx]+ "^" + "1#" + elementArray[multiRowId][x][i].value;
				      	   	  	 }
				      	   	  	 else
				      	   	  	 {
				      	   	  	 	valArr[newIndx] = valArr[newIndx]+ "^" + "0#" + elementArray[multiRowId][x][i].value;
				      	   	  	 }
				      	   	  }
				      	    } 
				      	  } 
		         }
		         //alert("valArr["+i+"]->"+valArr[i]);
		         newIndx=parseInt(newIndx)+1;
		      }
		   }
		}
	
	    if(objTableRes.indexOf("<tr>")!=-1)
	    {
	       myArray=objTableRes.split("<tr>");
	    }   
	    else
	    {
	       myArray=objTableRes.split("<TR>");
	    }   
	    var len= myArray.length;
	    
	    for(var j=0;j<len;j++)
	    {
	       if(parseInt(j)!=parseInt(parseInt(rowIndx)+2))
	       {
	         if(objTableRes.indexOf("<tr>")!=-1)
	         {
	           if(parseInt(j)!=parseInt(parseInt(len)-2))
	           {
	             newStr=newStr+myArray[j]+"<tr>";
	           }  
	           else
	           {
	             newStr=newStr+myArray[j];
	           }  
	         }
	         else
	         {
	           if(parseInt(j)!=parseInt(parseInt(len)-1))
	           {
	             newStr=newStr+myArray[j]+"<TR>";
	           }  
	           else
	           {
	             newStr=newStr+myArray[j];
	           }
	         }   
	       }     
	    }
	    if(parseInt(rowIndx)==(parseInt(elementArray[multiRowId][0].length)-1))
	    {
	      newStr=newStr+"</TBODY></TABLE>";
	    }
	    objTableDIV.innerHTML=newStr;
	    
	    rowsObjs[multiRowId] = document.getElementsByName(rowObj.name);
	    
	    if(first!="0")
		{
		   var start="0",end=elementArray[multiRowId][0].length-1,period="1";
		   
		   updateMultiRowValues(start,end,period,valArr,multiRowId);
		}
		return true;
	}
	else
	{
	  //alert("Sorry! Deletion not Allowed.");
	  
	  rowsObjs[multiRowId] = document.getElementsByName(rowObj.name);
	  
	  return false;
	}	
}

function updateRowIds(multiRowId)
{
	 for(var i=0;i<=elementArray[multiRowId][0].length-1;i++)
	 {
		for(var x=0;x<elementArray[multiRowId].length;x++)
	    {
	       elementArray[multiRowId][x][i].id=elementArray[multiRowId][x][i].name+"#"+i;
	    }
	    if(rowsObjs[multiRowId]!="0")
	    {
	       rowsObjs[multiRowId][i].id = rowsObjs[multiRowId][i].name+"#"+i;
	    }  
	 }
	 
	 // Updating DIV Ids
	 
	 var allDivObjs  =document.getElementById("multiRowDivId#"+multiRowId).getElementsByTagName("div");
	 
	 var myArray =new Array();
	 
	 var divId;
	 
	 for(var i=0;i<=divObjsArray[multiRowId].length-1;i++)
	 {
	    divId = 0;
	    
	    for(var x=0;x<=allDivObjs.length-1;x++)
	    {    
	      myArray = (divObjsArray[multiRowId][i]).split("#");
	      
	      if(myArray[0]==(allDivObjs[x].id).split("#")[0])   
	      {
	        allDivObjs[x].id= myArray[0]+"#"+divId;
	        
	        divId =parseInt(divId)+1;
	      }
	    } 
	 }
	 
}

function storePrevValues(start,end,period,valArr,multiRowId)
{
	 for(var i=parseInt(start);i<=parseInt(end);i=parseInt(i)+parseInt(period))
	 {
	      for(var x=0;x<elementArray[multiRowId].length;x++)
	      {
	      	if(x==0)
	      	{
	      	   if(elementArray[multiRowId][x][i].type=="text" || elementArray[multiRowId][x][i].type=="hidden" || elementArray[multiRowId][x][i].tagName=="SELECT" || elementArray[multiRowId][x][i].tagName=="TEXTAREA")
	      	   {
	      	      valArr[i]=elementArray[multiRowId][x][i].value;
	      	   }
	      	   else
	      	   {
	      	   	  // Storing CheckBox & Radio Button Status and Values
	      	   	  if(elementArray[multiRowId][x][i].type=="checkbox" || elementArray[multiRowId][x][i].type=="radio")
	      	   	  {
	      	   	  	 if(elementArray[multiRowId][x][i].checked)
	      	   	  	 {
	      	   	  	 	valArr[i]="1#" + elementArray[multiRowId][x][i].value;
	      	   	  	 }
	      	   	  	 else
	      	   	  	 {
	      	   	  	 	valArr[i]="0#" + elementArray[multiRowId][x][i].value;
	      	   	  	 }
	      	   	  }
	      	   }  
	      	}
	      	else
	      	{
	      	   if(elementArray[multiRowId][x][i].type=="text" || elementArray[multiRowId][x][i].type=="hidden" || elementArray[multiRowId][x][i].tagName=="SELECT" || elementArray[multiRowId][x][i].tagName=="TEXTAREA")
	      	   {
	      	      valArr[i]= valArr[i]+ "^" + elementArray[multiRowId][x][i].value;     
	      	   }
	      	   else
	      	   {
	      	   	  // Storing CheckBox & Radio Button Status and Values
	      	   	  if(elementArray[multiRowId][x][i].type=="checkbox" || elementArray[multiRowId][x][i].type=="radio")
	      	   	  {
	      	   	  	 if(elementArray[multiRowId][x][i].checked)
	      	   	  	 {
	      	   	  	 	valArr[i] = valArr[i]+ "^" + "1#" + elementArray[multiRowId][x][i].value;
	      	   	  	 }
	      	   	  	 else
	      	   	  	 {
	      	   	  	 	valArr[i] = valArr[i]+ "^" + "0#" + elementArray[multiRowId][x][i].value;
	      	   	  	 }
	      	   	  }
	      	    } 
	      	 }
	      }
	 }
}

function updateMultiRowValues(start,end,period,valArr,multiRowId)
{
	 var arrVal  = new Array();
	 
	 var myArray = new Array();
	 
	 updateRowIds(multiRowId);//function to update rowIds  
	  
     for(var i=parseInt(start);i<=parseInt(end);i=parseInt(i)+parseInt(period))
     {
          arrVal=valArr[i].split("^");
    
	      for(var x=0;x<elementArray[multiRowId].length;x++)
          {
             if(elementArray[multiRowId][x][i].type=="checkbox" || elementArray[multiRowId][x][i].type=="radio")
             {
                myArray = arrVal[x].split("#");
                
                if(myArray[0] == "1")
                {
                	elementArray[multiRowId][x][i].checked=true;
                }
                else
                {
                	elementArray[multiRowId][x][i].checked=false;
                }
                elementArray[multiRowId][x][i].value=myArray[1];
             }
             else
             {
                elementArray[multiRowId][x][i].value=arrVal[x];
             }   
          }
     }
} 

function resetMultiRow(initMultiRowLen,multiRowId)
{
	 var retVal = true;
	 
	 var minusImgName ;
	 
	 while(retVal)
	 {   
	     if(mode[multiRowId]=="1")
	     { 
	        retVal = minusLastRow(multiRowId);
	        
	        minusImgName = "0";
	     }
	     else
	     {
	     	var rowObj = document.getElementsByName("minusImgRow")[document.getElementsByName("minusImgRow").length-1];
	     	
	     	retVal = minusRow(rowObj,multiRowId);
	     	
	     	minusImgName = "minusImgRow";
	     }  
	 }
	 for(var i=1;i<=parseInt(initMultiRowLen)-1;i++)
     {
         add(minusImgName,'0');
     }
    
} 

function datePickerAjaxMultiRow(e,objName,objImg)
{
     //var fobj = nn6 ? e.target : event.srcElement; for capturing element on which event takes place
     //alert("1"+document.getElementsByName('strCreditLetterDate').length);
     var obj = document.getElementsByName(objName);
     
     var myArray = new Array();
     
     myArray = (objImg.id).split("#");
     
    //alert("split by #::"+myArray[1]+obj.length);
     
     Calendar.setup
     (
       {
           inputField :obj[myArray[1]].id,eventName : "click",ifFormat : "%d-%b-%Y",button :objImg.id,singleClick : true
       }
     );
     Calendar.setup
     ( 
     	{ 
     		inputField     :    obj[myArray[1]].id,eventName : "keypress",mapKey : "32", ifFormat       :    "%d-%b-%Y", button         :   objImg.id, singleClick    :    true 
     	}
     );
} 



//for normal mutli row operation which we make in jsp....
function datePickerMultiRow(e,objName,objImg)
{
     //var fobj = nn6 ? e.target : event.srcElement; for capturing element on which event takes place
     //alert("1"+document.getElementsByName('strCreditLetterDate').length);
     var obj = document.getElementsByName(objName);
     
     var myArray = new Array();
     
     myArray = (objImg.id).split("-");
     
     var tempIndex= parseInt(myArray[1]) - 1;
     
     //alert(tempIndex);
     
   // alert("temp index is::"+"strCreditRefDate12-"+myArray[1]);
     
    //alert("split by #::"+myArray[1]+obj.length);
     
     Calendar.setup
     (
       {
           //inputField :obj[tempIndex].id,eventName : "click",ifFormat : "%d-%b-%Y",button :objImg.id,singleClick : true
    	   inputField :"strCreditRefDate12-"+myArray[1],eventName : "click",ifFormat : "%d-%b-%Y",button :objImg.id,singleClick : true
       }
     );
     /*Calendar.setup
     (
       {
           //inputField :obj[tempIndex].id,eventName : "click",ifFormat : "%d-%b-%Y",button :objImg.id,singleClick : true
    	   inputField :"strOfflineTariffDate1-"+myArray[1],eventName : "click",ifFormat : "%d-%b-%Y",button :objImg.id,singleClick : true
       }
     );*/
     Calendar.setup
     ( 
     	{ 
     		inputField     :    obj[tempIndex].id,eventName : "keypress",mapKey : "32", ifFormat       :    "%d-%b-%Y", button         :   objImg.id, singleClick    :    true 
     	}
     );
} 
//for normal mutli row operation which we make in jsp....
function datePickerMultiRow1(e,objName,objImg)
{
     //var fobj = nn6 ? e.target : event.srcElement; for capturing element on which event takes place
     //alert("1"+document.getElementsByName('strCreditLetterDate').length);
     var obj = document.getElementsByName(objName);
     
     var myArray = new Array();
     
     myArray = (objImg.id).split("-");
     
     var tempIndex= parseInt(myArray[1]) - 1;
     
     //alert(tempIndex);
     
   // alert("temp index is::"+"strCreditRefDate12-"+myArray[1]);
     
    //alert("split by #::"+myArray[1]+obj.length);
     
     /*Calendar.setup
     (
       {
           //inputField :obj[tempIndex].id,eventName : "click",ifFormat : "%d-%b-%Y",button :objImg.id,singleClick : true
    	   inputField :"strCreditRefDate12-"+myArray[1],eventName : "click",ifFormat : "%d-%b-%Y",button :objImg.id,singleClick : true
       }
     );*/
     Calendar.setup
     (
       {
           //inputField :obj[tempIndex].id,eventName : "click",ifFormat : "%d-%b-%Y",button :objImg.id,singleClick : true
    	   inputField :"strOfflineTariffDate1-"+myArray[1],eventName : "click",ifFormat : "%d-%b-%Y",button :objImg.id,singleClick : true
       }
     );
     Calendar.setup
     ( 
     	{ 
     		inputField     :    obj[tempIndex].id,eventName : "keypress",mapKey : "32", ifFormat       :    "%d-%b-%Y", button         :   objImg.id, singleClick    :    true 
     	}
     );
} 