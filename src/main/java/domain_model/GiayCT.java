/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package domain_model;

import Enum.TrangThaiGiay;
import java.io.Serializable;
import java.math.BigDecimal;
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
@Table(name= "GiayCT")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class GiayCT implements Serializable{
    
    @Id
    @GenericGenerator(name="generator", strategy="increment", parameters = {})
    @GeneratedValue(generator = "generator")
    @Column(name= "IdGiayCT")
    private int id;
    
    @Column(name= "MaGiayCT")
    private String ma;
    
    @Column(name= "TenGiay")
    private String tenSP;
    
    @Column(name= "GiaNhap")
    private BigDecimal giaNhap;
    
    @Column(name= "GiaBan")
    private BigDecimal giaBan;
    
    @Column(name= "SoLuongTon")
    private int soLuongTon;
    
    @Column(name= "Anh")
    private String anh;
    
    @Column(name= "MoTa")
    private String moTa;
    
    @Column(name= "TrangThai")
    private TrangThaiGiay trangThai;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name= "IdLoaiGiay", nullable = false)
    private LoaiGiay loaiGiay;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name= "IdMau", nullable = false)
    private MauSac mauSac;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name= "IdSize", nullable = false)
    private Size size;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name= "IdNhanHieu", nullable = false)
    private NhanHieu nhanHieu;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="IdKieuDang", nullable = false)
    private KieuDang kieuDang;
    
    @ManyToOne( fetch = FetchType.LAZY)
    @JoinColumn(name= "IdDeGiay", nullable = false)
    private DeGiay deGiay;
}
