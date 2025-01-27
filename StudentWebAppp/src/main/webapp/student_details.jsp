<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%><!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Student Details</title>

<script type="text/javascript">
function confirmDelete(studentName) {
    return confirm("Are you sure you want to delete " + studentName + "?");
}
</script>
</head>
<body>
<h1>Student Details</h1>
<c:if test="${!empty sList}">
<table>
        <thead>
            <tr>
                <th>ID</th>
                <th>Name</th>
                <th>Address</th>
                <th>Contact</th>
                <th>Gender</th>
                <th>Actions</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach var="student" items="${sList}">
                <tr>
                    <td><c:out value="${student.id}"></c:out></td>
                    <td><c:out value="${student.name}"></c:out></td>
                    <td><c:out value="${student.address}"></c:out></td>
                    <td><c:out value="${student.contact}"></c:out></td>
                    <td><c:out value="${student.gender}"></c:out></td>
                    <td>
                    <a href="Controller?action=edit&id=${student.id}">
                    <button type="button" class="btn btn-success">Edit</button>
                    </a>
                    <a href="Controller?action=delete&id=${student.id}"
                    onclick="return confirmDelete('${student.name}')">
                    <button type="button" class="btn btn-danger">Delete</button>
                    </a>
                    </td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
    </c:if>
    
    <c:if test="${empty sList}">
    <p>No Students data.</p>
    </c:if>
</body>
</html>