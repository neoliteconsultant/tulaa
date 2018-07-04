package v1.io.tulaa.api;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.MediaType;
import v1.io.tulaa.model.TextRequest;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class QuizControllerTests {

    @Autowired
    private MockMvc mockMvc;


    @Test
    public void paramTextReturnReversedWord() throws Exception {


        TextRequest textRequest=new TextRequest();
        textRequest.setContent("a,b$c");

        ObjectMapper mapper = new ObjectMapper();
        String textRequestJSON = mapper.writeValueAsString(textRequest);

        this.mockMvc.perform(post("/api/v1/quiz/reversetext")
                .contentType(MediaType.APPLICATION_JSON)
                .content(textRequestJSON))
                .andDo(print()).andExpect(status().isOk())
                .andExpect(jsonPath("$.output").value("c,b$a"));
    }

}
