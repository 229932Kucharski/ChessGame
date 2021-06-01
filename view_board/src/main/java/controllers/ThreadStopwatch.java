package controllers;


import javafx.application.Platform;
import javafx.scene.control.Label;
import player.manager.LoginManager;

import static java.lang.StrictMath.abs;

public class ThreadStopwatch extends Thread{

    int Time = 0;
    int Increment = 0;
    int elapsedTime = 0;
    int seconds = 0;
    int minutes = 0;
    int hours = 0;


   public Label timelabel;

    String seconds_string = String.format("%02d", seconds);
    String minutes_string = String.format("%02d", minutes);
    String hours_string = String.format("%02d", hours);

    public int getTime() { return Time; }
    public void setTime(int time) { Time = time; }
    public int getIncrement() { return Increment; }
    public void setIncrement(int increment) { Increment = increment; }

    public int getElapsedTime() { return elapsedTime; }
    public void setElapsedTime(int elapsedTime) { this.elapsedTime = elapsedTime; }


    public int getSeconds() {return seconds; }
    public int getMinutes() {return minutes; }
    public int getHours() {return hours; }

    public String getSeconds_string() { return seconds_string; }
    public String getMinutes_string() { return minutes_string; }
    public String getHours_string() { return hours_string; }

    public void run() {
        while (true) {
            try {
                this.sleep(1000);
            } catch(InterruptedException exc) {
                System.out.println("Wątek zliczania czasu zoostał przerwany.");
                return;
            }

            elapsedTime++;
            hours   = abs((0));
            minutes = abs((getTime()-1 - (elapsedTime / 60)) % 60);
            seconds = (abs(59 - elapsedTime%60));
            if(seconds >=60){
                minutes++;
                seconds = seconds%60;
            }
            //System.out.println(hours+ ":"+ minutes + ":" + seconds);

            Platform.runLater(new Runnable(){
                @Override
                public void run() {
                    timelabel.setText(minutes + ":" + seconds);
                }
            });
            if (hours == 0 && minutes == 0 && seconds == 0){

                if(LoginManager.getLoggedUser() != null) {
                    LoginManager.getLoggedUser().getStatistic().setLoses(LoginManager.getLoggedUser().getStatistic().getLoses() + 1);
                    LoginManager.updateLoggedUser();
                }

                return;
            }
        }
    }

// public static void main(String[] args) {
//        ThreadStopwatch ts = new ThreadStopwatch();
//        ts.start();
//    }

    public void setLabel(Label lab){
        timelabel = lab;
    }

    public void setNot(ThreadStopwatch ts){
            setElapsedTime(getElapsedTime() - getIncrement());
            ts.suspend();
    }

    public void setYes(ThreadStopwatch ts){
            ts.resume();
    }

}