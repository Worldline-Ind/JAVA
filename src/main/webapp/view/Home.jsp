<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<script
	src="https://www.paynimo.com/paynimocheckout/client/lib/jquery.min.js"
	type="text/javascript"></script>
<script
	src='https://www.paynimo.com/Paynimocheckout/server/lib/checkout.js'
	type="text/javascript"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/js/onlinetransactionhandler.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/js/checkout.js"></script>	

<title>Worldline</title>
</head>
<body>

 <c:choose>
  <c:when test="${config_data.enableEmandate && config_data.enableSIDetailsAtMerchantEnd}">
   <script type="text/javascript">
$(document).ready(function(){
 var debitStartDate = new Date();
 document.getElementById('debitStartDate').value = debitStartDate.toISOString().slice(0, 10);
 debitStartDate.setFullYear(debitStartDate.getFullYear() + 30);
 var debitEndDate = debitStartDate.toISOString().slice(0, 10);
 $("#debitEndDate").val(debitEndDate);
 $("#frequency").val("${config_data.frequency}");
 $("#amountType").val("${config_data.amountType}");
 
 function myChangeFunction() {
    var maxAmount= $("#Amount").val()*2;
    console.log(maxAmount);
    $("#maxAmount").val(maxAmount);
  }
  
  $('#Amount').on( 'change', function(){ myChangeFunction(); } );

});	
</script>	
  </c:when>
  <c:when test="${config_data.enableEmandate && !config_data.enableSIDetailsAtMerchantEnd}">
    <style type="text/css">
        .hid{
            display: none;
        }        
    </style>
  </c:when>
  <c:otherwise>
   <style type="text/css">
        .hid{
            display: none;
        }        
    </style>
   
  </c:otherwise>
</c:choose>
  
  <h1>Online Transaction</h1>
	<form id ="form" class = "form">
		<table border="1" cellpadding="2" cellspacing="0">
			<tr>
				<td> <label for="Merchant Code">Merchant Code</label> </td>
				<td> <input type="text" id="MerchantCode" name="MerchantCode" value="${config_data.merchantCode}"><br></td>

			</tr>

			<tr>
				<td> <label for="Transaction ID">Transaction ID</label></td>
				<td><input type="text" id="Transaction ID" name="transactionID" value="${transcationId}"></td>
				
			</tr>

			<tr>
				<td> <label for="Amount">Amount<span style="color:red;">*</span></label></td>
				<td><input type="text" id="Amount"  name="amount" ></td>
			</tr>

			<tr>
				<td> <label for="Scheme">Scheme</label></td>
				<td><input type="text" id="scheme" name="scheme" value="${config_data.merchantSchemeCode}"></td>
				
			</tr>

			<tr>
				<td> <label for="CustomerID">Customer ID<span style="color:red;">*</span></label></td>
				<td><input type="text" id="custID" name="custID"></td>
				
			</tr>

			<tr>
				<td> <label for="Mobile Number">Mobile Number</label> </td>
				<td><input type="text" id="mobNo" name="mobNo"></td>
				
			</tr>

			<tr>
				<td> <label for="Email">Email</label> </td>
				<td><input type="email" id="email" name="email"></td>
				

			<tr>
				<td> <label for="Customer Name">Customer Name</label>  </td>
				<td><input type="text" id="name" name="name"></td>
			</tr>

			<tr>
				<td> <label for="Currency">Currency</label> </td>
				<td><input type="text" id="currency" name="currency" value="${config_data.currency}"></td>
				
			</tr>

			<tr>
				<td> <label for="SALT">SALT</label></td>
				<td><input type="text" id="SALT" name="SALT" value="${config_data.salt}" ></td>
				
			</tr>
			<tr>
				<td> <label for="ReturnUrl">Return Url</label> </td>
				<td><input type="text" id="ReturnUrl" name="ReturnUrl" value="${returnUrl}"></td>
			</tr>
			<tr class="hid">
                            <td><label>Account Number</label></td>
                            <td><input type="number" name="accNo" value=""/></td>
                        </tr>
                        <tr class="hid">
                            <td><label>Account Type</label></td>
                            <td>
                                <select class="form-control" name="accountType" >
                                    <option value="Saving" selected>Saving</option>
                                    <option value="Current" >Current</option>
                                </select>
                            </td>
                        </tr>
                        <tr class="hid">
                            <td><label>Account Name</label></td>
                            <td><input type="text" name="accountName" value=""/></td>
                        </tr>
                        <tr class="hid">
                            <td><label>Aadhar Number</label></td>
                            <td><input type="text" name="aadharNumber" value=""/></td>
                        </tr>
                        <tr class="hid">
                            <td><label>IFSC Code</label></td>
                            <td><input type="text" name="ifscCode" value=""/></td>
                        </tr>
                        <tr class="hid">
                            <td><label>Debit Start Date</label></td>
                            <td><input type="date" id="debitStartDate" name="debitStartDate" value=""/></td>
                        </tr>
                        <tr class="hid">
                            <td><label>Debit End Date</label></td>
                            <td><input type="date" id="debitEndDate"  name="debitEndDate" value=""/></td>
                        </tr>
                        <tr class="hid">
                            <td><label>maxAmount</label></td>
                            <td><input type="number" id="maxAmount" name="maxAmount" value="" readonly/></td>
                        </tr>
                        <tr class="hid">
                            <td><label>Amount Type</label></td>
                            <td>
                                <select class="form-control" name="amountType" id="amountType" >
                                    <option value="M"  >Variable</option>
                                    <option value="F" >Fixed</option>
                                </select>
                            </td>
                        </tr>
                        <tr class="hid">
                            <td><label>Frequency</label></td>
                            <td>
                                <select class="form-control" name="frequency" id="frequency" >
                                    <option value="ADHO" > As and when presented </option>
                                    <option value="DAIL" > Daily </option>
                                    <option value="WEEK" > Weekly </option>
                                    <option value="MNTH" > Monthly </option>
                                    <option value="BIMN" > Bi- monthly </option>
                                    <option value="QURT" > Quarterly </option>
                                    <option value="MIAN" > Semi annually </option>
                                    <option value="YEAR" > Yearly </option>
                                </select>
                            </td>
                        </tr>
			</table>
			<input type="hidden" id="accNo" name="accNo" />	
		    <input type="hidden" id="cardNumber" name="cardNumber" >
			<input type="hidden" id="expMonth" name="expMonth" >
			<input type="hidden" id="expYear" name="expYear" >
			<input type="hidden" id="cvvCode" name="cvvCode" >
			<input type="hidden" id="expYear" name="expYear" >
			<input type="hidden" id="config_data" name="config_data" value="${config_data}">
			
			
		
		  <div><button id="btnSubmit">Submit</button>
			</div>
		 <div id="worldline_embeded_popup"></div>	
			
		</form>
		

</body>
</html>