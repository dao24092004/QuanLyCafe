package com.cafe.api;

import com.cafe.dao.INhanVienDAO;
import com.cafe.dao.ImplNhanVienDAO;
import com.cafe.entity.NhanVien;

import javax.servlet.http.HttpSession;
import javax.ws.rs.FormParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/login")
public class LoginAPI {
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public void login(@FormParam("username") String username,
                      @FormParam("passwords") String passwords, HttpSession session) {

        INhanVienDAO nvdao = new ImplNhanVienDAO();
        boolean isOk = nvdao.isUsernameAndPasswordValid(username, passwords);

        if (isOk) {
            NhanVien user = nvdao.selectByName(username);
            session.setAttribute("username", username);
            session.setAttribute("passwords", passwords);
            session.setAttribute("tennv", user.getHo_va_ten());
        }
    }
}
