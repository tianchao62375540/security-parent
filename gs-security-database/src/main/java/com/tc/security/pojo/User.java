package com.tc.security.pojo;

import lombok.Data;
import lombok.experimental.Accessors;
import tk.mybatis.mapper.annotation.KeySql;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Accessors(chain = true)
@Table(name="user")
public class User implements Serializable {

    private static final long serialVersionUID = -1218958122124293822L;
    @Id
    @KeySql(useGeneratedKeys = true)
    private Long id;

    /**
     * 账号
     */
    private String username;

    /**
     * 密码
     */
    private String password;

    /**
     * 昵称
     */
    private String nickname;

}
