package com.zb.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

/***
 *
 * @author once
 * @date 2020/9/12 18:04
 *
 */
@Getter
@Setter
@Builder
public class User {
    private Long id;

    private String name;
}
