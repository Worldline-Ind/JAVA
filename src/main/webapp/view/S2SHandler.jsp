<!DOCTYPE html>
<html>

<head>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
	<title>S2S Handler Page</title>
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
  <h1>S2S Handler</h1>
  
	<c:if test="${not empty response}">
		<h3>${response}</h3>
	</c:if>


</body>

</html>