package top.zsh2401.recyclerviewtest;

/**8
 * Created by zsh2401 on 2017/6/3.
 */

public class Fruit {
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
    public void setName(String name){
        this.name = name;
    }
}
