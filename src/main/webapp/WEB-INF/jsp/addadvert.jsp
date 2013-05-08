<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<html>
<head>
<title>Tujulishe</title>
<link rel="shortcut icon" href="/favicon.ico" type="image/x-icon">
<link rel="icon" href="/favicon.ico" type="image/x-icon">



<link
	href="${pageContext.request.contextPath}/resources/css/bootstrap.css"
	media="all" rel="stylesheet" type="text/css" />
	<script type="text/javascript"
	src="${pageContext.request.contextPath}/resources/js/jquery-1.9.0.js"></script>
<link
	href="${pageContext.request.contextPath}/resources/css/projectmanager.css"
	media="all" rel="stylesheet" type="text/css" />
	<script type="text/javascript"
	src="${pageContext.request.contextPath}/resources/js/projectmanager.js"></script>
	
		<link href="${pageContext.request.contextPath}/resources/datepicker/css/bootstrap-responsive.css" media="all" rel="stylesheet" type="text/css"/>
	<link href="${pageContext.request.contextPath}/resources/datepicker/css/datepicker.css" media="all" rel="stylesheet" type="text/css"/>
	
    
    <link href="${pageContext.request.contextPath}/resources/css/bootstrap-combined.min.css" rel="stylesheet">
    <link rel="stylesheet" type="text/css" media="screen"
     href="${pageContext.request.contextPath}/resources/css/bootstrap-datetimepicker.min.css">	
	
