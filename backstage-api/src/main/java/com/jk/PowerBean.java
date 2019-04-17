package com.jk;

import java.util.List;

public class PowerBean {
    private Integer id;
    private String text;
    private String url;
    private String href;
    private Integer pid;
    private Boolean selectable;
    private List<PowerBean> nodes;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getHref() {
        return href;
    }

    public void setHref(String href) {
        this.href = href;
    }

    public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
    }

    public Boolean getSelectable() {
        return selectable;
    }

    public void setSelectable(Boolean selectable) {
        this.selectable = selectable;
    }

    public List<PowerBean> getNodes() {
        return nodes;
    }

    public void setNodes(List<PowerBean> nodes) {
        this.nodes = nodes;
    }

    @Override
    public String toString() {
        return "PowerBean{" +
                "id=" + id +
                ", text='" + text + '\'' +
                ", url='" + url + '\'' +
                ", href='" + href + '\'' +
                ", pid=" + pid +
                ", selectable=" + selectable +
                ", nodes=" + nodes +
                '}';
    }
}