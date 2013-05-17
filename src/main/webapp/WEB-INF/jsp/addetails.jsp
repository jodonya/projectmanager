<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
    <head>
    <c:choose>
	<c:when test="${not empty company}">

		<title><c:out value="${company.name}" />- Jobs - tujulishe.com
		</title>

	</c:when>
	<c:when test="${not empty advertCategory}">

		<title><c:out value="${advertCategory.name}" />- Jobs -
			tujulishe.com</title>

	</c:when>
	<c:otherwise>
		<title>Tujulishe - Jobs Advertisements in Kenya - Checkout who
			is hiring</title>
	</c:otherwise>
</c:choose>

<link rel="shortcut icon" href="/favicon.ico" type="image/x-icon">
<link rel="icon" href="/favicon.ico" type="image/x-icon">
<!--link
	href="${pageContext.request.contextPath}/resources/css/bootstrap.css"
	media="all" rel="stylesheet" type="text/css" / -->
<!--link
	href="${pageContext.request.contextPath}/resources/css/projectmanager.css"
	media="all" rel="stylesheet" type="text/css" / -->
        <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/main.css">
        <script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/functions.js">
        </script>
    </head>
    <body>
        <div class="row-top-segment">
        </div>
        <div class="row-top">
            <!-- logo -->
            <div class="logo">
            </div>
            <!-- <span class="font-header-8">Select Town</span> --><!-- buttons -->
            <div class="navirow">
                <div class="header-navirow">
                    <ul class="sf-menu">
                        <li class=" home">
                            <a href="/home">HOME</a>
                        </li>
                        <li class="photoshop">
                            <a href="/aboutus">ABOUT US</a>
                        </li>
                        <li class=" icons">
                            <a href="/contactus">CONTACT US</a>
                        </li>
                        <li class="active design ">
                            <a href="/main">Sign Up</a>
                        </li>
                    </ul>
                </div>
                <!-- search -->
                <div class="second-layer">
                    <form class="input-append pull-right" method="GET" action="/search/">
                        <input type="text" class="select2-search" autocomplete="off" tabindex="-1">
                    </form><span class="login-cred"><a href="">Welcome Japheth</a></span>
                    <span class="logout"><a href="">Logout</a></span>
                </div>
            </div>
        </div>
        <div class="advert-holder">
            <span class="advert">Who is hiring? </span>
            <span class="advert2"> Tujulishe Platform </span>
            <div class="advertexpired"><span style="float: right;"><a href="/home">All Active Jobs</a> | <a href="/homeexpired">Expired Jobs (Old)</a> </span><br/> <span style="float: right;">  Sort By <a href="/homebyexpiry">Expiry</a> | <a href="/homebydateposted">Posted</a></span></div>
        </div>
        <div class="middle-body">
            <div class="right-panel">
            	
            	<div class="side_div">
                    <div class="side_header_design">
                    	<span class="groupedheader"> Unexpired Jobs Added</span>
                      
                    </div>
                    <article class="spacing-3">
                    
                    	
						<div class="sidelink">
                           <span><a href="/todayads">Today (10)</a></span>
                        </div>
                        <div class="sidelink">
                           <span><a href="/yesterdayads">Yesterday (5)</a></span>
                        </div>
                        
                        <div class="sidelink">
                           <span><a href="/lastweekads">Less than a week ago (5)</a></span>
                        </div>
                        
                        <div class="sidelink">
                           <span><a href="/last2weekads">Less than 2 weeks ago (5)</a></span>
                        </div>
                        
                         <div class="sidelink">
                           <span><a href="/lastmonth">Less than a month (5)</a></span>
                        </div>
                        
                         <div class="sidelink">
                           <span><a href="/home">All Active (100)</a> </span>
                        </div>
						
                    </article>
                </div>
            
                <div class="side_div">
                    <div class="side_header_design">
                    	<span class="groupedheader">Job Categories</span>
                    </div>
                    <article class="spacing-3">
                    
                    	<c:if test="${not empty listCategory}">
						<c:forEach items="${listCategory}" var="category">
						<div class="sidelink">
                            <a href="/home/category/${category.id}"><c:out
									value="${category.name}" /></a>
                        </div>
						</c:forEach>
						</c:if>
                    </article>
                </div>
                
                <div class="side_div">
                    <div class="side_header_design">
                      <span class="groupedheader">Companies</span>
                    </div>
                    <article class="spacing-3">
 						
 						<c:if test="${not empty listCompany}">
					<c:forEach items="${listCompany}" var="company">
						<div class="sidelink">
                           <a href="/home/company/${company.id}"><c:out
									value="${company.name}" /></a>
                        </div>
					</c:forEach>
					</c:if>
                    </article>
                </div>
                
				
                <div class="plain-side-outerborder">
                    <span class="font-header-2">Live Feeds</span>
                    <div class="main-contents-details">
                        <div class="img-float">
                            <img src="${pageContext.request.contextPath}/resources/images/advert.png" width="80px"/>
                        </div>
                        <p class="story_4">
                            Advertise at tujulishe and let you company be known by
                            a large crowd
                        </p>
                    </div>
                </div>
                <div class="plain-side-outerborder">
                    <span class="font-header-2">Live Feeds</span>
                    <div class="main-contents-details">
                        <div class="img-float">
                            <img src="${pageContext.request.contextPath}/resources/images/advert.png" width="80px"/>
                        </div>
                        <p class="story_4">
                            Advertise at tujulishe and let you company be known by
                            a large crowd
                        </p>
                    </div>
                </div>
            </div>
            <div class="middle-panel-jobs">
                <!-- jobs & vacancies -->
                <!-- Loop starts here  -->
						<!-- Start of Middle Column -->
	<br />
			<div class="span10">
				<br />
				<!-- h1>welcome to Tujulishe</h1> <br/>
    		<span>Connect, communicate, keep in touch.</span -->

				<div class="nobodders">
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
					<table>
						<tr>
							<td>
								<!-- img
								src="${pageContext.request.contextPath}/resources/images/thumbnailtujulishelogo.png"></img -->

								<c:choose>
									<c:when test="${empty advert.company.companyPhoto}">

										<img
											src="${pageContext.request.contextPath}/resources/images/thumbnailtujulishelogo.png"></img>

									</c:when>
									<c:otherwise>
										<img
											src="${pageContext.request.contextPath}/companyphotothumbnail/${advert.company.companyPhoto.id}" />
									</c:otherwise>
								</c:choose>
							</td>
						</tr>
						<tr>

							<td><span class="adText"><c:out
										value="${advert.name}" /></span><br /> <span> <!-- a href="">Business</a>| <a href="">Account</a>| <a href="">ICT</a -->
							</span> <br /> <span> from : <a href="${advert.sourceWebsite}"><c:out
											value="${advert.sourceName}" /></a> adverts
							</span></td>
						</tr>

						<tr>
							<td><a href="/home/company/${advert.company.id}"><c:out
										value="${advert.company.name}" /></a></td>
						</tr>
						<tr>
							<td><span style="color: red;">Deadline is :</span> <fmt:formatDate
									value="${advert.deadLine}" type="both" pattern="dd MMMM yyyy" /></td>
						</tr>

						<tr>
							<td>
								<h3>Requirements</h3>

								<div>

									<c:if test="${not empty listRequirement}">
										<table class="table table-striped">


											<c:forEach items="${listRequirement}" var="requirement">

												<tr>
													<td><span><c:out value="${requirement.name}" />
													</span><br /> <span> <!-- a href="">Business</a>| <a href="">Account</a>| <a href="">ICT</a -->
													</span> <br /></td>
												</tr>
											</c:forEach>
										</table>
									</c:if>
									<c:if test="${empty listRequirement}">
							There are no Requirements. 
				  </c:if>
								</div>


							</td>
						</tr>

						<tr>
							<td>
								<h3>Job Responsibilities</h3>

								<div>

									<c:if test="${not empty listResponsibility}">
										<table class="table table-striped">


											<c:forEach items="${listResponsibility}" var="responsibility">

												<tr>
													<td><span><c:out value="${responsibility.name}" />
													</span><br /> <span> <!-- a href="">Business</a>| <a href="">Account</a>| <a href="">ICT</a -->
													</span> <br /></td>
												</tr>
											</c:forEach>
										</table>
									</c:if>
									<c:if test="${empty listResponsibility}">
							There are no Responsibilities. 
				  </c:if>
								</div>


							</td>
						</tr>
						<tr>
							<td>
								<h3>Contacts</h3>
								<table>
									<tr>
										<td>You can contact <c:out value="${advert.company.name}" />
											using :
										</td>
									</tr>
								</table>
							</td>
						</tr>
						<tr>
							<td>email: <c:out value="${advert.company.email}" /></td>
						</tr>
						<tr>
							<td>website: <c:out value="${advert.company.webaddress}" /></td>
						</tr>
					</table>
				</div>

				<div>
					<h3>Have your say...</h3>
					<!-- Start Comments -->

					<c:if test="${not empty advert.listAdvertComments}">
						<c:forEach items="${advert.listAdvertComments}"
							var="advertComment">
							<br />
							<span> <span style="float: left;"> <c:choose>
										<c:when test="${empty advertComment.createdBy.profilePhotoId}">

											<img
												src="${pageContext.request.contextPath}/resources/images/thumbnaildefaultphoto.jpg"></img>

										</c:when>
										<c:otherwise>
											<img
												src="${pageContext.request.contextPath}/photothumbnail/${advertComment.createdBy.profilePhotoId}" />
										</c:otherwise>
									</c:choose> <!--  img src="${pageContext.request.contextPath}/resources/images/thumbnaildefaultphoto.jpg"></img -->

							</span> <span> <span><b><c:out
												value="${advertComment.createdBy}" /></b></span> <span>on <fmt:formatDate
											value="${advertComment.created}" type="both"
											pattern="dd MMMM yyyy" /></span> <span> at <fmt:formatDate
											value="${advertComment.created}" type="both"
											pattern=" h:mm:ss a" /></span> <!-- span>at <c:out value="${postComment.created}" /></span -->
									<br /> <span><c:out value="${advertComment.name}" /></span>
							</span>

							</span>
							<br />
						</c:forEach>

					</c:if>
					<c:if test="${empty advert.listAdvertComments}">
										There are no comments yet. 
							  </c:if>



					<br /> <span> <span>Comment</span> <span> <form:form
								class="form-horizontal" action="/advertcomments/${advert.id}"
								modelAttribute="advertComment">
								<!--  form class="form-horizontal"-->
								<fieldset>
									<div class="control-group">
										<label class="control-label" for="name"></label>
										<div class="controls">
											<form:textarea path="name" class="input-xlarge"
												id="description" rows="2" />
										</div>
									</div>
									<div class="form-actions">
										<button type="submit" class="btn btn-success">comment</button>
									</div>

								</fieldset>
							</form:form>
					</span>
					</span> <br />

					<!-- End Comments -->
				</div>
			</div>
			
			<!-- Start of Detailed Import -->
			
			<!-- End of Detailed Import -->
		<!-- End of Middle Column -->
                <!-- End of loop here -->

            </div>
        </div>
    </body>
</html>