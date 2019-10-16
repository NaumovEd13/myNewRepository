package com.company;

public class ObjectOfGame {
    private boolean alive;

    public ObjectOfGame(boolean alive){
        this.alive=alive;
    }
    public boolean getAlive(){
        return this.alive;
    }
    public void setAlive(boolean alive){
        this.alive=alive;
    }
    @Override
    public String toString(){
        if(alive==true){
            return "*";
        }
        else{
            return ".";
        }
    }
    @Override
    public boolean equals(Object obj){
        if(obj==null)
            return false;
        if(obj instanceof ObjectOfGame) {
            ObjectOfGame objectOfGame=(ObjectOfGame)obj;
            if(this.getAlive()==objectOfGame.getAlive()){
                return true;
            }
            else{
                return false;
            }
        }
        else return false;
    }
}