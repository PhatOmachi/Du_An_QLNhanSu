/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package ux_ui;

import dao.ChucVuDAO;
import dao.CongTacDAO;
import dao.LuongDAO;
import dao.NhanVienDAO;
import dao.PhongBanDAO;
import dao.ThoiGianCongTacDAO;
import dao.TrinhDoHocVanDAO;
import entity.ChucVu;
import entity.Luong;
import entity.NhanVien;
import entity.PhongBan;
import entity.ThoiGianCongTac;
import entity.TrinhDoHocVan;
import java.awt.Image;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.util.Date;
import java.util.ArrayList;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;
import library.DialogHelper;
import library.Extension;
import library.XDate;
import library.XImage;

/**
 *
 * @author Admin
 */
public class JDialogNhanVien extends javax.swing.JDialog {

    /**
     * Creates new form JDialogNhanVien
     */
    public JDialogNhanVien(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        init();
    }

    NhanVienDAO nvDao = new NhanVienDAO();
    PhongBanDAO pbDao = new PhongBanDAO();
    ChucVuDAO cvDao = new ChucVuDAO();
    TrinhDoHocVanDAO tdhvDao = new TrinhDoHocVanDAO();
    LuongDAO lDao = new LuongDAO();

    ArrayList<NhanVien> nvList = nvDao.select();
    ArrayList<ChucVu> cvList = cvDao.select();
    ArrayList<TrinhDoHocVan> tdhvList = tdhvDao.select();
    ArrayList<Luong> lList = lDao.select();
    ArrayList<PhongBan> pbList = pbDao.select();

    int selectedRow = 0;

    void init() {
        this.setLocationRelativeTo(null);
        resizeColumn();
        fillToTable();
        setCBO();

        btnMoi.addActionListener(e -> {
            clearForm();
        });

        btnThem.addActionListener(e -> {
            insert();
            load();
        });

        btnSua.addActionListener(e -> {
            update();
            load();
        });

        btnXoa.addActionListener(e -> {
            delete();
            load();
        });

        btnFirst.addActionListener(e -> {
            selectedRow = 0;
            loadForm();
        });

        btnPrev.addActionListener(e -> {
            selectedRow--;
            loadForm();
        });

        btnNext.addActionListener(e -> {
            selectedRow++;
            loadForm();
        });

        btnLast.addActionListener(e -> {
            selectedRow = nvList.size() - 1;
            loadForm();
        });

        tbl.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                selectedRow = tbl.getSelectedRow();
                loadForm();
            }

            @Override
            public void mousePressed(MouseEvent e) {
            }

            @Override
            public void mouseReleased(MouseEvent e) {
            }

            @Override
            public void mouseEntered(MouseEvent e) {
            }

