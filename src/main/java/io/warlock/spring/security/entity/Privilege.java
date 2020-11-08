package io.warlock.spring.security.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "privilege")
public class Privilege extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "privilege_id")
    private Long privilegeId;
    private String name;
    private String description;
    private String permissionType;

    @ManyToMany(mappedBy = "privilegeList" ,fetch = FetchType.EAGER)
    private List<Role> roleList;

    public Long getPrivilegeId() {
        return privilegeId;
    }

    public void setPrivilegeId(Long privilegeId) {
        this.privilegeId = privilegeId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPermissionType() {
        return permissionType;
    }

    public void setPermissionType(String permissionType) {
        this.permissionType = permissionType;
    }

    public List<Role> getRoleList() {
        return roleList;
    }

    public void setRoleList(List<Role> roleList) {
        this.roleList = roleList;
    }
}
