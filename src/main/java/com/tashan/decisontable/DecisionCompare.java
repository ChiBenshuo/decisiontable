package com.tashan.decisontable;

import com.tashan.decisontable.constant.Compare;

/**
 * @author chi
 * @date 2018年10月25日 上午9:03:04
 */
public class DecisionCompare {
    /**
     * 小于
     * @param right
     * @return
     */
    public static DecisionCompareItem LT(Object right) {
        return DecisionCompareItem.of(Compare.LT, right);
    }

    /**
     * 小于等于
     * @param right
     * @return
     */
    public static DecisionCompareItem LE(Object right) {
        return DecisionCompareItem.of(Compare.LE, right);
    }

    /**
     * 大于
     * @param right
     * @return
     */
    public static DecisionCompareItem GT(Object right) {
        return DecisionCompareItem.of(Compare.GT, right);
    }

    /**
     * 大于等于
     * @param right
     * @return
     */
    public static DecisionCompareItem GE(Object right) {
        return DecisionCompareItem.of(Compare.GE, right);
    }

    /**
     * 等于
     * @param right
     * @return
     */
    public static DecisionCompareItem EQ(Object right) {
        return DecisionCompareItem.of(Compare.EQ, right);
    }

    /**
     * 不等于
     * @param right
     * @return
     */
    public static DecisionCompareItem NE(Object right) {
        return DecisionCompareItem.of(Compare.NE, right);
    }

    /**
     * 空
     * @return
     */
    public static DecisionCompareItem ISNULL() {
        return DecisionCompareItem.of(Compare.ISNULL);
    }

    /**
     * 非空
     * @return
     */
    public static DecisionCompareItem NOTNULL() {
        return DecisionCompareItem.of(Compare.NOTNULL);
    }

    /**
    * IN
    * @param rights
    * @return
    */
    public static DecisionCompareItem IN(Object... rights) {
        return DecisionCompareItem.of(Compare.IN, rights);
    }

    /**
    * NOTIN
    * @param rights
    * @return
    */
    public static DecisionCompareItem NOTIN(Object... rights) {
        return DecisionCompareItem.of(Compare.NOTIN, rights);
    }

    /**
    * BETWEEN
    * @param o1
    * @param o2
    * @return
    */
    public static DecisionCompareItem BETWEEN(Object o1, Object o2) {
        return DecisionCompareItem.of(Compare.NOTIN, o1, o2);
    }

    /**
     * true
     * @return
     */
    public static DecisionCompareItem TRUE() {
        return DecisionCompareItem.of(Compare.ISTRUE);
    }

    /**
     * false
     * @return
     */
    public static DecisionCompareItem FALSE() {
        return DecisionCompareItem.of(Compare.ISFALSE);
    }

    /**
    * 不关心
    * @return
    */
    public static DecisionCompareItem NOCASE() {
        return DecisionCompareItem.of(Compare.NOCASE);
    }
}
