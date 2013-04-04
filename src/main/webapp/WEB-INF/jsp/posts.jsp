<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<html>
<head>
<title>Project Management - ASAL</title>
<link href="/projectmanager/resources/css/bootstrap.css" media="all"
	rel="stylesheet" type="text/css" />
<link
	href="/projectmanager/resources/datepicker/css/bootstrap-responsive.css"
	media="all" rel="stylesheet" type="text/css" />
<link href="/projectmanager/resources/datepicker/css/datepicker.css"
	media="all" rel="stylesheet" type="text/css" />
<link href="/projectmanager/resources/css/projectmanager.css"
	media="all" rel="stylesheet" type="text/css" />

<!--  link href="http://netdna.bootstrapcdn.com/twitter-bootstrap/2.2.2/css/bootstrap-combined.min.css" rel="stylesheet" -->
<link rel="stylesheet" type="text/css" media="screen"
	href="http://tarruda.github.com/bootstrap-datetimepicker/assets/css/bootstrap-datetimepicker.min.css">

<script type="text/javascript"
	src="/projectmanager/resources/js/jquery-1.9.0.js"></script>
<script type="text/javascript"
	src="/projectmanager/resources/js/projectmanager.js"></script>
<script type="text/javascript"
	src="/projectmanager/resources/js/bootstrap-modal.js"></script>

</head>
<body>

	<div class="container">
		<div class="row">
			<br />
			<div class="span12">
				<div class="row">
					<div class="span8">
						<h1 class="page-header">forum</h1>
					</div>
					<div class="span4">
						<span>Welcome <c:out value="${logedInUser.firstName}"></c:out>
							<c:out value="${logedInUser.lastName}"></c:out></span> | <a
							href="/projectmanager/logout.html">Logout</a> | <a
							href="/projectmanager/index.html">Home</a> <br /> <br /> <a
							data-toggle="modal" data-target="#myModal" href="">Add Post</a>
					</div>
				</div>
			</div>
		</div>

		<div class="row">
			<br />
			<div class="span3">
				<br />



			</div>
			<div class="span6">
				<br />

				<div id="myModal" class="modal hide fade in">
					<div class="modal-header">
						<a class="close" data-dismiss="modal">×</a>
						<h3>What is New?</h3>
					</div>
					<div class="modal-body">
						<!--  Start -->
						<form:form class="form-horizontal"
							action="posts" modelAttribute="forumPost">
							<!--  form class="form-horizontal"-->
							<fieldset>
								<div class="control-group">
									<label class="control-label" for="name"></label>
									<div class="controls">
										<form:textarea path="name"
											class="input-xlarge input-xlarge-post"
											id="description" rows="3" />
									</div>
								</div>
								<div class="modal-footer">
									<button type="submit" class="btn btn-success">Post</button>
								</div>

							</fieldset>
						</form:form>
						<!--  -->
					</div>
				</div>

				<c:if test="${not empty forumPostList}" >
						<ul class="unstyled">
							<c:forEach items="${forumPostList}" var="forumPost">	
			         		<li>  
			         		     <span class="projectwho"><b>${forumPost.createdBy}</b></span>
			         		     <br/>
			         		     <br/>
			            		<span class="projectnormal"><c:out value="${forumPost.name}" /></span><br/>
			            		<br/>
			            		<br/>
			            		
			            		<c:if test="${not empty forumPost.listComments}" >
			            		<c:forEach items="${forumPost.listComments}" var="postComment">
			            		<br/>
			            		<span>
			            			<span><b><c:out value="${postComment.createdBy}" /></b></span>
			            			<br/>
			            			<span><c:out value="${postComment.name}" /></span>
			    
			            		</span>
			            		<br/>
			            		
			            		</c:forEach>
						
								</c:if>
								<c:if test="${empty forumPost.listComments}" >
										There are no comments yet. 
							  </c:if>
			            		
			            		
			            		
			            		<br/>
			            		<span>
			            				<span>Comment</span>
			            				<span>
			            					<form:form class="form-horizontal"
							action="posts/${forumPost.id}" modelAttribute="postComment">
							<!--  form class="form-horizontal"-->
							<fieldset>
								<div class="control-group">
									<label class="control-label" for="name"></label>
									<div class="controls">
										<form:textarea path="name"
											class="input-xlarge"
											id="description" rows="2" />
									</div>
								</div>
								<div class="form-actions">
									<button type="submit" class="btn btn-success">comment</button>
								</div>

							</fieldset>
						</form:form>
			            				</span>
			            		</span>
			            		<br/>
			          		</li>
			          		 
			          	</c:forEach>
						</ul>
					</c:if>
					<c:if test="${empty forumPostList}" >
							There are no Posts yet. 
				  </c:if>
				

			</div>
			<div class="span3">
				<br />


			</div>
		</div>

	</div>
	<!-- Le javascript -->
	<script src="http://code.jquery.com/jquery-1.7.min.js"></script>
	<script src="resources/datepicker/js/bootstrap-datepicker.js"></script>
	<script>
		/* Update datepicker plugin so that MM/DD/YYYY format is used. */
		$.extend($.fn.datepicker.defaults, {
			parse : function(string) {
				var matches;
				if ((matches = string
						.match(/^(\d{2,2})\/(\d{2,2})\/(\d{4,4})$/))) {
					return new Date(matches[3], matches[1] - 1, matches[2]);
				} else {
					return null;
				}
			},
			format : function(date) {
				var month = (date.getMonth() + 1).toString(), dom = date
						.getDate().toString();
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