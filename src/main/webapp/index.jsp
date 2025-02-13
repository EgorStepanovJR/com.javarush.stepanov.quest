<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@page import = "java.util.*" session="true"%>

<html>
<head>
    <title>Quest Game</title>
    <link href="css/index.css" rel="stylesheet">
    <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
</head>

<body>
<div>
    <h1>“Последнее сообщение”</h1>
    <button onclick="window.location='game'">Начать</button>
</div>
<div>
    <table>
        <tr>
            <td>
                <p><b>Статистика:</b></p>
                <%
                    Integer counter = (Integer)session.getAttribute("counter");
                    if (counter == null) {
                        counter = 1;
                    } else {
                        counter++;
                    }
                    session.setAttribute("counter", counter);
                %>
                ID сессии: <%=session.getId()%>
                <br>
                Кол-во сыгранных игр: <%=counter%>
                <br>
                Дата запуска: <%= (new java.util.Date())%>
            </td>
        </tr>
    </table>
</div>
</body>
</html>
