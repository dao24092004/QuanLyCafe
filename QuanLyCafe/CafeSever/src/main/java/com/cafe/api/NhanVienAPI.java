package com.cafe.api;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;


import com.cafe.dao.INhanVienDAO;
import com.cafe.dao.ImplNhanVienDAO;
import com.cafe.entity.MessageBox;
import com.cafe.entity.NhanVien;
import com.google.gson.Gson;

@Path("/nhan-vien")
public class NhanVienAPI {

    @Path("")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String index() {
        INhanVienDAO nvDAO = new ImplNhanVienDAO();
        List<NhanVien> lst = nvDAO.selectAll();
        Gson gson = new Gson();
        String json = gson.toJson(lst);
        return json;
    }

    @Path("/init-update/{id}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String initUpdate(@PathParam("id") int id) {
        INhanVienDAO nvDAO = new ImplNhanVienDAO();
        NhanVien nv = nvDAO.selectByid(id);
        System.out.println("Nhân viên: " + nv);
        Gson gson = new Gson();
        String json = gson.toJson(nv);
        return json;
    }
    
    @Path("/update")
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public String update(String nvJson) {
        INhanVienDAO nvDAO = new ImplNhanVienDAO();
        NhanVien nv = new Gson().fromJson(nvJson, NhanVien.class);
        boolean isOK = nvDAO.update(nv);

        // Trả về kết quả cập nhật
        MessageBox msg = new MessageBox();
        if (isOK) {
        	msg = new MessageBox(101, "Thêm mới nhân viên THÀNH CÔNG");
        } else {
        	msg = new MessageBox(101, "Thêm mới nhân viên THẤT BẠI!!!");
        }

        Gson gson = new Gson();
    
        String json = gson.toJson(msg);
        return json;
    }
}
