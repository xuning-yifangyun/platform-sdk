package com.fangcloud.sdk.bean.output.review;

import com.fangcloud.sdk.bean.output.BaseOutput;
import com.fangcloud.sdk.bean.output.elements.MiniReview;
import com.fangcloud.sdk.bean.output.elements.MiniUser;
import com.google.gson.annotations.SerializedName;

public class CreateReviewCommentOutput extends BaseOutput {
    private long id;
    private String content;
    private MiniReview review;
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
    private MiniUser user;


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public MiniReview getReview() {
        return review;
    }

    public void setReview(MiniReview review) {
        this.review = review;
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

    public MiniUser getUser() {
        return user;
    }

    public void setUser(MiniUser user) {
        this.user = user;
    }
}
