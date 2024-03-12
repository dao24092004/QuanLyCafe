package com.cafe.entity;

import java.io.Serializable;
import java.util.Objects;

public class HoaDonChiTietId implements Serializable{
	private int id_hoa_don;
    private int id_hang_hoa;

    // Default constructor (required for Hibernate)
    public HoaDonChiTietId() {
    }

    public HoaDonChiTietId(int id_hoa_don, int id_hang_hoa) {
        this.id_hoa_don = id_hoa_don;
        this.id_hang_hoa = id_hang_hoa;
    }

    // Override equals and hashCode (required for composite key)
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        HoaDonChiTietId that = (HoaDonChiTietId) o;
        return id_hoa_don == that.id_hoa_don &&
                id_hang_hoa == that.id_hang_hoa;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id_hoa_don, id_hang_hoa);
    }

}
