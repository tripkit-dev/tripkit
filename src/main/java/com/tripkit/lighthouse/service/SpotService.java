package com.tripkit.lighthouse.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.maps.errors.ApiException;
import com.google.maps.model.PlaceDetails;
import com.google.maps.model.PlacesSearchResult;
import com.tripkit.lighthouse.repository.SpotRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
@RequiredArgsConstructor
public class SpotService {

    private final ModelMapper modelMapper;  // Entity <-> DTO 변환
    private final ObjectMapper objectMapper;
    private final SpotRepository spotRepository;
    private final GoogleAPIService googleAPI;

    // parameter 단어들을 뽑아서 Spot 리스트들을 리턴
    private List<PlacesSearchResult> getSpotList(List<String> parameter) throws IOException, InterruptedException, ApiException {
        String query = String.join(" ", parameter);
        return googleAPI.textSearch(query);
    }

    private PlaceDetails getSpotDetail(List<String> parameter) throws IOException, InterruptedException, ApiException {
        String query = String.join(" ", parameter);
        return googleAPI.placeDetail(googleAPI.getPlaceId(query));

//        // HTTP 요청
//        String responseBodyString = googleAPI.getResponseBodyByString(url);
//
//        // Data 가공 : place_id 추출, candidates는 array 뱉음
//        String middleObject = objectMapper.readTree(responseBodyString).get("candidates").toString();
//        List<SpotBasicDto> spotBasicDtos = objectMapper.readValue(middleObject, new TypeReference<>() {});
//        String placeId = spotBasicDtos.get(0).getPlaceId();
//
//        // 추출한 place_id를 바탕으로 placeDetail 호출
//        url = googleAPI.placeDetail(placeId);
//        responseBodyString = googleAPI.getResponseBodyByString(url);
//
//        // 파싱해서 붙여넣기
//        return objectMapper.readValue(objectMapper.readTree(responseBodyString).get("result").toPrettyString(), SpotDetailDto.class);
    }

    public List<PlacesSearchResult> getSpotByLocation(String location, Pageable pageable) throws IOException, InterruptedException, ApiException {
        // TODO 나중에 location validation 넣기
        // 한국의 지역명 validation
        return getSpotList(Arrays.asList(location, "카페")); // 어느 지역이든 카페를 기본값으로 탐색
    }

    public List<PlacesSearchResult> getSpotByLocationCategory(String location, String category, Pageable pageable) throws IOException, InterruptedException, ApiException {
        // TODO 나중에 location, category validation 넣기
        // category에 따른 유효성도 검증
        return getSpotList(Arrays.asList(location, category));
    }

    public List<PlacesSearchResult> getSpotByLocationCategoryTag(String location, String category, String tag, Pageable pageable) throws IOException, InterruptedException, ApiException {
        // TODO 나중에 location, category, tag validation 넣기
        // 카테고리 유효성 검증 위의 메소드랑 같은걸로 만들기
        return getSpotList(Arrays.asList(location, category, tag));
    }

    public PlaceDetails getSpot(String location, String category, String tag, String title) throws IOException, InterruptedException, ApiException {
        return getSpotDetail(Arrays.asList(location, category, tag, title));
    }

    public List<PlacesSearchResult> getSpotByCategory(String category, Pageable pageable) throws IOException, InterruptedException, ApiException {
        // TODO 나중에 location validation 넣기
        // 한국의 지역명 validation
        List<String> strings = new ArrayList<>(Arrays.asList(category)); // 어느 지역이든 카페를 기본값으로 탐색
        return getSpotList(strings);
    }

//    public List<SpotBasicDto> getSpotByTag(String tag, Pageable pageable) throws IOException {
//
//        List<SpotBasicDto> spotBasicDtos = new ArrayList<>();
//
//        // Google API 주소 설정
//        String url = googleAPI.textSearch(tag);
//
//        // HTTP 요청
//        String responseBodyByString = googleAPI.getResponseBodyByString(url);
//
//        // Data 가공
//        for (JsonNode jsonNode : objectMapper.readTree(responseBodyByString).get("results")) {
//            spotBasicDtos.add(objectMapper.readValue(jsonNode.toPrettyString(), SpotBasicDto.class));
//        }
//
//        return spotBasicDtos;
//    }
//
//    public SpotBasicDto addSpot(SpotBasicDto spotBasicDto) {
//
//        Spot spot = new Spot();
//
//        SpotBasicDto retDto = new SpotBasicDto();
//
//        spot = modelMapper.map(spotBasicDto, spot.getClass());
//
//        spotRepository.save(spot);
//
//        return retDto;
//    }
//
//    public SpotDetailDto getSpotDetail(String name) {
//
//        SpotDetailDto spotDetailDto = null;
//
//        return spotDetailDto;
//    }
}
