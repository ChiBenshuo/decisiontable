package com.tashan.decisontable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

/**
 * @author chi
 * @date 2018年10月24日 下午8:14:39
 * @param <T>
 */
public class DecisionTable<T> {
    /** 判定项 */
    private List<Decision<T>> decisions = new ArrayList<>();

    /**
     * 添加判定项
     * @param result
     * @param items
     * @return
     */
    public DecisionTable<T> addDecision(T result,
            DecisionCompareItem... items) {
        decisions.add(Decision.of(result, items));
        return this;
    }

    /**
     * 添加判定项
     * @param items
     * @return
     */
    public DecisionTable<T> addDecision(DecisionCompareItem... items) {
        decisions.add(Decision.of(null, items));
        return this;
    }

    /**
     * 匹配
     * @param args
     * @return
     */
    public boolean macth(Object... args) {
        for (Decision<T> decision : this.decisions) {
            if (decision.equals(args)) {
                return true;
            }
        }
        return false;
    }

    /**
     * 匹配并获取值
     * @param args
     * @return
     */
    public Optional<T> get(Object... args) {
        for (Decision<T> decision : this.decisions) {
            if (decision.equals(args)) {
                return Optional.ofNullable(decision.get());
            }
        }
        return Optional.empty();
    }

    /**
     * 返回判定列表
     * @return
     */
    public List<Decision<T>> getDecisions() {
        return Collections.unmodifiableList(this.decisions);
    }
}
