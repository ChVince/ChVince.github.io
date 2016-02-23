<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://www.opensymphony.com/sitemesh/decorator" prefix="decorator" %>
<!DOCTYPE html>
<html>
<head>
    <title><decorator:title default="SiteMesh Integration"/></title>
    <meta http-equiv="content-type" content="text/html; charset=utf-8"/>
    <decorator:head/>
</head>
<body>


<style type="text/css">@import "/resources/css/bootstrap.css";</style>
<style type="text/css">@import "/resources/css/table.css";</style>


<decorator:body/>


<div id="Footer">
</div>
</body>
</html>