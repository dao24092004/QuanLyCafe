package com.cafe.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import com.cafe.entity.HangHoa;
import com.cafe.entity.HoaDonChiTiet;
import com.cafe.entity.NhanVien;
import com.cafe.entity.TempCart;


public class ImplHoaDonChiTietDAO implements IHoaDonChiTietDAO {
	private SessionFactory sf;

	public ImplHoaDonChiTietDAO() {
		sf = HibernateUtils.getSessionFactory();
	}
	@Override
	public void insert(HoaDonChiTiet hdct) {
		Session ss = sf.openSession();// Mở kết nối với database
		
		try {
			// Mở phiên làm việc
			ss.beginTransaction();
			// Thực hiện lệnh/ giao dịch
			
	                ss.save(hdct);
			 
			// Xác nhận giao dịch/thay đổi csdl
			ss.getTransaction().commit();
			

		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Lỗi" + e.getMessage());
			ss.getTransaction().rollback();// Hoàn tác lệnh
			
		} finally {
			ss.close();

		}

	}
	@Override
	public List<HoaDonChiTiet> selectAll() {
		Session ss = sf.openSession();// Mở kết nối với db
		List<HoaDonChiTiet> lst = new ArrayList<HoaDonChiTiet>();
		try {
			// Mở phiên làm việc
			ss.beginTransaction();
			// Thực hiện lệnh /giao dịch
			lst = ss.createNamedQuery("SELECT_ALL_KH").list();
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
}
