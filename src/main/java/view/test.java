/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view;

import domain_model.GiayCT;
import java.util.List;
import repository.GiayRepository;
import repository.repositoryimpl.GiayRepositoryImpl;

/**
 *
 * @author PhiLT
 */
public class test {
    public static void main(String[] args) {
        GiayRepository giay = new GiayRepositoryImpl();
      List<GiayCT> list =  giay.getAllGiay();
        for (GiayCT giayCT : list) {
            System.out.println(giayCT.getTenSP());
        }
    }
}
