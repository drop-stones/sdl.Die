package jp.ac.titech.itpro.sdl.die;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;

import javax.microedition.khronos.opengles.GL10;

public class Octahedron implements Obj {

    private final static float[] VERTICES = {
            // upper triangle 1
            1, 0, 0,
            0, 0, 1,
            0, 1, 0,
            // upper triangle 2
            1, 0, 0,
            0, 0, -1,
            0, 1, 0,
            // upper triangle 3
            -1, 0, 0,
            0, 0, 1,
            0, 1, 0,
            // upper triangle 4
            -1, 0, 0,
            0, 0, -1,
            0, 1, 0,
            // lower triangle 1
            1, 0, 0,
            0, 0, 1,
            0, -1, 0,
            // lower triangle 2
            1, 0, 0,
            0, 0, -1,
            0, -1, 0,
            // lower triangle 3
            -1, 0, 0,
            0, 0, 1,
            0, -1, 0,
            // lower triangle 4
            -1, 0, 0,
            0, 0, -1,
            0, -1, 0
    };

    private final FloatBuffer vbuf;

    Octahedron() {
        vbuf = ByteBuffer
                .allocateDirect(VERTICES.length * 4)
                .order(ByteOrder.nativeOrder())
                .asFloatBuffer();
        vbuf.put(VERTICES);
        vbuf.position(0);
    }

    @Override
    public void draw(GL10 gl) {
        gl.glEnableClientState(GL10.GL_VERTEX_ARRAY);
        gl.glVertexPointer(3, GL10.GL_FLOAT, 0, vbuf);

        // upper triangle 1
        gl.glNormal3f(1, 1, 1);
        gl.glDrawArrays(GL10.GL_TRIANGLES, 0, 3);

        // upper triangle 2
        gl.glNormal3f(1, 1, -1);
        gl.glDrawArrays(GL10.GL_TRIANGLES, 3, 3);

        // upper triangle 3
        gl.glNormal3f(-1, 1, 1);
        gl.glDrawArrays(GL10.GL_TRIANGLES, 6, 3);

        // upper triangle 4
        gl.glNormal3f(-1, 1, -1);
        gl.glDrawArrays(GL10.GL_TRIANGLES, 9, 3);

        // lower triangle 1
        gl.glNormal3f(1, -1, 1);
        gl.glDrawArrays(GL10.GL_TRIANGLE_FAN, 12, 3);

        // lower triangle 2
        gl.glNormal3f(1, -1, -1);
        gl.glDrawArrays(GL10.GL_TRIANGLES, 15, 3);

        // lower triangle 3
        gl.glNormal3f(-1, -1, 1);
        gl.glDrawArrays(GL10.GL_TRIANGLES, 18, 3);

        // lower triangle 4
        gl.glNormal3f(-1, -1, -1);
        gl.glDrawArrays(GL10.GL_TRIANGLES, 21, 3);
    }
}
