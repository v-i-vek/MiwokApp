package com.example.android.miwok;

public class word {

    private String mMiwokTranslation;
    private String mdefaultTranslation;
    private int mImageResource = No_ImageProvided;
    private static final int No_ImageProvided = -1;

    private int mAudioResource;

    public  word(String MiwokTranslation , String defaultTranslation,int AudioResource){

        mdefaultTranslation = defaultTranslation;
        mMiwokTranslation = MiwokTranslation;
        mAudioResource = AudioResource;
    }
    public  word(String MiwokTranslation , String defaultTranslation, int imageResource,int AudioResource){

        mdefaultTranslation = defaultTranslation;
        mMiwokTranslation = MiwokTranslation;
        mImageResource = imageResource;
        mAudioResource = AudioResource;
    }

    public String getMiwokTranslation(){

        return mMiwokTranslation;
    }
    public String getDefaultTranslation(){
        return mdefaultTranslation;
    }
    public int getImageResource(){
        return mImageResource;
    }
    public boolean hasImage(){
        return mImageResource != No_ImageProvided;
    }
    public int getAudioResource(){
        return mAudioResource;
    }
}


