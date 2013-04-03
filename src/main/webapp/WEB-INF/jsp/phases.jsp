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
    
    <!--  link href="http://netdna.bootstrapcdn.com/twitter-bootstrap/2.2.2/css/bootstrap-combined.min.css" rel="stylesheet" -->
    <link rel="stylesheet" type="text/css" media="screen"
     href="http://tarruda.github.com/bootstrap-datetimepicker/assets/css/bootstrap-datetimepicker.min.css">	
     
     <script type="text/javascript" src="/projectmanager/resources/js/jquery-1.9.0.js"></script>
	<script type="text/javascript" src="/projectmanager/resources/js/projectmanager.js"></script>	     
</head>
<body>

 <div class="container">
 		<div class="row"><br/>
 			<div class="span12">
 				<div class="row">
 						<div class="span8"><h1 class="page-header"><c:out value="${project.name}"></c:out></h1></div>
 						<div class="span4"><span>Welcome <c:out value="${logedInUser.firstName}"></c:out>  <c:out value="${logedInUser.lastName}"></c:out></span> | <a href="/projectmanager/logout.html">Logout</a> | <a href="/projectmanager/index.html">Home</a></div>
 				</div>
 			</div>
 		</div>
  
		  <div class="row"> <br/>
		  		<div class="span4"> <br/>
		  			<div>
		  			<h1 class="page-header">Phases List</h1>
		  				<c:if test="${not empty phaseList}" >
		<table class="table table-striped">  
        <thead>  
          <tr>  
            <th>Name</th>  
            <th>Duration</th>
             <th>Status</th>
            <th></th>
         </tr>  
         </thead>
         <tbody>  
         	<c:forEach items="${phaseList}" var="projectPhase">	
         		<tr>  
            		<td class="projectPhase"><c:out value="${projectPhase.name}" /></td>  
            		<td><c:out value="${projectPhase.phaseDuration}" /> </td>  
            		<td><c:out value="${projectPhase.status.name}" /> </td>
            		<td><a href="projects/${project.id}/phases/${projectPhase.id}">Delete</a></td>  
          		</tr>  
          	</c:forEach>
	 	</tbody>  
      	</table>  
      </c:if>
      <c:if test="${empty phaseList}" >
				There are no Phases yet. 
	  </c:if>
	  
	  <div>
		  			
	<form:form class="form-horizontal" action="projectPhase.html/${project.id}" modelAttribute="projectPhase">	
    	<!--  form class="form-horizontal"-->  
        <fieldset>  
          <legend>Phase</legend>
          <form:input path="project.id"  type="hidden" class="input-xlarge input-xlarge-projectmanagement" id="projectid" name="projectid"/> 
          <div class="control-group">  
            <label class="control-label" for="name">Name</label>  
            <div class="controls">  
              <form:input path="name"  type="text" class="input-xlarge input-xlarge-projectmanagement" id="name" name="name"/>    
            </div>  
          </div>
          <div class="control-group">  
            <label class="control-label" for="description">Description</label>  
            <div class="controls">  
              <form:textarea path="description"   class="input-xlarge input-xlarge-projectmanagement" id="description" rows="3"/>  
            </div>  
          </div>
          
          <div class="control-group">  
            <label class="control-label" for="name">Duration</label>  
            <div class="controls">  
              <form:input path="phaseDuration"  type="text" class="input-xlarge input-xlarge-projectmanagement" id="phaseDuration" name="phaseDuration"/>    
            </div>  
          </div>
          
           <div class="control-group">  
            <label class="control-label" for="status">Status</label>  
            <div class="controls">  
              <!--  select id="projectStatus">  
                <option>Started</option>  
                <option>Not Started</option>  
                <option>In Progress</option>  
                <option>Complete</option>  
              </select -->
              <form:select path="status.id">
            		<form:option value="" label="--Please Select"/>
            		<form:options items="${projectStatusList}" itemValue="id" itemLabel="name"/>
        		</form:select>  
            </div>  
          </div> 
        
          <div class="form-actions">  
            <button type="submit" class="btn btn-primary">Add</button>  
          </div>  
        </fieldset>  
		</form:form>
		  			</div>
		  			</div>
		  			
		  			
		  		</div>
		  		<div class="span4"> <br/>
		  		<div>
		  				<h1 class="page-header">Milestones List</h1>
		  				
		  					<c:if test="${not empty milestoneList}" >
		<table class="table table-striped">  
        <thead>  
          <tr>  
            <th>Name</th>
            <th>Deadline</th> 
            <th></th>
         </tr>  
         </thead>
         <tbody>  
         	<c:forEach items="${milestoneList}" var="milestone">	
         		<tr>  
             		<td><a href="milestones/${milestone.id}"><c:out value="${milestone.name}" /> </a></td>  
            		<td><c:out value="${milestone.deadLine}" /> </td>  
            		<td><a href="milestones/${milestone.id}">Delete</a></td>  
          		</tr>  
          	</c:forEach>
	 	</tbody>  
      	</table>  
      </c:if>
      <c:if test="${empty milestoneList}" >
				There are no Milestones yet. 
	  </c:if>
		  				</div>
		  				
		  				<div>
