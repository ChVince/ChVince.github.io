<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<!DOCTYPE html>
<head>

    <meta http-equiv="Content-Language" content="text/html; charset=UTF-8">
    <script type="text/javascript" src="/resources/js/jquery-1.5.1.min.js"></script>



    <title><spring:message code="dropTitle"/></title>

</head>
<body>

<script language="JavaScript" type="text/javascript">


    function HandleBrowseClick() {
        var fileinput = document.getElementById("file");
        fileinput.click();
    }
    function HandleBrowseChange() {
        var fileinput = document.getElementById("file");
        document.getElementById('filename').value = fileinput.files[0].name;
    }
</script>

<div class="wrapper">
    <form:form method="post" action="/upload" commandName="uploadedFile" id="dropForm" enctype="multipart/form-data">

        <p>
            <form:label for="author" path="author"><spring:message code="author"/></form:label></p>
        <form:input name="author" id="author" path="author"/>
        <form:errors path="author" cssClass="error"/>

        <p><form:label for="description" path="description"><spring:message code="description"/></form:label></p>
        <form:textarea id="description" name="description" path="description"/>
        <form:errors path="description" cssClass="error"/>


        <p><form:input type="file" name="file" id="file" path="file" onchange="HandleBrowseChange();" style="display:none"/></p>

        <input type="button" id="fakeBrowse" value="<spring:message code="dropFile.button"/>"
               onclick="HandleBrowseClick();"/>

        <label for="filename"></label>
        <input type="text" id="filename" readonly="true"/>


        <p><form:errors path="file" cssClass="error"/></p>

        <p><input type="submit" id="upload" value="<spring:message code="upload"/>"/></p>
        <span id="message"></span>
    </form:form>
</div>
</body>

</html>