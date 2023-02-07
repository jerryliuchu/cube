package run;

import java.awt.Color;
import processing.core.PApplet;

/**
 * An n x n x n cube
 */
public class Cube {

    private final Color red = new Color(255, 0, 0, 255),
            blue = new Color(0, 0, 255, 255),
            green = new Color(0, 255, 0, 255),
            yellow = new Color(255, 255, 0, 255),
            orange = new Color(255, 165, 0, 255),
            white = new Color(255, 255, 255, 255),
            nonVisible = new Color(255, 0, 0, 0);

    private final int N = 3; // number of sides

    private SmallCube[][][] parts; // x, y, z, (left, top, front) = (0, 0, 0)

    /**
     * Creates a fully solved 3 x 3 cube
     * 
     * TODO: You can take in a parameter to make a different size cube
     */
    public Cube() {
        parts = new SmallCube[N][N][N];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                for (int k = 0; k < N; k++) {
                    parts[i][j][k] = new SmallCube(nonVisible, nonVisible, nonVisible, nonVisible, nonVisible,
                            nonVisible);
                }
            }
        }

        // front
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                parts[i][j][0].setFront(white);
            }
        }

        // right
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                parts[N - 1][i][j].setRight(orange);
            }
        }

        // back
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                parts[i][j][N - 1].setBack(yellow);
            }
        }

        // left
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                parts[0][i][j].setLeft(red);
            }
        }

        // top
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                parts[i][0][j].setTop(green);
            }
        }

        // bottom
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                parts[i][N - 1][j].setBottom(blue);
            }
        }
    }

    public void rotateUp(int c) {
    }

    public void rotateDown(int c) {

    }

    public void rotateRight(int r) {

    }

    public void rotateLeft(int r) {

    }

    /**
     * draw on the given PApplet
     * 
     * @param w the PApplet to draw on
     */
    public void draw(PApplet w) {
        final float gap = 2.1f;

        for (int i = 0; i < N; i++) {
            float x = (i - (N / 2)) * SmallCube.size * gap; // TODO: this expression would be incorrect when N is even
            for (int j = 0; j < N; j++) {
                float y = (j - (N / 2)) * SmallCube.size * gap;
                for (int k = 0; k < N; k++) {
                    float z = -(k - (N / 2)) * SmallCube.size * gap;

                    if (i == 0 || i == N - 1 || j == 0 || j == N - 1 || k == 0 || k == N - 1) {
                        SmallCube curr = parts[i][j][k];
                        curr.draw(w, x, y, z);
                    }
                }
            }
        }

    }

}