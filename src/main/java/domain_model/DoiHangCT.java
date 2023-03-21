/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package domain_model;

import Enum.TrangThaiGiayDoi;
import java.io.Serializable;
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
@Table(name = "DoiHangCT")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class DoiHangCT implements Serializable{
    
    @Id
    @GenericGenerator(name = "generator", strategy = "increment", parameters = {})
    @GeneratedValue(generator = "generator")
    @Column(name= "Id")
    private int id;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "IdHDCT", nullable = false)
    private HoaDonChiTiet hdct;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "IdGiay", nullable = false)
    private GiayCT giayCT;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="IdDon", nullable = false)
    private DonDoiHang donDoiHang;
    
    @Column(name = "SoLuong")
    private int soLuong;
            
    @Column(name="TrangThaiGiay")
    private TrangThaiGiayDoi trangThai;
    
    @Column(name = "LyDoDoiTra")
    private String lyDo;
    
    @Column(name = "MoTa")
    private String moTa;
}
