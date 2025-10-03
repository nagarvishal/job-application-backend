package app.exceptions;

public class Message <T> {

    private Integer status;
    private String txt;
    private T data;

    public Message(Integer status, String txt){
        this.status = status;
        this.txt = txt;
    }

    public Message(Integer status, String txt, T Data){
        this.status = status;
        this.txt = txt;
        this.data = Data;
    }

    public void setStatus(Integer status){
        this.status = status;
    }
    public void setTxt(String txt){
        this.txt = txt;
    }
    public void setData(T data){
        this.data = data;
    }

    public Integer getStatus(){
        return this.status;
    }
    public String getTxt(){
        return this.txt;
    }

    public Object getData(){
        return this.data;
    }

}
