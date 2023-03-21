/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package domain_model;

import Enum.TrangThaiDanhMuc;
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
@Table(name= "KieuDang")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class KieuDang implements Serializable{
    
    @Id
    @GenericGenerator(name= "generator", strategy="guid", parameters = {})
    @GeneratedValue(generator = "generator")
    @Column(name= "IdKieuDang")
    private int id;
    
    @Column(name= "MaKieuDang")
    private String ma;
    
    @Column(name= "TenKieuDang")
    private String ten;
    
    @Column(name= "TrangThai")
    private TrangThaiDanhMuc trangThai;
}
