package com.zb.shell;

import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;

import java.util.Arrays;

/**
 * @author Zhang Bo
 * @date 2020/9/28 16:57
 */
@ShellComponent
public class ArithmeticCommand {

    @ShellMethod("A add all integers .")
    public int add(int... ints) {
        return Arrays.stream(ints).sum();
    }

    @ShellMethod("A sub all integers .")
    public int sub(int a,int... ints) {
        return a - Arrays.stream(ints).sum();
    }
}
