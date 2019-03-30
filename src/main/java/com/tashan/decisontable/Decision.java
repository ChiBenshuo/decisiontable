package com.tashan.decisontable;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

/**
 * 判定条目
 * @author chi
 * @date 2018年10月24日 下午8:01:05
 * @param <T>
 */
public class Decision<T> {
    /** 比较 */
    private final List<DecisionCompareItem> compares;
    /** 结果 */
    private final T result;

    private Decision(T result, DecisionCompareItem... items) {
        this.result = result;
        this.compares = Arrays.asList(items);
    }

    /**
     * 构造
     * @param result
     * @param items
     * @return
     */
    public static <T> Decision<T> of(T result, DecisionCompareItem... items) {
        return new Decision<T>(result, items);
    }

    /**
     * 构造
     * @param items
     * @return
     */
    public static <T> Decision<T> of(DecisionCompareItem... items) {
        return new Decision<T>(null, items);
    }

    /**
     * 比较
     * @param args
     * @return
     */
    public boolean equals(Object... args) {
        for (int i = 0; i < compares.size(); i++) {
            if (!compares.get(i).compare(args[i])) {
                return false;
            }
        }
        return true;
    }

    /**
     * 获取比较结果
     * @return
     */
    public T get() {
        return result;
    }

}