            @Override
            public void mouseExited(MouseEvent e) {
            }

        });
        txtSearch.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                search();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                search();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                search();
            }
        });

        loadForm();

        Extension.setPlaceholder(txtNgaySinh, "dd/MM/yyyy");

    }

    void load() {
//        if (nvList.isEmpty()) {
//            return;
//        }
        nvList = nvDao.select();
        fillToTable();
    }

    void loadForm() {
        btnFirst.setEnabled(true);
        btnPrev.setEnabled(true);
        btnLast.setEnabled(true);
        btnNext.setEnabled(true);

        if (selectedRow == 0) {
            btnFirst.setEnabled(false);
            btnPrev.setEnabled(false);
        }
        if (selectedRow >= nvList.size() - 1) {
            btnLast.setEnabled(false);
            btnNext.setEnabled(false);
        }

        NhanVien nv = nvList.get(selectedRow);
        setForm(nv);
        tabs.setSelectedIndex(0);
    }

    void fillToTable() {
        DefaultTableModel model = (DefaultTableModel) tbl.getModel();
        model.setRowCount(0);

        nvList.forEach((nv) -> {
            Object[] row = {nv.getMaNV(),
                nv.getHoTen(),
                nv.getDanToc(),
                nv.getGioiTinh() ? "Nam" : "Nữ",
                nv.getSoDienThoai(),
                nv.getQueQuan(),
                nv.getNgaySinh()};
            model.addRow(row);
        });
    }

    void setForm(NhanVien nv) {
        txtMaNhanVien.setText(nv.getMaNV());
        txtHoTen.setText(nv.getHoTen());
        txtNgaySinh.setText(XDate.toString(nv.getNgaySinh()));
        txtDanToc.setText(nv.getDanToc());
        txtSdt.setText(nv.getSoDienThoai());
        txtQueQuan.setText(nv.getQueQuan());
        rdoNam.setSelected(nv.getGioiTinh());
        rdoNữ.setSelected(!nv.getGioiTinh());
        cboBacLuong.setSelectedItem(nv.getBacLuong());
        cboChucVu.setSelectedItem(cvDao.selectByMaCV(nv.getMaCV()).getTenCV());
        cboPhongBan.setSelectedItem(pbDao.selectByMaPB(nv.getMaPB()).getMaPB());
        cboTDHV.setSelectedItem(tdhvDao.selectByMaTDHV(nv.getMaTDHV()).getTenTrinhDo());
        lblAnh.setIcon(null);

        if (nv.getAvatar() != null) {
            ImageIcon icon = XImage.read(nv.getAvatar());
            Image img = icon.getImage().getScaledInstance(lblAnh.getWidth(), lblAnh.getHeight(), Image.SCALE_SMOOTH);
            ImageIcon scaledIcon = new ImageIcon(img);
            lblAnh.setIcon(scaledIcon);
            lblAnh.setToolTipText(nv.getAvatar());
        }
    }

    NhanVien getForm() {
        String maNV = txtMaNhanVien.getText();
//        if (nvDao.selectByMaNV(maNV) != null) {
//            DialogHelper.alert(null, "Mã Nhân Viên đã tồn tại!");
//            return null;
//        }
        String danToc = txtDanToc.getText();
        String soDienThoai = txtSdt.getText();
        String hoTen = txtHoTen.getText();
        String queQuan = txtQueQuan.getText();
        Date ngaySinh = XDate.toDate(txtNgaySinh.getText());
        String maPB = pbList.get(cboPhongBan.getSelectedIndex()).getMaPB();
        String maCV = cvList.get(cboChucVu.getSelectedIndex()).getMaCV();
        String maTDHV = tdhvList.get(cboTDHV.getSelectedIndex()).getMaTDHV();
        Double bacLuong = (double) cboBacLuong.getSelectedItem();
        boolean gioiTinh = rdoNam.isSelected();
        String avatar = (lblAnh.getToolTipText());

        return new NhanVien(maNV, hoTen, avatar, ngaySinh, queQuan, gioiTinh, danToc, soDienThoai, maPB, maCV, maTDHV, bacLuong);
    }
    ThoiGianCongTacDAO tgctDao = new ThoiGianCongTacDAO();

    void insertTGCT(NhanVien nv) {
        String maCV = nv.getMaCV();
        String maNV = nv.getMaNV();

        tgctDao.insert(new ThoiGianCongTac(maNV, maCV, XDate.now()));
    }

    void search() {
        String val = txtSearch.getText();
        nvList = nvDao.search(val);
        fillToTable();
    }

    void insert() {
        NhanVien nv = getForm();
        if (nv == null) {
            DialogHelper.alert(null, "Vui lòng nhập đủ và đúng các input!\nInsert Failed!");
            return;
        }
        nvDao.insert(nv);
        insertTGCT(nv);
        DialogHelper.alert(null, "Thêm nhân viên thành công!");
    }

    void update() {
        NhanVien nv = getForm();
        if (nv == null) {
            DialogHelper.alert(null, "Vui lòng nhập đủ và đúng các input!\nUpdate Failed!");
            return;
        }
        nvDao.update(nv);
        insertTGCT(nv);
        DialogHelper.alert(null, "Cập nhật thông tin nhân viên thành công!");
    }

    void delete() {
        String maNV = txtMaNhanVien.getText();
        if (maNV.isEmpty()) {
            DialogHelper.alert(null, "Vui lòng nhập đủ và đúng các input!\nDelete Failed!");
            return;
        }
        NhanVien nv = nvDao.selectByMaNV(maNV);
        if (nv != null) {
            new CongTacDAO().delete(maNV);
            tgctDao.delete(maNV);
            nvDao.delete(nv);
        }
        DialogHelper.alert(null, "Xóa thông tin nhân viên thành công!");
    }

    void clearForm() {
        txtMaNhanVien.setText("");
        txtHoTen.setText("");
        txtNgaySinh.setText("");
        txtDanToc.setText("");
        txtSdt.setText("");
        txtQueQuan.setText("");
        rdoNam.setSelected(true);
        cboBacLuong.setSelectedIndex(0);
        cboChucVu.setSelectedIndex(0);
        cboPhongBan.setSelectedIndex(0);
        cboTDHV.setSelectedIndex(0);
        lblAnh.setToolTipText("");
        Extension.setPlaceholder(txtNgaySinh, "dd/MM/yyyy");
    }

    void setCBO() {
        setcboLuong();
        setCboCV();
        setcboPB();
        setcboTDHV();

        cboTDHV.addActionListener(e -> {
            int index = cboTDHV.getSelectedIndex();
            txtChuyenNganh.setText(tdhvList.get(index).getChuyenNganh());
        });
        cboBacLuong.addActionListener(e -> {
            int index = cboBacLuong.getSelectedIndex();
            txtLuongCB.setText(String.valueOf(lList.get(index).getLuongCoBan()));
        });
    }

    void setCboCV() {
        DefaultComboBoxModel<String> model = (DefaultComboBoxModel) cboChucVu.getModel();
        model.removeAllElements();

        cvList.forEach((cv) -> {
            model.addElement(cv.getTenCV());
        });
    }

    JFileChooser filechooser = new JFileChooser();

    void uploadImage() {
        if (filechooser.showOpenDialog(this) == filechooser.APPROVE_OPTION) {
            File file = filechooser.getSelectedFile();
            XImage.save(file);
            ImageIcon icon = XImage.read(file.getName());
            Image img = icon.getImage().getScaledInstance(lblAnh.getWidth(), lblAnh.getHeight(), Image.SCALE_SMOOTH);
            ImageIcon scaledIcon = new ImageIcon(img);
            lblAnh.setIcon(scaledIcon);
            lblAnh.setToolTipText(file.getName());
        }
    }

    void setcboTDHV() {
        DefaultComboBoxModel<String> model = (DefaultComboBoxModel) cboTDHV.getModel();
        model.removeAllElements();

        tdhvList.forEach((tdhv) -> {
            model.addElement(tdhv.getTenTrinhDo());
        });
        txtChuyenNganh.setText(tdhvList.get(0).getChuyenNganh());
    }

    void setcboLuong() {
        DefaultComboBoxModel<Double> model = (DefaultComboBoxModel) cboBacLuong.getModel();
        model.removeAllElements();

        lList.forEach((luong) -> {
            model.addElement(luong.getBacLuong());
        });
        txtLuongCB.setText(lList.get(0).getLuongCoBan().toString());
    }

    void setcboPB() {
        DefaultComboBoxModel<String> model = (DefaultComboBoxModel) cboPhongBan.getModel();
        model.removeAllElements();

        pbList.forEach((pb) -> {
            model.addElement(pb.getTenPB());
        });
    }

    private void resizeColumn() {
//        TableColumn col1 = tblChuyenDe.getColumnModel().getColumn(1);
        TableColumnModel clm = tbl.getColumnModel();
        clm.getColumn(4).setPreferredWidth(90);
        clm.getColumn(1).setPreferredWidth(130);
        clm.getColumn(5).setPreferredWidth(90);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        tabs = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        txtMaNhanVien = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtHoTen = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtDanToc = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        rdoNam = new javax.swing.JRadioButton();
        rdoNữ = new javax.swing.JRadioButton();
        jLabel6 = new javax.swing.JLabel();
        txtSdt = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        txtQueQuan = new javax.swing.JTextField();
        txtNgaySinh = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        cboChucVu = new javax.swing.JComboBox<>();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        cboTDHV = new javax.swing.JComboBox<>();
        cboPhongBan = new javax.swing.JComboBox<>();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        cboBacLuong = new javax.swing.JComboBox<>();
        btnThem = new javax.swing.JButton();
        btnSua = new javax.swing.JButton();
        btnXoa = new javax.swing.JButton();
        btnMoi = new javax.swing.JButton();
        btnLast = new javax.swing.JButton();
        btnNext = new javax.swing.JButton();
        btnPrev = new javax.swing.JButton();
        btnFirst = new javax.swing.JButton();
        jLabel14 = new javax.swing.JLabel();
        txtChuyenNganh = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        txtLuongCB = new javax.swing.JTextField();
        lblAnh = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbl = new javax.swing.JTable();
        txtSearch = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel2.setFont(new java.awt.Font("Segoe UI Black", 2, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(204, 102, 0));
        jLabel2.setText("QUẢN LÝ NHÂN VIÊN");

        jLabel1.setText("Mã nhân viên");

        jLabel3.setText("Họ tên");

        jLabel4.setText("Giới tính");

        jLabel5.setText("Dân tộc");

        buttonGroup1.add(rdoNam);
        rdoNam.setSelected(true);
        rdoNam.setText("Nam");
        rdoNam.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdoNamActionPerformed(evt);
            }
        });

        buttonGroup1.add(rdoNữ);
        rdoNữ.setText("Nữ");

        jLabel6.setText("SĐT");

        jLabel7.setText("Quê quán");

        jLabel8.setText("Ngày sinh");

        jLabel9.setText("Chức Vụ");

        jLabel10.setText("Trình độ học vấn");

        jLabel11.setText("Phòng Ban");

        jLabel12.setText("Bậc lương");

        cboBacLuong.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboBacLuongActionPerformed(evt);
            }
        });

        btnThem.setText("Thêm");
        btnThem.setMaximumSize(new java.awt.Dimension(80, 30));
        btnThem.setMinimumSize(new java.awt.Dimension(80, 30));

        btnSua.setText("Sửa");
        btnSua.setMaximumSize(new java.awt.Dimension(80, 30));
        btnSua.setMinimumSize(new java.awt.Dimension(80, 30));

        btnXoa.setText("Xóa");
        btnXoa.setMaximumSize(new java.awt.Dimension(80, 30));
        btnXoa.setMinimumSize(new java.awt.Dimension(80, 30));

        btnMoi.setText("Mới");
        btnMoi.setMaximumSize(new java.awt.Dimension(80, 30));
        btnMoi.setMinimumSize(new java.awt.Dimension(80, 30));

        btnLast.setText(">|");

        btnNext.setText(">>");

        btnPrev.setText("<<");

        btnFirst.setText("|<");

        jLabel14.setText("Chuyên Ngành");

        txtChuyenNganh.setEditable(false);

        jLabel15.setText("Mức lương cơ bản");

        txtLuongCB.setEditable(false);
        txtLuongCB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtLuongCBActionPerformed(evt);
            }
        });

        lblAnh.setFont(new java.awt.Font("Segoe UI Semilight", 2, 18)); // NOI18N
        lblAnh.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblAnh.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        lblAnh.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblAnhMouseClicked(evt);
            }
        });

        jLabel18.setFont(new java.awt.Font("Segoe UI Semilight", 0, 14)); // NOI18N
        jLabel18.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        jLabel17.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel17.setText("---Chọn Ảnh---");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblAnh, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel18, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel17, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(32, 32, 32)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(txtSdt, javax.swing.GroupLayout.Alignment.TRAILING)
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addComponent(cboTDHV, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel8, javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(txtNgaySinh)
                                        .addComponent(txtDanToc, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 204, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(jLabel10))
                                .addComponent(jLabel12)
                                .addComponent(jLabel11)
                                .addComponent(cboPhongBan, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(cboBacLuong, javax.swing.GroupLayout.PREFERRED_SIZE, 204, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(txtMaNhanVien, javax.swing.GroupLayout.PREFERRED_SIZE, 204, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btnThem, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnFirst, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btnPrev, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnSua, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(55, 55, 55)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel15)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jLabel9)
                                .addComponent(txtLuongCB, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 204, Short.MAX_VALUE)
                                .addComponent(jLabel3)
                                .addComponent(jLabel4)
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addComponent(rdoNam, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(rdoNữ, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addComponent(jLabel7)
                                .addComponent(txtHoTen)
                                .addComponent(txtQueQuan)
                                .addComponent(jLabel14)
                                .addComponent(txtChuyenNganh)
                                .addComponent(cboChucVu, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(btnXoa, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btnNext, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(btnLast, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(btnMoi, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addContainerGap(31, Short.MAX_VALUE))))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(204, 204, 204)
                .addComponent(jLabel2)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel18)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(lblAnh, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(jLabel17)
                        .addGap(135, 135, 135))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(50, 50, 50)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtMaNhanVien, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(23, 23, 23)
                                        .addComponent(txtDanToc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(jLabel5))
                                .addGap(10, 10, 10)
                                .addComponent(jLabel6)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtSdt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel8)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(24, 24, 24)
                                        .addComponent(txtNgaySinh, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel11)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cboPhongBan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel10)
                                .addGap(12, 12, 12)
                                .addComponent(cboTDHV, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel12)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cboBacLuong, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtHoTen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(rdoNam)
                                    .addComponent(rdoNữ))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel7)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtQueQuan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(72, 72, 72)
                                .addComponent(jLabel9)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cboChucVu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel14)
                                .addGap(13, 13, 13)
                                .addComponent(txtChuyenNganh, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel15)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtLuongCB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 13, Short.MAX_VALUE)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnThem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSua, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnMoi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnXoa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnPrev)
                    .addComponent(btnFirst)
                    .addComponent(btnNext)
                    .addComponent(btnLast))
                .addContainerGap(26, Short.MAX_VALUE))
        );

        tabs.addTab("Thêm", jPanel1);

        tbl.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "Mã NV", "Họ tên", "Dân tộc", "Giới tính", "SĐT", "Quê quán", "Ngày sinh"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tbl);

        txtSearch.setFont(new java.awt.Font("Segoe UI Semilight", 2, 14)); // NOI18N

        jLabel13.setFont(new java.awt.Font("Segoe UI Semibold", 0, 14)); // NOI18N
        jLabel13.setText("Tìm kiếm:");

        jLabel16.setFont(new java.awt.Font("Segoe UI Black", 2, 24)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(204, 102, 0));
        jLabel16.setText("QUẢN LÝ NHÂN VIÊN");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 674, Short.MAX_VALUE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel13)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtSearch)))
                .addContainerGap())
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(202, 202, 202)
                .addComponent(jLabel16)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel16)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel13))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 32, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 425, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        tabs.addTab("Xem", jPanel2);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(tabs, javax.swing.GroupLayout.PREFERRED_SIZE, 703, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(tabs, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtLuongCBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtLuongCBActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtLuongCBActionPerformed

    private void cboBacLuongActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboBacLuongActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cboBacLuongActionPerformed

    private void rdoNamActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdoNamActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rdoNamActionPerformed

    private void lblAnhMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblAnhMouseClicked
        uploadImage();
    }//GEN-LAST:event_lblAnhMouseClicked

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
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(JDialogNhanVien.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JDialogNhanVien.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JDialogNhanVien.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JDialogNhanVien.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                JDialogNhanVien dialog = new JDialogNhanVien(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnFirst;
    private javax.swing.JButton btnLast;
    private javax.swing.JButton btnMoi;
    private javax.swing.JButton btnNext;
    private javax.swing.JButton btnPrev;
    private javax.swing.JButton btnSua;
    private javax.swing.JButton btnThem;
    private javax.swing.JButton btnXoa;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JComboBox<String> cboBacLuong;
    private javax.swing.JComboBox<String> cboChucVu;
    private javax.swing.JComboBox<String> cboPhongBan;
    private javax.swing.JComboBox<String> cboTDHV;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblAnh;
    private javax.swing.JRadioButton rdoNam;
    private javax.swing.JRadioButton rdoNữ;
    private javax.swing.JTabbedPane tabs;
    private javax.swing.JTable tbl;
    private javax.swing.JTextField txtChuyenNganh;
    private javax.swing.JTextField txtDanToc;
    private javax.swing.JTextField txtHoTen;
    private javax.swing.JTextField txtLuongCB;
    private javax.swing.JTextField txtMaNhanVien;
    private javax.swing.JTextField txtNgaySinh;
    private javax.swing.JTextField txtQueQuan;
    private javax.swing.JTextField txtSdt;
    private javax.swing.JTextField txtSearch;
    // End of variables declaration//GEN-END:variables
}
