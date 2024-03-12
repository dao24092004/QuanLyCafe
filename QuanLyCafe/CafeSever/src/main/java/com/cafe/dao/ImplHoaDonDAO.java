package com.cafe.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import com.cafe.entity.HoaDon;
import com.cafe.entity.NhaCungCap;

public class ImplHoaDonDAO implements IHoaDonDAO {
	private SessionFactory sf;

	public ImplHoaDonDAO() {
		sf = HibernateUtils.getSessionFactory();
	}

	@Override
	public boolean insert(HoaDon hd) {
		Session ss = sf.openSession();// Mở kết nối với database
		boolean isOk = false;
		try {

			System.out.println(hd.toString());

			// Mở phiên làm việc
			ss.beginTransaction();
			// Thực hiện lệnh/ giao dịch
			ss.save(hd);
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
	public int getByNameAndPhone(String name, String phone) {
		Session ss = sf.openSession();// Mở kết nối với database
		int id = -1; // Khởi tạo giá trị mặc định
		try {
			// Mở phiên làm việc
			ss.beginTransaction();
			// Thực hiện lệnh/ giao dịch
			// Sử dụng SELECT để lấy id khách hàng
			Object result = ss.createQuery("SELECT id FROM KhachHang WHERE ten = :name AND dien_thoai = :phone")
					.setParameter("name", name).setParameter("phone", phone).uniqueResult();

			if (result != null) {
				id = (int) result;
			}

			// Xác nhận giao dịch/thay đổi csdl
			ss.getTransaction().commit();
		} catch (Exception e) {
			System.out.println("Lỗi: " + e.getMessage());
			ss.getTransaction().rollback();// Hoàn tác lệnh
		} finally {
			ss.close();
		}
		return id;
	}

	@Override
	public HoaDon selectByid(int id) {
		Session ss = sf.openSession();// Mở kết nối với database
		HoaDon hd = null; // Khởi tạo giá trị mặc định
		try {
			// Mở phiên làm việc
			ss.beginTransaction();
			// Thực hiện lệnh/ giao dịch
			hd = (HoaDon) ss.createQuery("from HoaDon where id = :mahd").setParameter("mahd", id).getSingleResult();

			// Xác nhận giao dịch/thay đổi csdl
			ss.getTransaction().commit();
		} catch (Exception e) {
			System.out.println("Lỗi: " + e.getMessage());
			ss.getTransaction().rollback();// Hoàn tác lệnh
		} finally {
			ss.close();
		}
		return hd;
	}

}
