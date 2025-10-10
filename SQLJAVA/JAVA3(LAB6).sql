CREATE DATABASE HRM;
GO

USE HRM;
GO

-- Bảng Departments (Phòng ban)
CREATE TABLE Departments (
    Id CHAR(3) NOT NULL,              -- Mã phòng
    Name NVARCHAR(50) NOT NULL,       -- Tên phòng
    Description NVARCHAR(255) NULL,   -- Mô tả phòng
    PRIMARY KEY (Id)
);
	
-- Bảng Employees (Nhân viên)
CREATE TABLE Employees (
    Id VARCHAR(20) NOT NULL,          -- Mã nhân viên
    Password NVARCHAR(50) NOT NULL,   -- Mật khẩu
    Fullname NVARCHAR(50) NOT NULL,   -- Họ và tên
    Photo NVARCHAR(50) NOT NULL,      -- Hình ảnh
    Gender BIT NOT NULL,              -- Giới tính
    Birthday DATE NOT NULL,           -- Ngày sinh
    Salary FLOAT NOT NULL,            -- Lương cơ bản
    DepartmentId CHAR(3) NOT NULL,    -- Mã phòng (liên kết)
    PRIMARY KEY (Id),
    FOREIGN KEY (DepartmentId) REFERENCES Departments(Id)
        ON DELETE CASCADE             -- Xóa dây chuyền theo DepartmentId
        ON UPDATE CASCADE             -- Sửa dây chuyền theo DepartmentId
);
GO


--Thêm mới: {CALL spInsert(?, ?, ?)}--
CREATE PROCEDURE spInsert(
	@Id VARCHAR(20),
	@Name NVARCHAR(50),
	@Description NVARCHAR(100)
) AS BEGIN
	INSERT INTO Departments(Id, Name, Description)
	VALUES(@Id, @Name, @Description)
END
GO
--Cập nhật: {CALL spUpdate(?, ?, ?)}--
CREATE PROCEDURE spUpdate(
	@Id VARCHAR(20),
	@Name NVARCHAR(50),
	@Description NVARCHAR(100)
) AS BEGIN
	UPDATE Departments
	SET Name=@Name, Description=@Description
	WHERE Id=@Id
END
GO
--Xóa theo khóa chính: {CALL spDeleteById(?)}--
CREATE PROCEDURE spDeleteById(
@Id VARCHAR(20)
) AS BEGIN
DELETE FROM Departments WHERE Id=@Id
END
--Truy vấn tất cả: {CALL spSelectAll()}--
CREATE PROCEDURE spSelectAll() 
AS BEGIN
SELECT * FROM Departments
END
GO

--Truy vấn theo khóa chính: {CALL spSelectById(?)}--
CREATE PROCEDURE spSelectById(
@Id VARCHAR(20)
) AS BEGIN
SELECT * FROM Departments WHERE Id=@Id
END
