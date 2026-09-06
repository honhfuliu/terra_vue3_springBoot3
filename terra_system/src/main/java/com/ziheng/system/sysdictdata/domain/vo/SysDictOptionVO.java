package com.ziheng.system.sysdictdata.domain.vo;

import com.ziheng.system.sysdictdata.domain.SysDictData;
import lombok.Data;

/**
 * 字典值选项 VO（供前端页面下拉框/标签展示使用，按字典类型编码查询）
 */
@Data
public class SysDictOptionVO {

    /**
     * 字典标签（显示名称）
     */
    private String dictLabel;

    /**
     * 字典值
     */
    private String dictValue;

    /**
     * 是否默认：Y是 N否
     */
    private String isDefault;

    /**
     * 标签类型：success、warning、error、processing、default
     */
    private String tagType;

    /**
     * CSS样式类
     */
    private String cssClass;

    public static SysDictOptionVO from(SysDictData dictData) {
        SysDictOptionVO vo = new SysDictOptionVO();
        vo.setDictLabel(dictData.getDictLabel());
        vo.setDictValue(dictData.getDictValue());
        vo.setIsDefault(dictData.getIsDefault());
        vo.setTagType(dictData.getTagType());
        vo.setCssClass(dictData.getCssClass());
        return vo;
    }
}
