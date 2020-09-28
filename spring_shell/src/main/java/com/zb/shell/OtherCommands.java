package com.zb.shell;

import org.springframework.shell.standard.ShellCommandGroup;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;
import org.springframework.shell.standard.ShellOption;

import java.io.File;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/***
 *
 * @author once
 * @date 2020/9/28 23:31
 *
 */
@ShellComponent
@ShellCommandGroup("a other commands")
public class OtherCommands {

    @ShellMethod(value = "Echo string a b c .")
    public String echo(String a, @ShellOption({"-B","--argb"}) String b, @ShellOption(defaultValue = "c") String c) {
        return String.format("string a=%s,b=%s,c=%s", a, b, c);
    }

    @ShellMethod(value = "List path file name .",group = "Arithmetic Commands")
    public List<String> list(String path) {
        File file = new File(path);
        if (file.isDirectory()) {
            File[] files = file.listFiles();
            assert files != null;
            return Arrays.stream(files).map(File::getName).collect(Collectors.toList());
        }
        return Collections.emptyList();
    }

}
