package com.example.landmarkbook;

public class singleton {
    private Landmark sentLandmark;
    private static singleton singleton;
    private singleton(){
    }
    public Landmark getSentLandmark(){
        return sentLandmark;
    }
    public void setSentLandmark(Landmark sentLandmark){
        this.sentLandmark = sentLandmark;
    }
}
