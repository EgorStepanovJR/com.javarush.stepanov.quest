package com.javarush.stepanov.quest;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebServlet("/quest")
public class QuestServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession session = request.getSession();
        GameState gameState = (GameState) session.getAttribute("gameState");

        if (gameState == null) {
            gameState = new GameState();
            session.setAttribute("gameState", gameState);
        }

        String action = request.getParameter("action");

        if (action != null) {
            // Обработка действий игрока на текущем экране
            switch (gameState.getCurrentScreen()) {
                case "screen1":
                    if ("optionA".equals(action)) {
                        gameState.setCurrentScreen("screen2A");
                    } else if ("optionB".equals(action)) {
                        gameState.setCurrentScreen("screen2B");
                    } else if ("optionC".equals(action)) {
                        gameState.setCurrentScreen("screen2C");
                    }
                    break;
                // Добавьте обработку для остальных экранов и действий
                case "screen2A":
                    if ("optionA".equals(action)) {
                        gameState.setCurrentScreen("goodEnding");
                    } else if ("optionB".equals(action)) {
                        gameState.setCurrentScreen("neutralEnding");
                    }
                    break;

                // Обработка остальных экранов ...
                default:
                    // По умолчанию, возможно, возвращаемся к начальному экрану или показываем сообщение об ошибке
                    break;
            }
        }

        // Передача данных для отображения в JSP
        request.setAttribute("gameState", gameState);
        request.getRequestDispatcher("/index.jsp").forward(request, response);
    }
}
