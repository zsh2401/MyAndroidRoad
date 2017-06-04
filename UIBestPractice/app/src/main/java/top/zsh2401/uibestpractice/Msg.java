package top.zsh2401.uibestpractice;

/**
 * Created by zsh2401 on 2017/6/4.
 */

public class Msg {
    /*
    * 信息类,用来存储信息的
    * */
    public static final int TYPE_RECEIVED = 0;
    public static final int TYPE_SENT = 1;
    private String content;
    private int type;
    public Msg(String content,int type){
        this.content = content;
        this.type = type;
    }
    public String getContent(){
        return content;
    }
    public int getType(){
        return type;
    }
}
