package group2.genetics.ui.swing;

import group2.genetics.engine.Configuration;
import group2.genetics.engine.GeneticEngine;
import group2.genetics.engine.playback.PlaybackState;
import group2.genetics.events.PlaybackEvent;
import group2.genetics.ui.View;
import group2.genetics.ui.swing.slider.CustomCompleteSlider;
import group2.genetics.ui.swing.viewsmenu.ViewsMenu;

public class ControlsFrame extends javax.swing.JFrame implements View<PlaybackEvent> {

    public static ControlsFrame showDialog(String title) {
        ControlsFrame f = new ControlsFrame();
        f.setTitle(title);
        f.setVisible(true);
        return f;
    }

    /**
     * Creates new form MainFrame
     */
    public ControlsFrame() {
        initComponents();
        updateJLists();
        updateSliders();
        GeneticEngine g = GeneticEngine.getInstance();
        g.attachPlaybackView(this);
        g.attachChronometerView(this.labelChronometer);
        g.attachPopulationView(this.iterationsView);
        g.attachPlaybackView(this.iterationsView);
    }

    public ViewsMenu getViewsMenu() {
        return ViewsMenu;
    }

    public void setViewsMenu(ViewsMenu viewsMenu) {
        this.ViewsMenu = viewsMenu;
    }

    private void updateSliders() {
        Configuration c = Configuration.getInstance();
        this.PopulationSizeCompleteSlider.setValue(c.getPopulationSize());
        this.CrossProbabilityCompleteSlider.setValue(c.getCrossOverProbability());
        this.MutationProbabilityCompleteSlider.setValue(c.getMutationProbability());
    }
    
    private void updateJLists() {
        Configuration c = Configuration.getInstance();
        this.SelectionList.setModel(c.getAvailableSelectionProcesses());
        this.StopList.setModel(c.getAvailableStopProcesses());
        this.CrossOverList.setModel(c.getAvailableCrossOverProcesses());
        this.MutationList.setModel(c.getAvailableMutationProcesses());
    }
    
