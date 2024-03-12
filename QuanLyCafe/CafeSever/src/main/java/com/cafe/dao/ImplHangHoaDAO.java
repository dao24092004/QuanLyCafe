package com.cafe.dao;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.cafe.entity.HangHoa;
import com.cafe.entity.TempCart;



public class ImplHangHoaDAO implements IHangHoaDAO {
	private SessionFactory sf;

	public ImplHangHoaDAO() {
		sf = HibernateUtils.getSessionFactory();
	}

	@Override
	public List<HangHoa> selectAll() {
		Session ss = sf.openSession();// Mở kết nối với database
		List<HangHoa> lst = new ArrayList<HangHoa>();
		try {
			// Mở phiên làm việc
			ss.beginTransaction();
			// Thực hiện lệnh/ giao dịch

			lst = ss.createNamedQuery("SELECT_ALL_HH").list();

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
	public HangHoa selectByid(int id) {
		Session ss = sf.openSession();// Mở kết nối với database
		HangHoa hh = null;
		try {
			// Mở phiên làm việc
			ss.beginTransaction();
			// Thực hiện lệnh/ giao dịch

			hh = (HangHoa) ss.createQuery("from HangHoa where id = :mahh").
					setParameter("mahh", id).getSingleResult();
			System.out.println("Câu truy vấn SQL: " + "from HangHoa where id = :mahh");
			System.out.println("có vào đây không");
			// Xác nhận giao dịch/thay đổi csdl
			ss.getTransaction().commit();

		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Lỗi" + e.getMessage());
			ss.getTransaction().rollback();// Hoàn tác lệnh
		} finally {
			ss.close();

		}
		return hh;
	}

	@Override
	public boolean update(HangHoa hh) {
		Session ss = sf.openSession();// Mở kết nối với database
		boolean isOk = false;
		try {
			// Mở phiên làm việc
			ss.beginTransaction();
			// Thực hiện lệnh/ giao dịch

			ss.update(hh);

			// Xác nhận giao dịch/thay đổi csdl
			ss.getTransaction().commit();
			isOk = true;

		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Lỗi" + e.getMessage());
			ss.getTransaction().rollback();// Hoàn tác lệnh
			isOk = false;
		} finally {
			ss.close();

		}

		return isOk;
	}

	@Override
	public boolean insert(HangHoa hh) {
		Session ss = sf.openSession();// Mở kết nối với database
		boolean isOk = false;
		try {
			// Mở phiên làm việc
			ss.beginTransaction();
			// Thực hiện lệnh/ giao dịch
			ss.save(hh);

			// Xác nhận giao dịch/thay đổi csdl
			ss.getTransaction().commit();
			isOk = true;

		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Lỗi" + e.getMessage());
			ss.getTransaction().rollback();// Hoàn tác lệnh
			isOk = false;
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
			HangHoa hh = ss.get(HangHoa.class, id);
			// Thực hiện lệnh/ giao dịch

			ss.delete(hh);

			// Xác nhận giao dịch/thay đổi csdl
			ss.getTransaction().commit();
			isOk = true;

		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Lỗi" + e.getMessage());
			ss.getTransaction().rollback();// Hoàn tác lệnh
			isOk = false;
		} finally {
			ss.close();

		}

		return isOk;
	}

	@Override
	public List<HangHoa> search(String search) {
		Session ss = sf.openSession();// Mở kết nối với db
		List<HangHoa> lst = new ArrayList<HangHoa>();
		try {
			// Mở phiên làm việc
			ss.beginTransaction();
			// Thực hiện lệnh /giao dịch
			lst = ss.createQuery("from HangHoa WHERE ten_hang_hoa LIKE:search order by id")
					.setParameter("search", "%" + search + "%").list();

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
