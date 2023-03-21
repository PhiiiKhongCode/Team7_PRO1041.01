/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package domain_model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
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
@Table(name = "DonDoiHang")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class DonDoiHang implements Serializable {

    @Id
    @GenericGenerator(name = "generator", strategy = "increment", parameters = {})
    @GeneratedValue(generator = "generator")
    @Column(name = "IdDon")
    private int id;

    @Column(name = "NgayDoi")
    private Date ngayDoi;

    @Column(name = "NgayMua")
    private Date ngayMua;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @Column(name = "IdNhanVien", nullable = false)
    private NhanVien nhanVien;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @Column(name = "IdHoaDon", nullable = false)
    private HoaDon hoaDon;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @Column(name = "IdKhachHang", nullable = false)
    private KhachHang khachHang;
}
