package group2.genetics.samples.tracking.ui;


public class RGBPixel {
    private int binary;
    
    public RGBPixel(int rgbBin) {
        this.binary = rgbBin;
    }
    
    public RGBPixel() {
        this(20);
    }
    
    public int r() {
        return (binary)&0xFF;
    }
    
    public int g() {
        return (binary>>8)&0xFF;
    }
    
    public int b() {
        return (binary>>16)&0xFF;
    }
    
    public void setBin(int rgbBin) {
        this.binary = rgbBin;
    }
    
    public int contrast(int pixelComp, int intensity) {
        return Math.round(pixelComp + intensity / 100 * (pixelComp-127));
    }
}
