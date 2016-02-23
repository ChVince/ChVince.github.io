<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<html>
<title><spring:message code="notification"/></title>
<body>
<p>

</p>
${message}
<p>
    <a href="${path}">${goTo}</a>;
</p>
</body>
<style>
    body{
        text-align: center;
    }
</style>
</html>