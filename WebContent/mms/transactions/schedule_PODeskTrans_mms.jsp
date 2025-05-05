<%@ page language="java" contentType="text/html;"	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<%@taglib uri="/WEB-INF/dateTag.tld" prefix="dateTag"%>
<%@ taglib uri="/WEB-INF/hisTab.tld" prefix="tag"%>
<%@ taglib uri="/WEB-INF/comboPersistence.tld" prefix="cmbPers"%>


<html>
<head>
<meta charset=UTF-8">
<title>PO Desk</title>
<link href="../css/master.css" rel="stylesheet" type="text/css">
<link href="../../hisglobal/css/tab.css" rel="stylesheet"
	type="text/css">
<link href="../../hisglobal/css/calendar-tas.css" rel="stylesheet"
	type="text/css">
<link href="../../hisglobal/css/popup.css" rel="stylesheet"
	type="text/css">
<script language="JavaScript" src="../../masterutil/js/master.js"></script>
<script language="JavaScript" src="../../hisglobal/js/tab.js"></script>
<script language="JavaScript" src="../../hisglobal/js/calendar.js"></script>
<script language="Javascript" src="../../hisglobal/js/validation.js"></script>
<script language="Javascript" src="../../hisglobal/js/util.js"></script>
<script language="Javascript" src="../../hisglobal/js/utilityFunctions.js"></script>
<script language="Javascript" src="../../hisglobal/js/popup.js"></script>
<script language="Javascript" src="../../mms/js/PODesk.js"></script>
<script language="Javascript" src="../../mms/js/POScheduleJS.js"></script>

