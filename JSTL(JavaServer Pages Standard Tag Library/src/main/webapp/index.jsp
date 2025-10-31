<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSTL Tutorial Example</title>
</head>
<body>

<h1>🌟 JSTL Core Tags Demonstration</h1>

<!-- 1️⃣ SET & OUT TAGS -->
<!-- <c:set> stores a variable value -->
<c:set var="studentName" value="Vansh Wagh" />
<!-- <c:out> safely prints the variable -->
<p>Student Name: <c:out value="${studentName}" /></p>


<!-- 2️⃣ IF CONDITION -->
<c:set var="marks" value="85" />
<c:if test="${marks >= 50}">
    <p>Status: <b>Passed</b></p>
</c:if>


<!-- 3️⃣ CHOOSE / WHEN / OTHERWISE -->
<h3>Grade:</h3>
<c:choose>
    <c:when test="${marks >= 90}">A+</c:when>
    <c:when test="${marks >= 75}">A</c:when>
    <c:when test="${marks >= 60}">B</c:when>
    <c:otherwise>Fail</c:otherwise>
</c:choose>


<!-- 4️⃣ FOR EACH LOOP -->
<h3>Subjects:</h3>
<%
    java.util.List<String> subjects = java.util.Arrays.asList("Maths", "Physics", "Chemistry", "Computer Science");
    request.setAttribute("subjectList", subjects);
%>
<ul>
    <c:forEach var="sub" items="${subjectList}" varStatus="loop">
        <li>${loop.count}. ${sub}</li>
    </c:forEach>
</ul>

<!-- 5️⃣ IMPORT Example -->
<h3>Import Example:</h3>
<c:import url="footer.jsp">
    <c:param name="year" value="2025" />
</c:import>

<!-- 6️⃣ REMOVE variable -->
<c:remove var="marks" />
<p>Marks removed? ${empty marks}</p>

</body>
</html>
