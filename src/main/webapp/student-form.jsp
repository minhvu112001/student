<%--
  Created by IntelliJ IDEA.
  User: default
  Date: 5/31/2023
  Time: 2:46 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Student Form</title>
    <style>
        body{
            font-family: Arial, sans-serif;
            margin: 20px;
        }
        h1{
            color: #333;
        }
        table{
            width: 100%;
            border-collapse: collapse;
        }
        th, td{
            padding: 10px;
            text-align: left;
            border-bottom: 1px solid #ccc;
        }
        tr:nth-child(even){
            background-color: #e0e0e0;
        }
        .button{
            display: inline-block;
            background-color: #4CAF50;
            color: #fff;
            padding: 8px 16px;
            text-decoration: none;
            border-radius: 4px;
            transition: background-color 0.3s;
        }
        .button:hover{
            background-color: #45a049;
        }
        .add-button{
            margin-bottom: 10px;
        }
        .image-container{
            width: 200px;
            height: 200px;
            border: 1px solid #ccc;
            border-radius: 5px;
            overflow: hidden;
        }
    </style>
</head>
<body>
<h1>Student Form</h1>
<c:choose>
<c:when test="${empty student.id}">
    <form method="POST" action="students?action=create">
        <label for="studentName">Student name: </label>
        <input type="text" id="studentName" name="studentName">
        <br><br>
        <label for="score">Score: </label>
        <input type="text" id="score" name="price">
        <br><br>
        <input  type="submit" value="Create">
        <a class="button" href="students">Cancels</a>
    </form>
    </c:when>
    <c:otherwise>

        <form method="POST" action="students?action=update">
            <input type="hidden" name="id" value="${student.id}">
            <label for="studentName">Product name: </label>
            <input type="text" id="Name" name="scoreName" value="${student.scoreName}">
            <br><br>
            <label for="score">Price: </label>
            <input type="text" id="score" name="score" value="${student.score}">
            <br><br>
            <input type="submit" value="Update">
            <a class="button" href="students">Cancel</a>
        </form>
        <form method="POST" action="students?action=delete">
            <input type="hidden" name="id" value="${student.id}">
            <input class="button" type="submit" value="Delete">
        </form>
        </c:otherwise>
        </c:choose>


</body>
</html>
