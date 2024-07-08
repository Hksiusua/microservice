package com.example.user.model;

import com.example.user.entity.RoleE;
import lombok.*;

import java.util.List;
import java.util.stream.Collectors;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class RoleM {
    private int roleId;
    private String roleName;
    private String description;
    public static RoleM conVertRoleEToRoleM(RoleE roleE){
        return RoleM.builder()
                .roleId(roleE.getRoleId())
                .roleName(roleE.getRoleName())
                .description(roleE.getDescription())
                .build();
    }

    public static List<RoleM> conVertListRoleEToListRoleM(List<RoleE> roleEList) {
        return roleEList.stream()
                .map(e -> conVertRoleEToRoleM(e))
                .collect(Collectors.toList());
    }
}
