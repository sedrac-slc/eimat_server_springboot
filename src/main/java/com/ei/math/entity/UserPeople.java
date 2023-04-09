package com.ei.math.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.UUID;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Type;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
/**
 * @author Sedrac Lucas Calupeteca
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "td_users")
public class UserPeople implements UserDetails, Serializable{
    
    private static long serialVersionUID = 1L;

    public static UserPeople uuidAllNull(String userId) {
        return new UserPeople(UUID.fromString(userId), null, null, null, null, null, null, null, null, null);
    }
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Type(type = "uuid-char")
    private UUID id;
    @NotEmpty @NotNull
    private String name;
    @Email @NotEmpty @NotNull
    @Column(unique = true)
    private String email;
    @NotEmpty @NotNull
    @Column(unique = true)
    private String phone;
    @NotNull 
    @Temporal(TemporalType.DATE)
    private Date birthDay;
    
    private String username;
    private String password;
    
    @ManyToMany
    @JoinTable(
        name = "tb_roles_users",
        joinColumns = @JoinColumn(name = "user_id", columnDefinition = "VARCHAR(255)"),
        inverseJoinColumns = @JoinColumn(name = "role_id", columnDefinition = "VARCHAR(255)")
    )
    private List<RolesUser> roles;
    
    @JsonIgnore
    @OneToMany(mappedBy = "userPeople")
    private List<Group> groups;
    
    @JsonIgnore
    @OneToMany(mappedBy = "userPeople")
    private List<Element> elements;    

    public UserPeople(String userId) {
       this.id = UUID.fromString(userId);
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
       return roles;
    }

    @Override
    public String getPassword() {
       return password;
    }

    @Override
    public String getUsername() {
       return username;
    }

    @Override
    public boolean isAccountNonExpired() {
       return true;
    }

    @Override
    public boolean isAccountNonLocked() {
      return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
       return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }  
    
}
