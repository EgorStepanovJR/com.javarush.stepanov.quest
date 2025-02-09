package com.javarush.stepanov.quest;

import java.io.Serial;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public class GameState implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    private String currentScreen;
    private final Map<String, Object> variables = new HashMap<>();

    public GameState() {
        currentScreen = "screen1"; // Начальный экран
    }

    public String getCurrentScreen() {
        return currentScreen;
    }

    public void setCurrentScreen(String currentScreen) {
        this.currentScreen = currentScreen;
    }

    public Object getVariable(String key) {
        return variables.get(key);
    }

    public void setVariable(String key, Object value) {
        variables.put(key, value);
    }

    public boolean hasVariable(String key) {
        return variables.containsKey(key);
    }
}
