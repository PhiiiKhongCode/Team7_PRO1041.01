/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */


//import Images.CallImages;
import Enum.TrangThaiHD;
import Piechart.ModelPieChart;
import Piechart.PieChart;
import com.itextpdf.kernel.color.Color;
import com.itextpdf.kernel.color.DeviceRgb;
import com.itextpdf.kernel.font.PdfFont;
import com.itextpdf.kernel.font.PdfFontFactory;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.border.Border;
import com.itextpdf.layout.element.Cell;
import com.itextpdf.layout.element.Paragraph;
import com.itextpdf.layout.element.Table;
import com.itextpdf.layout.property.TextAlignment;
import com.itextpdf.layout.property.VerticalAlignment;

import com.itextpdf.text.pdf.BaseFont;
import domain_model.HDCT;
import domain_model.HoaDon;
import domain_model.KhachHang;
import domain_model.NhanVien;
import domain_model.SPCT;
import java.awt.BorderLayout;

import java.awt.Image;
import java.awt.color.ColorSpace;
import java.math.BigDecimal;
import java.net.URL;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
import javax.swing.DefaultComboBoxModel;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;
import service.IDoanhSoService;
import service.IGiay_BanHangService;
import service.IHoaDonService;
import service.impl.DoanhSoService;
import service.impl.Giay_BanHangService;
import service.impl.HoaDon_BHService;

/**
 *
 * @author PhiLT
 */
public class BanHang extends javax.swing.JFrame {

    //Man ban hang
    private IGiay_BanHangService _IGiay_BanHangService;
    private int i = 0;
    private List<SPCT> dsGiay;
    private List<KhachHang> dsKH;
    private List<NhanVien> dsNV;
    private ReadQRCode _ReadQRCode;
    private IHoaDonService _IHoaDonService;
    private List<HDCT> dsHDCT;
    private List<HoaDon> dsHoaDon;
    private SimpleDateFormat dfm = new SimpleDateFormat("dd-MM-yyyy");
    //Quét QR
//    private WebcamPanel panel = null;
//    private Webcam webcam = null;
//    private Executor executor = Executors.newSingleThreadExecutor(this);
    private String _qr;

    /**
     * Creates new form ManHinh
     */
    public BanHang() {
        initComponents();

        _IGiay_BanHangService = new Giay_BanHangService();//giay man ban hang
        dsGiay = _IGiay_BanHangService.findAll();
        loadDsGiay_BHTien();
        _IHoaDonService = new HoaDon_BHService();
        loadTableHoaDon();

        loadCBBIdKH();
        loadCBBIdNV();
        loadCBBTinhTrang();

        clcNgayGui.setDateFormatString("dd-MM-yyyy");
        clcNgayNhan.setDateFormatString("dd-MM-yyyy");
        
        _IDoanhSoService = new DoanhSoService();
        
        loadCBBNamDS();
        loadCBBDoanhThuNam();
//        URL url = getClass().getResource("/icon/Logo.jpg");
//        ImageIcon icon = new ImageIcon(url);
//        lbLogo.setIcon(new ImageIcon(icon.getImage().getScaledInstance(lbLogo.getWidth(), lbLogo.getHeight(), 0)));
    }

    public static final String pathUnicode = "font\\unicode.ttf";
public static String gen(String ma) {
        int last = (int) Math.floor((Math.random()) * 9999);
        if (last < 1000 && last >= 100) {
            return ma + "0" + last;
        }
        if (last < 100 && last >= 10) {
            return ma + "00" + last;
        }
        if (last < 10) {
            return ma + "000" + last;
        }

        return ma + last;

    }

    public void inHoaDon(int row){
 
    
        try {
            
            SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
            String date = sdf.format(new Date());
            String path = "hoa_don" + gen("HD") + ".pdf";
            PdfWriter pdfWriter = new PdfWriter(path);
            PdfDocument pdfDocument = new PdfDocument(pdfWriter);
            Document document = new Document(pdfDocument);
            float col = 280f;
            float columWidth[] = {col, col};

            PdfFont font = PdfFontFactory.createFont(pathUnicode, BaseFont.IDENTITY_H);

            Table table = new Table(columWidth);
            table.setBackgroundColor(new DeviceRgb(63, 169, 219)).setFontColor(Color.WHITE);
            table.setFont(font);

            table.addCell(new Cell().add("Andrew Store").setTextAlignment(TextAlignment.CENTER)
                    .setVerticalAlignment(VerticalAlignment.MIDDLE)
                    .setMarginTop(30f)
                    .setMarginBottom(30f)
                    .setFontSize(30f)
                    .setBorder(Border.NO_BORDER));
            String ma = tbHoaDon.getValueAt(row, 1).toString();
                table.addCell(new Cell().add("Mã hóa đơn: "+ ma + "").setTextAlignment(TextAlignment.RIGHT)
                    .setMarginTop(30f)
                    .setMarginBottom(30f)
                    .setBorder(Border.NO_BORDER)
                    .setMarginRight(10f));
            String id = tbHoaDon.getValueAt(row, 0).toString();
        idHD_CT = id;
        String tenkh = tbHoaDon.getValueAt(row, 2).toString();
        String tennv = tbHoaDon.getValueAt(row, 3).toString();
        String ngayTT = tbHoaDon.getValueAt(row, 5).toString();
        String tinhTrang = tbHoaDon.getValueAt(row, 8).toString();
        String phanTram = tbHoaDon.getValueAt(row, 9).toString();

            float colWidth[] = {170, 900};
            Table customerInforTable = new Table(colWidth);
            customerInforTable.setFont(font);
            customerInforTable.addCell(new Cell(0, 5)
                    .add("Thông tin hóa đơn").setBold().setBorder(Border.NO_BORDER)).setTextAlignment(TextAlignment.CENTER);

            customerInforTable.addCell(new Cell().add("Tên khách hàng: ").setBorder(Border.NO_BORDER)).setTextAlignment(TextAlignment.LEFT);
            customerInforTable.addCell(new Cell().add(tenkh).setBorder(Border.NO_BORDER)).setTextAlignment(TextAlignment.RIGHT);
customerInforTable.addCell(new Cell().add("Tên Nhân Viên:").setBorder(Border.NO_BORDER).setTextAlignment(TextAlignment.LEFT));
            customerInforTable.addCell(new Cell().add(tennv).setBorder(Border.NO_BORDER)).setTextAlignment(TextAlignment.RIGHT);
            customerInforTable.addCell(new Cell().add("Ngày Thanh Toán:").setBorder(Border.NO_BORDER)).setTextAlignment(TextAlignment.LEFT);
            customerInforTable.addCell(new Cell().add(ngayTT).setBorder(Border.NO_BORDER)).setTextAlignment(TextAlignment.RIGHT);
            customerInforTable.addCell(new Cell().add("Phần Trăm Giảm:").setBorder(Border.NO_BORDER).setTextAlignment(TextAlignment.LEFT));
            customerInforTable.addCell(new Cell().add(phanTram).setBorder(Border.NO_BORDER).setTextAlignment(TextAlignment.RIGHT));
            customerInforTable.addCell(new Cell().add("Tình Trạng:").setBorder(Border.NO_BORDER).setTextAlignment(TextAlignment.LEFT));
            customerInforTable.addCell(new Cell().add(tinhTrang).setBorder(Border.NO_BORDER).setTextAlignment(TextAlignment.RIGHT));

            float itemColWidth[] = {130, 130, 130, 130};
            Table itemTable = new Table(itemColWidth);
            itemTable.setFont(font);
           // itemTable.addCell(new Cell().add("STT").setBackgroundColor(new DeviceRgb(63, 169, 219)).setFontColor(Color.WHITE));
            itemTable.addCell(new Cell().add("ID HD").setBackgroundColor(new DeviceRgb(63, 169, 219)).setFontColor(Color.WHITE));
            itemTable.addCell(new Cell().add("ID SP").setBackgroundColor(new DeviceRgb(63, 169, 219)).setFontColor(Color.WHITE));
            itemTable.addCell(new Cell().add("Số lượng").setBackgroundColor(new DeviceRgb(63, 169, 219)).setFontColor(Color.WHITE));
            itemTable.addCell(new Cell().add("Giá bán").setBackgroundColor(new DeviceRgb(63, 169, 219)).setFontColor(Color.WHITE));
            //itemTable.addCell(new Cell().add("Thành tiền").setBackgroundColor(new DeviceRgb(63, 169, 219)).setFontColor(Color.WHITE));

            for(int tb = 0; tb < tbHDCT0.getRowCount(); tb++){
            int stt = 1;    
            String maSP = tbHDCT0.getValueAt(tb, 0).toString();
            String tenSP = tbHDCT0.getValueAt(tb, 1).toString();
            String soLuong = tbHDCT0.getValueAt(tb, 2).toString();
            String gia = tbHDCT0.getValueAt(tb, 3).toString();
            
            //itemTable.addCell(new Cell().add(stt));
            itemTable.addCell(new Cell().add(maSP));
            itemTable.addCell(new Cell().add(tenSP));
            itemTable.addCell(new Cell().add(soLuong));
            itemTable.addCell(new Cell().add(gia));
            //itemTable.addCell(new Cell().add("500,000 Vnđ"));
            }
            itemTable.addCell(new Cell().add("").setBackgroundColor(new DeviceRgb(63, 169, 219)).setBorder(Border.NO_BORDER));
itemTable.addCell(new Cell().add("").setBackgroundColor(new DeviceRgb(63, 169, 219)).setBorder(Border.NO_BORDER));
            itemTable.addCell(new Cell().add("").setBackgroundColor(new DeviceRgb(63, 169, 219)).setBorder(Border.NO_BORDER));
            itemTable.addCell(new Cell().add("").setBackgroundColor(new DeviceRgb(63, 169, 219)).setBorder(Border.NO_BORDER));
            itemTable.addCell(new Cell().add("Thành tiền: ").setBackgroundColor(new DeviceRgb(63, 169, 219)).setBorder(Border.NO_BORDER).setFontColor(Color.WHITE));
            String thanhTien = txtTongTien.getText();
            itemTable.addCell(new Cell().add(thanhTien).setBackgroundColor(new DeviceRgb(63, 169, 219)).setBorder(Border.NO_BORDER).setFontColor(Color.WHITE));

            document.add(table);
            document.add(new Paragraph("\n"));
            document.add(customerInforTable);
            document.add(new Paragraph("\n"));
            document.add(itemTable);
            document.close();
            JOptionPane.showMessageDialog(this, "In thành công");
        } catch (Exception e) {
            e.printStackTrace();
        
    }

    
    }
    public void getQRCode(String qr) {
        System.out.println("123455678");
        if (qr == null) {
            return;
        }

        for (SPCT spct : dsGiay) {

            if (qr.equals(spct.getId())) {
                System.out.println("=============" + qr + "=============");
                System.out.println(spct.getAnh());
                URL url = getClass().getResource("/Images/" + spct.getAnh());
                ImageIcon icon = new ImageIcon(url);
                this.lbAnhGiay_BH.setIcon(new ImageIcon(icon.getImage().getScaledInstance(lbAnhGiay_BH.getWidth(), lbAnhGiay_BH.getHeight(), 0)));
                this.txtIdGiay_BH.setText(spct.getId());
                txtNamBH_BH.setText(spct.getNamBH()+"");
                spnSl_BH.setValue(1);
                txtGiaBan_BH.setText(spct.getGiaBan()+"");
                txtMoTa_BH.setText(spct.getMoTa());
                break;
            }
        }
    }

