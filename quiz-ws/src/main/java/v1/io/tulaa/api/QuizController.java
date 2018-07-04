package v1.io.tulaa.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import v1.io.tulaa.model.Quiz;
import v1.io.tulaa.model.TextRequest;
import v1.io.tulaa.service.QuizService;

import static org.springframework.web.bind.annotation.RequestMethod.POST;

/**
 * API endpoints.
 *
 * @author <a href="tonyafula@gmail.com">Tony Afula</a>
 */
@RestController
@RequestMapping("/api/v1/quiz")
public class QuizController {
    @Autowired
    QuizService quizService;

    /**
     * End point for reversing string while preserving the position of special characters.
     *
     * @param textRequest string to reverse
     * @return
     */
    @RequestMapping(value = "/reversetext", method = POST)
    public Quiz reverseText(@RequestBody TextRequest textRequest) {
        String inputText = textRequest.getContent();

        String reversedWord = quizService.reverseWord(inputText);
        Quiz quiz = new Quiz(inputText, reversedWord);
        return quiz;
    }
}