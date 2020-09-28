package com.zb.shell;

import org.springframework.shell.Availability;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;
import org.springframework.shell.standard.ShellMethodAvailability;

import java.util.Arrays;

/**
 * @author Zhang Bo
 * @date 2020/9/28 16:57
 */
@ShellComponent()
public class ArithmeticCommands {

    private boolean AVAILABILITY = false;

    @ShellMethodAvailability({"add","list"})
    public Availability availability() {
        return System.currentTimeMillis() % 2 == 0 ? Availability.available() : Availability.unavailable("时间戳不是偶数,不给执行!");
    }

    //    @ShellMethodAvailability("availability")
    @ShellMethod(value = "A add all integers .",group = "Other Commands")
    public int add(int... ints) {
        return Arrays.stream(ints).sum();
    }

    @ShellMethod("A sub all integers .")
    public int sub(int a, int... ints) {
        return a - Arrays.stream(ints).sum();
    }


}
