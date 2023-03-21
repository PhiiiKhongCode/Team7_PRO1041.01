package view;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */



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
public class ManHinh_11 extends javax.swing.JFrame {

    /**
     * Creates new form ManHinh
     */
    public ManHinh_11() {
        initComponents();
//        ImageIcon iconOMenu = new ImageIcon(getClass().getResource("/Icons/menu.png"));
//        lbOpenMenu.setIcon(new ImageIcon(iconOMenu.getImage().getScaledInstance(lbOpenMenu.getWidth(), lbOpenMenu.getHeight(), 0)));
        ImageIcon iconCMenu = new ImageIcon(getClass().getResource("/Icons/exit.png"));
        lbCloseMenu.setIcon(new ImageIcon(iconCMenu.getImage().getScaledInstance(lbCloseMenu.getWidth(), lbCloseMenu.getHeight(), 0)));
        
//        TableActionEvent event = new TableActionEvent() {
////            @Override
////            public void onEdit(int row) {
////                System.out.println("Edit row: " + row);
////            }
//            
//            @Override
//            public void onDelete(int row) {
//                //Table 0
//                if (table.isEditing()) {
//                    table.getCellEditor().stopCellEditing();
//                }
//                DefaultTableModel model = (DefaultTableModel) table.getModel();
//                model.removeRow(row);
//                System.out.println("Delete row: " + row);
//                
//                
//            }
//        };
//        table.getColumnModel().getColumn(3).setCellRenderer(new TableActionCellRender());
//        table.getColumnModel().getColumn(3).setCellEditor(new TableActionCellEditor(event));
//        
//        
//        //Table 1 mỗi event biểu diễn  sự kiện cho 1 table khác nhau
//        TableActionEvent event1 = new TableActionEvent() {
//            
//
//            @Override
//            public void onDelete(int row) {
//                if(table1.isEditing()){
//                    table1.getCellEditor().stopCellEditing();
//                }
//                DefaultTableModel model1 = (DefaultTableModel) table1.getModel();
//                model1.removeRow(row);
//                System.out.println("Delete on table 1: "+row);
//            }
//        };
//        
//        table1.getColumnModel().getColumn(3).setCellRenderer(new TableActionCellRender());
//        table1.getColumnModel().getColumn(3).setCellEditor(new TableActionCellEditor(event1));
    }
    
    int width = 210;
    int height = 781;

    private void openMenu() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                if (pnBackground.getHeight()> 700) {
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
                if (pnBackground.getHeight() > 700) {
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

        lbOpenMenu = new javax.swing.JLabel();
        pnBackground = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        pnMenuGradient = new keeptoo.KGradientPanel();
        lbLogo = new javax.swing.JLabel();
        pnMenu1 = new javax.swing.JPanel();
        lbMenu1 = new javax.swing.JLabel();
        lbCloseMenu = new javax.swing.JLabel();
        lbMenu2 = new javax.swing.JLabel();
        pnMenu2 = new javax.swing.JPanel();
        lbMenu3 = new javax.swing.JLabel();
        pnMenu3 = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

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
        pnBackground.setMaximumSize(new java.awt.Dimension(1322, 743));
        pnBackground.setPreferredSize(new java.awt.Dimension(1322, 743));
        pnBackground.setLayout(new java.awt.BorderLayout());

        jButton1.setText("Open panel");
        jButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton1MouseClicked(evt);
            }
        });

        jButton2.setText("Open panel");
        jButton2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton2MouseClicked(evt);
            }
        });

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

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(pnMenuGradient, javax.swing.GroupLayout.PREFERRED_SIZE, 0, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(lbOpenMenu, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(layout.createSequentialGroup()
                            .addGap(1, 1, 1)
                            .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)))
                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnBackground, javax.swing.GroupLayout.PREFERRED_SIZE, 1283, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnBackground, javax.swing.GroupLayout.DEFAULT_SIZE, 782, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lbOpenMenu, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28)
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(pnMenuGradient, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void lbOpenMenuMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbOpenMenuMouseClicked
        // TODO add your handling code here:
        openMenu();
    }//GEN-LAST:event_lbOpenMenuMouseClicked

  private pnQuanLyGiay view;
    private void jButton1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton1MouseClicked
        // TODO add your handling code here:
         view = new pnQuanLyGiay();
        pnBackground.removeAll();
        pnBackground.add(view);
        pnBackground.validate();
    }//GEN-LAST:event_jButton1MouseClicked
private pnQuanLyDanhMucGiay viewDM;
    private void jButton2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton2MouseClicked
        // TODO add your handling code here:
        viewDM = new pnQuanLyDanhMucGiay();
        pnBackground.removeAll();
        pnBackground.add(viewDM);
        pnBackground.validate();
    }//GEN-LAST:event_jButton2MouseClicked

    private void lbMenu1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbMenu1MouseClicked
        // TODO add your handling code here:
        changeColorClicked(pnMenu1);
        changeColorUnClicked(pnMenu2);
        changeColorUnClicked(pnMenu3);
    }//GEN-LAST:event_lbMenu1MouseClicked

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
                new ManHinh_11().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
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
    // End of variables declaration//GEN-END:variables
}
