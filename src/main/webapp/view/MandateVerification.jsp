<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Mandate Verification</title>
<script	src="https://www.paynimo.com/paynimocheckout/client/lib/jquery.min.js"
	type="text/javascript"></script>
</head>
<body>
	<h2>Mandate Verification</h2>
	<form action="mandate-verification" method="post">
		<table border="1" cellpadding="2" cellspacing="0">
			<tr>
				<th>Field Name</th>
				<th>Value</th>
			</tr>
			<tr>
				<td><label>Type of Transaction (eMandate/SI on Cards)<span style="color:red;">*</span></label></td>
				<td><select name="type">
						<option value="002" selected="selected">eMandate</option>
						<option value="001">SI on Cards</option>
				</select></td>
			</tr>
			<tr>
				<td><label>Merchant Transaction Id<span style="color:red;">*</span></label></td>
				<td><input type="text" name="merchantTransactionId" value="" /></td>
			</tr>
			<tr>
				<td><label>Consumer Transaction Id (Customer Id used during transaction)<span style="color:red;">*</span></label></td>
				<td><input type="text" name="consumerTransactionId" value="" /></td>
			</tr>
			<tr>
				<td><label>Date<span style="color:red;">*</span></label></td>
				<td><input type="date" name="transactionDate" value="" /></td>
			</tr>
		</table>
		<input type="submit" name="submit" value="Submit" />
	</form>
	<br>
	
	<br><br>
	
	<c:if test="${not empty response}">
			<table border="2" align="middle">
				<tr>
					<td><label for="Status Code">Status Code</label></td>
					<td>${response.paymentMethod.paymentTransaction.statusCode}</td>
				</tr>
				<tr>
					<td><label for="Merchant Transaction Reference No">Merchant Transaction Reference No</label></td>
					<td>${response.merchantTransactionIdentifier}</td>
				</tr>
				<tr>
					<td><label for="TPSL Transaction ID">TPSL Transaction ID</label></td>
					<td>${response.paymentMethod.paymentTransaction.identifier}</td>
				</tr>
				<tr>
					<td><label for="Message" >Message</label></td>
					<td>${response.paymentMethod.paymentTransaction.errorMessage}</td>
				</tr>
			</table>
		</c:if>
</body>
</html>