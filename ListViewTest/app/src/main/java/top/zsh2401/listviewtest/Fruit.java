package top.zsh2401.listviewtest;

/**
 * Created by zsh2401 on 2017/6/3.
 */

public class Fruit {
    /*水果类,用来存水果的信息*/
    private String name;
    private int imageId;
    public Fruit(String name,int imageId){
        this.name = name;
        this.imageId = imageId;
    }
    public String getName(){
        return name;
    }
    public int getImageId(){
        return imageId;
    }
}
