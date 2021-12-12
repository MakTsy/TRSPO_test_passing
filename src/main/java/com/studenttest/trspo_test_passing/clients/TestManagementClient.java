package com.studenttest.trspo_test_passing.clients;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.studenttest.trspo_test_passing.api.dto.Test;

public class TestManagementClient {

    private TestManagementClient() {}

    private static final String TEST_MANAGEMENT_SERVICE_URL_ADRESS ="http://service-test-management:8082/tests";

    public static Test getTestById(Long testId) {
        final RestTemplate restTemplate = new RestTemplate();
        final HttpEntity<Long> userRequest = new HttpEntity<>(testId);

        final ResponseEntity<Test> testResponse = restTemplate
                .exchange(TEST_MANAGEMENT_SERVICE_URL_ADRESS + "/" + testId,
                        HttpMethod.GET, userRequest, Test.class);

        return testResponse.getBody();
    }
}
