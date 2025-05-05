<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<script type="text/javascript">
	function view1(obj1, obj2, obj3) {
		document.getElementById(obj1).style.display = "none";
		document.getElementById(obj2).style.display = "block";
		document.getElementById(obj3).style.display = "block";
	}
	function view2(obj1, obj2, obj3) {
		document.getElementById(obj1).style.display = "block";
		document.getElementById(obj2).style.display = "none";
		document.getElementById(obj3).style.display = "none";
	}
</script>

<!-- <table class="TABLEWIDTH" align="center" cellspacing="1px">
	<tr>
		<td class="TITLE">
		<div id="plusAddItemId" align="left"
			style="display: none; color: blue;"><img
			src="../../hisglobal/images/plus.gif"
			onClick="view1('plusAddItemId','minusAddItemId','itemDetailsId');"
			style="cursor: pointer;" /> Drug Specification Details</div>
		<div id="minusAddItemId" style="display: block; color: blue;"
			align="left"><img src="../../hisglobal/images/minus.gif"
			onClick="view2('plusAddItemId','minusAddItemId','itemDetailsId');"
			style="cursor: pointer;" /> Drug Specification Details</div>
		</td>
	</tr>
</table> -->
<div id='itemDetailsId' style="display: block;">



<div id='fileNoId' style="display: none;">
<!-- <table class="TABLEWIDTH" align="center" cellspacing="1px"
	cellpadding="1px">
	<tr>
		<td class="LABEL" width="50%">File No./Page No.</td>
		<td class="CONTROL" width="50%"><input type="text"
			class="form-control" name="strFileNo"
			onkeypress="return validateData(event,9);" maxlength="35">/ <input
			type="text" name="strPageNo"
			onkeypress="return validateData(event,5);" maxlength="5"
			class="form-control"></td>

	</tr>
</table> -->
</div>
<div class="row">
<div class="col-sm-6">
<label>Attach</label>
</div>
<div class="col-sm-4">
<html:file   property="strLocation" />
</div>
</div>
		

	
</div>