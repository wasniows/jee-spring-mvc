
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>

    <style>
        table {
            border-collapse: collapse;
        }
        table, th, td {
            border: 1px solid grey;
        }
        th, td {
            text-align: center;
            padding: 6px;
        }
        tr {
            background-color: #F2F2F2;
        }
        .uprow {
            background: grey;
            color: #F2F2F2;
        }
    </style>

</head>
<body>

<table>
    <tr>
        <th class="uprow">x</th>
        <c:forEach varStatus="loop" begin="1" end="${sizeX}">
            <th class="uprow"> ${loop.index}</th>
        </c:forEach>
    </tr>
    <c:forEach varStatus="loop1" begin="1" end="${sizeY}">
        <tr>
            <th>${loop1.index}</th>
            <c:forEach varStatus="loop2" begin="1" end="${sizeX}">
                <td>${loop1.count * loop2.count}</td>
            </c:forEach>
        </tr>
    </c:forEach>
</table>

</body>
</html>
