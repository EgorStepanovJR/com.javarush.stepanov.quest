package com.javarush.stepanov.quest.utils;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class QuestionManager {

    public final static Map<Integer, Question> questionList = new HashMap<>();

    static {
        init();
    }

    private static void init() {
        int id = 0;
        questionList.put(++id, new Question(id, "Получено сообщение: \n[Странные символы] … Quarantine. Станция “Аргус-7” молчит. \nЧто вы делаете?", List.of(
                new Answer("Попытаться расшифровать символы."),
                new Answer("Проигнорировать сообщение (возможно, сбой системы)", "Вы решили проигнорировать сообщение..."))));

        questionList.put(++id, new Question(id, "Вам удается частично расшифровать символы. \n Они указывают на протокол биологической защиты. \n" +
                "Что вы делаете?", List.of(
                new Answer("Поднять уровень тревоги до максимального."),
                new Answer("Игнорировать (возможно, кто-то решил подшутить).",
                        "Сообщение обрывается.\n " +
                        "Через несколько дней вся система зафиксирует аномальную биологическую активность,\n" +
                        " исходящую от Х-42. Вы знали, вы могли что-то сделать. Game Over."))));

        questionList.put(++id ,new Question(id, "Согласно протоколу Аргус-7 изолируют, \nслужбы экстренной помощи будут подняты по тревоге. \nВы уверены?", List.of(
                new Answer("Да"),
                new Answer("Оборвать связь!","Дальнейшая судьба экипажа и потенциальной угрозы неизвестна."))));

        questionList.put(++id, new Question(id, "Командование требует немедленного доклада\n и запрашивает ваш уровень допуска. \nЧто вы делаете?", List.of(
                new Answer("Предоставить уровень допуска."),
                new Answer("Отказать в предоставлении уровня допуска.",
                        "Вы вызвали подозрение и началась долгая проверка.\n " +
                                "Дальнейшая судьба экипажа и потенциальной угрозы неизвестна."))));
    }

    public Question getById(int id) {
        return questionList.get(id);
    }
}
