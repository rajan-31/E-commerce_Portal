package com.pbl.ecommerce;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.UIManager;



public class ShoesDisplay extends javax.swing.JFrame {
	private String z;
    static String No1;

    public ShoesDisplay() {
        initComponents();
        populateJTable();
    }

  // create a methode to populate data Into JTable from Mysql  database And Displaying Picture
    
    public void populateJTable(){
        Db_Queryshoe mq1 = new Db_Queryshoe();
        ArrayList<Product> list=mq1.BindTable3();
        String[] columnName = {"No","Name","Cost","Stock","image"};
        Object[][] rows = new Object[list.size()][5];
        for(int i = 0; i < list.size(); i++){
            rows[i][0] = list.get(i).getID();
            rows[i][1] = list.get(i).getName();
            rows[i][2] = list.get(i).getPrice();
            rows[i][3] = list.get(i).getStock();
            if(list.get(i).getMyImage() != null){
                
             ImageIcon image = new ImageIcon(new ImageIcon(list.get(i).getMyImage()).getImage()
             .getScaledInstance(150, 150, Image.SCALE_SMOOTH) );   
                
            rows[i][4] = image;
            }
            else{
                rows[i][4] = null;
            }
            
        }
        
         model = new ModelTable(rows, columnName);
        jTable1.setModel(model);
        jTable1.setRowHeight(150);
        jTable1.getColumnModel().getColumn(4).setPreferredWidth(150);
        
        
      
        jScrollPane1.setViewportView(jTable1);
        
        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup().addContainerGap()
                .addComponent(jScrollPane1)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(248, 248, 248)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 480, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(261, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 480, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 194, Short.MAX_VALUE)
                .addContainerGap())
        );

      
        
    }
    
    
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">    

    private void initComponents() {
    	  jScrollPane1 = new javax.swing.JScrollPane();
          
          jTable1 = new javax.swing.JTable();
          jLabel1 = new javax.swing.JLabel();

          setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
          setBounds(200,200,902,540);
          

          jTable1.setModel(new javax.swing.table.DefaultTableModel(
              new Object [][] {
                  {null, null, null, null},
                  {null, null, null, null},
                  {null, null, null, null},
                  {null, null, null, null},
                  {null, null, null, null},
                  
              },
              new String [] {
                  "Title 1", "Title 2", "Title 3", "Title 4","Title 5"
              }
          ));
          jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
              public void mouseClicked(java.awt.event.MouseEvent evt) {
                
            	  int selectedRowIndex= jTable1.getSelectedRow();
            	  No1=(model.getValueAt(selectedRowIndex,0) .toString());
	                
            	  
              	 
              }
          });
         
    }// </editor-fold>                                                            

  
    // Variables declaration - do not modify                     
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private JFrame frame;
    
    
    private ModelTable model;
   
    // End of variables declaration   
   
}
