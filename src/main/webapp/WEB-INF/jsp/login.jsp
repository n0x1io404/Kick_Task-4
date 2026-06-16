<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ taglib prefix="fmt" uri="jakarta.tags.fmt" %>

<fmt:setLocale value="${not empty sessionScope.locale ? sessionScope.locale : 'en'}"/>
<fmt:setBundle basename="messages"/>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8"/>
    <title><fmt:message key="login.title"/></title>
    <style>
        body { font-family: sans-serif; padding: 2em; }
        .error { color: red; font-weight: bold; }
    </style>
</head>
<body>
    <h2><fmt:message key="login.title"/></h2>
    <!-- JSTL Logic -->
    <p class="error"><c:out value="${error}"/></p>
    
    <form action="${pageContext.request.contextPath}/controller" method="post">
        <!-- Command Pattern usage -->
        <input type="hidden" name="command" value="login"/>
        <label>Username: <input type="text" name="username" required/></label><br/><br/>
        <label>Password: <input type="password" name="password" required/></label><br/><br/>
        <button type="submit"><fmt:message key="login.button"/></button>
    </form>
</body>
</html>
