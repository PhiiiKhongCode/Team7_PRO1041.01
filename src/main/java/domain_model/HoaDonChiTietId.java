/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package domain_model;

import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 *
 * @author PhiLT
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class HoaDonChiTietId implements Serializable{
    private int idGiayCT;
    private int idHoaDon;
}
