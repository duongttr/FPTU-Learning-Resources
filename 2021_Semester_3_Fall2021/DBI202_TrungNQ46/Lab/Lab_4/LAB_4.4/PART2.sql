-- 1

INSERT INTO NHANVIEN (MANV, HOTEN, SODT, NGVL) VALUES ('NV01', 'Nguyen Nhu Nhut', '0927345678', '2006-04-13')
INSERT INTO NHANVIEN (MANV, HOTEN, SODT, NGVL) VALUES ('NV02', 'Le Thi Phi Yen', '0987567390', '2006-4-21')
INSERT INTO NHANVIEN (MANV, HOTEN, SODT, NGVL) VALUES ('NV03', 'Nguyen Van B', '0997047382', '2006-4-27')
INSERT INTO NHANVIEN (MANV, HOTEN, SODT, NGVL) VALUES ('NV04', 'Ngo Thanh Tuan', '0913758498', '2006-6-24')
INSERT INTO NHANVIEN (MANV, HOTEN, SODT, NGVL) VALUES ('NV05', 'Nguyen Thi Truc Thanh', '0918590387', '2006-7-20')

INSERT INTO KHACHHANG (MAKH, HOTEN, DCHI, SODT, NGSINH, DOANHSO, NGDK)
    VALUES(
    'KH01', 
    'Nguyen Van A', 
    '731 Tran Hung Dao, 05, TpHCM', 
    '08823451', 
    '1960-10-22', 
    13060000, 
    '2006-07-22');

INSERT INTO KHACHHANG (MAKH, HOTEN, DCHI, SODT, NGSINH, DOANHSO, NGDK)
    VALUES(
    'KH02', 
    'Tran Ngoc Han', 
    '23-5 Nguyen Trai, Q5, TpHCM', 
    '0908256478', 
    '1974-4-3', 
    280000, 
    '2006-07-30');

INSERT INTO KHACHHANG (MAKH, HOTEN, DCHI, SODT, NGSINH, DOANHSO, NGDK)
    VALUES(
    'KH03', 
    'Tran Ngoc Linh', 
    '45 Nguyen Canh Chan, Q1, TpHCM', 
    '0938776266', 
    '1980-6-12', 
    3860000, 
    '2006-08-05');

INSERT INTO KHACHHANG (MAKH, HOTEN, DCHI, SODT, NGSINH, DOANHSO, NGDK)
    VALUES(
    'KH04', 
    'Tran Minh Long', 
    '50134 Le Dai Hanh, Q10, TpHCM', 
    '0917325476', 
    '1965-3-9', 
    250000, 
    '2006-10-02');

INSERT INTO KHACHHANG (MAKH, HOTEN, DCHI, SODT, NGSINH, DOANHSO, NGDK)
    VALUES(
    'KH05', 
    'Le Nhat Minh', 
    '34 Truong Dinh, 03, TpHCM', 
    '08246108', 
    '1950-3-10', 
    21000, 
    '2006-10-28');

INSERT INTO KHACHHANG (MAKH, HOTEN, DCHI, SODT, NGSINH, DOANHSO, NGDK)
    VALUES(
    'KH06', 
    'Le Hoai Thuong', 
    '227 Nguyen Van Cu, Q5, TpHCM', 
    '08631738', 
    '1981-12-31', 
    915000, 
    '2006-11-24');

INSERT INTO KHACHHANG (MAKH, HOTEN, DCHI, SODT, NGSINH, DOANHSO, NGDK)
    VALUES(
    'KH07', 
    'Nguyen Van Tam', 
    '3213 Tran Binh Trong, 05, TpHCM', 
    '0916783565', 
    '1971-4-6', 
    12500, 
    '2006-12-01');

INSERT INTO KHACHHANG (MAKH, HOTEN, DCHI, SODT, NGSINH, DOANHSO, NGDK)
    VALUES(
    'KH08', 
    'Phan Thi Thanh', 
    '4512 An Duong Vuong, 05, TpHCM', 
    '0938435756', 
    '1971-1-10', 
    365000, 
    '2006-12-13'); 

INSERT INTO KHACHHANG (MAKH, HOTEN, DCHI, SODT, NGSINH, DOANHSO, NGDK)
    VALUES(
    'KH09', 
    'Le Ha Vinh', 
    '873 Le Hong Phong, Q5, TpHCM', 
    '08654763', 
    '1979-9-3', 
    70000, 
    '2007-01-14'); 

INSERT INTO KHACHHANG (MAKH, HOTEN, DCHI, SODT, NGSINH, DOANHSO, NGDK)
    VALUES(
    'KH10', 
    'Ha Duy Lap', 
    '34134B Nguyen Tral, Q1, TpHCM', 
    '08768904', 
    '1983-5-2', 
    67500, 
    '2007-01-16'); 

