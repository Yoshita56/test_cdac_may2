<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>

<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<%@ taglib uri="/WEB-INF/dateTag.tld" prefix="dateTag"%>
<%@ taglib uri="/WEB-INF/hisTab.tld" prefix="tag"%>

<html lang="en">
<head>
    <title>Store Wise Hierarchy</title>
   <!-- Include jQuery -->
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>

<!-- Include DataTables CSS -->
<link rel="stylesheet" type="text/css" href="https://cdn.datatables.net/1.11.6/css/jquery.dataTables.min.css">

<!-- Include DataTables JS -->
<script language="JavaScript" src="../../hisglobal/js/DataTables.js"></script>

</head>
<body>
<html:form action="/reports/StoreHierarchyViewCNT" method="post">
 <div id="dataTableContainer">
     <bean:write name="StoreHierarchyViewBEAN" property="strStoreHie" filter="false" />
 </div>    
</html:form>
 <script>
     $(document).ready(function () {
         $('#dataTable').DataTable();
     });
 </script>
</body>
</html>
