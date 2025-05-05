<jsp:useBean id="MenuGeneratorBean" class="menu.MenuGenerator" scope="request" />
<jsp:setProperty name="MenuGeneratorBean" property="*" />
<!-- Copyright ©.Pradeep Kumar-->
<!-- created by Pradeep Kumar using Pramati Studio 3.0 -->
	<%
	  String menuURL = request.getParameter("menuURL");
	  if(menuURL == null)
	  {
		try
		{
			if( Integer.parseInt(request.getParameter("level"))>0 )
				menuURL = null;
				
		}
		catch(Exception e)
		{
			System.out.println("Exception at ParseInt");
			menuURL = request.getParameter("hyper");
		}
	  }
	  System.out.println("Menu URL "+menuURL);
	  %>
<table width="100%" border="0" cellspacing="0" cellpadding="0" height="69">  
  <tr> 
    <td width="8%">&nbsp;</td>
    <td width="82%"> <div align="center"><b><font face="Verdana, Arial, Helvetica, sans-serif" size="4">
		Kasturba Hospital</font></b></div></td>
    <td width="10%">&nbsp;</td>
  </tr>
  <tr> 
    <td width="8%">&nbsp;</td>
    <td width="82%"> <div align="center"><b><font face="Verdana, Arial, Helvetica, sans-serif" size="4">
		Mahatma Gandhi Institute of Medical Sciences</font></b></div></td>
    <td width="10%">&nbsp;</td>
  </tr>
  <tr> 
    <td width="8%">&nbsp;</td>
    <td width="82%"> <div align="center"><b><font face="Verdana, Arial, Helvetica, sans-serif" size="4">
		Sevagram, Wardha</font></b></div></td>
    <td width="10%">&nbsp;</td>
  </tr>
</table>


<input type=hidden name="menuURL" value='<%=menuURL%>' />
<input type=hidden name="seatId" value='<%=request.getParameter("seatId")%>' />
<input type=hidden name="empId" value='<%=request.getParameter("empId")%>' />
<input type=hidden name="roleId" value='<%=request.getParameter("roleId")%>' />



