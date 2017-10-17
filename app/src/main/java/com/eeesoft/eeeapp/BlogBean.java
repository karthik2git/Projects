package com.eeesoft.eeeapp;

/**
 * Created by Karthik on 5/31/2016.
 */
public class BlogBean {

    private String title;

    private String content;

    private String url;

    public  BlogBean(){

    }


    public BlogBean(String title, String content, String url) {
        this.title = title;
        this.content = content;
        this.url = url;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

   public String getUrl() {
       return url;
   }

    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        BlogBean blogBean = (BlogBean) o;

        if (title != null ? !title.equals(blogBean.title) : blogBean.title != null) return false;
        if (content != null ? !content.equals(blogBean.content) : blogBean.content != null)
           return false;
        return !(url != null ? !url.equals(blogBean.url) : blogBean.url != null);

    }

    @Override
    public int hashCode() {
        int result = title != null ? title.hashCode() : 0;
        result = 31 * result + (content != null ? content.hashCode() : 0);
        result = 31 * result + (url != null ? url.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "BlogBean{" +
                "title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", url='" + url + '\'' +
                '}';
    }
}
