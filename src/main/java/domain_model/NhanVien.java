/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package domain_model;

import Enum.TrangThaiNhanVien;
import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
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
@Table(name="NhanVien")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class NhanVien implements Serializable{
    
    @Id
    @GenericGenerator(name= "generator", strategy = "increment", parameters = {})
    @GeneratedValue(generator = "generator")
    @Column(name= "IdNhanVien")
    private int id;
    
    @Column(name="MaNhanVien")
    private String ma;
    
    @Column(name="HoVaTenNhanVien")
    private String hoTen;
    
    @Column(name="GioiTinh")
    private boolean gioiTinh;
    
    @Column(name="DiaChi")
    private String diaChi;
    
    @Column(name="SDT")
    private String sdt;
    
    @Column(name="Email")
    private String email;
    
    @Column(name="cccd")
    private String cccd;
    
    @Column(name="TenTaiKhoan")
    private String tenTaiKhoan;
    
    @Column(name="MatKhau")
    private String matKhau;
    
    @Column(name="ChucVu")
    private int chucVu;
    
    @Column(name= "TrangThai")
    private TrangThaiNhanVien trangThai;
    
    @Column(name="GhiChu")
    private String ghiChu;
}
