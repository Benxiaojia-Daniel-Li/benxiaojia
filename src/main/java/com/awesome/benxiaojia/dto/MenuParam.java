package com.awesome.benxiaojia.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import java.util.List;

/**
 * @Classname MenuParam
 * @Description TODO
 * @Author by Daniel Li
 * @Contact 164278571@qq.com
 * @Date 2020/9/9
 */
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class MenuParam {
    private SubMenu homeInfo;
    private SubMenu logoInfo;
    private List<SubMenu> menuInfo;
    @Data
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public static class SubMenu {
        private String title;

        private String image;

        private String icon;

        private String href;

        private String target = "_self";

        private List<SubMenu> child;
    }

}
