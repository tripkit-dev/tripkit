package com.tripkit.lighthouse.controller;

import com.tripkit.lighthouse.data.dto.SpotBasicDto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.restdocs.AutoConfigureRestDocs;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.restdocs.mockmvc.MockMvcRestDocumentation.document;
import static org.springframework.restdocs.mockmvc.RestDocumentationRequestBuilders.get;
import static org.springframework.restdocs.operation.preprocess.Preprocessors.*;
import static org.springframework.restdocs.payload.PayloadDocumentation.*;
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
    private SpotController spotController;

    @Test
    @DisplayName("카테고리로 Spot 데이터 가져오기")
    void getSpotByCategory() {
    }

    @Test
    @DisplayName("태그로 Spot 데이터 가져오기")
    void getSpotByTag() {
    }

    @Test
    @DisplayName("매장 이름으로 Spot 데이터 가져오기")
    void getSpotByTitle() throws Exception{

        List<SpotBasicDto> spotBasicDtos = Arrays.asList(
                new SpotBasicDto("title12",
                        "link1",
                        "cafe",
                        "description4",
                        "telephone",
                        "address",
                        "roadAddress",
                        13,
                        13
                ),
                new SpotBasicDto("title12",
                        "link2",
                        "cafeteria",
                        "description5",
                        "telephone",
                        "address",
                        "roadAddress",
                        13,
                        13
                ),
                new SpotBasicDto("title12",
                        "link3",
                        "catcat",
                        "description6",
                        "telephone",
                        "address",
                        "roadAddress",
                        13,
                        13
                ));

        when(spotController.getSpotByTitle(any(), any())).thenReturn(spotBasicDtos);

        // 요청방식(GET, POST 등등)을 선택하고, url을 입력
        this.mockMvc.perform(get("/api/spots/title")
                        .content("{\"title\": \"title12\", \"pageable\": \"1\"}")
                        .accept(MediaType.APPLICATION_JSON)) //json 형식의 요청을 받겠다는 의미
                .andExpect(status().isOk())
                .andDo(document("get-spot-by-title", // Documentation에서 제목 설정
                        preprocessRequest(prettyPrint()),
                        preprocessResponse(prettyPrint()),
                        requestFields(
                                fieldWithPath("title").description("찾고자 하는 Spot의 지점명 검색"),
                                fieldWithPath("pageable").description("보고싶은 Spot 갯수")
                        ),
                        responseFields(
                                fieldWithPath("[].title").description("Spot Title"),
                                fieldWithPath("[].link").description("Spot Title"),
                                fieldWithPath("[].category").description("Spot Title"),
                                fieldWithPath("[].description").description("Spot Title"),
                                fieldWithPath("[].telephone").description("Spot Title"),
                                fieldWithPath("[].address").description("Spot Title"),
                                fieldWithPath("[].roadAddress").description("Spot Title"),
                                fieldWithPath("[].mapx").description("Spot Title"),
                                fieldWithPath("[].mapy").description("Spot Title")
                        )
                ))
                .andReturn(); // 정상적으로 동작시 isCreated 상태 코드 응답
    }

    @Test
    @DisplayName("Spot Post하기")
    void addSpot() {
    }
}