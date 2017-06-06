/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package applets;

import java.awt.*;
import java.applet.*;

/**
 *
 * @author Ryan Cabanas
 */
public class Resize extends Applet implements Runnable {
  Thread thread;
  Dimension dimension;
  
  /**
   * Initialization method that will be called after the applet is loaded into the browser.
   */
  @Override
  public void init() {
    thread = new Thread(this);
  }

  @Override
  public void start() {
    thread.start();
  }
  
  @Override
  public void run() {
    try {
      for (int i = 0; i < 5; i++) {
        if (i == 0) {
          dimension = getSize();          
        } else {
          dimension.height = (int) (dimension.height * 1.25); 
          dimension.width = (int) (dimension.width * 1.25);
        }
        repaint();
        Thread.sleep(3000);
      }
    } catch (Exception e) {
    }
    thread = null;
  }

  @Override
  public void paint(Graphics g) {
    resize(dimension);
    g.drawString("Applet width is : " + dimension.width, 10, 20);
    g.drawString("Applet height is : " + dimension.height, 10, 40);
  }
  // TODO overwrite start(), stop() and destroy() methods
}