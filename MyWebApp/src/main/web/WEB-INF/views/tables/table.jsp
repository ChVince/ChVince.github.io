<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib prefix="tag" uri="/WEB-INF/taglibs/customTaglib.tld"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link href="<c:url value="/resources/css/bootstrap.css" />" rel="stylesheet">
    <link href="<c:url value="/resources/css/table.css" />" rel="stylesheet">

    <title><spring:message code="filesList"/></title>
</head>
<body>

<div class="well">
    <strong><spring:message code="filesList"/></strong>
</div>


<div class="content">
    <table>
        <tr>
            <th>№</th>
            <th><spring:message code="file"/></th>
            <th><spring:message code="description"/></th>
            <th><spring:message code="size"/></th>
            <th><spring:message code="download"/></th>
            <th><spring:message code="delete"/></th>
        </tr>
        <c:forEach items="${filesByAuthor}" var="file" varStatus="itr">
            <tr>
                <td>${offset + itr.index +1 }</td>
                <th>${file.fileName}</th>
                <th>${file.description}</th>
                <th>${file.size} byte</th>
                <th>
                    <a href="/table/download?id=${file.id}&fileName=${file.fileName}&role=admin"><spring:message code="download"/></a>
                </th>
                <th><a href="/table/delete?code=${file.code}&role=admin"><spring:message code="delete"/></a></th>
            </tr>
        </c:forEach>
    </table>
    <tag:paginate max="15" offset="${offset}" count="${count}"
                  uri="/table/viewAllFilesByAuthor" next="&raquo;" previous="&laquo;" />
</div>

</body>
</html>







