package app.exceptions;

public class Message {

    private Integer status;
    private String txt;
    private Object data;

    public Message(Integer status, String txt){
        this.status = status;
        this.txt = txt;
    }

    public void setStatus(Integer status){
        this.status = status;
    }
    public void setTxt(String txt){
        this.txt = txt;
    }
    public void setData(Object data){
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
