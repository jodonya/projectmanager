<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<html>
<head>
<title>Tujulishe</title>
<link href="${pageContext.request.contextPath}/resources/css/bootstrap.css" media="all"
	rel="stylesheet" type="text/css" />
<link
	href="${pageContext.request.contextPath}/resources/datepicker/css/bootstrap-responsive.css"
	media="all" rel="stylesheet" type="text/css" />
<link href="${pageContext.request.contextPath}/resources/datepicker/css/datepicker.css"
	media="all" rel="stylesheet" type="text/css" />
<link href="${pageContext.request.contextPath}/resources/css/projectmanager.css"
	media="all" rel="stylesheet" type="text/css" />

<!--  link href="http://netdna.bootstrapcdn.com/twitter-bootstrap/2.2.2/css/bootstrap-combined.min.css" rel="stylesheet" -->
<!-- link rel="stylesheet" type="text/css" media="screen"
	href="http://tarruda.github.com/bootstrap-datetimepicker/assets/css/bootstrap-datetimepicker.min.css" -->

<script type="text/javascript"
	src="${pageContext.request.contextPath}/resources/js/jquery-1.9.0.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/resources/js/bootstrap-modal.js"></script>
		<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/jquery.atmosphere.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/resources/js/projectmanager.js"></script>
</head>
<body>
	<script  type="text/javascript"></script>
	<script  type="text/javascript">
	
	var contextPath = "http://localhost:8080/";
		
		/***
		
		"'${request.getContextPath()}';
	***/
	
	console.log(' ######### The Context Path is : ', contextPath);
	console.log(' ######### The Context Path is : ', contextPath);
	</script>

	<div class="container">
		<div class="row">
			<br />
			<div class="span12">
				<div class="row">
					<div class="span8">
						<h1 class="page-header">Tujulishe Forum</h1>
						<span id="julishamarquee"><marquee>inform!</marquee></span>
						<br/>
						<span class="notification-count"><span>1</span></span>
					</div>
					<div class="span4">
						<span>Welcome <c:out value="${logedInUser.firstName}"></c:out>
							<c:out value="${logedInUser.lastName}"></c:out></span> | <a
							href="${pageContext.request.contextPath}/logout.html">Logout</a> | <a
							href="${pageContext.request.contextPath}/posts">Home</a> <br/>   <a href="${pageContext.request.contextPath}/photos">My Photos</a> | <span> <c:out value="${totalUsers}"></c:out> members <span class="blink">online</span></span> <br /> <br /> <a
							data-toggle="modal" data-target="#myModal" class="mainPost" href="">Add Post</a>
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
			         		     <span class="projectwho"><!-- img src="${pageContext.request.contextPath}/resources/images/defaultphoto.jpg"></img -->
			         		    	<span style="float: left;">
			         		    	
			         		    	 <c:choose>
								    <c:when test="${empty forumPost.createdBy.profilePhotoId}">
								    
								    	<img src="${pageContext.request.contextPath}/resources/images/thumbnaildefaultphoto.jpg"></img>
								        
								    </c:when>
								    <c:otherwise>
								      <img src="${pageContext.request.contextPath}/photothumbnail/${forumPost.createdBy.profilePhotoId}" />
								    </c:otherwise>
								</c:choose>
			         		    	<!--  img src="${pageContext.request.contextPath}/resources/images/thumbnaildefaultphoto.jpg"></img  -->
			         		    	<!--  img src="${pageContext.request.contextPath}/photothumbnail/1081344" /  -->
			         		    	</span>
			         		     <span>
			         		     		<b>${forumPost.createdBy}</b>
			         		     		 on <fmt:formatDate value="${forumPost.created}" type="both" pattern="dd MMMM yyyy" />
			         		     	at <fmt:formatDate value="${forumPost.created}" type="both" pattern=" h:mm:ss a" />
			         		     	<br/>
			         		     	<span><c:out value="${forumPost.name}" /></span>
			         		     </span>
			         		     <span> </span>
			         		     </span>
			         		     
			         		     <br/>
			         		     <br/>
			            		<span class="projectnormal"></span><br/>
			            		<br/>
			            		<br/>
			            		
			            		<c:if test="${not empty forumPost.listComments}" >
			            		<c:forEach items="${forumPost.listComments}" var="postComment">
			            		<br/>
			            		<span>
			            		
			            			<span style="float:left;">
			            			 <c:choose>
								    <c:when test="${empty postComment.createdBy.profilePhotoId}">
								    
								    	<img src="${pageContext.request.contextPath}/resources/images/thumbnaildefaultphoto.jpg"></img>
								        
								    </c:when>
								    <c:otherwise>
								      <img src="${pageContext.request.contextPath}/photothumbnail/${postComment.createdBy.profilePhotoId}" />
								    </c:otherwise>
									</c:choose>
			            			<!--  img src="${pageContext.request.contextPath}/resources/images/thumbnaildefaultphoto.jpg"></img -->
			            			
			            			</span>
			            			
			            			<span>
			            			<span><b><c:out value="${postComment.createdBy}" /></b></span>
			            			<span>on <fmt:formatDate value="${postComment.created}" type="both" pattern="dd MMMM yyyy" /></span>
			            			<span> at <fmt:formatDate value="${postComment.created}" type="both" pattern=" h:mm:ss a" /></span>
			            			<!-- span>at <c:out value="${postComment.created}" /></span -->
			            			<br/>
			            			<span><c:out value="${postComment.name}" /></span> 
			            			</span>
			    
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
				<div>
					<c:if test="${totalUsers == 0}">
						<span>There is no one online ... </span>
					</c:if>
					<c:if test="${totalUsers > 0}">
						<h3>Users Online</h3>
					</c:if>
					
					<c:forEach items="${usersonline}" var="user">
							
							<c:choose>
						    <c:when test="${user.equals(myself)}">
						       <!-- Do nothing, it is me, you can't show me to me that I am online -->
						    </c:when>
						    <c:otherwise>
						       <!-- Display this guy so that I can know he is online   -->
						       
						       <!-- Start Show this guy -->
						       	<br/>
			            		<span>
			            		<span>
									<c:choose>
								    <c:when test="${empty user.profilePhotoId}">
								    
								    	<img src="${pageContext.request.contextPath}/resources/images/thumbnaildefaultphoto.jpg"></img>
								        
								    </c:when>
								    <c:otherwise>
								      <img src="${pageContext.request.contextPath}/photothumbnail/${user.profilePhotoId}" />
								    </c:otherwise>
									</c:choose>			            	
									
									</span>
					            	<span><c:out value="${user}" /> </span><span  class="chatonline">chat</span>
			            	 
			            	 </span>
			            	  <br/>
							  <hr/>
			            	 
						       <!-- End Show this guy -->
						    </c:otherwise>
							</c:choose>
			         </c:forEach>
					<!--  span><span><img src="${pageContext.request.contextPath}/resources/images/thumbnaildefaultphoto.jpg"></img></span><span>Jack Baur </span> <span  class="chatonline">chat</span></span>
					<br/>
					<hr/>
					<span><span><img src="${pageContext.request.contextPath}/resources/images/thumbnaildefaultphoto.jpg"></img></span><span>Noah Khaemba</span> <span class="chatonline">chat</span></span>
					<br/>
					<hr/ -->
					
				</div>
				<br/>
				
				
				<!-- Start Chat -->
				<div id="chatcontainer">
					<div id="chatheader"><span id="chatheaderusername"><h4>Atmosphere Chat.</h4></span><span id="chatclose"><img src="${pageContext.request.contextPath}/resources/images/close.jpg"></img></span></div>
					<div id="chatcontent"></div>
					<div id="chatbox">
					    <span id="chatstatus">Connecting...</span>
					    <input type="text" id="chatinput" disabled="disabled"/>
					</div>
				</div>
				<!-- End Chat -->

			</div>
		</div>

	</div>
	<!-- Le javascript -->
	<!--  script src="http://code.jquery.com/jquery-1.7.min.js"></script>
	<script src="${pageContext.request.contextPath}/resources/datepicker/js/bootstrap-datepicker.js"></script>
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
	</script -->	
</body>
</html>