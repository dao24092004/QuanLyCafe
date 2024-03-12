package com.cafe.api;

import java.time.LocalDate;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;


import com.cafe.dao.IHangHoaDAO;
import com.cafe.dao.IHoaDonChiTietDAO;
import com.cafe.dao.IHoaDonDAO;
import com.cafe.dao.ITempCartDAO;
import com.cafe.dao.ImplHangHoaDAO;
import com.cafe.dao.ImplHoaDonChiTietDAO;
import com.cafe.dao.ImplHoaDonDAO;
import com.cafe.dao.ImplTempCartDAO;
import com.cafe.entity.HangHoa;
import com.cafe.entity.HoaDon;
import com.cafe.entity.HoaDonChiTiet;
import com.cafe.entity.KhachHang;
import com.cafe.entity.MessageBox;
import com.cafe.entity.NhanVien;
import com.cafe.entity.TempCart;
import com.cafe.entity.ThanhToan;
import com.google.gson.Gson;
import com.google.gson.JsonElement;

@Path("/hoa-don")
public class HoaDonAPI {
	@Path("/init-pay")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public String initPay() {
		HoaDon hd = new HoaDon();
		System.out.println(hd.toString());
		Gson gson = new Gson();
		
		String json = gson.toJson(hd);
		return json;

	}

	@Path("/pay")
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	public String pay(String hdJson) {
		IHoaDonDAO hdDAO = new ImplHoaDonDAO();
		Gson gson = new Gson();
		HoaDon hd = gson.fromJson(hdJson, HoaDon.class);

		int id = hdDAO.getByNameAndPhone(hd.getHdkhachhang().getTen(), hd.getHdkhachhang().getDien_thoai());
		if (id > 0) {
			hd.setId_khach_hang(id);
			hd.setId_nhan_vien(hd.getNhanvien().getId());
			hd.setSdt_nhan(hd.getHdkhachhang().getDien_thoai());
			hd.setNgay_tao(hd.getNgay_tao());
			hd.setTrang_thai((short) 1);
		}

		// Xử lý và insert vào bảng hóa đơn
		boolean isOk = hdDAO.insert(hd);

		if (isOk) {
			System.out.println("Thanh toán thành công");
			ITempCartDAO tempDAO = new ImplTempCartDAO();
			List<TempCart> lstTemp = tempDAO.selectAll();
			IHoaDonChiTietDAO hdctDAO = new ImplHoaDonChiTietDAO();
			IHangHoaDAO hhDAO = new ImplHangHoaDAO();
		

			for (TempCart tempCart : lstTemp) {
				HoaDonChiTiet hdct = new HoaDonChiTiet();
				hdct.setId_hang_hoa(tempCart.getHanghoa().getId());
				hdct.setGia(tempCart.getGia());
				hdct.setSo_luong(1);
				hdct.setId_hoa_don(hd.getId());
				hdctDAO.insert(hdct);
				HangHoa hh = new HangHoa();
				hh = hhDAO.selectByid(hdct.getId_hang_hoa());
				float new_so_luong = hh.getSo_luong() - hdct.getSo_luong();
				hh.setSo_luong(new_so_luong);
				boolean isOK = hhDAO.update(hh);
				if (isOK) {
					System.out.println("Cập nhật số lượng hàng hóa thành công");
				} else {
					System.out.println("Cập nhật số lượng hàng hóa thất bại");
				}

			}
			tempDAO.deleteAll();

			HoaDon hdn = hdDAO.selectByid(hd.getId());
			hdn.setHdkhachhang(hd.getHdkhachhang());
			hdn.setNhanvien(hd.getNhanvien());
			return gson.toJson(hdn);
		} else {
			System.out.println("Thanh toán thất bại");
			return null;
		}

	}

}
