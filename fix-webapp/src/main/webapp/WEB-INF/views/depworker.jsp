<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page session="false" %>
<html>

<head>
    <link href="<c:url value="/resources/styles/css/table.css" />" type="text/css" rel="stylesheet">
    <title>Worker Page</title>
</head>
<body>

<c:url var="addAction" value="/depworkers/${department.departmentId}/add" ></c:url>
<form:form action="${addAction}" commandName="workerDTO">
<table id="add">
    <caption>Add Worker</caption>
    <c:if test="${!empty workerDTO.firstName}">
    <tr>
        <td>
            <form:label path="id">
                <spring:message text="ID"/>
            </form:label>
        </td>
        <td>
            <form:input path="id" readonly="true" size="8"  disabled="true" />
            <form:hidden path="id" />
        </td> 
    </tr>
    </c:if>
    <tr>
        <td>
            <form:label path="firstName">
                <spring:message text="First Name"/>
            </form:label>
        </td>
        <td>
            <form:input path="firstName" />
        </td> 
    </tr>
    <tr>
        <td>
            <form:label path="lastName">
                <spring:message text="Last Name"/>
            </form:label>
        </td>
        <td>
            <form:input path="lastName" />
        </td>
    </tr>
    <tr>
        <td>
            <form:label path="salary">
                <spring:message text="Salary"/>
            </form:label>
        </td>
        <td>
            <form:input path="salary" />
        </td> 
    </tr>
    <tr>
    	<td>
            <form:label path="departmentId"/>
        </td>
    	<td>
    		<form>
        	<input id="departmentId" name="departmentId" type="hidden" value="${department.departmentId}"/>
        	</form>
        </td>
    </tr>
    <tr>
        <td colspan="2">
            <c:if test="${!empty workerDTO.firstName}">
                <input id="button" type="submit"
                    value="<spring:message text="Edit Worker"/>" />
            </c:if>
            <c:if test="${empty workerDTO.firstName}">
                <input id="button" type="submit"
                    value="<spring:message text="Add Worker"/>" />
            </c:if>
        </td>
    </tr>
</table>  
</form:form>
<br>
<c:if test="${!empty listWorkers}">

    <table>
    <caption>Department: ${department.departmentName}</caption>
    <thead>
    <tr>
        <th width="40">Worker ID</th>
        <th width="120">Worker First Name</th>
        <th width="120">Worker Last Name</th>
        <th width="80">Worker Salary</th>
        <th width="60">Edit</th>
        <th width="60">Delete</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${listWorkers}" var="workerDTO">
    	<c:if test="${workerDTO.departmentId==department.departmentId}">
        <tr>
            <td>${workerDTO.id}</td>
            <td>${workerDTO.firstName}</td>
            <td>${workerDTO.lastName}</td>
            <td>${workerDTO.salary}</td>
            <td><a href="<c:url value='/depworkers/${department.departmentId}/edit/${workerDTO.id}' />" >Edit</a></td>
            <td><a href="<c:url value='/depworkers/${department.departmentId}/remove/${workerDTO.id}' />" >Delete</a></td>
        </tr>
        </c:if>
    </c:forEach>
    </tbody>
    </table>
</c:if>
<br>
<p><a href="/fix-webapp/departments">go back to previous page</a></p>
</body>
</html>