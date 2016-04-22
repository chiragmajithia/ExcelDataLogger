/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MenuHandler;

import dataset.Forms.alumnirecordforms.AlumniDataPanel;
import dataset.Forms.studentrecordforms.StudentRecordChecklistPanel;
import dataset.Workbook;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JComponent;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 *
 * @author Chirag
 */
public class ConnectDatabase extends javax.swing.JPanel
{
    String file_path;
    /**
     * Creates new form ConnectDatabase1
     */
    List<String[]> getStudentRecordHeadings()
    {
        String personal_details[] = {"Name","School","Conselor"};
        String application_fields[] = {"Student Demographic Sheet","Student Photo","Program Application","Income & Eligibility Status","Acceptance Letter","Student Participation Agreemment","Parent Participation Agreement","Financial Literacy Agreement"};
        String summer_forms_fields[] = {"Summer Enrollment Form","Health Information","Immunization Form","Medical History Form","Dietart Restrictions Form","Liability Release Form","Emergency Information Form","Residence Hall/Lost Key,Library Materials Agreement"};
        String academic_fields[] = {"High School Academic Schedule","Grade Reports from school","HSA scores","Student IAP","Student Award","College / University Acceptance Letter","SAT Academy/Summer Schedule"};
        String assessment_fields[] = {"SDS","CSI","Other Assesments"};
        String counseling_fields[] = {"Service Log","Disciplinary Actions","Permission Forms","Parent Hour Forms","Other Counselling Information"};
        String financial_medical_fields[] = {"Payroll Information (I-9,direct deposit forms)"};
        List<String[]> fields = new ArrayList<String[]>();
        fields.add(personal_details);
        fields.add(application_fields);
        fields.add(summer_forms_fields);
        fields.add(academic_fields);
        fields.add(assessment_fields);
        fields.add(counseling_fields);
        fields.add(financial_medical_fields);
        return fields;
    }
    
    List<String[]> getAlumniRecordHeadings()
    {
        String personal_details[] = {"First Name","Middle Name","Last Name","Address","Phone Number","Email ID","Parent Name"};
        String academic_fields[] = {"High School","High School Graduation Year","College Attended","Upward Bound Counselor"};
        List<String[]> fields = new ArrayList<String[]>();
        fields.add(personal_details);
        fields.add(academic_fields);
        return fields;
    }
    
