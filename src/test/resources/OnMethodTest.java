/*
 * Copyright 2008-2010 Sun Microsystems, Inc.  All Rights Reserved.
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
 *
 * This code is free software; you can redistribute it and/or modify it
 * under the terms of the GNU General Public License version 2 only, as
 * published by the Free Software Foundation.  Sun designates this
 * particular file as subject to the "Classpath" exception as provided
 * by Sun in the LICENSE file that accompanied this code.
 *
 * This code is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or
 * FITNESS FOR A PARTICULAR PURPOSE.  See the GNU General Public License
 * version 2 for more details (a copy is included in the LICENSE file that
 * accompanied this code).
 *
 * You should have received a copy of the GNU General Public License version
 * 2 along with this work; if not, write to the Free Software Foundation,
 * Inc., 51 Franklin St, Fifth Floor, Boston, MA 02110-1301 USA.
 *
 * Please contact Sun Microsystems, Inc., 4150 Network Circle, Santa Clara,
 * CA 95054 USA or visit www.sun.com if you need additional information or
 * have any questions.
 */

package resources;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * !!! Only append the new methods; line numbers need to be kept intact !!!
 * @author Jaroslav Bachorik
 */
public class OnMethodTest {
    private int field;

    public OnMethodTest() {}
    private OnMethodTest(String a) {}

    public void noargs() {};
    static public void noargs$static() {};
    public long args(String a, long b, String[] c, int[] d) {return 0L;}
    static public long args$static(String a, long b, String[] c, int[] d) {return 0L;}

    public static long callTopLevelStatic(String a, long b) {
        OnMethodTest instance  = new OnMethodTest();
        return callTargetStatic(a, b) + instance.callTarget(a, b);
    }

    public static long callTargetStatic(String a, long b) {
        return 3L;
    }

    public long callTopLevel(String a, long b) {
        return callTarget(a, b) + callTargetStatic(a, b);
    }

    private long callTarget(String a, long b) {
        return 4L;
    }

    public void exception() {
        try {
            throw new IOException("hello world");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void uncaught() {
        throw new RuntimeException("ho-hey");
    }

    public void array(int a) {
        int[] arr = new int[10];

        int b = arr[a];
        arr[a] = 15;
    }

    public void field() {
        this.field = this.field + 1;
    }

    public void newObject() {
        Map<String, String> m = new HashMap<String, String>();
    }

    public void newArray() {
        int[] a = new int[1];
        int[][] b = new int[1][1];
        String[] c = new String[1];
        String[][] d = new String[1][1];
    }

    public void casts() {
        Map<String, String> c = new HashMap<String, String>();
        HashMap<String, String> d = (HashMap<String, String>)c;

        if (c instanceof HashMap) {
            System.err.println("hey ho");
        }
    }

    public void sync() {
        synchronized(this) {
            System.err.println("ho hey");
        }
    }

    public long callTopLevel1(String a, long b) {
        long i = callTarget(a, b) + callTargetStatic(a, b);
        return i + calLTargetX(a, b);
    }

    private long calLTargetX(String a, long b) {
        return 5L;
    }

    public long argsMultiReturn(String a, long b, String[] c, int[] d) {
        if (System.currentTimeMillis() > 325723059) {
            return 0L;
        }

        if (System.currentTimeMillis() > 32525) {
            return 1L;
        }

        {
            System.out.println("fdsfg");
            return -1L;
        }
    }
}
