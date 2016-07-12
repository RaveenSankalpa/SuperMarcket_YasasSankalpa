<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
	<head>
		<!-- Latest compiled and minified CSS -->
		<link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">

		<!-- jQuery library -->
		<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.0/jquery.min.js"></script>

		<!-- Latest compiled JavaScript -->
		<script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
	</head>
	<body>
		<div class="col-md-8">
			<div>
				<form action="GrnSearch" method="post">
					<fieldset>
					<!-- Form Name -->
					<legend>GRN Search</legend>
					<!-- Appended Input-->
					<div class="form-group">
					  <label class="col-md-4 control-label" for="appendedtext">Enter Here Supplier Name/Product Name</label>
					  <div class="col-md-4">
						<div class="input-group">
						  <input type="text" name="searchText" required/><a href="<c:url value='searchGRN.htm'/>"> <button id="searchGrn" name="searchGrn" class="btn btn-success">Search</button></a>
						</div>
					  </div>
					</div>					
					</fieldset>
				</form>
			</div>
			<div>
				<div class="panel panel-default">
				  <!-- Default panel contents -->
			<table  class="table">
				<tr >
					<th>Supplier Name</th>
					<th>Product Name</th>
					<th>Product Quantity</th>
					<th>Unit Price (Buying)</th>
				</tr>
				<c:forEach items="${foundGrn}" var="grn">		  				  
				<tr bgcolor="#E1E1E1">
						<td>${grn.supplierName}</td>
						<td>${grn.productName}</td>
						<td>${grn.quantity}</td>
						<td>${grn.unitPrice}</td>
				</tr>
				</c:forEach>
				<c:if test="${!empty grnList}">
				<c:forEach items="${grnList}" var="grnlist">
					<tr bgcolor="#E1E1E1">
						<td>${grnlist.supplierName}</td>
						<td>${grnlist.productName}</td>
						<td>${grnlist.quantity}</td>
						<td>${grnlist.unitPrice}</td>
						<td><a href="<c:url value='editGrn?id=${grnlist.grnID}'/>"> <button id="editGrn" name="editGrn" class="btn btn-success">Edit</button></a>
							<a href="<c:url value='deleteGrn?id=${grnlist.grnID}'/>"><button id="deleteGrn" name="deleteGrn" class="btn btn-danger">Delete</button></a>
							</td>
					</tr>
				</c:forEach>
				</c:if>
			</table>
			<hr>
			<p>
				<a href="addGrn"><button id="addMore" name="addMore" class="btn btn-success">Add More GRNs</button></a> <input type="button" value="Go Back From Where You Came!" onclick="history.back(-1)" class="btn btn-success"/>
			</p>
				</div>		
			</div>
		</div>
	</body>
</html>