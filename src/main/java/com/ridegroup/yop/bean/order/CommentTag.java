package com.ridegroup.yop.bean.order;

/**
 * "comment_tag_id":1,"conflict_tag_id":2,"tag_text":准时到达,"type":1,"rank":1
 *
 * comment_tag_id: 1,
     conflict_tag_id: 0,
     tag_text: "准时到达",
     type: 1,
     rank: 18
 */
public class CommentTag {
    private int comment_tag_id;
    private int conflict_tag_id;
    private String tag_text;
    private int type;
    private int rank;

    public int getComment_tag_id() {
        return comment_tag_id;
    }

    public void setComment_tag_id(int comment_tag_id) {
        this.comment_tag_id = comment_tag_id;
    }

    public int getConflict_tag_id() {
        return conflict_tag_id;
    }

    public void setConflict_tag_id(int conflict_tag_id) {
        this.conflict_tag_id = conflict_tag_id;
    }

    public String getTag_text() {
        return tag_text;
    }

    public void setTag_text(String tag_text) {
        this.tag_text = tag_text;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public int getRank() {
        return rank;
    }

    public void setRank(int rank) {
        this.rank = rank;
    }
}
