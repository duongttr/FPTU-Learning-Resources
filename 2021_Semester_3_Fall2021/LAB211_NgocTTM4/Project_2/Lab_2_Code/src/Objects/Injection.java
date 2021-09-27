package Objects;

import java.util.Date;

public class Injection {

    private String id;
    private int firstInjectionPlace;
    private Date  firstInjectionDate;
    private int secondInjectionPlace;
    private Date secondInjectionDate;
    private String studentID;
    private int vaccineID;

    public static String[] PROVICES = new String[]{
        "AN GIANG",
        "BẠC LIÊU",
        "BẮC CẠN",
        "BẮC GIANG",
        "BẮC NINH",
        "BẾN TRE",
        "BÌNH DƯƠNG",
        "BÌNH ĐỊNH",
        "BÌNH PHƯỚC",
        "BÌNH THUẬN",
        "CÀ MAU",
        "CAO BẰNG",
        "CẦN THƠ",
        "ĐÀ NẴNG",
        "DAKLAK",
        "ĐỒNG NAI",
        "ĐỒNG THÁP",
        "GIA LAI",
        "HÀ GIANG",
        "HÀ NAM",
        "HÀ NỘI",
        "HÀ TĨNH",
        "HẢI DƯƠNG",
        "HẢI PHÒNG",
        "HÒA BÌNH",
        "HỒ CHÍ MINH",
        "HƯNG YÊN",
        "KHÁNH HÒA",
        "KIÊN GIANG",
        "KON TUM",
        "LAI CHÂU",
        "LẠNG SƠN",
        "LÀO CAI",
        "LÂM ĐỒNG",
        "LONG AN",
        "NAM ĐỊNH",
        "NGHỆ AN",
        "NINH BÌNH",
        "NINH THUẬN",
        "PHÚ THỌ",
        "PHÚ YÊN",
        "QUẢNG BÌNH",
        "QUẢNG NAM",
        "QUẢNG NGÃI",
        "QUẢNG NINH",
        "SÓC TRĂNG",
        "SƠN LA",
        "TÂY NINH",
        "THÁI BÌNH",
        "THÁI NGUYÊN",
        "THANH HÓA",
        "THỪA THIÊN HUẾ",
        "TIỀN GIANG",
        "TRÀ VINH",
        "TUYÊN QUANG",
        "VĨNH LONG",
        "VĨNH PHÚC",
        "YÊN BÁI"
    };

    public Injection() {
    }

    

    public String getId() {
        return id;
    }

    public int getFirstInjectionPlace() {
        return firstInjectionPlace;
    }

    public void setFirstInjectionPlace(int firstInjectionPlace) {
        this.firstInjectionPlace = firstInjectionPlace;
    }

    public Date getFirstInjectionDate() {
        return firstInjectionDate;
    }

    public void setFirstInjectionDate(Date firstInjectionDate) {
        this.firstInjectionDate = firstInjectionDate;
    }

    public int getSecondInjectionPlace() {
        return secondInjectionPlace;
    }

    public void setSecondInjectionPlace(int secondInjectionPlace) {
        this.secondInjectionPlace = secondInjectionPlace;
    }

    public Date getSecondInjectionDate() {
        return secondInjectionDate;
    }

    public void setSecondInjectionDate(Date secondInjectionDate) {
        this.secondInjectionDate = secondInjectionDate;
    }

    public String getStudentID() {
        return studentID;
    }

    public void setStudentID(String studentID) {
        this.studentID = studentID;
    }

    public int getVaccineID() {
        return vaccineID;
    }

    public void setVaccineID(int vaccineID) {
        this.vaccineID = vaccineID;
    }

    
}