<form:form class="form-horizontal" action="milestone.html/${project.id}" modelAttribute="projectMilestone">	
    	<!--  form class="form-horizontal"-->  
        <fieldset>  
          <legend>Milestone</legend> 
          <div class="control-group">  
            <label class="control-label" for="name">Name</label>  
            <div class="controls">  
              <form:input path="name"  type="text" class="input-xlarge input-xlarge-projectmanagement" id="name" name="name"/>    
            </div>  
          </div>
          
           <div class="control-group">  
            <label class="control-label" for="deadLine">Dead Line</label>  
            <div class="controls input-append date" id="deadLine" >  
              <form:input path="deadLine" class="input-xlarge input-xlarge-projectmanagement" id="deadLine" />
              	<span class="add-on">
        			<i data-time-icon="icon-time" data-date-icon="icon-calendar"></i>
     			 </span>  
            </div>  
          </div>
          
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
      $('#deadLine').datetimepicker({
        format: 'dd/MM/yyyy',
        language: 'en'
      });
      
    </script>
        
          <div class="form-actions">  
            <button type="submit" class="btn btn-primary">Add</button>  
          </div>  
        </fieldset>  
		</form:form>		  				
		  				</div>
		  		</div>
		  		<div class="span4"> <br/>
		  		<div>
		  				<h1 class="page-header">Tasks List</h1>
		  				
		  				<c:if test="${not empty taskList}" >
		<table class="table table-striped">  
        <thead>  
          <tr>  
            <th>Name</th>
            <th>Status</th> 
            <th></th>
         </tr>  
         </thead>
         <tbody>  
         	<c:forEach items="${taskList}" var="task">	
         		<tr>  
             		<td><a href="tasks/${task.id}"><c:out value="${task.name}" /> </a></td>  
            		<td><c:out value="${task.status.name}" /> </td>  
            		<td><a href="tasks/${task.id}">Delete</a></td>  
          		</tr>  
          	</c:forEach>
	 	</tbody>  
      	</table>  
      </c:if>
      <c:if test="${empty taskList}" >
				There are no Tasks yet. 
	  </c:if>
		  				</div>
		  				
		  			<div>
		  				<form:form class="form-horizontal" action="task.html/${project.id}" modelAttribute="task">	
    	<!--  form class="form-horizontal"-->  
        <fieldset>  
          <legend>Task</legend> 
          <div class="control-group">  
            <label class="control-label" for="name">Name</label>  
            <div class="controls">  
              <form:input path="name"  type="text" class="input-xlarge input-xlarge-projectmanagement" id="name" name="name"/>    
            </div>  
          </div>
          <div class="control-group">  
            <label class="control-label" for="description">Description</label>  
            <div class="controls">  
              <form:textarea path="description"   class="input-xlarge input-xlarge-projectmanagement" id="description" rows="3"/>  
            </div>  
          </div>
          
           <div class="control-group">  
            <label class="control-label" for="status">Status</label>  
            <div class="controls">  
              <!--  select id="projectStatus">  
                <option>Started</option>  
                <option>Not Started</option>  
                <option>In Progress</option>  
                <option>Complete</option>  
              </select -->
              <form:select path="status.id">
            		<form:option value="" label="--Please Select"/>
            		<form:options items="${projectStatusList}" itemValue="id" itemLabel="name"/>
        		</form:select>  
            </div>  
          </div> 
        
          <div class="form-actions">  
            <button type="submit" class="btn btn-primary">Add</button>    
          </div>  
        </fieldset>  
		</form:form>
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