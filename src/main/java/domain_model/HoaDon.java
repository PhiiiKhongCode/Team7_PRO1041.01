/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package domain_model;

import Enum.TrangThaiHoaDon;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

/**
 *
 * @author PhiLT
 */
@Entity
@Table(name = "HoaDon")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class HoaDon implements Serializable {
    
    @Id
    @GenericGenerator(name = "generator", strategy = "guid", parameters = {})
    @GeneratedValue(generator = "generator")
    @Column(name = "Id")
    private String id;
    
    @Column(name= "MaHoaDon")
    private String ma;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name= "IdNhanVien", nullable = false)
    private NhanVien nhanVien;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name= "IdKhachHang")
    private KhachHang khachHang;
    
    @Column(name= "TenKhachHang")
    private String tenKhach;
    
    @Column(name= "NgayTao")
    private Date ngayTao;
    @Column(name= "TongTien")
    private BigDecimal tongTien;
    @Column(name= "NgayThanhToan")
    private Date ngayThanhToan;
    @Column(name= "TrangThai")
    private TrangThaiHoaDon trangThai;
    @Column(name= "GhiChu")
    private String ghiChu;
    @Column(name= "NgayShip")
    private Date ngayShip;
    @Column(name= "TienShip")
    private BigDecimal tienShip;
    @Column(name= "TienCoc")
    private BigDecimal tienCoc;
    @Column(name= "NgayNhan")
    private Date ngayNhan;
    @Column(name= "DiaChi")
    private String diaChi;
    @Column(name= "TenNguoiShip")
    private String tenShipper;
    @Column(name= "CCCDNguoiShip")
    private String CCCDShipper;
    @Column(name= "SDTNguoiShip")
    private String sdtShipper;
    @Column(name= "SDTNguoiNhan")
    private String sdtNguoiNhan;
}
