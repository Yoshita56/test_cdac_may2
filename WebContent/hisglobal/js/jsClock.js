/*
File Name 		: jsClock.js
Version	  		: 1.0
Developer 		: Prakhar Misra[Associate Project Engineer]
Supported by 	: Md. Riazuddin Ansari
Guided By		: Mr. A S Cheema
Last Updated	: 17-mar-2010
*/

/*
Note -->
1. Call the method setTime() on load of window or body
2. Create an div where the clock is to be displayed and pass its id as parameter
3. Pass the element name of current date as second parameter
4. If the current date is empty then the new date object will be create which contains the current date 
5. The format of current date should be dd-MM-yyyy HH:mm


*/

var st1;
var secs;
var timerID = null;
var timerRunning = false;
var delay = 1000;
var currentDate=null;
var dateAsString=null;
var request;
var divId;
var lastKeyDown;

function setTime(timeDiv,sysDate)
{
var date=document.getElementsByName(sysDate)[0]
var d
if(date.value==""){
 d=new Date();

date.value=setLength(d.getDate())+"-"+setLength(d.getMonth()+1)+"-"+d.getFullYear()+" "+setLength(d.getHours())+":"+setLength(d.getMinutes())


}


currentDate=convertStrToDate(date.value,date.value);
if(document.getElementsByName(sysDate)[0].value!=""){
	d=currentDate;
}
alert("urrrentsdt="+currentDate)
dateAsString=date.value;
var tdDate=document.getElementById(timeDiv);
var day=getNextDay(currentDate.getDay());
day=day+","+setLength(d.getDate())+"-"+getNextMonth(setLength(d.getMonth()+1)-1)+"-"+d.getFullYear()+" "+setLength(d.getHours())+":"+setLength(d.getMinutes())
tdDate.innerHTML="<b>"+ day +"</b>"
divId=timeDiv
InitializeTimer(sysDate);

}

function setLength(value){
	value=value+''
	if(value.length==1){
		value='0'+ value;
	}
	return value
}

function convertStrToDate(_date,_dateAsString)
{

	var fT=["dd","MM","yyyy","hh","mm","ss"];	// formatTokens
	var value= new Array(6);
	// Date  As String is in Date Format dd/mm/yyyy hh:mm
	var _fDAS="dd/MM/yyyy hh:mm";
	
	alert("_dateAsString"+_dateAsString)
	for(var i=0;i<fT.length;i++)
	{
		var beg=_fDAS.indexOf(fT[i]);
		if(beg!=-1)
		{
			var len=fT[i].length;
			
			
			value[i]=parseInt(trimNum(_dateAsString.substr(beg,len)));
			alert("valuei"+value[i])
		}
	}
	var beg=_date.indexOf(":",_date.indexOf(":")+1)+1;
	
	value[5]=parseInt(trimNum(_date.substr(beg,fT[5].length)));
	alert("value[5]="+value[5])
	return new Date(value[2],value[1]-1,value[0],value[3],value[4],value[5]);	
}

function trimNum(n)
{
	while(n.substr(0,1)=='0')	n=n.substr(1);
	return n;
}


function InitializeTimer(date)
{

    // Set the length of the timer, in seconds
    secs = 60;
    StopTheClock();
    StartTheTimer(date);
}

function StopTheClock()
{	
    if(timerRunning)
        clearTimeout(timerID);
    timerRunning = false
}

function StartTheTimer(date)
{
	
	if (secs==0)
	{
		StopTheClock();
		var newYear=dateAsString.substring(dateAsString.lastIndexOf('-')+1,dateAsString.lastIndexOf(' '));
		currentDate.setSeconds(currentDate.getSeconds()+60);
		var newMin=currentDate.getMinutes();
		if(currentDate.getMinutes()>=0 && currentDate.getMinutes()<=9)
			newMin="0"+newMin;
		var newMonth=currentDate.getMonth()+1;
		var newDay=currentDate.getDate();
		var newHour=currentDate.getHours(); 
		if(currentDate.getHours()>=0 && currentDate.getHours()<=9)
			newHour="0"+newHour;
		var newWeekDayCode=currentDate.getDay();
		var newWeekDay=getNextDay(newWeekDayCode);
		var newMonthFormat=getNextMonth(newMonth-1)
	
	if(newDay<=9)
			newDay="0"+newDay;	
	
	if(newMonth<=9)
			newMonth="0"+newMonth;
	
		var newDate=newDay+"-"+newMonth+"-"+newYear+" "+newHour+":"+newMin;
		
		var newDateFormat=newWeekDay+","+newDay+"-"+newMonthFormat+"-"+newYear+" "+newHour+":"+newMin;
		
		var tdDate=document.getElementById(divId);
        
		
		tdDate.innerHTML="<b>"+newDateFormat+"</b>"
      	document.getElementsByName(date)[0].value=newDate;
      	
      	InitializeTimer(date);

    }
    else
    {
        self.status = secs;
        secs = secs - 1;
      	timerRunning = true;
        timerID = self.setTimeout("StartTheTimer('" + date + "')", delay);
    
    }
}
	

	
	function getNextMonth(monthId)
	{
	var monthArray=["Jan","Feb","Mar","Apr","May","Jun","Jul","Aug","Sep","Oct","Nov","Dec"];	
	return monthArray[monthId];
	}
	
	function getNextDay(dayId)
	{
	var daysArray=["Sunday","Monday","Tuesday","Wednesday","Thursday","Friday","Saturday"];	
	return daysArray[dayId];
	}
	
	


	