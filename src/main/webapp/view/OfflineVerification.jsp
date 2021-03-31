<!DOCTYPE html>
<html>

<head>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
	<title>Offline Verification Page</title>
	<style>
		table, td, th {
		 	border: 1px solid black;
		}

		table {
			border-collapse: collapse;
		}
	</style>
	
</head>

<body>
	
	<h1>Offline Verification</h1>
	<form action="offlineVerification" method="post">
	    <label for="Merchant Ref No">Merchant Ref No:<span style="color:red;">*</span></label>
	    <input type="text" id="merchantRefNo" name="merchantRefNo"  required=true />
	    <label for="Date">Date:<span style="color:red;">*</span></label>
	    <input type="date" id="date" name="date"  required=true />
		<input type="submit" value="Submit">
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
					<td><label for="Amount" >Amount</label></td>
					<td>${response.paymentMethod.paymentTransaction.amount}</td>
				</tr>
				<tr>
					<td><label for="Message" >Message</label></td>
					<td>${response.paymentMethod.paymentTransaction.errorMessage}</td>
				</tr>
				<tr>
					<td><label for="Status Message" >Status Message</label></td>
					<td>${response.paymentMethod.paymentTransaction.statusMessage}</td>
				</tr>
				<tr>
					<td><label for="Date Time" >Date Time</label></td>
					<td>${response.paymentMethod.paymentTransaction.dateTime}</td>
				</tr>
			</table>
		</c:if>

</body>

</html>

