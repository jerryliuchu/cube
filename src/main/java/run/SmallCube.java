package run;

import java.awt.Color;
import processing.core.PApplet;

/**
 * The small cubes that make up the surface of the big cube.
 */
public class SmallCube {

    public static final float size = 50; // TODO: make this value scale with the size of the window and the cube

    private Color colors[] = new Color[6]; // front, right, back, left, top, bottom
    private int hex[] = new int[6];

    /**
     * creates a small cube with given colors
     * 
     * @param front  the color of the front face
     * @param right  the color of the right face
     * @param back   the color of the back face
     * @param left   the color of the left face
     * @param top    the color of the top face
     * @param bottom the color of the bottom face
     */
    public SmallCube(Color front, Color right, Color back, Color left, Color top, Color bottom) {
        colors[0] = front;
        colors[1] = right;
        colors[2] = back;
        colors[3] = left;
        colors[4] = top;
        colors[5] = bottom;

        hex[0] = front.getRGB();
        hex[1] = right.getRGB();
        hex[2] = back.getRGB();
        hex[3] = left.getRGB();
        hex[4] = top.getRGB();
        hex[5] = bottom.getRGB();
    }

    /**
     * 
     * @param h The number of ninetry degree rotations around the y-axis. Right is
     *          positive
     * @param v The number of ninetry degree rotations around the x-axis. Down is
     *          positive
     */
    public void rotate(int h, int v) {
        v %= 4;
        h %= 4;
        if (v < 0)
            v += 4;
        if (h < 0)
            h += 4;

        Color newColors[] = new Color[6];
        for (int i = 0; i < 6; i++) {
            newColors[i] = new Color(colors[i].getRed(), colors[i].getGreen(), colors[i].getBlue(),
                    colors[i].getAlpha());
        }

        for (int i = 0; i < h; i++) {
            for (int j = 0; j < 4; j++) {
                newColors[(j + 1) % 4] = new Color(colors[j].getRed(), colors[j].getGreen(), colors[j].getBlue(),
                        colors[j].getAlpha());
            }

            colors = newColors;
            newColors = new Color[6];
            for (int j = 0; j < 6; j++) {
                newColors[j] = new Color(colors[j].getRed(), colors[j].getGreen(), colors[j].getBlue(),
                        colors[j].getAlpha());
            }
        }

        newColors = new Color[6];
        for (int i = 0; i < 6; i++) {
            newColors[i] = new Color(colors[i].getRed(), colors[i].getGreen(), colors[i].getBlue(),
                    colors[i].getAlpha());
        }

        for (int i = 0; i < v; i++) {
            newColors[0] = new Color(colors[4].getRed(), colors[4].getGreen(), colors[4].getBlue(),
                    colors[4].getAlpha());
            newColors[2] = new Color(colors[5].getRed(), colors[5].getGreen(), colors[5].getBlue(),
                    colors[5].getAlpha());
            newColors[4] = new Color(colors[2].getRed(), colors[2].getGreen(), colors[2].getBlue(),
                    colors[2].getAlpha());
            newColors[5] = new Color(colors[0].getRed(), colors[0].getGreen(), colors[0].getBlue(),
                    colors[0].getAlpha());

            colors = newColors;
            newColors = new Color[6];
            for (int j = 0; j < 6; j++) {
                newColors[j] = new Color(colors[j].getRed(), colors[j].getGreen(), colors[j].getBlue(),
                        colors[j].getAlpha());
            }
        }
    }

    /**
     * Changes the color of the front face
     * 
     * @param c The color to change to
     */
    public void setFront(Color c) {
        colors[0] = c;
        hex[0] = c.getRGB();
    }

    /**
     * Changes the color of the back face
     * 
     * @param c The color to change to
     */
    public void setBack(Color c) {
        colors[2] = c;
        hex[2] = c.getRGB();
    }

    /**
     * Changes the color of the right face
     * 
     * @param c The color to change to
     */
    public void setRight(Color c) {
        colors[1] = c;
        hex[1] = c.getRGB();
    }

    /**
     * Changes the color of the left face
     * 
     * @param c The color to change to
     */
    public void setLeft(Color c) {
        colors[3] = c;
        hex[3] = c.getRGB();
    }

    /**
     * Changes the color of the top face
     * 
     * @param c The color to change to
     */
    public void setTop(Color c) {
        colors[4] = c;
        hex[4] = c.getRGB();
    }

    /**
     * Changes the color of the bottom face
     * 
     * @param c The color to change to
     */
    public void setBottom(Color c) {
        colors[5] = c;
        hex[5] = c.getRGB();
    }

    /**
     * draw the cube on the given PApplet at the given position
     * 
     * @param w the PApplet to draw on
     * @param x the x coordinate of the cube
     * @param y the y-coordinate of the cube
     * @param z the z-coordinate of the cube
     */
    public void draw(PApplet w, float x, float y, float z) {
        w.pushStyle();
        w.pushMatrix();

        w.translate(x, y, z);
        w.scale(size);
        w.noStroke();

        // front
        w.beginShape(PApplet.QUADS);
        w.fill(colors[0].getRGB());
        w.vertex(-1, -1, 1);
        w.vertex(1, -1, 1);
        w.vertex(1, 1, 1);
        w.vertex(-1, 1, 1);
        w.endShape();

        // back
        w.beginShape(PApplet.QUADS);
        w.fill(colors[2].getRGB());
        w.vertex(1, -1, -1);
        w.vertex(-1, -1, -1);
        w.vertex(-1, 1, -1);
        w.vertex(1, 1, -1);
        w.endShape();

        // bottom
        w.beginShape(PApplet.QUADS);
        w.fill(colors[5].getRGB());
        w.vertex(-1, 1, 1);
        w.vertex(1, 1, 1);
        w.vertex(1, 1, -1);
        w.vertex(-1, 1, -1);
        w.endShape();

        // top
        w.beginShape(PApplet.QUADS);
        w.fill(colors[4].getRGB());
        w.vertex(-1, -1, -1);
        w.vertex(1, -1, -1);
        w.vertex(1, -1, 1);
        w.vertex(-1, -1, 1);
        w.endShape();

        // right
        w.beginShape(PApplet.QUADS);
        w.fill(colors[1].getRGB());
        w.vertex(1, -1, 1);
        w.vertex(1, -1, -1);
        w.vertex(1, 1, -1);
        w.vertex(1, 1, 1);
        w.endShape();

        // left
        w.beginShape(PApplet.QUADS);
        w.fill(colors[3].getRGB());
        w.vertex(-1, -1, -1);
        w.vertex(-1, -1, 1);
        w.vertex(-1, 1, 1);
        w.vertex(-1, 1, -1);
        w.endShape();

        w.popStyle();
        w.popMatrix();
    }

}