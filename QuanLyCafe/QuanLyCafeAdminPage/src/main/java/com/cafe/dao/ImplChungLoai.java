package com.cafe.dao;



import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;


import com.cafe.entity.ChungLoai;

public class ImplChungLoai implements IChungLoaiDAO {
	private SessionFactory sf;
	public ImplChungLoai() {
		sf = HibernateUtils.getSessionFactory();
	}
	@Override
	public ChungLoai selectByid(int id) {
		Session ss = sf.openSession();
		ChungLoai obj = null;
		try {
			//Mở phiên làm việc
			ss.beginTransaction();
			obj = ss.get(ChungLoai.class,id);
			ss.getTransaction().commit();
			
		} catch (Exception e) {
			System.out.println("Lỗi "+e.getMessage());
			ss.getTransaction().rollback();
		}finally {
			
		}
		return obj;
	}
	@Override
	public List<ChungLoai> selectAll() {
		Session ss = sf.openSession();
		List<ChungLoai> lst =  new ArrayList<ChungLoai>();
		try {
			//Mở phiên làm việc
			ss.beginTransaction();
			lst = ss.createQuery("from ChungLoai order by id").list();
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
