package com.cafe.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import com.cafe.entity.HangHoa;
import com.cafe.entity.TempCart;


public class ImplTempCartDAO implements ITempCartDAO {
	private SessionFactory sf;

	public ImplTempCartDAO() {
		sf = HibernateUtils.getSessionFactory();
	}

	@Override
	public List<TempCart> selectAll() {
		Session ss = sf.openSession();// Mở kết nối với database
		List<TempCart> lst = new ArrayList<TempCart>();
		try {
			// Mở phiên làm việc
			ss.beginTransaction();
			// Thực hiện lệnh/ giao dịch

			lst = ss.createNamedQuery("SELECT_ALL_TMPC").list();

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
	public void deleteAll() {
	    Session ss = sf.openSession(); // Open a connection to the database
	    try {
	        // Begin a transaction
	        ss.beginTransaction();

	        // Delete all records from the TempCart table
	        Query query = ss.createQuery("DELETE FROM TempCart");
	        query.executeUpdate();

	        // Commit the transaction to apply changes to the database
	        ss.getTransaction().commit();
	    } catch (Exception e) {
	        // Handle exceptions
	        System.out.println("Error: " + e.getMessage());
	        ss.getTransaction().rollback(); // Rollback the transaction in case of an error
	    } finally {
	        ss.close(); // Close the session
	    }
	}



	@Override
	public boolean insert(List<TempCart> tempCart) {
		Session ss = sf.openSession();// Mở kết nối với database
		boolean isOk = false;
		try {
			// Mở phiên làm việc
			ss.beginTransaction();
			// Thực hiện lệnh/ giao dịch
			 for (TempCart item : tempCart) {
	                ss.save(item);
			 }
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
			TempCart temp = ss.get(TempCart.class, id);
			// Thực hiện lệnh/ giao dịch

			ss.delete(temp);

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


}
