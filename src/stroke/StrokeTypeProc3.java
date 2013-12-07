package stroke;

import java.awt.Color;
import java.util.LinkedList;
import java.util.List;

import util.Vector2;
import canvas.Drawable;
import canvas.Pixel;
import canvas.command.DrawCommand;
import canvas.command.DrawCommandPixel;

public class StrokeTypeProc3 implements StrokeType {

    @Override
    public DrawCommand[] paintLine(Drawable canvas, Color color, int strokeWidth, int x1, int y1, int x2, int y2, Vector2 velocity) {
        List<DrawCommand> result = new LinkedList<DrawCommand>();
        double length = 1 + Math.random() * 1.5;
        for (int j = 0; j < strokeWidth * length; j++) {
            Pixel pixel = new Pixel((int)(x1 + Math.min(velocity.x()*j, 20)), (int)(y1 + Math.min(velocity.y()*j, 20)), new Color(color.getRed(),color.getGreen(), color.getBlue(), (int)(j/(float)(strokeWidth * length)*255)));

            if (!canvas.getPixelColor(pixel).equals(pixel.color())) {
                result.add(new DrawCommandPixel(pixel));
            }
        }
        
        return result.toArray(new DrawCommand[result.size()]);
    }
    
    @Override
    public String toString() {
        return "Follow";
    }


}