INSERT INTO SANPHAM (MASP, TENSP, DVT, NUOCSX, GIA)
VALUES
('BC01', 'But chi', 'cay', 'Singapore', 3000), 
('BC02', 'But chi', 'cay', 'Singapore', 5000),
('BC03', 'But chi', 'cay', 'Viet Nam', 3500),
('BC04', 'But chi', 'hop', 'Viet Nam', 30000),
('BB01', 'But bi', 'cay', 'Viet Nam', 5000),
('BB02', 'But bi', 'cay', 'Trung Quoc', 7000 ),
('BB03', 'But bi', 'hop', 'Thai Lan', 100000),
('TV01', 'Tap 100 giay mong', 'quyen', 'Trung Quoc', 2500 ),
('TV02', 'Tap 200 giay mong', 'quyen', 'Trung Quoc', 4500),
('TV03', 'Tap 100 giay tot', 'quyen', 'Viet Nam', 3000 ),
('TV04' ,'Tap 200 giay tot', 'quyen', 'Viet Nam', 5500),
('TV05', 'Tap 100 trang', 'chuc', 'Viet Nam', 23000 ),
('TV06', 'Tap 200 trang', 'chuc', 'Viet Nam' ,53000),
('TV07', 'Tap 100 trang', 'chuc', 'Trung Quoc', 34000),
('ST01', 'So tay 500 trang', 'quyen', 'Trung Quoc', 40000),
('ST02', 'So tay loai 1', 'quyen', 'Viet Nam', 55000 ),
('ST03', 'So tay loai 2', 'quyen', 'Viet Nam', 51000 ),
('ST04', 'So tay', 'quyen', 'Thai Lan', 55000 ),
('ST05', 'So tay mong', 'quyen', 'Thai Lan', 20000 ),
('ST06', 'Phan viet bang', 'hop', 'Viet Nam', 5000 ),
('ST07', 'Phan khong bui', 'hop', 'Viet Nam', 7000 ),
('ST08', 'Bong bang', 'cai', 'Viet Nam', 1000 ),
('ST09', 'But long', 'cay', 'Viet Nam', 5000 ),
('ST10', 'But long', 'cay', 'Trung Quoc', 7000 )

INSERT INTO HOADON (SOHD, NGHD, MAKH, MANV, TRIGIA)
VALUES
(1001, '2006-07-23', 'KH01', 'NV01', 320000),
(1002, '2006-08-12', 'KH01', 'NV02', 840000), 
( 1003, '2006-08-23', 'KH02', 'NV01', 100000), 
( 1004, '2006-09-01', 'KH02', 'NV01', 180000 ),
( 1005, '2006-10-20' ,'KH01', 'NV02', 3800000), 
( 1006, '2006-10-16', 'KH01', 'NV03', 2430000), 
( 1007, '2006-10-28' ,'KH03', 'NV03', 510000 ),
( 1008, '2006-10-28', 'KH01', 'NV03', 440000),
( 1009, '2006-10-28', 'KH03', 'NV04', 200000 ),
( 1010, '2006-11-01', 'KH01', 'NV01', 5200000), 
( 1011, '2006-11-04', 'KH04', 'NV03', 250000 ),
( 1012, '2006-11-30', 'KH05', 'NV03', 21000 ),
( 1013, '2006-12-12', 'KH06', 'NV01', 5000 ),
( 1014, '2006-12-31', 'KH03', 'NV02', 3150000), 
( 1015, '2007-01-01', 'KH06', 'NV01', 910000 ),
( 1016, '2007-01-01', 'KH07', 'NV02', 12500 ),
( 1017, '2007-01-02', 'KH08', 'NV03', 35000 ),
( 1018, '2007-01-13', 'KH08', 'NV03', 330000 ),
( 1019, '2007-01-13', 'KH01', 'NV03', 30000 ),
( 1020, '2007-01-14', 'KH09', 'NV04', 70000 ),
( 1021, '2007-01-16', 'KH10', 'NV03', 67500 ),
( 1022, '2007-01-16', Null, 'NV03', 7000 ),
( 1023, '2007-01-17', Null, 'NV01', 330000 )

INSERT INTO CTHD (SOHD, MASP, SL)
VALUES
(1001, 'TV02', 10 ),
(1001, 'ST01', 5 ),
(1001, 'BC01', 5 ),
(1001, 'BC02', 10 ),
(1001, 'ST08', 10 ),
(1002, 'BC04', 20 ),
(1002, 'BB01', 20 ),
(1002, 'BB02', 20 ),
(1003, 'BB03', 10 ),
(1004, 'TV01', 20 ),
(1006, 'TV01', 20 ),
(1006, 'ST01', 30 ),
(1006, 'ST02', 10 ),
(1007, 'ST03', 10 ),
(1008, 'ST04', 8 ),
(1009, 'ST05', 10 ),
(1010, 'TV07', 50 ),
(1010, 'ST07', 50 ),
(1010, 'ST08', 100 ),
(1010, 'ST04', 50 ),
(1010, 'TV03', 100 ),
(1011, 'ST06', 50 ),
(1012, 'ST07', 3 ),
(1013, 'ST08', 5 ),
(1014, 'BC02', 80 ),
(1014, 'BB02', 100 ),
(1014, 'BC04', 60 ),
(1014, 'BB01', 50 ),
(1015, 'BB02', 30 ),
(1015, 'BB03', 7 ),
(1016, 'TV01', 5 ),
(1017, 'TV02', 1 ),
(1017, 'TV03', 1 ),
(1017, 'TV04', 5 ),
(1018, 'ST04', 6 ),
(1019, 'ST05', 1 ),
(1019, 'ST06', 2 ),
(1020, 'ST07', 10 ),
(1021, 'ST08', 5 ),
(1021, 'TV01', 7 ),
(1021, 'TV02', 10 ),
(1022, 'ST07', 1 ),
(1023, 'ST04', 6)


--2
SELECT * INTO SANPHAM1 FROM SANPHAM
SELECT * INTO KHACHHANG1 FROM KHACHHANG


--3
UPDATE SANPHAM1
SET GIA += 5/100*GIA 
WHERE NUOCSX='Thai Lan'

--4
UPDATE SANPHAM1
SET GIA -= 5/100*GIA  
WHERE NUOCSX='Trung Quoc'

--5
UPDATE KHACHHANG1
SET LOAIKH =
CASE
	WHEN NGDK<'2007-01-01' AND DOANHSO>10000000 THEN 'Vip'
	WHEN NGDK>='2007-01-01' AND DOANHSO>2000000 THEN 'Vip'
END;
