------------- 1 -------------
CREATE FUNCTION StudenID_Func1
(
    @mavt NVARCHAR(5)
)
RETURNS INT
AS
BEGIN
    RETURN (SELECT SUM(cthd.SL * cthd.GiaBan) FROM CHITIETHOADON cthd
            JOIN VATTU vt ON cthd.MaVT = vt.MaVT
            WHERE cthd.MaVT = @mavt)
END;
GO

PRINT dbo.StudenID_Func1('VT01')
GO

------------- 2 -------------
CREATE FUNCTION TotalOfHoaDon(
    @maHD NVARCHAR(10)
)
RETURNS INT
AS
BEGIN
    RETURN (SELECT SUM(cthd.SL * cthd.GiaBan) FROM CHITIETHOADON cthd WHERE cthd.MaHD = @maHD);
END
GO

PRINT dbo.TotalOfHoaDon('HD004')
GO

------------- 3 -------------
CREATE PROCEDURE StudenId_Proc1 @makh NVARCHAR(5), @diachi NVARCHAR(50)
AS
BEGIN
    UPDATE KHACHHANG
    SET DiaChi = @diachi
    WHERE MaKH = @makh;
END
GO

EXEC StudenId_Proc1 'KH01', 'AN GIANG'
GO
------------- 4 -------------
CREATE PROCEDURE InsertToHoaDon @mahd NVARCHAR(10), @ngay DATETIME = NULL, @makh NVARCHAR(5), @tongtg INT = NULL
AS
BEGIN
    INSERT INTO HOADON (MaHD, Ngay, MaKH, TongTG) VALUES(@mahd,@ngay, @makh, @tongtg);
END
GO

EXEC InsertToHoaDon 'HD011','2000-08-15','KH04'
GO

------------- 5 -------------
CREATE TRIGGER StudenId_Trig1 ON CHITIETHOADON FOR INSERT AS BEGIN 
IF NOT EXISTS (
  SELECT 
    * 
  FROM 
    INFORMATION_SCHEMA.COLUMNS 
  WHERE 
    table_name = 'HOADON' 
    AND column_name = 'TongTG'
) 
ALTER TABLE 
  HOADON 
ADD 
  TongTG INT;
UPDATE 
  hd1 
SET 
  hd1.TongTG = (
    SELECT 
      CASE WHEN hd1.TongTG IS NOT NULL THEN hd1.TongTG ELSE 0 END
  ) + thanhtien.tong 
FROM 
  HOADON hd1 
  JOIN (
    SELECT 
      cthd.MaHD, 
      SUM(cthd.SL * cthd.GiaBan) AS tong 
    FROM 
      inserted cthd 
      JOIN HOADON hd ON hd.MaHD = cthd.MaHD 
    GROUP BY 
      cthd.MaHD
  ) thanhtien ON thanhtien.MaHD = hd1.MaHD;
END;
GO

INSERT CHITIETHOADON([MaHD],[MaVT],[SL],[GiaBan]) VALUES('HD011','VT02',4,52000)
GO

------------- 6 -------------
CREATE VIEW StudentID_View1 AS
(
    SELECT DISTINCT kh.* FROM KHACHHANG kh
        JOIN HOADON hd ON hd.MaKH = kh.MaKH
        JOIN CHITIETHOADON cthd ON cthd.MaHD = hd.MaHD
        JOIN VATTU vt ON cthd.MaVT = vt.MaVT
    WHERE vt.TenVT = 'Gach Ong'
)
GO

SELECT * FROM StudentID_View1