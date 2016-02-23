<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<html>
<title><spring:message code="titleResult"/></title>

<body>
<div class="text"><spring:message code="successUpload"/></div>
:
<table class="two-columns">
    <tbody>
    <tr>

        <td><spring:message code="file"/></td>
        <td><b>${file.fileName}</b></td>


    </tr>
    <tr>

        <td><a href="/table/download?id=${file.id}&fileName=${file.fileName}&role=user"><spring:message code="download"/></a>
        </td>
    </tr>
    <tr>
        <td><a href="/table/delete?code=${file.code}&role=user"><spring:message code="delete"/></a></td>
    </tr>
    </tbody>
</table>
<hr>
<p>
    <a href="/"><spring:message code="home"/></a>;
</p>
</body>
<style>
    body {
        text-align: center;
    }

    .two-columns {
        margin: auto;
    }
</style>
</html>


