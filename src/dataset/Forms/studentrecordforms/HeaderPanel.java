/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dataset.Forms.studentrecordforms;


import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import static java.lang.Math.ceil;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JCheckBox;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author Chirag
 */
public class HeaderPanel extends javax.swing.JPanel {

    GridLayout jFieldsPanelLayout;
    List<JCheckBox> checkbox = new ArrayList<JCheckBox>();
    
    public HeaderPanel(String heading, String[] fields) {
        initComponents();
        jHeading.setText(heading);
        System.out.println("Setting GridLayout for" + heading + Double.toString(ceil((float)fields.length/4))+" x 4" );
        System.out.println("ceil("+Integer.toString(fields.length)+"/4) = "+ Double.toString((float)fields.length/4) );
        
        jFieldsPanelLayout = new GridLayout((int)ceil((float)fields.length/4),4);
        jFieldsPanel.setLayout(jFieldsPanelLayout);
        for(int i = 0; i < fields.length; i++)
        {
            final JCheckBox cb = new JCheckBox(fields[i]);
            Dimension d = new Dimension(100,20);
            cb.setPreferredSize(d);
            cb.setMaximumSize(d);
            cb.setMinimumSize(d);
            checkbox.add(cb);
            jFieldsPanel.add(cb);
            cb.addFocusListener(new FocusListener(){

                @Override
                public void focusGained(FocusEvent fe) {
                   JComponent c = (JComponent) cb.getParent().getParent();
                   c.scrollRectToVisible(cb.getBounds());
                   System.out.println("Parent" + c);
                    //                  cb.getBounds()
                   //To change body of generated methods, choose Tools | Templates.
                }

                @Override
                public void focusLost(FocusEvent fe) {
                    //To change body of generated methods, choose Tools | Templates.
                }
            });
            cb.setVisible(true);
        }
        int diff = (fields.length  % 4 != 0 ? 4 - (fields.length) % 4:0);
        System.out.println("Diff : "+ Integer.toString(diff));
        for(int i = 0; i < diff;i++)
            jFieldsPanel.add(new JLabel(""));
    }
    
    public JPanel getFieldsPanel()
    {
        return jFieldsPanel;
    }
    
    public String[] getHeaders()
    {
        String fields[] = new String[checkbox.size()];
        int i = 0;
        for(JCheckBox cb : checkbox)
        {
            fields[i++] = cb.getText();
        }
        return fields;
    }
    public Boolean[] getFieldsValue()
    {
        System.out.println("Getting Fields Value ");
        System.out.println("size of checkbox" + Integer.toString(checkbox.size()));
        Boolean vals[] = new Boolean[checkbox.size()];

        for(int i = 0;i < checkbox.size();i++)
        {
            JCheckBox cb = checkbox.get(i);
            vals[i] = cb.isSelected();
            System.out.println(Integer.toString(i) + ": " +cb.getText() + ": " + cb.isSelected());
        }
        System.out.println("Returning Fields Value ");
        return vals;
    }
    public List<JCheckBox> getCheckBox()
    {
        return checkbox;
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents()
    {

        jHeading = new javax.swing.JLabel();
        jFieldsPanel = new javax.swing.JPanel();

        addFocusListener(new java.awt.event.FocusAdapter()
        {
            public void focusGained(java.awt.event.FocusEvent evt)
            {
                formFocusGained(evt);
            }
        });

        jHeading.setBackground(new java.awt.Color(204, 204, 255));
        jHeading.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jHeading.setText("HEADING");
        jHeading.setOpaque(true);

        jFieldsPanel.setBackground(new java.awt.Color(255, 255, 204));

        javax.swing.GroupLayout jFieldsPanelLayout = new javax.swing.GroupLayout(jFieldsPanel);
        jFieldsPanel.setLayout(jFieldsPanelLayout);
        jFieldsPanelLayout.setHorizontalGroup(
            jFieldsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jFieldsPanelLayout.setVerticalGroup(
            jFieldsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 419, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jHeading, javax.swing.GroupLayout.DEFAULT_SIZE, 981, Short.MAX_VALUE)
            .addComponent(jFieldsPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jHeading)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jFieldsPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void formFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_formFocusGained
        System.out.println("Here");        // TODO add your handling code here:
    }//GEN-LAST:event_formFocusGained


    // Variables declaration - do not modify//GEN-BEGIN:variables
    protected javax.swing.JPanel jFieldsPanel;
    protected javax.swing.JLabel jHeading;
    // End of variables declaration//GEN-END:variables
    public static void main(String args[]) throws Exception {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                String f[] = {"box 1","box 2"};
                HeaderPanel hp = new HeaderPanel("Panel No.1",f);
                hp.setVisible(true);
            }
        });
    }

    void resetFieldsValue() {
        for(JCheckBox c : checkbox)
        {
            c.setSelected(false);
        }
    }
}
