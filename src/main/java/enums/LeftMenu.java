package enums;

public enum LeftMenu {
    DIEN_GIA_DUNG("Điện Gia Dụng");
    private final String value;

    LeftMenu(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
