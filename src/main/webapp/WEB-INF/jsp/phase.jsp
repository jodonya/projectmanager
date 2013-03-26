<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<html>
<head>
	<title>Project Management - ASAL</title>
	<link href="/projectmanager/resources/css/bootstrap.css" media="all" rel="stylesheet" type="text/css"/>
	<link href="/projectmanager/resources/datepicker/css/bootstrap-responsive.css" media="all" rel="stylesheet" type="text/css"/>
	<link href="/projectmanager/resources/datepicker/css/datepicker.css" media="all" rel="stylesheet" type="text/css"/>
	<link href="/projectmanager/resources/css/projectmanager.css" media="all" rel="stylesheet" type="text/css"/>
	
    
    <link href="http://netdna.bootstrapcdn.com/twitter-bootstrap/2.2.2/css/bootstrap-combined.min.css" rel="stylesheet">
    <link rel="stylesheet" type="text/css" media="screen"
     href="http://tarruda.github.com/bootstrap-datetimepicker/assets/css/bootstrap-datetimepicker.min.css">	
     
</head>
<body>

 <div class="container">
 		<div class="row"><br/>
 			<div class="span12">
 				<div class="row">
 						<div class="span8"><h1 class="page-header">Project Management - ASAL</h1></div>
 						<div class="span4"><span>Welcome <c:out value="${logedInUser.firstName}"></c:out>  <c:out value="${logedInUser.lastName}"></c:out></span> | <a href="/projectmanager/logout.html">Logout</a> | <a href="/projectmanager/index.html">Home</a></div>
 				</div>
 			</div>
 		</div>
  
		<div class="row"><br/>
			<div class="span6"><br/>
			<div>
	
  
  	<form:form class="form-horizontal" action="/projectmanager/project.html" modelAttribute="project"> 
     <!--  form class="form-horizontal-->  
        <fieldset>  
          <legend>Add Project</legend> 
          <div class="control-group">  
            <label class="control-label" for="code">Code</label>  
            <div class="controls">  
              <form:input path="code" type="text" class="input-xlarge" id="code" value="${project.code}"/>    
            </div>  
          </div>
          <div class="control-group">  
            <label class="control-label" for="name">Name</label>  
            <div class="controls">  
              <form:input path="name" type="text" class="input-xlarge" id="name" value="${project.name}"/>
            </div>  
          </div>  
          <div class="control-group">  
            <label class="control-label" for="description">Description</label>  
            <div class="controls">  
              <form:textarea path="description" class="input-xlarge" id="description" rows="3" value="${project.description}"/>  
            </div>  
          </div>
          
            <div class="control-group">  
            <label class="control-label" for="startDate">Start Date</label>  
            <div class="controls input-append date" id="startDate" >  
              <form:input path="startDate" class="input-xlarge" id="startDate" />
              	<span class="add-on">
        			<i data-time-icon="icon-time" data-date-icon="icon-calendar"></i>
     			 </span>  
            </div>  
          </div>
          
          <div class="control-group">  
            <label class="control-label" for="name">Number Of Days</label>  
            <div class="controls">  
              <form:input path="NoOfDays" type="text" class="input-xlarge" id="NoOfDays"/>
            </div>  
          </div>  
          
           <div class="control-group">  
            <label class="control-label" for="startDate">End Date</label>  
            <div class="controls input-append date" id="endDate" >  
              <form:input path="endDate" class="input-xlarge" id="endDate" />
              	<span class="add-on">
        			<i data-time-icon="icon-time" data-date-icon="icon-calendar"></i>
     			 </span>  
            </div>  
          </div>
          
          <form:input path="id" type="hidden" class="input-xlarge" id="id" />   
          
          
          
         
    <script type="text/javascript"
     src="http://cdnjs.cloudflare.com/ajax/libs/jquery/1.8.3/jquery.min.js">
    </script> 
    <script type="text/javascript"
     src="http://netdna.bootstrapcdn.com/twitter-bootstrap/2.2.2/js/bootstrap.min.js">
    </script>
    <script type="text/javascript"
     src="http://tarruda.github.com/bootstrap-datetimepicker/assets/js/bootstrap-datetimepicker.min.js">
    </script>
    <script type="text/javascript"
     src="http://tarruda.github.com/bootstrap-datetimepicker/assets/js/bootstrap-datetimepicker.pt-BR.js">
    </script>
    <script type="text/javascript">
      $('#startDate').datetimepicker({
        format: 'dd/MM/yyyy',
        language: 'en'
      });
      
      $('#endDate').datetimepicker({
         /** format: 'dd/MM/yyyy hh:mm:ss',
          language: 'en' ***/
          
    	  format: 'dd/MM/yyyy',
          language: 'en'
        });
    </script>
          
          <div class="control-group">  
            <label class="control-label" for="projectManager">Project Manager</label>  
            <div class="controls">  
            <form:select path="projectManager.id">
            		<form:option value="" label="--Please Select"/>
            		<form:options items="${projectUserList}" itemValue="id" itemLabel="firstName"/>
        		</form:select>
        		
              <!--  select id="projectManager">  
                <option>Select Manager</option>  
                <option>Japheth Odonya</option>  
                <option>Abdillahi Hussei</option>  
                <option>Felix Wasike</option>  
                <option>Noah Khaemba</option>  
              </select --> 
            </div>  
          </div>  
          
           <div class="control-group">  
            <label class="control-label" for="projectType">Project Type</label>  
            <div class="controls">  
              <!--  select id="projectType">  
                <option>Select Project Type</option>  
                <option>Software Development</option>  
                <option>Heavy Machinery</option>  
                <option>Networking</option>  
                <option>Hardware Maintenance</option>  
              </select -->  
              <form:select path="projectType.id">
            		<form:option value="" label="--Please Select"/>
            		<form:options items="${projectTypeList}" itemValue="id" itemLabel="name"/>
        		</form:select>
            </div>  
          </div>
          
          <div class="control-group">  
            <label class="control-label" for="projectSponsor">Sponsor</label>  
            <div class="controls">  
              <!--  select id="projectSponsor">  
                <option>Select Sponsor</option>  
                <option>Japheth Odonya</option>  
                <option>Abdillahi Hussei</option>  
                <option>Felix Wasike</option>  
                <option>Noah Khaemba</option>  
              </select --> 
              <form:select path="projectSponsor.id">
            		<form:option value="" label="--Please Select"/>
            		<form:options items="${projectUserList}" itemValue="id" itemLabel="firstName"/>
        		</form:select> 
            </div>  
          </div>  
          
          <div class="control-group">  
            <label class="control-label" for="projectStatus">Project Status</label>  
            <div class="controls">  
              <!--  select id="projectStatus">  
                <option>Started</option>  
                <option>Not Started</option>  
                <option>In Progress</option>  
                <option>Complete</option>  
              </select -->
              <form:select path="projectStatus.id">
            		<form:option value="" label="--Please Select"/>
            		<form:options items="${projectStatusList}" itemValue="id" itemLabel="name"/>
        		</form:select>  
            </div>  
          </div>  
          
          <div class="control-group">  
            <label class="control-label" for="location">Location</label>  
            <div class="controls">  
              <!--  select id="projectStatus">  
                <option>Started</option>  
                <option>Not Started</option>  
                <option>In Progress</option>  
                <option>Complete</option>  
              </select -->
              <form:select path="location.id">
            		<form:option value="" label="--Please Select"/>
            		<form:options items="${locationList}" itemValue="id" itemLabel="name"/>
        		</form:select>  
            </div>  
          </div>  
          
          <div class="control-group">  
            <label class="control-label" for="summaryBudget">Summary Budget</label>  
            <div class="controls">  
              <form:input path="summaryBudget" type="text" class="input-xlarge" id="summaryBudget"/>
            </div>  
          </div>  
          <div class="form-actions">  
            <button type="submit" class="btn btn-primary">Save changes</button>  
            <button class="btn">Cancel</button>  
          </div>  
        </fieldset>  
		</form:form>  
		<br/>
		<!-- a href="/projectmanager/addgreeting.html">Add greeting</a>|
		<a href="/projectmanager/greetings.html">Show all greetings</a>| -->
		<a href="/projectmanager/index.html">Home</a> 
			</div>
			</div> <!--  End Column 1-->
			<div class="span6"><br/>
				<div>
					<legend>Project Listing</legend> <br/>
					
					
					<c:if test="${not empty projectList}" >
						<ul class="unstyled">
							<c:forEach items="${projectList}" var="project">	
			         		<li>  
			         			
			            		<span class="projectnormal projecthead"><a href="projectsphases/${project.id}"><c:out value="${project.name}" /></a></span><br/>  
			            		<span class="projectnormal"><c:out value="${project.code}" /> </span> <br/>
			            		<span class="projectnormal"><c:out value="${project.location.name}" /> </span><br/>
			            		<span class="projectnormal"><c:out value="${project.projectStatus.name}" /> </span>
			            		 
			            		 <span class="projectdelete"><a href="projectsphases/${project.id}">Add Phases</a> | <a href="/projectmanager/projectedit/${project.id}">Edit</a> | <a href="projectmainpage/${project.id}">Delete</a></span>  
			            		<hr/>
			            		<span class="projectdelete"><a href="projectsshowphases/${project.id}">Show Phases for <c:out value="${project.name}" /> </a></span> <br/>
			            		<hr/>
			            		 
			          		</li>  
			          	</c:forEach>
						</ul>
					</c:if>
					<c:if test="${empty projectList}" >
							There are no projects yet. 
				  </c:if>
						  
			    </div> 
			</div>
		
		</div>  

    </div>
   <!-- Le javascript -->
    <script src="http://code.jquery.com/jquery-1.7.min.js"></script>
    <script src="resources/datepicker/js/bootstrap-datepicker.js"></script>
    <script>
      /* Update datepicker plugin so that MM/DD/YYYY format is used. */
      $.extend($.fn.datepicker.defaults, {
        parse: function (string) {
          var matches;
          if ((matches = string.match(/^(\d{2,2})\/(\d{2,2})\/(\d{4,4})$/))) {
            return new Date(matches[3], matches[1] - 1, matches[2]);
          } else {
            return null;
          }
        },
        format: function (date) {
          var
            month = (date.getMonth() + 1).toString(),
            dom = date.getDate().toString();
          if (month.length === 1) {
            month = "0" + month;
          }
          if (dom.length === 1) {
            dom = "0" + dom;
          }
          return month + "/" + dom + "/" + date.getFullYear();
        }
      });  
    </script>
</body>
</html>