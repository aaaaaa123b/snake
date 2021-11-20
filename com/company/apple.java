package com.company;


public class apple {
    public int posX;
    public int posY;

    public apple(int x, int y){
        posX= x;
        posY= y;
    }
    public void setRandomPosition(){
        posX =Math.abs ((int) (Math.random()*GameFrame.WIDTH-1));
        posY =Math.abs ((int) (Math.random()*GameFrame.HEIGHT-1));
    }
}

