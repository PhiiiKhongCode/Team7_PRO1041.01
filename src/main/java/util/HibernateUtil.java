/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package util;



import domain_model.DeGiay;
import domain_model.DoiHangCT;
import domain_model.DonDoiHang;
import domain_model.GiayCT;
import domain_model.HoaDon;
import domain_model.HoaDonChiTiet;
import domain_model.HoaDonChiTietId;
import domain_model.KhachHang;
import domain_model.KhuyenMai;
import domain_model.KhuyenMaiGiay;
import domain_model.KieuDang;
import domain_model.LoaiGiay;
import domain_model.MauSac;
import domain_model.NhanHieu;
import domain_model.NhanVien;
import domain_model.Size;
import java.util.Properties;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;
import org.hibernate.service.ServiceRegistry;

/**
 *
 * @author PhiLT
 */
public class HibernateUtil {
    private static final SessionFactory FACTORY;
    static{
        Configuration conf = new Configuration();
        
        Properties properties = new Properties();
        properties.put(Environment.DIALECT, "org.hibernate.dialect.SQLServerDialect");
        properties.put(Environment.DRIVER, "com.microsoft.sqlserver.jdbc.SQLServerDriver");
        properties.put(Environment.URL, "jdbc:sqlserver://localhost:1433;"
                + "databaseName=nhom_7_ban_giay;encrypt=true;trustServerCertificate=true;");
        properties.put(Environment.USER, "sa");
        properties.put(Environment.PASS, "123");
        properties.put(Environment.SHOW_SQL, "true");
        
        conf.setProperties(properties);
        conf.addAnnotatedClass(DeGiay.class);
       // conf.addAnnotatedClass(DoiHangCT.class);
        //conf.addAnnotatedClass(DonDoiHang.class);
        conf.addAnnotatedClass(GiayCT.class);
        //conf.addAnnotatedClass(HoaDon.class);
        //conf.addAnnotatedClass(HoaDonChiTiet.class);
        //conf.addAnnotatedClass(HoaDonChiTietId.class);
        conf.addAnnotatedClass(KhachHang.class);
        conf.addAnnotatedClass(KhuyenMai.class);
        conf.addAnnotatedClass(KhuyenMaiGiay.class);
        //conf.addAnnotatedClass(KhuyenMaiGiayId.class);
        conf.addAnnotatedClass(KieuDang.class);
        conf.addAnnotatedClass(LoaiGiay.class);
        conf.addAnnotatedClass(MauSac.class);
        conf.addAnnotatedClass(NhanHieu.class);
        conf.addAnnotatedClass(NhanVien.class);
        conf.addAnnotatedClass(Size.class);
        
        ServiceRegistry registry = new StandardServiceRegistryBuilder()
                .applySettings(conf.getProperties()).build();
        FACTORY = conf.buildSessionFactory((org.hibernate.service.ServiceRegistry) registry);
    }
    
    public static SessionFactory getFACTORY(){
        return FACTORY;
    }
    public static void main(String[] args) {
        System.out.println(FACTORY);
    }
}
