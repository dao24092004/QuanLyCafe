package com.cafe.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;


import com.cafe.entity.PhanQuyen;

public class ImplPhanQuyenDAO implements IPhanQuyenDAO {
	private SessionFactory sf;
	public ImplPhanQuyenDAO() {
		sf = HibernateUtils.getSessionFactory();
	}

	@Override
	public PhanQuyen selectByid(int id) {
		Session ss = sf.openSession();
		PhanQuyen pq = null;
		try {
			ss.beginTransaction();//Mở Phiên 
			
			pq = ss.get(PhanQuyen.class, id);
			ss.getTransaction().commit();
		} catch (Exception e) {
			System.out.println("Lỗi"+ e.getMessage());
			ss.getTransaction().rollback();
		}finally {
			ss.close();
		}

		return pq;
	}

	@Override
	public List<PhanQuyen> selectAll() {
		Session ss = sf.openSession();
		List<PhanQuyen> lst =  new ArrayList<PhanQuyen>();
		try {
			//Mở phiên làm việc
			ss.beginTransaction();
			lst = ss.createQuery("from PhanQuyen order by id").list();
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
