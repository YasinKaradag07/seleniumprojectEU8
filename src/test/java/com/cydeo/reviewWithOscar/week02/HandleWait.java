package com.cydeo.reviewWithOscar.week02;

public class HandleWait {

    public static void staticWait(int seconds){
        try{
            Thread.sleep(seconds*1000);
        }catch(Exception e){

        }
    }
}
