package com.fangcloud.sdk.bean.input.collab;

import com.fangcloud.sdk.bean.input.BaseApiBean;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class UpdateCollabBean extends BaseApiBean {
    @SerializedName("collabs_roles")
    private List<CollabIdAndRole> collabsRoles;

    public UpdateCollabBean(List<CollabIdAndRole> collabsRoles) {
        this.collabsRoles = collabsRoles;
    }

    public List<CollabIdAndRole> getCollabsRoles() {
        return collabsRoles;
    }

    public void setCollabsRoles(List<CollabIdAndRole> collabsRoles) {
        this.collabsRoles = collabsRoles;
    }

    public static class CollabIdAndRole {
        @SerializedName("collab_id")
        private long collabId;
        private String role;

        public long getCollabId() {
            return collabId;
        }

        public void setCollabId(long collabId) {
            this.collabId = collabId;
        }

        public String getRole() {
            return role;
        }

        public void setRole(String role) {
            this.role = role;
        }
    }

}
