<%@page import="com.Patient"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"
    %>



<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Patients Management</title>
<link rel="stylesheet" href="Views/bootstrap.min.css"> 
<script src="Components/jquery-3.2.1.min.js">
</script> <script src="Components/patients.js"></script> 


</head>

<body>
<div class="container"> <div class="row"> <div class="col-6"> 

 			<h1>Patient Management </h1> 
 
 <form id="formPatient" name="formPatient">  
 
 
  		
 
  		<br> Patient first:
  		<input id="first" name="first" type="text" 	
         class="form-control form-control-sm"> 
 
  		<br> Patient last: 
  		<input id="lname" name="lname" type="text"   
      	 class="form-control form-control-sm"> 
 
 		 <br> Patient email: 
 		 <input id="email" name="email" type="text"   
   	      class="form-control form-control-sm"> 
   	      
   	     <br> Patient age: 
 		 <input id="age" name="age" type="text"   
   	      class="form-control form-control-sm"> 
   	      
   	     <br> Patient mobile: 
 		 <input id="mobile" name="mobile" type="text"   
   	      class="form-control form-control-sm"> 
   	      
   	     <br> Patient password: 
 		 <input id="password" name="password" type="text"   
   	      class="form-control form-control-sm"> 
   	    
   	    
 
  			   <br>   <input id="btnSave" name="btnSave" type="button" value="Save" 
      	       class="btn btn-primary">   <input type="hidden" id="hidPatientIDSave"     
        	   name="hidPatientIDSave" value=""> 
  </form> 
  
  
  
 
 <div id="alertSuccess" class="alert alert-success"></div> 
  <div id="alertError" class="alert alert-danger"></div> 
 
 <br>  <div id="divPatientGrid"> 
   	<%    Patient patientObj = new Patient();   
  	 out.print(patientObj.readPatient());  
  	 %>  
  	</div> 
   </div> 
  </div> 
</div>	

</body>
</html>