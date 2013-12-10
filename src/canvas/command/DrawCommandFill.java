package canvas.command;

import name.LayerIdentifier;
import canvas.Drawable;
import canvas.Pixel;

public class DrawCommandFill extends DrawCommand {
    private static final long serialVersionUID = -4272516979645753409L;
    
    private final Pixel pixel;
    
    public DrawCommandFill(Pixel pixel) {
        this.pixel = pixel;
    }
    
    @Override
    public void drawOn(Drawable drawable) {
        drawable.drawFill(pixel);

    }

}
