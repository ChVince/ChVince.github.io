<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>


<html>
<head>
    <meta charset="UTF-8">
    <title><spring:message code="moderatorTitle"/></title>

</head>
<body>
<div class="moderator">

    <spring:message code="welcome"/>

    <p><a href="dropFile"><spring:message code="upload"/></a></p>


    <p><a href="table/viewFilesAsModerator?login=${moderator.login}"><spring:message code="view"/></a></p>

   <p><a href="j_spring_security_logout"><spring:message code="moderator.logout"/></a></p>



</div>
</body>
</html>