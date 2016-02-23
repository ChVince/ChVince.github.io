<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring" %>

<!DOCTYPE html>
<html>
<head>



    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title><spring:message code="homeTitle"/></title>
</head>

<body>
<c:if test="${not empty error}" >
    ${error}
</c:if>
<div id="content">

      <form:form class="enter" method="POST" commandName="moderator" id="Home" name="Home_Form" action="j_spring_security_check">

        <span style="float:right">
            <a href="?lang=en">en</a>
            <a href="?lang=ru">ru</a>
        </span>


        <p>
            <form:label for="login" path="login"><spring:message code="username"/></form:label>
            <form:input id="login" name="login" path="login"/>
        </p>

        <p>
            <form:label for="password" path="password"><spring:message code="password"/></form:label>
            <form:password id="password" name="password" path="password"/>
        </p>
          <c:if test="${not empty error}">
              <span class="error">${error}</span>
          </c:if>
        <div id="check"></div>
        <p>
            <input type="submit" id="enter" value="<spring:message code="enter"/>"/>
        </p>
    </form:form>


</div>
<form:form class="registration" method="get" action="dropFile">
    <input type="submit" class="btnLogin" id="registration" value="<spring:message code="drop"/>"/>
</form:form>


<form:form class="view" method="get" action="table/list">
    <input type="submit" id="listFile" value="<spring:message code="view"/>"/>
</form:form>
</body>
</html>
