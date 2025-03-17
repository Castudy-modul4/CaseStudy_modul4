package org.example.casestudymodule4_quanlycanhochungcu.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.*;
import com.fasterxml.jackson.annotation.JsonIgnore;
import java.util.Date;

@Entity
@Table(name = "tai_khoan",
        uniqueConstraints = @UniqueConstraint(columnNames = {"username", "password"})) // Đảm bảo username + password không trùng nhau
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString(exclude = "password")
public class TaiKhoan {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotEmpty(message = "Tên đăng nhập không được để trống")
    @Size(min = 3, max = 50, message = "Tên đăng nhập phải có từ 3 đến 50 ký tự")
    @Column(nullable = false, length = 50)
    private String username; // Không cần unique, cho phép trùng nhau

    @JsonIgnore
    @NotEmpty(message = "Mật khẩu không được để trống")
    @Size(min = 6, message = "Mật khẩu phải có ít nhất 6 ký tự")
    @Pattern(regexp = "\\d+", message = "Mật khẩu chỉ được chứa số")
    @Column(nullable = false, length = 255)
    private String password;

    @NotEmpty(message = "Vai trò không được để trống")
    @Pattern(regexp = "^(ADMIN|USER|MANAGER)$", message = "Vai trò không hợp lệ (chỉ được ADMIN, USER hoặc MANAGER)")
    @Column(nullable = false, length = 20)
    private String role;

    @PastOrPresent(message = "Ngày tạo không hợp lệ")
    @Column(updatable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdAt = new Date();

}