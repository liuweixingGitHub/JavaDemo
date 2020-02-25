package com.ax.springsecurity.09springsecurity-oauth.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 
 * </p>
 *
 * @author jobob
 * @since 2020-01-09
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class TUserinfo implements Serializable {

    private static final long serialVersionUID = 1L;

    private String username;

    private String password;

    @TableField("userType")
    private String userType;


}
