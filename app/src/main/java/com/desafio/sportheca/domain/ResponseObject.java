package com.desafio.sportheca.domain;

import java.util.List;

public class ResponseObject {
    private String Status;
    private List<InfoPlayer> Object;

    public String getStatus() {
        return Status;
    }

    public void setStatus(String status) {
        Status = status;
    }

    public List<InfoPlayer> getObject() {
        return Object;
    }

    public void setObject(List<InfoPlayer> object) {
        Object = object;
    }
}