</head>
<body>

	<div class="container">

		<div class="row">
			<br />
			<div class="span12">
				<br />
				<div>
					<div class="row">
						<div class="span8">
							<h1>
								<c:out value="${company.name}" />
							</h1>
							
						</div>
						<div class="span4">
							<!--  a href="${pageContext.request.contextPath}/login">Sign In</a -->
							<span>Add Businesses and Adverts !</span>
							<br/>
							<div style="float: right;">
								<a href="/advert">Business Listing</a>
							</div>
						</div>
					</div>


				</div>
			</div>
			<div class="span2">
				<br />
				<!-- Login Form place holder -->


			</div>
		</div>


		<div class="row">
			<br />
			<div class="span6">
				<br />
				<!-- h1>Ad Listing</h1 -->
				<br />
				<!-- span>Registered to Post Ads.</span -->
				<br />
				<div class="nobodders">
					<div>
						<form:form class="form-horizontal" action="/advert/${company.id}" modelAttribute="advert" >
							<fieldset>
								<legend>Add Advert</legend>
								<div class="control-group">
									<label class="control-label" for="input01">Job/Vacancy</label>
									<div class="controls">
										<form:input path="name" type="text" class="input-xlarge" id="name"/>
										<!-- p class="help-block">In addition to freeform text, any HTML5 text-based input appears like so.</p -->
									</div>
								</div>
								
								<div class="control-group">
									<label class="control-label" for="location">Location</label>
									<div class="controls">
										<form:input path="location" type="text" class="input-xlarge" id="location"/>
										<!-- p class="help-block">In addition to freeform text, any HTML5 text-based input appears like so.</p -->
									</div>
								</div>
								
							   <!-- div class="control-group">  
					            <label class="control-label" for="deadLineDate">Deadline</label>  
					            <div class="controls input-append date" id="deadLineDate" >  
					            
					            <select id="day">
											<option>1</option>
											<option>2</option>
											<option>3</option>
											<option>4</option>
											<option>5</option>
										</select>
									<select id="month">
											<option>Jan</option>
											<option>Feb</option>
											<option>March</option>
											<option>April</option>
											<option>May</option>
										</select -->
					              <!-- form:input path="day" class="input-xlarge" id="deadLine" />
					              	<span class="add-on">
					        			<i data-time-icon="icon-time" data-date-icon="icon-calendar"></i>
					     			 </span -->  
					            <!-- /div>  
					          </div-->
								
								<div class="control-group">  
					            <label class="control-label" for="startDate">Deadline</label>  
					            <div class="controls input-append date" id="dateDeadLine" >  
					              <form:input path="tempDeadLine" class="input-xlarge" id="tempDeadLine" />
					              	<span class="add-on">
					        			<i data-time-icon="icon-time" data-date-icon="icon-calendar"></i>
					     			 </span>  
					            </div>  
					          </div>
					          
					              <script type="text/javascript"
							     src="${pageContext.request.contextPath}/resources/js/jquery.min.js">
							    </script> 
							    <script type="text/javascript"
							     src="${pageContext.request.contextPath}/resources/js/bootstrap.min.js">
							    </script>
							    <script type="text/javascript"
							     src="${pageContext.request.contextPath}/resources/js/bootstrap-datetimepicker.min.js">
							    </script>
							    <script type="text/javascript"
							     src="${pageContext.request.contextPath}/resources/js/bootstrap-datetimepicker.pt-BR.js">
							    </script>
							    <script type="text/javascript">
							      $('#dateDeadLine').datetimepicker({
							        format: 'dd/MM/yyyy',
							        language: 'en'
							      });
							      
							  /**    $('#endDate').datetimepicker({**/
							         /** format: 'dd/MM/yyyy hh:mm:ss',
							          language: 'en' ***/
							          
							          /**
							    	  format: 'dd/MM/yyyy hh:mm:ss',
							          language: 'en'
							        });***/
							    </script>

								<div class="control-group">
									<label class="control-label" for="textarea">Details </label>
									<div class="controls">
										<form:textarea path="details" class="input-xlarge" id="details" rows="10"></form:textarea>
									</div>
								</div>

								<div class="control-group">
									<label class="control-label" for="textarea">Summarize </label>
									<div class="controls">
										<form:textarea path="summary" class="input-xlarge" id="textarea" rows="4"></form:textarea>
									</div>
								</div>
																
								
								<div class="control-group">
									<label class="control-label" for="sourceName">Source </label>
									<div class="controls">
										<form:input path="sourceName" type="text" class="input-xlarge" id="sourceName"/>
										<!-- p class="help-block">In addition to freeform text, any HTML5 text-based input appears like so.</p -->
									</div>
								</div>
								
								<div class="control-group">
									<label class="control-label" for="sourceWebsite">Source Website</label>
									<div class="controls">
										<form:input path="sourceWebsite" type="text" class="input-xlarge" id="sourceWebsite"/>
										<!-- p class="help-block">In addition to freeform text, any HTML5 text-based input appears like so.</p -->
									</div>
								</div>
								
								

								<!-- div class="control-group">
									<label class="control-label" for="input01">Deadline</label>
									<div class="controls">
										<input type="text" class="input-xlarge" id="input01">
										<!-- p class="help-block">In addition to freeform text, any HTML5 text-based input appears like so.</p -->
									<!-- /div>
								</div -->

								<!-- div class="control-group">
									<label class="control-label" for="select01">Category</label>
									<div class="controls">
										<select id="select01">
											<option>Add Category</option>
											<option>ICT</option>
											<option>Construction</option>
											<option>Business</option>
											<option>Law</option>
										</select>
									</div>
								</div -->


								<div class="form-actions">
									<form:button type="submit" class="btn btn-primary">Save
										Advert</form:button>
									<form:button class="btn">Cancel</form:button>
								</div>
							</fieldset>
						</form:form>
					</div>




				</div>
			</div>

			<div class="span6">

				<!-- Ads Listing Starts here -->
				<br />
				<div class="nobodders"><a href="#"><span style="float: right;" id="ShowHideAddCategory" class="menubutton">Close</span></a></div>
				<div id="categoryId">
				
				<form:form class="form-horizontal"
					action="/addcategory/${company.id}" modelAttribute="category">
					<fieldset>
						<legend>New Category</legend>
						<div class="control-group">
							<label class="control-label" for="input01">Name</label>
							<div class="controls">
								<form:input path="name" type="text" class="input-xlarge"
									id="categoryName" />
								<!-- p class="help-block">In addition to freeform text, any HTML5 text-based input appears like so.</p -->
							</div>
						</div>

						<div class="control-group">
							<label class="control-label" for="textarea">Details </label>
							<div class="controls">
								<form:textarea path="description" class="input-xlarge"
									id="categoryDescription" rows="10"></form:textarea>
							</div>
						</div>

						<div class="form-actions">
							<button type="submit" class="btn btn-primary">Save</button>
							<button class="btn">Cancel</button>
						</div>
					</fieldset>
				</form:form>
				<br />

				<div>
					<c:if test="${not empty listCategory}">
						<table class="table table-striped">

							<tbody>
								<c:forEach items="${listCategory}" var="category">
									<tr>
										<td><c:out value="${category.name}" /></td>
										<td><c:out value="${category.description}" /></td>
										<td><a href="company/${category.id}">Delete</a></td>
									</tr>
								</c:forEach>
						</table>
					</c:if>
					<c:if test="${empty listCategory}">
							There are no Categories yet. 
				  </c:if>
				</div>
				</div>
				<br />


				<div>
					<!-- form class="well" -->
					<form>
						<!-- label>Label name</label -->
						<input type="text" class="span3" placeholder="search…">
						<!--span class="help-inline">Associated
								help text!</span> < label class="checkbox"> <input
								type="checkbox"> Check me out
							</label>
							< button type="submit" class="btn">Submit</button -->
					</form>
				</div>

				<div>
				
				<c:if test="${not empty listAdvert}">
						<table class="table table-striped">

							<tbody>
								<c:forEach items="${listAdvert}" var="advert">
									<tr>
										<td class="adText"><c:out value="${advert.name}" /></td>
										<td><c:out value="${advert.company}" /></td>
										<td><fmt:formatDate value="${advert.deadLine}" type="both" pattern="dd MMMM yyyy" /><!--  c:out value="${advert.deadLine}" / --></td>
										<td><a href="/newdetails/${advert.id}">Add Details - Roles and Requirements</a></td>
										<td><a href="/advert/${advert.id}">Delete</a></td>
									</tr>
								</c:forEach>
						</table>
					</c:if>
					<c:if test="${empty listAdvert}">
							There are no Adverts yet. 
				  </c:if>
				</div>


			</div>

		</div>

	</div>
</body>
</html>