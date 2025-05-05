

var xmlHttp;
var req;
var defColor = "red";
var selColor = "#653232";

function userOnLoadFunc(){
	try{
		document.getElementById("menuTable1").style.display = "block";
		userDefinedOnLoadFunc();
	}catch(_err){
		
	}
	document.getElementById("searchid").style.display = "block";
	
}
function goToMainPage(){
	showMenuFrame();
	document.forms[0].hmode.value="GOTOMAINPAGE";
	document.forms[0].submit();
}
function createRequestObject()
	{
		var xmlhttp = false;
	   try	
		{
 			xmlhttp = new ActiveXObject("Msxml2.XMLHTTP");
		}
 		catch (e)
 		{
  			try {
  				xmlhttp = new ActiveXObject("Microsoft.XMLHTTP");
	  		   } 
  			catch (E){
   				xmlhttp = false;
  		}
	 	     }
		if (!xmlhttp && typeof XMLHttpRequest !='undefined')
			{
			xmlhttp = new XMLHttpRequest();
			 }
  		 
	   return xmlhttp;
	}

function GetXmlHttpObject(handler)
	{ 
		var objXmlHttp=null

		if (navigator.userAgent.indexOf("Opera")>=0)
		{
			alert("This example doesn't work in Opera") 
			return 
		}
		if (navigator.userAgent.indexOf("MSIE")>=0)
		{ 
			var strName="Msxml2.XMLHTTP"
			if (navigator.appVersion.indexOf("MSIE 5.5")>=0)
			{
			strName="Microsoft.XMLHTTP"
			} 
			try
			{ 
			objXmlHttp=new ActiveXObject(strName)
			objXmlHttp.onreadystatechange=handler 
			return objXmlHttp
			} 
			catch(e)
			{ 
			alert("Error. Scripting for ActiveX might be disabled") 
			return 
			} 
		} 
		if (navigator.userAgent.indexOf("Mozilla")>=0)
		{
			objXmlHttp=new XMLHttpRequest()
			objXmlHttp.onload=handler
			objXmlHttp.onerror=handler 
			return objXmlHttp
		}
	}
	
function closeWindow() {
window.open('','_parent','');
window.close();
}

function fetchRecords(index,rowNum,prevNext)
{
	var tempRowNum = rowNum;
	
	xmlHttp=createRequestObject();
	
 	if(rowNum==null)rowNum='0';
	if(index==null) index="0^1^0";
	   
	obj=index.split("^");
	var blockNo=obj[1];
	
	document.forms[0].rowNum.value = rowNum;
	document.forms[0].prevNext.value = prevNext;
	
	
	if(prevNext==null) prevNext='1';
	
	var order				=	null;
	var search				=	null;
	var str 				=	"";						
	var no_of_combo			=	0;
	var combo				=	document.forms[0].combo;
	var cmb1				=	document.getElementsByName("cmb");
	var searchColumn		=	0;
	
	//var search			=	document.getElementsByName("search")[0].value;
	//var searchColumn	= 	document.getElementsByName("searchColumn")[0].value;	
	if(typeof(document.getElementsByName("search")[0]) !="undefined") search=document.getElementsByName("search")[0].value;
	if(typeof(document.forms[0].orderby) !="undefined") order=document.forms[0].orderby.value;
	if(typeof(document.getElementsByName("searchColumn")[0]) !="undefined") searchColumn=document.getElementsByName("searchColumn")[0].value;
	if(typeof(document.forms[0].no_of_combo) !="undefined") no_of_combo=document.forms[0].no_of_combo.value;
	
	if(cmb1.length > 0 && typeof(combo) == "undefined")
	{
		//when the list page is loaded then no_of_combo will be null
		if(no_of_combo == null || no_of_combo == 0 || no_of_combo == 'null') 
		{
			no_of_combo = cmb1.length;
		}
		
		if(no_of_combo > 0) 
		{
			for(var i=0;i<cmb1.length;i++)
					str += "&combo="+cmb1[i].value;
		}
	}
	else
	{
		if(typeof(combo) != "undefined" && no_of_combo > 0)
		{
			if(no_of_combo > 1)
			{
				for(var i=0;i<combo.length;i++)
					str += "&combo="+combo[i].value;
			}
			else
			{
				str= "&combo="+combo.value;
			}
		}
	}
	
	//var params="../../"+document.forms[0].cnt_page.value+".cnt?hmode=LISTPAGE"+str+"&searchColumn="+searchColumn+"&search="+search+"&blockNo="+blockNo+"&prevNext="+prevNext+"&rowNum="+rowNum+"&orderby="+order+"&date="+new Date().getTime();	
	var params = document.forms[0].action + "?hmode=LISTPAGE"+str+"&searchColumn="+searchColumn+"&search="+search+"&blockNo="+blockNo+"&prevNext="+prevNext+"&rowNum="+rowNum+"&orderby="+order+"&date="+new Date().getTime();	
		
	//alert(params);
	params = createFHashAjaxQuery(params);
	xmlHttp.open('POST',params,true);
	
	document.getElementById('start').innerHTML ='<table align=center><tr class="ROWFONT"><td height=30><b>Wait Fetching Data from Database...</b></td></tr></table>';
	
	xmlHttp.onreadystatechange = function()
	{
		if(xmlHttp.readyState == 4)
		{
			if(xmlHttp.status =='200')
			{
				document.getElementById("message").style.display	=	'none';
				var response 		= 	xmlHttp.responseText;			
				var responseData	=	response.split("####");
				
				//check for error
				if (responseData[0] == "ERROR") 
				{
					document.getElementById('start').innerHTML = "";
					document.getElementById("message").style.display	=	'block';
					document.getElementById('message').innerHTML 	= "<table align=center><tr><td height=30><font color = 'red'><b>" + responseData[1] + "</b></font></td></tr></table>";
				}
				else {
					document.forms[0].record_per_page.value			=	responseData[0];
					document.forms[0].no_of_combo.value				=	responseData[1];
					document.forms[0].actual_page_block.value		=	responseData[2];
					document.forms[0].totalpage.value				=	responseData[3];
					document.getElementById("start").innerHTML 		= 	responseData[4];
					//document.getElementById("searchid").innerHTML 	= 	responseData[5];
					document.getElementById("footer").innerHTML 	= 	responseData[6];
					document.getElementById("footer").style.display	=	'block';							
					document.getElementById("searchid").style.display=	'none';
					document.getElementById("comboId").innerHTML = responseData[7];							
					document.getElementById("buttonID").innerHTML = responseData[8];
					document.forms[0].divisionId.value="a1";      // division id name is a1  in which data is populated 							

					newDesk();
					checkIsChecked();
					
					if(document.getElementById("bba1") !=null) {
						document.getElementById("bba1").style.color=selColor;
					}
				}	// if(xmlHttp.status == 200 || xmlHttp.status=='complete') closed
			userOnLoadFunc();
			
			checkChangeDiv();
			
			try{
		     	autoTabIndexing();
		    }catch(_Err){
		     	//alert("Application Error[TabIndex not Included] Please Contact System Administrator");
		 	}
			}	
		}
	}	
		
	xmlHttp.send(null);
}//main method closed



function checkIsChecked(){
	$('input[name=chk]').change(function(){
		console.log('check checked....');
		if($('input[name=chk]:checked').length > 1)
		{
			console.log('inside if ....');
			$('input[name=chk]:checked').not(this).prop('checked', false);
			//$(this).attr('checked','true');
		}
	});
}


function newDesk(){
	 
	var table = $('#mainTablea1').dataTable( {    
		columnDefs: [
		             { targets: 'no-sort', orderable: false }
		           ],    
        "scrollCollapse": true, 
        "jQueryUI":       true,
        "paging":         true,   
        "ordering": true,   
        "filter": true,
        /*
        "order": [[ 2, "asc" ]],
        "columnDefs" : [
                        { type: 'natural', targets: '_all' }
                      ],*/
        "info": true,  
        "language": {
                     "zeroRecords": "No matching record found"
                      },
        "lengthMenu": [[10, 25, 50, -1], [10, 25, 50, "All"]]
                      /*,
		dom : 'Bfrtip',
        buttons: [
                  {
                      extend: 'pdfHtml5',
                      className: 'btn btn-sm btn-primary',
                      title: masterName,
                      text: "<span class='glyphicon glyphicon-file'></span> PDF"
                  }
	             ]*/
	       
	    }); 
	
}



