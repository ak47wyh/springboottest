package com.example.demo.service;

/**
 * Created by Administrator on 2017/6/5.
 */
public class WsResponse {

    private String responseMessage;

    public WsResponse(String responseMessage) {
        this.responseMessage = responseMessage;
    }

    public String getResponseMessage() {
        return responseMessage;
    }

    public void setResponseMessage(String responseMessage) {
        this.responseMessage = responseMessage;
    }
}
