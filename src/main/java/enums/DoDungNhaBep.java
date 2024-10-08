package enums;

public enum DoDungNhaBep {
    MAY_SAY_CHEN("Máy sấy chén"),
    MAY_XAY_MAY_EP("Máy xay, máy ép"),
    LO_VI_SONG("Lò vi sóng");
    private final String value;

    DoDungNhaBep(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
