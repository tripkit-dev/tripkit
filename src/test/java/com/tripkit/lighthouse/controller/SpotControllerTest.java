package com.tripkit.lighthouse.controller;

import com.tripkit.lighthouse.data.dto.LineBasicDto;
import com.tripkit.lighthouse.data.dto.SpotBasicDto;
import com.tripkit.lighthouse.data.entity.Line;
import com.tripkit.lighthouse.data.entity.images.LineImage;
import com.tripkit.lighthouse.service.SpotService;
import org.assertj.core.util.Lists;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.restdocs.AutoConfigureRestDocs;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.restdocs.mockmvc.MockMvcRestDocumentation.document;
import static org.springframework.restdocs.mockmvc.RestDocumentationRequestBuilders.get;
import static org.springframework.restdocs.mockmvc.RestDocumentationRequestBuilders.post;
import static org.springframework.restdocs.payload.PayloadDocumentation.fieldWithPath;
import static org.springframework.restdocs.payload.PayloadDocumentation.requestFields;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
@AutoConfigureMockMvc   // -> webAppContextSetup(webApplicationContext)
@AutoConfigureRestDocs  // -> apply(documentationConfiguration(restDocumentation))
@SpringBootTest
class SpotControllerTest {

//    아래의 설정들은 모두 상단부의 @AutoConfigureMockMvc와 @AutoConfigureRestDocs로 대체되었음
//    private MockMvc mockMvc;
//
//    @BeforeEach
//    public void setUp(WebApplicationContext webApplicationContext,
//                      RestDocumentationContextProvider restDocumentation) {
//        this.mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext)
//                .apply(documentationConfiguration(restDocumentation))
//                .build();
//    }

    @Autowired
    private MockMvc mockMvc;
    @MockBean
    private SpotService spotService;

    @Test
    void getSpotByCategory() {
    }

    @Test
    void getSpotByTag() {
    }

    @Test
    void getSpotByTitle() throws Exception{
        SpotBasicDto spotBasicDto = new SpotBasicDto("title", "link", "category", "description", "telephone", "address", "roadAddress", 13, 13);
        List<SpotBasicDto> spotBasicDtos = new ArrayList<>();
        spotBasicDtos.add(spotBasicDto);
        when(spotService.getSpotByTitle(any(), any())).thenReturn(spotBasicDtos);

        this.mockMvc.perform(get("/api/title?title=title&page=1") // 요청방식(GET, POST 등등)을 선택하고, url을 입력
//                        .content("{\"title\":\"title\", \n\"link\":\"link\", \n\"category\":\"category\", \n\"description\":\"description\", \n\"telephone\":\"telephone\", \n\"address\":\"address\", \n\"roadAddress\":\"roadAddress\", \n\"13\":\"13\", \n\"13\":\"13\"}") // RequestBody에 대응되는 부분. POST method 같은 경우에는 받는 값이 있어 이 부분에 작성하면 된다.
//                        .content("{\"title\":\"title\", \"pageable\":\"1\"}")
                        .contentType(MediaType.APPLICATION_JSON)) //json 형식의 요청을 받겠다는 의미
                .andExpect(status().isOk()) // 정상적으로 동작시 isCreated 상태 코드 응답
                .andDo(document("spot-get-list-10", // Documentation에서 제목 설정
                        requestFields( //문서에 필요한 requestFields를 명시함
                                fieldWithPath("[].title").description("제목"),
                                fieldWithPath("[].pageable").description("갯수").optional()
                        )
                ));
    }

    @Test
    void addSpot() {
    }
}