<!DOCTYPE html>
<html>
<head>
	<title>Response Page</title>
	
	<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
</head>

<body>

	<h2> Online Transaction Result </h2>
	<table border="1" cellpadding="2" cellspacing="2" >
		<tr>
			<th>
				Txn Status
			</th>
			<td>
				${onlineTransction[0]}
			</td>
		</tr>

		<tr>
			<th>
				Txn Message
			</th>
			<td>
				${onlineTransction[1]}
			</td>
		</tr>

		<tr>
			<th>
				Txn Error Message
			</th>
			<td>
				${onlineTransction[2]}
			</td>
		</tr>

		<tr>
			<th>
				Clnt Txn Ref
			</th>
			<td>
				${onlineTransction[3]}
			</td>
		</tr>


		<tr>
			<th>
				TPSL Bank Cd
			</th>
			<td>
				${onlineTransction[4]}
			</td>
		</tr>

		<tr>
			<th>
				TPSL Txn Id
			</th>
			<td>
				${onlineTransction[5] }
			</td>
		</tr>

		<tr>
			<th>
				Txn Amt
			</th>
			<td>
				${onlineTransction[6]}
			</td>
		</tr>

		<tr>
			<th>
				Clnt Request Meta
			</th>
			<td>
				${onlineTransction[7]}
			</td>
		</tr>

		<tr>
			<th>
				TPSL Txn Time
			</th>
			<td>
				${onlineTransction[8]}
			</td>
		</tr>

		<tr>
			<th>
				Balance Amt
			</th>
			<td>
				${onlineTransction[9] }
			</td>
		</tr>

		<tr>
			<th>
				Card Id
			</th>
			<td>
				${onlineTransction[10] }
			</td>
		</tr>

		<tr>
			<th>
				Alias Name
			</th>
			<td>
				${onlineTransction[11] }
			</td>
		</tr>

		<tr>
			<th>
				Bank Transaction Id
			</th>
			<td>
				${onlineTransction[12] }
			</td>
		</tr>

		<tr>
			<th>
				Mandate Reg No
			</th>
			<td>
				${onlineTransction[13] }
			</td>
		</tr>

		<tr>
			<th>
				Token
			</th>
			<td>
				${onlineTransction[14]}
			</td>
		</tr>

		<tr>
			<th>
				Hash
			</th>
			<td>
				${onlineTransction[15]}
			</td>
		</tr>

	</table>
	<br><br>
		${configData}
	<br><br>
	
	
	<c:if test="${not empty dualVerification}">
		<h2>Dual Verification Result</h2>
		<table border="1" cellpadding="2" cellspacing="2" >
			<tr>
				<th>
					Merchant Code
				</th>
				<td>
					${dualVerification.merchantCode} 
				</td>	
			</tr>

			<tr>
				<th>
					Merchant Txn Identifier
				</th>
				<td>
					${dualVerification.merchantTransactionIdentifier}
				</td>
			</tr>

			<tr>
				<th>
					Merchant Txn Request Type
				</th>
				<td>
					${dualVerification.merchantTransactionRequestType}
				</td>
			</tr>
		
			<tr>
				<th>
					 Response
				</th>
				<td>
					${dualVerification.responseType} 
				</td>
			</tr>

			<tr>
				<th>
					 Payment DateTime
				</th>
				<td>
					${dualVerification.paymentMethod.paymentTransaction.dateTime }
				</td>
			</tr>

			<tr>
				<th>
					 Amount
				</th>
				<td>
					${dualVerification.paymentMethod.paymentTransaction.amount}
				</td>
			</tr>

			<tr>
				<th>
					 Payment Transaction Identifier
				</th>
				<td>
					${dualVerification.paymentMethod.paymentTransaction.identifier}
				</td>
			</tr>

			<tr>
				<th>
					 Status Code
				</th>
				<td>
					${dualVerification.paymentMethod.paymentTransaction.statusCode}
				</td>
			</tr>

			<tr>
				<th>
					 Status Message
				</th>
				<td>
					${dualVerification.paymentMethod.paymentTransaction.statusMessage}
				</td>
			</tr>

			<tr>
				<th>
					Error
				</th>
				<td>
					${dualVerification.paymentMethod.error.desc}
				</td>
			</tr>

		</table>
		<br><br>
		${dualVerification}
	</c:if>
	<br><br>

<li><a href="${pageContext.request.contextPath}/">Go Home</a></li>

</body>
</html>
