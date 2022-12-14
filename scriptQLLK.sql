USE [master]
GO
/****** Object:  Database [QLLK]    Script Date: 11/11/2020 5:21:14 PM ******/
CREATE DATABASE [QLLK]
 CONTAINMENT = NONE
 ON  PRIMARY 
( NAME = N'QLLK_data', FILENAME = N'C:\Users\LAPTOP\Downloads\QLLINHKIEN.mdf' , SIZE = 10240KB , MAXSIZE = 51200KB , FILEGROWTH = 10%)
 LOG ON 
( NAME = N'QLLK_log', FILENAME = N'C:\Users\LAPTOP\Downloads\QLLINHKIEN.ldf' , SIZE = 10240KB , MAXSIZE = 51200KB , FILEGROWTH = 10%)
GO
ALTER DATABASE [QLLK] SET COMPATIBILITY_LEVEL = 140
GO
IF (1 = FULLTEXTSERVICEPROPERTY('IsFullTextInstalled'))
begin

end
GO
ALTER DATABASE [QLLK] SET ANSI_NULL_DEFAULT OFF 
GO
ALTER DATABASE [QLLK] SET ANSI_NULLS OFF 
GO
ALTER DATABASE [QLLK] SET ANSI_PADDING OFF 
GO
ALTER DATABASE [QLLK] SET ANSI_WARNINGS OFF 
GO
ALTER DATABASE [QLLK] SET ARITHABORT OFF 
GO
ALTER DATABASE [QLLK] SET AUTO_CLOSE ON 
GO
ALTER DATABASE [QLLK] SET AUTO_SHRINK OFF 
GO
ALTER DATABASE [QLLK] SET AUTO_UPDATE_STATISTICS ON 
GO
ALTER DATABASE [QLLK] SET CURSOR_CLOSE_ON_COMMIT OFF 
GO
ALTER DATABASE [QLLK] SET CURSOR_DEFAULT  GLOBAL 
GO
ALTER DATABASE [QLLK] SET CONCAT_NULL_YIELDS_NULL OFF 
GO
ALTER DATABASE [QLLK] SET NUMERIC_ROUNDABORT OFF 
GO
ALTER DATABASE [QLLK] SET QUOTED_IDENTIFIER OFF 
GO
ALTER DATABASE [QLLK] SET RECURSIVE_TRIGGERS OFF 
GO
ALTER DATABASE [QLLK] SET  ENABLE_BROKER 
GO
ALTER DATABASE [QLLK] SET AUTO_UPDATE_STATISTICS_ASYNC OFF 
GO
ALTER DATABASE [QLLK] SET DATE_CORRELATION_OPTIMIZATION OFF 
GO
ALTER DATABASE [QLLK] SET TRUSTWORTHY OFF 
GO
ALTER DATABASE [QLLK] SET ALLOW_SNAPSHOT_ISOLATION OFF 
GO
ALTER DATABASE [QLLK] SET PARAMETERIZATION SIMPLE 
GO
ALTER DATABASE [QLLK] SET READ_COMMITTED_SNAPSHOT OFF 
GO
ALTER DATABASE [QLLK] SET HONOR_BROKER_PRIORITY OFF 
GO
ALTER DATABASE [QLLK] SET RECOVERY SIMPLE 
GO
ALTER DATABASE [QLLK] SET  MULTI_USER 
GO
ALTER DATABASE [QLLK] SET PAGE_VERIFY CHECKSUM  
GO
ALTER DATABASE [QLLK] SET DB_CHAINING OFF 
GO
ALTER DATABASE [QLLK] SET FILESTREAM( NON_TRANSACTED_ACCESS = OFF ) 
GO
ALTER DATABASE [QLLK] SET TARGET_RECOVERY_TIME = 60 SECONDS 
GO
ALTER DATABASE [QLLK] SET DELAYED_DURABILITY = DISABLED 
GO
ALTER DATABASE [QLLK] SET QUERY_STORE = OFF
GO
USE [QLLK]
GO
/****** Object:  Table [dbo].[CTHoaDon]    Script Date: 11/11/2020 5:21:14 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[CTHoaDon](
	[soLuong] [int] NULL,
	[donGia] [real] NULL,
	[maLK] [char](5) NOT NULL,
	[maHD] [char](5) NOT NULL,
 CONSTRAINT [SuaCT] PRIMARY KEY CLUSTERED 
(
	[maHD] ASC,
	[maLK] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[DiaChi]    Script Date: 11/11/2020 5:21:14 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[DiaChi](
	[maDC] [char](5) NOT NULL,
	[nuoc] [nvarchar](30) NULL,
	[tinhTP] [nvarchar](30) NULL,
	[quanHuyen] [nvarchar](30) NULL,
	[phuongXa] [nvarchar](30) NULL,
	[soNha] [nvarchar](30) NULL,
PRIMARY KEY CLUSTERED 
(
	[maDC] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[HoaDon]    Script Date: 11/11/2020 5:21:14 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[HoaDon](
	[maHD] [char](5) NOT NULL,
	[ngayLap] [date] NULL,
	[maNV] [nchar](5) NOT NULL,
	[maKH] [char](5) NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[maHD] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[KhachHang]    Script Date: 11/11/2020 5:21:14 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[KhachHang](
	[maKH] [char](5) NOT NULL,
	[tenKH] [nvarchar](60) NOT NULL,
	[sdt] [nvarchar](15) NULL,
	[diaChi] [char](5) NOT NULL,
	[phai] [bit] NULL,
	[email] [nvarchar](50) NULL,
	[namSinh] [nvarchar](4) NULL,
PRIMARY KEY CLUSTERED 
(
	[maKH] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[LinhKien]    Script Date: 11/11/2020 5:21:14 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[LinhKien](
	[maLK] [char](5) NOT NULL,
	[tenLK] [nvarchar](120) NOT NULL,
	[soLuong] [int] NULL,
	[giaNhap] [real] NULL,
	[giaBan] [real] NULL,
	[donViTinh] [nvarchar](30) NULL,
	[baoHanh] [nvarchar](40) NULL,
	[kieuMau] [nvarchar](60) NULL,
	[nuocSX] [nvarchar](60) NULL,
	[thongsoKT] [nvarchar](300) NULL,
	[mauSac] [nvarchar](50) NULL,
	[tinhTrang] [nvarchar](30) NULL,
	[maNCC] [char](5) NOT NULL,
	[maLoai] [nvarchar](5) NOT NULL,
	[ngaNhap] [date] NULL,
PRIMARY KEY CLUSTERED 
(
	[maLK] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[loaiLK]    Script Date: 11/11/2020 5:21:14 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[loaiLK](
	[maLoai] [nvarchar](5) NOT NULL,
	[tenLoai] [nvarchar](60) NULL,
PRIMARY KEY CLUSTERED 
(
	[maLoai] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[NhaCungCap]    Script Date: 11/11/2020 5:21:14 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[NhaCungCap](
	[maNCC] [char](5) NOT NULL,
	[diaChi] [nvarchar](60) NULL,
	[tenNCC] [nvarchar](40) NOT NULL,
	[email] [nvarchar](50) NULL,
PRIMARY KEY CLUSTERED 
(
	[maNCC] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[NhanVien]    Script Date: 11/11/2020 5:21:14 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[NhanVien](
	[maNV] [nchar](5) NOT NULL,
	[tenNV] [nvarchar](50) NOT NULL,
	[diaChi] [nvarchar](60) NULL,
	[namSinh] [nchar](4) NULL,
	[phai] [bit] NULL,
	[CMND] [nvarchar](15) NULL,
	[chucVu] [nvarchar](30) NULL,
	[taiKhoan] [varchar](20) NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[maNV] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[TaiKhoan]    Script Date: 11/11/2020 5:21:14 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[TaiKhoan](
	[taiKhoan] [varchar](20) NOT NULL,
	[matKhau] [varchar](20) NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[taiKhoan] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
INSERT [dbo].[CTHoaDon] ([soLuong], [donGia], [maLK], [maHD]) VALUES (1, 1590000, N'LK001', N'HD01 ')
INSERT [dbo].[DiaChi] ([maDC], [nuoc], [tinhTP], [quanHuyen], [phuongXa], [soNha]) VALUES (N'DC001', N'Việt Nam', N'TP Hồ Chí Minh', N'Gò Vấp', N'Phu?ng 5', N'05 Nguy?n Thái Son')
INSERT [dbo].[HoaDon] ([maHD], [ngayLap], [maNV], [maKH]) VALUES (N'HD01 ', CAST(N'2020-11-11' AS Date), N'NV01 ', N'KH001')
INSERT [dbo].[KhachHang] ([maKH], [tenKH], [sdt], [diaChi], [phai], [email], [namSinh]) VALUES (N'KH001', N'Tr?n Th? H?ng', N'0935132656', N'DC001', 0, N'', N'1999')
INSERT [dbo].[LinhKien] ([maLK], [tenLK], [soLuong], [giaNhap], [giaBan], [donViTinh], [baoHanh], [kieuMau], [nuocSX], [thongsoKT], [mauSac], [tinhTrang], [maNCC], [maLoai], [ngaNhap]) VALUES (N'LK001', N'HDD Western Digital 250GB', 10, 1400000, 1590000, N'Ổ', N'6 tháng', N'WD10EFRX', N'Nhật Bản', N' Dung lượng 250GB; giao tiếp SATA 3 (6Gb/s max); 16MB Cache, tốc độ quay 7200RPM', N'', N'Mới', N'NCC4 ', N'OC001', CAST(N'2020-11-11' AS Date))
INSERT [dbo].[loaiLK] ([maLoai], [tenLoai]) VALUES (N'OC001', N'Ổ Cứng')
INSERT [dbo].[NhaCungCap] ([maNCC], [diaChi], [tenNCC], [email]) VALUES (N'NCC1 ', N'', N'Intel', N'')
INSERT [dbo].[NhaCungCap] ([maNCC], [diaChi], [tenNCC], [email]) VALUES (N'NCC2 ', N'', N'Gigabyte', N'')
INSERT [dbo].[NhaCungCap] ([maNCC], [diaChi], [tenNCC], [email]) VALUES (N'NCC3 ', N'', N'ASUS', N'')
INSERT [dbo].[NhaCungCap] ([maNCC], [diaChi], [tenNCC], [email]) VALUES (N'NCC4 ', N'', N'Western Digital', N'')
INSERT [dbo].[NhanVien] ([maNV], [tenNV], [diaChi], [namSinh], [phai], [CMND], [chucVu], [taiKhoan]) VALUES (N'NV01 ', N'Nguyễn Mai Anh', N'12, Nguyễn Văn Bảo', N'1990', 0, N'345689562', N'Thu Ngân', N'345689562')
INSERT [dbo].[NhanVien] ([maNV], [tenNV], [diaChi], [namSinh], [phai], [CMND], [chucVu], [taiKhoan]) VALUES (N'NV02 ', N'Nguyên Ngọc Hùng', N'1, Nguyễn Thái Sơn', N'1989', 1, N'345689541', N'Thu Ngân', N'345689541')
INSERT [dbo].[NhanVien] ([maNV], [tenNV], [diaChi], [namSinh], [phai], [CMND], [chucVu], [taiKhoan]) VALUES (N'NV03 ', N'Trần Anh Huy', N'25, Phan Văn Trị ', N'1991', 1, N'345156532', N'Thu Ngân', N'345156532')
INSERT [dbo].[TaiKhoan] ([taiKhoan], [matKhau]) VALUES (N'345156532', N'345156532')
INSERT [dbo].[TaiKhoan] ([taiKhoan], [matKhau]) VALUES (N'345689541', N'345689541')
INSERT [dbo].[TaiKhoan] ([taiKhoan], [matKhau]) VALUES (N'345689562', N'345689562')
ALTER TABLE [dbo].[CTHoaDon]  WITH CHECK ADD FOREIGN KEY([maHD])
REFERENCES [dbo].[HoaDon] ([maHD])
GO
ALTER TABLE [dbo].[CTHoaDon]  WITH CHECK ADD FOREIGN KEY([maLK])
REFERENCES [dbo].[LinhKien] ([maLK])
GO
ALTER TABLE [dbo].[HoaDon]  WITH CHECK ADD FOREIGN KEY([maKH])
REFERENCES [dbo].[KhachHang] ([maKH])
GO
ALTER TABLE [dbo].[HoaDon]  WITH CHECK ADD FOREIGN KEY([maNV])
REFERENCES [dbo].[NhanVien] ([maNV])
GO
ALTER TABLE [dbo].[KhachHang]  WITH CHECK ADD FOREIGN KEY([diaChi])
REFERENCES [dbo].[DiaChi] ([maDC])
GO
ALTER TABLE [dbo].[LinhKien]  WITH CHECK ADD FOREIGN KEY([maLoai])
REFERENCES [dbo].[loaiLK] ([maLoai])
GO
ALTER TABLE [dbo].[LinhKien]  WITH CHECK ADD FOREIGN KEY([maNCC])
REFERENCES [dbo].[NhaCungCap] ([maNCC])
GO
ALTER TABLE [dbo].[NhanVien]  WITH CHECK ADD FOREIGN KEY([taiKhoan])
REFERENCES [dbo].[TaiKhoan] ([taiKhoan])
GO
USE [master]
GO
ALTER DATABASE [QLLK] SET  READ_WRITE 
GO
