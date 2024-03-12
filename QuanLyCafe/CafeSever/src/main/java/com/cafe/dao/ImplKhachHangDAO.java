package com.cafe.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import com.cafe.entity.KhachHang;


public class ImplKhachHangDAO implements IKhachHangDAO {
	private SessionFactory sf;
	 public ImplKhachHangDAO() {
		 sf = HibernateUtils.getSessionFactory();
	 }
	 
	@Override
	public List<KhachHang> selectAll() {
		Session ss = sf.openSession();//Mở kết nối với db
		List<KhachHang> lst = new ArrayList<KhachHang>();
		try {
			//Mở phiên làm việc
			ss.beginTransaction();
			//Thực hiện lệnh /giao dịch
			lst = ss.createNamedQuery("SELECT_ALL_KH_API").list();	
			System.out.println("danh sách khách hang"+ lst);
			//Thực hiện xác nhận thay đổi csdl
			ss.getTransaction().commit();
			
		} catch (Exception e) {
			System.out.println("Lỗi" +e.getMessage());
			ss.getTransaction().rollback();//Hoàn tác lệnh
		}finally {
			ss.close();
		}
		return lst;
	}

//	@Override
//	public KhachHang selectByid(int id) {
//		Session ss = sf.openSession();// Mở kết nối với db
//		KhachHang kh = null;
//		try {
//			// Mở phiên làm việc
//			ss.beginTransaction();
//			// Thực hiện lệnh/ giao dịch
//
//			kh = (KhachHang) ss.createQuery("from KhachHang where id = :makh").setParameter("makh", id).getSingleResult();
//
//			// Xác nhận giao dịch/thay đổi csdl
//			ss.getTransaction().commit();
//
//		} catch (Exception e) {
//			// TODO: handle exception
//			
//			
//			System.out.println("Lỗi" + e.getMessage());
//			ss.getTransaction().rollback();// Hoàn tác lệnh
//		} finally {
//			ss.close();
//
//		}
//		return kh;
//	}
//
//	@Override
//	public boolean insert(KhachHang kh) {
//		Session ss = sf.openSession();//Mở kết nối với db
//		boolean isOk = false;
//		try {
//			//Mở phiên làm việc
//			ss.beginTransaction();
//			//Thực hiện lệnh /giao dịch
//			ss.save(kh);
//			//Thực hiện xác nhận thay đổi csdl
//			ss.getTransaction().commit();
//			isOk=true;
//		} catch (Exception e) {
//			System.out.println("Lỗi" +e.getMessage());
//			ss.getTransaction().rollback();//Hoàn tác lệnh
//		}finally {
//			ss.close();
//		}
//		return isOk;
//	}
	@Override
	public KhachHang searchCustomer(String phoneNumberOrEmail) {
	    Session session = sf.openSession();
	    KhachHang customer = null;

	    try {
	        session.beginTransaction();

	        String hql = "FROM KhachHang WHERE dien_thoai = :search OR email = :search";

	        Query query = session.createQuery(hql);
	        query.setParameter("search", phoneNumberOrEmail);

	        customer = (KhachHang) query.uniqueResult();

	        session.getTransaction().commit();
	    } catch (Exception e) {
	        System.out.println("Lỗi: " + e.getMessage());
	        session.getTransaction().rollback();
	    } finally {
	        session.close();
	    }

	    return customer;
	}


}
