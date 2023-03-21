/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package domain_model;

import Enum.TrangThaiKhuyenMai;
import java.io.Serializable;
import java.util.Date;
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
@Table(name = "KhuyenMai")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class KhuyenMai implements Serializable{
    @Id
    @GenericGenerator(name = "generator", strategy = "guid", parameters = {})
    @GeneratedValue(generator = "generator")
    @Column(name = "IdKhuyenMai")
    private int id;
    
    @Column(name= "MaKhuyenMai")
    private String ma;
    
    @Column(name= "TenKhuyenMai")
    private String ten;
    @Column(name= "NgayBatDau")
    private Date ngayBatDau;
    @Column(name= "NgayKetThuc")
    private Date ngayKetThuc;
    @Column(name= "PhanTramGiam")
    private float phanTramGiam;
    @Column(name= "DieuKien")
    private String dieuKien;
    @Column(name= "TrangThai")
    private TrangThaiKhuyenMai trangThai;
}
