<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Transaction Scheduling</title>
</head>
<body>
	<h2>Transaction Scheduling</h2>
	<form method="post" action="transaction-scheduling">
		<table border="1" cellpadding="2" cellspacing="0">
			<tr>
				<th>Field Name</th>
				<th>Value</th>
			</tr>
			<tr>
				<td><label>Type of Transaction (eMandate/SI on Cards)<span style="color:red;">*</span></label></td>
				<td><select name="transactionType">
						<option value="002">eMandate</option>
						<option value="001">SI on Cards</option>
				</select></td>
			</tr>
			<tr>
				<td><label> Mandate Registration Id <span style="color:red;">*</span></label></td>
				<td><input type="text" name="mandateRegistrationId" value="" /></td>
			</tr>
			<tr>
				<td><label>Amount<span style="color:red;">*</span></label></td>
				<td><input type="text" name="amount" value="" /></td>
			</tr>
			<tr>
				<td><label>Transaction Date<span style="color:red;">*</span></label></td>
				<td><input type="date" name="transactionDate" value="" /></td>
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
				<tr>
					<td><label for="Amount" >Amount</label></td>
					<td>${response.paymentMethod.paymentTransaction.amount}</td>
				</tr>
				<tr>
					<td><label for="Date Time" >Date Time</label></td>
					<td>${response.paymentMethod.paymentTransaction.dateTime}</td>
				</tr>
			</table>
		</c:if>
</body>
</html>