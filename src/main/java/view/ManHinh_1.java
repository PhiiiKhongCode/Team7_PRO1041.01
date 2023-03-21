/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package view;


import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.Insets;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author PhiLT
 */
public class ManHinh_1 extends javax.swing.JFrame {

    /**
     * Creates new form ManHinh
     */
    public ManHinh_1() {
        initComponents();
//        ImageIcon iconOMenu = new ImageIcon(getClass().getResource("/Icons/menu.png"));
//        lbOpenMenu.setIcon(new ImageIcon(iconOMenu.getImage().getScaledInstance(lbOpenMenu.getWidth(), lbOpenMenu.getHeight(), 0)));
        ImageIcon iconCMenu = new ImageIcon(getClass().getResource("/Icons/exit.png"));
        lbCloseMenu.setIcon(new ImageIcon(iconCMenu.getImage().getScaledInstance(lbCloseMenu.getWidth(), lbCloseMenu.getHeight(), 0)));
        
    }
    
    int width = 210;
    int height = 650;

    private void openMenu() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                if (pnBackground.getWidth() > width) {
                    for (int i = 0; i < width; i++) {
                        pnMenuGradient.setSize(i, 1920);
                        try {
                            Thread.sleep(1);
                        } catch (InterruptedException ex) {
                            ex.printStackTrace();
                        }
                    }                    
                } else {
                    for (int i = 0; i < width; i++) {
                        pnMenuGradient.setSize(i, height);
                        try {
                            Thread.sleep(1);
                        } catch (InterruptedException ex) {
                            ex.printStackTrace();
                        }
                    }                    
                }
            }
        }).start();
    }

    private void closeMenu() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                if (pnBackground.getWidth() > width) {
                    for (int i = width; i > 0; i--) {
                        pnMenuGradient.setSize(i, 1920);
                        try {
                            Thread.sleep(1);
                        } catch (InterruptedException ex) {
                            ex.printStackTrace();
                        }
                    }                    
                } else {
                    for (int i = width; i > 0; i--) {
                        pnMenuGradient.setSize(i, height);
                        try {
                            Thread.sleep(1);
                        } catch (InterruptedException ex) {
                            ex.printStackTrace();
                        }
                    }                    
                }
            }
        }).start();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnMenuGradient = new keeptoo.KGradientPanel();
        lbLogo = new javax.swing.JLabel();
        pnMenu1 = new javax.swing.JPanel();
        lbMenu1 = new javax.swing.JLabel();
        lbCloseMenu = new javax.swing.JLabel();
        lbMenu2 = new javax.swing.JLabel();
        pnMenu2 = new javax.swing.JPanel();
        lbMenu3 = new javax.swing.JLabel();
        pnMenu3 = new javax.swing.JPanel();
        lbOpenMenu = new javax.swing.JLabel();
        pnBackground = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        table = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        table1 = new javax.swing.JTable();
        jTextField1 = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        pnMenuGradient.setBackground(new java.awt.Color(0, 204, 204));
        pnMenuGradient.setkEndColor(new java.awt.Color(255, 0, 102));
        pnMenuGradient.setkStartColor(new java.awt.Color(255, 153, 153));
        pnMenuGradient.setOpaque(false);

        lbLogo.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        lbLogo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Logo.png"))); // NOI18N

        pnMenu1.setBackground(new java.awt.Color(0, 0, 0));
        pnMenu1.setAlignmentX(0.0F);
        pnMenu1.setAlignmentY(0.0F);
        pnMenu1.setOpaque(false);

        javax.swing.GroupLayout pnMenu1Layout = new javax.swing.GroupLayout(pnMenu1);
        pnMenu1.setLayout(pnMenu1Layout);
        pnMenu1Layout.setHorizontalGroup(
            pnMenu1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 10, Short.MAX_VALUE)
        );
        pnMenu1Layout.setVerticalGroup(
            pnMenu1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        lbMenu1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lbMenu1.setForeground(new java.awt.Color(255, 255, 255));
        lbMenu1.setText("Trang chủ");
        lbMenu1.setAlignmentY(0.0F);
        lbMenu1.setAutoscrolls(true);
        lbMenu1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbMenu1MouseClicked(evt);
            }
        });

        lbCloseMenu.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbCloseMenuMouseClicked(evt);
            }
        });

        lbMenu2.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lbMenu2.setForeground(new java.awt.Color(255, 255, 255));
        lbMenu2.setText("Khách");
        lbMenu2.setAlignmentY(0.0F);
        lbMenu2.setAutoscrolls(true);
        lbMenu2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbMenu2MouseClicked(evt);
            }
        });

        pnMenu2.setBackground(new java.awt.Color(0, 0, 0));
        pnMenu2.setAlignmentX(0.0F);
        pnMenu2.setAlignmentY(0.0F);
        pnMenu2.setOpaque(false);

        javax.swing.GroupLayout pnMenu2Layout = new javax.swing.GroupLayout(pnMenu2);
        pnMenu2.setLayout(pnMenu2Layout);
        pnMenu2Layout.setHorizontalGroup(
            pnMenu2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        pnMenu2Layout.setVerticalGroup(
            pnMenu2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 73, Short.MAX_VALUE)
        );

        lbMenu3.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lbMenu3.setForeground(new java.awt.Color(255, 255, 255));
        lbMenu3.setText("Hóa đơn");
        lbMenu3.setAlignmentY(0.0F);
        lbMenu3.setAutoscrolls(true);
        lbMenu3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbMenu3MouseClicked(evt);
            }
        });

        pnMenu3.setBackground(new java.awt.Color(0, 0, 0));
        pnMenu3.setAlignmentX(0.0F);
        pnMenu3.setAlignmentY(0.0F);
        pnMenu3.setOpaque(false);

        javax.swing.GroupLayout pnMenu3Layout = new javax.swing.GroupLayout(pnMenu3);
        pnMenu3.setLayout(pnMenu3Layout);
        pnMenu3Layout.setHorizontalGroup(
            pnMenu3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        pnMenu3Layout.setVerticalGroup(
            pnMenu3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout pnMenuGradientLayout = new javax.swing.GroupLayout(pnMenuGradient);
        pnMenuGradient.setLayout(pnMenuGradientLayout);
        pnMenuGradientLayout.setHorizontalGroup(
            pnMenuGradientLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnMenuGradientLayout.createSequentialGroup()
                .addGroup(pnMenuGradientLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnMenuGradientLayout.createSequentialGroup()
                        .addGroup(pnMenuGradientLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(pnMenu1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(pnMenu3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(pnMenu2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(pnMenuGradientLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(lbMenu2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lbMenu1, javax.swing.GroupLayout.DEFAULT_SIZE, 188, Short.MAX_VALUE)
                            .addComponent(lbMenu3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnMenuGradientLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(lbCloseMenu, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnMenuGradientLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(lbLogo)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pnMenuGradientLayout.setVerticalGroup(
            pnMenuGradientLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnMenuGradientLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lbCloseMenu, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31)
                .addComponent(lbLogo)
                .addGap(78, 78, 78)
                .addGroup(pnMenuGradientLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(pnMenu1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lbMenu1, javax.swing.GroupLayout.DEFAULT_SIZE, 73, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnMenuGradientLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pnMenu2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbMenu2, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnMenuGradientLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(pnMenu3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lbMenu3, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        lbOpenMenu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/menu.png"))); // NOI18N
        lbOpenMenu.setOpaque(true);
        lbOpenMenu.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbOpenMenuMouseClicked(evt);
            }
        });

        pnBackground.setBackground(new java.awt.Color(255, 255, 255));
        pnBackground.setAlignmentX(0.0F);
        pnBackground.setAlignmentY(0.0F);

        jScrollPane1.setBorder(null);

        table.setAutoCreateRowSorter(true);
        table.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Số thứ tự", "Mã", "Tên", "Action"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        table.setGridColor(new java.awt.Color(255, 255, 255));
        table.setIntercellSpacing(new java.awt.Dimension(5, 5));
        table.setRowHeight(43);
        table.setSelectionBackground(new java.awt.Color(255, 204, 204));
        jScrollPane1.setViewportView(table);

        jScrollPane2.setBorder(null);

        table1.setAutoCreateRowSorter(true);
        table1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        table1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Số thứ tự", "Mã", "Tên", "Action"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        table1.setGridColor(new java.awt.Color(255, 255, 255));
        table1.setIntercellSpacing(new java.awt.Dimension(5, 5));
        table1.setRowHeight(43);
        table1.setSelectionBackground(new java.awt.Color(255, 204, 204));
        jScrollPane2.setViewportView(table1);

        jTextField1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, new java.awt.Color(0, 0, 0), null, null, new java.awt.Color(0, 0, 0)));

        jLabel1.setText("Mã");

        jTextField2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, new java.awt.Color(0, 0, 0), null, null, new java.awt.Color(0, 0, 0)));

        jLabel2.setText("Tên");

        javax.swing.GroupLayout pnBackgroundLayout = new javax.swing.GroupLayout(pnBackground);
        pnBackground.setLayout(pnBackgroundLayout);
        pnBackgroundLayout.setHorizontalGroup(
            pnBackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnBackgroundLayout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 473, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 182, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 444, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(160, 160, 160))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnBackgroundLayout.createSequentialGroup()
                .addGap(222, 222, 222)
                .addGroup(pnBackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(pnBackgroundLayout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pnBackgroundLayout.createSequentialGroup()
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(177, 870, Short.MAX_VALUE))
        );
        pnBackgroundLayout.setVerticalGroup(
            pnBackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnBackgroundLayout.createSequentialGroup()
                .addContainerGap(38, Short.MAX_VALUE)
                .addGroup(pnBackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addGap(23, 23, 23)
                .addGroup(pnBackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGap(54, 54, 54)
                .addGroup(pnBackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(14, 14, 14))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(pnMenuGradient, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lbOpenMenu, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
                    .addComponent(pnBackground, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(lbOpenMenu, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnBackground, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(pnMenuGradient, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents
    /*
    width: 210px
    height: 650px
     */
    private void lbMenu1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbMenu1MouseClicked
        // TODO add your handling code here:
        changeColorClicked(pnMenu1);
        changeColorUnClicked(pnMenu2);
        changeColorUnClicked(pnMenu3);
    }//GEN-LAST:event_lbMenu1MouseClicked

    private void lbOpenMenuMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbOpenMenuMouseClicked
        // TODO add your handling code here:
        openMenu();
    }//GEN-LAST:event_lbOpenMenuMouseClicked

    private void lbCloseMenuMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbCloseMenuMouseClicked
        // TODO add your handling code here:
        closeMenu();
    }//GEN-LAST:event_lbCloseMenuMouseClicked

    private void lbMenu2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbMenu2MouseClicked
        // TODO add your handling code here:
        changeColorClicked(pnMenu2);
        changeColorUnClicked(pnMenu1);
        changeColorUnClicked(pnMenu3);
    }//GEN-LAST:event_lbMenu2MouseClicked

    private void lbMenu3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbMenu3MouseClicked
        // TODO add your handling code here:
        changeColorClicked(pnMenu3);
        changeColorUnClicked(pnMenu1);
        changeColorUnClicked(pnMenu2);
    }//GEN-LAST:event_lbMenu3MouseClicked

    private void buttonCell1MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_buttonCell1MouseExited
        // TODO add your handling code here:
        
    }//GEN-LAST:event_buttonCell1MouseExited

    private void buttonCell2MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_buttonCell2MouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_buttonCell2MouseExited

    private void changeColorClicked(JPanel panel){
       panel.setBackground(new Color(90, 90, 90));
       panel.setOpaque(true);
    }
    private void changeColorUnClicked(JPanel panel){
        panel.setBackground(new Color(70, 90, 90));
        panel.setOpaque(false);
    }
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
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        } catch (InstantiationException ex) {
            ex.printStackTrace();
        } catch (IllegalAccessException ex) {
            ex.printStackTrace();
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            ex.printStackTrace();
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ManHinh_1().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JLabel lbCloseMenu;
    private javax.swing.JLabel lbLogo;
    private javax.swing.JLabel lbMenu1;
    private javax.swing.JLabel lbMenu2;
    private javax.swing.JLabel lbMenu3;
    private javax.swing.JLabel lbOpenMenu;
    private javax.swing.JPanel pnBackground;
    private javax.swing.JPanel pnMenu1;
    private javax.swing.JPanel pnMenu2;
    private javax.swing.JPanel pnMenu3;
    private keeptoo.KGradientPanel pnMenuGradient;
    private javax.swing.JTable table;
    private javax.swing.JTable table1;
    // End of variables declaration//GEN-END:variables
}