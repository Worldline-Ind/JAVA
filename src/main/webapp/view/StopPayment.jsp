<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
    <title>Stop Payment</title>
    <meta name="viewport" content="user-scalable=no, width=device-width, initial-scale=1" />
    <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
   <%--  <link rel="stylesheet" href="${pageContext.request.contextPath}/css/bootstrap.min.css"/> --%>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.5.1/jquery.min.js" type="text/javascript"></script>
</head>
<body>
    <div class="container">
        <div class="row">
            <div class="col-md-12">
                <h2>Stop Payment :</h2>
                <form method="POST" id="myform" action="stopPayment">
                    <table class="table" border = "1" cellpadding="2" cellspacing="0" style="width: 50%;">
                        <tr class="info">
                            <th >Field Name</th>
                            <th>Value</th>
                        </tr>
                        <tr>
                            <td><label>TPSL Transaction Id (From Transaction Scheduling) <span style="color:red;">*</span></label></td>
                            <td><input class="form-control" type="text" name="tpslTransactionID" value=""/></td>
                        </tr>
                        
                    </table>
                    <input class="btn btn-info" type="submit" name="submit" value="Submit" />
                </form>
           
    </div>
    <br>
    <c:if test="${not empty response}">
    <table class="table" border = "1" cellpadding="2" cellspacing="0" style="width: 50%;text-align: center;">
        <thead>
          <tr class="info" >
            <th>Field Name</th>
            <th>Value</th>
          </tr>
        </thead>
        <tbody>
          <tr>
            <td>Status Code</td>
            <td>${response.paymentMethod.paymentTransaction.statusCode}</td>
          </tr>
          <tr>
            <td>Merchant Transaction Reference No.</td>
            <td>${response.merchantTransactionIdentifier}</td>
          </tr>
          <tr>
            <td>Message</td>
            <td>${response.paymentMethod.error.desc}</td>
          </tr>
          <tr>
            <td>Status</td>
            <td>${response.paymentMethod.paymentTransaction.statusMessage}</td>
          </tr>
        </tbody>
      </table>
    </c:if>
     </div>
        </div>
</body>
</html>