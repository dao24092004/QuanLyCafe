package com.cafe.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import com.cafe.entity.NhanVien;

public class ImplNhanVienDAO implements INhanVienDAO {
	private SessionFactory sf;

	public ImplNhanVienDAO() {
		sf = HibernateUtils.getSessionFactory();
	}

	@Override
	public List<NhanVien> selectAll() {
		Session ss = sf.openSession();// Mở kết nối với db
		List<NhanVien> lst = new ArrayList<NhanVien>();
		try {
			// Mở phiên làm việc
			ss.beginTransaction();
			// Thực hiện lệnh /giao dịch
			lst = ss.createNamedQuery("SELECT_ALL_NV").list();
			// Thực hiện xác nhận thay đổi csdl
			ss.getTransaction().commit();

		} catch (Exception e) {
			System.out.println("Lỗi" + e.getMessage());
			ss.getTransaction().rollback();// Hoàn tác lệnh
		} finally {
			ss.close();
		}
		return lst;
	}

	@Override
	public NhanVien selectByid(int id) {
		Session ss = sf.openSession();// Mở kết nối với db
		NhanVien nv = null;
		try {
			// Mở phiên làm việc
			ss.beginTransaction();
			// Thực hiện lệnh/ giao dịch

			nv = (NhanVien) ss.createQuery("from NhanVien where id = :manv")
					.setParameter("manv", id).getSingleResult();

			// Xác nhận giao dịch/thay đổi csdl
			ss.getTransaction().commit();

		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Lỗi" + e.getMessage());
			ss.getTransaction().rollback();// Hoàn tác lệnh
		} finally {
			if (nv != null) {
				ss.close();
			}

		}
		return nv;
	}

//
//	@Override
//	public boolean insert(NhanVien nv) {
//		Session ss = sf.openSession();// Mở kết nối với db
//		boolean isOk = false;
//		try {
//			// Mở phiên làm việc
//			ss.beginTransaction();
//			// Thực hiện lệnh /giao dịch
//			ss.save(nv);
//			// Thực hiện xác nhận thay đổi csdl
//			ss.getTransaction().commit();
//			isOk = true;
//
//		} catch (Exception e) {
//			System.out.println("Lỗi" + e.getMessage());
//			ss.getTransaction().rollback();// Hoàn tác lệnh
//		} finally {
//			ss.close();
//		}
//		return isOk;
//	}
//
	@Override
	public boolean update(NhanVien nv) {
		Session ss = sf.openSession();// Mở kết nối với db
		boolean isOk = false;
		try {
			// Mở phiên làm việc
			ss.beginTransaction();
			// Thực hiện lệnh /giao dịch
			ss.update(nv);
			// Thực hiện xác nhận thay đổi csdl
			ss.getTransaction().commit();
			isOk = true;

		} catch (Exception e) {
			System.out.println("Lỗi" + e.getMessage());

			ss.getTransaction().rollback();// Hoàn tác lệnh
		} finally {
			ss.close();
		}
		return isOk;
	}

	@Override
	public boolean isUsernameAndPasswordValid(String username, String passwords) {
		 Session session = sf.openSession();
		    boolean isLoginValid = false;
		    try {
		        session.beginTransaction();
		        
		        // Thực hiện truy vấn để kiểm tra  tên người dùng và mật khẩu
		        Query query = session.createQuery("SELECT COUNT(*) FROM NhanVien WHERE username = :username AND passwords = :passwords");
		        query.setParameter("username", username);
		        query.setParameter("passwords", passwords);
		        Long count = (Long) query.uniqueResult();
		        
		        session.getTransaction().commit();
		        
		        if (count > 0) {
		            isLoginValid = true;
		        }
		    } catch (Exception e) {
		        System.out.println("Lỗi: " + e.getMessage());
		        session.getTransaction().rollback();
		    } finally {
		        session.close();
		    }
		    return isLoginValid;
	}

	@Override
	public NhanVien selectByName(String username) {
		Session ss = sf.openSession();// Mở kết nối với db
		NhanVien user = null;
		try {
			// Mở phiên làm việc
			ss.beginTransaction();
			// Thực hiện lệnh/ giao dịch

			user = (NhanVien) ss.createQuery("from NhanVien where username = :usernamenv").setParameter("usernamenv",username ).getSingleResult();

			// Xác nhận giao dịch/thay đổi csdl
			ss.getTransaction().commit();

		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Lỗi" + e.getMessage());
			ss.getTransaction().rollback();// Hoàn tác lệnh
		} finally {
			ss.close();

		}
		return user;
	}

}
