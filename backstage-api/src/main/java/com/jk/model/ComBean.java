package com.jk.model;

import java.io.Serializable;

public class ComBean implements Serializable {
    private static final long serialVersionUID = 6223838168314795590L;
    private Integer commentId;
    private Integer commentNumber;
    private String   commentInfo;

    public Integer getCommentId() {
        return commentId;
    }

    public void setCommentId(Integer commentId) {
        this.commentId = commentId;
    }

    public Integer getCommentNumber() {
        return commentNumber;
    }

    public void setCommentNumber(Integer commentNumber) {
        this.commentNumber = commentNumber;
    }

    public String getCommentInfo() {
        return commentInfo;
    }

    public void setCommentInfo(String commentInfo) {
        this.commentInfo = commentInfo;
    }
}
