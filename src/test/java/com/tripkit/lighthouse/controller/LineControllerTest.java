package com.tripkit.lighthouse.controller;

import com.tripkit.lighthouse.data.dto.LineBasicDto;
import com.tripkit.lighthouse.data.dto.SpotBasicDto;
import com.tripkit.lighthouse.data.entity.Line;
import com.tripkit.lighthouse.data.entity.images.Image;
import com.tripkit.lighthouse.data.entity.images.LineImage;
import com.tripkit.lighthouse.data.entity.images.SpotImage;
import com.tripkit.lighthouse.service.LineService;
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

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.restdocs.mockmvc.MockMvcRestDocumentation.document;
import static org.springframework.restdocs.mockmvc.RestDocumentationRequestBuilders.post;
import static org.springframework.restdocs.payload.PayloadDocumentation.fieldWithPath;
import static org.springframework.restdocs.payload.PayloadDocumentation.requestFields;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@AutoConfigureMockMvc
@AutoConfigureRestDocs
@SpringBootTest
class LineControllerTest {

//    상단부의 @AutoConfigureMockMvc와 @AutoConfigureRestDocs로 대체되었음
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
    private LineService lineService;

    @Test
    void getLineByUser() throws Exception{
    }

    @Test
    void postLine() throws Exception{

        LineBasicDto lineBasicDto = new LineBasicDto();
        lineBasicDto.setUserName("Song Chihoon");

        List<SpotBasicDto> spotBasicDtoList = new ArrayList<>();
        spotBasicDtoList.add(new SpotBasicDto("testtest", "testtest", "test", "test", "testtest", "testtest", "testtest", 13, 13));

        List<LineImage> lineImages = new ArrayList<>();
        lineImages.add(new LineImage(1L, new Line(1L, "")))
        lineBasicDto.setImages();
        when(lineService.postLine(any())).thenReturn(lineBasicDto);

        this.mockMvc.perform(post("/") // 요청방식과 요청 URL을 매핑 "{\"title\": \"title\", \n\"content\": \"content\"}"
                .content("{\"userName\":\"userName\", \n\"spots\":\"spots\", \n\"images\":\"images\"}") // RequestBody에 대응되는 부분
                .contentType(MediaType.APPLICATION_JSON)) //json 형식의 요청을 받겠다는 의미
                .andExpect(status().isCreated()) // 정상적으로 동작시 isCreated 상태 코드 응답
                .andDo(document("Line-Create", // Documentation에서 제목 설정
                        requestFields( //문서에 필요한 requestFields를 명시함
                                fieldWithPath("userName").description("송치훈"),
                                fieldWithPath("spots").description(" ").optional(),
                                fieldWithPath("images").description(" ").optional()
                        )
                ));
    }
}