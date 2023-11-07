package com.moringaschool.student.response;

import com.fasterxml.jackson.annotation.JsonProperty;
/**
 *
 * @author egateri@gmail.com
 *
 *
 */

public class Response {
    @JsonProperty("header")
    private Header header;
    @JsonProperty("body")
    private Object bodyObject;

    public Response() {
        this.header = new Header();
    }

    public Header getHeader() {
        return header;
    }

    public void setHeader(Header header) {
        this.header = header;
    }

    public Object getBodyObject() {
        return bodyObject;
    }

    public void setBodyObject(Object bodyObject) {
        this.bodyObject = bodyObject;
    }
}
