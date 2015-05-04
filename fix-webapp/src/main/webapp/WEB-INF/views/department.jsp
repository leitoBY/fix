<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page session="false" %>
<html>
<head>
	<link href="<c:url value="/resources/styles/css/department.css" />" type="text/css" rel="stylesheet">
    <title>Department Page</title>
</head>
<body>

 
<c:url var="addAction" value="/department/add" ></c:url>
 
<form:form action="${addAction}" commandName="department">
<table id="add">
	<caption>Add Department</caption>
    <c:if test="${!empty department.departmentName}">
    <tr>
        <td>
            <form:label path="departmentId">
                <spring:message text="Department ID"/>
            </form:label>
        </td>
        <td>
            <form:input path="departmentId" readonly="true" size="8"  disabled="true" />
            <form:hidden path="departmentId" />
        </td> 
    </tr>
    </c:if>
    <tr>
        <td>
            <form:label path="departmentName">
                <spring:message text="Department Name"/>
            </form:label>
        </td>
        <td>
            <form:input path="departmentName" />
        </td> 
    </tr>
    <tr>
        <td colspan="2">
            <c:if test="${!empty department.departmentName}">
                <input id="button" type="submit"
                    value="<spring:message text="Edit Department's name"/>" />
            </c:if>
            <c:if test="${empty department.departmentName}">
                <input id="button" type="submit"
                    value="<spring:message text="Add new Department"/>" />
            </c:if>
        </td>
    </tr>
</table>  
</form:form>
<br>
<c:if test="${!empty listDeps}">
    <table class="tg">
    <caption>Departments</caption>
    <thead>
    <tr>
        <th width="120">Department name</th>
        <th width="90">Average salary</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${listDeps}" var="department">
        <tr>
            <td><a href="depworkers/${department.departmentId}"> ${department.departmentName} </a></td>
            <td>${department.avgSalary}</td>
            <td><a href="<c:url value='department/edit/${department.departmentId}' />" >Edit</a></td>
            <td><a href="<c:url value='department/remove/${department.departmentId}' />" >Delete</a></td>
        </tr>
    </c:forEach>
    </tbody>
    </table>
</c:if>
<br>
<p><a href="/fix-webapp">go back to main page</a></p>
</body>
</html>