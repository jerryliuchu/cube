package run;

import processing.core.PApplet;
import java.awt.Color;

public class DrawingSurface extends PApplet {

    private final int WIDTH = 800, HEIGHT = 800;
    private final float rate = 0.01f;

    private Cube cube;
    private float rx, ry;

    public DrawingSurface() {
        cube = new Cube();
    }

    @Override
    public void settings() {
        size(WIDTH, HEIGHT, P3D);
    }

    @Override
    public void setup() {

    }

    @Override
    public void mouseDragged() {
        if (mousePressed) {
            ry += (mouseX - pmouseX) * rate;
            rx += (pmouseY - mouseY) * rate;
        }
    }

    @Override
    public void draw() {
        background(0xC0FFEE);
        translate(WIDTH / 2, HEIGHT / 2);
        rotateX(rx);
        rotateY(ry);

        cube.draw(this);
    }
}