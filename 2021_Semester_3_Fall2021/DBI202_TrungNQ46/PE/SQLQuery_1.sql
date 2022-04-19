CREATE DATABASE CLUB;
GO
USE CLUB;

----- 1 -----
CREATE TABLE DOIBONG(
    MaDoi VARCHAR(2) PRIMARY KEY,
    TenDoi VARCHAR(100),
    NamTL INT
)
GO


CREATE TABLE CAUTHU(
    MaCauThu VARCHAR(2) PRIMARY KEY,
    TenCauThu VARCHAR(50),
    Phai BIT,
    NgaySinh DATETIME,
    NoiSinh VARCHAR(50)
)
GO


CREATE TABLE THAMGIA(
    MaDoi VARCHAR(2) NOT NULL,
    MaCT VARCHAR(2) NOT NULL,
    BatDau DATETIME,
    KetThuc DATETIME,

    FOREIGN KEY (MaDoi) REFERENCES DOIBONG(MaDoi),
    FOREIGN KEY (MaCT) REFERENCES CAUTHU(MaCauThu),
    PRIMARY KEY(MaDoi, MaCT)
)
GO

CREATE TABLE THIDAU(
    MaTran VARCHAR(20) NOT NULL,
    MaDoi VARCHAR(2) NOT NULL,
    NgayThiDau DATETIME,
    HieuSo INT,
    KetQua BIT,

    FOREIGN KEY (MaDoi) REFERENCES DOIBONG(MaDoi),
    PRIMARY KEY(MaTran, MaDoi)
)
GO

CREATE TABLE PENELTY(
    MaPhat VARCHAR(2) PRIMARY KEY,
    MaCT VARCHAR(2),
    MaTran VARCHAR(20),
    SoLanPhat INT,
    TienPhat NUMERIC,
    LoaiThe VARCHAR(1),
    NgayPhat DATETIME
)
GO

----- 2 -----
ALTER TABLE CAUTHU
ADD CONSTRAINT chk_Tuoi
    CHECK ((YEAR(GETDATE()) - YEAR(NgaySinh)) BETWEEN 17 AND 40)
GO

ALTER TABLE THAMGIA
ADD CONSTRAINT chk_NgayBD_NgayKT
    CHECK (BatDau < KetThuc)
GO

ALTER TRIGGER chk_ThamGia ON THAMGIA
FOR INSERT
AS
BEGIN
    DECLARE @MaCT varchar(2);
    DECLARE @BatDauThamGia DATETIME;
    SELECT @MaCT = MaCT, @BatDauThamGia = BatDau
    FROM inserted
    IF
        (SELECT COUNT(MaCT)
        FROM THAMGIA
        WHERE (KetThuc > @BatDauThamGia OR KetThuc) IS NULL AND MaCT = @MaCT) = 0
        BEGIN
                RAISERROR('Mot cau thu chi tham gia mot doi bong ', 10, 16)
                ROLLBACK
        END
    ELSE
        BEGIN
            --INSERT INTO THAMGIA SELECT * FROM inserted
            PRINT('Thanh cong')
        END
    END
GO


----- 3 -----
SELECT ct.TenCauThu, ct.NgaySinh, ct.NoiSinh FROM PENELTY p
JOIN CAUTHU ct ON p.MaCT = ct.MaCauThu
WHERE YEAR(p.NgayPhat) = 2020 AND p.LoaiThe = 'D'

SELECT ct.TenCauThu, ct.NgaySinh, ct.NoiSinh FROM PENELTY p
FULL JOIN CAUTHU ct ON p.MaCT = ct.MaCauThu WHERE p.LoaiThe != 'D';

SELECT ct.MaCauThu, ct.TenCauThu, SUM(p.TienPhat) as SoTienPhat FROM PENELTY p
JOIN CAUTHU ct ON ct.MaCauThu = p.MaCT
GROUP BY ct.MaCauThu, ct.TenCauThu HAVING SUM(p.TienPhat) >
(SELECT ISNULL(SUM(TienPhat), 0) FROM PENELTY WHERE MaCT = '01')
