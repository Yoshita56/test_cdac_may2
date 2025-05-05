<%@ page language="java" contentType="text/html;"	pageEncoding="UTF-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<%@ taglib uri="/WEB-INF/dateTag.tld" prefix="dateTag"%>
<%@ taglib uri="/WEB-INF/hisTab.tld" prefix="tag"%>
<%@ taglib uri="/WEB-INF/comboPersistence.tld" prefix="cmbPers"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Supplier Interface Report</title>
<script language="Javascript" src="../js/SupplierInterfaceTrans.js"></script>
<script language="Javascript" src="../../hisglobal/js/commonFunctions.js"></script>
</head>
<body>
<body>
<html:form action="/transactions/SupplierDeskInterfaceTransCNT"   name="supplierDeskTransBean"	type="mms.transactions.controller.fb.SupplierDeskInterfaceTransFB" styleClass="formbg">
    	   
    <bean:write 	name="supplierDeskTransBean" property="strSupplierInterfaceReport" filter="false" />
 
	
	</html:form>
</body>

</html>