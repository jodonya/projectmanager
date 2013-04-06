<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<html>
<head>
	<title>Project Management - ASAL</title>
	<link href="resources/css/bootstrap.css" media="all" rel="stylesheet" type="text/css"/>
	<link href="resources/css/projectmanager.css" media="all" rel="stylesheet" type="text/css"/>
</head>
<body>

 <div class="container">
  
  	<div class="row"><br/>
  			<div class="span12"> <br/>
  			<div>
  				<div class="row">
  					<div class="span8"><h1>julisha</h1></div>
  					<div class="span4"> <a href="/projectmanager/login">Sign In</a> </div>
  				</div>
  				
  					
  				</div>
  			</div>
  			<div class="span2"> <br/>
  				<!-- Login Form place holder -->
  				
  				
  			</div>
  	</div>
    
   
    <div class="row"><br/>
    	<div class="span8"> <br/>
    		<h1>welcome to julisha</h1> <br/>
    		<span>Connect, communicate, keep in touch.</span>
    	</div>
    	
    	<div class="span4"> <br/>
    	
    	<form:form accept-charset="UTF-8" action="main" autocomplete="off" class="home-signup" modelAttribute="projectUser">
    	<div style="margin:0;padding:0;display:inline"><input name="authenticity_token" type="hidden" value="oIUnZW17rd+yyLcJHLyM6f+xx4VB+Xa9M5IonS42KKA=" /></div> 
    	  <dl class="form">
            <dd>
            	<form:input path="firstName"  type="text" name="firstName" class="textfield" placeholder="Provide First Name"  />
            </dd>
          </dl>
          
           <dl class="form">
            <dd>
            	<form:input path="lastName"  type="text" name="lastName" class="textfield" placeholder="Provide Last Name"/>
            </dd>
          </dl>

          <dl class="form">
            <dd>
              <form:input path="email"  type="text" name="email" class="textfield" placeholder="Your email" />
            </dd>
          </dl>

          <dl class="form">
            <dd>
              <form:input path="password" type="password" name="password" class="textfield" placeholder="Provide Password" />
              <p class="note">Tip: use at least one number and at least 7 characters.</p>
            </dd>
          </dl>

         

          <button class="btn btn-success" type="submit">Sign up for free</button>
</form:form>
    	
    	</div>
    
    </div>
 	   
 </div>
</body>
</html>