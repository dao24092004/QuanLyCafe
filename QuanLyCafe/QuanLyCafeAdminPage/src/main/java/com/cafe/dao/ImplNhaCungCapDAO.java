package com.cafe.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.cafe.entity.NhaCungCap;

public class ImplNhaCungCapDAO implements INhaCungCapDAO {
	private SessionFactory sf;

	public ImplNhaCungCapDAO() {
		sf = HibernateUtils.getSessionFactory();
	}

	@Override
	public List<NhaCungCap> selectAll() {
		Session ss = sf.openSession();// Mở kết nối với database
		List<NhaCungCap> lst = new ArrayList<NhaCungCap>();
		try {
			// Mở phiên làm việc
			ss.beginTransaction();
			// Thực hiện lệnh/ giao dịch

			lst = ss.createQuery("from  NhaCungCap order by id").list();

			// Xác nhận giao dịch/thay đổi csdl
			ss.getTransaction().commit();

		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Lỗi" + e.getMessage());
			ss.getTransaction().rollback();// Hoàn tác lệnh
		} finally {
			ss.close();

		}

		return lst;
	}

	@Override
	public NhaCungCap selectByid(int id) {
		Session ss = sf.openSession();// Mở kết nối với database
		NhaCungCap ncc = null;
		try {
			// Mở phiên làm việc
			ss.beginTransaction();
			// Thực hiện lệnh/ giao dịch

			ncc = (NhaCungCap)ss.createQuery("from NhaCungCap where id = :mancc").setParameter("mancc", id).getSingleResult();

			// Xác nhận giao dịch/thay đổi csdl
			ss.getTransaction().commit();

		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Lỗi" + e.getMessage());
			ss.getTransaction().rollback();// Hoàn tác lệnh
		} finally {
			ss.close();

		}
		return ncc;
	}

	@Override
	public boolean insert(NhaCungCap ncc) {
		Session ss = sf.openSession();// Mở kết nối với database
		boolean isOk = false;
		try {
			
			System.out.println(ncc.toString());
			
			// Mở phiên làm việc
			ss.beginTransaction();
			// Thực hiện lệnh/ giao dịch
			ss.save(ncc);
			// Xác nhận giao dịch/thay đổi csdl
			ss.getTransaction().commit();
			isOk = true;

		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Lỗi 111" + e.getMessage());
			ss.getTransaction().rollback();// Hoàn tác lệnh
		} finally {
			ss.close();

		}
		return isOk;
		
	}

	@Override
	public boolean update(NhaCungCap ncc,String meseger) {
		Session ss = sf.openSession();// Mở kết nối với database
		boolean isOk = false;
		try {
			// Mở phiên làm việc
			ss.beginTransaction();
			// Thực hiện lệnh/ giao dịch

			ss.update(ncc);
			// Xác nhận giao dịch/thay đổi csdl
			ss.getTransaction().commit();
			isOk = true;

		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Lỗi" + e.getMessage());
			meseger = e.getMessage();
			ss.getTransaction().rollback();// Hoàn tác lệnh
		} finally {
			ss.close();

		}
		return isOk;
	}

	@Override
	public boolean delete(int id) {
		Session ss = sf.openSession();// Mở kết nối với database
		boolean isOk = false;
		try {
			// Mở phiên làm việc
			ss.beginTransaction();
			NhaCungCap ncc = ss.get(NhaCungCap.class, id);
			// Thực hiện lệnh/ giao dịch
			ss.delete(ncc);
			
			// Xác nhận giao dịch/thay đổi csdl
			ss.getTransaction().commit();
			isOk = true;

		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Lỗi" + e.getMessage());
			ss.getTransaction().rollback();// Hoàn tác lệnh
		} finally {
			ss.close();

		}
		return isOk;
	}

	
	

}
