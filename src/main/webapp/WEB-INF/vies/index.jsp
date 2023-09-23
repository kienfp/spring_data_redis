
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html; charset=UTF-8" pageEncoding="utf-8" %>
<html lang="en">
<head>
    <title>Title</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-4bw+/aepP/YC94hEpVNVgiZdgIC5+VKNBQNGCHeKRQN+PtmoHDEXuppvnDJzQIu9" crossorigin="anonymous">
</head>
<body>
<form:form action="/add" modelAttribute="sp" enctype="multipart/form-data">
    Nhap id <form:input path="id" />
    Nhap ten <form:input path="name"/>
    Nhap gia <form:input path="price"/>
    <form:button>Add</form:button>
</form:form>
<table class="table">
    <thead>
    <tr>
        <th scope="col">#</th>
        <th scope="col">ma</th>
        <th scope="col">ten</th>
        <th scope="col">gia</th>
        <th scope="col">action</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${list}" var="sp" varStatus="i">
        <tr>
            <th scope="col">${i.index + 1}</th>
            <th scope="col">${sp.id}</th>
            <th scope="col">${sp.name}</th>
            <th scope="col">${sp.price}</th>
            <th scope="col">
                <a href="/detail/${sp.id}" type="button" class="btn btn-primary">Detail</a>
                <a href="/delete/${sp.id}" type="button" class="btn btn-danger">Delete</a>
            </th>
        </tr>
    </c:forEach>
    </tbody>
</table>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-HwwvtgBNo3bZJJLYd8oVXjrBZt8cqVSpeBNS5n7C8IVInixGAoxmnlMuBnhbgrkm"
        crossorigin="anonymous"></script>
</body>
</html>