</head>
<body>
<html:form action="/transactions/PODeskScheduleTransCNT">

	<center>
	<div id="errMsg" class="errMsg"><bean:write
		name="PODeskScheduleTransBean" property="strErr" /></div>
	<div id="warningMsg" class="warningMsg"><bean:write
		name="PODeskScheduleTransBean" property="strWarning" /></div>
	<div id="normalMsg" class="normalMsg"><bean:write
		name="PODeskScheduleTransBean" property="strMsg" /></div>

	<center>

     <tag:tab tabLabel="PO Desk" selectedTab="FIRST" onlyTabIndexing="1" align="center" width="TABLEWIDTH">
	     </tag:tab>
    </center>

	<table class="TABLEWIDTH" align="center" cellpadding="1px"
		cellspacing="1px">
		<tr class="HEADER">
			<td colspan="4"></td>
		</tr>
		<tr>
			<td width="25%" class="LABEL">Store Name</td>
			<td width="75%" colspan="3" class="CONTROL"><html:hidden
				name="PODeskScheduleTransBean" property="strStoreId"></html:hidden><bean:write
				name="PODeskScheduleTransBean" property="strStoreName"
				filter="false"></bean:write></td>
		</tr>
		<tr>
			<td width="25%" class="LABEL">PO No.</td>
			<td width="25%" class="CONTROL"><html:hidden
				name="PODeskScheduleTransBean" property="strPONo"></html:hidden><bean:write
				name="PODeskScheduleTransBean" property="strPONo" filter="false"></bean:write></td>
			<td width="25%" class="LABEL">PO Date</td>
			<td width="25%" class="CONTROL"><html:hidden
				name="PODeskScheduleTransBean" property="strPODate"></html:hidden><bean:write
				name="PODeskScheduleTransBean" property="strPODate" filter="false"></bean:write>
			</td>
		</tr>
		<tr>
			<td width="25%" class="LABEL">PO Type</td>
			<td width="25%" class="CONTROL"><html:hidden
				name="PODeskScheduleTransBean" property="strPOTypeId"></html:hidden><bean:write
				name="PODeskScheduleTransBean" property="strPOType" filter="false"></bean:write>
			</td>

			<td width="25%" class="LABEL">Item Category</td>
			<td width="25%" class="CONTROL"><html:hidden
				name="PODeskScheduleTransBean" property="strItemCat"></html:hidden><bean:write
				name="PODeskScheduleTransBean" property="strItemCatName"
				filter="false"></bean:write></td>
		</tr>
		<tr>
			<td width="25%" class="LABEL">Supplier Name</td>
			<td width="75%" colspan="3" class="CONTROL"><html:hidden
				name="PODeskScheduleTransBean" property="strSupplierId"></html:hidden><bean:write
				name="PODeskScheduleTransBean" property="strSupplierName"
				filter="false"></bean:write></td>
		</tr>
		<bean:write name="PODeskScheduleTransBean"
			property="strForeignPODetails" filter="false"></bean:write>
		<tr>
			<td width="25%" class="LABEL">No. of Schedule</td>
			<td width="25%" class="CONTROL"><select name="strDNoOfSchedule">
				<option value=2>2</option>
				<option value=3>3</option>
				<option value=4>4</option>
				<option value=5>5</option>
				<option value=6>6</option>
				<option value=7>7</option>
				<option value=8>8</option>
				<option value=9>9</option>
				<option value=10>10</option>
				<option value=11>11</option>
				<option value=12>12</option>
				<option value=13>13</option>
				<option value=14>14</option>
				<option value=15>15</option>
				<option value=16>16</option>
				<option value=17>17</option>
				<option value=18>18</option>
				<option value=19>19</option>
				<option value=20>20</option>
				<option value=21>21</option>
				<option value=22>22</option>
				<option value=23>23</option>
				<option value=24>24</option>
				<option value=25>25</option>
				<option value=26>26</option>
				<option value=27>27</option>
				<option value=28>28</option>
				<option value=29>29</option>
				<option value=30>30</option>
				<option value=31>31</option>
				<option value=32>32</option>
				<option value=33>33</option>
				<option value=34>34</option>
				<option value=35>35</option>
				<option value=36>36</option>
				<option value=37>37</option>
				<option value=38>38</option>
				<option value=39>39</option>
				<option value=40>40</option>
				<option value=41>41</option>
				<option value=42>42</option>
				<option value=43>43</option>
				<option value=44>44</option>
				<option value=45>45</option>
				<option value=46>46</option>
				<option value=47>47</option>
				<option value=48>48</option>
				<option value=49>49</option>
				<option value=50>50</option>
			</select></td>
			<td width="100%" colspan="2" class="CONTROL">
			<div id="goButton"><img src="../../hisglobal/images/Go.png"
				onclick="showDiv('divSaveCancelId'),hideDiv('goButton'),getPOItemDetails();"
				style="cursor: pointer;"></div>
			</td>
		</tr>
	</table>

	<div id=divPOItemDetails></div>
	<table class="TABLEWIDTH" align="center" cellpadding="1px"
		cellspacing="1px">
		<tr>
			<td width="50%" class="LABEL">
			Remarks</td>
			<td width="50%" class="CONTROL"><textarea name="strDRemarks"></textarea></td>
		</tr>
	</table>
	<table class="TABLEWIDTH" align="center" cellpadding="1px"
		cellspacing="1px">
		<tr class="FOOTER">
			<td colspan="4"><font size="2" color="red">*</font> Mandatory
			Fields</td>
		</tr>
	</table>
	<div id="divSaveCancelId" style="display: none">
	<table border="0" class="TABLEWIDTH" align="center">
		<tr>
			<td align="center"><img
				src="../../hisglobal/images/btn-sv.png"
				style="cursor: pointer; " title="Save Record"
				onClick="return validate1();" /> <img
				src="../../hisglobal/images/btn-ccl.png"
				style="cursor: pointer; " title="Cancel Process"
				onClick="cancelToDesk();"></td>
		</tr>
	</table>
	</div>
	<input type="hidden" name="strCurrentDate" value="${PODeskScheduleTransBean.strCurrentDate }" />
	<input type="hidden" name="strItemIds" />
	<input type="hidden" name="strItemBrandIds" />
	<input type="hidden" name="strStoreIds" />
	<input type="hidden" name="strRequestIds" />
	<input type="hidden" name="strPODeliveryDate" value="${PODeskScheduleTransBean.strPODeliveryDate }"/>
	<input type="hidden" name="hmode" />
	<cmbPers:cmbPers />
</html:form>
<tag:autoIndex></tag:autoIndex>
</body>
</html>