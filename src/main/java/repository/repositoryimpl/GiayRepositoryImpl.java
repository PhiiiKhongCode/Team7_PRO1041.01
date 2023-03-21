/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repository.repositoryimpl;

import domain_model.GiayCT;
import java.util.List;
import javax.persistence.Query;
import org.hibernate.Session;
import repository.GiayRepository;
import util.HibernateUtil;

/**
 *
 * @author PhiLT
 */
public class GiayRepositoryImpl implements GiayRepository{

    @Override
    public List<GiayCT> getAllGiay() {
        Session session = HibernateUtil.getFACTORY().openSession();
        String hql = "from GiayCT";
        Query q = session.createQuery(hql);
        List<GiayCT> list = q.getResultList();
        for (GiayCT giayCT : list) {
            System.out.println(giayCT.getTenSP());
        }
        return list;   
}
}
