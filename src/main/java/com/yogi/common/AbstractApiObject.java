package com.yogi.common;

import org.springframework.http.*;
import org.springframework.web.client.DefaultResponseErrorHandler;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static java.util.Collections.singletonList;

/**
 * Reusable methods for all API objects
 */
public abstract class AbstractApiObject {
    protected String baseUrl;
    protected RestTemplate restTemplate;

    protected AbstractApiObject(final String baseUrl, final RestTemplate restTemplate) {
        this.baseUrl = baseUrl;
        this.restTemplate = restTemplate;

        restTemplate.setErrorHandler(new DefaultResponseErrorHandler() {
//            @Override
//            public boolean hasError(final ClientHttpResponse clientHttpResponse) throws IOException {
//                return true;
//            }
        });
    }

    public ResponseEntity<String> httpRequest(final HttpMethod method, final String url) {
        return httpRequest(method, url, "", new HashMap<>(), null);
    }

    public ResponseEntity<String> httpRequest(final HttpMethod method, final String url, final String body) {
        return httpRequest(method, url, body, new HashMap<>(), null);
    }

    public ResponseEntity<String> httpRequest(final HttpMethod method, final String url, final HashMap<String, List<String>> headers) {
        return httpRequest(method, url, "", new HashMap<>(), headers);
    }

    public ResponseEntity<String> httpRequest(final HttpMethod method, final String url, final String body, final HashMap<String, List<String>> headers) {
        return httpRequest(method, url, body, new HashMap<>(), headers);
    }

    public ResponseEntity<String> httpRequest(final HttpMethod method, final String url, final Map<String, Object> uriVariables) {
        return httpRequest(method, url, "", uriVariables, null);
    }

    private ResponseEntity<String> httpRequest(final HttpMethod method, final String url, final String body, final Map<String, Object> uriVariables, final HashMap<String, List<String>> h) {

        final HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.setAccept(singletonList(MediaType.APPLICATION_JSON));
        if (h != null) {
            headers.putAll(h);
        }
        final HttpEntity<String> entity = new HttpEntity<>(body, headers);

        return restTemplate.exchange(url, method, entity, String.class, uriVariables);
    }

    protected HttpHeaders getJsonHeaders() {
        final HttpHeaders headers = new HttpHeaders();
        headers.put(HttpHeaders.CONTENT_TYPE, singletonList("application/json"));
        headers.put("Accepts", singletonList("application/json"));
        return headers;
    }


    HttpHeaders getOAuthHeaders(final String oAuthToken) {
        final HttpHeaders headers = new HttpHeaders();
        headers.add(HttpHeaders.CONTENT_TYPE, "application/json");
        headers.add(HttpHeaders.AUTHORIZATION, createOAuthHeader(oAuthToken));
        return headers;
    }


    String createOAuthHeader(final String oAuthToken) {
        return String.format("Bearer %s", oAuthToken);
    }

    RequestEntity<Void> getOAuthRequestEntity(final HttpMethod httpMethod, final URI uri, final String oAuthToken) {
        return RequestEntity.method(httpMethod, uri)
                .header(HttpHeaders.AUTHORIZATION, createOAuthHeader(oAuthToken))
                .build();
    }


}