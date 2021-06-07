package controllers;


import javafx.application.Platform;
import javafx.scene.control.Label;
import player.manager.LoginManager;

import java.io.IOException;

import static controllers.GameController.move_counter;
import static java.lang.StrictMath.abs;

public class ThreadStopwatch extends Thread{

    int Time = 0;
    int Increment = 0;
    int elapsedTime = 0;
    int seconds = 0;
    int minutes = 0;
    int hours = 0;
    boolean exit = false;


   public Label timelabel;
   public GameController gameController;

//    String seconds_string = String.format("%02d", seconds);
//    String minutes_string = String.format("%02d", minutes);
//    String hours_string = String.format("%02d", hours);

    public int getTime() { return Time; }
    public void setTime(int time) { Time = time; }
    public int getIncrement() { return Increment; }
    public void setIncrement(int increment) { Increment = increment; }

    public GameController getGameController() {
        return gameController;
    }

    public void setGameController(GameController gameController) {
        this.gameController = gameController;
    }

    public int getElapsedTime() { return elapsedTime; }
    public void setElapsedTime(int elapsedTime) { this.elapsedTime = elapsedTime; }

//    public int getSeconds() {return seconds; }
//    public int getMinutes() {return minutes; }
//    public int getHours() {return hours; }
//
//    public String getSeconds_string() { return seconds_string; }
//    public String getMinutes_string() { return minutes_string; }
//    public String getHours_string() { return hours_string; }

    public void run() {
        while (!exit) {
            try {
                sleep(1000);
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
            String seconds_string = String.format("%02d", seconds);
            String minutes_string = String.format("%02d", minutes);
            //System.out.println(hours+ ":"+ minutes + ":" + seconds);

            Platform.runLater(new Runnable(){
                @Override
                public void run() {
                    timelabel.setText(minutes_string + ":" + seconds_string);
                }
            });
            if (hours == 0 && minutes == 0 && seconds == 0){
                exit = true;

                if(LoginManager.getLoggedUser() != null) {
                    if(move_counter %2 == 0) {
                        LoginManager.getLoggedUser().getStatistic().setCheckMate(LoginManager.getLoggedUser().getStatistic().getCheckMate() + 1);
                    }
                    else {
                        LoginManager.getLoggedUser().getStatistic().setLoses(LoginManager.getLoggedUser().getStatistic().getLoses() + 1);
                    }
                    LoginManager.updateLoggedUser();
                }

                Platform.runLater(new Runnable(){
                    @Override
                    public void run() {
                        try {
                            gameController.winOpen();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                });

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

    public void setNot(){
            this.setElapsedTime(this.getElapsedTime() - this.getIncrement());
            this.suspend();
    }

    public void setYes(){
            this.resume();
    }

    public void setZero(){
        this.setTime(0);
        this.setElapsedTime(0);
    }
}
