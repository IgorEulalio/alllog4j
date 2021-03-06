package com.fulllog.alllog4j;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpRequest;
import org.springframework.http.client.ClientHttpRequestExecution;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.http.client.ClientHttpResponse;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class AllLog4jInterceptor implements ClientHttpRequestInterceptor {

    private static final ObjectMapper mapper = new ObjectMapper();

    private static final Logger logger = LoggerFactory.getLogger("HttpLogger");

    @Override
    public ClientHttpResponse intercept(HttpRequest request, byte[] body, ClientHttpRequestExecution execution) throws IOException {
        ObjectNode objectRequest = traceRequest(request, body);
        ClientHttpResponse response = execution.execute(request, body);
        ObjectNode objectResponse = traceResponse(response);

//      requestsAndResponses.put(objectRequest.get("uri").toPrettyString(), Arrays.asList(objectRequest, objectResponse));

      logger.info("{\"Request\":{},\"Response\":{}}", objectRequest, objectResponse);
        return response;
    }

    public ObjectNode traceRequest(HttpRequest request, byte[] body) throws IOException {
        ObjectNode rootNode = mapper.createObjectNode();
        rootNode.put("uri", String.valueOf(request.getURI()));
        rootNode.put("method", String.valueOf(request.getMethod()));
        rootNode.set("headers", mapper.valueToTree(String.valueOf(request.getHeaders())));
        rootNode.put("body", new String(body, "UTF-8"));

        return rootNode;
    }

    public ObjectNode traceResponse(ClientHttpResponse response) throws IOException {
        StringBuilder inputStringBuilder = new StringBuilder();
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(response.getBody(), "UTF-8"));
        String line = bufferedReader.readLine();
        while (line != null) {
            inputStringBuilder.append(line);
            inputStringBuilder.append('\n');
            line = bufferedReader.readLine();
        }

        ObjectNode rootNode = mapper.createObjectNode();
        rootNode.put("status", String.valueOf(response.getStatusCode()));
        rootNode.put("status_text", String.valueOf(response.getStatusText()));
        rootNode.set("headers", mapper.valueToTree(String.valueOf(response.getHeaders())));
        rootNode.put("body", new String(inputStringBuilder.toString()));

        return rootNode;
    }
}
