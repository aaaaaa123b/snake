package com.company;

public class ssnake {
    public int lenght =2;
    public int direction =2;
    public int sX[]= new int[300];

    public int sY[]= new int[300];


    public ssnake(int x1, int y1, int x2, int y2){
        sX[0]=x1;
        sX[1]=x2;
        sX[0]=y1;
        sX[1]=y1;


    }
public void move(){
        for(int l=lenght;l>0;l--) {
            sX[l]=sX[l-1];
            sY[l]=sY[l-1];

        }
        //up
        if(direction==0) sY[0]--;
        //down
    if(direction==2) sY[0]++;
            //right
    if(direction==1) sX[0]++;
                //left
    if(direction==3) sX[0]--;


// возвращает змейку на поле
    if(sY[0]> GameFrame.WIDTH -1) sY[0]=0;
    if(sY[0] <0) sY[0]= GameFrame.HEIGHT -1;
    if(sX[0]> GameFrame.WIDTH -1) sX[0]=0;
    if(sX[0] <0) sX[0]= GameFrame.WIDTH -1;




}
}
