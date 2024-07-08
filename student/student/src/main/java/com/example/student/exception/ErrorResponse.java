 package com.example.student.exception;

public class ErrorResponse {
    private int status;
    private String messsage;
    private long timesStamp;

    public ErrorResponse(int status, String messsage) {
        this.status = status;
        this.messsage = messsage;
        this.timesStamp = System.currentTimeMillis();
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getMesssage() {
        return messsage;
    }

    public void setMesssage(String messsage) {
        this.messsage = messsage;
    }

    public long getTimesStamp() {
        return timesStamp;
    }

    public void setTimesStamp(long timesStamp) {
        this.timesStamp = timesStamp;
    }

}
