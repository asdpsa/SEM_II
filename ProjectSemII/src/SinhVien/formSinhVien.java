/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SinhVien;

import LopHoc.*;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author acer
 */
public class formSinhVien extends javax.swing.JPanel {

    private DefaultTableModel dtm;
    private DefaultTableModel dtmTK;
    private DefaultComboBoxModel dcbm;
    ArrayList<SinhVien> list = null;
    ArrayList<LopHoc> allClass = null;
    public static String regexDDMMYYYY = "^(0[1-9]|[12][0-9]|3[01])[- /.](0[1-9]|1[012])[- /.](19|20)\\d\\d$";

    public formSinhVien() {
        try {
            initComponents();
            dcbm = new DefaultComboBoxModel();
            dtm = new DefaultTableModel();
            dtmTK = new DefaultTableModel();

            ILopHocDAO lopHocDAO = (ILopHocDAO) Class.forName("LopHoc.LopHocDAO").newInstance();
            allClass = lopHocDAO.getAll();
            for (LopHoc lh : allClass) {
                dcbm.addElement(lh.getMalop());
            }
            jcblop.setModel(dcbm);
            dtm.addColumn("ID");
            dtm.addColumn("Họ Tên");
            dtm.addColumn("ID Lớp");
            dtm.addColumn("Ngày Sinh");
            dtm.addColumn("Địa Chỉ");
            dtm.addColumn("Giới Tính");
            dtm.addColumn("Số ĐT");
            loaddata();

            dtmTK.addColumn("ID");
            dtmTK.addColumn("Họ Tên");
            dtmTK.addColumn("ID Lớp");
            dtmTK.addColumn("Ngày Sinh");
            dtmTK.addColumn("Địa Chỉ");
            dtmTK.addColumn("Giới Tính");
            dtmTK.addColumn("Số ĐT");
            jtbTK.setModel(dtmTK);
        } catch (InstantiationException ex) {
            Logger.getLogger(formSinhVien.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(formSinhVien.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(formSinhVien.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void loaddata() {
        list = new SinhVienDAO().getAll();
        for (SinhVien sv : list) {
            dtm.addRow(toObjectData(sv));
        }
        jtbTTSV.setModel(dtm);
    }

    private static Object[] toObjectData(SinhVien sv) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        String date = dateFormat.format(sv.getNgaySinh());
        Object[] objectData = {sv.getMaSV(), sv.getTenSV(), sv.getMaLop(), date, sv.getDiaChi(), sv.getGioiTinh(), sv.getsDT()};
        return objectData;
    }

    private void showAll() {
        while (dtm.getRowCount() > 0) {
            dtm.removeRow(0);
        }
        ArrayList<SinhVien> svs = new SinhVienDAO().getAll();
        for (SinhVien sv : svs) {
            Vector vector = new Vector();
            vector.add(sv.getMaSV());
            vector.add(sv.getTenSV());
            vector.add(sv.getMaLop());
            SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
            vector.add(dateFormat.format(sv.getNgaySinh()));
            vector.add(sv.getDiaChi());
            vector.add(sv.getGioiTinh());
            vector.add(sv.getsDT());
            dtm.addRow(vector);
        }
        bttAddNew.setEnabled(false);
        bttDelete.setEnabled(false);
        bttEdit.setEnabled(true);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel4 = new javax.swing.JPanel();
        bttAddNew = new javax.swing.JButton();
        bttEdit = new javax.swing.JButton();
        bttRefresh = new javax.swing.JButton();
        bttDelete = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        maSV = new javax.swing.JTextField();
        ngaySinh = new javax.swing.JTextField();
        diaChi = new javax.swing.JTextField();
        sDT = new javax.swing.JTextField();
        jcblop = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        hoTen = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jcbGioiTinh = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel5 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jtbTTSV = new javax.swing.JTable();
        jPanel6 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtbTK = new javax.swing.JTable();
        jtfMaSV = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();

        setPreferredSize(new java.awt.Dimension(887, 429));

        jPanel4.setBackground(new java.awt.Color(153, 204, 255));

        bttAddNew.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        bttAddNew.setForeground(new java.awt.Color(255, 51, 51));
        bttAddNew.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/add_30px.png"))); // NOI18N
        bttAddNew.setText(" Thêm Mới");
        bttAddNew.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        bttAddNew.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bttAddNewActionPerformed(evt);
            }
        });

        bttEdit.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        bttEdit.setForeground(new java.awt.Color(0, 0, 255));
        bttEdit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/edit_file_30px.png"))); // NOI18N
        bttEdit.setText("      Sửa");
        bttEdit.setEnabled(false);
        bttEdit.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        bttEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bttEditActionPerformed(evt);
            }
        });

        bttRefresh.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        bttRefresh.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/refresh_30px.png"))); // NOI18N
        bttRefresh.setText("   Làm Mới");
        bttRefresh.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        bttRefresh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bttRefreshActionPerformed(evt);
            }
        });

        bttDelete.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        bttDelete.setForeground(new java.awt.Color(255, 0, 51));
        bttDelete.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/delete_database_30px.png"))); // NOI18N
        bttDelete.setText("      Xóa");
        bttDelete.setEnabled(false);
        bttDelete.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        bttDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bttDeleteActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(bttRefresh, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(bttDelete, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(bttEdit, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(bttAddNew, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(4, 4, 4)
                .addComponent(bttAddNew, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addComponent(bttEdit, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addComponent(bttDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addComponent(bttRefresh, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(4, 4, 4))
        );

        jcblop.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 51, 255));
        jLabel2.setText("Mã Sinh Viên");

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(0, 51, 255));
        jLabel10.setText("Họ Tên");

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(0, 51, 255));
        jLabel11.setText("Địa Chỉ");

        jLabel12.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(0, 51, 255));
        jLabel12.setText("Số Điện Thoại");

        jLabel13.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(0, 51, 255));
        jLabel13.setText("Ngày Sinh");

        jLabel14.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(0, 51, 255));
        jLabel14.setText("Giới Tính");

        jLabel15.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(0, 51, 255));
        jLabel15.setText("Lớp");

        jcbGioiTinh.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Nam", "Nữ" }));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 0, 204));
        jLabel3.setText("dd/mm/yyyy");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel11)
                            .addComponent(jLabel12)
                            .addComponent(jLabel10))
                        .addGap(17, 17, 17))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel2)
                        .addGap(18, 18, 18)))
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(maSV, javax.swing.GroupLayout.DEFAULT_SIZE, 150, Short.MAX_VALUE)
                                    .addComponent(hoTen))
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel3Layout.createSequentialGroup()
                                        .addGap(58, 58, 58)
                                        .addComponent(jLabel13)
                                        .addGap(19, 19, 19))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(jLabel15)
                                            .addComponent(jLabel14))
                                        .addGap(18, 18, 18))))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(sDT, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(ngaySinh, javax.swing.GroupLayout.DEFAULT_SIZE, 150, Short.MAX_VALUE)
                            .addComponent(jcblop, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jcbGioiTinh, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addComponent(diaChi))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(maSV, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel13)
                    .addComponent(ngaySinh, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addGap(11, 11, 11)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(hoTen, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10)
                    .addComponent(jLabel14)
                    .addComponent(jcbGioiTinh, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(11, 11, 11)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(sDT, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel12)
                    .addComponent(jLabel15)
                    .addComponent(jcblop, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(diaChi, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11))
                .addContainerGap())
        );

        jtbTTSV.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jtbTTSV.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jtbTTSVMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(jtbTTSV);

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 882, Short.MAX_VALUE)
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 220, Short.MAX_VALUE)
        );

        jTabbedPane1.addTab("Sinh Viên", jPanel5);

        jtbTK.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jtbTK.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jtbTKMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jtbTK);

        jtfMaSV.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jtfMaSVKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jtfMaSVKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jtfMaSVKeyTyped(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 204));
        jLabel1.setText("Nhập Mã Sinh Viên");

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(234, 234, 234)
                .addComponent(jLabel1)
                .addGap(35, 35, 35)
                .addComponent(jtfMaSV, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(339, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addGap(0, 10, Short.MAX_VALUE)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jtfMaSV, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jTabbedPane1.addTab("Tìm Kiếm Theo MSV", jPanel6);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(0, 0, 0)
                .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addComponent(jTabbedPane1)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 245, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
    }// </editor-fold>//GEN-END:initComponents

    public void resetForm() {
        maSV.setText("");
        hoTen.setText("");
        ngaySinh.setText("");
        sDT.setText("");
        diaChi.setText("");
        ngaySinh.setText("");
        maSV.requestFocus();
        bttAddNew.setEnabled(true);
        bttEdit.setEnabled(false);
        bttDelete.setEnabled(false);
        maSV.setEnabled(true);
    }

    private void bttRefreshActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bttRefreshActionPerformed
        this.resetForm();
    }//GEN-LAST:event_bttRefreshActionPerformed

    private void bttAddNewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bttAddNewActionPerformed
        String masv = maSV.getText();
        String tensv = hoTen.getText();
        String diachi = diaChi.getText();
        String sdt = sDT.getText();
        String ngaysinh = ngaySinh.getText();
        String gioitinh = (String) jcbGioiTinh.getSelectedItem();
        String malop = allClass.get(jcblop.getSelectedIndex()).getMalop();
        Date d = null;
        if (ngaysinh == null || ngaysinh.equals("") || !ngaysinh.matches(regexDDMMYYYY)) {
            JOptionPane.showMessageDialog(this, "Lỗi ngày sinh", "Hãy nhập lại", JOptionPane.ERROR_MESSAGE);
            ngaySinh.setText("");
            ngaySinh.requestFocus();
            return;
        } else if (masv == null || masv.equals("")) {
            JOptionPane.showMessageDialog(this, "Mã sinh viên trống!!", "Hãy nhập lại", JOptionPane.ERROR_MESSAGE);
            maSV.requestFocus();
            return;
        } else if (tensv == null || tensv.equals("")) {
            JOptionPane.showMessageDialog(this, "Tên sinh viên trống!!", "Hãy nhập lại", JOptionPane.ERROR_MESSAGE);
            maSV.requestFocus();
            return;
        } else if (sdt == null || sdt.equals("")) {
            JOptionPane.showMessageDialog(this, "Số điện thoại trống!!", "Hãy nhập lại", JOptionPane.ERROR_MESSAGE);
            maSV.requestFocus();
            return;
        } else {
            try {
                d = new SimpleDateFormat("dd/MM/yyyy").parse(ngaysinh);
            } catch (ParseException ex) {
                Logger.getLogger(formSinhVien.class.getName()).log(Level.SEVERE, null, ex);
                return;
            }
        }
        SinhVien sinhVien = new SinhVien(masv, tensv, malop, diachi, d, gioitinh, sdt);
        ArrayList<SinhVien> listCheck = new SinhVienDAO().CheckID(masv);
        if (listCheck.size() > 0) {
            JOptionPane.showMessageDialog(this, "Mã ID bị trùng. Vui lòng kiểm tra lại", "Lỗi", JOptionPane.ERROR_MESSAGE);
            maSV.setText("");
            maSV.requestFocus();
        } else {
            SinhVien insert = new SinhVienDAO().addNew(sinhVien);
            if (insert != null) {
                showAll();
            }
        }
        resetForm();
    }//GEN-LAST:event_bttAddNewActionPerformed

    private void bttEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bttEditActionPerformed
        String masv = maSV.getText();
        String tensv = hoTen.getText();
        String diachi = diaChi.getText();
        String sdt = sDT.getText();
        String ngaysinh = ngaySinh.getText();
        String gioitinh = (String) jcbGioiTinh.getSelectedItem();
        String malop = allClass.get(jcblop.getSelectedIndex()).getMalop();
        Date d = null;
        if (ngaysinh == null || ngaysinh.equals("") || !ngaysinh.matches(regexDDMMYYYY)) {
            JOptionPane.showMessageDialog(this, "Lỗi ngày sinh", "Hãy nhập lại", JOptionPane.ERROR_MESSAGE);
            ngaySinh.setText("");
            ngaySinh.requestFocus();
            return;
        }
        if (tensv == null || tensv.equals("")) {
            JOptionPane.showMessageDialog(this, "Tên sinh viên trống!!", "Hãy nhập lại", JOptionPane.ERROR_MESSAGE);
            maSV.requestFocus();
            return;
        } else if (sdt == null || sdt.equals("")) {
            JOptionPane.showMessageDialog(this, "Số điện thoại trống!!", "Hãy nhập lại", JOptionPane.ERROR_MESSAGE);
            maSV.requestFocus();
            return;
        } else {
            try {
                d = new SimpleDateFormat("dd/MM/yyyy").parse(ngaysinh);
            } catch (ParseException ex) {
                Logger.getLogger(formSinhVien.class.getName()).log(Level.SEVERE, null, ex);
                return;
            }
        }
        SinhVien sinhVien = new SinhVien(masv, tensv, malop, diachi, d, gioitinh, sdt);
        int b = JOptionPane.showConfirmDialog(null, "Bạn chắc chắn muốn thay đổi thông tin về sinh viên này?", "Thông Báo", JOptionPane.YES_NO_OPTION);
        if (b == JOptionPane.YES_OPTION) {
            SinhVien updateByID = new SinhVienDAO().updateByID(sinhVien);
            if (updateByID != null) {
                showAll();
            }
        }
        resetForm();
    }//GEN-LAST:event_bttEditActionPerformed

    private void bttDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bttDeleteActionPerformed
        int b = JOptionPane.showConfirmDialog(null, "Bạn chắc chắn muốn xóa dữ liệu này?", "Thông Báo", JOptionPane.YES_NO_OPTION);
        if (b == JOptionPane.YES_OPTION) {
            try {
                String masv = maSV.getText();
                new SinhVienDAO().deleteIDSinhVien(masv);
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(this, "Sinh viên này có điểm, hãy xóa điểm của sinh viên này trước", "Thông báo", JOptionPane.ERROR_MESSAGE);
            } catch (ClassNotFoundException ex) {
                JOptionPane.showMessageDialog(this, "Sinh viên này có điểm, hãy xóa điểm của sinh viên này trước", "Thông báo", JOptionPane.ERROR_MESSAGE);
            }
            while (dtm.getRowCount() > 0) {
                dtm.removeRow(0);
            }
            loaddata();
            resetForm();
        }
    }//GEN-LAST:event_bttDeleteActionPerformed

    private void jtbTTSVMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtbTTSVMouseClicked
        maSV.setText(jtbTTSV.getValueAt(jtbTTSV.getSelectedRow(), 0).toString());
        hoTen.setText(jtbTTSV.getValueAt(jtbTTSV.getSelectedRow(), 1).toString());
        jcblop.setSelectedItem(jtbTTSV.getValueAt(jtbTTSV.getSelectedRow(), 2).toString());
        ngaySinh.setText(jtbTTSV.getValueAt(jtbTTSV.getSelectedRow(), 3).toString());
        diaChi.setText(jtbTTSV.getValueAt(jtbTTSV.getSelectedRow(), 4).toString());
        jcbGioiTinh.setSelectedItem(jtbTTSV.getValueAt(jtbTTSV.getSelectedRow(), 5).toString());
        sDT.setText(jtbTTSV.getValueAt(jtbTTSV.getSelectedRow(), 6).toString());
        bttAddNew.setEnabled(false);
        bttEdit.setEnabled(true);
        bttDelete.setEnabled(true);
        maSV.setEnabled(false);
    }//GEN-LAST:event_jtbTTSVMouseClicked

    private void jtfMaSVKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtfMaSVKeyPressed
        timSV();
    }//GEN-LAST:event_jtfMaSVKeyPressed

    private void jtfMaSVKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtfMaSVKeyReleased
        timSV();
    }//GEN-LAST:event_jtfMaSVKeyReleased

    private void jtfMaSVKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtfMaSVKeyTyped
        timSV();
    }//GEN-LAST:event_jtfMaSVKeyTyped

    private void jtbTKMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtbTKMouseClicked
        maSV.setText(jtbTK.getValueAt(jtbTK.getSelectedRow(), 0).toString());
        hoTen.setText(jtbTK.getValueAt(jtbTK.getSelectedRow(), 1).toString());
        jcblop.setSelectedItem(jtbTK.getValueAt(jtbTK.getSelectedRow(), 2).toString());
        ngaySinh.setText(jtbTK.getValueAt(jtbTK.getSelectedRow(), 3).toString());
        diaChi.setText(jtbTK.getValueAt(jtbTK.getSelectedRow(), 4).toString());
        jcbGioiTinh.setSelectedItem(jtbTK.getValueAt(jtbTK.getSelectedRow(), 5).toString());
        sDT.setText(jtbTK.getValueAt(jtbTK.getSelectedRow(), 6).toString());

        bttAddNew.setEnabled(false);
        bttEdit.setEnabled(true);
        bttDelete.setEnabled(true);
        maSV.setEnabled(false);
    }//GEN-LAST:event_jtbTKMouseClicked

    public void timSV() {
        while (dtmTK.getRowCount() > 0) {
            dtmTK.removeRow(0);
        }
        String masv = jtfMaSV.getText() + "%";
        ArrayList<SinhVien> listSV = new SinhVienDAO().getAllByIDSV(masv);
        for (SinhVien sinhVien : listSV) {
            dtmTK.addRow(toObjectData(sinhVien));
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bttAddNew;
    private javax.swing.JButton bttDelete;
    private javax.swing.JButton bttEdit;
    private javax.swing.JButton bttRefresh;
    private javax.swing.JTextField diaChi;
    private javax.swing.JTextField hoTen;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JComboBox<String> jcbGioiTinh;
    private javax.swing.JComboBox<String> jcblop;
    private javax.swing.JTable jtbTK;
    private javax.swing.JTable jtbTTSV;
    private javax.swing.JTextField jtfMaSV;
    private javax.swing.JTextField maSV;
    private javax.swing.JTextField ngaySinh;
    private javax.swing.JTextField sDT;
    // End of variables declaration//GEN-END:variables
}
