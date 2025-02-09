<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="com.javarush.stepanov.quest.GameState" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Последнее сообщение</title>
    <link rel="stylesheet" href="css/style.css">
</head>
<body>
<%
    GameState gameState = (GameState) request.getAttribute("gameState");
    if (gameState == null) {
        response.sendRedirect("quest"); // Инициализация игры
        return;
    }

    String currentScreen = gameState.getCurrentScreen();
%>

<div class="container">
    <h1>Последнее сообщение</h1>

    <%-- Отображение контента в зависимости от экрана --%>
    <% if ("screen1".equals(currentScreen)) { %>
    <p>Получено сообщение: [Странные символы] ... Quarantine. Станция "Аргус-7" молчит. Что вы делаете?</p>
    <form action="quest" method="post">
        <button type="submit" name="action" value="optionA">Попытаться расшифровать символы.</button><br>
        <button type="submit" name="action" value="optionB">Немедленно связаться с командованием.</button><br>
        <button type="submit" name="action" value="optionC">Проигнорировать сообщение (возможно, сбой системы).</button>
    </form>

    <% } else if ("screen2A".equals(currentScreen)) { %>
    <p>Вам удалось частично расшифровать символы. Они указывают на протокол биологической защиты. Что вы делаете?</p>
    <form action="quest" method="post">
        <button type="submit" name="action" value="optionA">Поднять уровень тревоги до максимального.</button><br>
        <button type="submit" name="action" value="optionB">Попытаться связаться с медицинским отделом станции.</button><br>
    </form>

    <% } else if ("screen2B".equals(currentScreen)) { %>
    <%-- Контент для screen2B --%>

    <% } else if ("screen2C".equals(currentScreen)) { %>
    <%-- Контент для screen2C --%>

    <% } else if ("goodEnding".equals(currentScreen)) { %>
    <p>Благодаря вашим действиям, карантин сработал. Угроза локализована. Вас благодарят за оперативность и профессионализм.</p>
    <% } else if ("neutralEnding".equals(currentScreen)) { %>
    <p>Станция "Аргус-7" эвакуирована. Дальнейшая судьба экипажа и потенциальной угрозы неизвестна. Вы выполнили протокол, но вопросы остались.</p>
    <% } %>
</div>
</body>
</html>
