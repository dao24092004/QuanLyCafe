package com.cafe.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.cafe.entity.ChungLoai;
import com.cafe.entity.DonViTinh;

public class ImplDonViTinhDAO implements IDonViTinhDAO {
	private SessionFactory sf;
	public ImplDonViTinhDAO() {
		sf = HibernateUtils.getSessionFactory();
	}

	@Override
	public DonViTinh selectByid(int id) {
		Session ss = sf.openSession();
		DonViTinh dv = null;
		try {
			ss.beginTransaction();//Mở Phiên 
			
			dv = ss.get(DonViTinh.class, id);
			ss.getTransaction().commit();
		} catch (Exception e) {
			System.out.println("Lỗi"+ e.getMessage());
			ss.getTransaction().rollback();
		}finally {
			ss.close();
		}

		return dv;
	}

	@Override
	public List<DonViTinh> selectAll() {
		Session ss = sf.openSession();
		List<DonViTinh> lst =  new ArrayList<DonViTinh>();
		try {
			//Mở phiên làm việc
			ss.beginTransaction();
			lst = ss.createQuery("from DonViTinh order by id").list();
			ss.getTransaction().commit();
			
		} catch (Exception e) {
			 System.out.println("Lỗi "+e.getMessage());
			ss.getTransaction().rollback();
		}finally {
			ss.close();
		}
		return lst;
		
	}

}
