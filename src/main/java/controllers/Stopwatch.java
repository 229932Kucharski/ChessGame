package controllers;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import static java.lang.StrictMath.abs;

public class Stopwatch implements ActionListener {

    JFrame frame = new JFrame();
    JButton startButton = new JButton("START");
    JButton resetButton = new JButton("RESET");
    JLabel timeLabel = new JLabel();

    int Time = 1;
    int Increment = 0;
    int elapsedTime = 0;
    int seconds = 0;
    int minutes = 0;
    int hours = 0;
    boolean started = false;
    String seconds_string = String.format("%02d", seconds);
    String minutes_string = String.format("%02d", minutes);
    String hours_string = String.format("%02d", hours);

    Timer timer = new Timer(100, new ActionListener() {

        public void actionPerformed(ActionEvent e) {
            elapsedTime = elapsedTime + 1000;
            hours = (elapsedTime / 3600000);
            minutes = (getTime()-1-elapsedTime / 60000) % 60;
                if(minutes < 0){
                    reset();
                }
            seconds = (abs(59-((elapsedTime / 1000)) % 60));
            seconds_string = String.format("%02d", seconds);
            minutes_string = String.format("%02d", minutes);
            hours_string = String.format("%02d", hours);
            timeLabel.setText(hours_string + ":" + minutes_string + ":" + seconds_string);
        }
    });

    Stopwatch() {
        timeLabel.setText(hours_string + ":" + minutes_string + ":" + seconds_string);
        timeLabel.setBounds(100, 100, 200, 100);
        timeLabel.setFont(new Font("Verdana", Font.PLAIN, 35));
        timeLabel.setBorder(BorderFactory.createBevelBorder(1));
        timeLabel.setOpaque(true);
        timeLabel.setHorizontalAlignment(JTextField.CENTER);

        startButton.setBounds(100, 200, 100, 50);
        startButton.setFont(new Font("Ink Free", Font.PLAIN, 20));
        startButton.setFocusable(false);
        startButton.addActionListener(this);

        resetButton.setBounds(200, 200, 100, 50);
        resetButton.setFont(new Font("Ink Free", Font.PLAIN, 20));
        resetButton.setFocusable(false);
        resetButton.addActionListener(this);

        frame.add(startButton);
        frame.add(resetButton);
        frame.add(timeLabel);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(420, 420);
        frame.setLayout(null);
        frame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == startButton) {

            if (!started) {
                started = true;
                startButton.setText("INC");
                start();
            } else {
                started = false;
                startButton.setText("START");
                stop();
            }
        }
        if (e.getSource() == resetButton) {
            started = false;
            startButton.setText("START");
            reset();
        }
    }

    void start() {
        timer.start();
    }

    void stop() {

        elapsedTime = elapsedTime-getIncrement()*1000;

    }

    void reset() {
        timer.stop();
        elapsedTime = 0;
        seconds = 0;
        minutes = 0;
        hours = 0;
        seconds_string = String.format("%02d", seconds);
        minutes_string = String.format("%02d", minutes);
        hours_string = String.format("%02d", hours);
        timeLabel.setText(hours_string + ":" + minutes_string + ":" + seconds_string);
    }

    public void setTime(int time) {
        Time = time;
    }
    public void setIncrement(int increment) {
        Increment = increment;
    }
    public int getTime() {
        return Time;
    }

    public int getIncrement() {
        return Increment;
    }
//
//    public static void main(String[] args) { Stopwatch sp = new Stopwatch(); }

}