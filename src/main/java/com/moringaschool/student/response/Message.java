package com.moringaschool.student.response;

import java.sql.Timestamp;

/**
 *
 * @author egateri@gmail.com
 *
 *
 */

public class Message extends Response {

    public static Response response(String requestRefId, int responseCode, String responseStatus, String responseMessage, Object bodyResponseObject){
        Message response = new Message();
        response.getHeader().setRequestRefId(requestRefId);
        response.getHeader().setResponseCode(responseCode);
        response.getHeader().setResponseStatus(responseStatus);
        response.getHeader().setResponseMessage(responseMessage);
        response.getHeader().setTimestamp(new Timestamp(System.currentTimeMillis()).toString());
        if(bodyResponseObject!=null){
            response.setBodyObject(bodyResponseObject);
        }
        return response;

    }

}
