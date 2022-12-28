package com.tripkit.lighthouse.service;

import com.tripkit.lighthouse.configuration.GoogleAPIConfiguration;
import com.tripkit.lighthouse.injector.GoogleProperties;
import com.tripkit.lighthouse.data.dto.SpotBasicDto;
import com.tripkit.lighthouse.data.entity.Spot;
import com.tripkit.lighthouse.repository.SpotRepository;
import lombok.RequiredArgsConstructor;
import okhttp3.*;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class SpotService {

    private final ModelMapper modelMapper;  // Entity <-> DTO 변환
    private final SpotRepository spotRepository;
    private final GoogleAPIConfiguration googleAPI;


    public List<SpotBasicDto> getSpotByCategory(String category, Pageable pageable) {

        List<Spot> spots = new ArrayList<>();

        List<SpotBasicDto> spotBasicDtos = new ArrayList<>();

//        spots = spotRepository.findByCategoryIn(category, pageable);

        for (Spot spot : spots) {
            spotBasicDtos.add(modelMapper.map(spot, SpotBasicDto.class));
        }

        return spotBasicDtos;
    }

    public SpotBasicDto addSpot(SpotBasicDto spotBasicDto) {

        Spot spot = new Spot();

        SpotBasicDto retDto = new SpotBasicDto();

        spot = modelMapper.map(spotBasicDto, spot.getClass());

        spotRepository.save(spot);

        return retDto;
    }

    public String getSpotByTitle(String title, Pageable pageable) {

        // Google API 주소 설정
        String url = googleAPI.findPlaceFromText(title);

        // HTTP 요청
        OkHttpClient client = new OkHttpClient().newBuilder()
                .build();
        MediaType mediaType = MediaType.parse("text/plain");
        RequestBody body = RequestBody.create(mediaType, "Museum");
        Request request = new Request.Builder()
                .url(url)
//                .method("GET", body)
                .build();
        try(Response response = client.newCall(request).execute()) {
            System.out.println(response);
            System.out.println(response.body().string());
            return response.body().string();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public String getSpotSearch(String query, Pageable pageable) {

        // Google API 주소 설정
        String url = googleAPI.textSearch(query);

        // HTTP 요청
        OkHttpClient client = new OkHttpClient().newBuilder()
                .build();
        MediaType mediaType = MediaType.parse("text/plain");
        RequestBody body = RequestBody.create(mediaType, "Museum");
        Request request = new Request.Builder()
                .url(url)
//                .method("GET", body)
                .build();
        try(Response response = client.newCall(request).execute()) {
            System.out.println(response);
            System.out.println(response.body().string());

            return response.body().string();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public List<SpotBasicDto> getSpotByTag(String tag, Pageable pageable) {

        List<SpotBasicDto> spotBasicDtos = new ArrayList<>();

        return spotBasicDtos;
    }
}
