/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package domain_model;

import Enum.TrangThaiKhuyenMai;
import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.Column;
import javax.persistence.ConstraintMode;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.mapping.Constraint;

/**
 *
 * @author PhiLT
 */
@Entity
@Table(name = "KhuyenMaiGiay")
@IdClass(KhuyenMaiGiayId.class)
@Data
@NoArgsConstructor
@AllArgsConstructor
public class KhuyenMaiGiay implements Serializable {

    @Id
    @Column(name = "IdGiayCT")
    private int idGiayCT;

    @Id
    @Column(name = "IdKhuyenMai")
    private int idKhuyenMai;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("IdGiayCT")
    @JoinColumn(name = "IdGiayCT", nullable = false, foreignKey = @ForeignKey(ConstraintMode.NO_CONSTRAINT), referencedColumnName = "id")
    private GiayCT giayCT;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("IdKhuyenMai")
    @JoinColumn(name = "IdKhuyenMai", nullable = false, foreignKey = @ForeignKey(ConstraintMode.NO_CONSTRAINT), referencedColumnName = "id")
    private KhuyenMai km;

    @Column(name = "GiaBan")
    private BigDecimal giaban;
    @Column(name = "GiaKhuyenMai")
    private BigDecimal giaKM;
    @Column(name = "TrangThai")
    private TrangThaiKhuyenMai trangThai;
}