/*
	When combo value is changed
*/
function fetchRecordsCombo(cmbIndex)
{
	var rowNum			=	'0';
	var blockNo			=	1;
	var search			=	document.getElementsByName("search")[0].value;
	var searchColumn	= 	document.getElementsByName("searchColumn")[0].value;
	var no_of_cmb		=	document.forms[0].no_of_combo.value;
	var combo			=	document.forms[0].combo;
	var comboReset		=	document.forms[0].comboReset;
	var cmb1			=	document.forms[0].cmb;
	var test			= 	new Array();
	var str 			= 	"";
	var tempStr			=	"";
	
	/*if(no_of_cmb> 1){ 
		for(var i=0;i<combo.length;i++)
		if(i==0){ 
			tempStr += document.forms[0].combo[i].value;
		}
		else
		{
			tempStr += "^"+document.forms[0].combo[i].value;
		}
	}// if condition*/
	if(no_of_cmb> 1){
		for(var i=cmbIndex+1;i <no_of_cmb;i++)	
		{
			if(typeof(document.forms[0].comboReset)!="undefined")
			{
				if(document.forms[0].comboReset[i].value=="0")
				{
			 		document.forms[0].combo[i].selectedIndex=0;
				}
			}
			else
			{
				document.forms[0].combo[i].selectedIndex=0;
			}			
		}	// for loop closed
    }  // if conditions

	if(no_of_cmb> 1){ 
		for(var i=0;i<combo.length;i++)
			str += "&combo="+combo[i].value;
	}// if condition
	else {
		if(combo !=null) str= "&combo="+combo.value;
	}
/*	
	var params="../../"+document.forms[0].cnt_page.value+".cnt?hmode=DEFAULT"+str+"&searchColumn="+searchColumn+"&search="+search+
			"&rowNum="+rowNum+"&blockNo="+blockNo;
*/
	var params=document.forms[0].action + "?hmode=DEFAULT"+str+"&searchColumn="+searchColumn+"&search="+search+
			"&rowNum="+rowNum+"&blockNo="+blockNo;
	params = createFHashAjaxQuery(params);			
	xmlHttp.open("POST",params,true);
	document.getElementById('start').innerHTML = '<table align=center><tr class="ROWFONT"><td height=30><b>Wait Fetching Data from Database...</b></td></tr></table>';
	
	xmlHttp.onreadystatechange = function()
	{	
		if(xmlHttp.readyState == 4)
		{
			if(xmlHttp.status =='200')
			{
				document.getElementById("message").style.display	=	'none';
					
				var response 		= 	xmlHttp.responseText;
				var responseData	=	response.split("####");	
				
				//check for error
				if (responseData[0] == "ERROR") {
					document.getElementById('start').innerHTML = "";
					document.getElementById("message").style.display	=	'block';
					document.getElementById('message').innerHTML 	= "<table align=center><tr><td height=30><font color = 'red'><b>" + responseData[1] + "</b></font></td></tr></table>";
				}
				else {
					document.forms[0].record_per_page.value			=	responseData[0];
					document.forms[0].no_of_combo.value				=	responseData[1];
					document.forms[0].actual_page_block.value		=	responseData[2];
					document.forms[0].totalpage.value				=	responseData[3];
					document.getElementById("start").innerHTML 		= 	responseData[4];
					//document.getElementById("searchid").innerHTML 	= 	responseData[5];
					document.getElementById("footer").innerHTML 	= 	responseData[6];
					document.getElementById("footer").style.display	=	'block';							
					document.getElementById("searchid").style.display=	'block';
					document.getElementById("comboId").innerHTML = responseData[7];							
					document.getElementById("buttonID").innerHTML = responseData[8];
					document.forms[0].divisionId.value="a1";   
				
					if(document.getElementById("bba1") !=null){
						document.getElementById("bba1").style.color=selColor;
					}// if closed	
					newDesk();
					checkIsChecked();
				}	
				try{
			     	autoTabIndexing();
			    }catch(_Err){
			     	//alert("Application Error[TabIndex not Included] Please Contact System Administrator");
			 	}
			}// if(xmlHttp.status == 200 || xmlHttp.status=='complete') closed
		}// if(xmlHttp.readyState == 4) closed
	 } // function () closed	 
    
    xmlHttp.send(params);
    
}//main method closed

/*
* function sortData(index) is called when user click on order by image 
*/
function sortData(index)
{
	var rowNum			=	'0';
	var blockNo			=	1;
	//var search			=	document.forms[0].search.value;
	//var searchColumn	= 	document.forms[0].searchColumn.value;
	var search			=	document.getElementsByName("search")[0].value;
	var searchColumn	= 	document.getElementsByName("searchColumn")[0].value;
	
	var combo			=	document.forms[0].combo;
	var cmb1			=	document.forms[0].cmb;
	var test			= 	new Array();
	var str 			= 	"";

	document.getElementById("message").style.display	=	'none';
	
	if(document.forms[0].no_of_combo.value > 1)
	{
		for(var i=0;i<combo.length;i++)
			str += "&combo="+combo[i].value;
	}
	else 
	{
		if(combo !=null) str= "&combo="+combo.value;
	}
	
//	var params="../../"+document.forms[0].cnt_page.value+".cnt?hmode=DEFAULT"+str+"&searchColumn="+searchColumn+"&search="+search+"&orderby="+index+"&rowNum=0&prevNext=0&blockNo=0";
	var params=document.forms[0].action + "?hmode=DEFAULT"+str+"&searchColumn="+searchColumn+"&search="+search+"&orderby="+index+"&rowNum=0&prevNext=0&blockNo=0";	
	params = createFHashAjaxQuery(params);
	xmlHttp.open("POST",params,true);
	document.getElementById('start').innerHTML = '<table align=center><tr class="ROWFONT"><td height=30><b>Wait Fetching Data from Database...</b></td></tr></table>';
	
	xmlHttp.onreadystatechange = function()
	{
		if(xmlHttp.readyState == 4)
		{
			if(xmlHttp.status == 200)
			{
				var response 		= 	xmlHttp.responseText;
				var responseData	=	response.split("####");
				
				//check for error
				if (responseData[0] == "ERROR") {
					document.getElementById('start').innerHTML = "";
					document.getElementById("message").style.display	=	'block';
					document.getElementById('message').innerHTML 	= "<table align=center><tr><td height=30><font color = 'red'><b>" + responseData[1] + "</b></font></td></tr></table>";
				}
				else {
					document.forms[0].record_per_page.value			=	responseData[0];
					document.forms[0].no_of_combo.value				=	responseData[1];
					document.forms[0].actual_page_block.value		=	responseData[2];
					document.forms[0].totalpage.value				=	responseData[3];
					document.getElementById("start").innerHTML 		= 	responseData[4];
					document.getElementById("searchid").innerHTML	= 	responseData[5];
					document.getElementById("message").style.display=	'none';
					document.getElementById("footer").style.display =	'block';
					document.forms[0].divisionId.value				=	"a1";
						
					if(document.getElementById("bba1") !=null){
						document.getElementById("bba1").style.color=selColor;
					}
				}
				try{
			     	autoTabIndexing();
			    }catch(_Err){
			     	//alert("Application Error[TabIndex not Included] Please Contact System Administrator");
			 	}	
			}// if(xmlHttp.status == 200 || xmlHttp.status=='complete') closed
		}// if(xmlHttp.readyState == 4) closed
	} // function () closed	 
	
    xmlHttp.send(params);
}//main method closed

