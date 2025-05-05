function doPagination(e,p)
{
	// Override this function in your JS
}

// -------------------------------------------------------------------------------
// ************  Pagination Tag Overview
var pageTagRequest;
var pageTagQueryString;
var pageTagMousePosX;
var pageTagMousePosY;
var pageTagSelectedPage = '-1';

var cX = 0; var cY = 0; var rX = 0; var rY = 0;

function UpdateCursorPosition(e){ cX = e.pageX; cY = e.pageY;}
function UpdateCursorPositionDocAll(e){ cX = event.clientX; cY = event.clientY;}


function doPageOverview(e,p)
{
	if(pageTagSelectedPage != p)
	{
		pageTagMousePosX = e.clientX;
		pageTagMousePosY = e.clientY;
		sendRequest(p);
	}
	else
		setView(true);
	pageTagSelectedPage = p;
}

function sendRequest(pageNo)
{	
	var url="/AHIMS/hisglobal/PaginationTag?pageNo="+pageNo;
	httpRequest("GET",url,true);
}

function httpRequest(reqType,url,asynch)
{
	if(window.XMLHttpRequest)	//Mozilla-based browsers
	{
		pageTagRequest = new XMLHttpRequest();
		initReq(reqType,url,asynch);
	}
	else if (window.ActiveXObject)	// Other
	{
		pageTagRequest=new ActiveXObject("Msxml2.XMLHTTP");
		if (! pageTagRequest)	pageTagRequest=new ActiveXObject("Microsoft.XMLHTTP");
		if(pageTagRequest)		initReq(reqType,url,asynch);
		else	alert("Your browser does not permit the use of all of this application's features!");
 	}
 	else	alert("Your browser does not permit the use of all of this application's features!");
}

function initReq(reqType,url,isAsynch)
{
	pageTagRequest.onreadystatechange=handleResponse;
	pageTagRequest.open(reqType,url,isAsynch);
	pageTagRequest.setRequestHeader("Content-Type","application/x-www-form-urlencoded; charset=UTF-8");
	pageTagRequest.send(pageTagQueryString);
}

function handleResponse()
{
	if(pageTagRequest.readyState == 4)
	{
		if(pageTagRequest.status == 200)
		{
			var htmlCode = ""; 
			var data = pageTagRequest.responseText;
			if(data == null || data == "")	setView(false);
			
			var dataRows = data.split("#");
			var htmlCode = "";
			
			htmlCode+="<table cellspacing='1' cellpadding='0' border='1' bordercolor='brown' bgcolor='#FFFFFF'>";
			for(var i=0; i<dataRows.length; i++)
			{
				htmlCode+="<tr>";
				if(dataRows[i]!=null && dataRows[i]!="")
				{
					var dataCols = dataRows[i].split("@");
					for(var j=0; j<dataCols.length; j++)
					{
						htmlCode+="<td class='tdfonthead'><div align='center'>";
						htmlCode+=dataCols[j];
						htmlCode+="</div></td>";
					}
				}
				htmlCode+="</tr>";
			}
			htmlCode+="</table>";
			setView(true,htmlCode);
		}
		else
			alert("A problem occurred with communicating between the XMLHttpRequest object and the server program.");
	}
}

function setView(flag, htmlCode)
{
	var div = document.getElementById("divPaginationTag");
	
	if(flag)
	{
		if(typeof htmlCode != 'undefined')
			div.innerHTML = htmlCode;
		div.style.display = "block";
		positionOverview(div)
	}
	else
	{
		div.style.display = "none";
	}	
}

function positionOverview(div)
{
	// at bottom position
	div.style.top = document.body.offsetTop + document.body.scrollTop + pageTagMousePosY+10;
	div.style.left = document.body.offsetLeft + document.body.scrollLeft + pageTagMousePosX;
	//PragyaDesigner.showData(div);
	//alert(pageTagMousePosX+","+div.clientWidth +" > "+document.body.clientWidth+","+document.body.offsetLeft);
	if((pageTagMousePosX+document.body.offsetLeft+document.body.scrollLeft+div.clientWidth )>(document.body.clientWidth+document.body.offsetLeft-20))
		 div.style.left = document.body.offsetLeft + document.body.scrollLeft + pageTagMousePosX - div.clientWidth ;
}
// ************  End Pagination Tag Overview
// -------------------------------------------------------------------------------