    void createStudentRecordDb()
    {
        List<String[]> headings = getStudentRecordHeadings();
        FileOutputStream out;
        try
        {
            File f = new File(file_path);
            if (!f.exists())
            {
            System.out.println("File not exist");
            Workbook workbook = new Workbook();
            workbook.createWorkbook(file_path);
            workbook.openWorkbook(file_path);
            workbook.createSheet("First Sheet");
            workbook.addHeadings("Student Records",headings);
            jConnect.setEnabled(true);
            }
            else
            {
                final JPanel panel = new JPanel();
                int a = JOptionPane.showConfirmDialog(panel, "File Already exists - connect to it?", "Error", JOptionPane.ERROR_MESSAGE);
                if(a == JOptionPane.YES_OPTION)
                {
                    jConnect.setEnabled(true);
                }
            }
            //jConnect.setEnabled(true);
        }
        catch (Exception ex)
        {
            Logger.getLogger(ConnectDatabase.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    void createAlumniRecordDb()
    {
        List<String[]> headings = getAlumniRecordHeadings();
        FileOutputStream out;
        try
        {
            File f = new File(file_path);
            if (!f.exists())
            {
            System.out.println("File not exist");
            Workbook workbook = new Workbook();
            workbook.createWorkbook(file_path);
            workbook.openWorkbook(file_path);
            workbook.createSheet("Alumnu Records Sheet");
            workbook.addHeadings("Alumni Records",headings);
            jConnect.setEnabled(true);
            }
            else
            {
                final JPanel panel = new JPanel();
                int a = JOptionPane.showConfirmDialog(panel, "File Already exists - connect to it?", "Error", JOptionPane.ERROR_MESSAGE);
                if(a == JOptionPane.YES_OPTION)
                {
                    jConnect.setEnabled(true);
                }
            }
            //jConnect.setEnabled(true);
        }
        catch (Exception ex)
        {
            Logger.getLogger(ConnectDatabase.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    public ConnectDatabase()
    {
        file_path = null;
        initComponents();
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

        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jOpenFolder = new javax.swing.JButton();
        jFilePath = new javax.swing.JTextField();
        jFileNameLabel = new javax.swing.JLabel();
        jFileName = new javax.swing.JTextField();
        jCreate = new javax.swing.JButton();
        jConnect = new javax.swing.JButton();
        jDbType = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();

        jLabel1.setText("Establish Database Connection");

        jLabel2.setText("File / Directory :");

        jOpenFolder.setText("Open Folder");
        jOpenFolder.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                jOpenFolderActionPerformed(evt);
            }
        });

        jFileNameLabel.setText("File Name : ");
        jFileNameLabel.setEnabled(false);

        jFileName.setEnabled(false);
        jFileName.addFocusListener(new java.awt.event.FocusAdapter()
        {
            public void focusLost(java.awt.event.FocusEvent evt)
            {
                jFileNameFocusLost(evt);
            }
        });

        jCreate.setText("Create Database");
        jCreate.setEnabled(false);
        jCreate.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                jCreateActionPerformed(evt);
            }
        });

        jConnect.setText("Connect");
        jConnect.setEnabled(false);
        jConnect.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                jConnectActionPerformed(evt);
            }
        });

        jDbType.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Student Record", "Alumni Record" }));

        jLabel3.setText("Database Type :");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jFileNameLabel)
                            .addComponent(jLabel2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jFileName, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(0, 0, Short.MAX_VALUE)
                                        .addComponent(jCreate)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jConnect, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jFilePath)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jOpenFolder)))
                                .addContainerGap())))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jDbType, javax.swing.GroupLayout.PREFERRED_SIZE, 255, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 204, Short.MAX_VALUE))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jOpenFolder)
                    .addComponent(jFilePath, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jFileNameLabel)
                    .addComponent(jFileName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(16, 16, 16)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jDbType, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jCreate)
                    .addComponent(jConnect))
                .addContainerGap(43, Short.MAX_VALUE))
        );

        jScrollPane1.setViewportView(jPanel1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addComponent(jScrollPane1)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 193, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jOpenFolderActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_jOpenFolderActionPerformed
    {//GEN-HEADEREND:event_jOpenFolderActionPerformed
        JFileChooser chooser = new JFileChooser();
        chooser.setCurrentDirectory(new java.io.File("."));
        chooser.setDialogTitle("Choose a database file");
        chooser.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
        chooser.setAcceptAllFileFilterUsed(false);

        if (chooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION)
        {
            File f = chooser.getSelectedFile();
            jFilePath.setText(f.getAbsolutePath());

            if (f.isDirectory())
            {
                jFileName.setEnabled(true);
                jFileNameLabel.setEnabled(true);
                jCreate.setEnabled(true);
                jConnect.setEnabled(false);
            }
            else
            {
                jFileName.setEnabled(false);
                jFileNameLabel.setEnabled(false);
                jFileName.setText(f.getName());
                jCreate.setEnabled(false);
                file_path = f.getAbsolutePath();
                jConnect.setEnabled(true);
            }

        }
        else
        {
            System.out.println("No Selection ");
        }
        // TODO add your handling code here:
    }//GEN-LAST:event_jOpenFolderActionPerformed

    private void jCreateActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_jCreateActionPerformed
    {//GEN-HEADEREND:event_jCreateActionPerformed
        file_path = jFilePath.getText();
        file_path = jFilePath.getText()+"\\"+jFileName.getText();
        if(jDbType.getSelectedIndex() == 0)
        {
            createStudentRecordDb();
            System.out.println("Student Records Form Created");
        }
        else if(jDbType.getSelectedIndex() == 1)
        {
            createAlumniRecordDb();
            System.out.println("Alumni Record Form Created");
        }
            
    }//GEN-LAST:event_jCreateActionPerformed

    private void jConnectActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_jConnectActionPerformed
    {//GEN-HEADEREND:event_jConnectActionPerformed
        File f = new File(file_path);
         try
        {
            FileInputStream fIP = new FileInputStream(f);
            XSSFWorkbook workbook = new XSSFWorkbook(fIP);
            if (f.isFile() && f.exists())
            {
                System.out.println("openworkbook"+f.getAbsolutePath()+" file open successfully.");
                System.out.println("Start Logging");
            }
        }
        catch (Exception e) 
        {
            System.out.println("Error in opening the file" + e);
        }
        System.out.println("File Path =" + file_path);
        JTabbedPane c = (JTabbedPane) this.getParent();
        Workbook database = new Workbook();
        database.openWorkbook(file_path);
        String db_type = (String)database.readCell(0, 0);
        switch (db_type)
        {
            case "Student Records":
                StudentRecordChecklistPanel  student_records = new StudentRecordChecklistPanel(database);
                c.add(student_records,"Student Records");
                c.setSelectedIndex(c.getTabCount()-1);
                break;
            case "Alumni Records":
                AlumniDataPanel alumini_records = new AlumniDataPanel();
                c.add(alumini_records,"Alumni Records");
                c.setSelectedIndex(c.getTabCount()-1);
                break;
            default:
                System.out.println("Database Mismatch");
                break;
        }
        jConnect.setEnabled(false);
        
    }//GEN-LAST:event_jConnectActionPerformed

    private void jFileNameFocusLost(java.awt.event.FocusEvent evt)//GEN-FIRST:event_jFileNameFocusLost
    {//GEN-HEADEREND:event_jFileNameFocusLost
        if(jFileName.getText() != null && !jFileName.getText().contains(".xlsx"))
            jFileName.setText(jFileName.getText()+".xlsx");// TODO add your handling code here:
    }//GEN-LAST:event_jFileNameFocusLost


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jConnect;
    private javax.swing.JButton jCreate;
    private javax.swing.JComboBox<String> jDbType;
    private javax.swing.JTextField jFileName;
    private javax.swing.JLabel jFileNameLabel;
    private javax.swing.JTextField jFilePath;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JButton jOpenFolder;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
