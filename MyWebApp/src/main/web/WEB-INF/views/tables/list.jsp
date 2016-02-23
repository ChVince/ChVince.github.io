<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib prefix="tag" uri="/WEB-INF/taglibs/customTaglib.tld"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">


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
        </tr>
        <c:forEach items="${files}" var="file" varStatus="itr">
            <tr>
                <td>${offset + itr.index +1 }</td>
                <th>${file.fileName}</th>
                <th>${file.description}</th>
                <th>${file.size} byte</th>
                <th>
                    <a href="download?id=${file.id}&fileName=${file.fileName}&role=user"><spring:message code="download"/></a>
                </th>
            </tr>
        </c:forEach>
    </table>
      <tag:paginate max="15" offset="${offset}" count="${count}"
                    uri="/table/list" next="&raquo;" previous="&laquo;" />
</div>

</body>
</html>