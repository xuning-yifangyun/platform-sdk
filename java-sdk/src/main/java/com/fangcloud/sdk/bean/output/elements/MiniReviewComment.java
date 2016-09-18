package com.fangcloud.sdk.bean.output.elements;

import com.google.gson.annotations.SerializedName;

public class MiniReviewComment {
    private long id;
    private MiniReview review;
    private MiniUser user;
    private String content;
    @SerializedName("created_at")
    private long created;
    @SerializedName("is_voice")
    private boolean isVoice;
    @SerializedName("voice_length")
    private long voiceLength;
    @SerializedName("voice_storage_path_mp3")
    private String voiceStoragePathMp3;
    @SerializedName("voice_storage_path_ogg")
    private String voiceStoragePathOgg;


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public MiniReview getReview() {
        return review;
    }

    public void setReview(MiniReview review) {
        this.review = review;
    }

    public MiniUser getUser() {
        return user;
    }

    public void setUser(MiniUser user) {
        this.user = user;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public long getCreated() {
        return created;
    }

    public void setCreated(long created) {
        this.created = created;
    }

    public boolean isVoice() {
        return isVoice;
    }

    public void setVoice(boolean voice) {
        isVoice = voice;
    }

    public long getVoiceLength() {
        return voiceLength;
    }

    public void setVoiceLength(long voiceLength) {
        this.voiceLength = voiceLength;
    }

    public String getVoiceStoragePathMp3() {
        return voiceStoragePathMp3;
    }

    public void setVoiceStoragePathMp3(String voiceStoragePathMp3) {
        this.voiceStoragePathMp3 = voiceStoragePathMp3;
    }

    public String getVoiceStoragePathOgg() {
        return voiceStoragePathOgg;
    }

    public void setVoiceStoragePathOgg(String voiceStoragePathOgg) {
        this.voiceStoragePathOgg = voiceStoragePathOgg;
    }
}
