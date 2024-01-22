package com.example.sedes.OpenAI.DTO;import java.util.ArrayList;import java.util.List;import lombok.Data;import org.springframework.http.HttpEntity;import org.springframework.http.HttpHeaders;import org.springframework.http.MediaType;@Datapublic class ChatRequest {    private String model;    private List<Message> messages;    public HttpEntity<ChatRequest> makeRequest(String model, String api_key,  String role, String message) {        HttpHeaders headers = new HttpHeaders();        headers.setContentType(MediaType.APPLICATION_JSON);        headers.setBearerAuth(api_key);        ChatRequest requestBody = new ChatRequest();        requestBody.setModel(model);        List<Message> messages = new ArrayList<>();        Message messageDTO = new Message();        messageDTO.setRole(role);        messageDTO.setContent(message);        messages.add(messageDTO);        requestBody.setMessages(messages);        HttpEntity<ChatRequest> entity = new HttpEntity<>(requestBody, headers);        return entity;    }    public String makeGeneRequest(String sentence) {        String generalContent = sentence;        return generalContent;    }    public String makeTranRequest(String koreanSentence) {        String transContent = "\"" + koreanSentence + "\" Translate this sentence into Korean.";        return transContent;    }    public String makeEvalRequest(String koreanSentence, String engSentence) {        String evalContent =  "\" S1: " + koreanSentence + "\", \" S2:" + engSentence + "\" Please evaluate the result of translating S1 into S2.";        return evalContent;    }}