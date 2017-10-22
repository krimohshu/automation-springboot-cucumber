package com.yogi.common;

import com.yogi.dto.FileInfoDto;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.io.File;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

public class FileScannerApi extends AbstractApiObject {

    public FileScannerApi(String baseUrl, RestTemplate restTemplate) {
        super(baseUrl, restTemplate);
    }

    public Optional<FileInfoDto> getFile(String datasource,String  filename){
        System.setProperty("proxyPort", "8186");
        //localhost:8186/v1/api/scanfilesByMimetypes

       // --->>>>  "v1/api/scanfilesByMimetypes" + ?supportedFileTypes=xxx&directoryPath=yyy
        ResponseEntity<Set<FileInfoDto>> fileScanResponse =
                restTemplate.exchange(baseUrl + "v1/api/scanfilesByMimetypes",
                        HttpMethod.GET, null, new ParameterizedTypeReference<Set<FileInfoDto>>() {
                        });
        Set<FileInfoDto> sites = fileScanResponse.getBody();
       // sites.stream().map(t-> t.equalsIgnoreCase(filename)).collect(Collectors.toList());

      Optional<FileInfoDto> file  = sites.stream().filter(t-> t.getFileName().equalsIgnoreCase(datasource)).findFirst();

        return file;

    }
}
