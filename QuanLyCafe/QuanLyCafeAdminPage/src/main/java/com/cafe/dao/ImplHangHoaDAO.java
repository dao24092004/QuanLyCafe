package com.cafe.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import com.cafe.entity.HangHoa;

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

			lst = ss.createQuery("from  HangHoa order by id").list();

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

			hh = (HangHoa) ss.createQuery("from HangHoa where id = :mahh").setParameter("mahh", id).getSingleResult();

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
			lst = ss.createQuery("from HangHoa WHERE LOWER(ten_hang_hoa) LIKE:search order by id")
					.setParameter("search", "%" + search.toLowerCase() + "%").list();

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
	public List<Object[]> thongKeTheoNgayThang(int ngay, int thang, int nam) {
		Session session = null;

		try {
			session = sf.openSession();
			String queryString = "SELECT hh.ten_hang_hoa, SUM(hdct.so_luong), SUM(hdct.gia * hdct.so_luong)"
					+ " FROM HoaDonChiTiet hdct" + " INNER JOIN HangHoa hh ON hdct.id_hang_hoa = hh.id"
					+ " INNER JOIN HoaDon hd ON hdct.id_hoa_don = hd.id"
					+ " WHERE DAY(hd.ngay_tao) = :ngay AND MONTH(hd.ngay_tao) = :thang AND YEAR(hd.ngay_tao) = :nam"
					+ " GROUP BY hh.ten_hang_hoa";

			Query<Object[]> query = session.createQuery(queryString);
			query.setParameter("ngay", ngay);
			query.setParameter("thang", thang);
			query.setParameter("nam", nam);

			return query.list();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		} finally {
			if (session != null) {
				session.close();
			}
		}
	}
	@Override
	public HangHoa selectByName(String ten_hang_hoa) {
		Session ss = sf.openSession();// Mở kết nối với database
		HangHoa hh = null;
		try {
			// Mở phiên làm việc
			ss.beginTransaction();
			// Thực hiện lệnh/ giao dịch

			hh = (HangHoa) ss.createQuery("from HangHoa where ten_hang_hoa = :tenhh").setParameter("tenhh", ten_hang_hoa).getSingleResult();

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

}
