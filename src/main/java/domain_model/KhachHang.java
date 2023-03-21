/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package domain_model;

import Enum.TrangThaiNhanVien;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

/**
 *
 * @author PhiLT
 */
@Entity
@Table(name= "KhachHang")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class KhachHang implements Serializable{
    
    @Id
    @GenericGenerator(name= "generator", strategy = "increment", parameters = {})
    @GeneratedValue(generator = "generator")
    @Column(name= "IdKhachHang")
    private int id;
    
    @Column(name="MaKhachHang")
    private String ma;
    
    @Column(name="Hoten")
    private String hoTen;
    
    @Column(name="GioiTinh")
    private boolean gioiTinh;
    
    @Column(name="NgaySinh")
    private Date ngaySinh;
    
    @Column(name="DiaChi")
    private String diaChi;
    
    @Column(name="SDT")
    private String sdt;
    
    @Column(name="Emai")
    private String email;
    
    @Column(name="TrangThai")
    private TrangThaiNhanVien trangThai;
    
    @Column(name="GhiChu")
    private String ghiChu;
}
