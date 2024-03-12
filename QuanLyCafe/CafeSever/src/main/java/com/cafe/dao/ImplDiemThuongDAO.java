package com.cafe.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import com.cafe.entity.DiemThuong;
import com.cafe.entity.KhachHang;
import com.cafe.entity.NhanVien;


public class ImplDiemThuongDAO implements IDiemThuongDAO {
	private SessionFactory sf;
	 public ImplDiemThuongDAO() {
		 sf = HibernateUtils.getSessionFactory();
	 }
	 @Override
		public List<DiemThuong> selectAll() {
			Session ss = sf.openSession();// Mở kết nối với db
			List<DiemThuong> lst = new ArrayList<DiemThuong>();
			try {
				// Mở phiên làm việc
				ss.beginTransaction();
				// Thực hiện lệnh /giao dịch
				lst = ss.createNamedQuery("SELECT_ALL_DT").list();
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
	public DiemThuong selectByid(int id_khach_hang) {
		Session ss = sf.openSession();// Mở kết nối với db
		DiemThuong dt = null;
		try {
			// Mở phiên làm việc
			ss.beginTransaction();
			// Thực hiện lệnh/ giao dịch

			dt = (DiemThuong) ss.createQuery("from DiemThuong where id_khach_hang = :makh")
					.setParameter("makh", id_khach_hang).getSingleResult();

			// Xác nhận giao dịch/thay đổi csdl
			ss.getTransaction().commit();

		} catch (Exception e) {
			// TODO: handle exception
			
			
			System.out.println("Lỗi" + e.getMessage());
			ss.getTransaction().rollback();// Hoàn tác lệnh
		} finally {
			ss.close();

		}
		return dt;
	}



	


}
