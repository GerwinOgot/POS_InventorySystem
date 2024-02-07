/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */

/**
 *
 * @author GJ
 */
import java.sql.*;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
public class inventoryadmin extends javax.swing.JFrame {

    public inventoryadmin() {
        initComponents();
        Connect();
        Fetch();
        Fetch1();
        jPanel4.setVisible(false);
    }
    
    Connection con; 
    PreparedStatement pst;
    ResultSet rs;
    
    public void Connect () {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/choco_users","root","admin");
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(inventoryadmin.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @SuppressWarnings("unchecked")
    private void Fetch(){
        try {
            int a;
            pst = con.prepareStatement("SELECT * FROM inventory");
            rs = pst.executeQuery();
            ResultSetMetaData rss = rs.getMetaData();
            a = rss.getColumnCount();
            
            DefaultTableModel df = (DefaultTableModel)producttable.getModel();
            df.setRowCount(0);
            while(rs.next()){
                Vector v2 = new Vector();
                for(int x=1; x<=a; x++){
                    v2.add(rs.getString("product_id"));
                    v2.add(rs.getString("product_name"));
                    v2.add(rs.getString("category"));
                    v2.add(rs.getString("expiration_date"));
                    v2.add(rs.getString("current_quantity"));
                    v2.add(rs.getString("unit_cost"));
                }
                df.addRow(v2);
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(inventoryadmin.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @SuppressWarnings("unchecked")
    private void Fetch1(){
        try {
            int a;
            pst = con.prepareStatement("SELECT * FROM inventory WHERE current_quantity >0");
            rs = pst.executeQuery();
            ResultSetMetaData rss = rs.getMetaData();
            a = rss.getColumnCount();
            
            DefaultTableModel df = (DefaultTableModel)producttable1.getModel();
            df.setRowCount(0);
            while(rs.next()){
                Vector v2 = new Vector();
                for(int x=1; x<=a; x++){
                    v2.add(rs.getString("product_id"));
                    v2.add(rs.getString("product_name"));
                    v2.add(rs.getString("category"));
                    v2.add(rs.getString("expiration_date"));
                    v2.add(rs.getString("current_quantity"));
                    v2.add(rs.getString("unit_cost"));
                }
                df.addRow(v2);
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(inventoryadmin.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        transaction = new javax.swing.JButton();
        sales = new javax.swing.JButton();
        inventory = new javax.swing.JButton();
        access = new javax.swing.JButton();
        home = new javax.swing.JButton();
        logout = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        product1 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        producttable1 = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        product = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        producttable = new javax.swing.JTable();
        edit = new javax.swing.JButton();
        add = new javax.swing.JButton();
        delete = new javax.swing.JButton();
        ibalik = new javax.swing.JButton();
        ibalik1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(4, 12, 23));

        transaction.setBackground(new java.awt.Color(11, 44, 89));
        transaction.setFont(new java.awt.Font("Segoe UI Light", 1, 24)); // NOI18N
        transaction.setForeground(new java.awt.Color(255, 255, 255));
        transaction.setText("TRANSACTION");
        transaction.setBorder(null);
        transaction.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                transactionActionPerformed(evt);
            }
        });

        sales.setBackground(new java.awt.Color(11, 44, 89));
        sales.setFont(new java.awt.Font("Segoe UI Light", 1, 24)); // NOI18N
        sales.setForeground(new java.awt.Color(255, 255, 255));
        sales.setText("SALES");
        sales.setBorder(null);
        sales.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                salesActionPerformed(evt);
            }
        });

        inventory.setBackground(new java.awt.Color(11, 44, 89));
        inventory.setFont(new java.awt.Font("Segoe UI Light", 1, 24)); // NOI18N
        inventory.setForeground(new java.awt.Color(255, 255, 255));
        inventory.setText("INVENTORY");
        inventory.setBorder(null);
        inventory.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                inventoryActionPerformed(evt);
            }
        });

