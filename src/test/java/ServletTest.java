import com.javarush.stepanov.quest.GameServlet;
import com.javarush.stepanov.quest.utils.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

import static org.mockito.Mockito.*;

public class ServletTest {

    HttpServletRequest request = mock(HttpServletRequest.class);

    HttpServletResponse response = mock(HttpServletResponse.class);

    HttpSession session = mock(HttpSession.class);

        Question question1 = new Question(1, "Согласно протоколу Аргус-7 изолируют, службы экстренной помощи будут подняты по тревоге. Вы уверены?",List.of(
            new Answer("Да"),
                new Answer("Оборвать связь", "Вы приняли верное решение!")));

    Question question2 = new Question(2, "Получено сообщение: [Странные символы] … Quarantine. Станция “Аргус-7” молчит. Что вы делаете?", List.of(
            new Answer("Попытаться расшифровать символы"),
            new Answer("Немедленно связаться с командованием", "Сообщение обрывается. " +
                    "Через несколько дней вся система зафиксирует аномальную биологическую активность, " +
                    "исходящую от Х-42. Вы знали, вы могли что-то сделать. Game Over.")));

    @Test
    @DisplayName("Game Over")
    public void doGetGameServletTestWrongAnswer() throws IOException {
        GameServlet gameServlet = new GameServlet();
        when(request.getSession()).thenReturn(session);
        when(request.getParameter("answerId")).thenReturn("1");
        doNothing().when(session).setAttribute(anyString(), any());
        when(session.getAttribute("question")).thenReturn(question1);
        QuestionManager questionManager = spy(new QuestionManager());
        when(questionManager.getById(2)).thenReturn(question2);
        gameServlet.doGet(request, response);
        verify(session).setAttribute(eq("wrongAnswer"), any(Answer.class));
    }

    @Test
    @DisplayName("Victory")
    public void doGetGameServletTestRightAnswer() throws IOException {
        GameServlet gameServlet = new GameServlet();
        when(request.getSession()).thenReturn(session);
        when(request.getParameter("answerId")).thenReturn("0");
        doNothing().when(session).setAttribute(anyString(), any());
        when(session.getAttribute("question")).thenReturn(question1);
        QuestionManager questionManager = spy(new QuestionManager());
        when(questionManager.getById(2)).thenReturn(question2);
        gameServlet.doGet(request, response);
        verify(session).setAttribute(eq("question"), any(Question.class));
        verify(response).sendRedirect("/game.jsp");
    }
}
