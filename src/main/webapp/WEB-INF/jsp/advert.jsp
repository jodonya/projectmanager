<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
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
<link
	href="${pageContext.request.contextPath}/resources/css/projectmanager.css"
	media="all" rel="stylesheet" type="text/css" />
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
							<h1>Tujulishe - Ad Listing</h1>
						</div>
						<div class="span4">
							<!--  a href="${pageContext.request.contextPath}/login">Sign In</a -->
							<span>Add Businesses and Adverts !</span>
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
						<form class="form-horizontal">
							<fieldset>
								<legend>Add Advert</legend>
								 <div class="control-group">  
						            <label class="control-label" for="select01">Business</label>  
						            <div class="controls">  
						              <select id="select01">  
						                <option>Select Business/Company</option>  
						                <option>Kakamega</option>  
						                <option>Finlays</option>  
						                <option>Sweeden</option>  
						                <option>Lutheran World Federation</option>  
						              </select>  
						            </div>  
						          </div>
								<div class="control-group">
									<label class="control-label" for="input01">Job/Vacancy</label>
									<div class="controls">
										<input type="text" class="input-xlarge" id="input01">
										<!-- p class="help-block">In addition to freeform text, any HTML5 text-based input appears like so.</p -->
									</div>
								</div>

								<div class="control-group">
									<label class="control-label" for="textarea">Details
										</label>
									<div class="controls">
										<textarea class="input-xlarge" id="textarea" rows="10"></textarea>
									</div>
								</div>

								<div class="control-group">
									<label class="control-label" for="textarea">Summarize
										</label>
									<div class="controls">
										<textarea class="input-xlarge" id="textarea" rows="4"></textarea>
									</div>
								</div>

								<div class="control-group">
									<label class="control-label" for="input01">Deadline</label>
									<div class="controls">
										<input type="text" class="input-xlarge" id="input01">
										<!-- p class="help-block">In addition to freeform text, any HTML5 text-based input appears like so.</p -->
									</div>
								</div>
								
								<div class="control-group">  
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
						          </div>
								

								<div class="form-actions">
									<button type="submit" class="btn btn-primary">Save
										Advert</button>
									<button class="btn">Cancel</button>
								</div>
							</fieldset>
						</form>
					</div>
					
				

					<div class="nobodders">
						<!-- form class="well" -->
						<form>
							<!-- label>Label name</label --> <input type="text" class="span3"
								placeholder="search…"> <!--span class="help-inline">Associated
								help text!</span> < label class="checkbox"> <input
								type="checkbox"> Check me out
							</label>
							< button type="submit" class="btn">Submit</button -->
						</form>
					</div>

					<div>
						<table>
							<tr>
								<td class="adText">Regional Financial Controller Eastern
									Africa <br />

								</td>
								<td>by Swedish Corporative Center</td>
								<td><a href="">Details</a></td>
							</tr>

							<tr>
								<td class="adText">Assistant Research Manager</td>
								<td>by Finlays</td>
								<td><a href="">Details</a></td>
							</tr>

						</table>
					</div>
				</div>
			</div>

			<div class="span6">
				<br />

				<div class="nobodders">
					<div>
						<form class="form-horizontal">
							<fieldset>
								<legend>Register Business</legend>
								<div class="control-group">
									<label class="control-label" for="input01">Name</label>
									<div class="controls">
										<input type="text" class="input-xlarge" id="input01">
										<!-- p class="help-block">In addition to freeform text, any HTML5 text-based input appears like so.</p -->
									</div>
								</div>

								<div class="control-group">
									<label class="control-label" for="textarea">Physical
										Location</label>
									<div class="controls">
										<textarea class="input-xlarge" id="textarea" rows="3"></textarea>
									</div>
								</div>

								<div class="control-group">
									<label class="control-label" for="input01">Contact
										Person</label>
									<div class="controls">
										<input type="text" class="input-xlarge" id="input01">
										<!-- p class="help-block">In addition to freeform text, any HTML5 text-based input appears like so.</p -->
									</div>
								</div>

								<div class="control-group">
									<label class="control-label" for="input01">Phone No.</label>
									<div class="controls">
										<input type="text" class="input-xlarge" id="input01">
										<!-- p class="help-block">In addition to freeform text, any HTML5 text-based input appears like so.</p -->
									</div>
								</div>

								<div class="control-group">
									<label class="control-label" for="input01">Email</label>
									<div class="controls">
										<input type="text" class="input-xlarge" id="input01">
										<!-- p class="help-block">In addition to freeform text, any HTML5 text-based input appears like so.</p -->
									</div>
								</div>
								<div class="form-actions">
									<button type="submit" class="btn btn-primary">Save
										Business</button>
									<button class="btn">Cancel</button>
								</div>
							</fieldset>
						</form>
					</div>
					<div>
						<table>
							<tr>
								<td class="adText">KAKAMEGA TEACHERS AND CREDIT COOPERATIVE SOCIETY LTD</td>
								<td>Kateko Plaza, Muruli Road, Behind Posta or Telcom Kenya
								</td>
								<td>0726340851</td>
							</tr>

							<tr>
								<td class="adText">Finlays</td>
								<td>Kericho</td>
								<td>careers@finlays.co.ke</td>
							</tr>

						</table>
					</div>
				</div>


			</div>

		</div>

	</div>
</body>
</html>