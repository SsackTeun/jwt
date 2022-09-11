package com.github.ssackteun.portal.jwt;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.restdocs.AutoConfigureRestDocs;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.restdocs.mockmvc.MockMvcRestDocumentation.document;
import static org.springframework.restdocs.mockmvc.RestDocumentationRequestBuilders.get;
import static org.springframework.restdocs.payload.PayloadDocumentation.fieldWithPath;
import static org.springframework.restdocs.payload.PayloadDocumentation.requestFields;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@AutoConfigureMockMvc
@AutoConfigureRestDocs
@SpringBootTest
public class AuthControllerTests {
    @Autowired
    MockMvc mockMvc;

    @Test
    void token() throws Exception{
        this.mockMvc.perform(get("/auth/token")
                .content("{\"userid\": \"ssackteun\",\n\"password\": \"asdf\" }")
                .contentType(MediaType.APPLICATION_JSON)) //요청

                .andExpect(status().isCreated()) //검증
                .andDo(document("get-token",
                            requestFields(
                                    fieldWithPath("userid").description("유저 아이디"),
                                    fieldWithPath("password").description("유저 패스워드").optional()
                            )
                ))
                .andDo(print());
    }
}
