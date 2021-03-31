<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<%-- <link rel="stylesheet" href="${pageContext.request.contextPath}/css/bootstrap.min.css"/> --%>
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.5.1/jquery.min.js" type="text/javascript">
</script>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
    <div class="container">
        <div class="row">
            <div class="col-md-12">
                <h2>Transaction Verification :</h2>
                <form method="POST" id="myform" action="transactionVerification">
                 <table class="table" border = "1" cellpadding="2" cellspacing="0" style="width: 50%;">
                   <!--  <table class="table table-bordered table-hover"> -->
                        <tr class="info">
                            <th >Field Name</th>
                            <th >Value</th>
                        </tr>
                        <tr>
                            <td><label>Type of Transaction (eMandate/SI on Cards) <span style="color:red;">*</span></label></td>
                            <td>
                                <select class="form-control" name="type" >
                                    <option value="002" selected="selected">eMandate</option>
                                    <option value="001" >SI on Cards</option>
                                </select>
                            </td>
                        </tr>        
                        <tr>
                            <td><label>Merchant Transaction ID (From Transaction Scheduling)<span style="color:red;">*</span></label></td>
                            <td><input class="form-control" type="text" name="merchantTransactionID" value=""/></td>
                        </tr>
                        <tr>
                            <td><label>Date <span style="color:red;">*</span></label></td>
                            <td><input class="form-control" type="date" name="transactionDate" value=""/></td>
                        </tr>
                    </table>
                    <input class="btn btn-info" type="submit" name="submit" value="Submit" />
                </form>
                <br>
        <c:if test="${not empty response}">        
       <table class="table" border = "1" cellpadding="2" cellspacing="0" style="width: 50%;text-align: center;">
        <thead>
          <tr class="info">
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
            <td>Tpsl Transaction ID</td>
            <td>${response.paymentMethod.paymentTransaction.identifier}</td>
          </tr>
          <tr>
            <td>Message</td>
            <td>${response.paymentMethod.error.desc}</td>
          </tr>
          <tr>
            <td>Status</td>
            <td>${response.paymentMethod.paymentTransaction.statusMessage}</td>
          </tr>
          <tr>
            <td>Date</td>
            <td>${response.paymentMethod.paymentTransaction.dateTime}</td>
          </tr>
        </tbody>
      </table>
       </c:if>      
               
         </div>
        </div>
    </div>
 
</body>
</html>