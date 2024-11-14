<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <title>Store</title>
    <link rel="stylesheet"
        href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
        integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
        crossorigin="anonymous">
    <style>
        .small-width {
            max-width: 100px;
            word-wrap: break-word;
        }
        .description {
            max-width: 100px; 
            word-wrap: break-word; 
            white-space: normal; 
        }
    </style>
</head>
<body>
    <jsp:include page="header.jsp" />
    
    <br>

    <div class="container">
        <h3 class="text-center">Item List</h3>
        <hr>
        <div class="text-left">
            <a href="${pageContext.request.contextPath}/new" class="btn btn-success">Add New Item</a>
        </div>
        <br>
        <table class="table table-striped table-bordered table-hover">
            <thead class="thead-dark">
                <tr>
                    <th>ID</th>
                    <th>Category</th>
                    <th>Name</th>
                    <th class="small-width">Image URL</th>
                    <th>Price</th>
                    <th>Discount</th>
                    <th class="description">Description</th>
                    <th>Start Date</th>
                    <th>endDate</th>
                    <th>Action</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach var="item" items="${menuList}">
                    <tr>
                        <td><c:out value="${item.id}" /></td>
                        <td><c:out value="${item.categoryID}" /></td>
                        <td><c:out value="${item.menuName}" /></td>
                        <td class="small-width"><c:out value="${item.image}" /></td>
                        <td><c:out value="${item.price}" /></td>
                        <td><c:out value="${item.discount}" /></td>
                        <td class="description"><c:out value="${item.description}" /></td>
                        <td><c:out value="${item.startDate}" /></td>
                        <td><c:out value="${item.endDate}" /></td>
                        <td>
                            <a href="${pageContext.request.contextPath}/edit?id=<c:out value='${item.id}' />"
                                class="btn btn-primary btn-sm">Edit</a>
                            <a href="${pageContext.request.contextPath}/delete?id=<c:out value='${item.id}' />"
                                class="btn btn-danger btn-sm">Delete</a>
                        </td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
    </div>
    <jsp:include page="footer.jsp" />
</body>
</html>