        access.setBackground(new java.awt.Color(11, 44, 89));
        access.setFont(new java.awt.Font("Segoe UI Light", 1, 24)); // NOI18N
        access.setForeground(new java.awt.Color(255, 255, 255));
        access.setText("ACCESS");
        access.setBorder(null);
        access.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                accessActionPerformed(evt);
            }
        });

        home.setBackground(new java.awt.Color(4, 12, 23));
        home.setForeground(new java.awt.Color(255, 255, 255));
        home.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/1 (1).jpg"))); // NOI18N
        home.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        home.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                homeActionPerformed(evt);
            }
        });

        logout.setBackground(new java.awt.Color(4, 12, 23));
        logout.setForeground(new java.awt.Color(255, 255, 255));
        logout.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/2.jpg"))); // NOI18N
        logout.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        logout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                logoutActionPerformed(evt);
            }
        });

        jPanel4.setBackground(new java.awt.Color(217, 217, 217));

        product1.setFont(new java.awt.Font("Segoe UI Semibold", 1, 18)); // NOI18N
        product1.setForeground(new java.awt.Color(4, 12, 23));
        product1.setText("PRODUCTS");
        product1.setPreferredSize(new java.awt.Dimension(10, 10));

        producttable1.setBackground(new java.awt.Color(204, 204, 204));
        producttable1.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        producttable1.setForeground(new java.awt.Color(4, 12, 23));
        producttable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Product ID", "Product Name", "Category", "Expiration Date", "Current Quantity", "Unit Cost"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        producttable1.setSelectionForeground(new java.awt.Color(4, 12, 23));
        jScrollPane2.setViewportView(producttable1);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(product1, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(product1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(33, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(access, javax.swing.GroupLayout.PREFERRED_SIZE, 234, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(sales, javax.swing.GroupLayout.PREFERRED_SIZE, 234, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(inventory, javax.swing.GroupLayout.PREFERRED_SIZE, 234, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(transaction, javax.swing.GroupLayout.PREFERRED_SIZE, 234, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(31, 31, 31))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(home, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(logout, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(92, 92, 92)
                .addComponent(transaction, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(54, 54, 54)
                .addComponent(inventory, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(50, 50, 50)
                .addComponent(sales, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(54, 54, 54)
                .addComponent(access, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(home, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(logout, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        jPanel2.setBackground(new java.awt.Color(65, 93, 124));

        jPanel3.setBackground(new java.awt.Color(217, 217, 217));

        product.setFont(new java.awt.Font("Segoe UI Semibold", 1, 18)); // NOI18N
        product.setForeground(new java.awt.Color(4, 12, 23));
        product.setText("PRODUCTS");

        producttable.setBackground(new java.awt.Color(204, 204, 204));
        producttable.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        producttable.setForeground(new java.awt.Color(4, 12, 23));
        producttable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Product ID", "Product Name", "Category", "Expiration Date", "Current Quantity", "Unit Cost"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        producttable.setSelectionForeground(new java.awt.Color(4, 12, 23));
        jScrollPane1.setViewportView(producttable);

        edit.setBackground(new java.awt.Color(11, 44, 89));
        edit.setFont(new java.awt.Font("Segoe UI Light", 1, 10)); // NOI18N
        edit.setForeground(new java.awt.Color(255, 255, 255));
        edit.setText("EDIT");
        edit.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        edit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editActionPerformed(evt);
            }
        });

        add.setBackground(new java.awt.Color(11, 44, 89));
        add.setFont(new java.awt.Font("Segoe UI Light", 1, 10)); // NOI18N
        add.setForeground(new java.awt.Color(255, 255, 255));
        add.setText("ADD");
        add.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        add.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addActionPerformed(evt);
            }
        });

        delete.setBackground(new java.awt.Color(11, 44, 89));
        delete.setFont(new java.awt.Font("Segoe UI Light", 1, 10)); // NOI18N
        delete.setForeground(new java.awt.Color(255, 255, 255));
        delete.setText("DELETE");
        delete.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        delete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteActionPerformed(evt);
            }
        });

        ibalik.setBackground(new java.awt.Color(11, 44, 89));
        ibalik.setFont(new java.awt.Font("Segoe UI Light", 1, 10)); // NOI18N
        ibalik.setForeground(new java.awt.Color(255, 255, 255));
        ibalik.setText("RETURN");
        ibalik.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        ibalik.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ibalikActionPerformed(evt);
            }
        });

        ibalik1.setBackground(new java.awt.Color(11, 44, 89));
        ibalik1.setFont(new java.awt.Font("Segoe UI Light", 1, 10)); // NOI18N
        ibalik1.setForeground(new java.awt.Color(255, 255, 255));
        ibalik1.setText("SEE RETURNED PRODUCTS");
        ibalik1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        ibalik1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ibalik1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(33, 33, 33)
                                .addComponent(edit, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(37, 37, 37)
                                .addComponent(add, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(delete, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(69, 69, 69)
                                .addComponent(ibalik, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(ibalik1, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 739, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(product, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(22, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(product)
                    .addComponent(ibalik1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 481, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ibalik, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(delete, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(add, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(edit, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(15, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(17, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(36, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void addActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addActionPerformed
        inventoryadmin_addstock i = new inventoryadmin_addstock();
        i.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_addActionPerformed

    private void deleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteActionPerformed
        try {
            DefaultTableModel models = (DefaultTableModel) producttable.getModel();
            if(producttable.getSelectedRowCount()==0){
                JOptionPane.showMessageDialog(this, "Product not selected");
            }
            else{
                int row = producttable.getSelectedRow();
                String selected = (String) producttable.getModel().getValueAt(row, 0);
                pst = con.prepareStatement("DELETE FROM inventory WHERE product_id=?");
                pst.setString(1,selected);
                int k = pst.executeUpdate();
                if (k==1){
                    JOptionPane.showMessageDialog(this, "Product deleted");
                    Fetch();
                }
                else{
                    JOptionPane.showMessageDialog(this, "Product not deleted");
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(accessadmin.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_deleteActionPerformed

    private void ibalikActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ibalikActionPerformed
        inventoryadmin_return i = new inventoryadmin_return();
        i.setVisible(true);
        this.dispose();        // TODO add your handling code here:
    }//GEN-LAST:event_ibalikActionPerformed

    private void transactionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_transactionActionPerformed
       this.dispose();
       homepageadmin h = new homepageadmin();
       h.setVisible(true);
    }//GEN-LAST:event_transactionActionPerformed

    private void salesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_salesActionPerformed
        this.dispose();
        salesadmin s = new salesadmin();
        s.setVisible(true);
    }//GEN-LAST:event_salesActionPerformed

    private void accessActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_accessActionPerformed
        this.dispose();
        accessadmin a = new accessadmin ();
        a.setVisible(true);
    }//GEN-LAST:event_accessActionPerformed

    private void inventoryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_inventoryActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_inventoryActionPerformed

    private void homeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_homeActionPerformed
        this.dispose(); 
        Homepage p = new Homepage();
        p.setVisible(true);// TODO add your handling code here:
    }//GEN-LAST:event_homeActionPerformed

    private void logoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_logoutActionPerformed
        int result = JOptionPane.showConfirmDialog(null,"Sure? You want to exit?", "Swing Tester",
               JOptionPane.YES_NO_OPTION,
               JOptionPane.QUESTION_MESSAGE);
            if(result == JOptionPane.YES_OPTION){
               this.dispose();
                LOGIN l = new LOGIN();
                l.show();
            }else if (result == JOptionPane.NO_OPTION){
             this.show();
            }
    }//GEN-LAST:event_logoutActionPerformed

    private void ibalik1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ibalik1ActionPerformed
        return_product r = new return_product();
        r.setVisible(true);
        r.setDefaultCloseOperation(r.HIDE_ON_CLOSE);
    }//GEN-LAST:event_ibalik1ActionPerformed

    private void editActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editActionPerformed
        inventoryadmin_edit i = new inventoryadmin_edit();
        i.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_editActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
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
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(inventoryadmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new inventoryadmin().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton access;
    private javax.swing.JButton add;
    private javax.swing.JButton delete;
    private javax.swing.JButton edit;
    private javax.swing.JButton home;
    private javax.swing.JButton ibalik;
    private javax.swing.JButton ibalik1;
    private javax.swing.JButton inventory;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JButton logout;
    private javax.swing.JLabel product;
    private javax.swing.JLabel product1;
    public javax.swing.JTable producttable;
    public javax.swing.JTable producttable1;
    private javax.swing.JButton sales;
    private javax.swing.JButton transaction;
    // End of variables declaration//GEN-END:variables
}
