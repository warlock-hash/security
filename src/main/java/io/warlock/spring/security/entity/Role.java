package io.warlock.spring.security.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.warlock.spring.security.entity.ApplicationUsers;
import io.warlock.spring.security.entity.BaseEntity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "role")
public class Role extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "role_id")
    private Long roleId;

    private String roleName;
    private String desicription;

    @ManyToMany
    @JoinTable(name = "role_privilege" ,
            joinColumns = @JoinColumn(name = "role_id"),
            inverseJoinColumns = @JoinColumn(name = "privilege_id"))
    private List<Privilege> privilegeList;

    @JsonIgnore
    @ManyToMany(mappedBy = "roleList", fetch = FetchType.LAZY)
    private List<ApplicationUsers> usersList;

    public Long getRoleId() {
        return roleId;
    }

    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public String getDesicription() {
        return desicription;
    }

    public void setDesicription(String desicription) {
        this.desicription = desicription;
    }

    public List<Privilege> getPrivilegeList() {
        return privilegeList;
    }

    public void setPrivilegeList(List<Privilege> privilegeList) {
        this.privilegeList = privilegeList;
    }

    public List<ApplicationUsers> getUsersList() {
        return usersList;
    }

    public void setUsersList(List<ApplicationUsers> usersList) {
        this.usersList = usersList;
    }
}
