package com.example.vo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.awt.*;
import java.io.Serializable;
import java.util.List;

/**
 * <p>
 * 菜单表
 * </p>
 *
 * @author LLY
 * @since 2020-12-11
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("menu")
public class MenuVo implements Serializable {

    private static final long serialVersionUID = 1L;

    public MenuVo() {
    }

    public MenuVo(Integer menuId, String name, Integer parentId ) {
        this.menuId = menuId;
        this.name = name;
        this.parentId = parentId;
    }

    /**
     * 菜单id
     */
    @TableId(value = "menu_id", type = IdType.AUTO)
    private Integer menuId;

    /**
     * 菜单名
     */
    @TableField("name")
    private String name;

    /**
     * 路由地址
     */
    @TableField("url")
    private String url;

    /**
     * 菜单类型  （M目录 C菜单 F按钮）
     */
    @TableField("type")
    private String type;

    /**
     * 权限标识
     */
    @TableField("perms")
    private String perms;

    /**
     * 菜单图标
     */
    @TableField("icon")
    private String icon;

    /**
     * 菜单父id
     */
    @TableField("parent_id")
    private Integer parentId;

    /**
     * 子集合
     */
    @TableField(exist = false)
    private List<MenuVo> children;
}
