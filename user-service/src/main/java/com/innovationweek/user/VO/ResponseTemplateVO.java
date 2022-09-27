package com.innovationweek.user.VO;

import com.innovationweek.user.entity.DeptUser;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResponseTemplateVO {

    private DeptUser user;
    private Department department;
}
