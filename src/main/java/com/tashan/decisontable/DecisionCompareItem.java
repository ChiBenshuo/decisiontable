package com.tashan.decisontable;

import com.tashan.decisontable.constant.Compare;

/**
 * 比较项目
 * @author chi
 * @date 2018年10月24日 下午6:54:48
 */
public class DecisionCompareItem {
    /** 比较符号 */
    private final Compare compare;
    /** 右 */
    private final Object[] rights;

    private DecisionCompareItem(Compare compare, Object... rights) {
        this.compare = compare;
        this.rights = rights;
    }

    /**
     * 构造比较项目
     * @param compare
     * @param rights
     * @return
     */
    public static DecisionCompareItem of(Compare compare, Object... rights) {
        return new DecisionCompareItem(compare, rights);
    }

    /**
     * 比较结果
     * @param left
     * @return
     */
    public boolean compare(Object left) {
        return this.compare.compare(left, rights);
    }

    /**
     * 是否是参数
     * @return
     */
    public boolean isArgument() {
        return compare.isArgument();
    }
}
