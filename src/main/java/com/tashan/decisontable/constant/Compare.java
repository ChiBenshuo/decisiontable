package com.tashan.decisontable.constant;

import java.util.Arrays;

/**
 * 比较运算符
 * 
 * @author chi
 *
 */
@SuppressWarnings({ "unchecked", "rawtypes" })
public enum Compare {
    /** 大于 */
    GT {
        @Override
        public boolean compare(Object o1, Object... o2) {
            return o1 != null && ((Comparable) o1).compareTo(o2[0]) > 0;
        }
    },
    /** 小于 */
    LT {
        @Override
        public boolean compare(Object o1, Object... o2) {
            return o1 != null && ((Comparable) o1).compareTo(o2[0]) < 0;
        }
    },
    /** 等于 */
    EQ {
        @Override
        public boolean compare(Object o1, Object... o2) {
            return o1 != null && o1.equals(o2[0]);
        }
    },
    /** 大于等于 */
    GE {
        @Override
        public boolean compare(Object o1, Object... o2) {
            return o1 != null && ((Comparable) o1).compareTo(o2[0]) >= 0;
        }
    },
    /** 小于等于 */
    LE {
        @Override
        public boolean compare(Object o1, Object... o2) {
            return o1 != null && ((Comparable) o1).compareTo(o2[0]) <= 0;
        }
    },
    /** 不等于 */
    NE {
        @Override
        public boolean compare(Object o1, Object... o2) {
            return (o1 != null && !o1.equals(o2[0]))
                    || (o1 == null && o2[0] != null);
        }
    },
    /** isNull */
    ISNULL {
        @Override
        public boolean compare(Object o1, Object... o2) {
            return o1 == null;
        }

        @Override
        public boolean isArgument() {
            return false;
        }

    },
    /** NotNull */
    NOTNULL {
        @Override
        public boolean compare(Object o1, Object... o2) {
            return o1 != null;
        }
    },
    /** IN */
    IN {
        @Override
        public boolean compare(Object o1, Object... o2) {
            return Arrays.asList(o2).contains(o1);
        }
    },
    /** NOTIN */
    NOTIN {
        @Override
        public boolean compare(Object o1, Object... o2) {
            return !Arrays.asList(o2).contains(o1);
        }
    },
    /** BETWEEN */
    BETWEEN {
        @Override
        public boolean compare(Object o1, Object... o2) {
            assert o1 instanceof Comparable : "参数实现Comparable";
            return o1 != null && ((Comparable) o1).compareTo(o2[0]) >= 0
                    && ((Comparable) o1).compareTo(o2[1]) <= 0;
        }
    },
    /** True */
    ISTRUE {
        @Override
        public boolean compare(Object o1, Object... o2) {
            return (Boolean) o1;
        }
    },
    /** False */
    ISFALSE {
        @Override
        public boolean compare(Object o1, Object... o2) {
            return !((Boolean) o1);
        }
    },
    /** 不关心 */
    /** 不关心 */
    NOCASE {
        @Override
        public boolean compare(Object o1, Object... o2) {
            return true;
        }
    };

    /**
     * 比较运算
     * 
     * @param o1
     * @param o2
     * @return
     */
    public abstract boolean compare(Object o1, Object... o2);

    /**
     * 是否是参数
     * @return
     */
    public boolean isArgument() {
        return true;
    }
}
