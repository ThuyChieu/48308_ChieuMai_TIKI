package enums;

public enum LeftMenu {
    NHA_SACH_TIKI("Nhà Sách Tiki"),
    THE_THAO_DA_NGOAI("Thể Thao - Dã Ngoại"),
    DIEN_GIA_DUNG("Điện Gia Dụng");
    private final String value;

    LeftMenu(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
