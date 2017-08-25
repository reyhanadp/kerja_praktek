/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package datapulsa;

import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 * NIM : 10114279
 * Nama : Muhamad Solahudin
 * Kelas : Basdat-8
 * @author Muhamad Solahudin
 */
public class Main extends javax.swing.JFrame {

    /**
     * Creates new form Main
     */
    public DefaultTableModel dtm = new DefaultTableModel();
    
    public Main() {
        initComponents();
        tampilTabel();
        disable();

        Data_Pulsa.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                if (e.getClickCount() > 1) {
                    Data_Pulsa.getCellEditor().stopCellEditing();
                }
            }
        });
    }
    
    public void tampilTabel() {
        String columns[] = {"Kode Pulsa", "Provider", "Nominal", "Harga Beli", "Harga Jual"};
        dtm.setColumnIdentifiers(columns);

        String line;
        BufferedReader reader;
        try {
            reader = new BufferedReader(new FileReader("pulsa.txt"));
            while ((line = reader.readLine()) != null) {
                dtm.addRow(line.split("\t"));
            }
            Data_Pulsa.setModel(dtm);
            reader.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "File Baru Telah Di Buat", "INFORMATION", JOptionPane.INFORMATION_MESSAGE);
            File log = new File("pulsa.txt");
            try {
                log.createNewFile();
            } catch (Exception y) {
            }
            tampilTabel();
        }
    }
	
	
	public static void cetakKeFile(String pNamaFile, StringBuffer pDataTabel) throws IOException {
        BufferedWriter output = new BufferedWriter(new FileWriter(pNamaFile));
        output.write(pDataTabel.toString());
        output.flush();
        output.close();
    }
    
    private void saveTable() throws IOException {
        StringBuffer sbTableData = new StringBuffer();

        for (int row = 0; row < Data_Pulsa.getRowCount(); row++) {
            for (int column = 0; column < Data_Pulsa.getColumnCount(); column++) {
                sbTableData.append(Data_Pulsa.getValueAt(row, column)).append("\t");
            }
            sbTableData.append(System.getProperty("line.separator"));
        }
        cetakKeFile("pulsa.txt", sbTableData);
        clear();
    }
	
	public void disable() {
        provider.setEnabled(false);
        nominal.setEnabled(false);
        kode_pulsa.setEnabled(false);
        harga_beli.setEnabled(false);
        harga_jual.setEnabled(false);
        simpan.setEnabled(false);
        batal.setEnabled(false);
    }

    public void enable() {
        provider.setEnabled(true);
        nominal.setEnabled(true);
        kode_pulsa.setEnabled(true);
        harga_beli.setEnabled(true);
        harga_jual.setEnabled(true);
        simpan.setEnabled(true);
        batal.setEnabled(true);
    }

    public void clear() {
        provider.setText("");
        kode_pulsa.setText("");
        nominal.setText("");
        harga_beli.setText("");
        harga_jual.setText("");
    }
    
    public void HanyaAngka(java.awt.event.KeyEvent evt) {
        char c = evt.getKeyChar();
        if (!((Character.isDigit(c) || (c == KeyEvent.VK_BACK_SPACE) || (c == KeyEvent.VK_DELETE)))) {
            JOptionPane.showMessageDialog(null, "Hanya Boleh Angka !");
            evt.consume();
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

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        kode_pulsa = new javax.swing.JTextField();
        harga_jual = new javax.swing.JTextField();
        provider = new javax.swing.JTextField();
        nominal = new javax.swing.JTextField();
        harga_beli = new javax.swing.JTextField();
        tambah = new javax.swing.JButton();
        simpan = new javax.swing.JButton();
        edit = new javax.swing.JButton();
        batal = new javax.swing.JButton();
        hapus = new javax.swing.JButton();
        exit = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        pilih_cari = new javax.swing.JComboBox();
        cari = new javax.swing.JTextField();
        bcari = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        Data_Pulsa = new javax.swing.JTable();
        jLabel8 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Microsoft YaHei UI", 1, 18)); // NOI18N
        jLabel1.setText("Data Pulsa");

        jLabel2.setText("Kode Pulsa");

        jLabel3.setText("Provider");

        jLabel4.setText("Nominal");

        jLabel5.setText("Harga Beli");

        jLabel6.setText("Harga Jual");

        harga_jual.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                harga_jualKeyTyped(evt);
            }
        });

        provider.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                providerActionPerformed(evt);
            }
        });

        nominal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nominalActionPerformed(evt);
            }
        });
        nominal.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                nominalKeyTyped(evt);
            }
        });

        harga_beli.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                harga_beliKeyTyped(evt);
            }
        });

        tambah.setText("Tambah");
        tambah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tambahActionPerformed(evt);
            }
        });

        simpan.setText("Simpan");
        simpan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                simpanActionPerformed(evt);
            }
        });

        edit.setText("Edit");
        edit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editActionPerformed(evt);
            }
        });

        batal.setText("Batal");
        batal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                batalActionPerformed(evt);
            }
        });

        hapus.setText("Hapus");
        hapus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                hapusActionPerformed(evt);
            }
        });

        exit.setText("Exit");
        exit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exitActionPerformed(evt);
            }
        });

        jLabel7.setText("Cari Berdasarkan :");

        pilih_cari.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Kode Pulsa", "Provider" }));
        pilih_cari.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pilih_cariActionPerformed(evt);
            }
        });

        bcari.setText("Cari");
        bcari.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bcariActionPerformed(evt);
            }
        });

        Data_Pulsa.setModel(new javax.swing.table.DefaultTableModel(
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
        Data_Pulsa.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Data_PulsaMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(Data_Pulsa);

        jLabel8.setFont(new java.awt.Font("Trebuchet MS", 1, 14)); // NOI18N
        jLabel8.setText("Data Yang Tersedia");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(181, 181, 181)
                .addComponent(jLabel8)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 465, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addComponent(jLabel7)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(pilih_cari, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(2, 2, 2)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                                .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                    .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(provider, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 300, Short.MAX_VALUE)
                                    .addComponent(nominal)
                                    .addComponent(harga_jual, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(harga_beli, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(kode_pulsa)))
                            .addComponent(cari)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(simpan, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel1)
                        .addGap(105, 105, 105)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(tambah)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(bcari, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(exit, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(edit, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(batal, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(hapus, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 71, Short.MAX_VALUE)))
                .addGap(16, 16, 16))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(kode_pulsa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tambah))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(provider, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(edit))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(nominal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(hapus))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(harga_beli, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(batal)))
                .addGap(3, 3, 3)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(harga_jual, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6)
                    .addComponent(exit))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(simpan)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7)
                            .addComponent(pilih_cari, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(cari, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(bcari))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 130, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void providerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_providerActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_providerActionPerformed

    private void tambahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tambahActionPerformed
        enable();
        tambah.setEnabled(false);
        edit.setEnabled(false);
        hapus.setEnabled(false);
        clear();
    }//GEN-LAST:event_tambahActionPerformed

    private void simpanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_simpanActionPerformed
        if (tambah.isEnabled() == false && edit.isEnabled() == false) {
            try {
                String a = kode_pulsa.getText().toUpperCase();
                String b = provider.getText();
                String c = nominal.getText();
                String d = harga_beli.getText();
                String e = harga_jual.getText();
                Object[] o = {a, b, c, d, e};

                if (a.equals("") || b.equals("") || c.equals("") || d.equals("") || e.equals("")) {
                    JOptionPane.showMessageDialog(null, "Data Tidak Boleh kosong !", "WARNING!", JOptionPane.WARNING_MESSAGE);
                } else {
                    dtm.addRow(o);
                    saveTable();
                    JOptionPane.showMessageDialog(null, "Data Berhasil Disimpan", "SUKSES", JOptionPane.INFORMATION_MESSAGE);
                }
            } catch (Exception e) {
            }
            Data_Pulsa.setModel(dtm);
        } else if (edit.isEnabled()) {
            try {
                String a = kode_pulsa.getText().toUpperCase();
                String b = provider.getText();
                String c = nominal.getText();
                String d = harga_beli.getText();
                String e = harga_jual.getText();

                if (a.equals("") || b.equals("") || c.equals("") || d.equals("") || e.equals("")) {
                    JOptionPane.showMessageDialog(null, "Data Tidak Boleh Kosong", "WARNING!", JOptionPane.WARNING_MESSAGE);
                } else {
                    int konfirmasi = JOptionPane.showConfirmDialog(null, "Ingin Mengganti Data?", "Confirm", JOptionPane.YES_NO_OPTION);
                    if (konfirmasi == JOptionPane.YES_OPTION) {
                        int baris = Data_Pulsa.getSelectedRow();
                        Data_Pulsa.getModel().setValueAt(a, baris, 0);
                        Data_Pulsa.getModel().setValueAt(b, baris, 1);
                        Data_Pulsa.getModel().setValueAt(c, baris, 2);
                        Data_Pulsa.getModel().setValueAt(d, baris, 3);
                        Data_Pulsa.getModel().setValueAt(e, baris, 4);
                        clear();
                        saveTable();
                        JOptionPane.showMessageDialog(null, "Data Berhasil Dirubah", "SUKSES", JOptionPane.INFORMATION_MESSAGE);
                    }     
                }

            } catch (Exception e) {
            }
        }
    }//GEN-LAST:event_simpanActionPerformed

    private void nominalKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_nominalKeyTyped
        HanyaAngka(evt);
    }//GEN-LAST:event_nominalKeyTyped

    private void harga_beliKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_harga_beliKeyTyped
        HanyaAngka(evt);
    }//GEN-LAST:event_harga_beliKeyTyped

    private void harga_jualKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_harga_jualKeyTyped
        HanyaAngka(evt);
    }//GEN-LAST:event_harga_jualKeyTyped

    private void batalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_batalActionPerformed
        disable();
        tambah.setEnabled(true);
        edit.setEnabled(true);
        hapus.setEnabled(true);
    }//GEN-LAST:event_batalActionPerformed

    private void editActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editActionPerformed
        enable();
        tambah.setEnabled(false);
        hapus.setEnabled(false);
    }//GEN-LAST:event_editActionPerformed

    private void hapusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_hapusActionPerformed
        try {
            int konfirmasi = JOptionPane.showConfirmDialog(null, "Hapus Data?", "Confirm", JOptionPane.YES_NO_OPTION);
            if (konfirmasi == JOptionPane.YES_OPTION) {
                int x = Data_Pulsa.getSelectedRow();
                dtm.removeRow(x);
                JOptionPane.showMessageDialog(null, "Data Berhasil Dihapus", "\t\tSukses", JOptionPane.INFORMATION_MESSAGE);
            }
            saveTable();
        } catch (Exception e) {
        }
    }//GEN-LAST:event_hapusActionPerformed

    private void Data_PulsaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Data_PulsaMouseClicked
        if (tambah.isEnabled() || edit.isEnabled() || hapus.isEnabled()) {
            try {
                int row = Data_Pulsa.getSelectedRow();
                kode_pulsa.setText(Data_Pulsa.getModel().getValueAt(row, 0).toString());
                provider.setText(Data_Pulsa.getModel().getValueAt(row, 1).toString());
                nominal.setText(Data_Pulsa.getModel().getValueAt(row, 2).toString());
                harga_beli.setText(Data_Pulsa.getModel().getValueAt(row, 3).toString());
                harga_jual.setText(Data_Pulsa.getModel().getValueAt(row, 4).toString());
            } catch (Exception e) {
            }
        }
    }//GEN-LAST:event_Data_PulsaMouseClicked

    private void bcariActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bcariActionPerformed
        DefaultTableModel dtm1 = new DefaultTableModel();

        String columns[] = {"Kode Pulsa", "Provider", "Nominal", "Harga Beli", "Harga Jual"};
        dtm1.setColumnIdentifiers(columns);

        String line;
        BufferedReader reader;
        try {
            reader = new BufferedReader(new FileReader("pulsa.txt"));
            int i;
            while ((line = reader.readLine()) != null) {
                String asd[] = {};
                asd = line.split("\t");

                String searchOption = pilih_cari.getSelectedItem().toString();
                String searchValue = cari.getText().toLowerCase();
                if (searchOption.equalsIgnoreCase("Provider") && !searchValue.isEmpty()) {
                    if (asd[1].toLowerCase().contains(searchValue)) {
                        dtm1.addRow(line.split("\t"));
                    }
                } else if (searchOption.equalsIgnoreCase("Kode Pulsa") && !searchValue.isEmpty()) {
                    if (asd[0].toLowerCase().equals(searchValue)) {
                        dtm1.addRow(line.split("\t"));
                    }
                } else {
                    dtm1.addRow(line.split("\t"));
                }
            }
            Data_Pulsa.setModel(dtm1);
            if (dtm1.getRowCount() == 0) {
                JOptionPane.showMessageDialog(null, "Data Tidak Ditemukan", "", JOptionPane.INFORMATION_MESSAGE);
                cari.setText(null);
                //tampilData();
                Data_Pulsa.setModel(dtm);
            }
            reader.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "ERROR");
        }
    }//GEN-LAST:event_bcariActionPerformed

    private void exitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exitActionPerformed
        int validasi = JOptionPane.showConfirmDialog(null, "Keluar?", "WARNING", JOptionPane.YES_NO_OPTION);

        if (validasi == JOptionPane.YES_OPTION) {
            System.exit(0);
        }
    }//GEN-LAST:event_exitActionPerformed

    private void nominalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nominalActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nominalActionPerformed

    private void pilih_cariActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pilih_cariActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_pilih_cariActionPerformed

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
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Main().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable Data_Pulsa;
    private javax.swing.JButton batal;
    private javax.swing.JButton bcari;
    private javax.swing.JTextField cari;
    private javax.swing.JButton edit;
    private javax.swing.JButton exit;
    private javax.swing.JButton hapus;
    private javax.swing.JTextField harga_beli;
    private javax.swing.JTextField harga_jual;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField kode_pulsa;
    private javax.swing.JTextField nominal;
    private javax.swing.JComboBox pilih_cari;
    private javax.swing.JTextField provider;
    private javax.swing.JButton simpan;
    private javax.swing.JButton tambah;
    // End of variables declaration//GEN-END:variables
}
