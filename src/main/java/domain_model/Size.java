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
@Table(name= "Size")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Size implements Serializable{
    
    @Id
    @GenericGenerator(name= "generator", strategy= "guid", parameters = {})
    @GeneratedValue(generator = "generator")
    @Column(name= "IdSize")
    private int id;
    
    @Column(name= "MaSize")
    private String ma;
    
    @Column(name= "Size")
    private float size;
    
    @Column(name= "TrangThai")
    private TrangThaiDanhMuc trangThai;
}
