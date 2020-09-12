package com.zb.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

/***
 *
 * @author once
 * @date 2020/9/5 12:55
 *
 */
@Getter
@Setter
@Accessors(chain = true)
public class User {
    private long id;
    private String strId;
    private String name;
    private String address;
    private String mobile;
}
