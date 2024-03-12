package com.cafe.controller;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.hibernate.validator.constraints.pl.REGON;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.cafe.dao.IChungLoaiDAO;
import com.cafe.dao.IDonViTinhDAO;
import com.cafe.dao.IHangHoaDAO;
import com.cafe.dao.INhaCungCapDAO;
import com.cafe.dao.INhanVienDAO;
import com.cafe.dao.ImplChungLoai;
import com.cafe.dao.ImplDonViTinhDAO;
import com.cafe.dao.ImplHangHoaDAO;
import com.cafe.dao.ImplNhaCungCapDAO;
import com.cafe.dao.ImplNhanVienDAO;
import com.cafe.entity.ChungLoai;
import com.cafe.entity.DonViTinh;
import com.cafe.entity.HangHoa;
import com.cafe.entity.NhaCungCap;
import com.cafe.entity.NhanVien;
import com.cafe.entity.ThongKe;

@Controller
@RequestMapping("/admin/hang-hoa")
public class ControllerHangHoa extends CheckRole {

	@RequestMapping(value = { "", "/" })
	public String index(Model m, HttpSession session, HttpServletRequest request, HttpServletResponse response)
			throws IOException {

		check(session, request, response);
		IHangHoaDAO hhDAO = new ImplHangHoaDAO();
		List<HangHoa> lst = hhDAO.selectAll();
		HangHoa hh = new HangHoa();
		hh.setNgay_cap_nhat(LocalDate.now());
		hh.setNgay_tao(LocalDate.now());
		m.addAttribute("lst", lst);
		return "hang-hoa/index";

	}

	private void initData(Model m) {
		IChungLoaiDAO clDAO = new ImplChungLoai();
		List<ChungLoai> lstcl = clDAO.selectAll();
		IDonViTinhDAO dvDAO = new ImplDonViTinhDAO();
		List<DonViTinh> lstdv = dvDAO.selectAll();
		INhaCungCapDAO nccDAO = new ImplNhaCungCapDAO();
		List<NhaCungCap> lstncc = nccDAO.selectAll();
		m.addAttribute("lstcl", lstcl);
		m.addAttribute("lstdv", lstdv);
		m.addAttribute("lstncc", lstncc);
	}

	@RequestMapping(value = "/init-form", method = RequestMethod.GET)
	public String initForm(Model m) {

		HangHoa hh = new HangHoa();

		hh.setNgay_tao(LocalDate.now());
		initData(m);
		m.addAttribute("hh", hh);

		return "hang-hoa/init-form";
	}

	@RequestMapping(value = "/insert", method = RequestMethod.POST)
	public String insertForm(@Valid @ModelAttribute(value = "hh") HangHoa hhoa, BindingResult result, Model m) {

		hhoa.setNgay_tao(LocalDate.now());

		ImplHangHoaDAO hhDAO = new ImplHangHoaDAO();
		boolean isOk = hhDAO.insert(hhoa);
		if (isOk == false) {
			System.out.println("lỗi");
			m.addAttribute("hh", hhoa);
			initData(m);
			return "hang-hoa/init-form";
		} else {
			m.addAttribute("msg", "Thêm mới thành công");
			System.out.println("thanh cong");
			m.addAttribute("hh", hhoa);
			initData(m);
			return "hang-hoa/view-form";
		}
	}

	@RequestMapping(value = "/init-update/{id}", method = RequestMethod.GET)
	public String initUpdate(@PathVariable(value = "id", required = true) int id, Model m) {
		IHangHoaDAO hhDAO = new ImplHangHoaDAO();
		
		HangHoa hh = hhDAO.selectByid(id);
		hh.setNgay_cap_nhat(LocalDate.now());
		m.addAttribute("hh", hh);
		initData(m);
		return "hang-hoa/update";

	}

	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public String upDate(@Valid @ModelAttribute("hh") HangHoa hh, BindingResult result, Model m) {
		IHangHoaDAO hhDAO = new ImplHangHoaDAO();
		initData(m);

		hh.setNgay_cap_nhat(LocalDate.now());

		boolean isOk = hhDAO.update(hh);
		if (isOk) {
			m.addAttribute("msg", "Cập nhật thành công!!!");
		} else {
			m.addAttribute("msg", "Cập nhật thất bại!!!");
		}
		return "hang-hoa/update";
	}

	@RequestMapping(value = "delete/{id}", method = RequestMethod.GET)
	public String delete(@PathVariable(value = "id", required = true) int id, Model m) {

		IHangHoaDAO hhDAO = new ImplHangHoaDAO();
		initData(m);
		boolean isOk = hhDAO.delete(id);
		if (isOk) {
			m.addAttribute("msg", "Xóa thành công!!!");
		} else {
			m.addAttribute("msg", "Xóa thất bại!!!");
		}
		List<HangHoa> lst = hhDAO.selectAll();
		m.addAttribute("lst", lst);

		return "hang-hoa/index";
	}

	@RequestMapping(value = "search", method = RequestMethod.GET)
	public String search(@RequestParam(name = "txtSearch") String search, Model m) {
		IHangHoaDAO hhDAO = new ImplHangHoaDAO();
		List<HangHoa> lst = hhDAO.search(search);
		m.addAttribute("lst", lst);
		initData(m);
		return "hang-hoa/index";
	}
	  @RequestMapping(value = "/thong-ke", method = RequestMethod.POST)
	    public String thongKe(@RequestParam("ngay") int ngay,
	                          @RequestParam("thang") int thang,
	                          @RequestParam("nam") int nam, Model m) {
		  IHangHoaDAO hhDAO = new ImplHangHoaDAO();
	        List<Object[]> result = hhDAO.thongKeTheoNgayThang(ngay, thang, nam);
	        List<ThongKe> thongKeList = new ArrayList<>();
	        float tong_tien = 0;
            for (Object[] item : result) {
            	
                String tenHangHoa = (String) item[0];
                float soLuong = Float.parseFloat(item[1].toString());
                float so_tien = Float.parseFloat(item[2].toString());
                HangHoa hh = hhDAO.selectByName(tenHangHoa);
                float doanhThu = so_tien - (hh.getGia_nhap()*soLuong);
                tong_tien = tong_tien + doanhThu;
                ThongKe thongKe = new ThongKe();
                thongKe.setTen_hang_hoa(tenHangHoa);
                thongKe.setSo_luong(soLuong);
                thongKe.setDoanh_thu(doanhThu);
                System.out.println("tien"+ thongKe.getDoanh_thu());

                thongKeList.add(thongKe);
            }
            m.addAttribute("tongtien", tong_tien);
            System.out.println("tong tien" + tong_tien);
            m.addAttribute("lst", thongKeList);
	        System.out.println("thông kê" + thongKeList);
	        return "hang-hoa/thong-ke";
	    }
}
