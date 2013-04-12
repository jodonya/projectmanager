<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
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
						<h1 class="page-header">julisha forum</h1>
						<span id="julishamarquee"><marquee>inform!</marquee></span>
						<br/>
						<span class="notification-count"><span>1</span></span>
					</div>
					<div class="span4">
						<span>Welcome <c:out value="${logedInUser.firstName}"></c:out>
							<c:out value="${logedInUser.lastName}"></c:out></span> | <a
							href="/projectmanager/logout.html">Logout</a> | <a
							href="${pageContext.request.contextPath}/posts">Home</a> <br /> <br />
					</div>
				</div>
			</div>
		</div>

		<div class="row">
			<br />
			<div class="span8">
				<br />

				<div>
				
				<h2>Photo Manager</h2>

				<form:form method="post" action="addPhoto" commandName="photo" enctype="multipart/form-data">
				  <table>
				  	<tr><td colspan="2" style="color: red;"><form:errors path="*" cssStyle="color : red;"/>
				         ${errors}
         			</td></tr>
				    <tr>
				      <td><form:label path="content">Photo</form:label></td>
				      <td><input type="file" name="file" id="file"></input></td>
				    </tr>
				    <tr>
				      <td colspan="2">
				        <input type="submit" value="Upload"/>
				      </td>
				    </tr>
				  </table>
				</form:form>
				<br>
				<br>
				<h3>All the Photos</h3>
				<c:if test="${!empty photoList}">
				  <table>
				    <tr>
				      <!-- th>Name | </th>
				      <  th>Content Type | </th>
				      <th>Size | </th -->
				      <!-- <th>Pic | </th> -->
				      <th>&nbsp;</th>
				    </tr>
				    <c:forEach items="${photoList}" var="photo">
				        <tr>
				        <td></td>
				        <!--  td>${photo.contentType}</td>
				        <td>${photo.length} bytes</td -->
				        <td><img src="${pageContext.request.contextPath}/photo/${photo.id}" /> </td>
				        <td></td>
				        <td></td>
				      </tr>
				      <tr><td></td><td>
				      <c:choose>
					    <c:when test="${empty photo.newname}">
					    
					    	${photo.name}
					        
					    </c:when>
					    <c:otherwise>
					       ${photo.newname}
					    </c:otherwise>
					</c:choose>
				     </td><td></td></tr>
				      <tr><td></td><td><a href="deletePhoto/${photo.id}">Delete Photo</a></td></tr>
				      <tr><td></td><td><a data-toggle="modal" data-target="#photoEdit${photo.id}" href="">Edit Photo</a></td></tr>
				      <tr><td>&nbsp;</td><td>&nbsp;</td></tr>
				      <tr><td>&nbsp;</td><td>&nbsp;</td></tr>
				      <tr><td>&nbsp;</td><td>&nbsp;</td></tr>
				      <tr><td>&nbsp;</td><td>&nbsp;</td></tr>
				      <tr><td>&nbsp;</td><td><div id="photoEdit${photo.id}" class="modal hide fade in">
					<div class="modal-header">
						<a class="close" data-dismiss="modal">×</a>
						<h3>Edit Photo</h3>
					</div>
					<div class="modal-body">
						<!--  Start -->
						<form:form class="form-horizontal"
							action="photoEdit/${photo.id}" modelAttribute="photo">
							<span>
							<img src="${pageContext.request.contextPath}/photo/${photo.id}" />
							</span>
							
							<br/>
							<br/>
							<br/>
							<!--  form class="form-horizontal"-->
							<fieldset>
								<div class="control-group">
									<label class="control-label" for="name">Name</label>
									<div class="controls">
										<form:input path="newname" 
											class="input-xlarge input-xlarge-post"
											id="description" rows="3" />
									</div>
								</div>
								
								
							    <div class="control-group">
							        <label class="checkbox">
							            <form:checkbox path="isProfilePhoto" id="inlineCheckbox1"/> Profile Photo
							        </label>
							        <label class="checkbox">
							            <form:checkbox path="isDefault" id="inlineCheckbox2"/> Default Photo
							        </label>
							    </div>

								<div class="modal-footer">
									<button type="submit" class="btn btn-success">Save</button>
								</div>

							</fieldset>
						</form:form>
						<!--  -->
					</div>
				</div></td></tr>
				    </c:forEach>
				  </table>
				</c:if>
				</div>
				
				

			</div>
			
			<div class="span4">
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