    private void loadTableHoaDon() {
        dsHoaDon = _IHoaDonService.findAllHD();
        DefaultTableModel modelHD = (DefaultTableModel) tbHoaDon.getModel();
        modelHD.setRowCount(0);
        for (HoaDon hoaDon : dsHoaDon) {
            modelHD.addRow(new Object[]{hoaDon.getId(), hoaDon.getMa(), hoaDon.getKh().getTen(),
                hoaDon.getNv().getTen(), dfm.format(hoaDon.getNgayTao()), dfm.format(hoaDon.getNgayThanhToan()),
                dfm.format(hoaDon.getNgayGui()), dfm.format(hoaDon.getNgayNhan()), hoaDon.getTrangThai(),
                hoaDon.getPhanTramGiam()});
        }
    }

    private void loadTableHDCT(String idHD) {

        dsHDCT = _IHoaDonService.findAllHDCT(idHD);
        DefaultTableModel modelHDCT0 = (DefaultTableModel) tbHDCT0.getModel();
        DefaultTableModel modelHDCT1 = (DefaultTableModel) tbHDCT1.getModel();
        modelHDCT0.setRowCount(0);
        modelHDCT1.setRowCount(0);
        for (HDCT hdct : dsHDCT) {
            modelHDCT0.addRow(new Object[]{hdct.getHd().getId(), hdct.getsPCT().getId(), hdct.getsLg(), hdct.getDonGia()});
            modelHDCT1.addRow(new Object[]{hdct.getHd().getId(), hdct.getsPCT().getId(), hdct.getsLg(), hdct.getDonGia()});
        }
    }

    private void loadCBBIdNV() {
        dsNV = _IHoaDonService.findAllNV();
        cbbIdNhanVien.removeAllItems();;
        for (NhanVien nhanVien : dsNV) {
            cbbIdNhanVien.addItem(nhanVien.getMa());
        }
    }

    private void loadCBBIdKH() {
        dsKH = _IHoaDonService.findAllKH();
        cbbIdKhachHang.removeAllItems();;
        for (KhachHang khachHang : dsKH) {
            cbbIdKhachHang.addItem(khachHang.getMa());
        }
    }

    private void loadCBBTinhTrang() {
        DefaultComboBoxModel cbb = new DefaultComboBoxModel<>(TrangThaiHD.values());
        cbbTinhTrang.setModel(cbb);
    }

    private void loadDsGiay_BHTien() {

        int max = dsGiay.size();

        if (i + 4 <= max) {
            setAnhlbGiay0(dsGiay, i);
            setAnhlbGiay1(dsGiay, i + 1);
            setAnhlbGiay2(dsGiay, i + 2);
            setAnhlbGiay3(dsGiay, i + 3);
            i++;
        } else if (i + 3 <= max) {
            setAnhlbGiay0(dsGiay, i);
            setAnhlbGiay1(dsGiay, i + 1);
            setAnhlbGiay2(dsGiay, i + 2);
            setAnhlbGiay3(dsGiay, 0);
            i++;
        } else if (i + 2 <= max) {
            setAnhlbGiay0(dsGiay, i);
            setAnhlbGiay1(dsGiay, i + 1);
            setAnhlbGiay2(dsGiay, 0);
            setAnhlbGiay3(dsGiay, 1);
            i++;
        } else {
            setAnhlbGiay0(dsGiay, i);
            setAnhlbGiay1(dsGiay, 0);
            setAnhlbGiay2(dsGiay, 1);
            setAnhlbGiay3(dsGiay, 2);
            i = 0;
        }
    }

    private void loadDsGiay_BHLui() {

        int max = dsGiay.size();
        if (i >= 3) {
            setAnhlbGiay0(dsGiay, i - 3);
            setAnhlbGiay1(dsGiay, i - 2);
            setAnhlbGiay2(dsGiay, i - 1);
            setAnhlbGiay3(dsGiay, i);
            i--;
        } else if (i >= 2) {
            setAnhlbGiay0(dsGiay, max - 1);
            setAnhlbGiay1(dsGiay, i - 2);
            setAnhlbGiay2(dsGiay, i - 1);
            setAnhlbGiay3(dsGiay, i);
            i--;
        } else if (i >= 1) {
            setAnhlbGiay0(dsGiay, max - 2);
            setAnhlbGiay1(dsGiay, max - 1);
            setAnhlbGiay2(dsGiay, i - 1);
            setAnhlbGiay3(dsGiay, i);
            i--;
        } else {
            setAnhlbGiay0(dsGiay, max - 3);
            setAnhlbGiay1(dsGiay, max - 2);
            setAnhlbGiay2(dsGiay, max - 1);
            setAnhlbGiay3(dsGiay, i);
            i = max - 1;
        }
    }
    //set anh lb sp ban hang
    private String tenAnh0;
    private String tenAnh1;
    private String tenAnh2;
    private String tenAnh3;

    private void setAnhlbGiay0(List<SPCT> dsGiay, int i) {
        if (dsGiay.get(i).getAnh() != null) {
            URL url = getClass().getResource("/Images/" + dsGiay.get(i).getAnh());
            ImageIcon icon = new ImageIcon(url);
            lbGiay0.setIcon(new ImageIcon(icon.getImage().getScaledInstance(lbGiay0.getWidth(), lbGiay0.getHeight(), 0)));
            lbSoLuongBH0.setText(dsGiay.get(i).getSLgCon() + "");
            lbGiaBanBH0.setText(dsGiay.get(i).getGiaBan() + "");
            tenAnh0 = dsGiay.get(i).getAnh();
        }
    }

    private void setAnhlbGiay1(List<SPCT> dsGiay, int i) {
        if (dsGiay.get(i).getAnh() != null) {
            URL url = getClass().getResource("/Images/" + dsGiay.get(i).getAnh());
            ImageIcon icon = new ImageIcon(url);
            lbGiay1.setIcon(new ImageIcon(icon.getImage().getScaledInstance(lbGiay1.getWidth(), lbGiay1.getHeight(), 0)));
            lbSoLuongBH1.setText(dsGiay.get(i).getSLgCon() + "");
            lbGiaBanBH1.setText(dsGiay.get(i).getGiaBan() + "");
            tenAnh1 = dsGiay.get(i).getAnh();
        }
    }

    private void setAnhlbGiay2(List<SPCT> dsGiay, int i) {
        if (dsGiay.get(i).getAnh() != null) {
            URL url = getClass().getResource("/Images/" + dsGiay.get(i).getAnh());
            ImageIcon icon = new ImageIcon(url);
            lbGiay2.setIcon(new ImageIcon(icon.getImage().getScaledInstance(lbGiay2.getWidth(), lbGiay2.getHeight(), 0)));
            lbSoLuongBH2.setText(dsGiay.get(i).getSLgCon() + "");
            lbGiaBanBH2.setText(dsGiay.get(i).getGiaBan() + "");
            tenAnh2 = dsGiay.get(i).getAnh();
        }
    }

    private void setAnhlbGiay3(List<SPCT> dsGiay, int i) {
        if (dsGiay.get(i).getAnh() != null) {
            URL url = getClass().getResource("/Images/" + dsGiay.get(i).getAnh());
            ImageIcon icon = new ImageIcon(url);
            lbGiay3.setIcon(new ImageIcon(icon.getImage().getScaledInstance(lbGiay3.getWidth(), lbGiay3.getHeight(), 0)));
            lbSoLuongBH3.setText(dsGiay.get(i).getSLgCon() + "");
            lbGiaBanBH3.setText(dsGiay.get(i).getGiaBan() + "");
            tenAnh3 = dsGiay.get(i).getAnh();
        }
    }

