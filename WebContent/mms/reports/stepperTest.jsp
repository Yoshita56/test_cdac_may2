<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    <%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<%@taglib uri="/WEB-INF/dateTag.tld" prefix="dateTag"%>
<%@ taglib uri="/WEB-INF/hisTab.tld" prefix="tag"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>

<link href="../css/master.css" rel="stylesheet" type="text/css">
<link href="../../hisglobal/css/tab.css" rel="stylesheet" type="text/css">
<link href="../../hisglobal/css/calendar-tas.css" rel="stylesheet" type="text/css">
<link href="../../hisglobal/css/buttons.css" rel="stylesheet" type="text/css">
<link href="../../hisglobal/css/popup.css" rel="stylesheet" type="text/css">	
	
<script language="JavaScript" src="../../masterutil/js/master.js"></script>
<script language="JavaScript" src="../../hisglobal/js/tab.js"></script>
<script language="JavaScript" src="../../hisglobal/js/calendar.js"></script>
<script language="Javascript" src="../../hisglobal/js/validation.js"></script>
<script language="Javascript" src="../../hisglobal/js/util.js"></script>

<!-- <script language="Javascript" src="../../hisglobal/js/commonFunctions.js"></script>
<script language="Javascript" src="../../hisglobal/js/time.js"></script> -->

<!-- JQuery -->
<script src="../../hisglobal/jquery/3.6.0.min.js"></script>

<script src="/INVMGM/hisglobal/js/jquery.autocomplete.min.js"></script> 

<!-- BS Library  -->
<link href="/INVMGM/hisglobal/bootstrap4.0_newgui/css/bootstrap.css" rel="stylesheet" />
<link href="/INVMGM/hisglobal/bootstrap4.0_newgui/css/bootstrap-theme.css" rel="stylesheet" />
<link href="/INVMGM/hisglobal/bootstrap4.0_newgui/datetimepicker/css/gijgo.min.css" rel="stylesheet" type="text/css"> 
<link href="/INVMGM/hisglobal/bootstrap4.0_newgui/font-awesome/css/all.css" rel="stylesheet">
<link rel="stylesheet" type="text/css" href="styles.css">

<!-- JS Library  -->
<script type="text/javascript" src="/INVMGM/hisglobal/bootstrap4.0_newgui/js/bootstrap.min.js"></script>
<script type="text/javascript" src="/INVMGM/hisglobal/bootstrap4.0_newgui/datetimepicker/js/gijgo.min.js"></script>

<style>

.bs-stepper-content .content {
    display: none;
}
.bs-stepper-content .content.active {
    display: block;
}
</style>


</head>
<body>
<p>Hello world</p>

<div class="container mt-5">
    <div id="stepper" class="bs-stepper">
        <div class="bs-stepper-header" role="tablist">
            <div class="step" data-target="#step-1">
                <button type="button" class="step-trigger" role="tab">
                    <span class="bs-stepper-circle">1</span>
                    <span class="bs-stepper-label">Personal Details</span>
                </button>
            </div>
            <div class="line"></div>
            <div class="step" data-target="#step-2">
                <button type="button" class="step-trigger" role="tab">
                    <span class="bs-stepper-circle">2</span>
                    <span class="bs-stepper-label">Contact Info</span>
                </button>
            </div>
            <!-- add new tabs in between -->
             <div class="line"></div>
           <div class="step" data-target="#step-3">
                <button type="button" class="step-trigger" role="tab">
                    <span class="bs-stepper-circle">3</span>
                    <span class="bs-stepper-label">Education</span>
                </button>
            </div>
                       
            <div class="line"></div>
            <div class="step" data-target="#step-4">
                <button type="button" class="step-trigger" role="tab">
                    <span class="bs-stepper-circle">4</span>
                    <span class="bs-stepper-label">Review & Submit</span>
                </button>
            </div>
        </div>

        <div class="bs-stepper-content">
            <form id="myForm">
                <!-- Step 1 -->
                <div id="step-1" class="content">
                    <h4>Step 1: Personal Details</h4>
                    <label>Name:</label>
                    <input type="text" class="form-control">
                    <button class="btn btn-primary mt-3" onclick="stepper.next(); return false;">Next</button>
                </div>

                <!-- Step 2 -->
                <div id="step-2" class="content">
                    <h4>Step 2: Contact Info</h4>
                    <label>Email:</label>
                    <input type="email" class="form-control">
                    <button class="btn btn-secondary mt-3" onclick="stepper.previous(); return false;">Previous</button>
                    <button class="btn btn-primary mt-3" onclick="stepper.next(); return false;">Next</button>
                </div>
                
				 <!-- add new tabs in between after adding the new stepper header above -->
				 <div id="step-3" class="content">
                    <h4>Step 3: Education Details</h4>
                    <label>Graduate Degree/12th/10th score:</label>
                    <input type="text" class="form-control">
                    <button class="btn btn-secondary mt-3" onclick="stepper.previous(); return false;">Previous</button>
                    <button class="btn btn-primary mt-3" onclick="stepper.next(); return false;">Next</button>
                </div>

                <!-- Step 3 -->
                <div id="step-4" class="content">
                    <h4>Step 4: Review & Submit</h4>
                    <p>Check your details and submit the form.</p>
                    <button class="btn btn-secondary mt-3" onclick="stepper.previous(); return false;">Previous</button>
                    <button class="btn btn-success mt-3" type="submit">Submit</button>
                </div>
            </form>
        </div>
    </div>
</div>


<script>
document.addEventListener("DOMContentLoaded", function () {
    window.stepper = new Stepper(document.querySelector("#stepper"),{
      linear:false,
      animation:true
    });


// Ensure the first step is visible
document.querySelector(".bs-stepper-content .content").classList.add("active");


document.querySelectorAll(".step-trigger").forEach(trigger => {
    trigger.addEventListener("click", function () {
        // Hide all step contents
        document.querySelectorAll(".bs-stepper-content .content").forEach(content => {
            content.classList.remove("active");
        });

        // Show the clicked step's content
        let target = this.parentElement.getAttribute("data-target");
        document.querySelector(target).classList.add("active");
        console.log(target+"");
    });
  });

document.getElementById("myForm").addEventListener("submit", function (event) {
   var inputs = document.querySelectorAll("#myForm input");
   var isValid = true;
   var errorMessage = "Please fill out the following fields:\n";

   for (var k = 0; k < inputs.length; k++) {
	   console.log(inputs.value+"");
       if (inputs[k].value.trim() === "") {
           isValid = false;
           errorMessage += "- " + (inputs[k].previousElementSibling.innerText || "Unnamed Field") + "\n";
       }
   }

   if (!isValid) {
       alert(errorMessage);
       event.preventDefault(); // Prevent form submission
   } else {
       alert("Form submitted successfully!"); // Show success alert
   }
}); 


});

</script>

</body>
</html>