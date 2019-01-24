/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pk;

import java.applet.Applet;
import java.awt.Graphics;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author user
 */
public class Ball extends Applet implements Runnable {

    int x, y;
    int flag = 1;
    int flag2 = 1;

    /**
     * Initialization method that will be called after the applet is loaded into
     * the browser.
     */
    @Override
    public void init() {
        Thread t = new Thread(this);
        t.start();
        // TODO start asynchronous download of heavy resources
    }

    @Override
    public void paint(Graphics g) {

        g.fillOval(x, y, 20, 20);

    }

    public void update() {
        if (x == getWidth()) {
            flag = -1;
        }

        if (x == -1) {
            flag = 1;
        }

        if (flag == -1) {
            x--;
        } else {
            x++;
        }

        if (y == getHeight()) {
            flag2 = -1;

        }

        if (y == -1) {
            flag2 = 1;
        }

        if (flag2 == -1) {
            y--;
        } else {
            y++;
        }

    }

    @Override

    public void run() {
        while (true) {
            repaint();

            update();

            try {
                Thread.sleep(1);
            } catch (InterruptedException ex) {
                Logger.getLogger(Ball.class.getName()).log(Level.SEVERE, null, ex);
            }

        }

    }
}