    /**
     * *
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        sidePane = new javax.swing.JPanel();
        pnBanHang = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        pnDoanhSo = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        lbLogo = new javax.swing.JLabel();
        JTabPn = new javax.swing.JTabbedPane();
        pnBanHangView = new javax.swing.JPanel();
        tabpalBanHang = new javax.swing.JTabbedPane();
        jPanel2 = new javax.swing.JPanel();
        lbTitle = new javax.swing.JLabel();
        jScrollPane6 = new javax.swing.JScrollPane();
        tbHDCT1 = new javax.swing.JTable();
        jLabel31 = new javax.swing.JLabel();
        btnXoaHDCT1 = new javax.swing.JButton();
        btnSuaHDCT1 = new javax.swing.JButton();
        btnThemGioHangTemp = new javax.swing.JButton();
        btnQRCode = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        pnDsGiay1 = new javax.swing.JPanel();
        lbGiay0 = new javax.swing.JLabel();
        lbSoLuongBH0 = new javax.swing.JLabel();
        lbGiaBanBH0 = new javax.swing.JLabel();
        jLabel46 = new javax.swing.JLabel();
        jLabel47 = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        lbGiay1 = new javax.swing.JLabel();
        dd = new javax.swing.JLabel();
        d = new javax.swing.JLabel();
        lbSoLuongBH1 = new javax.swing.JLabel();
        lbGiaBanBH1 = new javax.swing.JLabel();
        pnDsGiay3 = new javax.swing.JPanel();
        lbGiay2 = new javax.swing.JLabel();
        rr = new javax.swing.JLabel();
        ddd = new javax.swing.JLabel();
        lbSoLuongBH2 = new javax.swing.JLabel();
        lbGiaBanBH2 = new javax.swing.JLabel();
        pnDsGiay4 = new javax.swing.JPanel();
        lbGiay3 = new javax.swing.JLabel();
        r = new javax.swing.JLabel();
        rrr = new javax.swing.JLabel();
        lbSoLuongBH3 = new javax.swing.JLabel();
        lbGiaBanBH3 = new javax.swing.JLabel();
        lbDsGiayTien = new javax.swing.JLabel();
        lbDsGiayLui = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        lbAnhGiay_BH = new javax.swing.JLabel();
        txtIdGiay_BH = new javax.swing.JTextField();
        jLabel42 = new javax.swing.JLabel();
        txtNamBH_BH = new javax.swing.JTextField();
        jLabel36 = new javax.swing.JLabel();
        spnSl_BH = new javax.swing.JSpinner();
        jLabel35 = new javax.swing.JLabel();
        txtGiaBan_BH = new javax.swing.JTextField();
        jLabel34 = new javax.swing.JLabel();
        jScrollPane7 = new javax.swing.JScrollPane();
        txtMoTa_BH = new javax.swing.JTextArea();
        jLabel33 = new javax.swing.JLabel();
        jLabel38 = new javax.swing.JLabel();
        txtTenSP_BH = new javax.swing.JTextField();
        jPanel1 = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbHoaDon = new javax.swing.JTable();
        jLabel24 = new javax.swing.JLabel();
        btnSuaHDCT = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        txtMaHD = new javax.swing.JTextField();
        txtIdHD = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        txtTongTien = new javax.swing.JTextField();
        txtPhanTramGiam = new javax.swing.JTextField();
        jLabel23 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        btnTaoHD = new javax.swing.JButton();
        btnSuaHD = new javax.swing.JButton();
        jLabel26 = new javax.swing.JLabel();
        txtTienKhachDua = new javax.swing.JTextField();
        jLabel27 = new javax.swing.JLabel();
        txtTienThua = new javax.swing.JTextField();
        btnLamMoi = new javax.swing.JButton();
        btnHuyHD = new javax.swing.JButton();
        btnThanhToan = new javax.swing.JButton();
        txtNgayTao = new javax.swing.JTextField();
        cbbIdKhachHang = new javax.swing.JComboBox<>();
        cbbIdNhanVien = new javax.swing.JComboBox<>();
        clcNgayGui = new com.toedter.calendar.JDateChooser();
        clcNgayNhan = new com.toedter.calendar.JDateChooser();
        cbbTinhTrang = new javax.swing.JComboBox<>();
        jLabel29 = new javax.swing.JLabel();
        btnXoaHDCT = new javax.swing.JButton();
        jScrollPane8 = new javax.swing.JScrollPane();
        tbHDCT0 = new javax.swing.JTable();
        jLabel37 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        pnDoanhSoView = new javax.swing.JPanel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel7 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        cbbNamDoanhSo = new javax.swing.JComboBox<>();
        jLabel30 = new javax.swing.JLabel();
        cbbThangDoanhSo = new javax.swing.JComboBox<>();
        jLabel32 = new javax.swing.JLabel();
        cbbNgayDoanhSo = new javax.swing.JComboBox<>();
        pieChart1 = new Piechart.PieChart();
        jPanel8 = new javax.swing.JPanel();
        jPanel9 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tbNamDoanhThu = new javax.swing.JTable();
        cbbNamDoanhThu = new javax.swing.JComboBox<>();
        jLabel39 = new javax.swing.JLabel();
        jLabel40 = new javax.swing.JLabel();
        lbDoanhThuNam = new javax.swing.JLabel();
        jPanel10 = new javax.swing.JPanel();
        jScrollPane5 = new javax.swing.JScrollPane();
        tbThangDoanhThu = new javax.swing.JTable();
        Jlabel = new javax.swing.JLabel();
        lbDoanhThuThang = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        sidePane.setBackground(new java.awt.Color(54, 33, 89));

        pnBanHang.setBackground(new java.awt.Color(64, 33, 100));
        pnBanHang.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                pnBanHangMousePressed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel5.setText("Icon");

        jLabel6.setBackground(new java.awt.Color(255, 255, 255));
        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Bán hàng");

        pnDoanhSo.setBackground(new java.awt.Color(64, 33, 100));
        pnDoanhSo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                pnDoanhSoMousePressed(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel7.setText("Icon");

        jLabel8.setBackground(new java.awt.Color(255, 255, 255));
        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Doanh số");

        javax.swing.GroupLayout pnDoanhSoLayout = new javax.swing.GroupLayout(pnDoanhSo);
        pnDoanhSo.setLayout(pnDoanhSoLayout);
        pnDoanhSoLayout.setHorizontalGroup(
            pnDoanhSoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnDoanhSoLayout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(35, 35, 35)
                .addComponent(jLabel8)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pnDoanhSoLayout.setVerticalGroup(
            pnDoanhSoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnDoanhSoLayout.createSequentialGroup()
                .addGap(0, 6, Short.MAX_VALUE)
                .addGroup(pnDoanhSoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(0, 0, 0))
        );

        javax.swing.GroupLayout pnBanHangLayout = new javax.swing.GroupLayout(pnBanHang);
        pnBanHang.setLayout(pnBanHangLayout);
        pnBanHangLayout.setHorizontalGroup(
            pnBanHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnBanHangLayout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(35, 35, 35)
                .addComponent(jLabel6)
                .addContainerGap(92, Short.MAX_VALUE))
            .addComponent(pnDoanhSo, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        pnBanHangLayout.setVerticalGroup(
            pnBanHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnBanHangLayout.createSequentialGroup()
                .addGap(0, 6, Short.MAX_VALUE)
                .addGroup(pnBanHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnDoanhSo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        lbLogo.setBackground(new java.awt.Color(255, 255, 255));
        lbLogo.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        lbLogo.setForeground(new java.awt.Color(255, 255, 255));
        lbLogo.setText("Logo");

        javax.swing.GroupLayout sidePaneLayout = new javax.swing.GroupLayout(sidePane);
        sidePane.setLayout(sidePaneLayout);
        sidePaneLayout.setHorizontalGroup(
            sidePaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnBanHang, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, sidePaneLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lbLogo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        sidePaneLayout.setVerticalGroup(
            sidePaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(sidePaneLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lbLogo, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(pnBanHang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(436, Short.MAX_VALUE))
        );

        getContentPane().add(sidePane, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 5, 249, 750));

        tabpalBanHang.setBackground(new java.awt.Color(255, 255, 255));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        lbTitle.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lbTitle.setText("Sản phẩm");

        jScrollPane6.setBorder(null);

        tbHDCT1.setAutoCreateRowSorter(true);
        tbHDCT1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        tbHDCT1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id hóa đơn", "Id sản phẩm", "Số lượng", "Đơn giá"
            }
        ));
        tbHDCT1.setGridColor(new java.awt.Color(255, 255, 255));
        tbHDCT1.setIntercellSpacing(new java.awt.Dimension(5, 5));
        tbHDCT1.setRowHeight(25);
        tbHDCT1.setSelectionBackground(new java.awt.Color(122, 72, 221));
        tbHDCT1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbHDCT1MouseClicked(evt);
            }
        });
        jScrollPane6.setViewportView(tbHDCT1);

        jLabel31.setText("Giỏ hàng");

        btnXoaHDCT1.setText("Xóa giày");
        btnXoaHDCT1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXoaHDCT1ActionPerformed(evt);
            }
        });

        btnSuaHDCT1.setText("Sửa giỏ hàng");
        btnSuaHDCT1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSuaHDCT1ActionPerformed(evt);
            }
        });

        btnThemGioHangTemp.setText("Thêm vào giỏ hàng");
        btnThemGioHangTemp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemGioHangTempActionPerformed(evt);
            }
        });

        btnQRCode.setText("QR code");
        btnQRCode.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnQRCodeActionPerformed(evt);
            }
        });

        jPanel4.setBackground(new java.awt.Color(110, 89, 222));

        lbGiay0.setText("jLabel32");
        lbGiay0.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbGiay0MouseClicked(evt);
            }
        });

        lbSoLuongBH0.setText("Số lượng");

        lbGiaBanBH0.setText("Giá bán");

        jLabel46.setText("Giá bán");

        jLabel47.setText("Số lượng");

        javax.swing.GroupLayout pnDsGiay1Layout = new javax.swing.GroupLayout(pnDsGiay1);
        pnDsGiay1.setLayout(pnDsGiay1Layout);
        pnDsGiay1Layout.setHorizontalGroup(
            pnDsGiay1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lbGiay0, javax.swing.GroupLayout.PREFERRED_SIZE, 257, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGroup(pnDsGiay1Layout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addGroup(pnDsGiay1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel47)
                    .addComponent(jLabel46, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnDsGiay1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbSoLuongBH0)
                    .addComponent(lbGiaBanBH0, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pnDsGiay1Layout.setVerticalGroup(
            pnDsGiay1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnDsGiay1Layout.createSequentialGroup()
                .addComponent(lbGiay0, javax.swing.GroupLayout.PREFERRED_SIZE, 231, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(13, 13, 13)
                .addGroup(pnDsGiay1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbSoLuongBH0)
                    .addComponent(jLabel47))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnDsGiay1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbGiaBanBH0)
                    .addComponent(jLabel46))
                .addContainerGap(32, Short.MAX_VALUE))
        );

        lbGiay1.setText("jLabel32");
        lbGiay1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbGiay1MouseClicked(evt);
            }
        });

        dd.setText("Giá bán");

        d.setText("Số lượng");

        lbSoLuongBH1.setText("Số lượng");

        lbGiaBanBH1.setText("Giá bán");

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lbGiay1, javax.swing.GroupLayout.PREFERRED_SIZE, 257, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(46, 46, 46)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(d)
                    .addComponent(dd, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(36, 36, 36)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbSoLuongBH1)
                    .addComponent(lbGiaBanBH1, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addComponent(lbGiay1, javax.swing.GroupLayout.PREFERRED_SIZE, 231, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(d)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(dd))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(lbSoLuongBH1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(lbGiaBanBH1)))
                .addGap(0, 0, Short.MAX_VALUE))
        );

        lbGiay2.setText("jLabel32");
        lbGiay2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbGiay2MouseClicked(evt);
            }
        });

        rr.setText("Giá bán");

        ddd.setText("Số lượng");

        lbSoLuongBH2.setText("Số lượng");

        lbGiaBanBH2.setText("Giá bán");

        javax.swing.GroupLayout pnDsGiay3Layout = new javax.swing.GroupLayout(pnDsGiay3);
        pnDsGiay3.setLayout(pnDsGiay3Layout);
        pnDsGiay3Layout.setHorizontalGroup(
            pnDsGiay3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lbGiay2, javax.swing.GroupLayout.PREFERRED_SIZE, 257, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGroup(pnDsGiay3Layout.createSequentialGroup()
                .addGap(49, 49, 49)
                .addGroup(pnDsGiay3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(ddd)
                    .addComponent(rr, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(38, 38, 38)
                .addGroup(pnDsGiay3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbSoLuongBH2)
                    .addComponent(lbGiaBanBH2, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pnDsGiay3Layout.setVerticalGroup(
            pnDsGiay3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnDsGiay3Layout.createSequentialGroup()
                .addComponent(lbGiay2, javax.swing.GroupLayout.PREFERRED_SIZE, 231, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(pnDsGiay3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnDsGiay3Layout.createSequentialGroup()
                        .addComponent(ddd)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(rr))
                    .addGroup(pnDsGiay3Layout.createSequentialGroup()
                        .addComponent(lbSoLuongBH2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(lbGiaBanBH2)))
                .addGap(0, 0, Short.MAX_VALUE))
        );

        lbGiay3.setText("jLabel32");
        lbGiay3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbGiay3MouseClicked(evt);
            }
        });

        r.setText("Số lượng");

        rrr.setText("Giá bán");

        lbSoLuongBH3.setText("Số lượng");

        lbGiaBanBH3.setText("Giá bán");

        javax.swing.GroupLayout pnDsGiay4Layout = new javax.swing.GroupLayout(pnDsGiay4);
        pnDsGiay4.setLayout(pnDsGiay4Layout);
        pnDsGiay4Layout.setHorizontalGroup(
            pnDsGiay4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnDsGiay4Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(lbGiay3, javax.swing.GroupLayout.PREFERRED_SIZE, 257, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(pnDsGiay4Layout.createSequentialGroup()
                .addGap(48, 48, 48)
                .addGroup(pnDsGiay4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(r)
                    .addComponent(rrr, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(31, 31, 31)
                .addGroup(pnDsGiay4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbSoLuongBH3)
                    .addComponent(lbGiaBanBH3, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pnDsGiay4Layout.setVerticalGroup(
            pnDsGiay4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnDsGiay4Layout.createSequentialGroup()
                .addComponent(lbGiay3, javax.swing.GroupLayout.PREFERRED_SIZE, 237, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnDsGiay4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnDsGiay4Layout.createSequentialGroup()
                        .addComponent(r)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(rrr))
                    .addGroup(pnDsGiay4Layout.createSequentialGroup()
                        .addComponent(lbSoLuongBH3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(lbGiaBanBH3)))
                .addGap(0, 0, Short.MAX_VALUE))
        );

        lbDsGiayTien.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        lbDsGiayTien.setText(">");
        lbDsGiayTien.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbDsGiayTienMouseClicked(evt);
            }
        });

        lbDsGiayLui.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        lbDsGiayLui.setText("<");
        lbDsGiayLui.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbDsGiayLuiMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(lbDsGiayLui)
                .addGap(0, 0, 0)
                .addComponent(pnDsGiay1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnDsGiay3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnDsGiay4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lbDsGiayTien))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lbDsGiayTien, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(139, 139, 139))
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(pnDsGiay4, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(pnDsGiay1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel6, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(pnDsGiay3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(116, 116, 116)
                .addComponent(lbDsGiayLui, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(150, Short.MAX_VALUE))
        );

        lbAnhGiay_BH.setText("IMG");

        txtIdGiay_BH.setEditable(false);

        jLabel42.setText("Id sản phẩm");

        txtNamBH_BH.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        jLabel36.setText("Năm BH");

        jLabel35.setText("Số lượng");

        txtGiaBan_BH.setEditable(false);

        jLabel34.setText("Giá bán");

        txtMoTa_BH.setColumns(20);
        txtMoTa_BH.setRows(5);
        jScrollPane7.setViewportView(txtMoTa_BH);

        jLabel33.setText("Mô tả");

        jLabel38.setText("Tên giày");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addComponent(lbAnhGiay_BH, javax.swing.GroupLayout.PREFERRED_SIZE, 257, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel33, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel35)
                            .addComponent(jLabel34, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(23, 23, 23)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(txtGiaBan_BH, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(spnSl_BH)
                            .addComponent(jScrollPane7, javax.swing.GroupLayout.DEFAULT_SIZE, 252, Short.MAX_VALUE)))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel42)
                            .addComponent(jLabel36)
                            .addComponent(jLabel38))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtIdGiay_BH, javax.swing.GroupLayout.DEFAULT_SIZE, 252, Short.MAX_VALUE)
                            .addComponent(txtNamBH_BH)
                            .addComponent(txtTenSP_BH))))
                .addContainerGap(13, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addComponent(lbAnhGiay_BH, javax.swing.GroupLayout.PREFERRED_SIZE, 231, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 37, Short.MAX_VALUE))
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel42, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(txtIdGiay_BH, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel38)
                    .addComponent(txtTenSP_BH, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel36, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(txtNamBH_BH, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(spnSl_BH, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel35))
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtGiaBan_BH, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel34))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(40, 40, 40)
                        .addComponent(jLabel33)))
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel31)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnThemGioHangTemp)
                                .addGap(6, 6, 6)
                                .addComponent(btnXoaHDCT1, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(6, 6, 6)
                                .addComponent(btnSuaHDCT1)
                                .addGap(6, 6, 6)
                                .addComponent(btnQRCode)
                                .addGap(3, 3, 3))
                            .addComponent(jScrollPane6)))
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel2Layout.createSequentialGroup()
                            .addGap(537, 537, 537)
                            .addComponent(lbTitle))
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, 1096, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(24, 24, 24))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lbTitle)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(198, 198, 198)
                        .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(btnThemGioHangTemp)
                                        .addComponent(jLabel31))
                                    .addComponent(btnXoaHDCT1)
                                    .addComponent(btnSuaHDCT1)
                                    .addComponent(btnQRCode))
                                .addGap(174, 174, 174))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))))
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        tabpalBanHang.addTab("Sản phẩm", jPanel2);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jLabel10.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel10.setText("Hóa đơn");

        jScrollPane2.setBorder(null);

        tbHoaDon.setAutoCreateRowSorter(true);
        tbHoaDon.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        tbHoaDon.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id", "Mã", "Tên khách hàng", "Tên nhân viên", "Ngày tạo", "Ngày thanh toán", "Ngày gửi", "Ngày nhận", "Tình trạng", "Phần trăm giảm"
            }
        ));
        tbHoaDon.setGridColor(new java.awt.Color(255, 255, 255));
        tbHoaDon.setIntercellSpacing(new java.awt.Dimension(5, 5));
        tbHoaDon.setRowHeight(25);
        tbHoaDon.setSelectionBackground(new java.awt.Color(122, 72, 221));
        tbHoaDon.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                tbHoaDonMousePressed(evt);
            }
        });
        jScrollPane2.setViewportView(tbHoaDon);

        jLabel24.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel24.setText("Giỏ hàng");

        btnSuaHDCT.setText("Sửa giỏ hàng");
        btnSuaHDCT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSuaHDCTActionPerformed(evt);
            }
        });

        jPanel3.setBackground(new java.awt.Color(131, 111, 255));

        jLabel14.setText("Id");

        jLabel15.setText("Mã");

        jLabel16.setText("Mã khách hàng");

        jLabel17.setText("Mã nhân viên");

        jLabel18.setText("Ngày tạo");

        jLabel19.setText("Tổng tiền");

        jLabel23.setText("Phần trăm giảm");

        jLabel22.setText("Tình trạng");

        jLabel21.setText("Ngày nhận");

        jLabel20.setText("Ngày gửi");

        btnTaoHD.setText("Tạo hóa đơn");
        btnTaoHD.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTaoHDActionPerformed(evt);
            }
        });

        btnSuaHD.setText("Sửa hóa đơn");
        btnSuaHD.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSuaHDActionPerformed(evt);
            }
        });

        jLabel26.setText("Tiền khách đưa");

        jLabel27.setText("Tiền thừa");

        btnLamMoi.setText("Làm mới");
        btnLamMoi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLamMoiActionPerformed(evt);
            }
        });

        btnHuyHD.setText("Hủy hóa đơn");
        btnHuyHD.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHuyHDActionPerformed(evt);
            }
        });

        btnThanhToan.setText("Thanh toán");
        btnThanhToan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThanhToanActionPerformed(evt);
            }
        });

        cbbIdKhachHang.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        cbbIdNhanVien.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        cbbTinhTrang.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                                .addComponent(btnTaoHD)
                                .addGap(52, 52, 52)
                                .addComponent(btnSuaHD)
                                .addGap(60, 60, 60))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                                .addComponent(btnHuyHD)
                                .addGap(50, 50, 50)
                                .addComponent(btnLamMoi)
                                .addGap(63, 63, 63))))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addGroup(jPanel3Layout.createSequentialGroup()
                                    .addComponent(jLabel27)
                                    .addGap(57, 57, 57)
                                    .addComponent(txtTienThua))
                                .addGroup(jPanel3Layout.createSequentialGroup()
                                    .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(58, 58, 58)
                                    .addComponent(txtIdHD, javax.swing.GroupLayout.PREFERRED_SIZE, 218, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(jPanel3Layout.createSequentialGroup()
                                    .addComponent(jLabel26, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(18, 18, 18)
                                    .addComponent(txtTienKhachDua))
                                .addGroup(jPanel3Layout.createSequentialGroup()
                                    .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(18, 18, 18)
                                    .addComponent(txtTongTien))
                                .addComponent(jLabel21)
                                .addComponent(jLabel20)
                                .addGroup(jPanel3Layout.createSequentialGroup()
                                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel16)
                                        .addComponent(jLabel17))
                                    .addGap(19, 19, 19)
                                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(txtMaHD)
                                        .addComponent(cbbIdKhachHang, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                                .addGroup(jPanel3Layout.createSequentialGroup()
                                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel23)
                                        .addComponent(jLabel22, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGap(18, 18, 18)
                                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(txtPhanTramGiam)
                                        .addComponent(cbbTinhTrang, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jLabel18)
                                .addGap(52, 52, 52)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(clcNgayNhan, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(txtNgayTao, javax.swing.GroupLayout.DEFAULT_SIZE, 218, Short.MAX_VALUE)
                                    .addComponent(clcNgayGui, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(cbbIdNhanVien, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                        .addContainerGap(16, Short.MAX_VALUE))))
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(142, 142, 142)
                .addComponent(btnThanhToan)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(txtIdHD, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel14))
                .addGap(12, 12, 12)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtMaHD, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel15))
                .addGap(12, 12, 12)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel16)
                    .addComponent(cbbIdKhachHang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(12, 12, 12)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel17)
                    .addComponent(cbbIdNhanVien, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtNgayTao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel18))
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(47, 47, 47)
                                .addComponent(jLabel21))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(clcNgayGui, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(9, 9, 9)
                                .addComponent(clcNgayNhan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel22)
                            .addComponent(cbbTinhTrang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(9, 9, 9)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel23)
                            .addComponent(txtPhanTramGiam, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(16, 16, 16)
                        .addComponent(jLabel20)))
                .addGap(23, 23, 23)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnTaoHD)
                    .addComponent(btnSuaHD))
                .addGap(38, 38, 38)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel19)
                    .addComponent(txtTongTien, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel26)
                    .addComponent(txtTienKhachDua, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel27)
                    .addComponent(txtTienThua, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(23, 23, 23)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnHuyHD)
                    .addComponent(btnLamMoi))
                .addGap(20, 20, 20)
                .addComponent(btnThanhToan)
                .addContainerGap(29, Short.MAX_VALUE))
        );

        jLabel29.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel29.setText("Hóa đơn");

        btnXoaHDCT.setText("Xóa giày");
        btnXoaHDCT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXoaHDCTActionPerformed(evt);
            }
        });

        jScrollPane8.setBorder(null);

        tbHDCT0.setAutoCreateRowSorter(true);
        tbHDCT0.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        tbHDCT0.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id hóa đơn", "Id sản phẩm", "Số lượng", "Đơn giá"
            }
        ));
        tbHDCT0.setGridColor(new java.awt.Color(255, 255, 255));
        tbHDCT0.setIntercellSpacing(new java.awt.Dimension(5, 5));
        tbHDCT0.setRowHeight(25);
        tbHDCT0.setSelectionBackground(new java.awt.Color(122, 72, 221));
        tbHDCT0.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbHDCT0MouseClicked(evt);
            }
        });
        jScrollPane8.setViewportView(tbHDCT0);

        jLabel37.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel37.setText("Hóa đơn");

        jButton1.setText("In hóa đon");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel29)
                                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 757, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jButton1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel37)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(520, 520, 520)
                        .addComponent(jLabel10))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel24)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jScrollPane8, javax.swing.GroupLayout.PREFERRED_SIZE, 611, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(btnSuaHDCT)
                                    .addComponent(btnXoaHDCT, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                .addGap(23, 23, 23))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addComponent(jLabel10)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addComponent(jLabel29)
                        .addGap(6, 6, 6)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 235, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton1)
                        .addGap(34, 34, 34)
                        .addComponent(jLabel24)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jScrollPane8, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(btnXoaHDCT)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnSuaHDCT)
                                .addGap(49, 49, 49))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(9, 9, 9)
                        .addComponent(jLabel37)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(73, Short.MAX_VALUE))
        );

        tabpalBanHang.addTab("Hóa đơn", jPanel1);

        javax.swing.GroupLayout pnBanHangViewLayout = new javax.swing.GroupLayout(pnBanHangView);
        pnBanHangView.setLayout(pnBanHangViewLayout);
        pnBanHangViewLayout.setHorizontalGroup(
            pnBanHangViewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnBanHangViewLayout.createSequentialGroup()
                .addComponent(tabpalBanHang, javax.swing.GroupLayout.PREFERRED_SIZE, 1127, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        pnBanHangViewLayout.setVerticalGroup(
            pnBanHangViewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnBanHangViewLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(tabpalBanHang, javax.swing.GroupLayout.PREFERRED_SIZE, 754, Short.MAX_VALUE)
                .addContainerGap())
        );

        JTabPn.addTab("Bán hàng", pnBanHangView);

        pnDoanhSoView.setBackground(new java.awt.Color(255, 255, 255));
        pnDoanhSoView.setPreferredSize(new java.awt.Dimension(1133, 766));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel1.setText("Doanh số ngày");

        jLabel28.setText("Năm");

        cbbNamDoanhSo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cbbNamDoanhSo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbbNamDoanhSoActionPerformed(evt);
            }
        });

        jLabel30.setText("Tháng");

        cbbThangDoanhSo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cbbThangDoanhSo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbbThangDoanhSoActionPerformed(evt);
            }
        });

        jLabel32.setText("Ngày");

        cbbNgayDoanhSo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cbbNgayDoanhSo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbbNgayDoanhSoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(pieChart1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addContainerGap(480, Short.MAX_VALUE)
                        .addComponent(jLabel28)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel7Layout.createSequentialGroup()
                                .addComponent(cbbNamDoanhSo, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(26, 26, 26)
                                .addComponent(jLabel30))
                            .addComponent(jLabel1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(cbbThangDoanhSo, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel32)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(cbbNgayDoanhSo, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(11, 11, 11)))
                .addContainerGap())
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jLabel1)
                .addGap(36, 36, 36)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel28)
                    .addComponent(cbbNamDoanhSo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel30)
                    .addComponent(cbbThangDoanhSo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel32)
                    .addComponent(cbbNgayDoanhSo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pieChart1, javax.swing.GroupLayout.DEFAULT_SIZE, 584, Short.MAX_VALUE)
                .addContainerGap())
        );

        jTabbedPane1.addTab("Doanh số", jPanel7);

        jScrollPane3.setBorder(null);

        tbNamDoanhThu.setAutoCreateRowSorter(true);
        tbNamDoanhThu.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        tbNamDoanhThu.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Tháng", "Doanh thu"
            }
        ));
        tbNamDoanhThu.setGridColor(new java.awt.Color(255, 255, 255));
        tbNamDoanhThu.setIntercellSpacing(new java.awt.Dimension(5, 5));
        tbNamDoanhThu.setName(""); // NOI18N
        tbNamDoanhThu.setRowHeight(25);
        tbNamDoanhThu.setSelectionBackground(new java.awt.Color(122, 72, 221));
        tbNamDoanhThu.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbNamDoanhThuMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(tbNamDoanhThu);

        cbbNamDoanhThu.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cbbNamDoanhThu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbbNamDoanhThuActionPerformed(evt);
            }
        });

        jLabel39.setText("Năm");

        jLabel40.setText("Doanh thu năm");

        lbDoanhThuNam.setText("0");

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 466, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel9Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jLabel39, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(cbbNamDoanhThu, javax.swing.GroupLayout.PREFERRED_SIZE, 213, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(91, 91, 91))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel9Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel40)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lbDoanhThuNam, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbbNamDoanhThu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel39))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 607, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel40)
                    .addComponent(lbDoanhThuNam))
                .addGap(18, 18, 18))
        );

        jScrollPane5.setBorder(null);

        tbThangDoanhThu.setAutoCreateRowSorter(true);
        tbThangDoanhThu.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        tbThangDoanhThu.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Ngày", "Doanh thu"
            }
        ));
        tbThangDoanhThu.setGridColor(new java.awt.Color(255, 255, 255));
        tbThangDoanhThu.setIntercellSpacing(new java.awt.Dimension(5, 5));
        tbThangDoanhThu.setName(""); // NOI18N
        tbThangDoanhThu.setRowHeight(25);
        tbThangDoanhThu.setSelectionBackground(new java.awt.Color(122, 72, 221));
        jScrollPane5.setViewportView(tbThangDoanhThu);

        Jlabel.setText("Doanh thu tháng");

        lbDoanhThuThang.setText("0");

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel10Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(Jlabel, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(lbDoanhThuThang, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane5, javax.swing.GroupLayout.DEFAULT_SIZE, 609, Short.MAX_VALUE))
                .addGap(3, 3, 3))
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 607, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Jlabel)
                    .addComponent(lbDoanhThuThang))
                .addGap(18, 18, 18))
        );

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        jTabbedPane1.addTab("Doanh thu", jPanel8);

        javax.swing.GroupLayout pnDoanhSoViewLayout = new javax.swing.GroupLayout(pnDoanhSoView);
        pnDoanhSoView.setLayout(pnDoanhSoViewLayout);
        pnDoanhSoViewLayout.setHorizontalGroup(
            pnDoanhSoViewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnDoanhSoViewLayout.createSequentialGroup()
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1114, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 19, Short.MAX_VALUE))
        );
        pnDoanhSoViewLayout.setVerticalGroup(
            pnDoanhSoViewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnDoanhSoViewLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 736, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        JTabPn.addTab("Doanh số", pnDoanhSoView);

        getContentPane().add(JTabPn, new org.netbeans.lib.awtextra.AbsoluteConstraints(255, -36, -1, 790));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void pnBanHangMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnBanHangMousePressed
        // TODO add your handling code here:

        setColorPnMenu(pnBanHang);
        resetColorPnMenu(pnDoanhSo);

        this.JTabPn.setSelectedIndex(0);
    }//GEN-LAST:event_pnBanHangMousePressed

    private void pnDoanhSoMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnDoanhSoMousePressed
        // TODO add your handling code here:
        setColorPnMenu(pnDoanhSo);
        resetColorPnMenu(pnBanHang);

        this.JTabPn.setSelectedIndex(1);
    }//GEN-LAST:event_pnDoanhSoMousePressed

    private void lbDsGiayLuiMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbDsGiayLuiMouseClicked
        // TODO add your handling code here:
        loadDsGiay_BHLui();
    }//GEN-LAST:event_lbDsGiayLuiMouseClicked

    private void lbDsGiayTienMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbDsGiayTienMouseClicked
        // TODO add your handling code here:
        loadDsGiay_BHTien();
    }//GEN-LAST:event_lbDsGiayTienMouseClicked

    private void lbGiay0MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbGiay0MouseClicked
        // TODO add your handling code here:
        URL url = getClass().getResource("/Images/" + tenAnh0);
        ImageIcon icon = new ImageIcon(url);
        lbAnhGiay_BH.setIcon(new ImageIcon(icon.getImage().getScaledInstance(lbAnhGiay_BH.getWidth(), lbAnhGiay_BH.getHeight(), 0)));
        for (SPCT spct : dsGiay) {
            if (tenAnh0.equals(spct.getAnh())) {
                txtIdGiay_BH.setText(spct.getId());
                txtTenSP_BH.setText(spct.getSp().getTen());
                idSP_CT = txtIdGiay_BH.getText();
                txtNamBH_BH.setText(spct.getNamBH() + "");
                spnSl_BH.setValue(1);
                txtGiaBan_BH.setText(spct.getGiaBan() + "");
                txtMoTa_BH.setText(spct.getMoTa());
            }
        }
    }//GEN-LAST:event_lbGiay0MouseClicked

    private void lbGiay1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbGiay1MouseClicked
        // TODO add your handling code here:
        URL url = getClass().getResource("/Images/" + tenAnh1);
        ImageIcon icon = new ImageIcon(url);
        lbAnhGiay_BH.setIcon(new ImageIcon(icon.getImage().getScaledInstance(lbAnhGiay_BH.getWidth(), lbAnhGiay_BH.getHeight(), 0)));
        for (SPCT spct : dsGiay) {
            if (tenAnh1.equals(spct.getAnh())) {
                txtIdGiay_BH.setText(spct.getId());
                txtTenSP_BH.setText(spct.getSp().getTen());
                idSP_CT = txtIdGiay_BH.getText();
                txtNamBH_BH.setText(spct.getNamBH() + "");
                spnSl_BH.setValue(1);
                txtGiaBan_BH.setText(spct.getGiaBan() + "");
                txtMoTa_BH.setText(spct.getMoTa());
            }
        }
    }//GEN-LAST:event_lbGiay1MouseClicked

    private void lbGiay2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbGiay2MouseClicked
        // TODO add your handling code here:
        URL url = getClass().getResource("/Images/" + tenAnh2);
        ImageIcon icon = new ImageIcon(url);
        lbAnhGiay_BH.setIcon(new ImageIcon(icon.getImage().getScaledInstance(lbAnhGiay_BH.getWidth(), lbAnhGiay_BH.getHeight(), 0)));
        for (SPCT spct : dsGiay) {
            if (tenAnh2.equals(spct.getAnh())) {
                txtIdGiay_BH.setText(spct.getId());
                txtTenSP_BH.setText(spct.getSp().getTen());
                idSP_CT = txtIdGiay_BH.getText();
                txtNamBH_BH.setText(spct.getNamBH() + "");
                spnSl_BH.setValue(1);
                txtGiaBan_BH.setText(spct.getGiaBan() + "");
                txtMoTa_BH.setText(spct.getMoTa());
            }
        }
    }//GEN-LAST:event_lbGiay2MouseClicked

    private void lbGiay3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbGiay3MouseClicked
        // TODO add your handling code here:
        URL url = getClass().getResource("/Images/" + tenAnh3);
        ImageIcon icon = new ImageIcon(url);
        lbAnhGiay_BH.setIcon(new ImageIcon(icon.getImage().getScaledInstance(lbAnhGiay_BH.getWidth(), lbAnhGiay_BH.getHeight(), 0)));
        for (SPCT spct : dsGiay) {
            if (tenAnh3.equals(spct.getAnh())) {
                txtIdGiay_BH.setText(spct.getId());
                txtTenSP_BH.setText(spct.getSp().getTen());
                idSP_CT = txtIdGiay_BH.getText();
                txtNamBH_BH.setText(spct.getNamBH() + "");
                spnSl_BH.setValue(1);
                txtGiaBan_BH.setText(spct.getGiaBan() + "");
                txtMoTa_BH.setText(spct.getMoTa());
            }
        }
    }//GEN-LAST:event_lbGiay3MouseClicked

    private void btnQRCodeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnQRCodeActionPerformed
        // TODO add your handling code here:
        ReadQRCode read = new ReadQRCode(this);
        read.setVisible(true);
        
    }//GEN-LAST:event_btnQRCodeActionPerformed

    private void btnThemGioHangTempActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemGioHangTempActionPerformed
        // TODO add your handling code here:
        HDCT hdct = getHDCTFromInput();
        for (HDCT hdct1 : dsHDCT) {
            if (hdct.getIdSPCT().equals(hdct1.getIdSPCT())) {
                JOptionPane.showMessageDialog(this, "Bạn đã có sản phẩm này trong giỏ hàng");
                return;
            }
        }
        _IHoaDonService.saveHDCT(hdct);
        loadTableHDCT(idHD_CT);
    }//GEN-LAST:event_btnThemGioHangTempActionPerformed

    private void tbHoaDonMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbHoaDonMousePressed
        // TODO add your handling code here:
        int row = tbHoaDon.getSelectedRow();
        String id = tbHoaDon.getValueAt(row, 0).toString();
        idHD_CT = id;
        String ma = tbHoaDon.getValueAt(row, 1).toString();
        String idkh = tbHoaDon.getValueAt(row, 2).toString();
        String idnv = tbHoaDon.getValueAt(row, 3).toString();
        String ngayTao = tbHoaDon.getValueAt(row, 4) + "";
        //String ngayTT = tbHoaDon.getValueAt(row, 5).toString();
        String tinhTrang = tbHoaDon.getValueAt(row, 8).toString();
        String phanTram = tbHoaDon.getValueAt(row, 9).toString();

        txtIdHD.setText(id);
        txtMaHD.setText(ma);
        cbbIdKhachHang.setSelectedItem(idkh);
        cbbIdNhanVien.setSelectedItem(idnv);

        txtNgayTao.setText(ngayTao);
        try {
            Date ngayGuiD = new SimpleDateFormat("dd-MM-yyyy").parse(tbHoaDon.getValueAt(row, 6).toString());
            Date ngayNhanD = new SimpleDateFormat("dd-MM-yyyy").parse(tbHoaDon.getValueAt(row, 7).toString());
            System.out.println(ngayGuiD + "+" + ngayNhanD);
            clcNgayGui.setDate(ngayGuiD);
            clcNgayNhan.setDate(ngayNhanD);
            //clcNgayGui.setDateFormatString(tbHoaDon.getValueAt(row, 6).toString());
        } catch (ParseException ex) {
            ex.printStackTrace();
        }
        System.out.println(tinhTrang);
        if ("Chờ_Thanh_Toán".equals(tinhTrang)) {
            cbbTinhTrang.setSelectedItem(TrangThaiHD.Chờ_Thanh_Toán);
        } else if ("Đã_Hủy".equals(tinhTrang)) {
            cbbTinhTrang.setSelectedItem(TrangThaiHD.Đã_Hủy);
        } else {
            cbbTinhTrang.setSelectedItem(TrangThaiHD.Đã_Thanh_Toán);
        }

        txtPhanTramGiam.setText(phanTram);

        BigDecimal tongTien = null;
        dsHDCT = _IHoaDonService.findAllHDCT(id);
        for (HDCT hdct : dsHDCT) {
            if (tongTien == null) {
                tongTien = BigDecimal.valueOf(hdct.getsLg()).multiply(hdct.getDonGia());
            } else {
                tongTien = tongTien.add(BigDecimal.valueOf(hdct.getsLg()).multiply(hdct.getDonGia()));
            }
        }
        if(tongTien==null){
            txtTongTien.setText("0");
        }else{
        txtTongTien.setText(tongTien + "");
        }
        loadTableHDCT(id);
    }//GEN-LAST:event_tbHoaDonMousePressed

    private void btnTaoHDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTaoHDActionPerformed
        // TODO add your handling code here:
        _IHoaDonService.saveHD(getHoaDonFromInput());
        loadTableHoaDon();
    }//GEN-LAST:event_btnTaoHDActionPerformed

    private void btnSuaHDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSuaHDActionPerformed
        // TODO add your handling code here:
        HoaDon hd = getHoaDonFromInput();
        if (idHD_CT.length() == 0) {
            JOptionPane.showMessageDialog(this, "Bạn chưa chọn hóa đơn nào");
            return;
        }
        for (HoaDon hoaDon : dsHoaDon) {
            if(idHD_CT.equals(hoaDon.getId())){
                if(hoaDon.getTrangThai()==TrangThaiHD.Đã_Thanh_Toán){
                    JOptionPane.showMessageDialog(this, "Hóa đơn không thể sửa");
                    return;
                }
            }
        }
        hd.setId(idHD_CT);
        _IHoaDonService.updateHD(hd);
        loadTableHoaDon();
    }//GEN-LAST:event_btnSuaHDActionPerformed

    private void btnHuyHDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHuyHDActionPerformed
        // TODO add your handling code here:
        for (HoaDon hoaDon : dsHoaDon) {
            if(hoaDon.getId().equals(idHD_CT)){
                if(hoaDon.getTrangThai()==TrangThaiHD.Đã_Thanh_Toán){
                    JOptionPane.showMessageDialog(this, "Hóa đơn ko thể xóa");
                    return;
                }
            }
        }
        _IHoaDonService.deleteHD(idHD_CT);
        loadTableHoaDon();
    }//GEN-LAST:event_btnHuyHDActionPerformed

    private void btnThanhToanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThanhToanActionPerformed
        // TODO add your handling code here:
        HoaDon hd = new HoaDon();
        hd.setId(txtIdHD.getText());
        for (HoaDon hoaDon : dsHoaDon) {
            if (hd.getId().equals(hoaDon.getId())) {
                hd = hoaDon;
            }
        }
        if (hd == null) {
            JOptionPane.showMessageDialog(this, "Bạn chưa chọn hóa đơn nào");
            return;
        }
        BigDecimal tongTien = null;
        dsHDCT = _IHoaDonService.findAllHDCT(hd.getId());
        for (HDCT hdct : dsHDCT) {
            if (tongTien == null) {
                tongTien = BigDecimal.valueOf(hdct.getsLg()).multiply(hdct.getDonGia());
            } else {
                tongTien = tongTien.add(BigDecimal.valueOf(hdct.getsLg()).multiply(hdct.getDonGia()));
            }
        }
        txtTongTien.setText(tongTien + "");
        BigDecimal tienKhachDua = BigDecimal.valueOf(Float.parseFloat(txtTienKhachDua.getText().trim()));
        BigDecimal tienThua = tienKhachDua.subtract(tongTien);
        if (Float.parseFloat(tienThua + "") >= 0) {
            hd.setTrangThai(TrangThaiHD.Đã_Thanh_Toán);

            List<HDCT> listHDCT = _IHoaDonService.findAllHDCT(hd.getId());
            for (HDCT hdct : listHDCT) {
                int slTon = hdct.getsPCT().getSLgCon();
                int slCon = slTon - hdct.getsLg();
                if (slCon < 0) {
                    JOptionPane.showMessageDialog(this, "Số lượng mua vượt quá " + slTon + " sản phẩm");
                    return;
                }
                SPCT spct = hdct.getsPCT();
                spct.setSLgCon(slCon);
                _IGiay_BanHangService.updateGiay(spct);
            }
            hd.setNgayThanhToan(new Date());
            _IHoaDonService.updateHD(hd);
            txtTienThua.setText(tienThua + "");
        } else if (Float.parseFloat(tienThua + "") < 0) {
            txtTienThua.setText("Chưa đủ");
        }
        dsGiay = _IGiay_BanHangService.findAll();
        loadTableHoaDon();
    }//GEN-LAST:event_btnThanhToanActionPerformed

    private String idHD_CT;
    private String idSP_CT;
    private String donGia;
    private HDCT hdctUpdate;
    private void tbHDCT0MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbHDCT0MouseClicked
        // TODO add your handling code here:
        int row = tbHDCT0.getSelectedRow();
        idHD_CT = tbHDCT0.getValueAt(row, 0).toString();
        idSP_CT = tbHDCT0.getValueAt(row, 1).toString();
    }//GEN-LAST:event_tbHDCT0MouseClicked

    private void btnSuaHDCTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSuaHDCTActionPerformed
        // TODO add your handling code here:
        String sl = JOptionPane.showInputDialog(this, "Mời bạn nhập số lượng giày");
        HDCT hoaDonCT = null;
        if (idHD_CT.length() == 0 || idSP_CT.length() == 0) {
            JOptionPane.showMessageDialog(this, "Bạn chưa chọn sản phẩm nào");
            return;
        }
        List<HDCT> dsHDCTTemp = _IHoaDonService.findAllHDCT(idHD_CT);
        for (HDCT hdct : dsHDCTTemp) {
            if (idSP_CT.equals(hdct.getIdSPCT())) {
                hoaDonCT = hdct;
            }
        }
        hoaDonCT.setsLg(Integer.parseInt(sl));
        _IHoaDonService.updateHDCT(hoaDonCT);
        loadTableHDCT(idHD_CT);
    }//GEN-LAST:event_btnSuaHDCTActionPerformed

    private void btnXoaHDCTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaHDCTActionPerformed
        // TODO add your handling code here:
        HoaDon hoaDon = null;
        SPCT sanPhamCT = null;
        for (HoaDon hd : dsHoaDon) {
            if (idHD_CT.equals(hd.getId())) {
                hoaDon = hd;
            }
        }
        for (SPCT spct : dsGiay) {
            if (idSP_CT.equals(spct.getId())) {
                sanPhamCT = spct;
            }
        }
        _IHoaDonService.deleteHDCT(hoaDon, sanPhamCT);
        loadTableHDCT(idHD_CT);
    }//GEN-LAST:event_btnXoaHDCTActionPerformed

    private void tbHDCT1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbHDCT1MouseClicked
        // TODO add your handling code here:
        int row = tbHDCT1.getSelectedRow();
        idHD_CT = tbHDCT1.getValueAt(row, 0).toString();
        idSP_CT = tbHDCT1.getValueAt(row, 1).toString();
    }//GEN-LAST:event_tbHDCT1MouseClicked

    private void btnXoaHDCT1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaHDCT1ActionPerformed
        // TODO add your handling code here:
        HoaDon hoaDon = null;
        SPCT sanPhamCT = null;
        for (HoaDon hd : dsHoaDon) {
            if (idHD_CT.equals(hd.getId())) {
                hoaDon = hd;
            }
        }
        for (SPCT spct : dsGiay) {
            if (idSP_CT.equals(spct.getId())) {
                sanPhamCT = spct;
            }
        }
        _IHoaDonService.deleteHDCT(hoaDon, sanPhamCT);
        loadTableHDCT(idHD_CT);
    }//GEN-LAST:event_btnXoaHDCT1ActionPerformed

    private void btnSuaHDCT1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSuaHDCT1ActionPerformed
        // TODO add your handling code here:
        String sl = JOptionPane.showInputDialog(this, "Mời bạn nhập số lượng giày");
        HDCT hoaDonCT = null;
        if (idHD_CT.length() == 0 || idSP_CT.length() == 0) {
            JOptionPane.showMessageDialog(this, "Bạn chưa chọn sản phẩm nào");
            return;
        }
        List<HDCT> dsHDCTTemp = _IHoaDonService.findAllHDCT(idHD_CT);
        for (HDCT hdct : dsHDCTTemp) {
            if (idSP_CT.equals(hdct.getIdSPCT())) {
                hoaDonCT = hdct;
            }
        }
        hoaDonCT.setsLg(Integer.parseInt(sl));
        _IHoaDonService.updateHDCT(hoaDonCT);
        loadTableHDCT(idHD_CT);
    }//GEN-LAST:event_btnSuaHDCT1ActionPerformed

    private void btnLamMoiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLamMoiActionPerformed
        // TODO add your handling code here:
        txtIdHD.setText("");
        txtMaHD.setText("");
        cbbIdKhachHang.setSelectedIndex(0);
        cbbIdNhanVien.setSelectedIndex(0);
        txtNgayTao.setText("");
        clcNgayGui.setDate(new Date());
        clcNgayNhan.setDate(new Date());
        cbbTinhTrang.setSelectedIndex(0);
        txtPhanTramGiam.setText("");
        txtTongTien.setText("");
        txtTienKhachDua.setText("");
        txtTienThua.setText("");
    }//GEN-LAST:event_btnLamMoiActionPerformed

    private void cbbNamDoanhSoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbbNamDoanhSoActionPerformed
        // TODO add your handling code here:
        if(cbbNamDoanhSo.getSelectedIndex()>=0){
            int year = Integer.valueOf(cbbNamDoanhSo.getSelectedItem().toString());
            loadCBBThangDS(year);
        }
    }//GEN-LAST:event_cbbNamDoanhSoActionPerformed

    private void cbbNgayDoanhSoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbbNgayDoanhSoActionPerformed
        // TODO add your handling code here:
        if(cbbNgayDoanhSo.getSelectedIndex()>=0){
            showDataDoanhSo1();
        }
    }//GEN-LAST:event_cbbNgayDoanhSoActionPerformed

    private void cbbThangDoanhSoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbbThangDoanhSoActionPerformed
        // TODO add your handling code here:
        if(cbbThangDoanhSo.getSelectedIndex()>=0){
            int month = Integer.valueOf(cbbThangDoanhSo.getSelectedItem().toString());
            int year = Integer.valueOf(cbbNamDoanhSo.getSelectedItem().toString());
        loadCBBNgayDS(month, year);
        }
    }//GEN-LAST:event_cbbThangDoanhSoActionPerformed

    private void cbbNamDoanhThuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbbNamDoanhThuActionPerformed
        // TODO add your handling code here:
        int nam;
        if(cbbNamDoanhThu.getSelectedIndex()>=0){
            loadCBBDoanhThuNam();
            nam = Integer.parseInt(cbbNamDoanhThu.getSelectedItem().toString());
            loadTableDoanhThuNam(nam);
        }
    }//GEN-LAST:event_cbbNamDoanhThuActionPerformed

    private void tbNamDoanhThuMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbNamDoanhThuMouseClicked
        // TODO add your handling code here:
        int slRow = tbNamDoanhThu.getSelectedRow();
        String thangStr = tbNamDoanhThu.getValueAt(slRow, 0).toString();
        int thang = Integer.parseInt(thangStr);
        List<Object[]> dsDTThang = _IDoanhSoService.findDoanhThuThang(thang);
        DefaultTableModel model = (DefaultTableModel) tbThangDoanhThu.getModel();
        double total= 0;
        model.setRowCount(0);
        for (Object[] x : dsDTThang) {
            total+= Float.parseFloat(x[1]+"");
            model.addRow(new Object[]{x[0], x[1]});
        }
        lbDoanhThuThang.setText(new DecimalFormat("0.####").format(total)+" VND");
    }//GEN-LAST:event_tbNamDoanhThuMouseClicked

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        int row = tbHoaDon.getSelectedRow();
        inHoaDon(row);
        
    }//GEN-LAST:event_jButton1ActionPerformed

    //set mau menu
    private void setColorPnMenu(JPanel panel) {
        //panel.setBackground(java.awt.Color);
     //   panel.setBackground(java.awt.Color(54,33,89));
        panel.setBackground(new java.awt.Color(54,33,89));
    }

    private void resetColorPnMenu(JPanel panel) {
       // panel.setBackground(new Color(64, 33, 100));
       panel.setBackground(new java.awt.Color(64, 33, 100));
     //  panel.setBackground(java.awt.Color.red);
    }

    private HoaDon getHoaDonFromInput() {
        String ma = txtMaHD.getText().trim();
        String makh = cbbIdKhachHang.getSelectedItem().toString();
        String manv = cbbIdNhanVien.getSelectedItem().toString();
        Date ngayTao = new Date();
        Date ngayGuiTemp = clcNgayGui.getDate();
        Date ngayNhanTemp = clcNgayNhan.getDate();
        Date ngayGui = null;
        Date ngayNhan = null;
        try {
            ngayGui = dfm.parse(dfm.format(ngayGuiTemp));
            ngayNhan = dfm.parse(dfm.format(ngayNhanTemp));
        } catch (ParseException ex) {
            ex.printStackTrace();
        }
        String tt = cbbTinhTrang.getSelectedItem().toString();
        TrangThaiHD trangThai = tt.equals(TrangThaiHD.Chờ_Thanh_Toán.toString()) ? TrangThaiHD.Chờ_Thanh_Toán : (tt.equals(TrangThaiHD.Đã_Hủy) ? TrangThaiHD.Đã_Hủy : TrangThaiHD.Chờ_Thanh_Toán);
        String phanTramStr = txtPhanTramGiam.getText().trim();
        if(phanTramStr.length()==0) phanTramStr = "0";
        float phanTramGiam = Float.parseFloat(phanTramStr);
        NhanVien nv = null;
        KhachHang kh = null;
        for (KhachHang khachHang : dsKH) {
            if (makh.equals(khachHang.getMa())) {
                kh = khachHang;
            }
        }
        for (NhanVien nhanVien : dsNV) {
            if (manv.equals(nhanVien.getMa())) {
                nv = nhanVien;
            }
        }
        return new HoaDon(ma, ngayTao, new Date(), ngayGui, ngayNhan, trangThai, phanTramGiam, kh, nv);
    }

    private HDCT getHDCTFromInput() {
        String idhd = txtIdHD.getText().trim();
        if (idhd.length() == 0) {
            JOptionPane.showMessageDialog(this, "Bạn chưa chọn hóa đơn nào");
            return null;
        }
        String idsp = txtIdGiay_BH.getText().trim();
        if (idsp.length() == 0) {
            JOptionPane.showMessageDialog(this, "Bạn chưa chọn sản phẩm nào");
            return null;
        }
        int sl = (int) spnSl_BH.getValue();
        float giaBan = Float.parseFloat(txtGiaBan_BH.getText().trim());
        HoaDon hoaDon = null;
        SPCT sanPhamCT = null;
        for (HoaDon hd : dsHoaDon) {
            if (idhd.equals(hd.getId())) {
                hoaDon = hd;
            }
        }
        for (SPCT spct : dsGiay) {
            if (idsp.equals(spct.getId())) {
                sanPhamCT = spct;
            }
        }
        return new HDCT(idhd, idSP_CT, sl, BigDecimal.valueOf(giaBan));
    }

    //===============================Xem doanh số=================================
    private IDoanhSoService _IDoanhSoService;
    
    private void loadCBBNamDS(){
        List<Object> dsNam = _IDoanhSoService.findAllNam();
        cbbNamDoanhSo.removeAllItems();
        for (Object date : dsNam) {
            cbbNamDoanhSo.addItem(date.toString());
        }
    }
    private void loadCBBThangDS(int year){
        List<Object> dsThang = _IDoanhSoService.findAllThang(year);
        cbbThangDoanhSo.removeAllItems();
        for (Object date : dsThang) {
            cbbThangDoanhSo.addItem(date.toString());
        }
    }
    private void loadCBBNgayDS(int month, int year){
        List<Object> dsNgay = _IDoanhSoService.findAllNgay(month, year);
        cbbNgayDoanhSo.removeAllItems();
        for (Object date : dsNgay) {
            cbbNgayDoanhSo.addItem(date.toString());
        }
    }

    private void showDataDoanhSo1(){
        pieChart1.setChartType(PieChart.PeiChartType.DONUT_CHART);
        int nam = 0;
        nam = Integer.parseInt(cbbNamDoanhSo.getSelectedItem()+"");
        int thang = 0;
        thang = Integer.parseInt(cbbThangDoanhSo.getSelectedItem()+"");
        int ngay = 0;
        ngay = Integer.parseInt(cbbNgayDoanhSo.getSelectedItem()+"");
        
        List<Object[]> dsHDCTDS = new ArrayList<>();
                dsHDCTDS =_IDoanhSoService.findAll(nam, thang, ngay);
        if(dsHDCTDS.isEmpty()) return;
        pieChart1.clearData();
        for (int j = 0; j < dsHDCTDS.size(); j++) {
            //System.out.println(dsHDCTDS.get(j)[0]+", "+dsHDCTDS.get(j)[1]+"-----------------");
            pieChart1.addData(new ModelPieChart(dsHDCTDS.get(j)[0].toString(),  Double.parseDouble(dsHDCTDS.get(j)[1]+""), Double.parseDouble(dsHDCTDS.get(j)[2]+""), new java.awt.Color(j, ThreadLocalRandom.current().nextInt(j,225), ThreadLocalRandom.current().nextInt(j, 200))));
        }
    }
    
    
    
    //Doanh thu
    private void loadCBBDoanhThuNam(){
        List<Object> dsNam = _IDoanhSoService.findAllNam();
        cbbNamDoanhThu.removeAllItems();
        for (Object object : dsNam) {
            cbbNamDoanhThu.addItem(object.toString());
        }
    }

    private void loadTableDoanhThuNam(int nam){
        List<Object[]> dsDTNam = _IDoanhSoService.findDoanhThuNam(nam);
        DefaultTableModel modelDTNam = (DefaultTableModel) tbNamDoanhThu.getModel();
        double total = 0;
        modelDTNam.setRowCount(0);
        for (Object[] x : dsDTNam) {
            total+= Float.parseFloat(x[1]+"");
            modelDTNam.addRow(new Object[]{x[0], x[1]});
        }
        lbDoanhThuNam.setText(new DecimalFormat("0.####").format(total)+" VND");
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
            java.util.logging.Logger.getLogger(BanHang.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(BanHang.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(BanHang.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(BanHang.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new BanHang().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTabbedPane JTabPn;
    private javax.swing.JLabel Jlabel;
    private javax.swing.JButton btnHuyHD;
    private javax.swing.JButton btnLamMoi;
    private javax.swing.JButton btnQRCode;
    private javax.swing.JButton btnSuaHD;
    private javax.swing.JButton btnSuaHDCT;
    private javax.swing.JButton btnSuaHDCT1;
    private javax.swing.JButton btnTaoHD;
    private javax.swing.JButton btnThanhToan;
    private javax.swing.JButton btnThemGioHangTemp;
    private javax.swing.JButton btnXoaHDCT;
    private javax.swing.JButton btnXoaHDCT1;
    private javax.swing.JComboBox<String> cbbIdKhachHang;
    private javax.swing.JComboBox<String> cbbIdNhanVien;
    private javax.swing.JComboBox<String> cbbNamDoanhSo;
    private javax.swing.JComboBox<String> cbbNamDoanhThu;
    private javax.swing.JComboBox<String> cbbNgayDoanhSo;
    private javax.swing.JComboBox<String> cbbThangDoanhSo;
    private javax.swing.JComboBox<String> cbbTinhTrang;
    private com.toedter.calendar.JDateChooser clcNgayGui;
    private com.toedter.calendar.JDateChooser clcNgayNhan;
    private javax.swing.JLabel d;
    private javax.swing.JLabel dd;
    private javax.swing.JLabel ddd;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel39;
    private javax.swing.JLabel jLabel40;
    private javax.swing.JLabel jLabel42;
    private javax.swing.JLabel jLabel46;
    private javax.swing.JLabel jLabel47;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JScrollPane jScrollPane8;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JLabel lbAnhGiay_BH;
    private javax.swing.JLabel lbDoanhThuNam;
    private javax.swing.JLabel lbDoanhThuThang;
    private javax.swing.JLabel lbDsGiayLui;
    private javax.swing.JLabel lbDsGiayTien;
    private javax.swing.JLabel lbGiaBanBH0;
    private javax.swing.JLabel lbGiaBanBH1;
    private javax.swing.JLabel lbGiaBanBH2;
    private javax.swing.JLabel lbGiaBanBH3;
    private javax.swing.JLabel lbGiay0;
    private javax.swing.JLabel lbGiay1;
    private javax.swing.JLabel lbGiay2;
    private javax.swing.JLabel lbGiay3;
    private javax.swing.JLabel lbLogo;
    private javax.swing.JLabel lbSoLuongBH0;
    private javax.swing.JLabel lbSoLuongBH1;
    private javax.swing.JLabel lbSoLuongBH2;
    private javax.swing.JLabel lbSoLuongBH3;
    private javax.swing.JLabel lbTitle;
    private Piechart.PieChart pieChart1;
    private javax.swing.JPanel pnBanHang;
    private javax.swing.JPanel pnBanHangView;
    private javax.swing.JPanel pnDoanhSo;
    private javax.swing.JPanel pnDoanhSoView;
    private javax.swing.JPanel pnDsGiay1;
    private javax.swing.JPanel pnDsGiay3;
    private javax.swing.JPanel pnDsGiay4;
    private javax.swing.JLabel r;
    private javax.swing.JLabel rr;
    private javax.swing.JLabel rrr;
    private javax.swing.JPanel sidePane;
    private javax.swing.JSpinner spnSl_BH;
    private javax.swing.JTabbedPane tabpalBanHang;
    private javax.swing.JTable tbHDCT0;
    private javax.swing.JTable tbHDCT1;
    private javax.swing.JTable tbHoaDon;
    private javax.swing.JTable tbNamDoanhThu;
    private javax.swing.JTable tbThangDoanhThu;
    private javax.swing.JTextField txtGiaBan_BH;
    private javax.swing.JTextField txtIdGiay_BH;
    private javax.swing.JTextField txtIdHD;
    private javax.swing.JTextField txtMaHD;
    private javax.swing.JTextArea txtMoTa_BH;
    private javax.swing.JTextField txtNamBH_BH;
    private javax.swing.JTextField txtNgayTao;
    private javax.swing.JTextField txtPhanTramGiam;
    private javax.swing.JTextField txtTenSP_BH;
    private javax.swing.JTextField txtTienKhachDua;
    private javax.swing.JTextField txtTienThua;
    private javax.swing.JTextField txtTongTien;
    // End of variables declaration//GEN-END:variables

}
