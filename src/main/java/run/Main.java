package run;

import processing.core.PApplet;

public class Main {
    public static void main(String[] args) {
        DrawingSurface ds = new DrawingSurface();
        PApplet.runSketch(new String[] { "" }, ds);
        ds.windowResizable(true);
    }
}