<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Mandate De-activation</title>
</head>
<body>
	<h2>Mandate De-activation :</h2>
	<form method="post" action="mandate-deactivation">
		<table border="1" cellpadding="2" cellspacing="0">
			<tr>
				<th>Field Name</th>
				<th>Value</th>
			</tr>
			<!-- <tr>
				<td><label>Type of Transaction (eMandate/SI on Cards)</label></td>
				<td><select name="type">
						<option value="002" selected="selected">eMandate</option>
						<option value="001">SI on Cards</option>
				</select></td>
			</tr> -->
			<tr>
				<td><label>Mandate Registration ID<span style="color:red;">*</span></label></td>
				<td><input type="text" name="mandateRegistrationID" value="" /></td>
			</tr>
		</table>
		<input type="submit" name="submit" value="Submit" />
	</form>
	
	<br><br>

	<c:if test="${not empty response}">
		<table border="2" align="middle">
			<tr>
				<td><label for="Status Code">Status Code</label></td>
				<td>${response.paymentMethod.paymentTransaction.statusCode}</td>
			</tr>
			<tr>
				<td><label for="Merchant Transaction Reference No">Merchant
						Transaction Reference No</label></td>
				<td>${response.merchantTransactionIdentifier}</td>
			</tr>
			<tr>
				<td><label for="Message">Message</label></td>
				<td>${response.paymentMethod.paymentTransaction.errorMessage}</td>
			</tr>
		</table>
	</c:if>

</body>
</html>