/*
	When Serach button is clicked
*/	
function searchpage()
	{
	var mode			=	'SEARCH';
	var test   			= 	new Array(); 
	var combo1			=	"";  
	var str    			= 	"";
	//var searchColumn	= 	document.forms[0].searchColumn.value;
	//var search			=	document.forms[0].search.value;
	var searchColumn	= 	document.getElementsByName('searchColumn')[0].value;
	var search			=	document.getElementsByName('search')[0].value;	
	var blockNo			=	1;
	var rowNum			=	0;
	var prevNext		=	1; 
	
	/* LTrim */
	search=search.replace(/^\s+/,"");
	
	/* REMOVING ' # $ & special characters. */
	search=search.replace(/[#$&']/g, "");
	
	document.getElementById("message").style.display	=	'none';
	
	if(	document.forms[0].combo !=null)
		combo1 	= 	document.forms[0].combo;
	else
 		combo1 =	0;

	for(i=0;i<combo1.length;i++)
		str += "&combo=" + combo1[i].value;
	
//	var params="../../"+document.forms[0].cnt_page.value+".cnt?hmode=SEARCH"+str+"&searchColumn="+searchColumn+"&search="+search+"&blockNo="+blockNo+"&prevNext="+prevNext+"&rowNum="+rowNum+"&date="+new Date().getTime();	
	var params=document.forms[0].action + "?hmode=SEARCH"+str+"&searchColumn="+searchColumn+"&search="+search+"&blockNo="+blockNo+"&prevNext="+prevNext+"&rowNum="+rowNum+"&date="+new Date().getTime();	
	params = createFHashAjaxQuery(params);
	xmlHttp.open("POST",params,true);
	document.getElementById('start').innerHTML = '<table align=center><tr class="ROWFONT"><td height=30><b>Wait Fetching Data from Database...</b></td></tr></table>';
	
	xmlHttp.onreadystatechange = function()
	{
		if(xmlHttp.readyState == 4)
		{
			if(xmlHttp.status =='200' || xmlHttp.status=='complete')
			{
				var response 		=	xmlHttp.responseText;
				var responseData	=	response.split("####");
				
				//check for error
				if (responseData[0] == "ERROR") {
					document.getElementById('start').innerHTML = "";
					document.getElementById("message").style.display	=	'block';
					document.getElementById('message').innerHTML 	= "<table align=center><tr><td height=30><font color = 'red'><b>" + responseData[1] + "</b></font></td></tr></table>";
				}
				else {
					document.forms[0].record_per_page.value			=	responseData[0];
					document.forms[0].no_of_combo.value				=	responseData[1];
					document.forms[0].actual_page_block.value		=	responseData[2];
					document.forms[0].totalpage.value				=	responseData[3];
					document.getElementById("start").innerHTML 		= 	responseData[4];
					document.getElementById("searchid").innerHTML 	=	responseData[5];
					document.getElementById("footer").style.display	=	'block';
					document.forms[0].divisionId.value				=	"a1";
					
					if(document.getElementById("bba1") 	!=null){
						document.getElementById("bba1").style.color	=	selColor;
					}
				}
				try{
			     	autoTabIndexing();
			    }catch(_Err){
			     	//alert("Application Error[TabIndex not Included] Please Contact System Administrator");
			 	}		
			}
		}
	}
	
	xmlHttp.send(params);
	return false;		
}


/*
* this function called when delete button is pressed 
*
*
*/
function deleteRecords()
{
	var combo1;
	var prevNext	=	null;
	var totalChk	=	0;
	var primarykey	=	"";
	var search		=	"";
	var str			=	"";
	var str			=	"";
			
	var mode = "DELETE";
	var len			= 	0;
	var no_of_combo	=	0;
	
	if(typeof(document.forms[0].chk) !="undefined") len	= 	document.forms[0].chk.length;
	if(typeof(document.forms[0].no_of_combo) !="undefined") no_of_combo	=	document.forms[0].no_of_combo.value;
	if(typeof(document.forms[0].combo) !="undefined") combo1 =	document.forms[0].combo;
		
	//if(document.forms[0].combo !=null) combo1 =	document.forms[0].combo;	
	
	//call in this file	 
	if(checkForDelete()==false) return ;
		 
	var divisionId		= document.forms[0].divisionId.value;
	var rec_per_page	= document.forms[0].record_per_page.value;
	var prevDivIndex 	= divisionId.substring(1,divisionId.length);
	var min_rec_len 	= parseInt(rec_per_page)*(parseInt(prevDivIndex) -1); 
	var max_rec_len 	= parseInt(rec_per_page) * parseInt(prevDivIndex);
	
	if(!isNaN(document.forms[0].chk.length))
	{
		for(var i=min_rec_len;i< max_rec_len && i < document.forms[0].chk.length;i++)
		{
			if(document.forms[0].chk[i].checked==true)
			{
				totalChk+=1;
				primarykey +=document.forms[0].chk[i].value;
		  		// concatenating all chk value with @ symbols to a single variable to for easy manipulations like deleting the records and update
		  		primarykey +="~"; 
//		  		primarykey +="@"; 
		  	}
		  }
	}
	else
		primarykey=document.forms[0].chk.value;
	
	var retValue=confirm("Selected Record (s) are being deleted\n\nAre You Sure");	 	
	if(retValue==false) return;
	
	if(prevNext	==	null) prevNext='1';
	
	if(no_of_combo >1)
		{
			for(i=0;i<combo1.length;i++)
				str += "&combo="+combo1[i].value;
		}
	else
		if(no_of_combo==1) 
			str += "&combo="+combo1.value;		
	
	
	var minrow		=	document.forms[0].minrow.value;	
	var max_rownum	=	document.forms[0].max_rownum.value;	
	var blockNo		=	document.forms[0].blockNo.value;  
	var divisionId	=	document.forms[0].divisionId.value;
	var search			=	"";
	var searchColumn	=	null;
	var rowNum			=	minrow;
	
	/*
	var params="../../"+document.forms[0].cnt_page.value+".cnt?hmode="+mode+str+"&divisionId="+divisionId+"&chk="+primarykey+"&prevNext"+prevNext
					+"&rowNum=0&minrow="+minrow+"&blockNo="+blockNo+"&max_rownum="+max_rownum+"&search="+search+"&searchColumn="+searchColumn;
	*/
		
	var params = document.forms[0].action	+ "?hmode="+mode+str+"&divisionId="+divisionId+"&chk="+primarykey+"&prevNext"+prevNext
					+"&rowNum=0&minrow="+minrow+"&blockNo="+blockNo+"&max_rownum="+max_rownum+"&search="+search+"&searchColumn="+searchColumn;
	
	params = createFHashAjaxQuery(params);
	xmlHttp.open("POST",params,true);
	document.getElementById("message").style.display='block';	
	document.getElementById('start').innerHTML ='<table align=center><tr class="ROWFONT"><td height=30><b>Wait Deleting Records...</b></td></tr></table>';
	
	xmlHttp.onreadystatechange = function()
	{
		if(xmlHttp.readyState ==4 )
		{
			if(xmlHttp.status == 200 || xmlHttp.status=='complete' )
			{
				var response 		= 	xmlHttp.responseText;
				var responseData	=	new Array();
				
				responseData	=	response.split("####");
				//check for error
				if (responseData[0] == "ERROR") {
					document.getElementById('start').innerHTML = "";
					document.getElementById("message").style.display	=	'block';
					document.getElementById('message').innerHTML 	= "<table align=center><tr><td height=30><font color = 'red'><b>" + responseData[1] + "</b></font></td></tr></table>";
				}
				else {
					
					document.getElementById('message').innerHTML 	= 	responseData[9];
	        		document.forms[0].record_per_page.value			=	responseData[0];
	        		document.forms[0].no_of_combo.value				=	responseData[1];
					document.forms[0].actual_page_block.value		=	responseData[2];
					document.forms[0].totalpage.value				=	responseData[3];
					document.forms[0].divisionId.value				=	responseData[10];
					document.getElementById("start").innerHTML 		= 	responseData[4];
					document.getElementById("searchid").innerHTML	= 	responseData[5];
					document.getElementById("footer").style.display	=	'block';
					document.getElementById("a1").style.display		=	'none';
					
					var	curr_block		=	responseData[7];
			  	
			   		if(document.getElementById("bb"+curr_block) !=null)
			   		{
			   			document.getElementById(curr_block).style.display='block';
			   			document.forms[0].divisionId.value=curr_block;
			   			changeDiv(curr_block);
			   			document.forms[0].divisionId.value=curr_block;
						document.getElementById("bb"+curr_block).style.color=selColor;
					}
					else
					{
			    		if(document.getElementById("bba1") !=null)
			   			{
			   				document.getElementById("a1").style.display='block';
			   				document.forms[0].divisionId.value="a1";
			 				document.getElementById("bba1").style.color=selColor;
						}		
					}				
			 	}
			 	try{
			     	autoTabIndexing();
			    }catch(_Err){
			     	//alert("Application Error[TabIndex not Included] Please Contact System Administrator");
			 	}
			 }			
		}
	}
	
	xmlHttp.send(params);
}		

/* 
* changeDiv () function called when user click on the block( page number) 
* current active block is shown with red color and other are black color
*/
function changeDiv(index)
{

	var divisionId	=	document.forms[0].divisionId.value;
	var blc			=	"bb"+index;
	var blcdiv		=	"bb"+divisionId;
	
	var rec_per_page = document.forms[0].record_per_page.value;
	var prevDivIndex = divisionId.substring(1,divisionId.length);
	var min_rec_len = parseInt(rec_per_page)*(parseInt(prevDivIndex) -1); 
	var max_rec_len = parseInt(rec_per_page) * parseInt(prevDivIndex);
	
	document.getElementById(blcdiv).style.color=defColor;	
	document.getElementById(blc).style.color=selColor;
	
	//document.getElementById("message").style.display	=	'none'; 
	document.forms[0].chkmain.checked					=	false;
	
	if(!isNaN(document.forms[0].chk.length))
		{
			for(var i=min_rec_len;i< max_rec_len && i < document.forms[0].chk.length;i++)
			{
				if(document.getElementById("tr"+(i+1)).className!="rowfontmatch")
					document.getElementById("tr"+(i+1)).className='ONMOUSEOUT1';
					
				document.forms[0].chk[i].checked	=	false;
			}
		}
	else
		{
			if(document.getElementById("tr1").className!="rowfontmatch")
				document.getElementById("tr1").className='ONMOUSEOUT1';
				
			document.forms[0].chk.checked	=	false;
		}
	document.getElementById(divisionId).style.display		=	'none';
	document.getElementById(index).style.display			=	'block';
	document.forms[0].divisionId.value	=	index;
	
}


		
/* record selection on the listing page change the color of table row on mouseover and mouse out
*
*/

function changeColor(event,i,flag)
{
	
	var retVal;
	
	if(flag==0)		//on mouse over
		event.className = "ONMOUSEOVER1";
	else
	 {
		if(isNaN(document.forms[0].chk.length))
			retVal = document.forms[0].chk.checked;
		else
			retVal = document.forms[0].chk[i-1].checked;	
				
		if(retVal==true)
		{
			event.className = "ONSELECTYELLOW";
		}
			
		else
			event.className = "ONMOUSEOUT1";
	}
}
		 
/* 
*	changeNextPage(index,rownum) is called when user click on the next link at list page
*/


function changeNextPage(index,rownum)
{
	//document.getElementById("message").style.display	=	'none';	
	
	var total_page	=	document.forms[0].totalpage.value;
	var n			=	"n"+index;
	var p			=	"n"+index+1;
	
	if(p==index)
		document.getElementById(p).style.display='block';
	else
		document.getElementById(n).style.display='none';

}

/* 
*	changeBDivision(objvalue) is called when user click on the block  link at list page
*/

function changeBDivision(objvalue)
{
	var obj		=	objvalue.split("^");
	var p		=	obj[0];
	var i		=	obj[1];
	var k		=	obj[2];
	var obj1	=	p+"^"+i;
	
	v		=	p+"^"+(++i);
	changeDiv("a"+k);
	document.getElementById("message").style.display	=	'none';	
	document.getElementById(obj1).style.display			=	'none';
	document.getElementById(v).style.display			=	'block';

}

 /* 
*	changeNextPage(index,rownum) is called when user click on the Previous link at list page
*/
 
function changePDivision(objvalue)
{
	var obj	=	objvalue.split("^");
	var p	=	obj[0];
	var i	=	obj[1];
	var k	=	obj[2];
	var obj1=	p+"^"+i;
		i--;
		v		=	p+"^"+i;
		changeDiv("a"+k);
		document.getElementById("message").style.display	=	'none';	
		document.getElementById(obj1).style.display			=	'none';
		document.getElementById(v).style.display			=	'block';
}

// for checking main check box

function isCheckedFirst(obj)
{
	var record_par_page	=	document.forms[0].record_per_page.value;
	if(document.forms[0].minrow !=null)
	{
		min_row=document.forms[0].minrow.value;
		min_row=document.forms[0].max_rownum.value;
	}
	
	if(document.getElementsByName("chk")==null) return;
	
	  if(!isNaN(document.getElementsByName("chk").length)) 
	  { 
			for(var i=0;i<document.forms[0].chk.length-1;i++)
	   	 		document.forms[0].chk[i].checked=false;
	  }
	  else
	   	 document.forms[0].chk.checked=false;
	  
	var temp	=	document.getElementById(document.forms[0].divisionId.value).id;
	var sub		=	temp.substring(1,temp.length);
	var m		=	((record_par_page*sub)-record_par_page)+1;
	 //alert("u"+document.forms[0].chkmain.checked);  
	 if(obj.checked==true)
	 {
		 if(!isNaN(document.getElementsByName("chk").length))	
		 {
				 for(var i=((record_par_page * sub)-record_par_page);i<(record_par_page*sub);i++,m++)
					{
						if(document.getElementsByName("chk").length <=i)
								break;
								if(document.getElementById("tr"+parseInt(m)).className=="ONMOUSEOVER1" || document.getElementById("tr"+parseInt(m)).className=="ONMOUSEOUT1")
					          //document.getElementById("tr"+parseInt(m)).className='ONMOUSEOVER1';
									document.getElementById("tr"+parseInt(m)).className='ONSELECTYELLOW';
								document.getElementsByName("chk")[i].checked=true;
					} 
		 }
		 else
		 {
			 	if(document.getElementById("tr"+parseInt(m)).className=="ONMOUSEOVER1" || document.getElementById("tr"+parseInt(m)).className=="ONMOUSEOUT1")
			 	//document.getElementById("tr1").className='ONMOUSEOVER1';
		 			document.getElementById("tr1").className='ONSELECTYELLOW';
				document.forms[0].chk.checked=true;
		 }
	 } 
	 else 
	 {	
			if(!isNaN(document.getElementsByName("chk").length))	     
			{
					for(var i=((record_par_page*sub)-record_par_page);i<(record_par_page*sub);i++)  
					{  
				          if(document.getElementsByName("chk").length <=i)
			          		     break;
			          		     if(document.getElementById("tr"+parseInt(m)).className=="ONMOUSEOVER1" || document.getElementById("tr"+parseInt(m)).className=="ONMOUSEOUT1" ||document.getElementById("tr"+parseInt(m)).className=="ONSELECTYELLOW")
				           	 document.getElementById("tr"+parseInt(m)).className='ONMOUSEOUT1';
			          		   document.getElementsByName("chk")[i].checked	=	false;
						  	 m++; 
				     } 
			 }
			 else
			 {
			 		if(document.getElementById("tr"+parseInt(m)).className=="ONMOUSEOVER1" || document.getElementById("tr"+parseInt(m)).className=="ONMOUSEOUT1" || document.getElementById("tr"+parseInt(m)).className=="ONSELECTYELLOW")
			      document.getElementById("tr1").className='ONMOUSEOUT1';
			      document.forms[0].chk.checked		=	false;
			 }
		}
		
	 try
	 {
			chkUserDefinedFunc();
	 }
	 catch(_err)
	 {			
	 }
}

/* view () method is called when user click on view button of list page and it
* opens a popup page gbl_master_view.jsp
*/
function  view()
{
     document.getElementById('message').style.display='none';

	if(checkForView()==false) return false;
    
	var chk_temp	=	document.forms[0].chk.length;
	var temp_cnt	=	document.forms[0].cnt_page.value;
	var temp1		=	temp_cnt.split(".");
	var cnt_page	=	temp1[0];
	var chk			=	"";
	
	var mode = "VIEWDATA";	
		
	if(!isNaN(chk_temp))
	{
		for(var i=0;i<chk_temp;i++)
		{
			if(document.forms[0].chk[i].checked==true) 
			{
				chk =document.forms[0].chk[i].value;
				
			}
			
		}
	}
	else
	{
		chk =document.forms[0].chk.value;
		
	}
	
	var  heightValue = document.forms[0].view_row_length.value * 40;
		
	var url = "../../hisglobal/transactionutil/master/view_transTemp_gbl.jsp?mode="+mode+"&chk="+chk+"&cnt_page="+cnt_page+"&masterName="+document.forms[0].masterName.value;
	openPopUp_master(url,'700',heightValue,'1');
	//var myPopup     =  window.open(,'popupWindow',heg_width, 'scrollbars=yes,ALIGN=CENETER,left=100,top=100');
 
}

/*
* this function called on body onload of popup page and mode is VIEWDATA and goes to
* conrtroller page of user
*/

function fetchViewData()
	{ 
     
	xmlHttp			=	createRequestObject();

//    var params= "../../../" + document.forms[0].cnt_page.value+".cnt?hmode="+document.forms[0].hmode.value+"&chk="+document.forms[0].chk.value;
    var params= opener.document.forms[0].action + "?hmode="+document.forms[0].hmode.value+"&chk="+document.forms[0].chk.value;
    params = createFHashAjaxQuery(params);
    xmlHttp.open("POST",params,true);
	document.getElementById("viewdata").innerHTML ='<table align=center><tr class="ROWFONT"><td height=30><b>Wait Fetching Data from Database...</b></td></tr></table>';
	xmlHttp.onreadystatechange = function()
	{
		if(xmlHttp.readyState ==4 )
			{ 
			
				if(xmlHttp.status == 200 || xmlHttp.status=='complete' )
					{  
				    
				  	var response = xmlHttp.responseText;
					document.getElementById("viewdata").innerHTML=xmlHttp.responseText;
					try{
				     	autoTabIndexing();
				    }catch(_Err){
				     	//alert("Application Error[TabIndex not Included] Please Contact System Administrator");
				 	}
					 }
			}
	} 
		xmlHttp.send(params);
}
		
	
	
/*
* fetchViewNext(index) method is called when user click on next link at view page of master with mode VIEWDATA
*
*/

function fetchViewNext(index)
{
	var divisionId		= 	opener.document.forms[0].divisionId.value;
	var rec_per_page	= 	opener.document.forms[0].record_per_page.value;
	var prevDivIndex 	= 	divisionId.substring(1,divisionId.length);
	var min_rec_len 	= 	parseInt(rec_per_page)*(parseInt(prevDivIndex) -1); 
	var max_rec_len 	= 	parseInt(rec_per_page) * parseInt(prevDivIndex);
	var current_div_id	=	parseInt(index)/parseInt(rec_per_page);
	var prev_div		=	opener.document.forms[0].divisionId.value;
	var chk				=	"";
	var total_rec		=	"";
	 
	
	 if((parseInt(opener.document.forms[0].totalpage.value)) < parseInt(opener.document.forms[0].page_par_block.value))
	      total_rec=parseInt(opener.document.forms[0].totalpage.value) * parseInt(rec_per_page);
	   else
	      total_rec=(parseInt(opener.document.forms[0].totalpage.value)-1) * parseInt(rec_per_page);
	      
 	if((index < (parseInt(opener.document.forms[0].chk.length))) && (index < total_rec))
	 	{
 			chk		=	opener.document.forms[0].chk[index].value; // fetch next value of checkbox from list page
			opener.document.forms[0].chk[index].checked							=	true;  // below 4 line objects is  fetching  from original window
			opener.document.forms[0].chk[index-1].checked						=	false;
			opener.document.getElementById("tr"+index).className				=	'ONMOUSEOUT1';
			opener.document.getElementById("tr"+(parseInt(index)+1)).className	=	'ONMOUSEOVER1';
		
			if(current_div_id <=0)
				current_div_id	=	1;
			else
				current_div_id	=	parseInt(current_div_id)+1;
		
		var blockcomp	="a"+current_div_id;
		if(prev_div !=blockcomp) // if block is change
			{
				opener.document.getElementById("bba"+parseInt(current_div_id)).style.color			=	selColor;
				opener.document.getElementById("bba"+parseInt(prev_div.substring(1))).style.color	=	defColor;
				opener.document.getElementById(prev_div).style.display								=	'none';
				opener.document.getElementById("a"+parseInt(current_div_id)).style.display			=	'block';
				opener.document.forms[0].divisionId.value		=	"a"+parseInt(current_div_id);
			}
			
		//var params="../../../"+document.forms[0].cnt_page.value+".cnt?hmode=VIEWDATA&chk="+chk;
		var params=opener.document.forms[0].action + "?hmode=VIEWDATA&chk="+chk;
		params = createFHashAjaxQuery(params);
		xmlHttp.open("POST",params,true);
		document.getElementById("viewdata").innerHTML ='<table align=center><tr class="ROWFONT"><td height=30><b>Wait Fetching Data from Database...</b></td></tr></table>';
		xmlHttp.onreadystatechange = function()
			{
				if(xmlHttp.readyState ==4 && xmlHttp.status == 200)
				{
					var response = xmlHttp.responseText;
					document.getElementById("viewdata").innerHTML	=	xmlHttp.responseText;
					try{
				     	autoTabIndexing();
				    }catch(_Err){
				     	//alert("Application Error[TabIndex not Included] Please Contact System Administrator");
				 	}
				}
			}
		xmlHttp.send(params);
		}
	else
		alert("No More Data To display");
}
		
		
/*
* fetchViewPrevious(index) method is called when user click on Previous link at view page of
* master with mode VIEWDATA, it also change the color < table row > of parent window and checked 
* the chekbox on the basis of previous index
*/	

function fetchViewPrevious(index)
{
	var mode	=	'VIEWDATA';
	if(index == 0)
	{
		alert("No More Data !!");
		return;
	}
	
		var chk				=	opener.document.forms[0].chk[index-1].value;
		var prev_div		=	opener.document.forms[0].divisionId.value;
		var record_par_page	=	opener.document.forms[0].record_per_page.value;
		var current_div_id	=	parseInt(index-1)/parseInt(record_par_page) ;
		
		opener.document.forms[0].chk[index-1].checked						=	true;	// below 4 line objects is  fetching  from original window
		opener.document.forms[0].chk[index].checked							=	false;
		opener.document.getElementById("tr"+index).className				=	'ONMOUSEOVER1';
		opener.document.getElementById("tr"+(parseInt(index)+1)).className	=	'ONMOUSEOUT1';
		
	if(current_div_id 	<=	0)
		 current_div_id	=	1;
	 else
	  	current_div_id	=	parseInt(current_div_id) + 1;
	
	  var blockcomp			=	"a"+parseInt(current_div_id);
	
		if(prev_div !=blockcomp)
		{
			opener.document.getElementById("bba"+parseInt(current_div_id)).style.color			=	selColor;
			opener.document.getElementById("bba"+parseInt(prev_div.substring(1))).style.color	=	defColor;
			opener.document.getElementById(prev_div).style.display								=	'none';
			opener.document.getElementById("a"+current_div_id).style.display					=	'block';
			opener.document.forms[0].divisionId.value											=	"a"+parseInt(current_div_id);
		}
//		var params="../../../"+document.forms[0].cnt_page.value+".cnt?hmode="+mode+"&chk="+chk;
		var params=opener.document.forms[0].action + "?hmode="+mode+"&chk="+chk;
		params = createFHashAjaxQuery(params);
	xmlHttp.open("POST",params,true);
	document.getElementById("viewdata").innerHTML ='<table align=center><tr class="ROWFONT"><td height=30><b>Wait Fetching Data from Database...</b></td></tr></table>';
	xmlHttp.onreadystatechange = function()
	{
		if(xmlHttp.readyState ==4 && xmlHttp.status == 200)
		{
			var response = xmlHttp.responseText;
			document.getElementById("viewdata").innerHTML=xmlHttp.responseText;
			try{
		     	autoTabIndexing();
		    }catch(_Err){
		     	//alert("Application Error[TabIndex not Included] Please Contact System Administrator");
		 	}
		}
	}
	xmlHttp.send(params);
}


	
/***********************Report Page javaScript*********************************************/

/*	
report(mode) function is called when user click on the report button

*/
function report()
{
	if(document.forms[0].chk ==null) return ;
	
	var no_of_combo	=	document.forms[0].no_of_combo.value;
	var temp_combo	=	document.forms[0].combo;
	var comboValue	=	"";
	var mode 		= 	"REPORT";
	
	if(temp_combo)
	{
		if(no_of_combo >1)
		{
			for(var i=0;i<temp_combo.length;i++)
				comboValue +=temp_combo[i].options[temp_combo[i].selectedIndex].text+"@";
		}
	}
	else
		if(no_of_combo ==1) 
			comboValue =temp_combo.options[temp_combo.selectedIndex].text;
	
	document.forms[0].comboValue.value	=	comboValue;
	document.forms[0].hmode.value		=	mode;
	document.forms[0].submit();
}

/*
* fetchReportsData() methods call when user click on the report button 
* this methods called on  body onload  of report page 
*/

function fetchReportsData()
{ 
	xmlHttp			=	createRequestObject();	
	var combo1			=	document.forms[0].combo;
	var blockNo			=	document.forms[0].blockNo.value;
	//var search			=	document.forms[0].search.value;
	//var searchColumn 	=	document.forms[0].searchColumn.value;
	var search			=	document.getElementsByName("search")[0].value;
	var searchColumn 	=	document.getElementsByName("searchColumn")[0].value;
	
	var combotext		=	document.forms[0].comboValue.value;
	var no_of_combo		=	document.forms[0].no_of_combo.value;
	var combostr		=	"";
	var minrow			=	0;
	var str				=	"";
	var combo2			=	"";
	
	if(combo1 	!=	null)
	{
		if(no_of_combo >1)
			{
				for(var i=0;i<combo1.length;i++)
					str += "&combo=" + combo1[i].value;
			}
		else
			{
			if(no_of_combo == 1)
	     	 	 str = "&combo=" +combo1.value;
	     	 }
	}
	
	//var params="../../"+document.forms[0].cnt_page.value+".cnt?hmode=REPORTDATA"+str+"&minrow"+minrow+"&cnt_page="+document.forms[0].cnt_page.value+"&blockNo="+blockNo+"&search="+search+"&searchColumn="+searchColumn+"&comboValue="+combotext;
	var params = document.forms[0].action + "?hmode=REPORTDATA"+str+"&minrow"+minrow+"&cnt_page="+document.forms[0].cnt_page.value+"&blockNo="+blockNo+"&search="+search+"&searchColumn="+searchColumn+"&comboValue="+combotext;
	params = createFHashAjaxQuery(params);
	xmlHttp.open("POST",params,true);
	document.getElementById('reportdata').innerHTML ='<table align=center><tr class="ROWFONT"><td height=30><b>Wait Fetching Data from Database...</b></td></tr></table>';
	
	xmlHttp.onreadystatechange = function()
	{
		if(xmlHttp.readyState ==4 )
		{
			if(xmlHttp.status == 200 || xmlHttp.status=='complete')
			{	
				var response = xmlHttp.responseText;
				var responseData=response.split("####");
				
				//check for error
				if (responseData[0] == "ERROR") {
					document.getElementById('reportdata').innerHTML 	= "<table align=center><tr><td height=30><font color = 'red'><b>" + responseData[1] + "</b></font></td></tr></table>";
				}
				else {
					document.getElementById("reportdata").innerHTML 	=	responseData[0];
					document.forms[0].blockNo.value						=	responseData[1];
				}
				try{
			     	autoTabIndexing();
			    }catch(_Err){
			     	//alert("Application Error[TabIndex not Included] Please Contact System Administrator");
			 	}	
			}
		}
	}
	
	xmlHttp.send(params);
}

	
/*
* fetchNextPrev() methods is called when user click on next
* and previos lonk on report page 
*/	
		
function fetchNextPrev(blockNo)
{
	var combo1			=	document.forms[0].combo;
	var combotext		=	document.forms[0].comboValue.value;
	//var search			=	document.forms[0].search.value;
	//var searchColumn 	=	document.forms[0].searchColumn.value;
	var search			=	document.getElementsByName("search")[0].value;
	var searchColumn 	=	document.getElementsByName("searchColumn")[0].value;
	
	var no_of_combo 	=   document.forms[0].no_of_combo.value;
	var str				=	"";
	var combo2			=	"";
	document.forms[0].blockNo.value	=	blockNo;
	
	if(combo1 !=	null)
	{
		if(no_of_combo >1)
			{	for(var i=0;i<combo1.length;i++)
					str += "&combo=" + combo1[i].value;
			}		
		else
			if(no_of_combo == 1)
				str = "&combo=" +combo1.value;
	}	
		
	//var params		=	"../../"+document.forms[0].cnt_page.value+".cnt?hmode=REPORTDATA"+str+"&minrow=0&blockNo="+blockNo+"&search="+search+"&searchColumn="+searchColumn+"&comboValue="+combotext;
	var params		=	document.forms[0].action + "?hmode=REPORTDATA"+str+"&minrow=0&blockNo="+blockNo+"&search="+search+"&searchColumn="+searchColumn+"&comboValue="+combotext;
	
	params = createFHashAjaxQuery(params);
	xmlHttp.open("POST",params,true);
	document.getElementById('reportdata').innerHTML ='<table align=center><tr class="ROWFONT"><td height=30><b>Wait Fetching Data from Database...</b></td></tr></table>';
	
	xmlHttp.onreadystatechange = function()
	{
		if(xmlHttp.readyState ==4 )
		{
			if(xmlHttp.status == 200 ) {
				
				var response = xmlHttp.responseText;
				var responseData=response.split("####");
				
				//check for error
				if (responseData[0] == "ERROR") {
					document.getElementById('reportdata').innerHTML 	= "<table align=center><tr><td height=30><font color = 'red'><b>" + responseData[1] + "</b></font></td></tr></table>";
				}
				else
					document.getElementById("reportdata").innerHTML= responseData[0];
				try{
			     	autoTabIndexing();
			    }catch(_Err){
			     	//alert("Application Error[TabIndex not Included] Please Contact System Administrator");
			 	}
			}	
		}		
	}
	
	xmlHttp.send(params);
}

/*******************General Functions for master**********************************/
	
function cancel(mode)
{
	document.forms[0].hmode.value=mode;
	document.forms[0].submit();
}

function printData()
{
	document.getElementById("id1").style.display="none";
	window.print();
	document.getElementById("id1").style.display="block";
}

function checkForDelete()
{
	var totalChk=0;
	if(document.forms[0].chk ==null)
	{	
		alert("No Value Exists!");
		return false;
	}
	else
	{
		var divisionId		=document.forms[0].divisionId.value;
		var rec_per_page	=document.forms[0].record_per_page.value;
		var prevDivIndex = divisionId.substring(1,divisionId.length);
		var min_rec_len = parseInt(rec_per_page)*(parseInt(prevDivIndex) -1); 
		var max_rec_len = parseInt(rec_per_page) * parseInt(prevDivIndex);
	
		if(!isNaN(document.forms[0].chk.length))
		{
			for(var i=min_rec_len;i< max_rec_len && i < document.forms[0].chk.length;i++)
			{
				if(document.forms[0].chk[i].checked==true)
					{	
						totalChk++;
						break;
					}
			}
		}
		else
		{
			if(document.forms[0].chk.checked==true)
				totalChk++;
		}
	}
	if(totalChk <=0)
		{
			alert("Select A  Record To Delete!");
				return false;
		}
		else
	 	   if(totalChk > 1 )
	 		return true;
}


function checkForView()
{
	var totalChk=0;
	if(document.forms[0].chk ==null)
	{ 
		alert("No Value Exists!");
		return false;
	}
	else
	{
	var divisionId		=document.forms[0].divisionId.value;
	var rec_per_page	=document.forms[0].record_per_page.value;
	var prevDivIndex = divisionId.substring(1,divisionId.length);
	var min_rec_len = parseInt(rec_per_page)*(parseInt(prevDivIndex) -1); 
	var max_rec_len = parseInt(rec_per_page) * parseInt(prevDivIndex);
	
	
	if(!isNaN(document.forms[0].chk.length))
	{
		for(var i=min_rec_len;i< max_rec_len && i < document.forms[0].chk.length;i++)
			{
			if(document.forms[0].chk[i].checked==true)
				{	
					totalChk++;
					
			  		if(totalChk >1)
			   		 break;
			   } 
			}
	}
		else
			 {
			 if(document.forms[0].chk.checked==true)
				totalChk++;
					     	
			 }
		 		
	}
	if(totalChk <=0)
	{
				alert("Select A  Record To View!!");
				return false;
	}
	 else
	 	if(totalChk > 1 )
	 	{
	 	alert("Only One Record Can Be Viewed!!");
		 	return false;
		 }  
		else
			return true;

}

function checkForModify()
{
	var totalChk=0;
	
	if(document.forms[0].chk ==null)
		{ 
		alert("No Value Exists!!");
		return ;
		}
	
	else
	{
		var divisionId		=document.forms[0].divisionId.value;
		var rec_per_page	=document.forms[0].record_per_page.value;
		var prevDivIndex = divisionId.substring(1,divisionId.length);
		var min_rec_len = parseInt(rec_per_page)*(parseInt(prevDivIndex) -1); 
		var max_rec_len = parseInt(rec_per_page) * parseInt(prevDivIndex);
		
		if(!isNaN(document.forms[0].chk.length))
			{
			for(var i=min_rec_len;i< max_rec_len && i < document.forms[0].chk.length;i++)
				{
				if(document.forms[0].chk[i].checked==true)
					{
						totalChk++;
						if(totalChk >1)
	   	 					break;
					}
				}
			}	
		else
			 {
			 if(document.forms[0].chk.checked==true)
				totalChk++;
			}
	}
	if(totalChk <=0)
		{
			alert("Select A  Record To Modify!");
			return false;
		}
 	else
		if(totalChk > 1 )
	 	{
	 		alert("Only One Record Can Be Modified At A Time!");
	 		return false;
	 	}  
	 	else
	        return true;
	  
	
}

	

function getChkLength()
	{
		 var totalChk=0;
		 if(document.forms[0].chk !=null)
		    {
		 if(isNaN(document.forms[0].chk.length))
		 	{
		  	if(document.forms[0].chk.checked==true)
				totalChk++;
		 	 }
		 	else
		 	{
		  		for(var m=0;m<document.forms[0].chk.length;m++)
			 	 {   
			   		if(document.forms[0].chk[m].checked==true)
			     		totalChk++;
			     }
			} 
		  }	   
		return totalChk;
	}

function submitPage(mode)
{
	document.forms[0].hmode.value=mode;
	document.forms[0].submit();
}

function edit(mode)
{
	if(checkForModify()==true)
	   {
		document.forms[0].hmode.value=mode;
		document.forms[0].submit();
		}
}


function add(mode)
{
	if(document.getElementById('message').innerHTML.length>0)
	{
		alert("Menu Services Not Applicable due to Error on Form!");
		return;
	}
	else
	{
		document.forms[0].hmode.value=mode;
		document.forms[0].submit();
	}
	
	
}

/**
	Popup functionality
	
	This function is used to open pop up window
	
	<<Constrints >> In a page, only one popup window can be active at a time. If user tries to open another
	popup window then this function will close the previous popup then open the new popup
	
	<<How to use the popup functionality >>
	
	Step 1>> Define the following global variables in parent form
			
			var child = null;
			var popIndex = 0;
			var gblCntrlObj = null;

	Step 2>> write the following code in body tag in parent form
			
			onFocus="checkPopUp();" onUnload="closePopUp();"
	
	Step 3>>Write the following code to open popup where you want 
			
			openPopUp(url,width,height,index,cntrlObj) -- Argument description defined below
	
	Step 4>>In Popup window, write the following code in body tag
	
			onUnload="window.opener.closePopUp_master();"
	
	Step 5 >>In Popup window, if you have given the close functionality then call the following function on close event
			
			window.opener.closePopUp_master();	
	
			
	<<Argument>>
	
	url >> path
	width >> width of the popup page
	height >> height of the popup page
	index >> unique value, this is mandatory. 
			It will be useful if same popup is displayed on different - different event
	
	cntrlObj >> Not Mandatory (don't need to pass anything), it would be useful if popup window is opened 
				using checkbox and you want that as popup window is closed then this checkbox should be unchecked.		 
*/
function openPopUp_master(url,width,height,index,cntrlObj)
{
	var width = width;
    var height = height;
    var left = parseInt((screen.availWidth/2) - (width/2));
    var top = parseInt((screen.availHeight/2) - (height/2));
    var flag = 0;
			
	if(child!=null && !child.closed) {
		if(popIndex == index) {
			flag = 1;
			child.focus();
		}
		else {
			closePopUp_master();
		}	
	}
	
	if(flag == 0) {
		popIndex = index;
		gblCntrlObj = cntrlObj;	
		var windowFeatures = "width=" + width + ",height=" + height + ",status,scrollbars=yes,left=" + left + ",top=" + top + "screenX=" + left + ",screenY=" + top;
		child = window.open(url, "subWind", windowFeatures);
		child.focus();
	}
}//end openPopUp()

/**
	This function is used to set focus on pop up window
*/
function checkPopUp_master()
{
	if(child!=null && !child.closed)
		child.focus();
}

/**
	This function is used to close popup window
*/
function closePopUp_master()
{
	if(child!=null && !child.closed)
	{
		if (gblCntrlObj != null && typeof(gblCntrlObj) != "undefined") 
		{
			if ((gblCntrlObj.type).toUpperCase() == "CHECKBOX") 
			{
				gblCntrlObj.checked = false;
				gblCntrlObj = null;
			}
			
		}
		//
		child.close();
		child = null;
		popIndex = 0;	
	}
}
//popup functionality finish


/*********** functions made by Rahul ****************/

// to enable or disable search field table.
function searchData(e){
	if (window.event)
		key = window.event.keyCode;
	else
		key = e.which;
	if(document.getElementById("searchid").style.display == "block"){		
		e.altKey ? ((key==83)?document.getElementById("searchid").style.display="none":""):"";
	} else if(document.getElementById("searchid").style.display == "none"){		
		e.altKey ? ((key==83)?document.getElementById("searchid").style.display="block":""):"";
	//e.altKey ? ((e.keyCode==83)?document.getElementById("searchid").style.display="block":document.getElementById("searchid").style.display="none"):(e.keyCode==27?document.getElementById("searchid").style.display="none":document.getElementById("searchid").style.display="block");
	}
}

function chkFunc(eve,obj,func){	
	
	if(obj.checked == true)
	{
		document.forms[0].chkValue.value = obj.value;		
		document.forms[0].chkLength.value = parseInt(document.forms[0].chkLength.value) + 1;		
		//document.getElementById("buttonTab0").style.background-color="red";
		eve.className="ONSELECTYELLOW";
	} 
	else
	{
		document.forms[0].chkValue.value = "";
		document.forms[0].chkLength.value = parseInt(document.forms[0].chkLength.value) - 1;
		if(document.forms[0].chkLength.value == -1)
			document.forms[0].chkLength.value = 0;
	}
	
	//call user defined function 
	if(func != null && func != "") 
	{	
		eval(func+'(obj' + ")");
	}
}


function selectRow(eve,obj,idx,func)
{	
	//document.forms[0].chkValue.value = obj.value;		
	
	var chkObj="chk"+idx;
	if(obj.className=="ONSELECTYELLOW")//If Already Selected Then Unselect The Row
	{
		obj.className="ONMOUSEOUT1";
		document.getElementById(chkObj).checked=false;
		document.getElementById("checkbtn"+idx).style.display="none";
		document.getElementById("checkbtnDisabled"+idx).style.display="";
		//document.forms[0].chkLength.value = parseInt(document.forms[0].chkLength.value) - 1;
		chkFunc(eve,document.getElementById(chkObj),func);
		return;
	}
	else
	{
		if(!isNaN(document.getElementsByName("chk").length)) 
		{
				for(var i=0;i<=document.getElementsByName("chk").length-1;i++)//RESET ALL ROWS TO DEFAULT
				{
					//alert(document.getElementsByName("chk")[i].id);
					document.getElementsByName("chk")[i].checked=false;
					if(!document.getElementById("tr"+(i+1)).className=="ROWFONTMATCH")
						document.getElementById("tr"+(i+1)).className="ONMOUSEOUT1";
					document.getElementById("checkbtn"+(i+1)).style.display="none";
					document.getElementById("checkbtnDisabled"+(i+1)).style.display="";
				}		   	 		
		}
		document.getElementById(chkObj).checked=true;
		document.getElementById("checkbtn"+idx).style.display="";
		document.getElementById("checkbtnDisabled"+idx).style.display="none";
		//document.getElementById("buttonTab0").style.background-color="red";
		obj.className="ONSELECTYELLOW";
		chkFunc(eve,document.getElementById(chkObj),func);
	}	
}


function resetRow()
{	
	var check=document.getElementsByName("chk");
	for(var i=0;i<check.length;i++)
	{
		check[i].checked=false;
		document.getElementById("checkbtn"+(i+1)).style.display="none";
		document.getElementById("checkbtnDisabled"+idx).style.display="none";
	}
}
function resetOtherRow(idx)
{	
	var check=document.getElementsByName("chk");
	for(var i=0;i<check.length;i++)
	{
		//alert(check[i].id+"XXX"+idx);
		//alert(!check[i].id=="chk"+idx);
		if(!(check[i].id=="chk"+idx))
		{
			document.getElementById("checkbtn"+(i+1)).style.display="none";
			document.getElementById("checkbtnDisabled"+idx).style.display="";
		}
		else
		{
			document.getElementById("checkbtn"+(i+1)).style.display="";
			document.getElementById("checkbtnDisabled"+idx).style.display="none";
		}
	}
}
function button1(modeType){

	var mod = "BUTTON";	
	var params="../../../"+document.forms[0].cnt_page.value+".cnt?hmode="+mod+"&mode="+modeType;
	
//var params = "../../../item_master/master/Item_action.cnt?hmode=BUTTON";		
	//alert(params);
	xmlHttp = createRequestObject();
	params = createFHashAjaxQuery(params);
	xmlHttp.open("POST",params,true);	
	
	  xmlHttp.send(null);
	xmlHttp.onreadystatechange = function()
	{
		if(xmlHttp.readyState == 4){
				if(xmlHttp.status == 200){ 				
				var response 		= 	xmlHttp.responseText;	
				var responseData	=	new Array();
				//responseData	=	response.split("###");
				if(modeType == 1)
					document.getElementById("buttonId").innerHTML = response;
				else if(modeType == 2)
					document.getElementById("buttonId2").innerHTML = response;	
				try{
			     	autoTabIndexing();
			    }catch(_Err){
			     	//alert("Application Error[TabIndex not Included] Please Contact System Administrator");
			 	}
				}
			}
	}
}

function callMe(mode){
	//alert("hi!!!!!!!"+document.forms[0].chkLength.value);
	alert(parent.document.getElementById("testData").value);
	//alert(document.getElementById("frame2").innerHTML);
}

/*
 * This function will be called after an on change event in search field.
 * It will convert any initial space or ' or # or $ or & character found in Search 
 * Field into empty String.
 */
function validateSearchField(element) {
	var strElementValue=element.value;
	
	
	/* LTrim */
	strElementValue=strElementValue.replace(/^\s+/,"");
	
	/* REMOVING ' # $ & special characters. */
	strElementValue=strElementValue.replace(/[#$&']/g, "");
	
	element.value=strElementValue;
}


function changeSize(imgObj)
{
	imgObj.style.width='31px';
	imgObj.style.height='31px';
	//imgObj.css({'width' : '31px' , 'height' : '31px'});
	
	/*if($('[name="intMenuViewType"]')[0])
		menuViewType = $('[name="intMenuViewType"]')[0].value;
	else
		menuViewType = 6;
		//menuViewType = 7;
	
	
	
	if(menuViewType=="1")
	{
		// Large Icons View
		$(imgObj).css({'width' : '85px' , 'height' : '85px'});
	}
	else if(menuViewType=="2")
	{
		// Medium Icons View
		$(imgObj).css({'width' : '70px' , 'height' : '70px'});
	}
	else if(menuViewType=="3")
	{
		// Small Icons View
		$(imgObj).css({'width' : '55px' , 'height' : '55px'});
	}
	else if(menuViewType=="4")
	{
		// Tiles View
		$(imgObj).css({'width' : '35px' , 'height' : '35px'});
	}
	else if(menuViewType=="5")
	{
		// Details View
		$(imgObj).css({'width' : '35px' , 'height' : '35px'});
	}
	else if(menuViewType=="6")
	{
		// Very Small Icon View
		$(imgObj).css({'width' : '31px' , 'height' : '31px'});
	}
	else if(menuViewType=="7")
	{
		// Very Small Icon View
		$(imgObj).css({'width' : '45px' , 'height' : '45px'});
	}
	else
	{
		// Default - Large Icons View
		$(imgObj).css({'width' : '85px' , 'height' : '85px'});
	}*/
}

function resetSize(imgObj)
{
	imgObj.style.width='30px';
	imgObj.style.height='30px';
	//imgObj.css({'width' : '30px' , 'height' : '30px'});
	
	/*if($('[name="intMenuViewType"]')[0])
		menuViewType = $('[name="intMenuViewType"]')[0].value;
	else
		menuViewType = 6;
		//menuViewType = 7;

	if(menuViewType=="1")
	{
		// Large Icons View
		$(imgObj).css({'width' : '80px' , 'height' : '80px'});
	}
	else if(menuViewType=="2")
	{
		// Medium Icons View
		$(imgObj).css({'width' : '65px' , 'height' : '65px'});
	}
	else if(menuViewType=="3")
	{
		// Small Icons View
		$(imgObj).css({'width' : '50px' , 'height' : '50px'});
	}
	else if(menuViewType=="4")
	{
		// Tiles View
		$(imgObj).css({'width' : '30px' , 'height' : '30px'});
	}
	else if(menuViewType=="5")
	{
		// Details View
		$(imgObj).css({'width' : '30px' , 'height' : '30px'});
	}
	else if(menuViewType=="6")
	{
		// Very Small Icon View
		$(imgObj).css({'width' : '30px' , 'height' : '30px'});
	}
	else if(menuViewType=="7")
	{
		// Very Small Icon View
		$(imgObj).css({'width' : '22px' , 'height' : '22px'});
	}
	else
	{
		// Default - Large Icons View
		$(imgObj).css({'width' : '80px' , 'height' : '80px'});
	}*/
}

function changeBGColor(divObj)
{
	var colour = ["rgb(224, 236, 255)"];
	//var colour = ["rgb(18, 109, 165)"];
	var backgroundColor = colour[colour.length * Math.random() << 0];
	
	divObj.style.backgroundColor=backgroundColor;
	
	/*divObj.css({
		backgroundColor: backgroundColor,
	});*/
}

function resetBGColor(divObj)
{
	//var colour = ["rgb(224, 236, 255)"];
	var colour = ["rgb(18, 109, 165)"];
	var backgroundColor = colour[colour.length * Math.random() << 0];
	divObj.style.backgroundColor=backgroundColor;
	
	/*divObj.css({
		backgroundColor: backgroundColor,
	});*/
}