package main;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyHandler implements KeyListener {

    private boolean upPressed, downPressed, rightPressed, leftPressed;

    // not using
    @Override
    public void keyTyped(KeyEvent e) {}

    @Override
    public void keyPressed(KeyEvent e) {
        int code = e.getKeyCode();

        // W equals UP
        if (code == KeyEvent.VK_W) {
            upPressed = true;
        }

        if (code == KeyEvent.VK_D) {rightPressed = true;}

        if (code == KeyEvent.VK_S) {downPressed = true;}

        if (code == KeyEvent.VK_A) {leftPressed = true;}
    }

    @Override
    public void keyReleased(KeyEvent e) {
        int code = e.getKeyCode();

        // W equals UP
        if (code == KeyEvent.VK_W) {
            upPressed = false;
        }

        if (code == KeyEvent.VK_D) {rightPressed = false;}

        if (code == KeyEvent.VK_S) {downPressed = false;}

        if (code == KeyEvent.VK_A) {leftPressed = false;}
    }

    public boolean getUpPressed() {return this.upPressed;}
    public boolean getDownPressed() {return this.downPressed;}
    public boolean getRightPressed() {return this.rightPressed;}
    public boolean getLeftPressed() {return this.leftPressed;}
}
