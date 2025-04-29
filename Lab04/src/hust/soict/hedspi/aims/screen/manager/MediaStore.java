package hust.soict.hedspi.aims.screen.manager;

import hust.soict.hedspi.aims.media.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MediaStore extends JPanel {
    private static final long serialVersionUID = 1L;
    private Media media;
    
    public MediaStore(Media media) {
        this.media = media;
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        
        JLabel title = new JLabel(media.getTitle());
        title.setFont(new Font(title.getFont().getName(), Font.PLAIN, 15));
        title.setAlignmentX(CENTER_ALIGNMENT);
        
        JLabel cost = new JLabel("" + media.getCost() + " $");
        cost.setAlignmentX(CENTER_ALIGNMENT);
        
        JPanel container = new JPanel();
        container.setLayout(new FlowLayout(FlowLayout.CENTER));
        
        if (media instanceof Playable) {
            JButton playButton = new JButton("Play");
            playButton.addActionListener(new PlayButtonListener());
            container.add(playButton);
        }
        
        this.add(Box.createVerticalGlue());
        this.add(title);
        this.add(cost);
        this.add(Box.createVerticalGlue());
        this.add(container);
        this.setBorder(BorderFactory.createLineBorder(Color.BLACK));
    }
    
    private class PlayButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            JDialog playDialog = new JDialog();
            playDialog.setTitle("Playing " + media.getTitle());
            playDialog.setLayout(new BorderLayout());
            
            JPanel contentPanel = new JPanel();
            contentPanel.setLayout(new BoxLayout(contentPanel, BoxLayout.Y_AXIS));
            contentPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
            
            JLabel titleLabel = new JLabel("Now Playing: " + media.getTitle());
            titleLabel.setFont(new Font(titleLabel.getFont().getName(), Font.BOLD, 16));
            titleLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
            contentPanel.add(titleLabel);
            contentPanel.add(Box.createRigidArea(new Dimension(0, 10)));
            
            JTextArea playInfo = new JTextArea(10, 30);
            playInfo.setEditable(false);
            playInfo.setLineWrap(true);
            playInfo.setWrapStyleWord(true);
            
            if (media instanceof DigitalVideoDisc) {
                DigitalVideoDisc dvd = (DigitalVideoDisc) media;
                playInfo.setText("DVD: " + dvd.getTitle() + "\n");
                playInfo.append("Category: " + dvd.getCategory() + "\n");
                playInfo.append("Director: " + dvd.getDirector() + "\n");
                playInfo.append("Length: " + dvd.getLength() + " minutes\n");
                ((Playable) media).play();
            } else if (media instanceof CompactDisc) {
                CompactDisc cd = (CompactDisc) media;
                playInfo.setText("CD: " + cd.getTitle() + "\n");
                playInfo.append("Artist: " + cd.getArtist() + "\n");
                playInfo.append("Category: " + cd.getCategory() + "\n");
                ((Playable) media).play();
            }
            
            JScrollPane scrollPane = new JScrollPane(playInfo);
            contentPanel.add(scrollPane);
            
            JButton closeButton = new JButton("Close");
            closeButton.setAlignmentX(Component.CENTER_ALIGNMENT);
            closeButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    playDialog.dispose();
                }
            });
            
            contentPanel.add(Box.createRigidArea(new Dimension(0, 10)));
            contentPanel.add(closeButton);
            
            playDialog.add(contentPanel, BorderLayout.CENTER);
            playDialog.setSize(400, 300);
            playDialog.setLocationRelativeTo(null);
            playDialog.setModal(true);
            playDialog.setVisible(true);
        }
    }
}