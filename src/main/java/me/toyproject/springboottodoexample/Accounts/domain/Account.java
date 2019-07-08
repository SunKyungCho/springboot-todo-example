package me.toyproject.springboottodoexample.Accounts.domain;

import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Set;


@Entity
@Getter
@EqualsAndHashCode(of = "id")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Builder
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;
    @Column(name = "name", nullable = false)
    private String name;
    @Column(name = "password", nullable = false)
    private String password;
    @Column(name = "roles")
    @ElementCollection(fetch = FetchType.EAGER)
    @Enumerated(EnumType.STRING)
    private Set<AccountRole> roles;
//    @CreationTimestamp
//    @Column(name = "create_at", nullable = false, updatable = false)
//    private LocalDateTime createAt;
//    @UpdateTimestamp
//    @Column(name = "update_at", nullable = false)
//    private LocalDateTime updateAt;

    public Account(String name, String password, Set<AccountRole> roles) {
        this.name = name;
        this.password = password;
        this.roles = roles;
    }
}