    @Override
    public void refresh(PlaybackEvent ev) {
        PlaybackState state = ev.getState();
        switch (state) {
            case PLAYING:
                PlayPauseButton.setText("Pause");
                break;
            case PAUSED:
                PlayPauseButton.setText("Play");
                break;
            case STOPPED:
                PlayPauseButton.setText("Play");
                break;
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        PlayPauseButton = new javax.swing.JButton();
        StopButton = new javax.swing.JButton();
        ResetButton = new javax.swing.JButton();
        StepByStepLabel = new javax.swing.JLabel();
        StepByStepSwitchButton = new group2.genetics.ui.swing.JSwitchButton();
        NextStepButton = new javax.swing.JButton();
        SelectionSeparator = new javax.swing.JSeparator();
        SelectionLabel = new javax.swing.JLabel();
        SelectionList = new group2.genetics.ui.swing.JList();
        PopulationSizeSeparator = new javax.swing.JSeparator();
        PopulationSizeLabel = new javax.swing.JLabel();
        PopulationSizeCompleteSlider = new group2.genetics.ui.swing.slider.CustomCompleteSlider();
        StopSeparator = new javax.swing.JSeparator();
        StopLabel = new javax.swing.JLabel();
        StopList = new group2.genetics.ui.swing.JList();
        IterationsLabel = new javax.swing.JLabel();
        IterationsCompleteSlider = new group2.genetics.ui.swing.slider.CustomCompleteSlider();
        CrossOverSeparator = new javax.swing.JSeparator();
        CrossOverLabel = new javax.swing.JLabel();
        CrossOverList = new group2.genetics.ui.swing.JList();
        CrossProbabilityLabel = new javax.swing.JLabel();
        CrossProbabilityCompleteSlider = new group2.genetics.ui.swing.slider.CustomCompleteSlider();
        MutationSeparator = new javax.swing.JSeparator();
        MutationLabel = new javax.swing.JLabel();
        MutationList = new group2.genetics.ui.swing.JList();
        MutationProbabilityLabel = new javax.swing.JLabel();
        MutationProbabilityCompleteSlider = new group2.genetics.ui.swing.slider.CustomCompleteSlider();
        iterationsView = new group2.genetics.ui.swing.IterationsView();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        labelChronometer = new group2.genetics.chronometer.view.LabelChronometer();
        MenuBar = new javax.swing.JMenuBar();
        FileMenu = new javax.swing.JMenu();
        ExitButton = new javax.swing.JMenuItem();
        ViewsMenu = new group2.genetics.ui.swing.viewsmenu.ViewsMenu();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        PlayPauseButton.setText("Play");
        PlayPauseButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PlayPauseButtonActionPerformed(evt);
            }
        });

        StopButton.setText("Stop");
        StopButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                StopButtonActionPerformed(evt);
            }
        });

        ResetButton.setText("Reset");
        ResetButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ResetButtonActionPerformed(evt);
            }
        });

        StepByStepLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        StepByStepLabel.setText("Step By Step");

        StepByStepSwitchButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                StepByStepSwitchButtonActionPerformed(evt);
            }
        });

        NextStepButton.setText("Next");
        NextStepButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NextStepButtonActionPerformed(evt);
            }
        });

        SelectionLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        SelectionLabel.setText("Opérateur de sélection");

        SelectionList.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SelectionListActionPerformed(evt);
            }
        });

        PopulationSizeLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        PopulationSizeLabel.setText("Taille population (vies) *");
        PopulationSizeLabel.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        PopulationSizeCompleteSlider.setPaintLabels(false);
        PopulationSizeCompleteSlider.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PopulationSizeCompleteSliderActionPerformed(evt);
            }
        });

        StopLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        StopLabel.setText("Critère d'arrêt");

        StopList.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                StopListActionPerformed(evt);
            }
        });

        IterationsLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        IterationsLabel.setText("Nombre d'itérations (cycles)");

        IterationsCompleteSlider.setMajorTickSpacing(2000);
        IterationsCompleteSlider.setMaximum(10000);
        IterationsCompleteSlider.setMinorTickSpacing(1000);
        IterationsCompleteSlider.setPaintLabels(false);
        IterationsCompleteSlider.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                IterationsCompleteSliderActionPerformed(evt);
            }
        });

        CrossOverLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        CrossOverLabel.setText("Opérateur de croisement");

        CrossOverList.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CrossOverListActionPerformed(evt);
            }
        });

        CrossProbabilityLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        CrossProbabilityLabel.setText("Probabilité de croisement (%)");

        CrossProbabilityCompleteSlider.setPaintLabels(false);
        CrossProbabilityCompleteSlider.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CrossProbabilityCompleteSliderActionPerformed(evt);
            }
        });

        MutationLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        MutationLabel.setText("Opérateur de mutation");

        MutationList.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MutationListActionPerformed(evt);
            }
        });

        MutationProbabilityLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        MutationProbabilityLabel.setText("Probabilité de mutation (%)");

        MutationProbabilityCompleteSlider.setPaintLabels(false);
        MutationProbabilityCompleteSlider.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MutationProbabilityCompleteSliderActionPerformed(evt);
            }
        });

        jLabel1.setText("iterations");

        jLabel2.setText("s");

        labelChronometer.setAlignmentY(0.0F);
        labelChronometer.setMaximumSize(null);

        FileMenu.setMnemonic('F');
        FileMenu.setText("File");

        ExitButton.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_E, java.awt.event.InputEvent.CTRL_MASK));
        ExitButton.setMnemonic('E');
        ExitButton.setText("Exit");
        ExitButton.setToolTipText("Exit Genetics");
        ExitButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ExitButtonActionPerformed(evt);
            }
        });
        FileMenu.add(ExitButton);

        MenuBar.add(FileMenu);
        MenuBar.add(ViewsMenu);

        jMenu1.setMnemonic('?');
        jMenu1.setText("?");

        jMenuItem1.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_H, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem1.setMnemonic('H');
        jMenuItem1.setText("Help");
        jMenuItem1.setToolTipText("Show Help Dialog");
        jMenu1.add(jMenuItem1);

        jMenuItem2.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_A, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem2.setMnemonic('A');
        jMenuItem2.setText("About");
        jMenuItem2.setToolTipText("About Genetics");
        jMenu1.add(jMenuItem2);

        MenuBar.add(jMenu1);

        setJMenuBar(MenuBar);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(MutationSeparator, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(MutationLabel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(MutationProbabilityLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(CrossOverList, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(StopList, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(CrossOverLabel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(PlayPauseButton, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(StepByStepLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(StepByStepSwitchButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(StopButton, javax.swing.GroupLayout.DEFAULT_SIZE, 130, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(ResetButton, javax.swing.GroupLayout.DEFAULT_SIZE, 130, Short.MAX_VALUE)
                                    .addComponent(NextStepButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                            .addComponent(SelectionSeparator)
                            .addComponent(PopulationSizeLabel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(SelectionLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(PopulationSizeSeparator)
                            .addComponent(StopSeparator, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(PopulationSizeCompleteSlider, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 402, Short.MAX_VALUE)
                            .addComponent(StopLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(IterationsLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(IterationsCompleteSlider, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(CrossOverSeparator)
                            .addComponent(CrossProbabilityLabel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(CrossProbabilityCompleteSlider, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(MutationProbabilityCompleteSlider, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(labelChronometer, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(iterationsView, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel1))
                            .addComponent(SelectionList, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(MutationList, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(PlayPauseButton)
                    .addComponent(StopButton)
                    .addComponent(ResetButton))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(StepByStepLabel)
                    .addComponent(StepByStepSwitchButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(NextStepButton))
                .addGap(18, 18, 18)
                .addComponent(SelectionSeparator, javax.swing.GroupLayout.PREFERRED_SIZE, 4, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(SelectionLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(SelectionList, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(PopulationSizeSeparator, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(PopulationSizeLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(PopulationSizeCompleteSlider, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(StopSeparator, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(StopLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(StopList, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(11, 11, 11)
                .addComponent(IterationsLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(IterationsCompleteSlider, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(4, 4, 4)
                .addComponent(CrossOverSeparator, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(5, 5, 5)
                .addComponent(CrossOverLabel)
                .addGap(11, 11, 11)
                .addComponent(CrossOverList, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(CrossProbabilityLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(CrossProbabilityCompleteSlider, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(MutationSeparator, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(MutationLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(MutationList, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(MutationProbabilityLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(MutationProbabilityCompleteSlider, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(44, 44, 44)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel1)
                        .addComponent(iterationsView, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel2))
                    .addComponent(labelChronometer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void PlayPauseButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PlayPauseButtonActionPerformed
        PlaybackState state = GeneticEngine.getInstance().getState();
        switch (state) {
            case PLAYING:
                GeneticEngine.getInstance().Pause();
                break;
            default:
                GeneticEngine.getInstance().Play();
        }
    }//GEN-LAST:event_PlayPauseButtonActionPerformed

    private void StopButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_StopButtonActionPerformed
        GeneticEngine.getInstance().Stop();
    }//GEN-LAST:event_StopButtonActionPerformed

    private void NextStepButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NextStepButtonActionPerformed
        GeneticEngine.getInstance().Play();
    }//GEN-LAST:event_NextStepButtonActionPerformed

    private void StepByStepSwitchButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_StepByStepSwitchButtonActionPerformed
        GeneticEngine.getInstance().toggleStepByStep();
    }//GEN-LAST:event_StepByStepSwitchButtonActionPerformed

    private void CrossProbabilityCompleteSliderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CrossProbabilityCompleteSliderActionPerformed
        CustomCompleteSlider source = (CustomCompleteSlider) evt.getSource();
        Configuration.getInstance().setCrossOverProbability(source.getValue());
    }//GEN-LAST:event_CrossProbabilityCompleteSliderActionPerformed

    private void MutationProbabilityCompleteSliderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MutationProbabilityCompleteSliderActionPerformed
        CustomCompleteSlider source = (CustomCompleteSlider) evt.getSource();
        Configuration.getInstance().setMutationProbability(source.getValue());
    }//GEN-LAST:event_MutationProbabilityCompleteSliderActionPerformed

    private void IterationsCompleteSliderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_IterationsCompleteSliderActionPerformed
        CustomCompleteSlider source = (CustomCompleteSlider) evt.getSource();
        Configuration.getInstance().setStopIterations(source.getValue());
    }//GEN-LAST:event_IterationsCompleteSliderActionPerformed

    private void PopulationSizeCompleteSliderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PopulationSizeCompleteSliderActionPerformed
        CustomCompleteSlider source = (CustomCompleteSlider) evt.getSource();
        Configuration.getInstance().setPopulationSize(source.getValue());
    }//GEN-LAST:event_PopulationSizeCompleteSliderActionPerformed

    private void ResetButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ResetButtonActionPerformed
        GeneticEngine.getInstance().Reset();
    }//GEN-LAST:event_ResetButtonActionPerformed

    private void ExitButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ExitButtonActionPerformed
        System.exit(0);
    }//GEN-LAST:event_ExitButtonActionPerformed

    private void SelectionListActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SelectionListActionPerformed
        JList source = (JList) evt.getSource();
        Class c = source.getSelectedSimpleClass().toClass();
        Configuration.getInstance().setSelectionProcess(c);
    }//GEN-LAST:event_SelectionListActionPerformed

    private void StopListActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_StopListActionPerformed
        JList source = (JList) evt.getSource();
        Class c = source.getSelectedSimpleClass().toClass();
        Configuration.getInstance().setStopProcess(c);
    }//GEN-LAST:event_StopListActionPerformed

    private void CrossOverListActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CrossOverListActionPerformed
        JList source = (JList) evt.getSource();
        Class c = source.getSelectedSimpleClass().toClass();
        Configuration.getInstance().setCrossOverProcess(c);
    }//GEN-LAST:event_CrossOverListActionPerformed

    private void MutationListActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MutationListActionPerformed
        JList source = (JList) evt.getSource();
        Class c = source.getSelectedSimpleClass().toClass();
        Configuration.getInstance().setMutationProcess(c);
    }//GEN-LAST:event_MutationListActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel CrossOverLabel;
    private group2.genetics.ui.swing.JList CrossOverList;
    private javax.swing.JSeparator CrossOverSeparator;
    private group2.genetics.ui.swing.slider.CustomCompleteSlider CrossProbabilityCompleteSlider;
    private javax.swing.JLabel CrossProbabilityLabel;
    private javax.swing.JMenuItem ExitButton;
    private javax.swing.JMenu FileMenu;
    private group2.genetics.ui.swing.slider.CustomCompleteSlider IterationsCompleteSlider;
    private javax.swing.JLabel IterationsLabel;
    private javax.swing.JMenuBar MenuBar;
    private javax.swing.JLabel MutationLabel;
    private group2.genetics.ui.swing.JList MutationList;
    private group2.genetics.ui.swing.slider.CustomCompleteSlider MutationProbabilityCompleteSlider;
    private javax.swing.JLabel MutationProbabilityLabel;
    private javax.swing.JSeparator MutationSeparator;
    private javax.swing.JButton NextStepButton;
    private javax.swing.JButton PlayPauseButton;
    private group2.genetics.ui.swing.slider.CustomCompleteSlider PopulationSizeCompleteSlider;
    private javax.swing.JLabel PopulationSizeLabel;
    private javax.swing.JSeparator PopulationSizeSeparator;
    private javax.swing.JButton ResetButton;
    private javax.swing.JLabel SelectionLabel;
    private group2.genetics.ui.swing.JList SelectionList;
    private javax.swing.JSeparator SelectionSeparator;
    private javax.swing.JLabel StepByStepLabel;
    private group2.genetics.ui.swing.JSwitchButton StepByStepSwitchButton;
    private javax.swing.JButton StopButton;
    private javax.swing.JLabel StopLabel;
    private group2.genetics.ui.swing.JList StopList;
    private javax.swing.JSeparator StopSeparator;
    private group2.genetics.ui.swing.viewsmenu.ViewsMenu ViewsMenu;
    private group2.genetics.ui.swing.IterationsView iterationsView;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private group2.genetics.chronometer.view.LabelChronometer labelChronometer;
    // End of variables declaration//GEN-END:variables
}
