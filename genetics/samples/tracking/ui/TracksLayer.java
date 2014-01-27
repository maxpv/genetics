package group2.genetics.samples.tracking.ui;

import group2.genetics.events.PopulationEvent;
import group2.genetics.inhabitants.Being;
import group2.genetics.inhabitants.Population;
import group2.genetics.samples.tracking.TrackBeing;
import group2.genetics.samples.tracking.TrackProblem;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;
import java.util.Iterator;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JPanel;


public class TracksLayer extends JPanel {
    private static BufferedImage image;
    private static int marge = TrackProblem.getColorDelay();
    private Population pop;
    private TrackVideo video;
    private JPanel pointsCanvas;
    private boolean free;
    private static Color refColor = TrackProblem.videoFile.getColor();
    private TrackTargetUI target;
    
    public TracksLayer(Dimension d) {
        this.video = new TrackVideo(this, TrackProblem.videoFile.getURL());
        this.pointsCanvas = new JPanel();
        pointsCanvas.setPreferredSize(d);
        pointsCanvas.setBounds(0, 0, d.width, d.height);

        this.add(pointsCanvas, new Integer(10));      

        this.free=true;
        this.target = new TrackTargetUI(20, d);
    }
    
    public void play() {
        this.video.play();
    }
    
     @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
    }
    
    public synchronized void setImage(final BufferedImage img) {
        if(this.free) {
            this.free = false;
            image = img;
            prepare();
        }
    }
    
    public static Color getRefColor() {
        return refColor;
    }
    
    public static boolean isNear(int x, int y) {
        if(image == null) {
            return false;
        }
        int b = image.getRGB(x, y);
        RGBPixel pix = new RGBPixel(b);
        return isNearColor(pix.r(), pix.g(), pix.b(), refColor);
    }
    
    private synchronized void prepare() {
        if(this.free || this.pop == null) {
            return;
        }
        
        Iterator<Being> it = this.pop.iterator();
        while(it.hasNext()) {
            TrackBeing tB = (TrackBeing) it.next();
            if(isNear(tB.getX(), tB.getY())) {
                target.addTarget(new Point(tB.getX(), tB.getY()));
            }
        }

        target.setDirection();
        target.lock();
    }

    public synchronized void refresh(PopulationEvent ev) {
        this.pop = ev.getPopulation();
        if(!this.free) {
            
            repaint();
        }
    }
  
    private static boolean isNearColor(int r, int g, int b, Color refColor) {
        if(r < refColor.getRed()+marge+2 && r > refColor.getRed()-marge-4){
           if(g < refColor.getGreen()+marge+2 && g > refColor.getGreen()-marge-4) {
               if(b < refColor.getBlue()+marge+35 && b > refColor.getBlue()-marge-35) {
                return true;
               }
           }
        }
        return false;
    }
    
    public synchronized void paint(Graphics g) {
      if (image != null) {
            g.drawImage(image, 0, 0, null);
            if(!free) {
                Graphics2D g2D = (Graphics2D) g;
                refreshPoints(g2D);
                target.release();
                target.refreshTrackZone(g2D);
                try {
                        Thread.sleep(20);
                    } catch (InterruptedException ex) {
                        Logger.getLogger(TrackVideo.class.getName()).log(Level.SEVERE, null, ex);
                    }
            }
      }
    }
    
    private void refreshPoints(Graphics2D g2D) {
        if(pop == null) {
            return;
        }
        Rectangle2D ui = new Rectangle2D.Double();

        for (Being b : pop) {
            TrackBeing tB = (TrackBeing) b;
            TrackBeingUI.prepare(tB);
        }
        
        TrackBeingUI.DRAW(g2D);
        this.free = true;
    }
}