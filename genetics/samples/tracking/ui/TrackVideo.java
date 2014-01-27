package group2.genetics.samples.tracking.ui;

import com.xuggle.mediatool.IMediaReader;
import com.xuggle.mediatool.MediaListenerAdapter;
import com.xuggle.mediatool.ToolFactory;
import com.xuggle.mediatool.event.IVideoPictureEvent;
import java.awt.Dimension;
import java.awt.image.BufferedImage;
import java.util.logging.Level;
import java.util.logging.Logger;

public final class TrackVideo {
    private String source;
    private TracksLayer screen;
    
    private int display = 0;
    private int eventFrequency = 1;
    
    public TrackVideo(TracksLayer father, String sourcePath) {
        this.source = sourcePath;
        this.screen = father;
    }
    
    public void play() {
        IMediaReader reader = ToolFactory.makeReader(source);
        reader.setBufferedImageTypeToGenerate(BufferedImage.TYPE_3BYTE_BGR);

        this.screen.setSize(new Dimension(480, 360));

        MediaListenerAdapter adapter = new MediaListenerAdapter()  {
            @Override
            public void onVideoPicture(IVideoPictureEvent event) {
                if(display == eventFrequency) {
                    try {
                        Thread.sleep(20);
                    } catch (InterruptedException ex) {
                        Logger.getLogger(TrackVideo.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    screen.setImage((BufferedImage) event.getImage());
                    display = 0;
                }
                display++;
            }
        };
        reader.addListener(adapter);

        while (reader.readPacket() == null)
            do {} while(false);
    }
}