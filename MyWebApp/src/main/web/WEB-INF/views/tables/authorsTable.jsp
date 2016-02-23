

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

    <title><spring:message code="tableAuthors"/></title>
</head>
<body>

  <div class="well">
      <strong><spring:message code="tableAuthors"/></strong>
  </div>

<div class="content">
    <table>
        <tr>
            <th>№</th>
            <th><spring:message code="author"/></th>
            <th><spring:message code="removeAuthor"/></th>
        </tr>
        <c:forEach items="${authors}" var="author" varStatus="itr">
            <tr>
                <td>${offset + itr.index +1 }</td>
                <th><a href="/table/viewAllFilesByAuthor?author=${author.nameAuthor}">${author.nameAuthor}</a></th>

                <th>
                    <a href="deleteByAuthor?author=${author.nameAuthor}"><spring:message code="removeAuthor"/></a>
                </th>
            </tr>
        </c:forEach>
    </table>
    <tag:paginate max="15" offset="${offset}" count="${count}"
                  uri="/table/viewFilesAsModerator" next="&raquo;" previous="&laquo;" />
</div>

</body>
</html>





