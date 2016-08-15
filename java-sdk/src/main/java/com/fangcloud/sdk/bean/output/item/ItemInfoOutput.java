package com.fangcloud.sdk.bean.output.item;

import com.fangcloud.sdk.bean.output.BaseOutput;
import com.fangcloud.sdk.bean.output.elements.MiniUser;
import com.fangcloud.sdk.bean.output.elements.PathFolder;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ItemInfoOutput extends BaseOutput {
    private String type;
    private long id;
    private String name;
    private long size;
    @SerializedName("created_at")
    private long createdAt;
    @SerializedName("modified_at")
    private long modifiedAt;
    private String description;
    private List<PathFolder> path;
    @SerializedName("owned_by")
    private MiniUser ownedBy;
    private boolean shared;
    private PathFolder parent;
    private List<String> permissions;
    @SerializedName("sequence_id")
    private long sequenceId;
    @SerializedName("in_trash")
    private boolean inTrash;
    @SerializedName("is_deleted")
    private boolean isDeleted;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getSize() {
        return size;
    }

    public void setSize(long size) {
        this.size = size;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<String> getPermissions() {
        return permissions;
    }

    public void setPermissions(List<String> permissions) {
        this.permissions = permissions;
    }

    public List<PathFolder> getPath() {
        return path;
    }

    public void setPath(List<PathFolder> path) {
        this.path = path;
    }

    public PathFolder getParent() {
        return parent;
    }

    public long getSequenceId() {
        return sequenceId;
    }

    public void setSequenceId(long sequenceId) {
        this.sequenceId = sequenceId;
    }

    public boolean isInTrash() {
        return inTrash;
    }

    public void setInTrash(boolean inTrash) {
        this.inTrash = inTrash;
    }

    public boolean isDeleted() {
        return isDeleted;
    }

    public void setDeleted(boolean deleted) {
        isDeleted = deleted;
    }

    public long getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(long createdAt) {
        this.createdAt = createdAt;
    }

    public long getModifiedAt() {
        return modifiedAt;
    }

    public void setModifiedAt(long modifiedAt) {
        this.modifiedAt = modifiedAt;
    }

    public MiniUser getOwnedBy() {
        return ownedBy;
    }
    //public MiniUser getModifiedBy() {
    //    return modifiedBy;
    //}
    //
    //public void setModifiedBy(MiniUser modifiedBy) {
    //    if (modifiedBy != null) {
    //        this.modifiedBy = modifiedBy;
    //    }
    //}
    //
    //public MiniUser getCreatedBy() {
    //    return createdBy;
    //}
    //
    //public void setCreatedBy(MiniUser createdBy) {
    //    if (createdBy != null) {
    //        this.createdBy = createdBy;
    //    }
    //}

    public boolean getShared() {
        return shared;
    }

    public void setShared(boolean shared) {
        this.shared = shared;
    }
}
