
<%@page import="java.util.*"%>
<%
	session = request.getSession(false);
	String seatID = "0";
	if(session != null)
	{
		seatID = (String)session.getAttribute("SEATID");
	}
	//System.out.println("seatID is in header .jsp ==  "+seatID);
	
	String sessionVal = "0";
	
	if(seatID==null || seatID.equals("0") || seatID.equals(""))
	{
		sessionVal = "0";
	}
	else
	{
		sessionVal = "0";
		String[] sesTemp;
		String sesVal="";
		ServletContext context = session.getServletContext();
		ArrayList loginUserList = (ArrayList) context.getAttribute("LOGIN_USER");
		
		for(int i=0;i<loginUserList.size();i++)
		{
			System.out.println("loginUserList.get("+i+") "+loginUserList.get(i));
			sesVal = (String)loginUserList.get(i);
			sesTemp =sesVal.split("#");			
			if(sesTemp[0].equals(session.getAttribute("USER_ID")))
				sessionVal="1";
		}
	}
%>
<script>
history.forward();
var value = "<%=sessionVal%>";	
if(value== 0)
{
	callLogOut();	
}
function callLogOut()
{	
	//alert("calllogout");	
	document.forms[0].action="../../startup/loginAction?hmode=LOG_OUT";
	document.forms[0].submit();
}
</script>


<form name="logout" target="_parent" >
	<table width="100%">
<!--  		<tr>
			<td nowrap style="cursor:hand">
			<div align="center">
			<img src="../../images/e_sushrut_header.gif" width="716" height="74" vspace="0"></div>
			</td>
			<td valign="bottom" align="right" class='piyush' style="cursor:hand" nowrap>
			<img src="../../images/logout.gif"   onClick="submitPage();">
			</td>	
		</tr>    -->
	</table>
	<input type="hidden" name="hmode">
</form>	


