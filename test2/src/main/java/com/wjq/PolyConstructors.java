package com.wjq;

/**
 * Created by wangjianqiang on 2017/10/24.
 */
public class PolyConstructors {

    public static void main(String[] args) {
        new RoundGlyph(5);
    }
}

class Glyph{
    void draw(){
        System.out.println("Glyph.draw()");
    }

    public Glyph() {
        System.out.println("Glyph before draw");
        draw();
        System.out.println("after");
    }
}

class RoundGlyph extends Glyph{

    private int radius = getRadius();
    int getRadius(){
        System.out.println("get");
        return 1;
    }

    public RoundGlyph(int radius) {
        System.out.println(this.radius);
        this.radius = radius;
        System.out.println("RoundGlyph.RoundGlyph=" +radius );
    }

    void draw(){
        System.out.println("RoundGlyph.r=" + radius);
    }
}
