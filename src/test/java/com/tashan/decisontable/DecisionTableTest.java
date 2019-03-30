package com.tashan.decisontable;

import static com.tashan.decisontable.DecisionCompare.EQ;
import static com.tashan.decisontable.DecisionCompare.FALSE;
import static com.tashan.decisontable.DecisionCompare.GT;
import static com.tashan.decisontable.DecisionCompare.LT;
import static com.tashan.decisontable.DecisionCompare.NOCASE;
import static com.tashan.decisontable.DecisionCompare.TRUE;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.NoSuchElementException;

import org.junit.Test;

/**
 * 
 * 测试
 * @author chi
 * @date 2018年10月25日 上午9:05:25
 */
public class DecisionTableTest {

    @Test
    public void testVoid() {
        DecisionTable<Void> table = new DecisionTable<>();
        table.addDecision(LT(1), EQ("EQ"), NOCASE());
        table.addDecision(EQ(2), EQ("XQ"), EQ("EQ"));
        table.addDecision(GT(2), EQ("XQ"), EQ("EQ"));
        assertTrue("1,EQ,null", table.macth(0, "EQ", null));
        assertTrue("2,EQ,null", table.macth(2, "XQ", "EQ"));
        assertTrue("3,EQ,null", table.macth(3, "XQ", "EQ"));
        assertFalse("1,EQ,null", table.macth(1, "EQ", null));
        assertFalse("1,EQ,EQ", table.macth(1, "XQ", "EQ"));
    }

    @Test
    public void testGet() {
        DecisionTable<Integer> table = new DecisionTable<>();
        table.addDecision(1, LT(1), EQ("EQ"), NOCASE());
        table.addDecision(2, EQ(2), EQ("XQ"), EQ("EQ"));
        table.addDecision(3, GT(2), EQ("XQ"), EQ("EQ"));
        assertEquals("1,EQ,null", 1, table.get(0, "EQ", null).get().intValue());
        assertEquals("2,EQ,null", 2, table.get(2, "XQ", "EQ").get().intValue());
        assertEquals("3,EQ,null", 3, table.get(3, "XQ", "EQ").get().intValue());
    }

    @Test(expected = NoSuchElementException.class)
    public void testThrow() {
        DecisionTable<Integer> table = new DecisionTable<>();
        table.addDecision(1, LT(1), EQ("EQ"), NOCASE());
        table.get(1, "EQ", null).get().intValue();
    }

    @Test
    public void testBoolean() {
        DecisionTable<Integer> table = new DecisionTable<>();
        table.addDecision(1, TRUE());
        table.addDecision(2, FALSE());
        assertEquals(1, table.get(true).get().intValue());
        assertEquals(2, table.get(false).get().intValue());
    }

}
